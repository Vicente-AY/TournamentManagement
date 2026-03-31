package tournament;

import java.time.LocalDateTime;

public class Match {

    int id = 0;
    LocalDateTime startDate = null;
    LocalDateTime endDate = null;

    public Match(int id, LocalDateTime startDate, LocalDateTime endDate) {

        this.id = id;
        this.startDate = startDate;
    }
}
