package views.Dialogs;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WordDialog extends JDialog implements ActionListener {

    private JTextField txtWord;
    private JButton buttonAccept;
    private String palabra;

    public WordDialog() {
        super();
        setTitle("Solicitud de Palabra");
        setModal(true);
        setSize(300, 150);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JLabel lblWord = new JLabel("Ingrese una palabra:");
        txtWord = new JTextField();
        buttonAccept = new JButton("Aceptar");
        buttonAccept.setBackground(Color.decode("#22577A"));
        buttonAccept.setForeground(Color.WHITE);
        buttonAccept.addActionListener(this);

        panel.add(lblWord, BorderLayout.NORTH);
        panel.add(txtWord, BorderLayout.CENTER);
        panel.add(buttonAccept, BorderLayout.SOUTH);

        add(panel);
    }

    public String getPalabra() {
        return palabra;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonAccept) {
            palabra = txtWord.getText();
            dispose();
        }
    }
}

