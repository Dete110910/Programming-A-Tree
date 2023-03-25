package views.panels;

import models.Node;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class GeneralTreePaintedPanel extends JPanel {


    private int WIDTH = 400;
    private int HEIGHT = 700;

    private int spacingX = 100;
    private int multiPly;

    private ArrayList<Integer> n = new ArrayList<>();
    private Node root;

    public GeneralTreePaintedPanel(){
        this.setSize(WIDTH, HEIGHT);
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        n.add(1);
        n.add(3);
        n.add(9);
        n.add(12);
        n.add(24);
        n.add(30);

        this.setVisible(true);
    }
        public void setRoot(Node node){
        this.root = node;

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        int width = getWidth();
        int startX = width / 2;
        int startY = 50;
        int radius = 15;
        layoutTree(root, 0, startX, startY, -1, g2, radius);
    }

    private void layoutTree(Node node, int level, int x, int y, int parentX, Graphics2D g, int radio) {
        if (node == null) {
            return;
        }

        int numChildren = node.getNodeList().size();
        int halfWidth = numChildren * 25;

        // Distribuir los hijos horizontalmente
        int startX = x - halfWidth;
        int spacingX = 50;

        // Calcular la posición vertical
        int spacingY = 50;
        int verticalOffset = level + spacingY;
        int yPos = y + verticalOffset;

        // Colocar el nodo actual
        //g.drawOval(x - radio, yPos - radio, radio * 2, radio * 2);
        g.drawString(node.getValue(), x, yPos);

        // Dibujar las conexiones a los hijos
        if (parentX != -1) {
            g.drawLine(parentX, y - 45 + verticalOffset, x, yPos);
        }

        // Colocar los hijos recursivamente
        int childX = startX + spacingX / 2;
        int childY = y + spacingY;
        for (Node child : node.getNodeList()) {
            layoutTree(child, level + 1, childX, childY, x, g, radio);
            childX += spacingX;
        }
    }


}
