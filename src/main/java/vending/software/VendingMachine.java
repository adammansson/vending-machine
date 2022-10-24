package vending.software;

import java.util.Scanner;

public class VendingMachine {

    private State state;
    private Order order;
    private CommandFactory cf;

    public VendingMachine() {
        this.order = new Order();
        this.state = new IdleState(this, order);
        this.cf = new CommandFactory();
    }

    public void setState(State state) {
        this.state = state;
    }
    public void run() {
        Scanner scanner = new Scanner(System.in);
        String line;

        System.out.println("Vending machine simulator");
        System.out.println("Syntax: [command] [argument]");
        while (true) {
            line = scanner.nextLine();
            if (line.equals("q") || line.equals("quit")) break;

            cf.create(line).execute(state);
        }
    }
}
