package enums;

public enum TipoJogador {
	JOGADORCOMUM((byte) 1),
	JOGADORSORTUDO((byte)2),
	JOGADORAZARADO((byte)3);
	
	private final byte codigo;
	
	TipoJogador(byte codigo){
		this.codigo = codigo;
	}
	
	public byte getCodigo() {
		return codigo;
	}
	
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
