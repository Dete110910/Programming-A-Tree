package views.panels;

import javax.swing.*;
import java.awt.*;

public class ContainerGrammar extends JPanel {

    private ElementsGrammarPanel elementsGrammarPanel;
    private ProductionsPanel productionsPanel;


    public ContainerGrammar(){
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.initComponents();
        this.setVisible(true);
    }

    private void initComponents() {
        this.elementsGrammarPanel = new ElementsGrammarPanel();
        this.productionsPanel = new ProductionsPanel();

        this.add(elementsGrammarPanel, BorderLayout.PAGE_START);
        this.add(productionsPanel, BorderLayout.PAGE_END);
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

}
