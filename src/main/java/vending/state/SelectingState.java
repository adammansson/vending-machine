package vending.state;

import vending.inventory.Product;
import vending.software.Order;
import vending.software.VendingMachine;

public class SelectingState implements State {

    private final VendingMachine machine;
    private final Order order;

    public SelectingState(VendingMachine machine, Order order) {
        this.machine = machine;
        this.order = order;
//        machine.setStatus("Please select product");
    }

    @Override
    public void insertMoney(double amount) {
        order.insertMoney(amount);
        machine.setStatus(String.format("%.2f inserted%n", amount));
    }

    @Override
    public void selectProduct(Product product) {
        order.selectProduct(product);
        machine.setStatus(String.format("%s selected%n", product.name()));
        machine.setState(new DispenseState(machine, order));
    }

    @Override
    public void dispenseProduct() {
        machine.setStatus("Select product first");
    }

    @Override
    public void abortOrder() {
        double change = order.getChange();
        machine.setStatus(String.format("Order aborted. You got %.2f in change%n", change));
        machine.setState(new IdleState(machine, order));
    }
}
