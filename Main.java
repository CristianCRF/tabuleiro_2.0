package tabuleiro_refatorado;

import java.util.Locale;
import java.util.Scanner;

public class Main {
	protected static final String[] REPETITIVOS = {"\n\n\n\n\n\n\n\n\n", "aperte enter para prosseguir...", "aperte enter para finalizar..."};
	protected static final String[] cores = {"BRANCA", "AZUL", "VERMELHA", "MARROM", "VERDE", "ROSA"};
	
	public static void main(String[] args){
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		Jogador[] jogador = null;
	
		System.out.println("Bem vindo:\ndeseja jogar: ");
		System.out.println("1-Jogo principal");
		System.out.println("2-Modo debug");
		System.out.println("0-Sair");
		System.out.print(": ");
		int menu = sc.nextInt();
		
		while(menu < 0 || menu > 2) {
			System.out.print("opção invalida!! digite novamente\n: ");
			menu = sc.nextInt();
		}
		
		if(menu == 1) {
			System.out.print("\n\n\n\n\nquantas peças serão usadas? maximo de 6 peças.\n: ");
			byte size = sc.nextByte();
			
			while(size < 0 || size > 7) {
				System.out.print("quantidade invalida!! digite novamente\n: ");
				size = sc.nextByte();
			}
	
			jogador = new Jogador[size];
			System.out.println("\n\n\n\n\n\ndigite o tipo de dado será usado?");
			setarTipoDeJogador(jogador, sc);
			Mensagens mensagens = null;
			Jogador vencedor = null;
			
			vencedor = jogoPrincipal(jogador, sc);
			
			for(int i=0; i<jogador.length;i++) {
				mensagens = new Mensagens(jogador[i]);
				if(vencedor != jogador[i]) {
					System.out.println(mensagens.scores(vencedor.getCorPeca()));
					System.out.println("\nprosseguir...");
					sc.nextLine();
				}
			}
			
			mensagens = new Mensagens(vencedor);
			System.out.println(mensagens.scores(vencedor.getCorPeca()));
			System.out.println("\nTHANK YOU FOR PLAYING MY SILLY GAME UwU...");
			
			//creditos: hideo kojima.
			sc.close();
		}
		else if(menu == 2) {
			System.out.print("\n\n\n\n\nquantas peças serão usadas? maximo de 6 peças.\n: ");
			byte size = sc.nextByte();
			sc.nextLine();
			if(size < 7 && size > 0) {
				jogador = new Jogador[size];
			}
			else {
				System.out.println("quantidade de peças digitada errada, alterado para um.");
				jogador = new Jogador[1];
				sc.nextLine();
			}

			System.out.println("\n\n\n\n\n\ndigite o tipo de dado será usado?");
			setarTipoDeJogador(jogador, sc);
			
			Mensagens mensagens = null;
			Jogador vencedor = null;
			
			vencedor = debugMode(jogador, sc);
			
			for(int i=0; i<jogador.length;i++) {
				mensagens = new Mensagens(jogador[i]);
				if(vencedor != jogador[i]) {
					System.out.println(mensagens.scores(vencedor.getCorPeca()));
					System.out.println("\nprosseguir...");
					sc.nextLine();
				}
			}
			
			mensagens = new Mensagens(vencedor);
			System.out.println(mensagens.scores(vencedor.getCorPeca()));
			System.out.println("\nTHANK YOU FOR PLAYING MY MANLY GAME ÙWÚ...");
			
			//creditos: Stallone.
			sc.close();
		}
		else if(menu == 0){System.out.println("\n\n\n\n\nPORQUE TAO CEDO??? :(\nThank you for playing!!!");}
	}
	
