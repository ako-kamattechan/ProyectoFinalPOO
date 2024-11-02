package Ruleta;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class PruebaGUI extends JFrame {
    final private Font mainFont=new Font("Segoe print", Font.BOLD,18);
    JTextField tfFirstName,tfLastName;
    JLabel lbWelcome;
    public void InicioDePrueba(){
        JLabel lbFirstName=new JLabel("First Name");
        lbFirstName.setFont(mainFont);

        tfFirstName=new JTextField();
        tfFirstName.setFont(mainFont);

        JLabel lbLastName=new JLabel("Last Name");
        lbLastName.setFont(mainFont);

        tfLastName=new JTextField();
        tfLastName.setFont(mainFont);

        JPanel formPanel=new JPanel();
        formPanel.setLayout(new GridLayout(4,1,5,5));
        formPanel.setOpaque(false);
        formPanel.add(lbFirstName);
        formPanel.add(tfFirstName);
        formPanel.add(lbLastName);
        formPanel.add(tfLastName);

        lbWelcome=new JLabel();
        lbWelcome.setFont(mainFont);

        JButton btnOK=new JButton("ok");
        btnOK.setFont(mainFont);
        btnOK.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                //throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
                String firtName=tfFirstName.getText();
                String lastName=tfLastName.getText();
                lbWelcome.setText("Hello "+firtName+" "+ lastName);
            }
            
        });
        JButton btnClear=new JButton("Clear");
        btnClear.setFont(mainFont);
        btnClear.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                //throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
                tfFirstName.setText("");
                tfLastName.setText("");
                lbWelcome.setText("");
            }
            
        });
        JPanel buttonsPanel=new JPanel();
        buttonsPanel.setLayout(new GridLayout(1,2,5,5));
        buttonsPanel.setOpaque(false);
        buttonsPanel.add(btnOK);
        buttonsPanel.add(btnClear);

        JPanel mainPanel=new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(new Color(128,128,255));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mainPanel.add(formPanel, BorderLayout.NORTH);
        mainPanel.add(lbWelcome,BorderLayout.CENTER);
        mainPanel.add(buttonsPanel,BorderLayout.SOUTH);

        add(mainPanel);
        setTitle("Esta es una prueba");
        setSize(500,600);
        setMinimumSize(new Dimension(300,400));
        setVisible(true);
    }
}
