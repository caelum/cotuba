package cotuba;

import org.apache.commons.cli.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LeitorOpcoesCLI {

    private Path diretorioDosMD;
    private String formato;
    private Path arquivoDeSaida;
    boolean modoVerboso = false;

    LeitorOpcoesCLI(String[] args) {
        Options options = initializeOptions();

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

    private Options initializeOptions() {
        Options options = new Options();

        Option opcaoDeDiretorioDosMD = CommandLineOptions.DIR.getOption();
        options.addOption(opcaoDeDiretorioDosMD);

        Option opcaoDeFormatoDoEbook = CommandLineOptions.FORMAT.getOption();
        options.addOption(opcaoDeFormatoDoEbook);

        Option opcaoDeArquivoDeSaida = CommandLineOptions.OUTPUT.getOption();
        options.addOption(opcaoDeArquivoDeSaida);

        Option opcaoModoVerboso = CommandLineOptions.VERBOSE.getOption();
        options.addOption(opcaoModoVerboso);
        return options;
    }

    public Path getDiretorioDosMD() {
        return diretorioDosMD;
    }

    public String getFormato() {
        return formato;
    }

    public Path getArquivoDeSaida() {
        return arquivoDeSaida;
    }

    public boolean isModoVerboso() {
        return modoVerboso;
    }
}
