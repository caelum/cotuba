package cotuba.cli;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import cotuba.application.ParametrosCotuba;

public class LeitorOpcoesCLI implements ParametrosCotuba {

	private Path diretorioDosMD;
	private String formato;
	private Path arquivoDeSaida;
	private boolean modoVerboso = false;

	public LeitorOpcoesCLI(String[] args) {

		Options options = new Options();

		Option opcaoDeDiretorioDosMD = new Option("d", "dir", true,
				"Diretório que contem os arquivos md. Default: diretório atual.");
		options.addOption(opcaoDeDiretorioDosMD);

		Option opcaoDeFormatoDoEbook = new Option("f", "format", true,
				"Formato de saída do ebook. Pode ser: pdf ou epub. Default: pdf");
		options.addOption(opcaoDeFormatoDoEbook);

		Option opcaoDeArquivoDeSaida = new Option("o", "output", true,
				"Arquivo de saída do ebook. Default: book.{formato}.");
		options.addOption(opcaoDeArquivoDeSaida);

		Option opcaoModoVerboso = new Option("v", "verbose", false, "Habilita modo verboso.");
		options.addOption(opcaoModoVerboso);

		CommandLineParser cmdParser = new DefaultParser();
		HelpFormatter ajuda = new HelpFormatter();
		CommandLine cmd;

		try {
			cmd = cmdParser.parse(options, args);
		} catch (ParseException e) {
			System.err.println(e.getMessage());
			ajuda.printHelp("cotuba", options);
			System.exit(1);
			return;
		}

		String nomeDoDiretorioDosMD = cmd.getOptionValue("dir");

		if (nomeDoDiretorioDosMD != null) {
			diretorioDosMD = Paths.get(nomeDoDiretorioDosMD);
			if (!Files.isDirectory(diretorioDosMD)) {
				throw new RuntimeException(nomeDoDiretorioDosMD + " não é um diretório.");
			}
		} else {
			Path diretorioAtual = Paths.get("");
			diretorioDosMD = diretorioAtual;
		}

		String nomeDoFormatoDoEbook = cmd.getOptionValue("format");

		if (nomeDoFormatoDoEbook != null) {
			formato = nomeDoFormatoDoEbook.toLowerCase();
		} else {
			formato = "pdf";
		}

		String nomeDoArquivoDeSaidaDoEbook = cmd.getOptionValue("output");
		if (nomeDoArquivoDeSaidaDoEbook != null) {
			arquivoDeSaida = Paths.get(nomeDoArquivoDeSaidaDoEbook);
			if (Files.exists(arquivoDeSaida) && Files.isDirectory(arquivoDeSaida)) {
				throw new RuntimeException(nomeDoArquivoDeSaidaDoEbook + " é um diretório.");
			}
		} else {
			arquivoDeSaida = Paths.get("book." + formato.toLowerCase());
		}

		modoVerboso = cmd.hasOption("verbose");

	}

	@Override
	public Path getDiretorioDosMD() {
		return diretorioDosMD;
	}

	@Override
	public String getFormato() {
		return formato;
	}

	@Override
	public Path getArquivoDeSaida() {
		return arquivoDeSaida;
	}

	public boolean isModoVerboso() {
		return modoVerboso;
	}

}