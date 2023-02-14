package vending.gui;

import vending.command.*;
import vending.inventory.Inventory;
import vending.inventory.ProductParseException;
import vending.software.SnackVendingMachine;
import vending.software.VendingMachine;

import javax.swing.*;
import java.awt.*;

public class VendingGUI extends JFrame {

    VendingMachine machine = new SnackVendingMachine();
    Display display = new Display(120);
    Inventory inventory = new Inventory();

    public VendingGUI() {
        super("Vending machine");
        initGUI();
    }

    private void initGUI() {
        add(display, BorderLayout.NORTH);

        Keypad keypad =
                new Keypad(
                        button -> display.setText(display.getText() + button.getText()),
                        button -> display.setText(""));
        add(keypad, BorderLayout.SOUTH);

        CommandPanel commandPanel = new CommandPanel(120);
        add(commandPanel);

        commandPanel.addButton("Insert money", e -> {
            Double[] prices = {1.0, 5.0, 10.0, 20.0};
            Object res = JOptionPane.showInputDialog(null, "Choose how much to insert: ",
                "Insert money", JOptionPane.QUESTION_MESSAGE, null, prices, prices[2]);
            double amount = (res == null ? 0.0 : (double) res);
            executeCommand(new InsertCommand(amount));
        });

        commandPanel.addButton("Select product", e -> {
            try {
                executeCommand(new SelectCommand(inventory.getProductById(display.getText())));
            } catch (ProductParseException ex) {
                display.setStatusText(ex.getMessage());
            }
        });

        commandPanel.addButton("Dispense", e -> {
            executeCommand(new DispenseCommand());
            display.setText("");
        });

        commandPanel.addButton("Abort", e -> {
            executeCommand(new AbortCommand());
            display.setText("");
        });

        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    private void executeCommand(Command command) {
        machine.execute(command);
        display.setStatusText(machine.getStatus());
    }
}
