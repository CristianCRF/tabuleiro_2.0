package enums;

public enum TipoJogador {
	JOGADORCOMUM,
	JOGADORSORTUDO,
	JOGADORAZARADO;
	
	public static TipoJogador fromCodigo(byte c) {
		switch(c) {
			case 1:
				return JOGADORCOMUM;
			case 2:
				return JOGADORSORTUDO;
			case 3:
				return JOGADORAZARADO;
			default:
				throw new IllegalArgumentException("Código de tipo inválido: " + c);
		}
	}
}
