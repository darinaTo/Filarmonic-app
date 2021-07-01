package mate.academy.spring.dto.response;

public class ConcertSessionResponseDto {
    private Long concertSessionId;
    private Long concertId;
    private String concertTitle;
    private Long cinemaHallId;
    private String showTime;

    public Long getConcertSessionId() {
        return concertSessionId;
    }

    public void setConcertSessionId(Long concertSessionId) {
        this.concertSessionId = concertSessionId;
    }

    public Long getConcertId() {
        return concertId;
    }

    public void setConcertId(Long concertId) {
        this.concertId = concertId;
    }

    public String getConcertTitle() {
        return concertTitle;
    }

    public void setConcertTitle(String concertTitle) {
        this.concertTitle = concertTitle;
    }

    public Long getCinemaHallId() {
        return cinemaHallId;
    }

    public void setCinemaHallId(Long cinemaHallId) {
        this.cinemaHallId = cinemaHallId;
    }

    public String getShowTime() {
        return showTime;
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }
}
