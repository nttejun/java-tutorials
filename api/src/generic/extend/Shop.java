package generic.extend;

class Shop<T extends Type> {

  public T type;

  Shop(T type) {
    this.type = type;
  }
}
