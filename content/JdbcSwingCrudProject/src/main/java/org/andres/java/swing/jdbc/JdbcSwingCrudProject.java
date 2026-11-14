package org.andres.java.swing.jdbc;

import org.andres.java.swing.jdbc.repositories.ProductRepository;
import org.andres.java.swing.jdbc.repositories.ProductRepositoryImpl;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class JdbcSwingCrudProject extends JFrame {

    private final JTextField nameField = new JTextField();
    private final JTextField priceField = new JTextField();
    private final JTextField quantityField = new JTextField();
    private final ProductTableModel tableModel = new ProductTableModel();
    private final ProductRepository repository = new ProductRepositoryImpl();

    private long id;
    private int row;

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
        buttonSave.addActionListener(_ -> {
            String name = nameField.getText();
            int price = 0;
            int quantity = 0;

            try {
                price = Integer.parseInt(priceField.getText());
            } catch (NumberFormatException _) {
            }

            try {
                quantity = Integer.parseInt(quantityField.getText());
            } catch (NumberFormatException _) {
            }

            List<String> errors = new ArrayList<>();

            if (name.isBlank()) {
                errors.add("El nombre es requerido!");
            }

            if (price <= 0) {
                errors.add("El precio es requerido y debe debe ser mayor a 0!");
            }

            if (quantity <= 0) {
                errors.add("La cantidad es requerida y debe ser mayor a 0!");
            }

            if (!errors.isEmpty()) {
                JOptionPane.showMessageDialog(
                        null,
                        errors.toArray(),
                        "Error en la validación!",
                        JOptionPane.ERROR_MESSAGE
                );
            } else {
                if (id == 0) {
                    Object[] product = new Object[]{System.currentTimeMillis(), name, price, quantity, "Eliminar"};
                    tableModel.getRows().add(product);
                    tableModel.fireTableDataChanged();
                } else if (id > 0) {
                    tableModel.setValueAt(id, row, 0);
                    tableModel.setValueAt(name, row, 1);
                    tableModel.setValueAt(price, row, 2);
                    tableModel.setValueAt(quantity, row, 3);
                }

                reset();
            }
        });

        JPanel tablePanel = new JPanel(new FlowLayout());

        JTable jTable = new JTable();
        jTable.setModel(tableModel);
        jTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                row = jTable.rowAtPoint(e.getPoint());
                int column = jTable.columnAtPoint(e.getPoint());

                if (row > -1 && column == 4) {
                    int option = JOptionPane.showConfirmDialog(
                            null,
                            "Estas seguro que deseas eliminar el registro " + tableModel.getValueAt(row, 1).toString() + "?",
                            "Cuidado Eliminar Item",
                            JOptionPane.OK_CANCEL_OPTION,
                            JOptionPane.PLAIN_MESSAGE
                    );

                    if (option == JOptionPane.OK_OPTION) {
                        tableModel.getRows().remove(row);
                        tableModel.fireTableDataChanged();
                    }

                    reset();

                } else if (row > -1 && column > -1) {
                    id = (long) tableModel.getValueAt(row, 0);
                    nameField.setText(tableModel.getValueAt(row, 1).toString());
                    priceField.setText(tableModel.getValueAt(row, 2).toString());
                    quantityField.setText(tableModel.getValueAt(row, 3).toString());
                }
            }
        });

        JScrollPane scroll = new JScrollPane(jTable);
        tablePanel.add(scroll);

        p.add(tablePanel, BorderLayout.SOUTH);
        p.add(formPanel, BorderLayout.NORTH);

        pack();
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void reset() {
        id = 0;
        row = -1;
        nameField.setText("");
        priceField.setText("");
        quantityField.setText("");
    }

    static void main() {
        new JdbcSwingCrudProject();
    }

    private static class ProductTableModel extends AbstractTableModel {

        private final String[] columns = new String[]{"Id", "Nombre", "Precio", "Cantidad", "Delete"};
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
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            this.rows.get(rowIndex)[columnIndex] = aValue;
            fireTableCellUpdated(rowIndex, columnIndex);
        }

        @Override
        public String getColumnName(int column) {
            return this.columns[column];
        }
    }
}
