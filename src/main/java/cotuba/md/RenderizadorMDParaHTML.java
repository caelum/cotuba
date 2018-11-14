package cotuba.md;

import java.nio.file.Path;
import java.util.List;

import cotuba.domain.Capitulo;

public interface RenderizadorMDParaHTML {

	List<Capitulo> renderiza(Path diretorioDosMD);

}