package EntradaPrincipal;
import java.awt.*;
import javax.swing.*;
import java.io.*;
public class MenuDelCasinoGUI{
    final private Font mainFont=new Font(/*Font.createFont(Font.TRUETYPE_FONT, fontFile).deriveFont(24f)*/"Segoe print", Font.BOLD,18);
    public void FramePrincipal(JPanel mainPanel){
        JFrame frame=new JFrame("CasaPuesta.POO");
        //frame.setTitle("CasaPuesta.POO");
        frame.setSize(1024,1080);
        frame.add(mainPanel);
        frame.setVisible(true);
    }
    public void EjecuciónMenuDeInicio(){
        JPanel mainPanel=utilerías.CrearPanel(231, 227, 210);
        JPanel panelImagen=utilerías.CrearPanel(231, 227, 210);
        panelImagen.setLayout(null);
        panelImagen.setSize(200,400);
        JLabel LBlogo=utilerías.AgregarImagen(300, 200, 25, 0, "ProyectoFinalPOO/src/tipografias/Logo3.jpg");
        panelImagen.add(LBlogo);

        mainPanel.add(panelImagen, BorderLayout.CENTER);
        FramePrincipal(mainPanel);
    }

}
//IMLogo.setImageObserver(LBlogo);--idea para animación de ruleta
