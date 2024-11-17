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
    public static void PuntoDeAccesoRuleta(usuario usuarioActual, MenuDelCasinoGUI menu,List<usuario> listaDeusuarios, JFrame FramePrincipal){
        Font mainFont=new Font("Garamond", Font.ITALIC,50);
        JFrame frameRuleta=utilerías.CrearFrameGenerico("Ruleta", 600, 300);
        JPanel PantallaRuleta=utilerías.CrearPanel(136, 0, 21);
        JButton IniciarRuleta=utilerías.CrearBotones("Gira la ruleta!", mainFont);
        JLabel ImagenRuleta=utilerías.AgregarImagen(1000, 800, 600, 100, "ProyectoFinalPOO/src/tipografias/RuletadeLasuerte.gif");
        Double[] premios={100d,200d,300d,400d,500d,600d,700d,800d,900d,1000d};
        int[] premio={Aleatorio(10)};
        JLabel MensajeDePremio=new JLabel("¡FELICIDADES! Ganaste "+premios[premio[0]]+" pesos :D");
        MensajeDePremio.setFont(mainFont);
        IniciarRuleta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame RuletaGirando=utilerías.CrearFrameGenerico("Ruleta", 1000, 800);
                JPanel panel=utilerías.CrearPanel(136, 0, 21);
                panel.add(ImagenRuleta,BorderLayout.CENTER);
                RuletaGirando.add(panel,BorderLayout.CENTER);
                RuletaGirando.setVisible(true);
                
                Timer temporizadorDeDossegundos=new Timer(3000,new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e){
                        frameRuleta.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
                        frameRuleta.dispose();
                        panel.setVisible(false);
                        JPanel PanelMensaje=utilerías.CrearPanel(191, 165, 123);
                        PanelMensaje.add(MensajeDePremio);
                        RuletaGirando.add(PanelMensaje);
                        RuletaGirando.setVisible(true);
                        Timer temporizador=new Timer(3000,new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e){
                                RuletaGirando.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
                                RuletaGirando.dispose();
                                FramePrincipal.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
                                FramePrincipal.dispose();
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
            FramePrincipal.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
            FramePrincipal.dispose();
            menu.EjecuciónConInicioDeSesión(usuarioActual,menu,listaDeusuarios);
            }
        });
        PantallaRuleta.setLayout(new GridLayout(2,1));
        PantallaRuleta.add(IniciarRuleta,BorderLayout.NORTH);
        PantallaRuleta.add(Salida,BorderLayout.SOUTH);
        frameRuleta.add(PantallaRuleta,BorderLayout.CENTER);
        frameRuleta.setVisible(true);
    }
        public static int Aleatorio(int maximo){
            Random random=new Random();
            int numero=random.nextInt(maximo);
            return numero;
        }
        public static int Aleatorio(int minimo,int maximo){
            Random random=new Random();
            int numero=random.nextInt(minimo,maximo);
            return numero;
        }
}
