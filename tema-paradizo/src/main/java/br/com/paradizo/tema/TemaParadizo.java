package br.com.paradizo.tema;

import cotuba.plugin.Plugin;

public class TemaParadizo implements Plugin {

	@Override
	public String cssDoTema() {
		return FileUtils.getResourceContents("/tema.css");
	}

}
