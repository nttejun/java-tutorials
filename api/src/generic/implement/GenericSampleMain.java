package generic.implement;

public class GenericSampleMain {

  public static void main(String[] args) {
    Shop outlet = new Shop(new OutletType("outlet"));
    System.out.println(outlet.type.getType());
    /*** 컴파일 시점에 오류
     Shop<String> expectedError = new Shop<String>("outlet");
     */
  }
}