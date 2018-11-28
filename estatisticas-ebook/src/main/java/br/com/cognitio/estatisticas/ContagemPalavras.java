package br.com.cognitio.estatisticas;

import java.util.TreeMap;

public class ContagemPalavras {

	public void adicionaPalavra(String palavra) {
		Integer contagem = get(palavra);

		if (contagem != null) {
			contagem++;
		} else {
			contagem = 1;
		}

		put(palavra, contagem);
	}
}
