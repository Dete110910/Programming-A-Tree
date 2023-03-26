package views;

import models.Node;
import views.panels.AddGrammarPanel;
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

    private AddGrammarPanel addGrammarPanel;

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

        this.addGrammarPanel = new AddGrammarPanel(listener);
    }

    private void hideAllPanels(){
        SwingUtilities.updateComponentTreeUI(this);
    }
    public void showEnterGrammar(){
        this.addGrammarPanel.setVisible(true);
        SwingUtilities.updateComponentTreeUI(this);
    }



    public String getTerminalSymbols(){
       return this.addGrammarPanel.getTerminalSymbols();
    }

    public String getTerminalSymbol() {
        return addGrammarPanel.getTerminalSymbol();
    }

    public void setTerminalSymbol(String terminalSymbol) {
        this.addGrammarPanel.setTerminalSymbol(terminalSymbol);
    }

    public String getNonTerminalSymbol() {
        return addGrammarPanel.getNonTerminalSymbol();
    }

    public void setNonTerminalSymbol(String nonTerminalSymbol) {
        this.addGrammarPanel.setNonTerminalSymbol(nonTerminalSymbol);
    }

    public String getAxiomaticSymbol() {
        return addGrammarPanel.getAxiomaticSymbol();
    }

    public void setAxiomaticSymbol(String axiomaticSymbol) {
        this.addGrammarPanel.setAxiomaticSymbol(axiomaticSymbol);
    }

    public String getProductions(){
        return this.addGrammarPanel.getProductions();
    }

    public void setvLabel(String vLabel) {
        this.containerGrammar.setvLabel(vLabel);
    }

    public void setSigmaValueLabel(String sigmaValueLabel) {
        this.containerGrammar.setSigmaValueLabel(sigmaValueLabel);
    }

    public void setAxiomaticValueLabel(String axiomaticValueLabel) {
        this.containerGrammar.setAxiomaticValueLabel(axiomaticValueLabel);
    }
    public String getAxiomaticValueLabel() {
        return containerGrammar.getAxiomaticValueLabel();
    }


    public void hideCreateDialog(){
        this.addGrammarPanel.cleanFields();
        this.addGrammarPanel.setVisible(false);
        SwingUtilities.updateComponentTreeUI(this);
    }

    public void showGeneralDerivationTreePaintedPanel(Node node){
        this.containerGrammar.addGeneralTreePaintedPanel(node);
        SwingUtilities.updateComponentTreeUI(this);
    }

    public void setProductions(Object[][] parseArrayListToMatrixObject) {
        this.containerGrammar.setProductions(parseArrayListToMatrixObject);
    }
}
