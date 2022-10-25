package vending.command;

import vending.state.State;

public interface Command {
    void execute(State state);
}
