package Test;

import models.Grammar;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class TestHorizontalDerivation {
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

        System.out.println(grammar.generateHorizontalDerivationWord("abbb"));

    }
}
