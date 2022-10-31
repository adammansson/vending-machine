package vending.gui;

import vending.command.*;
import vending.inventory.Inventory;
import vending.inventory.ProductParseException;
import vending.software.StandardVendingMachine;
import vending.software.VendingMachine;

import javax.swing.*;
import java.awt.*;

public class VendingGUI extends JFrame {

    VendingMachine machine = new StandardVendingMachine();
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
                        4,
                        3,
                        button -> display.setText(display.getText() + button.getText()),
                        button -> display.setText(""));
        add(keypad, BorderLayout.SOUTH);

        JPanel buttonPanel = new JPanel();
        Button insertButton = new Button("Insert money", 120);
        insertButton.addActionListener(e -> {
            Double[] prices = {1.0, 5.0, 10.0, 20.0};
            Object res = JOptionPane.showInputDialog(null, "Choose how much to insert: ",
                "Insert money", JOptionPane.QUESTION_MESSAGE, null, prices, prices[2]);
            double amount = (res == null ? 0.0 : (double) res);
            execute(new InsertCommand(amount));
        });
        buttonPanel.add(insertButton);

        Button selectButton = new Button("Select product", 120);
        selectButton.addActionListener(e -> {
            try {
                execute(new SelectCommand(inventory.getProductById(display.getText())));
            } catch (ProductParseException ex) {
                display.setStatusText(ex.getMessage());
            }
        });
        buttonPanel.add(selectButton, BorderLayout.EAST);

        Button dispenseButton = new Button("Dispense", 120);
        dispenseButton.addActionListener(e -> execute(new DispenseCommand()));
        buttonPanel.add(dispenseButton);

        Button abortButton = new Button("Abort", 120);
        abortButton.addActionListener(e -> execute(new AbortCommand()));
        buttonPanel.add(abortButton);
        add(buttonPanel);

        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    private void execute(Command command) {
        machine.execute(command);
        display.setStatusText(machine.getStatus());
    }
}
