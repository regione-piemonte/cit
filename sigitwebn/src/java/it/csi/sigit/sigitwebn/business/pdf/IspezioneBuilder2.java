/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitwebn.business.pdf;

import java.awt.Color;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;

//import com.lowagie.text.BaseColor;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.Utilities;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import it.csi.sigit.sigitext.dto.sigitext.Impianto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitRAllegatoCompGtDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTAllegatoDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTCompBrRcBrRcLegateAGtComplexDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTDettIspezGfDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTDettIspezGtDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTImpiantoDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTPersonaFisicaDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTPersonaGiuridicaDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTRappIspezGfDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTRappIspezGtDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTTrattH2ODto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTUnitaImmobiliareDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitVSk4GfDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitVSk4GtDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitTCompBrRcDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.CompFilter;
import it.csi.sigit.sigitwebn.business.manager.util.DbManagerException;
import it.csi.sigit.sigitwebn.business.manager.util.Message;
import it.csi.sigit.sigitwebn.dto.allegati.DettaglioAllegato;

//itext 5.5.0 - non si puo' usare
//import com.itextpdf.text.BaseColor;
//import com.itextpdf.text.Chunk;
//import com.itextpdf.text.Document;
//import com.itextpdf.text.DocumentException;
//import com.itextpdf.text.Element;
//import com.itextpdf.text.Font;
//import com.itextpdf.text.Image;
//import com.itextpdf.text.PageSize;
//import com.itextpdf.text.Paragraph;
//import com.itextpdf.text.Rectangle;
//import com.itextpdf.text.Utilities;
//import com.itextpdf.text.pdf.PdfPCell;
//import com.itextpdf.text.pdf.PdfPTable;
//import com.itextpdf.text.pdf.PdfWriter;

import it.csi.sigit.sigitwebn.dto.index.DettaglioDocumento;
import it.csi.sigit.sigitwebn.dto.ispezioni.DettaglioIspezione;
import it.csi.sigit.sigitwebn.dto.ispezioni.Ispezione2018;
import it.csi.sigit.sigitwebn.util.Constants;
import it.csi.sigit.sigitwebn.util.ConvertUtil;
import it.csi.sigit.sigitwebn.util.DateUtil;
import it.csi.sigit.sigitwebn.util.GenericUtil;
//import test.sigitwebn.Phrase;
import it.csi.sigit.sigitwebn.util.MapDto;
import it.csi.sigit.sigitwebn.util.Messages;

public class IspezioneBuilder2 extends BaseBuilder {

	private static String FILE = "D:/progetti/eclipse oxygen/sigit/sigit_sigitwebn/src/java/test/sigitwebn/TestIspezioneGT";

