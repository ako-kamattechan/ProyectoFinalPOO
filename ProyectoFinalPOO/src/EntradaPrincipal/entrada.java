package EntradaPrincipal;

import java.util.ArrayList;
import java.util.List;

import Usuarios.usuario;
import Usuarios.utileriasParaAgregarObjetos;

public class entrada {
    public static void main(String[] args) {
        List<usuario> ListaUsuarios=new ArrayList<>();
        ListaUsuarios=utileriasParaAgregarObjetos.PasarDatosALista(ListaUsuarios);
        MenuDelCasinoGUI menu=new MenuDelCasinoGUI();
        menu.EjecuciónMenuDeInicioSinIniciarSesión(ListaUsuarios,menu);
        //IMPORTANTE: LA INSTRUCCIÓN DE ABAJO SI SE QUITA EN CUALQUIER CASO EN EL QUE SE ACTUALICE LA LISTA, VA A DESERIALIZAR EL ARCHIVO Y POR ENDE EL PROGRAMA NO FUNCIONARÁ CORRECTAMENTE.
        utileriasParaAgregarObjetos.ArchivoConUsuarios(ListaUsuarios);
    }
}
