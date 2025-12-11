package strategy;

import enums.ResultadoCasas;
import facade.JogoFacade;
import jogadores.Jogador;
import jogadores.JogadorAzarado;
import singleton.Tabuleiro;

public class CasaSorte extends Casa{

	public CasaSorte(int numero) {
		super(numero);
	}

	@Override
	public void aplicarRegra(Jogador jogador, Tabuleiro tabuleiro, JogoFacade jogoFacade) {
		jogoFacade.mensagensCasas(ResultadoCasas.AZAR_SORTE_INTRO, jogador);
		
		if(jogador instanceof JogadorAzarado) {
			jogoFacade.mensagensCasas(ResultadoCasas.SORTE_NULO, jogador);
			return;
		}
		
		jogoFacade.mensagensCasas(ResultadoCasas.SORTE_OK, jogador);
		jogador.avancar();
	}

}
