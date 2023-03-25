package views.panels;

import views.ConstantsGUI;

import javax.swing.*;
import java.awt.*;


public class ElementsGrammarPanel extends JPanel {

    private JLabel vLabel, sigmaLabel, axiomaticLabel, vValueLabel, sigmaValueLabel, axiomaticValueLabel;

    private final int WIDTH = 400;
    private final int HEIGHT = 200;


    public ElementsGrammarPanel(){
        this.setSize(WIDTH, HEIGHT);
        this.setBackground(Color.decode("#80ED99"));
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setLayout(new GridBagLayout());
        this.initComponents();
        this.setVisible(true);
    }

    private void initComponents(){
        this.vLabel = new JLabel("V = ");
        this.vLabel.setFont(ConstantsGUI.FONT_PANEL);
        this.addLabel(vLabel, 0, 0, false);
        this.vValueLabel = new JLabel("{ Non terminals }");
        this.vValueLabel.setFont(ConstantsGUI.FONT_PANEL);
        this.addLabel(vValueLabel, 1, 0, true);

        this.sigmaLabel = new JLabel("Σ = ");
        this.sigmaLabel.setFont(ConstantsGUI.FONT_PANEL);
        this.addLabel(sigmaLabel, 0, 1, false);
        this.sigmaValueLabel = new JLabel("{ Terminals }");
        this.sigmaValueLabel.setFont(ConstantsGUI.FONT_PANEL);
        this.addLabel(sigmaValueLabel, 1, 1, true);

        this.axiomaticLabel = new JLabel("S = ");
        this.axiomaticLabel.setFont(ConstantsGUI.FONT_PANEL);
        this.addLabel(axiomaticLabel, 0, 2, false);
        this.axiomaticValueLabel = new JLabel("{ Axiomatic }");
        this.axiomaticValueLabel.setFont(ConstantsGUI.FONT_PANEL);
        this.addLabel(axiomaticValueLabel, 1, 2, true);

    }

    private void addLabel(JComponent jComponent,int gridX, int gridY, boolean fills){
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = gridX;
        gridBagConstraints.gridy = gridY;

        if(fills){
            gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
            gridBagConstraints.gridwidth = GridBagConstraints.REMAINDER;
            gridBagConstraints.anchor = GridBagConstraints.LINE_END;
        }

        else{
            gridBagConstraints.fill = GridBagConstraints.NONE;
            gridBagConstraints.anchor = GridBagConstraints.LINE_START;
        }

        this.add(jComponent, gridBagConstraints);
    }

}
