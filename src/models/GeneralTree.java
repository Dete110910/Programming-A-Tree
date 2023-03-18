package models;

import java.util.ArrayList;
import java.util.List;

public class GeneralTree {

    public Node rootNode;
    private int height = 0;

    private String axiomaticSymbol;
    private List<String> noTerminalSymbolsList;
    private List<String> terminalSymbolsList;

    public GeneralTree(String axiomaticSymbol, String[] terminalSymbolsList, String[] nonTerminalSymbolsList){
        this.noTerminalSymbolsList = new ArrayList<>();
        this.terminalSymbolsList = new ArrayList<>();
        this.addNoTerminalSymbolsList(terminalSymbolsList);
        this.addTerminalSymbolsList(nonTerminalSymbolsList);
        this.axiomaticSymbol = axiomaticSymbol;
    }

    public GeneralTree(ArrayList<String> terminalSymbolsProductionList, ArrayList<String> nonTerminalSymbolProductionList, Node initialNode){
        this.terminalSymbolsList = terminalSymbolsProductionList;
        this.noTerminalSymbolsList = nonTerminalSymbolProductionList;
        this.rootNode = initialNode;
        this.axiomaticSymbol = rootNode.getValue();
    }

    public void addNoTerminalSymbolsList(String[] finalSymbol){
        for (int i = 0; i < finalSymbol.length; i++) {
            noTerminalSymbolsList.add(finalSymbol[i]);
        }
    }
    public void addTerminalSymbolsList(String[] productionSymbol){
        for (int i = 0; i < productionSymbol.length; i++) {
            terminalSymbolsList.add(productionSymbol[i]);
        }
    }

    public void addNewNode(){
        for(int i = 0; i < noTerminalSymbolsList.size(); i++){
            if(rootNode.getValue().contains(noTerminalSymbolsList.get(i))){
                rootNode.setNodeList(new Node(terminalSymbolsList.get(i), 1));
                this.addNewNode(rootNode.getNodeList().get(rootNode.getNodeList().size() - 1));
            }
        }
    }
    private void addNewNode(Node rootNode){
        if(rootNode.getHeight() >= 5){
            return;
        }
        for(int i = 0; i < noTerminalSymbolsList.size(); i++){
            if(rootNode.getValue().contains(noTerminalSymbolsList.get(i))){
                String value = rootNode.getValue();
                String newValue = value.replace(noTerminalSymbolsList.get(i), terminalSymbolsList.get(i));
                rootNode.setNodeList(new Node(newValue, rootNode.getHeight() + 1));
                this.addNewNode(rootNode.getNodeList().get(rootNode.getNodeList().size() - 1));
            }
        }
    }

    public int validateSymbolNode(Node node) {
        int num =-1;
        for (int i = 0; i < node.getNodeList().size(); i++) {
            if (node.getNodeList().get(i).getValue().contains(axiomaticSymbol)) {
                //System.out.println(node.getNodeList().get(i).getValue());
                num = i;
            }
        }
        return num;
    }

    public void showNodeList(Node node){
        for (int i = 0; i < node.getNodeList().size(); i++) {
            System.out.println(node.getNodeList().get(i).getValue());
        }
    }


}