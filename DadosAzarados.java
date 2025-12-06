package tabuleiro_refatorado;

public class DadosAzarados extends Dados{
	@Override
	public byte lancarDado1() {
		dado1 = (byte) rd.nextInt(1, 4);
		return dado1;
	}
	
	@Override
	public byte lancarDado2() {
		dado2 = (byte) rd.nextInt(1, 4);
		return dado2;
	}
}
