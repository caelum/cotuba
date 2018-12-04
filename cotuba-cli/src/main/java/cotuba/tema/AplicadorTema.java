package cotuba.tema;

import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import cotuba.domain.Capitulo;
import cotuba.plugin.Tema;

public class AplicadorTema {

	public String aplica(Capitulo capitulo) {

		String html = capitulo.getConteudoHTML();
		Document document = Jsoup.parse(html);

		List<String> listaDeTemas = Tema.listaDeTemas();
		for (String css : listaDeTemas) {
			document.select("head").append("<style> " + css + " </style>");
		}

		return document.html();

	}

}