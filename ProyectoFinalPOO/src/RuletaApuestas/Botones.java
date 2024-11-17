package RuletaApuestas;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import EntradaPrincipal.*;
import Ruleta.RuletaGUI;
import Usuarios.usuario;
import java.util.List;
import Usuarios.utileriasParaAgregarObjetos;
public class Botones {
    public static JButton BotónParaIngresarApuestas(Font mainFont,usuario usuarioActual,List<usuario> listaDeusuarios){
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
                JButton IngresarApuesta=BotónParaIngresarValoresDeApuesta(FieldNUMERO,FieldCOLOR, FieldApuesta,mainFont,exito,frameParaIngresarApuestas,panelParaingresarApuestas,usuarioActual,listaDeusuarios);
                panelParaingresarApuestas.add(IngresarApuesta);
                panelParaingresarApuestas.add(exito);
                frameParaIngresarApuestas.add(panelParaingresarApuestas);
                frameParaIngresarApuestas.setVisible(true);
            }
        });
        return IniciarRuleta;
    }
    public static JButton BotónParaIngresarValoresDeApuesta(JTextField FieldNUMERO,JTextField FieldCOLOR, JTextField FieldApuesta,Font mainFont,JLabel exito,JFrame frameParaIngresarApuestas, JPanel panelParaingresarApuestas,usuario usuarioActual,List<usuario> listaDeusuarios){
        JButton IngresarApuesta=utilerías.CrearBotones("Enviar apuesta", mainFont);
                IngresarApuesta.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e){
                        if(RuletaApuestaGUI.comprobarApuestas(FieldNUMERO.getText(),FieldCOLOR.getText(),FieldApuesta.getText(),usuarioActual)==true){
                            exito.setText("Apuesta Ingresada");
                            Timer temporizadorDeDossegundos=new Timer(2000,new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e){
                                    //panelParaingresarApuestas.setVisible(false);
                                    frameParaIngresarApuestas.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
                                    frameParaIngresarApuestas.dispose();
                                    JFrame frame=utilerías.CrearFrameGenerico("Imagen", 1000, 800);
                                    JLabel img=utilerías.AgregarImagen(1000, 800, 600, 100, "ProyectoFinalPOO/src/tipografias/Ruleta.gif");
                                    JPanel panelimagen=utilerías.CrearPanel(83, 140, 207);
                                    panelimagen.add(img);
                                    frame.add(panelimagen);
                                    frame.setVisible(true);
                                    //Integer numerosNegros[]={2,4,6,8,11,10,15,17,20,22,24,26,29,28,31,33,35};
                                    Timer temporizadorDeDossegundos=new Timer(3000,new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e){
                                            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
                                            frame.dispose();
                                            JFrame frameaux=utilerías.CrearFrameGenerico("ResultadosApuestas", 500, 650);
                                            JPanel panelimagen=utilerías.CrearPanel(83, 140, 207);
                                            JLabel Mensaje=new JLabel();
                                            Integer NUmero=Integer.parseInt(FieldNUMERO.getText());
                                            Double dinero=Double.parseDouble(FieldApuesta.getText());
                                            usuarioActual.QuitarDinero(dinero);
                                            utileriasParaAgregarObjetos.ArchivoConUsuarios(listaDeusuarios);
                                            int Resultado=ResultadoRuleta();
                                            JLabel resultado=new JLabel("El resultado de girar la ruleta fue:"+Resultado);
                                            if(NUmero==Resultado){
                                                Mensaje.setText("Ganaste "+(35*dinero+dinero));
                                                Mensaje.setFont(mainFont);
                                                Double total=(35*dinero)+dinero;
                                                usuarioActual.AgregarDinero(total);
                                                utileriasParaAgregarObjetos.ArchivoConUsuarios(listaDeusuarios);
                                                //ganador
                                            }else{
                                                //perdedor
                                                Mensaje.setText("Perdiste:(");
                                                Mensaje.setFont(mainFont);
                                
                                            }
                                            panelimagen.setLayout(new GridLayout(2,1));
                                            panelimagen.add(resultado);
                                            panelimagen.add(Mensaje);
                                            frameaux.add(panelimagen);
                                            frameaux.setVisible(true);
                                            Timer temporizadorDeDossegundos=new Timer(3000,new ActionListener() {
                                                @Override
                                                public void actionPerformed(ActionEvent e){
                                                    frameaux.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
                                                    frameaux.dispose();
                                                }
                                            });
                                            temporizadorDeDossegundos.setRepeats(false);
                                            temporizadorDeDossegundos.start();
                                        }    
                                    });
                                        temporizadorDeDossegundos.setRepeats(false);
                                        temporizadorDeDossegundos.start();
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
    public static JButton JugarRojos(Font mainFont,usuario usuarioactual,List<usuario> listaDeusuarios){
        JButton boton=AccionParaPreguntarDinero("Jugar Rojos", mainFont,usuarioactual,true,listaDeusuarios);
        return boton;
    }
    public static JButton JugarNegros(Font maiFont,usuario usuarioactual,List<usuario> listaDeusuarios){
        JButton boton=AccionParaPreguntarDinero("Jugar Negros", maiFont,usuarioactual,false,listaDeusuarios);
        return boton;
    }
    public static JButton AccionParaPreguntarDinero(String titulo,Font maiFont,usuario usuarioactual,Boolean color,List<usuario> listaDeusuarios){
        JButton boton=utilerías.CrearBotones(titulo, maiFont);
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                JLabel dinero=new JLabel("¿Cuánto desea apostar?");
                JTextField TFDinero=new JTextField();
                JFrame frame=utilerías.CrearFrameGenerico(titulo, 800, 300);
                JPanel panelaux=utilerías.CrearPanel(201, 90, 181);
                JLabel exito=new JLabel();
                JButton enviarApuesta=utilerías.CrearBotones("Enviar apuesta", maiFont);
                enviarApuesta.addActionListener(new ActionListener() {
                    @Override
                   public void actionPerformed(ActionEvent e){
                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
                    frame.dispose();                    
                    JFrame frame=utilerías.CrearFrameGenerico(titulo, 1000, 800);
                    JLabel img=utilerías.AgregarImagen(1000, 800, 600, 100, "ProyectoFinalPOO/src/tipografias/Ruleta.gif");
                    JPanel panelimagen=utilerías.CrearPanel(83, 140, 207);
                    panelimagen.add(img);
                    frame.add(panelimagen);
                    frame.setVisible(true);
                    Timer temporizadorDeDossegundos=new Timer(3000,new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e){    
                        if(RuletaApuestaGUI.comprobarApuestas(TFDinero.getText(), usuarioactual)==true){
                            panelimagen.setVisible(false);
                            Double Dinero=Double.parseDouble(TFDinero.getText());
                            JPanel panelResultados=utilerías.CrearPanel(83, 140, 207);
                            int Resultado=ResultadoRuleta();
                            usuarioactual.QuitarDinero(Dinero);
                            utileriasParaAgregarObjetos.ArchivoConUsuarios(listaDeusuarios);
                            JLabel resultado=new JLabel("El resultado de girar la ruleta fue:"+Resultado);
                            resultado.setFont(maiFont);
                            panelResultados.setLayout(new GridLayout(3,1));
                            panelResultados.add(resultado);
                            JLabel Mensaje=new JLabel();
                            if(PerteneceARojos(Resultado)==true&&color==true){
                                Mensaje.setText("Ganaste "+(2*Dinero));
                                Mensaje.setFont(maiFont);
                                usuarioactual.AgregarDinero(2*Dinero);
                                utileriasParaAgregarObjetos.ArchivoConUsuarios(listaDeusuarios);
                            }else if(!PerteneceARojos(Resultado)&&color==false){
                                Mensaje.setText("Ganaste "+(2*Dinero));
                                Mensaje.setFont(maiFont);
                                usuarioactual.AgregarDinero(2*Dinero);
                                utileriasParaAgregarObjetos.ArchivoConUsuarios(listaDeusuarios);
                            }
                            else{
                                Mensaje.setText("Perdiste :(");
                            }
                            panelResultados.add(Mensaje);
                            frame.add(panelResultados);
                            panelResultados.setVisible(true);
                            Timer temporizadorDeDossegundos=new Timer(2000,new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e){
                                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
                                    frame.dispose();
                                }
                            } );
                            temporizadorDeDossegundos.setRepeats(false);
                            temporizadorDeDossegundos.start();
                        
                        }else{
                            exito.setText("Error, prueba de nuevo");
                            TFDinero.setText("");
                        }
                        }
                    });
                    temporizadorDeDossegundos.setRepeats(false);
                    temporizadorDeDossegundos.start();
                   } 
                });
                panelaux.setLayout(new GridLayout(4,1));
                panelaux.add(dinero);
                panelaux.add(TFDinero);
                panelaux.add(enviarApuesta);
                panelaux.add(exito);
                frame.add(panelaux);
                frame.setVisible(true);
            }
        });
        utileriasParaAgregarObjetos.ArchivoConUsuarios(listaDeusuarios);

        return boton;
    }
    public static int ResultadoRuleta(){
        int resultado=RuletaGUI.Aleatorio(0,36); 
        return resultado;  
    }
    public static Boolean PerteneceARojos(int numero){
        Boolean condicion=false;
        int[] rojos={1,3,5,7,9,12,14,16,18,19,21,23,25,27,30,32,34,37};
        for(int valor: rojos){
            if(valor==numero){
                condicion=true;
            }
        }
        return condicion;
    }
}
