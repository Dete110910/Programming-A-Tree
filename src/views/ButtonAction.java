package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ButtonAction extends JButton {

    private final int WIDTH = 200;
    private final int HEIGHT = 30;

    public ButtonAction(String buttonText, ActionListener listener, String actionCommand){
        super(buttonText);
        this.setBackground(Color.decode("#38A3A5"));
        this.setForeground(Color.WHITE);
        this.setFont(ConstantsGUI.FONT_MENU_BUTTONS);
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setActionCommand(actionCommand);
        this.addActionListener(listener);
    }
}
