package vending.command;

import vending.state.State;

public class AbortCommand implements Command {
    @Override
    public void execute(State state) {
        state.abortOrder();
    }
}
