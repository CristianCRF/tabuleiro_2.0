package facade;

import jogadores.*;
import singleton.Tabuleiro;

// lógica base da classe implementada com auxílio de IA


public class Jogo {
    private Tabuleiro tabuleiro;

    public Jogo() {
        this.tabuleiro = Tabuleiro.getInstance(); // Pega a instância única
    }

    public void configTabuleiro(int numCasas) {
        // lógica para criar as casas usando CasaFactory e adicionar ao tabuleiro
        // perguntar ao usuário quais casas especiais ele quer ou gerar aleatoriamente
    }

    public void config(int numJogadores) {
        // lógica para ler nomes/cores e usar JogadorFactory para criar e add ao tabuleiro
    }

    public void printTabuleiro() {
        // itera sobre tabuleiro.getCasas() e tabuleiro.getJogadores() para mostrar o estado
    }

    public void start() {
        // loop principal do jogo
        boolean temVencedor = false;
        while(!temVencedor) {
            for (Jogador j : tabuleiro.getJogadores()) {
                // 1. jogar dados (j.movimento())
                // 2. atualizar posição
                // 3. verificar se ganhou
                // 4. pegar a casa atual: Casa c = tabuleiro.getCasas().get(j.getCasa());
                // 5. executar regra: c.aplicarRegra(j);
            }
        }
    }
}