package singleton;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import enums.TipoCasa;
import factory.CasaFactory;
import jogadores.Jogador;
import strategy.Casa;

public class Tabuleiro {
	private static Tabuleiro instancia;
	
	private List<Jogador> jogadores;
	private List<Casa> casas;
	private final int tamanho;

    private Tabuleiro(int tamanho, Map<TipoCasa, List<Integer>> config) {
    	this.jogadores = new ArrayList<>();
    	this.casas = new ArrayList<>();
    	this.tamanho = tamanho;
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
    	return instancia;
    }

    public void addJogador(Jogador jogador) {
    	jogadores.add(jogador);
    }
    
    public List<Jogador> getJogadores(){
    	return jogadores;
    }
    
    public Casa getCasa(int n) {
        return casas.get(n - 1);
    }
    
    public void substituirJogador(Jogador novo, Jogador antigo) {
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
