package lsp.good;

import org.junit.jupiter.api.Test;

class ItemTest {

  @Test
  public void item() {
    double price = 2000;
    Coupon coupon = new Coupon(0.5);
    Item item = new Item("과자", price);
    System.out.println("원가 : " + price + " / " + "할인가 : " + coupon.calculateDiscountAmount(item));
  }
}