package EntradaPrincipal;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;

import java.io.*;
public class MenuDelCasinoGUI{
    final private Font mainFont=new Font("Garamond", Font.ITALIC,50);
    final private Font FontChico=new Font("Garamond", Font.ITALIC,35);
    final private Font fontBotones=new Font("SansSerif", Font.ITALIC,35);
    public void FramePrincipal(JPanel mainPanel){
        JFrame frame=new JFrame("CasaPuesta.POO");
        frame.setSize(1420,560);
        frame.add(mainPanel);
        frame.setVisible(true);
    }
    public void EjecuciónMenuDeInicio(){
        JPanel mainPanel=utilerías.CrearPanel(231, 227, 210);
        JPanel PanelBienvenida=utilerías.CrearPanel(255, 255, 255);
        JPanel PanelPregunta=utilerías.CrearPanel(255, 251, 217,10,10,10,10);
        JPanel PanelJuegos=utilerías.CrearPanel(105, 163, 255);


        JLabel LBlogo=utilerías.AgregarImagen(300, 200, 30, 0, "ProyectoFinalPOO/src/tipografias/Logo3.jpg");
        JLabel Bienvenida=new JLabel("Bienvenido al casino CasaPuesta.POO");
        JLabel PreguntaCuenta=new JLabel("¿Ya tienes una cuenta en nuestro banco?");
        JLabel Pregunta2=new JLabel("Si desea jugar sin iniciar sesión, no se guardará su progreso.(dinero)");
        JLabel SeleccionDeJuegos=new JLabel("Seleccione un juego:");

        JButton BotonSi=utilerías.CrearBotones("si", fontBotones);
        BotonSi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        JButton BotonNo=utilerías.CrearBotones("No", fontBotones);
        BotonNo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        JButton BotonBlack=utilerías.CrearBotones("Black Jack", FontChico);
        BotonBlack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        JButton BotonRuleta=utilerías.CrearBotones("Girar la Ruleta", FontChico);
        BotonRuleta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        JButton BotonTragamonedas=utilerías.CrearBotones("Jugar a la tragaMonedas", FontChico);
        BotonTragamonedas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });

        Bienvenida.setFont(mainFont);
        PreguntaCuenta.setFont(FontChico);
        SeleccionDeJuegos.setFont(mainFont);

        PanelBienvenida.setSize(200,200);
        PanelPregunta.setSize(100,100);
        PanelJuegos.setSize(600, 200);;

        PanelBienvenida.add(LBlogo, BorderLayout.WEST);
        PanelBienvenida.add(Bienvenida,BorderLayout.EAST);

        PanelPregunta.add(PreguntaCuenta,BorderLayout.NORTH);
        PanelPregunta.add(Pregunta2);
        PanelPregunta.setLayout(new GridLayout(4, 1));
        PanelPregunta.add(BotonSi);
        PanelPregunta.add(BotonNo);

        PanelJuegos.add(SeleccionDeJuegos,BorderLayout.CENTER);
        PanelJuegos.setLayout(new GridLayout(4,1));
        PanelJuegos.add(BotonBlack);
        PanelJuegos.add(BotonRuleta);
        PanelJuegos.add(BotonTragamonedas);

        mainPanel.add(PanelBienvenida,BorderLayout.NORTH);
        mainPanel.add(PanelPregunta,BorderLayout.WEST);
        mainPanel.add(PanelJuegos, BorderLayout.CENTER);
        FramePrincipal(mainPanel);
    }
}
//IMLogo.setImageObserver(LBlogo);--idea para animación de ruleta
//JPanel panelImagen=utilerías.CrearPanel(231, 227, 210);
//panelImagen.setLayout(null);
//panelImagen.setSize(400,400);  
//panelImagen.add(LBlogo);
//mainPanel.add(panelImagen, BorderLayout.CENTER);
//JPanel PanelPregunta=utilerías.CrearPanel(231, 227, 210);
//PanelBienvenida.setSize(400,400);
//PanelBienvenida.add(PreguntaCuenta,BorderLayout.EAST);
//mainPanel.add(PanelPregunta, BorderLayout.NORTH);

