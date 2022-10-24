package vending.software;

public class DispenseCommand implements Command {
    @Override
    public void execute(State state) {
        state.dispenseProduct();
    }
}
