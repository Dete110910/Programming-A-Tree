package views;

import javax.swing.*;
import java.awt.*;

public class UtilitiesGUI {

    public static void addComponent(Container container, JComponent component, int xPositionLayout, int yPositionLayout){
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = xPositionLayout;
        gridBagConstraints.gridy = yPositionLayout;
        container.add(component);
    }

}
