package jogadores;

import utils.Dados;

public class JogadorComun extends Jogador {

	public JogadorComun(String cor) {
		super(cor);
	}

	@Override
	protected byte movimento() {
		byte d1 = Dados.lancarDado1();
		byte d2 = Dados.lancarDado2();
		return (byte)(d1 + d2);
	}

}
