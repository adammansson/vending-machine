package vending.software;

import vending.command.Command;
import vending.state.State;

public interface VendingMachine {
    void setState(State state);

    void setStatus(String status);

    String getStatus();
    void execute(Command command);
}
