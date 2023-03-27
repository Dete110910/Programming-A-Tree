package views.panels;

import javax.swing.*;
import java.awt.*;

public class HorizontalByPassTree extends JPanel{
    private final int WIDTH = 800;
    private final int HEIGHT = 600;
    private JLabel title;
    private JTextArea labelTree;

    public HorizontalByPassTree() {
        this.setSize(WIDTH, HEIGHT);
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.initComponents();
        this.setVisible(true);
    }

    private void initComponents() {
        this.setLayout(new BorderLayout());
        this.setBackground(Color.WHITE);
        labelTree = new JTextArea();
        labelTree.setEditable(false);
        title = new JLabel("Árbol de derivación particular horizontal");
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setForeground(Color.decode("#22577A"));
        title.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        title.setFont(new Font("Arial", Font.BOLD, 40));
        labelTree.setFont(new Font("Arial", Font.BOLD, 34));
        labelTree.setBorder(BorderFactory.createEmptyBorder(30, 20, 0, 20));
        labelTree.setLineWrap(true);
        labelTree.setWrapStyleWord(true);
        labelTree.setOpaque(false);
        labelTree.setBackground(null);

        this.add(title, BorderLayout.NORTH);
        this.add(labelTree, BorderLayout.CENTER);

        this.setBorder(null);
    }

    public void setHorizontalBypassTree (String horizontalBypassTree) {
        labelTree.setText(horizontalBypassTree);
    }




}
