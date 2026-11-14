import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window07CurrencyConvertor extends JFrame implements ActionListener {

    Container panel;

    JButton buttonEu;
    JButton buttonUsd;
    JButton buttonReset;

    JTextField mount;

    public static final String CURRENCY_DOLAR = "Dólar";
    public static final String CURRENCY_EUROS = "Euros";

    public Window07CurrencyConvertor() throws HeadlessException {
        super("Conversor de Monedas");

        panel = getContentPane();

        panel.setLayout(new FlowLayout());

        mount = new JTextField(10);

        buttonReset = new JButton("Reset");
        buttonReset.addActionListener(this);

        buttonEu = new JButton(CURRENCY_EUROS);
        buttonEu.addActionListener(this);

        buttonUsd = new JButton(CURRENCY_DOLAR);
        buttonUsd.addActionListener(this);

        panel.add(mount);
        panel.add(buttonEu);
        panel.add(buttonUsd);
        panel.add(buttonReset);

        setSize(500, 250);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        float value = Float.parseFloat(mount.getText());
        String textCurrency = e.getActionCommand();

        if (textCurrency.equals(CURRENCY_EUROS)) {
            value = value / 1029.19F;
            panel.setBackground(Color.GREEN);
        } else if (textCurrency.equals(CURRENCY_DOLAR)) {
            value = value / 976.38F;
            panel.setBackground(Color.BLUE);
        } else {
            value = 0.00F;
        }

        mount.setText(String.valueOf(value));
    }

    public static void main(String[] args) {
        new Window07CurrencyConvertor();
    }
}
