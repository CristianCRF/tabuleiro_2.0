package factory;

import strategy.*;

public class CasaFactory {
    public static Casa criarCasa(String tipo, int numero) {
        switch (tipo.toLowerCase()) {
            case "surpresa": return new CasaSurpresa(numero);
            case "prisao": return new CasaPrisao(numero);
            case "sorte": return new CasaSorte(numero);
            case "azar": return new CasaAzar(numero);
            case "reversa": return new CasaReversa(numero);
            // case "jogadenovo": return new CasaJogaDeNovo(numero); // como a gente repetiria o loop do jogo? acho que vezJogador -- serve
            case "simples": 
            default: return new CasaSimples(numero);
        }
    }
}