	public static Jogador jogoPrincipal(Jogador[] jogador, Scanner sc) {
		Mensagens mensagens = null;
		Jogador vencedor = null;
		boolean doisDadosIguais = false;
		Dados dados = null;
		int rodadas = 1; 
		Integer[] pulaJogadores = new Integer [jogador.length]; //pulaJogadores: armazenar para pular vez.
		
		for(int vezJogador=0; ;) { //FOR PRINCIPAL DO JOGO.
			vezJogador = checarSeCaiuDoisDadosIguais(pulaJogadores, vezJogador, 
					jogador, doisDadosIguais, sc);
			
			doisDadosIguais = false;
			mensagens = new Mensagens(jogador[vezJogador]);
			
			String[] casas = new String[41];
			casas = montarTabuleiroComPecas(casas, jogador);
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nRODADA: "+rodadas+"\nTABULEIRO:");
			printarTabuleiro(casas);
			
			switch(jogador[vezJogador].getTipo()) {
				case 1: {
					dados = new Dados();
					break;
				}
				case 2:	{
					dados = new DadosSortudo();
					break;
				}
				case 3: {
					dados = new DadosAzarados();
					break;
				}
				default: //switch para satisfazer parametros SonarQube.
					throw new IllegalStateException("Tipo de jogador inválido: "
							+ jogador[vezJogador].getTipo()); //nunca chegará, mais é bom deixar.
			}
			
			System.out.println("\nPeça "+jogador[vezJogador].getCorPeca()+" irá lançar os dados.");
			System.out.println("aperte enter para jogar...");
			sc.nextLine();
			byte d1 = dados.lancarDado1();
			byte d2 = dados.lancarDado2();
			byte res = dados.resultadoDados();
			
			System.out.println(Mensagens.dadosJogados(d1, d2, res));
			
			byte casaCaiuEm = (byte) (jogador[vezJogador].getCasa() + res); 
			jogador[vezJogador].setCasa(casaCaiuEm);
			
			if(jogador[vezJogador].getCasa() < 40) {
				casas = montarTabuleiroComPecas(casas, jogador);
				System.out.println("\n\nTABULEIRO:");
				printarTabuleiro(casas);
				System.out.println();
			}
			else {
				int jogou = jogador[vezJogador].getJogadas() + 1;
				jogador[vezJogador].setJogadas(jogou);
				vencedor = jogador[vezJogador];
				break;
			}
			
			switch(casaCaiuEm) { //logica das consequencias.
				case 10, 25,38: 
					consequenciaPularVez(pulaJogadores, vezJogador, mensagens);
					sc.nextLine();
					break;
					
				case 20, 35:
					consequenciasCasaMagica(jogador, vezJogador, mensagens);
					sc.nextLine();
					break;
					
				case 5, 15, 30:
					consequenciaCasaDaSorte(jogador, vezJogador, mensagens);
					sc.nextLine();
					break;
					
				case 17, 27:
					consequenciaVoltarAoInicio(jogador, vezJogador, mensagens, sc);
					break;
					
				case 13: {
					consequenciaCartas(jogador, vezJogador, mensagens, sc);
					break;
				}
				
				default: //switch para satisfazer parametros.
					break;
			}
			doisDadosIguais = setarEstadoDadosIguais(d1,d2, jogador, vezJogador, 
					doisDadosIguais, mensagens);
			if(!doisDadosIguais){
				rodadas = encerrarRodada(jogador, vezJogador, rodadas);
				vezJogador = mudarVezJogador(vezJogador, jogador);
			}
			sc.nextLine();
		}
		
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\nBATEU BATEU BATEU PODE COMEMORAAAAAAAAAAAAAR!!!!!!!!");
		System.out.println(mensagens.vencedorFimDeJogo());
		System.out.println("prosseguir...");
		sc.nextLine();
		return vencedor;
	}
	
	public static Jogador debugMode(Jogador[] jogador, Scanner sc){
		Mensagens mensagens = null;
		Jogador vencedor = null;
		boolean doisDadosIguais = false;
		int rodadas = 1; 
		Integer[] pulaJogadores = new Integer [jogador.length]; //pulaJogadores: armazenar para pular vez.
		
		for(int vezJogador=0; ;) { //FOR PRINCIPAL DO JOGO.
			vezJogador = checarSeCaiuDoisDadosIguais(pulaJogadores, vezJogador, 
					jogador, doisDadosIguais, sc);
			
			doisDadosIguais = false;
			mensagens = new Mensagens(jogador[vezJogador]);
			
			String[] casas = new String[41];
			casas = montarTabuleiroComPecas(casas, jogador);
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nRODADA: "+rodadas+"\nTABULEIRO:");
			printarTabuleiro(casas);
			
			System.out.println("\n"+jogador[vezJogador].getCorPeca()+
					":\nDigite os valores dos dados.");
			System.out.println("D1:  D2:");
			int d1 = sc.nextByte();
			int d2 = sc.nextByte();
			int res =  d1+d2;
			sc.nextLine();
			
			System.out.println(Mensagens.dadosJogados(d1, d2, res));
			
			byte casaCaiuEm = (byte) (jogador[vezJogador].getCasa() + res); 
			jogador[vezJogador].setCasa(casaCaiuEm);
			
			if(jogador[vezJogador].getCasa() < 40) {
				montarTabuleiroComPecas(casas, jogador);
				System.out.println("\n\nTABULEIRO:");
				printarTabuleiro(casas);
				System.out.println();
			}
			else {
				int jogou = jogador[vezJogador].getJogadas() + 1;
				jogador[vezJogador].setJogadas(jogou);
				vencedor = jogador[vezJogador];
				break;
			}
			
			switch(casaCaiuEm) { //logica das consequencias.
				case 10, 25, 38: 
					consequenciaPularVez(pulaJogadores, vezJogador, mensagens);
					sc.nextLine();
					break;
					
				case 20, 35:
					consequenciasCasaMagica(jogador, vezJogador, mensagens);
					sc.nextLine();
					break;
					
				case 5, 15, 30:
					consequenciaCasaDaSorte(jogador, vezJogador, mensagens);
					sc.nextLine();
					break;
					
				case 17, 27:
					consequenciaVoltarAoInicio(jogador, vezJogador, mensagens, sc);
					break;
					
				case 13: {
					consequenciaCartas(jogador, vezJogador, mensagens, sc);
					break;
				}
				
				default: //switch para satisfazer parametros SonarQube.
					break;
			}
			
			doisDadosIguais = setarEstadoDadosIguais((byte)d1, (byte)d2, jogador, vezJogador, 
					doisDadosIguais, mensagens);
			if(!doisDadosIguais){
				rodadas = encerrarRodada(jogador, vezJogador, rodadas);
				vezJogador = mudarVezJogador(vezJogador, jogador);
			}
			sc.nextLine();
		}
		
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\nBATEU BATEU BATEU PODE COMEMORAAAAAAAAAAAAAR!!!!!!!!");
		System.out.println(mensagens.vencedorFimDeJogo());
		System.out.println("prosseguir...");
		sc.nextLine();
		return vencedor;
	}
	
