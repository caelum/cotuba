package cotuba.cli;

import java.nio.file.Path;

import cotuba.CotubaConfig;
import cotuba.application.Cotuba;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {

		LeitorOpcoesCLI opcoesCLI = new LeitorOpcoesCLI(args);

		Path arquivoDeSaida = opcoesCLI.getArquivoDeSaida();
		boolean modoVerboso = opcoesCLI.isModoVerboso();

		try {

			var applicationContext = new AnnotationConfigApplicationContext(CotubaConfig.class);
			Cotuba cotuba = applicationContext.getBean(Cotuba.class);
			cotuba.executa(opcoesCLI);

			System.out.println("Arquivo gerado com sucesso: " + arquivoDeSaida);

		} catch (Exception ex) {
			System.err.println(ex.getMessage());
			if (modoVerboso) {
				ex.printStackTrace();
			}
			System.exit(1);
		}
	}

}
