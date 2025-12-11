package view;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jogadores.Jogador;
import singleton.Tabuleiro;


//essa classe existe unicamente para nao usar facade
//para printar o tabuleiro toda hora.
public class PrintaTabuleiro {
	public static void imprimir(Tabuleiro tabuleiro) {
		List<Jogador> jogadores = tabuleiro.getJogadores();
		int tamanhoTabuleiro = tabuleiro.getTamanho();
		Set<Integer> excludedValues = new HashSet<>(Arrays.asList(21, 41, 61, 81)); //so para deixar mais limpo o tabuleiro
		
	    for (int i = 0; i <= tamanhoTabuleiro; i++) {
	    	StringBuilder conteudo = new StringBuilder();
	    	conteudo.append(i); // sempre mostra o número da casa primeiro
	    	for (Jogador j : jogadores) {
	    		if (j.getCasa() == i) {
	    			conteudo.append("-").append(j.getNomeCorPeca());
	    		}
	    	}
	    	
	    	if (excludedValues.contains(i)) {//pula para quebrar linha
	    	    System.out.println();
	    	}
	    	System.out.print("[" + conteudo + "]");
	    }

	    	System.out.println();
	}
}
