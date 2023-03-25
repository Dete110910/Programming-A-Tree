package models;

import java.util.ArrayList;

public class Grammar {

    private ArrayList<String> noTerminalSymbols;
    private ArrayList<String> terminalSymbols;

    private ArrayList<String> leftList;
    private ArrayList<String> rightList;
    private String axiomaticSymbol;

    public Grammar(String[] noTerminalSymbols, String[] terminalSymbols, String axiomaticSymbol){
        this.noTerminalSymbols =new ArrayList<>();
        this.terminalSymbols = new ArrayList<>();
        this.setNoTerminalSymbolsList(noTerminalSymbols);
        this.setTerminalSymbolsList(terminalSymbols);
        this.axiomaticSymbol = axiomaticSymbol;
    }
    public Grammar(ArrayList<String> leftList, ArrayList<String> rightList, ArrayList<String> noTerminalSymbols, ArrayList<String> terminalSymbols, String axiomaticSymbol) {
        this.leftList = leftList;
        this.rightList = rightList;
        this.axiomaticSymbol = axiomaticSymbol;
    }


    public String generateHorizontalDerivationWord(String word){
        ArrayList<String> horizontalDerivation = this.generateHorizontalDerivationWord(word,word,axiomaticSymbol);
        String answer = "";
        for (String text:horizontalDerivation) {
            answer = text +">" +answer;
        }
        return answer;
    }
    public ArrayList<String> generateHorizontalDerivationWord(String originalWord, String create, String created){
        ArrayList<String> horizontalDerivation = new ArrayList<>();
        if(!create.equals("")) {
            ArrayList<Integer> positionProductions = getPositionProductions(getFirstNotTerminal(created),create.charAt(0)+"");
            for (Integer position: positionProductions) {
                ArrayList<String> auxHorizontalDerivation = generateHorizontalDerivationWord(originalWord,this.eliminateFirstSymbol(create), this.replaceNotTerminalSymbol(created, position));
                if ((auxHorizontalDerivation.size() !=0 &&auxHorizontalDerivation.get(0).equals(originalWord))|| auxHorizontalDerivation.size()> horizontalDerivation.size())
                    horizontalDerivation =   auxHorizontalDerivation;
            }
        }
        horizontalDerivation.add(created);
        return horizontalDerivation;

    }
    private ArrayList<Integer> getPositionProductions(String noTerminal, String terminal){
        ArrayList<Integer> positionsProducts = new ArrayList<Integer>();
        for (int i = 0; i < leftList.size(); i++) {
            if(leftList.get(i).equals(noTerminal) && rightList.get(i).startsWith(terminal)){
                positionsProducts.add(i);
            }
        }
        return positionsProducts;
    }
    private String getFirstNotTerminal(String text) {
        for (int i = 0; i < text.length(); i++) {
            if (isNotTerminal(text.charAt(i) +""))
                return text.charAt(i) +"";
        }
        return null;
    }

    private boolean isNotTerminal(String text){
        for (String noTerminal: leftList)
            if (noTerminal.equals(text))
                return  true;
        return  false;
    }
    private String eliminateFirstSymbol(String text){
        if(text.length() == 1)
            return "";
        else
            return text.substring(1);
    }
    private String replaceNotTerminalSymbol(String text, int production){
        boolean replaced = false;
        String newText = "";
        for (int i = 0; i < text.length(); i++) {
            if(isNotTerminal(text.charAt(i)+"") && !replaced) {
                newText += rightList.get(production);
                replaced = true;
            }
            else
                newText += text.charAt(i)+"";
        }
        return  newText;
    }

    public boolean checkWordInGrammar(String word){
        if(this.generateHorizontalDerivationWord(word,word,axiomaticSymbol).get(0).equals(word)){
            return true;
        }
        return false;
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
        return "{ "+axiomaticSymbol+" }";
    }
    public void setAxiomaticSymbol(String axiomaticSymbol) {
        this.axiomaticSymbol = axiomaticSymbol;
    }

    public ArrayList<String> getNoTerminalSymbolsList() {
        return this.noTerminalSymbols;
    }

    public void setNoTerminalSymbolsList(String[] noTerminalSymbols) {
        for (int i = 0; i < noTerminalSymbols.length; i++) {
            this.noTerminalSymbols.add(noTerminalSymbols[i]);
        }
    }

    public ArrayList<String> getTerminalSymbolsList() {
        return terminalSymbols;
    }

    public void setTerminalSymbolsList(String[] terminalSymbols) {
        for (int i = 0; i < terminalSymbols.length; i++) {
            this.terminalSymbols.add(terminalSymbols[i]);
        }
    }
}