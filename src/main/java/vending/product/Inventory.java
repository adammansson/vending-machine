package vending.product;

public class Inventory {

    public Product parseString(String s) throws ProductParseException {
        return switch (s) {
            case "drink" -> new Drink();
            case "snack" -> new Snack();
            default -> throw new ProductParseException("Product not found");
        };
    }
}
