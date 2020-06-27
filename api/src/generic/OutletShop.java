package generic;

public class OutletShop<T> {

  public String type;
  public int number;
  public T discountType;

  public OutletShop(String type, int number, T discountType) {
    this.type = type;
    this.number = number;
    this.discountType = discountType;
  }
}
