package vending;

import vending.gui.VendingGUI;

public class Main {

    void run() {
        //var machine = new VendingMachine();
        //machine.run();
        new VendingGUI();
    }
    public static void main(String[] args) {
        new Main().run();
    }
}