package Usuarios;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class utileriasParaAgregarObjetos {
    public static void ArchivoConUsuarios(List<usuario> ListaComputadoras){
            try{
                ObjectOutputStream fileOut=new ObjectOutputStream(new FileOutputStream("ProyectoFinalPOO/src/Usuarios/ListaDeUsuarios"));
                fileOut.writeObject(ListaComputadoras);
                fileOut.close();
            }catch(IOException e){
                System.out.println("IO Error: " + e.getMessage());
            }
    }
    public static void LeerArchivo(List<usuario> ListaComputadoras){
        try{
            ObjectInputStream FileIn=new ObjectInputStream(new FileInputStream("ProyectoFinalPOO/src/Usuarios/ListaDeUsuarios"));
            ListaComputadoras=(List<usuario>)FileIn.readObject();
            for(usuario computadoras: ListaComputadoras){
                System.out.println(computadoras.toString());
            }
            FileIn.close();
        }catch(IOException e){
            System.out.println("IO Error: " + e.getMessage());
        }catch (ClassNotFoundException e) {
            System.out.println("ClassNotFound " + e.getMessage());
        }
    }
    public static List<usuario> PasarDatosALista(List<usuario> ListaComputadoras){
        ObjectInputStream FileIn;
        try{
            FileIn=new ObjectInputStream(new FileInputStream("ProyectoFinalPOO/src/Usuarios/ListaDeUsuarios"));
            return (List<usuario>)FileIn.readObject();
        }catch(IOException e){
            System.out.println("IO Error: " + e.getMessage());
        }catch (ClassNotFoundException e) {
            System.out.println("ClassNotFound " + e.getMessage());
        }
        return ListaComputadoras;
    }
}
