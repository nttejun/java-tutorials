package strategy;

import java.util.List;

public class Calculator {

    private DiscountStrategy discountStrategy;

    public Calculator(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public int calculate(List<Item> items) {
        int sum = 0;
        for (Item item : items) {
            sum += discountStrategy.getDiscountPrice(item);
        }
        return sum;
    }

    public int calculate(boolean firstGuest, List<Item> items) {
        int sum = 0;
        for (Item item : items) {
            if (firstGuest) {
                sum += (item.getPrice() * 0.9);
            } else if (!item.isFresh()){
                sum += (item.getPrice() * 0.8);
            } else {
                sum += item.getPrice();
            }
        }
        return sum;
    }
}
