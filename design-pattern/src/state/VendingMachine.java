package state;

public class VendingMachine {

    private State state;

    public VendingMachine() {
        state = new NoCoinState();
    }

    public void insertCoin(int coin) {
        state.increaseCoin(coin, this);
    }

    public void select(int productId) {
        state.select(productId, this);
    }

    public void changeState(State newState) {
        this.state = newState;
    }

    public boolean hasNoCoin() {
        return true;
    }

    public void decreaseCoin() {
    }

    public void provideProduct(int productId) {
    }

    public void increaseCoin(int coin) {
    }

}
