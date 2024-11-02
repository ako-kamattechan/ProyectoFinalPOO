package Usuarios;

import java.util.ArrayList;
//import java.util.Scanner;

//import java.util.ArrayList;
import java.util.List;
public class Pruebas {
    public static void main(String[] args) {
        //Scanner scanner=new Scanner(System.in);
        List<usuario> ListaUsuarios=new ArrayList<>();
        ListaUsuarios=utileriasParaAgregarObjetos.PasarDatosALista(ListaUsuarios);
        for(usuario Jugadores: ListaUsuarios){
            System.out.println(Jugadores.toString());
        }
    }
}
