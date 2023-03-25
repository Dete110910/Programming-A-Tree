package views;

import views.panels.ContainerGrammar;
import views.panels.MainMenuPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {

    private final int HEIGHT = 1000;
    private final int WIDTH = 1000;

    private MainMenuPanel mainMenuPanel;
    private ContainerGrammar containerGrammar;

    public MainFrame(ActionListener listener){
        this.setTitle("Validador de Gramática");
        this.setBackground(Color.decode("#C7F9CC"));
        this.setSize(WIDTH, HEIGHT);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.initComponents(listener);
        this.setVisible(true);
    }

    private void initComponents(ActionListener listener){
        this.mainMenuPanel = new MainMenuPanel(listener);
        this.containerGrammar = new ContainerGrammar();

        this.add(mainMenuPanel, BorderLayout.NORTH);
        this.add(containerGrammar, BorderLayout.CENTER);
    }

    public void showEnterGrammarMenu(){

    }

}
