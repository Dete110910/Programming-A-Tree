package views.panels;

import views.UtilitiesGUI;

import javax.swing.*;
import java.awt.*;

public class GeneralDerivationTree extends JPanel {
    private final int WIDTH = 1200;
    private final int HEIGHT = 800;
    private JLabel title;
    private JTextArea space;
    private JTextArea labelTree1;
    private JTextArea labelTree2;
    private JTextArea labelTree3;
    private JTextArea labelTree4;
    private JTextArea labelTree5;

    public GeneralDerivationTree() {
        this.setSize(WIDTH, HEIGHT);
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.initComponents();
        this.setVisible(true);
    }

    private void initComponents() {
        this.setLayout(new GridBagLayout());
        this.setBackground(Color.WHITE);
        labelTree1 = new JTextArea();
        labelTree2 = new JTextArea();
        labelTree3 = new JTextArea();
        labelTree4 = new JTextArea();
        labelTree5 = new JTextArea();
        labelTree1.setEditable(false);
        title = new JLabel("Árbol de derivación general");
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setForeground(Color.decode("#22577A"));
        title.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        title.setFont(new Font("Arial", Font.BOLD, 50));
        labelTree1.setFont(new Font("Arial", Font.BOLD, 25));
        labelTree1.setOpaque(false);
        labelTree1.setBackground(null);
        labelTree1.setFont(new Font("Arial", Font.BOLD, 25));
        labelTree1.setPreferredSize(new Dimension(1100, 50));
        labelTree2.setOpaque(false);
        labelTree2.setBackground(null);
        labelTree2.setFont(new Font("Arial", Font.BOLD, 25));
        labelTree2.setPreferredSize(new Dimension(1100, 50));
        labelTree3.setOpaque(false);
        labelTree3.setBackground(null);
        labelTree3.setFont(new Font("Arial", Font.BOLD, 25));
        labelTree3.setPreferredSize(new Dimension(1100, 50));
        labelTree4.setOpaque(false);
        labelTree4.setBackground(null);
        labelTree4.setFont(new Font("Arial", Font.BOLD, 25));
        labelTree4.setPreferredSize(new Dimension(1100, 50));
        labelTree5.setOpaque(false);
        labelTree5.setBackground(null);
        labelTree5.setFont(new Font("Arial", Font.BOLD, 25));
        labelTree5.setPreferredSize(new Dimension(1100, 50));
        space = new JTextArea("          ");
        space.setPreferredSize(new Dimension(1100, 500));

        UtilitiesGUI.addComponent(this, title, 0, 0,0,0,0,0);
        UtilitiesGUI.addComponent(this, space, 0, 1,0,0,0,0);
        UtilitiesGUI.addComponent(this, labelTree1, 0, 9,0,0,0,0);
        UtilitiesGUI.addComponent(this, labelTree2, 0, 10,0,0,0,0);
        UtilitiesGUI.addComponent(this, labelTree3, 0, 11,0,0,0,0);
        UtilitiesGUI.addComponent(this, labelTree4, 0, 12,0,0,0,0);
        UtilitiesGUI.addComponent(this, labelTree5, 0, 13,0,0,0,0);

        this.setBorder(null);
    }

    public void setGeneralDerivationTree1(String derivationTree1) {
        labelTree1.setText(derivationTree1);
    }

    public void setGeneralDerivationTree2(String derivationTree2) {
        labelTree2.setText(derivationTree2);
    }
    public void setGeneralDerivationTree3(String derivationTree3) {
        labelTree3.setText(derivationTree3);
    }

    public void setGeneralDerivationTree4(String derivationTree4) {
        labelTree4.setText(derivationTree4);
    }
    public void setGeneralDerivationTree5(String derivationTree5) {
        labelTree5.setText(derivationTree5);
    }

}
