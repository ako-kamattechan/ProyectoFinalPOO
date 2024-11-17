package Usuarios;
import java.io.*;

public class usuario implements Serializable {
    private String nombreDeusuario;
    private String correo;
    private String Contraseña;
    private double Dinero;
    private Boolean InicioDeSesion=false;
    public usuario( String nombre, String correo, String Contraseña){
        this.nombreDeusuario=nombre;
        this.correo=correo;
        this.Contraseña=Contraseña;
        this.Dinero=0;
    }
    public void AgregarDinero(Double dinero){
        this.Dinero=this.Dinero+dinero;
    }
    public void QuitarDinero(Double dinero){
        this.Dinero=this.Dinero-dinero;
    }
    public String toString(){
        return "usuario:"+nombreDeusuario+"\tcorreo:"+correo+"\tContraseña:"+Contraseña+"\tDinero: "+Dinero+"$";
    }
    //Getters:
    public Boolean getBool(){
        return InicioDeSesion;
    }
    public void setInicioDesesión(Boolean booleano){
        this.InicioDeSesion=booleano;
    }
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
