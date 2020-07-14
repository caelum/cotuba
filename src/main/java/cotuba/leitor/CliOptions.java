package cotuba.leitor;

import org.apache.commons.cli.*;

import static java.util.stream.Stream.of;

public enum  CliOptions {

    DIRETORIO("d", "dir", true,"Diretório que contem os arquivos md. Default: diretório atual."),
    FORMATO_SAIDA("f", "format", true, "Formato de saída do ebook. Pode ser: pdf ou epub. Default: pdf"),
    TEST("o", "output", true, "Arquivo de saída do ebook. Default: book.{formato}.");

    private String opt;
    private String longOpt;
    private boolean hasArg;
    private String description;

    CliOptions(String opt, String longOpt, boolean hasArg, String description) {
        this.opt = opt;
        this.longOpt = longOpt;
        this.hasArg = hasArg;
        this.description = description;
    }

    public String getOpt() {
        return opt;
    }

    public String getLongOpt() {
        return longOpt;
    }

    public boolean hasArg() {
        return hasArg;
    }

    public String getDescription() {
        return description;
    }

    public static Options buildOptions() {
        Options options = new Options();
        of(CliOptions.values())
                .map(cliOptions -> new Option(
                        cliOptions.getOpt(),
                        cliOptions.getLongOpt(),
                        cliOptions.hasArg(),
                        cliOptions.getDescription()))
                .forEach(options::addOption);
        return options;
    }
}
