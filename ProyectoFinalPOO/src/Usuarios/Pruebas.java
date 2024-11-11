package Usuarios;

import java.util.ArrayList;
//import java.util.Scanner;

//import java.util.ArrayList;
import java.util.List;
public class Pruebas {
    public static void main(String[] args) {
        //Scanner scanner=new Scanner(System.in);
        List<usuario> ListaUsuarios=new ArrayList<>();
        usuario Admin=new usuario("Alan", "Alanvilchis07", "123");
        ListaUsuarios.add(Admin);
        ListaUsuarios=utileriasParaAgregarObjetos.PasarDatosALista(ListaUsuarios);
        for(usuario Jugadores: ListaUsuarios){
            System.out.println(Jugadores.toString());
        }
    }
}
