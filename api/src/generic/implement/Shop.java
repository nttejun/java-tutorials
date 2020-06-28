package generic.implement;

public class Shop<T extends Type> {

  public T type;

  public Shop(T type) {
    this.type = type;
  }
}
