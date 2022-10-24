package vending.software;

public class CommandFactory {
    public Command create(String s) {
        String[] words = s.split(" ");
        return switch (words[0]) {
            case "insert" -> new InsertCommand(Double.parseDouble(words[1]));
            case "select" -> new SelectCommand(Inventory.parseString(words[1]));
            case "dispense" -> new DispenseCommand();
            default -> new AbortCommand();
        };
    }
}
