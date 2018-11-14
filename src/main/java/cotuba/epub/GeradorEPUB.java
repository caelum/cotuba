package cotuba.epub;

import cotuba.domain.Ebook;

public interface GeradorEPUB {

	void gera(Ebook ebook);

	public static GeradorEPUB cria() {
		return new GeradorEPUBComEpublib();
	}

}