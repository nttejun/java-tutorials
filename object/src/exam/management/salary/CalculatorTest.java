package exam.management.salary;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {

    @Test
    public void createUserObject(){
        User user = new User(35, 3000000);
        Assert.assertEquals(35, user.getTaxRate());
        Assert.assertEquals(3000000, user.getSalary());
    }

    @Test
    public void payCalculate(){
        User user = new User(15, 3000000);
        double taxRate = user.getTaxRate();
        double salary = user.getSalary();
        Calculator calculator = new Calculator();
        Assert.assertEquals(30600000, calculator.calculatePostTaxAnnualSalary(taxRate, salary));
    }

}