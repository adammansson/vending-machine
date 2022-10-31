package vending.gui;

import javax.swing.*;
import java.awt.*;

import static java.awt.Font.BOLD;
import static java.awt.Font.MONOSPACED;

public class Display extends JPanel {

    JTextField main = new JTextField();
    JTextField status = new JTextField();
    public Display(int height) {
        super();

        setPreferredSize(new Dimension(400, 2*height));

        main.setPreferredSize(new Dimension(400, height));
        main.setFont(new Font(MONOSPACED, BOLD, 64));
        main.setHorizontalAlignment(SwingConstants.CENTER);
        main.setEditable(false);

        status.setPreferredSize(new Dimension(400, height / 2));
        status.setFont(new Font(MONOSPACED, BOLD, 12));
        status.setHorizontalAlignment(SwingConstants.CENTER);
        status.setEditable(false);

        add(main, BorderLayout.CENTER);
        add(status, BorderLayout.SOUTH);
    }

    public void setText(String string) {
        main.setText(string);
    }

    public void setStatusText(String string) {
        status.setText(string);
    }

    public String getText() {
        return main.getText();
    }
}
