package mate.academy.spring.dto.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class ConcertSessionRequestDto {
    @Positive
    private Long concertId;
    @Positive
    private Long cinemaHallId;
    @NotNull
    private String showTime;

    public Long getConcertId() {
        return concertId;
    }

    public Long getCinemaHallId() {
        return cinemaHallId;
    }

    public String getShowTime() {
        return showTime;
    }
}
