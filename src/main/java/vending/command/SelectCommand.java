package vending.command;

import vending.inventory.Product;
import vending.state.State;

public class SelectCommand implements Command {

    private final Product product;

    public SelectCommand(Product product) {
        this.product = product;
    }
    @Override
    public void execute(State state) {
        state.selectProduct(product);
    }
}
