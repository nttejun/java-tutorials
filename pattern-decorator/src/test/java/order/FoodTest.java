package order;

import org.junit.jupiter.api.Test;

class FoodTest {
    @Test
    public void print() {
        Food food = new Bagle();
        System.out.println(food);

        food = new CreamCheeseBagle(food);
        System.out.println(food);
    }
}