	public static int checarSeCaiuDoisDadosIguais(Integer[] pulaJogadores, int vezJogador,
			Jogador[] jogador, boolean doisDadosIguais, Scanner sc) {
		if(pulaJogadores[vezJogador] != null && !doisDadosIguais) {
			System.out.println("\n!!!!Vez da peça "+jogador[vezJogador].getCorPeca()+" pulada!!!!");
			System.out.println(REPETITIVOS[1]);
			sc.nextLine();
			pulaJogadores[vezJogador] = null;
			
			if(vezJogador == jogador.length - 1) {vezJogador = 0;}
			else {vezJogador++;}
			
		}
		return vezJogador;
	}
	
	public static void setarTipoDeJogador(Jogador[] jogador, Scanner sc){
		for(int i=0; i<jogador.length; i++) {
			System.out.println("1-Normal: sem modificação.");
			System.out.println("2-Sortudo: soma de dados sempre igual ou maior que 7.");
			System.out.println("3-Azarado: soma de dados sempre igual ou menor que 6.");
			System.out.print(cores[i]+": ");
			byte tipo = sc.nextByte();
			sc.nextLine();
			
			if(tipo > 0 && tipo < 4){
				jogador[i] = new Jogador(cores[i], tipo);
				System.out.println(REPETITIVOS[0]);
			}
			else {
				System.out.println("\n\n\n\n\n\n\n\n\nvalor digitado invalido, tipo alterado para normal.");
				System.out.println("aperte enter para continuar...");
				sc.nextLine();
				jogador[i] = new Jogador(cores[i], (byte) 1);
				System.out.println(REPETITIVOS[0]);
			}	
		}
	}
	
	public static String[] montarTabuleiroComPecas(String[] casas, Jogador[] jogador) {
		for(int i=0; i<casas.length;i++) {
			casas[i] = String.valueOf(i);
		}
		for (Jogador j : jogador) {
            int pos = j.getCasa();
            casas[pos] += "-" + j.getCorPeca();
        }
		return casas;
	}
	
	public static void printarTabuleiro(String[] casas) {
		for(int i=0;i<casas.length;i++) {
			if(i != 21) {
				System.out.printf("[%s]", casas[i]);
			}
			else {
				System.out.println();
				System.out.printf("[%s]", casas[i]);
			}
		}
	}
	
	public static void consequenciaPularVez(Integer[] pulaJogadores, int vezJogador, Mensagens mensagens) {
		System.out.println(mensagens.pularRodada());
		System.out.println(REPETITIVOS[1]);
		pulaJogadores[vezJogador] = vezJogador;
	}
	
	public static void consequenciasCasaMagica(Jogador[] jogador, int vezJogador, Mensagens mensagens) {
		byte oUltimo = jogador[vezJogador].getCasa();
		for(Jogador obj:jogador) {
			if(oUltimo > obj.getCasa()) {
				oUltimo = obj.getCasa();
			}
		}
		
		System.out.println(mensagens.casaMagica(oUltimo));
		System.out.println(REPETITIVOS[1]);
		
		if(oUltimo != jogador[vezJogador].getCasa()) {
			for(int j=0; j<jogador.length;j++) {
				if(oUltimo == jogador[j].getCasa()) {
					byte bubble = jogador[vezJogador].getCasa();
					jogador[j].setCasa(bubble);
					jogador[vezJogador].setCasa(oUltimo);
					break;
				}
			}
		}
	}
	
