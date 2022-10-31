package vending.gui;

import javax.swing.*;
import java.awt.*;

public class Button extends JButton {

    public Button(String text, int side) {
        super(text);
        setPreferredSize(new Dimension(side, side));
    }
}
