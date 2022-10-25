package vending.software;

import vending.command.CommandFactory;
import vending.command.CommandParseException;
import vending.product.Inventory;
import vending.product.ProductParseException;
import vending.state.IdleState;
import vending.state.State;

import java.util.Scanner;

public class VendingMachine {

    private State state;

    public void setState(State state) {
        this.state = state;
    }
    public void run() {
        Scanner scanner = new Scanner(System.in);
        String line;
        Inventory inventory = new Inventory();
        CommandFactory cf = new CommandFactory(inventory);
        Order order = new Order();

        System.out.println("Vending machine simulator");
        System.out.println("Syntax: [command] [argument]");

        setState(new IdleState(this, order));
        while (true) {
            line = scanner.nextLine();
            if (line.equals("q")) break;

            try {
                cf.create(line).execute(state);
            } catch (CommandParseException | ProductParseException err) {
                System.out.println(err.getMessage());
            }
        }
    }
}
