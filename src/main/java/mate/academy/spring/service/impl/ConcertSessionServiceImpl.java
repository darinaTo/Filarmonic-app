package mate.academy.spring.service.impl;

import java.time.LocalDate;
import java.util.List;
import mate.academy.spring.dao.ConcertSessionDao;
import mate.academy.spring.exception.DataProcessingException;
import mate.academy.spring.model.ConcertSession;
import mate.academy.spring.service.ConcertSessionService;
import org.springframework.stereotype.Service;

@Service
public class ConcertSessionServiceImpl implements ConcertSessionService {
    private final ConcertSessionDao concertSessionDao;

    public ConcertSessionServiceImpl(ConcertSessionDao concertSessionDao) {
        this.concertSessionDao = concertSessionDao;
    }

    @Override
    public List<ConcertSession> findAvailableSessions(Long concertId, LocalDate date) {
        return concertSessionDao.findAvailableSessions(concertId, date);
    }

    @Override
    public ConcertSession add(ConcertSession session) {
        return concertSessionDao.add(session);
    }

    @Override
    public ConcertSession get(Long id) {
        return concertSessionDao.get(id).orElseThrow(
                () -> new DataProcessingException("Session with id " + id + " not found"));
    }

    @Override
    public ConcertSession update(ConcertSession concertSession) {
        return concertSessionDao.update(concertSession);
    }

    @Override
    public void delete(Long id) {
        concertSessionDao.delete(id);
    }
}
