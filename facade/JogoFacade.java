package facade;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

import enums.*;
import jogadores.Jogador;
import utils.*;

public class JogoFacade {
	Map<TipoCasa, List<Integer>> config = new HashMap<>();
	
	public void criarJogadores() {

	    int quantidade = escolherQuantidadeJogadores(); // 2 a 6

	    for (int i = 0; i < quantidade; i++) {

	        Cor cor = ORDEM_CORES[i];
	        String peca = cor.name(); // ou um nome personalizado

	        System.out.println("Escolha o tipo da peça " + cor.name() + ":");
	        int tipo = escolherTipo(); // 1, 2, 3

	        Jogador jogador = JogadorFactory.criarJogador(
	            TipoJogador.fromCodigo(tipo),
	            cor,
	            peca
	        );

	        tabuleiro.addJogador(jogador);
	    }
	}
}