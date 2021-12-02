package cotuba.application;

import cotuba.domain.Capitulo;
import cotuba.domain.Ebook;
import org.springframework.stereotype.Component;

import java.nio.file.Path;
import java.util.List;

@Component
public class Cotuba {

	private final List<GeradorEbook> geradoresEbook;
	private final RenderizadorMDParaHTML renderizador;

	public Cotuba(List<GeradorEbook> geradoresEbook, RenderizadorMDParaHTML renderizador) {
		this.geradoresEbook = geradoresEbook;
		this.renderizador = renderizador;
	}

	public void executa(ParametrosCotuba parametros) {

		String formato = parametros.getFormato();
		Path diretorioDosMD = parametros.getDiretorioDosMD();
		Path arquivoDeSaida = parametros.getArquivoDeSaida();

		List<Capitulo> capitulos = renderizador.renderiza(diretorioDosMD);

		Ebook ebook = new Ebook();
		ebook.setFormato(formato);
		ebook.setArquivoDeSaida(arquivoDeSaida);
		ebook.setCapitulos(capitulos);

		GeradorEbook geradorEbook = geradoresEbook.stream()
			.filter(gerador -> gerador.accept(formato))
			.findAny()
			.orElseThrow(() -> new RuntimeException("Formato do ebook inválido: " + formato));

		geradorEbook.gera(ebook);
	

	}

}