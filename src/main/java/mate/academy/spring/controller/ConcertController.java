package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import mate.academy.spring.dto.request.ConcertRequestDto;
import mate.academy.spring.dto.response.ConcertResponseDto;
import mate.academy.spring.model.Concert;
import mate.academy.spring.service.ConcertService;
import mate.academy.spring.service.mapper.ConcertMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/concerts")
public class ConcertController {
    private final ConcertService concertService;
    private final ConcertMapper concertMapper;

    public ConcertController(ConcertService concertService, ConcertMapper concertMapper) {
        this.concertService = concertService;
        this.concertMapper = concertMapper;
    }

    @PostMapping
    public ConcertResponseDto add(@RequestBody @Valid ConcertRequestDto requestDto) {
        Concert concert = concertService.add(concertMapper.mapToModel(requestDto));
        return concertMapper.mapToDto(concert);
    }

    @GetMapping
    public List<ConcertResponseDto> getAll() {
        return concertService.getAll()
                .stream()
                .map(concertMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
