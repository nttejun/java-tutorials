package srp;

public class HourReport {

  public long calculateExtraHour(int hour) {
    return hour * 12000;
  }

  public long hourReport(int hour) {
    return this.calculateExtraHour(hour);
  }

}
