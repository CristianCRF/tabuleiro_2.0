package tabuleiro_refatorado;

public class DadosSortudo extends Dados{
	@Override
	public byte lancarDado1() {
		dado1 = (byte) rd.nextInt(4, 7);
		return dado1;
	}
	
	@Override
	public byte lancarDado2() {
		dado2 = (byte) rd.nextInt(3, 7);
		return dado2;
	}
}
