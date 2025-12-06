package tabuleiro_refatorado;

import java.util.Random;

public class Carta {
	private byte tirou;
	private Random sortes = new Random(System.currentTimeMillis());

	public byte getCarta() {
		return tirou;
	}
	
	public void tirarCarta() {
		tirou = (byte) sortes.nextInt(1, 4);
	}
	
}
