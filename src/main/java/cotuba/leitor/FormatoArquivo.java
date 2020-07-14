package cotuba.leitor;

import java.util.Optional;

public class FormatoArquivo {

    private static String FORMATO_PADRAO = "pdf";

    public static String constuirFormato(String formato) {
        return Optional.ofNullable(formato)
                .map(String::toLowerCase)
                .orElse(FORMATO_PADRAO);
    }
}
