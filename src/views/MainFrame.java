package views;

import models.Node;
import views.panels.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainFrame extends JFrame {

    private final int HEIGHT = 1000;
    private final int WIDTH = 1000;

    private MainMenuPanel mainMenuPanel;
    private ContainerGrammar containerGrammar;

    private AddGrammarPanel addGrammarPanel;
    private ParticularTreePanel particularTreePanel;
    private GeneralDerivationTree generalDerivationTree;

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
        this.particularTreePanel = new ParticularTreePanel();
        this.generalDerivationTree = new GeneralDerivationTree();
        this.add(mainMenuPanel, BorderLayout.NORTH);
        this.add(containerGrammar, BorderLayout.CENTER);

        this.addGrammarPanel = new AddGrammarPanel(listener);
    }

    private void hideAllPanels(){
        containerGrammar.setVisible(false);
        addGrammarPanel.setVisible(false);
        generalDerivationTree.setVisible(false);
        particularTreePanel.setVisible(false);
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

    public void showGeneralDerivationTree(ArrayList<String> stringsTree) {
        generalDerivationTree.setGeneralDerivationTree1(stringsTree.get(0));
        generalDerivationTree.setGeneralDerivationTree2(stringsTree.get(1));
        generalDerivationTree.setGeneralDerivationTree3(stringsTree.get(2));
        generalDerivationTree.setGeneralDerivationTree4(stringsTree.get(3));
        generalDerivationTree.setGeneralDerivationTree5(stringsTree.get(4));
        hideAllPanels();
        generalDerivationTree.setVisible(true);
        add(generalDerivationTree, BorderLayout.CENTER);

        revalidate();
        repaint();
    }

    public void showHorizontalByPassTree(String horizontalByPassTree, String word) {
        particularTreePanel.setHorizontalByPassTree(horizontalByPassTree);
        particularTreePanel.setWord(word);
        containerGrammar.setVisible(false);
        add(particularTreePanel, BorderLayout.CENTER);
        hideAllPanels();
        particularTreePanel.setVisible(true);
        revalidate();
        repaint();
    }

    public void setProductions(Object[][] parseArrayListToMatrixObject) {
        this.containerGrammar.setProductions(parseArrayListToMatrixObject);
    }
}
