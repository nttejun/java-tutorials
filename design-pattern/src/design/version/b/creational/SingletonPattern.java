package design.version.b.creational;

public class SingletonPattern {

  // 인스턴스를 저장할 정적 변수
  private static SingletonPattern instance;

  // private 생성자로 외부에서 직접 인스턴스 생성 방지
  private SingletonPattern() {
    // 초기화 작업
  }

  // 인스턴스를 반환하는 정적 메서드
  public static SingletonPattern getInstance() {
    if (instance == null) {
      instance = new SingletonPattern();
    }
    return instance;
  }

  // 기타 메서드
  public void doSomething() {
    // 작업 수행
  }

  public static void main(String[] args) {
    SingletonPattern singleton1 = SingletonPattern.getInstance();
    SingletonPattern singleton2 = SingletonPattern.getInstance();

    // 두 객체는 동일한 인스턴스를 참조
    System.out.println(singleton1 == singleton2); // true
  }
}
