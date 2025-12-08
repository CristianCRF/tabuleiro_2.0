package singleton;
import java.util.ArrayList;
import jogadores.Jogador; // importante: usar a classe abstrata Casa
import strategy.Casa;

public class Tabuleiro {
    private static Tabuleiro instance;
    private ArrayList<Jogador> jogadores; 
    private ArrayList<Casa> casas;       

    private Tabuleiro() {
        jogadores = new ArrayList<>();
        casas = new ArrayList<>();
    }

    public static Tabuleiro getInstance() { 
        if (instance == null) {
            instance = new Tabuleiro();
        }
        return instance;
    }

    // getters e métodos para adicionar jogadores/casas
    public ArrayList<Jogador> getJogadores() { return jogadores; }
    public ArrayList<Casa> getCasas() { return casas; }
}