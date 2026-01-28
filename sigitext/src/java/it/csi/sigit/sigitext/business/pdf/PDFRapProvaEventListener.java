package it.csi.sigit.sigitext.business.pdf;

import java.awt.Color;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.ExceptionConverter;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.ColumnText;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfPageEventHelper;
import com.lowagie.text.pdf.PdfTemplate;
import com.lowagie.text.pdf.PdfWriter;

import it.csi.sigit.sigitext.business.util.Constants;


public class PDFRapProvaEventListener  extends PdfPageEventHelper{

	public static Font FONT = new Font(Font.HELVETICA, 8);
	//Image imgLogo = null;
	
	PdfTemplate total;
	boolean isBozza;
	boolean isHeader = false;
	String numeroRee = null;
	String idTipoDocumento = null;
	
	//String header = "PROVA";

	public PDFRapProvaEventListener(boolean isBozza)
	{
		this.isBozza = isBozza;
	}

	public PDFRapProvaEventListener(String idTipoDocumento, String numeroRee, boolean isBozza, boolean isHeader)
	{
		this.idTipoDocumento = idTipoDocumento;
		this.numeroRee = numeroRee;
		this.isBozza = isBozza;
		this.isHeader = isHeader;
	}
	
	
	public boolean isBozza() {
		return isBozza;
	}

	public void setBozza(boolean isBozza) {
		this.isBozza = isBozza;
	}

    public void onOpenDocument(PdfWriter writer, Document document) {

        total = writer.getDirectContent().createTemplate(30, 16);
    }

