package strategy;

import enums.ResultadoCasas;
import facade.JogoFacade;
import jogadores.Jogador;
import singleton.Tabuleiro;

public class CasaPrisao extends Casa{

	public CasaPrisao(int numero) {
		super(numero);
	}

	@Override
	public void aplicarRegra(Jogador jogador, Tabuleiro tabuleiro, JogoFacade jogoFacade) {
		jogoFacade.mensagensCasas(ResultadoCasas.PRISAO, jogador);
		jogador.setEstadoPreso(true);
	}
	
}
