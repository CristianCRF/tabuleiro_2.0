package strategy;

import jogadores.Jogador;
import singleton.Tabuleiro;

public abstract class Casa {
    protected int numero;

    public Casa(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    // método do strategy
    public abstract void aplicarRegra(Jogador jogador, Tabuleiro tabuleiro);
    
    @Override
    public String toString() {
        return this.getClass().getSimpleName().replace("Casa", "");
    }
}