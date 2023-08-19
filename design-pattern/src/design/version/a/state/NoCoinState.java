package design.version.a.state;

public class NoCoinState implements State {

    @Override
    public void increaseCoin(int coin, VendingMachine vm) {
        vm.increaseCoin(coin);
        vm.changeState(new SelectableCoinState());
    }

    @Override
    public void select(int productId, VendingMachine vendingMachine) {

    }
}
