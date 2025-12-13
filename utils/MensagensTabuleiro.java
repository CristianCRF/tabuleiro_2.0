package utils;

import enums.TipoJogador;
import jogadores.Jogador;

public class MensagensTabuleiro {
	public static final String APECA = "\nA peça ";
	public static final String AVANCOU = " avançou para a casa ";
	public static final String QUANTJOGADAS = ":\nQuantidade de jogadas: ";
	public static final String QUANTMOEDAS = "\nMoedas adquiridas: ";
	
	public static String antesLancarDados(Jogador jogador) {
		return "A peça "+jogador.getNomeCorPeca()+" irá lançar os dados.\n"
				+"aperte ENTER para jogar...";
	}
	
	private static String repetitivo(Jogador jogador) {
	    return APECA + jogador.getNomeCorPeca() + AVANCOU + jogador.getCasa();
	}
	
	public static String msgDadosJogados(int d1, int d2, int result) {
		return "Dados lançados...\n"
				+"D1: "+d1+"  D2: "+d2
				+"\nResultado: "+result;
	}
	
	public static String msgCaiuEmCasaSimples(Jogador jogador) {
		return repetitivo(jogador)+", ganha mais uma moeda!!!";
	}
	
	public static String msgCaiuEmCasaSurpresa(Jogador jogador) {
		return repetitivo(jogador)+" e foi contemplado para puxar as cartas!!!!\n"
				+"Escolha uma das cartas que mudaram seu tipo de jogador.\n"
				+"[1] [2] [3]\n"
				+": ";
	}
	
	public static String msgTipoTrocado(Jogador jogador, TipoJogador tipo) {
		return APECA+jogador.getNomeCorPeca()+" teve tipo alterado para "+tipo;
	}
	
	public static String msgCaiuEmCasaPrisao(Jogador jogador) {
		return repetitivo(jogador)+", não jogará na proxima rodada.";
	}
	
	public static String msgFoiPulado(Jogador jogador) {
		return APECA+ jogador.getNomeCorPeca() + " teve a vez pulada!!!";
	}
	
	public static String introducaoCasaSorteAzar(Jogador jogador) { //chamado antes dos metodos.
		return repetitivo(jogador);
	}
	
	public static String msgCasaSorteEfeito() {
		return "e avançou mais 3 casas!!";
	}
	
	public static String msgCasaSorteNulo() {
		return "Porém o efeito da casa foi anulado pela sua maré de má sorte :(";
	}
	
	public static String msgCasaAzarEfeito() {
		return "e voltou 3 casas!!!";
	}
	
	public static String msgCasaAzarNulo() {
		return "Porém o efeito da casa "
				+"foi anulado pela sua maré de boas energias meu Djavan :)";
	}
	
	public static String msgCasaReversa(Jogador jogador) { 
		return repetitivo(jogador)+", irá trocar com o ultimo no tabuleiro.";
	}
	
	public static String msgCasaReversaNulo(Jogador jogador) { 
		return "mas como é o ultimo do tabuleiro, nao tera efeito.";
	}
	
	public static String msgCaiuEmCasaJogaDeNovo(Jogador jogador) { 
		return repetitivo(jogador)+" e poderá jogar esta rodada mais uma vez.";
	}
	
	public static String msgVencedorFimDeJogo(Jogador jogador) {  
		return APECA+jogador.getNomeCorPeca()+" chegou no fim do tabuleiro!!!!"
				+"\nVocê ganhou no melhor jogo de tabuleiro da UECE!!!!";
	}
	
	public static String scores(Jogador vencedor, Jogador outros, int TamanhoTabuleiro) {
		if (!outros.getNomeCorPeca().equals(vencedor.getNomeCorPeca())) {
			return "\nPeça " + outros.getNomeCorPeca() + MensagensTabuleiro.QUANTJOGADAS + outros.getJogadas() 
			+ MensagensTabuleiro.QUANTMOEDAS + outros.getMoedas()
			+ ".\nUltima casa: " + outros.getCasa();
		} else {
			if (vencedor.getCasa() == TamanhoTabuleiro) {
				return "\nNOSSO VENCEDOR " + vencedor.getNomeCorPeca() + MensagensTabuleiro.QUANTJOGADAS + 
						vencedor.getJogadas() 
				+ MensagensTabuleiro.QUANTMOEDAS + vencedor.getMoedas()
				+ "\nUltima casa: " + vencedor.getCasa();
			} else {
				return "\nNOSSO VENCEDOR " + vencedor.getNomeCorPeca() + MensagensTabuleiro.QUANTJOGADAS + 
						vencedor.getJogadas()
						+ MensagensTabuleiro.QUANTMOEDAS + outros.getMoedas()
						+ String.format(".%nUltima casa: Foi ao infinito e alem. (%d)", vencedor.getCasa());
			}
		}
	}
}
