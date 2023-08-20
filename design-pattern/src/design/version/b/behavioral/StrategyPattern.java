package design.version.b.behavioral;

public class StrategyPattern {

  // Strategy interface
  interface PaymentStrategy {

    void pay(int amount);
  }

  // Concrete Strategies
  class CreditCardPayment implements PaymentStrategy {

    private String cardNumber;

    public CreditCardPayment(String cardNumber) {
      this.cardNumber = cardNumber;
    }

    @Override
    public void pay(int amount) {
      System.out.println("Paid $" + amount + " using credit card " + cardNumber);
    }
  }

  class PayPalPayment implements PaymentStrategy {

    private String email;

    public PayPalPayment(String email) {
      this.email = email;
    }

    @Override
    public void pay(int amount) {
      System.out.println("Paid $" + amount + " using PayPal account " + email);
    }
  }

  // Context
  class ShoppingCart {

    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
      this.paymentStrategy = paymentStrategy;
    }

    public void checkout(int amount) {
      paymentStrategy.pay(amount);
    }
  }

  // 결제수단을 정의해놓고 캡슐화해서 상호 교환 가능하도록 만드는 패턴
  public void main() {
    ShoppingCart cart = new ShoppingCart();

    PaymentStrategy creditCardPayment = new CreditCardPayment("1234-5678-9012-3456");
    PaymentStrategy paypalPayment = new PayPalPayment("example@example.com");

    cart.setPaymentStrategy(creditCardPayment);
    cart.checkout(100);

    cart.setPaymentStrategy(paypalPayment);
    cart.checkout(50);
  }
}
