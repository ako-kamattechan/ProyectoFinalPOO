package EntradaPrincipal;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

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
        //Boolean FrameRegistroActivo=false;
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
                JPanel IngresoDeDatos=utilerías.CrearPanel(92, 138, 129);
                JLabel Nombre=new JLabel("Ingrese nombre de usuario:");
                Nombre.setFont(FontChico);
                JTextField TFNombre=new JTextField();
                TFNombre.setFont(FontChico);

                JLabel Contraseña=new JLabel("Ingrese su contraseña:");
                Contraseña.setFont(FontChico);
                JTextField TFContraseña=new JTextField();
                TFContraseña.setFont(FontChico);

                IngresoDeDatos.setLayout(new GridLayout(4,1));
                IngresoDeDatos.add(Nombre);
                IngresoDeDatos.add(TFNombre);
                IngresoDeDatos.add(Contraseña);
                IngresoDeDatos.add(TFContraseña);
                FrameParaIniciarSesion(IngresoDeDatos);
            }
        });
        JButton BotonNo=utilerías.CrearBotones("No", fontBotones);
        BotonNo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JPanel IngresoDeDatos=utilerías.CrearPanel(92, 138, 129);
                JLabel Pregunta=new JLabel("¿Desea registrarse para guardar sus datos?");
                Pregunta.setFont(FontChico);
                
                JButton BotonRegistro1=utilerías.CrearBotones("Si", FontChico);
                BotonRegistro1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //Aquí va un método para que ingrese sus datos personales y se guarden en objetos de tipo Cliente :/
                    }
                    
                });
                JButton BotonRegistro2=utilerías.CrearBotones("No", FontChico);
                BotonRegistro2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //Aquí se tiene que agregar algo para que el programa de salida hacia la zona de juegos
                        
                    }
                    
                });
                IngresoDeDatos.setLayout(new GridLayout(3,1));
                IngresoDeDatos.add(Pregunta);
                IngresoDeDatos.add(BotonSi);
                IngresoDeDatos.add(BotonNo);
                FrameParaRegistrarUsuarios(IngresoDeDatos);
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
    public void FrameParaIniciarSesion(JPanel panel){
        JFrame frame=new JFrame("Inicio de sesión");
        frame.setSize(600,560);
        frame.add(panel);
        frame.setVisible(true);
    }
    public void FrameParaRegistrarUsuarios(JPanel panel){
        JFrame frame=new JFrame("Registro");
        frame.setSize(600,560);
        frame.add(panel);
        frame.setVisible(true);
    }
}
//IMLogo.setImageObserver(LBlogo);--idea para animación de ruleta