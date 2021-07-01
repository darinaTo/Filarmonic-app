package mate.academy.spring.service.mapper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import mate.academy.spring.dto.request.ConcertSessionRequestDto;
import mate.academy.spring.dto.response.ConcertSessionResponseDto;
import mate.academy.spring.model.ConcertSession;
import mate.academy.spring.service.StageService;
import mate.academy.spring.service.ConcertService;
import mate.academy.spring.util.DateTimePatternUtil;
import org.springframework.stereotype.Component;

@Component
public class ConcertSessionMapper implements RequestDtoMapper<ConcertSessionRequestDto, ConcertSession>,
        ResponseDtoMapper<ConcertSessionResponseDto, ConcertSession> {
    private final DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern(DateTimePatternUtil.DATE_TIME_PATTERN);
    private final StageService stageService;
    private final ConcertService concertService;

    public ConcertSessionMapper(StageService stageService, ConcertService concertService) {
        this.stageService = stageService;
        this.concertService = concertService;
    }

    @Override
    public ConcertSession mapToModel(ConcertSessionRequestDto dto) {
        ConcertSession concertSession = new ConcertSession();
        concertSession.setConcert(concertService.get(dto.getConcertId()));
        concertSession.setStage(stageService.get(dto.getStageId()));
        concertSession.setShowTime(LocalDateTime.parse(dto.getShowTime(), formatter));
        return concertSession;
    }

    @Override
    public ConcertSessionResponseDto mapToDto(ConcertSession concertSession) {
        ConcertSessionResponseDto responseDto = new ConcertSessionResponseDto();
        responseDto.setConcertSessionId(concertSession.getId());
        responseDto.setStageId(concertSession.getStage().getId());
        responseDto.setConcertId(concertSession.getConcert().getId());
        responseDto.setConcertTitle(concertSession.getConcert().getTitle());
        responseDto.setShowTime(concertSession.getShowTime().format(formatter));
        return responseDto;
    }
}
