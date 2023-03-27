package views.panels;

import javax.swing.*;
import java.awt.*;

public class WordPanel extends JPanel{
    private JLabel lblWord;
    private JTextArea txtWord;

    private final int WIDTH = 400;
    private final int HEIGHT = 200;


    public WordPanel(){
        this.setSize(WIDTH, HEIGHT);
        this.setBackground(Color.decode("#ade8f4"));
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setLayout(new GridBagLayout());
        this.initComponents();
        this.setVisible(true);
    }

    private void initComponents(){
        this.setLayout(new BorderLayout());
        this.lblWord = new JLabel("Palabra: ");
        this.lblWord.setFont(new Font("Arial", Font.BOLD, 35));
        lblWord.setBorder(BorderFactory.createEmptyBorder(10, 15, 0, 15));
        this.txtWord = new JTextArea();
        this.txtWord.setEditable(false);
        this.txtWord.setFont(new Font("Arial", Font.BOLD, 35));
        this.txtWord.setLineWrap(true);
        this.txtWord.setWrapStyleWord(true);
        txtWord.setBorder(BorderFactory.createEmptyBorder(5, 15, 0, 15));
        JScrollPane scrollPane = new JScrollPane(this.txtWord);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        txtWord.setLineWrap(true);
        txtWord.setWrapStyleWord(true);
        txtWord.setOpaque(false);
        txtWord.setBackground(null);
        this.add(lblWord, BorderLayout.NORTH);
        this.add(txtWord, BorderLayout.CENTER);
    }
    public void setTxtWord (String word) {
        txtWord.setText(word);
    }
}