	public static void consequenciaCasaDaSorte(Jogador[] jogador, int vezJogador, Mensagens mensagens) {
		byte tipo = jogador[vezJogador].getTipo();
		System.out.println(mensagens.casaDaSorte(tipo));
		System.out.println(REPETITIVOS[1]);
		if(tipo != 3) {
			byte avanco = (byte) (jogador[vezJogador].getCasa() + 3);
			jogador[vezJogador].setCasa(avanco);
		}
	}
	
	public static void consequenciaVoltarAoInicio(Jogador[] jogador, int vezJogador, Mensagens mensagens, Scanner sc) {
		System.out.println(mensagens.voltarAoInicio());
		if(jogador.length > 1) {
			byte count = 1;
			for(Jogador obj:jogador) {
				if(!jogador[vezJogador].getCorPeca().equals(obj.getCorPeca())) {
					System.out.println(obj.getCorPeca()+"-"+count);
				}
				count++;
			}
			System.out.print(":-> ");
			byte escolhido = sc.nextByte();
			sc.nextLine();
			if(escolhido <= jogador.length && escolhido > 0 && escolhido-1 != vezJogador) {
				jogador[escolhido-1].setCasa((byte) 0);
				System.out.println("Peça "+jogador[escolhido-1].getCorPeca()+" voltará"
						+ " para o inicio (;_;)");
				System.out.println(REPETITIVOS[1]);
			}
			else {
				System.out.println("Ou você é fair-player ou apertou errado :()");
				System.out.println(REPETITIVOS[1]);
			}
			sc.nextLine();
		}
		else {
			System.out.println("Mas como só tem voce aqui, essa casa"
					+ " não terá nenhum efeito.");
		}
	}
	
	public static void consequenciaCartas(Jogador[] jogador, int vezJogador, Mensagens mensagens, Scanner sc) {
		Carta[] cartas = new Carta[3];
		for(int i=0; i<3; i++) {
			cartas[i] = new Carta();
			cartas[i].tirarCarta();
		}
		String[] tipos = {"NORMAL", "SORTUDO", "AZARADO"};
		System.out.println(mensagens.cartas());
		
		byte trocaTipo = trocarTipo(jogador, cartas, vezJogador, sc);
		System.out.println("Tipo da peça "+
		jogador[vezJogador].getCorPeca()+" trocado para "+tipos[trocaTipo-1]);
	}
	
	public static byte trocarTipo(Jogador[] jogador, Carta[] cartas, int vezJogador, Scanner sc) {
		byte escolha, trocaTipo = 0;
		boolean flag = false;
		while(!flag) {
			System.out.print(":-> ");
			escolha = sc.nextByte();
			sc.nextLine();
			switch(escolha) {
				case 1: {
					trocaTipo = cartas[0].getCarta();
					jogador[vezJogador].setTipo(trocaTipo);
					flag = !flag;
					break;
				}
				case 2: {
					trocaTipo = cartas[1].getCarta();
					jogador[vezJogador].setTipo(trocaTipo);
					flag = !flag;
					break;
				}
				case 3:{
					trocaTipo = cartas[2].getCarta();
					jogador[vezJogador].setTipo(trocaTipo);
					flag = !flag;
					break;
				}
				default: {
					System.out.println("não fuja do destino, escolha uma carta.");
					break;
				}
			}
		}
		return trocaTipo;
	}
	
	public static boolean setarEstadoDadosIguais(byte d1, byte d2, Jogador[] jogador,
			int vezJogador, boolean doisDadosIguais, Mensagens mensagens) {
		if(d1 == d2) {
			doisDadosIguais = !doisDadosIguais;
			int jogou = jogador[vezJogador].getJogadas() + 1;
			jogador[vezJogador].setJogadas(jogou);
			System.out.println(mensagens.duasVezes());
			System.out.println(REPETITIVOS[2]);
		}
		return doisDadosIguais;
	}
	
	public static int encerrarRodada(Jogador[] jogador, int vezJogador, int rodadas) {
		int jogou = jogador[vezJogador].getJogadas() + 1;
		jogador[vezJogador].setJogadas(jogou);
		rodadas += 1;
		System.out.println(REPETITIVOS[2]);
		return rodadas;
	}
	
	public static int mudarVezJogador(int vezJogador, Jogador[] jogador) {
		if(vezJogador == jogador.length - 1) {vezJogador = 0;}
		else {vezJogador++;}
		return vezJogador;
	}
}