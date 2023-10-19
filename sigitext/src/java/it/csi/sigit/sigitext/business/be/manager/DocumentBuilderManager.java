package it.csi.sigit.sigitext.business.be.manager;

import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTPersonaGiuridicaDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitVRicercaAllegatiDto;
import it.csi.sigit.sigitext.business.pdf.BaseBuilder;
import it.csi.sigit.sigitext.business.util.Constants;
import it.csi.sigit.sigitext.business.util.ConvertUtil;
import it.csi.sigit.sigitext.business.util.GenericUtil;
import it.csi.sigit.sigitext.business.util.MapDto;
import it.csi.sigit.sigitext.dto.sigitext.DettaglioIspezione;

import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import static it.csi.sigit.sigitext.business.pdf.BaseBuilder.*;

public class DocumentBuilderManager {

	private DbServiceImp serviceDb;

	public DbServiceImp getDbServiceImp() {
		return serviceDb;
	}

	public void setDbServiceImp(DbServiceImp serviceDb) {
		this.serviceDb = serviceDb;
	}

	public static Font FONT_HELVETICA_18_B = new Font(Font.HELVETICA, 18, Font.BOLD);
	public static Font FONT_HELVETICA_12_B = new Font(Font.HELVETICA, 12, Font.BOLD);
	public static Font FONT_HELVETICA_10 = new Font(Font.HELVETICA, 10);
	public static Font FONT_HELVETICA_9 = new Font(Font.HELVETICA, 9);

	public static String DATE_FORMAT = "dd/MM/yyyy";

