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
