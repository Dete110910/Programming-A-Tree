package presenter;

import models.GeneralTree;
import models.Grammar;
import models.Node;
import views.Dialogs.ValidationDialog;
import views.Dialogs.WordDialog;
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
            case "View Particular Tree":
                this.viewParticularTree();
                break;
            case "Check Word":
                this.viewCheckWord();
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
        ArrayList<String> productionsList = new ArrayList<>();

        String productions = this.mainFrame.getProductions();
        String lastSymbolProductions = " ";
        if(productions.length() > 0){
            lastSymbolProductions = String.valueOf(productions.charAt(this.mainFrame.getProductions().length() - 1));

        }
        boolean areProductionsValid = false;
        if(lastSymbolProductions.equals(";")){
             productionsList = new ArrayList<>(Arrays.asList(this.mainFrame.getProductions().split(";")));
             areProductionsValid = this.validateProductions(productionsList, listTerminalSymbol, listNonTerminalSymbol);
        }



        if (validateEmptyList(listTerminalSymbol)){
            UtilitiesMessages.showErrorDialog("Debe agregar al menos un elemento a la lista de Símbolos Terminales. \n Estos deben estar separados por comas \",\"", "Error");
        } else if (validateEmptyList(listNonTerminalSymbol)) {
            UtilitiesMessages.showErrorDialog("Debe agregar al menos un elemento a la lista Símbolos No Terminales. \n Estos deben estar separados por comas \",\"", "Error");
        } else if (validateAxiomaticSymbol(axiomaticSymbol)) {
            UtilitiesMessages.showErrorDialog("Debe establecer uno y solo un Símbolo Axiomático", "Error");
        }else if (!areListDisjunction(listTerminalSymbol, listNonTerminalSymbol)){
            UtilitiesMessages.showErrorDialog("Las listas de Símbolos Teminales y No Terminales deben ser disyuntas", "Error");
        } else if (!validateContainAxiomaticSymbol(axiomaticSymbol,listNonTerminalSymbol)) {
            UtilitiesMessages.showErrorDialog("El Simbolo Axiomático debe pertenecer al conjunto de los Simbolos No Terminales", "Error");
        } else if(!areProductionsValid){
            UtilitiesMessages.showErrorDialog("Las producciones ingresadas no son correctas. \n Estas deben tener la forma \"ST,SNT;\"", "Error");
        }
        else {
            grammar.setTerminalSymbolsList(listTerminalSymbol);
            grammar.setNoTerminalSymbolsList(listNonTerminalSymbol);
            grammar.setAxiomaticSymbol(axiomaticSymbol);
            grammar.setLeftList(this.getLeftList(this.parseProductionsToMatrix(productionsList)));
            grammar.setRightList(this.getRightList(this.parseProductionsToMatrix(productionsList)));


            this.mainFrame.setvLabel(grammar.getNoTerminalSymbolsList().toString().replace("[", "{ ").replace("]", " }"));
            this.mainFrame.setSigmaValueLabel(grammar.getTerminalSymbolsList().toString().replace("[", "{ ").replace("]", " }"));
            this.mainFrame.setAxiomaticValueLabel(grammar.getAxiomaticSymbol());
            this.mainFrame.setProductions(grammar.parseArrayListToMatrixObject());
            this.mainFrame.hideCreateDialog();
        }
    }

    private ArrayList<String> getLeftList(ArrayList<ArrayList<String>> parseProductionsToMatrix) {
        ArrayList<String> leftList = new ArrayList<>();
        for(int i = 0; i < parseProductionsToMatrix.size(); i++){
            leftList.add(parseProductionsToMatrix.get(i).get(0));
        }
        return leftList;
    }

    private ArrayList<String> getRightList (ArrayList<ArrayList<String>> parseProductionsToMatrix) {
        ArrayList<String> rightList = new ArrayList<>();
        for(int i = 0; i < parseProductionsToMatrix.size(); i++){
            rightList .add(parseProductionsToMatrix.get(i).get(1));
        }
        return rightList ;
    }

    private boolean validateProductions(ArrayList<String> productionsList, ArrayList<String> terminalList, ArrayList<String> noTerminalsList) {
        ArrayList<ArrayList<String>> productionMatrix = this.parseProductionsToMatrix(productionsList);
        boolean isValid = false;
        for(int i = 0; i < productionMatrix.size(); i++){
            isValid = true;
            if(!noTerminalsList.contains(productionMatrix.get(i).get(0)) || !this.rightProductionListIsValid(productionMatrix.get(i).get(1), terminalList, noTerminalsList))
                isValid = false;
        }
        return isValid;
    }

    private ArrayList<ArrayList<String>> parseProductionsToMatrix(ArrayList<String> productionsList) {
        ArrayList<ArrayList<String>> productionMatrix = new ArrayList<>();
        for(int i = 0; i < productionsList.size(); i++){
            ArrayList<String> productionsRow = new ArrayList<>(Arrays.asList(productionsList.get(i).split(",")));
            if(productionsRow.size() < 2){
                productionsRow.add(" ");
            }

            productionMatrix.add(productionsRow);
        }
        System.out.println(productionMatrix);
        return  productionMatrix;
    }

    private boolean rightProductionListIsValid(String rightElement, ArrayList<String> terminalList, ArrayList<String> noTerminalList){
        for(int i = 0; i < rightElement.length(); i++){
            System.out.println(terminalList.contains(String.valueOf(rightElement.charAt(i))) + " terminal");
            System.out.println(noTerminalList.contains(String.valueOf(rightElement.charAt(i))) + " no Terminal");
            if(!terminalList.contains(String.valueOf(rightElement.charAt(i))) && !noTerminalList.contains(String.valueOf(rightElement.charAt(i)))){
                System.out.println("Es inválida");
                return false;

            }
        }
        System.out.println("Es válida");
        return true;
    }

    private boolean validateEmptyList(ArrayList<String> listTerminalSymbol) {
        for(int i = 0; i < listTerminalSymbol.size(); i++){
            if(listTerminalSymbol.get(i).trim().equals("")){
                return true;
            }
        }
            return false;
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
        if(axiomaticSymbol.split(",").length != 1){
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

    private boolean areListDisjunction(ArrayList<String> listTerminalSymbol,ArrayList<String> listNonTerminalSymbol){
        for (int i = 0; i < listTerminalSymbol.size(); i++) {
            for (int j = 0; j < listNonTerminalSymbol.size(); j++) {
                if(listTerminalSymbol.get(i).equals(listNonTerminalSymbol.get(j))){
                    return false;
                }
            }
        }
        return true;
    }


    public void cancelAddGrammar(){
        this.mainFrame.hideCreateDialog();
    }

    private void viewGeneralTree() {
        ArrayList<String> stringsTree = grammar.getTextGeneralTree();
        mainFrame.showGeneralDerivationTree(stringsTree);
    }

    private void viewParticularTree() {
        WordDialog wordDialog = new WordDialog();
        wordDialog.setVisible(true);
        String word = wordDialog.getPalabra();
        if (word == null) {
            UtilitiesMessages.showErrorDialog("No ingresó ninguna palabra.", "Error");
        } else {
            String horizontalBypassTree = grammar.generateHorizontalDerivationWord(word);
            mainFrame.showHorizontalByPassTree(horizontalBypassTree, word);
        }
    }

    private void viewCheckWord() {
        WordDialog wordDialog = new WordDialog();
        wordDialog.setVisible(true);
        String word = wordDialog.getPalabra();
        if (word == null) {
            UtilitiesMessages.showErrorDialog("No ingresó ninguna palabra.", "Error");
        } else {
            boolean validation = grammar.checkWordInGrammar(word);
            ValidationDialog validationDialog = new ValidationDialog(validation);
            validationDialog.setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Presenter();
    }
}
