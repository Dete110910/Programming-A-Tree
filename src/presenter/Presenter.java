package presenter;

import models.GeneralTree;
import models.Grammar;
import models.Node;
import views.MainFrame;
import views.UtilitiesMessages;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class Presenter implements ActionListener {

    private MainFrame mainFrame;
    private Grammar grammar;

    public Presenter(){
        this.mainFrame = new MainFrame(this);
        this.grammar = new Grammar();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "Enter Grammar":
                this.enterGrammar();
                break;
            case "Guardar":
                this.saveGrammar();
                break;
            case "View General Tree":
                this.viewGeneralTree();
                break;
            case "Cancelar":
                this.cancelAddGrammar();
        }
    }


    private void enterGrammar(){
        this.mainFrame.showEnterGrammar();
    }

    public void saveGrammar(){
        ArrayList<String> listTerminalSymbol = new ArrayList<>(Arrays.asList(mainFrame.getTerminalSymbol().split(",")));
        ArrayList<String> listNonTerminalSymbol = new ArrayList<>(Arrays.asList(mainFrame.getNonTerminalSymbol().split(",")));
        String axiomaticSymbol = mainFrame.getAxiomaticSymbol();

        grammar.setTerminalSymbolsList(listTerminalSymbol);
        grammar.setNoTerminalSymbolsList(listNonTerminalSymbol);
        grammar.setAxiomaticSymbol(axiomaticSymbol);

        if (validateEmptyTerminalList(listTerminalSymbol)){
            UtilitiesMessages.showErrorDialog("Debe agregar al menos un elemento a la lista", "Error");
        }else if (validateUpperCaseTerminalList(listTerminalSymbol)){
            UtilitiesMessages.showErrorDialog("Los simbolos terminales deben ingresarse en minúscula", "Error");
        } else if (validateEmptyNonTerminalList(listNonTerminalSymbol)) {
            UtilitiesMessages.showErrorDialog("Debe agregar al menos un elemento a la lista", "Error");
        } else if (validateUpperCaseNonTerminalList(listNonTerminalSymbol)) {
            UtilitiesMessages.showErrorDialog("Los simbolos No terminales deben ingresarse en mayúscula", "Error");
        } else if (validateAxiomaticSymbol(axiomaticSymbol)) {
            UtilitiesMessages.showErrorDialog("Solo se puede establecer un simbolo axiomatico", "Error");
        } else if (!validateContainAxiomaticSymbol(axiomaticSymbol,listNonTerminalSymbol)) {
            UtilitiesMessages.showErrorDialog("El simbolo axiomatico debe pertenecer al conjunto de los simbolos no terminales", "Error");
        } else {
            this.mainFrame.setvLabel(grammar.getNoTerminalSymbolsList().toString().replace("[", "{").replace("]", "}"));
            this.mainFrame.setSigmaValueLabel(grammar.getTerminalSymbolsList().toString().replace("[", "{").replace("]", "}"));
            this.mainFrame.setAxiomaticValueLabel(grammar.getAxiomaticSymbol());
            this.mainFrame.hideCreateDialog();
        }
    }

    private boolean validateEmptyTerminalList(ArrayList<String> listTerminalSymbol) {
        boolean list = false;
            if (listTerminalSymbol.isEmpty()) {
                list = true;
            }
            return list;
    }

    private boolean validateUpperCaseTerminalList(ArrayList<String> listTerminalSymbol){
        boolean list = false;
        for (int i = 0; i < listTerminalSymbol.size(); i++) {
            for (int j = 0; j < listTerminalSymbol.get(i).length(); j++) {
                if(Character.isUpperCase(listTerminalSymbol.get(i).charAt(j))){
                    list = true;
                }
            }
        }
        return list;
    }

    private boolean validateEmptyNonTerminalList(ArrayList<String> listNonTerminalSymbol) {
        boolean list = false;
        if (listNonTerminalSymbol.isEmpty()) {
            list = true;
        }
        return list;
    }

    private boolean validateUpperCaseNonTerminalList(ArrayList<String> listNonTerminalSymbol){
        boolean list = false;
        for (int i = 0; i < listNonTerminalSymbol.size(); i++) {
            for (int j = 0; j < listNonTerminalSymbol.get(i).length(); j++) {
                if(!Character.isUpperCase(listNonTerminalSymbol.get(i).charAt(j))){
                    list = true;
                }
            }
        }
        return list;
    }

    private boolean validateAxiomaticSymbol(String axiomaticSymbol){
        boolean list = false;
        if(axiomaticSymbol.length() != 1){
            list = true;
        }
        return list;
    }

    private boolean validateContainAxiomaticSymbol(String axiomaticSymbol, ArrayList<String> listNonTerminalSymbol){
        boolean list = false;
        if(listNonTerminalSymbol.contains(axiomaticSymbol)){
            list = true;
        }
        return list;
    }

    private boolean validateIntersectionList(ArrayList<String> listTerminalSymbol,ArrayList<String> listNonTerminalSymbol){
        boolean list = false;
        for (int i = 0; i < listTerminalSymbol.size(); i++) {
            for (int j = 0; j < listNonTerminalSymbol.size(); j++) {
                if(listNonTerminalSymbol.get(i).contains(listNonTerminalSymbol.get(j))){
                    list = true;
                }
            }
        }
        return list;
    }

    public void cancelAddGrammar(){
        this.mainFrame.hideCreateDialog();
    }

    private void viewGeneralTree() {
        ArrayList<String> nonTerminalSymbolsList = new ArrayList<>();
        nonTerminalSymbolsList.add("S");
        nonTerminalSymbolsList.add("S");
        nonTerminalSymbolsList.add("S");
        ArrayList<String> terminalSymbolsList = new ArrayList<>();
        terminalSymbolsList.add("a");
        terminalSymbolsList.add("Sa");
        terminalSymbolsList.add("Sb");

        GeneralTree generalTree = new GeneralTree(terminalSymbolsList,nonTerminalSymbolsList, new Node("S"));
        generalTree.addNewNode();
        //generalTree.showNodeList();
        this.mainFrame.showGeneralDerivationTreePaintedPanel(generalTree.rootNode);

    }

    private void validateGrammar(){
        //Call arrays generated by front
        //Verify not empty
        //Verify sets disjunction
        //Verify axiomatic isn't empty
    }

    public static void main(String[] args) {
        new Presenter();

        /**

        ArrayList<String> nonTerminalSymbolsList = new ArrayList<>();
        nonTerminalSymbolsList.add("S");
        nonTerminalSymbolsList.add("S");
        nonTerminalSymbolsList.add("S");
        ArrayList<String> terminalSymbolsList = new ArrayList<>();
        terminalSymbolsList.add("a");
        terminalSymbolsList.add("Sa");
        terminalSymbolsList.add("Sb");

        GeneralTree generalTree = new GeneralTree(terminalSymbolsList,nonTerminalSymbolsList, new Node("S"));
        generalTree.addNewNode();
        generalTree.showNodeList();

         */

    }
}
