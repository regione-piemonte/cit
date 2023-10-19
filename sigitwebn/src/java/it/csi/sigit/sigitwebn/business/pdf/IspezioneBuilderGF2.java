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
import java.util.List;

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

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTAllegatoDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTDettIspezGfDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTImpiantoDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTPersonaFisicaDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTPersonaGiuridicaDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTRappIspezGfDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTTrattH2ODto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTUnitaImmobiliareDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitVSk4GfDto;
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

public class IspezioneBuilderGF2 extends BaseBuilder {

	private static String FILE = "D:/progetti/eclipse oxygen/sigit/sigit_sigitwebn/src/java/test/sigitwebn/TestIspezioneGF";

	public static String getDataCompleta() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HH_mm_ss");
		return sdf.format(new Date());
	}

	
	public static void main(String[] args) {
		try {
			IspezioneBuilderGF2 ispezione = new IspezioneBuilderGF2();

			DettaglioDocumento dettaglioDocumento = ispezione.generaIspezioneGf(null, true);
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
	
	
	
	public DettaglioDocumento generaIspezioneGf(DettaglioAllegato ispezione, boolean isSimulazione)
	{
		DettaglioDocumento result = new DettaglioDocumento();

		try
		{
			Integer idIspezione = null;
		
			DatiGFCommon allegato2Common = null; 
			List<SigitVSk4GfDto> allegatoCompGfList = null;
			List<SigitTDettIspezGfDto> dettIspezList = null;

			Ispezione2018 dettaglioIspezione = null;

			SigitTAllegatoDto allegato = null;

			SigitTRappIspezGfDto rappIspez = null;
			
			
			SigitTUnitaImmobiliareDto unitaImmobPrincipale = null;

			 SigitTImpiantoDto impianto = null;
			 SigitTTrattH2ODto h2O = null;
			 

			if (!isSimulazione)
			{
				idIspezione = ispezione.getIdIspezione2018();
				
				allegato2Common = getSigitMgr().cercaDatiAllegato2Common(ispezione); 

				allegatoCompGfList = allegato2Common.getSk4GfDtoList();
				 impianto = allegato2Common.getImpiantoDto();
				 h2O = allegato2Common.getDettaglioTrattAcquaDto();
				 

				dettaglioIspezione = getSigitMgr().caricaIspezioneDaId(ConvertUtil.convertToString(idIspezione), false, true);

				allegato = allegato2Common.getAllegatoDto();

				rappIspez = getSigitMgr().cercaRappIspezioneGfByIdIspez(allegato.getIdAllegato());
				
				dettIspezList = getSigitMgr().cercaDettIspezioneListGfByIdIspez(allegato.getIdAllegato(), null);
				
				for (SigitTUnitaImmobiliareDto ui : allegato2Common.getUnitaImmobiliareList()) {
					 if(ConvertUtil.convertToBooleanAllways(ui.getFlgPrincipale()))
						 unitaImmobPrincipale = ui;
				 }
				
			}
			else
			{
				idIspezione = 20;
				
				allegato2Common = new DatiGFCommon();
				
				allegato2Common.setPersonaFisicaDto(new SigitTPersonaFisicaDto());
				allegato2Common.setPersonaGiuridicaDto(new SigitTPersonaGiuridicaDto());
				
				 impianto = new SigitTImpiantoDto();
				 h2O = new SigitTTrattH2ODto();

				dettaglioIspezione = new Ispezione2018();
				
				allegato2Common.setImpiantoDto(new SigitTImpiantoDto());
				allegato2Common.setAllegatoDto(new SigitTAllegatoDto());

				allegato = new SigitTAllegatoDto();
				allegato.setFkStatoRapp(ConvertUtil.convertToBigDecimal(Constants.ID_STATO_RAPPORTO_BOZZA));
				
				rappIspez = new SigitTRappIspezGfDto();
				
				allegatoCompGfList = new ArrayList<SigitVSk4GfDto>();
				allegatoCompGfList.add(new SigitVSk4GfDto());
				
				dettIspezList = new ArrayList<SigitTDettIspezGfDto>();
				dettIspezList.add(new SigitTDettIspezGfDto());
				
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

			aggiungiIntestazioneGF(document);

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
			
			//document.add(new Paragraph("Foglio n°_________ di __________", FONT_HELVETICA_9_I));

			int numPagine = 1;
			String totPagine = ConvertUtil.convertToString(allegatoCompGfList.size()+1);
			
			/*
			Paragraph p3 = new Paragraph("Foglio n° ", FONT_HELVETICA_9_I);
			//p3.add("Foglio n° ");
			aggiungiTesto(p3, ConvertUtil.convertToString(++numPagine), 5);
			p3.add(" di ");
			aggiungiTesto(p3,totPagine , 10);
			*/
			
			Paragraph p3 = aggiungiNumFoglio(numPagine++, totPagine);
			document.add(p3);

			//document.add( Chunk.LINEHEIGHT);

			log.debug("generaIspezione - PASSO 5");

			aggiungiDatiGeneraliGF(document, idIspezione, dettaglioIspezione, rappIspez, allegato2Common, unitaImmobPrincipale);

			log.debug("generaIspezione - PASSO 6");

			aggiungiDestinazioneGF(document, impianto, h2O, unitaImmobPrincipale, rappIspez);

			log.debug("generaIspezione - PASSO 7");

			aggiungiControlloImpiantoGF(document, rappIspez);

			log.debug("generaIspezione - PASSO 8");

			aggiungiStatoDocumentazioneGF(document, rappIspez);

			log.debug("generaIspezione - PASSO 9");

			aggiungiInterventiMiglioramentoGF(document, rappIspez);
			
			
			
			SigitVSk4GfDto sigitRAllegatoCompGfDto = null;
			for (int i = 0; i < allegatoCompGfList.size(); i++) {
				sigitRAllegatoCompGfDto = allegatoCompGfList.get(i);
				
			
				// Nuova pagina
				 document.newPage();
				 
			     //document.add(new Paragraph("Foglio n°_________ di _________ Catasto impianti/codice: _________ Data dell'ispezione: _________ N° _________", FONT_HELVETICA_9_I));
			    /*
				 p3 = new Paragraph("Foglio n° ", FONT_HELVETICA_9_I);
					//p3.add("Foglio n° ");
					aggiungiTesto(p3, ConvertUtil.convertToString(numPagine++), 10);
					p3.add(" di ");
					//aggiungiTesto(p3, totPagine , 10);
					*/
				 
					p3 = aggiungiNumFoglio(numPagine++, totPagine);

					p3.add("Catasto impianti/codice: ");
					aggiungiTesto(p3, ConvertUtil.getStringValid(allegato2Common.getImpiantoDto().getCodiceImpianto()) , 10);
					p3.add("Data dell'ispezione: ");
					aggiungiTesto(p3, ConvertUtil.getStringValid(allegato2Common.getAllegatoDto().getDataControllo()) , 15);
					p3.add("N° ");
					aggiungiTesto(p3, ConvertUtil.getStringValid(idIspezione) , 10);

					document.add(p3);
					
			     
			     // Devo recuperare da r_allegato_comp_gf quanti GF ci sono (es GF-1, GF-2, ecc)
			     // devo recuperare su comp_gf i dati
			     // PER ADESSO NON RECUPERARE - devo recuperare su sigit_t_comp_br_rc x i bruciatori
					aggiungiGruppoFrigoGF(document, dettIspezList.get(0), sigitRAllegatoCompGfDto);

					aggiungiManutenzioneAnalisiGF(document, dettIspezList.get(0));
				 
				 for (SigitTDettIspezGfDto sigitTDettIspezGfDto : dettIspezList) {
					
					 aggiungiControlloEVerificaEnergeticaGF(document, sigitTDettIspezGfDto, dettIspezList.size());

					 aggiungiEsitoProvaGF(document, sigitTDettIspezGfDto);

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
	
	 private static void aggiungiIntestazioneGF(Document document) throws DocumentException {
		 // Paragraph prefazione = new Paragraph();

		 //Oltre a creare una semplice tabella, questo metodo e anche buono se si vuole gestire il foglio in sezioni, in modo molto semplice. L’idea è paragonabile alla programmazione HTML, quando si usano le tabelle.
		 //float paddingleft=10f; //Margine Sx 

		 //Suddivido il foglio in sezioni, cioè in questo caso, un foglio 100% viene diviso in due sezioni, su 8 la prima è larga 2 e l’altra larga 6. Le sezioni possono essere anche di più spartizioni, basta solo aggiungere un valore dopo la virgola es. {3,3,3} suddividiamo in tre sezioni uguali tra di loro.
		 float[] columnWidths = {2,8}; 

		 PdfPTable tabella = new PdfPTable(columnWidths);
		 //Definisco la tabella con il 100%, il bordo,e il margine sinis

		 tabella.setWidthPercentage(100); 
		 tabella.getDefaultCell().setBorder(2);
		 tabella.getDefaultCell().setBackgroundColor(Color.LIGHT_GRAY);
		 tabella.getDefaultCell().setPaddingLeft(PADDING_LEFT);

		 
		 
		 //tabella.addCell("Prova 1");
		 
		 //A questo punto viene definito la cella, in cui gli metto il testo e tutto e infine lo aggiungo alla tabella. Rifacendo le stesse istruzioni, ci spostiamo nella prossima cella.

		 //Modo per inserire un’immagine all’interno di una cella
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

		 
		 
		 
/*
		 c1 = new PdfPCell(new Paragraph("TESTO", smallBold));
		 c1.setHorizontalAlignment(Element.ALIGN_RIGHT); 
		 c1.setBackgroundColor(Color.DARK_GRAY);
		 //c1.setBorder(0);

		 tabella.addCell(c1);

		 //c1 = new PdfPCell(new Paragraph("PROVA", bigFont));
		 //c1.setHorizontalAlignment(Element.ALIGN_LEFT); 
		 //c1.setBorder(0);

		 tabella.addCell(c1);

*/

		 document.add(tabella); //AGGIUNGO LA TABELLA NEL DOCUMENTO


		
	 }
	 

	

	
	 
	 private static void aggiungiDatiGeneraliGF(Document document, Integer idIspezione, Ispezione2018 dettaglioIspezione, SigitTRappIspezGfDto rappIspez, DatiGFCommon allegato1Common, SigitTUnitaImmobiliareDto unitaImmobPrincipale) throws DocumentException {
		 // Paragraph prefazione = new Paragraph();
	
		 //Oltre a creare una semplice tabella, questo metodo e anche buono se si vuole gestire il foglio in sezioni, in modo molto semplice. L’idea è paragonabile alla programmazione HTML, quando si usano le tabelle.
		 //float paddingleft=10f; //Margine Sx 
	
			SigitTPersonaFisicaDto pf = allegato1Common.getPersonaFisicaDto();
			SigitTPersonaGiuridicaDto pg = allegato1Common.getPersonaGiuridicaDto();
	
		 SigitTImpiantoDto impiantoDto = allegato1Common.getImpiantoDto();
		 SigitTAllegatoDto allegatoDto = allegato1Common.getAllegatoDto();
	
		 //Suddivido il foglio in sezioni, cioè in questo caso, un foglio 100% viene diviso in due sezioni, su 8 la prima è larga 2 e l’altra larga 6. Le sezioni possono essere anche di più spartizioni, basta solo aggiungere un valore dopo la virgola es. {3,3,3} suddividiamo in tre sezioni uguali tra di loro.
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
		 
		 //Suddivido il foglio in sezioni, cioè in questo caso, un foglio 100% viene diviso in due sezioni, su 8 la prima è larga 2 e l’altra larga 6. Le sezioni possono essere anche di più spartizioni, basta solo aggiungere un valore dopo la virgola es. {3,3,3} suddividiamo in tre sezioni uguali tra di loro.
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
	
		 /*
		 p = new Paragraph();
		 p.add("Bollino");
		 p.setFont(FONT_TIMES_7);
		 c2 = new PdfPCell();
		 c2.setVerticalAlignment(Element.ALIGN_MIDDLE);
		 c2.addElement(p);
		 //c2.setUseAscender(true);
		 //c2.setUseDescender(true);
	     c2.setRowspan(2);
		 tabella2.addCell(c2);
		 */
		 
		 /*
		 c2 = new PdfPCell(new Paragraph("Bollino", FONT_TIMES_7));
		 c2.setVerticalAlignment(Element.ALIGN_MIDDLE);
	     c2.setRowspan(2);
		 tabella2.addCell(c2);
		 */
		 
		 c2 = new PdfPCell(new Paragraph("N° bollino "+ConvertUtil.formattaSiglaBollino(rappIspez.getS1cSiglaBollino(), rappIspez.getS1cNumBollino()), FONT_HELVETICA_8));
		 tabella2.addCell(c2);
	
		 //BEPPE
		 c2 = new PdfPCell(new Paragraph("Data bollino "+ConvertUtil.getStringValid(rappIspez.getS1cDataRee()), FONT_HELVETICA_8));
		 tabella2.addCell(c2);
	
		 
		 document.add(tabella2); //AGGIUNGO LA TABELLA NEL DOCUMENTO
	
		 ///////// OK - sopra
	
		 
		 
		 
		 
		 
		 
		 //float[] columnWidths3 = {15,30,15,10,24,21}; 
		 float[] columnWidths3 = {15,30,15,40};
	
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
	     //c3.setColspan(3);
	     tabella3.addCell(c3);
	
	     
	     
		 // Seconda riga tabella3
	     c3 = new PdfPCell(new Paragraph("e) Impianto", FONT_HELVETICA_8));
		 tabella3.addCell(c3);
	     
		 c3 = new PdfPCell(new Paragraph("Data prima installazione: "+ConvertUtil.getStringValid(rappIspez.getS1eDtPrimaInstallazione()), FONT_HELVETICA_8));
		 //c3.setVerticalAlignment(Element.ALIGN_MIDDLE);
	     //c3.setColspan(2);
	     tabella3.addCell(c3);
	     
		 Paragraph p3 = new Paragraph("Potenze termiche nominali totale massima: ", FONT_HELVETICA_8);
		 p3.add(ConvertUtil.getStringValid(rappIspez.getS1ePotTermicaMaxKw()));
		 p3.add("  (kW) ");
	     c3 = new PdfPCell(p3);
	     c3.setColspan(2);
		 //c3.setVerticalAlignment(Element.ALIGN_MIDDLE);
	     //c3.setColspan(2);
	     tabella3.addCell(c3);
	     
	     //c3 = new PdfPCell(new Paragraph("al focolare "+ConvertUtil.getStringValid(rappIspez.getS1ePotTermicaMaxKw())+" (kW)", FONT_HELVETICA_8));
		 //c3.setVerticalAlignment(Element.ALIGN_MIDDLE);
	     //c3.setColspan(2);
	     //tabella3.addCell(c3);
	     
//	     c3 = new PdfPCell(new Paragraph("Utile "+ConvertUtil.getStringValid(rappIspez.getS1ePotUtileKw())+" (kW)", FONT_HELVETICA_8));
//		 //c3.setVerticalAlignment(Element.ALIGN_MIDDLE);
//	     //c3.setColspan(2);
//	     tabella3.addCell(c3);
		 
	     
	     
		 // Terza riga tabella3
	     c3 = new PdfPCell(new Paragraph("f) Ubicazione", FONT_HELVETICA_8));
		 c3.setVerticalAlignment(Element.ALIGN_MIDDLE);
	     c3.setRowspan(2);
	     tabella3.addCell(c3);
	
	     c3 = new PdfPCell(new Paragraph("Comune: "+ConvertUtil.getStringValid(impiantoDto.getDenominazioneComune()), FONT_HELVETICA_8));
		 //c3.setVerticalAlignment(Element.ALIGN_MIDDLE);
	     //c3.setColspan(2);
	     tabella3.addCell(c3);
	     
	     
	     c3 = new PdfPCell(new Paragraph("Localita': "+ConvertUtil.getStringValid(impiantoDto.getSiglaProvincia()), FONT_HELVETICA_8));
		 //c3.setVerticalAlignment(Element.ALIGN_MIDDLE);
	     //c3.setColspan(3);
	     c3.setColspan(2);
	     tabella3.addCell(c3);
	     
	     String indirizzo = GenericUtil.isNotNullOrEmpty(unitaImmobPrincipale.getIndirizzoSitad()) ? 
					unitaImmobPrincipale.getIndirizzoSitad() : unitaImmobPrincipale.getIndirizzoNonTrovato();
	     
	     c3 = new PdfPCell(new Paragraph("Indirizzo: "+ConvertUtil.getStringValid(indirizzo), FONT_HELVETICA_8));
		 //c3.setVerticalAlignment(Element.ALIGN_MIDDLE);
	     c3.setColspan(3);
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
	     
		 p3 = new Paragraph("", FONT_HELVETICA_8);
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
	
		 ///////// OK - sopra
	
	     
	     
	     
	     
	     
	     
	     
	     
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
	private static void aggiungiDestinazioneGF(Document document, SigitTImpiantoDto impianto, SigitTTrattH2ODto h2O, SigitTUnitaImmobiliareDto unitaImmobPrincipale,  SigitTRappIspezGfDto rappIspez) throws DocumentException {
		 // Paragraph prefazione = new Paragraph();
	
		 //Oltre a creare una semplice tabella, questo metodo e anche buono se si vuole gestire il foglio in sezioni, in modo molto semplice. L’idea è paragonabile alla programmazione HTML, quando si usano le tabelle.
		 //float paddingleft=10f; //Margine Sx 
	
		 //Suddivido il foglio in sezioni, cioè in questo caso, un foglio 100% viene diviso in due sezioni, su 8 la prima è larga 2 e l’altra larga 6. Le sezioni possono essere anche di più spartizioni, basta solo aggiungere un valore dopo la virgola es. {3,3,3} suddividiamo in tre sezioni uguali tra di loro.
		 //float[] columnWidths = {20,15,20,45}; 
		 float[] columnWidths = {20,40,40}; 
	
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
	     c1.setColspan(2);
	
		 tabella.addCell(c1);
		 
		 c1 = new PdfPCell(new Paragraph("b) Unità immobiliari servite ", FONT_HELVETICA_8));
		 tabella.addCell(c1);
	
		 p1 = new Paragraph("", FONT_HELVETICA_8);
		 aggiungiCheckPrima(p1, "Singola inita' immobiliare", GenericUtil.getCheckSi(unitaImmobPrincipale.getL12FlgSingolaUnita()), 70);
		 aggiungiCheckPrima(p1, "Piu' unita' immobiliari", GenericUtil.getCheckNo(unitaImmobPrincipale.getL12FlgSingolaUnita()));
		 c1 = new PdfPCell(p1);
	     c1.setColspan(2);
		 tabella.addCell(c1);
	
		 c1 = new PdfPCell(new Paragraph("c) Uso dell'impianto ", FONT_HELVETICA_8));
		 tabella.addCell(c1);
	
	
		 p1 = new Paragraph("", FONT_HELVETICA_8);
		 aggiungiCheckPrima(p1, "Raffrescamento estivo", GenericUtil.isBigDecimalPositive(impianto.getL13PotClimaEstKw()), 30);
		 aggiungiCheckPrima(p1, "Riscaldamento ambienti", GenericUtil.isBigDecimalPositive(impianto.getL13PotClimaInvKw()), 30);
		 aggiungiCheckPrima(p1, "Produzione Acqua Calda Sanitaria", GenericUtil.isBigDecimalPositive(impianto.getL13PotH2oKw()));
		 c1 = new PdfPCell(p1);
	     c1.setColspan(2);
		 tabella.addCell(c1);
	
		 c1 = new PdfPCell(new Paragraph("e) Volume lorda servita", FONT_HELVETICA_8));
		 tabella.addCell(c1);
	
		 p1 = new Paragraph("In raffrescamento estivo", FONT_HELVETICA_8);
		 p1.add(GenericUtil.getStringValid(unitaImmobPrincipale.getL12VolRaffM3()));
		 p1.add(" (m3)");
		 c1 = new PdfPCell(p1);
	     //c1.setColspan(2);
		 tabella.addCell(c1);

		 p1 = new Paragraph("In riscaldamento ambienti", FONT_HELVETICA_8);
		 p1.add(GenericUtil.getStringValid(unitaImmobPrincipale.getL12VolRiscM3()));
		 p1.add(" (m3)");
		 c1 = new PdfPCell(p1);
	     //c1.setColspan(2);
		 tabella.addCell(c1);

		 // Colonna vuota
		 //tabella.addCell(new PdfPCell());
	
		 
		 
		 c1 = new PdfPCell(new Paragraph("f) Trattamento dell'acqua", FONT_HELVETICA_8));
		 c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
	     //c1.setRowspan(2);
		 tabella.addCell(c1);
	
		 p1 = new Paragraph("", FONT_HELVETICA_8);
		 aggiungiCheckPrima(p1, "Non richiesto", GenericUtil.getCheckSi(rappIspez.getS2eFlgTrattH2oNonRich()), 20);
		 aggiungiCheckPrima(p1, "Assente", GenericUtil.getCheckSi(h2O.getL23FlgTrattClimaAssente()), 20);
		 aggiungiCheckPrima(p1, "Filtrazione", GenericUtil.getCheckSi(h2O.getL23FlgTrattClimaFiltr()), 20);
		 aggiungiCheckPrima(p1, "Addolcimento", GenericUtil.getCheckSi(h2O.getL23FlgTrattClimaAddolc()), 20);
		 aggiungiCheckPrima(p1, "Cond. chimico", GenericUtil.getCheckSi(h2O.getL23FlgTrattClimaChimico()), 20);
		 
		 c1 = new PdfPCell(p1);
	     c1.setColspan(2);
		 tabella.addCell(c1);
		 
		
		 document.add(tabella); //AGGIUNGO LA TABELLA NEL DOCUMENTO
	
		 
	 }

	private static void aggiungiControlloImpiantoGF(Document document, SigitTRappIspezGfDto rappIspez) throws DocumentException {
		 // Paragraph prefazione = new Paragraph();
	
		 //Oltre a creare una semplice tabella, questo metodo e anche buono se si vuole gestire il foglio in sezioni, in modo molto semplice. L’idea è paragonabile alla programmazione HTML, quando si usano le tabelle.
		 //float paddingleft=10f; //Margine Sx 
	
		 //Suddivido il foglio in sezioni, cioè in questo caso, un foglio 100% viene diviso in due sezioni, su 8 la prima è larga 2 e l’altra larga 6. Le sezioni possono essere anche di più spartizioni, basta solo aggiungere un valore dopo la virgola es. {3,3,3} suddividiamo in tre sezioni uguali tra di loro.
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
		 c1 = new PdfPCell(new Paragraph("a) Locale di installazione idoneo", FONT_HELVETICA_8));
		 tabella.addCell(c1);
	
		 Paragraph p1 = new Paragraph("", FONT_HELVETICA_8);
	
		 //if (ConvertUtil.convertToInteger(rappIspez.getS3aFlgLocaleIntIdoneo()) == Constants.ID_STATO_LIBRETTO_BOZZA
		 aggiungiCheckSi(p1, GenericUtil.getCheckSi(rappIspez.getS3aFlgLocaleIntIdoneo()));
		 aggiungiCheckNo(p1, GenericUtil.getCheckNo(rappIspez.getS3aFlgLocaleIntIdoneo()));
		 aggiungiCheckPrima(p1, "Nc", GenericUtil.getCheckNc(rappIspez.getS3aFlgLocaleIntIdoneo()));
		 c1 = new PdfPCell(p1);
		 tabella.addCell(c1);
	
	
		 c1 = new PdfPCell(new Paragraph("b) Linee elettriche idonee (esame visivo)", FONT_HELVETICA_8));
		 tabella.addCell(c1);
	
		 p1 = new Paragraph("", FONT_HELVETICA_8);
	
		 aggiungiCheckSi(p1, GenericUtil.getCheckSi(rappIspez.getS3bFlgLineeElettrIdonee()));
		 aggiungiCheckNo(p1, GenericUtil.getCheckNo(rappIspez.getS3bFlgLineeElettrIdonee()));
		 aggiungiCheckPrima(p1, "Nc", GenericUtil.getCheckNc(rappIspez.getS3bFlgLineeElettrIdonee()));
		 c1 = new PdfPCell(p1);
		 tabella.addCell(c1);
	
	
		 // Riga 2
		 c1 = new PdfPCell(new Paragraph("c) Aperture di ventilazione adeguate", FONT_HELVETICA_8));
		 tabella.addCell(c1);
	
		 p1 = new Paragraph("", FONT_HELVETICA_8);
	
		 aggiungiCheckSi(p1, GenericUtil.getCheckSi(rappIspez.getS3cFlgVentilazAdeguate()));
		 aggiungiCheckNo(p1, GenericUtil.getCheckNo(rappIspez.getS3cFlgVentilazAdeguate()));
		 aggiungiCheckPrima(p1, "Na", GenericUtil.getCheckNc(rappIspez.getS3cFlgVentilazAdeguate()));
		 c1 = new PdfPCell(p1);
		 tabella.addCell(c1);
	
	
		 c1 = new PdfPCell(new Paragraph("d) Coibentazioni idonee (esame visivo)", FONT_HELVETICA_8));
		 tabella.addCell(c1);
	
		 p1 = new Paragraph("", FONT_HELVETICA_8);
	
		 aggiungiCheckSi(p1, GenericUtil.getCheckSi(rappIspez.getS3dFlgCoibentazioniIdonee()));
		 aggiungiCheckNo(p1, GenericUtil.getCheckNo(rappIspez.getS3dFlgCoibentazioniIdonee()));
		 aggiungiCheckPrima(p1, "Nc", GenericUtil.getCheckNc(rappIspez.getS3dFlgCoibentazioniIdonee()));
		 c1 = new PdfPCell(p1);
		 tabella.addCell(c1);
	
		 document.add(tabella); //AGGIUNGO LA TABELLA NEL DOCUMENTO
	
	
	 }

	private static void aggiungiStatoDocumentazioneGF(Document document, SigitTRappIspezGfDto rappIspez) throws DocumentException {
		 // Paragraph prefazione = new Paragraph();
	
		 //Oltre a creare una semplice tabella, questo metodo e anche buono se si vuole gestire il foglio in sezioni, in modo molto semplice. L’idea è paragonabile alla programmazione HTML, quando si usano le tabelle.
		 //float paddingleft=10f; //Margine Sx 
	
		 //Suddivido il foglio in sezioni, cioè in questo caso, un foglio 100% viene diviso in due sezioni, su 8 la prima è larga 2 e l’altra larga 6. Le sezioni possono essere anche di più spartizioni, basta solo aggiungere un valore dopo la virgola es. {3,3,3} suddividiamo in tre sezioni uguali tra di loro.
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
	
		 document.add(tabella); //AGGIUNGO LA TABELLA NEL DOCUMENTO
	 }

	private static void aggiungiInterventiMiglioramentoGF(Document document, SigitTRappIspezGfDto rappIspez) throws DocumentException {
		 // Paragraph prefazione = new Paragraph();
	
		 //Oltre a creare una semplice tabella, questo metodo e anche buono se si vuole gestire il foglio in sezioni, in modo molto semplice. L’idea è paragonabile alla programmazione HTML, quando si usano le tabelle.
		 //float paddingleft=10f; //Margine Sx 
	
		 //Suddivido il foglio in sezioni, cioè in questo caso, un foglio 100% viene diviso in due sezioni, su 8 la prima è larga 2 e l'altra larga 6. Le sezioni possono essere anche di più spartizioni, basta solo aggiungere un valore dopo la virgola es. {3,3,3} suddividiamo in tre sezioni uguali tra di loro.
	
		 float[] columnWidths = {20,80}; 
	
		 PdfPTable tabella = new PdfPTable(columnWidths);
		 //Definisco la tabella con il 100%, il bordo,e il margine sinis
		 tabella.setSpacingBefore(5);      
	
		 tabella.setWidthPercentage(100); 
		 tabella.getDefaultCell().setBorder(1);
		 tabella.getDefaultCell().setPaddingLeft(PADDING_LEFT);
	
		 PdfPCell c1;
		 c1 = new PdfPCell(new Paragraph("5. INTERVENTI DI MIGLIORAMENTO ENERGETICO DELL’IMPIANTO", FONT_HELVETICA_9_B_I));
		 c1.setHorizontalAlignment(Element.ALIGN_CENTER); 
		 c1.setBackgroundColor(Color.LIGHT_GRAY);
		 c1.setColspan(3);
		 tabella.addCell(c1);
	
		 tabella.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
	
		 // Riga 1
		 c1 = new PdfPCell(new Paragraph("a) CHECK-LIST", FONT_HELVETICA_8));
		 c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
		 c1.setRowspan(4);
		 tabella.addCell(c1);
	
		 Paragraph p1 = new Paragraph("", FONT_HELVETICA_8);
		 aggiungiCheckPrima(p1, "Sostituzione di macchine a regolazione on/off con altri di pari potenza a piu' gradini o a regolazione continua", GenericUtil.getCheckSi(rappIspez.getS5aFlgSostituzMacchineReg()));
		 c1 = new PdfPCell(p1);
		 c1.setBorder(Rectangle.LEFT | Rectangle.TOP | Rectangle.RIGHT);
		 //c1.setColspan(2);
		 tabella.addCell(c1);

		 p1 = new Paragraph("", FONT_HELVETICA_8);
		 aggiungiCheckPrima(p1, "Sostituzione di sistema di regolazione on/off con sistemi programmabili a piu' livelli di temperatura", GenericUtil.getCheckSi(rappIspez.getS5aFlgSostituzSistemiReg()));
		 c1 = new PdfPCell(p1);
		 c1.setBorder(Rectangle.LEFT | Rectangle.RIGHT);
		 //c1.setColspan(2);
		 tabella.addCell(c1);

		 p1 = new Paragraph("", FONT_HELVETICA_8);
		 aggiungiCheckPrima(p1, "Isolamento della rete di distribuzione acqua calda/refrigerata nei locali non climatizzati", GenericUtil.getCheckSi(rappIspez.getS5aFlgIsolamReteDistrib()));
		 c1 = new PdfPCell(p1);
		 c1.setBorder(Rectangle.LEFT | Rectangle.RIGHT);
		 //c1.setColspan(2);
		 tabella.addCell(c1);
		 
		 
		 p1 = new Paragraph("", FONT_HELVETICA_8);
		 aggiungiCheckPrima(p1, "Isolamento dei canali di distribuzione aria calda/fredda nei locali non climatizzati", GenericUtil.getCheckSi(rappIspez.getS5aFlgIsolamCanaliDistrib()));
		 c1 = new PdfPCell(p1);
		 c1.setBorder(Rectangle.LEFT | Rectangle.BOTTOM | Rectangle.RIGHT);
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

	private static void aggiungiGruppoFrigoGF(Document document, SigitTDettIspezGfDto sigitTDettIspezGfDto, SigitVSk4GfDto sigitRAllegatoCompGfDto) throws DocumentException {
	
		 //Suddivido il foglio in sezioni, cioè in questo caso, un foglio 100% viene diviso in due sezioni, su 8 la prima è larga 2 e l’altra larga 6. Le sezioni possono essere anche di più spartizioni, basta solo aggiungere un valore dopo la virgola es. {3,3,3} suddividiamo in tre sezioni uguali tra di loro.
		 float[] columnWidths = {23,9,25,23,15,5}; 
		 
		 // 7 colonne
		 
		 PdfPTable tabella = new PdfPTable(columnWidths);
		 //Definisco la tabella con il 100%, il bordo,e il margine sinis
		 tabella.setSpacingBefore(5);      
	
		 tabella.setWidthPercentage(100); 
		 tabella.getDefaultCell().setBorder(1);
		 tabella.getDefaultCell().setPaddingLeft(PADDING_LEFT);
		 
		 PdfPCell c1;
		 c1 = new PdfPCell(new Paragraph("6. GRUPPO FRIGO/PDC", FONT_HELVETICA_9_B_I));
		 c1.setHorizontalAlignment(Element.ALIGN_CENTER); 
		 c1.setBackgroundColor(Color.LIGHT_GRAY);
	     c1.setColspan(7);
		 tabella.addCell(c1);
	
		 tabella.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
	
		 
		 c1 = new PdfPCell(new Paragraph("a) Gruppo frigo / PDC", FONT_HELVETICA_8));
		 tabella.addCell(c1);
		 
		 Paragraph p1 = new Paragraph("", FONT_HELVETICA_8);
	
		 p1 = new Paragraph("", FONT_HELVETICA_8);
		 //p1.add("N° ");
		 p1.add(GenericUtil.getDescSezioneComp(sigitRAllegatoCompGfDto.getIdTipoComponente(), ConvertUtil.convertToBigInteger(sigitRAllegatoCompGfDto.getProgressivo())));
		 c1 = new PdfPCell(p1);
	     //c1.setColspan(2);
		 tabella.addCell(c1);
		 
		 // Lascio questa cella per non dover riscrivere la tabella 
		 p1 = new Paragraph("", FONT_HELVETICA_8);
		 p1.add(" "); // Di
		 p1.add(" ");
		 c1 = new PdfPCell(p1);
	     //c1.setColspan(2);
		 tabella.addCell(c1);
		 
		 p1 = new Paragraph("", FONT_HELVETICA_8);
		 c1 = new PdfPCell(p1);
	     c1.setColspan(3);
		 tabella.addCell(c1);
		 
		 c1 = new PdfPCell(new Paragraph("c) Data installazione", FONT_HELVETICA_8));
		 tabella.addCell(c1);
		 
		 p1 = new Paragraph(ConvertUtil.getStringValid(sigitRAllegatoCompGfDto.getDataInstall()), FONT_HELVETICA_8);
		 /*
		 p1 = new Paragraph("", FONT_HELVETICA_8);
	
		 aggiungiCheckPrima(p1, "Gas natur.", true, 12);
		 aggiungiCheckPrima(p1, "GPL", false, 12);
		 aggiungiCheckPrima(p1, "Gasolio", true, 12);
		 aggiungiCheckPrima(p1, "Altro: "+VAR, false);
		 */
		 c1 = new PdfPCell(p1);
	     c1.setColspan(2);
		 tabella.addCell(c1);
		 
		 p1 = new Paragraph("k) Dati nominali in riscaldamento:", FONT_HELVETICA_8_I);
		 c1 = new PdfPCell(p1);
	     c1.setColspan(3);
		 tabella.addCell(c1);
	
		 c1 = new PdfPCell(new Paragraph("d) Costruttore", FONT_HELVETICA_8));
		 tabella.addCell(c1);
		 
		 c1 = new PdfPCell(new Paragraph(GenericUtil.getStringValid(sigitRAllegatoCompGfDto.getDesMarca()), FONT_HELVETICA_8));
	     c1.setColspan(2);
		 tabella.addCell(c1);
	
		 Phrase p2 = new Phrase("COP (o ", FONT_HELVETICA_8);
		 
		 p2.add(SYMBOL_ETA);
		 
		 Chunk  p3 = new Chunk (")", FONT_HELVETICA_8);
		 p2.add(p3);
		 c1 = new PdfPCell(p2);
		 c1.setBorder(Rectangle.TOP | Rectangle.LEFT);
		 tabella.addCell(c1);

		 /*
		 c1 = new PdfPCell(new Paragraph("COP (o XXX):", FONT_HELVETICA_8));
		 c1.setBorder(Rectangle.TOP | Rectangle.LEFT);
		 tabella.addCell(c1);
		 */
	
		 c1 = new PdfPCell(new Paragraph(GenericUtil.getStringValid(sigitRAllegatoCompGfDto.getRiscaldamentoCop()), FONT_HELVETICA_8));
		 c1.setBorder(Rectangle.TOP);
		 tabella.addCell(c1);
		 
		 c1 = new PdfPCell(); // Cella vuota
		 c1.setBorder(Rectangle.TOP | Rectangle.RIGHT);
		 tabella.addCell(c1);
		 
		 
		 c1 = new PdfPCell(new Paragraph("e) Modello", FONT_HELVETICA_8));
		 tabella.addCell(c1);
		 
		 p1 = new Paragraph(GenericUtil.getStringValid(sigitRAllegatoCompGfDto.getModello()), FONT_HELVETICA_8);
		 c1 = new PdfPCell(p1);
	     c1.setColspan(2);
		 tabella.addCell(c1);
		 
		 c1 = new PdfPCell(new Paragraph("Potenza termica nominale:", FONT_HELVETICA_8));
		 c1.setBorder(Rectangle.LEFT);
		 tabella.addCell(c1);
		 
		 c1 = new PdfPCell(new Paragraph(GenericUtil.getStringValid(sigitRAllegatoCompGfDto.getRiscPotenzaKw()), FONT_HELVETICA_8));
		 c1.setBorder(Rectangle.NO_BORDER);
		 tabella.addCell(c1);
		 
		 c1 = new PdfPCell(new Paragraph("(kW)", FONT_HELVETICA_8));
		 c1.setBorder(Rectangle.RIGHT);
		 tabella.addCell(c1);
		 
		 
		 c1 = new PdfPCell(new Paragraph("f) Matricola", FONT_HELVETICA_8));
		 tabella.addCell(c1);

		 p1 = new Paragraph(GenericUtil.getStringValid(sigitRAllegatoCompGfDto.getMatricola()), FONT_HELVETICA_8);
		 c1 = new PdfPCell(p1);
	     c1.setColspan(2);
		 tabella.addCell(c1);

		 c1 = new PdfPCell(new Paragraph("Potenza assorbita nominale:", FONT_HELVETICA_8));
		 c1.setBorder(Rectangle.LEFT | Rectangle.BOTTOM);
		 tabella.addCell(c1);
		 
		 c1 = new PdfPCell(new Paragraph(GenericUtil.getStringValid(sigitRAllegatoCompGfDto.getRiscPotenzaAssKw()), FONT_HELVETICA_8));
		 c1.setBorder(Rectangle.BOTTOM);
		 tabella.addCell(c1);
		 
		 c1 = new PdfPCell(new Paragraph("(kW)", FONT_HELVETICA_8));
		 c1.setBorder(Rectangle.RIGHT | Rectangle.BOTTOM);
		 tabella.addCell(c1);


		 c1 = new PdfPCell(new Paragraph("g) Fluido frigorigeno", FONT_HELVETICA_8));
		 tabella.addCell(c1);

		 p1 = new Paragraph(GenericUtil.getStringValid(sigitRAllegatoCompGfDto.getFluidoFrigorigeno()), FONT_HELVETICA_8);
		 c1 = new PdfPCell(p1);
	     c1.setColspan(2);
		 tabella.addCell(c1);
		 
		 p1 = new Paragraph("l) Dati nominali in raffrescamento:", FONT_HELVETICA_8_I);
		 c1 = new PdfPCell(p1);
	     c1.setColspan(3);
		 tabella.addCell(c1);
		 
		 c1 = new PdfPCell(new Paragraph("g) Macchian dotata di inverter", FONT_HELVETICA_8));
		 tabella.addCell(c1);
		 
		 p1 = new Paragraph("", FONT_HELVETICA_8);

		 aggiungiSpaziVuoti(p1, 5);
		 aggiungiCheckPrima(p1, "Si", GenericUtil.getCheckSi(sigitTDettIspezGfDto.getS6hFlgInverter()), 13);
		 aggiungiCheckPrima(p1, "No", GenericUtil.getCheckNo(sigitTDettIspezGfDto.getS6hFlgInverter()));
		 c1 = new PdfPCell(p1);
	     c1.setColspan(2);
		 tabella.addCell(c1);

		 c1 = new PdfPCell(new Paragraph("EER (o GUE):", FONT_HELVETICA_8));
		 c1.setBorder(Rectangle.TOP | Rectangle.LEFT);
		 tabella.addCell(c1);
		 
		 c1 = new PdfPCell(new Paragraph(GenericUtil.getStringValid(sigitRAllegatoCompGfDto.getRaffrescamentoEer()), FONT_HELVETICA_8));
		 c1.setBorder(Rectangle.TOP);
		 tabella.addCell(c1);
		 
		 c1 = new PdfPCell(new Paragraph("(kW)", FONT_HELVETICA_8));
		 c1.setBorder(Rectangle.TOP | Rectangle.RIGHT);
		 tabella.addCell(c1);

		 
		 c1 = new PdfPCell(new Paragraph("i) Sorgente lato esterno", FONT_HELVETICA_8));
		 tabella.addCell(c1);
		 
		 p1 = new Paragraph("", FONT_HELVETICA_8);
		 aggiungiSpaziVuoti(p1, 5);
		 aggiungiCheckPrima(p1, "Aria", GenericUtil.getCheck(sigitRAllegatoCompGfDto.getFlgSorgenteExt(), Constants.FLG_ARIA), 12);
		 aggiungiCheckPrima(p1, "Acqua", GenericUtil.getCheck(sigitRAllegatoCompGfDto.getFlgSorgenteExt(), Constants.FLG_ACQUA), 12);
		 aggiungiCheckPrima(p1, "Altro", GenericUtil.getCheck(sigitRAllegatoCompGfDto.getFlgSorgenteExt(), Constants.DESC_ALTRO));
		 c1 = new PdfPCell(p1);
	     c1.setColspan(2);
		 tabella.addCell(c1);

		 c1 = new PdfPCell(new Paragraph("Potenza frigorifera nominale:", FONT_HELVETICA_8));
		 c1.setBorder(Rectangle.LEFT);
		 tabella.addCell(c1);
		 
		 c1 = new PdfPCell(new Paragraph(GenericUtil.getStringValid(sigitRAllegatoCompGfDto.getRaffPotenzaKw()), FONT_HELVETICA_8));
		 c1.setBorder(Rectangle.NO_BORDER);
		 tabella.addCell(c1);
		 
		 c1 = new PdfPCell(new Paragraph("(kW)", FONT_HELVETICA_8));
		 c1.setBorder(Rectangle.RIGHT);
		 tabella.addCell(c1);
		 
		 c1 = new PdfPCell(new Paragraph("j) Fluido lato utenze", FONT_HELVETICA_8));
		 tabella.addCell(c1);
		 
		 p1 = new Paragraph("", FONT_HELVETICA_8);
		 aggiungiSpaziVuoti(p1, 5);
		 aggiungiCheckPrima(p1, "Aria", GenericUtil.getCheck(sigitRAllegatoCompGfDto.getFlgFluidoUtenze(), Constants.FLG_ARIA), 12);
		 aggiungiCheckPrima(p1, "Acqua", GenericUtil.getCheck(sigitRAllegatoCompGfDto.getFlgFluidoUtenze(), Constants.FLG_ACQUA));
		 c1 = new PdfPCell(p1);
	     c1.setColspan(2);
		 tabella.addCell(c1);

		 c1 = new PdfPCell(new Paragraph("Potenza assorbita nominale:", FONT_HELVETICA_8));
		 c1.setBorder(Rectangle.LEFT | Rectangle.BOTTOM);
		 tabella.addCell(c1);
		 
		 c1 = new PdfPCell(new Paragraph(GenericUtil.getStringValid(sigitRAllegatoCompGfDto.getRaffPotenzaAss()), FONT_HELVETICA_8));
		 c1.setBorder(Rectangle.BOTTOM);
		 tabella.addCell(c1);
		 
		 c1 = new PdfPCell(new Paragraph("(kW)", FONT_HELVETICA_8));
		 c1.setBorder(Rectangle.RIGHT | Rectangle.BOTTOM);
		 tabella.addCell(c1);
		 
		 c1 = new PdfPCell(new Paragraph("m) Tipo di macchina", FONT_HELVETICA_8));
		 c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
	     c1.setRowspan(2);
		 tabella.addCell(c1);
		 
		 p1 = new Paragraph("", FONT_HELVETICA_8);
		 aggiungiCheckPrima(p1, "Ad assorbimento per recupero calore", GenericUtil.getCheck(ConvertUtil.convertToString(sigitRAllegatoCompGfDto.getFkDettaglioGf()), Constants.ID_DETT_GF_ASS_REC_CALORE), 40);
		 aggiungiCheckPrima(p1, "A ciclo di compressione con motore elettrico o endotermico", GenericUtil.getCheck(ConvertUtil.convertToString(sigitRAllegatoCompGfDto.getFkDettaglioGf()), Constants.ID_DETT_GF_CICLO_COMPRESS));
		 c1 = new PdfPCell(p1);
	     c1.setColspan(5);
		 tabella.addCell(c1);

		 p1 = new Paragraph("", FONT_HELVETICA_8);
		 aggiungiCheckPrima(p1, "Ad assorbimento a fiamma diretta con alimentazione a combustibile: ", GenericUtil.getCheck(ConvertUtil.convertToString(sigitRAllegatoCompGfDto.getFkDettaglioGf()), Constants.ID_DETT_GF_ASS_FIAMM_COMB));
		 p1.add(GenericUtil.getStringValid(sigitRAllegatoCompGfDto.getDesDettaglioGf()));
		 c1 = new PdfPCell(p1);
	     c1.setColspan(5);
		 tabella.addCell(c1);
		 
		 document.add(tabella); //AGGIUNGO LA TABELLA NEL DOCUMENTO

		 // Non funzioan il rowspan insieme al colspan, quindi faccio una nuova tabella
		 float[] columnWidthsNew = {50,25,25}; 
		 
		 tabella = new PdfPTable(columnWidthsNew);
		 //Definisco la tabella con il 100%, il bordo,e il margine sinis
		 //tabella.setSpacingBefore(5);      
	
		 tabella.setWidthPercentage(100); 
		 tabella.getDefaultCell().setBorder(1);
		 tabella.getDefaultCell().setPaddingLeft(PADDING_LEFT);
		 
		 c1 = new PdfPCell(new Paragraph("n) Presenza apparecchiatura automatica rilevazione fughe refrigerante", FONT_HELVETICA_8));
		 c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
	     c1.setRowspan(2);
	     //c1.setColspan(2);
		 tabella.addCell(c1);

		 p1 = new Paragraph("Diretta (leak detector)", FONT_HELVETICA_8);
		 c1 = new PdfPCell(p1);
		 c1.setBorder(Rectangle.TOP | Rectangle.LEFT | Rectangle.BOTTOM);
		 tabella.addCell(c1);
		 
		 p1 = new Paragraph("", FONT_HELVETICA_8);
		 aggiungiSpaziVuoti(p1, 5);
		 aggiungiCheckPrima(p1, "Si", GenericUtil.getCheckSi(sigitTDettIspezGfDto.getS6nFlgFugaDiretta()), 12);
		 aggiungiCheckPrima(p1, "No", GenericUtil.getCheckNo(sigitTDettIspezGfDto.getS6nFlgFugaDiretta()), 12);
		 aggiungiCheckPrima(p1, "Nc", GenericUtil.getCheckNc(sigitTDettIspezGfDto.getS6nFlgFugaDiretta()));
		 c1 = new PdfPCell(p1);
		 c1.setBorder(Rectangle.TOP | Rectangle.BOTTOM | Rectangle.RIGHT);
		 tabella.addCell(c1);

		 p1 = new Paragraph("Indiretta (parametri termodinamici)", FONT_HELVETICA_8);
		 c1 = new PdfPCell(p1);
		 c1.setBorder(Rectangle.TOP | Rectangle.LEFT | Rectangle.BOTTOM);
		 tabella.addCell(c1);
		 
		 p1 = new Paragraph("", FONT_HELVETICA_8);
		 aggiungiSpaziVuoti(p1, 5);
		 aggiungiCheckPrima(p1, "Si", GenericUtil.getCheckSi(sigitTDettIspezGfDto.getS6nFlgFugaIndiretta()), 12);
		 aggiungiCheckPrima(p1, "No", GenericUtil.getCheckNo(sigitTDettIspezGfDto.getS6nFlgFugaIndiretta()), 12);
		 aggiungiCheckPrima(p1, "Nc", GenericUtil.getCheckNc(sigitTDettIspezGfDto.getS6nFlgFugaIndiretta()));
		 c1 = new PdfPCell(p1);
		 c1.setBorder(Rectangle.TOP | Rectangle.BOTTOM | Rectangle.RIGHT);
		 tabella.addCell(c1);
		 
		 
		 document.add(tabella); //AGGIUNGO LA TABELLA NEL DOCUMENTO
	
		 
	 }

	private static void aggiungiManutenzioneAnalisiGF(Document document, SigitTDettIspezGfDto sigitTDettIspezGfDto) throws DocumentException {
	
		 //Suddivido il foglio in sezioni, cioè in questo caso, un foglio 100% viene diviso in due sezioni, su 8 la prima è larga 2 e l’altra larga 6. Le sezioni possono essere anche di più spartizioni, basta solo aggiungere un valore dopo la virgola es. {3,3,3} suddividiamo in tre sezioni uguali tra di loro.
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
		 aggiungiCheckPrima(p1, "Semestrale", GenericUtil.getCheck(sigitTDettIspezGfDto.getS7aFkFrequenzaManut(),Constants.ID_FREQ_SEMESTRALE), 12);
		 aggiungiCheckPrima(p1, "Annuale", GenericUtil.getCheck(sigitTDettIspezGfDto.getS7aFkFrequenzaManut(),Constants.ID_FREQ_ANNUALE), 12);
		 aggiungiCheckPrima(p1, "Biennale", GenericUtil.getCheck(sigitTDettIspezGfDto.getS7aFkFrequenzaManut(),Constants.ID_FREQ_BIENNALE), 12);
		 aggiungiCheckPrima(p1, "Altra: "+GenericUtil.getStringValid(sigitTDettIspezGfDto.getS7aFrequenzaManutAltro()), GenericUtil.getCheck(sigitTDettIspezGfDto.getS7aFkFrequenzaManut(),Constants.ID_FREQ_ALTRO), 12);
		 c1 = new PdfPCell(p1);
		 tabella.addCell(c1);
		 
		 
		 p1 = new Paragraph("Ultima manutenzione prevista effettuata", FONT_HELVETICA_8);
		 aggiungiSpaziVuoti(p1, 5);
		 aggiungiCheckPrima(p1, "Si", GenericUtil.getCheckSi(sigitTDettIspezGfDto.getS7aFlgManutEffettuata()), 12);
		 aggiungiCheckPrima(p1, "No", GenericUtil.getCheckNo(sigitTDettIspezGfDto.getS7aFlgManutEffettuata()), 12);
		 
		 p1.add("In data:");
		 p1.add(GenericUtil.getStringValid(sigitTDettIspezGfDto.getS7aDataUltimaManut()));
		 c1 = new PdfPCell(p1);
		 tabella.addCell(c1);
		 

		 c1 = new PdfPCell(new Paragraph("b) Registro dell'apparecchiatura", FONT_HELVETICA_8));
		 tabella.addCell(c1);

		 p1 = new Paragraph("", FONT_HELVETICA_8);
		 aggiungiCheckPrima(p1, "Regolarmente compilato", GenericUtil.getCheckSi(sigitTDettIspezGfDto.getS7bFlgRegistroApparecc()), 30);
		 aggiungiCheckPrima(p1, "Assente o non regolarmente compilato", GenericUtil.getCheckNo(sigitTDettIspezGfDto.getS7bFlgRegistroApparecc()), 45);
		 aggiungiCheckPrima(p1, "Non applicabile", GenericUtil.getCheckNc(sigitTDettIspezGfDto.getS7bFlgRegistroApparecc()));
		 c1 = new PdfPCell(p1);
		 tabella.addCell(c1);


		 c1 = new PdfPCell(new Paragraph("c) Rapporto controllo efficienza", FONT_HELVETICA_8));
		 tabella.addCell(c1);
		 
		 p1 = new Paragraph("Presente", FONT_HELVETICA_8);
		 aggiungiSpaziVuoti(p1, 5);
		 aggiungiCheckPrima(p1, "Si", GenericUtil.getCheckSi(sigitTDettIspezGfDto.getS7cFlgReePresente()), 7);
		 aggiungiCheckPrima(p1, "No", GenericUtil.getCheckNo(sigitTDettIspezGfDto.getS7cFlgReePresente()), 7);
		 p1.add("In data:");
		 p1.add(GenericUtil.getStringValid(sigitTDettIspezGfDto.getS7cDataRee()));
		 aggiungiSpaziVuoti(p1, 5);
		 aggiungiCheckDopo(p1, "Osservazioni", GenericUtil.getCheckSi(sigitTDettIspezGfDto.getS7cFlgOsservazioni()), 20);
		 aggiungiCheckDopo(p1, "Raccomandazioni", GenericUtil.getCheckSi(sigitTDettIspezGfDto.getS7cFlgRaccomand()), 20);
		 aggiungiCheckDopo(p1, "Prescrizioni", GenericUtil.getCheckSi(sigitTDettIspezGfDto.getS7cFlgPrescr()));
		 c1 = new PdfPCell(p1);
		 tabella.addCell(c1);
	
		 document.add(tabella); //AGGIUNGO LA TABELLA NEL DOCUMENTO
	
		 
	 }

	private static void aggiungiControlloEVerificaEnergeticaGF(Document document, SigitTDettIspezGfDto sigitTDettIspezGfDto, Integer nCircuiti) throws DocumentException {

		
		log.debug("@@@@ STAMPO il nCircuiti: "+nCircuiti);
		
		 //Suddivido il foglio in sezioni, cioè in questo caso, un foglio 100% viene diviso in due sezioni, su 8 la prima è larga 2 e l’altra larga 6. Le sezioni possono essere anche di più spartizioni, basta solo aggiungere un valore dopo la virgola es. {3,3,3} suddividiamo in tre sezioni uguali tra di loro.
		 float[] columnWidths = {17,3,7,20,25,25,13}; 
		 
		 String valore = null;
		 // 2 colonne
		 
		 PdfPTable tabella = new PdfPTable(columnWidths);
		 //Definisco la tabella con il 100%, il bordo,e il margine sinis
		 tabella.setSpacingBefore(5);      

		 tabella.setWidthPercentage(100); 
		 tabella.getDefaultCell().setBorder(1);
		 tabella.getDefaultCell().setPaddingLeft(PADDING_LEFT);
		 
		 PdfPCell c1;
		 c1 = new PdfPCell(new Paragraph("8. CONTROLLO E VERIFICA ENERGETICA", FONT_HELVETICA_9_B_I));
		 c1.setHorizontalAlignment(Element.ALIGN_CENTER); 
		 c1.setBackgroundColor(Color.LIGHT_GRAY);
	     c1.setColspan(9);
		 tabella.addCell(c1);

		 tabella.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);

		 tabella.addCell("1");
		 tabella.addCell("2");
		 tabella.addCell("3");
		 tabella.addCell("4");
		 tabella.addCell("5");
		 tabella.addCell("6");
		 tabella.addCell("7");

		 
		 c1 = new PdfPCell(new Paragraph("a) Numero circuito", FONT_HELVETICA_8));
		 tabella.addCell(c1);


		 Paragraph p1 = new Paragraph("N° ", FONT_HELVETICA_8);
		 p1.add(GenericUtil.getStringValid(sigitTDettIspezGfDto.getS8aNCircuito()));
		 c1 = new PdfPCell(p1);
	     c1.setColspan(2);
		 tabella.addCell(c1);

		 
		 p1 = new Paragraph("di ", FONT_HELVETICA_8);
		 p1.add(ConvertUtil.convertToString(nCircuiti));
		 c1 = new PdfPCell(p1);
		 tabella.addCell(c1);

		 c1 = new PdfPCell(new Paragraph("b) Prova eseguita in modalita'", FONT_HELVETICA_8));
	     //c1.setColspan(2);
		 tabella.addCell(c1);

		 p1 = new Paragraph("", FONT_HELVETICA_8);
		 aggiungiSpaziVuoti(p1, 5);
		 aggiungiCheckPrima(p1, "Raffrescamento", GenericUtil.getCheckSi(sigitTDettIspezGfDto.getS8bFlgProveRaffrescamento()), 17);
		 aggiungiCheckPrima(p1, "Riscaldamento", GenericUtil.getCheckSi(sigitTDettIspezGfDto.getS8bFlgProveRiscaldamento()));
		 c1 = new PdfPCell(p1);
		 c1.setColspan(2);
		 tabella.addCell(c1);
		 
		 c1 = new PdfPCell(new Paragraph("c) Filtri puliti", FONT_HELVETICA_8));
	     //c1.setColspan(2);
		 tabella.addCell(c1);

		 p1 = new Paragraph("", FONT_HELVETICA_8);
		 aggiungiSpaziVuoti(p1, 5);
		 aggiungiCheckPrima(p1, "Si", GenericUtil.getCheckSi(sigitTDettIspezGfDto.getS8cFlgFiltriPuliti()), 12);
		 aggiungiCheckPrima(p1, "No", GenericUtil.getCheckNo(sigitTDettIspezGfDto.getS8cFlgFiltriPuliti()));
		 c1 = new PdfPCell(p1);
		 c1.setColspan(3);
		 tabella.addCell(c1);
		 
		 c1 = new PdfPCell(new Paragraph("d) Assenza perdite gas refrigerante", FONT_HELVETICA_8));
	     //c1.setColspan(2);
		 tabella.addCell(c1);

		 p1 = new Paragraph("", FONT_HELVETICA_8);
		 aggiungiSpaziVuoti(p1, 5);
		 aggiungiCheckPrima(p1, "Si", GenericUtil.getCheckSi(sigitTDettIspezGfDto.getS8dFlgAssenzaPerditeGas()), 12);
		 aggiungiCheckPrima(p1, "No", GenericUtil.getCheckNo(sigitTDettIspezGfDto.getS8dFlgAssenzaPerditeGas()), 12);
		 aggiungiCheckPrima(p1, "Nc", GenericUtil.getCheckNc(sigitTDettIspezGfDto.getS8dFlgAssenzaPerditeGas()));
		 c1 = new PdfPCell(p1);
		 c1.setColspan(2);
		 tabella.addCell(c1);

		 c1 = new PdfPCell(new Paragraph("e) Strumento utilizzato", FONT_HELVETICA_8));
	     //c1.setColspan(2);
		 tabella.addCell(c1);
		 
		 
		 Phrase p2 = new Phrase("Marca: ", FONT_HELVETICA_8);
		 p2.add(new Chunk (GenericUtil.getStringValid(sigitTDettIspezGfDto.getS8eMarcaStrumMisura()), FONT_HELVETICA_8));
		 p2.add(new Chunk ("Modello/Matricola: ", FONT_HELVETICA_8));
		 p2.add(new Chunk (GenericUtil.getStringValid(sigitTDettIspezGfDto.getS8eModelloStrumMisura()), FONT_HELVETICA_8));
		 p2.add(new Chunk ("/ ", FONT_HELVETICA_8));
		 p2.add(new Chunk (GenericUtil.getStringValid(sigitTDettIspezGfDto.getS8eMatricolaStrumMisura()), FONT_HELVETICA_8));
		 c1 = new PdfPCell(p2);
		 //c1.setVerticalAlignment(Element.ALIGN_MIDDLE); 
	     c1.setColspan(4);
		 tabella.addCell(c1);

		 c1 = new PdfPCell(new Paragraph("f) Potenza assorbita", FONT_HELVETICA_8));
	     //c1.setColspan(2);
		 tabella.addCell(c1);
		 
		 Paragraph p3 = new Paragraph("", FONT_HELVETICA_8);
		 p3.add(ConvertUtil.getStringValid(sigitTDettIspezGfDto.getS8fPotAssorbitaKw()));
		 p3.add(" (kW) ");
		 c1 = new PdfPCell(p3);
		 //c1.setColspan(2);
		 //c3.setVerticalAlignment(Element.ALIGN_MIDDLE);
	     //c3.setColspan(2);
		 tabella.addCell(c1);
	     
		 document.add(tabella); //AGGIUNGO LA TABELLA NEL DOCUMENTO

		 
		 float[] columnWidths2 = {17,10,23,19,12,23}; 
		 
		 // 2 colonne
		 
		 tabella = new PdfPTable(columnWidths2);
		 //Definisco la tabella con il 100%, il bordo,e il margine sinis

		 tabella.setWidthPercentage(100); 
		 tabella.getDefaultCell().setBorder(1);
		 tabella.getDefaultCell().setPaddingLeft(PADDING_LEFT);
		 
		 c1 = new PdfPCell(new Paragraph("g) Strumentazione fissa per la misura delle temperature manometriche di condensazione ed evaporazione:", FONT_HELVETICA_8));
		 //c1.setHorizontalAlignment(Element.ALIGN_CENTER); 
	     c1.setColspan(5);
		 tabella.addCell(c1);

		 p1 = new Paragraph("", FONT_HELVETICA_8);
		 aggiungiSpaziVuoti(p1, 5);
		 aggiungiCheckPrima(p1, "Si", GenericUtil.getCheckSi(sigitTDettIspezGfDto.getS8gFlgStrumentazioneFissa()), 12);
		 aggiungiCheckPrima(p1, "No", GenericUtil.getCheckNo(sigitTDettIspezGfDto.getS8gFlgStrumentazioneFissa()));
		 c1 = new PdfPCell(p1);
		 //c1.setColspan(3);
		 tabella.addCell(c1);
		 
		 
		 c1 = new PdfPCell(new Paragraph("Dati dell'operatore patentato ai sensi el D.P.R. 43/2012", FONT_HELVETICA_8_B));
		 c1.setHorizontalAlignment(Element.ALIGN_CENTER); 
	     c1.setColspan(6);
		 tabella.addCell(c1);

		 
		 
		 c1 = new PdfPCell(new Paragraph("h) Cognome e nome: ", FONT_HELVETICA_8));
		 //c1.setHorizontalAlignment(Element.ALIGN_CENTER); 
	     //c1.setColspan(2);
		 tabella.addCell(c1);
		 
		 c1 = new PdfPCell(new Paragraph(GenericUtil.getStringValid(sigitTDettIspezGfDto.getS8hOperatoreDenominazione()), FONT_HELVETICA_8));
		 c1.setColspan(2);
		 tabella.addCell(c1);
		 

		 c1 = new PdfPCell(new Paragraph("Num. Iscr. Reg. impresa: ", FONT_HELVETICA_8));
		 tabella.addCell(c1);
		 
		 c1 = new PdfPCell(new Paragraph(GenericUtil.getStringValid(sigitTDettIspezGfDto.getS8iOperatoreNumIscriz()), FONT_HELVETICA_8));
		 c1.setColspan(2);
		 tabella.addCell(c1);
		 
		 c1 = new PdfPCell(new Paragraph("j) Valori rilevati", FONT_HELVETICA_8));
		 c1.setHorizontalAlignment(Element.ALIGN_CENTER); 
	     c1.setColspan(6);
		 tabella.addCell(c1);
		 
		 
		 c1 = new PdfPCell(new Paragraph("Surriscaldamento (K)", FONT_HELVETICA_8));
		 c1.setColspan(2);
		 tabella.addCell(c1);
		 
		 c1 = new PdfPCell(new Paragraph(GenericUtil.getStringValid(sigitTDettIspezGfDto.getS8jSurriscaldamentoK()), FONT_HELVETICA_8));
		 tabella.addCell(c1);
		 
		 c1 = new PdfPCell(new Paragraph("Temp. sorgente ingresso lato esterno (°C)", FONT_HELVETICA_8));
		 c1.setColspan(2);
		 tabella.addCell(c1);

		 c1 = new PdfPCell(new Paragraph(GenericUtil.getStringValid(sigitTDettIspezGfDto.getS8jTempSorgIngressoC()), FONT_HELVETICA_8));
		 tabella.addCell(c1);

		 
		 ///
		 
		 
		 c1 = new PdfPCell(new Paragraph("Sottoraffreddamento (K)", FONT_HELVETICA_8));
		 c1.setColspan(2);
		 tabella.addCell(c1);
		 
		 c1 = new PdfPCell(new Paragraph(GenericUtil.getStringValid(sigitTDettIspezGfDto.getS8jSottoraffreddamentoK()), FONT_HELVETICA_8));
		 tabella.addCell(c1);
		 
		 c1 = new PdfPCell(new Paragraph("Temp. sorgente uscita lato esterno (°C)", FONT_HELVETICA_8));
		 c1.setColspan(2);
		 tabella.addCell(c1);

		 c1 = new PdfPCell(new Paragraph(GenericUtil.getStringValid(sigitTDettIspezGfDto.getS8jTempSorgUscitaC()), FONT_HELVETICA_8));
		 tabella.addCell(c1);
		 
		 
		 
		 ///
		 
		 c1 = new PdfPCell(new Paragraph("Temp. di condensazione (°C)", FONT_HELVETICA_8));
		 c1.setColspan(2);
		 tabella.addCell(c1);
		 
		 c1 = new PdfPCell(new Paragraph(GenericUtil.getStringValid(sigitTDettIspezGfDto.getS8jTempCondensazioneC()), FONT_HELVETICA_8));
		 tabella.addCell(c1);
		 
		 c1 = new PdfPCell(new Paragraph("Temp. ingresso fluido utenze (°C)", FONT_HELVETICA_8));
		 c1.setColspan(2);
		 tabella.addCell(c1);

		 c1 = new PdfPCell(new Paragraph(GenericUtil.getStringValid(sigitTDettIspezGfDto.getS8jTempIngressoFluidoC()), FONT_HELVETICA_8));
		 tabella.addCell(c1);
		 


		 
		 
		 c1 = new PdfPCell(new Paragraph("Temp. di evaporazione (°C)", FONT_HELVETICA_8));
		 c1.setColspan(2);
		 tabella.addCell(c1);
		 
		 c1 = new PdfPCell(new Paragraph(GenericUtil.getStringValid(sigitTDettIspezGfDto.getS8jTempEvaporazioneC()), FONT_HELVETICA_8));
		 tabella.addCell(c1);
		 
		 c1 = new PdfPCell(new Paragraph("Temp. uscita fluido utenze (°C)", FONT_HELVETICA_8));
		 c1.setColspan(2);
		 tabella.addCell(c1);

		 c1 = new PdfPCell(new Paragraph(GenericUtil.getStringValid(sigitTDettIspezGfDto.getS8jTempUscitaFluidoC()), FONT_HELVETICA_8));
		 tabella.addCell(c1);
		 
		 
		 document.add(tabella); //AGGIUNGO LA TABELLA NEL DOCUMENTO

		 
	 }

	 private static void aggiungiEsitoProvaGF(Document document, SigitTDettIspezGfDto sigitTDettIspezGfDto) throws DocumentException {

		 //Suddivido il foglio in sezioni, cioè in questo caso, un foglio 100% viene diviso in due sezioni, su 8 la prima è larga 2 e l’altra larga 6. Le sezioni possono essere anche di più spartizioni, basta solo aggiungere un valore dopo la virgola es. {3,3,3} suddividiamo in tre sezioni uguali tra di loro.
		 float[] columnWidths = {40,60}; 
		 
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
		 p2.add(new Chunk ("Verifica superata", FONT_HELVETICA_8_B_I));

		 c1 = new PdfPCell(p2);
		 tabella.addCell(c1);

		 Paragraph p1 = new Paragraph("", FONT_HELVETICA_8);
		 aggiungiSpaziVuoti(p1, 15);
		 aggiungiCheckPrima(p1, "Si", GenericUtil.getCheckSi(sigitTDettIspezGfDto.getS9aFlgVerificaSuperata()), 30);
		 aggiungiCheckPrima(p1, "No", GenericUtil.getCheckNo(sigitTDettIspezGfDto.getS9aFlgVerificaSuperata()));
		 c1 = new PdfPCell(p1);
		 //c1.setColspan(3);
		 tabella.addCell(c1);
		 
		 

		 p1 = new Paragraph("b) ", FONT_HELVETICA_8);
		 p1.add(new Chunk ("L'impianto rispetta la normativa\n", FONT_HELVETICA_8_B_I));
		 p1.add(new Chunk ("(DPR 74/2013", FONT_HELVETICA_8_I));
		 aggiungiSpaziVuoti(p1, 40);
		 aggiungiCheckPrima(p1, "", GenericUtil.getCheckSi(sigitTDettIspezGfDto.getS9bFlgRispettoNormativa()));

		 c1 = new PdfPCell(p1);
		 tabella.addCell(c1);
		 

		 p1 = new Paragraph("c) ", FONT_HELVETICA_8);
		 p1.add(new Chunk ("L'impianto non rispetta la normativa", FONT_HELVETICA_8_B_I));
		 p1.add(new Chunk (" per quanto riguarda i punti:\n", FONT_HELVETICA_8_I));
		 aggiungiSpaziVuoti(p1, 20);
		 aggiungiCheckPrima(p1, "7.a", GenericUtil.getCheckSi(sigitTDettIspezGfDto.getS9cFlgNoRispetto7a()), 10);
		 aggiungiCheckPrima(p1, "7.b", GenericUtil.getCheckSi(sigitTDettIspezGfDto.getS9cFlgNoRispetto7b()), 10);
		 aggiungiCheckPrima(p1, "8.d", GenericUtil.getCheckSi(sigitTDettIspezGfDto.getS9cFlgNoRispetto8d()), 10);
		 aggiungiCheckPrima(p1, "9.a", GenericUtil.getCheckSi(sigitTDettIspezGfDto.getS9cFlgNoRispetto9a()));

		 c1 = new PdfPCell(p1);
		 c1.setColspan(2);
		 tabella.addCell(c1);


		 
		 /*
		 c1 = new PdfPCell(new Paragraph("a)", FONT_HELVETICA_8));
		 tabella.addCell(c1);


		 Paragraph p1 = new Paragraph("N° ", FONT_HELVETICA_8);
		 p1.add("XXXXX");
		 c1 = new PdfPCell(p1);
	     c1.setColspan(2);
		 tabella.addCell(c1);

		 
		 p1 = new Paragraph("di ", FONT_HELVETICA_8);
		 p1.add(VAR);
		 c1 = new PdfPCell(p1);
		 tabella.addCell(c1);

		 c1 = new PdfPCell(new Paragraph("b) Indice di fumosità (combustibili liquidi)", FONT_HELVETICA_8));
	     c1.setColspan(2);
		 tabella.addCell(c1);

		 p1 = new Paragraph("1° misura: ", FONT_HELVETICA_8);
		 p1.add(VAR);
		 c1 = new PdfPCell(p1);
		 tabella.addCell(c1);

		 p1 = new Paragraph("2° misura: ", FONT_HELVETICA_8);
		 p1.add(VAR);
		 c1 = new PdfPCell(p1);
		 tabella.addCell(c1);
		 
		 p1 = new Paragraph("3° misura: ", FONT_HELVETICA_8);
		 p1.add(VAR);
		 c1 = new PdfPCell(p1);
		 tabella.addCell(c1);
		 
		 c1 = new PdfPCell(new Paragraph("c) Strumento utilizzato", FONT_HELVETICA_8));
	     c1.setColspan(2);
		 tabella.addCell(c1);
		 
		 p1 = new Paragraph("Marca: ", FONT_HELVETICA_8);
		 p1.add(VAR);
		 c1 = new PdfPCell(p1);
	     c1.setColspan(3);
		 tabella.addCell(c1);
		 
		 
		 p1 = new Paragraph("Modello: ", FONT_HELVETICA_8);
		 p1.add(VAR);
		 c1 = new PdfPCell(p1);
	     c1.setColspan(2);
		 tabella.addCell(c1);
		 
		 p1 = new Paragraph("Matricola: ", FONT_HELVETICA_8);
		 p1.add(VAR);
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
		 
		 c1 = new PdfPCell(new Paragraph("Temperatura del fluido di mandata (°C)", FONT_HELVETICA_8));
		 tabella.addCell(c1);
		 
		 c1 = new PdfPCell(new Paragraph(VAR, FONT_HELVETICA_8));
		 tabella.addCell(c1);
		 

		 c1 = new PdfPCell(new Paragraph("Indice d'aria (n)", FONT_HELVETICA_8));
		 tabella.addCell(c1);
		 
		 c1 = new PdfPCell(new Paragraph(VAR, FONT_HELVETICA_8));
		 tabella.addCell(c1);

		 c1 = new PdfPCell(new Paragraph("Temperatura dell'aria comburente (°C)", FONT_HELVETICA_8));
		 tabella.addCell(c1);
		 
		 c1 = new PdfPCell(new Paragraph(VAR, FONT_HELVETICA_8));
		 tabella.addCell(c1);
		 

		 c1 = new PdfPCell(new Paragraph("CO nei fumi secchi e senz'aria (ppm)", FONT_HELVETICA_8));
		 tabella.addCell(c1);
		 
		 c1 = new PdfPCell(new Paragraph(VAR, FONT_HELVETICA_8));
		 tabella.addCell(c1);
		 
		 
		 c1 = new PdfPCell(new Paragraph("Temperatura dei fumi (°C)", FONT_HELVETICA_8));
		 tabella.addCell(c1);
		 
		 c1 = new PdfPCell(new Paragraph(VAR, FONT_HELVETICA_8));
		 tabella.addCell(c1);
		 

		 c1 = new PdfPCell(new Paragraph("Potenza termica persa al camino Qs(%)", FONT_HELVETICA_8));
		 tabella.addCell(c1);
		 
		 c1 = new PdfPCell(new Paragraph(VAR, FONT_HELVETICA_8));
		 tabella.addCell(c1);
		 
		 p1 = new Paragraph("", FONT_HELVETICA_8);
		 aggiungiCheckDopo(p1, "O2 (%)", true, 7);
		 p1.add("oppure ");
		 aggiungiCheckPrima(p1, "CO2 (%)", false);
		 c1 = new PdfPCell(p1);
		 tabella.addCell(c1);
		 
		 c1 = new PdfPCell(new Paragraph(VAR, FONT_HELVETICA_8));
		 tabella.addCell(c1);
		 
		 
		 c1 = new PdfPCell(new Paragraph("Recupero calore di condensazione ET (%)", FONT_HELVETICA_8));
		 tabella.addCell(c1);
		 
		 c1 = new PdfPCell(new Paragraph(VAR, FONT_HELVETICA_8));
		 tabella.addCell(c1);
		 
		 
		 c1 = new PdfPCell(new Paragraph("CO nei fumi secchi (ppm)", FONT_HELVETICA_8));
		 tabella.addCell(c1);
		 
		 c1 = new PdfPCell(new Paragraph(VAR, FONT_HELVETICA_8));
		 tabella.addCell(c1);
		 
		 
//		 c1 = new PdfPCell(new Paragraph("Rendimento di combustione (%)", FONT_HELVETICA_8));
//		 tabella.addCell(c1);

		
		 //Font f = FontFactory.getFont(FONT_FREESANS, "Cp1253", true);
		 //f.setSize(8);

		 Phrase p2 = new Phrase("Rendimento di combustione \u03B7", FONT_HELVETICA_8);//u33A5
		 Chunk  p3 = new Chunk ("comb", FONT_HELVETICA_8_B);
		 Chunk  p4 = new Chunk (" (%)", FONT_HELVETICA_8);

		 p2.add(p3);
		 p2.add(p4);


		 //Phrase phrase = new Phrase("Rendimento di combustione \u03B7", FONT_HELVETICA_8).add(new Chunk("Environment", null));
		 c1 = new PdfPCell(p2);
		 tabella.addCell(c1);
		 //tabella.addCell(getNormalCell("\u039d\u03cd\u03c6\u03b5\u03c2", "greek", 12));

		
	        
	        
	        
	        
	        
	        
	        
		 
	        
		 c1 = new PdfPCell(new Paragraph(VAR, FONT_HELVETICA_8));
		 tabella.addCell(c1);
		 
		 c1 = new PdfPCell(new Paragraph("NO al valore di ossigeno misurato (mg/kWh)", FONT_HELVETICA_8));
		 tabella.addCell(c1);
		 
		 c1 = new PdfPCell(new Paragraph(VAR, FONT_HELVETICA_8));
		 tabella.addCell(c1);
		 
		 
		 c1 = new PdfPCell(new Paragraph("NOx al 3% di ossigeno (mg/kWh)", FONT_HELVETICA_8));
		 tabella.addCell(c1);
		 
		 c1 = new PdfPCell(new Paragraph(VAR, FONT_HELVETICA_8));
		 tabella.addCell(c1);
		 */
		 
		 document.add(tabella); //AGGIUNGO LA TABELLA NEL DOCUMENTO

		 
	 }
	
	 private static void aggiungiOssPrescrDich(Document document, SigitTAllegatoDto allegato) throws DocumentException {

			 //Suddivido il foglio in sezioni, cioè in questo caso, un foglio 100% viene diviso in due sezioni, su 8 la prima è larga 2 e l’altra larga 6. Le sezioni possono essere anche di più spartizioni, basta solo aggiungere un valore dopo la virgola es. {3,3,3} suddividiamo in tre sezioni uguali tra di loro.
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

			 // 12. DICHIARAZIONI DEL RESPONSABILE DELL’IMPIANTO 
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
