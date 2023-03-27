package Test;

import models.Grammar;

import java.util.ArrayList;

public class TestGeneralTree {
    public static void main(String[] args) {
        ArrayList<String> noTerminal = new ArrayList<>();
        noTerminal.add("S");
        noTerminal.add("A");
        noTerminal.add("A");
        noTerminal.add("A");

        ArrayList<String> terminal = new ArrayList<>();
        terminal.add("aA");
        terminal.add("aA");
        terminal.add("bA");
        terminal.add("b");
        Grammar grammar = new Grammar(noTerminal,terminal, "S");

        ArrayList<String> tree = grammar.getTextGeneralTree();
        for (String a:tree) {
            System.out.println(a);
        }

      //  System.out.println(grammar.checkWordInGrammar("aaab"));
    }
}
