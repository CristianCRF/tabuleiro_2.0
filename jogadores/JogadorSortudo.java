package jogadores;

import utils.Dados;
import enums.Cor;


public class JogadorSortudo extends Jogador{
	public JogadorSortudo(Cor cor, String corPeca) {
		super(cor, corPeca);
	}

	@Override
	protected int movimento() {
		int resultado;
		do{
			int d1 = Dados.lancarDado1();
			int d2 = Dados.lancarDado2();
			resultado = (byte)(d1 + d2);
		}
		while(resultado < 7);
		return resultado;
	}
}
