package views;

import javax.swing.*;

public class UtilitiesMessages {

    public static void showErrorDialog(String message, String title){
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.ERROR_MESSAGE);
    }
}
