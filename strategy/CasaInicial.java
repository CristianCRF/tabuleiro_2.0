package strategy;

import facade.JogoFacade;
import jogadores.Jogador;
import singleton.Tabuleiro;

public class CasaInicial extends Casa {

	public CasaInicial(int numero) {
		super(numero);
	}

	@Override
	public void aplicarRegra(Jogador jogador, Tabuleiro tabuleiro, JogoFacade jogoFacade) {
		//esta casa não tem regras
		//existe apenas para ser o indice zer, inicio do tabuleiro E evitar usar casaSimples.
	}

}
