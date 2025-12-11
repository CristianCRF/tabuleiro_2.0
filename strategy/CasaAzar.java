package strategy;

import enums.ResultadoCasas;
import facade.JogoFacade;
import jogadores.Jogador;
import jogadores.JogadorSortudo;
import singleton.Tabuleiro;

public class CasaAzar extends Casa {

	public CasaAzar(int numero) {
		super(numero);
	}

	@Override
	public void aplicarRegra(Jogador jogador, Tabuleiro tabuleiro, JogoFacade jogoFacade) {
		jogoFacade.mensagensCasas(ResultadoCasas.AZAR_SORTE_INTRO, jogador);
		
		if(jogador instanceof JogadorSortudo) {
			jogoFacade.mensagensCasas(ResultadoCasas.AZAR_NULO, jogador);
			return;
		}
		
		jogoFacade.mensagensCasas(ResultadoCasas.AZAR_OK, jogador);
		jogador.voltar();
	}

}
