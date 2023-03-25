package views.panels;

import views.MenuButton;
import views.UtilitiesGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainMenuPanel extends JPanel {

    private final int WIDTH = 300;
    private final int  HEIGHT = 100;

    private JLabel label;
    private MenuButton showEnterGrammarMenu;

    public  MainMenuPanel(ActionListener listener){
        this.setLayout(new GridBagLayout());
        this.setBackground(Color.decode("#22577A"));
        this.setSize(WIDTH, HEIGHT);
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.initComponents(listener);
        this.setVisible(true);
    }

    private void initComponents(ActionListener listener){
        this.label = new JLabel("¿Menú principal?");

        this.showEnterGrammarMenu = new MenuButton("Ingresar gramática", listener, "Enter Grammar");
        UtilitiesGUI.addComponent(this, showEnterGrammarMenu, 0, 1);
    }

}
