package strategy;

import enums.ResultadoCasas;
import facade.JogoFacade;
import jogadores.Jogador;
import singleton.Tabuleiro;

public class CasaJogaDeNovo extends Casa{

	public CasaJogaDeNovo(int numero) {
		super(numero);
	}

	@Override
	public void aplicarRegra(Jogador jogador, Tabuleiro tabuleiro, JogoFacade jogoFacade) {
		jogoFacade.mensagensCasas(ResultadoCasas.JOGADENOVO, jogador);
		jogador.setEstadoDeJogarDenovo(true);
	}

}
