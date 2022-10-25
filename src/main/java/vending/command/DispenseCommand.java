package vending.command;

import vending.state.State;

public class DispenseCommand implements Command {

    @Override
    public void execute(State state) {
        state.dispenseProduct();
    }
}
