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

}
