package order;

import org.junit.jupiter.api.Test;

class BeverageTest {

    @Test
    public void print() {
        Beverage beverage1 = new Espresso();
        System.out.println(beverage1);

        beverage1 = new Mocha(beverage1);
        System.out.println(beverage1);

        Beverage beverage2 = new HouseBlend();
        System.out.println(beverage2);

        beverage2 = new Mocha(beverage2);
        System.out.println(beverage2);
    }
}