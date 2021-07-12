package mate.academy.spring.dao.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import mate.academy.spring.dao.AbstractDao;
import mate.academy.spring.dao.ConcertSessionDao;
import mate.academy.spring.exception.DataProcessingException;
import mate.academy.spring.model.ConcertSession;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class ConcertSessionDaoImpl extends AbstractDao<ConcertSession>
        implements ConcertSessionDao {
    public ConcertSessionDaoImpl(SessionFactory factory) {
        super(factory, ConcertSession.class);
    }

    @Override
    public List<ConcertSession> findAvailableSessions(Long concertId, LocalDate date) {
        try (Session session = factory.openSession()) {
            Query<ConcertSession> getAvailableSessions = session.createQuery(
                    "FROM ConcertSession WHERE id = :id "
                            + "AND DATE_FORMAT(showTime, '%Y-%m-%d') = :date",
                    ConcertSession.class);
            getAvailableSessions.setParameter("id", concertId);
            getAvailableSessions.setParameter("date", date.toString());
            return getAvailableSessions.getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Session for concert with id "
                    + concertId + " and show date " + date + " not found", e);
        }
    }
}
