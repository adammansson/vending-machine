package vending.gui;

import javax.swing.*;
import java.awt.*;

import static java.awt.Font.BOLD;
import static java.awt.Font.MONOSPACED;

public class Display extends JTextField {

    public Display(int height) {
        super();

        setPreferredSize(new Dimension(100, height));
        setFont(new Font(MONOSPACED, BOLD, 40));
        setHorizontalAlignment(SwingConstants.CENTER);
        setBackground(Color.WHITE);
        setEditable(false);
    }
}
