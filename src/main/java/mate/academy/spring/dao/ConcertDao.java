package mate.academy.spring.dao;

import java.util.List;
import java.util.Optional;
import mate.academy.spring.model.Concert;

public interface ConcertDao {
    Concert add(Concert concert);

    Optional<Concert> get(Long id);

    List<Concert> getAll();
}
