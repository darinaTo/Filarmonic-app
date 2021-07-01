package mate.academy.spring.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import mate.academy.spring.model.ConcertSession;

public interface ConcertSessionDao {
    ConcertSession add(ConcertSession concertSession);

    Optional<ConcertSession> get(Long id);

    List<ConcertSession> findAvailableSessions(Long concertId, LocalDate date);

    ConcertSession update(ConcertSession concertSession);

    void delete(Long id);
}
