package cotuba.application;

import cotuba.domain.Ebook;
import cotuba.epub.GeradorEPUB;
import cotuba.pdf.GeradorPDF;

public interface GeradorEbook {

	void gera(Ebook ebook);

	public static GeradorEbook cria(String formato) {

		GeradorEbook gerador;

		if ("pdf".equals(formato)) {

			gerador = new GeradorPDF();

		} else if ("epub".equals(formato)) {

			gerador = new GeradorEPUB();

		} else {
			throw new RuntimeException("Formato	do	ebook	inválido:	" + formato);
		}

		return gerador;

	}

}
