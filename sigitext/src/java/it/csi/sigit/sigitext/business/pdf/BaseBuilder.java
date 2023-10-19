/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitext.business.pdf;

import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.*;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import it.csi.sigit.sigitext.business.be.manager.DbServiceImp;
import it.csi.sigit.sigitext.business.be.manager.ServiceManager;
import it.csi.sigit.sigitext.business.util.Constants;
import it.csi.sigit.sigitext.business.util.ConvertUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import java.awt.*;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseBuilder {

	/**
	 * The chapter font.
	 */

	public static final Logger log = Logger.getLogger(Constants.APPLICATION_CODE + ".business.pdf");
	private static final String IMG_PATH = "/it/csi/sigit/sigitext/business/pdf/assets/img/";
	private static String FONT_PATH = "/it/csi/sigit/sigitext/business/pdf/assets/font/";

	public static float PADDING_LEFT = 10f; //Margine Sx
	public static Font FONT_HELVETICA_11_B = new Font(Font.HELVETICA, 11, Font.BOLD);

	public static Font FONT_HELVETICA_9_B = new Font(Font.HELVETICA, 9, Font.BOLD);
	public static Font FONT_HELVETICA_9_I = new Font(Font.HELVETICA, 9, Font.ITALIC);
	public static Font FONT_HELVETICA_9_B_I = new Font(Font.HELVETICA, 9, Font.BOLD | Font.ITALIC);
	public static Font FONT_HELVETICA_9_B_S = new Font(Font.HELVETICA, 9, Font.BOLD | Font.UNDERLINE);
	public static Font FONT_HELVETICA_8 = new Font(Font.HELVETICA, 8);
	public static Font FONT_HELVETICA_8_B = new Font(Font.HELVETICA, 8, Font.BOLD);
	public static Font FONT_HELVETICA_8_I = new Font(Font.HELVETICA, 8, Font.ITALIC);
	public static Font FONT_HELVETICA_8_B_I = new Font(Font.HELVETICA, 8, Font.BOLD | Font.ITALIC);
	public static Font FONT_HELVETICA_7 = new Font(Font.HELVETICA, 7);
	public static Font FONT_HELVETICA_7_B = new Font(Font.HELVETICA, 7, Font.BOLD);
	public static Font FONT_HELVETICA_6 = new Font(Font.HELVETICA, 6);
	public static Font FONT_HELVETICA_6_B = new Font(Font.HELVETICA, 6, Font.BOLD);
	public static Font FONT_HELVETICA_6_I = new Font(Font.HELVETICA, 6, Font.ITALIC);
	public static Font FONT_HELVETICA_6_GRAY = new Font(Font.HELVETICA, 6, Font.NORMAL, Color.LIGHT_GRAY);
	public static Font FONT_HELVETICA_190_GRAY = new Font(Font.HELVETICA, 190, Font.NORMAL, Color.LIGHT_GRAY);
	public static Font FONT_HELVETICA_18_B = new Font(Font.HELVETICA, 18, Font.BOLD);
	public static Font FONT_HELVETICA_12_B = new Font(Font.HELVETICA, 12, Font.BOLD);
	public static Font FONT_HELVETICA_10 = new Font(Font.HELVETICA, 10);
	//private static Font redFont  = new Font(Font.FontFamily.TIMES_ROMAN, 12,  Font.NORMAL, BaseColor.RED);
	public static Font FONT_HELVETICA_9 = new Font(Font.HELVETICA, 9);
	public static Font FONT_HELVETICA_8_B_S = new Font(Font.HELVETICA, 8, Font.BOLD | Font.UNDERLINE);
	public static Font FONT_HELVETICA_5 = new Font(Font.HELVETICA, 5);
	public static Font FONT_HELVETICA_5_B = new Font(Font.HELVETICA, 5, Font.BOLD);
	private static String CODE_ETA = "\u03B7";
	public static Chunk SYMBOL_ETA = null;
	public static String IMG_LOGO_NAME = "logo.jpg";
	public static String IMG_CHECK_NAME_SI = "check_si.png";
	public static String IMG_CHECK_NAME_NO = "check_no.png";
	public static Image IMG_CHECK_SI = null;
	public static Image IMG_CHECK_NO = null;
	public static Image IMG_LOGO = null;
	public static String DATE_FORMAT = "dd/MM/yyyy";
	public static int MIN_SPAZIO_NON_PRESENTE = 0;
	public static String VAR = "XXXXXXX";
	public static String DATO_NON_PRESENTE = " ";

	public static Color LIGHT_GRAY = new Color(225, 225, 225);
	public DbServiceImp dbServiceImp;
	public ServiceManager serviceManager;

	public DbServiceImp getDbServiceImp() {
		return dbServiceImp;
	}

	public void setDbServiceImp(DbServiceImp dbServiceImp) {
		this.dbServiceImp = dbServiceImp;
	}

	public ServiceManager getServiceManager() {
		return serviceManager;
	}

	public void setServiceManager(ServiceManager serviceManager) {
		this.serviceManager = serviceManager;
	}

	public static String getDataCompleta() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HH_mm_ss");
		return sdf.format(new Date());
	}

	public static Document creaDocumento(boolean isSimulazione) {
		Document document = new Document(PageSize.A4, 10, 10, 10, 10);

		caricaImg();

		return document;
	}

	public static Document creaDocumentoLibretto(boolean isSimulazione) {

		Document document = new Document(PageSize.A4, 10, 10, 50, 50);

		caricaImg();

		return document;
	}

	public static void caricaImg() {
		IMG_LOGO = getImmagineLogo();
		IMG_CHECK_SI = getImmagineCheck(IMG_CHECK_NAME_SI);
		IMG_CHECK_NO = getImmagineCheck(IMG_CHECK_NAME_NO);

		SYMBOL_ETA = getEtaSymbol();
	}

	public static Document creaDocumentoMain() {
		Document document = new Document(PageSize.A4, 10, 10, 10, 10);

		IMG_CHECK_SI = getImmagineCheck(IMG_CHECK_NAME_SI);
		IMG_CHECK_NO = getImmagineCheck(IMG_CHECK_NAME_NO);

		return document;
	}

	public static Image getImmagineCheck(String imgName) {
		Image image = null;
		try {
			log.debug("Cerco l'immagine check");

			image = getImmagine(imgName);

			log.debug("Cerco l'immagine check - TROVATA");

			image.scaleAbsolute(6f, 6f);
		} catch (Exception e) {
			System.out.println("Immagine mancante");

		}
		return image;
	}

	public static Image getImmagineLogo() {
		Image image = null;
		try {

			log.debug("Cerco l'immagine logo");

			image = getImmagine(IMG_LOGO_NAME);

			log.debug("Stampo image: " + image);

			image.scaleAbsolute(90f, 35f);
		} catch (Exception e) {
			System.out.println("Immagine mancante");

		}
		return image;
	}

	private static Image getImmagine(String imgName) {
		Image image = null;
		try {

			log.debug("Cerco l'immagine: " + imgName);

			URL imgURL = BaseBuilder.class.getResource(IMG_PATH + imgName);

			image = Image.getInstance(imgURL);

			log.debug("Stampo image: " + image);

		} catch (Exception e) {
			System.out.println("Immagine mancante");

		}
		return image;
	}

	private static Chunk getEtaSymbol() {
		Chunk chunk = null;
		try {
			Image etaImage = getImmagine("greek_eta.png");
			etaImage.scaleAbsolute(6, 8);
			chunk = new Chunk(etaImage, -1, -2);

		} catch (Exception e) {
			System.out.println("Font mancante\n" + e.getMessage());
		}

		return chunk;
	}

	private static Chunk getFontSymbol(String symbol) {
		Chunk chunk = null;
		try {
			URL fontPath = BaseBuilder.class.getResource(FONT_PATH + "FreeSans.ttf");

			Font f = FontFactory.getFont(fontPath.toString(), BaseFont.IDENTITY_H, true);
			f.setSize(8);

			chunk = new Chunk(symbol, f);

		} catch (Exception e) {
			System.out.println("Font mancante\n" + e.getMessage());
		}

		return chunk;
	}

	/* iText permette di aggiungere metadati al pdf che possono essere
	 * visualizzati in Adobe Reader da File -> Proprietà */
	public static void aggiungiMetaDati(Document document) {
		document.addTitle("Il mio primo PDF");
		document.addSubject("Uso di iText");
		document.addKeywords("Java, PDF, iText");
		document.addAuthor("Mario Rossi");
		document.addCreator("Luigi Bianchi");
	}

	public static void aggiungiCheckSi(Paragraph paragraph, boolean isSelezionato) {
		if (isSelezionato) {
			paragraph.add(new Chunk(IMG_CHECK_SI, 0, 0, true));
		} else {
			paragraph.add(new Chunk(IMG_CHECK_NO, 0, 0, true));
		}
		paragraph.add(" Si  ");
	}

	public static void aggiungiCheckNo(Paragraph paragraph, boolean isSelezionato) {
		if (isSelezionato) {
			paragraph.add(new Chunk(IMG_CHECK_SI, 0, 0, true));
		} else {
			paragraph.add(new Chunk(IMG_CHECK_NO, 0, 0, true));
		}
		paragraph.add(" No  ");
	}

	public static void aggiungiCheckPrimaOld(Paragraph paragraph, String nomeCheck, boolean isSelezionato) {
		if (isSelezionato) {
			paragraph.add(new Chunk(IMG_CHECK_SI, 0, 0, true));
		} else {
			paragraph.add(new Chunk(IMG_CHECK_NO, 0, 0, true));
		}
		paragraph.add(" " + nomeCheck + "  ");
	}

	public static void aggiungiCheckPrima(Paragraph paragraph, String nomeCheck, boolean isSelezionato) {
		aggiungiCheckPrima(paragraph, nomeCheck, isSelezionato, MIN_SPAZIO_NON_PRESENTE);

	}

	public static void aggiungiCheckPrima(Paragraph paragraph, String nomeCheck, boolean isSelezionato, int minSpazio) {

		if (isSelezionato) {
			paragraph.add(new Chunk(IMG_CHECK_SI, 0, 0, true));
		} else {
			paragraph.add(new Chunk(IMG_CHECK_NO, 0, 0, true));
		}

		paragraph.add(" " + nomeCheck);

		aggiungiSpaziVuoti(paragraph, nomeCheck, minSpazio);
	}

	public static void aggiungiCheckDopoOld(Paragraph paragraph, String nomeCheck, boolean isSelezionato) {
		if (isSelezionato) {
			paragraph.add(new Chunk(IMG_CHECK_SI, 0, 0, true));
		} else {
			paragraph.add(new Chunk(IMG_CHECK_NO, 0, 0, true));
		}
		paragraph.add(" " + nomeCheck + "  ");
	}

	public static void aggiungiCheckDopo(Paragraph paragraph, String nomeCheck, boolean isSelezionato) {

		aggiungiCheckDopo(paragraph, nomeCheck, isSelezionato, MIN_SPAZIO_NON_PRESENTE);

	}

	public static void aggiungiCheckDopo(Paragraph paragraph, String nomeCheck, boolean isSelezionato, int minSpazio) {

		paragraph.add(nomeCheck + " ");

		if (isSelezionato) {
			paragraph.add(new Chunk(IMG_CHECK_SI, 0, 0, true));
		} else {
			paragraph.add(new Chunk(IMG_CHECK_NO, 0, 0, true));
		}

		aggiungiSpaziVuoti(paragraph, nomeCheck, minSpazio);
	}

	public static Paragraph aggiungiNumFoglio(int numPagine, String totPagine) {
		Paragraph p3 = new Paragraph("Foglio n° ", FONT_HELVETICA_9_I);
		//p3.add("Foglio n° ");
		aggiungiTesto(p3, ConvertUtil.convertToString(numPagine), 3);
		p3.add(" di ");
		aggiungiTesto(p3, totPagine, 10);

		return p3;
	}

	public static Paragraph aggiungiNumPagina(int numPagine, String totPagine) {

		Font font = new Font(FONT_HELVETICA_6);
		font.setColor(Color.GRAY);

		Paragraph p3 = new Paragraph("Pagina n° ", font);
		//p3.add("Foglio n° ");
		aggiungiTesto(p3, ConvertUtil.convertToString(numPagine), 1);
		p3.add(" di ");
		aggiungiTesto(p3, totPagine, 10);

		return p3;
	}

	public static void aggiungiMinMedMaxFormat(Paragraph paragraph, BigDecimal min, BigDecimal med, BigDecimal max) {

		aggiungiTesto(paragraph, ConvertUtil.convertToString(min), 1);
		paragraph.add(Constants.INTERVAL_SEP_SLASH);

		aggiungiTesto(paragraph, ConvertUtil.convertToString(med), 1);
		paragraph.add(Constants.INTERVAL_SEP_SLASH);

		aggiungiTesto(paragraph, ConvertUtil.convertToString(max), 1);
	}

	public static void aggiungiTesto(Phrase phrase, String testo, int minSpazio, Font font) {

		phrase.add(new Chunk(testo, font));

		aggiungiSpaziVuoti(phrase, testo, minSpazio);

	}

	public static void aggiungiSpazioETesto(Phrase phrase, String testo, int minSpazio, Font font) {

		aggiungiSpaziVuoti(phrase, testo, minSpazio);

		phrase.add(new Chunk(testo, font));
	}

	public static void aggiungiTesto(Paragraph paragraph, String testo, int minSpazio) {

		paragraph.add(testo);

		aggiungiSpaziVuoti(paragraph, testo, minSpazio);
	}

	public static void aggiungiSpazioETesto(Paragraph paragraph, String testo, int minSpazio) {

		aggiungiSpaziVuoti(paragraph, testo, minSpazio);

		paragraph.add(testo);
	}

	public static void aggiungiSpaziVuoti(Phrase phrase, String testo, int minSpazio) {

		testo = StringUtils.trimToEmpty(testo);

		if (minSpazio != MIN_SPAZIO_NON_PRESENTE && testo.length() < minSpazio) {
			StringBuffer sb = new StringBuffer();

			for (int i = testo.length(); i < minSpazio; i++) {

				sb.append(" ");
			}

			phrase.add(sb.toString());

		}

	}

	public static void aggiungiSpaziVuoti(Paragraph paragraph, String testo, int minSpazio) {

		testo = StringUtils.trimToEmpty(testo);

		if (minSpazio != MIN_SPAZIO_NON_PRESENTE && testo.length() < minSpazio) {
			StringBuffer sb = new StringBuffer();

			for (int i = testo.length(); i < minSpazio; i++) {

				sb.append(" ");
			}

			paragraph.add(sb.toString());

		}

	}

	public static void aggiungiSpaziVuoti(Paragraph paragraph, int minSpazio) {

		if (minSpazio != MIN_SPAZIO_NON_PRESENTE) {
			StringBuffer sb = new StringBuffer();

			for (int i = 0; i < minSpazio; i++) {

				sb.append(" ");
			}

			paragraph.add(sb.toString());

		}

	}

	public static void aggiungiSpaziVuoti(Phrase phrase, int minSpazio) {

		if (minSpazio != MIN_SPAZIO_NON_PRESENTE) {
			StringBuffer sb = new StringBuffer();

			for (int i = 0; i < minSpazio; i++) {

				sb.append(" ");
			}

			phrase.add(sb.toString());

		}

	}

	public static void aggiungiPuntini(Paragraph paragraph, int minSpazio) {

		if (minSpazio != MIN_SPAZIO_NON_PRESENTE) {
			StringBuffer sb = new StringBuffer();

			for (int i = 0; i < minSpazio; i++) {

				sb.append(".");
			}

			paragraph.add(sb.toString());

		}

	}

	public static void aggiungiLineaVuota(Paragraph paragraph, int number) {
		for (int i = 0; i < number; i++) {
			paragraph.add(new Paragraph(" "));
		}
	}

	public static void gestDebug(boolean isSimulazione, String message) {
		if (!isSimulazione) {
			log.debug(message);
		} else {
			System.out.println(message);

		}
	}

	public static void gestError(boolean isSimulazione, String message, Throwable e) {
		if (!isSimulazione) {
			log.error(message, e);
		} else {
			System.err.println("Exception: " + e);
			e.printStackTrace();

		}
	}

	public static PdfPTable initializeTable(float[] columWidths) {

		PdfPTable tabella = new PdfPTable(columWidths);
		//Definisco la tabella con il 100%, il bordo,e il margine sinis
		tabella.setSpacingBefore(8);

		tabella.setWidthPercentage(100);
		tabella.getDefaultCell().setBorder(1);

		tabella.getDefaultCell().setPaddingLeft(PADDING_LEFT);
		tabella.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);

		return tabella;

	}

	public static PdfPTable addEmptyCell(PdfPTable tabella, int colNumber, int border, Color backgroundColor) {
		PdfPCell cell = new PdfPCell(new Paragraph());
		cell.setBorder(border);
		cell.setColspan(colNumber);
		if (backgroundColor != null) {
			cell.setBackgroundColor(backgroundColor);
		}
		tabella.addCell(cell);
		return tabella;
	}

	public static Document creaDocumentoRee() {
		Document document = new Document(PageSize.A4, 10, 10, 50, 10);
		caricaImg();
		return document;
	}

	public static PdfPTable initializeInternalTable(float[] columWidths) {
		PdfPTable tabella = new PdfPTable(columWidths);

		tabella.getDefaultCell().setBorderWidth((float) 0.8);
		tabella.getDefaultCell().setBorder(Rectangle.BOX);
		tabella.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
		tabella.getDefaultCell().setMinimumHeight(10);

		return tabella;

	}

	public static PdfPCell initializeInternalCell(Phrase phrase) {
		PdfPCell cell = new PdfPCell(phrase);
		cell.setBorderWidth((float) 0.8);
		cell.setBorder(Rectangle.BOX);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);

		return cell;
	}

	public static PdfPTable addEmptyCell(PdfPTable tabella, int colNumber, int border) {
		return addEmptyCell(tabella, colNumber, border, null);
	}
}
