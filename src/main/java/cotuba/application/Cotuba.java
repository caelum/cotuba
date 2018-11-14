package cotuba.application;

import java.nio.file.Path;
import java.util.List;

import cotuba.domain.Capitulo;
import cotuba.domain.Ebook;
import cotuba.epub.GeradorEPUBComEpublib;
import cotuba.pdf.GeradorPDFComIText;

public class Cotuba {

	public void executa(ParametrosCotuba parametros) {

		String formato = parametros.getFormato();
		Path diretorioDosMD = parametros.getDiretorioDosMD();
		Path arquivoDeSaida = parametros.getArquivoDeSaida();

		RenderizadorMDParaHTML renderizador = RenderizadorMDParaHTML.cria();
		List<Capitulo> capitulos = renderizador.renderiza(diretorioDosMD);

		Ebook ebook = new Ebook();
		ebook.setFormato(formato);
		ebook.setArquivoDeSaida(arquivoDeSaida);
		ebook.setCapitulos(capitulos);

		GeradorEbook gerador;

		if ("pdf".equals(formato)) {

			gerador = new GeradorPDFComIText();

		} else if ("epub".equals(formato)) {

			gerador = new GeradorEPUBComEpublib();

		} else {
			throw new RuntimeException("Formato	do	ebook	inválido:	" + formato);
		}

		gerador.gera(ebook);

	}

}