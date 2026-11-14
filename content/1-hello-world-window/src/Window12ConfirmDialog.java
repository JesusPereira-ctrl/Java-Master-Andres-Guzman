import javax.swing.*;
import java.awt.*;

public class Window12ConfirmDialog extends JFrame {

    Container panel;

    public Window12ConfirmDialog() throws HeadlessException {
        super("Confirmar antes de ejecutar una tarea");

        panel = getContentPane();
        panel.setLayout(new FlowLayout());

        JPanel formPanel = new JPanel(new GridLayout(4, 2, 4, 4));

        JLabel nameLabel = new JLabel("Nombre: ", JLabel.RIGHT);
        JTextField nameField = new JTextField();
        formPanel.add(nameLabel);
        formPanel.add(nameField);

        JLabel lastNameLabel = new JLabel("Apellido: ", JLabel.RIGHT);
        JTextField lastNameField = new JTextField();
        formPanel.add(lastNameLabel);
        formPanel.add(lastNameField);

        JLabel taxNumberLabel = new JLabel("Rut: ", JLabel.RIGHT);
        JTextField taxNumberField = new JTextField();
        formPanel.add(taxNumberLabel);
        formPanel.add(taxNumberField);

        JRadioButton morning = new JRadioButton("Grupo mañana", true);
        formPanel.add(morning);

        JRadioButton afternoon = new JRadioButton("Grupo tarde", false);
        formPanel.add(afternoon);

        int option = JOptionPane.showConfirmDialog(
                this,
                formPanel,
                "Introduzca los datos",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE
        );
        System.out.println(option);

        if (option == JOptionPane.OK_OPTION) {
            System.out.println("hemos seleccionado Ok");

            String nameValue = nameField.getText();
            System.out.println(nameValue);

            JOptionPane.showMessageDialog(
                    this,
                    "Ejecutado con éxito!",
                    "Alerta", JOptionPane.INFORMATION_MESSAGE
            );
        } else if (option == JOptionPane.CANCEL_OPTION) {
            System.out.println("hemos seleccionado Cancelar");
            JOptionPane.showMessageDialog(
                    this,
                    "Ejecutado con error!",
                    "Alerta", JOptionPane.ERROR_MESSAGE
            );
        }

        System.exit(0);
    }

    static void main() {
        new Window12ConfirmDialog();
    }
}
