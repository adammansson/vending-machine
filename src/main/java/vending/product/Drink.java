package vending.product;

public class Drink implements Product {
    @Override
    public double cost() {
        return 10.0;
    }

    @Override
    public String name() {
        return "Drink";
    }
}
