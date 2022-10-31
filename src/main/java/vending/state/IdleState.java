package vending.state;

import vending.inventory.Product;
import vending.software.Order;
import vending.software.StandardVendingMachine;

public class IdleState implements State {

    private final StandardVendingMachine machine;
    private final Order order;
    public IdleState(StandardVendingMachine machine, Order order) {
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
