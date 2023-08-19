package design.version.b.creational;

public class BuilderPattern {

  // Product class
  class Order {

    private String item;
    private int quantity;
    private boolean isExpressShipping;

    public Order(String item, int quantity, boolean isExpressShipping) {
      this.item = item;
      this.quantity = quantity;
      this.isExpressShipping = isExpressShipping;
    }

    @Override
    public String toString() {
      return "Order{" +
          "item='" + item + '\'' +
          ", quantity=" + quantity +
          ", isExpressShipping=" + isExpressShipping +
          '}';
    }
  }

  // Builder interface
  interface OrderBuilder {

    OrderBuilder addItem(String item);

    OrderBuilder setQuantity(int quantity);

    OrderBuilder setExpressShipping(boolean expressShipping);

    Order build();
  }

  // Concrete Builder
  class ConcreteOrderBuilder implements OrderBuilder {

    private String item;
    private int quantity;
    private boolean isExpressShipping;

    @Override
    public OrderBuilder addItem(String item) {
      this.item = item;
      return this;
    }

    @Override
    public OrderBuilder setQuantity(int quantity) {
      this.quantity = quantity;
      return this;
    }

    @Override
    public OrderBuilder setExpressShipping(boolean expressShipping) {
      this.isExpressShipping = expressShipping;
      return this;
    }

    @Override
    public Order build() {
      return new Order(item, quantity, isExpressShipping);
    }
  }

  public void main() {
    OrderBuilder builder = new ConcreteOrderBuilder();
    Order order = builder
        .addItem("Widget")
        .setQuantity(5)
        .setExpressShipping(true)
        .build();

    System.out.println(order);
  }
}
