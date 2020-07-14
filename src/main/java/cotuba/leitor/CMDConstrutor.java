package cotuba.leitor;

import org.apache.commons.cli.*;

public class CMDConstrutor {

    public static CommandLine construir(String[] args) throws ParseException {
        Options options = CliOptions.buildOptions();
        CommandLineParser cmdParser = new DefaultParser();
        return cmdParser.parse(options, args);
    }
}
