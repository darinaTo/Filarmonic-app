package mate.academy.spring.service.impl;

import java.util.List;
import mate.academy.spring.dao.StageDao;
import mate.academy.spring.exception.DataProcessingException;
import mate.academy.spring.model.Stage;
import mate.academy.spring.service.StageService;
import org.springframework.stereotype.Service;

@Service
public class StageServiceImpl implements StageService {
    private final StageDao stageDao;

    public StageServiceImpl(StageDao stageDao) {
        this.stageDao = stageDao;
    }

    @Override
    public Stage add(Stage stage) {
        return stageDao.add(stage);
    }

    @Override
    public Stage get(Long id) {
        return stageDao.get(id).orElseThrow(
                () -> new DataProcessingException("Can't get cinema hall by id " + id));
    }

    @Override
    public List<Stage> getAll() {
        return stageDao.getAll();
    }
}
