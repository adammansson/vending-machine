package vending.software;

import vending.command.Command;
import vending.inventory.Inventory;
import vending.state.IdleState;
import vending.state.State;

public class StandardVendingMachine implements VendingMachine {

    private State state;
    private Inventory inventory;

    public StandardVendingMachine(Inventory inventory) {
        Order order = new Order();
        this.inventory = inventory;
        setState(new IdleState(this, order));
    }

    public void setState(State state) {
        this.state = state;
    }

    public void execute(Command command) {
        command.execute(state);
    }
}
