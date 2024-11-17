package RuletaApuestas;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import EntradaPrincipal.*;
import Usuarios.usuario;

public class Botones {
    public static JButton BotónParaIngresarApuestas(Font mainFont,usuario usuarioActual){
        Font nuevo=new Font("Garamond", Font.ITALIC,40);
        JButton IniciarRuleta=utilerías.CrearBotones("Seleccione un número para apostar y color", mainFont);
        IniciarRuleta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frameParaIngresarApuestas=utilerías.CrearFrameGenerico("Ingreso de apuesta", 800, 300);
                JPanel panelParaingresarApuestas=utilerías.CrearPanel(237, 144, 44);
                JLabel IngresoDeNumero=new JLabel("Ingrese su número:");
                IngresoDeNumero.setFont(nuevo);
                JLabel IngresoDeColor=new JLabel("Ingrese su color:");
                IngresoDeColor.setFont(nuevo);
                JLabel IngresoDeApuestas=new JLabel("Ingrese su apuesta:");
                IngresoDeApuestas.setFont(nuevo);
                JLabel exito=new JLabel();
                JTextField FieldNUMERO=new JTextField();
                JTextField FieldCOLOR=new JTextField();
                JTextField FieldApuesta=new JTextField();
                panelParaingresarApuestas.setLayout(new GridLayout(7,1));
                panelParaingresarApuestas.add(IngresoDeNumero);
                panelParaingresarApuestas.add(FieldNUMERO);
                panelParaingresarApuestas.add(IngresoDeColor);
                panelParaingresarApuestas.add(FieldCOLOR);
                panelParaingresarApuestas.add(IngresoDeApuestas);
                panelParaingresarApuestas.add(FieldApuesta);
                JButton IngresarApuesta=BotónParaIngresarValoresDeApuesta(FieldNUMERO,FieldCOLOR, FieldApuesta,mainFont,exito,frameParaIngresarApuestas,panelParaingresarApuestas,usuarioActual);
                panelParaingresarApuestas.add(IngresarApuesta);
                panelParaingresarApuestas.add(exito);
                frameParaIngresarApuestas.add(panelParaingresarApuestas);
                frameParaIngresarApuestas.setVisible(true);
            }
        });
        return IniciarRuleta;
    }
    public static JButton BotónParaIngresarValoresDeApuesta(JTextField FieldNUMERO,JTextField FieldCOLOR, JTextField FieldApuesta,Font mainFont,JLabel exito,JFrame frameParaIngresarApuestas, JPanel panelParaingresarApuestas,usuario usuarioActual){
        JButton IngresarApuesta=utilerías.CrearBotones("Enviar apuesta", mainFont);
                IngresarApuesta.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e){
                        if(RuletaApuestaGUI.comprobarApuestas(FieldNUMERO.getText(),FieldCOLOR.getText(),FieldApuesta.getText(),usuarioActual)==true){
                            exito.setText("Apuesta Ingresada");
                            Timer temporizadorDeDossegundos=new Timer(2000,new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e){
                                    panelParaingresarApuestas.setVisible(false);
                                    JPanel panelaux=utilerías.CrearPanel(201, 90, 181);
                                    frameParaIngresarApuestas.add(panelaux);
                                    JLabel SeleccionDeNumeros=new JLabel();
                                    panelaux.add(SeleccionDeNumeros);
                                    panelaux.setVisible(true);
                                }
                            } );
                            temporizadorDeDossegundos.setRepeats(false);
                            temporizadorDeDossegundos.start();

                        }else{
                            exito.setText("Apuesta inválida");
                            BotonesMenu.LimpiarCampos(FieldCOLOR, FieldApuesta, FieldNUMERO);
                        }
                    }
                });
                
        return IngresarApuesta;
    }
}
