package vending.software;

import vending.command.Command;
import vending.state.IdleState;
import vending.state.State;

public class StandardVendingMachine implements VendingMachine {

    private State state;
    private String status;

    public StandardVendingMachine() {
        Order order = new Order();
        setState(new IdleState(this, order));
    }

    public void setState(State state) {
        this.state = state;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void execute(Command command) {
        command.execute(state);
    }
}
