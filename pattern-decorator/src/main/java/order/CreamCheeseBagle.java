package order;

public class CreamCheeseBagle extends Bagle {
    Food food;

    public CreamCheeseBagle(Food food) {
        description = "크림치즈 베이글";
        this.food = food;
    }

    @Override
    public double cost() {
        return 0.5 + food.cost();
    }

    @Override
    public String getDescription() {
        return food.getDescription() + ", " + description;
    }

}
