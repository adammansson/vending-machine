package vending;

import vending.software.VendingMachine;

public class Main {

    void run() {
        var machine = new VendingMachine();
        machine.run();
    }
    public static void main(String[] args) {
        new Main().run();
    }
}