package com.coinnect.CoinNect.utils;

import java.io.IOException;

import com.coinnect.CoinNect.exceptions.ContratoCannotBeCreatedException;
import com.coinnect.CoinNect.model.entities.Contrato;
import com.itextpdf.io.source.ByteArrayOutputStream;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

public class PdfGenerator {

	public byte[] gerarPdfSeFormalizado(Contrato contrato)  {
		try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) { // BAOS transforma uma strem de saida para
			if(!contrato.foiFormalizado()) throw new ContratoCannotBeCreatedException("Contrato não foi fomralizado, frmalize-o e tnete novamente!");																// bytes de array
			PdfWriter pdfWriter = new PdfWriter(baos);
			Document doc = new Document(new PdfDocument(pdfWriter));

			doc.add(new Paragraph("==== Contrato de Serviços ==="));
			doc.add(new Paragraph("Valor final -> " + contrato.getValor()));
			doc.add(new Paragraph("Assinatura Contratante -> " + contrato.getAssinaturaContratante()));
			doc.add(new Paragraph("Assinatura Prestador -> " + contrato.getAssinaturaPrestador()));
			doc.add(new Paragraph("/Clausulas -> " + contrato.getClausulasEspecificas()));
			doc.add(new Paragraph("Valor final -> " + contrato.getClausulasEspecificas()));
			doc.close();

			return baos.toByteArray();

		} catch (ContratoCannotBeCreatedException | IOException e) {
			throw new ContratoCannotBeCreatedException("Pdf não pode ser criado! Tente novamente!");
		}

	}
}
