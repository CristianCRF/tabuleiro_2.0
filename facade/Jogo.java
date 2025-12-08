package facade;

import java.util.Scanner;
import singleton.Tabuleiro;
import strategy.Casa;
import factory.CasaFactory;
import jogadores.Jogador;
import factory.JogadorFactory;
import enums.Cor;

public class Jogo {
    private Tabuleiro tabuleiro;
    private Scanner sc;

    public Jogo() {
        // Singleton: garante acesso à única instância do tabuleiro 
        this.tabuleiro = Tabuleiro.getInstance();
        this.sc = new Scanner(System.in);
    }

    // configura as casas do tabuleiro
    public void configTabuleiro(int numCasas) {
        System.out.println("Configurando o tabuleiro com " + numCasas + " casas...");
        
        // limpa configurações anteriores se houver
        tabuleiro.getCasas().clear(); 

        for (int i = 0; i < numCasas; i++) {
            // lógica simplificada: intercala casas especiais (ou pede input do usuário)
            // usar casaFactory
            String tipo = "SIMPLES";
            
            // distribuição de casas (a gente pode mudar depois pro usuário selecionar, se der tempo)
            if (i == 10 || i == 25 || i == 38) tipo = "PRISAO";
            else if (i == 5 || i == 15 || i == 30) tipo = "SORTE";
            else if (i == 17 || i == 27) tipo = "AZAR";
            else if (i == 20 || i == 35) tipo = "SURPRESA"; // a casa das cartas
            else if (i == 13) tipo = "REVERSA";

            // cria a casa usando a Factory e adiciona ao Singleton
            Casa novaCasa = CasaFactory.criarCasa(tipo, i);
            tabuleiro.getCasas().add(novaCasa);
        }
    }

    // configura os jogadores 
    public void config(int numJogadores) {
        tabuleiro.getJogadores().clear();
        
        for (int i = 1; i <= numJogadores; i++) {
            System.out.println("\nConfiguração do Jogador " + i);
            System.out.println("Escolha o tipo: [1] Normal, [2] Sortudo, [3] Azarado");
            int tipo = sc.nextInt();
            
            // reutilizando a lógica do primeiro jogo de cores sequenciais
            Jogador novoJogador = JogadorFactory.criarJogador(tipo, i); // decidir depois como vai ficar o construtor dos jogadores
            tabuleiro.getJogadores().add(novoJogador);
        }
    }

    // exibe o estado atual do tabuleiro
    public void printTabuleiro() {
        System.out.println("\n--- ESTADO DO TABULEIRO ---");
        for (Jogador j : tabuleiro.getJogadores()) {
            System.out.println("Jogador " + j.getCorPeca() + 
                               " | Casa: " + j.getCasa() + 
                               " | Moedas: " + j.getMoedas() +
                               " | Jogadas: " + j.getJogadas());
        }
        System.out.println("---------------------------");
    }

    // loop principal do jogo
    public void start() {
        boolean temVencedor = false;
        int ultimaCasa = tabuleiro.getCasas().size() - 1;
        
        System.out.println("Deseja iniciar em modo Debug? (1-Sim, 2-Não)");
        boolean modoDebug = sc.nextInt() == 1;

        while (!temVencedor) {
            for (Jogador jogador : tabuleiro.getJogadores()) {
                
                // verifica se o jogador está preso (CasaPrisao)
                if (jogador.preso()) {
                    System.out.println("Jogador " + jogador.getCorPeca() + " está preso e perde a vez!");
                    jogador.setPreso(false); // talvez seja jogo setar um numero maior de rounds pro jogador ficar preso com um loop
                    continue;
                } 

                System.out.println("\nVez do jogador: " + jogador.getCorPeca());
                
                int movimento = 0;
                
                if (modoDebug) {
                    System.out.print("[DEBUG] Digite a casa de destino (0 a " + ultimaCasa + "): ");
                    int destino = sc.nextInt();
                    movimento = destino - jogador.getCasa(); // calcula o deslocamento
                } else {
                    System.out.println("Pressione ENTER para jogar os dados...");
                    new Scanner(System.in).nextLine(); // pausa dramática
                    movimento = jogador.movimento(); // depois olha se o movimento precisa ser privado pls
                    System.out.println("Resultado dos dados: " + movimento);
                }

                // Atualiza posição
                int novaPosicao = jogador.getCasa() + movimento;
                
                // Garante que não saia dos limites (ou lógica de vitória imediata)
                if (novaPosicao > ultimaCasa) {
                    novaPosicao = ultimaCasa;
                } else if (novaPosicao < 0) {
                    novaPosicao = 0;
                }

                jogador.setCasa((byte) novaPosicao);
                jogador.setJogadas(jogador.getJogadas() + 1);

                System.out.println("Avançou para a casa " + novaPosicao);

                // aplica a regra da casa onde caiu (Strategy)
                Casa casaAtual = tabuleiro.getCasas().get(novaPosicao);
                casaAtual.aplicarRegra(jogador, tabuleiro); // o Facade não sabe a regra (pq varia conforme a casa), então chama a casa que sabe!

                if (jogador.getCasa() == ultimaCasa) {
                    System.out.println("\n\n!!! TEMOS UM VENCEDOR !!!");
                    System.out.println("O jogador " + jogador.getCorPeca() + " venceu!");
                    jogador.scores(jogador.getCorPeca()); // score final
                    temVencedor = true;
                    break;
                }
                
                printTabuleiro(); // mostra as posições após toda rodada
            }
        }
    }
}