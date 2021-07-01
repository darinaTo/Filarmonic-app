package mate.academy.spring.service.impl;

import java.util.List;
import mate.academy.spring.dao.ConcertDao;
import mate.academy.spring.exception.DataProcessingException;
import mate.academy.spring.model.Concert;
import mate.academy.spring.service.ConcertService;
import org.springframework.stereotype.Service;

@Service
public class ConcertServiceImpl implements ConcertService {
    private final ConcertDao concertDao;

    public ConcertServiceImpl(ConcertDao concertDao) {
        this.concertDao = concertDao;
    }

    @Override
    public Concert add(Concert concert) {
        return concertDao.add(concert);
    }

    @Override
    public Concert get(Long id) {
        return concertDao.get(id).orElseThrow(
                () -> new DataProcessingException("Can't get concert by id " + id));
    }

    @Override
    public List<Concert> getAll() {
        return concertDao.getAll();
    }
}
