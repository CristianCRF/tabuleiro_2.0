package strategy;

import enums.ResultadoCasas;
import facade.JogoFacade;
import jogadores.Jogador;
import singleton.Tabuleiro;

public class CasaSimples extends Casa{
	public CasaSimples(int numero) {
		super(numero);
	}
	
	
	@Override
	public void aplicarRegra(Jogador jogador, Tabuleiro tabuleiro, JogoFacade jogoFacade) {
		jogoFacade.mensagensCasas(ResultadoCasas.SIMPLES, jogador);
		jogador.incrementaMoedas();
	}
}
