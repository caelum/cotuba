package cotuba.application;

import cotuba.domain.Ebook;

public interface GeradorEbook {

	void gera(Ebook ebook);

	public static GeradorEbook cria(String formato) {
	}

}
