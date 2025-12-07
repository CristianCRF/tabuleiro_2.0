package jogadores;

import utils.Dados;
import enums.Cor;

public class JogadorAzarado extends Jogador{

	public JogadorAzarado(Cor cor, String corPeca) {
		super(cor, corPeca);
	}

	@Override
	protected int movimento() {
		byte resultado;
		do{
			byte d1 = Dados.lancarDado1();
			byte d2 = Dados.lancarDado2();
			resultado = (byte)(d1 + d2);
		}
		while(resultado > 6);
		return resultado;
	}
}
