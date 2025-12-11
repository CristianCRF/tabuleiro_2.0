package facade;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import enums.*;
import factory.JogadorFactory;
import jogadores.Jogador;
import singleton.Tabuleiro;
import utils.*;
import view.PrintaTabuleiro;

public class JogoFacade {
	Scanner sc = new Scanner(System.in);
	Map<TipoCasa, List<Integer>> config = new HashMap<>();
    private static JogoFacade instancia;
    private Tabuleiro tabuleiro;
    private int tamanhoTabuleiro;
    private boolean modoDebug = false;
    private Jogador jogadorAtual, jogadorVencedor;
    private int ultimoResultadoDados;

    private JogoFacade() { }

    public static JogoFacade getInstance() {
        if (instancia == null) {
            instancia = new JogoFacade();
        }
        return instancia;
    }
    
    public void iniciarJogo() {
        menu();
        configurarTabuleiro();
        criarTabuleiro();
        configurarEAddPecas();
    }
    
    public void executarJogo() {
    	while (jogadorVencedor == null) {
    		tabuleiro.incrementaRodadas();
    		System.out.println("Rodada "+tabuleiro.getRodadas());
    		
            for (Jogador jogador : tabuleiro.getJogadores()) {
                jogadorAtual = jogador;

                if (jogadorAtual.getEstadoPreso()) {
                    jogadorAtual.setEstadoPreso(false);
                    System.out.println(MensagensTabuleiro.msgFoiPulado(jogadorAtual));
                    continue;
                }

                boolean continua = true;

                while (continua) {
                    iniciarRodadas();
                    fazJogadas(); // executarTurno(), movimento(), aplicarCasa().
                    jogadorAtual.incrementaJogadas();
                    if (jogadorVencedor != null) {return;}
                    continua = jogadorAtual.getEstadoDeJogarDenovo();
                }
                
                finalizarTurno();
            }
        }
    }
	
	private void finalizarTurno() {
		System.out.println("resultados finais: ");
		PrintaTabuleiro.imprimir(tabuleiro);
	}
    
	//iniciar jogo
    public void menu() {
    	System.out.print(MensagensGeral.msgBoasVindas());
    	int menuOpcao = sc.nextInt();
    	while(menuOpcao > 2 || menuOpcao < 0) {
    		System.out.print(MensagensGeral.msgOpcaoInvalida());
    		menuOpcao = sc.nextInt();
    	}
    	if(menuOpcao == 2) {
    		modoDebug = true;
    	}
    	else if(menuOpcao == 0) {
    		System.out.println(MensagensGeral.msgSairMenu());
    		System.exit(0);
    	}
    }
    
    public void configurarTabuleiro() {   	
    	System.out.println(MensagensGeral.LIMPARTELA);
    	System.out.print(MensagensGeral.msgConfigurarTamanhoTabuleiro());
    	int tamanho = sc.nextInt();
    	while(tamanho > 100 || tamanho < 10) {
    		System.out.print(MensagensGeral.msgValorInvalido());
    		tamanho = sc.nextInt();
    	}
    	System.out.println(MensagensGeral.ESPACOMAIOR);
    	sc.nextLine();
    	
    	Set<Integer> posicoesOcupadas = new HashSet<>();
    	for(TipoCasa tipo : TipoCasa.values()) {
    		List<Integer> lista = new ArrayList<>();
    		if(tipo==TipoCasa.SIMPLES) {continue;} 
    		
    		System.out.print(MensagensGeral.msgConfigurarCasas(tipo));
    		String linha = sc.nextLine().trim();
    		
    		if(linha.isEmpty()) {
    			config.put(tipo, List.of());
    			continue;
    		}
    		
    		String[] partes = linha.split("\\s+");
    		
    		for (String num : partes) {
                try {
                    int posicao = Integer.parseInt(num);//pega os strings e converte para int se poder.
                    if (posicao < 1 || posicao > tamanho) {
                        System.out.println("posição "+posicao+" está fora do tabuleiro e será ignorada.");
                        System.out.println(MensagensGeral.msgContinuar());
                        sc.nextLine();
                        continue;
                    }
                    
                    if(posicoesOcupadas.contains(posicao)) {
                    	System.out.println("posição "+posicao+" ja esta ocupada para outra casa.");
                    	System.out.println(MensagensGeral.msgContinuar());
                        sc.nextLine();
                    	continue;
                    }
                   
                    posicoesOcupadas.add(posicao);
                    lista.add(posicao);
                }
                catch (NumberFormatException e) {
                    System.out.println("Valor inválido ignorado: " + num);
                }
            }

    		config.put(tipo, lista);
    	}
    	this.tamanhoTabuleiro = tamanho;
    }
    
