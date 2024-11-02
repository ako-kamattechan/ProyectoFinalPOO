package EntradaPrincipal;

import javax.swing.*;
import java.awt.*;
import javax.swing.*;
import java.io.*;
public class utilerías {
    public static JPanel CrearPanel(int colorRojo,int colorGreen, int colorAzul){
        JPanel panel=new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(new Color(colorRojo,colorGreen,colorAzul));
        return panel;

    }
    public static JPanel CrearPanel(int colorRojo,int colorGreen, int colorAzul, int top,int left,int bottom,int right){
        JPanel panel=new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(new Color(colorRojo,colorGreen,colorAzul));
        panel.setBorder(BorderFactory.createEmptyBorder(top, left, bottom, right));
        return panel;
    }
    public static JLabel AgregarImagen(int width, int height, int x, int y, String Path){      
        File file=new File(Path);
        ImageIcon ImagenOriginal=new ImageIcon(file.getAbsolutePath());

        Image Logo=ImagenOriginal.getImage().getScaledInstance(width, height, Image.SCALE_REPLICATE);
        ImageIcon LogoEscalado=new ImageIcon(Logo);

        JLabel imagen=new JLabel();
        imagen.setIcon(LogoEscalado);
        imagen.setBounds(x,y,width,height);
        
        return imagen;
    }
    public static JButton CrearBotones(String Contenido, Font font){
        JButton boton=new JButton(Contenido);
        boton.setFont(font);
        return boton;
    }
}

