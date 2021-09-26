package lsp.good;

public class Coupon {

  private double discountRate;

  public Coupon(double discountRate) {
    this.discountRate = discountRate;
  }

  public double calculateDiscountAmount(Item item) {
    if (!item.isDiscountAvailable()) {
      return item.getPrice();
    }

    return item.getPrice() * discountRate;
  }
}
