package vending.software;

public class InsertCommand implements Command {

    private double amount;
    public InsertCommand(double amount) {
        this.amount = amount;
    }
    @Override
    public void execute(State state) {
        state.insertMoney(amount);
    }
}
