package cotuba.application;

import java.nio.file.Path;
import java.util.List;

import cotuba.domain.Capitulo;
import cotuba.md.RenderizadorMDParaHTMLComCommonMark;

public interface RenderizadorMDParaHTML {

	List<Capitulo> renderiza(Path diretorioDosMD);

}