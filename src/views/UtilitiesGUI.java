package views;

import javax.swing.*;
import java.awt.*;

public class UtilitiesGUI {

    public static void addComponent(Container container, JComponent component, int xPositionLayout, int yPositionLayout,int up, int left, int down, int right){
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.insets =(new Insets(up, left, down, right));
        gridBagConstraints.gridx = xPositionLayout;
        gridBagConstraints.gridy = yPositionLayout;
        container.add(component, gridBagConstraints);
    }


}
