package time;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import org.junit.Assert;
import org.junit.Test;

public class TimeSample {

  @Test
  public void localDateTimeParse(){
    LocalDateTime startLdt = LocalDateTime.parse("2020-01-01T00:00:00");
    LocalDateTime endLdt = LocalDateTime.parse("2020-02-29T00:00:00");

    Calendar calendar = Calendar.getInstance();
    Date date = calendar.getTime();
    Instant instant = Instant.ofEpochMilli(date.getTime());

    LocalDateTime nowDateToLdt = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
    Assert.assertTrue(findValidDate(nowDateToLdt, startLdt, endLdt));
  }

  public boolean findValidDate(LocalDateTime useDate, LocalDateTime startLdt, LocalDateTime endLdt){
    if(useDate.compareTo(startLdt) > 0 && useDate.compareTo(endLdt) < 0){
      return true;
    }
    return false;
  }
}
