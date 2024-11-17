package TragaMonedas;
import EntradaPrincipal.*;
import Usuarios.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Random;
import javax.swing.*;
public class interfaz{
    public static void ventana(usuario UsuarioActual,MenuDelCasinoGUI menu, List<usuario> listaDeusuarios,  JFrame FramePrincipal) {
        JFrame ventana = new JFrame("Traga Monedas");
        ventana.setSize(1000, 600);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.getContentPane().setBackground(Color.RED);
        JLabel texto = new JLabel("¿Desea Jugar en la maquina Traga Monedas?", SwingConstants.CENTER);
        texto.setForeground(Color.BLACK);
        texto.setFont(new Font("Arial", Font.BOLD, 30));
        ventana.setLayout(new BorderLayout());
        ventana.add(texto, BorderLayout.NORTH);
        JLabel etiquetaImagen = new JLabel();
        etiquetaImagen.setBackground(Color.RED);
        etiquetaImagen.setHorizontalAlignment(SwingConstants.CENTER);
        ImageIcon icono = new ImageIcon("ProyectoFinalPOO/src/tipografias/gif.gif");
        etiquetaImagen.setIcon(icono);
        ventana.add(etiquetaImagen, BorderLayout.CENTER);
        JPanel panelBotones = new JPanel();
        panelBotones.setBackground(Color.RED);
        panelBotones.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 20)); 
        JButton botonSi = new JButton("Sí");
        botonSi.setPreferredSize(new Dimension(150, 50));   
        JButton botonNo = new JButton("No");
        botonNo.setPreferredSize(new Dimension(150, 50));
        botonNo. addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                ventana.dispose();
                FramePrincipal.dispose();
                menu.EjecuciónConInicioDeSesión(UsuarioActual, menu, listaDeusuarios);
            }
        });
        botonSi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(UsuarioActual.getDinero()<=0){
                    JOptionPane.showMessageDialog(ventana, "No puede jugar", "saldo insuficiente", JOptionPane.WARNING_MESSAGE);
                }else{
                UsuarioActual.QuitarDinero(10.0);
                Random random = new Random();
                int n1 = random.nextInt(100) + 1;
                int n2 = random.nextInt(100) + 1;
                int n3 = random.nextInt(100) + 1;
                mostrarImagenes(n1, n2, n3, UsuarioActual, listaDeusuarios);
                //Ganar(n1, n2, n3);
                }
            }
        });
        panelBotones.add(botonSi);
        panelBotones.add(botonNo);
        ventana.add(panelBotones, BorderLayout.SOUTH);
        ventana.setVisible(true);
    }
    public static void mostrarImagenes(int n1, int n2, int n3, usuario UsuarioActual, List<usuario> listaDeusuarios){
        JFrame ventanaImagenes = new JFrame("Imágenes de Frutas");
        ventanaImagenes.setSize(1000, 600);
        ventanaImagenes.setLayout(new GridLayout(1, 3));

        ImageIcon manzana = new ImageIcon("ProyectoFinalPOO/src/tipografias/manzana-removebg-preview.png"); 
        ImageIcon pera = new ImageIcon("ProyectoFinalPOO/src/tipografias/pera-removebg-preview.png"); 
        ImageIcon cereza = new ImageIcon("ProyectoFinalPOO/src/tipografias/Cereza.png"); 
        JLabel label1 = new JLabel();
        manzana = cambiarTamaño(manzana, 300, 300); 
        pera = cambiarTamaño(pera, 300, 300); 
        cereza = cambiarTamaño(cereza, 300, 300);

        JLabel label2 = new JLabel();
        JLabel label3 = new JLabel();
        if (n1 >= 1 && n1 < 30) label1.setIcon(manzana);
        else if (n1 >= 30 && n1 < 60) label1.setIcon(pera);
        else label1.setIcon(cereza);

        if (n2 >= 1 && n2 < 30) label2.setIcon(manzana);
        else if (n2 >= 30 && n2 < 60) label2.setIcon(pera);
        else label2.setIcon(cereza);

        if (n3 >= 1 && n3 < 30) label3.setIcon(manzana);
        else if (n3 >= 30 && n3 < 60) label3.setIcon(pera);
        else label3.setIcon(cereza);
        ventanaImagenes.add(label1);
        ventanaImagenes.add(label2);
        ventanaImagenes.add(label3);
        ventanaImagenes.setVisible(true);
        Ganar(n1, n2, n3, UsuarioActual, listaDeusuarios);
        ventanaImagenes.dispose();
    }
    public static void Ganar(int n1, int n2, int n3, usuario UsuarioActual, List<usuario> listaDeusuarios) {
        if(n1>=1 && n1<30 && n2>1 && n2<30 && n3>1 && n3<30){
            JOptionPane.showMessageDialog(null, "¡Felicidades, ganaste 100.0!");
            UsuarioActual.AgregarDinero(100.0);
            utileriasParaAgregarObjetos.ArchivoConUsuarios(listaDeusuarios);
        }else if(n1>=30 && n1<60 && n2>30 && n2<60 && n3>30 && n3<60){
            JOptionPane.showMessageDialog(null, "¡Felicidades, ganaste 200.0!");
            UsuarioActual.AgregarDinero(200.0);
            utileriasParaAgregarObjetos.ArchivoConUsuarios(listaDeusuarios);
        }else if(n1>=60 && n1<100 && n2>60 && n2<100 && n3>60 && n3<101){
            JOptionPane.showMessageDialog(null, "¡Felicidades, ganaste 300.0!");
            UsuarioActual.AgregarDinero(300.0);
            utileriasParaAgregarObjetos.ArchivoConUsuarios(listaDeusuarios);
        }else{
            JOptionPane.showMessageDialog(null, "No ganaste");
        }
    }
    private static ImageIcon cambiarTamaño(ImageIcon icon, int ancho, int alto) {
        Image img = icon.getImage();
        Image nuevaImg = img.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH); 
        return new ImageIcon(nuevaImg); 
    }
}
