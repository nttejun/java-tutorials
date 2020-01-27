package exam.management.salary;

public class User {
    
    private int taxRate;
    private int salary;

    public User(int taxRate, int salary) {
        this.taxRate = taxRate;
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public int getTaxRate() {
        return taxRate;
    }
}
