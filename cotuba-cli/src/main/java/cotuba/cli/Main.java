package cotuba.cli;

import java.nio.file.Path;

import cotuba.application.Cotuba;

public class Main {

	public static void main(String[] args) {

		LeitorOpcoesCLI opcoesCLI = new LeitorOpcoesCLI(args);

		Path arquivoDeSaida = opcoesCLI.getArquivoDeSaida();
		boolean modoVerboso = opcoesCLI.isModoVerboso();

		try {

			Cotuba cotuba = new Cotuba();
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
