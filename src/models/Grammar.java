package models;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;

public class Grammar {

    private ArrayList<String> noTerminalSymbols;
    private ArrayList<String> terminalSymbols;

    private ArrayList<String> leftList;
    private ArrayList<String> rightList;
    private String axiomaticSymbol;

    public Grammar() {
        this.leftList = new ArrayList<String>();
        this.rightList = new ArrayList<String>();
        this.terminalSymbols = new ArrayList<String>();
        this.noTerminalSymbols = new ArrayList<String>();
        this.axiomaticSymbol = "";

    }

    public Grammar(ArrayList<String> leftList, ArrayList<String> rightList, String axiomaticSymbol) {
        this.leftList = leftList;
        this.rightList = rightList;
        this.axiomaticSymbol = axiomaticSymbol;
    }

    public Grammar(ArrayList<String> leftList, ArrayList<String> rightList, ArrayList<String> noTerminalSymbols, ArrayList<String> terminalSymbols, String axiomaticSymbol) {
        this.leftList = leftList;
        this.rightList = rightList;
        this.axiomaticSymbol = axiomaticSymbol;
    }


    public String generateHorizontalDerivationWord(String word) {
        ArrayList<String> horizontalDerivation = this.generateHorizontalDerivationWord(word, word, axiomaticSymbol);
        String answer = "";
        for (String text : horizontalDerivation) {
            answer = text + ">" + answer;
        }
        return answer;
    }

    public ArrayList<String> generateHorizontalDerivationWord(String originalWord, String create, String created) {
        ArrayList<String> horizontalDerivation = new ArrayList<>();
        if (!create.equals("")) {
            ArrayList<Integer> positionProductions = getPositionProductions(getFirstNotTerminal(created), create.charAt(0) + "");
            for (Integer position : positionProductions) {
                ArrayList<String> auxHorizontalDerivation = generateHorizontalDerivationWord(originalWord, this.deleteFirstSymbol(create), this.replaceNotTerminalSymbol(created, position));
                if ((auxHorizontalDerivation.size() != 0 && auxHorizontalDerivation.get(0).equals(originalWord)) || auxHorizontalDerivation.size() > horizontalDerivation.size())
                    horizontalDerivation = auxHorizontalDerivation;
            }
        }
        horizontalDerivation.add(created);
        return horizontalDerivation;

    }

    private ArrayList<Integer> getPositionProductions(String noTerminal, String terminal) {
        ArrayList<Integer> positionsProducts = new ArrayList<Integer>();
        for (int i = 0; i < leftList.size(); i++) {
            if (leftList.get(i).equals(noTerminal) && rightList.get(i).startsWith(terminal)) {
                positionsProducts.add(i);
            }
        }
        return positionsProducts;
    }

    private String getFirstNotTerminal(String text) {
        for (int i = 0; i < text.length(); i++) {
            if (isNotTerminal(text.charAt(i) + ""))
                return text.charAt(i) + "";
        }
        return "";
    }

    private boolean isNotTerminal(String text) {
        for (String noTerminal : leftList)
            if (noTerminal.equals(text))
                return true;
        return false;
    }

    private String deleteFirstSymbol(String text) {
        if (text.length() == 1)
            return "";
        else
            return text.substring(1);
    }

    private String replaceNotTerminalSymbol(String text, int production) {
        boolean replaced = false;
        String newText = "";
        for (int i = 0; i < text.length(); i++) {
            if (isNotTerminal(text.charAt(i) + "") && !replaced) {
                newText += rightList.get(production);
                replaced = true;
            } else
                newText += text.charAt(i) + "";
        }
        return newText;
    }

    public Object[][] parseArrayListToMatrixObject(){
        int sizeList = this.leftList.size();
        Object[][] processList = new Object[sizeList][3];

        for(int i = 0; i < sizeList; i++){
            processList[i][0] = this.leftList.get(i);
            processList[i][1] = "-->";
            processList[i][2] = this.rightList.get(i);
        }

        return processList;
    }

