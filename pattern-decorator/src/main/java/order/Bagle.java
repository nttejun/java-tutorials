package order;

public class Bagle extends Food {
    public Bagle() {
        description = "베이글";
    }

    @Override
    public double cost() {
        return 2.0;
    }
}
