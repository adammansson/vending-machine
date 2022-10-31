package vending.gui;

import vending.command.AbortCommand;
import vending.command.DispenseCommand;
import vending.command.InsertCommand;
import vending.command.SelectCommand;
import vending.inventory.Inventory;
import vending.inventory.ProductParseException;
import vending.software.StandardVendingMachine;
import vending.software.VendingMachine;

import javax.swing.*;
import java.awt.*;

public class VendingGUI extends JFrame {

    public VendingGUI() {
        super("Vending machine");

        Inventory inventory = new Inventory();
        VendingMachine machine = new StandardVendingMachine(inventory);

        Display display = new Display(120);
        add(display, BorderLayout.NORTH);

        Keypad keypad = new Keypad(4, 3, key -> display.setText(display.getText() + key.getText()));
        add(keypad, BorderLayout.SOUTH);

        JPanel buttonPanel = new JPanel();
        Button insertButton = new Button("Insert money", 120);
        insertButton.addActionListener(e -> {
            Integer[] prices = {1, 5, 10, 20};
            int n = (int) JOptionPane.showInputDialog(null, "Chose how much to insert: ",
                "Insert money", JOptionPane.QUESTION_MESSAGE, null, prices, prices[2]);
            machine.execute(new InsertCommand(n));
        });
        buttonPanel.add(insertButton);

        Button selectButton = new Button("Select product", 120);
        selectButton.addActionListener(e -> {
            try {
                machine.execute(new SelectCommand(inventory.getProductById(display.getText())));
            } catch (ProductParseException ex) {
                throw new RuntimeException(ex);
            }
        });
        buttonPanel.add(selectButton, BorderLayout.EAST);

        Button dispenseButton = new Button("Dispense", 120);
        dispenseButton.addActionListener(e -> machine.execute(new DispenseCommand()));
        buttonPanel.add(dispenseButton);

        Button abortButton = new Button("Abort", 120);
        abortButton.addActionListener(e -> machine.execute(new AbortCommand()));
        buttonPanel.add(abortButton);
        add(buttonPanel);

        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }
}
