package cotuba;

import org.apache.commons.cli.Option;

public enum CommandLineOptions {
    DIR(new Option("d", "dir", true,
            "Diretório que contem os arquivos md. Default: diretório atual.")),
    FORMAT(new Option("f", "format", true,
            "Formato de saída do ebook. Pode ser: pdf ou epub. Default: pdf")),
    OUTPUT(new Option("o", "output", true,
            "Arquivo de saída do ebook. Default: book.{formato}.")),
    VERBOSE(new Option("o", "output", true,
            "Arquivo de saída do ebook. Default: book.{formato}."));

    private Option option;

    CommandLineOptions(Option option) {
        this.option = option;
    }

    public Option getOption() {
        return this.option;
    }
}
