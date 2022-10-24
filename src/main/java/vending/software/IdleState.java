package vending.software;

public class IdleState implements State {

    private VendingMachine machine;
    private Order order;
    public IdleState(VendingMachine machine, Order order) {
        this.machine = machine;
        this.order = order;
    }

    @Override
    public void insertMoney(double amount) {
        order.insertMoney(amount);
        machine.setState(new SelectingState(machine, order));
        System.out.printf("%.2f inserted%n", amount);
    }

    @Override
    public void selectProduct(Product product) {
        System.out.println("Insert money first");
    }

    @Override
    public void dispenseProduct() {
        System.out.println("Insert money and select product first");
    }

    @Override
    public void abortOrder() {
        System.out.println("Order aborted");
    }
}
