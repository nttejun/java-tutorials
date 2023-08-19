package design.version.a.strategy;

import java.util.List;

public class LastGuestDiscountStrategy implements DiscountStrategy {

    private DiscountStrategy strategy;

    private List<Item> items;

    private LastGuestDiscountStrategy(List<Item> items) {
        this.items = items;
    }

    public void onFirstGuestButtonClick() {
        strategy = new LastGuestDiscountStrategy(items);
    }

    public void onCalculationButtonClick() {
        Calculator cal = new Calculator(strategy);
        int price = cal.calculate(items);
    }

    @Override
    public int getDiscountPrice(Item item) {
        return (int) (item.getPrice());
    }
}
