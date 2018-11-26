package cotuba.plugin;

import java.util.ArrayList;
import java.util.List;

public interface Plugin {

	String cssDoTema();

	static List<String> listaDeTemas() {
		List<String> temas = new ArrayList<>();
		return temas;
	}

}
