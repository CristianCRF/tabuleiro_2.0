package jogadores;

import utils.Dados;
import enums.Cor;


public class JogadorSortudo extends Jogador{
	public JogadorSortudo(Cor cor) {
		super(cor);
	}

	@Override
	protected byte movimento() {
		byte resultado;
		do{
			byte d1 = Dados.lancarDado1();
			byte d2 = Dados.lancarDado2();
			resultado = (byte)(d1 + d2);
		}
		while(resultado < 7);
		return resultado;
	}
}
