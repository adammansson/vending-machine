package vending.software;

public class Inventory {

    public static Product parseString(String s) {
        return switch (s) {
            case "drink" -> new Drink();
            default -> new Snack();
        };
    }
}
