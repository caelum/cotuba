package cotuba.domain;

import java.nio.file.Path;
import java.util.List;

public final class Ebook {

	private FormatoEbook formato;
	private Path arquivoDeSaida;
	private List<Capitulo> capitulos;

	public FormatoEbook getFormato() {
		return formato;
	}

	public Path getArquivoDeSaida() {
		return arquivoDeSaida;
	}

	public List<Capitulo> getCapitulos() {
		return capitulos;
	}

}