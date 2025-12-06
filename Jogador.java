package tabuleiro_refatorado;

public class Jogador {
	private String corPeca; 
	private byte tipo; 
	private byte casa;
	private int jogadas;

	public Jogador(String cor, byte tipo) {
		this.tipo = tipo;
		this.corPeca = cor;
		casa = 0;
		jogadas = 0;
	}

	public String getCorPeca() {
		return corPeca;
	}
	
	public byte getTipo() {
		return tipo;
	}
	
	public void setTipo(byte tipo) {
		this.tipo = tipo;
	}
	
	public byte getCasa() {
		return casa;
	}

	public void setCasa(byte casa) { 
		this.casa = casa; 
	}
	
	public int getJogadas() {
		return jogadas;
	}
	
	public void setJogadas(int jogadas) {
		this.jogadas = jogadas;
	}

	public String scores(String vencedorCor) {
		if (!getCorPeca().equals(vencedorCor)) {
			return "\nPeça " + getCorPeca() + Mensagens.REPETITIVOS[2] + getJogadas() + ".\nUltima casa: " + getCasa();
		} else {
			if (getCasa() == 40) {
				return "\nNOSSO VENCEDOR " + getCorPeca() + Mensagens.REPETITIVOS[2] + getJogadas() + "\nUltima casa: "
						+ getCasa();
			} else {
				return "\nNOSSO VENCEDOR " + getCorPeca() + Mensagens.REPETITIVOS[2] + getJogadas()
						+ String.format(".%nUltima casa: Foi ao infinito e alem. (%d)", getCasa());
			}
		}
	}
	
}
