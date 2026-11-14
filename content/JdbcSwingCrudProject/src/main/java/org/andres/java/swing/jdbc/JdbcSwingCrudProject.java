package org.andres.java.swing.jdbc;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class JdbcSwingCrudProject extends JFrame {

    private final JTextField nameField = new JTextField();
    private final JTextField priceField = new JTextField();
    private final JTextField quantityField = new JTextField();

    private final ProductTableModel tableModel = new ProductTableModel();

    public JdbcSwingCrudProject() throws HeadlessException {
        super("Swing: GUI con Base de Datos MySQL!");

        Container p = getContentPane();
        p.setLayout(new BorderLayout(20, 10));

        JPanel formPanel = new JPanel(new GridLayout(4, 2, 20, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        JButton buttonSave = new JButton("Guardar");

        formPanel.add(new JLabel("Nombre: "));
        formPanel.add(nameField);

        formPanel.add(new JLabel("Precio: "));
        formPanel.add(priceField);

        formPanel.add(new JLabel("Cantidad: "));
        formPanel.add(quantityField);

        formPanel.add(new JLabel(""));
        formPanel.add(buttonSave);
        buttonSave.addActionListener(new AddActionListener());

        JPanel tablePanel = new JPanel(new FlowLayout());

        JTable jTable = new JTable();
        jTable.setModel(tableModel);

        JScrollPane scroll = new JScrollPane(jTable);
        tablePanel.add(scroll);

        p.add(tablePanel, BorderLayout.EAST);
        p.add(formPanel, BorderLayout.WEST);

        pack();
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    static void main() {
        new JdbcSwingCrudProject();
    }

    private class AddActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String name = nameField.getText();
            int price = Integer.parseInt(priceField.getText());
            int quantity = Integer.parseInt(quantityField.getText());

            Object[] product = new Object[]{System.currentTimeMillis(), name, price, quantity};
            tableModel.getRows().add(product);
            tableModel.fireTableDataChanged();

            nameField.setText("");
            priceField.setText("");
            quantityField.setText("");
        }
    }

    private static class ProductTableModel extends AbstractTableModel {

        private final String[] columns = new String[]{"Id", "Nombre", "Precio", "Cantidad"};
        private final List<Object[]> rows = new ArrayList<>();

        public List<Object[]> getRows() {
            return rows;
        }

        @Override
        public int getRowCount() {
            return this.rows.size();
        }

        @Override
        public int getColumnCount() {
            return this.columns.length;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            return this.rows.get(rowIndex)[columnIndex];
        }

        @Override
        public String getColumnName(int column) {
            return this.columns[column];
        }
    }
}
