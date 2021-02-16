package order;

public class CranberryBagle extends Bagle{
    Food food;

    public CranberryBagle(Food food) {
        description = "크렌베리 베이글";
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
