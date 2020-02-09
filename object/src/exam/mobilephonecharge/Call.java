package exam.mobilephonecharge;

import java.time.Duration;
import java.time.LocalDateTime;

public class Call {
    private LocalDateTime to;
    private LocalDateTime from;

    public Call(LocalDateTime to, LocalDateTime from) {
        this.to = to;
        this.from = from;
    }

    public Duration getDuration(){
        return Duration.between(from, to);
    }

    public LocalDateTime getFrom(){
        return from;
    }

}
