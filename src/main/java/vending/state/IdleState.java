package vending.state;

import vending.product.Product;
import vending.software.Order;
import vending.software.VendingMachine;

public class IdleState implements State {

    private final VendingMachine machine;
    private final Order order;
    public IdleState(VendingMachine machine, Order order) {
        this.machine = machine;
        this.order = order;
        System.out.println("Please insert money");
    }

    @Override
    public void insertMoney(double amount) {
        order.insertMoney(amount);
        System.out.printf("%.2f inserted%n", amount);
        machine.setState(new SelectingState(machine, order));
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
        double change = order.getChange();
        System.out.printf("You got %.2f in change%n", change);
    }
}
