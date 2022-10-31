package vending.software;

import vending.command.Command;
import vending.state.State;

public interface VendingMachine {
    void setState(State state);
    void execute(Command command);
}
