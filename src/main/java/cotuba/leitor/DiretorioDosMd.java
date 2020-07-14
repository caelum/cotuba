package cotuba.leitor;

import java.nio.file.*;

class DiretorioDosMd {

    private static String DIRETORIO_PADRAO = "";

    public static Path construirDiretorio(String diretorio) {
        if(diretorio != null) return criarDiretorio(diretorio);
        return criarDiretorioPadrao();
    }

    private static Path criarDiretorio(String nomeDiretorio) {
        Path diretorio = Paths.get(nomeDiretorio);
        if (!caminhoEhValido(diretorio)) {
            throw new RuntimeException(nomeDiretorio + " não é um diretório.");
        }
        return diretorio;
    }

    private static Path criarDiretorioPadrao() {
        return Paths.get(DIRETORIO_PADRAO);
    }

    private static boolean caminhoEhValido(Path caminho) {
        return Files.isDirectory(caminho);
    }

}
