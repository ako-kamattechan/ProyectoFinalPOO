package RuletaApuestas;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.List;
import EntradaPrincipal.*;

import Usuarios.usuario;

public class RuletaApuestaGUI {
    public static void RuletaApuestasGUI(usuario usuarioActual, MenuDelCasinoGUI menu,List<usuario> listaDeusuarios){
        Font mainFont=new Font("Garamond", Font.ITALIC,25);

        JFrame frameRuleta=utilerías.CrearFrameGenerico("Ruleta De Apuestas", 1000, 800);
        JPanel PantallaRuleta=utilerías.CrearPanel(58,77, 145); 
        JPanel PanelBotones=utilerías.CrearPanel(58,77 ,145);
        JLabel ImagenRuleta=utilerías.AgregarImagen(600, 600, 150, 100, "ProyectoFinalPOO/src/tipografias/Ruleta.gif");

        JButton IniciarRuleta=Botones.BotónParaIngresarApuestas(mainFont,usuarioActual);
        JButton Salida=utilerías.CrearBotones("Regresar al menú principal", mainFont);
        Salida.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            frameRuleta.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
            frameRuleta.dispose();
            menu.EjecuciónConInicioDeSesión(usuarioActual,menu,listaDeusuarios);
            }
        });
        PanelBotones.setLayout(new GridLayout(2,1));
        PanelBotones.add(IniciarRuleta,BorderLayout.NORTH);
        PanelBotones.add(Salida,BorderLayout.SOUTH);
        PantallaRuleta.add(ImagenRuleta,BorderLayout.CENTER);
        frameRuleta.add(PantallaRuleta,BorderLayout.CENTER);
        frameRuleta.add(PanelBotones, BorderLayout.WEST);
        frameRuleta.setVisible(true);
        
    }
    public static Boolean comprobarApuestas(String numero, String Color, String Dinero,usuario usuarioActual){
        Boolean Condicion=false;
        if((!numero.equals(null))&&(!Color.equals(null))&&(!Dinero.equals(null))){
            if(ComprobarSiUnacadenaEsUnNumero(numero)==true&&ComprobarSiUnacadenaEsUnNumero(Dinero)==true){  
                Integer NumeroDeApuesta=Integer.parseInt(numero);
                if(NumeroDeApuesta<=31&&NumeroDeApuesta>=0&&(Color.toLowerCase().equals("rojo")||Color.toLowerCase().equals("negro"))||(Color.toLowerCase().equals("verde")&&numero.equals("00"))){
                    Double DineroD=Double.parseDouble(Dinero);
                    if(DineroD<=usuarioActual.getDinero()){
                        Condicion=true;
                    }
                }else{
                    return false;
                }
            }
        }else{
            return false;
        }
        return Condicion;
    }
    public static boolean ComprobarSiUnacadenaEsUnNumero(String s){
        Boolean booleano=false;
        char[] ss=s.toCharArray();
        for(char caracter:ss){
            if(Character.isDigit(caracter)){
                booleano=true;
            }else{
                booleano=false;
                break;
            }
        }
        return booleano;
    }
}
