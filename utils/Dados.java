package utils;

import java.util.Random;

public class Dados { 
	private static int dado1;
	private static int dado2;
	private static final Random rd = new Random(); 

	public static int getDado1() { 
		return dado1;
	}
	
	public static int getDado2() {
		return dado2;
	}
	
	public static int lancarDado1() {
		dado1 = rd.nextInt(1, 7);
		return dado1;
	}
	
	public static int lancarDado2() {
		dado2 = rd.nextInt(1, 7);
		return dado2;
	}
	
	public static int lancarDado1(int c, int n) {
		dado1 = rd.nextInt(c, n);
		return dado1;
	}
	
	public static int lancarDado2(int c, int n) {
		dado2 = rd.nextInt(c, n);
		return dado2;
	}
	
	public static int resultadoDados() {
		return getDado1() + getDado2();
	}
	
}
