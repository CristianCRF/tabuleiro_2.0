package strategy;

import facade.JogoFacade;
import jogadores.Jogador;
import singleton.Tabuleiro;

public abstract class Casa {

    private final int numero;

    public Casa(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public abstract void aplicarRegra(Jogador jogador, Tabuleiro tabuleiro, JogoFacade jogoFacade);
}
