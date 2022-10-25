package vending.product;

public class Snack implements Product {
    @Override
    public double cost() {
        return 5.0;
    }

    @Override
    public String name() {
        return "Snack";
    }
}
