package vending.command;

import vending.product.Inventory;
import vending.product.ProductParseException;

public class CommandFactory {

    private final Inventory inventory;

    public CommandFactory(Inventory inventory) {
        this.inventory = inventory;
    }
    public Command create(String s) throws CommandParseException, ProductParseException {
        String[] words = s.split(" ");
        return switch (words[0]) {
            case "insert" -> new InsertCommand(Double.parseDouble(words[1]));
            case "select" -> new SelectCommand(inventory.parseString(words[1]));
            case "dispense" -> new DispenseCommand();
            case "abort" -> new AbortCommand();
            default -> throw new CommandParseException("Command not found");
        };
    }
}
