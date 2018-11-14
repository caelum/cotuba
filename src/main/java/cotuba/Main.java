package cotuba;

import java.nio.file.Path;

public class Main {

	public static void main(String[] args) {

		LeitorOpcoesCLI opcoesCLI = new LeitorOpcoesCLI(args);
		Path diretorioDosMD = opcoesCLI.getDiretorioDosMD();
		String formato = opcoesCLI.getFormato();
		Path arquivoDeSaida = opcoesCLI.getArquivoDeSaida();
		boolean modoVerboso = opcoesCLI.isModoVerboso();

		try {

			if ("pdf".equals(formato)) {

				GeradorPDF geradorPDF = new GeradorPDF();
				geradorPDF.gera(diretorioDosMD, arquivoDeSaida);

			} else if ("epub".equals(formato)) {

				GeradorEPUB geradorEPUB = new GeradorEPUB();
				geradorEPUB.gera(diretorioDosMD, arquivoDeSaida);

			} else {
				throw new RuntimeException("Formato do ebook inválido: " + formato);
			}

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
