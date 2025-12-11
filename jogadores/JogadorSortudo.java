package jogadores;

import utils.Dados;
import enums.Cor;


public class JogadorSortudo extends Jogador{
	public JogadorSortudo(Cor cor, String corPeca) {
		super(cor, corPeca);
	}

	@Override
	public int movimento() {
		int resultado;
		do{
			int d1 = Dados.lancarDado1(4, 6);
			int d2 = Dados.lancarDado2(3, 6);
			resultado = (byte)(d1 + d2);
		}
		while(resultado < 7);
		return resultado;
	}
}
