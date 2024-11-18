package blackjack;

import javax.swing.*;
import java.awt.*;

public class FirstBet {

    public static double bet() {
        final JDialog dialog = new JDialog((Frame) null, "Apuesta", true);
        dialog.setSize(500, 500);
        dialog.setLayout(new BorderLayout());
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        JLabel messageLabel = new JLabel("Ingrese el dinero que desea apostar:");
        messageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        messageLabel.setFont(new Font("Arial", Font.BOLD, 20));

        JTextField betField = new JTextField();
        betField.setHorizontalAlignment(JTextField.CENTER);
        betField.setFont(new Font("Arial", Font.PLAIN, 18));

        JButton confirmButton = new JButton("Confirmar");
        confirmButton.setFont(new Font("Arial", Font.PLAIN, 18));

        JPanel centerPanel = new JPanel(new GridLayout(2, 1, 10, 10));
        centerPanel.add(messageLabel);
        centerPanel.add(betField);

        dialog.add(centerPanel, BorderLayout.CENTER);
        dialog.add(confirmButton, BorderLayout.SOUTH);

        // Center the dialog
        dialog.setLocationRelativeTo(null);

        final double[] betAmount = {0.0};

        confirmButton.addActionListener(e -> {
            try {
                betAmount[0] = Double.parseDouble(betField.getText());
                if (betAmount[0] <= 0) {
                    JOptionPane.showMessageDialog(dialog, "Apuesta inválida", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    dialog.dispose();
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(dialog, "Apuesta inválida", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        dialog.setVisible(true); // This will block until the dialog is closed
        return betAmount[0];
    }


    public static void notEnoughFunds(){
        JFrame Frame = new JFrame("Sin fondos");
        Frame.setSize(500, 500);
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Frame.setLayout(new BorderLayout());

        JLabel messageLabel = new JLabel("Su usuario no cuenta con los fondos suficientes");
        messageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        messageLabel.setFont(new Font("Arial", Font.BOLD, 20));

        Frame.setLocationRelativeTo(null);
        Frame.setVisible(true);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Probablemente forzó el programa a terminar, si no, quién sabe que se rompió");
        }

        Frame.dispose();
    }
}
