package ocp;

public class HotPackaging extends Packaging {

  HotPackaging(Product product) {
    super(product);
  }

  @Override
  public void pack() {
    System.out.println("핫 포장을 합니다.");
    System.out.println("포장을 완료합니다.");
  }
}
