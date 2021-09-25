package ocp;

public class IcePackaging extends Packaging {

  IcePackaging(Product product) {
    super(product);
  }

  @Override
  public void pack() {
    System.out.println("아이스 포장을 진행합니다.");
    System.out.println("포장을 완료합니다.");
  }
}
