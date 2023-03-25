package views;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class MenuButton extends JButton {

    private final int WIDTH = 300;
    private final int HEIGHT = 40;

    public MenuButton(String buttonText, ActionListener listener, String actionCommand){
        super(buttonText);
        this.setBackground(Color.decode("#38A3A5"));
        this.setForeground(Color.WHITE);
        this.setFont(ConstantsGUI.FONT_MENU_BUTTONS);
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setActionCommand(actionCommand);
        this.addActionListener(listener);
    }

}
