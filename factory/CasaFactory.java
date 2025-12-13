package factory;

import java.util.List;
import java.util.Map;

import enums.TipoCasa;
import strategy.*;

public class CasaFactory {
	public static Casa criarCasa(int numero, Map<TipoCasa, List<Integer>> config) {
		for(var obj : config.entrySet()) {
			TipoCasa tipo = obj.getKey();
			List<Integer> casaPosicoes = obj.getValue();
			
			if(!casaPosicoes.contains(numero)) {continue;}
			return switch(tipo) {
				case PRISAO -> new CasaPrisao(numero);
				case SURPRESA -> new CasaSurpresa(numero);
				case SORTE ->new CasaSorte(numero);
				case AZAR -> new CasaAzar(numero);
				case REVERSA -> new CasaReversa(numero);
				case JOGADUASVEZES -> new CasaJogaDeNovo(numero);
				default -> throw new IllegalArgumentException("Erro inesperado de tipo de casa: " + tipo);
			};
		}
		return new CasaSimples(numero);
	}
}
