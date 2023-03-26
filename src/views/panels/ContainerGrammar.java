package views.panels;

import models.Node;

import javax.swing.*;
import java.awt.*;

public class ContainerGrammar extends JPanel {

    private ElementsGrammarPanel elementsGrammarPanel;
    private ProductionsPanel productionsPanel;

    private GeneralTreePaintedPanel generalTreePaintedPanel;


    public ContainerGrammar(){
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.initComponents();
        this.setVisible(true);
    }

    private void initComponents() {
        this.elementsGrammarPanel = new ElementsGrammarPanel();
        this.productionsPanel = new ProductionsPanel();

        this.generalTreePaintedPanel = new GeneralTreePaintedPanel();

        this.add(elementsGrammarPanel);
        this.add(productionsPanel);
    }

    public void addGeneralTreePaintedPanel(Node node){
        this.removeAllPanels();
        this.generalTreePaintedPanel.setRoot(node);
        this.add(elementsGrammarPanel);
        this.add(generalTreePaintedPanel);
        SwingUtilities.updateComponentTreeUI(this);
    }

    private void removeAllPanels(){
        this.remove(elementsGrammarPanel);
        this.remove(productionsPanel);
        SwingUtilities.updateComponentTreeUI(this);
    }

    public void setvLabel(String vLabel) {
        this.elementsGrammarPanel.setvLabel(vLabel);
    }

    public void setSigmaValueLabel(String sigmaValueLabel) {
        this.elementsGrammarPanel.setSigmaValueLabel(sigmaValueLabel);
    }


    public String getAxiomaticValueLabel() {
        return elementsGrammarPanel.getAxiomaticValueLabel();
    }

    public void setAxiomaticValueLabel(String axiomaticValueLabel) {
        this.elementsGrammarPanel.setAxiomaticValueLabel(axiomaticValueLabel);
    }

    public void setProductions(Object[][] parseArrayListToMatrixObject) {
        this.productionsPanel.setDefaultTableModel(parseArrayListToMatrixObject);
    }
}
