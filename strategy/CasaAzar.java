package strategy;

import jogadores.Jogador;
import singleton.Tabuleiro;

public class CasaAzar extends Casa {

	public CasaAzar(int numero) {
		super(numero);
	}

	@Override
	public void aplicarRegra(Jogador jogador, Tabuleiro tabuleiro) {
		jogador.voltar();
	}

}
