package cotuba.plugin;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

public interface Plugin {

	String cssDoTema();

	static List<String> listaDeTemas() {
		List<String> temas = new ArrayList<>();

		ServiceLoader<Plugin> loader = ServiceLoader.load(Plugin.class);
		for (Plugin plugin : loader) {
			String css = plugin.cssDoTema();
			temas.add(css);
		}

		return temas;
	}

}
