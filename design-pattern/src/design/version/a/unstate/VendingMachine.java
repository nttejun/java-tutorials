package design.version.a.unstate;

public class VendingMachine {
    public static enum State {NOCOIN, SELECTABLE, SOLDOUT}

    private State state = State.NOCOIN;

    public void insertCoin(int coin) {
        switch (state) {
            case NOCOIN:
                increaseCoin(coin);
                state = State.SELECTABLE;
                break;
            case SELECTABLE:
                increaseCoin(coin);
            case SOLDOUT:
                returnCoin();
        }
    }

    private void select(int productId) {
        switch (state) {
            case NOCOIN:
                break;
            case SELECTABLE:
                provideProduct(productId);
                decreaseCoin();
                if (hasNoCoin())
                    state = State.NOCOIN;
            case SOLDOUT:
                return;
        }
    }

    private void returnCoin() {
    }

    private boolean hasNoCoin() {
        return true;
    }

    private void decreaseCoin() {
    }

    private void provideProduct(int productId) {
    }

    private void increaseCoin(int coin) {
    }
}
