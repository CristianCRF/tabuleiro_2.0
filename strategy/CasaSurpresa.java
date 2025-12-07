package strategy;

import enums.TipoJogador;
import facade.JogoFacade;
import factory.JogadorFactory;
import jogadores.*;
import singleton.Tabuleiro;
import utils.Carta;

public class CasaSurpresa extends Casa {
	private Carta cartas[] = new Carta[3];
	
	public CasaSurpresa(int numero) {
		super(numero);
		gerarCartas();
	}
	
	private void gerarCartas() {
		for(int i=0; i<cartas.length;i++) {
			cartas[i] = new Carta();
		}
	}
	
	private TipoJogador sortearCartas(byte escolha) {
		byte valor = cartas[escolha].tirarCarta();
		return TipoJogador.fromCodigo(valor);
	}

	@Override
	public void aplicarRegra(Jogador jogador, Tabuleiro tabuleiro) {
		byte escolha = JogoFacade.getInstance().escolherCarta(jogador); //uma ideia de como chamar do facade.
		TipoJogador tipo = sortearCartas((byte)(escolha-1));
		Jogador novo = JogadorFactory.criarJogador(tipo, jogador.getCor(), jogador.getCorPeca());
		novo.setCasa(jogador.getCasa());
		novo.setMoedas(jogador.getMoedas());
		novo.setJogadas(jogador.getJogadas());
		
		
		tabuleiro.substituirJogador(novo, jogador);
	}	
}
