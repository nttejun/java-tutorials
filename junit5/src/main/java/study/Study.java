package study;

public class Study {

  private StudyStatus status = StudyStatus.DRAFT;

  private String name;
  private int limit = 0;

  public Study(int limit, String name) {
    if (limit < 0) {
      throw new IllegalArgumentException("Limit은 0 보다 커야 한다.");
    }
    this.limit = limit;
  }

  public Study(int limit) {
    if (limit < 0) {
      throw new IllegalArgumentException("limit은 0보다 커야한다.");
    }
    this.limit = limit;
  }

  public StudyStatus getStatus() {
    return this.status;
  }

  public int getLimit() {
    return limit;
  }

  @Override
  public String toString() {
    return "Study{" +
        "status=" + status +
        ", name='" + name + '\'' +
        ", limit=" + limit +
        '}';
  }
}
