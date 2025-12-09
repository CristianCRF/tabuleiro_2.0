package strategy;

import jogadores.Jogador;
import singleton.Tabuleiro;

public class CasaJogaDeNovo extends Casa{

	public CasaJogaDeNovo(int numero) {
		super(numero);
	}

	@Override
	public void aplicarRegra(Jogador jogador, Tabuleiro tabuleiro) {
		jogador.setEstadoDeJogarDenovo(true);
	}

}
