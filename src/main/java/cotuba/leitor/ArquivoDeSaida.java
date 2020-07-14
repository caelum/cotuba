package cotuba.leitor;

import java.nio.file.*;

class ArquivoDeSaida {

    public static Path criarCaminho(String formato, String nomeDoArquivo) {
        if (nomeDoArquivo != null) return criaCaminhoParaArquivo(nomeDoArquivo);
        return Paths.get("book." + formato.toLowerCase());
    }

    private static Path criaCaminhoParaArquivo(String nomeDoArquivoDeSaidaDoEbook) {
        Path arquivoDeSaida = Paths.get(nomeDoArquivoDeSaidaDoEbook);
        if (caminhoEhDiretorio(arquivoDeSaida)) {
            throw new RuntimeException(nomeDoArquivoDeSaidaDoEbook + " é um diretório.");
        }
        return arquivoDeSaida;
    }

    private static boolean caminhoEhDiretorio(Path arquivoDeSaida) {
        return Files.exists(arquivoDeSaida) && Files.isDirectory(arquivoDeSaida);
    }

}
