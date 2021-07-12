package mate.academy.spring.dao;

import java.util.List;
import java.util.Optional;
import mate.academy.spring.exception.DataProcessingException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public abstract class AbstractDao<T> {
    protected final SessionFactory factory;
    private final Class<T> clazz;
    private final Logger logger = LogManager.getLogger(AbstractDao.class);


    public AbstractDao(SessionFactory factory, Class<T> clazz) {
        this.factory = factory;
        this.clazz = clazz;
    }

    public T add(T t) {
        logger.info("Method add was called :" + clazz.getSimpleName());
        Transaction transaction = null;
        Session session = null;
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            session.save(t);
            transaction.commit();
            return t;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.error("Can't insert "
                    + clazz.getSimpleName() + " " + t, e);
            throw new DataProcessingException("Can't insert "
                    + clazz.getSimpleName() + " " + t, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public Optional<T> get(Long id) {
        logger.info("Method get was called: " + clazz.getSimpleName());
        try (Session session = factory.openSession()) {
            return Optional.ofNullable(session.get(clazz, id));
        } catch (Exception e) {
            logger.error("Can't get "
                    + clazz.getSimpleName() + ", id: " + id, e);
            throw new DataProcessingException("Can't get "
                + clazz.getSimpleName() + ", id: " + id, e);
        }
    }

    public List<T> getAll() {
        logger.info("Method get all was called: " + clazz.getSimpleName());
        try (Session session = factory.openSession()) {
            return session.createQuery("from " + clazz.getSimpleName(), clazz).getResultList();
        } catch (Exception e) {
            logger.error("Can't get all "
                    + clazz.getSimpleName() + "s from db", e);
            throw new DataProcessingException("Can't get all "
                + clazz.getSimpleName() + "s from db", e);
        }
    }

    public T update(T t) {
        logger.info("Method update was called: " + clazz.getSimpleName());
        Transaction transaction = null;
        Session session = null;
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            session.update(t);
            transaction.commit();
            return t;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.error("Can't update "
                    + clazz.getSimpleName() + " " + t, e);
            throw new DataProcessingException("Can't update "
                + clazz.getSimpleName() + " " + t, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void delete(Long id) {
        logger.info("Method delete was called: " + clazz.getSimpleName());
        Transaction transaction = null;
        Session session = null;
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            T concertSession = session.get(clazz, id);
            session.delete(concertSession);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.error("Can't delete "
                    + clazz.getSimpleName() + " with id: " + id, e);
            throw new DataProcessingException("Can't delete "
                + clazz.getSimpleName() + " with id: " + id, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
