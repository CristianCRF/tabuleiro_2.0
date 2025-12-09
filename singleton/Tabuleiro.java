package singleton;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import enums.TipoCasa;
import factory.CasaFactory;
import jogadores.Jogador;
import strategy.Casa;
import strategy.CasaInicial;

public class Tabuleiro {
	private static Tabuleiro instancia;
	
	private List<Jogador> jogadores;
	private List<Casa> casas;
	private final int tamanho; //maximo so pode ser 100 (ninguem vai jogar mais que isso msm plamordeDeus)
	private int rodadas;

    private Tabuleiro(int tamanho, Map<TipoCasa, List<Integer>> config) {
    	jogadores = new ArrayList<>();
    	casas = new ArrayList<>();
    	this.tamanho = tamanho;
    	rodadas = 0;
    	casas.add(new CasaInicial(0)); //CasaInicial em 0
    	
        for (int i = 1; i <= this.tamanho; i++) {
            casas.add(CasaFactory.criarCasa(i, config));
        }
    }
    
    public static Tabuleiro getInstancia(int tamanho, Map<TipoCasa, List<Integer>> config) {
    	if(instancia == null) {
    		instancia = new Tabuleiro(tamanho, config);
    	}
    	return instancia;
    }
    
    public static Tabuleiro getInstancia() {
    	if (instancia == null)
    		throw new IllegalStateException("Tabuleiro ainda não foi inicializado!");
    	return instancia;
    }
    
    public List<Jogador> getJogadores(){
    	return jogadores;
    }
    
    public Casa getCasa(int n) {
    	if (n < 0 || n > tamanho)
    		throw new IllegalArgumentException("Casa fora dos limites: " + n);
        return casas.get(n);
    }
    
    public int getTamanho() {
    	return tamanho;
    }
    
    public int getRodadas() {
		return rodadas;
	}
    
    public void incrementaRodadas() {
    	rodadas++;
    }

    public void addJogador(Jogador jogador) {
    	jogadores.add(jogador);
    }
    
    public void substituirJogador(Jogador antigo, Jogador novo) {
    	int index = jogadores.indexOf(antigo);
    	if(index >= 0) {
    		jogadores.set(index, novo);
    	}
    }
    
    public Jogador getUltimoJogador() {
        Jogador ultimo = null;
        
        for (Jogador j : jogadores) {
            if (ultimo == null || j.getCasa() < ultimo.getCasa()) {
                ultimo = j;
            }
        }
        return ultimo;
    }

}
