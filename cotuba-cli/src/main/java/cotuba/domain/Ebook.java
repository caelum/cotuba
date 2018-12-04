package cotuba.domain;

import java.nio.file.Path;
import java.util.List;

public final class Ebook {

	private final FormatoEbook formato;
	private final  Path arquivoDeSaida;
	private final List<Capitulo> capitulos;

	public Ebook(FormatoEbook formato, Path arquivoDeSaida, List<Capitulo> capitulos) {
		this.formato = formato;
		this.arquivoDeSaida = arquivoDeSaida;
		this.capitulos = capitulos;
	}

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