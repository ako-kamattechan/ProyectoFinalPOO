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

        menu.EjecuciónMenuDeInicio(ListaUsuarios,menu.getInicioDesesion());
    }
}
