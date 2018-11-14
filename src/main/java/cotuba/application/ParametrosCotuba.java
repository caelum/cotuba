package cotuba.application;

import java.nio.file.Path;

import cotuba.domain.FormatoEbook;

public interface ParametrosCotuba {

	Path getDiretorioDosMD();

	FormatoEbook getFormato();

	Path getArquivoDeSaida();

}