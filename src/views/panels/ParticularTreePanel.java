package views.panels;

import javax.swing.*;
import java.awt.*;

public class ParticularTreePanel extends JPanel{

    private WordPanel wordPanel;
    private HorizontalByPassTree horizontalByPassTree;


    public ParticularTreePanel(){
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.initComponents();
        this.setVisible(true);
    }

    private void initComponents() {
        this.wordPanel = new WordPanel();
        this.horizontalByPassTree = new HorizontalByPassTree();

        this.add(wordPanel, BorderLayout.PAGE_START);
        this.add(horizontalByPassTree, BorderLayout.PAGE_END);
    }

    public void setWord (String word){
        wordPanel.setTxtWord(word);
    }

    public void setHorizontalByPassTree (String horizontalTree) {
        horizontalByPassTree.setHorizontalBypassTree(horizontalTree);
    }
}
