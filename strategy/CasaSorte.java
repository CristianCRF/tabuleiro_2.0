package strategy;

import jogadores.Jogador;
import singleton.Tabuleiro;

public class CasaSorte extends Casa{

	public CasaSorte(int numero) {
		super(numero);
	}

	@Override
	public void aplicarRegra(Jogador jogador, Tabuleiro tabuleiro) {
		jogador.avancar();
	}

}
