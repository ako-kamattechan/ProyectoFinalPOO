package EntradaPrincipal;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import Usuarios.*;
import java.util.List;
import Ruleta.RuletaGUI;
import RuletaApuestas.RuletaApuestaGUI;
import TragaMonedas.*;
public class MenuDelCasinoGUI{
    final private Font mainFont=new Font("Garamond", Font.ITALIC,50);
    final private Font FontChico=new Font("Garamond", Font.ITALIC,35);
    final private Font fontBotones=new Font("SansSerif", Font.ITALIC,35);
    private Boolean InicioDesesión=false;
    public void FramePrincipal(JPanel mainPanel){
        JFrame frame=new JFrame("CasaPuesta.POO");
        frame.setSize(1420,560);
        frame.add(mainPanel);
        frame.setVisible(true);
    }
    public JFrame FramePrincipal(){
        JFrame frame=new JFrame("CasaPuesta.POO");
        frame.setSize(1420,560);
        return frame;
    }

    public void setInicioDesesión(Boolean booleano){
        this.InicioDesesión=booleano;
    }
    public Boolean getInicioDesesion(){
        return InicioDesesión;
    }
    public void EjecuciónMenuDeInicioSinIniciarSesión(List<usuario> listaDeusuarios, MenuDelCasinoGUI menu){
        JFrame FramePrincipal=FramePrincipal();

        utileriasParaAgregarObjetos.PasarDatosALista(listaDeusuarios);
        usuario[] usuarioActual=new usuario[1];
        JPanel mainPanel=utilerías.CrearPanel(231, 227, 210);
        JPanel PanelBienvenida=utilerías.CrearPanel(255, 255, 255);
        JPanel PanelPregunta=utilerías.CrearPanel(255, 251, 217,10,10,10,10);


        JLabel LBlogo=utilerías.AgregarImagen(300, 200, 30, 0, "ProyectoFinalPOO/src/tipografias/Logo3.jpg");
        JLabel Bienvenida=new JLabel("Bienvenido al casino CasaPuesta.POO");
        JLabel PreguntaCuenta=new JLabel("¿Ya tienes una cuenta en nuestro banco?");
        JLabel Pregunta2=new JLabel("Si desea jugar sin iniciar sesión, no se guardará su progreso.(dinero)");
        JLabel SeleccionDeJuegos=new JLabel("Seleccione un juego:");

        JButton BotonSi=utilerías.CrearBotones("si", fontBotones);
        BotonSi=BotonesMenu.BotonDeIniciarSesión(fontBotones, FontChico, listaDeusuarios,usuarioActual,FramePrincipal,menu);
        
        JButton BotonNo=utilerías.CrearBotones("No", fontBotones);
        BotonNo=BotonesMenu.BotonDeQueNoEstáRegistrado(fontBotones, FontChico, listaDeusuarios);
        
        Bienvenida.setFont(mainFont);
        PreguntaCuenta.setFont(FontChico);
        SeleccionDeJuegos.setFont(mainFont);

        PanelBienvenida.setSize(200,200);
        PanelPregunta.setSize(100,100);

        PanelBienvenida.add(LBlogo, BorderLayout.WEST);
        PanelBienvenida.add(Bienvenida,BorderLayout.EAST);

        PanelPregunta.add(PreguntaCuenta,BorderLayout.NORTH);
        PanelPregunta.add(Pregunta2);
        PanelPregunta.setLayout(new GridLayout(4, 1));
        PanelPregunta.add(BotonSi);
        PanelPregunta.add(BotonNo);
        mainPanel.add(PanelBienvenida,BorderLayout.NORTH);
        mainPanel.add(PanelPregunta,BorderLayout.CENTER);
        FramePrincipal.add(mainPanel);
        FramePrincipal.setVisible(true);

    }
    public void EjecuciónConInicioDeSesión(usuario usuarioActual,  MenuDelCasinoGUI menu,List<usuario> listaDeusuarios){
        JFrame FramePrincipal=FramePrincipal();
        JPanel mainPanel=utilerías.CrearPanel(231, 227, 210);
        JPanel PanelBienvenida=utilerías.CrearPanel(255, 255, 255);
        JPanel PanelPregunta=utilerías.CrearPanel(255, 251, 217,10,10,10,10);


        JLabel LBlogo=utilerías.AgregarImagen(300, 200, 30, 0, "ProyectoFinalPOO/src/tipografias/Logo3.jpg");
        JLabel Bienvenida=new JLabel("Bienvenido al casino CasaPuesta.POO");
        JLabel SeleccionDeJuegos=new JLabel("Seleccione un juego:");
        JLabel Usuario=new JLabel("Usuario: "+usuarioActual.getnombre());
        JLabel DineroAcumulado=new JLabel("Dinero actual: "+usuarioActual.getDinero());

            JPanel PanelJuegos=utilerías.CrearPanel(105, 163, 255);
            JButton BotonBlack=utilerías.CrearBotones("Black Jack", FontChico);
            BotonBlack.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    
                }
            });

            JButton BotonApuesta=utilerías.CrearBotones("Apueste con la Ruleta", FontChico);
            BotonApuesta.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    RuletaApuestaGUI.RuletaApuestasGUI(usuarioActual, menu, listaDeusuarios);
                    FramePrincipal.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
                    FramePrincipal.dispose();    
                    utileriasParaAgregarObjetos.ArchivoConUsuarios(listaDeusuarios);
                 }
            });
            JButton BotonRuleta=utilerías.CrearBotones("Gire la ruleta de la suerte!", FontChico);
            BotonRuleta.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    RuletaGUI.PuntoDeAccesoRuleta(usuarioActual,menu,listaDeusuarios,FramePrincipal);
                    
                    utileriasParaAgregarObjetos.ArchivoConUsuarios(listaDeusuarios);
   
                 }
            });
            JButton BotonTragamonedas=utilerías.CrearBotones("Jugar a la tragaMonedas", FontChico);
            BotonTragamonedas.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    interfaz.ventana(usuarioActual, menu, listaDeusuarios,FramePrincipal);   
                }
            });
            PanelJuegos.add(BotonBlack);
            PanelJuegos.add(BotonRuleta);
            PanelJuegos.add(BotonTragamonedas);
            PanelJuegos.add(BotonApuesta);
            PanelJuegos.setSize(600, 200);

            PanelJuegos.add(SeleccionDeJuegos,BorderLayout.CENTER);
            PanelJuegos.setLayout(new GridLayout(5,1));
            mainPanel.add(PanelJuegos, BorderLayout.CENTER);

        Bienvenida.setFont(mainFont);
        SeleccionDeJuegos.setFont(mainFont);

        PanelBienvenida.setSize(200,200);
        PanelPregunta.setSize(100,100);

        PanelBienvenida.add(LBlogo, BorderLayout.WEST);
        PanelBienvenida.add(Bienvenida,BorderLayout.EAST);

        PanelPregunta.setLayout(new GridLayout(2, 1));
        PanelPregunta.add(Usuario);
        PanelPregunta.add(DineroAcumulado);

        mainPanel.add(PanelBienvenida,BorderLayout.NORTH);
        mainPanel.add(PanelPregunta,BorderLayout.WEST);

        FramePrincipal.add(mainPanel);
        FramePrincipal.setVisible(true);
    }
}