	public byte[] generaRicevutaAllegato(String idAllegato) {
		byte[] pdfITextRicevutaAllegato = {};
		SigitVRicercaAllegatiDto allegatoDB = null;
		SigitTPersonaGiuridicaDto personaGiuridicaCat = null;

		try {

			allegatoDB = getDbServiceImp().cercaSigitVRicercaAllegatiByIdAllegato(idAllegato);

			if (GenericUtil.isNotNullOrEmpty(allegatoDB.getFkPgCat())) {
				personaGiuridicaCat = getDbServiceImp().cercaTPersonaGiuridicaById(ConvertUtil.convertToInteger(allegatoDB.getFkPgCat()));
			}

			Document document = creaDocumento(false);
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			PdfWriter writer = PdfWriter.getInstance(document, outputStream);

			document.open();

			aggiungiHeader(document);

			Paragraph title = new Paragraph("Ricevuta avvenuto invio rapporto di controllo", FONT_HELVETICA_18_B);
			title.setSpacingBefore(25);
			document.add(title);

			String ragioneSociale = "";
			String indirizzo = "";
			String codiceFiscale = "";
			String codiceRea = "";
			if (allegatoDB.getRuoloFunz() != null) {
				if (allegatoDB.getRuoloFunz().equalsIgnoreCase(Constants.RUOLO_ISPETTORE)) {
					DettaglioIspezione dettaglioIspezione = getDbServiceImp().getDettaglioIspezioneByIdIspezIspet(ConvertUtil.convertToInteger(allegatoDB.getFkIspezIspet()));
					ragioneSociale = MapDto.costruisciEnteCpompetenteIspettore(dettaglioIspezione);
				} else {
					SigitTPersonaGiuridicaDto personaGiuridicaDto = getDbServiceImp().cercaTPersonaGiuridicaById(ConvertUtil.convertToInteger(allegatoDB.getIdPersonaGiuridica()));

					if (ConvertUtil.convertToBooleanAllways(personaGiuridicaDto.getFlgIndirizzoEstero())) {
						indirizzo = MapDto.getIndirizzoEsteroCompleto(personaGiuridicaDto.getStatoEstero(), personaGiuridicaDto.getCittaEstero(), personaGiuridicaDto.getIndirizzoEstero(), personaGiuridicaDto.getCivico());
					} else {
						indirizzo = MapDto.getIndirizzoCompleto(personaGiuridicaDto.getComune(), personaGiuridicaDto.getIndirizzoSitad(), personaGiuridicaDto.getIndirizzoNonTrovato(), personaGiuridicaDto.getCivico(), personaGiuridicaDto.getSiglaProv());
					}
					ragioneSociale = allegatoDB.getPgDenominazione();
					codiceFiscale = allegatoDB.getPgCodiceFiscale();
					codiceRea = MapDto.getCodiceRea(allegatoDB.getPgSiglaRea(), ConvertUtil.convertToInteger(allegatoDB.getPgNumeroRea()));
				}
			}

			aggiungiDescrizioneImpresa(document, ragioneSociale, indirizzo, codiceFiscale, codiceRea);

			aggiungiDescrizioneImpianto(document, allegatoDB);

			aggiungiDescrizioneRapportoDiControllo(document, allegatoDB, personaGiuridicaCat);

			aggiungiFooter(writer);

			outputStream.flush();
			document.close();
			outputStream.close();

			pdfITextRicevutaAllegato = outputStream.toByteArray();

		} catch (DocumentException docEx) {
			gestError(false, docEx.getMessage(), docEx);
		} catch (Exception ex) {
			gestError(false, ex.getMessage(), ex);
		}
		return pdfITextRicevutaAllegato;
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

	private void aggiungiDescrizioneImpresa(Document document, String ragioneSociale, String indirizzo, String codiceFiscale, String codiceRea) throws DocumentException {
		Paragraph titoloDescrizione = new Paragraph("Descrizione impresa", FONT_HELVETICA_12_B);
		titoloDescrizione.setSpacingBefore(20);
		document.add(titoloDescrizione);
		document.add(aggiungiRigaDescrizione("Ragione Sociale", ragioneSociale));
		document.add(aggiungiRigaDescrizione("Indirizzo", indirizzo));
		document.add(aggiungiRigaDescrizione("Partita IVA/Codice Fiscale", codiceFiscale));
		document.add(aggiungiRigaDescrizione("Codice Rea", codiceRea));
	}

	private void aggiungiDescrizioneImpianto(Document document, SigitVRicercaAllegatiDto allegatoDB) throws DocumentException {
		Paragraph titoloDescrizione = new Paragraph("Descrizione Impianto", FONT_HELVETICA_12_B);
		titoloDescrizione.setSpacingBefore(20);
		document.add(titoloDescrizione);

		document.add(aggiungiRigaDescrizione("Codice Impianto", ConvertUtil.convertToString(allegatoDB.getCodiceImpianto())));
		String ubicazione = MapDto.getIndirizzoCompleto(allegatoDB.getComuneImpianto(), allegatoDB.getIndirizzoUnitaImmob(), null, allegatoDB.getCivicoUnitaImmob(), allegatoDB.getSiglaProvImpianto());
		document.add(aggiungiRigaDescrizione("Ubicazione", ubicazione));
	}

	private void aggiungiDescrizioneRapportoDiControllo(Document document, SigitVRicercaAllegatiDto allegatoDB, SigitTPersonaGiuridicaDto personaGiuridicaCat) throws DocumentException {
		Paragraph titoloDescrizione = new Paragraph("Descrizione rapporto di Controllo", FONT_HELVETICA_12_B);
		titoloDescrizione.setSpacingBefore(20);
		document.add(titoloDescrizione);

		String codiceBollino = "";

		if (GenericUtil.isNotNullOrEmpty(allegatoDB.getFkNumeroBollino())) {
			codiceBollino = allegatoDB.getFkSiglaBollino() + "-" + allegatoDB.getFkNumeroBollino();
		}

		document.add(aggiungiRigaDescrizione("Tipo rapporto", allegatoDB.getDesTipoDocumento()));
		document.add(aggiungiRigaDescrizione("Elenco apparecchiature", allegatoDB.getElencoApparecchiature()));
		document.add(aggiungiRigaDescrizione("Data controllo", ConvertUtil.convertToString(allegatoDB.getDataControllo())));
		document.add(aggiungiRigaDescrizione("Codice bollino", codiceBollino));
		document.add(aggiungiRigaDescrizione("Data invio del rapporto", ConvertUtil.convertToString(allegatoDB.getDataInvio())));

		if (allegatoDB.getDataRespinta() != null) {
			document.add(aggiungiRigaDescrizione("Data respinta del rapporto", ConvertUtil.convertToString(allegatoDB.getDataRespinta())));
		}

		if (personaGiuridicaCat != null) {
			document.add(aggiungiRigaDescrizione("Invio da parte del CAT", personaGiuridicaCat.getDenominazione()));
		}
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

	public static PdfPTable initializeTable(float[] columWidths) {
		PdfPTable tabella = new PdfPTable(columWidths);
		//Definisco la tabella con il 100%, il bordo,e il margine sinistro
		tabella.setSpacingBefore(8);

		tabella.setWidthPercentage(100);
		tabella.getDefaultCell().setBorder(1);

		tabella.getDefaultCell().setPaddingLeft(PADDING_LEFT);
		tabella.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);

		return tabella;

	}
}
