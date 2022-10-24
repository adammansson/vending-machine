package vending.software;

public class AbortCommand implements Command {
    @Override
    public void execute(State state) {
        state.abortOrder();
    }
}
