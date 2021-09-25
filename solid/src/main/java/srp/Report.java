package srp;

/***
 * 특정 유형 근무자 초과수당이 변경된다고 하자
 * 예를들어 아르바이트(hourReport)의 초과수당 금액이 변경되면
 * HourReport 클래스의 calculateExtraHour 메서드 금액만 변경하면 된다.
 */
public class Report {

  private String name;
  private String position;
  private String contractType;

  public Report(String name, String position, String contractType) {
    this.name = name;
    this.position = position;
    this.contractType = contractType;
  }

  public long dayReport() {
    return new DayReport().dayReport(3);
  }

  public long hourReport() {
    return new HourReport().hourReport(3);
  }
}
