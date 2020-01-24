package exam.management.schedule;

import org.junit.Test;

import java.time.Duration;
import java.time.LocalDateTime;

public class EventTest {

    @Test
    public void createEvent(){
        Event meeting = new Event("회의",
        LocalDateTime.of(2019, 5, 8, 10, 30),
                Duration.ofMinutes(30));
        org.junit.Assert.assertNotNull(meeting);
    }
}