    // pag 1 di 1 messo nell'header sopra
    public void onEndPage(PdfWriter writer, Document document)
    {
    	if (isBozza)
    	{
    		PdfContentByte canvas = writer.getDirectContentUnder();
    		Phrase watermark = new Phrase("BOZZA", new Font(Font.HELVETICA, 190, Font.NORMAL, Color.LIGHT_GRAY));
    		//ColumnText.showTextAligned(canvas, Element.ALIGN_CENTER, watermark, 337, 500, 45);
    		ColumnText.showTextAligned(canvas, Element.ALIGN_CENTER, watermark, 337, 400, 45);
    	}

    	if (isHeader)
    	{
    		PdfPTable table = new PdfPTable(3);
    		try {


    			// set defaults
    			table.setWidths(new int[]{24, 24, 2});

    			//table.setWidthPercentage(100);
    			table.setTotalWidth(575);
    			table.setLockedWidth(true);
    			//table.getDefaultCell().setFixedHeight(10);
    			table.getDefaultCell().setBorder(Rectangle.NO_BORDER);
    			//table.getDefaultCell().setBorder(Rectangle.BOX);
    			table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_RIGHT);


    			Paragraph par = new Paragraph();  
    			// Col1
    			try{ 
    				par.setAlignment(Paragraph.ALIGN_LEFT);
    				par.add(new Chunk(BaseBuilder.IMG_LOGO, 0, 0,true));
    			}catch(Exception e){  
    				System.out.println("Immagine mancante");
    			}

    			PdfPCell cellCol1 = new PdfPCell(par);
    			cellCol1.setBorder(Rectangle.NO_BORDER);
    			table.addCell(cellCol1);

    			Phrase phrase = new Phrase();
    			phrase.add(new Chunk (String.format("Pagina° %d di", writer.getPageNumber()), BaseBuilder.FONT_HELVETICA_6_GRAY));
    			phrase.add(new Chunk ("\n\nNumero REE ", BaseBuilder.FONT_HELVETICA_9_B));
    			phrase.add(new Chunk (numeroRee, BaseBuilder.FONT_HELVETICA_9_B_S));
    			phrase.add(new Chunk ("            "));
    			phrase.add(new Chunk ("ALLEGATO ", BaseBuilder.FONT_HELVETICA_9_B));

    			String descTipoDocumento = "";
    			if(Constants.ALLEGATO_TIPO_1.equalsIgnoreCase(idTipoDocumento)){
    				descTipoDocumento = "II";
    			}else if(Constants.ALLEGATO_TIPO_2.equalsIgnoreCase(idTipoDocumento)){
    				descTipoDocumento = "III";
    			}else if(Constants.ALLEGATO_TIPO_3.equalsIgnoreCase(idTipoDocumento)){
    				descTipoDocumento = "IV";
    			}else if(Constants.ALLEGATO_TIPO_4.equalsIgnoreCase(idTipoDocumento)){
    				descTipoDocumento = "V";
    			}
    			
    			// SE ALLEGATO II (da fare l'IF)
    			phrase.add(new Chunk (descTipoDocumento, BaseBuilder.FONT_HELVETICA_9_B));

    			phrase.add(new Chunk ("    (Art. 2)", BaseBuilder.FONT_HELVETICA_6_GRAY));

    			PdfPCell cellCol2 = new PdfPCell(phrase);
    			cellCol2.setHorizontalAlignment(Paragraph.ALIGN_RIGHT);
    			cellCol2.setBorder(Rectangle.NO_BORDER);
    			table.addCell(cellCol2);

    			//        	phrase = new Phrase("", font);
    			//        	phrase.add(String.format("Pagina° %d di", writer.getPageNumber()));
    			//        	PdfPCell cellCol3 = new PdfPCell(phrase);
    			//        	cellCol3.setHorizontalAlignment(Paragraph.ALIGN_RIGHT);
    			//        	cellCol3.setColspan(2);
    			//        	//cellCol3.setBorder(Rectangle.NO_BORDER);
    			//        	table.addCell(cellCol3);
    			//table.addCell(cellCol3);

    			PdfPCell cell = new PdfPCell(Image.getInstance(total));
    			cell.setBorder(Rectangle.NO_BORDER);
    			table.addCell(cell);

    			/*
    			 * public float writeSelectedRows(
                               int rowStart,
                               int rowEnd,
                               float xPos,
                               float yPos,
                               PdfContentByte canvas)
               Parameters:
				rowStart - the first row to be written, zero index
				rowEnd - the last row to be written + 1. If it is -1 all the rows to the end are written
				xPos - the x write coordinate
				yPos - the y write coordinate
				canvas - the PdfContentByte where the rows will be written to
			  Returns:
				the y coordinate position of the bottom of the last row
    			 */
    			//table.writeSelectedRows(0, -1, 10, 803, writer.getDirectContent());
    			table.writeSelectedRows(0, -1, 10, 833, writer.getDirectContent());
    		} catch(DocumentException de) {
    			throw new ExceptionConverter(de);
    		} 
    	}
    }
    
    // pag 1 di 1 messo nell'header sotto (occupa piu' spazio)
	public void onEndPageOK(PdfWriter writer, Document document)
	{
		if (isBozza)
		{
			PdfContentByte canvas = writer.getDirectContentUnder();
			Phrase watermark = new Phrase("BOZZA", BaseBuilder.FONT_HELVETICA_190_GRAY);
			//ColumnText.showTextAligned(canvas, Element.ALIGN_CENTER, watermark, 337, 500, 45);
			ColumnText.showTextAligned(canvas, Element.ALIGN_CENTER, watermark, 337, 400, 45);
		}
		
		PdfPTable table = new PdfPTable(3);
        try {
            // set defaults
        	table.setWidths(new int[]{24, 24, 2});
        	
        	//table.setWidthPercentage(100);
        	table.setTotalWidth(575);
        	table.setLockedWidth(true);
        	//table.getDefaultCell().setFixedHeight(10);
        	table.getDefaultCell().setBorder(Rectangle.NO_BORDER);
        	//table.getDefaultCell().setBorder(Rectangle.BOX);
        	table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_RIGHT);


        	Paragraph par = new Paragraph();  
        	// Col1
        	try{ 
        		//image=  Image.getInstance("D:/progetti/eclipse oxygen/energia/sigit_sigitwebn/src/web/sigitwebn/img/logo.jpg");
        		//image.scaleAbsolute(70f, 35f); 
        		par.setAlignment(Paragraph.ALIGN_LEFT);
        		par.add(new Chunk(BaseBuilder.IMG_LOGO, 0, 0,true));
        	}catch(Exception e){  
        		System.out.println("Immagine mancante");
        	}

        	PdfPCell cellCol1 = new PdfPCell(par);
        	//PdfPCell cellCol1 = new PdfPCell(new Phrase("Prova"));
        	//cellCol1.setRowspan(2);
        	cellCol1.setBorder(Rectangle.NO_BORDER);
        	table.addCell(cellCol1);
        	//table.set

        	Phrase phrase = new Phrase();
        	phrase.add(new Chunk ("Bollino ", BaseBuilder.FONT_HELVETICA_9_B));
        	phrase.add(new Chunk ("XX-XXXXXXXX", BaseBuilder.FONT_HELVETICA_9_B_S));
        	phrase.add(new Chunk ("            "));
        	phrase.add(new Chunk ("ALLEGATO ", BaseBuilder.FONT_HELVETICA_9_B));

        	//xx

        	// SE ALLEGATO II (da fare l'IF)
        	phrase.add(new Chunk ("II", BaseBuilder.FONT_HELVETICA_9_B));

//        	Font font = new Font(BaseBuilder.FONT_HELVETICA_6);
//        	font.setColor(Color.GRAY);		 
        	phrase.add(new Chunk ("    (Art. 2)", BaseBuilder.FONT_HELVETICA_6_GRAY));
        	//phrase.add(String.format("\nPage %d of", writer.getPageNumber()));

        	PdfPCell cellCol2 = new PdfPCell(phrase);
        	cellCol2.setHorizontalAlignment(Paragraph.ALIGN_RIGHT);
        	cellCol2.setColspan(2);
        	cellCol2.setBorder(Rectangle.NO_BORDER);
        	table.addCell(cellCol2);

        	phrase = new Phrase("", BaseBuilder.FONT_HELVETICA_6_GRAY);
        	phrase.add(String.format("Pagina° %d di", writer.getPageNumber()));
        	PdfPCell cellCol3 = new PdfPCell(phrase);
        	cellCol3.setHorizontalAlignment(Paragraph.ALIGN_RIGHT);
        	cellCol3.setColspan(2);
        	cellCol3.setBorder(Rectangle.NO_BORDER);
        	table.addCell(cellCol3);
        	//table.addCell(cellCol3);

        	PdfPCell cell = new PdfPCell(Image.getInstance(total));
        	//cell.setBorder(Rectangle.BOTTOM);
        	cell.setBorder(Rectangle.NO_BORDER);
        	table.addCell(cell);

            /*
             * public float writeSelectedRows(
                               int rowStart,
                               int rowEnd,
                               float xPos,
                               float yPos,
                               PdfContentByte canvas)
               Parameters:
				rowStart - the first row to be written, zero index
				rowEnd - the last row to be written + 1. If it is -1 all the rows to the end are written
				xPos - the x write coordinate
				yPos - the y write coordinate
				canvas - the PdfContentByte where the rows will be written to
			  Returns:
				the y coordinate position of the bottom of the last row
             */
            //table.writeSelectedRows(0, -1, 10, 803, writer.getDirectContent());
            table.writeSelectedRows(0, -1, 10, 833, writer.getDirectContent());
        } catch(DocumentException de) {
            throw new ExceptionConverter(de);
        } 
	}

	public void onCloseDocument(PdfWriter writer, Document document) {
		
//    	Font font = new Font(BaseBuilder.FONT_HELVETICA_6);
//    	font.setColor(Color.GRAY);	
    	// Se c'è l'header setto il numero di pagina
    	if (isHeader)
    	{
			/*
			public static void showTextAligned(PdfContentByte canvas,
			                                   int alignment,
			                                   Phrase phrase,
			                                   float x,
			                                   float y,
			                                   float rotation)
				Shows a line of text. Only the first line is written.
			Parameters:
				canvas - where the text is to be written to
				alignment - the alignment
				phrase - the Phrase with the text
				x - the x reference position
				y - the y reference position
				rotation - the rotation to be applied in degrees counterclockwise
			 */
			
			ColumnText.showTextAligned(total, Element.ALIGN_LEFT,
					new Phrase(String.valueOf(writer.getPageNumber() - 1), BaseBuilder.FONT_HELVETICA_6_GRAY), 2, 8, 0);
    	}
	}
	
}
