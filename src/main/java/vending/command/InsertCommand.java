package vending.command;

import vending.state.State;

public class InsertCommand implements Command {

    private final double amount;
    public InsertCommand(double amount) {
        this.amount = amount;
    }
    @Override
    public void execute(State state) {
        state.insertMoney(amount);
    }
}
