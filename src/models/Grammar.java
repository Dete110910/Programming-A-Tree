package models;

import java.util.ArrayList;

public class Grammar {

    private ArrayList<String> noTerminalSymbols;
    private ArrayList<String> terminalSymbols;
    private String axiomaticSymbol;

    public Grammar(ArrayList<String> noTerminalSymbols, ArrayList<String> terminalSymbols, String axiomaticSymbol) {
        this.noTerminalSymbols = noTerminalSymbols;
        this.terminalSymbols = terminalSymbols;
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
        if(create != "") {
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
        for (int i = 0; i < noTerminalSymbols.size(); i++) {
            if(noTerminalSymbols.get(i).equals(noTerminal) && terminalSymbols.get(i).startsWith(terminal)){
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
        for (String noTerminal: noTerminalSymbols)
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
            if(isNotTerminal(text.charAt(i)+"") && !replaced)
                newText += terminalSymbols.get(production);
            else
                newText += text.charAt(i)+"";
        }
        return  newText;
    }

    public ArrayList<String> getNoTerminalSymbols() {
        return noTerminalSymbols;
    }


    public void setNoTerminalSymbols(ArrayList<String> noTerminalSymbols) {
        this.noTerminalSymbols = noTerminalSymbols;
    }

    public ArrayList<String> getTerminalSymbols() {
        return terminalSymbols;
    }

    public void setTerminalSymbols(ArrayList<String> terminalSymbols) {
        this.terminalSymbols = terminalSymbols;
    }

    public String getAxiomaticSymbol() {
        return axiomaticSymbol;
    }

    public void setAxiomaticSymbol(String axiomaticSymbol) {
        this.axiomaticSymbol = axiomaticSymbol;
    }


}