	public static String getDataCompleta() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HH_mm_ss");
		return sdf.format(new Date());
	}

	
	public static void main(String[] args) {
		try {
			IspezioneBuilder2 ispezione = new IspezioneBuilder2();

			DettaglioDocumento dettaglioDocumento = ispezione.generaIspezioneGt(null, true);
			byte[] libretto = dettaglioDocumento.getFile(); 


			FileOutputStream fileStream =  new FileOutputStream(FILE+getDataCompleta()+".pdf"); 

			//FileOutputStream fileStream = new FileOutputStream("scarico/"+tipoDoc+"_"+idLibretto+"_"+nomeFile+".xml"); 
			fileStream.write(libretto);   
			fileStream.flush(); 
			fileStream.close(); 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public DettaglioDocumento generaIspezioneGt(DettaglioAllegato ispezione, boolean isSimulazione)
	{
		DettaglioDocumento result = new DettaglioDocumento();

		try
		{
			Integer idIspezione = null;
		
			DatiGTCommon allegato1Common = null; 
			List<SigitVSk4GtDto> allegatoCompGtList = null;
			List<SigitTDettIspezGtDto> dettIspezList = null;

			Ispezione2018 dettaglioIspezione = null;

			SigitTAllegatoDto allegato = null;

			SigitTRappIspezGtDto rappIspez = null;
			
			
			SigitTUnitaImmobiliareDto unitaImmobPrincipale = null;

			 SigitTImpiantoDto impianto = null;
			 SigitTTrattH2ODto h2O = null;
			 

			if (!isSimulazione)
			{
				idIspezione = ispezione.getIdIspezione2018();
				
				allegato1Common = getSigitMgr().cercaDatiAllegato1Common(ispezione); 

				allegatoCompGtList = allegato1Common.getSk4GtDtoList();
				 impianto = allegato1Common.getImpiantoDto();
				 h2O = allegato1Common.getDettaglioTrattAcquaDto();
				 

				dettaglioIspezione = getSigitMgr().caricaIspezioneDaId(ConvertUtil.convertToString(idIspezione), false, true);

				allegato = allegato1Common.getAllegatoDto();

				rappIspez = getSigitMgr().cercaRappIspezioneGtByIdIspez(allegato.getIdAllegato());
				
				dettIspezList = getSigitMgr().cercaDettIspezioneListGtByIdIspez(allegato.getIdAllegato(), null);
				
				for (SigitTUnitaImmobiliareDto ui : allegato1Common.getUnitaImmobiliareList()) {
					 if(ConvertUtil.convertToBooleanAllways(ui.getFlgPrincipale()))
						 unitaImmobPrincipale = ui;
				 }
				
			}
			else
			{
				idIspezione = 20;
				
				allegato1Common = new DatiGTCommon();
				
				allegato1Common.setPersonaFisicaDto(new SigitTPersonaFisicaDto());
				allegato1Common.setPersonaGiuridicaDto(new SigitTPersonaGiuridicaDto());
				
				 impianto = new SigitTImpiantoDto();
				 h2O = new SigitTTrattH2ODto();

				dettaglioIspezione = new Ispezione2018();
				
				allegato1Common.setImpiantoDto(new SigitTImpiantoDto());
				allegato1Common.setAllegatoDto(new SigitTAllegatoDto());

				allegato = new SigitTAllegatoDto();
				allegato.setFkStatoRapp(ConvertUtil.convertToBigDecimal(Constants.ID_STATO_RAPPORTO_BOZZA));
				
				rappIspez = new SigitTRappIspezGtDto();
				
				allegatoCompGtList = new ArrayList<SigitVSk4GtDto>();
				allegatoCompGtList.add(new SigitVSk4GtDto());
				
				dettIspezList = new ArrayList<SigitTDettIspezGtDto>();
				dettIspezList.add(new SigitTDettIspezGtDto());
				
				unitaImmobPrincipale = new SigitTUnitaImmobiliareDto();
			}
			
			
			log.debug("generaIspezione - START");
			Document document = creaDocumento(isSimulazione);
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			PdfWriter writer = PdfWriter.getInstance(document, outputStream);

			log.debug("generaIspezione - PASSO 1");

			//PdfWriter.getInstance(document, new FileOutputStream(FILE+getDataCompleta()+".pdf"));
			document.open();

			if (ConvertUtil.convertToInteger(allegato.getFkStatoRapp()) == Constants.ID_STATO_RAPPORTO_BOZZA)
			{
				// Aggiungo il Watermark (filigrana)
				writer.setPageEvent(new PDFEventListener(ConvertUtil.convertToInteger(allegato.getFkStatoRapp()) == Constants.ID_STATO_RAPPORTO_BOZZA));
			}

			log.debug("generaIspezione - PASSO 2");

			//aggiungiMetaDati(document);

			log.debug("generaIspezione - PASSO 3");

			aggiungiIntestazioneGT(document);

			log.debug("generaIspezione - PASSO 4");


			// QUESTA E' UNA PROVA -- inizio
			/*
			List<SigitVSk4GtDto> allegatoCompGtListNew = new ArrayList<SigitVSk4GtDto>();
			
			for (int i = 0; i < 100; i++) {
				allegatoCompGtListNew.addAll(allegatoCompGtList);
			}
			
			allegatoCompGtList = allegatoCompGtListNew;
			*/
			
			// QUESTA E' UNA PROVA -- fine
			
			//document.add(new Paragraph("Foglio n�_________ di __________", FONT_HELVETICA_9_I));

			int numPagine = 1;
			String totPagine = ConvertUtil.convertToString(allegatoCompGtList.size()+1);
			
			/*
			Paragraph p3 = new Paragraph("Foglio n� ", FONT_HELVETICA_9_I);
			//p3.add("Foglio n� ");
			aggiungiTesto(p3, ConvertUtil.convertToString(++numPagine), 5);
			p3.add(" di ");
			aggiungiTesto(p3,totPagine , 10);
			*/
			
			Paragraph p3 = aggiungiNumFoglio(numPagine++, totPagine);
			document.add(p3);

			//document.add( Chunk.LINEHEIGHT);

			log.debug("generaIspezione - PASSO 5");

			aggiungiDatiGeneraliGT(document, idIspezione, dettaglioIspezione, rappIspez, allegato1Common, unitaImmobPrincipale);

			log.debug("generaIspezione - PASSO 6");

			aggiungiDestinazioneGT(document, impianto, h2O, unitaImmobPrincipale, rappIspez);

			log.debug("generaIspezione - PASSO 7");

			aggiungiControlloImpiantoGT(document, rappIspez);

			log.debug("generaIspezione - PASSO 8");

			aggiungiStatoDocumentazioneGT(document, rappIspez);

			log.debug("generaIspezione - PASSO 9");

			aggiungiInterventiMiglioramentoGT(document, rappIspez);
			
			
			
			SigitVSk4GtDto sigitRAllegatoCompGtDto = null;
			for (int i = 0; i < allegatoCompGtList.size(); i++) {
				sigitRAllegatoCompGtDto = allegatoCompGtList.get(i);
				
			
				// Nuova pagina
				 document.newPage();
				 
			     //document.add(new Paragraph("Foglio n�_________ di _________ Catasto impianti/codice: _________ Data dell'ispezione: _________ N� _________", FONT_HELVETICA_9_I));
			    /*
				 p3 = new Paragraph("Foglio n� ", FONT_HELVETICA_9_I);
					//p3.add("Foglio n� ");
					aggiungiTesto(p3, ConvertUtil.convertToString(numPagine++), 10);
					p3.add(" di ");
					//aggiungiTesto(p3, totPagine , 10);
					*/
				 
					p3 = aggiungiNumFoglio(numPagine++, totPagine);

					p3.add("Catasto impianti/codice: ");
					aggiungiTesto(p3, ConvertUtil.getStringValid(allegato1Common.getImpiantoDto().getCodiceImpianto()) , 10);
					p3.add("Data dell'ispezione: ");
					aggiungiTesto(p3, ConvertUtil.getStringValid(allegato1Common.getAllegatoDto().getDataControllo()) , 15);
					p3.add("N\u00B0 ");
					aggiungiTesto(p3, ConvertUtil.getStringValid(idIspezione) , 10);

					document.add(p3);
					
					List<SigitTCompBrRcBrRcLegateAGtComplexDto> bruciatoriAssociati = null;
					if (!isSimulazione)
					{
						// Devo recuperare i bruciatori collegati al GT
						bruciatoriAssociati = getSigitMgr().cercaBrRcLegateAGt(sigitRAllegatoCompGtDto.getCodiceImpianto(), sigitRAllegatoCompGtDto.getDataInstall(), sigitRAllegatoCompGtDto.getProgressivo(), sigitRAllegatoCompGtDto.getDataControllo());
					}
					else
					{
						bruciatoriAssociati = new ArrayList<SigitTCompBrRcBrRcLegateAGtComplexDto>();
					}
					
					
			     // Devo recuperare da r_allegato_comp_gt quanti GT ci sono (es GT-1, GT2, ecc)
			     // devo recuperare su comp_gt i dati
			     // PER ADESSO NON RECUPERARE - devo recuperare su sigit_t_comp_br_rc x i bruciatori
				 aggiungiGeneratoreGT(document, dettIspezList.get(0), sigitRAllegatoCompGtDto, bruciatoriAssociati);

				 aggiungiManutenzioneAnalisiGT(document, dettIspezList.get(0));
				 
				 for (SigitTDettIspezGtDto sigitTDettIspezGtDto : dettIspezList) {
					
					 aggiungiMisuraDeiProdottiGT(document, sigitTDettIspezGtDto, dettIspezList.size());

					 aggiungiEsitoProvaGT(document, sigitTDettIspezGtDto);

				 }
				 
				 
				 aggiungiOssPrescrDich(document, allegato);
				 
			}
			 
			 // Nuova pagina
			 //document.newPage();

			 //createTabellaProvaPdf(document);
			 
			 //aggiungiContenuto(document);


				outputStream.flush();
				document.close();
				outputStream.close();

				log.debug("generaIspezione - PASSO 13");

				byte[] thePdfIText = outputStream.toByteArray();

				log.debug("generaIspezione - PASSO 14");

				result.setFile(thePdfIText);
				result.setNomeDocumento("Ispezione_IText.pdf");
				
			 
		}
		catch (DocumentException e) {
			// TODO: handle exception
			log.error("DocumentException", e);

			if (isSimulazione)
			{
				System.err.println("DocumentException: " + e);
				e.printStackTrace();
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			log.error("Exception", e);
			
			if (isSimulazione)
			{
				System.err.println("Exception: " + e);
				e.printStackTrace();
			}
		}

		log.debug("generaIspezione - END");

		return result;

	}
	
	
	 private static void aggiungiIntestazioneGT(Document document) throws DocumentException {
		 // Paragraph prefazione = new Paragraph();

		 //Oltre a creare una semplice tabella, questo metodo e anche buono se si vuole gestire il foglio in sezioni, in modo molto semplice. L�idea � paragonabile alla programmazione HTML, quando si usano le tabelle.
		 //float paddingleft=10f; //Margine Sx 

		 //Suddivido il foglio in sezioni, cio� in questo caso, un foglio 100% viene diviso in due sezioni, su 8 la prima � larga 2 e l�altra larga 6. Le sezioni possono essere anche di pi� spartizioni, basta solo aggiungere un valore dopo la virgola es. {3,3,3} suddividiamo in tre sezioni uguali tra di loro.
		 float[] columnWidths = {2,8}; 

		 PdfPTable tabella = new PdfPTable(columnWidths);
		 //Definisco la tabella con il 100%, il bordo,e il margine sinis

		 tabella.setWidthPercentage(100); 
		 tabella.getDefaultCell().setBorder(2);
		 tabella.getDefaultCell().setBackgroundColor(Color.LIGHT_GRAY);
		 tabella.getDefaultCell().setPaddingLeft(PADDING_LEFT);

		 
		 
		 //tabella.addCell("Prova 1");
		 
		 //A questo punto viene definito la cella, in cui gli metto il testo e tutto e infine lo aggiungo alla tabella. Rifacendo le stesse istruzioni, ci spostiamo nella prossima cella.

		 //Modo per inserire un�immagine all�interno di una cella
		 PdfPCell c1;

		 Paragraph p2 = new Paragraph();  
		 
		 //Image image = getImmagineLogo();
		 try{ 
			 //image=  Image.getInstance("D:/progetti/eclipse oxygen/energia/sigit_sigitwebn/src/web/sigitwebn/img/logo.jpg");
			 //image.scaleAbsolute(70f, 35f); 
			 p2.setAlignment(Paragraph.ALIGN_LEFT);
			 p2.add(new Chunk(IMG_LOGO, 0, 0,true));
		 }catch(Exception e){  
			 System.out.println("Immagine mancante");
			 //JOptionPane.showMessageDialog(null, "IMMAGINE MANCANTE");
		 }
		 c1 = new PdfPCell(p2);
		 c1.setHorizontalAlignment(Element.ALIGN_LEFT);
		 c1.setBackgroundColor(Color.LIGHT_GRAY);
	     c1.setRowspan(3);
	     //c1.setBorderWidthTop(2);

		 //c1.setBorder(1); 
		 tabella.addCell(c1);
		 tabella.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);

		 
		 PdfPCell c2;

		 c2 = new PdfPCell(new Paragraph("RAPPORTO DI PROVA", FONT_HELVETICA_11_B));
		 c2.setHorizontalAlignment(Element.ALIGN_CENTER); 
		 c2.setBackgroundColor(Color.LIGHT_GRAY);
		 //c2.setUseVariableBorders(true);
		 //c2.setBorderColorBottom(Color.RED);
		 c2.setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.TOP);
		 tabella.addCell(c2);
		 c2 = new PdfPCell(new Paragraph("ISPEZIONE IMPIANTI TERMICI CON GENERATORI DI CALORE A FIAMMA", FONT_HELVETICA_9_B));
		 c2.setHorizontalAlignment(Element.ALIGN_CENTER); 
		 c2.setBackgroundColor(Color.LIGHT_GRAY);
		 c2.setBorder(Rectangle.LEFT | Rectangle.RIGHT);
		 //c2.setPhrase(new Paragraph("ISPEZIONE IMPIANTI TERMICI CON GENERATORI DI CALORE A FIAMMA", FONT_TIMES_8_B));
		 tabella.addCell(c2);
		 //c2.setPhrase(new Paragraph("(ai sensi del D.Lgs. 192/05, del D.P.R. 16 aprile 2013 n. 74 e della D.G.R. 29 dicembre 2015 n. 23-2724)", FONT_TIMES_6_B));
		 c2 = new PdfPCell(new Paragraph("(ai sensi del D.Lgs. 192/05, del D.P.R. 16 aprile 2013 n. 74 e della D.G.R. 29 dicembre 2015 n. 23-2724)", FONT_HELVETICA_7_B));
		 c2.setHorizontalAlignment(Element.ALIGN_CENTER); 
		 c2.setBackgroundColor(Color.LIGHT_GRAY);
		 c2.setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.BOTTOM);
		 tabella.addCell(c2);

		 document.add(tabella); //AGGIUNGO LA TABELLA NEL DOCUMENTO
	 }
	 

	

	
	 private static void aggiungiDatiGeneraliGT(Document document, Integer idIspezione, Ispezione2018 dettaglioIspezione, SigitTRappIspezGtDto rappIspez, DatiGTCommon allegato1Common, SigitTUnitaImmobiliareDto unitaImmobPrincipale) throws DocumentException {
		 // Paragraph prefazione = new Paragraph();
	
		 //Oltre a creare una semplice tabella, questo metodo e anche buono se si vuole gestire il foglio in sezioni, in modo molto semplice. L�idea � paragonabile alla programmazione HTML, quando si usano le tabelle.
		 //float paddingleft=10f; //Margine Sx 
	
			SigitTPersonaFisicaDto pf = allegato1Common.getPersonaFisicaDto();
			SigitTPersonaGiuridicaDto pg = allegato1Common.getPersonaGiuridicaDto();
	
		 SigitTImpiantoDto impiantoDto = allegato1Common.getImpiantoDto();
		 SigitTAllegatoDto allegatoDto = allegato1Common.getAllegatoDto();
	
		 //Suddivido il foglio in sezioni, cio� in questo caso, un foglio 100% viene diviso in due sezioni, su 8 la prima � larga 2 e l�altra larga 6. Le sezioni possono essere anche di pi� spartizioni, basta solo aggiungere un valore dopo la virgola es. {3,3,3} suddividiamo in tre sezioni uguali tra di loro.
		 float[] columnWidths = {20,25,25,30}; 
	
		 PdfPTable tabella = new PdfPTable(columnWidths);
		 //Definisco la tabella con il 100%, il bordo,e il margine sinis
		 tabella.setSpacingBefore(8);      
	
		 tabella.setWidthPercentage(100); 
		 tabella.getDefaultCell().setBorder(1);
		 tabella.getDefaultCell().setPaddingLeft(PADDING_LEFT);
		 
		 PdfPCell c1;
		 c1 = new PdfPCell(new Paragraph("1. DATI GENERALI", FONT_HELVETICA_9_B_I));
		 c1.setHorizontalAlignment(Element.ALIGN_CENTER); 
		 c1.setBackgroundColor(Color.LIGHT_GRAY);
	     c1.setColspan(4);
		 tabella.addCell(c1);
	
		 tabella.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
	
	
		 c1 = new PdfPCell(new Paragraph("a) Catasto impianti/codice: ", FONT_HELVETICA_8));
		 tabella.addCell(c1);
		 
		 c1 = new PdfPCell(new Paragraph(ConvertUtil.getStringValid(impiantoDto.getCodiceImpianto()), FONT_HELVETICA_8));
	     c1.setColspan(3);
		 tabella.addCell(c1);
	
		 c1 = new PdfPCell(new Paragraph("b) Ispezione", FONT_HELVETICA_8));
		 tabella.addCell(c1);
		 
		 c1 = new PdfPCell(new Paragraph("Data: "+ConvertUtil.getStringValid(allegatoDto.getDataControllo()), FONT_HELVETICA_8));
		 tabella.addCell(c1);
	
		 c1 = new PdfPCell(new Paragraph("Ora: "+GenericUtil.getStringValid(allegatoDto.getFOraArrivo()), FONT_HELVETICA_8));
		 tabella.addCell(c1);
	
		 c1 = new PdfPCell(new Paragraph("Numero: "+ConvertUtil.getStringValid(idIspezione), FONT_HELVETICA_8));
		 tabella.addCell(c1);
	
		 document.add(tabella); //AGGIUNGO LA TABELLA NEL DOCUMENTO
		 
		 //Suddivido il foglio in sezioni, cio� in questo caso, un foglio 100% viene diviso in due sezioni, su 8 la prima � larga 2 e l�altra larga 6. Le sezioni possono essere anche di pi� spartizioni, basta solo aggiungere un valore dopo la virgola es. {3,3,3} suddividiamo in tre sezioni uguali tra di loro.
		 float[] columnWidths2 = {20,25,25,30}; 
	
		 PdfPTable tabella2 = new PdfPTable(columnWidths2);
		 //Definisco la tabella con il 100%, il bordo,e il margine sinis
	
		 tabella2.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
		 //tabella2.getDefaultCell().setVerticalAlignment(Element.ALIGN_BOTTOM);
	
		 tabella2.setWidthPercentage(100); 
		 tabella2.getDefaultCell().setBorder(1);
		 tabella2.getDefaultCell().setPaddingLeft(PADDING_LEFT);
		 //tabella2.setTotalWidth(Utilities.millimetersToPoints(100));
	     //tabella2.setLockedWidth(true);
		 
		 PdfPCell c2;
		 c2 = new PdfPCell(new Paragraph("c) Rapporto di controllo efficienza", FONT_HELVETICA_8));
		 c2.setVerticalAlignment(Element.ALIGN_MIDDLE);
	     c2.setRowspan(2);
		 tabella2.addCell(c2);
	
		 
		 
		 Paragraph p = new Paragraph("Inviato   ", FONT_HELVETICA_8);
		 aggiungiCheckSi(p, GenericUtil.getCheckSi(rappIspez.getS1cFlgReeInviato()));
		 aggiungiCheckNo(p, GenericUtil.getCheckNo(rappIspez.getS1cFlgReeInviato()));
		 
		 c2 = new PdfPCell(p);
		 c2.setVerticalAlignment(Element.ALIGN_MIDDLE);
	     c2.setRowspan(2);
		 tabella2.addCell(c2);
	
	
		 p = new Paragraph("Bollino   ", FONT_HELVETICA_8);
		 aggiungiCheckSi(p, GenericUtil.getCheckSi(rappIspez.getS1cFlgReeBollino()));
		 aggiungiCheckNo(p, GenericUtil.getCheckNo(rappIspez.getS1cFlgReeBollino()));
		 
		 c2 = new PdfPCell(p);
		 c2.setVerticalAlignment(Element.ALIGN_MIDDLE);
	     c2.setRowspan(2);
		 tabella2.addCell(c2);
	
		 c2 = new PdfPCell(new Paragraph("N\u00B0 bollino "+ConvertUtil.formattaSiglaBollino(rappIspez.getS1cSiglaBollino(), rappIspez.getS1cNumBollino()), FONT_HELVETICA_8));
		 tabella2.addCell(c2);
	
		 c2 = new PdfPCell(new Paragraph("Data bollino "+ConvertUtil.getStringValid(rappIspez.getS1cDataRee()), FONT_HELVETICA_8));
		 tabella2.addCell(c2);
	
		 
		 document.add(tabella2); //AGGIUNGO LA TABELLA NEL DOCUMENTO
		 
		 float[] columnWidths3 = {15,30,15,10,24,21}; 
	
		 PdfPTable tabella3 = new PdfPTable(columnWidths3);
		 //Definisco la tabella con il 100%, il bordo,e il margine sinis
	
		 tabella3.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
		 //tabella2.getDefaultCell().setVerticalAlignment(Element.ALIGN_BOTTOM);
	
		 tabella3.setWidthPercentage(100); 
		 tabella3.getDefaultCell().setBorder(1);
		 tabella3.getDefaultCell().setPaddingLeft(PADDING_LEFT);
		 //tabella2.setTotalWidth(Utilities.millimetersToPoints(100));
	     //tabella2.setLockedWidth(true);
		 
		 PdfPCell c3;
		 
		 // Prima riga tabella3
		 c3 = new PdfPCell(new Paragraph("d) Ispettore", FONT_HELVETICA_8));
		 //c3.setVerticalAlignment(Element.ALIGN_MIDDLE);
	     //c3.setRowspan(2);
		 tabella3.addCell(c3);
	
		 c3 = new PdfPCell(new Paragraph("Cognome e nome: "+GenericUtil.getStringValid(dettaglioIspezione.getDescrizioneIspettore()), FONT_HELVETICA_8));
		 //c3.setVerticalAlignment(Element.ALIGN_MIDDLE);
	     c3.setColspan(2);
	     tabella3.addCell(c3);
	
	
		 c3 = new PdfPCell(new Paragraph("Estremi/qualifica:", FONT_HELVETICA_8));
		 //c3.setVerticalAlignment(Element.ALIGN_MIDDLE);
	     c3.setColspan(3);
	     tabella3.addCell(c3);
	
	     
	     
		 // Seconda riga tabella3
	     c3 = new PdfPCell(new Paragraph("e) Impianto", FONT_HELVETICA_8));
		 tabella3.addCell(c3);
	     
		 c3 = new PdfPCell(new Paragraph("Data prima installazione: "+ConvertUtil.getStringValid(rappIspez.getS1eDtPrimaInstallazione()), FONT_HELVETICA_8));
		 //c3.setVerticalAlignment(Element.ALIGN_MIDDLE);
	     //c3.setColspan(2);
	     tabella3.addCell(c3);
	     
	     
	     c3 = new PdfPCell(new Paragraph("Potenze termiche nominali totali:", FONT_HELVETICA_8));
		 //c3.setVerticalAlignment(Element.ALIGN_MIDDLE);
	     c3.setColspan(2);
	     tabella3.addCell(c3);
	     
	     c3 = new PdfPCell(new Paragraph("al focolare "+ConvertUtil.getStringValid(rappIspez.getS1ePotFocolareKw())+" (kW)", FONT_HELVETICA_8));
		 //c3.setVerticalAlignment(Element.ALIGN_MIDDLE);
	     //c3.setColspan(2);
	     tabella3.addCell(c3);
	     
	     c3 = new PdfPCell(new Paragraph("Utile "+ConvertUtil.getStringValid(rappIspez.getS1ePotUtileKw())+" (kW)", FONT_HELVETICA_8));
		 //c3.setVerticalAlignment(Element.ALIGN_MIDDLE);
	     //c3.setColspan(2);
	     tabella3.addCell(c3);
		 
	     
	     
		 // Terza riga tabella3
	     c3 = new PdfPCell(new Paragraph("f) Ubicazione", FONT_HELVETICA_8));
		 c3.setVerticalAlignment(Element.ALIGN_MIDDLE);
	     c3.setRowspan(2);
	     tabella3.addCell(c3);
	
	     c3 = new PdfPCell(new Paragraph("Comune: "+impiantoDto.getDenominazioneComune(), FONT_HELVETICA_8));
		 //c3.setVerticalAlignment(Element.ALIGN_MIDDLE);
	     c3.setColspan(2);
	     tabella3.addCell(c3);
	     
	     
	     c3 = new PdfPCell(new Paragraph("Localita': "+impiantoDto.getSiglaProvincia(), FONT_HELVETICA_8));
		 //c3.setVerticalAlignment(Element.ALIGN_MIDDLE);
	     c3.setColspan(3);
	     tabella3.addCell(c3);
	     
	     String indirizzo = GenericUtil.isNotNullOrEmpty(unitaImmobPrincipale.getIndirizzoSitad()) ? 
					unitaImmobPrincipale.getIndirizzoSitad() : unitaImmobPrincipale.getIndirizzoNonTrovato();
	     
	     c3 = new PdfPCell(new Paragraph("Indirizzo: "+indirizzo, FONT_HELVETICA_8));
		 //c3.setVerticalAlignment(Element.ALIGN_MIDDLE);
	     c3.setColspan(5);
	     tabella3.addCell(c3);
	     
	     
		 // Quarta riga tabella3
	     c3 = new PdfPCell(new Paragraph("f1)Dati cat.", FONT_HELVETICA_8));
		 //c3.setVerticalAlignment(Element.ALIGN_MIDDLE);
	     //c3.setRowspan(2);
	     tabella3.addCell(c3);
	
	     
	     
	     log.debug("@@ Stampo getSezione: "+unitaImmobPrincipale.getSezione());
	     log.debug("@@ Stampo getFoglio: "+unitaImmobPrincipale.getFoglio());
	     log.debug("@@ Stampo getParticella: "+unitaImmobPrincipale.getParticella());
	     log.debug("@@ Stampo getSubalterno: "+unitaImmobPrincipale.getSubalterno());
	     
		 Paragraph p3 = new Paragraph("", FONT_HELVETICA_8);
		 p3.add("Sezione: ");
		 aggiungiTesto(p3, ConvertUtil.getStringValid(unitaImmobPrincipale.getSezione()), 30);
		 p3.add("Foglio: ");
		 aggiungiTesto(p3, ConvertUtil.getStringValid(unitaImmobPrincipale.getFoglio()), 30);
		 p3.add("Particella: ");
		 aggiungiTesto(p3, ConvertUtil.getStringValid(unitaImmobPrincipale.getParticella()), 30);
		 p3.add("Subalterno: ");
		 aggiungiTesto(p3, ConvertUtil.getStringValid(unitaImmobPrincipale.getSubalterno()), 30);
		 
	     c3 = new PdfPCell(p3);
	     c3.setColspan(5);
	     tabella3.addCell(c3);
	     
		 // Quarta riga tabella3
	     c3 = new PdfPCell(new Paragraph("f2)Id. utenze", FONT_HELVETICA_8));
		 //c3.setVerticalAlignment(Element.ALIGN_MIDDLE);
	     //c3.setRowspan(2);
	     tabella3.addCell(c3);
	     
		 p3 = new Paragraph("", FONT_HELVETICA_8);
		 p3.add("POD: ");
		 aggiungiTesto(p3, unitaImmobPrincipale.getPodElettrico(), 50);
		 p3.add("PDR: ");
		 p3.add(unitaImmobPrincipale.getPdrGas());
		 
	     c3 = new PdfPCell(p3);
	     c3.setColspan(5);
	     tabella3.addCell(c3);
	
	
	     
	     
		 // Quinta riga tabella3
	     c3 = new PdfPCell(new Paragraph("g) Responsabile", FONT_HELVETICA_8));
		 //c3.setVerticalAlignment(Element.ALIGN_MIDDLE);
	     //c3.setRowspan(2);
	     tabella3.addCell(c3);
	     
		 p3 = new Paragraph("", FONT_HELVETICA_8);
		 
		 boolean isOccupante = false;
		 boolean isProprietario = false;
		 boolean is3Resp = false;
		 boolean isAmministr = false;
	
		 if (allegato1Common.isTerzoResp())
		 {
			 is3Resp = true;
			 
			 aggiungiCheckDopo(p3, "Occupante", isOccupante, 40); // sicuramente e' false
			 aggiungiCheckDopo(p3, "Proprietario", isProprietario, 40); // sicuramente e' false
			 aggiungiCheckDopo(p3, "Terzo Responsabile", is3Resp, 40); // sicuramente e' true
			 aggiungiCheckDopo(p3, "Amministratore di Condominio", isAmministr, 40); // sicuramente e' false
		 }
		 else
		 {
			 int ruolo = allegato1Common.getRuolo();
			 
			 isOccupante = (Constants.ID_RUOLO_OCCUPANTE == ruolo) || (Constants.ID_RUOLO_RESPONSABILE_IMPRESA_OCCUPANTE ==  ruolo);
			 isProprietario = (Constants.ID_RUOLO_PROPRIETARIO == ruolo) || (Constants.ID_RUOLO_RESPONSABILE_IMPRESA_PROPRIETARIO ==  ruolo);
			 isAmministr = (Constants.ID_RUOLO_AMMINISTRATORE == ruolo) || (Constants.ID_RUOLO_RESPONSABILE_IMPRESA_AMMINISTRATORE ==  ruolo);
			 
			 aggiungiCheckDopo(p3, "Occupante", isOccupante, 40);
			 aggiungiCheckDopo(p3, "Proprietario", isProprietario, 40);
			 aggiungiCheckDopo(p3, "Terzo Responsabile", is3Resp, 40); // sicuramente e' false
			 aggiungiCheckDopo(p3, "Amministratore di Condominio", isAmministr, 40);
			 
		 }
		 
	     c3 = new PdfPCell(p3);
	     c3.setColspan(5);
	     tabella3.addCell(c3);
	
		 document.add(tabella3); //AGGIUNGO LA TABELLA NEL DOCUMENTO
	
		 float[] columnWidths4 = {3,20,37,3,20,37}; 
	
		 PdfPTable tabella4 = new PdfPTable(columnWidths4);
		 //Definisco la tabella con il 100%, il bordo,e il margine sinis
	
		 tabella4.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
		 //tabella4.getDefaultCell().setVerticalAlignment(Element.ALIGN_BOTTOM);
	
		 tabella4.setWidthPercentage(100); 
		 tabella4.getDefaultCell().setBorder(1);
		 tabella4.getDefaultCell().setPaddingLeft(PADDING_LEFT);
		 //tabella4.setTotalWidth(Utilities.millimetersToPoints(100));
		 //tabella4.setLockedWidth(true);
	
		 PdfPCell c4;
	
		 // Prima riga tabella4 colonna 1 
		 c4 = new PdfPCell(new Paragraph("h) Occupante", FONT_HELVETICA_8_I));
		 c4.setRotation(90);
		 c4.setVerticalAlignment(Element.ALIGN_MIDDLE);
		 c4.setHorizontalAlignment(Element.ALIGN_CENTER);
		 c4.setRowspan(7);
		 tabella4.addCell(c4);
	
		 c4 = new PdfPCell(new Paragraph("Cognome e nome", FONT_HELVETICA_8));
		 tabella4.addCell(c4);
	
		 c4 = new PdfPCell(new Paragraph(getCognomeNome(isOccupante, pf, pg), FONT_HELVETICA_8));
		 tabella4.addCell(c4);
	
	
		 // Prima riga tabella4 colonna 2
		 c4 = new PdfPCell(new Paragraph("i) Proprietario", FONT_HELVETICA_8_I));
		 c4.setRotation(90);
		 c4.setVerticalAlignment(Element.ALIGN_MIDDLE);
		 c4.setHorizontalAlignment(Element.ALIGN_CENTER);
		 c4.setRowspan(7);
		 tabella4.addCell(c4);
	
		 c4 = new PdfPCell(new Paragraph("Cognome e nome", FONT_HELVETICA_8));
		 tabella4.addCell(c4);
	
		 c4 = new PdfPCell(new Paragraph(getCognomeNome(isProprietario, pf, pg), FONT_HELVETICA_8));
		 tabella4.addCell(c4);
	
		 c4 = new PdfPCell(new Paragraph("Ragione sociale", FONT_HELVETICA_8));
		 tabella4.addCell(c4);
	
		 c4 = new PdfPCell(new Paragraph(getRagioneSociale(isOccupante, pf, pg), FONT_HELVETICA_8));
		 tabella4.addCell(c4);
	
		 c4 = new PdfPCell(new Paragraph("Ragione sociale", FONT_HELVETICA_8));
		 tabella4.addCell(c4);
	
		 c4 = new PdfPCell(new Paragraph(getRagioneSociale(isProprietario, pf, pg), FONT_HELVETICA_8));
		 tabella4.addCell(c4);
	
		 c4 = new PdfPCell(new Paragraph("Comune", FONT_HELVETICA_8));
		 tabella4.addCell(c4);
	
		 c4 = new PdfPCell(new Paragraph(getComune(isOccupante, pf, pg), FONT_HELVETICA_8));
		 tabella4.addCell(c4);
	
		 c4 = new PdfPCell(new Paragraph("Comune", FONT_HELVETICA_8));
		 tabella4.addCell(c4);
	
		 c4 = new PdfPCell(new Paragraph(getComune(isProprietario, pf, pg), FONT_HELVETICA_8));
		 tabella4.addCell(c4);
	
		 c4 = new PdfPCell(new Paragraph("Indirizzo", FONT_HELVETICA_8));
		 tabella4.addCell(c4);
	
		 c4 = new PdfPCell(new Paragraph(getIndirizzo(isOccupante, pf, pg), FONT_HELVETICA_8));
		 tabella4.addCell(c4);
	
		 c4 = new PdfPCell(new Paragraph("Indirizzo", FONT_HELVETICA_8));
		 tabella4.addCell(c4);
	
		 c4 = new PdfPCell(new Paragraph(getIndirizzo(isProprietario, pf, pg), FONT_HELVETICA_8));
		 tabella4.addCell(c4);
	
		 c4 = new PdfPCell(new Paragraph("Telefono /Fax", FONT_HELVETICA_8));
		 tabella4.addCell(c4);
	
		 c4 = new PdfPCell(new Paragraph(getTelefonoFax(isOccupante, pf, pg), FONT_HELVETICA_8));
		 tabella4.addCell(c4);
	
		 c4 = new PdfPCell(new Paragraph("Telefono /Fax", FONT_HELVETICA_8));
		 tabella4.addCell(c4);
	
		 c4 = new PdfPCell(new Paragraph(getTelefonoFax(isProprietario, pf, pg), FONT_HELVETICA_8));
		 tabella4.addCell(c4);
	
		 c4 = new PdfPCell(new Paragraph("E-mail", FONT_HELVETICA_8));
		 tabella4.addCell(c4);
	
		 c4 = new PdfPCell(new Paragraph(getEmail(isOccupante, pf, pg), FONT_HELVETICA_8));
		 tabella4.addCell(c4);
	
		 c4 = new PdfPCell(new Paragraph("E-mail", FONT_HELVETICA_8));
		 tabella4.addCell(c4);
	
		 c4 = new PdfPCell(new Paragraph(getEmail(isProprietario, pf, pg), FONT_HELVETICA_8));
		 tabella4.addCell(c4);
	
	
		 Paragraph p4 = new Paragraph("", FONT_HELVETICA_8);
		 aggiungiCheckPrima(p4, "C.F.", isCF(isOccupante, pf, pg), 20);
		 aggiungiCheckPrima(p4, "P.IVA", isPIVA(isOccupante, pf, pg));
	
		 c4 = new PdfPCell(p4);
		 tabella4.addCell(c4);
	
	
		 c4 = new PdfPCell(new Paragraph(getCfPiva(isOccupante, pf, pg), FONT_HELVETICA_8));
		 tabella4.addCell(c4);
	
	
		 p4 = new Paragraph("", FONT_HELVETICA_8);
		 aggiungiCheckPrima(p4, "C.F.", isCF(isProprietario, pf, pg), 20);
		 aggiungiCheckPrima(p4, "P.IVA", isPIVA(isProprietario, pf, pg));
	
		 c4 = new PdfPCell(p4);
		 //c4.setVerticalAlignment(Element.ALIGN_MIDDLE);
		 //c4.setRowspan(2);
		 tabella4.addCell(c4);
	
		 c4 = new PdfPCell(new Paragraph(getCfPiva(isProprietario, pf, pg), FONT_HELVETICA_8));
		 tabella4.addCell(c4);
	
		 // Aggiungo riga vuota
		 c4 = new PdfPCell(new Paragraph(" ", FONT_HELVETICA_8));
		 c4.setFixedHeight(6);
		 c4.setColspan(6);
		 tabella4.addCell(c4);
	
	
		 c4 = new PdfPCell(new Paragraph("j) T. Resp./Manutent.", FONT_HELVETICA_8_I));
		 c4.setRotation(90);
		 c4.setVerticalAlignment(Element.ALIGN_MIDDLE);
		 c4.setHorizontalAlignment(Element.ALIGN_CENTER);
		 c4.setRowspan(7);
		 tabella4.addCell(c4);
	
		 c4 = new PdfPCell(new Paragraph("Cognome e nome", FONT_HELVETICA_8));
		 tabella4.addCell(c4);
	
		 c4 = new PdfPCell(new Paragraph(getCognomeNome(is3Resp, pf, pg), FONT_HELVETICA_8));
		 tabella4.addCell(c4);
	
		 // Prima riga tabella4 colonna 2
		 c4 = new PdfPCell(new Paragraph("k) Amministrat. Cond.", FONT_HELVETICA_8_I));
		 c4.setRotation(90);
		 c4.setVerticalAlignment(Element.ALIGN_MIDDLE);
		 c4.setHorizontalAlignment(Element.ALIGN_CENTER);
		 c4.setRowspan(7);
		 tabella4.addCell(c4);
	
		 c4 = new PdfPCell(new Paragraph("Cognome e nome", FONT_HELVETICA_8));
		 tabella4.addCell(c4);
	
		 c4 = new PdfPCell(new Paragraph(getCognomeNome(isAmministr, pf, pg), FONT_HELVETICA_8));
		 tabella4.addCell(c4);
	
		 c4 = new PdfPCell(new Paragraph("Ragione sociale", FONT_HELVETICA_8));
		 tabella4.addCell(c4);
	
		 c4 = new PdfPCell(new Paragraph(getRagioneSociale(is3Resp, pf, pg), FONT_HELVETICA_8));
		 tabella4.addCell(c4);
	
		 c4 = new PdfPCell(new Paragraph("Ragione sociale", FONT_HELVETICA_8));
		 tabella4.addCell(c4);
	
		 c4 = new PdfPCell(new Paragraph(getRagioneSociale(isAmministr, pf, pg), FONT_HELVETICA_8));
		 tabella4.addCell(c4);
	
		 c4 = new PdfPCell(new Paragraph("Comune", FONT_HELVETICA_8));
		 tabella4.addCell(c4);
	
		 c4 = new PdfPCell(new Paragraph(getComune(is3Resp, pf, pg), FONT_HELVETICA_8));
		 tabella4.addCell(c4);
	
		 c4 = new PdfPCell(new Paragraph("Comune", FONT_HELVETICA_8));
		 tabella4.addCell(c4);
	
		 c4 = new PdfPCell(new Paragraph(getComune(isAmministr, pf, pg), FONT_HELVETICA_8));
		 tabella4.addCell(c4);
	
		 c4 = new PdfPCell(new Paragraph("Indirizzo", FONT_HELVETICA_8));
		 tabella4.addCell(c4);
	
		 c4 = new PdfPCell(new Paragraph(getIndirizzo(is3Resp, pf, pg), FONT_HELVETICA_8));
		 tabella4.addCell(c4);
	
		 c4 = new PdfPCell(new Paragraph("Indirizzo", FONT_HELVETICA_8));
		 tabella4.addCell(c4);
	
		 c4 = new PdfPCell(new Paragraph(getIndirizzo(isAmministr, pf, pg), FONT_HELVETICA_8));
		 tabella4.addCell(c4);
	
		 c4 = new PdfPCell(new Paragraph("Telefono /Fax", FONT_HELVETICA_8));
		 tabella4.addCell(c4);
	
		 c4 = new PdfPCell(new Paragraph(getTelefonoFax(is3Resp, pf, pg), FONT_HELVETICA_8));
		 tabella4.addCell(c4);
	
		 c4 = new PdfPCell(new Paragraph("Telefono /Fax", FONT_HELVETICA_8));
		 tabella4.addCell(c4);
	
		 c4 = new PdfPCell(new Paragraph(getTelefonoFax(isAmministr, pf, pg), FONT_HELVETICA_8));
		 tabella4.addCell(c4);
	
		 c4 = new PdfPCell(new Paragraph("E-mail", FONT_HELVETICA_8));
		 tabella4.addCell(c4);
	
		 c4 = new PdfPCell(new Paragraph(getEmail(is3Resp, pf, pg), FONT_HELVETICA_8));
		 tabella4.addCell(c4);
	
		 c4 = new PdfPCell(new Paragraph("E-mail", FONT_HELVETICA_8));
		 tabella4.addCell(c4);
	
		 c4 = new PdfPCell(new Paragraph(getEmail(isAmministr, pf, pg), FONT_HELVETICA_8));
		 tabella4.addCell(c4);
	
	
		 p4 = new Paragraph("", FONT_HELVETICA_8);
		 aggiungiCheckPrima(p4, "P.IVA", isPIVA(is3Resp, pf, pg));
	
		 c4 = new PdfPCell(p4);
		 tabella4.addCell(c4);
	
		 c4 = new PdfPCell(new Paragraph(getCfPiva(is3Resp, pf, pg), FONT_HELVETICA_8));
		 tabella4.addCell(c4);
	
	
		 p4 = new Paragraph("", FONT_HELVETICA_8);
		 aggiungiCheckPrima(p4, "P.IVA", isPIVA(isAmministr, pf, pg));
	
		 c4 = new PdfPCell(p4);
		 //c4.setVerticalAlignment(Element.ALIGN_MIDDLE);
		 //c4.setRowspan(2);
		 tabella4.addCell(c4);
	
		 c4 = new PdfPCell(new Paragraph(getCfPiva(isAmministr, pf, pg), FONT_HELVETICA_8));
		 tabella4.addCell(c4);
	
		 document.add(tabella4); //AGGIUNGO LA TABELLA NEL DOCUMENTO
	
	     
	     
	     // OK sopra
	     
		 float[] columnWidths5 = {10,15,35,40}; 
	
		 PdfPTable tabella5 = new PdfPTable(columnWidths5);
		 //Definisco la tabella con il 100%, il bordo,e il margine sinis
	
		 tabella5.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
		 //tabella5.getDefaultCell().setVerticalAlignment(Element.ALIGN_BOTTOM);
	
		 tabella5.setWidthPercentage(100); 
		 tabella5.getDefaultCell().setBorder(1);
		 tabella5.getDefaultCell().setPaddingLeft(PADDING_LEFT);
		 //tabella5.setTotalWidth(Utilities.millimetersToPoints(100));
	     //tabella5.setLockedWidth(true);
		 
		 PdfPCell c5;
		 c5 = new PdfPCell(new Paragraph("l) Delegato", FONT_HELVETICA_8));
		 tabella5.addCell(c5);
	
	     c5 = new PdfPCell(new Paragraph("Cognome e nome:", FONT_HELVETICA_8));
	     tabella5.addCell(c5);
	
	     c5 = new PdfPCell(new Paragraph(GenericUtil.getStringValid(rappIspez.getS1lDenomDelegato()), FONT_HELVETICA_8));
	     tabella5.addCell(c5);
	
		 
		 Paragraph p5 = new Paragraph("Delega   ", FONT_HELVETICA_8);
		 aggiungiCheckPrima(p5, "presente", GenericUtil.getCheckSi(rappIspez.getS1lFlgDelega()), 20);
		 aggiungiCheckPrima(p5, "assente", GenericUtil.getCheckNo(rappIspez.getS1lFlgDelega()));
		 
		 c5 = new PdfPCell(p5);
		 tabella5.addCell(c5);
	     
		 document.add(tabella5); //AGGIUNGO LA TABELLA NEL DOCUMENTO
		 
	 }

	 
	private static void aggiungiDestinazioneGT(Document document, SigitTImpiantoDto impianto, SigitTTrattH2ODto h2O, SigitTUnitaImmobiliareDto unitaImmobPrincipale,  SigitTRappIspezGtDto rappIspez) throws DocumentException {
		 // Paragraph prefazione = new Paragraph();
	
		 //Oltre a creare una semplice tabella, questo metodo e anche buono se si vuole gestire il foglio in sezioni, in modo molto semplice. L�idea � paragonabile alla programmazione HTML, quando si usano le tabelle.
		 //float paddingleft=10f; //Margine Sx 
	
		 //Suddivido il foglio in sezioni, cio� in questo caso, un foglio 100% viene diviso in due sezioni, su 8 la prima � larga 2 e l�altra larga 6. Le sezioni possono essere anche di pi� spartizioni, basta solo aggiungere un valore dopo la virgola es. {3,3,3} suddividiamo in tre sezioni uguali tra di loro.
		 float[] columnWidths = {20,15,20,45}; 
	
		 PdfPTable tabella = new PdfPTable(columnWidths);
		 //Definisco la tabella con il 100%, il bordo,e il margine sinis
		 tabella.setSpacingBefore(5);      
	
		 tabella.setWidthPercentage(100); 
		 tabella.getDefaultCell().setBorder(1);
		 tabella.getDefaultCell().setPaddingLeft(PADDING_LEFT);
		 
		 PdfPCell c1;
		 c1 = new PdfPCell(new Paragraph("2. DESTINAZIONE", FONT_HELVETICA_9_B_I));
		 c1.setHorizontalAlignment(Element.ALIGN_CENTER); 
		 c1.setBackgroundColor(Color.LIGHT_GRAY);
	     c1.setColspan(4);
		 tabella.addCell(c1);
	
		 tabella.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
	
		 
		 c1 = new PdfPCell(new Paragraph("a) Categoria dell'edificio: ", FONT_HELVETICA_8));
		 tabella.addCell(c1);
		 
		 Paragraph p1 = new Paragraph("", FONT_HELVETICA_8);
	
		 aggiungiCheckPrima(p1, "E.1", GenericUtil.getCheck(unitaImmobPrincipale.getL12FkCategoria(),Constants.ID_UNITA_IMMOB_CATEGORIA_E1), 20); 
		 aggiungiCheckPrima(p1, "E.2", GenericUtil.getCheck(unitaImmobPrincipale.getL12FkCategoria(),Constants.ID_UNITA_IMMOB_CATEGORIA_E2), 20); 
		 aggiungiCheckPrima(p1, "E.3", GenericUtil.getCheck(unitaImmobPrincipale.getL12FkCategoria(),Constants.ID_UNITA_IMMOB_CATEGORIA_E3), 20); 
		 aggiungiCheckPrima(p1, "E.4", GenericUtil.getCheck(unitaImmobPrincipale.getL12FkCategoria(),Constants.ID_UNITA_IMMOB_CATEGORIA_E4), 20); 
		 aggiungiCheckPrima(p1, "E.5", GenericUtil.getCheck(unitaImmobPrincipale.getL12FkCategoria(),Constants.ID_UNITA_IMMOB_CATEGORIA_E5), 20); 
		 aggiungiCheckPrima(p1, "E.6", GenericUtil.getCheck(unitaImmobPrincipale.getL12FkCategoria(),Constants.ID_UNITA_IMMOB_CATEGORIA_E6), 20); 
		 aggiungiCheckPrima(p1, "E.7", GenericUtil.getCheck(unitaImmobPrincipale.getL12FkCategoria(),Constants.ID_UNITA_IMMOB_CATEGORIA_E7), 20); 
		 aggiungiCheckPrima(p1, "E.8", GenericUtil.getCheck(unitaImmobPrincipale.getL12FkCategoria(),Constants.ID_UNITA_IMMOB_CATEGORIA_E8));
		 
		 c1 = new PdfPCell(p1);
	     c1.setColspan(3);
	
		 tabella.addCell(c1);
		 
		 c1 = new PdfPCell(new Paragraph("b) Unita' immobiliari servite ", FONT_HELVETICA_8));
		 tabella.addCell(c1);
	
		 p1 = new Paragraph("", FONT_HELVETICA_8);
		 aggiungiCheckPrima(p1, "Unica", GenericUtil.getCheckSi(unitaImmobPrincipale.getL12FlgSingolaUnita()), 10);
		 aggiungiCheckPrima(p1, "Piu' unita'", GenericUtil.getCheckNo(unitaImmobPrincipale.getL12FlgSingolaUnita()));
		 c1 = new PdfPCell(p1);
	     //c1.setColspan(3);
		 tabella.addCell(c1);
	
		 c1 = new PdfPCell(new Paragraph("c) Uso dell'impianto ", FONT_HELVETICA_8));
		 tabella.addCell(c1);
	
	
		 p1 = new Paragraph("", FONT_HELVETICA_8);
		 aggiungiCheckPrima(p1, "Riscaldamento ambienti", GenericUtil.isBigDecimalPositive(impianto.getL13PotClimaInvKw()), 30);
		 aggiungiCheckPrima(p1, "Produzione Acqua Calda Sanitaria", GenericUtil.isBigDecimalPositive(impianto.getL13PotH2oKw()));
		 c1 = new PdfPCell(p1);
	     //c1.setColspan(3);
		 tabella.addCell(c1);
	
		 c1 = new PdfPCell(new Paragraph("b1) Sono presenti sistemi di termoregolazione e contabilizzazione del calore?", FONT_HELVETICA_8));
	     c1.setColspan(3);
		 tabella.addCell(c1);
	
		 p1 = new Paragraph("", FONT_HELVETICA_8);
		 aggiungiCheckSi(p1, GenericUtil.getCheckSi(rappIspez.getS2b1FlgTermoContab()));
		 aggiungiCheckNo(p1, GenericUtil.getCheckNo(rappIspez.getS2b1FlgTermoContab()));
		 aggiungiCheckPrima(p1, "Esentato", GenericUtil.getCheckNc(rappIspez.getS2b1FlgTermoContab()), 10);
	
		 c1 = new PdfPCell(p1);
	     //c1.setColspan(3);
		 tabella.addCell(c1);
	
		 
		 c1 = new PdfPCell(new Paragraph("b2) E' applicata la UNI 10200 per la contabilizzazione?", FONT_HELVETICA_8));
	     c1.setColspan(3);
		 tabella.addCell(c1);
	
		 p1 = new Paragraph("", FONT_HELVETICA_8);
		 aggiungiCheckSi(p1, GenericUtil.getCheckSi(rappIspez.getS2b2FlgUni10200()));
		 aggiungiCheckNo(p1, GenericUtil.getCheckNo(rappIspez.getS2b2FlgUni10200()));
		 aggiungiCheckPrima(p1, "Prima stagione", GenericUtil.getCheckNc(rappIspez.getS2b2FlgUni10200()), 10);
	
		 c1 = new PdfPCell(p1);
	     //c1.setColspan(3);
		 tabella.addCell(c1);
	
		 
		 c1 = new PdfPCell(new Paragraph("d) Volume lordo riscaldato", FONT_HELVETICA_8));
		 tabella.addCell(c1);
	
		 p1 = new Paragraph("", FONT_HELVETICA_8);
		 p1.add(GenericUtil.getStringValid(unitaImmobPrincipale.getL12VolRiscM3()));
		 p1.add(" (m3)");
		 c1 = new PdfPCell(p1);
	     c1.setColspan(2);
		 tabella.addCell(c1);
	
		 // Colonna vuota
		 tabella.addCell(new PdfPCell());
	
		 
		 
		 c1 = new PdfPCell(new Paragraph("f) Trattamento dell'acqua", FONT_HELVETICA_8));
		 c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
	     c1.setRowspan(2);
		 tabella.addCell(c1);
	
		 c1 = new PdfPCell(new Paragraph("in riscaldamento", FONT_HELVETICA_8));
		 tabella.addCell(c1);
		 
		 p1 = new Paragraph("", FONT_HELVETICA_8);
		 aggiungiCheckPrima(p1, "Non richiesto", GenericUtil.getCheckSi(rappIspez.getS2fFlgTrattClimaNonRich()), 20);
		 aggiungiCheckPrima(p1, "Assente", GenericUtil.getCheckSi(h2O.getL23FlgTrattClimaAssente()), 20);
		 aggiungiCheckPrima(p1, "Filtrazione", GenericUtil.getCheckSi(h2O.getL23FlgTrattClimaFiltr()), 20);
		 aggiungiCheckPrima(p1, "Addolcimento", GenericUtil.getCheckSi(h2O.getL23FlgTrattClimaAddolc()), 20);
		 aggiungiCheckPrima(p1, "Cond. chimico", GenericUtil.getCheckSi(h2O.getL23FlgTrattClimaChimico()), 20);
		 
		 c1 = new PdfPCell(p1);
	     c1.setColspan(2);
		 tabella.addCell(c1);
		 
	
		 c1 = new PdfPCell(new Paragraph("in produzione di ACS", FONT_HELVETICA_8));
		 tabella.addCell(c1);
		 
		 p1 = new Paragraph("", FONT_HELVETICA_8);
		 aggiungiCheckPrima(p1, "Non richiesto", GenericUtil.getCheckSi(rappIspez.getS2fFlgTrattAcsNonRich()), 20);
		 aggiungiCheckPrima(p1, "Assente", GenericUtil.getCheckSi(h2O.getL24FlgTrattAcsAssente()), 20);
		 aggiungiCheckPrima(p1, "Filtrazione", GenericUtil.getCheckSi(h2O.getL24FlgTrattAcsFiltr()), 20);
		 aggiungiCheckPrima(p1, "Addolcimento", GenericUtil.getCheckSi(h2O.getL24FlgTrattAcsAddolc()), 20);
		 aggiungiCheckPrima(p1, "Cond. chimico", GenericUtil.getCheckSi(h2O.getL24FlgTrattAcsChimico()), 20);
		 
		 c1 = new PdfPCell(p1);
	     c1.setColspan(2);
		 tabella.addCell(c1);
		 
		 document.add(tabella); //AGGIUNGO LA TABELLA NEL DOCUMENTO
	
		 
	 }

	private static void aggiungiControlloImpiantoGT(Document document, SigitTRappIspezGtDto rappIspez) throws DocumentException {
		 // Paragraph prefazione = new Paragraph();
	
		 //Oltre a creare una semplice tabella, questo metodo e anche buono se si vuole gestire il foglio in sezioni, in modo molto semplice. L�idea � paragonabile alla programmazione HTML, quando si usano le tabelle.
		 //float paddingleft=10f; //Margine Sx 
	
		 //Suddivido il foglio in sezioni, cio� in questo caso, un foglio 100% viene diviso in due sezioni, su 8 la prima � larga 2 e l�altra larga 6. Le sezioni possono essere anche di pi� spartizioni, basta solo aggiungere un valore dopo la virgola es. {3,3,3} suddividiamo in tre sezioni uguali tra di loro.
		 float[] columnWidths = {35,15,35,15}; 
	
		 PdfPTable tabella = new PdfPTable(columnWidths);
		 //Definisco la tabella con il 100%, il bordo,e il margine sinis
		 tabella.setSpacingBefore(5);      
	
		 tabella.setWidthPercentage(100); 
		 tabella.getDefaultCell().setBorder(1);
		 tabella.getDefaultCell().setPaddingLeft(PADDING_LEFT);
	
		 PdfPCell c1;
		 c1 = new PdfPCell(new Paragraph("3. CONTROLLO DELL'IMPIANTO", FONT_HELVETICA_9_B_I));
		 c1.setHorizontalAlignment(Element.ALIGN_CENTER); 
		 c1.setBackgroundColor(Color.LIGHT_GRAY);
		 c1.setColspan(4);
		 tabella.addCell(c1);
	
		 tabella.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
	
		 // Riga 1
		 c1 = new PdfPCell(new Paragraph("a) Installazione interna: locale idoneo", FONT_HELVETICA_8));
		 tabella.addCell(c1);
	
		 Paragraph p1 = new Paragraph("", FONT_HELVETICA_8);
	
		 //if (ConvertUtil.convertToInteger(rappIspez.getS3aFlgLocaleIntIdoneo()) == Constants.ID_STATO_LIBRETTO_BOZZA
		 aggiungiCheckSi(p1, GenericUtil.getCheckSi(rappIspez.getS3aFlgLocaleIntIdoneo()));
		 aggiungiCheckNo(p1, GenericUtil.getCheckNo(rappIspez.getS3aFlgLocaleIntIdoneo()));
		 aggiungiCheckPrima(p1, "Nc", GenericUtil.getCheckNc(rappIspez.getS3aFlgLocaleIntIdoneo()));
		 c1 = new PdfPCell(p1);
		 tabella.addCell(c1);
	
	
		 c1 = new PdfPCell(new Paragraph("b) Installazione esterna: generatori idonei", FONT_HELVETICA_8));
		 tabella.addCell(c1);
	
		 p1 = new Paragraph("", FONT_HELVETICA_8);
	
		 aggiungiCheckSi(p1, GenericUtil.getCheckSi(rappIspez.getS3bFlgGenExtIdoneo()));
		 aggiungiCheckNo(p1, GenericUtil.getCheckNo(rappIspez.getS3bFlgGenExtIdoneo()));
		 aggiungiCheckPrima(p1, "Nc", GenericUtil.getCheckNc(rappIspez.getS3bFlgGenExtIdoneo()));
		 c1 = new PdfPCell(p1);
		 tabella.addCell(c1);
	
	
		 // Riga 2
		 c1 = new PdfPCell(new Paragraph("c) Sistema di ventilazione sufficiente", FONT_HELVETICA_8));
		 tabella.addCell(c1);
	
		 p1 = new Paragraph("", FONT_HELVETICA_8);
	
		 aggiungiCheckSi(p1, GenericUtil.getCheckSi(rappIspez.getS3cFlgVentilazSuff()));
		 aggiungiCheckNo(p1, GenericUtil.getCheckNo(rappIspez.getS3cFlgVentilazSuff()));
		 aggiungiCheckPrima(p1, "Na", GenericUtil.getCheckNc(rappIspez.getS3cFlgVentilazSuff()));
		 c1 = new PdfPCell(p1);
		 tabella.addCell(c1);
	
	
		 c1 = new PdfPCell(new Paragraph("d) Sistema evacuazione fumi idoneo (esame visivo)", FONT_HELVETICA_8));
		 tabella.addCell(c1);
	
		 p1 = new Paragraph("", FONT_HELVETICA_8);
	
		 aggiungiCheckSi(p1, GenericUtil.getCheckSi(rappIspez.getS3dFlgEvacFumiIdoneo()));
		 aggiungiCheckNo(p1, GenericUtil.getCheckNo(rappIspez.getS3dFlgEvacFumiIdoneo()));
		 aggiungiCheckPrima(p1, "Nc", GenericUtil.getCheckNc(rappIspez.getS3dFlgEvacFumiIdoneo()));
		 c1 = new PdfPCell(p1);
		 tabella.addCell(c1);
	
	
	
		 // Riga 3
		 c1 = new PdfPCell(new Paragraph("e) Cartellonistica prevista presente", FONT_HELVETICA_8));
		 tabella.addCell(c1);
	
		 p1 = new Paragraph("", FONT_HELVETICA_8);
	
		 aggiungiCheckSi(p1, GenericUtil.getCheckSi(rappIspez.getS3eFlgCartelliPresenti()));
		 aggiungiCheckNo(p1, GenericUtil.getCheckNo(rappIspez.getS3eFlgCartelliPresenti()));
		 aggiungiCheckPrima(p1, "Na", GenericUtil.getCheckNc(rappIspez.getS3eFlgCartelliPresenti()));
		 c1 = new PdfPCell(p1);
		 tabella.addCell(c1);
	
	
		 c1 = new PdfPCell(new Paragraph("f) Mezzi estinzione incendi presenti e revisionati", FONT_HELVETICA_8));
		 tabella.addCell(c1);
	
		 p1 = new Paragraph("", FONT_HELVETICA_8);
	
		 aggiungiCheckSi(p1, GenericUtil.getCheckSi(rappIspez.getS3fFlgEstinzPresenti()));
		 aggiungiCheckNo(p1, GenericUtil.getCheckNo(rappIspez.getS3fFlgEstinzPresenti()));
		 aggiungiCheckPrima(p1, "Na", GenericUtil.getCheckNc(rappIspez.getS3fFlgEstinzPresenti()));
		 c1 = new PdfPCell(p1);
		 tabella.addCell(c1);
	
	
		 // Riga 4
		 c1 = new PdfPCell(new Paragraph("g) Interruttore generale presente", FONT_HELVETICA_8));
		 tabella.addCell(c1);
	
		 p1 = new Paragraph("", FONT_HELVETICA_8);
	
		 aggiungiCheckSi(p1, GenericUtil.getCheckSi(rappIspez.getS3gFlgInterrGenPresenti()));
		 aggiungiCheckNo(p1, GenericUtil.getCheckNo(rappIspez.getS3gFlgInterrGenPresenti()));
		 aggiungiCheckPrima(p1, "Na", GenericUtil.getCheckNc(rappIspez.getS3gFlgInterrGenPresenti()));
		 c1 = new PdfPCell(p1);
		 tabella.addCell(c1);
	
	
		 c1 = new PdfPCell(new Paragraph("h) Rubinetto intercettazione esterno presente", FONT_HELVETICA_8));
		 tabella.addCell(c1);
	
		 p1 = new Paragraph("", FONT_HELVETICA_8);
	
		 aggiungiCheckSi(p1, GenericUtil.getCheckSi(rappIspez.getS3hFlgRubinPresente()));
		 aggiungiCheckNo(p1, GenericUtil.getCheckNo(rappIspez.getS3hFlgRubinPresente()));
		 aggiungiCheckPrima(p1, "Na", GenericUtil.getCheckNc(rappIspez.getS3hFlgRubinPresente()));
		 c1 = new PdfPCell(p1);
		 tabella.addCell(c1);
	
	
	
		 // Riga 5
		 c1 = new PdfPCell(new Paragraph("i) Assenza perdite comb. (esame visivo)", FONT_HELVETICA_8));
		 tabella.addCell(c1);
	
		 p1 = new Paragraph("", FONT_HELVETICA_8);
	
		 aggiungiCheckSi(p1, GenericUtil.getCheckSi(rappIspez.getS3iFlgAssenzaPerdComb()));
		 aggiungiCheckNo(p1, GenericUtil.getCheckNo(rappIspez.getS3iFlgAssenzaPerdComb()));
		 aggiungiCheckPrima(p1, "Nc", GenericUtil.getCheckNc(rappIspez.getS3iFlgAssenzaPerdComb()));
		 c1 = new PdfPCell(p1);
		 tabella.addCell(c1);
	
	
		 c1 = new PdfPCell(new Paragraph("j) Sistema regolazione temp. ambiente funzionante", FONT_HELVETICA_8));
		 tabella.addCell(c1);
	
		 p1 = new Paragraph("", FONT_HELVETICA_8);
	
		 aggiungiCheckSi(p1, GenericUtil.getCheckSi(rappIspez.getS3jFlgTempAmbFunz()));
		 aggiungiCheckNo(p1, GenericUtil.getCheckNo(rappIspez.getS3jFlgTempAmbFunz()));
		 aggiungiCheckPrima(p1, "Nc", GenericUtil.getCheckNc(rappIspez.getS3jFlgTempAmbFunz()));
		 c1 = new PdfPCell(p1);
		 tabella.addCell(c1);
	
		 // Riga 6
		 c1 = new PdfPCell(new Paragraph("k) Assenza o mancata taratura dei dispositivi DM 1/12/75", FONT_HELVETICA_8));
		 c1.setColspan(3);
		 tabella.addCell(c1);
	
		 p1 = new Paragraph("", FONT_HELVETICA_8);
	
		 aggiungiCheckSi(p1, GenericUtil.getCheckSi(rappIspez.getS3kFlgDm1121975()));
		 aggiungiCheckNo(p1, GenericUtil.getCheckNo(rappIspez.getS3kFlgDm1121975()));
		 aggiungiCheckPrima(p1, "Na", GenericUtil.getCheckNc(rappIspez.getS3kFlgDm1121975()));
		 c1 = new PdfPCell(p1);
		 tabella.addCell(c1);
	
		 document.add(tabella); //AGGIUNGO LA TABELLA NEL DOCUMENTO
	
	
	 }

	private static void aggiungiStatoDocumentazioneGT(Document document, SigitTRappIspezGtDto rappIspez) throws DocumentException {
		 // Paragraph prefazione = new Paragraph();
	
		 //Oltre a creare una semplice tabella, questo metodo e anche buono se si vuole gestire il foglio in sezioni, in modo molto semplice. L�idea � paragonabile alla programmazione HTML, quando si usano le tabelle.
		 //float paddingleft=10f; //Margine Sx 
	
		 //Suddivido il foglio in sezioni, cio� in questo caso, un foglio 100% viene diviso in due sezioni, su 8 la prima � larga 2 e l�altra larga 6. Le sezioni possono essere anche di pi� spartizioni, basta solo aggiungere un valore dopo la virgola es. {3,3,3} suddividiamo in tre sezioni uguali tra di loro.
		 float[] columnWidths = {35,15,35,15}; 
	
		 PdfPTable tabella = new PdfPTable(columnWidths);
		 //Definisco la tabella con il 100%, il bordo,e il margine sinis
		 tabella.setSpacingBefore(5);      
	
		 tabella.setWidthPercentage(100); 
		 tabella.getDefaultCell().setBorder(1);
		 tabella.getDefaultCell().setPaddingLeft(PADDING_LEFT);
	
		 PdfPCell c1;
		 c1 = new PdfPCell(new Paragraph("4. STATO DELLA DOCUMENTAZIONE", FONT_HELVETICA_9_B_I));
		 c1.setHorizontalAlignment(Element.ALIGN_CENTER); 
		 c1.setBackgroundColor(Color.LIGHT_GRAY);
		 c1.setColspan(4);
		 tabella.addCell(c1);
	
		 tabella.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
	
		 // Riga 1
		 c1 = new PdfPCell(new Paragraph("a) Libretto di impianto presente", FONT_HELVETICA_8));
		 tabella.addCell(c1);
	
		 Paragraph p1 = new Paragraph("", FONT_HELVETICA_8);
	
		 aggiungiCheckSi(p1, GenericUtil.getCheckSi(rappIspez.getS4aFlgLibImpPresente()));
		 aggiungiCheckNo(p1, GenericUtil.getCheckNo(rappIspez.getS4aFlgLibImpPresente()));
		 c1 = new PdfPCell(p1);
		 tabella.addCell(c1);
	
	
		 c1 = new PdfPCell(new Paragraph("b) Libretto di impianto compilato in tutte le sue parti", FONT_HELVETICA_8));
		 tabella.addCell(c1);
	
		 p1 = new Paragraph("", FONT_HELVETICA_8);
	
		 aggiungiCheckSi(p1, GenericUtil.getCheckSi(rappIspez.getS4bFlgLibCompilato()));
		 aggiungiCheckNo(p1, GenericUtil.getCheckNo(rappIspez.getS4bFlgLibCompilato()));
		 c1 = new PdfPCell(p1);
		 tabella.addCell(c1);
	
	
		 // Riga 2
		 c1 = new PdfPCell(new Paragraph("c) Dic. conformita'/rispondenza presente)", FONT_HELVETICA_8));
		 tabella.addCell(c1);
	
		 p1 = new Paragraph("", FONT_HELVETICA_8);
	
		 aggiungiCheckSi(p1, GenericUtil.getCheckSi(rappIspez.getS4cFlgConformitaPresente()));
		 aggiungiCheckNo(p1, GenericUtil.getCheckNo(rappIspez.getS4cFlgConformitaPresente()));
		 c1 = new PdfPCell(p1);
		 tabella.addCell(c1);
	
	
		 c1 = new PdfPCell(new Paragraph("d) Libretti uso/manutenzione generatore presenti", FONT_HELVETICA_8));
		 tabella.addCell(c1);
	
		 p1 = new Paragraph("", FONT_HELVETICA_8);
	
		 aggiungiCheckSi(p1, GenericUtil.getCheckSi(rappIspez.getS4dFlgLibUsoPresente()));
		 aggiungiCheckNo(p1, GenericUtil.getCheckNo(rappIspez.getS4dFlgLibUsoPresente()));
		 c1 = new PdfPCell(p1);
		 tabella.addCell(c1);
	
	
	
		 // Riga 3
		 c1 = new PdfPCell(new Paragraph("e) Pratica VV.F. presente ove richiesto", FONT_HELVETICA_8));
		 tabella.addCell(c1);
	
		 p1 = new Paragraph("", FONT_HELVETICA_8);
	
		 aggiungiCheckSi(p1, GenericUtil.getCheckSi(rappIspez.getS4eFlgPraticaVvfPresente()));
		 aggiungiCheckNo(p1, GenericUtil.getCheckNo(rappIspez.getS4eFlgPraticaVvfPresente()));
		 aggiungiCheckPrima(p1, "Na", GenericUtil.getCheckNc(rappIspez.getS4eFlgPraticaVvfPresente()));
		 c1 = new PdfPCell(p1);
		 tabella.addCell(c1);
	
	
		 c1 = new PdfPCell(new Paragraph("f) Pratica INAIL presente (gia' ISPESL)", FONT_HELVETICA_8));
		 tabella.addCell(c1);
	
		 p1 = new Paragraph("", FONT_HELVETICA_8);
	
		 aggiungiCheckSi(p1, GenericUtil.getCheckSi(rappIspez.getS4fFlgPraticaInailPresente()));
		 aggiungiCheckNo(p1, GenericUtil.getCheckNo(rappIspez.getS4fFlgPraticaInailPresente()));
		 aggiungiCheckPrima(p1, "Na", GenericUtil.getCheckNc(rappIspez.getS4fFlgPraticaInailPresente()));
		 c1 = new PdfPCell(p1);
		 tabella.addCell(c1);
	
	
		 // Riga 4
		 p1 = new Paragraph("g) Matricola DM 1/12/1975 n. ", FONT_HELVETICA_8);
		 p1.add(GenericUtil.getStringValid(rappIspez.getS4gMatricolaDm1121975()));
		 c1 = new PdfPCell(p1);
		 tabella.addCell(c1);
	
		 p1 = new Paragraph("", FONT_HELVETICA_8);
	
		 aggiungiCheckSi(p1, GenericUtil.getCheckSi(rappIspez.getS4gFlgDm121975()));
		 aggiungiCheckNo(p1, GenericUtil.getCheckNo(rappIspez.getS4gFlgDm121975()));
		 aggiungiCheckPrima(p1, "Na", GenericUtil.getCheckNc(rappIspez.getS4gFlgDm121975()));
		 c1 = new PdfPCell(p1);
		 tabella.addCell(c1);
	
		 // Colonna vuota
		 tabella.addCell(new PdfPCell());
		 // Colonna vuota
		 tabella.addCell(new PdfPCell());
	
		 document.add(tabella); //AGGIUNGO LA TABELLA NEL DOCUMENTO
	
	
	 }

	private static void aggiungiInterventiMiglioramentoGT(Document document, SigitTRappIspezGtDto rappIspez) throws DocumentException {
		 // Paragraph prefazione = new Paragraph();
	
		 //Oltre a creare una semplice tabella, questo metodo e anche buono se si vuole gestire il foglio in sezioni, in modo molto semplice. L�idea � paragonabile alla programmazione HTML, quando si usano le tabelle.
		 //float paddingleft=10f; //Margine Sx 
	
		 //Suddivido il foglio in sezioni, cio� in questo caso, un foglio 100% viene diviso in due sezioni, su 8 la prima � larga 2 e l'altra larga 6. Le sezioni possono essere anche di pi� spartizioni, basta solo aggiungere un valore dopo la virgola es. {3,3,3} suddividiamo in tre sezioni uguali tra di loro.
	
		 float[] columnWidths = {20,40,40}; 
	
		 PdfPTable tabella = new PdfPTable(columnWidths);
		 //Definisco la tabella con il 100%, il bordo,e il margine sinis
		 tabella.setSpacingBefore(5);      
	
		 tabella.setWidthPercentage(100); 
		 tabella.getDefaultCell().setBorder(1);
		 tabella.getDefaultCell().setPaddingLeft(PADDING_LEFT);
	
		 PdfPCell c1;
		 c1 = new PdfPCell(new Paragraph("5. INTERVENTI DI MIGLIORAMENTO ENERGETICO DELL'IMPIANTO", FONT_HELVETICA_9_B_I));
		 c1.setHorizontalAlignment(Element.ALIGN_CENTER); 
		 c1.setBackgroundColor(Color.LIGHT_GRAY);
		 c1.setColspan(3);
		 tabella.addCell(c1);
	
		 tabella.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
	
		 // Riga 1
		 c1 = new PdfPCell(new Paragraph("a) CHECK-LIST", FONT_HELVETICA_8));
		 c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
		 c1.setRowspan(2);
		 tabella.addCell(c1);
	
		 Paragraph p1 = new Paragraph("", FONT_HELVETICA_8);
		 aggiungiCheckPrima(p1, "Adozione di valvole termostatiche sui corpi scaldanti", GenericUtil.getCheckSi(rappIspez.getS5aFlgAdozioneValvoleTerm()));
		 c1 = new PdfPCell(p1);
		 c1.setBorder(Rectangle.LEFT | Rectangle.TOP);
		 //c1.setColspan(2);
		 tabella.addCell(c1);
	
		 p1 = new Paragraph("", FONT_HELVETICA_8);
		 aggiungiCheckPrima(p1, "Isolamento della rete di distribuzione nei locali non riscaldati", GenericUtil.getCheckSi(rappIspez.getS5aFlgIsolamenteRete()));
		 c1 = new PdfPCell(p1);
		 c1.setBorder(Rectangle.TOP | Rectangle.RIGHT);
		 //c1.setColspan(2);
		 tabella.addCell(c1);
		 
		 
		 p1 = new Paragraph("", FONT_HELVETICA_8);
		 aggiungiCheckPrima(p1, "Introduzione di un sistema di trattamento dell'acqua", GenericUtil.getCheckSi(rappIspez.getS5aFlgAdozSistTrattamH2o()));
		 c1 = new PdfPCell(p1);
		 c1.setBorder(Rectangle.LEFT | Rectangle.BOTTOM);
		 //c1.setColspan(2);
		 tabella.addCell(c1);
	
		 p1 = new Paragraph("", FONT_HELVETICA_8);
		 aggiungiCheckPrima(p1, "Sostituzione sistema regolazione on/off con uno programmabile", GenericUtil.getCheckSi(rappIspez.getS5aFlgSostituzSistRegolaz()));
		 c1 = new PdfPCell(p1);
		 c1.setBorder(Rectangle.RIGHT | Rectangle.BOTTOM);
		 //c1.setColspan(2);
		 tabella.addCell(c1);
		 
		// Aggiungo riga vuota
		 c1 = new PdfPCell(new Paragraph(" ", FONT_HELVETICA_8));
		 c1.setFixedHeight(6);
		 c1.setColspan(3);
		 tabella.addCell(c1);
	
		 document.add(tabella); //AGGIUNGO LA TABELLA NEL DOCUMENTO
	
		 
		 float[] columnWidthsNew = {35,30,35}; 
		 tabella = new PdfPTable(columnWidthsNew);
		 //Definisco la tabella con il 100%, il bordo,e il margine sinis
		 //tabella.setSpacingBefore(5);      
	
		 tabella.setWidthPercentage(100); 
		 tabella.getDefaultCell().setBorder(1);
		 tabella.getDefaultCell().setPaddingLeft(PADDING_LEFT);
		 
		 // Riga 2
		 c1 = new PdfPCell(new Paragraph("b) Interventi atti a migliorare il rendimentoenergetico", FONT_HELVETICA_8));
		 c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
		 c1.setRowspan(3);
		 //c1.setColspan(2);
		 tabella.addCell(c1);
	
		
		 p1 = new Paragraph("", FONT_HELVETICA_8);
		 aggiungiCheckPrima(p1, "Non sono stati individuati interventi economicamente convenienti", GenericUtil.getCheckSi(rappIspez.getS5bFlgNoIntervConv()));
		 c1 = new PdfPCell(p1);
		 c1.setBorder(Rectangle.LEFT | Rectangle.TOP | Rectangle.RIGHT);
		 c1.setColspan(2);
		 tabella.addCell(c1);
	
		 p1 = new Paragraph("", FONT_HELVETICA_8);
		 aggiungiCheckPrima(p1, "Si allega relazione di dettaglio", GenericUtil.getCheckSi(rappIspez.getS5bFlgRelazDettaglio()));
		 c1 = new PdfPCell(p1);
		 c1.setBorder(Rectangle.LEFT);
		 //c1.setColspan(2);
		 tabella.addCell(c1);
	
		 p1 = new Paragraph("", FONT_HELVETICA_8);
		 aggiungiCheckPrima(p1, "Si rimanda a relazione di dettaglio successiva", GenericUtil.getCheckSi(rappIspez.getS5bFlgRelazDettaglioSucc()));
		 c1 = new PdfPCell(p1);
		 c1.setBorder(Rectangle.RIGHT);
		 tabella.addCell(c1);
	
		 p1 = new Paragraph("", FONT_HELVETICA_8);
		 aggiungiCheckPrima(p1, "Valutazione non eseguita, motivo:", GenericUtil.getCheckSi(rappIspez.getS5bFlgValutazNonEseguita()));
		 p1.add(GenericUtil.getStringValid(rappIspez.getS5bMotivoRelazNonEseg()));
		 c1 = new PdfPCell(p1);
		 c1.setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.BOTTOM);
		 c1.setColspan(2);
		 tabella.addCell(c1);
		 
			// Aggiungo riga vuota
		 c1 = new PdfPCell(new Paragraph(" ", FONT_HELVETICA_8));
		 c1.setFixedHeight(6);
		 c1.setColspan(3);
		 tabella.addCell(c1);
	
		 
		 // Riga 3
		 c1 = new PdfPCell(new Paragraph("c) Stima del dimensionamento del/i generatore/i", FONT_HELVETICA_8));
		 c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
		 c1.setRowspan(2);
		 //c1.setColspan(2);
		 tabella.addCell(c1);
	
	
		 p1 = new Paragraph("", FONT_HELVETICA_8);
		 aggiungiCheckPrima(p1, "Dimensionamento corretto", GenericUtil.getCheckSi(rappIspez.getS5cFlgDimensCorretto()));
		 c1 = new PdfPCell(p1);
		 c1.setBorder(Rectangle.LEFT | Rectangle.TOP);
		 //c1.setColspan(2);
		 tabella.addCell(c1);
	
		 p1 = new Paragraph("", FONT_HELVETICA_8);
		 aggiungiCheckPrima(p1, "Dimensionamento non corretto", GenericUtil.getCheckSi(rappIspez.getS5cFlgDimensNonCorretto()));
		 c1 = new PdfPCell(p1);
		 c1.setBorder(Rectangle.TOP | Rectangle.RIGHT);
		 tabella.addCell(c1);
	
		 p1 = new Paragraph("", FONT_HELVETICA_8);
		 aggiungiCheckPrima(p1, "Non controllabile", GenericUtil.getCheckSi(rappIspez.getS5cFlgDimensNonControll()));
		 c1 = new PdfPCell(p1);
		 c1.setBorder(Rectangle.LEFT | Rectangle.BOTTOM);
		 //c1.setColspan(2);
		 tabella.addCell(c1);
	
		 p1 = new Paragraph("", FONT_HELVETICA_8);
		 aggiungiCheckPrima(p1, "Si rimanda a relazione di dettaglio successiva", GenericUtil.getCheckSi(rappIspez.getS5cFlgDimensRelazSucces()));
		 c1 = new PdfPCell(p1);
		 c1.setBorder(Rectangle.RIGHT | Rectangle.BOTTOM);
		 tabella.addCell(c1);
		 
		 
		 document.add(tabella); //AGGIUNGO LA TABELLA NEL DOCUMENTO
		
	
	 }

	private static void aggiungiGeneratoreGT(Document document, SigitTDettIspezGtDto sigitTDettIspezGtDto, SigitVSk4GtDto sigitRAllegatoCompGtDto, List<SigitTCompBrRcBrRcLegateAGtComplexDto> bruciatoriAssociati) throws DocumentException {
	
		 //Suddivido il foglio in sezioni, cio� in questo caso, un foglio 100% viene diviso in due sezioni, su 8 la prima � larga 2 e l�altra larga 6. Le sezioni possono essere anche di pi� spartizioni, basta solo aggiungere un valore dopo la virgola es. {3,3,3} suddividiamo in tre sezioni uguali tra di loro.
		 float[] columnWidths = {23,9,7,16,20,20,5}; 
		 
		 // 7 colonne
		 
		 PdfPTable tabella = new PdfPTable(columnWidths);
		 //Definisco la tabella con il 100%, il bordo,e il margine sinis
		 tabella.setSpacingBefore(5);      
	
		 tabella.setWidthPercentage(100); 
		 tabella.getDefaultCell().setBorder(1);
		 tabella.getDefaultCell().setPaddingLeft(PADDING_LEFT);
		 
		 PdfPCell c1;
		 c1 = new PdfPCell(new Paragraph("6. GENERATORE", FONT_HELVETICA_9_B_I));
		 c1.setHorizontalAlignment(Element.ALIGN_CENTER); 
		 c1.setBackgroundColor(Color.LIGHT_GRAY);
	     c1.setColspan(7);
		 tabella.addCell(c1);
	
		 tabella.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
	
		 
		 c1 = new PdfPCell(new Paragraph("a) Generatore", FONT_HELVETICA_8));
		 tabella.addCell(c1);
		 
		 Paragraph p1 = new Paragraph("", FONT_HELVETICA_8);
	
		 p1 = new Paragraph("", FONT_HELVETICA_8);
		 //p1.add("N� ");
		 p1.add(GenericUtil.getDescSezioneComp(sigitRAllegatoCompGtDto.getIdTipoComponente(), ConvertUtil.convertToBigInteger(sigitRAllegatoCompGtDto.getProgressivo())));
		 c1 = new PdfPCell(p1);
	     //c1.setColspan(2);
		 tabella.addCell(c1);
		 
		 // Lascio questa cella per non dover riscrivere la tabella 
		 p1 = new Paragraph("", FONT_HELVETICA_8);
		 p1.add(" "); // Di
		 p1.add(" ");
		 c1 = new PdfPCell(p1);
	     c1.setColspan(2);
		 tabella.addCell(c1);
		 
		 p1 = new Paragraph("", FONT_HELVETICA_8);
		 c1 = new PdfPCell(p1);
	     c1.setColspan(3);
		 tabella.addCell(c1);
		 
		 c1 = new PdfPCell(new Paragraph("a1) Tipo di combustibile", FONT_HELVETICA_8));
		 tabella.addCell(c1);
		 
		 p1 = new Paragraph(GenericUtil.getStringValid(sigitRAllegatoCompGtDto.getDesCombustibile()), FONT_HELVETICA_8);
		 /*
		 p1 = new Paragraph("", FONT_HELVETICA_8);
	
		 aggiungiCheckPrima(p1, "Gas natur.", true, 12);
		 aggiungiCheckPrima(p1, "GPL", false, 12);
		 aggiungiCheckPrima(p1, "Gasolio", true, 12);
		 aggiungiCheckPrima(p1, "Altro: "+VAR, false);
		 */
		 c1 = new PdfPCell(p1);
	     c1.setColspan(3);
		 tabella.addCell(c1);
		 
		 p1 = new Paragraph("k) Dati nominali:", FONT_HELVETICA_8_I);
		 c1 = new PdfPCell(p1);
	     c1.setColspan(3);
		 tabella.addCell(c1);
	
		 c1 = new PdfPCell(new Paragraph("b) Data installazione", FONT_HELVETICA_8));
		 tabella.addCell(c1);
		 
		 c1 = new PdfPCell(new Paragraph(ConvertUtil.getStringValid(sigitRAllegatoCompGtDto.getDataInstall()), FONT_HELVETICA_8));
	     c1.setColspan(3);
		 tabella.addCell(c1);
	
		 c1 = new PdfPCell(new Paragraph("Potenza termica al focolare:", FONT_HELVETICA_8));
		 c1.setBorder(Rectangle.TOP | Rectangle.LEFT | Rectangle.BOTTOM);
		 tabella.addCell(c1);
	
		 c1 = new PdfPCell(new Paragraph(GenericUtil.getStringValid(sigitTDettIspezGtDto.getS6kPotTermFocolKw()), FONT_HELVETICA_8));
		 c1.setBorder(Rectangle.TOP | Rectangle.BOTTOM);
		 tabella.addCell(c1);
		 
		 c1 = new PdfPCell(new Paragraph("(kW)", FONT_HELVETICA_8));
		 c1.setBorder(Rectangle.TOP | Rectangle.RIGHT | Rectangle.BOTTOM);
		 tabella.addCell(c1);
		 
		 
		 c1 = new PdfPCell(new Paragraph("c) Fluido termovettore", FONT_HELVETICA_8));
		 tabella.addCell(c1);
		 
		 p1 = new Paragraph(GenericUtil.getStringValid(sigitRAllegatoCompGtDto.getDesFluido()), FONT_HELVETICA_8);
		 /*
		 p1 = new Paragraph("", FONT_HELVETICA_8);
		 aggiungiCheckPrima(p1, "Acqua", false, 12);
		 aggiungiCheckPrima(p1, "Aria", true, 12);
		 aggiungiCheckPrima(p1, "Altro: "+VAR, false);
		 */
		 c1 = new PdfPCell(p1);
	     c1.setColspan(3);
		 tabella.addCell(c1);
		 
		 c1 = new PdfPCell(new Paragraph("Potenza termica utile:", FONT_HELVETICA_8));
		 c1.setBorder(Rectangle.TOP | Rectangle.LEFT | Rectangle.BOTTOM);
		 tabella.addCell(c1);
		 
		 c1 = new PdfPCell(new Paragraph(GenericUtil.getStringValid(sigitRAllegatoCompGtDto.getPotenzaTermicaKw()), FONT_HELVETICA_8));
		 c1.setBorder(Rectangle.TOP | Rectangle.BOTTOM);
		 tabella.addCell(c1);
		 
		 c1 = new PdfPCell(new Paragraph("(kW)", FONT_HELVETICA_8));
		 c1.setBorder(Rectangle.TOP | Rectangle.RIGHT | Rectangle.BOTTOM);
		 tabella.addCell(c1);
		 
		 
		 c1 = new PdfPCell(new Paragraph("d) Modalita' di evacuazione fumi", FONT_HELVETICA_8));
		 tabella.addCell(c1);
		 
		 p1 = new Paragraph("", FONT_HELVETICA_8);
		 aggiungiCheckPrima(p1, "Naturale", GenericUtil.getCheck(sigitTDettIspezGtDto.getS6dFlgEvacuFumi(), Constants.FLAG_EVACUAZIONE_FUMI_NATURALE), 20);
		 aggiungiCheckPrima(p1, "Forzata", GenericUtil.getCheck(sigitTDettIspezGtDto.getS6dFlgEvacuFumi(), Constants.FLAG_EVACUAZIONE_FUMI_FORZATA));
		 
		 c1 = new PdfPCell(p1);
	     c1.setColspan(3);
		 tabella.addCell(c1);
	
		 
		 c1 = new PdfPCell(new Paragraph("Campo di lavoro bruciatore:", FONT_HELVETICA_8));
		 c1.setBorder(Rectangle.TOP | Rectangle.LEFT | Rectangle.BOTTOM);
	     c1.setRowspan(2);
		 tabella.addCell(c1);
		 
		 c1 = new PdfPCell(new Paragraph("da: "+GenericUtil.getStringValid(sigitTDettIspezGtDto.getS6kBruciatoreDaKw()), FONT_HELVETICA_8));
		 c1.setBorder(Rectangle.TOP);
		 tabella.addCell(c1);
		 
		 c1 = new PdfPCell(new Paragraph("(kW)", FONT_HELVETICA_8));
		 c1.setBorder(Rectangle.TOP | Rectangle.RIGHT);
		 tabella.addCell(c1);
		 
		 c1 = new PdfPCell(new Paragraph("e) Costruttore caldaia", FONT_HELVETICA_8));
		 tabella.addCell(c1);
		 
		 c1 = new PdfPCell(new Paragraph(GenericUtil.getStringValid(sigitRAllegatoCompGtDto.getDesMarca()), FONT_HELVETICA_8));
	     c1.setColspan(3);
		 tabella.addCell(c1);
	
		 c1 = new PdfPCell(new Paragraph("a: "+GenericUtil.getStringValid(sigitTDettIspezGtDto.getS6kBruciatoreAKw()), FONT_HELVETICA_8));
		 c1.setBorder(Rectangle.BOTTOM);
		 tabella.addCell(c1);
		 
		 c1 = new PdfPCell(new Paragraph("(kW)", FONT_HELVETICA_8));
		 c1.setBorder(Rectangle.RIGHT | Rectangle.BOTTOM);
		 tabella.addCell(c1);
		 
	
		 c1 = new PdfPCell(new Paragraph("f) modello e matricola caldaia", FONT_HELVETICA_8));
		 tabella.addCell(c1);
	
		 c1 = new PdfPCell(new Paragraph(GenericUtil.getStringValid(sigitRAllegatoCompGtDto.getModello()), FONT_HELVETICA_8));
	     c1.setColspan(2);
		 tabella.addCell(c1);
	
		 c1 = new PdfPCell(new Paragraph(GenericUtil.getStringValid(sigitRAllegatoCompGtDto.getMatricola()), FONT_HELVETICA_8));
		 tabella.addCell(c1);
		 
		 c1 = new PdfPCell(new Paragraph("l) Dati misurati:", FONT_HELVETICA_8_I));
		 c1.setBorder(Rectangle.LEFT | Rectangle.TOP| Rectangle.RIGHT);
	     c1.setColspan(3);
		 tabella.addCell(c1);
		 
		 
			Set<String> elencoMarche = new HashSet<String>();
			Set<String> elencoModelli = new HashSet<String>();
			Set<String> elencoMatricole = new HashSet<String>();
		 
		 for (SigitTCompBrRcBrRcLegateAGtComplexDto bruciatore : bruciatoriAssociati) {
			 elencoMarche.add(bruciatore.getDesMarca());
			 elencoModelli.add(bruciatore.getModello());
			 elencoMatricole.add(bruciatore.getMatricola());
		 }
		 
		 
		 c1 = new PdfPCell(new Paragraph("g) Costruttore bruciatore", FONT_HELVETICA_8));
		 tabella.addCell(c1);
		 
		 c1 = new PdfPCell(new Paragraph(ConvertUtil.getStringByList(new ArrayList(elencoMarche), Constants.INTERVAL_SEP_SLASH), FONT_HELVETICA_8));
	     c1.setColspan(3);
		 tabella.addCell(c1);
		 
		 c1 = new PdfPCell(new Paragraph("Portata di combustibile:", FONT_HELVETICA_8));
		 c1.setBorder(Rectangle.LEFT | Rectangle.BOTTOM);
		 tabella.addCell(c1);
	
		 c1 = new PdfPCell(new Paragraph(GenericUtil.getStringValid(sigitTDettIspezGtDto.getS6lPortataCombM3H()) + " (m3/h) ", FONT_HELVETICA_8));
		 c1.setBorder(Rectangle.BOTTOM);
		 tabella.addCell(c1);
		 
		 c1 = new PdfPCell(new Paragraph(GenericUtil.getStringValid(sigitTDettIspezGtDto.getS6lPortataCombKgH()) + " (kg/h)", FONT_HELVETICA_8));
		 c1.setBorder(Rectangle.RIGHT | Rectangle.BOTTOM);
		 tabella.addCell(c1);
	
		 
		 c1 = new PdfPCell(new Paragraph("h) modello e matricola bruciatore", FONT_HELVETICA_8));
		 tabella.addCell(c1);
	
		 c1 = new PdfPCell(new Paragraph(ConvertUtil.getStringByList(new ArrayList(elencoModelli), Constants.INTERVAL_SEP_SLASH), FONT_HELVETICA_8));
	     c1.setColspan(2);
		 tabella.addCell(c1);
	
		 c1 = new PdfPCell(new Paragraph(ConvertUtil.getStringByList(new ArrayList(elencoMatricole), Constants.INTERVAL_SEP_SLASH), FONT_HELVETICA_8));
		 tabella.addCell(c1);
	
		 c1 = new PdfPCell(new Paragraph("Potenza termica al focolare:", FONT_HELVETICA_8));
		 c1.setBorder(Rectangle.TOP | Rectangle.LEFT | Rectangle.BOTTOM);
		 tabella.addCell(c1);
		 
		 c1 = new PdfPCell(new Paragraph(GenericUtil.getStringValid(sigitTDettIspezGtDto.getS6lPotTermFocolKw()), FONT_HELVETICA_8));
		 c1.setBorder(Rectangle.TOP | Rectangle.BOTTOM);
		 tabella.addCell(c1);
		 
		 c1 = new PdfPCell(new Paragraph("(kW)", FONT_HELVETICA_8));
		 c1.setBorder(Rectangle.TOP | Rectangle.RIGHT | Rectangle.BOTTOM);
		 tabella.addCell(c1);
		 
		 
		 c1 = new PdfPCell(new Paragraph("i) Tipologia gruppo termico", FONT_HELVETICA_8));
		 tabella.addCell(c1);
		 
		 p1 = new Paragraph("", FONT_HELVETICA_8);
		 aggiungiCheckPrima(p1, "Singolo tipo B", GenericUtil.getCheckSi(sigitTDettIspezGtDto.getS6iFlgTipoB()), 20);
		 aggiungiCheckPrima(p1, "Singolo tipo C", GenericUtil.getCheckSi(sigitTDettIspezGtDto.getS6iFlgTipoC()), 20);
		 aggiungiCheckPrima(p1, "Modulare", Constants.ID_DETT_GT_GRUPPO_TERM_MOD.equals(ConvertUtil.convertToString(sigitRAllegatoCompGtDto.getFkDettaglioGt())), 18);
		 aggiungiCheckPrima(p1, "Tubo o nastro radiante", Constants.ID_DETT_GT_TUBO_RADIANTE.equals(ConvertUtil.convertToString(sigitRAllegatoCompGtDto.getFkDettaglioGt())), 30);
		 aggiungiCheckPrima(p1, "Ad aria calda", Constants.ID_DETT_GT_GEN_ARIA_CALDA.equals(ConvertUtil.convertToString(sigitRAllegatoCompGtDto.getFkDettaglioGt())));
	
		 c1 = new PdfPCell(p1);
	     c1.setColspan(6);
		 tabella.addCell(c1);
	
		 c1 = new PdfPCell(new Paragraph("j) Classificazione DPR 660/96", FONT_HELVETICA_8));
		 tabella.addCell(c1);
		 
		 p1 = new Paragraph("", FONT_HELVETICA_8);
		 aggiungiCheckPrima(p1, "Standard", GenericUtil.getCheck(sigitTDettIspezGtDto.getS6dFlgEvacuFumi(), Constants.ID_CLASS_DPR660_96_STANDARD), 30);
		 aggiungiCheckPrima(p1, "A bassa temperatura", GenericUtil.getCheck(sigitTDettIspezGtDto.getS6dFlgEvacuFumi(), Constants.ID_CLASS_DPR660_96_BASSA_TEMP), 30);
		 aggiungiCheckPrima(p1, "A gas a condensazione", GenericUtil.getCheck(sigitTDettIspezGtDto.getS6dFlgEvacuFumi(), Constants.ID_CLASS_DPR660_96_GAS_CONDENS));
	
		 c1 = new PdfPCell(p1);
	     c1.setColspan(6);
		 tabella.addCell(c1);
		 
		 document.add(tabella); //AGGIUNGO LA TABELLA NEL DOCUMENTO
	
		 
	 }

	private static void aggiungiManutenzioneAnalisiGT(Document document, SigitTDettIspezGtDto sigitTDettIspezGtDto) throws DocumentException {
	
		 //Suddivido il foglio in sezioni, cio� in questo caso, un foglio 100% viene diviso in due sezioni, su 8 la prima � larga 2 e l�altra larga 6. Le sezioni possono essere anche di pi� spartizioni, basta solo aggiungere un valore dopo la virgola es. {3,3,3} suddividiamo in tre sezioni uguali tra di loro.
		 float[] columnWidths = {30,70}; 
		 
		 // 2 colonne
		 
		 PdfPTable tabella = new PdfPTable(columnWidths);
		 //Definisco la tabella con il 100%, il bordo,e il margine sinis
		 tabella.setSpacingBefore(5);      
	
		 tabella.setWidthPercentage(100); 
		 tabella.getDefaultCell().setBorder(1);
		 tabella.getDefaultCell().setPaddingLeft(PADDING_LEFT);
		 
		 PdfPCell c1;
		 c1 = new PdfPCell(new Paragraph("7. MANUTENZIONE E ANALISI", FONT_HELVETICA_9_B_I));
		 c1.setHorizontalAlignment(Element.ALIGN_CENTER); 
		 c1.setBackgroundColor(Color.LIGHT_GRAY);
	     c1.setColspan(7);
		 tabella.addCell(c1);
	
		 tabella.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
	
		 
		 c1 = new PdfPCell(new Paragraph("a) Operazioni di controllo e manutenzione", FONT_HELVETICA_8));
	     c1.setRowspan(2);
		 tabella.addCell(c1);
		 
		 Paragraph p1 = new Paragraph("Frequenza", FONT_HELVETICA_8);
		 aggiungiSpaziVuoti(p1, 5);
		 aggiungiCheckPrima(p1, "Semestrale", GenericUtil.getCheck(sigitTDettIspezGtDto.getS7aFkFrequenzaManut(),Constants.ID_FREQ_SEMESTRALE), 12);
		 aggiungiCheckPrima(p1, "Annuale", GenericUtil.getCheck(sigitTDettIspezGtDto.getS7aFkFrequenzaManut(),Constants.ID_FREQ_ANNUALE), 12);
		 aggiungiCheckPrima(p1, "Biennale", GenericUtil.getCheck(sigitTDettIspezGtDto.getS7aFkFrequenzaManut(),Constants.ID_FREQ_BIENNALE), 12);
		 aggiungiCheckPrima(p1, "Altra: "+GenericUtil.getStringValid(sigitTDettIspezGtDto.getS7aFrequenzaManutAltro()), GenericUtil.getCheck(sigitTDettIspezGtDto.getS7aFkFrequenzaManut(),Constants.ID_FREQ_ALTRO), 12);
		 c1 = new PdfPCell(p1);
		 tabella.addCell(c1);
		 
		 
		 p1 = new Paragraph("Ultima manutenzione prevista effettuata", FONT_HELVETICA_8);
		 aggiungiSpaziVuoti(p1, 5);
		 aggiungiCheckPrima(p1, "Si", GenericUtil.getCheckSi(sigitTDettIspezGtDto.getS7aFlgManutEffettuata()), 12);
		 aggiungiCheckPrima(p1, "No", GenericUtil.getCheckNo(sigitTDettIspezGtDto.getS7aFlgManutEffettuata()), 12);
		 
		 p1.add("In data:");
		 p1.add(GenericUtil.getStringValid(sigitTDettIspezGtDto.getS7aDataUltimaManut()));
		 c1 = new PdfPCell(p1);
		 tabella.addCell(c1);
		 
		 
		 c1 = new PdfPCell(new Paragraph("b) Rapporto controllo efficienza", FONT_HELVETICA_8));
		 tabella.addCell(c1);
		 
		 p1 = new Paragraph("Presente", FONT_HELVETICA_8);
		 aggiungiSpaziVuoti(p1, 5);
		 aggiungiCheckPrima(p1, "Si", GenericUtil.getCheckSi(sigitTDettIspezGtDto.getS7bFlgReePresente()), 7);
		 aggiungiCheckPrima(p1, "No", GenericUtil.getCheckNo(sigitTDettIspezGtDto.getS7bFlgReePresente()), 7);
		 p1.add("In data:");
		 p1.add(GenericUtil.getStringValid(sigitTDettIspezGtDto.getS7bDataRee()));
		 aggiungiSpaziVuoti(p1, 5);
		 aggiungiCheckDopo(p1, "Osservazioni", GenericUtil.getCheckSi(sigitTDettIspezGtDto.getS7bFlgOsservazioni()), 20);
		 aggiungiCheckDopo(p1, "Raccomandazioni", GenericUtil.getCheckSi(sigitTDettIspezGtDto.getS7bFlgRaccomand()), 20);
		 aggiungiCheckDopo(p1, "Prescrizioni", GenericUtil.getCheckSi(sigitTDettIspezGtDto.getS7bFlgPrescr()));
		 c1 = new PdfPCell(p1);
		 tabella.addCell(c1);
	
		 document.add(tabella); //AGGIUNGO LA TABELLA NEL DOCUMENTO
	
		 
	 }

	private static void aggiungiMisuraDeiProdottiGT(Document document, SigitTDettIspezGtDto sigitTDettIspezGtDto, Integer nModuli) throws DocumentException {

		
		log.debug("@@@@ STAMPO il nModuli: "+nModuli);
		
		 //Suddivido il foglio in sezioni, cio� in questo caso, un foglio 100% viene diviso in due sezioni, su 8 la prima � larga 2 e l�altra larga 6. Le sezioni possono essere anche di pi� spartizioni, basta solo aggiungere un valore dopo la virgola es. {3,3,3} suddividiamo in tre sezioni uguali tra di loro.
		 float[] columnWidths = {13,2,7,12,15,12,13,13,13}; 
		 
		 String valore = null;
		 // 2 colonne
		 
		 PdfPTable tabella = new PdfPTable(columnWidths);
		 //Definisco la tabella con il 100%, il bordo,e il margine sinis
		 tabella.setSpacingBefore(5);      

		 tabella.setWidthPercentage(100); 
		 tabella.getDefaultCell().setBorder(1);
		 tabella.getDefaultCell().setPaddingLeft(PADDING_LEFT);
		 
		 PdfPCell c1;
		 c1 = new PdfPCell(new Paragraph("8. MISURA DEI PRODOTTI DI COMBUSTIONE E DEL RENDIMENTO DI COMBUSTIONE (UNI 10389 - 1)", FONT_HELVETICA_9_B_I));
		 c1.setHorizontalAlignment(Element.ALIGN_CENTER); 
		 c1.setBackgroundColor(Color.LIGHT_GRAY);
	     c1.setColspan(9);
		 tabella.addCell(c1);

		 tabella.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);

		 
		 c1 = new PdfPCell(new Paragraph("a) Modulo termico", FONT_HELVETICA_8));
		 tabella.addCell(c1);


		 Paragraph p1 = new Paragraph("N\u00B0 ", FONT_HELVETICA_8);
		 p1.add(GenericUtil.getStringValid(sigitTDettIspezGtDto.getS8aNModuloTermico()));
		 c1 = new PdfPCell(p1);
	     c1.setColspan(2);
		 tabella.addCell(c1);

		 
		 p1 = new Paragraph("di ", FONT_HELVETICA_8);
		 p1.add(ConvertUtil.convertToString(nModuli));
		 c1 = new PdfPCell(p1);
		 tabella.addCell(c1);

		 c1 = new PdfPCell(new Paragraph("b) Indice di fumosita' (combustibili liquidi)", FONT_HELVETICA_8));
	     c1.setColspan(2);
		 tabella.addCell(c1);

		 p1 = new Paragraph("1\u00B0 misura: ", FONT_HELVETICA_8);
		 p1.add(GenericUtil.getStringValid(sigitTDettIspezGtDto.getS8bFumoMis1()));
		 c1 = new PdfPCell(p1);
		 tabella.addCell(c1);

		 p1 = new Paragraph("2\u00B0 misura: ", FONT_HELVETICA_8);
		 p1.add(GenericUtil.getStringValid(sigitTDettIspezGtDto.getS8bFumoMis2()));
		 c1 = new PdfPCell(p1);
		 tabella.addCell(c1);
		 
		 p1 = new Paragraph("3\u00B0 misura: ", FONT_HELVETICA_8);
		 p1.add(GenericUtil.getStringValid(sigitTDettIspezGtDto.getS8bFumoMis3()));
		 c1 = new PdfPCell(p1);
		 tabella.addCell(c1);
		 
		 c1 = new PdfPCell(new Paragraph("c) Strumento utilizzato", FONT_HELVETICA_8));
	     c1.setColspan(2);
		 tabella.addCell(c1);
		 
		 p1 = new Paragraph("Marca: ", FONT_HELVETICA_8);
		 p1.add(GenericUtil.getStringValid(sigitTDettIspezGtDto.getS8cMarcaStrumMisura()));
		 c1 = new PdfPCell(p1);
	     c1.setColspan(3);
		 tabella.addCell(c1);
		 
		 
		 p1 = new Paragraph("Modello: ", FONT_HELVETICA_8);
		 p1.add(GenericUtil.getStringValid(sigitTDettIspezGtDto.getS8cModelloStrumMisura()));
		 c1 = new PdfPCell(p1);
	     c1.setColspan(2);
		 tabella.addCell(c1);

		 p1 = new Paragraph("Matricola: ", FONT_HELVETICA_8);
		 p1.add(GenericUtil.getStringValid(sigitTDettIspezGtDto.getS8cMatricolaStrumMisura()));
		 c1 = new PdfPCell(p1);
	     c1.setColspan(2);
		 tabella.addCell(c1);
		 document.add(tabella); //AGGIUNGO LA TABELLA NEL DOCUMENTO

		 
		 
		 
		 float[] columnWidths2 = {30,20,30,20}; 
		 
		 // 2 colonne
		 
		 tabella = new PdfPTable(columnWidths2);
		 //Definisco la tabella con il 100%, il bordo,e il margine sinis

		 tabella.setWidthPercentage(100); 
		 tabella.getDefaultCell().setBorder(1);
		 tabella.getDefaultCell().setPaddingLeft(PADDING_LEFT);
		 
		 c1 = new PdfPCell(new Paragraph("d) Valori Misurati (media delle tre misure)", FONT_HELVETICA_8));
		 c1.setHorizontalAlignment(Element.ALIGN_CENTER); 
	     c1.setColspan(2);
		 tabella.addCell(c1);

		 c1 = new PdfPCell(new Paragraph("e) Valori Calcolati", FONT_HELVETICA_8));
		 c1.setHorizontalAlignment(Element.ALIGN_CENTER); 
	     c1.setColspan(2);
		 tabella.addCell(c1);
		 
		 c1 = new PdfPCell(new Paragraph("Temperatura del fluido di mandata (\u00B0C)", FONT_HELVETICA_8));
		 tabella.addCell(c1);
		 
		 c1 = new PdfPCell(new Paragraph(GenericUtil.getStringValid(sigitTDettIspezGtDto.getS8dTempFluidoMandataC()), FONT_HELVETICA_8));
		 tabella.addCell(c1);
		 

		 c1 = new PdfPCell(new Paragraph("Indice d'aria (n)", FONT_HELVETICA_8));
		 tabella.addCell(c1);
		 
		 c1 = new PdfPCell(new Paragraph(GenericUtil.getStringValid(sigitTDettIspezGtDto.getS8eIndiceAria()), FONT_HELVETICA_8));
		 tabella.addCell(c1);

		 c1 = new PdfPCell(new Paragraph("Temperatura dell'aria comburente (\u00B0C)", FONT_HELVETICA_8));
		 tabella.addCell(c1);
		 
		 c1 = new PdfPCell(new Paragraph(GenericUtil.getStringValid(sigitTDettIspezGtDto.getS8dTempAriaC()), FONT_HELVETICA_8));
		 tabella.addCell(c1);
		 

		 c1 = new PdfPCell(new Paragraph("CO nei fumi secchi e senz'aria (ppm)", FONT_HELVETICA_8));
		 tabella.addCell(c1);
		 
		 c1 = new PdfPCell(new Paragraph(GenericUtil.getStringValid(sigitTDettIspezGtDto.getS8eFumiSecchiNoAriaPpm()), FONT_HELVETICA_8));
		 tabella.addCell(c1);
		 
		 
		 c1 = new PdfPCell(new Paragraph("Temperatura dei fumi (\u00B0C)", FONT_HELVETICA_8));
		 tabella.addCell(c1);
		 
		 c1 = new PdfPCell(new Paragraph(GenericUtil.getStringValid(sigitTDettIspezGtDto.getS8dTempFumiC()), FONT_HELVETICA_8));
		 tabella.addCell(c1);
		 

		 c1 = new PdfPCell(new Paragraph("Potenza termica persa al camino Qs(%)", FONT_HELVETICA_8));
		 tabella.addCell(c1);
		 
		 c1 = new PdfPCell(new Paragraph(GenericUtil.getStringValid(sigitTDettIspezGtDto.getS8eQsPerc()), FONT_HELVETICA_8));
		 tabella.addCell(c1);
		 
		 p1 = new Paragraph("", FONT_HELVETICA_8);
		 aggiungiCheckDopo(p1, "O2 (%)", GenericUtil.isNotNullOrEmpty(sigitTDettIspezGtDto.getS8dO2Perc()), 7);
		 p1.add("oppure ");
		 aggiungiCheckPrima(p1, "CO2 (%)", GenericUtil.isNotNullOrEmpty(sigitTDettIspezGtDto.getS8dCo2Perc()));
		 c1 = new PdfPCell(p1);
		 tabella.addCell(c1);
		 
		 if (GenericUtil.isNotNullOrEmpty(sigitTDettIspezGtDto.getS8dO2Perc()))
		 {
			 valore = ConvertUtil.convertToString(sigitTDettIspezGtDto.getS8dO2Perc());
		 } else if (GenericUtil.isNotNullOrEmpty(sigitTDettIspezGtDto.getS8dCo2Perc()))
		 {
			 valore = ConvertUtil.convertToString(sigitTDettIspezGtDto.getS8dCo2Perc());
		 }
		 
		 c1 = new PdfPCell(new Paragraph(valore, FONT_HELVETICA_8));
		 tabella.addCell(c1);
		 
		 
		 c1 = new PdfPCell(new Paragraph("Recupero calore di condensazione ET (%)", FONT_HELVETICA_8));
		 tabella.addCell(c1);
		 
		 c1 = new PdfPCell(new Paragraph(GenericUtil.getStringValid(sigitTDettIspezGtDto.getS8eEtPerc()), FONT_HELVETICA_8));
		 tabella.addCell(c1);
		 
		 
		 c1 = new PdfPCell(new Paragraph("CO nei fumi secchi (ppm)", FONT_HELVETICA_8));
		 tabella.addCell(c1);
		 
		 c1 = new PdfPCell(new Paragraph(GenericUtil.getStringValid(sigitTDettIspezGtDto.getS8dCoFumiSecchiPpm()), FONT_HELVETICA_8));
		 tabella.addCell(c1);

		 Phrase p2 = new Phrase("Rendimento di combustione ", FONT_HELVETICA_8);
		 
		 p2.add(SYMBOL_ETA);
		 
		 Chunk  p3 = new Chunk ("comb", FONT_HELVETICA_6);
		 Chunk  p4 = new Chunk (" (%)", FONT_HELVETICA_8);

		 p2.add(p3);
		 p2.add(p4);


		 //Phrase phrase = new Phrase("Rendimento di combustione \u03B7", FONT_HELVETICA_8).add(new Chunk("Environment", null));
		 c1 = new PdfPCell(p2);
		 tabella.addCell(c1);
	        
		 c1 = new PdfPCell(new Paragraph(GenericUtil.getStringValid(sigitTDettIspezGtDto.getS8eRendCombPerc()), FONT_HELVETICA_8));
		 tabella.addCell(c1);
		 
		 c1 = new PdfPCell(new Paragraph("NO al valore di ossigeno misurato (mg/kWh)", FONT_HELVETICA_8));
		 tabella.addCell(c1);
		 
		 c1 = new PdfPCell(new Paragraph(GenericUtil.getStringValid(sigitTDettIspezGtDto.getS8dNoMgKwH()), FONT_HELVETICA_8));
		 tabella.addCell(c1);
		 
		 
		 c1 = new PdfPCell(new Paragraph("NOx al 3% di ossigeno (mg/kWh)", FONT_HELVETICA_8));
		 tabella.addCell(c1);
		 
		 c1 = new PdfPCell(new Paragraph(GenericUtil.getStringValid(sigitTDettIspezGtDto.getS8eNoxMgKwH()), FONT_HELVETICA_8));
		 tabella.addCell(c1);
		 
		 
		 document.add(tabella); //AGGIUNGO LA TABELLA NEL DOCUMENTO

		 
	 }

	 private static void aggiungiEsitoProvaGT(Document document, SigitTDettIspezGtDto sigitTDettIspezGtDto) throws DocumentException {

		 //Suddivido il foglio in sezioni, cio� in questo caso, un foglio 100% viene diviso in due sezioni, su 8 la prima � larga 2 e l�altra larga 6. Le sezioni possono essere anche di pi� spartizioni, basta solo aggiungere un valore dopo la virgola es. {3,3,3} suddividiamo in tre sezioni uguali tra di loro.
		 float[] columnWidths = {40,30,30}; 
		 
		 // 2 colonne
		 
		 PdfPTable tabella = new PdfPTable(columnWidths);
		 //Definisco la tabella con il 100%, il bordo,e il margine sinis
		 tabella.setSpacingBefore(5);      

		 tabella.setWidthPercentage(100); 
		 tabella.getDefaultCell().setBorder(1);
		 tabella.getDefaultCell().setPaddingLeft(PADDING_LEFT);
		 
		 PdfPCell c1;
		 c1 = new PdfPCell(new Paragraph("9. ESITO DELLA PROVA", FONT_HELVETICA_9_B_I));
		 c1.setHorizontalAlignment(Element.ALIGN_CENTER); 
		 c1.setBackgroundColor(Color.LIGHT_GRAY);
	     c1.setColspan(3);
		 tabella.addCell(c1);

		 tabella.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);

		 Phrase p2 = new Phrase("a) ", FONT_HELVETICA_8);//u33A5
		 p2.add(new Chunk ("Monossido di carbonio", FONT_HELVETICA_8_B_I));
		 p2.add(new Chunk (" nei fumi secchi e senz'aria\n(deve essere <= 1000 ppm)", FONT_HELVETICA_8_I));

		 c1 = new PdfPCell(p2);
		 tabella.addCell(c1);
		 
		 Paragraph p1 = new Paragraph("", FONT_HELVETICA_8);
		 aggiungiCheckPrima(p1, "Regolare", GenericUtil.getCheck(sigitTDettIspezGtDto.getS9aFlgMonossidoCarb(), Constants.FLAG_REGOLARE));
		 c1 = new PdfPCell(p1);
		 c1.setHorizontalAlignment(Element.ALIGN_CENTER); 
		 c1.setVerticalAlignment(Element.ALIGN_MIDDLE); 
		 tabella.addCell(c1);

		 p1 = new Paragraph("", FONT_HELVETICA_8);
		 aggiungiCheckPrima(p1, "Irregolare", GenericUtil.getCheck(sigitTDettIspezGtDto.getS9aFlgMonossidoCarb(), Constants.FLAG_IRREGOLARE));
		 c1 = new PdfPCell(p1);
		 c1.setHorizontalAlignment(Element.ALIGN_CENTER); 
		 c1.setVerticalAlignment(Element.ALIGN_MIDDLE); 
		 tabella.addCell(c1);

		 
		 p2 = new Phrase("b) ", FONT_HELVETICA_8);
		 p2.add(new Chunk ("Indice di fumosita'", FONT_HELVETICA_8_B_I));
		 p2.add(new Chunk ("(deve essere: olio combustibile <=6; gasolio <=2)", FONT_HELVETICA_8_I));

		 c1 = new PdfPCell(p2);
		 tabella.addCell(c1);

		 p1 = new Paragraph("", FONT_HELVETICA_8);
		 aggiungiSpaziVuoti(p1, 15); 
		 aggiungiCheckPrima(p1, "Regolare", GenericUtil.getCheck(sigitTDettIspezGtDto.getS9aFlgMonossidoCarb(), Constants.FLAG_REGOLARE), 30);
		 aggiungiCheckPrima(p1, "Irregolare", GenericUtil.getCheck(sigitTDettIspezGtDto.getS9aFlgMonossidoCarb(), Constants.FLAG_IRREGOLARE), 30);
		 aggiungiCheckPrima(p1, "Na (combustibile gassoso)", GenericUtil.getCheck(sigitTDettIspezGtDto.getS9aFlgMonossidoCarb(), Constants.FLAG_NA));
		 c1 = new PdfPCell(p1);
		 c1.setColspan(2);
		 c1.setVerticalAlignment(Element.ALIGN_MIDDLE); 
		 tabella.addCell(c1);

		 p2 = new Phrase("c) ", FONT_HELVETICA_8);
		 p2.add(new Chunk ("Rendimento di combustione\n", FONT_HELVETICA_8_B_I));
		 p2.add(new Chunk ("(rendimento minimo richiesto ", FONT_HELVETICA_8_I));
		 
		 p2.add(SYMBOL_ETA);
		 
		 p2.add(new Chunk ("DPR74 e limiti reg.", FONT_HELVETICA_6_I));
		 p2.add(new Chunk (GenericUtil.getStringValid(sigitTDettIspezGtDto.getS9cRendMinCombustPerc()), FONT_HELVETICA_8_I));
		 p2.add(new Chunk ("%)", FONT_HELVETICA_8_I));
		 c1 = new PdfPCell(p2);
		 c1.setVerticalAlignment(Element.ALIGN_MIDDLE); 
		 tabella.addCell(c1);

		 p2 = new Phrase("Valore rilevato + 2 =", FONT_HELVETICA_8);
		 p2.add(GenericUtil.isNotNullOrEmpty(sigitTDettIspezGtDto.getS8eRendCombPerc())?GenericUtil.getStringValid(sigitTDettIspezGtDto.getS8eRendCombPerc().add(new BigDecimal(2))):DATO_NON_PRESENTE);
		 p2.add("%");
		 c1 = new PdfPCell(p2);
		 c1.setHorizontalAlignment(Element.ALIGN_CENTER); 
		 c1.setVerticalAlignment(Element.ALIGN_MIDDLE); 
		 tabella.addCell(c1);


		 p1 = new Paragraph("", FONT_HELVETICA_8);
		 aggiungiSpaziVuoti(p1, 5);
		 aggiungiCheckPrima(p1, "Sufficiente", GenericUtil.getCheckSi(sigitTDettIspezGtDto.getS9cFlgRendCombustSuff()), 30);
		 aggiungiCheckPrima(p1, "Non sufficiente", GenericUtil.getCheckNo(sigitTDettIspezGtDto.getS9cFlgRendCombustSuff()));
		 c1 = new PdfPCell(p1);
		 c1.setVerticalAlignment(Element.ALIGN_MIDDLE); 
		 tabella.addCell(c1);

		 p2 = new Phrase("d) ", FONT_HELVETICA_8);
		 p2.add(new Chunk ("Ossidi di azoto", FONT_HELVETICA_8_B_I));
		 p2.add(new Chunk (" (Emissioni di NOx)\n", FONT_HELVETICA_8_I));
		 p2.add(new Chunk ("(deve essere < di", FONT_HELVETICA_8_I));

		 p2.add(new Chunk (GenericUtil.getStringValid(sigitTDettIspezGtDto.getS9dOssidiAzotoLimMgKwH()), FONT_HELVETICA_8_I));
		 p2.add(new Chunk (" mg/kWh in funzione del combustibile, della potenza nominale e dell'eta' del generatore)", FONT_HELVETICA_8_I));

		 c1 = new PdfPCell(p2);
		 tabella.addCell(c1);

		 p2 = new Phrase("Valore rilevato - 20 =", FONT_HELVETICA_8);
		 p2.add(GenericUtil.isNotNullOrEmpty(sigitTDettIspezGtDto.getS8eNoxMgKwH())?GenericUtil.getStringValid(sigitTDettIspezGtDto.getS8eNoxMgKwH().subtract(new BigDecimal(20))):DATO_NON_PRESENTE);
		 p2.add("mg/kWh");
		 c1 = new PdfPCell(p2);
		 c1.setHorizontalAlignment(Element.ALIGN_CENTER); 
		 c1.setVerticalAlignment(Element.ALIGN_MIDDLE); 
		 tabella.addCell(c1);


		 p1 = new Paragraph("", FONT_HELVETICA_8);
		 aggiungiSpaziVuoti(p1, 5);
		 aggiungiCheckPrima(p1, "Regolare", GenericUtil.getCheck(sigitTDettIspezGtDto.getS9dFlgOssidiAzoto(), Constants.FLAG_REGOLARE), 30);
		 aggiungiCheckPrima(p1, "Irregolare", GenericUtil.getCheck(sigitTDettIspezGtDto.getS9dFlgOssidiAzoto(), Constants.FLAG_IRREGOLARE));
		 c1 = new PdfPCell(p1);
		 c1.setVerticalAlignment(Element.ALIGN_MIDDLE); 
		 tabella.addCell(c1);
		 
		 p1 = new Paragraph("e) ", FONT_HELVETICA_8);
		 p1.add(new Chunk ("L'impianto rispetta la normativa\n", FONT_HELVETICA_8_B_I));
		 p1.add(new Chunk ("(DPR 74/2013 e normativa regionale", FONT_HELVETICA_8_I));
		 aggiungiSpaziVuoti(p1, 20);
		 aggiungiCheckPrima(p1, "", GenericUtil.getCheckSi(sigitTDettIspezGtDto.getS9eFlgRispettoNormativa()));

		 c1 = new PdfPCell(p1);
		 tabella.addCell(c1);
		 

		 p1 = new Paragraph("e) ", FONT_HELVETICA_8);
		 p1.add(new Chunk ("L'impianto non rispetta la normativa", FONT_HELVETICA_8_B_I));
		 p1.add(new Chunk (" per quanto riguarda i punti:\n", FONT_HELVETICA_8_I));
		 aggiungiSpaziVuoti(p1, 20);
		 aggiungiCheckPrima(p1, "7.a", GenericUtil.getCheckSi(sigitTDettIspezGtDto.getS9eFlgNoRispetto7a()), 10);
		 aggiungiCheckPrima(p1, "7.b", GenericUtil.getCheckSi(sigitTDettIspezGtDto.getS9eFlgNoRispetto7b()), 10);
		 aggiungiCheckPrima(p1, "9.a", GenericUtil.getCheckSi(sigitTDettIspezGtDto.getS9eFlgNoRispetto9a()), 10);
		 aggiungiCheckPrima(p1, "9.b", GenericUtil.getCheckSi(sigitTDettIspezGtDto.getS9eFlgNoRispetto9b()), 10);
		 aggiungiCheckPrima(p1, "9.c", GenericUtil.getCheckSi(sigitTDettIspezGtDto.getS9eFlgNoRispetto9c()), 10);
		 aggiungiCheckPrima(p1, "9.d", GenericUtil.getCheckSi(sigitTDettIspezGtDto.getS9eFlgNoRispetto9d()));

		 c1 = new PdfPCell(p1);
		 c1.setColspan(2);
		 tabella.addCell(c1);

		 document.add(tabella); //AGGIUNGO LA TABELLA NEL DOCUMENTO

		 
	 }
	
	 private static void aggiungiOssPrescrDich(Document document, SigitTAllegatoDto allegato) throws DocumentException {

			 //Suddivido il foglio in sezioni, cio� in questo caso, un foglio 100% viene diviso in due sezioni, su 8 la prima � larga 2 e l�altra larga 6. Le sezioni possono essere anche di pi� spartizioni, basta solo aggiungere un valore dopo la virgola es. {3,3,3} suddividiamo in tre sezioni uguali tra di loro.
			 float[] columnWidths = {100}; 

			 // 1 colonne

			 // 10. OSSERVAZIONI
			 PdfPTable tabella = new PdfPTable(columnWidths);
			 //Definisco la tabella con il 100%, il bordo,e il margine sinis
			 tabella.setSpacingBefore(5);      

			 tabella.setWidthPercentage(100); 
			 tabella.getDefaultCell().setBorder(1);
			 tabella.getDefaultCell().setPaddingLeft(PADDING_LEFT);

			 PdfPCell c1 = new PdfPCell(new Paragraph("10. OSSERVAZIONI", FONT_HELVETICA_9_B_I));
			 c1.setHorizontalAlignment(Element.ALIGN_CENTER); 
			 c1.setBackgroundColor(Color.LIGHT_GRAY);
			 c1.setColspan(7);
			 tabella.addCell(c1);

			 tabella.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);


			 c1 = new PdfPCell(new Paragraph(GenericUtil.getStringValid(allegato.getFOsservazioni()), FONT_HELVETICA_8));
			 tabella.addCell(c1);

			 document.add(tabella); //AGGIUNGO LA TABELLA NEL DOCUMENTO


			 // 11. PRESCRIZIONI 
			 tabella = new PdfPTable(columnWidths);
			 //Definisco la tabella con il 100%, il bordo,e il margine sinis
			 tabella.setSpacingBefore(5);      

			 tabella.setWidthPercentage(100); 
			 tabella.getDefaultCell().setBorder(1);
			 tabella.getDefaultCell().setPaddingLeft(PADDING_LEFT);

			 c1 = new PdfPCell(new Paragraph("11. PRESCRIZIONI", FONT_HELVETICA_9_B_I));
			 c1.setHorizontalAlignment(Element.ALIGN_CENTER); 
			 c1.setBackgroundColor(Color.LIGHT_GRAY);
			 c1.setColspan(7);
			 tabella.addCell(c1);

			 tabella.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);


			 c1 = new PdfPCell(new Paragraph(GenericUtil.getStringValid(allegato.getFPrescrizioni()), FONT_HELVETICA_8));
			 tabella.addCell(c1);

			 document.add(tabella); //AGGIUNGO LA TABELLA NEL DOCUMENTO

			 // 12. DICHIARAZIONI DEL RESPONSABILE DELL�IMPIANTO 
			 tabella = new PdfPTable(columnWidths);
			 //Definisco la tabella con il 100%, il bordo,e il margine sinis
			 tabella.setSpacingBefore(5);      

			 tabella.setWidthPercentage(100); 
			 tabella.getDefaultCell().setBorder(1);
			 tabella.getDefaultCell().setPaddingLeft(PADDING_LEFT);

			 c1 = new PdfPCell(new Paragraph("12. DICHIARAZIONI DEL RESPONSABILE DELL'IMPIANTO", FONT_HELVETICA_9_B_I));
			 c1.setHorizontalAlignment(Element.ALIGN_CENTER); 
			 c1.setBackgroundColor(Color.LIGHT_GRAY);
			 c1.setColspan(7);
			 tabella.addCell(c1);

			 tabella.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);


			 c1 = new PdfPCell(new Paragraph(GenericUtil.getStringValid(allegato.getFRaccomandazioni()), FONT_HELVETICA_8));
			 tabella.addCell(c1);

			 document.add(tabella); //AGGIUNGO LA TABELLA NEL DOCUMENTO


		 }
	 
	 public static void createTabellaProvaPdf(Document document) throws IOException, DocumentException {
	       // Document document = new Document();
	        //PdfWriter.getInstance(document, new FileOutputStream(dest));
	        //document.open();
	        PdfPTable table = new PdfPTable(10);
	        table.setTotalWidth(Utilities.millimetersToPoints(100));
	        table.setLockedWidth(true);
	        table.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
	        table.addCell(getCell(10));
	        table.addCell(getCell(5));
	        table.addCell(getCell(3));
	        table.addCell(getCell(2));
	        table.addCell(getCell(3));
	        table.addCell(getCell(5));
	        table.addCell(getCell(1));
	        table.completeRow();
	        document.add(table);
	        document.close();
	    }

	    private static PdfPCell getCell(int cm) {
	        PdfPCell cell = new PdfPCell();
	        cell.setColspan(cm);
	        cell.setUseAscender(true);
	        cell.setUseDescender(true);
	        Paragraph p = new Paragraph(
	                String.format("%smm", 10 * cm),
	                new Font(Font.HELVETICA, 8));
	        p.setAlignment(Element.ALIGN_CENTER);
	        cell.addElement(p);
	        return cell;
	    }
	    
	    /*
	    private static void aggiungiSpaziVuoti(Paragraph paragraph, String testo, int minSpazio) {

			 if (minSpazio != MIN_SPAZIO_NON_PRESENTE && testo.length() < minSpazio)
			 {
				 StringBuffer sb = new StringBuffer();

				 for (int i = testo.length(); i < minSpazio; i++) {
					 
					 sb.append(" ");
				 }

				 paragraph.add(sb.toString());

			 }
			 

		 }
			*/
	    
		 

		 /*
		 private static Font creaHelveticaFont(int size)
		 {
			 
				 return creaHelveticaBoldItalicFont(size, Font.NORMAL);
				  //return new Font(BaseFont.createFont(FONT_HELVETICA, BaseFont.IDENTITY_H, BaseFont.EMBEDDED), size, Font.BOLD | Font.ITALIC);
				 //return new Font(Font.FontFamily.HELVETICA, 9);
			 
		 }

		 private static Font creaHelveticaBoldFont(int size)
		 {
			
				 return creaHelveticaBoldItalicFont(size, Font.BOLD);

				  //return new Font(BaseFont.createFont(FONT_HELVETICA, BaseFont.IDENTITY_H, BaseFont.EMBEDDED), size, Font.BOLD | Font.ITALIC);
				 //return new Font(Font.FontFamily.HELVETICA, 9);
			 
		 }
		 
		 private static Font creaHelveticaItalicFont(int size)
		 {
			
				 return creaHelveticaBoldItalicFont(size, Font.ITALIC);

				  //return new Font(BaseFont.createFont(FONT_HELVETICA, BaseFont.IDENTITY_H, BaseFont.EMBEDDED), size, Font.BOLD | Font.ITALIC);
				 //return new Font(Font.FontFamily.HELVETICA, 9);
			 
		 }
		 
		 private static Font creaHelveticaBoldItalicFont(int size)
		 {
			 
				 return creaHelveticaBoldItalicFont(size, Font.BOLD | Font.ITALIC);
				  //return new Font(BaseFont.createFont(FONT_HELVETICA, BaseFont.IDENTITY_H, BaseFont.EMBEDDED), size, Font.BOLD | Font.ITALIC);
				 //return new Font(Font.FontFamily.HELVETICA, 9);
			 
		}
		 
		 private static Font creaHelveticaBoldItalicFont(int size, int style)
		 {
			 try
			 {
				  //return new Font(BaseFont.createFont(FONT_HELVETICA, BaseFont.IDENTITY_H, BaseFont.EMBEDDED), size, style);
				 return new Font(Font.HELVETICA, size, style);
				 
				 //return new Font(Font.FontFamily.HELVETICA, 9);
			 }
			 catch (Exception e)
			 {
				 return null;
			 }
		 }
		 */
}
