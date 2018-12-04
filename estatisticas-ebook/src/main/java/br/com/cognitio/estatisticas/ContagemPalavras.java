package br.com.cognitio.estatisticas;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class ContagemPalavras {

	public static final class Contagem {

		private final String palavra;
		private final int quantidade;

		public Contagem(String palavra, int quantidade) {
			this.palavra = palavra;
			this.quantidade = quantidade;
		}

		public String getPalavra() {
			return palavra;
		}

		public int getQuantidade() {
			return quantidade;
		}
	}

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

	public Set<Map.Entry<String, Integer>> entrySet() {
		return map.entrySet();
	}
}
