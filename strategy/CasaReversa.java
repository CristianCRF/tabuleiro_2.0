package strategy;

import jogadores.Jogador;
import singleton.Tabuleiro;

public class CasaReversa extends Casa {

	public CasaReversa(int numero) {
		super(numero);
	}

	@Override
	public void aplicarRegra(Jogador jogador, Tabuleiro tabuleiro) {
		Jogador ultimo = tabuleiro.getUltimoJogador(); 

        int posAtual = jogador.getCasa();
        int posUltimo = ultimo.getCasa();

        jogador.setCasa(posUltimo);
        ultimo.setCasa(posAtual);
	}
}
