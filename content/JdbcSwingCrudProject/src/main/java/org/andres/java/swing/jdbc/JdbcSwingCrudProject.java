package org.andres.java.swing.jdbc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JdbcSwingCrudProject extends JFrame {

    private final Container p;

    private final JTextField nameField = new JTextField();
    private final JTextField priceField = new JTextField();
    private final JTextField quantityField = new JTextField();

    public JdbcSwingCrudProject() throws HeadlessException {
        super("Swing: GUI con Base de Datos MySQL!");

        p = getContentPane();
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

            Object[] product = new Object[]{name, price, quantity};
            System.out.println(product[0]);
            System.out.println(product[1]);
            System.out.println(product[2]);
        }
    }
}
