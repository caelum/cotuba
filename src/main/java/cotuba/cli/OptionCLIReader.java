package cotuba.cli;

import org.apache.commons.cli.*;

public class OptionCLIReader {

    private String nomeDoDiretorioDosMD;
    private String nomeDoFormatoDoEbook;
    private String nomeDoArquivoDeSaidaDoEbook;
    private boolean modoVerboso = false;

    public OptionCLIReader(String [] args) {
        Options options = new Options();

        options.addOption(new Option("d", "dir", true, "Diretório que contem os arquivos md. Default: diretório atual."));
        options.addOption(new Option("f", "format", true, "Formato de saída do ebook. Pode ser: pdf ou epub. Default: pdf"));
        options.addOption(new Option("o", "output", true, "Arquivo de saída do ebook. Default: book.{formato}."));
        options.addOption(new Option("v", "verbose", false, "Habilita modo verboso."));

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

        this.nomeDoDiretorioDosMD = cmd.getOptionValue("dir");
        this.nomeDoFormatoDoEbook = cmd.getOptionValue("format");
        this.nomeDoArquivoDeSaidaDoEbook = cmd.getOptionValue("output");
        this.modoVerboso = cmd.hasOption("verbose");
    }

    public String getNomeDoDiretorioDosMD() {
        return nomeDoDiretorioDosMD;
    }

    public String getNomeDoFormatoDoEbook() {
        return nomeDoFormatoDoEbook;
    }

    public String getNomeDoArquivoDeSaidaDoEbook() {
        return nomeDoArquivoDeSaidaDoEbook;
    }

    public boolean isModoVerboso() {
        return modoVerboso;
    }
}
