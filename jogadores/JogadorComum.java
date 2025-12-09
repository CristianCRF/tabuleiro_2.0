package jogadores;

import utils.Dados;
import enums.Cor;

public class JogadorComum extends Jogador {

	public JogadorComum(Cor cor, String corPeca) {
		super(cor, corPeca);
	}

	@Override
	protected int movimento() {
		int d1 = Dados.lancarDado1();
		int d2 = Dados.lancarDado2();
		return d1 + d2;
	}

}
