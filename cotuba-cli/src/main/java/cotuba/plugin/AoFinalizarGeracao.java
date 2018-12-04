package cotuba.plugin;

import java.util.ServiceLoader;
import java.util.function.Consumer;

import cotuba.domain.Ebook;

public interface AoFinalizarGeracao {

	void aposGeracao(Ebook ebook, Consumer<String> acaoPosGeracao);

	static void gerou(Ebook ebook, Consumer<String> acaoPosGeracao) {
		ServiceLoader<AoFinalizarGeracao> loader = ServiceLoader.load(AoFinalizarGeracao.class);
		for (AoFinalizarGeracao plugin : loader) {
			plugin.aposGeracao(ebook, acaoPosGeracao);
		}
	}

}