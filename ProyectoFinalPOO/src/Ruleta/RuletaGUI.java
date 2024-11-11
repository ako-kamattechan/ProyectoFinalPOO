package Ruleta;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.List;
import java.util.Random;
import Usuarios.*;
import EntradaPrincipal.*;
public class RuletaGUI {
    public static void PuntoDeAccesoRuleta(usuario usuarioActual, MenuDelCasinoGUI menu,List<usuario> listaDeusuarios){
        Font mainFont=new Font("Garamond", Font.ITALIC,50);
        Font FontPremio=new Font("Garamond", Font.ITALIC,75);


        JFrame frameRuleta=utilerías.CrearFrameGenerico("Ruleta", 1000, 300);
        JPanel PantallaRuleta=utilerías.CrearPanel(136, 0, 21);
        JButton IniciarRuleta=utilerías.CrearBotones("Gira la ruleta!", mainFont);
        JLabel ImagenRuleta=utilerías.AgregarImagen(300, 300, 600, 100, "ProyectoFinalPOO/src/tipografias/Ruleta.gif");
        Double[] premios={100d,200d,300d,400d,500d,600d,700d,800d,900d,1000d};
        int[] premio={Aleatorio(10)};
        JLabel MensajeDePremio=new JLabel("¡FELICIDADES! Ganaste "+premios[premio[0]]+" pesos :D");
        MensajeDePremio.setFont(FontPremio);
        IniciarRuleta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameRuleta.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
                frameRuleta.dispose();
                JFrame RuletaGirando=utilerías.CrearFrameGenerico("Ruleta", 400, 500);
                JPanel panel=utilerías.CrearPanel(136, 0, 21);
                panel.add(ImagenRuleta,BorderLayout.CENTER);
                RuletaGirando.add(panel,BorderLayout.CENTER);
                RuletaGirando.setVisible(true);
                
                Timer temporizadorDeDossegundos=new Timer(3000,new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e){
                        RuletaGirando.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
                                RuletaGirando.dispose();
                        JFrame Mensaje=utilerías.CrearFrameGenerico("Mensaje de Premio", 1200, 500);
                        JPanel PanelMensaje=utilerías.CrearPanel(191, 165, 123);
                        PanelMensaje.add(MensajeDePremio);
                        Mensaje.add(PanelMensaje);
                        Mensaje.setVisible(true);
                        Timer temporizador=new Timer(3000,new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e){
                                Mensaje.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
                                Mensaje.dispose();
                                menu.EjecuciónConInicioDeSesión(usuarioActual, menu, listaDeusuarios);
                            }
                        } );
                        temporizador.setRepeats(false);
                        temporizador.start();
                    }
                } );
                temporizadorDeDossegundos.setRepeats(false);
                temporizadorDeDossegundos.start();

                usuarioActual.AgregarDinero(premios[premio[0]]);
                frameRuleta.add(MensajeDePremio,BorderLayout.WEST);
                utileriasParaAgregarObjetos.ArchivoConUsuarios(listaDeusuarios);
                
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
        frameRuleta.add(PantallaRuleta,BorderLayout.CENTER);
        frameRuleta.setVisible(true);
    }
        public static int Aleatorio(int maximo){
            Random random=new Random();
            int numero=random.nextInt(maximo);
            return numero;
        }
}
