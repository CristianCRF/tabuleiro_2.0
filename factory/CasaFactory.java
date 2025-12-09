package factory;

import java.util.List;
import java.util.Map;

import enums.TipoCasa;
import strategy.Casa;
import strategy.CasaPrisao;
import strategy.CasaSimples;
import strategy.CasaSurpresa;

public class CasaFactory {
	public static Casa criarCasa(int numero, Map<TipoCasa, List<Integer>> config) {
		for(var obj : config.entrySet()) {
			TipoCasa tipo = obj.getKey();
			List<Integer> casaPosicoes = obj.getValue();
			
			if(casaPosicoes.contains(numero)) { //em facade so vai receber o que nao for simples.
				switch(tipo) {
					case SIMPLES: return new CasaSimples(numero);
					case SURPRESA: return new CasaSurpresa(numero);
					case PRISAO: return new CasaPrisao(numero);
				}
			}
		}
		return new CasaSimples(numero);
	}
}
