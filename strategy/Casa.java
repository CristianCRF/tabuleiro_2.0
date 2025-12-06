package strategy;

import jogadores.Jogador;

abstract class Casa {
	protected Jogador jogador;
	protected int numero;
	
	public abstract void aplicarRegra();
}
