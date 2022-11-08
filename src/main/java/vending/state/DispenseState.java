package vending.state;

import vending.inventory.Product;
import vending.software.Order;
import vending.software.VendingMachine;

public class DispenseState implements State {

    private final VendingMachine machine;
    private final Order order;

    public DispenseState(VendingMachine machine, Order order) {
        this.machine = machine;
        this.order = order;
//        machine.setStatus("Dispense product or insert the remaining money");
    }

    @Override
    public void insertMoney(double amount) {
        order.insertMoney(amount);
        machine.setStatus((String.format("%.2f inserted%n", amount)));
    }

    @Override
    public void selectProduct(Product product) {
        order.selectProduct(product);
        machine.setStatus(String.format("%s selected%n", product.name()));
    }

    @Override
    public void dispenseProduct() {
        double remaining = order.remaining();
        if (remaining >= 0) {
            machine.setStatus(String.format("Not enough money has been inserted, %.2f remaining%n", remaining));
            return;
        }
        machine.setStatus(String.format("%s has been dispensed%n", order.dispenseProduct().name()));
    }

    @Override
    public void abortOrder() {
        double change = order.getChange();
        machine.setStatus(String.format("Order aborted. You got %.2f in change%n", change));
        machine.setState(new IdleState(machine, order));
    }
}
