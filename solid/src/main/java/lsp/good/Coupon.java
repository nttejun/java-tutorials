package lsp.good;

public class Coupon {

  private int discountRate;

  public Coupon(int discountRate) {
    this.discountRate = discountRate;
  }

  public int calculateDiscountAmount(Item item) {
    if (!item.isDiscountAvailable()) {
      return 0;
    }

    return item.getPrice() * discountRate;
  }
}
