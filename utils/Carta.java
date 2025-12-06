package utils;

import java.util.Random;

public class Carta {
	private byte tirou;
	private static final Random sortes = new Random(System.currentTimeMillis());

	public byte getCarta() {
		return tirou;
	}
	
	public byte tirarCarta() {
		tirou = (byte) sortes.nextInt(1, 4);
		return tirou;
	}
	
}
