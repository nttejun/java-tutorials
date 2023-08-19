package design.version.a.strategy;

import java.util.List;

public class FirstGuestDiscountStrategy implements DiscountStrategy {

    private List<Item> items;

    private FirstGuestDiscountStrategy(List<Item> items) {
        this.items = items;
    }

    private DiscountStrategy strategy;

    public void onFirstGuestButtonClick() {
        strategy = new FirstGuestDiscountStrategy(items);
    }

    public void onCalculationButtonClick() {
        Calculator cal = new Calculator(strategy);
        int price = cal.calculate(items);
    }

    @Override
    public int getDiscountPrice(Item item) {
        return (int) (item.getPrice() * 0.9);
    }
}
