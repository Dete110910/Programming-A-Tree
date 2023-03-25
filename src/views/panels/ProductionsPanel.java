package views.panels;

import views.ConstantsGUI;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ProductionsPanel extends JPanel {

    private final String[] HEADERS = {"Lado Izq.", " -> ", "Lado Der."};
    private int WIDTH = 400;
    private int HEIGHT = 700;
    private DefaultTableModel defaultTableModel;
    private JTable jTable;

    public ProductionsPanel(){
        this.setSize(WIDTH, HEIGHT);
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.initComponents();
        this.setVisible(true);
    }

    private void initComponents(){
        this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        this.setBackground(Color.decode("#C7F9CC"));
        defaultTableModel = new DefaultTableModel();
        defaultTableModel.setColumnIdentifiers(HEADERS);
        defaultTableModel.setRowCount(5);

        jTable = new JTable();
        jTable.setModel(this.defaultTableModel);
        jTable.getTableHeader().setReorderingAllowed(false);
        jTable.getTableHeader().setBackground(Color.decode("#22577A"));
        jTable.getTableHeader().setForeground(Color.WHITE);
        jTable.getTableHeader().setFont(ConstantsGUI.FONT_TABLE_HEADER);
        jTable.setFillsViewportHeight(true);
        jTable.setFont(ConstantsGUI.FONT_TABLE_BODY);
        jTable.setBackground(Color.decode("#C7F9CC"));
        jTable.setOpaque(true);
        jTable.setRowHeight(45);

        JScrollPane jScrollPane = new JScrollPane(jTable);
        jScrollPane.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.decode("#22577A")),
                "Producciones", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION, ConstantsGUI.FONT_TABLE_HEADER, Color.decode("#22577A")));
        jScrollPane.setAlignmentX(Component.LEFT_ALIGNMENT);

        this.add(jScrollPane, BorderLayout.PAGE_END);
        this.setBorder(null);
    }

    public void setDefaultTableModel(DefaultTableModel defaultTableModel){
        this.defaultTableModel = defaultTableModel;
        this.jTable.setModel(defaultTableModel);

    }

}
