package lsp.good;

public class Item {

  private String item;
  private double price;

  public Item(String item, double price) {
    this.item = item;
    this.price = price;
  }

  public double getPrice() {
    return price;
  }

  /***
   * 상위클래스에 할인가능 여부를 판단하는 기능을 추가한다
   * 하위클래스에서 @Override 이용
   * Coupon 클래스의 변경없이 Item 확장(SpecialItem)이 가능하다
   */
  public boolean isDiscountAvailable() {
    return true;
  }
}
