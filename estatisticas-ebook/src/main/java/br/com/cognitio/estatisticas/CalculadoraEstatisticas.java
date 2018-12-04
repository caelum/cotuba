package br.com.cognitio.estatisticas;

import java.text.Normalizer;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import cotuba.domain.Capitulo;
import cotuba.domain.Ebook;
import cotuba.plugin.AoFinalizarGeracao;

public class CalculadoraEstatisticas implements AoFinalizarGeracao {

	public void aposGeracao(Ebook ebook) {

		ContagemPalavras contagemPalavras = new ContagemPalavras();

		for (Capitulo capitulo : ebook.getCapitulos()) {
			String html = capitulo.getConteudoHTML();
			Document doc = Jsoup.parse(html);
			String textoDoCapitulo = doc.body().text();

			String textoDoCapituloSemPontuacao = textoDoCapitulo.replaceAll("\\p{Punct}", " ");
			String textoDoCapituloSemAcentos = Normalizer.normalize(textoDoCapituloSemPontuacao, Normalizer.Form.NFD)
					.replaceAll("[^\\p{ASCII}]", "");

			String[] palavras = textoDoCapituloSemAcentos.split("\\s+");
			for (String palavra : palavras) {
				String emMaiusculas = palavra.toUpperCase();
				contagemPalavras.adicionaPalavra(emMaiusculas);
			}
		}

		for (Map.Entry<String, Integer> contagem : contagemPalavras.entrySet()) {
			String palavra = contagem.getKey();
			Integer ocorrencias = contagem.getValue();
			System.out.println(palavra + ": " + ocorrencias);
		}
	}

}
