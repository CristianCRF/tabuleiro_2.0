package tabuleiro_refatorado;

import java.util.Random;

public class Dados { 
	protected byte dado1;
	protected byte dado2;
	protected Random rd = new Random(System.currentTimeMillis());  //usa milisegundos como seed.

	public byte getDado1() { //acho que nao usei nenhum dos dois.
		return dado1;
	}
	
	public byte getDado2() {
		return dado2;
	}
	
	public byte lancarDado1() {
		dado1 = (byte) rd.nextInt(1, 7);
		return dado1;
	}
	
	public byte lancarDado2() {
		dado2 = (byte) rd.nextInt(1, 7);
		return dado2;
	}
	
	public byte resultadoDados() {
		return (byte) (getDado1() + getDado2());
	}
	
}