    public boolean checkWordInGrammar(String word){
        if(this.generateHorizontalDerivationWord(word,word,axiomaticSymbol).get(0).equals(word)){
            return true;
        }
        return false;
    }

    public ArrayList<String> getTextGeneralTree() {
        ArrayList<String> tree = new ArrayList<>();
        tree.add("");
        tree.add("");
        tree.add("");
        tree.add("");
        tree.add("");
        tree.add("");
        this.getTextGeneralTree(0, axiomaticSymbol, tree);
        tree.set(0,this.addSpaces(axiomaticSymbol,tree.get(1).length()));
        return tree;
    }

    private int getTextGeneralTree(int positionArray, String txt, ArrayList<String> tree) {
        String row = "";
        String firstNotTerminal = getFirstNotTerminal(txt);
        ArrayList<Integer> positionProductions = this.getPositionProductions(firstNotTerminal);
        if (firstNotTerminal.equals("")) {
            row = this.generateStringSpaces(txt.length())
            ;
        } else if (positionArray == 4) {
                for (Integer pos : positionProductions) {
                    row += replaceNotTerminalSymbol(txt, pos)+ " ";
                }

        } else{
            for (Integer pos : positionProductions) {
                String newTxt = replaceNotTerminalSymbol(txt, pos);
                int lengthInferior = getTextGeneralTree((positionArray+1),newTxt,tree);
                row += this.addSpaces(newTxt,lengthInferior);
            }
        }
        tree.set(positionArray+1, tree.get(positionArray+1) +row);
        return row.length();
    }

    private String addSpaces(String newTxt, int length) {
        int side = 0;
        while (newTxt.length() != length){
            if (side==0){
                newTxt += " ";
                side = 1;
            }else{
                newTxt = " " + newTxt;
                side = 0;
            }
        }
        return  newTxt;
    }

    private String generateStringSpaces(int length) {
        String txt = "";
        while (length != 0) {
            txt += " ";
            length--;
        }
        return txt;
    }

    private ArrayList<Integer> getPositionProductions(String noTerminal) {
        ArrayList<Integer> positionsProducts = new ArrayList<Integer>();
        for (int i = 0; i < leftList.size(); i++) {
            if (leftList.get(i).equals(noTerminal)) {
                positionsProducts.add(i);
            }
        }
        return positionsProducts;
    }


    public ArrayList<String> getLeftList() {
        return leftList;
    }


    public void setLeftList(ArrayList<String> leftList) {
        this.leftList = leftList;

    }

    public ArrayList<String> getRightList() {
        return rightList;
    }

    public void setRightList(ArrayList<String> rightList) {
        this.rightList = rightList;
    }

    public String getAxiomaticSymbol() {
        return "{ " + axiomaticSymbol + " }";
    }

    public void setAxiomaticSymbol(String axiomaticSymbol) {
        this.axiomaticSymbol = axiomaticSymbol;
    }

    public ArrayList<String> getNoTerminalSymbolsList() {
        return this.noTerminalSymbols;
    }

    public void setNoTerminalSymbolsList(ArrayList<String> noTerminalSymbols) {
        this.noTerminalSymbols = noTerminalSymbols;
    }

    public ArrayList<String> getTerminalSymbolsList() {
        return terminalSymbols;
    }

    public void setTerminalSymbolsList(ArrayList<String> terminalSymbols) {
        this.terminalSymbols = terminalSymbols;
    }



    @Override
    public String toString() {
        return "Grammar{" +
                "noTerminalSymbols=" + noTerminalSymbols +
                ", terminalSymbols=" + terminalSymbols +
                ", leftList=" + leftList +
                ", rightList=" + rightList +
                ", axiomaticSymbol='" + axiomaticSymbol + '\'' +
                '}';
    }
}