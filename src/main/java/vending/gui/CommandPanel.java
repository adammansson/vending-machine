package vending.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CommandPanel extends JPanel {

    int height;

    public CommandPanel(int height) {
        super();
        this.height = height;
        setPreferredSize(new Dimension(500, height));
    }

    public void addButton(String text, ActionListener al) {
        var b = new Button(text, height);
        b.addActionListener(al);
        add(b);
    }
}
