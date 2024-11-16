package RuletaApuestas;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;

import java.util.List;
import java.util.Random;
import Usuarios.*;
import EntradaPrincipal.*;
import java.util.List;

import Usuarios.usuario;

public class RuletaApuestaGUI {
    public static void RuletaApuestasGUI(usuario usuarioActual, MenuDelCasinoGUI menu,List<usuario> listaDeusuarios){
        Font mainFont=new Font("Garamond", Font.ITALIC,25);
        Font FontPremio=new Font("Garamond", Font.ITALIC,75);

        JFrame frameRuleta=utilerías.CrearFrameGenerico("Ruleta De Apuestas", 600, 800);
        JPanel PantallaRuleta=utilerías.CrearPanel(58,77, 145); 
        JLabel ImagenRuleta=utilerías.AgregarImagen(300, 300, 600, 100, "ProyectoFinalPOO/src/tipografias/RuletaDeApuestas.gif");

        JButton IniciarRuleta=utilerías.CrearBotones("Seleccione un número para apostar y color", mainFont);
        IniciarRuleta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameRuleta.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
                frameRuleta.dispose();
            }
        });
        JButton Salida=utilerías.CrearBotones("Regresar al menú principal", mainFont);
        Salida.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            frameRuleta.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
            frameRuleta.dispose();
            menu.EjecuciónConInicioDeSesión(usuarioActual,menu,listaDeusuarios);
            }
        });
        PantallaRuleta.add(Salida,BorderLayout.SOUTH);
        PantallaRuleta.add(IniciarRuleta,BorderLayout.NORTH);
        frameRuleta.add(ImagenRuleta,BorderLayout.CENTER);
        frameRuleta.add(PantallaRuleta);
        frameRuleta.setVisible(true);
        
    }
}
