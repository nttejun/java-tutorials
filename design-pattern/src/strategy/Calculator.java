package strategy;

import java.util.List;

public class Calculator {

    private DiscountStrategy strategy;

    public Calculator(DiscountStrategy discountStrategy) {
        this.strategy = discountStrategy;
    }

    public int calculate(List<Item> items) {
        int sum = 0;
        for (Item item : items) {
            sum += strategy.getDiscountPrice(item);
        }
        return sum;
    }
}
