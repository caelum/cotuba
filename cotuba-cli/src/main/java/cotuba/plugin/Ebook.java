package cotuba.plugin;

import java.nio.file.Path;
import java.util.List;
import cotuba.plugin.Capitulo;
import cotuba.domain.FormatoEbook;

public interface Ebook {

	FormatoEbook getFormato();

	Path getArquivoDeSaida();

	List<? extends Capitulo> getCapitulos();

}

