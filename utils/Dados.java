package utils;

import java.util.Random;

public class Dados { 
	private static byte dado1;
	private static byte dado2;
	private static final Random rd = new Random(System.currentTimeMillis()); 

	public static byte getDado1() { 
		return dado1;
	}
	
	public static byte getDado2() {
		return dado2;
	}
	
	public static byte lancarDado1() {
		dado1 = (byte) rd.nextInt(1, 7);
		return dado1;
	}
	
	public static byte lancarDado2() {
		dado2 = (byte) rd.nextInt(1, 7);
		return dado2;
	}
	
	public static byte resultadoDados() {
		return (byte) (getDado1() + getDado2());
	}
	
}
