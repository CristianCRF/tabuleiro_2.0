package tabuleiro_refatorado;

public class Mensagens {
	protected static final String[] REPETITIVOS = {"\nA peça ", " avançou para a casa ", ":\nQuantidade de jogadas: "};
	
	private Jogador jogadorAtributos;
	
	public Mensagens(Jogador jogador) {
		jogadorAtributos = jogador; 
	} 
	
	public static String dadosJogados(byte d1, byte d2, byte result) {
		return "Dados lançados...\n"
				+"D1: "+d1+"  D2: "+d2
				+"\nResultado: "+result;
	}
	
	public static String dadosJogados(int d1, int d2, int result) {
		return "Dados lançados...\n"
				+"D1: "+d1+"  D2: "+d2
				+"\nResultado: "+result;
	}
	
	public String pularRodada() {
		return REPETITIVOS[0]+jogadorAtributos.getCorPeca()+REPETITIVOS[1]
				+jogadorAtributos.getCasa()+", sua proxima rodada sera pulada.";
	}
	
	public String cartas() {
		return REPETITIVOS[0]+jogadorAtributos.getCorPeca()+REPETITIVOS[1]
				+jogadorAtributos.getCasa()+" e foi comtemplado para puxar as carta!!!!\n"
				+"Escolha uma das cartas que mudaram seu tipo de jogador.\n"+
				"[1] [2] [3]";
	}
	
	public String casaDaSorte(byte tipo) {
		if(tipo == 3) {
			return REPETITIVOS[0]+jogadorAtributos.getCorPeca()+REPETITIVOS[1]
					+jogadorAtributos.getCasa()+", Porém o efeito da casa "+
					"\nfoi anulado pela sua maré de má sorte :(";
		}
		else {
			return REPETITIVOS[0]+jogadorAtributos.getCorPeca()+REPETITIVOS[1]
					+jogadorAtributos.getCasa()+" e avançou mais 3 casas!!";
		}
	}
	
	public String voltarAoInicio() {
		return "\n"+jogadorAtributos.getCorPeca()+REPETITIVOS[1]+jogadorAtributos.getCasa()
				+", um jogador de sua escolha\n"
				+"irá voltar para o inicio.";
	}
	
	public String casaMagica(byte oUltimo) {
		if(oUltimo == jogadorAtributos.getCasa()) {
			return REPETITIVOS[0]+jogadorAtributos.getCorPeca()+REPETITIVOS[1]
					+jogadorAtributos.getCasa()+".\n"
					+"Mas como este é o ultimo do tabuleiro, não terá efeito algum.";
		}
		else {
			return REPETITIVOS[0]+jogadorAtributos.getCorPeca()+REPETITIVOS[1]
					+jogadorAtributos.getCasa()+".\n"
					+"trocará de posição com o ultimo do tabuleiro.";
		}
	}
	
	public String duasVezes() { 
		return REPETITIVOS[0]+jogadorAtributos.getCorPeca()+" tirou dois dados iguais!!\n"
				+"poderá jogar esta partida mais uma vez.";
	}
	
	public String vencedorFimDeJogo() {  
		return REPETITIVOS[0]+jogadorAtributos.getCorPeca()+" chegou no fim do tabuleiro!!!!"
				+"\nVocê ganhou no melhor jogo de tabuleiro da UECE!!!!";
	}
	
	public String scores(String vencedorCor) { 
		return jogadorAtributos.scores(vencedorCor);
	}
}
