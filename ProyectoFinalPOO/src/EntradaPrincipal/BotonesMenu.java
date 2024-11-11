package EntradaPrincipal;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import Usuarios.*;
import java.util.List;

public class BotonesMenu {
    public static JButton BotonDeIniciarSesión(Font fontBotones,Font FontChico,List<usuario> listaDeusuarios,usuario[] usuarioActual,JFrame FramePrincipal,MenuDelCasinoGUI menu){
        JButton BotonSi=utilerías.CrearBotones("si", fontBotones);
        BotonSi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame=utilerías.CrearFrameGenerico("Iniciar Sesión", 560, 600);
                frame.setVisible(true);
                JPanel IngresoDeDatos=utilerías.CrearPanel(92, 138, 129);
                JLabel Nombre=new JLabel("Ingrese nombre de usuario:");
                Nombre.setFont(FontChico);
                JTextField TFNombre=new JTextField();
                TFNombre.setFont(FontChico);

                JLabel Contraseña=new JLabel("Ingrese su contraseña:");
                Contraseña.setFont(FontChico);
                JTextField TFContraseña=new JTextField();
                TFContraseña.setFont(FontChico);

                JLabel Exito=new JLabel();
                Exito.setFont(FontChico);
                JButton botonComprobaciónDeDatos=utilerías.CrearBotones("Iniciar sesión", FontChico);
                botonComprobaciónDeDatos.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                            String Usuario=TFNombre.getText();
                            String Contraseña=TFContraseña.getText();
                            for(usuario Jugador: listaDeusuarios){
                                if(Jugador.getnombre().equals(Usuario)&&Jugador.getContraseña().equals(Contraseña)){
                                    Exito.setText("Iniciaste Sesión");
                                    usuarioActual[0]=Jugador;
                                    usuarioActual[0].setInicioDesesión(true);

                                    Timer temporizadorDeDossegundos=new Timer(2000,new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e){
                                            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
                                            frame.dispose();
                                            FramePrincipal.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
                                            FramePrincipal.dispose();
                                            menu.EjecuciónConInicioDeSesión(usuarioActual[0],menu,listaDeusuarios);
                                        }
                                    } );
                                    temporizadorDeDossegundos.setRepeats(false);
                                    temporizadorDeDossegundos.start();

                                    break;
                                }else{
                                    Exito.setText("No se logró iniciar sesión");
                                    LimpiarCampos(TFNombre, TFContraseña);
                                }
                            }
                        
                    }
                });
                IngresoDeDatos.setLayout(new GridLayout(6,1));
                IngresoDeDatos.add(Nombre);
                IngresoDeDatos.add(TFNombre);
                IngresoDeDatos.add(Contraseña);
                IngresoDeDatos.add(TFContraseña);
                IngresoDeDatos.add(botonComprobaciónDeDatos);
                IngresoDeDatos.add(Exito);
                frame.add(IngresoDeDatos);
            }
        });
        return BotonSi;
    }
    public static JButton BotónDeRegistro(Font fontBotones,Font FontChico,List<usuario> listaDeusuarios){
        JButton BotonRegistro1=utilerías.CrearBotones("Si", FontChico);
                BotonRegistro1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JFrame frame=utilerías.CrearFrameGenerico("Ingresar Datos de usuario", 560, 600);
                        frame.setVisible(true);
                        JLabel IngreseDatos, IngresaTuNombreDeusuario, IngresaTuContraseña,IngresaTuCorreo;
                        IngreseDatos=new JLabel();
                        IngreseDatos.setFont(FontChico);
                        IngresaTuNombreDeusuario=new JLabel();
                        IngresaTuNombreDeusuario.setFont(FontChico);
                        IngresaTuContraseña= new JLabel();
                        IngresaTuContraseña.setFont(FontChico);
                        IngresaTuCorreo=new JLabel();
                        IngresaTuCorreo.setFont(FontChico);

                        JTextField AreaNombre=new JTextField();
                        JTextField AreaContraseña=new JTextField();
                        JTextField AreaCorreo=new JTextField();
                        JPanel PanelDeIngreseDeDatos=utilerías.CrearPanel(255, 255, 255);
                        
                        IngreseDatos.setText("Ingresa tus datos:");
                        IngresaTuNombreDeusuario.setText("Ingresa tu nombre de usuario:");
                        IngresaTuContraseña.setText("Ingresa tu contraseña:");
                        IngresaTuCorreo.setText("Ingresa tu correo:");

                        PanelDeIngreseDeDatos.setLayout(new GridLayout(8,1));
                        PanelDeIngreseDeDatos.add(IngreseDatos);
                        PanelDeIngreseDeDatos.add(IngresaTuNombreDeusuario);
                        PanelDeIngreseDeDatos.add(AreaNombre);
                        PanelDeIngreseDeDatos.add(IngresaTuContraseña);
                        PanelDeIngreseDeDatos.add(AreaContraseña);
                        PanelDeIngreseDeDatos.add(IngresaTuCorreo);
                        PanelDeIngreseDeDatos.add(AreaCorreo);
                        JButton botonParaenviarDatos=utilerías.CrearBotones("Registrarme", FontChico);
                        botonParaenviarDatos.addActionListener(new ActionListener() {
                            @Override
                                public void actionPerformed(ActionEvent e) {
                                    usuario usuario=new usuario(AreaNombre.getText(),AreaCorreo.getText() , AreaContraseña.getText());
                                    listaDeusuarios.add(usuario);
                                    utileriasParaAgregarObjetos.ArchivoConUsuarios(listaDeusuarios);
                                    LimpiarCampos(AreaNombre, AreaContraseña, AreaCorreo);
                                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
                                    frame.dispose();
                                }
                        });
                        PanelDeIngreseDeDatos.add(botonParaenviarDatos);
                        frame.add(PanelDeIngreseDeDatos);
                    }
                    
                });
                return BotonRegistro1;
    }
    public static void LimpiarCampos(JTextField Campo1,JTextField Campo2,JTextField Campo3){
        Campo1.setText("");
        Campo2.setText("");
        Campo3.setText("");
    }
    public static void LimpiarCampos(JTextField Campo1,JTextField Campo2){
        Campo1.setText("");
        Campo2.setText("");
    }
    public static JButton BotonDeQueNoEstáRegistrado(Font fontBotones,Font FontChico,List<usuario> listaDeusuarios){
        JButton BotonNo=utilerías.CrearBotones("No", fontBotones);
        BotonNo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame=utilerías.CrearFrameGenerico("registro", 560, 600);
                frame.setVisible(true);
                JPanel IngresoDeDatos=utilerías.CrearPanel(92, 138, 129);
                JLabel Pregunta=new JLabel("¿Desea registrarse para guardar sus datos?");
                Pregunta.setFont(FontChico);
                
                JButton BotonRegistro1=utilerías.CrearBotones("Si", FontChico);
                BotonRegistro1=BotonesMenu.BotónDeRegistro(fontBotones, FontChico, listaDeusuarios);


                JButton BotonRegistro2=utilerías.CrearBotones("No", FontChico);
                BotonRegistro2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
                        frame.dispose();
                    }
                    
                });
                IngresoDeDatos.setLayout(new GridLayout(3,1));
                IngresoDeDatos.add(Pregunta);
                IngresoDeDatos.add(BotonRegistro1);
                IngresoDeDatos.add(BotonRegistro2);
                frame.add(IngresoDeDatos);
            }
        });
        return BotonNo;
    }

}
