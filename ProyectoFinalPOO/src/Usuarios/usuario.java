package Usuarios;
import java.io.*;

public class usuario implements Serializable {
    private String nombreDeusuario;
    private String correo;
    private String Contraseña;
    private double Dinero;
    public usuario( String nombre, String correo, String Contraseña){
        this.nombreDeusuario=nombre;
        this.correo=correo;
        this.Contraseña=Contraseña;
        this.Dinero=0;
    }
    public String toString(){
        return "usuario:"+nombreDeusuario+"\tcorreo:"+correo+"\tContraseña:"+Contraseña;
    }
    //Getters:
    public String getnombre(){
        return nombreDeusuario;
    }
    public String getcorreo(){
        return correo;
    }
    public String getContraseña(){
        return Contraseña;
    }
    public double getDinero(){
        return Dinero;
    }
    //setters:
    /*public void setfechaDeNacimiento(String Fecha){
        if(Fecha.length()==10){
        this.fechaDeNacimiento=Fecha;
        }else if(Fecha.isBlank()||Fecha.length()<10){
            System.out.println("Intente Otra vez");
        }
    }*/
    public void setnombre(String nombre){
        this.nombreDeusuario=nombre;
    }
    public void setcorreo(String correo){
        this.correo=correo;
    }
    public void setContraseña(String Contraseña){
        this.Contraseña=Contraseña;
    }
    public void setDinero(Double dinero){
        this.Dinero=dinero;
    }
}
