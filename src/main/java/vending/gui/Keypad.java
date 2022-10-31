package vending.gui;

import javax.swing.*;
import java.awt.*;

public class Keypad extends JPanel {

    ButtonAction numberAction;
    ButtonAction clearAction;

    public Keypad(int rows, int cols, ButtonAction numberAction, ButtonAction clearAction) {
        super(new GridLayout(rows, cols, 2, 2));
        this.numberAction = numberAction;
        this.clearAction = clearAction;

        for (int i = 1; i < 10; i++) {
            addNumberKey(i);
        }
        addNumberKey(0);
        addClearKey("E");
        addClearKey("C");
    }

    private void addNumberKey(int number) {
        Button button = new Button(Integer.toString(number), 80);
        button.addActionListener(e -> numberAction.actionPerformed(button));
        add(button);
    }

    private void addClearKey(String string) {
        Button button = new Button(string, 80);
        button.addActionListener(e -> clearAction.actionPerformed(button));
        add(button);
    }
}
