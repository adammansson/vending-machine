package vending.software;

public class PayingState implements State {

    private VendingMachine machine;
    private Order order;

    public PayingState(VendingMachine machine, Order order) {
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
        System.out.printf("%s selected%n", product.name());
    }

    @Override
    public void dispenseProduct() {
        if (!order.payed()) {
            System.out.println("Not enough money has been inserted");
            return;
        }
        System.out.printf("%s has been dispensed%n", order.payedProduct().name());

        double change = order.getChange();
        System.out.printf("You got %.2f in change%n", change);
        if (change == 0) {
            machine.setState(new IdleState(machine, order));
        } else {
            machine.setState(new SelectingState(machine, order));
        }
    }

    @Override
    public void abortOrder() {
        machine.setState(new SelectingState(machine, order));
        System.out.println("Order aborted");
    }
}
