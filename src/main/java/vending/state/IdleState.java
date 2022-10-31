package vending.state;

import vending.inventory.Product;
import vending.software.Order;
import vending.software.VendingMachine;

public class IdleState implements State {

    private final VendingMachine machine;
    private final Order order;
    public IdleState(VendingMachine machine, Order order) {
        this.machine = machine;
        this.order = order;
        machine.setStatus("Please insert money");
    }

    @Override
    public void insertMoney(double amount) {
        if (amount <= 0) {
            machine.setStatus("No money inserted");
            return;
        }
        order.insertMoney(amount);
        machine.setStatus(String.format("%.2f inserted%n", amount));
        machine.setState(new SelectingState(machine, order));
    }

    @Override
    public void selectProduct(Product product) {
        machine.setStatus("Insert money first");
    }

    @Override
    public void dispenseProduct() {
        machine.setStatus("Insert money and select product first");
    }

    @Override
    public void abortOrder() {
        double change = order.getChange();
        machine.setStatus(String.format("Order aborted. You got %.2f in change%n", change));
    }
}
