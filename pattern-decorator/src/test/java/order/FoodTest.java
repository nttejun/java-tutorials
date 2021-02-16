package order;

import org.junit.jupiter.api.Test;

class FoodTest {
    @Test
    public void print() {
        Food food1 = new Bagle();
        System.out.println(food1);

        food1 = new CreamCheeseBagle(food1);
        System.out.println(food1);

        Food food2 = new Bagle();
        System.out.println(food2);

        food2 = new CranberryBagle(food2);
        System.out.println(food2);
    }
}