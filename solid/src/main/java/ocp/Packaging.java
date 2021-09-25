package ocp;

public class Packaging {

  private Product product;

  Packaging(Product product) {
    this.product = product;
  }

  protected void pack() {
    System.out.println("기본 포장을 진행합니다.");
    System.out.println("포장이 완료되었습니다.");
  }

  public void invalidOpenClosePrinciplePack(Packaging packaging) {
    if (packaging instanceof IcePackaging) {
      System.out.println("아이스 포장을 진행합니다.");
    } else if (packaging instanceof HotPackaging) {
      System.out.println("핫 포장을 진행합니다.");
    } else {
      System.out.println("기본 포장을 진행합니다.");
    }
    System.out.println("포장이 완료되었습니다.");
  }
}
