package design.version.a.state;

public interface State {
    public void increaseCoin(int coin, VendingMachine vm);
    public void select(int productId, VendingMachine vm);
}
