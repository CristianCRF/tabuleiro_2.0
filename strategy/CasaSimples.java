package strategy;

import jogadores.Jogador;

public class CasaSimples extends Casa{
	public CasaSimples(Jogador jogador, int numero) {
		this.jogador = jogador;
		this.numero = numero;
	}
	
	@Override
	public void aplicarRegra() {
		int moedas = jogador.getMoedas() + 1;
	}
}
