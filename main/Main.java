package main;

import enums.Cor;

// main -> jogo -> tabuleiro -> jogadores e casas

import facade.JogoFacade;

public class Main {
	public static void main(String[] args) {
		JogoFacade jogo = JogoFacade.getInstance();
		jogo.iniciarJogo();
		jogo.executarJogo();
		jogo.finalizarJogo();
	}
}
