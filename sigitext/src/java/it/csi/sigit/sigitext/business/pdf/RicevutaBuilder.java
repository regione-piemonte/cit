/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitext.business.pdf;

import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTImportDistribRicevutaByIdImportDistribDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTPersonaGiuridicaDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitVRicercaAllegatiDto;
import it.csi.sigit.sigitext.business.util.Constants;
import it.csi.sigit.sigitext.business.util.ConvertUtil;
import it.csi.sigit.sigitext.business.util.GenericUtil;
import it.csi.sigit.sigitext.business.util.MapDto;
import it.csi.sigit.sigitext.dto.sigitext.DettaglioIspezione;
import it.csi.sigit.sigitext.exception.sigitext.SigitextException;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RicevutaBuilder extends BaseBuilder {
	
	private static String FILE = "C:/Repo/CSI/sigit/sigit_sigitwebn/test/";

	
	public static void main(String[] args) {		
		
		try {
			RicevutaBuilder ricevutaAllegato = new RicevutaBuilder();
			
			byte[] libretto = ricevutaAllegato.generaRicevutaImportDistributore(null, true);
			
			FileOutputStream fileStream =  new FileOutputStream(FILE+getDataCompleta()+"_ricevuta_import_distributori.pdf");
			
			fileStream.write(libretto);   
			fileStream.flush(); 
			fileStream.close(); 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public byte[] generaRicevutaAllegato(String idAllegato) {
		return generaRicevutaAllegato(idAllegato, false);
	}
	
	public byte[] generaRicevutaAllegato(String idAllegato, boolean isSimul) {
		gestDebug(isSimul, "generaRicevutaAllegato - START");
		byte[] pdfITextRicevutaAllegato = {};
		SigitVRicercaAllegatiDto allegatoDB = null;
		SigitTPersonaGiuridicaDto personaGiuridicaCat = null;
		
		try {
			if (isSimul) {
				allegatoDB = new SigitVRicercaAllegatiDto();
				allegatoDB.setDataRespinta(ConvertUtil.convertToSqlDate(new Date()));
				personaGiuridicaCat = new SigitTPersonaGiuridicaDto();
				personaGiuridicaCat.setDenominazione("Test CAT");
			}
			else {
				allegatoDB = getDbServiceImp().cercaSigitVRicercaAllegatiByIdAllegato(idAllegato);
				
				if (GenericUtil.isNotNullOrEmpty(allegatoDB.getFkPgCat()))
				{
					personaGiuridicaCat = getDbServiceImp().cercaTPersonaGiuridicaById(ConvertUtil.convertToInteger(allegatoDB.getFkPgCat()));
				}
			}
			
			Document document = creaDocumento(isSimul);
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
				if (allegatoDB.getRuoloFunz().equalsIgnoreCase(Constants.RUOLO_ISPETTORE))
				{
					DettaglioIspezione dettaglioIspezione = getDbServiceImp().getDettaglioIspezioneByIdIspezIspet(ConvertUtil.convertToInteger(allegatoDB.getFkIspezIspet()));
					ragioneSociale = MapDto.costruisciEnteCpompetenteIspettore(dettaglioIspezione);
				}
				else
				{
					SigitTPersonaGiuridicaDto personaGiuridicaDto = getDbServiceImp().cercaTPersonaGiuridicaById(ConvertUtil.convertToInteger(allegatoDB.getIdPersonaGiuridica()));
					
					if (ConvertUtil.convertToBooleanAllways(personaGiuridicaDto.getFlgIndirizzoEstero()))
					{
						indirizzo = MapDto.getIndirizzoEsteroCompleto(personaGiuridicaDto.getStatoEstero(), personaGiuridicaDto.getCittaEstero(), personaGiuridicaDto.getIndirizzoEstero(), personaGiuridicaDto.getCivico());
					}
					else
					{
						indirizzo = MapDto.getIndirizzoCompleto(personaGiuridicaDto.getComune(), personaGiuridicaDto.getIndirizzoSitad(), personaGiuridicaDto.getIndirizzoNonTrovato(), 
								personaGiuridicaDto.getCivico(), personaGiuridicaDto.getSiglaProv());
					}
					ragioneSociale = allegatoDB.getPgDenominazione();
					codiceFiscale = allegatoDB.getPgCodiceFiscale();
					codiceRea = MapDto.getCodiceRea(allegatoDB.getPgSiglaRea(), ConvertUtil.convertToInteger(allegatoDB.getPgNumeroRea()));
				}
			}
			
			aggiungiDescrizioneImpresa(document, ragioneSociale, indirizzo, codiceFiscale, codiceRea, isSimul);
			
			aggiungiDescrizioneImpianto(document, allegatoDB, isSimul);
			
			aggiungiDescrizioneRapportoDiControllo(document, allegatoDB, personaGiuridicaCat, isSimul);
			
			aggiungiFooter(writer);
			
			outputStream.flush();
			document.close();
			outputStream.close();
			
			pdfITextRicevutaAllegato = outputStream.toByteArray();
			
		} catch(DocumentException docEx) {
			gestError(isSimul, docEx.getMessage(), docEx);
		} catch(Exception ex) {
			gestError(isSimul, ex.getMessage(), ex);
		}
	
		gestDebug(isSimul, "generaRicevutaAllegato - END");
		return pdfITextRicevutaAllegato;
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
			}
			else {
				importDistribDB = getDbServiceImp().cercaImportRicevutaByIdDistr(idImportDistrib);
			}
			
			Document document = creaDocumento(isSimul);
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			PdfWriter writer = PdfWriter.getInstance(document, outputStream);
		
			document.open();
			
			aggiungiHeader(document);
			
			Paragraph title = new Paragraph("Ricevuta avvenuta acquisizione dati distributori", FONT_HELVETICA_18_B);
			title.setSpacingBefore(25);
			document.add(title);
			
			String ragioneSociale = importDistribDB.getPgDenominazione();
			String indirizzo =  MapDto.getIndirizzoCompleto(importDistribDB.getPgComune(), importDistribDB.getPgIndirizzoSitad(), importDistribDB.getPgIndirizzoNonTrovato(), 
					importDistribDB.getPgCivico(), importDistribDB.getPgSiglaProv());
			String codiceFiscale = importDistribDB.getPgCodiceFiscale();
			String codiceRea =  MapDto.getCodiceRea(importDistribDB.getPgSiglaRea(), ConvertUtil.convertToInteger(importDistribDB.getPgNumeroRea()));
			
			aggiungiDescrizioneImpresa(document, ragioneSociale, indirizzo, codiceFiscale, codiceRea, isSimul);
			
			aggiungiDescrizioneAcquisizioneDatiDistributori(document, importDistribDB, isSimul);
			
			aggiungiFooter(writer);
			
			outputStream.flush();
			document.close();
			outputStream.close();
			
			pdfITextRicevutaImportDistributore = outputStream.toByteArray();
			
		} catch(DocumentException docEx) {
			gestError(isSimul, docEx.getMessage(), docEx);
		} catch(Exception ex) {
			gestError(isSimul, ex.getMessage(), ex);
		}
	
		gestDebug(isSimul, "generaRicevutaImportDistributore - END");
		return pdfITextRicevutaImportDistributore;
	}
	
	private void aggiungiDescrizioneImpresa(Document document, String ragioneSociale, String indirizzo, String codiceFiscale, String codiceRea, boolean isSimul) throws DocumentException, SigitextException {
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
	
	private void aggiungiDescrizioneImpianto(Document document, SigitVRicercaAllegatiDto allegatoDB, boolean isSimul) throws DocumentException {
		gestDebug(isSimul, "aggiungiDescrizioneImpianto - START");
		
		Paragraph titoloDescrizione = new Paragraph("Descrizione Impianto", FONT_HELVETICA_12_B);
		titoloDescrizione.setSpacingBefore(20);
		document.add(titoloDescrizione);
		
		document.add(aggiungiRigaDescrizione("Codice Impianto", ConvertUtil.convertToString(allegatoDB.getCodiceImpianto())));
		String ubicazione = MapDto.getIndirizzoCompleto(allegatoDB.getComuneImpianto(), allegatoDB.getIndirizzoUnitaImmob(), null, allegatoDB.getCivicoUnitaImmob(), allegatoDB.getSiglaProvImpianto());
		document.add(aggiungiRigaDescrizione("Ubicazione", ubicazione));
		
		gestDebug(isSimul, "aggiungiDescrizioneImpianto - END");
	}
	
	private void aggiungiDescrizioneRapportoDiControllo(Document document, SigitVRicercaAllegatiDto allegatoDB, SigitTPersonaGiuridicaDto personaGiuridicaCat, boolean isSimul) throws DocumentException {
		gestDebug(isSimul, "aggiungiDescrizioneRapportoDiControllo - START");
		
		Paragraph titoloDescrizione = new Paragraph("Descrizione rapporto di Controllo", FONT_HELVETICA_12_B);
		titoloDescrizione.setSpacingBefore(20);
		document.add(titoloDescrizione);
		
		String codiceBollino = "";
		
		if(GenericUtil.isNotNullOrEmpty(allegatoDB.getFkNumeroBollino()))
		{
			codiceBollino = allegatoDB.getFkSiglaBollino() + "-" + allegatoDB.getFkNumeroBollino();
		}
		
		document.add(aggiungiRigaDescrizione("Tipo rapporto", allegatoDB.getDesTipoDocumento()));
		document.add(aggiungiRigaDescrizione("Elenco apparecchiature", allegatoDB.getElencoApparecchiature()));
		document.add(aggiungiRigaDescrizione("Data controllo", ConvertUtil.convertToString(allegatoDB.getDataControllo())));
		document.add(aggiungiRigaDescrizione("Codice bollino", codiceBollino));
		document.add(aggiungiRigaDescrizione("Data invio del rapporto", ConvertUtil.convertToString(allegatoDB.getDataInvio())));
		
		if (allegatoDB.getDataRespinta() != null)
		{
			document.add(aggiungiRigaDescrizione("Data respinta del rapporto", ConvertUtil.convertToString(allegatoDB.getDataRespinta())));
		}
		
		if (personaGiuridicaCat != null)
		{
			document.add(aggiungiRigaDescrizione("Invio da parte del CAT", personaGiuridicaCat.getDenominazione()));
		}
		
		gestDebug(isSimul, "aggiungiDescrizioneRapportoDiControllo - END");
	}
	
	private void aggiungiDescrizioneAcquisizioneDatiDistributori(Document document, SigitTImportDistribRicevutaByIdImportDistribDto importDistribDB, boolean isSimul) throws DocumentException {
		gestDebug(isSimul, "aggiungiDescrizioneAcquisizioneDatiDistributori - START");
		
		Paragraph titoloDescrizione = new Paragraph("Descrizione acquisizione dati distributori", FONT_HELVETICA_12_B);
		titoloDescrizione.setSpacingBefore(20);
		document.add(titoloDescrizione);
		
		document.add(aggiungiRigaDescrizione("Data caricamento dati", ConvertUtil.convertToString(importDistribDB.getIdDataInizioElab())));
		document.add(aggiungiRigaDescrizione("Data acquisizione dati", ConvertUtil.convertToString(importDistribDB.getIdDataFineElab())));
		document.add(aggiungiRigaDescrizione("Data annullamento dati", ConvertUtil.convertToString(importDistribDB.getIdDataAnnullamento())));
		document.add(aggiungiRigaDescrizione("Nome file", ConvertUtil.getStringValid(importDistribDB.getIdNomeFileImport())));
		document.add(aggiungiRigaDescrizione("Anno riferimento", ConvertUtil.convertToString(importDistribDB.getIdAnnoRiferimento())));
		document.add(aggiungiRigaDescrizione("Stato acquisizione", ConvertUtil.getStringValid(importDistribDB.getSdDesStatoDistrib())));
		gestDebug(isSimul, "aggiungiDescrizioneAcquisizioneDatiDistributori - END");
	}
	
	private void aggiungiHeader(Document document) throws DocumentException {
		Paragraph logo = new Paragraph();  
		try{ 
			logo.setAlignment(Paragraph.ALIGN_LEFT);
			logo.add(new Chunk(BaseBuilder.IMG_LOGO, 0, 0,true));
		}catch(Exception e){  
			System.out.println("Immagine mancante");
		}
		
		document.add(logo);
	}
	
	private void aggiungiFooter(PdfWriter writer) throws DocumentException {
		
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
		
		PdfPTable footer = initializeTable(new float[] {100});
		footer.getDefaultCell().setBorder(0);
		footer.setTotalWidth(600);
		footer.setLockedWidth(true);
		
		Paragraph par = new Paragraph("il " + sdf.format(new Date()), FONT_HELVETICA_9);  
		footer.addCell(par);
        footer.writeSelectedRows(0, -1, 0, 50, writer.getDirectContent());        
	}
	
	private PdfPTable aggiungiRigaDescrizione(String label, String valore) {
		PdfPTable tabellaDescrizione = initializeTable(new float[]{10, 25, 65});
		
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
