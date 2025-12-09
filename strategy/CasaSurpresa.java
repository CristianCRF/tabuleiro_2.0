package strategy;

import enums.TipoJogador;
import facade.JogoFacade;
import factory.JogadorFactory;
import jogadores.*;
import singleton.Tabuleiro;
import utils.Carta;

public class CasaSurpresa extends Casa {
	private Carta cartas[] = new Carta[3];
	private int escolha;
	
	public CasaSurpresa(int numero) {
		super(numero);
		gerarCartas();
	}
	
	private void gerarCartas() {
		for(int i=0; i<cartas.length;i++) {
			cartas[i] = new Carta();
		}
	}
	
	private TipoJogador sortearCartas(int escolha) {
		byte valor = cartas[escolha].tirarCarta();
		return TipoJogador.fromCodigo(valor);
	}
	
	public void escolherCarta(int escolha) {
		this.escolha = escolha;
	}

	@Override
	public void aplicarRegra(Jogador jogador, Tabuleiro tabuleiro) {
		TipoJogador tipo = sortearCartas((escolha-1));
		Jogador novo = JogadorFactory.criarJogador(tipo, jogador.getCor(), jogador.getNomeCorPeca());
		novo.setCasa(jogador.getCasa());
		novo.setMoedas(jogador.getMoedas());
		novo.setJogadas(jogador.getJogadas());
		
		
		tabuleiro.substituirJogador(jogador, novo);
	}	
}
