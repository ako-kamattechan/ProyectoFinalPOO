package blackjack;

import Usuarios.usuario;
import javax.swing.*;

public class PlayWhileTrue {
    public static void play(usuario usuarioActual) {

        double bet = FirstBet.bet();

        if(bet > usuarioActual.getDinero()) {
            FirstBet.notEnoughFunds();
            return;
        }

        usuarioActual.QuitarDinero(bet);

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                usuarioActual.AgregarDinero(BJ21.b21(bet));
            }
        });
    }

}
