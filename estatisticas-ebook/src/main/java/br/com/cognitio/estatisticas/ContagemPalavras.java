package br.com.cognitio.estatisticas;

import java.util.Map;
import java.util.TreeMap;

public class ContagemPalavras {

	private Map<String, Integer> map = new TreeMap<>();

	public void adicionaPalavra(String palavra) {
		Integer contagem = map.get(palavra);

		if (contagem != null) {
			contagem++;
		} else {
			contagem = 1;
		}

		map.put(palavra, contagem);
	}
}
