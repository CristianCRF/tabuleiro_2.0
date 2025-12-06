package strategy;

import jogadores.Jogador;
import jogadores.JogadorAzarado;
import jogadores.JogadorComun;
import jogadores.JogadorSortudo;
import utils.Carta;

public class CasaCartas extends Casa {
	private Carta cartas[] = new Carta[3];
	
	public CasaCartas(Jogador jogador) {
		this.jogador = jogador;
	}
	
	private void gerarCartas() {
		for(int i=0; i<cartas.length;i++) {
			cartas[i].tirarCarta();
		}
	}
	
	/*public Jogador puxarCartas(byte tipo) {
		gerarCartas();
		if(tipo == 1) {
			return new JogadorComun();
		}
		else if(tipo == 2) {
			return new JogadorAzarado();
		}
		else {
			return new JogadorSortudo();
		}
	}*/

	@Override
	public void aplicarRegra() {
	}	
}
