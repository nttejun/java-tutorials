package srp;

import org.junit.jupiter.api.Test;

class ReportTest {

  @Test
  public void report() {
    Report report = new Report("il", "part", "management");
    System.out.println("정규직 초과수당 : " + report.dayReport());
    System.out.println("--------");
    System.out.println("파트타임 초과수당 : " + report.hourReport());
  }
}