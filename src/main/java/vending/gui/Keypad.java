package vending.gui;

import javax.swing.*;
import java.awt.*;

public class Keypad extends JPanel {

    ButtonAction action;

    public Keypad(int rows, int cols, ButtonAction action) {
        super(new GridLayout(rows, cols, 2, 2));
        this.action = action;

        for (int i = 1; i < 10; i++) {
            addKey(i);
        }
        addKey(0);
    }

    private void addKey(int number) {
        Button button = new Button(Integer.toString(number), 80);
        button.addActionListener(e -> action.actionPerformed(button));
        add(button);
    }
}
