import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;

public class Window13TableModel extends JFrame {

    public Window13TableModel() throws HeadlessException {
        super("Tabla con Registros o Grilla");

        JTable table = new JTable(new UserTableModel());

        JScrollPane scroll = new JScrollPane(table);

        JPanel panel = new JPanel();
        panel.add(scroll);

        getContentPane().add(panel);
        setVisible(true);
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    static void main() {
        new Window13TableModel();
    }

    private static class UserTableModel extends AbstractTableModel {

        private final String[] columns = {"Id", "Name", "Lastname", "Email"};
        private final Object[][] rows;

        public UserTableModel() {
            this.rows = new Object[5][4];

            rows[0] = new Object[]{1, "Andres", "Guzman", "andres@correo.com"};
            rows[1] = new Object[]{2, "Pepe", "Doe", "pepe@correo.com"};
            rows[2] = new Object[]{3, "Ana", "Roe", "ana@correo.com"};
            rows[3] = new Object[]{4, "James", "Gosling", "james@correo.com"};
            rows[4] = new Object[]{5, "Bruce", "Gao", "bruce@correo.com"};
        }

        @Override
        public int getRowCount() {
            return rows.length;
        }

        @Override
        public int getColumnCount() {
            return columns.length;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            return rows[rowIndex][columnIndex];
        }

        @Override
        public String getColumnName(int column) {
            return columns[column];
        }
    }
}
