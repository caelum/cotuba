package cotuba.leitor;

import org.apache.commons.cli.CommandLine;

import java.nio.file.Path;

public class Leitor {

    private Path diretorioDosMD;
    private String formato;
    private Path arquivoDeSaida;
    private boolean modoVerboso;

    public Leitor(String[] args) throws Exception {
        CommandLine cmd = CMDConstrutor.construir(args);
        diretorioDosMD = DiretorioDosMd.construirDiretorio(cmd.getOptionValue("dir"));
        formato = FormatoArquivo.constuirFormato(cmd.getOptionValue("format"));
        arquivoDeSaida = ArquivoDeSaida.criarCaminho(formato, cmd.getOptionValue("output"));
        modoVerboso = cmd.hasOption("verbose");
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
