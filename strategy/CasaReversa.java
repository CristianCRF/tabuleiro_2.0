package strategy;

import enums.ResultadoCasas;
import facade.JogoFacade;
import jogadores.Jogador;
import singleton.Tabuleiro;

public class CasaReversa extends Casa {

	public CasaReversa(int numero) {
		super(numero);
	}

	@Override
	public void aplicarRegra(Jogador jogador, Tabuleiro tabuleiro, JogoFacade jogoFacade) {
		jogoFacade.mensagensCasas(ResultadoCasas.REVERSA, jogador);
		Jogador ultimo = tabuleiro.getUltimoJogador();
		
		if(ultimo.getCasa() == jogador.getCasa()) {
			jogoFacade.mensagensCasas(ResultadoCasas.REVERSA_NULO, jogador);
			return;
		}

        int posAtual = jogador.getCasa();
        int posUltimo = ultimo.getCasa();

        jogador.setCasa(posUltimo);
        ultimo.setCasa(posAtual);
	}
}
