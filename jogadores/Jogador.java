package jogadores;

import utils.Mensagens;
import enums.Cor;

public abstract class Jogador {
	private String corPeca; 
	private Cor cor;
	private int casa;
	private int jogadas;
	private int moedas; 

	public Jogador(Cor cor) {
		this.cor = cor;
		casa = 0;
		jogadas = 0;
		moedas = 0;
	}

	public String getCorPeca() {
		return corPeca;
	}
	
	public int getCasa() {
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
	
	public int getMoedas() {
		return moedas;
	}
	
	public void setMoedas(int moedas) {
		this.moedas = moedas;
	}
	
	protected abstract byte movimento();

	public String scores(String vencedorCor) {
		if (!getCorPeca().equals(vencedorCor)) {
			return "\nPeça " + getCorPeca() + Mensagens.REPETITIVOS[2] + getJogadas() 
			+ Mensagens.REPETITIVOS[3] + getMoedas()
			+ ".\nUltima casa: " + getCasa();
		} else {
			if (getCasa() == 40) {
				return "\nNOSSO VENCEDOR " + getCorPeca() + Mensagens.REPETITIVOS[2] + getJogadas() 
				+ Mensagens.REPETITIVOS[3] + getMoedas()
				+ "\nUltima casa: " + getCasa();
			} else {
				return "\nNOSSO VENCEDOR " + getCorPeca() + Mensagens.REPETITIVOS[2] + getJogadas()
						+ String.format(".%nUltima casa: Foi ao infinito e alem. (%d)", getCasa());
			}
		}
	}
	
}
