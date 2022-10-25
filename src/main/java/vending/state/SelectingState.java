package vending.state;

import vending.product.Product;
import vending.software.Order;
import vending.software.VendingMachine;

public class SelectingState implements State {

    private final VendingMachine machine;
    private final Order order;

    public SelectingState(VendingMachine machine, Order order) {
        this.machine = machine;
        this.order = order;
        System.out.println("Please select product");
    }

    @Override
    public void insertMoney(double amount) {
        order.insertMoney(amount);
        System.out.printf("%.2f inserted%n", amount);
    }

    @Override
    public void selectProduct(Product product) {
        order.selectProduct(product);
        System.out.printf("%s selected%n", product.name());
        machine.setState(new DispenseState(machine, order));
    }

    @Override
    public void dispenseProduct() {
        System.out.println("Select product first");
    }

    @Override
    public void abortOrder() {
        System.out.println("Order aborted");
        double change = order.getChange();
        System.out.printf("You got %.2f in change%n", change);
        machine.setState(new IdleState(machine, order));
    }
}
