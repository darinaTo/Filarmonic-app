package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import mate.academy.spring.dto.request.StageRequestDto;
import mate.academy.spring.dto.response.StageResponseDto;
import mate.academy.spring.model.Stage;
import mate.academy.spring.service.StageService;
import mate.academy.spring.service.mapper.StageMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cinema-halls")
public class StageController {
    private final StageService stageService;
    private final StageMapper stageMapper;

    public StageController(StageService stageService,
                                StageMapper stageMapper) {
        this.stageService = stageService;
        this.stageMapper = stageMapper;
    }

    @PostMapping
    public StageResponseDto add(@RequestBody @Valid StageRequestDto requestDto) {
        Stage stage = stageService.add(stageMapper.mapToModel(requestDto));
        return stageMapper.mapToDto(stage);
    }

    @GetMapping
    public List<StageResponseDto> getAll() {
        return stageService.getAll()
                .stream()
                .map(stageMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
