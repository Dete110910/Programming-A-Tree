package models;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private String value;
    private int height;
    private List<Node> nodeList;

    public Node(String value){
        this.value = value;
        this.nodeList = new ArrayList<>();
    }

    public Node(String value, int height){
        this.value = value;
        this.height = height;
        this.nodeList = new ArrayList<>();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<Node> getNodeList() {
        return nodeList;
    }

    public void setNodeList(Node node) {
        this.nodeList.add(node);
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void show (){
        System.out.println(getValue());
    }

    @Override
    public String toString() {
        return "Node{" +
                "value='" + value + '\'' +
                ", height=" + height + "}";

    }
}