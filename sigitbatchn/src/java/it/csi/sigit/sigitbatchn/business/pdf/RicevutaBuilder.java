/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitbatchn.business.pdf;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.SigitTImportDistribRicevutaByIdImportDistribDto;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.SigitVRicercaAllegatiDto;
import it.csi.sigit.sigitbatchn.business.manager.util.DbManagerException;
import it.csi.sigit.sigitbatchn.business.util.ConvertUtil;
import it.csi.sigit.sigitbatchn.business.util.GenericUtil;
import it.csi.sigit.sigitbatchn.business.util.MapDto;

public class RicevutaBuilder extends BaseBuilder {

	private static String FILE = "C:/Repo/CSI/sigit/sigit_sigitbatchn/test/";

	public static void main(String[] args) {

		try {
			RicevutaBuilder ricevutaAllegato = new RicevutaBuilder();

			byte[] libretto = ricevutaAllegato.generaRicevutaImportDistributore(null, true);

			FileOutputStream fileStream = new FileOutputStream(
					FILE + getDataCompleta() + "_ricevuta_import_distributori.pdf");

			fileStream.write(libretto);
			fileStream.flush();
			fileStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public byte[] generaRicevutaImportDistributore(Integer idImportDistrib) {
		return generaRicevutaImportDistributore(idImportDistrib, false);
	}

	public byte[] generaRicevutaImportDistributore(Integer idImportDistrib, boolean isSimul) {
		gestDebug(isSimul, "generaRicevutaImportDistributore - START");
		byte[] pdfITextRicevutaImportDistributore = {};
		SigitTImportDistribRicevutaByIdImportDistribDto importDistribDB = null;

		try {
			if (isSimul) {
				importDistribDB = new SigitTImportDistribRicevutaByIdImportDistribDto();
			} else {
				importDistribDB = getDbMgr().cercaImportRicevutaByIdDistr(idImportDistrib);
			}

			Document document = creaDocumento();
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			PdfWriter writer = PdfWriter.getInstance(document, outputStream);

			document.open();

			aggiungiHeader(document);

			Paragraph title = new Paragraph("Ricevuta avvenuta acquisizione dati distributori", FONT_HELVETICA_18_B);
			title.setSpacingBefore(25);
			document.add(title);

			String ragioneSociale = importDistribDB.getPgDenominazione();
			String indirizzo = MapDto.getIndirizzoCompleto(importDistribDB.getPgComune(),
					importDistribDB.getPgIndirizzoSitad(), importDistribDB.getPgIndirizzoNonTrovato(),
					importDistribDB.getPgCivico(), importDistribDB.getPgSiglaProv());
			String codiceFiscale = importDistribDB.getPgCodiceFiscale();
			String codiceRea = MapDto.getCodiceRea(importDistribDB.getPgSiglaRea(),
					ConvertUtil.convertToInteger(importDistribDB.getPgNumeroRea()));

			aggiungiDescrizioneImpresa(document, ragioneSociale, indirizzo, codiceFiscale, codiceRea, isSimul);

			aggiungiDescrizioneAcquisizioneDatiDistributori(document, importDistribDB, isSimul);

			aggiungiFooter(writer);

			outputStream.flush();
			document.close();
			outputStream.close();

			pdfITextRicevutaImportDistributore = outputStream.toByteArray();

		} catch (DocumentException docEx) {
			gestError(isSimul, docEx.getMessage(), docEx);
		} catch (Exception ex) {
			gestError(isSimul, ex.getMessage(), ex);
		}

		gestDebug(isSimul, "generaRicevutaImportDistributore - END");
		return pdfITextRicevutaImportDistributore;
	}

	private void aggiungiDescrizioneImpresa(Document document, String ragioneSociale, String indirizzo,
			String codiceFiscale, String codiceRea, boolean isSimul) throws DocumentException, DbManagerException {
		gestDebug(isSimul, "aggiungiDescrizioneImpresa - START");

		Paragraph titoloDescrizione = new Paragraph("Descrizione impresa", FONT_HELVETICA_12_B);
		titoloDescrizione.setSpacingBefore(20);
		document.add(titoloDescrizione);

		document.add(aggiungiRigaDescrizione("Ragione Sociale", ragioneSociale));
		document.add(aggiungiRigaDescrizione("Indirizzo", indirizzo));
		document.add(aggiungiRigaDescrizione("Partita IVA/Codice Fiscale", codiceFiscale));
		document.add(aggiungiRigaDescrizione("Codice Rea", codiceRea));
		gestDebug(isSimul, "aggiungiDescrizioneImpresa - END");
	}

	private void aggiungiDescrizioneImpianto(Document document, SigitVRicercaAllegatiDto allegatoDB, boolean isSimul)
			throws DocumentException {
		gestDebug(isSimul, "aggiungiDescrizioneImpianto - START");

		Paragraph titoloDescrizione = new Paragraph("Descrizione Impianto", FONT_HELVETICA_12_B);
		titoloDescrizione.setSpacingBefore(20);
		document.add(titoloDescrizione);

		document.add(aggiungiRigaDescrizione("Codice Impianto",
				ConvertUtil.convertToString(allegatoDB.getCodiceImpianto())));
		String ubicazione = MapDto.getIndirizzoCompleto(allegatoDB.getComuneImpianto(),
				allegatoDB.getIndirizzoUnitaImmob(), null, allegatoDB.getCivicoUnitaImmob(),
				allegatoDB.getSiglaProvImpianto());
		document.add(aggiungiRigaDescrizione("Ubicazione", ubicazione));

		gestDebug(isSimul, "aggiungiDescrizioneImpianto - END");
	}

	private void aggiungiDescrizioneRapportoDiControllo(Document document, SigitVRicercaAllegatiDto allegatoDB,
			boolean isSimul) throws DocumentException {
		gestDebug(isSimul, "aggiungiDescrizioneRapportoDiControllo - START");

		Paragraph titoloDescrizione = new Paragraph("Descrizione rapporto di Controllo", FONT_HELVETICA_12_B);
		titoloDescrizione.setSpacingBefore(20);
		document.add(titoloDescrizione);

		String codiceBollino = "";

		if (GenericUtil.isNotNullOrEmpty(allegatoDB.getFkNumeroBollino())) {
			codiceBollino = allegatoDB.getFkSiglaBollino() + "-" + allegatoDB.getFkNumeroBollino();
		}

		document.add(aggiungiRigaDescrizione("Tipo rapporto", allegatoDB.getDesTipoDocumento()));
		document.add(aggiungiRigaDescrizione("Elenco apparecchiature", allegatoDB.getElencoApparecchiature()));
		document.add(
				aggiungiRigaDescrizione("Data controllo", ConvertUtil.convertToString(allegatoDB.getDataControllo())));
		document.add(aggiungiRigaDescrizione("Codice bollino", codiceBollino));
		document.add(aggiungiRigaDescrizione("Data invio del rapporto",
				ConvertUtil.convertToString(allegatoDB.getDataInvio())));

		gestDebug(isSimul, "aggiungiDescrizioneRapportoDiControllo - END");
	}

	private void aggiungiDescrizioneAcquisizioneDatiDistributori(Document document,
			SigitTImportDistribRicevutaByIdImportDistribDto importDistribDB, boolean isSimul) throws DocumentException {
		gestDebug(isSimul, "aggiungiDescrizioneAcquisizioneDatiDistributori - START");

		Paragraph titoloDescrizione = new Paragraph("Descrizione acquisizione dati distributori", FONT_HELVETICA_12_B);
		titoloDescrizione.setSpacingBefore(20);
		document.add(titoloDescrizione);

		document.add(aggiungiRigaDescrizione("Data caricamento dati",
				ConvertUtil.convertToString(importDistribDB.getIdDataInizioElab())));
		document.add(aggiungiRigaDescrizione("Data acquisizione dati",
				ConvertUtil.convertToString(importDistribDB.getIdDataFineElab())));
		document.add(aggiungiRigaDescrizione("Data annullamento dati",
				ConvertUtil.convertToString(importDistribDB.getIdDataAnnullamento())));
		document.add(aggiungiRigaDescrizione("Nome file",
				ConvertUtil.getStringValid(importDistribDB.getIdNomeFileImport())));
		document.add(aggiungiRigaDescrizione("Anno riferimento",
				ConvertUtil.convertToString(importDistribDB.getIdAnnoRiferimento())));
		document.add(aggiungiRigaDescrizione("Stato acquisizione",
				ConvertUtil.getStringValid(importDistribDB.getSdDesStatoDistrib())));
		gestDebug(isSimul, "aggiungiDescrizioneAcquisizioneDatiDistributori - END");
	}

	private void aggiungiHeader(Document document) throws DocumentException {
		Paragraph logo = new Paragraph();
		try {
			logo.setAlignment(Paragraph.ALIGN_LEFT);
			logo.add(new Chunk(BaseBuilder.IMG_LOGO, 0, 0, true));
		} catch (Exception e) {
			System.out.println("Immagine mancante");
		}

		document.add(logo);
	}

	private void aggiungiFooter(PdfWriter writer) throws DocumentException {

		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);

		PdfPTable footer = initializeTable(new float[] { 100 });
		footer.getDefaultCell().setBorder(0);
		footer.setTotalWidth(600);
		footer.setLockedWidth(true);

		Paragraph par = new Paragraph("il " + sdf.format(new Date()), FONT_HELVETICA_9);
		footer.addCell(par);
		footer.writeSelectedRows(0, -1, 0, 50, writer.getDirectContent());
	}

	private PdfPTable aggiungiRigaDescrizione(String label, String valore) {
		PdfPTable tabellaDescrizione = initializeTable(new float[] { 10, 25, 65 });

		Paragraph paragraph = new Paragraph("");
		PdfPCell cell = new PdfPCell(paragraph);
		cell.setBorder(0);
		tabellaDescrizione.addCell(cell);

		paragraph = new Paragraph(label, FONT_HELVETICA_10);
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.BOTTOM | Rectangle.LEFT | Rectangle.TOP);
		cell.setPadding(10);
		tabellaDescrizione.addCell(cell);

		paragraph = new Paragraph(valore, FONT_HELVETICA_10);
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.BOTTOM | Rectangle.RIGHT | Rectangle.TOP);
		cell.setPadding(10);
		tabellaDescrizione.addCell(cell);

		return tabellaDescrizione;
	}
}
