package lsp.bad;

/***
 * Item 하위클래스 SpecialItem 에서
 * calculateDiscountAmount 사용하는 경우
 * Item 확장되는데 Coupon 클래스가 변경되는 문제가 발생한다 OCP 위배
 */
public class BadCoupon {

  private int discountRate;

  public BadCoupon(int discountRate) {
    this.discountRate = discountRate;
  }

  public int calculateDiscountAmount(BadItem item) {
    return item.getPrice() * discountRate;
  }

}
