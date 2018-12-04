package cotuba.tema;

import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import cotuba.plugin.Tema;

public class AplicadorTema {

	public String aplica(String html) {

		Document document = Jsoup.parse(html);

		List<String> listaDeTemas = Tema.listaDeTemas();
		for (String css : listaDeTemas) {
			document.select("head").append("<style> " + css + " </style>");
		}

		return document.html();

	}

}