package lsp.good;

public class SpecialItem extends Item {

  @Override
  public boolean isDiscountAvailable() {
    return false;
  }
}
