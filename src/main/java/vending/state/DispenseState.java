package vending.state;

import vending.product.Product;
import vending.software.Order;
import vending.software.VendingMachine;

public class DispenseState implements State {

    private final VendingMachine machine;
    private final Order order;

    public DispenseState(VendingMachine machine, Order order) {
        this.machine = machine;
        this.order = order;
        System.out.println("Dispense product or insert the remaining money");
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
    }

    @Override
    public void dispenseProduct() {
        if (order.remaining() != 0) {
            System.out.printf("Not enough money has been inserted, %.2f remaining%n", order.remaining());
            return;
        }
        System.out.printf("%s has been dispensed%n", order.dispenseProduct().name());
    }

    @Override
    public void abortOrder() {
        System.out.println("Order aborted");
        double change = order.getChange();
        System.out.printf("You got %.2f in change%n", change);
        machine.setState(new IdleState(machine, order));
    }
}
