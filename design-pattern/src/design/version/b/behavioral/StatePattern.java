package design.version.b.behavioral;

public class StatePattern {

  // State interface
  interface OrderState {

    void processOrder();
  }

  // Concrete States
  class NewOrder implements OrderState {

    @Override
    public void processOrder() {
      System.out.println("Processing new order");
    }
  }

  class ShippedOrder implements OrderState {

    @Override
    public void processOrder() {
      System.out.println("Processing shipped order");
    }
  }

  class DeliveredOrder implements OrderState {

    @Override
    public void processOrder() {
      System.out.println("Processing delivered order");
    }
  }

  // Context
  // 주문 상태에 따라 주문을 처리하는 시스템에서 주문의 상태를 다루고
  // 각 상태에 따라 다른 동작을 수행할 때,
  // 스테이트 패턴을 사용하여 상태와 해당 상태에서 수행되는 동작을 캡슐화할 수 있습니다.
  class Order {

    private OrderState currentState;

    public Order() {
      currentState = new NewOrder();
    }

    public void setState(OrderState state) {
      currentState = state;
    }

    public void process() {
      currentState.processOrder();
    }
  }

  public void main() {
    Order order = new Order();

    order.process();

    order.setState(new ShippedOrder());
    order.process();

    order.setState(new DeliveredOrder());
    order.process();
  }
}
