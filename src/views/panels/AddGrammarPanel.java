package views.panels;

import views.ButtonAction;
import views.ConstantsGUI;
import views.MenuButton;
import views.UtilitiesGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class AddGrammarPanel extends JDialog {
    private ButtonAction saveGrammar, cancel;
    private JLabel text,addTerminalSymbol, addNonTerminalSymbol, addAxiomaticSymbol;
    private JTextField terminalSymbol, nonTerminalSymbol, axiomaticSymbol;

    public AddGrammarPanel(ActionListener listener){
        this.setModal(true);
        this.setTitle("Añadir Gramatica");
        this.setLayout(new GridBagLayout());
        this.setFont(ConstantsGUI.FONT_TABLE_HEADER);
        this.setSize(600, 400);
        this.setUndecorated(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.getContentPane().setBackground(Color.decode("#89c2d9"));
        initComponents(listener);
    }

    private void initComponents(ActionListener listener){

        addTerminalSymbol = new JLabel("Simbolos Terminales");
        addTerminalSymbol.setFont(ConstantsGUI.FONT_MENU_BUTTONS);
        UtilitiesGUI.addComponent(this, addTerminalSymbol, 0, 0, 0,0,10,0);

        terminalSymbol = new JTextField(15);
        terminalSymbol.setSize(100,50);
        terminalSymbol.setPreferredSize(new Dimension(100,30));
        terminalSymbol.setBackground(Color.WHITE);
        terminalSymbol.setFont(ConstantsGUI.FONT_TABLE_BODY);
        UtilitiesGUI.addComponent(this, terminalSymbol, 1, 0, 0,0,10,0);

        addNonTerminalSymbol = new JLabel("Simbolos No Terminales");
        addNonTerminalSymbol.setFont(ConstantsGUI.FONT_MENU_BUTTONS);
        UtilitiesGUI.addComponent(this, addNonTerminalSymbol, 0, 1, 0,0,10,0);

        nonTerminalSymbol = new JTextField(15);
        nonTerminalSymbol.setSize(100,50);
        nonTerminalSymbol.setPreferredSize(new Dimension(100,30));
        nonTerminalSymbol.setBackground(Color.WHITE);
        nonTerminalSymbol.setFont(ConstantsGUI.FONT_TABLE_BODY);
        UtilitiesGUI.addComponent(this, nonTerminalSymbol, 1, 1, 0,0,10,0);

        addAxiomaticSymbol = new JLabel("Simbolo Axiomatico");
        addAxiomaticSymbol.setFont(ConstantsGUI.FONT_MENU_BUTTONS);
        UtilitiesGUI.addComponent(this, addAxiomaticSymbol, 0, 2, 0,0,0,0);

        axiomaticSymbol = new JTextField(15);
        axiomaticSymbol.setSize(100,50);
        axiomaticSymbol.setPreferredSize(new Dimension(100,30));
        axiomaticSymbol.setBackground(Color.WHITE);
        axiomaticSymbol.setFont(ConstantsGUI.FONT_TABLE_BODY);
        UtilitiesGUI.addComponent(this, axiomaticSymbol, 1, 2, 0,0,0,0);

        saveGrammar = new ButtonAction("Guardar", listener, "Guardar");
        UtilitiesGUI.addComponent(this, saveGrammar, 0, 4, 20,10,0,0);

        cancel = new ButtonAction("Cancelar", listener, "Cancelar");
        UtilitiesGUI.addComponent(this, cancel, 1, 4, 20,10,0,0);

    }


    public String getTerminalSymbols() {
        return terminalSymbol.getText();
    }


    public String getTerminalSymbol() {
        return terminalSymbol.getText();
    }

    public void setTerminalSymbol(String terminalSymbol) {
        this.terminalSymbol.setText(terminalSymbol);
    }

    public String getNonTerminalSymbol() {
        return nonTerminalSymbol.getText();
    }

    public void setNonTerminalSymbol(String nonTerminalSymbol) {
        this.nonTerminalSymbol.setText(nonTerminalSymbol);
    }

    public String getAxiomaticSymbol() {
        return axiomaticSymbol.getText();
    }

    public void setAxiomaticSymbol(String axiomaticSymbol) {
        this.axiomaticSymbol.setText(axiomaticSymbol);
    }



    public void cleanFields(){
        this.terminalSymbol.setText("");
        this.nonTerminalSymbol.setText("");
        this.axiomaticSymbol.setText("");
    }


}