    public void criarTabuleiro() {
    	tabuleiro = Tabuleiro.getInstancia(tamanhoTabuleiro, config);
    }
    
    public void configurarEAddPecas() {
    	System.out.println(MensagensGeral.LIMPARTELA);
    	System.out.println(MensagensGeral.msgConfigurarQuantidadeJogadores());
    	int quantJogadores = sc.nextInt();
    	while(quantJogadores > 6 || quantJogadores < 1) {
    		System.out.print(MensagensGeral.msgValorInvalido());
    		quantJogadores = sc.nextInt();
    	}
    	System.out.println(MensagensGeral.LIMPARTELA);
    	
    	System.out.println(MensagensGeral.msgConfigurarTipoJogadores());
    	Jogador jogador;
    	for(int i=0; i<quantJogadores; i++) {
    		System.out.print(MensagensGeral.msgEscolherTiposJogadores(i));
    		int tipoPeca = sc.nextInt();
    		sc.nextLine();
    		
    		if(tipoPeca > 3 || tipoPeca < 1) {
    			System.out.println(MensagensGeral.msgTipoInvalido());
    			tipoPeca = 1;
    			System.out.println(MensagensGeral.msgContinuar());
    			sc.nextLine();
    		}
    		
    		System.out.println(MensagensGeral.ESPACOMAIOR);
    		TipoJogador tipoJogador = TipoJogador.values()[tipoPeca-1];
    		Cor cor = Cor.values()[i];
    		jogador = JogadorFactory.criarJogador(tipoJogador, cor, cor.toString());
    		tabuleiro.addJogador(jogador);
    	}
    }
    
    //executar jogo
    private void iniciarRodadas() {
		System.out.println(MensagensTabuleiro.antesLancarDados(jogadorAtual));
		sc.nextLine();
	}
    
    private void fazJogadas() {
    	executarTurno();
    	movimentaParaCasa();
    	if(jogadorVencedor != null) {return;}
    	aplicarCasa();
    }
    
    private void executarTurno() {
    	ultimoResultadoDados = jogadorAtual.movimento();
    	System.out.println(MensagensTabuleiro.msgDadosJogados(Dados.getDado1(),
    			Dados.getDado2(), ultimoResultadoDados));
    }
    
	private void movimentaParaCasa() {
		int mudarPara = jogadorAtual.getCasa() + ultimoResultadoDados;
		jogadorAtual.setCasa(mudarPara);
		if(jogadorAtual.getCasa() >= tamanhoTabuleiro) {
			jogadorVencedor = jogadorAtual;
			return;
		}
	}
	
	private void aplicarCasa() {
		tabuleiro.getCasa(jogadorAtual.getCasa()).aplicarRegra(jogadorAtual, tabuleiro);
	}
	
 // util
 	private void imprimirTabuleiro() {
 		PrintaTabuleiro.imprimir(tabuleiro);
 	}
 	
 	public void finalizarJogo() {
 		System.out.println(MensagensTabuleiro.msgVencedorFimDeJogo(jogadorAtual));
 		System.out.println(MensagensGeral.msgFinal());
 		System.exit(0);
 	}
}