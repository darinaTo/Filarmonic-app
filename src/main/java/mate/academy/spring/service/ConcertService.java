package mate.academy.spring.service;

import java.util.List;
import mate.academy.spring.model.Concert;

public interface ConcertService {
    Concert add(Concert concert);

    Concert get(Long id);

    List<Concert> getAll();
}
