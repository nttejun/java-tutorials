package order;

public abstract class Food {
    String description = "없음";

    public String getDescription() {
        return description;
    }

    public abstract double cost();

    @Override
    public String toString() {
        return getDescription() + ": $ " + cost();
    }
}
