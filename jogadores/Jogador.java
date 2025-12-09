package jogadores;

import enums.Cor;

public abstract class Jogador {
	private String nomeCorPeca; 
	private Cor cor;
	private int casa;
	private int jogadas;
	private int moedas; 
	private boolean preso;
	private boolean jogarDenovo;

	public Jogador(Cor cor, String nomeCorPeca) {
		this.nomeCorPeca = nomeCorPeca;
		this.cor = cor;
		casa = 0;
		jogadas = 0;
		moedas = 0;
		preso = false;
		jogarDenovo = false;
	}
	
	public String getNomeCorPeca() {
		return nomeCorPeca;
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
	
	public boolean getEstadoPreso() {
        return preso;
    }

    public void setEstadoPreso(boolean preso) {
        this.preso = preso;
    }
    
    public boolean getEstadoDeJogarDenovo() {
        return jogarDenovo;
    }

    public void setEstadoDeJogarDenovo(boolean jogarDenovo) {
        this.jogarDenovo = jogarDenovo;
    }
	
	public void avancar() {
       casa += 3;
    }

    public void voltar() {
       casa -= 3;
    }
	
	public void incrementaJogadas() {
		jogadas++;
	}
	
	public void incrementaMoedas() {
		moedas += 1;
	}
	
	protected abstract int movimento();
	
}
