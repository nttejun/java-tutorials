package generic;

public class EditShop<T> {

  public String type;
  public int number;
  public T discountType;

  public EditShop(String type, int number, T discountType) {
    this.type = type;
    this.number = number;
    this.discountType = discountType;
  }
}
