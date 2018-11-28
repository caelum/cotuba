package br.com.cognitio.estatisticas;

import java.util.HashMap;

public class ContagemPalavras extends HashMap<String, Integer> {

	private static final long serialVersionUID = 1L;

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
