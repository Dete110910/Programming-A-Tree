package views.Dialogs;

import javax.swing.*;
import java.awt.*;

public class ValidationDialog extends JDialog{
    private JTextField txtWord;
    private JButton buttonAccept;
    private String palabra;

    public ValidationDialog(boolean isValid) {
        super();
        setTitle("Validación de Palabra");
        setModal(true);
        setSize(250, 100);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);


        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JLabel lblResult = new JLabel();
        lblResult.setHorizontalAlignment(JLabel.CENTER);
        Font font = new Font("Arial", Font.BOLD, 16);
        lblResult.setFont(font);

        if (isValid) {
            lblResult.setText("La palabra es válida");
        } else {
            lblResult.setText("La palabra no es válida");
        }

        panel.add(lblResult, BorderLayout.CENTER);
        if (isValid) {
            panel.setBackground(Color.decode("#80ED99"));
        } else {
            panel.setBackground(Color.decode("#CD5C5C"));
        }

        add(panel);
    }

    public String getPalabra() {
        return palabra;
    }
}
