package factory;

import enums.Cor;
import enums.TipoJogador;
import jogadores.*;

public class JogadorFactory {
	public static Jogador criarJogador(TipoJogador tipo, Cor cor, String corPeca) {

        switch (tipo) {
            case JOGADORCOMUM:
                return new JogadorComum(cor, corPeca);
            case JOGADORSORTUDO:
                return new JogadorSortudo(cor, corPeca);
            case JOGADORAZARADO:
            	return new JogadorAzarado(cor, corPeca);   
            default:
            	return new JogadorComum(cor, corPeca);
        }
    }
}
