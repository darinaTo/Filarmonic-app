package mate.academy.spring.dao.impl;

import mate.academy.spring.dao.AbstractDao;
import mate.academy.spring.dao.ConcertDao;
import mate.academy.spring.model.Concert;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
class ConcertDaoImpl extends AbstractDao<Concert> implements ConcertDao {
    public ConcertDaoImpl(SessionFactory factory) {
        super(factory, Concert.class);
    }
}
