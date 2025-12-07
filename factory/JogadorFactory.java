package factory;

import enums.Cor;
import jogadores.*;

public class JogadorFactory {
    public static Jogador criarJogador(int tipo, int codigoCor) {
        Cor corSelecionada;
        switch (codigoCor) {
            case 1: corSelecionada = Cor.VERMELHO; break;
            case 2: corSelecionada = Cor.AZUL; break;
            case 3: corSelecionada = Cor.AMARELO; break;
            case 4: corSelecionada = Cor.VERDE; break;
            default: corSelecionada = Cor.VERMELHO;break;
        }

        switch (tipo) {
            case 2: return new JogadorAzarado(corSelecionada);
            case 3: return new JogadorSortudo(corSelecionada);
            default: return new JogadorComun(corSelecionada);
        }
    }
}
