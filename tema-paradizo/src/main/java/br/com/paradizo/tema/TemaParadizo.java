package br.com.paradizo.tema;

import cotuba.domain.Ebook;
import cotuba.plugin.Plugin;

public class TemaParadizo implements Plugin {

	@Override
	public String cssDoTema() {
		return FileUtils.getResourceContents("/tema.css");
	}

	@Override
	public void aposGeracao(Ebook ebook) {

	}

}
