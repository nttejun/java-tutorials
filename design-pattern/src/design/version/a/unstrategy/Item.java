package design.version.a.unstrategy;

public class Item {
    private int price;
    private boolean isFresh;

    public Item (int price, boolean isFresh) {
        this.price = price;
        this.isFresh = isFresh;
    }

    public int getPrice() {
        return price;
    }

    public boolean isFresh() {
        return isFresh;
    }
}
