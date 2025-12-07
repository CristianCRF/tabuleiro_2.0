package strategy;

import jogadores.Jogador;
import singleton.Tabuleiro;

public class CasaPrisao extends Casa{

	public CasaPrisao(int numero) {
		super(numero);
	}

	@Override
	public void aplicarRegra(Jogador jogador, Tabuleiro tabuleiro) {
		jogador.setPreso(true);
	}
	
}
