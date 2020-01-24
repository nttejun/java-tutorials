package exam.management.schedule;


import org.junit.Assert;
import org.junit.Test;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class RecurringScheduleTest {

    @Test
    public void createRecurringSchedule(){
        RecurringSchedule recurringSchedule = new RecurringSchedule("회의", DayOfWeek.MONDAY, LocalTime.of(10,  30), Duration.ofMinutes(30));
        Assert.assertNotNull(recurringSchedule);
    }

    @Test
    public void isSatisfied(){
        RecurringSchedule recurringSchedule = new RecurringSchedule("회의", DayOfWeek.MONDAY, LocalTime.of(10,  30), Duration.ofMinutes(30));
        Assert.assertFalse(recurringSchedule.isSatisfied());
    }

    @Test
    public void isSatisfiedEventFail(){
        RecurringSchedule recurringSchedule = new RecurringSchedule("회의", DayOfWeek.MONDAY, LocalTime.of(10,  30), Duration.ofMinutes(30));
        Event event = new Event("회의", LocalDateTime.of(2019, 5, 9, 10, 30), Duration.ofMinutes(30));
        System.out.println(event.isSatisfied(recurringSchedule));
        Assert.assertFalse(event.isSatisfied(recurringSchedule));
    }

    @Test
    public void isSatisfiedEventTrue(){
        RecurringSchedule recurringSchedule = new RecurringSchedule("회의", DayOfWeek.MONDAY, LocalTime.of(10,  30), Duration.ofMinutes(30));
        Event event = new Event("회의", LocalDateTime.of(2019, 5, 9, 10, 30), Duration.ofMinutes(30));
        System.out.println(event.isSatisfied(recurringSchedule));
        System.out.println(event.isSatisfied(recurringSchedule));
        Assert.assertFalse(event.isSatisfied(recurringSchedule));
        Assert.assertFalse(event.isSatisfied(recurringSchedule));
    }
}