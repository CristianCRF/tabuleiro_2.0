package utils;

import enums.Cor;
import enums.TipoCasa;

public class MensagensGeral {
	public static final String LIMPARTELA = "\n".repeat(9);
	public static final String ESPACOMAIOR = "\n".repeat(4);
	
	public static String msgBoasVindas() {
		return "Bem vindo:\ndeseja jogar:\n"
			+"1-Jogo principal\n"
			+"2-Modo debug\n"
			+"0-Sair\n"
			+": ";
	}
	
	public static String msgConfigurarTamanhoTabuleiro() {
		return "Digite o tamanho do tabuleiro (min: 10  max:100)\n"
			+": ";
	}
	
	public static String msgConfigurarCasas(TipoCasa casa) {
		return "Digite quais casas serão "+ casa+".\n"
				+"ex: 3 5 8"
				+": ";
	}
	
	public static String msgConfigurarQuantidadeJogadores() {
		return "quantas peças serão usadas? maximo de 6 peças.\n: ";
	}
	
	public static String msgConfigurarTipoJogadores() {
		return "digite o tipo de jogador que será usado:";
	}
	
	public static String msgEscolherTiposJogadores(int index) {
		return "digite qual tipo da peça "+Cor.values()[index]
			+".\n1-Normal: sem modificação.\n"
			+"2-Sortudo: soma de dados sempre igual ou maior que 7.\n"
			+"3-Azarado: soma de dados sempre igual ou menor que 6.\n"
			+": ";
	}
	
	public static String msgTipoInvalido() {
		return "valor digitado invalido, tipo alterado para normal.";
	}
	
	public static String msgOpcaoInvalida() {
		return "Opção invalida, digite novamente: ";
	}
	
	public static String msgValorInvalido() {
		return "O valor digitado é invalido, digite novamente: ";
	}
	
	public static String msgContinuar() {
		return "aperte ENTER para continuar...";
	}
	
	public static String msgSairMenu() {
		return "aff veyrr, ate a proxima então:)";
	}
	
	public static String msgFinal() {
		return "THANK YOU FOR PLAYING MY SILLY GAME UWU!!!";
	}
}
