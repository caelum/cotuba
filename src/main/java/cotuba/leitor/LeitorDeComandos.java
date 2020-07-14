package cotuba.leitor;

import org.apache.commons.cli.CommandLine;

import java.nio.file.Path;

import static cotuba.leitor.ArquivoDeSaida.criarCaminho;
import static cotuba.leitor.CMDConstrutor.construir;
import static cotuba.leitor.DiretorioDosMd.construirDiretorio;
import static cotuba.leitor.FormatoArquivo.constuirFormato;

public class LeitorDeComandos {

    private Path diretorioDosMD;
    private String formato;
    private Path arquivoDeSaida;
    private boolean modoVerboso;

    public LeitorDeComandos(String[] args) throws Exception {
        CommandLine cmd = construir(args);
        diretorioDosMD = construirDiretorio(cmd.getOptionValue("dir"));
        formato = constuirFormato(cmd.getOptionValue("format"));
        arquivoDeSaida = criarCaminho(formato, cmd.getOptionValue("output"));
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
