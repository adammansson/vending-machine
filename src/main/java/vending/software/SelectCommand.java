package vending.software;

public class SelectCommand implements Command {

    private Product product;

    public SelectCommand(Product product) {
        this.product = product;
    }
    @Override
    public void execute(State state) {
        state.selectProduct(product);
    }
}
