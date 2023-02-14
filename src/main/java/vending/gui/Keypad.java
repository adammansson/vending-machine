package vending.gui;

import javax.swing.*;
import java.awt.*;

public class Keypad extends JPanel {

    ButtonAction numberAction;
    ButtonAction clearAction;

    public Keypad(ButtonAction numberAction, ButtonAction clearAction) {
        super(new GridLayout(4, 3, 2, 2));
        this.numberAction = numberAction;
        this.clearAction = clearAction;

        for (int i = 1; i < 10; i++) {
            addNumberKey(i);
        }
        addClearKey("E");
        addNumberKey(0);
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
