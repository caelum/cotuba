package cotuba;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import nl.siegmann.epublib.domain.Book;
import nl.siegmann.epublib.domain.Resource;
import nl.siegmann.epublib.epub.EpubWriter;
import nl.siegmann.epublib.service.MediatypeService;

public class GeradorEPUB {

	public void gera(Path diretorioDosMD, Path arquivoDeSaida) {

		Book epub = new Book();

		// TODO: usar título do capítulo
		epub.addSection("Capítulo", new Resource(html.getBytes(), MediatypeService.XHTML));

		EpubWriter epubWriter = new EpubWriter();

		try {
			epubWriter.write(epub, Files.newOutputStream(arquivoDeSaida));
		} catch (IOException ex) {
			throw new RuntimeException("Erro ao criar arquivo EPUB: " + arquivoDeSaida.toAbsolutePath(), ex);
		}

	}

}
