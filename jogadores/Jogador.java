package jogadores;

import utils.Mensagens;
import enums.Cor;

public abstract class Jogador {
	private String corPeca; 
	private Cor cor;
	private int casa;
	private int jogadas;
	private int moedas; 
	private boolean preso;

	public Jogador(Cor cor, String corPeca) {
		this.corPeca = corPeca;
		this.cor = cor;
		casa = 0;
		jogadas = 0;
		moedas = 0;
		preso = false;
	}
	
	public String getCorPeca() {
		return corPeca;
	}

	public Cor getCor() {
		return cor;
	}
	
	public int getCasa() {
		return casa;
	}

	public void setCasa(int casa) { 
		this.casa = casa; 
	}
	
	public void avancar() {
       this.casa += 3;
    }

    public void voltar() {
       this.casa -= 3;
    }
	
	public int getJogadas() {
		return jogadas;
	}
	
	public void setJogadas(int jogadas) {
		this.jogadas = jogadas;
	}
	
	public void incrementaJogadas() {
		this.jogadas++;
	}
	
	public int getMoedas() {
		return moedas;
	}
	
	public void setMoedas(int moedas) {
		this.moedas = moedas;
	}
	
	public void incrementaMoedas() {
		this.moedas += 1;
	}
	
	public boolean preso() {
        return preso;
    }

    public void setPreso(boolean preso) {
        this.preso = preso;
    }

	
	protected abstract int movimento();

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
