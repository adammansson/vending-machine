package vending.software;

public class SelectingState implements State {

    private VendingMachine machine;
    private Order order;

    public SelectingState(VendingMachine machine, Order order) {
        this.machine = machine;
        this.order = order;
    }

    @Override
    public void insertMoney(double amount) {
        order.insertMoney(amount);
        System.out.printf("%.2f inserted%n", amount);
    }

    @Override
    public void selectProduct(Product product) {
        order.selectProduct(product);
        machine.setState(new PayingState(machine, order));
        System.out.printf("%s selected%n", product.name());
    }

    @Override
    public void dispenseProduct() {
        System.out.println("Select product first");
    }

    @Override
    public void abortOrder() {
        machine.setState(new SelectingState(machine, order));
        System.out.println("Order aborted");
    }
}
