package design.version.b.structural;

public class DecoratorPattern {

  // Component interface
  interface Coffee {

    String getDescription();

    double cost();
  }

  // Concrete Component
  class BasicCoffee implements Coffee {

    @Override
    public String getDescription() {
      return "Basic Coffee";
    }

    @Override
    public double cost() {
      return 2.0;
    }
  }

  // Decorator
  // 커피데코레이터 클랙스에서 커피 객체를 갖고 있습니다
  abstract class CoffeeDecorator implements Coffee {

    protected Coffee decoratedCoffee;

    public CoffeeDecorator(Coffee decoratedCoffee) {
      this.decoratedCoffee = decoratedCoffee;
    }

    @Override
    public String getDescription() {
      return decoratedCoffee.getDescription();
    }

    @Override
    public double cost() {
      return decoratedCoffee.cost();
    }
  }

  // Concrete Decorator
  class MilkDecorator extends CoffeeDecorator {

    public MilkDecorator(Coffee decoratedCoffee) {
      super(decoratedCoffee);
    }

    @Override
    public String getDescription() {
      return super.getDescription() + ", Milk";
    }

    @Override
    public double cost() {
      return super.cost() + 0.5;
    }
  }

  class SugarDecorator extends CoffeeDecorator {

    public SugarDecorator(Coffee decoratedCoffee) {
      super(decoratedCoffee);
    }

    @Override
    public String getDescription() {
      return super.getDescription() + ", Sugar";
    }

    @Override
    public double cost() {
      return super.cost() + 0.2;
    }
  }

  public void main() {
    Coffee basicCoffee = new BasicCoffee();
    System.out.println(
        "Basic Coffee: " + basicCoffee.getDescription() + " - Cost: $" + basicCoffee.cost());

    Coffee milkCoffee = new MilkDecorator(basicCoffee);
    System.out
        .println("Milk Coffee: " + milkCoffee.getDescription() + " - Cost: $" + milkCoffee.cost());

    Coffee sugarMilkCoffee = new SugarDecorator(milkCoffee);
    System.out.println(
        "Sugar Milk Coffee: " + sugarMilkCoffee.getDescription() + " - Cost: $" + sugarMilkCoffee
            .cost());
  }
}
