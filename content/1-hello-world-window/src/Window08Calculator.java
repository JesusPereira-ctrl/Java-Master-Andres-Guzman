import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window08Calculator extends JFrame implements ActionListener {

    Container container;

    JTextField numberA;
    JTextField numberB;
    JTextField result;

    public static final String CALCULATOR_ADD = "Sumar";
    public static final String CALCULATOR_SUBSTRACTION = "Restar";
    public static final String CALCULATOR_DIVISION = "Dividir";
    public static final String CALCULATOR_MULTIPLICATION = "Multiplicar";
    public static final String CALCULATOR_CLOSE = "Salir";

    public Window08Calculator() throws HeadlessException {
        super("Calculadora");

        container = getContentPane();
        container.setLayout(new BorderLayout());

        JMenuBar bar = new JMenuBar();
        setJMenuBar(bar);

        JMenu menu = new JMenu("Operaciones");
        JMenuItem itemAdd = new JMenuItem(CALCULATOR_ADD);
        JMenuItem itemSubst = new JMenuItem(CALCULATOR_SUBSTRACTION);
        JMenuItem itemDiv = new JMenuItem(CALCULATOR_DIVISION);
        JMenuItem itemMulti = new JMenuItem(CALCULATOR_MULTIPLICATION);

        menu.add(itemAdd);
        menu.add(itemSubst);
        menu.add(itemDiv);
        menu.add(itemMulti);

        JMenu closeMenu = new JMenu("Cerrar");
        JMenuItem itemClose = new JMenuItem(CALCULATOR_CLOSE);
        closeMenu.add(itemClose);

        bar.add(menu);
        bar.add(closeMenu);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        panel.add(new JLabel("Numero 1"));
        panel.add(numberA = new JTextField(3));

        panel.add(new JLabel("Numero 2"));
        panel.add(numberB = new JTextField(3));

        panel.add(new JLabel("Resultado"));
        panel.add(result = new JTextField(5));

        result.setEditable(false);

        container.add(panel, BorderLayout.CENTER);

        itemAdd.addActionListener(this);
        itemSubst.addActionListener(this);
        itemDiv.addActionListener(this);
        itemMulti.addActionListener(this);
        itemClose.addActionListener(this);

        setVisible(true);
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    static void main() {
        new Window08Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String operation = e.getActionCommand();
        int a = Integer.parseInt(numberA.getText().trim());
        int b = Integer.parseInt(numberB.getText().trim());
        int value = 0;

        switch (operation) {
            case CALCULATOR_ADD:
                value = a + b;
                break;
            case CALCULATOR_SUBSTRACTION:
                value = a - b;
                break;
            case CALCULATOR_DIVISION:
                if (b == 0) {
                    JOptionPane.showMessageDialog(
                            null,
                            "No se puede dividir en cero, infinito!",
                            "Error de entrada",
                            JOptionPane.ERROR_MESSAGE
                    );
                    break;
                }
                value = a / b;
                break;
            case CALCULATOR_MULTIPLICATION:
                value = a * b;
                break;
            case CALCULATOR_CLOSE:
                System.exit(0);
                break;
        }
        result.setText(String.valueOf(value));
    }
}
