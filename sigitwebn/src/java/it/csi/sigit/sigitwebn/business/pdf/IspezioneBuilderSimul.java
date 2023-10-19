/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitwebn.business.pdf;

import java.awt.Color;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTRappIspezGtDto;

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
import it.csi.sigit.sigitwebn.util.Constants;
//import test.sigitwebn.Phrase;

public class IspezioneBuilderSimul extends BaseBuilder {

	private static String FILE = "D:/progetti/eclipse oxygen/sigit/sigit_sigitwebn/src/java/test/sigitwebn/TestIspezione";

	public static String getDataCompleta() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HH_mm_ss");
		return sdf.format(new Date());
	}

	public static void main(String[] args) {
		try {
			IspezioneBuilderSimul ispezione = new IspezioneBuilderSimul();

			DettaglioDocumento dettaglioDocumento = ispezione.generaIspezione(null, true);
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
	 
	
	public DettaglioDocumento generaIspezione(DettaglioIspezione ispezione, boolean isSimulazione)
	{
		DettaglioDocumento result = new DettaglioDocumento();

		try
		{
			log.debug("generaIspezione - START");
			Document document = creaDocumento(isSimulazione);
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			PdfWriter writer = PdfWriter.getInstance(document, outputStream);

			log.debug("generaIspezione - PASSO 1");

			//PdfWriter.getInstance(document, new FileOutputStream(FILE+getDataCompleta()+".pdf"));
			document.open();

			// Aggiungo il Watermark (filigrana)
			writer.setPageEvent(new PDFEventListener(true));
			
			log.debug("generaIspezione - PASSO 2");

			//SigitTRappIspezGtDto rappIsp = getSigitMgr().cercaComponentiScByFilter(codiceImpianto, progressivo, componentiDistinte)
			
			aggiungiMetaDati(document);

			log.debug("generaIspezione - PASSO 3");

			aggiungiIntestazione(document);

			log.debug("generaIspezione - PASSO 4");

			document.add(new Paragraph("Foglio n°_________ di __________", FONT_HELVETICA_9_I));

			//document.add( Chunk.LINEHEIGHT);

			log.debug("generaIspezione - PASSO 5");

			aggiungiDatiGenerali(document);

			log.debug("generaIspezione - PASSO 6");

			aggiungiDestinazione(document);

			log.debug("generaIspezione - PASSO 7");

			aggiungiControlloImpianto(document);

			log.debug("generaIspezione - PASSO 8");

			aggiungiStatoDocumentazione(document);

			log.debug("generaIspezione - PASSO 9");

			aggiungiInterventiMiglioramento(document);
			
			 // Nuova pagina
			 document.newPage();
			 
		     document.add(new Paragraph("Foglio n°_________ di _________ Catasto impianti/codice: _________ Data dell'ispezione: _________ N° _________", FONT_HELVETICA_9_I));

			 aggiungiGeneratore(document);

			 aggiungiManutenzioneAnalisi(document);
			 
			 aggiungiMisuraDeiProdotti(document);
			 
			 aggiungiEsitoProva(document);
			 
			 aggiungiOssPrescrDich(document);
			 
			 // Nuova pagina
			 document.newPage();

			 createTabellaProvaPdf(document);
			 
			 //aggiungiContenuto(document);


				outputStream.flush();
				document.close();
				outputStream.close();

				log.debug("generaIspezione - PASSO 13");

				byte[] thePdfIText = outputStream.toByteArray();

				log.debug("generaIspezione - PASSO 14");

				result.setFile(thePdfIText);
				result.setNomeDocumento("Ispezione_IText.pdf");
				
			 /*
			document.add( Chunk.NEWLINE );
			log.debug("generaIspezione - PASSO 10");

			// Nuova pagina
			document.newPage();

			log.debug("generaIspezione - PASSO 11");

			createTabellaProvaPdf(document);

			log.debug("generaIspezione - PASSO 12");

			//aggiungiContenuto(document);
			outputStream.flush();
			document.close();
			outputStream.close();

			log.debug("generaIspezione - PASSO 13");

			byte[] thePdfIText = outputStream.toByteArray();

			log.debug("generaIspezione - PASSO 14");

			result.setFile(thePdfIText);
			result.setNomeDocumento("Ispezione_IText.pdf");
			
			log.debug("generaIspezione - PASSO 15");
			*/
		}
		catch (DocumentException e) {
			// TODO: handle exception
			log.error("DocumentException", e);
		}
		catch (Exception e) {
			// TODO: handle exception
			log.error("Exception", e);
		}

		log.debug("generaIspezione - END");

		return result;

	}
	
	private static void aggiungiOssPrescrDich(Document document) throws DocumentException {

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


		 c1 = new PdfPCell(new Paragraph(VAR, FONT_HELVETICA_8));
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


		 c1 = new PdfPCell(new Paragraph(VAR, FONT_HELVETICA_8));
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


		 c1 = new PdfPCell(new Paragraph(VAR, FONT_HELVETICA_8));
		 tabella.addCell(c1);

		 document.add(tabella); //AGGIUNGO LA TABELLA NEL DOCUMENTO


	 }
	
	private static void aggiungiEsitoProva(Document document) throws DocumentException {

		 //Suddivido il foglio in sezioni, cioè in questo caso, un foglio 100% viene diviso in due sezioni, su 8 la prima è larga 2 e l’altra larga 6. Le sezioni possono essere anche di più spartizioni, basta solo aggiungere un valore dopo la virgola es. {3,3,3} suddividiamo in tre sezioni uguali tra di loro.
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
		 aggiungiCheckPrima(p1, "Regolare", true);
		 c1 = new PdfPCell(p1);
		 c1.setHorizontalAlignment(Element.ALIGN_CENTER); 
		 c1.setVerticalAlignment(Element.ALIGN_MIDDLE); 
		 tabella.addCell(c1);

		 p1 = new Paragraph("", FONT_HELVETICA_8);
		 aggiungiCheckPrima(p1, "Irregolare", false);
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
		 aggiungiCheckPrima(p1, "Regolare", true, 30);
		 aggiungiCheckPrima(p1, "Irregolare", true, 30);
		 aggiungiCheckPrima(p1, "Na (combustibile gassoso)", true);
		 c1 = new PdfPCell(p1);
		 c1.setColspan(2);
		 c1.setVerticalAlignment(Element.ALIGN_MIDDLE); 
		 tabella.addCell(c1);

		 p2 = new Phrase("Rendimento di combustione ", FONT_HELVETICA_8);//u33A5
		 
		 String FONT = "D:/progetti/eclipse oxygen/sigit/sigit_sigitwebn/src/web/sigitwebn/img/FreeSans.ttf";
		 String TEXT = "\u03B7";

		    BaseFont bf;
			try {
				bf = BaseFont.createFont(FONT, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
			    Font f = new Font(bf, 8);
			    Paragraph p = new Paragraph(TEXT, f);
			    p2.add(p);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		 Chunk  p3 = new Chunk ("comb", FONT_HELVETICA_6);
		 Chunk  p4 = new Chunk (" (%)", FONT_HELVETICA_8);

		 p2.add(p3);
		 p2.add(p4);
		 
//		 p2 = new Phrase("c) ", FONT_HELVETICA_8);
//		 p2.add(new Chunk ("Rendimento di combustione\n", FONT_HELVETICA_8_B_I));
//		 p2.add(new Chunk ("(rendimento minimo richiesto ", FONT_HELVETICA_8_I));
//		 p2.add(new Chunk ("\u03B7DPR74 e limiti reg.", FONT_HELVETICA_6_I));
//		 p2.add(new Chunk (VAR, FONT_HELVETICA_8_I));
//		 p2.add(new Chunk ("%)", FONT_HELVETICA_8_I));
		 
		 
		    
		    
		 c1 = new PdfPCell(p2);
		 c1.setVerticalAlignment(Element.ALIGN_MIDDLE); 
		 tabella.addCell(c1);

		 p2 = new Phrase("Valore rilevato + 2 =", FONT_HELVETICA_8);
		 p2.add(VAR);
		 p2.add("%");
		 c1 = new PdfPCell(p2);
		 c1.setHorizontalAlignment(Element.ALIGN_CENTER); 
		 c1.setVerticalAlignment(Element.ALIGN_MIDDLE); 
		 tabella.addCell(c1);


		 p1 = new Paragraph("", FONT_HELVETICA_8);
		 aggiungiSpaziVuoti(p1, 5);
		 aggiungiCheckPrima(p1, "Sufficiente", true, 30);
		 aggiungiCheckPrima(p1, "Insufficiente", true);
		 c1 = new PdfPCell(p1);
		 c1.setVerticalAlignment(Element.ALIGN_MIDDLE); 
		 tabella.addCell(c1);

		 p2 = new Phrase("d) ", FONT_HELVETICA_8);
		 p2.add(new Chunk ("Ossidi di azoto", FONT_HELVETICA_8_B_I));
		 p2.add(new Chunk (" (Emissioni di NOx)\n", FONT_HELVETICA_8_I));
		 p2.add(new Chunk ("(deve essere < di", FONT_HELVETICA_8_I));

		 p2.add(new Chunk (VAR, FONT_HELVETICA_8_I));
		 p2.add(new Chunk ("mg/kWh in funzione del combustibile, della potenza nominale e dell'eta' del generatore)", FONT_HELVETICA_8_I));

		 c1 = new PdfPCell(p2);
		 tabella.addCell(c1);

		 p2 = new Phrase("Valore rilevato - 20 =", FONT_HELVETICA_8);
		 p2.add(VAR);
		 p2.add("mg/kWh");
		 c1 = new PdfPCell(p2);
		 c1.setHorizontalAlignment(Element.ALIGN_CENTER); 
		 c1.setVerticalAlignment(Element.ALIGN_MIDDLE); 
		 tabella.addCell(c1);


		 p1 = new Paragraph("", FONT_HELVETICA_8);
		 aggiungiSpaziVuoti(p1, 5);
		 aggiungiCheckPrima(p1, "Regolare", true, 30);
		 aggiungiCheckPrima(p1, "Irregolare", true);
		 c1 = new PdfPCell(p1);
		 c1.setVerticalAlignment(Element.ALIGN_MIDDLE); 
		 tabella.addCell(c1);
		 
		 p1 = new Paragraph("e) ", FONT_HELVETICA_8);
		 p1.add(new Chunk ("L'impianto rispetta la normativa\n", FONT_HELVETICA_8_B_I));
		 p1.add(new Chunk ("(DPR 74/2013 e normativa regionale", FONT_HELVETICA_8_I));
		 aggiungiSpaziVuoti(p1, 20);
		 aggiungiCheckPrima(p1, "", true);

		 c1 = new PdfPCell(p1);
		 tabella.addCell(c1);
		 

		 p1 = new Paragraph("e) ", FONT_HELVETICA_8);
		 p1.add(new Chunk ("L'impianto non rispetta la normativa", FONT_HELVETICA_8_B_I));
		 p1.add(new Chunk (" per quanto riguarda i punti:\n", FONT_HELVETICA_8_I));
		 aggiungiSpaziVuoti(p1, 20);
		 aggiungiCheckPrima(p1, "7.a", true, 10);
		 aggiungiCheckPrima(p1, "7.b", false, 10);
		 aggiungiCheckPrima(p1, "9.a", true, 10);
		 aggiungiCheckPrima(p1, "9.b", false, 10);
		 aggiungiCheckPrima(p1, "9.c", true, 10);
		 aggiungiCheckPrima(p1, "9.d", false);

		 c1 = new PdfPCell(p1);
		 c1.setColspan(2);
		 tabella.addCell(c1);


		 //sss
		 
		 
		 
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
	
	 private static void aggiungiMisuraDeiProdotti(Document document) throws DocumentException {

		 //Suddivido il foglio in sezioni, cioè in questo caso, un foglio 100% viene diviso in due sezioni, su 8 la prima è larga 2 e l’altra larga 6. Le sezioni possono essere anche di più spartizioni, basta solo aggiungere un valore dopo la virgola es. {3,3,3} suddividiamo in tre sezioni uguali tra di loro.
		 float[] columnWidths = {13,2,7,12,15,12,13,13,13}; 
		 
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

		 /*
		 // Prova caratteri
		 Font font = FontFactory.getFont(FONT_FREESANS, "Cp1253", true);
		 Phrase phrase = new Phrase("Prova" + "\u010c,\u0106,\u0160,\u017d,\u0110", font);
		 //Paragraph p = new Paragraph().setFont(null);
		 c1 = new PdfPCell(phrase);
		 tabella.addCell(c1);
		 //"\u0425\u0430\u0439\u0434\u0430"
		 */
		 /*
		 try
		 {
		 tabella.addCell(getNormalCell("\u010c,\u0106,\u0160,\u017d,\u0110", "czech", 12));
		 }
		 catch (Exception e)
		 {
			 e.printStackTrace();
		 }
		 */
		 //Font f = FontFactory.getFont(FONT_FREESANS, "Cp1253", true);
		 //f.setSize(8);

		 Phrase p2 = new Phrase("Rendimento di combustione \u03B7", FONT_HELVETICA_8);//u33A5
		 Chunk  p3 = new Chunk ("comb", FONT_HELVETICA_6);
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
		 
		 
		 document.add(tabella); //AGGIUNGO LA TABELLA NEL DOCUMENTO

		 
	 }

	 private static void aggiungiManutenzioneAnalisi(Document document) throws DocumentException {

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
		 aggiungiCheckPrima(p1, "Semestrale", true, 12);
		 aggiungiCheckPrima(p1, "Annuale", false, 12);
		 aggiungiCheckPrima(p1, "Biennale", true, 12);
		 aggiungiCheckPrima(p1, "Altra: "+VAR, false, 12);
		 c1 = new PdfPCell(p1);
		 tabella.addCell(c1);
		 
		 
		 p1 = new Paragraph("Ultima manutenzione prevista effettuata", FONT_HELVETICA_8);
		 aggiungiSpaziVuoti(p1, 5);
		 aggiungiCheckPrima(p1, "Si", true, 12);
		 aggiungiCheckPrima(p1, "No", false, 12);
		 
		 p1.add("In data:");
		 p1.add(VAR);
		 c1 = new PdfPCell(p1);
		 tabella.addCell(c1);
		 
		 
		 c1 = new PdfPCell(new Paragraph("b) Rapporto controllo efficienza", FONT_HELVETICA_8));
		 tabella.addCell(c1);
		 
		 p1 = new Paragraph("Presente", FONT_HELVETICA_8);
		 aggiungiSpaziVuoti(p1, 5);
		 aggiungiCheckPrima(p1, "Si", true, 7);
		 aggiungiCheckPrima(p1, "No", false, 7);
		 p1.add("In data:");
		 p1.add(VAR);
		 aggiungiSpaziVuoti(p1, 5);
		 aggiungiCheckDopo(p1, "Osservazioni", true, 20);
		 aggiungiCheckDopo(p1, "Raccomandazioni", false, 20);
		 aggiungiCheckDopo(p1, "Prescrizioni", false);
		 c1 = new PdfPCell(p1);
		 tabella.addCell(c1);

		 document.add(tabella); //AGGIUNGO LA TABELLA NEL DOCUMENTO

		 
	 }

	 
	private static void aggiungiGeneratore(Document document) throws DocumentException {

		 //Suddivido il foglio in sezioni, cioè in questo caso, un foglio 100% viene diviso in due sezioni, su 8 la prima è larga 2 e l’altra larga 6. Le sezioni possono essere anche di più spartizioni, basta solo aggiungere un valore dopo la virgola es. {3,3,3} suddividiamo in tre sezioni uguali tra di loro.
		 float[] columnWidths = {23,9,10,13,20,20,5}; 
		 
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
		 p1.add("N° ");
		 p1.add("XXXXX");
		 c1 = new PdfPCell(p1);
	     //c1.setColspan(2);
		 tabella.addCell(c1);
		 
		 p1 = new Paragraph("", FONT_HELVETICA_8);
		 p1.add("di ");
		 p1.add(VAR);
		 c1 = new PdfPCell(p1);
	     c1.setColspan(2);
		 tabella.addCell(c1);
		 
		 p1 = new Paragraph("", FONT_HELVETICA_8);
		 c1 = new PdfPCell(p1);
	     c1.setColspan(3);
		 tabella.addCell(c1);
		 
		 c1 = new PdfPCell(new Paragraph("a1) Tipo di combustibile", FONT_HELVETICA_8));
		 tabella.addCell(c1);
		 
		 p1 = new Paragraph("", FONT_HELVETICA_8);

		 aggiungiCheckPrima(p1, "Gas natur.", true, 12);
		 aggiungiCheckPrima(p1, "GPL", false, 12);
		 aggiungiCheckPrima(p1, "Gasolio", true, 12);
		 aggiungiCheckPrima(p1, "Altro: "+VAR, false);
		 
		 c1 = new PdfPCell(p1);
	     c1.setColspan(3);
		 tabella.addCell(c1);
		 
		 p1 = new Paragraph("k) Dati nominali:", FONT_HELVETICA_8_I);
		 c1 = new PdfPCell(p1);
	     c1.setColspan(3);
		 tabella.addCell(c1);

		 c1 = new PdfPCell(new Paragraph("b) Data installazione", FONT_HELVETICA_8));
		 tabella.addCell(c1);
		 
		 c1 = new PdfPCell(new Paragraph(VAR, FONT_HELVETICA_8));
	     c1.setColspan(3);
		 tabella.addCell(c1);

		 c1 = new PdfPCell(new Paragraph("Potenza termica al focolare:", FONT_HELVETICA_8));
		 c1.setBorder(Rectangle.TOP | Rectangle.LEFT | Rectangle.BOTTOM);
		 tabella.addCell(c1);

		 c1 = new PdfPCell(new Paragraph(VAR, FONT_HELVETICA_8));
		 c1.setBorder(Rectangle.TOP | Rectangle.BOTTOM);
		 tabella.addCell(c1);
		 
		 c1 = new PdfPCell(new Paragraph("(kW)", FONT_HELVETICA_8));
		 c1.setBorder(Rectangle.TOP | Rectangle.RIGHT | Rectangle.BOTTOM);
		 tabella.addCell(c1);
		 
		 
		 c1 = new PdfPCell(new Paragraph("c) Fluido termovettore", FONT_HELVETICA_8));
		 tabella.addCell(c1);
		 
		 p1 = new Paragraph("", FONT_HELVETICA_8);
		 aggiungiCheckPrima(p1, "Acqua", false, 12);
		 aggiungiCheckPrima(p1, "Aria", true, 12);
		 aggiungiCheckPrima(p1, "Altro: "+VAR, false);
		 
		 c1 = new PdfPCell(p1);
	     c1.setColspan(3);
		 tabella.addCell(c1);
		 
		 c1 = new PdfPCell(new Paragraph("Potenza termica utile:", FONT_HELVETICA_8));
		 c1.setBorder(Rectangle.TOP | Rectangle.LEFT | Rectangle.BOTTOM);
		 tabella.addCell(c1);
		 
		 c1 = new PdfPCell(new Paragraph(VAR, FONT_HELVETICA_8));
		 c1.setBorder(Rectangle.TOP | Rectangle.BOTTOM);
		 tabella.addCell(c1);
		 
		 c1 = new PdfPCell(new Paragraph("(kW)", FONT_HELVETICA_8));
		 c1.setBorder(Rectangle.TOP | Rectangle.RIGHT | Rectangle.BOTTOM);
		 tabella.addCell(c1);
		 
		 
		 c1 = new PdfPCell(new Paragraph("d) Modalita' di evacuazione fumi", FONT_HELVETICA_8));
		 tabella.addCell(c1);
		 
		 p1 = new Paragraph("", FONT_HELVETICA_8);
		 aggiungiCheckPrima(p1, "Naturale", false, 20);
		 aggiungiCheckPrima(p1, "Forzata", true);
		 
		 c1 = new PdfPCell(p1);
	     c1.setColspan(3);
		 tabella.addCell(c1);

		 
		 c1 = new PdfPCell(new Paragraph("Campo di lavoro bruciatore:", FONT_HELVETICA_8));
		 c1.setBorder(Rectangle.TOP | Rectangle.LEFT | Rectangle.BOTTOM);
	     c1.setRowspan(2);
		 tabella.addCell(c1);
		 
		 c1 = new PdfPCell(new Paragraph("da: "+VAR, FONT_HELVETICA_8));
		 c1.setBorder(Rectangle.TOP);
		 tabella.addCell(c1);
		 
		 c1 = new PdfPCell(new Paragraph("(kW)", FONT_HELVETICA_8));
		 c1.setBorder(Rectangle.TOP | Rectangle.RIGHT);
		 tabella.addCell(c1);
		 
		 c1 = new PdfPCell(new Paragraph("e) Costruttore caldaia", FONT_HELVETICA_8));
		 tabella.addCell(c1);
		 
		 c1 = new PdfPCell(new Paragraph(VAR, FONT_HELVETICA_8));
	     c1.setColspan(3);
		 tabella.addCell(c1);

		 c1 = new PdfPCell(new Paragraph("a: "+VAR, FONT_HELVETICA_8));
		 c1.setBorder(Rectangle.BOTTOM);
		 tabella.addCell(c1);
		 
		 c1 = new PdfPCell(new Paragraph("(kW)", FONT_HELVETICA_8));
		 c1.setBorder(Rectangle.RIGHT | Rectangle.BOTTOM);
		 tabella.addCell(c1);
		 

		 c1 = new PdfPCell(new Paragraph("f) modello e matricola caldaia", FONT_HELVETICA_8));
		 tabella.addCell(c1);

		 c1 = new PdfPCell(new Paragraph(VAR, FONT_HELVETICA_8));
	     c1.setColspan(2);
		 tabella.addCell(c1);

		 c1 = new PdfPCell(new Paragraph(VAR, FONT_HELVETICA_8));
		 tabella.addCell(c1);
		 
		 c1 = new PdfPCell(new Paragraph("l) Dati misurati:", FONT_HELVETICA_8_I));
		 c1.setBorder(Rectangle.LEFT | Rectangle.TOP| Rectangle.RIGHT);
	     c1.setColspan(3);
		 tabella.addCell(c1);
		 
		 c1 = new PdfPCell(new Paragraph("g) Costruttore bruciatore", FONT_HELVETICA_8));
		 tabella.addCell(c1);
		 
		 c1 = new PdfPCell(new Paragraph(VAR, FONT_HELVETICA_8));
	     c1.setColspan(3);
		 tabella.addCell(c1);
		 
		 c1 = new PdfPCell(new Paragraph("Portata di combustibile:", FONT_HELVETICA_8));
		 c1.setBorder(Rectangle.LEFT | Rectangle.BOTTOM);
		 tabella.addCell(c1);

		 c1 = new PdfPCell(new Paragraph(VAR + " (m3/h) " + VAR, FONT_HELVETICA_8));
		 c1.setBorder(Rectangle.BOTTOM);
		 tabella.addCell(c1);
		 
		 c1 = new PdfPCell(new Paragraph("(kg/h)", FONT_HELVETICA_8));
		 c1.setBorder(Rectangle.RIGHT | Rectangle.BOTTOM);
		 tabella.addCell(c1);

		 
		 c1 = new PdfPCell(new Paragraph("h) modello e matricola bruciatore", FONT_HELVETICA_8));
		 tabella.addCell(c1);

		 c1 = new PdfPCell(new Paragraph(VAR, FONT_HELVETICA_8));
	     c1.setColspan(2);
		 tabella.addCell(c1);

		 c1 = new PdfPCell(new Paragraph(VAR, FONT_HELVETICA_8));
		 tabella.addCell(c1);

		 c1 = new PdfPCell(new Paragraph("Potenza termica al focolare:", FONT_HELVETICA_8));
		 c1.setBorder(Rectangle.TOP | Rectangle.LEFT | Rectangle.BOTTOM);
		 tabella.addCell(c1);
		 
		 c1 = new PdfPCell(new Paragraph(VAR, FONT_HELVETICA_8));
		 c1.setBorder(Rectangle.TOP | Rectangle.BOTTOM);
		 tabella.addCell(c1);
		 
		 c1 = new PdfPCell(new Paragraph("(kW)", FONT_HELVETICA_8));
		 c1.setBorder(Rectangle.TOP | Rectangle.RIGHT | Rectangle.BOTTOM);
		 tabella.addCell(c1);
		 
		 
		 c1 = new PdfPCell(new Paragraph("i) Tipologia gruppo termico", FONT_HELVETICA_8));
		 tabella.addCell(c1);
		 
		 p1 = new Paragraph("", FONT_HELVETICA_8);
		 aggiungiCheckPrima(p1, "Singolo tipo B", false, 20);
		 aggiungiCheckPrima(p1, "Singolo tipo C", true, 20);
		 aggiungiCheckPrima(p1, "Modulare", false, 18);
		 aggiungiCheckPrima(p1, "Tubo o nastro radiante", true, 30);
		 aggiungiCheckPrima(p1, "Ad aria calda", false);

		 c1 = new PdfPCell(p1);
	     c1.setColspan(6);
		 tabella.addCell(c1);

		 c1 = new PdfPCell(new Paragraph("j) Classificazione DPR 660/96", FONT_HELVETICA_8));
		 tabella.addCell(c1);
		 
		 p1 = new Paragraph("", FONT_HELVETICA_8);
		 aggiungiCheckPrima(p1, "Standard", false, 30);
		 aggiungiCheckPrima(p1, "A bassa temperatura", true, 30);
		 aggiungiCheckPrima(p1, "A gas a condensazione", false);

		 c1 = new PdfPCell(p1);
	     c1.setColspan(6);
		 tabella.addCell(c1);
		 
		 document.add(tabella); //AGGIUNGO LA TABELLA NEL DOCUMENTO

		 
	 }

	 private static void aggiungiInterventiMiglioramento(Document document) throws DocumentException {
		 // Paragraph prefazione = new Paragraph();

		 //Oltre a creare una semplice tabella, questo metodo e anche buono se si vuole gestire il foglio in sezioni, in modo molto semplice. L’idea è paragonabile alla programmazione HTML, quando si usano le tabelle.
		 //float paddingleft=10f; //Margine Sx 

		 //Suddivido il foglio in sezioni, cioè in questo caso, un foglio 100% viene diviso in due sezioni, su 8 la prima è larga 2 e l'altra larga 6. Le sezioni possono essere anche di più spartizioni, basta solo aggiungere un valore dopo la virgola es. {3,3,3} suddividiamo in tre sezioni uguali tra di loro.

		 float[] columnWidths = {20,40,40}; 

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
		 c1.setRowspan(2);
		 tabella.addCell(c1);

		 Paragraph p1 = new Paragraph("", FONT_HELVETICA_8);
		 aggiungiCheckPrima(p1, "Adozione di valvole termostatiche sui corpi scaldanti", true);
		 c1 = new PdfPCell(p1);
		 c1.setBorder(Rectangle.LEFT | Rectangle.TOP);
		 //c1.setColspan(2);
		 tabella.addCell(c1);

		 p1 = new Paragraph("", FONT_HELVETICA_8);
		 aggiungiCheckPrima(p1, "Isolamento della rete di distribuzione nei locali non riscaldati", true);
		 c1 = new PdfPCell(p1);
		 c1.setBorder(Rectangle.TOP | Rectangle.RIGHT);
		 //c1.setColspan(2);
		 tabella.addCell(c1);
		 
		 
		 p1 = new Paragraph("", FONT_HELVETICA_8);
		 aggiungiCheckPrima(p1, "Introduzione di un sistema di trattamento dell'acqua", true);
		 c1 = new PdfPCell(p1);
		 c1.setBorder(Rectangle.LEFT | Rectangle.BOTTOM);
		 //c1.setColspan(2);
		 tabella.addCell(c1);

		 p1 = new Paragraph("", FONT_HELVETICA_8);
		 aggiungiCheckPrima(p1, "Sostituzione sistema regolazione on/off con uno programmabile", true);
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
		 aggiungiCheckPrima(p1, "Non sono stati individuati interventi economicamente convenienti", true);
		 c1 = new PdfPCell(p1);
		 c1.setBorder(Rectangle.LEFT | Rectangle.TOP);
		 c1.setColspan(2);
		 tabella.addCell(c1);

		 p1 = new Paragraph("", FONT_HELVETICA_8);
		 aggiungiCheckPrima(p1, "Si allega relazione di dettaglio", true);
		 c1 = new PdfPCell(p1);
		 c1.setBorder(Rectangle.LEFT);
		 //c1.setColspan(2);
		 tabella.addCell(c1);

		 p1 = new Paragraph("", FONT_HELVETICA_8);
		 aggiungiCheckPrima(p1, "Si rimanda a relazione di dettaglio successiva", true);
		 c1 = new PdfPCell(p1);
		 c1.setBorder(Rectangle.RIGHT);
		 tabella.addCell(c1);

		 p1 = new Paragraph("", FONT_HELVETICA_8);
		 aggiungiCheckPrima(p1, "Valutazione non eseguita, motivo:", true);
		 p1.add(VAR);
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
		 aggiungiCheckPrima(p1, "Dimensionamento corretto", true);
		 c1 = new PdfPCell(p1);
		 c1.setBorder(Rectangle.LEFT | Rectangle.TOP);
		 //c1.setColspan(2);
		 tabella.addCell(c1);

		 p1 = new Paragraph("", FONT_HELVETICA_8);
		 aggiungiCheckPrima(p1, "Dimensionamento non corretto", true);
		 c1 = new PdfPCell(p1);
		 c1.setBorder(Rectangle.TOP | Rectangle.RIGHT);
		 tabella.addCell(c1);

		 p1 = new Paragraph("", FONT_HELVETICA_8);
		 aggiungiCheckPrima(p1, "Non controllabile", true);
		 c1 = new PdfPCell(p1);
		 c1.setBorder(Rectangle.LEFT | Rectangle.BOTTOM);
		 //c1.setColspan(2);
		 tabella.addCell(c1);

		 p1 = new Paragraph("", FONT_HELVETICA_8);
		 aggiungiCheckPrima(p1, "Si rimanda a relazione di dettaglio successiva", true);
		 c1 = new PdfPCell(p1);
		 c1.setBorder(Rectangle.RIGHT | Rectangle.BOTTOM);
		 tabella.addCell(c1);
		 
		 
		 document.add(tabella); //AGGIUNGO LA TABELLA NEL DOCUMENTO
		

	 }
	 
	 private static void aggiungiStatoDocumentazione(Document document) throws DocumentException {
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

		 aggiungiCheckSi(p1, false);
		 aggiungiCheckNo(p1, false);
		 c1 = new PdfPCell(p1);
		 tabella.addCell(c1);


		 c1 = new PdfPCell(new Paragraph("b) Libretto di impianto compilato in tutte le sue parti", FONT_HELVETICA_8));
		 tabella.addCell(c1);

		 p1 = new Paragraph("", FONT_HELVETICA_8);

		 aggiungiCheckSi(p1, false);
		 aggiungiCheckNo(p1, true);
		 c1 = new PdfPCell(p1);
		 tabella.addCell(c1);


		 // Riga 2
		 c1 = new PdfPCell(new Paragraph("c) Dic. conformita'/rispondenza presente)", FONT_HELVETICA_8));
		 tabella.addCell(c1);

		 p1 = new Paragraph("", FONT_HELVETICA_8);

		 aggiungiCheckSi(p1, true);
		 aggiungiCheckNo(p1, false);
		 c1 = new PdfPCell(p1);
		 tabella.addCell(c1);


		 c1 = new PdfPCell(new Paragraph("d) Libretti uso/manutenzione generatore presenti", FONT_HELVETICA_8));
		 tabella.addCell(c1);

		 p1 = new Paragraph("", FONT_HELVETICA_8);

		 aggiungiCheckSi(p1, true);
		 aggiungiCheckNo(p1, false);
		 c1 = new PdfPCell(p1);
		 tabella.addCell(c1);



		 // Riga 3
		 c1 = new PdfPCell(new Paragraph("e) Pratica VV.F. presente ove richiesto", FONT_HELVETICA_8));
		 tabella.addCell(c1);

		 p1 = new Paragraph("", FONT_HELVETICA_8);

		 aggiungiCheckSi(p1, false);
		 aggiungiCheckNo(p1, true);
		 aggiungiCheckPrima(p1, "Na", false);
		 c1 = new PdfPCell(p1);
		 tabella.addCell(c1);


		 c1 = new PdfPCell(new Paragraph("f) Pratica INAIL presente (gia' ISPESL)", FONT_HELVETICA_8));
		 tabella.addCell(c1);

		 p1 = new Paragraph("", FONT_HELVETICA_8);

		 aggiungiCheckSi(p1, false);
		 aggiungiCheckNo(p1, true);
		 aggiungiCheckPrima(p1, "Na", false);
		 c1 = new PdfPCell(p1);
		 tabella.addCell(c1);


		 // Riga 4
		 p1 = new Paragraph("g) Matricola DM 1/12/1975 n. ", FONT_HELVETICA_8);
		 p1.add(VAR);
		 c1 = new PdfPCell(p1);
		 tabella.addCell(c1);

		 p1 = new Paragraph("", FONT_HELVETICA_8);

		 aggiungiCheckSi(p1, false);
		 aggiungiCheckNo(p1, true);
		 aggiungiCheckPrima(p1, "Na", false);
		 c1 = new PdfPCell(p1);
		 tabella.addCell(c1);

		 // Colonna vuota
		 tabella.addCell(new PdfPCell());
		 // Colonna vuota
		 tabella.addCell(new PdfPCell());

		 document.add(tabella); //AGGIUNGO LA TABELLA NEL DOCUMENTO


	 }

	 
	 private static void aggiungiControlloImpianto(Document document) throws DocumentException {
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
		 c1 = new PdfPCell(new Paragraph("a) Installazione interna: locale idoneo", FONT_HELVETICA_8));
		 tabella.addCell(c1);

		 Paragraph p1 = new Paragraph("", FONT_HELVETICA_8);

		 aggiungiCheckSi(p1, false);
		 aggiungiCheckNo(p1, false);
		 aggiungiCheckPrima(p1, "Na", false);
		 c1 = new PdfPCell(p1);
		 tabella.addCell(c1);


		 c1 = new PdfPCell(new Paragraph("b) Installazione esterna: generatori idonei", FONT_HELVETICA_8));
		 tabella.addCell(c1);

		 p1 = new Paragraph("", FONT_HELVETICA_8);

		 aggiungiCheckSi(p1, false);
		 aggiungiCheckNo(p1, true);
		 aggiungiCheckPrima(p1, "Na", false);
		 c1 = new PdfPCell(p1);
		 tabella.addCell(c1);


		 // Riga 2
		 c1 = new PdfPCell(new Paragraph("c) Sistema di ventilazione sufficiente", FONT_HELVETICA_8));
		 tabella.addCell(c1);

		 p1 = new Paragraph("", FONT_HELVETICA_8);

		 aggiungiCheckSi(p1, true);
		 aggiungiCheckNo(p1, false);
		 aggiungiCheckPrima(p1, "Na", true);
		 c1 = new PdfPCell(p1);
		 tabella.addCell(c1);


		 c1 = new PdfPCell(new Paragraph("d) Sistema evacuazione fumi idoneo (esame visivo)", FONT_HELVETICA_8));
		 tabella.addCell(c1);

		 p1 = new Paragraph("", FONT_HELVETICA_8);

		 aggiungiCheckSi(p1, true);
		 aggiungiCheckNo(p1, false);
		 aggiungiCheckPrima(p1, "Na", true);
		 c1 = new PdfPCell(p1);
		 tabella.addCell(c1);



		 // Riga 3
		 c1 = new PdfPCell(new Paragraph("e) Cartellonistica prevista presente", FONT_HELVETICA_8));
		 tabella.addCell(c1);

		 p1 = new Paragraph("", FONT_HELVETICA_8);

		 aggiungiCheckSi(p1, false);
		 aggiungiCheckNo(p1, true);
		 aggiungiCheckPrima(p1, "Na", false);
		 c1 = new PdfPCell(p1);
		 tabella.addCell(c1);


		 c1 = new PdfPCell(new Paragraph("f) Mezzi estinzione incendi presenti e revisionati", FONT_HELVETICA_8));
		 tabella.addCell(c1);

		 p1 = new Paragraph("", FONT_HELVETICA_8);

		 aggiungiCheckSi(p1, false);
		 aggiungiCheckNo(p1, true);
		 aggiungiCheckPrima(p1, "Na", false);
		 c1 = new PdfPCell(p1);
		 tabella.addCell(c1);


		 // Riga 4
		 c1 = new PdfPCell(new Paragraph("g) Interruttore generale presente", FONT_HELVETICA_8));
		 tabella.addCell(c1);

		 p1 = new Paragraph("", FONT_HELVETICA_8);

		 aggiungiCheckSi(p1, false);
		 aggiungiCheckNo(p1, true);
		 aggiungiCheckPrima(p1, "Na", false);
		 c1 = new PdfPCell(p1);
		 tabella.addCell(c1);


		 c1 = new PdfPCell(new Paragraph("h) Rubinetto intercettazione esterno presente", FONT_HELVETICA_8));
		 tabella.addCell(c1);

		 p1 = new Paragraph("", FONT_HELVETICA_8);

		 aggiungiCheckSi(p1, true);
		 aggiungiCheckNo(p1, false);
		 aggiungiCheckPrima(p1, "Na", false);
		 c1 = new PdfPCell(p1);
		 tabella.addCell(c1);



		 // Riga 5
		 c1 = new PdfPCell(new Paragraph("i) Assenza perdite comb. (esame visivo)", FONT_HELVETICA_8));
		 tabella.addCell(c1);

		 p1 = new Paragraph("", FONT_HELVETICA_8);

		 aggiungiCheckSi(p1, false);
		 aggiungiCheckNo(p1, false);
		 aggiungiCheckPrima(p1, "Na", true);
		 c1 = new PdfPCell(p1);
		 tabella.addCell(c1);


		 c1 = new PdfPCell(new Paragraph("j) Sistema regolazione temp. ambiente funzionante", FONT_HELVETICA_8));
		 tabella.addCell(c1);

		 p1 = new Paragraph("", FONT_HELVETICA_8);

		 aggiungiCheckSi(p1, true);
		 aggiungiCheckNo(p1, false);
		 aggiungiCheckPrima(p1, "Na", false);
		 c1 = new PdfPCell(p1);
		 tabella.addCell(c1);

		 // Riga 6
		 c1 = new PdfPCell(new Paragraph("k) Assenza o mancata taratura dei dispositivi DM 1/12/75", FONT_HELVETICA_8));
		 c1.setColspan(3);
		 tabella.addCell(c1);

		 p1 = new Paragraph("", FONT_HELVETICA_8);

		 aggiungiCheckSi(p1, false);
		 aggiungiCheckNo(p1, true);
		 aggiungiCheckPrima(p1, "Na", false);
		 c1 = new PdfPCell(p1);
		 tabella.addCell(c1);

		 document.add(tabella); //AGGIUNGO LA TABELLA NEL DOCUMENTO


	 }

	 private static void aggiungiDestinazione(Document document) throws DocumentException {
		 // Paragraph prefazione = new Paragraph();

		 //Oltre a creare una semplice tabella, questo metodo e anche buono se si vuole gestire il foglio in sezioni, in modo molto semplice. L’idea è paragonabile alla programmazione HTML, quando si usano le tabelle.
		 //float paddingleft=10f; //Margine Sx 

		 //Suddivido il foglio in sezioni, cioè in questo caso, un foglio 100% viene diviso in due sezioni, su 8 la prima è larga 2 e l’altra larga 6. Le sezioni possono essere anche di più spartizioni, basta solo aggiungere un valore dopo la virgola es. {3,3,3} suddividiamo in tre sezioni uguali tra di loro.
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

		 aggiungiCheckPrima(p1, "E.1", false, 20);
		 aggiungiCheckPrima(p1, "E.2", false, 20);
		 aggiungiCheckPrima(p1, "E.3", false, 20);
		 aggiungiCheckPrima(p1, "E.4", false, 20);
		 aggiungiCheckPrima(p1, "E.5", false, 20);
		 aggiungiCheckPrima(p1, "E.6", false, 20);
		 aggiungiCheckPrima(p1, "E.7", false, 20);
		 aggiungiCheckPrima(p1, "E.8", false);
		 
		 c1 = new PdfPCell(p1);
	     c1.setColspan(3);

		 tabella.addCell(c1);
		 
		 c1 = new PdfPCell(new Paragraph("b) Unità immobiliari servite ", FONT_HELVETICA_8));
		 tabella.addCell(c1);

		 p1 = new Paragraph("", FONT_HELVETICA_8);
		 aggiungiCheckPrima(p1, "Unica", true, 10);
		 aggiungiCheckPrima(p1, "Piu' unita'", false);
		 c1 = new PdfPCell(p1);
	     //c1.setColspan(3);
		 tabella.addCell(c1);

		 c1 = new PdfPCell(new Paragraph("c) Uso dell'impianto ", FONT_HELVETICA_8));
		 tabella.addCell(c1);


		 p1 = new Paragraph("", FONT_HELVETICA_8);
		 aggiungiCheckPrima(p1, "Riscaldamento ambienti", false, 30);
		 aggiungiCheckPrima(p1, "Produzione Acqua Calda Sanitaria", true);
		 c1 = new PdfPCell(p1);
	     //c1.setColspan(3);
		 tabella.addCell(c1);

		 c1 = new PdfPCell(new Paragraph("b1) Sono presenti sistemi di termoregolazione e contabilizzazione del calore?", FONT_HELVETICA_8));
	     c1.setColspan(3);
		 tabella.addCell(c1);

		 p1 = new Paragraph("", FONT_HELVETICA_8);
		 aggiungiCheckSi(p1, true);
		 aggiungiCheckNo(p1, false);
		 aggiungiCheckPrima(p1, "Esentato", false, 10);

		 c1 = new PdfPCell(p1);
	     //c1.setColspan(3);
		 tabella.addCell(c1);

		 
		 c1 = new PdfPCell(new Paragraph("b2) E' applicata la UNI 10200 per la contabilizzazione?", FONT_HELVETICA_8));
	     c1.setColspan(3);
		 tabella.addCell(c1);

		 p1 = new Paragraph("", FONT_HELVETICA_8);
		 aggiungiCheckSi(p1, true);
		 aggiungiCheckNo(p1, false);
		 aggiungiCheckPrima(p1, "Prima stagione", false, 10);

		 c1 = new PdfPCell(p1);
	     //c1.setColspan(3);
		 tabella.addCell(c1);

		 
		 c1 = new PdfPCell(new Paragraph("d) Volume lordo riscaldato", FONT_HELVETICA_8));
		 tabella.addCell(c1);

		 p1 = new Paragraph("", FONT_HELVETICA_8);
		 p1.add(VAR);
		 p1.add(" (m3)");
		 c1 = new PdfPCell(p1);
	     c1.setColspan(2);
		 tabella.addCell(c1);

		 // Colonna vuota
		 tabella.addCell(new PdfPCell());

		 
		 
		 c1 = new PdfPCell(new Paragraph("f) Trattamento dell’acqua", FONT_HELVETICA_8));
		 c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
	     c1.setRowspan(2);
		 tabella.addCell(c1);

		 c1 = new PdfPCell(new Paragraph("in riscaldamento", FONT_HELVETICA_8));
		 tabella.addCell(c1);
		 
		 p1 = new Paragraph("", FONT_HELVETICA_8);
		 aggiungiCheckPrima(p1, "Non richiesto", true, 20);
		 aggiungiCheckPrima(p1, "Assente", false, 20);
		 aggiungiCheckPrima(p1, "Filtrazione", true, 20);
		 aggiungiCheckPrima(p1, "Addolcimento", false, 20);
		 aggiungiCheckPrima(p1, "Cond. chimico", true, 20);
		 
		 c1 = new PdfPCell(p1);
	     c1.setColspan(2);
		 tabella.addCell(c1);
		 

		 c1 = new PdfPCell(new Paragraph("in produzione di ACS", FONT_HELVETICA_8));
		 tabella.addCell(c1);
		 
		 p1 = new Paragraph("", FONT_HELVETICA_8);
		 aggiungiCheckPrima(p1, "Non richiesto", false, 20);
		 aggiungiCheckPrima(p1, "Assente", true, 20);
		 aggiungiCheckPrima(p1, "Filtrazione", false, 20);
		 aggiungiCheckPrima(p1, "Addolcimento", true, 20);
		 aggiungiCheckPrima(p1, "Cond. chimico", false, 20);
		 
		 c1 = new PdfPCell(p1);
	     c1.setColspan(2);
		 tabella.addCell(c1);
		 

		 
	     /*
	     cc
		 
		 
		 c1 = new PdfPCell(new Paragraph(var, FONT_TIMES_7));
	     c1.setColspan(3);
		 tabella.addCell(c1);

		 c1 = new PdfPCell(new Paragraph("b) Ispezione", FONT_TIMES_7));
		 tabella.addCell(c1);
		 
		 c1 = new PdfPCell(new Paragraph("Data: "+var, FONT_TIMES_7));
		 tabella.addCell(c1);

		 c1 = new PdfPCell(new Paragraph("Ora: "+var, FONT_TIMES_7));
		 tabella.addCell(c1);

		 c1 = new PdfPCell(new Paragraph("Numero: "+var, FONT_TIMES_7));
		 tabella.addCell(c1);
		*/
		 
		 document.add(tabella); //AGGIUNGO LA TABELLA NEL DOCUMENTO

		 
	 }
	 
	 private static void aggiungiIntestazione(Document document) throws DocumentException {
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
	 
	 private static void aggiungiDatiGenerali(Document document) throws DocumentException {
		 // Paragraph prefazione = new Paragraph();

		 //Oltre a creare una semplice tabella, questo metodo e anche buono se si vuole gestire il foglio in sezioni, in modo molto semplice. L’idea è paragonabile alla programmazione HTML, quando si usano le tabelle.
		 //float paddingleft=10f; //Margine Sx 

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
		 
		 c1 = new PdfPCell(new Paragraph(VAR, FONT_HELVETICA_8));
	     c1.setColspan(3);
		 tabella.addCell(c1);

		 c1 = new PdfPCell(new Paragraph("b) Ispezione", FONT_HELVETICA_8));
		 tabella.addCell(c1);
		 
		 c1 = new PdfPCell(new Paragraph("Data: "+VAR, FONT_HELVETICA_8));
		 tabella.addCell(c1);

		 c1 = new PdfPCell(new Paragraph("Ora: "+VAR, FONT_HELVETICA_8));
		 tabella.addCell(c1);

		 c1 = new PdfPCell(new Paragraph("Numero: "+VAR, FONT_HELVETICA_8));
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
		 aggiungiCheckSi(p, true);
		 aggiungiCheckNo(p, false);
		 
		 c2 = new PdfPCell(p);
		 c2.setVerticalAlignment(Element.ALIGN_MIDDLE);
	     c2.setRowspan(2);
		 tabella2.addCell(c2);


		 p = new Paragraph("Bollino   ", FONT_HELVETICA_8);
		 aggiungiCheckSi(p, false);
		 aggiungiCheckNo(p, true);
		 
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
		 
		 c2 = new PdfPCell(new Paragraph("N° bollino "+VAR, FONT_HELVETICA_8));
		 tabella2.addCell(c2);

		 c2 = new PdfPCell(new Paragraph("Data bollino "+VAR, FONT_HELVETICA_8));
		 tabella2.addCell(c2);

		 
		 document.add(tabella2); //AGGIUNGO LA TABELLA NEL DOCUMENTO

		 ///////// OK - sopra

		 
		 
		 
		 
		 
		 
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

		 c3 = new PdfPCell(new Paragraph("Cognome e nome:", FONT_HELVETICA_8));
		 //c3.setVerticalAlignment(Element.ALIGN_MIDDLE);
	     c3.setColspan(2);
	     tabella3.addCell(c3);


		 c3 = new PdfPCell(new Paragraph("Estremi/qualifica::", FONT_HELVETICA_8));
		 //c3.setVerticalAlignment(Element.ALIGN_MIDDLE);
	     c3.setColspan(3);
	     tabella3.addCell(c3);

	     
	     
		 // Seconda riga tabella3
	     c3 = new PdfPCell(new Paragraph("e) Impianto", FONT_HELVETICA_8));
		 tabella3.addCell(c3);
	     
		 c3 = new PdfPCell(new Paragraph("Data prima installazione:", FONT_HELVETICA_8));
		 //c3.setVerticalAlignment(Element.ALIGN_MIDDLE);
	     //c3.setColspan(2);
	     tabella3.addCell(c3);
	     
	     
	     c3 = new PdfPCell(new Paragraph("Potenze termiche nominali totali:", FONT_HELVETICA_8));
		 //c3.setVerticalAlignment(Element.ALIGN_MIDDLE);
	     c3.setColspan(2);
	     tabella3.addCell(c3);
	     
	     c3 = new PdfPCell(new Paragraph("al focolare "+VAR+" (kW)", FONT_HELVETICA_8));
		 //c3.setVerticalAlignment(Element.ALIGN_MIDDLE);
	     //c3.setColspan(2);
	     tabella3.addCell(c3);
	     
	     c3 = new PdfPCell(new Paragraph("Utile "+VAR+" (kW)", FONT_HELVETICA_8));
		 //c3.setVerticalAlignment(Element.ALIGN_MIDDLE);
	     //c3.setColspan(2);
	     tabella3.addCell(c3);
		 
	     
	     
		 // Terza riga tabella3
	     c3 = new PdfPCell(new Paragraph("f) Ubicazione", FONT_HELVETICA_8));
		 c3.setVerticalAlignment(Element.ALIGN_MIDDLE);
	     c3.setRowspan(2);
	     tabella3.addCell(c3);

	     c3 = new PdfPCell(new Paragraph("Comune: "+VAR, FONT_HELVETICA_8));
		 //c3.setVerticalAlignment(Element.ALIGN_MIDDLE);
	     c3.setColspan(2);
	     tabella3.addCell(c3);
	     
	     
	     c3 = new PdfPCell(new Paragraph("Localita': "+VAR, FONT_HELVETICA_8));
		 //c3.setVerticalAlignment(Element.ALIGN_MIDDLE);
	     c3.setColspan(3);
	     tabella3.addCell(c3);
	     
	     
	     c3 = new PdfPCell(new Paragraph("Indirizzo: "+VAR, FONT_HELVETICA_8));
		 //c3.setVerticalAlignment(Element.ALIGN_MIDDLE);
	     c3.setColspan(5);
	     tabella3.addCell(c3);
	     
	     
	     
		 // Quarta riga tabella3
	     c3 = new PdfPCell(new Paragraph("f1)Dati cat.", FONT_HELVETICA_8));
		 //c3.setVerticalAlignment(Element.ALIGN_MIDDLE);
	     //c3.setRowspan(2);
	     tabella3.addCell(c3);

	     
	     
		 Paragraph p3 = new Paragraph("", FONT_HELVETICA_8);
		 p3.add("Sezione: ");
		 aggiungiTesto(p3, VAR, 20);
		 p3.add("Foglio: ");
		 aggiungiTesto(p3, VAR, 20);
		 p3.add("Particella: ");
		 aggiungiTesto(p3, VAR, 20);
		 p3.add("Subalterno: ");
		 aggiungiTesto(p3, VAR, 20);
		 
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
		 aggiungiTesto(p3, VAR, 50);
		 p3.add("PDR: ");
		 p3.add(VAR);
		 
	     c3 = new PdfPCell(p3);
	     c3.setColspan(5);
	     tabella3.addCell(c3);


	     
	     
		 // Quinta riga tabella3
	     c3 = new PdfPCell(new Paragraph("g) Responsabile", FONT_HELVETICA_8));
		 //c3.setVerticalAlignment(Element.ALIGN_MIDDLE);
	     //c3.setRowspan(2);
	     tabella3.addCell(c3);
	     
		 p3 = new Paragraph("", FONT_HELVETICA_8);
		 aggiungiCheckDopo(p3, "Occupante", false, 40);
		 aggiungiCheckDopo(p3, "Proprietario", true, 40);
		 aggiungiCheckDopo(p3, "Terzo Responsabile", false, 40);
		 aggiungiCheckDopo(p3, "Amministratore di Condominio", true, 40);

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
	     
	     c4 = new PdfPCell(new Paragraph(VAR +" h)", FONT_HELVETICA_8));
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
	     
	     c4 = new PdfPCell(new Paragraph(VAR+" i)", FONT_HELVETICA_8));
	     tabella4.addCell(c4);

		 c4 = new PdfPCell(new Paragraph("Ragione sociale", FONT_HELVETICA_8));
	     tabella4.addCell(c4);

	     c4 = new PdfPCell(new Paragraph(VAR +" h)", FONT_HELVETICA_8));
	     tabella4.addCell(c4);

		 c4 = new PdfPCell(new Paragraph("Ragione sociale", FONT_HELVETICA_8));
	     tabella4.addCell(c4);

	     c4 = new PdfPCell(new Paragraph(VAR +" i)", FONT_HELVETICA_8));
	     tabella4.addCell(c4);

		 c4 = new PdfPCell(new Paragraph("Comune", FONT_HELVETICA_8));
	     tabella4.addCell(c4);

	     c4 = new PdfPCell(new Paragraph(VAR +" h)", FONT_HELVETICA_8));
	     tabella4.addCell(c4);

		 c4 = new PdfPCell(new Paragraph("Comune", FONT_HELVETICA_8));
	     tabella4.addCell(c4);

	     c4 = new PdfPCell(new Paragraph(VAR +" i)", FONT_HELVETICA_8));
	     tabella4.addCell(c4);

	     c4 = new PdfPCell(new Paragraph("Indirizzo", FONT_HELVETICA_8));
	     tabella4.addCell(c4);

	     c4 = new PdfPCell(new Paragraph(VAR +" h)", FONT_HELVETICA_8));
	     tabella4.addCell(c4);

	     c4 = new PdfPCell(new Paragraph("Indirizzo", FONT_HELVETICA_8));
	     tabella4.addCell(c4);

	     c4 = new PdfPCell(new Paragraph(VAR +" i)", FONT_HELVETICA_8));
	     tabella4.addCell(c4);

	     c4 = new PdfPCell(new Paragraph("Telefono /Fax", FONT_HELVETICA_8));
	     tabella4.addCell(c4);

	     c4 = new PdfPCell(new Paragraph(VAR +" h)", FONT_HELVETICA_8));
	     tabella4.addCell(c4);

	     c4 = new PdfPCell(new Paragraph("Telefono /Fax", FONT_HELVETICA_8));
	     tabella4.addCell(c4);

	     c4 = new PdfPCell(new Paragraph(VAR +" i)", FONT_HELVETICA_8));
	     tabella4.addCell(c4);

	     c4 = new PdfPCell(new Paragraph("E-mail", FONT_HELVETICA_8));
	     tabella4.addCell(c4);

	     c4 = new PdfPCell(new Paragraph(VAR +" h)", FONT_HELVETICA_8));
	     tabella4.addCell(c4);

	     c4 = new PdfPCell(new Paragraph("E-mail", FONT_HELVETICA_8));
	     tabella4.addCell(c4);

	     c4 = new PdfPCell(new Paragraph(VAR +" i)", FONT_HELVETICA_8));
	     tabella4.addCell(c4);

	     
		 Paragraph p4 = new Paragraph("", FONT_HELVETICA_8);
		 aggiungiCheckPrima(p4, "C.F.", true, 20);
		 aggiungiCheckPrima(p4, "P.IVA", false);
		 
		 c4 = new PdfPCell(p4);
	     tabella4.addCell(c4);

	     
	     c4 = new PdfPCell(new Paragraph("", FONT_HELVETICA_8));
	     tabella4.addCell(c4);
	     

	     p4 = new Paragraph("", FONT_HELVETICA_8);
		 aggiungiCheckPrima(p4, "C.F.", false, 20);
		 aggiungiCheckPrima(p4, "P.IVA", true);
		 
		 c4 = new PdfPCell(p4);
		 //c4.setVerticalAlignment(Element.ALIGN_MIDDLE);
		 //c4.setRowspan(2);
	     tabella4.addCell(c4);
	     
	     c4 = new PdfPCell(new Paragraph("", FONT_HELVETICA_8));
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
	     
	     c4 = new PdfPCell(new Paragraph(VAR +" j)", FONT_HELVETICA_8));
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
	     
	     c4 = new PdfPCell(new Paragraph(VAR +" k)", FONT_HELVETICA_8));
	     tabella4.addCell(c4);

		 c4 = new PdfPCell(new Paragraph("Ragione sociale", FONT_HELVETICA_8));
	     tabella4.addCell(c4);

	     c4 = new PdfPCell(new Paragraph(VAR +" j)", FONT_HELVETICA_8));
	     tabella4.addCell(c4);

		 c4 = new PdfPCell(new Paragraph("Ragione sociale", FONT_HELVETICA_8));
	     tabella4.addCell(c4);

	     c4 = new PdfPCell(new Paragraph(VAR +" k)", FONT_HELVETICA_8));
	     tabella4.addCell(c4);

		 c4 = new PdfPCell(new Paragraph("Comune", FONT_HELVETICA_8));
	     tabella4.addCell(c4);

	     c4 = new PdfPCell(new Paragraph(VAR +" j)", FONT_HELVETICA_8));
	     tabella4.addCell(c4);

		 c4 = new PdfPCell(new Paragraph("Comune", FONT_HELVETICA_8));
	     tabella4.addCell(c4);

	     c4 = new PdfPCell(new Paragraph(VAR +" k)", FONT_HELVETICA_8));
	     tabella4.addCell(c4);

	     c4 = new PdfPCell(new Paragraph("Indirizzo", FONT_HELVETICA_8));
	     tabella4.addCell(c4);

	     c4 = new PdfPCell(new Paragraph(VAR +" j)", FONT_HELVETICA_8));
	     tabella4.addCell(c4);

	     c4 = new PdfPCell(new Paragraph("Indirizzo", FONT_HELVETICA_8));
	     tabella4.addCell(c4);

	     c4 = new PdfPCell(new Paragraph(VAR +" k)", FONT_HELVETICA_8));
	     tabella4.addCell(c4);

	     c4 = new PdfPCell(new Paragraph("Telefono /Fax", FONT_HELVETICA_8));
	     tabella4.addCell(c4);

	     c4 = new PdfPCell(new Paragraph(VAR +" j)", FONT_HELVETICA_8));
	     tabella4.addCell(c4);

	     c4 = new PdfPCell(new Paragraph("Telefono /Fax", FONT_HELVETICA_8));
	     tabella4.addCell(c4);

	     c4 = new PdfPCell(new Paragraph(VAR +" k)", FONT_HELVETICA_8));
	     tabella4.addCell(c4);

	     c4 = new PdfPCell(new Paragraph("E-mail", FONT_HELVETICA_8));
	     tabella4.addCell(c4);

	     c4 = new PdfPCell(new Paragraph(VAR +" j)", FONT_HELVETICA_8));
	     tabella4.addCell(c4);

	     c4 = new PdfPCell(new Paragraph("E-mail", FONT_HELVETICA_8));
	     tabella4.addCell(c4);

	     c4 = new PdfPCell(new Paragraph(VAR +" k)", FONT_HELVETICA_8));
	     tabella4.addCell(c4);

	     
		 p4 = new Paragraph("", FONT_HELVETICA_8);
		 aggiungiCheckPrima(p4, "P.IVA", false);
		 
		 c4 = new PdfPCell(p4);
	     tabella4.addCell(c4);

	     c4 = new PdfPCell(new Paragraph("", FONT_HELVETICA_8));
	     tabella4.addCell(c4);
	     

	     p4 = new Paragraph("", FONT_HELVETICA_8);
		 aggiungiCheckPrima(p4, "P.IVA", true);
		 
		 c4 = new PdfPCell(p4);
		 //c4.setVerticalAlignment(Element.ALIGN_MIDDLE);
		 //c4.setRowspan(2);
	     tabella4.addCell(c4);
	     
	     c4 = new PdfPCell(new Paragraph("", FONT_HELVETICA_8));
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

	     c5 = new PdfPCell(new Paragraph(VAR, FONT_HELVETICA_8));
	     tabella5.addCell(c5);

		 
		 Paragraph p5 = new Paragraph("Delega   ", FONT_HELVETICA_8);
		 aggiungiCheckPrima(p5, "presente", true, 20);
		 aggiungiCheckPrima(p5, "assente", false);
		 
		 c5 = new PdfPCell(p5);
		 tabella5.addCell(c5);
	     
	     
	     
	     
		 document.add(tabella5); //AGGIUNGO LA TABELLA NEL DOCUMENTO

		 
		 
		 
		 
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
		 private static void aggiungiSpaziVuoti(Paragraph paragraph, int minSpazio) {

			 if (minSpazio != MIN_SPAZIO_NON_PRESENTE)
			 {
				 StringBuffer sb = new StringBuffer();

				 for (int i = 0; i < minSpazio; i++) {
					 
					 sb.append(" ");
				 }

				 paragraph.add(sb.toString());

			 }
			 

		 }
		*/

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
		 
}
