package cotuba;

import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.kernel.pdf.*;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.*;
import com.itextpdf.layout.property.AreaBreakType;
import cotuba.leitor.*;
import nl.siegmann.epublib.domain.*;
import nl.siegmann.epublib.epub.EpubWriter;
import nl.siegmann.epublib.service.MediatypeService;
import org.commonmark.node.*;
import org.commonmark.node.Text;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {

		boolean modoVerboso = false;
		try {
			LeitorDeComandos leitor = new LeitorDeComandos(args);
			Path diretorioDosMD = leitor.getDiretorioDosMD();
			String formato = leitor.getFormato();
			Path arquivoDeSaida = leitor.getArquivoDeSaida();
			modoVerboso = leitor.isModoVerboso();

			if ("pdf".equals(leitor.getFormato())) {
				GeradorDePdf geradorDePdf = new GeradorDePdf();
				geradorDePdf.gera(diretorioDosMD, arquivoDeSaida);

			} else if ("epub".equals(formato)) {
				GeradorDeEpub geradorDeEpub = new GeradorDeEpub();
				geradorDeEpub.gera(diretorioDosMD, arquivoDeSaida);
			} else {
				throw new RuntimeException("Formato do ebook inválido: " + formato);
			}

			System.out.println("Arquivo gerado com sucesso: " + arquivoDeSaida);

		} catch (Exception ex) {
			System.err.println(ex.getMessage());
			if (modoVerboso) {
				ex.printStackTrace();
			}
			System.exit(1);
		}
	}

}
