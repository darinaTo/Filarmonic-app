package mate.academy.spring.dao.impl;

import mate.academy.spring.dao.AbstractDao;
import mate.academy.spring.dao.StageDao;
import mate.academy.spring.model.Stage;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class StageDaoImpl extends AbstractDao<Stage> implements StageDao {
    public StageDaoImpl(SessionFactory factory) {
        super(factory, Stage.class);
    }
}
