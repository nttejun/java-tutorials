package lsp.good;

public class SpecialItem extends Item {

  public SpecialItem(String item, int price) {
    super(item, price);
  }

  @Override
  public boolean isDiscountAvailable() {
    return false;
  }
}
