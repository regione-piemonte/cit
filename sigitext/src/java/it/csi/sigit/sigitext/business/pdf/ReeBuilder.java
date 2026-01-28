/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitext.business.pdf;

import java.awt.Color;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitDFluidoDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitDUnitaMisuraDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTAllegatoDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTConsumoTipo1BDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTDettTipo1Dto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTDettTipo2Dto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTDettTipo3Dto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTDettTipo4Dto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTImpiantoDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTPersonaFisicaDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTPersonaGiuridicaDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTRappTipo1Dto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTRappTipo2Dto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTRappTipo3Dto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTRappTipo4Dto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTTrattH2ODto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTUnitaImmobiliareDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitVSk4CgDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitVSk4GfDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitVSk4GtDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitVSk4ScDto;
import it.csi.sigit.sigitext.business.dao.util.Constants;
import it.csi.sigit.sigitext.business.util.ConvertUtil;
import it.csi.sigit.sigitext.business.util.GenericUtil;
import it.csi.sigit.sigitext.dto.index.DettaglioDocumento;
import it.csi.sigit.sigitext.dto.sigitext.DettaglioAllegato;

public class ReeBuilder extends BaseBuilder {

	public static void main(String[] args) {
		FileOutputStream fileStream = null;
		try {
			ReeBuilder ispezione = new ReeBuilder();

			DettaglioDocumento dettaglioDocumento = ispezione.generaReeGtB(null, true, true);

			byte[] libretto = dettaglioDocumento.getFile();

			String FILE = "C:/Repo/CSI/sigit/sigit_sigitwebn/src/java/test/sigitwebn/";
			fileStream = new FileOutputStream(FILE + getDataCompleta() + "_Test_Ree_Tipo1B.pdf");

			fileStream.write(libretto);
			fileStream.flush();
			fileStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(fileStream!=null) {
				try {
					fileStream.close();
				} catch (IOException e) {					
					e.printStackTrace();
				}
			}
		}
	}

	//REE TIPO 1 - GT (Gruppi Termici)

	public DettaglioDocumento generaReeGt(DettaglioAllegato dettAllegato, boolean isSimul, boolean isBozza) {
		gestDebug(isSimul, "generaReeGt - START");

		DettaglioDocumento result = new DettaglioDocumento();

		try {
			Integer idAllegato = null;
			SigitTImpiantoDto impianto = null;
			DatiGTCommon allegato1Common = null;
			SigitTAllegatoDto allegato = null;
			List<SigitTUnitaImmobiliareDto> unitaImmobiliareList = null;

			List<SigitVSk4GtDto> allegatoCompGtList = null;
			List<SigitTDettTipo1Dto> tDettTipo1List = null;
			SigitTPersonaGiuridicaDto pgManut = null;
			SigitTRappTipo1Dto rappTipo1Dto = null;

			if (!isSimul) {
				idAllegato = dettAllegato.getIdAllegato();
				allegato1Common = getServiceManager().cercaDatiAllegato1Common(dettAllegato);
				allegato = allegato1Common.getAllegatoDto();
				unitaImmobiliareList = allegato1Common.getUnitaImmobiliareList();
				allegatoCompGtList = allegato1Common.getSk4GtDtoList();

				rappTipo1Dto = getDbServiceImp().cercaTRappTipo1ById(allegato.getIdAllegato());

				pgManut = getDbServiceImp().cercaTPersonaGiuridicaById(ConvertUtil.convertToInteger(dettAllegato.getPersonaGiuridica().getIdPersonaGiuridica()));
			} else {
				allegato1Common = new DatiGTCommon();

				impianto = new SigitTImpiantoDto();

				allegatoCompGtList = new ArrayList<SigitVSk4GtDto>();

				SigitVSk4GtDto sk4GtDto = new SigitVSk4GtDto();
				sk4GtDto.setDesMarca("VAILLANT");
				sk4GtDto.setModello("VMW 346/5 H ECOTEC PLUS");
				sk4GtDto.setMatricola("211550001001869410001006849N2");
				allegatoCompGtList.add(sk4GtDto);

				allegato1Common.setImpiantoDto(new SigitTImpiantoDto());
				allegato1Common.setAllegatoDto(new SigitTAllegatoDto());
				//allegato1Common.setPersonaFisicaDto(new SigitTPersonaFisicaDto());

				SigitTPersonaGiuridicaDto pg = new SigitTPersonaGiuridicaDto();
				pg.setDenominazione("M;i aimpresa");
				allegato1Common.setPersonaGiuridicaDto(pg);

				allegato1Common.setTerzoResp(false);
				allegato1Common.setRuolo(Constants.ID_RUOLO_OCCUPANTE);

				allegato1Common.setDettaglioTrattAcquaDto(new SigitTTrattH2ODto());
				allegato = new SigitTAllegatoDto();
				allegato.setFkTipoDocumento(ConvertUtil.convertToBigDecimal(Constants.ALLEGATO_TIPO_1));
				allegato.setAPotenzaTermicaNominaleMax(new BigDecimal(15));
				allegato.setBFlgDichiarConform(BigDecimal.ONE);
				allegato.setBFlgLibrettoUso(BigDecimal.ONE);
				allegato.setBFlgLibImp(BigDecimal.ZERO);
				allegato.setBFlgLibCompl(BigDecimal.ZERO);

				allegato1Common.setAllegatoDto(allegato);
				pgManut = new SigitTPersonaGiuridicaDto();
				pgManut.setDenominazione("PROVA S.p.A.");
				pgManut.setCodiceFiscale("CTSMCC74S50L219C");

				pgManut.setProvincia("TO");
				pgManut.setComune("Torino");
				pgManut.setIndirizzoSitad("Corso Tazzoli");
				pgManut.setCivico("215");
				rappTipo1Dto = new SigitTRappTipo1Dto();
				unitaImmobiliareList = new ArrayList<SigitTUnitaImmobiliareDto>();
				unitaImmobiliareList.add(new SigitTUnitaImmobiliareDto());
			}

			Document document = creaDocumentoRee();
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			PdfWriter writer = PdfWriter.getInstance(document, outputStream);

			gestDebug(isSimul, "generaReeGt - PASSO 1");

			PDFReeEventListener event = new PDFReeEventListener(ConvertUtil.convertToString(allegato.getFkTipoDocumento()), ConvertUtil.formattaSiglaBollino(allegato.getFkNumeroBollino()), isBozza, true);

			writer.setPageEvent(event);

			document.open();

			gestDebug(isSimul, "generaReeGt - PASSO 2");
			gestDebug(isSimul, "generaReeGt - PASSO 3");
			gestDebug(isSimul, "generaReeGt - PASSO 4");

			addCodDocPerFirma(document, ConvertUtil.convertToString(idAllegato));
			Paragraph par = new Paragraph("RAPPORTO DI CONTROLLO DI EFFICIENZA ENERGETICA TIPO 1 (gruppi termici)", FONT_HELVETICA_8_B);
			par.setAlignment(Element.ALIGN_CENTER);
			document.add(par);

			aggiungiDatiIdentificativi(document, allegato1Common.getImpiantoDto(), allegato1Common.getAllegatoDto(), unitaImmobiliareList);

			aggiungiResponsabileEManutentore(document, allegato1Common.getPersonaFisicaDto(), allegato1Common.getPersonaGiuridicaDto(), allegato1Common.getRuolo(), allegato1Common.isTerzoResp(), pgManut);

			aggiungiDocumentazioneCorredo(document, allegato);

			aggiungiTrattamentoAcquaGt(document, rappTipo1Dto, allegato1Common.getDettaglioTrattAcquaDto());

			aggiungiControlloImpiantoGt(document, rappTipo1Dto);

			for (SigitVSk4GtDto vSk4GtDto : allegatoCompGtList) {

				if (!isSimul) {
					tDettTipo1List = getDbServiceImp().getDettTipo1(ConvertUtil.convertToString(vSk4GtDto.getCodiceImpianto()), ConvertUtil.convertToInteger(vSk4GtDto.getProgressivo()), ConvertUtil.convertToString(idAllegato));
				} else {
					tDettTipo1List = new ArrayList<SigitTDettTipo1Dto>();

					SigitTDettTipo1Dto tDettTipo1 = new SigitTDettTipo1Dto();

					tDettTipo1.setEBacharachMin(new BigDecimal(10));
					tDettTipo1.setEBacharachMed(new BigDecimal(20));
					tDettTipo1.setEBacharachMax(new BigDecimal(30));

					tDettTipo1List.add(tDettTipo1);

					tDettTipo1List.add(new SigitTDettTipo1Dto());

				}
				// Passo il primo elemento del dettaglio, mi servono solo i dati generali che sono comuni a tutte le righe
				aggiungiControlloVerificaGt(document, tDettTipo1List.get(0), vSk4GtDto);

				aggiungiModuloTermicoGt(document, tDettTipo1List);

			}

			aggiungiCheckListGt(document, rappTipo1Dto);

			aggiungiConclusione(document, allegato);

			outputStream.flush();
			if (document.isOpen())
				document.close();
			outputStream.close();

			gestDebug(isSimul, "generaReeGt - PASSO 13");

			byte[] thePdfIText = outputStream.toByteArray();

			gestDebug(isSimul, "generaReeGt - PASSO 14");

			result.setFile(thePdfIText);
			result.setNomeDocumento("ReeGT_IText.pdf");
		} catch (DocumentException e) {
			// TODO: handle exception
			gestError(isSimul, "DocumentException", e);

		} catch (Exception e) {
			// TODO: handle exception
			gestError(isSimul, "Exception", e);

		}

		gestDebug(isSimul, "generaIspezione - END");

		return result;

	}

	public DettaglioDocumento generaReeGtB(DettaglioAllegato dettAllegato, boolean isSimul, boolean isBozza) {
		gestDebug(isSimul, "generaReeGtB - START");

		DettaglioDocumento result = new DettaglioDocumento();

		try {
			String idAllegato = null;
			SigitTImpiantoDto impianto = null;
			DatiGTCommon allegato1Common = null;
			SigitTAllegatoDto allegato = null;
			List<SigitTUnitaImmobiliareDto> unitaImmobiliareList = null;

			List<SigitVSk4GtDto> allegatoCompGtList = null;
			List<SigitTDettTipo1Dto> tDettTipo1List = null;
			SigitTPersonaGiuridicaDto pgManut = null;
			SigitTRappTipo1Dto rappTipo1Dto = null;
			List<SigitTConsumoTipo1BDto> consumiAcquaReintegro = new ArrayList<SigitTConsumoTipo1BDto>();
			List<SigitTConsumoTipo1BDto> consumiCombustibile = new ArrayList<SigitTConsumoTipo1BDto>();

			if (!isSimul) {
				idAllegato = ConvertUtil.convertToString(dettAllegato.getIdAllegato());
				allegato1Common = getServiceManager().cercaDatiAllegato1Common(dettAllegato);
				allegato = allegato1Common.getAllegatoDto();
				unitaImmobiliareList = allegato1Common.getUnitaImmobiliareList();
				allegatoCompGtList = allegato1Common.getSk4GtDtoList();
				rappTipo1Dto = getDbServiceImp().cercaTRappTipo1ById(allegato.getIdAllegato());
				pgManut = getDbServiceImp().cercaTPersonaGiuridicaById(ConvertUtil.convertToInteger(dettAllegato.getPersonaGiuridica().getIdPersonaGiuridica()));
				BigDecimal idAllegatoBigDecimal = ConvertUtil.convertToBigDecimal(idAllegato);
				consumiAcquaReintegro = getDbServiceImp().findConsumiTipo1ByIdAllegatoIdTipoConsumo(idAllegatoBigDecimal, Constants.ID_TIPO_CONSUMO_1B_ACQUA_REINTEGRO);
				consumiCombustibile = getDbServiceImp().findConsumiTipo1ByIdAllegatoIdTipoConsumo(idAllegatoBigDecimal, Constants.ID_TIPO_CONSUMO_1B_CONSUMO_BIOMASSA);
			} else {
				allegato1Common = new DatiGTCommon();

				impianto = new SigitTImpiantoDto();

				allegatoCompGtList = new ArrayList<SigitVSk4GtDto>();

				SigitVSk4GtDto sk4GtDto = new SigitVSk4GtDto();
				sk4GtDto.setDesMarca("");
				sk4GtDto.setModello("");
				sk4GtDto.setMatricola("");
				allegatoCompGtList.add(sk4GtDto);

				allegato1Common.setImpiantoDto(new SigitTImpiantoDto());
				allegato1Common.setAllegatoDto(new SigitTAllegatoDto());

				SigitTPersonaGiuridicaDto pg = new SigitTPersonaGiuridicaDto();
				pg.setDenominazione("");
				allegato1Common.setPersonaGiuridicaDto(pg);

				allegato1Common.setTerzoResp(false);

				allegato1Common.setDettaglioTrattAcquaDto(new SigitTTrattH2ODto());
				allegato = new SigitTAllegatoDto();
				allegato.setFkTipoDocumento(ConvertUtil.convertToBigDecimal(Constants.ALLEGATO_TIPO_1));

				allegato1Common.setAllegatoDto(allegato);
				pgManut = new SigitTPersonaGiuridicaDto();
				pgManut.setDenominazione("");
				pgManut.setCodiceFiscale("");

				pgManut.setProvincia("");
				pgManut.setComune("");
				pgManut.setIndirizzoSitad("");
				pgManut.setCivico("");
				rappTipo1Dto = new SigitTRappTipo1Dto();
				SigitTUnitaImmobiliareDto unitaImmobiliarePrincipale = new SigitTUnitaImmobiliareDto();
				unitaImmobiliareList = new ArrayList<SigitTUnitaImmobiliareDto>();
				unitaImmobiliarePrincipale.setFlgPrincipale(BigDecimal.ONE);
				unitaImmobiliareList.add(unitaImmobiliarePrincipale);
			}

			Document document = creaDocumentoRee();
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			PdfWriter writer = PdfWriter.getInstance(document, outputStream);

			PDFReeEventListener event = new PDFReeEventListener(ConvertUtil.convertToString(allegato.getFkTipoDocumento()), ConvertUtil.formattaSiglaBollino(allegato.getFkNumeroBollino()), isBozza, true);
			writer.setPageEvent(event);

			document.open();
			addCodDocPerFirma(document, idAllegato);
			Paragraph par = new Paragraph("RAPPORTO DI CONTROLLO DI EFFICIENZA ENERGETICA TIPO 1B (gruppi termici a biomassa combustibile)", FONT_HELVETICA_8_B);
			par.setAlignment(Element.ALIGN_CENTER);
			document.add(par);

			aggiungiDatiIdentificativi(document, allegato1Common.getImpiantoDto(), allegato1Common.getAllegatoDto(), unitaImmobiliareList, true);

			aggiungiResponsabileEManutentore(document, allegato1Common.getPersonaFisicaDto(), allegato1Common.getPersonaGiuridicaDto(), allegato1Common.getRuolo(), allegato1Common.isTerzoResp(), pgManut);

			aggiungiDocumentazioneCorredo(document, allegato);

			aggiungiTrattamentoAcquaGt(document, rappTipo1Dto, allegato1Common.getDettaglioTrattAcquaDto());

			aggiungiConsumoAcquaGtB(document, consumiAcquaReintegro);

			aggiungiControlloImpiantoGt(document, rappTipo1Dto, true);

			for (SigitVSk4GtDto vSk4GtDto : allegatoCompGtList) {

				if (!isSimul) {
					tDettTipo1List = getDbServiceImp().getDettTipo1(ConvertUtil.convertToString(vSk4GtDto.getCodiceImpianto()), ConvertUtil.convertToInteger(vSk4GtDto.getProgressivo()), idAllegato);
				} else {
					tDettTipo1List = new ArrayList<SigitTDettTipo1Dto>();

					SigitTDettTipo1Dto tDettTipo1 = new SigitTDettTipo1Dto();

					tDettTipo1List.add(tDettTipo1);
				}
				// Passo il primo elemento del dettaglio, mi servono solo i dati generali che sono comuni a tutte le righe
				aggiungiControlloVerificaGtB(document, tDettTipo1List.get(0), vSk4GtDto, rappTipo1Dto);
				aggiungiConsumoCombustibileGtB(document, consumiCombustibile);
				aggiungiModuloTermicoGtB(document, tDettTipo1List);
			}

			aggiungiCheckListGt(document, rappTipo1Dto);

			aggiungiConclusione(document, allegato);

			outputStream.flush();
			if (document.isOpen())
				document.close();
			outputStream.close();

			byte[] thePdfIText = outputStream.toByteArray();

			result.setFile(thePdfIText);
			result.setNomeDocumento("ReeGT_B_IText.pdf");
		} catch (DocumentException e) {
			gestError(isSimul, "DocumentException", e);
		} catch (Exception e) {
			gestError(isSimul, "Exception", e);
		}

		gestDebug(isSimul, "generaReeGtB - END");

		return result;

	}

	/***METODI SPECIFICI REE TIPO 1 - GT (Gruppi termici) ***/

	private static void aggiungiModuloTermicoGt(Document document, List<SigitTDettTipo1Dto> tDettTipo1List) throws DocumentException {

		log.debug("[ReeBuilder] - aggiungiModuloTermicoGt - start");


		//Suddivido il foglio in sezioni, cioè in questo caso, un foglio 100% viene diviso in due sezioni, su 8 la prima è larga 2 e l'altra larga 6. Le sezioni possono essere anche di più spartizioni, basta solo aggiungere un valore dopo la virgola es. {3,3,3} suddividiamo in tre sezioni uguali tra di loro.
		float[] columnWidths = { 10, 15, 5, 5, 16, 10, 12, 13, 7, 7 };
		//float[] columnWidths = {10,10,10,10,10};

		PdfPTable tabella = new PdfPTable(columnWidths);
		//Definisco la tabella con il 100%, il bordo,e il margine sinis
		//tabella.setSpacingBefore(8);      

		tabella.setWidthPercentage(100);
		tabella.getDefaultCell().setBorder(1);

		tabella.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);

		tabella.getDefaultCell().setPaddingLeft(PADDING_LEFT);

		PdfPCell cell;

		int listLastElement = tDettTipo1List.size() - 1;
		for (int i = 0; i < tDettTipo1List.size(); i++) {
			SigitTDettTipo1Dto tDettTipo1 = tDettTipo1List.get(i);

			// riga1
			Paragraph paragraph = new Paragraph("Temperatura\nFumi (\u00B0C)", FONT_HELVETICA_7);
			cell = new PdfPCell(paragraph);

			cell.setBorder(Rectangle.LEFT | Rectangle.TOP);

			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			tabella.addCell(cell);

			paragraph = new Paragraph("Temp. Aria\ncomburente (\u00B0C)", FONT_HELVETICA_7);
			cell = new PdfPCell(paragraph);

			cell.setBorder(Rectangle.TOP);

			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			tabella.addCell(cell);

			paragraph = new Paragraph("O2\n%", FONT_HELVETICA_7);
			cell = new PdfPCell(paragraph);
			cell.setBorder(Rectangle.TOP);

			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			tabella.addCell(cell);

			paragraph = new Paragraph("CO2\n%", FONT_HELVETICA_7);
			cell = new PdfPCell(paragraph);
			cell.setBorder(Rectangle.TOP);

			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			tabella.addCell(cell);

			paragraph = new Paragraph("Bacharach", FONT_HELVETICA_7);
			cell = new PdfPCell(paragraph);
			cell.setBorder(Rectangle.TOP);

			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			tabella.addCell(cell);

			paragraph = new Paragraph("CO corretto\n(ppm)", FONT_HELVETICA_7);
			cell = new PdfPCell(paragraph);
			cell.setBorder(Rectangle.TOP);

			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			tabella.addCell(cell);

			paragraph = new Paragraph("Rendimento\ndi combustione %", FONT_HELVETICA_7);
			cell = new PdfPCell(paragraph);
			cell.setBorder(Rectangle.TOP);

			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			tabella.addCell(cell);

			paragraph = new Paragraph("Rendimento\nminimo di legge %", FONT_HELVETICA_7);
			cell = new PdfPCell(paragraph);
			cell.setBorder(Rectangle.TOP);

			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			tabella.addCell(cell);

			paragraph = new Paragraph("NOX\n(mg/kWh)", FONT_HELVETICA_7);
			cell = new PdfPCell(paragraph);
			cell.setBorder(Rectangle.TOP);

			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			tabella.addCell(cell);

			paragraph = new Paragraph("Modulo\ntermico", FONT_HELVETICA_7);
			cell = new PdfPCell(paragraph);
			cell.setBorder(Rectangle.RIGHT | Rectangle.TOP);

			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			tabella.addCell(cell);

			// riga2
			paragraph = new Paragraph(ConvertUtil.getStringValid((tDettTipo1.getETempFumiC())), FONT_HELVETICA_7);
			cell = new PdfPCell(paragraph);
			if (i == listLastElement) {
				cell.setBorder(Rectangle.LEFT | Rectangle.BOTTOM);
			} else {
				cell.setBorder(Rectangle.LEFT);
			}

			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			tabella.addCell(cell);

			paragraph = new Paragraph(ConvertUtil.getStringValid((tDettTipo1.getETempAriaC())), FONT_HELVETICA_7);
			cell = new PdfPCell(paragraph);
			if (i == listLastElement) {
				cell.setBorder(Rectangle.BOTTOM);
			} else {
				cell.setBorder(Rectangle.NO_BORDER);
			}
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			tabella.addCell(cell);

			paragraph = new Paragraph(ConvertUtil.getStringValid((tDettTipo1.getEO2Perc())), FONT_HELVETICA_7);
			cell = new PdfPCell(paragraph);
			if (i == listLastElement) {
				cell.setBorder(Rectangle.BOTTOM);
			} else {
				cell.setBorder(Rectangle.NO_BORDER);
			}
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			tabella.addCell(cell);

			paragraph = new Paragraph(ConvertUtil.getStringValid((tDettTipo1.getECo2Perc())), FONT_HELVETICA_7);
			cell = new PdfPCell(paragraph);
			if (i == listLastElement) {
				cell.setBorder(Rectangle.BOTTOM);
			} else {
				cell.setBorder(Rectangle.NO_BORDER);
			}
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			tabella.addCell(cell);

			paragraph = new Paragraph("", FONT_HELVETICA_7);

			aggiungiMinMedMaxFormat(paragraph, tDettTipo1.getEBacharachMin(), tDettTipo1.getEBacharachMed(), tDettTipo1.getEBacharachMax());
			cell = new PdfPCell(paragraph);
			if (i == listLastElement) {
				cell.setBorder(Rectangle.BOTTOM);
			} else {
				cell.setBorder(Rectangle.NO_BORDER);
			}
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			tabella.addCell(cell);

			paragraph = new Paragraph(ConvertUtil.getStringValid((tDettTipo1.getECoCorrettoPpm())), FONT_HELVETICA_7);
			cell = new PdfPCell(paragraph);
			if (i == listLastElement) {
				cell.setBorder(Rectangle.BOTTOM);
			} else {
				cell.setBorder(Rectangle.NO_BORDER);
			}
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			tabella.addCell(cell);

			paragraph = new Paragraph(ConvertUtil.getStringValid((tDettTipo1.getERendCombPerc())), FONT_HELVETICA_7);
			cell = new PdfPCell(paragraph);
			if (i == listLastElement) {
				cell.setBorder(Rectangle.BOTTOM);
			} else {
				cell.setBorder(Rectangle.NO_BORDER);
			}
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			tabella.addCell(cell);

			paragraph = new Paragraph(ConvertUtil.getStringValid((tDettTipo1.getERendMinLeggePerc())), FONT_HELVETICA_7);
			cell = new PdfPCell(paragraph);
			if (i == listLastElement) {
				cell.setBorder(Rectangle.BOTTOM);
			} else {
				cell.setBorder(Rectangle.NO_BORDER);
			}
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			tabella.addCell(cell);

			paragraph = new Paragraph(ConvertUtil.getStringValid((tDettTipo1.getENoxMgKwh())), FONT_HELVETICA_7);
			cell = new PdfPCell(paragraph);
			if (i == listLastElement) {
				cell.setBorder(Rectangle.BOTTOM);
			} else {
				cell.setBorder(Rectangle.NO_BORDER);
			}
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			tabella.addCell(cell);

			paragraph = new Paragraph(ConvertUtil.getStringValid((tDettTipo1.getENModuloTermico())), FONT_HELVETICA_7);
			cell = new PdfPCell(paragraph);
			if (i == listLastElement) {
				cell.setBorder(Rectangle.BOTTOM | Rectangle.RIGHT);
			} else {
				cell.setBorder(Rectangle.RIGHT);
			}
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			tabella.addCell(cell);

		}

		document.add(tabella); //AGGIUNGO LA TABELLA NEL DOCUMENTO
		log.debug("[ReeBuilder] - aggiungiModuloTermicoGt - end");
	}

	private static void aggiungiControlloVerificaGt(Document document, SigitTDettTipo1Dto dettTipo1, SigitVSk4GtDto vSk4GtDto) throws DocumentException {

		log.debug("[ReeBuilder] - aggiungiControlloVerificaGt - start");

		//Suddivido il foglio in sezioni, cioè in questo caso, un foglio 100% viene diviso in due sezioni, su 8 la prima è larga 2 e l'altra larga 6. Le sezioni possono essere anche di più spartizioni, basta solo aggiungere un valore dopo la virgola es. {3,3,3} suddividiamo in tre sezioni uguali tra di loro.
		float[] columnWidths = { 40, 20, 20, 20 };

		PdfPTable tabella = new PdfPTable(columnWidths);
		//Definisco la tabella con il 100%, il bordo,e il margine sinis
		//tabella.setSpacingBefore(8);      

		tabella.setWidthPercentage(100);
		tabella.getDefaultCell().setBorder(1);

		tabella.getDefaultCell().setPaddingLeft(PADDING_LEFT);

		PdfPCell cell;

		tabella.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);

		addEmptyCell(tabella, 4, Rectangle.LEFT | Rectangle.RIGHT);

		// riga1
		Phrase phrase = new Phrase();
		phrase.add(new Chunk("E. CONTROLLO E VERIFICA ENERGETICA DEL GRUPPO TERMICO ", FONT_HELVETICA_7_B));
		phrase.add(new Chunk("GT ", FONT_HELVETICA_7));
		phrase.add(new Chunk(ConvertUtil.getStringValid((vSk4GtDto.getProgressivo())), FONT_HELVETICA_7_B));
		cell = new PdfPCell(phrase);
		cell.setBorder(Rectangle.LEFT);
		cell.setColspan(2);
		tabella.addCell(cell);

		Paragraph paragraph = new Paragraph("Data di installazione ", FONT_HELVETICA_7);
		paragraph.add(ConvertUtil.getStringValid((vSk4GtDto.getDataInstall())));
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.RIGHT);
		cell.setColspan(2);
		tabella.addCell(cell);

		// riga2
		paragraph = new Paragraph("", FONT_HELVETICA_7);
		aggiungiTesto(paragraph, "Fabbricante", 14);
		paragraph.add(ConvertUtil.getStringValid(vSk4GtDto.getDesMarca()));
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.LEFT);
		tabella.addCell(cell);

		paragraph = new Paragraph("", FONT_HELVETICA_7);
		aggiungiCheckPrima(paragraph, "Gruppo termico singolo", Constants.ID_DETT_GT_GRUPPO_TERM_SING.equals(ConvertUtil.convertToString(vSk4GtDto.getFkDettaglioGt())));
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.NO_BORDER);
		tabella.addCell(cell);

		paragraph = new Paragraph("", FONT_HELVETICA_7);
		aggiungiCheckPrima(paragraph, "Gruppo termico modulare", Constants.ID_DETT_GT_GRUPPO_TERM_MOD.equals(ConvertUtil.convertToString(vSk4GtDto.getFkDettaglioGt())));
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.RIGHT);
		cell.setColspan(2);
		tabella.addCell(cell);

		// riga3
		paragraph = new Paragraph("", FONT_HELVETICA_7);
		aggiungiTesto(paragraph, "Modello", 15);
		paragraph.add(ConvertUtil.getStringValid(vSk4GtDto.getModello()));
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.LEFT);
		tabella.addCell(cell);

		paragraph = new Paragraph("", FONT_HELVETICA_7);
		aggiungiCheckPrima(paragraph, "Tubo / nastro radiante", Constants.ID_DETT_GT_TUBO_RADIANTE.equals(ConvertUtil.convertToString(vSk4GtDto.getFkDettaglioGt())));
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.NO_BORDER);
		tabella.addCell(cell);

		paragraph = new Paragraph("", FONT_HELVETICA_7);
		aggiungiCheckPrima(paragraph, "Generatore d'aria calda", Constants.ID_DETT_GT_GEN_ARIA_CALDA.equals(ConvertUtil.convertToString(vSk4GtDto.getFkDettaglioGt())));
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.RIGHT);
		cell.setColspan(2);
		tabella.addCell(cell);

		// riga4
		paragraph = new Paragraph("", FONT_HELVETICA_7);
		aggiungiTesto(paragraph, "Matricola", 15);
		paragraph.add(ConvertUtil.getStringValid(vSk4GtDto.getMatricola()));
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.LEFT);
		tabella.addCell(cell);

		paragraph = new Paragraph("Pot.term. nominale max al focolare ", FONT_HELVETICA_7);
		paragraph.add(ConvertUtil.getStringValid((dettTipo1.getEPotTermFocolKw())));
		paragraph.add(" (kW) ");
		paragraph.add(" Pot.term. nominale utile ");
		paragraph.add(ConvertUtil.getStringValid((vSk4GtDto.getPotenzaTermicaKw())));
		paragraph.add(" (kW) ");
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.RIGHT);
		cell.setColspan(3);
		tabella.addCell(cell);

		// riga4
		paragraph = new Paragraph("", FONT_HELVETICA_7);
		aggiungiCheckDopo(paragraph, "Climatizzazione invernale", ConvertUtil.convertToBooleanAllways(dettTipo1.getEFlgClimaInverno()), 30);
		aggiungiCheckDopo(paragraph, "Produzione acs", ConvertUtil.convertToBooleanAllways(dettTipo1.getEFlgProduzAcs()));
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.LEFT);
		tabella.addCell(cell);

		paragraph = new Paragraph("Dispositivi di comando e regolazione funzionanti correttamente", FONT_HELVETICA_7);
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setColspan(2);
		tabella.addCell(cell);

		paragraph = new Paragraph("", FONT_HELVETICA_7);
		aggiungiCheckSi(paragraph, GenericUtil.getCheckSi(dettTipo1.getEFlgDisposComando()));
		aggiungiCheckNo(paragraph, GenericUtil.getCheckNo(dettTipo1.getEFlgDisposComando()));
		aggiungiCheckPrima(paragraph, "NC", GenericUtil.getCheckNc(dettTipo1.getEFlgDisposComando()));
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.RIGHT);
		tabella.addCell(cell);

		// riga5
		paragraph = new Paragraph("Combustibile ", FONT_HELVETICA_7);
		paragraph.add(ConvertUtil.getStringValid(vSk4GtDto.getDesCombustibile()));
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.LEFT);
		cell.setRowspan(2);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		tabella.addCell(cell);

		paragraph = new Paragraph("Dispositivi di sicurezza non manomessi e/o cortocircuitati", FONT_HELVETICA_7);
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setColspan(2);
		tabella.addCell(cell);

		paragraph = new Paragraph("", FONT_HELVETICA_7);
		aggiungiCheckSi(paragraph, GenericUtil.getCheckSi(dettTipo1.getEFlgDisposSicurezza()));
		aggiungiCheckNo(paragraph, GenericUtil.getCheckNo(dettTipo1.getEFlgDisposSicurezza()));
		aggiungiCheckPrima(paragraph, "NC", GenericUtil.getCheckNc(dettTipo1.getEFlgDisposSicurezza()));
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.RIGHT);
		tabella.addCell(cell);

		paragraph = new Paragraph("Valvola di sicurezza alla sovrapressione a scarico libero", FONT_HELVETICA_7);
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setColspan(2);
		tabella.addCell(cell);

		paragraph = new Paragraph("", FONT_HELVETICA_7);
		aggiungiCheckSi(paragraph, GenericUtil.getCheckSi(dettTipo1.getEFlgValvolaSicurezza()));
		aggiungiCheckNo(paragraph, GenericUtil.getCheckNo(dettTipo1.getEFlgValvolaSicurezza()));
		aggiungiCheckPrima(paragraph, "NC", GenericUtil.getCheckNc(dettTipo1.getEFlgValvolaSicurezza()));
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.RIGHT);
		tabella.addCell(cell);

		// riga6
		paragraph = new Paragraph("Modalita' di evacuazione fumi ", FONT_HELVETICA_7);
		aggiungiSpaziVuoti(paragraph, 5);
		aggiungiCheckPrima(paragraph, "Naturale", Constants.FLAG_EVACUAZIONE_FUMI_NATURALE.equals(dettTipo1.getEFlgEvacuFumi()), 15);
		aggiungiCheckPrima(paragraph, "Forzata", Constants.FLAG_EVACUAZIONE_FUMI_FORZATA.equals(dettTipo1.getEFlgEvacuFumi()));
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.LEFT);
		cell.setRowspan(2);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		tabella.addCell(cell);

		paragraph = new Paragraph("Controllato e pulito lo scambiatore lato fumi", FONT_HELVETICA_7);
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setColspan(2);
		tabella.addCell(cell);

		paragraph = new Paragraph("", FONT_HELVETICA_7);
		aggiungiCheckSi(paragraph, GenericUtil.getCheckSi(dettTipo1.getEFlgScambiatoreFumi()));
		aggiungiCheckNo(paragraph, GenericUtil.getCheckNo(dettTipo1.getEFlgScambiatoreFumi()));
		aggiungiCheckPrima(paragraph, "NC", GenericUtil.getCheckNc(dettTipo1.getEFlgScambiatoreFumi()));
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.RIGHT);
		tabella.addCell(cell);

		paragraph = new Paragraph("Presenza riflusso dei prodotti della combustione", FONT_HELVETICA_7);
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setColspan(2);
		tabella.addCell(cell);

		paragraph = new Paragraph("", FONT_HELVETICA_7);
		aggiungiCheckSi(paragraph, GenericUtil.getCheckSi(dettTipo1.getEFlgRiflusso()));
		aggiungiCheckNo(paragraph, GenericUtil.getCheckNo(dettTipo1.getEFlgRiflusso()));
		aggiungiCheckPrima(paragraph, "NC", GenericUtil.getCheckNc(dettTipo1.getEFlgRiflusso()));
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.RIGHT);
		tabella.addCell(cell);

		// riga7
		paragraph = new Paragraph("Depressione nel canale da fumo ", FONT_HELVETICA_7);
		paragraph.add(ConvertUtil.getStringValid((dettTipo1.getEDeprCanaleFumoPa())));
		paragraph.add(" (Pa)");
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.LEFT);
		cell.setRowspan(2);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		tabella.addCell(cell);

		paragraph = new Paragraph("Risultati controllo, secondo UNI 10389-1, conformi alla legge", FONT_HELVETICA_7);
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setColspan(2);
		tabella.addCell(cell);

		paragraph = new Paragraph("", FONT_HELVETICA_7);
		aggiungiCheckSi(paragraph, GenericUtil.getCheckSi(dettTipo1.getEFlgUni103891()));
		aggiungiCheckNo(paragraph, GenericUtil.getCheckNo(dettTipo1.getEFlgUni103891()));
		aggiungiCheckPrima(paragraph, "NC", GenericUtil.getCheckNc(dettTipo1.getEFlgUni103891()));
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.RIGHT);
		tabella.addCell(cell);

		paragraph = new Paragraph("Altro riferimento normativo", FONT_HELVETICA_7);
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.NO_BORDER);
		tabella.addCell(cell);

		paragraph = new Paragraph(ConvertUtil.getStringValid(dettTipo1.getL111AltroRiferimento()), FONT_HELVETICA_7);
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.RIGHT);
		cell.setColspan(2);
		tabella.addCell(cell);

		document.add(tabella); //AGGIUNGO LA TABELLA NEL DOCUMENTO
		log.debug("[ReeBuilder] - aggiungiControlloVerificaGt - end");

	}

	private static void aggiungiCheckListGt(Document document, SigitTRappTipo1Dto rappTipo1Dto) throws DocumentException {

		//Suddivido il foglio in sezioni, cioè in questo caso, un foglio 100% viene diviso in due sezioni, su 8 la prima è larga 2 e l'altra larga 6. Le sezioni possono essere anche di più spartizioni, basta solo aggiungere un valore dopo la virgola es. {3,3,3} suddividiamo in tre sezioni uguali tra di loro.
		float[] columnWidths = { 20, 80 };

		PdfPTable tabella = new PdfPTable(columnWidths);
		//Definisco la tabella con il 100%, il bordo,e il margine sinis
		//tabella.setSpacingBefore(8);      

		tabella.setWidthPercentage(100);
		tabella.getDefaultCell().setBorder(1);

		tabella.getDefaultCell().setPaddingLeft(PADDING_LEFT);

		PdfPCell cell;

		tabella.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);

		addEmptyCell(tabella, 2, Rectangle.LEFT | Rectangle.RIGHT);

		// riga1
		cell = new PdfPCell(new Paragraph("F. CHECK-LIST", FONT_HELVETICA_7_B));
		cell.setColspan(2);
		cell.setBorder(Rectangle.LEFT | Rectangle.RIGHT);

		tabella.addCell(cell);

		// riga2
		Paragraph paragraph = new Paragraph(
				"Elenco di possibili interventi, dei quali va valutata la convenienza economica, che qualora applicabili all'impianto, potrebbero comportare un miglioramento\r\n"
						+ "della prestazione energetica:", FONT_HELVETICA_7);
		cell = new PdfPCell(paragraph);
		cell.setColspan(2);
		cell.setBorder(Rectangle.LEFT | Rectangle.RIGHT);
		tabella.addCell(cell);

		// riga3
		paragraph = new Paragraph("", FONT_HELVETICA_7);
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.LEFT);
		//cell.setRowspan(4);
		tabella.addCell(cell);

		paragraph = new Paragraph("", FONT_HELVETICA_7);
		aggiungiCheckPrima(paragraph, "l'adozione di valvole termostatiche sui corpi scaldanti\n", GenericUtil.getCheckSi(rappTipo1Dto.getFFlgAdozioneValvoleTerm()));
		aggiungiCheckPrima(paragraph, "l'isolamento della rete di distribuzione nei locali non riscaldati\n", GenericUtil.getCheckSi(rappTipo1Dto.getFFlgIsolamenteRete()));
		aggiungiCheckPrima(paragraph, "l'introduzione di un sistema di trattamento dell'acqua sanitaria e per riscaldamento, ove assente\n", GenericUtil.getCheckSi(rappTipo1Dto.getFFlgAdozSistTrattamH2o()));
		aggiungiCheckPrima(paragraph, "la sostituzione di un sistema di regolazione on/off con un sistema programmabile su piu' livelli di temperatura", GenericUtil.getCheckSi(rappTipo1Dto.getFFlgSostituzSistRegolaz()));

		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.RIGHT);
		tabella.addCell(cell);

		document.add(tabella); //AGGIUNGO LA TABELLA NEL DOCUMENTO

	}

	private static void aggiungiControlloImpiantoGt(Document document, SigitTRappTipo1Dto rappTipo1Dto) throws DocumentException {
		aggiungiControlloImpiantoGt(document, rappTipo1Dto, false);
	}

	private static void aggiungiControlloImpiantoGt(Document document, SigitTRappTipo1Dto rappTipo1Dto, boolean isTipo1B) throws DocumentException {

		//Suddivido il foglio in sezioni, cioè in questo caso, un foglio 100% viene diviso in due sezioni, su 8 la prima è larga 2 e l'altra larga 6. Le sezioni possono essere anche di più spartizioni, basta solo aggiungere un valore dopo la virgola es. {3,3,3} suddividiamo in tre sezioni uguali tra di loro.
		float[] columnWidths = { 34, 12, 40, 12 };

		PdfPTable tabella = new PdfPTable(columnWidths);
		//Definisco la tabella con il 100%, il bordo,e il margine sinis
		//tabella.setSpacingBefore(8);      

		tabella.setWidthPercentage(100);
		tabella.getDefaultCell().setBorder(1);

		tabella.getDefaultCell().setPaddingLeft(PADDING_LEFT);

		PdfPCell cell;

		tabella.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);

		addEmptyCell(tabella, 4, Rectangle.LEFT | Rectangle.RIGHT);

		// riga1
		cell = new PdfPCell(new Paragraph("D. CONTROLLO DELL'IMPIANTO", FONT_HELVETICA_7_B));
		cell.setColspan(4);
		cell.setBorder(Rectangle.LEFT | Rectangle.RIGHT);

		tabella.addCell(cell);

		// riga2
		Paragraph paragraph = new Paragraph("Per installazione interna: in locale idoneo", FONT_HELVETICA_7);
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.LEFT);
		tabella.addCell(cell);

		paragraph = new Paragraph("", FONT_HELVETICA_7);
		aggiungiCheckSi(paragraph, GenericUtil.getCheckSi(rappTipo1Dto.getDFlgLocaleIntIdoneo()));
		aggiungiCheckNo(paragraph, GenericUtil.getCheckNo(rappTipo1Dto.getDFlgLocaleIntIdoneo()));
		aggiungiCheckPrima(paragraph, "NC", GenericUtil.getCheckNc(rappTipo1Dto.getDFlgLocaleIntIdoneo()));

		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.NO_BORDER);
		tabella.addCell(cell);

		paragraph = new Paragraph("Canale da fumo o condotti di scarico idonei (esame visivo)", FONT_HELVETICA_7);
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.NO_BORDER);
		tabella.addCell(cell);

		paragraph = new Paragraph("", FONT_HELVETICA_7);
		aggiungiCheckSi(paragraph, GenericUtil.getCheckSi(rappTipo1Dto.getDFlgScaricoIdoneo()));
		aggiungiCheckNo(paragraph, GenericUtil.getCheckNo(rappTipo1Dto.getDFlgScaricoIdoneo()));
		aggiungiCheckPrima(paragraph, "NC", GenericUtil.getCheckNc(rappTipo1Dto.getDFlgScaricoIdoneo()));

		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.RIGHT);
		tabella.addCell(cell);

		// riga3
		paragraph = new Paragraph("Per installazione esterna: generatori idonei", FONT_HELVETICA_7);
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.LEFT);
		tabella.addCell(cell);

		paragraph = new Paragraph("", FONT_HELVETICA_7);
		aggiungiCheckSi(paragraph, GenericUtil.getCheckSi(rappTipo1Dto.getDFlgGenExtIdoneo()));
		aggiungiCheckNo(paragraph, GenericUtil.getCheckNo(rappTipo1Dto.getDFlgGenExtIdoneo()));
		aggiungiCheckPrima(paragraph, "NC", GenericUtil.getCheckNc(rappTipo1Dto.getDFlgGenExtIdoneo()));

		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.NO_BORDER);
		tabella.addCell(cell);

		paragraph = new Paragraph("Sistema di regolazione temperatura ambiente funzionante", FONT_HELVETICA_7);
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.NO_BORDER);
		tabella.addCell(cell);

		paragraph = new Paragraph("", FONT_HELVETICA_7);
		aggiungiCheckSi(paragraph, GenericUtil.getCheckSi(rappTipo1Dto.getDFlgTempAmbFunz()));
		aggiungiCheckNo(paragraph, GenericUtil.getCheckNo(rappTipo1Dto.getDFlgTempAmbFunz()));
		aggiungiCheckPrima(paragraph, "NC", GenericUtil.getCheckNc(rappTipo1Dto.getDFlgTempAmbFunz()));

		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.RIGHT);
		tabella.addCell(cell);

		// riga4
		paragraph = new Paragraph("Aperture ventilazione/aerazione libere da ostruzioni", FONT_HELVETICA_7);
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.LEFT);
		tabella.addCell(cell);

		paragraph = new Paragraph("", FONT_HELVETICA_7);
		aggiungiCheckSi(paragraph, GenericUtil.getCheckSi(rappTipo1Dto.getDFlgApertureLibere()));
		aggiungiCheckNo(paragraph, GenericUtil.getCheckNo(rappTipo1Dto.getDFlgApertureLibere()));
		aggiungiCheckPrima(paragraph, "NC", GenericUtil.getCheckNc(rappTipo1Dto.getDFlgApertureLibere()));

		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.NO_BORDER);
		tabella.addCell(cell);

		PdfPCell cellIdoneaTenutaImpiantoLabel = new PdfPCell(new Paragraph("Idonea tenuta dell'impianto interno e raccordi con il generatore", FONT_HELVETICA_7));
		cellIdoneaTenutaImpiantoLabel.setBorder(Rectangle.NO_BORDER);

		Paragraph paragraphIdoneaTenutaImpiantoValue = new Paragraph("", FONT_HELVETICA_7);
		aggiungiCheckSi(paragraphIdoneaTenutaImpiantoValue, GenericUtil.getCheckSi(rappTipo1Dto.getDFlgIdoTenImpInt()));
		aggiungiCheckNo(paragraphIdoneaTenutaImpiantoValue, GenericUtil.getCheckNo(rappTipo1Dto.getDFlgIdoTenImpInt()));
		aggiungiCheckPrima(paragraphIdoneaTenutaImpiantoValue, "NC", GenericUtil.getCheckNc(rappTipo1Dto.getDFlgIdoTenImpInt()));

		PdfPCell cellIdoneaTenutaImpiantoValue = new PdfPCell(paragraphIdoneaTenutaImpiantoValue);
		cellIdoneaTenutaImpiantoValue.setBorder(Rectangle.RIGHT);

		if (!isTipo1B) {

			paragraph = new Paragraph("Assenza di perdite di combustibile liquido", FONT_HELVETICA_7);
			cell = new PdfPCell(paragraph);
			cell.setBorder(Rectangle.NO_BORDER);
			tabella.addCell(cell);

			paragraph = new Paragraph("", FONT_HELVETICA_7);
			aggiungiCheckSi(paragraph, GenericUtil.getCheckSi(rappTipo1Dto.getDFlgAssenzaPerdComb()));
			aggiungiCheckNo(paragraph, GenericUtil.getCheckNo(rappTipo1Dto.getDFlgAssenzaPerdComb()));
			aggiungiCheckPrima(paragraph, "NC", GenericUtil.getCheckNc(rappTipo1Dto.getDFlgAssenzaPerdComb()));

			cell = new PdfPCell(paragraph);
			cell.setBorder(Rectangle.RIGHT);
			tabella.addCell(cell);
		} else {
			tabella.addCell(cellIdoneaTenutaImpiantoLabel);
			tabella.addCell(cellIdoneaTenutaImpiantoValue);
		}

		// riga5
		paragraph = new Paragraph("Adeguate dimensioni aperture di ventilazione/aerazione", FONT_HELVETICA_7);
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.LEFT);
		tabella.addCell(cell);

		paragraph = new Paragraph("", FONT_HELVETICA_7);
		aggiungiCheckSi(paragraph, GenericUtil.getCheckSi(rappTipo1Dto.getDFlgApertureAdeg()));
		aggiungiCheckNo(paragraph, GenericUtil.getCheckNo(rappTipo1Dto.getDFlgApertureAdeg()));
		aggiungiCheckPrima(paragraph, "NC", GenericUtil.getCheckNc(rappTipo1Dto.getDFlgApertureAdeg()));

		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.NO_BORDER);
		tabella.addCell(cell);

		if (!isTipo1B) {
			tabella.addCell(cellIdoneaTenutaImpiantoLabel);
			tabella.addCell(cellIdoneaTenutaImpiantoValue);
		} else {
			paragraph = new Paragraph("Pulizia camino effettuata secondo UNI 10847", FONT_HELVETICA_7);
			cell = new PdfPCell(paragraph);
			cell.setBorder(Rectangle.NO_BORDER);
			tabella.addCell(cell);

			paragraph = new Paragraph("", FONT_HELVETICA_7);
			aggiungiCheckSi(paragraph, GenericUtil.getCheckSi(rappTipo1Dto.getD1bFlgPuliziaCamino()));
			aggiungiCheckNo(paragraph, GenericUtil.getCheckNo(rappTipo1Dto.getD1bFlgPuliziaCamino()));
			aggiungiCheckPrima(paragraph, "NC", GenericUtil.getCheckNc(rappTipo1Dto.getD1bFlgPuliziaCamino()));

			cell = new PdfPCell(paragraph);
			cell.setBorder(Rectangle.RIGHT);
			tabella.addCell(cell);

		}

		document.add(tabella); //AGGIUNGO LA TABELLA NEL DOCUMENTO

	}

	private static void aggiungiTrattamentoAcquaGt(Document document, SigitTRappTipo1Dto rappTipo1Dto, SigitTTrattH2ODto h2O) throws DocumentException {

		log.debug("[ReeBuilder] - aggiungiTrattamentoAcquaGt - start");

		//Suddivido il foglio in sezioni, cioè in questo caso, un foglio 100% viene diviso in due sezioni, su 8 la prima è larga 2 e l'altra larga 6. Le sezioni possono essere anche di più spartizioni, basta solo aggiungere un valore dopo la virgola es. {3,3,3} suddividiamo in tre sezioni uguali tra di loro.
		float[] columnWidths = { 25, 20, 55 };

		PdfPTable tabella = new PdfPTable(columnWidths);
		//Definisco la tabella con il 100%, il bordo,e il margine sinis
		//tabella.setSpacingBefore(8);      

		tabella.setWidthPercentage(100);
		tabella.getDefaultCell().setBorder(1);

		tabella.getDefaultCell().setPaddingLeft(PADDING_LEFT);

		PdfPCell cell;

		tabella.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);

		addEmptyCell(tabella, 3, Rectangle.LEFT | Rectangle.RIGHT);

		// riga1
		cell = new PdfPCell(new Paragraph("C. TRATTAMENTO DELL'ACQUA", FONT_HELVETICA_7_B));
		cell.setColspan(3);
		cell.setBorder(Rectangle.LEFT | Rectangle.RIGHT);

		tabella.addCell(cell);

		// riga2
		Paragraph paragraph = new Paragraph("Durezza totale dell'acqua ", FONT_HELVETICA_7);
		paragraph.add(h2O != null ? ConvertUtil.getStringValid((h2O.getL22DurezzaH2oFr())) : "");
		paragraph.add("(\u00B0fr)");
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.LEFT);
		tabella.addCell(cell);

		paragraph = new Paragraph("Trattamento in riscaldamento", FONT_HELVETICA_7);

		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.NO_BORDER);
		tabella.addCell(cell);

		paragraph = new Paragraph("", FONT_HELVETICA_7);
		aggiungiCheckPrima(paragraph, "non richiesto", GenericUtil.getCheckSi(rappTipo1Dto.getCFlgTrattClimaNonRich()), 15);
		aggiungiCheckPrima(paragraph, "assente", (h2O != null && GenericUtil.getCheckSi(h2O.getL23FlgTrattClimaAssente())), 15);
		aggiungiCheckPrima(paragraph, "filtrazione", (h2O != null && GenericUtil.getCheckSi(h2O.getL23FlgTrattClimaFiltr())), 15);
		aggiungiCheckPrima(paragraph, "addolcimento", (h2O != null && GenericUtil.getCheckSi(h2O.getL23FlgTrattClimaAddolc())), 15);
		aggiungiCheckPrima(paragraph, "condiz. Chimico", (h2O != null && GenericUtil.getCheckSi(h2O.getL23FlgTrattClimaChimico())), 15);

		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.RIGHT);
		tabella.addCell(cell);

		// riga3
		paragraph = new Paragraph("", FONT_HELVETICA_7);
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.LEFT);
		tabella.addCell(cell);

		paragraph = new Paragraph("Trattamento in ACS", FONT_HELVETICA_7);

		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.NO_BORDER);
		tabella.addCell(cell);

		paragraph = new Paragraph("", FONT_HELVETICA_7);
		aggiungiCheckPrima(paragraph, "non richiesto", GenericUtil.getCheckSi(rappTipo1Dto.getCFlgTrattAcsNonRichiesto()), 15);
		aggiungiCheckPrima(paragraph, "assente", (h2O != null && GenericUtil.getCheckSi(h2O.getL24FlgTrattAcsAssente())), 15);
		aggiungiCheckPrima(paragraph, "filtrazione", (h2O != null && GenericUtil.getCheckSi(h2O.getL24FlgTrattAcsFiltr())), 15);
		aggiungiCheckPrima(paragraph, "addolcimento", (h2O != null && GenericUtil.getCheckSi(h2O.getL24FlgTrattAcsAddolc())), 15);
		aggiungiCheckPrima(paragraph, "condiz. Chimico", (h2O != null && GenericUtil.getCheckSi(h2O.getL24FlgTrattAcsChimico())), 15);

		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.RIGHT);
		tabella.addCell(cell);

		document.add(tabella); //AGGIUNGO LA TABELLA NEL DOCUMENTO

		log.debug("[ReeBuilder] - aggiungiTrattamentoAcquaGt - end");

	}

	/******/

	/***METODI SPECIFICI REE TIPO 1 B - GT (Gruppi termici a biomassa combustibile) 
	 * @throws DocumentException ***/

	private static void aggiungiConsumoAcquaGtB(Document document, List<SigitTConsumoTipo1BDto> consumiAcquaReintegro) throws DocumentException {
		log.debug("[ReeBuilder] - aggiungiConsumoAcquaGtB - start");

		PdfPTable tabella = initializeTable(new float[] { 100 });
		tabella.setSpacingBefore(0);
		tabella.setHorizontalAlignment(Element.ALIGN_CENTER);

		PdfPTable tabellaConsumoAcqua = initializeInternalTable(new float[] { 20, 20, 20, 20, 20 });

		PdfPCell cell = initializeInternalCell(new Paragraph("Acqua di reintegro nel circuito dell'impianto termico", FONT_HELVETICA_7));
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setRowspan(consumiAcquaReintegro != null && !consumiAcquaReintegro.isEmpty() ? consumiAcquaReintegro.size() + 1 : 2);

		tabellaConsumoAcqua.addCell(cell);

		tabellaConsumoAcqua.addCell(new Paragraph("Esercizio", FONT_HELVETICA_7));

		tabellaConsumoAcqua.addCell(new Paragraph("Lettura iniziale (l)", FONT_HELVETICA_7));

		tabellaConsumoAcqua.addCell(new Paragraph("Lettura finale (l)", FONT_HELVETICA_7));

		tabellaConsumoAcqua.addCell(new Paragraph("Consumo totale (l)", FONT_HELVETICA_7));

		if (consumiAcquaReintegro != null && !consumiAcquaReintegro.isEmpty()) {

			for (SigitTConsumoTipo1BDto consumoAcquaReintegro : consumiAcquaReintegro) {

				tabellaConsumoAcqua.addCell(new Paragraph(ConvertUtil.getStringValid((consumoAcquaReintegro.getEsercizio())), FONT_HELVETICA_7));

				tabellaConsumoAcqua.addCell(new Paragraph(ConvertUtil.getStringValid((consumoAcquaReintegro.getLetturaIniziale())), FONT_HELVETICA_7));

				tabellaConsumoAcqua.addCell(new Paragraph(ConvertUtil.getStringValid((consumoAcquaReintegro.getLetturaFinale())), FONT_HELVETICA_7));

				tabellaConsumoAcqua.addCell(new Paragraph(ConvertUtil.getStringValid((consumoAcquaReintegro.getConsumo())), FONT_HELVETICA_7));
			}

		} else {
			tabellaConsumoAcqua.addCell(new Paragraph("", FONT_HELVETICA_7));

			tabellaConsumoAcqua.addCell(new Paragraph("", FONT_HELVETICA_7));

			tabellaConsumoAcqua.addCell(new Paragraph("", FONT_HELVETICA_7));

			tabellaConsumoAcqua.addCell(new Paragraph("", FONT_HELVETICA_7));
		}

		PdfPCell mainCell = new PdfPCell(tabellaConsumoAcqua);
		mainCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		mainCell.setPadding(10);
		mainCell.setPaddingBottom(0);
		mainCell.setBorder(Rectangle.LEFT | Rectangle.RIGHT);
		tabella.addCell(mainCell);

		document.add(tabella);
		log.debug("[ReeBuilder] - aggiungiConsumoAcquaGtB - end");

	}

	private static void aggiungiControlloVerificaGtB(Document document, SigitTDettTipo1Dto dettTipo1, SigitVSk4GtDto vSk4GtDto, SigitTRappTipo1Dto rappTipo1Dto) throws DocumentException {

		float[] columnWidths = { 28, 24, 24, 24 };

		PdfPTable tabella = initializeTable(columnWidths);
		tabella.setSpacingBefore(0);

		addEmptyCell(tabella, 4, Rectangle.RIGHT | Rectangle.LEFT);

		PdfPCell cell;

		// riga1
		Phrase phrase = new Phrase();
		phrase.add(new Chunk("E. CONTROLLO E VERIFICA ENERGETICA DEL GRUPPO TERMICO ", FONT_HELVETICA_7_B));
		phrase.add(new Chunk("GT ", FONT_HELVETICA_7_B));
		phrase.add(new Chunk(ConvertUtil.getStringValid((vSk4GtDto.getProgressivo())), FONT_HELVETICA_7_B));
		cell = new PdfPCell(phrase);
		cell.setBorder(Rectangle.LEFT);
		cell.setColspan(3);
		tabella.addCell(cell);

		Paragraph paragraph = new Paragraph("Data di installazione ", FONT_HELVETICA_7);
		paragraph.add(ConvertUtil.getStringValid((vSk4GtDto.getDataInstall())));
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.RIGHT);
		tabella.addCell(cell);

		// riga2
		paragraph = new Paragraph("", FONT_HELVETICA_7);
		aggiungiTesto(paragraph, "Fabbricante", 14);
		paragraph.add(ConvertUtil.getStringValid(vSk4GtDto.getDesMarca()));
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.LEFT);
		tabella.addCell(cell);

		paragraph = new Paragraph("", FONT_HELVETICA_7);
		aggiungiTesto(paragraph, "Modello", 15);
		paragraph.add(ConvertUtil.getStringValid(vSk4GtDto.getModello()));
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.NO_BORDER);
		tabella.addCell(cell);

		paragraph = new Paragraph("", FONT_HELVETICA_7);
		aggiungiTesto(paragraph, "Matricola", 15);
		paragraph.add(ConvertUtil.getStringValid(vSk4GtDto.getMatricola()));
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.NO_BORDER);
		tabella.addCell(cell);

		paragraph = new Paragraph("Pot. term. nominale utile ", FONT_HELVETICA_7);
		paragraph.add(ConvertUtil.getStringValid((vSk4GtDto.getPotenzaTermicaKw())));
		paragraph.add(" (kW) ");
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.RIGHT);
		tabella.addCell(cell);

		// riga3
		paragraph = new Paragraph("", FONT_HELVETICA_7);
		aggiungiCheckPrima(paragraph, "Caldaia (UNI EN 303-5)", ConvertUtil.convertToBooleanAllways(rappTipo1Dto.getE1bFlgCaldaia()));
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.LEFT);
		tabella.addCell(cell);

		paragraph = new Paragraph("", FONT_HELVETICA_7);
		aggiungiCheckPrima(paragraph, "Stufa (UNI EN 13240)", ConvertUtil.convertToBooleanAllways(rappTipo1Dto.getE1bFlgStufa()));
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.NO_BORDER);
		tabella.addCell(cell);

		paragraph = new Paragraph("", FONT_HELVETICA_7);
		aggiungiCheckPrima(paragraph, "Stufa ad accumulo (UNI EN 15250)", ConvertUtil.convertToBooleanAllways(rappTipo1Dto.getE1bFlgStufaAccumulo()));
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.NO_BORDER);
		tabella.addCell(cell);

		paragraph = new Paragraph("", FONT_HELVETICA_7);
		aggiungiCheckPrima(paragraph, "Termocucina (UNI EN 12815)", ConvertUtil.convertToBooleanAllways(rappTipo1Dto.getE1bFlgTermocucina()));
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.RIGHT);
		tabella.addCell(cell);

		// riga4
		paragraph = new Paragraph("", FONT_HELVETICA_7);
		aggiungiCheckPrima(paragraph, "Caminetto aperto (UNI EN 13229)", ConvertUtil.convertToBooleanAllways(rappTipo1Dto.getE1bFlgCaminettoAperto()));
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.LEFT);
		tabella.addCell(cell);

		paragraph = new Paragraph("", FONT_HELVETICA_7);
		aggiungiCheckPrima(paragraph, "Caminetto chiuso (UNI EN 13229)", ConvertUtil.convertToBooleanAllways(rappTipo1Dto.getE1bFlgCaminettoChiuso()));
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.NO_BORDER);
		tabella.addCell(cell);

		paragraph = new Paragraph("", FONT_HELVETICA_7);
		aggiungiCheckPrima(paragraph, "Inserto caminetto (UNI EN 13229)", ConvertUtil.convertToBooleanAllways(rappTipo1Dto.getE1bFlgInsertoCaminetto()));
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.RIGHT);
		cell.setColspan(2);
		tabella.addCell(cell);

		//riga5
		paragraph = new Paragraph("", FONT_HELVETICA_7);
		aggiungiCheckPrima(paragraph, "Stufe assemblata in opera (UNI EN 15544)", ConvertUtil.convertToBooleanAllways(rappTipo1Dto.getE1bFlgStufaAssemblata()));
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.LEFT);
		tabella.addCell(cell);

		paragraph = new Paragraph("", FONT_HELVETICA_7);
		aggiungiCheckPrima(paragraph, "Stufa a pellet (UNI EN 14785)", ConvertUtil.convertToBooleanAllways(rappTipo1Dto.getE1bFlgStufaPellet()));
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.NO_BORDER);
		tabella.addCell(cell);

		BigDecimal idStelle = rappTipo1Dto.getIdStelle();
		paragraph = new Paragraph("", FONT_HELVETICA_7);
		aggiungiCheckPrima(paragraph, "3 Stelle  ", idStelle != null && idStelle.intValue() == Constants.ID_STELLE_3);
		aggiungiCheckPrima(paragraph, "4 Stelle  ", idStelle != null && idStelle.intValue() == Constants.ID_STELLE_4);
		aggiungiCheckPrima(paragraph, "5 Stelle  ", idStelle != null && idStelle.intValue() == Constants.ID_STELLE_5);
		aggiungiCheckPrima(paragraph, "Non applicabile", idStelle != null && idStelle.intValue() == Constants.ID_STELLE_NON_APPLICABILE);
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.RIGHT);
		cell.setColspan(2);
		tabella.addCell(cell);

		// riga6
		BigDecimal idApparecchiatura = rappTipo1Dto.getIdTipo1b();
		paragraph = new Paragraph("", FONT_HELVETICA_7);
		aggiungiCheckPrima(paragraph, "Tradizionale", idApparecchiatura != null && idApparecchiatura.intValue() == Constants.ID_TIPO_1B_TRADIZIONALE);
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.LEFT);
		tabella.addCell(cell);

		paragraph = new Paragraph("", FONT_HELVETICA_7);
		aggiungiCheckPrima(paragraph, "A condensazione", idApparecchiatura != null && idApparecchiatura.intValue() == Constants.ID_TIPO_1B_CONDENSAZIONE);
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.NO_BORDER);
		tabella.addCell(cell);

		paragraph = new Paragraph("", FONT_HELVETICA_7);
		aggiungiCheckPrima(paragraph, "Altro", idApparecchiatura != null && idApparecchiatura.intValue() == Constants.ID_TIPO_1B_ALTRO);
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.RIGHT);
		cell.setColspan(2);
		tabella.addCell(cell);

		document.add(tabella);

		tabella = initializeTable(new float[] { 21, 11, 14, 18, 16, 12 });
		tabella.setSpacingBefore(0);

		//riga7
		paragraph = new Paragraph("Servizi: ", FONT_HELVETICA_7);
		aggiungiCheckPrima(paragraph, "Climatizzazione invernale", ConvertUtil.convertToBooleanAllways(dettTipo1.getEFlgClimaInverno()), 30);
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.LEFT);
		tabella.addCell(cell);

		paragraph = new Paragraph("", FONT_HELVETICA_7);
		aggiungiCheckPrima(paragraph, "Produzione acs", ConvertUtil.convertToBooleanAllways(dettTipo1.getEFlgProduzAcs()));
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.NO_BORDER);
		tabella.addCell(cell);

		paragraph = new Paragraph("", FONT_HELVETICA_7);
		aggiungiCheckPrima(paragraph, "Cucina", ConvertUtil.convertToBooleanAllways(dettTipo1.getE1bFlgCucina()));
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.NO_BORDER);
		tabella.addCell(cell);

		paragraph = new Paragraph("Dispositivi di comando e regolazione funzionanti correttamente", FONT_HELVETICA_7);
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setColspan(2);
		tabella.addCell(cell);

		paragraph = new Paragraph("", FONT_HELVETICA_7);
		aggiungiCheckSi(paragraph, GenericUtil.getCheckSi(dettTipo1.getEFlgDisposComando()));
		aggiungiCheckNo(paragraph, GenericUtil.getCheckNo(dettTipo1.getEFlgDisposComando()));
		aggiungiCheckPrima(paragraph, "NC", GenericUtil.getCheckNc(dettTipo1.getEFlgDisposComando()));
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.RIGHT);
		tabella.addCell(cell);

		// riga8
		paragraph = new Paragraph("Depressione nel canale da fumo ", FONT_HELVETICA_7);
		paragraph.add(ConvertUtil.getStringValid((dettTipo1.getEDeprCanaleFumoPa())));
		paragraph.add(" (Pa)");
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.LEFT);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setColspan(3);
		tabella.addCell(cell);

		paragraph = new Paragraph("Dispositivi di sicurezza non manomessi e/o cortocircuitati", FONT_HELVETICA_7);
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setColspan(2);
		tabella.addCell(cell);

		paragraph = new Paragraph("", FONT_HELVETICA_7);
		aggiungiCheckSi(paragraph, GenericUtil.getCheckSi(dettTipo1.getEFlgDisposSicurezza()));
		aggiungiCheckNo(paragraph, GenericUtil.getCheckNo(dettTipo1.getEFlgDisposSicurezza()));
		aggiungiCheckPrima(paragraph, "NC", GenericUtil.getCheckNc(dettTipo1.getEFlgDisposSicurezza()));
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.RIGHT);
		tabella.addCell(cell);

		//riga9
		paragraph = new Paragraph("Marcatura CE apparecchio:", FONT_HELVETICA_7);
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.LEFT);
		tabella.addCell(cell);

		Boolean flgMarcaturaCE = ConvertUtil.convertToBoolean(ConvertUtil.convertToString(rappTipo1Dto.getE1bFlgMarcaturaCe()));
		paragraph = new Paragraph("", FONT_HELVETICA_7);
		aggiungiCheckPrima(paragraph, "Presente", flgMarcaturaCE != null && flgMarcaturaCE);
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.NO_BORDER);
		tabella.addCell(cell);

		paragraph = new Paragraph("", FONT_HELVETICA_7);
		aggiungiCheckPrima(paragraph, "Assente", flgMarcaturaCE != null && !flgMarcaturaCE);
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.NO_BORDER);
		tabella.addCell(cell);

		paragraph = new Paragraph("Valvola di sicurezza alla sovrapressione a scarico libero", FONT_HELVETICA_7);
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setColspan(2);
		tabella.addCell(cell);

		paragraph = new Paragraph("", FONT_HELVETICA_7);
		aggiungiCheckSi(paragraph, GenericUtil.getCheckSi(dettTipo1.getEFlgValvolaSicurezza()));
		aggiungiCheckNo(paragraph, GenericUtil.getCheckNo(dettTipo1.getEFlgValvolaSicurezza()));
		aggiungiCheckPrima(paragraph, "NC", GenericUtil.getCheckNc(dettTipo1.getEFlgValvolaSicurezza()));
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.RIGHT);
		tabella.addCell(cell);

		// riga10
		Boolean flgPlaccaCamino = ConvertUtil.convertToBoolean(ConvertUtil.convertToString(rappTipo1Dto.getE1bFlgPlaccaCamino()));
		paragraph = new Paragraph("Placca camino:", FONT_HELVETICA_7);
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.LEFT);
		tabella.addCell(cell);

		paragraph = new Paragraph("", FONT_HELVETICA_7);
		aggiungiCheckPrima(paragraph, "Presente", flgPlaccaCamino != null && flgPlaccaCamino);
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.NO_BORDER);
		tabella.addCell(cell);

		paragraph = new Paragraph("", FONT_HELVETICA_7);
		aggiungiCheckPrima(paragraph, "Assente", flgPlaccaCamino != null && !flgPlaccaCamino);
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.NO_BORDER);
		tabella.addCell(cell);

		paragraph = new Paragraph("Controllato e pulito lo scambiatore lato fumi", FONT_HELVETICA_7);
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setColspan(2);
		tabella.addCell(cell);

		paragraph = new Paragraph("", FONT_HELVETICA_7);
		aggiungiCheckSi(paragraph, GenericUtil.getCheckSi(dettTipo1.getEFlgScambiatoreFumi()));
		aggiungiCheckNo(paragraph, GenericUtil.getCheckNo(dettTipo1.getEFlgScambiatoreFumi()));
		aggiungiCheckPrima(paragraph, "NC", GenericUtil.getCheckNc(dettTipo1.getEFlgScambiatoreFumi()));
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.RIGHT);
		tabella.addCell(cell);

		//riga11
		paragraph = new Paragraph("Modalita' di evacuazione fumi:", FONT_HELVETICA_7);
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.LEFT);
		tabella.addCell(cell);

		paragraph = new Paragraph("", FONT_HELVETICA_7);
		aggiungiCheckPrima(paragraph, "Naturale", Constants.FLAG_EVACUAZIONE_FUMI_NATURALE.equals(dettTipo1.getEFlgEvacuFumi()));
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.NO_BORDER);
		tabella.addCell(cell);

		paragraph = new Paragraph("", FONT_HELVETICA_7);
		aggiungiCheckPrima(paragraph, "Forzata", Constants.FLAG_EVACUAZIONE_FUMI_FORZATA.equals(dettTipo1.getEFlgEvacuFumi()));
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.NO_BORDER);
		tabella.addCell(cell);

		paragraph = new Paragraph("Presenza riflusso dei prodotti della combustione", FONT_HELVETICA_7);
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setColspan(2);
		tabella.addCell(cell);

		paragraph = new Paragraph("", FONT_HELVETICA_7);
		aggiungiCheckSi(paragraph, GenericUtil.getCheckSi(dettTipo1.getEFlgRiflusso()));
		aggiungiCheckNo(paragraph, GenericUtil.getCheckNo(dettTipo1.getEFlgRiflusso()));
		aggiungiCheckPrima(paragraph, "NC", GenericUtil.getCheckNc(dettTipo1.getEFlgRiflusso()));
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.RIGHT);
		tabella.addCell(cell);

		// riga12
		BigDecimal idAriaComburente = rappTipo1Dto.getIdAriaComburente();
		paragraph = new Paragraph("Aria comburente:", FONT_HELVETICA_7);
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.LEFT);
		tabella.addCell(cell);

		paragraph = new Paragraph("", FONT_HELVETICA_7);
		aggiungiCheckPrima(paragraph, "Da esterno", idAriaComburente != null && idAriaComburente.intValue() == Constants.ID_ARIA_COMBURENTE_DA_ESTERNO);
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.NO_BORDER);
		tabella.addCell(cell);

		paragraph = new Paragraph("", FONT_HELVETICA_7);
		aggiungiCheckPrima(paragraph, "Dal locale installazione", idAriaComburente != null && idAriaComburente.intValue() == Constants.ID_ARIA_COMBURENTE_DA_LOCALE_INSTALLAZIONE);
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.NO_BORDER);
		tabella.addCell(cell);

		paragraph = new Paragraph("Risultati controllo, secondo UNI 10389-2, conformi alla legge", FONT_HELVETICA_7);
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setColspan(2);
		tabella.addCell(cell);

		paragraph = new Paragraph("", FONT_HELVETICA_7);
		aggiungiCheckSi(paragraph, GenericUtil.getCheckSi(dettTipo1.getE1bFlgUni103892()));
		aggiungiCheckNo(paragraph, GenericUtil.getCheckNo(dettTipo1.getE1bFlgUni103892()));
		aggiungiCheckPrima(paragraph, "NC", GenericUtil.getCheckNc(dettTipo1.getE1bFlgUni103892()));
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.RIGHT);
		tabella.addCell(cell);

		//riga13
		BigDecimal idControlloAriaComburente = rappTipo1Dto.getIdControlloAria();
		paragraph = new Paragraph("Controllo aria comburente:", FONT_HELVETICA_7);
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.LEFT);
		tabella.addCell(cell);

		paragraph = new Paragraph("", FONT_HELVETICA_7);
		aggiungiCheckPrima(paragraph, "Automatico", idControlloAriaComburente != null && idControlloAriaComburente.intValue() == Constants.ID_CONTROLLO_ARIA_COMBURENTE_AUTOMATICO);
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.NO_BORDER);
		tabella.addCell(cell);

		paragraph = new Paragraph("", FONT_HELVETICA_7);
		aggiungiCheckPrima(paragraph, "Semiautomatico", idControlloAriaComburente != null && idControlloAriaComburente.intValue() == Constants.ID_CONTROLLO_ARIA_COMBURENTE_SEMIAUTOMATICO);
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.NO_BORDER);
		tabella.addCell(cell);

		paragraph = new Paragraph("", FONT_HELVETICA_7);
		aggiungiCheckPrima(paragraph, "Manuale", idControlloAriaComburente != null && idControlloAriaComburente.intValue() == Constants.ID_CONTROLLO_ARIA_COMBURENTE_MANUALE);
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.RIGHT);
		cell.setColspan(3);
		tabella.addCell(cell);

		//riga14
		BigDecimal idCaricamentoCombustibile = rappTipo1Dto.getIdTipoCaricCombu();
		paragraph = new Paragraph("Caricamento combustibile:", FONT_HELVETICA_7);
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.LEFT);
		tabella.addCell(cell);

		paragraph = new Paragraph("", FONT_HELVETICA_7);
		aggiungiCheckPrima(paragraph, "Automatico", idCaricamentoCombustibile != null && idCaricamentoCombustibile.intValue() == Constants.ID_CARICAMENTO_COMBUSTIBILE_AUTOMATICO);
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.NO_BORDER);
		tabella.addCell(cell);

		paragraph = new Paragraph("", FONT_HELVETICA_7);
		aggiungiCheckPrima(paragraph, "Manuale", idCaricamentoCombustibile != null && idCaricamentoCombustibile.intValue() == Constants.ID_CARICAMENTO_COMBUSTIBILE_MANUALE);
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.NO_BORDER);
		tabella.addCell(cell);

		paragraph = new Paragraph("", FONT_HELVETICA_7);
		aggiungiCheckPrima(paragraph, "Automatico / manuale", idCaricamentoCombustibile != null && idCaricamentoCombustibile.intValue() == Constants.ID_CARICAMENTO_COMBUSTIBILE_AUTOMATICO_MANUALE);
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.RIGHT);
		cell.setColspan(3);
		tabella.addCell(cell);

		//riga15
		BigDecimal idCombustibile = vSk4GtDto.getIdCombustibile();
		paragraph = new Paragraph("Combustibile:", FONT_HELVETICA_7);
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.LEFT);
		tabella.addCell(cell);

		paragraph = new Paragraph("", FONT_HELVETICA_7);
		aggiungiCheckPrima(paragraph, "Legna", idCombustibile != null && idCombustibile.intValue() == Constants.ID_TIPO_COMBUSTIBILE_LEGNA);
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.NO_BORDER);
		tabella.addCell(cell);

		paragraph = new Paragraph("", FONT_HELVETICA_7);
		aggiungiCheckPrima(paragraph, "Pellet", idCombustibile != null && idCombustibile.intValue() == Constants.ID_TIPO_COMBUSTIBILE_PELLET);
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.NO_BORDER);
		tabella.addCell(cell);

		paragraph = new Paragraph("", FONT_HELVETICA_7);
		aggiungiCheckPrima(paragraph, "Bricchette", idCombustibile != null && idCombustibile.intValue() == Constants.ID_TIPO_COMBUSTIBILE_BRICCHETTE);
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.NO_BORDER);
		tabella.addCell(cell);

		paragraph = new Paragraph("", FONT_HELVETICA_7);
		aggiungiCheckPrima(paragraph, "Cippato", idCombustibile != null && idCombustibile.intValue() == Constants.ID_TIPO_COMBUSTIBILE_CIPPATO);
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.NO_BORDER);
		tabella.addCell(cell);

		boolean altroCombustibile = idCombustibile != null && !Arrays.asList(Constants.ID_TIPO_COMBUSTIBILE_CHECKBOX_PDF).contains(idCombustibile.intValue());

		paragraph = new Paragraph("", FONT_HELVETICA_7);
		aggiungiCheckPrima(paragraph, "Altro  ", altroCombustibile);
		aggiungiTesto(paragraph, altroCombustibile ? GenericUtil.getStringValid(vSk4GtDto.getDesCombustibile()) : "", 5);
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.RIGHT);
		tabella.addCell(cell);

		document.add(tabella);
	}

	private void aggiungiConsumoCombustibileGtB(Document document, List<SigitTConsumoTipo1BDto> consumiCombustibile) throws DocumentException {

		PdfPTable tabella = initializeTable(new float[] { 100 });
		tabella.setSpacingBefore(0);
		tabella.setHorizontalAlignment(Element.ALIGN_CENTER);

		PdfPTable tabellaConsumoCombustibile = initializeInternalTable(new float[] { 33, 33, 33 });

		tabellaConsumoCombustibile.addCell(new Paragraph("Unita' di misura", FONT_HELVETICA_7));

		tabellaConsumoCombustibile.addCell(new Paragraph("Esercizio", FONT_HELVETICA_7));

		tabellaConsumoCombustibile.addCell(new Paragraph("Consumo", FONT_HELVETICA_7));

		if (consumiCombustibile != null && !consumiCombustibile.isEmpty()) {

			for (SigitTConsumoTipo1BDto consumoCombustibile : consumiCombustibile) {

				tabellaConsumoCombustibile.addCell(new Paragraph(getDesUnitaMisura(consumoCombustibile.getIdUnitaMisura()), FONT_HELVETICA_7));

				tabellaConsumoCombustibile.addCell(new Paragraph(ConvertUtil.getStringValid((consumoCombustibile.getEsercizio())), FONT_HELVETICA_7));

				tabellaConsumoCombustibile.addCell(new Paragraph(ConvertUtil.getStringValid((consumoCombustibile.getConsumo())), FONT_HELVETICA_7));

			}
		} else {

			tabellaConsumoCombustibile.addCell(new Paragraph("", FONT_HELVETICA_7));

			tabellaConsumoCombustibile.addCell(new Paragraph("", FONT_HELVETICA_7));

			tabellaConsumoCombustibile.addCell(new Paragraph("", FONT_HELVETICA_7));
		}

		PdfPCell mainCell = new PdfPCell(tabellaConsumoCombustibile);
		mainCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		mainCell.setPadding(5);
		mainCell.setPaddingBottom(0);
		mainCell.setBorder(Rectangle.LEFT | Rectangle.RIGHT);
		tabella.addCell(mainCell);

		document.add(tabella);
	}

	private static void aggiungiModuloTermicoGtB(Document document, List<SigitTDettTipo1Dto> tDettTipo1List) throws DocumentException {

		PdfPTable tabella = initializeTable(new float[] { 100 });
		tabella.setSpacingBefore(0);
		tabella.setHorizontalAlignment(Element.ALIGN_CENTER);

		PdfPTable tabellaModuliTermici = initializeInternalTable(new float[] { 10, 17, 5, 5, 10, 10, 12, 13, 9, 9 });

		tabellaModuliTermici.addCell(new Paragraph("Temperatura Fumi (\u00B0C)", FONT_HELVETICA_7));

		tabellaModuliTermici.addCell(new Paragraph("Temp. Aria comburente (\u00B0C)", FONT_HELVETICA_7));

		tabellaModuliTermici.addCell(new Paragraph("O2 %", FONT_HELVETICA_7));

		tabellaModuliTermici.addCell(new Paragraph("CO2 %", FONT_HELVETICA_7));

		tabellaModuliTermici.addCell(new Paragraph("Particolato primario mg/Nm3", FONT_HELVETICA_7));

		tabellaModuliTermici.addCell(new Paragraph("CO corretto (ppm)", FONT_HELVETICA_7));

		tabellaModuliTermici.addCell(new Paragraph("Rendimento di combustione %", FONT_HELVETICA_7));

		tabellaModuliTermici.addCell(new Paragraph("Rendimento minimo di legge %", FONT_HELVETICA_7));

		tabellaModuliTermici.addCell(new Paragraph("NOX", FONT_HELVETICA_7));

		tabellaModuliTermici.addCell(new Paragraph("Modulo termico", FONT_HELVETICA_7));

		for (SigitTDettTipo1Dto tDettTipo1 : tDettTipo1List) {

			tabellaModuliTermici.addCell(new Paragraph(ConvertUtil.getStringValid((tDettTipo1.getETempFumiC())), FONT_HELVETICA_7));

			tabellaModuliTermici.addCell(new Paragraph(ConvertUtil.getStringValid((tDettTipo1.getETempAriaC())), FONT_HELVETICA_7));

			tabellaModuliTermici.addCell(new Paragraph(ConvertUtil.getStringValid((tDettTipo1.getEO2Perc())), FONT_HELVETICA_7));

			tabellaModuliTermici.addCell(new Paragraph(ConvertUtil.getStringValid((tDettTipo1.getECo2Perc())), FONT_HELVETICA_7));

			tabellaModuliTermici.addCell(new Paragraph(ConvertUtil.getStringValid((tDettTipo1.getE1bParticolatoMgAlM3())), FONT_HELVETICA_7));

			tabellaModuliTermici.addCell(new Paragraph(ConvertUtil.getStringValid((tDettTipo1.getECoCorrettoPpm())), FONT_HELVETICA_7));

			tabellaModuliTermici.addCell(new Paragraph(ConvertUtil.getStringValid((tDettTipo1.getERendCombPerc())), FONT_HELVETICA_7));

			tabellaModuliTermici.addCell(new Paragraph(ConvertUtil.getStringValid((tDettTipo1.getERendMinLeggePerc())), FONT_HELVETICA_7));

			if (GenericUtil.isNullOrEmpty(tDettTipo1.getENoxMgKwh())) {
				tabellaModuliTermici.addCell(new Paragraph(ConvertUtil.getStringValid(tDettTipo1.getENoxMgNm3() + "(mg/Nm3)"), FONT_HELVETICA_7));
			} else {
				tabellaModuliTermici.addCell(new Paragraph(ConvertUtil.getStringValid(tDettTipo1.getENoxMgKwh() + "(mg/KWh)"), FONT_HELVETICA_7));
			}
			tabellaModuliTermici.addCell(new Paragraph(ConvertUtil.getStringValid((tDettTipo1.getENModuloTermico())), FONT_HELVETICA_7));
		}

		PdfPCell mainCell = new PdfPCell(tabellaModuliTermici);
		mainCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		mainCell.setPadding(5);
		mainCell.setBorder(Rectangle.LEFT | Rectangle.RIGHT);
		tabella.addCell(mainCell);

		document.add(tabella);
	}

	/******/

	/***METODI COMUNI REE TIPO 1 e TIPO 2***/

	private static void aggiungiDatiIdentificativi(Document document, SigitTImpiantoDto impiantoDto, SigitTAllegatoDto allegatoDto, List<SigitTUnitaImmobiliareDto> listaUnitaImmobiliare)
			throws DocumentException {
		aggiungiDatiIdentificativi(document, impiantoDto, allegatoDto, listaUnitaImmobiliare, false);
	}

	private static void aggiungiDatiIdentificativi(Document document, SigitTImpiantoDto impiantoDto, SigitTAllegatoDto allegatoDto, List<SigitTUnitaImmobiliareDto> listaUnitaImmobiliare, boolean isTipo1B)
			throws DocumentException {
		log.debug("[ReeBuilder] - aggiungi dati identificativi - start");
		List<SigitTUnitaImmobiliareDto> unitaImmobSecondarie = new ArrayList<SigitTUnitaImmobiliareDto>();
		SigitTUnitaImmobiliareDto unitaImmobPrincipale = new SigitTUnitaImmobiliareDto();

		for (SigitTUnitaImmobiliareDto ui : listaUnitaImmobiliare) {
			if (ConvertUtil.convertToBooleanAllways(ui.getFlgPrincipale()))
				unitaImmobPrincipale = ui;
			else
				unitaImmobSecondarie.add(ui);
		}

		//Suddivido il foglio in sezioni, cioè in questo caso, un foglio 100% viene diviso in due sezioni, su 8 la prima è larga 2 e l'altra larga 6. Le sezioni possono essere anche di più spartizioni, basta solo aggiungere un valore dopo la virgola es. {3,3,3} suddividiamo in tre sezioni uguali tra di loro.
		float[] columnWidths = { 35, 10, 45, 10 };

		PdfPTable tabella = new PdfPTable(columnWidths);
		//Definisco la tabella con il 100%, il bordo,e il margine sinis
		tabella.setSpacingBefore(8);

		tabella.setWidthPercentage(100);
		tabella.getDefaultCell().setBorder(1);

		tabella.getDefaultCell().setPaddingLeft(PADDING_LEFT);

		PdfPCell cell;

		tabella.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);

		cell = new PdfPCell(new Paragraph("A. DATI IDENTIFICATIVI: ", FONT_HELVETICA_7_B));
		cell.setBorder(Rectangle.LEFT | Rectangle.TOP);

		tabella.addCell(cell);

		Phrase phrase = new Phrase();
		phrase.add(new Chunk("codice catasto ", FONT_HELVETICA_7));
		phrase.add(new Chunk("(cod. impianto)   ", FONT_HELVETICA_5));
		phrase.add(new Chunk(ConvertUtil.getStringValid(impiantoDto.getCodiceImpianto()), FONT_HELVETICA_7));
		//phrase.add(new Chunk (ConvertUtil.getStringValid(impiantoDto.getCodiceImpianto()), new Font(Font.HELVETICA, 8, Font.UNDERLINE)));

		cell = new PdfPCell(phrase);
		cell.setColspan(3);
		cell.setBorder(Rectangle.TOP | Rectangle.RIGHT);

		tabella.addCell(cell);

		phrase = new Phrase();
		phrase.add(new Chunk("Impianto: ", FONT_HELVETICA_7_B));
		phrase.add(new Chunk("di Potenza termica nominale totale max ", FONT_HELVETICA_7));
		phrase.add(new Chunk(ConvertUtil.getStringValid((allegatoDto.getAPotenzaTermicaNominaleMax())), FONT_HELVETICA_7));

		//aggiungiTesto(phrase, ConvertUtil.getStringValid(allegatoDto.getAPotenzaTermicaNominaleMax()), 5, FONT_HELVETICA_7);

		//phrase.add(new Chunk (ConvertUtil.getStringValid(allegatoDto.getAPotenzaTermicaNominaleMax()), FONT_HELVETICA_7_B));
		phrase.add(new Chunk(" (kW)", FONT_HELVETICA_7));
		cell = new PdfPCell(phrase);
		cell.setColspan(2);
		cell.setBorder(Rectangle.LEFT);
		//cell.setBorder(Rectangle.BOX);
		tabella.addCell(cell);

		phrase = new Phrase("sito nel Comune " + ConvertUtil.getStringValid(impiantoDto.getDenominazioneComune()), FONT_HELVETICA_7);
		cell = new PdfPCell(phrase);
		cell.setBorder(Rectangle.NO_BORDER);
		//cell.setBorder(Rectangle.BOX);

		tabella.addCell(cell);

		cell = new PdfPCell(new Paragraph("prov: " + ConvertUtil.getStringValid(impiantoDto.getSiglaProvincia()), FONT_HELVETICA_7));
		cell.setBorder(Rectangle.RIGHT);
		tabella.addCell(cell);

		String indirizzo = GenericUtil.isNotNullOrEmpty(unitaImmobPrincipale.getIndirizzoSitad()) ? unitaImmobPrincipale.getIndirizzoSitad() : unitaImmobPrincipale.getIndirizzoNonTrovato();

		cell = new PdfPCell(new Paragraph("Indirizzo: " + ConvertUtil.getStringValid(indirizzo), FONT_HELVETICA_7));
		cell.setColspan(2);
		cell.setBorder(Rectangle.LEFT);
		//cell.setBorder(Rectangle.BOX);

		tabella.addCell(cell);

		Paragraph paragraph = new Paragraph("", FONT_HELVETICA_7);

		aggiungiTesto(paragraph, "N. " + ConvertUtil.getStringValid(unitaImmobPrincipale.getCivico()), 10);

		aggiungiTesto(paragraph, "Palazzo " + ConvertUtil.getStringValid(unitaImmobPrincipale.getPalazzo()), 15);
		aggiungiTesto(paragraph, "Scala " + ConvertUtil.getStringValid(unitaImmobPrincipale.getScala()), 15);
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.NO_BORDER);
		tabella.addCell(cell);

		cell = new PdfPCell(new Paragraph("Interno: " + ConvertUtil.getStringValid(unitaImmobPrincipale.getInterno()), FONT_HELVETICA_7));
		cell.setBorder(Rectangle.RIGHT);
		tabella.addCell(cell);

		document.add(tabella); //AGGIUNGO LA TABELLA NEL DOCUMENTO

		tabella = new PdfPTable(new float[] { 15, 10, 15, 10, 15, 15 });
		//Definisco la tabella con il 100%, il bordo,e il margine sinis
		//tabella.setSpacingBefore(8);

		tabella.setWidthPercentage(100);
		tabella.getDefaultCell().setBorder(1);
		tabella.getDefaultCell().setPaddingLeft(PADDING_LEFT);

		aggiungiUnitaImmobiliare(tabella, unitaImmobPrincipale, isTipo1B);

		for (SigitTUnitaImmobiliareDto umSec : unitaImmobSecondarie) {
			aggiungiUnitaImmobiliare(tabella, umSec, isTipo1B);
		}

		document.add(tabella); //AGGIUNGO LA TABELLA NEL DOCUMENTO
		log.debug("[ReeBuilder] - aggiungi dati identificativi - end");

	}

	private static void aggiungiUnitaImmobiliare(PdfPTable tabella, SigitTUnitaImmobiliareDto unitaImmboliare, boolean isTipo1B) {

		PdfPCell cell = new PdfPCell(new Paragraph("sezione: " + ConvertUtil.getStringValid(unitaImmboliare.getSezione()), FONT_HELVETICA_7));
		cell.setBorder(Rectangle.LEFT);
		tabella.addCell(cell);

		cell = new PdfPCell(new Paragraph("foglio: " + ConvertUtil.getStringValid(unitaImmboliare.getFoglio()), FONT_HELVETICA_7));
		cell.setBorder(Rectangle.NO_BORDER);
		tabella.addCell(cell);

		cell = new PdfPCell(new Paragraph("particella: " + ConvertUtil.getStringValid(unitaImmboliare.getParticella()), FONT_HELVETICA_7));
		cell.setBorder(Rectangle.NO_BORDER);
		tabella.addCell(cell);

		cell = new PdfPCell(new Paragraph("sub.: " + ConvertUtil.getStringValid(unitaImmboliare.getSubalterno()), FONT_HELVETICA_7));
		cell.setBorder(Rectangle.NO_BORDER);
		tabella.addCell(cell);

		cell = new PdfPCell(new Paragraph("POD: " + ConvertUtil.getStringValid(unitaImmboliare.getPodElettrico()), FONT_HELVETICA_7));

		if (!isTipo1B) {
			cell.setBorder(Rectangle.NO_BORDER);
		} else {
			cell.setBorder(Rectangle.RIGHT);
			cell.setColspan(2);
		}

		tabella.addCell(cell);

		if (!isTipo1B) {
			cell = new PdfPCell(new Paragraph("PDR: " + ConvertUtil.getStringValid(unitaImmboliare.getPdrGas()), FONT_HELVETICA_7));
			cell.setBorder(Rectangle.RIGHT);
			tabella.addCell(cell);
		}
	}

	private static void aggiungiIntestazione(Document document) throws DocumentException {

		//Suddivido il foglio in sezioni, cioè in questo caso, un foglio 100% viene diviso in due sezioni, su 8 la prima è larga 2 e l’altra larga 6. Le sezioni possono essere anche di più spartizioni, basta solo aggiungere un valore dopo la virgola es. {3,3,3} suddividiamo in tre sezioni uguali tra di loro.
		float[] columnWidths = { 2, 8 };

		PdfPTable tabella = new PdfPTable(columnWidths);
		//Definisco la tabella con il 100%, il bordo,e il margine sinis

		tabella.setWidthPercentage(100);
		tabella.getDefaultCell().setBorder(2);
		// tabella.getDefaultCell().setBackgroundColor(Color.LIGHT_GRAY);
		tabella.getDefaultCell().setPaddingLeft(PADDING_LEFT);

		PdfPCell cell;

		Paragraph par = new Paragraph();

		//Image image = getImmagineLogo();
		try {

			par.setAlignment(Paragraph.ALIGN_LEFT);
			par.add(new Chunk(IMG_LOGO, 0, 0, true));
		} catch (Exception e) {
			System.out.println("Immagine mancante");
			//JOptionPane.showMessageDialog(null, "IMMAGINE MANCANTE");
		}

		cell = new PdfPCell(par);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);

		tabella.addCell(cell);

		Phrase phrase = new Phrase();
		phrase.add(new Chunk("Numero REE ", FONT_HELVETICA_8_B));
		phrase.add(new Chunk("XX-XXXXXXXX", FONT_HELVETICA_8_B_S));
		phrase.add(new Chunk("            "));
		phrase.add(new Chunk("ALLEGATO ", FONT_HELVETICA_8_B));

		Font font = new Font(FONT_HELVETICA_5);
		font.setColor(Color.GRAY);
		phrase.add(new Chunk("    (Art. 2)", font));

		cell = new PdfPCell(phrase);
		cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		tabella.addCell(cell);

		document.add(tabella); //AGGIUNGO LA TABELLA NEL DOCUMENTO
	}

	private static void aggiungiConclusione(Document document, SigitTAllegatoDto allegatoDto) throws DocumentException {

		//Suddivido il foglio in sezioni, cioè in questo caso, un foglio 100% viene diviso in due sezioni, su 8 la prima è larga 2 e l'altra larga 6. Le sezioni possono essere anche di più spartizioni, basta solo aggiungere un valore dopo la virgola es. {3,3,3} suddividiamo in tre sezioni uguali tra di loro.
		float[] columnWidths = { 100 };

		PdfPTable tabella = new PdfPTable(columnWidths);
		//Definisco la tabella con il 100%, il bordo,e il margine sinis

		tabella.setWidthPercentage(100);
		tabella.getDefaultCell().setBorder(1);

		tabella.getDefaultCell().setPaddingLeft(PADDING_LEFT);

		PdfPCell cell;

		tabella.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);

		// riga1
		Phrase phrase = new Phrase();
		phrase.add(new Chunk("Osservazioni ", FONT_HELVETICA_7_B));
		phrase.add(new Chunk(ConvertUtil.getStringValid(allegatoDto.getFOsservazioni()), FONT_HELVETICA_7));
		cell = new PdfPCell(phrase);
		cell.setBorder(Rectangle.LEFT | Rectangle.RIGHT);
		tabella.addCell(cell);

		// riga2
		phrase = new Phrase();
		phrase.add(new Chunk("Raccomandazioni ", FONT_HELVETICA_7_B));
		phrase.add(new Chunk(ConvertUtil.getStringValid(allegatoDto.getFRaccomandazioni()), FONT_HELVETICA_7));
		cell = new PdfPCell(phrase);
		cell.setBorder(Rectangle.LEFT | Rectangle.RIGHT);
		tabella.addCell(cell);

		// riga3
		phrase = new Phrase();
		phrase.add(new Chunk("Presrizioni ", FONT_HELVETICA_7_B));
		phrase.add(new Chunk(ConvertUtil.getStringValid(allegatoDto.getFPrescrizioni()), FONT_HELVETICA_7));
		cell = new PdfPCell(phrase);
		cell.setBorder(Rectangle.LEFT | Rectangle.RIGHT);
		tabella.addCell(cell);

		// riga4
		Paragraph paragraph = new Paragraph(
				"Il tecnico dichiara, in riferimento ai punti A,B,C,D,E (sopra menzionati), che l'apparecchio puo' essere messo in servizio ed usato normalmente ai fini dell'efficienza\r\n"
						+ "energetica senza compromettere la sicurezza delle persone, degli animali e dei beni. ", FONT_HELVETICA_6_B);
		cell = new PdfPCell(paragraph);
		//cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);

		cell.setBorder(Rectangle.LEFT | Rectangle.RIGHT);
		tabella.addCell(cell);

		// riga5
		paragraph = new Paragraph("L'impianto puo' funzionare ", FONT_HELVETICA_6_B);
		aggiungiSpaziVuoti(paragraph, 10);

		aggiungiCheckPrima(paragraph, "Si", GenericUtil.getCheckSi(allegatoDto.getFFlgPuoFunzionare()), 20);
		aggiungiCheckPrima(paragraph, "No", GenericUtil.getCheckNo(allegatoDto.getFFlgPuoFunzionare()));
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.LEFT | Rectangle.RIGHT);
		tabella.addCell(cell);

		// riga6
		paragraph = new Paragraph(
				"Il tecnico declina altresi' ogni responsabilita' per sinistri a persone, animali o cose derivanti da manomissioni dell'impianto o dell'apparecchio da parte di terzi, ovvero da carenza di"
						+ "manutenzione successiva. In presenza di carenze riscontrate e non eliminate, il responsabile dell'impianto si impegna, entro breve tempo, a provvedere alla loro risoluzione dandone "
						+ "notizia all'operatore incaricato.", FONT_HELVETICA_6);
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.LEFT | Rectangle.RIGHT);
		tabella.addCell(cell);

		// riga7
		paragraph = new Paragraph("Si raccomanda un'intervento manutentivo entro il ", FONT_HELVETICA_6);
		paragraph.add(ConvertUtil.getStringValid((allegatoDto.getFInterventoEntro())));
		cell = new PdfPCell(paragraph);
		cell.setFixedHeight(15);
		cell.setBorder(Rectangle.LEFT | Rectangle.RIGHT);
		tabella.addCell(cell);

		// riga8
		paragraph = new Paragraph("Data del presente controllo ", FONT_HELVETICA_6);
		paragraph.add(ConvertUtil.getStringValid((allegatoDto.getDataControllo())));
		aggiungiSpaziVuoti(paragraph, 70);

		paragraph.add("Orario di arrivo/partenza presso l'impianto");
		aggiungiTesto(paragraph, ConvertUtil.getStringValid(allegatoDto.getFOraArrivo()), 15);
		paragraph.add(ConvertUtil.getStringValid(allegatoDto.getFOraArrivo()));
		paragraph.add("/");
		paragraph.add(ConvertUtil.getStringValid(allegatoDto.getFOraPartenza()));
		cell = new PdfPCell(paragraph);
		cell.setFixedHeight(15);
		cell.setBorder(Rectangle.LEFT | Rectangle.RIGHT);
		tabella.addCell(cell);

		// riga9
		paragraph = new Paragraph("Tecnico che ha effettuato il controllo: Nome e Cognome ", FONT_HELVETICA_6);
		paragraph.add(ConvertUtil.getStringValid(allegatoDto.getFDenominazTecnico()));
		cell = new PdfPCell(paragraph);
		cell.setFixedHeight(15);
		cell.setBorder(Rectangle.LEFT | Rectangle.RIGHT);
		tabella.addCell(cell);

		// riga10
		paragraph = new Paragraph("Firma del tecnico ", FONT_HELVETICA_6);
		paragraph.add(ConvertUtil.getStringValid(allegatoDto.getFFirmaTecnico()));
		aggiungiSpaziVuoti(paragraph, 70);

		paragraph.add("Firma per presa visione del responsabile dell'impianto");
		paragraph.add(ConvertUtil.getStringValid(allegatoDto.getFFirmaResponsabile()));
		cell = new PdfPCell(paragraph);
		cell.setFixedHeight(15);
		cell.setBorder(Rectangle.LEFT | Rectangle.RIGHT);
		tabella.addCell(cell);

		// riga11
		paragraph = new Paragraph("OPEN DATA: i dati contenuti sul presente rapporto sono pubblicati in ambito open data su Dati Piemonte. Eventuale esclusione dalla pubblicazione puo' essere richiesta all'assistenza informatica https://bit.ly/3gOEixP", FONT_HELVETICA_6_B);
		cell = new PdfPCell(paragraph);
		cell.setFixedHeight(15);
		cell.setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.BOTTOM);
		tabella.addCell(cell);

		document.add(tabella); //AGGIUNGO LA TABELLA NEL DOCUMENTO

	}

	private static void aggiungiResponsabileEManutentore(Document document, SigitTPersonaFisicaDto personaFisicaDto, SigitTPersonaGiuridicaDto personaGiuridicaDto, int idRuolo, boolean isTerzoResp, SigitTPersonaGiuridicaDto pgManut)
			throws DocumentException {

		log.debug("[ReeBuilder] - aggiungiResponsabileEManutentore - start");

		//Suddivido il foglio in sezioni, cioè in questo caso, un foglio 100% viene diviso in due sezioni, su 8 la prima è larga 2 e l'altra larga 6. Le sezioni possono essere anche di più spartizioni, basta solo aggiungere un valore dopo la virgola es. {3,3,3} suddividiamo in tre sezioni uguali tra di loro.
		float[] columnWidths = { 35, 10, 20, 35 };

		PdfPTable tabella = new PdfPTable(columnWidths);

		tabella.setWidthPercentage(100);
		tabella.getDefaultCell().setBorder(1);

		tabella.getDefaultCell().setPaddingLeft(PADDING_LEFT);

		PdfPCell cell;

		tabella.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);

		// riga1
		cell = new PdfPCell(new Paragraph("Responsabile dell'impianto", FONT_HELVETICA_7_B));
		cell.setColspan(4);
		cell.setBorder(Rectangle.LEFT | Rectangle.RIGHT);

		tabella.addCell(cell);

		String cognome = null;
		String nome = null;
		String cf = null;
		String ragioneSociale = null;
		String pIva = null;
		String indirizzo = null;
		String civico = null;
		String provincia = null;
		String comune = null;

		if (personaGiuridicaDto != null) {
			ragioneSociale = personaGiuridicaDto.getDenominazione();
			pIva = personaGiuridicaDto.getCodiceFiscale();

			if (ConvertUtil.convertToBooleanAllways(personaGiuridicaDto.getFlgIndirizzoEstero())) {
				indirizzo = personaGiuridicaDto.getIndirizzoEstero();
				comune = GenericUtil.getStringValid(personaGiuridicaDto.getCittaEstero()) + " (" + GenericUtil.getStringValid(personaGiuridicaDto.getStatoEstero()) + ")";
				//rowAllegatoIV.setAA2Prov(null);

			} else {
				if (personaGiuridicaDto.getIndirizzoSitad() != null) {
					indirizzo = personaGiuridicaDto.getIndirizzoSitad();
				} else {
					indirizzo = personaGiuridicaDto.getIndirizzoNonTrovato();
				}
				provincia = personaGiuridicaDto.getSiglaProv();
				comune = personaGiuridicaDto.getComune();
			}

			// Questo campo e' comune a tutti e due gli indirizzi (ESTERO/NAZIONALE)
			civico = personaGiuridicaDto.getCivico();

		} else {
			//vuol dire che e'  persona fisica
			cognome = personaFisicaDto.getCognome();
			nome = personaFisicaDto.getNome();
			cf = personaFisicaDto.getCodiceFiscale();

			if (ConvertUtil.convertToBooleanAllways(personaFisicaDto.getFlgIndirizzoEstero())) {
				indirizzo = personaFisicaDto.getIndirizzoEstero();
				comune = GenericUtil.getStringValid(personaFisicaDto.getCittaEstero()) + " (" + GenericUtil.getStringValid(personaFisicaDto.getStatoEstero()) + ")";
				//rowAllegatoIV.setAA2Prov(null);
			} else {
				if (personaFisicaDto.getIndirizzoSitad() != null) {
					indirizzo = personaFisicaDto.getIndirizzoSitad();
				} else {
					indirizzo = personaFisicaDto.getIndirizzoNonTrovato();
				}

				provincia = personaFisicaDto.getSiglaProv();
				comune = personaFisicaDto.getComune();

			}
			// Questo campo e' comune a tutti e due gli indirizzi (ESTERO/NAZIONALE)
			civico = personaFisicaDto.getCivico();
		}

		// riga2
		Paragraph paragraph = new Paragraph("Cognome " + ConvertUtil.getStringValid(cognome), FONT_HELVETICA_7);
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.LEFT);
		tabella.addCell(cell);

		paragraph = new Paragraph("Nome " + ConvertUtil.getStringValid(nome), FONT_HELVETICA_7);
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setColspan(2);
		tabella.addCell(cell);

		paragraph = new Paragraph("Codice Fiscale " + ConvertUtil.getStringValid(cf), FONT_HELVETICA_7);
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.RIGHT);
		tabella.addCell(cell);

		// riga3
		paragraph = new Paragraph("Ragione sociale " + ConvertUtil.getStringValid(ragioneSociale), FONT_HELVETICA_7);
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.LEFT);
		cell.setColspan(3);
		tabella.addCell(cell);

		paragraph = new Paragraph("P.IVA " + ConvertUtil.getStringValid(pIva), FONT_HELVETICA_7);
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.RIGHT);
		tabella.addCell(cell);

		// riga4
		paragraph = new Paragraph("Indirizzo " + ConvertUtil.getStringValid(indirizzo), FONT_HELVETICA_7);
		aggiungiSpaziVuoti(paragraph, 5);
		aggiungiTesto(paragraph, "N. " + ConvertUtil.getStringValid(civico), 0);
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.LEFT);
		cell.setColspan(2);
		tabella.addCell(cell);

		paragraph = new Paragraph("Comune " + ConvertUtil.getStringValid(comune), FONT_HELVETICA_7);
		aggiungiSpaziVuoti(paragraph, 5);
		aggiungiTesto(paragraph, "prov. " + ConvertUtil.getStringValid(provincia), 0);

		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.RIGHT);
		cell.setColspan(2);
		tabella.addCell(cell);

		boolean isProprietario = false;
		boolean isOccupante = false;
		boolean isAmministratore = false;

		// riga5

		// Se non e' terzo responsabile, devo capire cos'e'
		if (!isTerzoResp) {
			if ((Constants.ID_RUOLO_PROPRIETARIO == idRuolo) || (Constants.ID_RUOLO_RESPONSABILE_IMPRESA_PROPRIETARIO == idRuolo)) {

				isProprietario = true;
			}
			if ((Constants.ID_RUOLO_OCCUPANTE == idRuolo) || (Constants.ID_RUOLO_RESPONSABILE_IMPRESA_OCCUPANTE == idRuolo)) {
				isOccupante = true;
			}
			if ((Constants.ID_RUOLO_AMMINISTRATORE == idRuolo) || (Constants.ID_RUOLO_RESPONSABILE_IMPRESA_AMMINISTRATORE == idRuolo)) {
				isAmministratore = true;
			}
		}

		paragraph = new Paragraph("Titolo di responsabilita':", FONT_HELVETICA_7);
		aggiungiSpaziVuoti(paragraph, 10);
		aggiungiCheckPrima(paragraph, "Proprietario", isProprietario, 40);
		aggiungiCheckPrima(paragraph, "Occupante", isOccupante, 40);
		aggiungiCheckPrima(paragraph, "Amministratore Condominio", isAmministratore, 40);
		aggiungiCheckPrima(paragraph, "Terzo Responsabile", isTerzoResp, 40);
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.LEFT | Rectangle.RIGHT);
		cell.setColspan(4);
		tabella.addCell(cell);

		// riga6
		paragraph = new Paragraph("Impresa manutentrice", FONT_HELVETICA_7_B);
		cell = new PdfPCell(paragraph);
		cell.setColspan(4);
		cell.setBorder(Rectangle.LEFT | Rectangle.RIGHT);

		tabella.addCell(cell);

		Phrase phrase = new Phrase();
		phrase.add(new Chunk("Ragione sociale ", FONT_HELVETICA_7));
		phrase.add(new Chunk(ConvertUtil.getSubstring(ConvertUtil.getStringValid(pgManut.getDenominazione()), 40), FONT_HELVETICA_7));
		cell = new PdfPCell(phrase);
		cell.setColspan(2);
		cell.setBorder(Rectangle.LEFT);

		tabella.addCell(cell);

		paragraph = new Paragraph("P.IVA " + ConvertUtil.getStringValid(pgManut.getCodiceFiscale()), FONT_HELVETICA_7);
		cell = new PdfPCell(paragraph);
		cell.setColspan(2);
		cell.setBorder(Rectangle.RIGHT);
		tabella.addCell(cell);

		String indirizzoManut = null;
		String civicoManut = null;
		String provinciaManut = null;
		String comuneManut = null;

		if (pgManut != null) {
			ragioneSociale = pgManut.getDenominazione();
			pIva = pgManut.getCodiceFiscale();

			if (ConvertUtil.convertToBooleanAllways(pgManut.getFlgIndirizzoEstero())) {
				indirizzoManut = pgManut.getIndirizzoEstero();
				comuneManut = GenericUtil.getStringValid(pgManut.getCittaEstero()) + " (" + GenericUtil.getStringValid(pgManut.getStatoEstero()) + ")";
				//rowAllegatoIV.setAA2Prov(null);

			} else {
				if (pgManut.getIndirizzoSitad() != null) {
					indirizzoManut = pgManut.getIndirizzoSitad();
				} else {
					indirizzoManut = pgManut.getIndirizzoNonTrovato();
				}
				provinciaManut = pgManut.getSiglaProv();
				comuneManut = pgManut.getComune();
			}

			// Questo campo e' comune a tutti e due gli indirizzi (ESTERO/NAZIONALE)
			civicoManut = pgManut.getCivico();

		}

		// riga7
		paragraph = new Paragraph("Indirizzo " + ConvertUtil.getStringValid(indirizzoManut), FONT_HELVETICA_7);
		aggiungiSpaziVuoti(paragraph, 5);
		aggiungiTesto(paragraph, "N. " + ConvertUtil.getStringValid(civicoManut), 0);
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.LEFT);
		cell.setColspan(2);
		tabella.addCell(cell);

		paragraph = new Paragraph("Comune " + ConvertUtil.getStringValid(comuneManut), FONT_HELVETICA_7);
		aggiungiSpaziVuoti(paragraph, 5);
		aggiungiTesto(paragraph, "prov. " + ConvertUtil.getStringValid(provinciaManut), 0);
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.RIGHT);
		cell.setColspan(2);
		tabella.addCell(cell);

		document.add(tabella); //AGGIUNGO LA TABELLA NEL DOCUMENTO
		log.debug("[ReeBuilder] - aggiungiResponsabileEManutentore - end");

	}

	private static void aggiungiDocumentazioneCorredo(Document document, SigitTAllegatoDto allegato) throws DocumentException {

		log.debug("[ReeBuilder] - aggiungiDocumentazioneCorredo - start");

		//Suddivido il foglio in sezioni, cioè in questo caso, un foglio 100% viene diviso in due sezioni, su 8 la prima è larga 2 e l'altra larga 6. Le sezioni possono essere anche di più spartizioni, basta solo aggiungere un valore dopo la virgola es. {3,3,3} suddividiamo in tre sezioni uguali tra di loro.
		float[] columnWidths = { 30, 20, 30, 20 };

		PdfPTable tabella = new PdfPTable(columnWidths);
		//Definisco la tabella con il 100%, il bordo,e il margine sinis
		//tabella.setSpacingBefore(8);      

		tabella.setWidthPercentage(100);
		tabella.getDefaultCell().setBorder(1);

		tabella.getDefaultCell().setPaddingLeft(PADDING_LEFT);

		PdfPCell cell;

		tabella.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);

		addEmptyCell(tabella, 4, Rectangle.LEFT | Rectangle.RIGHT);

		// riga1
		cell = new PdfPCell(new Paragraph("B. DOCUMENTAZIONE TECNICA A CORREDO", FONT_HELVETICA_7_B));
		cell.setColspan(4);
		cell.setBorder(Rectangle.LEFT | Rectangle.RIGHT);

		tabella.addCell(cell);

		// riga2
		Paragraph paragraph = new Paragraph("Dichiarazione di Conformita' presente", FONT_HELVETICA_7);
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.LEFT);
		tabella.addCell(cell);

		//		System.out.println("Stampo getBFlgDichiarConform: "+ConvertUtil.convertToBooleanAllways(allegato.getBFlgDichiarConform()));

		paragraph = new Paragraph("", FONT_HELVETICA_7);
		aggiungiCheckSi(paragraph, GenericUtil.getCheckSi(allegato.getBFlgDichiarConform()));
		aggiungiCheckNo(paragraph, GenericUtil.getCheckNo(allegato.getBFlgDichiarConform()));

		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.NO_BORDER);
		tabella.addCell(cell);

		paragraph = new Paragraph("Libretti uso/manutenzione generatore presenti", FONT_HELVETICA_7);
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.NO_BORDER);
		tabella.addCell(cell);

		paragraph = new Paragraph("", FONT_HELVETICA_7);
		aggiungiCheckSi(paragraph, GenericUtil.getCheckSi(allegato.getBFlgLibrettoUso()));
		aggiungiCheckNo(paragraph, GenericUtil.getCheckNo(allegato.getBFlgLibrettoUso()));

		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.RIGHT);
		tabella.addCell(cell);

		// riga3
		paragraph = new Paragraph("Libretto impianto presente", FONT_HELVETICA_7);
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.LEFT);
		tabella.addCell(cell);

		paragraph = new Paragraph("", FONT_HELVETICA_7);
		aggiungiCheckSi(paragraph, GenericUtil.getCheckSi(allegato.getBFlgLibImp()));
		aggiungiCheckNo(paragraph, GenericUtil.getCheckNo(allegato.getBFlgLibImp()));

		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.NO_BORDER);
		tabella.addCell(cell);

		paragraph = new Paragraph("Libretto compilato in tutte le sue parti", FONT_HELVETICA_7);
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.NO_BORDER);
		tabella.addCell(cell);

		paragraph = new Paragraph("", FONT_HELVETICA_7);
		aggiungiCheckSi(paragraph, GenericUtil.getCheckSi(allegato.getBFlgLibCompl()));
		aggiungiCheckNo(paragraph, GenericUtil.getCheckNo(allegato.getBFlgLibCompl()));

		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.RIGHT);
		tabella.addCell(cell);

		document.add(tabella); //AGGIUNGO LA TABELLA NEL DOCUMENTO

		log.debug("[ReeBuilder] - aggiungiDocumentazioneCorredo - end");

	}

	/******/

	// REE Tipo 2 - GF (Gruppi frigo)
	public DettaglioDocumento generaReeGf(DettaglioAllegato dettAllegato, boolean isSimul, boolean isBozza) {
		gestDebug(isSimul, "generaReeGf - START");

		DettaglioDocumento dettDoc = new DettaglioDocumento();
		try {
			String idAllegato = null;
			SigitTImpiantoDto impianto = null;
			DatiGFCommon allegato2Common = null;
			SigitTAllegatoDto allegato = null;
			List<SigitTUnitaImmobiliareDto> unitaImmobiliareList = null;
			List<SigitVSk4GfDto> allegatoCompGfList = null;
			List<SigitTDettTipo2Dto> tDettTipo2List = null;
			SigitTPersonaGiuridicaDto pgManut = null;
			SigitTRappTipo2Dto rappTipo2Dto = null;

			if (!isSimul) { //recupero dati dal sistema
				idAllegato = ConvertUtil.convertToString(dettAllegato.getIdAllegato());
				allegato2Common = getServiceManager().cercaDatiAllegato2Common(dettAllegato);
				allegato = allegato2Common.getAllegatoDto();
				unitaImmobiliareList = allegato2Common.getUnitaImmobiliareList();
				allegatoCompGfList = allegato2Common.getSk4GfDtoList();
				rappTipo2Dto = getDbServiceImp().cercaTRappTipo2ById(allegato.getIdAllegato());
				pgManut = getDbServiceImp().cercaTPersonaGiuridicaById(ConvertUtil.convertToInteger(dettAllegato.getPersonaGiuridica().getIdPersonaGiuridica()));
			} else { //utilizzo un mock
				allegato2Common = new DatiGFCommon();
				impianto = new SigitTImpiantoDto();
				allegatoCompGfList = new ArrayList<SigitVSk4GfDto>();

				SigitVSk4GfDto sk4GfDto = new SigitVSk4GfDto();
				sk4GfDto.setDesMarca("NUOVO FABBRICANTE");
				sk4GfDto.setModello("NUOVO MODELLO");
				sk4GfDto.setMatricola("N. NUOVA_MATRICOLA_1234567890");
				sk4GfDto.setNCircuiti(BigDecimal.TEN);
				sk4GfDto.setFkDettaglioGf(BigDecimal.ONE);

				sk4GfDto.setRaffPotenzaKw(new BigDecimal(2));
				sk4GfDto.setRiscPotenzaKw(new BigDecimal(5));

				SigitVSk4GfDto sk4GfDtoA = new SigitVSk4GfDto();
				sk4GfDtoA.setDesMarca("ALTRO FABBRICANTE");
				sk4GfDtoA.setModello("ALTRO MODELLO");
				sk4GfDtoA.setMatricola("ALTRO N. NUOVA_MATRICOLA_1234567890");
				sk4GfDtoA.setNCircuiti(BigDecimal.TEN);
				sk4GfDtoA.setFkDettaglioGf(BigDecimal.ONE);

				sk4GfDtoA.setRaffPotenzaKw(new BigDecimal(2));
				sk4GfDtoA.setRiscPotenzaKw(new BigDecimal(5));

				allegatoCompGfList.add(sk4GfDto);
				allegatoCompGfList.add(sk4GfDtoA);

				allegato2Common.setImpiantoDto(new SigitTImpiantoDto());
				allegato2Common.setAllegatoDto(new SigitTAllegatoDto());
				//allegato1Common.setPersonaFisicaDto(new SigitTPersonaFisicaDto());

				SigitTPersonaGiuridicaDto pg = new SigitTPersonaGiuridicaDto();
				pg.setDenominazione("MIA IMPRESA");
				allegato2Common.setPersonaGiuridicaDto(pg);

				allegato2Common.setTerzoResp(false);
				allegato2Common.setRuolo(Constants.ID_RUOLO_OCCUPANTE);

				allegato2Common.setDettaglioTrattAcquaDto(new SigitTTrattH2ODto());
				allegato = new SigitTAllegatoDto();
				allegato.setFkTipoDocumento(ConvertUtil.convertToBigDecimal(Constants.ALLEGATO_TIPO_2));
				allegato.setAPotenzaTermicaNominaleMax(new BigDecimal(15));
				allegato.setBFlgDichiarConform(BigDecimal.ONE);
				allegato.setBFlgLibrettoUso(BigDecimal.ONE);
				allegato.setBFlgLibImp(BigDecimal.ZERO);
				allegato.setBFlgLibCompl(BigDecimal.ZERO);

				allegato2Common.setAllegatoDto(allegato);
				pgManut = new SigitTPersonaGiuridicaDto();

				rappTipo2Dto = new SigitTRappTipo2Dto();
				unitaImmobiliareList = new ArrayList<SigitTUnitaImmobiliareDto>();
				unitaImmobiliareList.add(new SigitTUnitaImmobiliareDto());
			}

			Document document = creaDocumentoRee();
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			PdfWriter writer = PdfWriter.getInstance(document, outputStream);

			PDFReeEventListener event = new PDFReeEventListener(ConvertUtil.convertToString(allegato.getFkTipoDocumento()), ConvertUtil.formattaSiglaBollino(allegato.getFkNumeroBollino()), isBozza, true);
			writer.setPageEvent(event);

			document.open();
			addCodDocPerFirma(document, idAllegato);
			Paragraph par = new Paragraph("RAPPORTO DI CONTROLLO DI EFFICIENZA ENERGETICA TIPO 2 (gruppi frigo)", FONT_HELVETICA_8_B);
			par.setAlignment(Element.ALIGN_CENTER);
			document.add(par);

			aggiungiDatiIdentificativi(document, allegato2Common.getImpiantoDto(), allegato2Common.getAllegatoDto(), unitaImmobiliareList);
			aggiungiResponsabileEManutentore(document, allegato2Common.getPersonaFisicaDto(), allegato2Common.getPersonaGiuridicaDto(), allegato2Common.ruolo, allegato2Common.isTerzoResp, pgManut);
			aggiungiDocumentazioneCorredo(document, allegato);

			aggiungiTrattamentoAcquaGf(document, rappTipo2Dto, allegato2Common.getDettaglioTrattAcquaDto());
			aggiungiControlloImpiantoGf(document, rappTipo2Dto);

			for (SigitVSk4GfDto vSk4GfDto : allegatoCompGfList) {
				if (!isSimul)
					tDettTipo2List = getDbServiceImp().getDettTipo2(ConvertUtil.convertToString(vSk4GfDto.getCodiceImpianto()), ConvertUtil.convertToInteger(vSk4GfDto.getProgressivo()), idAllegato);
				else {
					tDettTipo2List = new ArrayList<SigitTDettTipo2Dto>();
					SigitTDettTipo2Dto tDettTipo2_A = new SigitTDettTipo2Dto();
					tDettTipo2_A.setENCircuito("1");
					tDettTipo2List.add(tDettTipo2_A);

					SigitTDettTipo2Dto tDettTipo2_B = new SigitTDettTipo2Dto();
					tDettTipo2_B.setENCircuito("2");
					tDettTipo2List.add(tDettTipo2_B);

					SigitTDettTipo2Dto tDettTipo2_C = new SigitTDettTipo2Dto();
					tDettTipo2_C.setENCircuito("333");
					tDettTipo2List.add(tDettTipo2_C);
				}
				aggiungiControlloEVerificaEnergeticaGf(document, tDettTipo2List.get(0), vSk4GfDto);
				aggiungiCircuitiGf(document, tDettTipo2List);
			}

			aggiungiCheckListGf(document, rappTipo2Dto);
			aggiungiConclusione(document, allegato);

			outputStream.flush();
			if (document.isOpen())
				document.close();
			outputStream.close();

			byte[] thePdfIText = outputStream.toByteArray();

			dettDoc.setFile(thePdfIText);
			dettDoc.setNomeDocumento("ReeGF_IText.pdf");

		} catch (Exception docEx) {
			gestError(isSimul, docEx.getMessage(), docEx);
		}

		gestDebug(isSimul, "generaReeGf - END");
		return dettDoc;
	}

	/***METODI SPECIFICI REE TIPO 2 - (Gruppi frigo) ***/

	//C. TRATTAMENTO DELL'ACQUA
	private static void aggiungiTrattamentoAcquaGf(Document document, SigitTRappTipo2Dto rappTipo2Dto, SigitTTrattH2ODto h2O) throws DocumentException {

		float[] columnWidths = { 25, 20, 55 };

		PdfPTable tabella = new PdfPTable(columnWidths);
		tabella.setWidthPercentage(100);
		tabella.getDefaultCell().setBorder(1);
		tabella.getDefaultCell().setPaddingLeft(PADDING_LEFT);

		PdfPCell cell;
		tabella.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);

		addEmptyCell(tabella, 3, Rectangle.LEFT | Rectangle.RIGHT);

		// riga1
		cell = new PdfPCell(new Paragraph("C. TRATTAMENTO DELL'ACQUA", FONT_HELVETICA_7_B));
		cell.setColspan(3);
		cell.setBorder(Rectangle.LEFT | Rectangle.RIGHT);
		tabella.addCell(cell);

		// riga2
		Paragraph paragraph = new Paragraph("Durezza totale dell'acqua ", FONT_HELVETICA_7);
		paragraph.add(h2O != null ? ConvertUtil.getStringValid(h2O.getL22DurezzaH2oFr()) : ""); // JIRA SIGIT-667

		paragraph.add("(\u00B0fr)");
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.LEFT);
		tabella.addCell(cell);

		paragraph = new Paragraph("Trattamento: ", FONT_HELVETICA_7);
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
		tabella.addCell(cell);

		paragraph = new Paragraph("", FONT_HELVETICA_7);
		aggiungiCheckPrima(paragraph, "non richiesto", GenericUtil.getCheckSi(rappTipo2Dto.getCFlgTrattClimaNonRichiest()), 15);
		aggiungiCheckPrima(paragraph, "assente", (h2O != null ? GenericUtil.getCheckSi(h2O.getL23FlgTrattClimaAssente()) : false), 15);
		aggiungiCheckPrima(paragraph, "filtrazione", (h2O != null ? GenericUtil.getCheckSi(h2O.getL23FlgTrattClimaFiltr()) : false), 15);
		aggiungiCheckPrima(paragraph, "addolcimento", (h2O != null ? GenericUtil.getCheckSi(h2O.getL23FlgTrattClimaAddolc()) : false), 15);
		aggiungiCheckPrima(paragraph, "condiz. Chimico", (h2O != null ? GenericUtil.getCheckSi(h2O.getL23FlgTrattClimaChimico()) : false), 15);

		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.RIGHT);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		tabella.addCell(cell);

		document.add(tabella);
	}

	//D. CONTROLLO DELL'IMPIANTO (ESAMI VISIVI)
	private static void aggiungiControlloImpiantoGf(Document document, SigitTRappTipo2Dto rappTipo2Dto) throws DocumentException {

		float[] columnWidths = { 35, 15, 35, 15 };

		PdfPTable tabella = new PdfPTable(columnWidths);
		tabella.setWidthPercentage(100);
		tabella.getDefaultCell().setBorder(1);
		tabella.getDefaultCell().setPaddingLeft(PADDING_LEFT);

		PdfPCell cell;
		tabella.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);

		addEmptyCell(tabella, 4, Rectangle.LEFT | Rectangle.RIGHT);

		// riga1
		cell = new PdfPCell(new Paragraph("D. CONTROLLO DELL'IMPIANTO", FONT_HELVETICA_7_B));
		cell.setColspan(4);
		cell.setBorder(Rectangle.LEFT | Rectangle.RIGHT);
		tabella.addCell(cell);

		// riga2 : locale di installazione idoneo + linee elettriche idonee
		Paragraph paragraph = new Paragraph("Locale di installazione idoneo", FONT_HELVETICA_7);
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.LEFT);
		tabella.addCell(cell);

		paragraph = new Paragraph("", FONT_HELVETICA_7);
		aggiungiCheckSi(paragraph, GenericUtil.getCheckSi(rappTipo2Dto.getDFlgLocaleIdoneo()));
		aggiungiCheckNo(paragraph, GenericUtil.getCheckNo(rappTipo2Dto.getDFlgLocaleIdoneo()));
		aggiungiCheckPrima(paragraph, "NC", GenericUtil.getCheckNc(rappTipo2Dto.getDFlgLocaleIdoneo()));

		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.NO_BORDER);
		tabella.addCell(cell);

		paragraph = new Paragraph("Linee elettriche idonee", FONT_HELVETICA_7);
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.NO_BORDER);
		tabella.addCell(cell);

		paragraph = new Paragraph("", FONT_HELVETICA_7);
		aggiungiCheckSi(paragraph, GenericUtil.getCheckSi(rappTipo2Dto.getDFlgLineaElettIdonea()));
		aggiungiCheckNo(paragraph, GenericUtil.getCheckNo(rappTipo2Dto.getDFlgLineaElettIdonea()));
		aggiungiCheckPrima(paragraph, "NC", GenericUtil.getCheckNc(rappTipo2Dto.getDFlgLineaElettIdonea()));

		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.RIGHT);
		tabella.addCell(cell);

		// riga3 : dimensioni aperture + coibentazioni idonee
		paragraph = new Paragraph("Dimensioni aperture di ventilazione adeguate", FONT_HELVETICA_7);
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.LEFT);
		tabella.addCell(cell);

		paragraph = new Paragraph("", FONT_HELVETICA_7);
		aggiungiCheckSi(paragraph, GenericUtil.getCheckSi(rappTipo2Dto.getDFlgApertureAdeg()));
		aggiungiCheckNo(paragraph, GenericUtil.getCheckNo(rappTipo2Dto.getDFlgApertureAdeg()));
		aggiungiCheckPrima(paragraph, "NC", GenericUtil.getCheckNc(rappTipo2Dto.getDFlgApertureAdeg()));

		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.NO_BORDER);
		tabella.addCell(cell);

		paragraph = new Paragraph("Coibentazioni idonee", FONT_HELVETICA_7);
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.NO_BORDER);
		tabella.addCell(cell);

		paragraph = new Paragraph("", FONT_HELVETICA_7);
		aggiungiCheckSi(paragraph, GenericUtil.getCheckSi(rappTipo2Dto.getDFlgCoibIdonea()));
		aggiungiCheckNo(paragraph, GenericUtil.getCheckNo(rappTipo2Dto.getDFlgCoibIdonea()));
		aggiungiCheckPrima(paragraph, "NC", GenericUtil.getCheckNc(rappTipo2Dto.getDFlgCoibIdonea()));

		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.RIGHT);
		tabella.addCell(cell);

		// riga 4 aperture ventilazioni libere
		paragraph = new Paragraph("Aperture di ventilazione libere da ostruzioni", FONT_HELVETICA_7);
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.LEFT);
		tabella.addCell(cell);

		paragraph = new Paragraph("", FONT_HELVETICA_7);
		aggiungiCheckSi(paragraph, GenericUtil.getCheckSi(rappTipo2Dto.getDFlgApertureLibere()));
		aggiungiCheckNo(paragraph, GenericUtil.getCheckNo(rappTipo2Dto.getDFlgApertureLibere()));
		aggiungiCheckPrima(paragraph, "NC", GenericUtil.getCheckNc(rappTipo2Dto.getDFlgApertureLibere()));

		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.NO_BORDER);
		tabella.addCell(cell);

		paragraph = new Paragraph("", FONT_HELVETICA_7);
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.NO_BORDER);
		tabella.addCell(cell);

		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.RIGHT);
		tabella.addCell(cell);

		document.add(tabella);
	}

	//E. CONTROLLO E VERIFICA ENERGETICA GRUPPO FRIGO
	private static void aggiungiControlloEVerificaEnergeticaGf(Document document, SigitTDettTipo2Dto dettTipo2, SigitVSk4GfDto vSk4GfDto) throws DocumentException {

		float[] firstColumnWidths = { 50, 50 };

		PdfPTable tabella = new PdfPTable(firstColumnWidths);
		tabella.setWidthPercentage(100);
		tabella.getDefaultCell().setBorder(1);
		tabella.getDefaultCell().setPaddingLeft(PADDING_LEFT);
		tabella.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);

		addEmptyCell(tabella, 2, Rectangle.LEFT | Rectangle.RIGHT);

		// riga1
		Phrase phrase = new Phrase();
		phrase.add(new Chunk("E. CONTROLLO E VERIFICA ENERGETICA DEL GRUPPO FRIGO ", FONT_HELVETICA_7_B));
		phrase.add(new Chunk("GF ", FONT_HELVETICA_7));
		phrase.add(new Chunk(ConvertUtil.getStringValid(vSk4GfDto.getProgressivo()), FONT_HELVETICA_7_B));
		PdfPCell cell;
		cell = new PdfPCell(phrase);
		cell.setColspan(2);
		cell.setBorder(Rectangle.LEFT | Rectangle.RIGHT);
		tabella.addCell(cell);

		// riga2
		Paragraph paragraph = new Paragraph("", FONT_HELVETICA_7);
		aggiungiTesto(paragraph, "Fabbricante", 14);
		paragraph.add(ConvertUtil.getStringValid(vSk4GfDto.getDesMarca()));
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.LEFT);
		tabella.addCell(cell);

		paragraph = new Paragraph("", FONT_HELVETICA_7);
		aggiungiCheckPrima(paragraph, "Ad assorbimento per recupero del calore", Constants.ID_DETT_GF_ASS_REC_CALORE.equals(ConvertUtil.convertToString(vSk4GfDto.getFkDettaglioGf())));
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.RIGHT);
		tabella.addCell(cell);

		// riga3
		paragraph = new Paragraph("", FONT_HELVETICA_7);
		aggiungiTesto(paragraph, "Modello", 14);
		paragraph.add(ConvertUtil.getStringValid(vSk4GfDto.getModello()));
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.LEFT);
		tabella.addCell(cell);

		paragraph = new Paragraph("", FONT_HELVETICA_7);
		aggiungiCheckPrima(paragraph, "Ad assorbimento a fiamma diretta con combustibile", Constants.ID_DETT_GF_ASS_FIAMM_COMB.equals(ConvertUtil.convertToString(vSk4GfDto.getFkDettaglioGf())));
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.RIGHT);
		tabella.addCell(cell);

		// riga4
		paragraph = new Paragraph("", FONT_HELVETICA_7);
		aggiungiTesto(paragraph, "Matricola", 14);
		paragraph.add(ConvertUtil.getStringValid(vSk4GfDto.getMatricola()));
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.LEFT);
		tabella.addCell(cell);

		paragraph = new Paragraph("", FONT_HELVETICA_7);
		aggiungiCheckPrima(paragraph, "A ciclo di compressione con motore elettrico o endotermico", Constants.ID_DETT_GF_CICLO_COMPRESS.equals(ConvertUtil.convertToString(vSk4GfDto.getFkDettaglioGf())));
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.RIGHT);
		tabella.addCell(cell);

		float[] secColumnWidths = { 50, 35, 15 };

		PdfPTable tabellaSec = new PdfPTable(secColumnWidths);
		tabellaSec.setWidthPercentage(100);
		tabellaSec.getDefaultCell().setBorder(1);
		tabellaSec.getDefaultCell().setPaddingLeft(PADDING_LEFT);
		tabellaSec.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);

		//riga5
		paragraph = new Paragraph("", FONT_HELVETICA_7);
		aggiungiTesto(paragraph, "N\u00B0 circuiti", 14);
		paragraph.add(ConvertUtil.getStringValid((vSk4GfDto.getNCircuiti())));
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.LEFT);
		tabellaSec.addCell(cell);

		paragraph = new Paragraph("Assenza perdite di gas refrigerante", FONT_HELVETICA_7);
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.NO_BORDER);
		tabellaSec.addCell(cell);

		paragraph = new Paragraph("", FONT_HELVETICA_7);
		aggiungiCheckSi(paragraph, GenericUtil.getCheckSi(dettTipo2.getEFlgPerditaGas()));
		aggiungiCheckNo(paragraph, GenericUtil.getCheckNo(dettTipo2.getEFlgPerditaGas()));
		aggiungiCheckPrima(paragraph, "NC", GenericUtil.getCheckNc(dettTipo2.getEFlgPerditaGas()));

		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.RIGHT);
		tabellaSec.addCell(cell);

		//riga6
		paragraph = new Paragraph("", FONT_HELVETICA_7);
		aggiungiTesto(paragraph, "Pot. frigorifera nominale in raffrescamento", 14);
		aggiungiSpaziVuoti(paragraph, 3);
		paragraph.add(ConvertUtil.getStringValid((vSk4GfDto.getRaffPotenzaKw())));
		paragraph.add(" (kW)");
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.LEFT);
		tabellaSec.addCell(cell);

		paragraph = new Paragraph("Presenza apparecchiatura automatica rilevazione diretta fughe refrigerante (leak detector)", FONT_HELVETICA_7);
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.NO_BORDER);
		tabellaSec.addCell(cell);

		paragraph = new Paragraph("", FONT_HELVETICA_7);
		aggiungiCheckSi(paragraph, GenericUtil.getCheckSi(dettTipo2.getEFlgLeakDetector()));
		aggiungiCheckNo(paragraph, GenericUtil.getCheckNo(dettTipo2.getEFlgLeakDetector()));
		aggiungiCheckPrima(paragraph, "NC", GenericUtil.getCheckNc(dettTipo2.getEFlgLeakDetector()));

		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.RIGHT);
		tabellaSec.addCell(cell);

		//riga7
		paragraph = new Paragraph("", FONT_HELVETICA_7);
		aggiungiTesto(paragraph, "Pot. termica nominale in riscaldamento", 14);
		aggiungiSpaziVuoti(paragraph, 3);
		paragraph.add(ConvertUtil.getStringValid((vSk4GfDto.getRiscPotenzaKw())));
		paragraph.add(" (kW)");
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.LEFT);
		tabellaSec.addCell(cell);

		paragraph = new Paragraph("Presenza apparecchiatura automatica rilevazione indiretta fughe refrigerante (parametri termodinamici)", FONT_HELVETICA_7);
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.NO_BORDER);
		tabellaSec.addCell(cell);

		paragraph = new Paragraph("", FONT_HELVETICA_7);
		aggiungiCheckSi(paragraph, GenericUtil.getCheckSi(dettTipo2.getEFlgParamTermodinam()));
		aggiungiCheckNo(paragraph, GenericUtil.getCheckNo(dettTipo2.getEFlgParamTermodinam()));
		aggiungiCheckPrima(paragraph, "NC", GenericUtil.getCheckNc(dettTipo2.getEFlgParamTermodinam()));

		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.RIGHT);
		tabellaSec.addCell(cell);

		//riga8
		paragraph = new Paragraph("", FONT_HELVETICA_7);
		aggiungiTesto(paragraph, "Prova eseguita in modalita': ", 14);
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.LEFT);

		aggiungiSpaziVuoti(paragraph, 5);
		aggiungiCheckPrima(paragraph, "raffrescamento", Constants.FLAG_MODALITA_RAFFRESCAMENTO.equals(dettTipo2.getEFlgModProva()));
		aggiungiSpaziVuoti(paragraph, 5);
		aggiungiCheckPrima(paragraph, "riscaldamento", Constants.FLAG_MODALITA_RISCALDAMENTO.equals(dettTipo2.getEFlgModProva()));
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.LEFT);
		tabellaSec.addCell(cell);

		paragraph = new Paragraph("Scambiatori di calore puliti e liberi da incrostazioni", FONT_HELVETICA_7);
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.NO_BORDER);
		tabellaSec.addCell(cell);

		paragraph = new Paragraph("", FONT_HELVETICA_7);
		aggiungiCheckSi(paragraph, GenericUtil.getCheckSi(dettTipo2.getEFlgIncrostazioni()));
		aggiungiCheckNo(paragraph, GenericUtil.getCheckNo(dettTipo2.getEFlgIncrostazioni()));
		aggiungiCheckPrima(paragraph, "NC", GenericUtil.getCheckNc(dettTipo2.getEFlgIncrostazioni()));

		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.RIGHT);
		tabellaSec.addCell(cell);

		document.add(tabella);
		document.add(tabellaSec);
	}

	//E. CIRCUITI GRUPPO FRIGO
	private static void aggiungiCircuitiGf(Document document, List<SigitTDettTipo2Dto> listTDettTipo2) throws DocumentException {

		float[] columnWidths = { 8, 10, 8, 8, 14, 15, 15, 15, 7 };

		PdfPTable tabella = new PdfPTable(columnWidths);
		tabella.setWidthPercentage(100);
		tabella.getDefaultCell().setBorder(1);
		tabella.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
		tabella.getDefaultCell().setPaddingLeft(PADDING_LEFT);

		PdfPCell cell;
		int listLastElement = listTDettTipo2.size() - 1;
		for (int i = 0; i < listTDettTipo2.size(); i++) {

			SigitTDettTipo2Dto tDettTipo2 = listTDettTipo2.get(i);

			// riga intestazioni

			Paragraph paragraph = new Paragraph("Surriscald. (\u00B0C)", FONT_HELVETICA_7);
			cell = new PdfPCell(paragraph);
			cell.setBorder(Rectangle.LEFT | Rectangle.TOP);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			tabella.addCell(cell);

			paragraph = new Paragraph("Sottoraffredd. (\u00B0C)", FONT_HELVETICA_7);
			cell = new PdfPCell(paragraph);
			cell.setBorder(Rectangle.TOP);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			tabella.addCell(cell);

			paragraph = new Paragraph("T condens. (\u00B0C)", FONT_HELVETICA_7);
			cell = new PdfPCell(paragraph);
			cell.setBorder(Rectangle.TOP);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			tabella.addCell(cell);

			paragraph = new Paragraph("T evapor. (\u00B0C)", FONT_HELVETICA_7);
			cell = new PdfPCell(paragraph);
			cell.setBorder(Rectangle.TOP);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			tabella.addCell(cell);

			paragraph = new Paragraph("T. ing.lato est. (\u00B0C)", FONT_HELVETICA_7);
			cell = new PdfPCell(paragraph);
			cell.setBorder(Rectangle.TOP);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			tabella.addCell(cell);

			paragraph = new Paragraph("T usc.lato est. (\u00B0C)", FONT_HELVETICA_7);
			cell = new PdfPCell(paragraph);
			cell.setBorder(Rectangle.TOP);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			tabella.addCell(cell);

			paragraph = new Paragraph("T ing.lato utenze (\u00B0C)", FONT_HELVETICA_7);
			cell = new PdfPCell(paragraph);
			cell.setBorder(Rectangle.TOP);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			tabella.addCell(cell);

			paragraph = new Paragraph("T usc.lato utenze (\u00B0C)", FONT_HELVETICA_7);
			cell = new PdfPCell(paragraph);
			cell.setBorder(Rectangle.TOP);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			tabella.addCell(cell);

			paragraph = new Paragraph("N\u00B0 circuito", FONT_HELVETICA_7);
			cell = new PdfPCell(paragraph);
			cell.setBorder(Rectangle.RIGHT | Rectangle.TOP);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			tabella.addCell(cell);

			//riga valori

			paragraph = new Paragraph(ConvertUtil.getStringValid((tDettTipo2.getETSurriscC())), FONT_HELVETICA_7);
			cell = new PdfPCell(paragraph);
			if (i == listLastElement) {
				cell.setBorder(Rectangle.LEFT | Rectangle.BOTTOM);
			} else {
				cell.setBorder(Rectangle.LEFT);
			}

			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			tabella.addCell(cell);

			paragraph = new Paragraph(ConvertUtil.getStringValid((tDettTipo2.getETSottorafC())), FONT_HELVETICA_7);
			cell = new PdfPCell(paragraph);
			if (i == listLastElement) {
				cell.setBorder(Rectangle.BOTTOM);
			} else {
				cell.setBorder(Rectangle.NO_BORDER);
			}
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			tabella.addCell(cell);

			paragraph = new Paragraph(ConvertUtil.getStringValid((tDettTipo2.getETCondensazioneC())), FONT_HELVETICA_7);
			cell = new PdfPCell(paragraph);
			if (i == listLastElement) {
				cell.setBorder(Rectangle.BOTTOM);
			} else {
				cell.setBorder(Rectangle.NO_BORDER);
			}
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			tabella.addCell(cell);

			paragraph = new Paragraph(ConvertUtil.getStringValid((tDettTipo2.getETEvaporazioneC())), FONT_HELVETICA_7);
			cell = new PdfPCell(paragraph);
			if (i == listLastElement) {
				cell.setBorder(Rectangle.BOTTOM);
			} else {
				cell.setBorder(Rectangle.NO_BORDER);
			}
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			tabella.addCell(cell);

			paragraph = new Paragraph("", FONT_HELVETICA_7);

			paragraph = new Paragraph(ConvertUtil.getStringValid((tDettTipo2.getETInExtC())), FONT_HELVETICA_7);
			cell = new PdfPCell(paragraph);
			if (i == listLastElement) {
				cell.setBorder(Rectangle.BOTTOM);
			} else {
				cell.setBorder(Rectangle.NO_BORDER);
			}
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			tabella.addCell(cell);

			paragraph = new Paragraph(ConvertUtil.getStringValid((tDettTipo2.getETOutExtC())), FONT_HELVETICA_7);
			cell = new PdfPCell(paragraph);
			if (i == listLastElement) {
				cell.setBorder(Rectangle.BOTTOM);
			} else {
				cell.setBorder(Rectangle.NO_BORDER);
			}
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			tabella.addCell(cell);

			paragraph = new Paragraph(ConvertUtil.getStringValid((tDettTipo2.getETInUtenzeC())), FONT_HELVETICA_7);
			cell = new PdfPCell(paragraph);
			if (i == listLastElement) {
				cell.setBorder(Rectangle.BOTTOM);
			} else {
				cell.setBorder(Rectangle.NO_BORDER);
			}
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			tabella.addCell(cell);

			paragraph = new Paragraph(ConvertUtil.getStringValid((tDettTipo2.getETOutUtenzeC())), FONT_HELVETICA_7);
			cell = new PdfPCell(paragraph);
			if (i == listLastElement) {
				cell.setBorder(Rectangle.BOTTOM);
			} else {
				cell.setBorder(Rectangle.NO_BORDER);
			}
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			tabella.addCell(cell);

			paragraph = new Paragraph(ConvertUtil.getStringValid(tDettTipo2.getENCircuito()), FONT_HELVETICA_7);
			cell = new PdfPCell(paragraph);
			if (i == listLastElement) {
				cell.setBorder(Rectangle.BOTTOM | Rectangle.RIGHT);
			} else {
				cell.setBorder(Rectangle.NO_BORDER);
			}
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			tabella.addCell(cell);
		}

		document.add(tabella);
	}

	//F. CHECKLIST
	private static void aggiungiCheckListGf(Document document, SigitTRappTipo2Dto rappTipo2Dto) throws DocumentException {

		float[] columnWidths = { 20, 80 };

		PdfPTable tabella = new PdfPTable(columnWidths);
		tabella.setWidthPercentage(100);
		tabella.getDefaultCell().setBorder(1);
		tabella.getDefaultCell().setPaddingLeft(PADDING_LEFT);

		PdfPCell cell;
		tabella.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);

		addEmptyCell(tabella, 2, Rectangle.LEFT | Rectangle.RIGHT);

		// riga1
		cell = new PdfPCell(new Paragraph("F. CHECK-LIST", FONT_HELVETICA_7_B));
		cell.setColspan(2);
		cell.setBorder(Rectangle.LEFT | Rectangle.RIGHT);

		tabella.addCell(cell);

		// riga2
		Paragraph paragraph = new Paragraph(
				"Elenco di possibili interventi, dei quali va valutata la convenienza economica, che qualora applicabili all'impianto, potrebbero comportare un miglioramento\r\n"
						+ "della prestazione energetica:", FONT_HELVETICA_7);
		cell = new PdfPCell(paragraph);
		cell.setColspan(2);
		cell.setBorder(Rectangle.LEFT | Rectangle.RIGHT);
		tabella.addCell(cell);

		// riga3
		paragraph = new Paragraph("", FONT_HELVETICA_7);
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.LEFT);
		tabella.addCell(cell);

		paragraph = new Paragraph("", FONT_HELVETICA_7);
		aggiungiCheckPrima(paragraph, "la sostituzione di generatori a regolazione on/off, con altri di pari potenza a piu' gradini o a regolazione continua.\n", GenericUtil.getCheckSi(rappTipo2Dto.getFFlgSostituzGeneratori()));
		aggiungiCheckPrima(paragraph, "la sostituzione dei sistemi di regolazione on/off con sistemi programmabili su piu' livelli di temperatura.\n", GenericUtil.getCheckSi(rappTipo2Dto.getFFlgSostituzSistemiReg()));
		aggiungiCheckPrima(paragraph, "l'isolamento della rete di distribuzione acqua refrigerata/calda nei locali non climatizzati.\n", GenericUtil.getCheckSi(rappTipo2Dto.getFFlgIsolDistribuzH2o()));
		aggiungiCheckPrima(paragraph, "l'isolamento dei canali di distribuzione aria fredda/calda nei locali non climatizzati", GenericUtil.getCheckSi(rappTipo2Dto.getFFlgIsolDistribuzAria()));

		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.RIGHT);
		tabella.addCell(cell);

		document.add(tabella);
	}

	/******/

	// REE Tipo 3 - SC (Scambiatori)
	public DettaglioDocumento generaReeSc(DettaglioAllegato dettAllegato, boolean isSimul, boolean isBozza) {
		gestDebug(isSimul, "generaReeSc - START");

		DettaglioDocumento dettDoc = new DettaglioDocumento();
		try {
			String idAllegato = null;
			SigitTImpiantoDto impianto = null;
			DatiSCCommon allegato3Common = null;
			SigitTAllegatoDto allegato = null;
			List<SigitTUnitaImmobiliareDto> unitaImmobiliareList = null;
			List<SigitVSk4ScDto> allegatoCompScList = null;
			List<SigitTDettTipo3Dto> tDettTipo3List = null;
			SigitTPersonaGiuridicaDto pgManut = null;
			SigitTRappTipo3Dto rappTipo3Dto = null;

			if (!isSimul) { //recupero dati dal sistema
				idAllegato = ConvertUtil.convertToString(dettAllegato.getIdAllegato());
				allegato3Common = getServiceManager().cercaDatiAllegato3Common(dettAllegato);
				allegato = allegato3Common.getAllegatoDto();
				unitaImmobiliareList = allegato3Common.getUnitaImmobiliareList();
				allegatoCompScList = allegato3Common.getSk4ScDtoList();
				rappTipo3Dto = getDbServiceImp().cercaTRappTipo3ById(allegato.getIdAllegato());
				pgManut = getDbServiceImp().cercaTPersonaGiuridicaById(ConvertUtil.convertToInteger(dettAllegato.getPersonaGiuridica().getIdPersonaGiuridica()));
			} else { //utilizzo un mock
				allegato3Common = new DatiSCCommon();
				impianto = new SigitTImpiantoDto();
				allegatoCompScList = new ArrayList<SigitVSk4ScDto>();

				SigitVSk4ScDto sk4ScDto = new SigitVSk4ScDto();
				sk4ScDto.setDesMarca("NUOVO FABBRICANTE");
				sk4ScDto.setModello("NUOVO MODELLO");
				sk4ScDto.setMatricola("N. NUOVA_MATRICOLA_1234567890");
				sk4ScDto.setPotenzaTermicaKw(BigDecimal.valueOf(25));
				sk4ScDto.setProgressivo(BigDecimal.ONE);

				allegatoCompScList.add(sk4ScDto);

				allegato3Common.setImpiantoDto(new SigitTImpiantoDto());
				allegato3Common.setAllegatoDto(new SigitTAllegatoDto());
				//allegato1Common.setPersonaFisicaDto(new SigitTPersonaFisicaDto());

				SigitTPersonaGiuridicaDto pg = new SigitTPersonaGiuridicaDto();
				pg.setDenominazione("MIA IMPRESA");
				allegato3Common.setPersonaGiuridicaDto(pg);

				allegato3Common.setTerzoResp(false);
				allegato3Common.setRuolo(Constants.ID_RUOLO_OCCUPANTE);

				SigitTTrattH2ODto sigitTTrattH2ODto = new SigitTTrattH2ODto();
				sigitTTrattH2ODto.setL22DurezzaH2oFr(BigDecimal.valueOf(24));
				sigitTTrattH2ODto.setL23FlgTrattClimaFiltr(BigDecimal.ONE);
				sigitTTrattH2ODto.setL24FlgTrattAcsAssente(BigDecimal.ONE);

				allegato3Common.setDettaglioTrattAcquaDto(sigitTTrattH2ODto);
				allegato = new SigitTAllegatoDto();
				allegato.setFkTipoDocumento(ConvertUtil.convertToBigDecimal(Constants.ALLEGATO_TIPO_3));
				allegato.setAPotenzaTermicaNominaleMax(new BigDecimal(15));
				allegato.setBFlgDichiarConform(BigDecimal.ONE);
				allegato.setBFlgLibrettoUso(BigDecimal.ONE);
				allegato.setBFlgLibImp(BigDecimal.ZERO);
				allegato.setBFlgLibCompl(BigDecimal.ZERO);

				allegato3Common.setAllegatoDto(allegato);
				pgManut = new SigitTPersonaGiuridicaDto();

				rappTipo3Dto = new SigitTRappTipo3Dto();
				rappTipo3Dto.setFFlgInstallInvolucro(BigDecimal.ONE);
				rappTipo3Dto.setCFlgTrattAcsNonRichiesto(BigDecimal.ZERO);
				rappTipo3Dto.setDFlgLocaleIdoneo(BigDecimal.ZERO);
				rappTipo3Dto.setDFlgCoibIdonea(BigDecimal.valueOf(2));
				rappTipo3Dto.setDFlgLineaElettIdonea(BigDecimal.ONE);
				rappTipo3Dto.setDFlgAssenzaPerdite(BigDecimal.valueOf(2));
				unitaImmobiliareList = new ArrayList<SigitTUnitaImmobiliareDto>();
				unitaImmobiliareList.add(new SigitTUnitaImmobiliareDto());
			}

			Document document = creaDocumentoRee();
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			PdfWriter writer = PdfWriter.getInstance(document, outputStream);

			PDFReeEventListener event = new PDFReeEventListener(ConvertUtil.convertToString(allegato.getFkTipoDocumento()), ConvertUtil.formattaSiglaBollino(allegato.getFkNumeroBollino()), isBozza, true);
			writer.setPageEvent(event);

			document.open();
			addCodDocPerFirma(document, idAllegato);
			Paragraph par = new Paragraph("RAPPORTO DI CONTROLLO DI EFFICIENZA ENERGETICA TIPO 3 (scambiatori)", FONT_HELVETICA_8_B);
			par.setAlignment(Element.ALIGN_CENTER);
			document.add(par);

			aggiungiDatiIdentificativi(document, allegato3Common.getImpiantoDto(), allegato3Common.getAllegatoDto(), unitaImmobiliareList);
			aggiungiResponsabileEManutentore(document, allegato3Common.getPersonaFisicaDto(), allegato3Common.getPersonaGiuridicaDto(), allegato3Common.getRuolo(), allegato3Common.isTerzoResp(), pgManut);
			aggiungiDocumentazioneCorredo(document, allegato);

			aggiungiTrattamentoAcquaScambiatori(document, rappTipo3Dto, allegato3Common.getDettaglioTrattAcquaDto());
			aggiungiControlloImpiantoScambiatori(document, rappTipo3Dto);

			for (SigitVSk4ScDto vSk4ScDto : allegatoCompScList) {

				SigitDFluidoDto fluido = null;
				SigitDFluidoDto alimentazione = null;
				SigitTDettTipo3Dto sigitTDettTipo3Dto = null;
				if (!isSimul) {
					tDettTipo3List = getDbServiceImp().getDettTipo3(ConvertUtil.convertToString(vSk4ScDto.getCodiceImpianto()), ConvertUtil.convertToInteger(vSk4ScDto.getProgressivo()), idAllegato);
					sigitTDettTipo3Dto = tDettTipo3List.get(0);
					BigDecimal fkFluido = sigitTDettTipo3Dto.getFkFluido();
					if (fkFluido != null) {
						fluido = getDbServiceImp().getFluidoById(fkFluido.intValue());
					}
					BigDecimal fkAlimentazione = sigitTDettTipo3Dto.getFkFluidoAlimentaz();
					if (fkAlimentazione != null) {
						alimentazione = getDbServiceImp().getFluidoById(fkAlimentazione.intValue());
					}
				} else {
					tDettTipo3List = new ArrayList<SigitTDettTipo3Dto>();

					SigitTDettTipo3Dto tDettTipo3_A = new SigitTDettTipo3Dto();
					tDettTipo3_A.setEFlgClimaInverno(BigDecimal.ONE);
					tDettTipo3_A.setEFlgPotenzaCompatibile(BigDecimal.valueOf(2));
					tDettTipo3_A.setFkFluidoAlimentaz(BigDecimal.valueOf(1));
					tDettTipo3_A.setEFlgCoibIdonea(BigDecimal.ONE);
					tDettTipo3_A.setFkFluido(BigDecimal.valueOf(2));
					tDettTipo3_A.setEFlgDispFunzionanti(BigDecimal.valueOf(2));

					tDettTipo3_A.setETempExtC(BigDecimal.valueOf(28));
					tDettTipo3_A.setETempMandPrimarioC(BigDecimal.valueOf(14));
					tDettTipo3_A.setETempMandSecondarioC(BigDecimal.valueOf(26));
					tDettTipo3_A.setETempRitorPrimarioC(BigDecimal.valueOf(36));
					tDettTipo3_A.setETempRitSecondarioC(BigDecimal.valueOf(34));
					tDettTipo3_A.setEPortFluidoM3H(BigDecimal.valueOf(12));
					tDettTipo3_A.setEPotenzaTermKw(BigDecimal.valueOf(28));

					SigitTDettTipo3Dto tDettTipo3_B = new SigitTDettTipo3Dto();
					tDettTipo3_B.setETempExtC(BigDecimal.valueOf(33));
					tDettTipo3_B.setETempMandPrimarioC(BigDecimal.valueOf(19));
					tDettTipo3_B.setETempMandSecondarioC(BigDecimal.valueOf(21));
					tDettTipo3_B.setETempRitorPrimarioC(BigDecimal.valueOf(41));
					tDettTipo3_B.setETempRitSecondarioC(BigDecimal.valueOf(44));
					tDettTipo3_B.setEPortFluidoM3H(BigDecimal.valueOf(23));
					tDettTipo3_B.setEPotenzaTermKw(BigDecimal.valueOf(34));

					sigitTDettTipo3Dto = tDettTipo3_A;
					tDettTipo3List.add(tDettTipo3_A);
					tDettTipo3List.add(tDettTipo3_B);

					fluido = new SigitDFluidoDto();
					fluido.setDesFluido("Vapore");

					alimentazione = new SigitDFluidoDto();
					alimentazione.setDesFluido("Olio diatermico");
				}

				aggiungiControlloEVerificaEnergeticaScamb(document, sigitTDettTipo3Dto, vSk4ScDto, fluido, alimentazione);
				aggiungiDettaglioScambiatore(document, tDettTipo3List);
			}

			aggiungiCheckListScambiatore(document, rappTipo3Dto);

			aggiungiConclusione(document, allegato);

			outputStream.flush();
			if (document.isOpen())
				document.close();
			outputStream.close();

			byte[] thePdfIText = outputStream.toByteArray();

			dettDoc.setFile(thePdfIText);
			dettDoc.setNomeDocumento("ReeSC_IText.pdf");

		} catch (DocumentException docEx) {
			gestError(isSimul, docEx.getMessage(), docEx);
		} catch (Exception ex) {
			gestError(isSimul, ex.getMessage(), ex);
		}

		gestDebug(isSimul, "generaReeSc - END");
		return dettDoc;
	}

	/***METODI SPECIFICI REE TIPO 3 - (Scambiatori) ***/

	//C. TRATTAMENTO DELL'ACQUA
	private void aggiungiTrattamentoAcquaScambiatori(Document document, SigitTRappTipo3Dto rappTipo3Dto, SigitTTrattH2ODto h2O) throws DocumentException {

		float[] columnWidths = { 25, 20, 55 };

		PdfPTable tabella = new PdfPTable(columnWidths);
		tabella.setWidthPercentage(100);
		tabella.getDefaultCell().setBorder(1);
		tabella.getDefaultCell().setPaddingLeft(PADDING_LEFT);

		PdfPCell cell;
		tabella.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);

		addEmptyCell(tabella, 3, Rectangle.LEFT | Rectangle.RIGHT);

		// riga1
		cell = new PdfPCell(new Paragraph("C. TRATTAMENTO DELL'ACQUA", FONT_HELVETICA_7_B));
		cell.setColspan(3);
		cell.setBorder(Rectangle.LEFT | Rectangle.RIGHT);
		tabella.addCell(cell);

		// riga2
		Paragraph paragraph = new Paragraph("Durezza totale dell'acqua ", FONT_HELVETICA_7);
		paragraph.add(h2O != null ? ConvertUtil.getStringValid((h2O.getL22DurezzaH2oFr())) : ""); // JIRA SIGIT-667

		paragraph.add("(\u00B0fr)");
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.LEFT);
		tabella.addCell(cell);

		paragraph = new Paragraph("Trattamento in riscaldamento ", FONT_HELVETICA_7);
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		tabella.addCell(cell);

		paragraph = new Paragraph("", FONT_HELVETICA_7);
		aggiungiCheckPrima(paragraph, "non richiesto", GenericUtil.getCheckSi(rappTipo3Dto.getCFlgTrattClimaNonRichiest()), 15);
		aggiungiCheckPrima(paragraph, "assente", (h2O != null && GenericUtil.getCheckSi(h2O.getL23FlgTrattClimaAssente())), 15);
		aggiungiCheckPrima(paragraph, "filtrazione", (h2O != null && GenericUtil.getCheckSi(h2O.getL23FlgTrattClimaFiltr())), 15);
		aggiungiCheckPrima(paragraph, "addolcimento", (h2O != null && GenericUtil.getCheckSi(h2O.getL23FlgTrattClimaAddolc())), 15);
		aggiungiCheckPrima(paragraph, "condiz. Chimico", (h2O != null && GenericUtil.getCheckSi(h2O.getL23FlgTrattClimaChimico())), 15);

		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.RIGHT);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		tabella.addCell(cell);

		//riga3
		paragraph = new Paragraph("");
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.LEFT);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		tabella.addCell(cell);

		paragraph = new Paragraph("Trattamento in ACS ", FONT_HELVETICA_7);
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		tabella.addCell(cell);

		paragraph = new Paragraph("", FONT_HELVETICA_7);
		aggiungiCheckPrima(paragraph, "non richiesto", GenericUtil.getCheckSi(rappTipo3Dto.getCFlgTrattAcsNonRichiesto()), 15);
		aggiungiCheckPrima(paragraph, "assente", (h2O != null && GenericUtil.getCheckSi(h2O.getL24FlgTrattAcsAssente())), 15);
		aggiungiCheckPrima(paragraph, "filtrazione", (h2O != null && GenericUtil.getCheckSi(h2O.getL24FlgTrattAcsFiltr())), 15);
		aggiungiCheckPrima(paragraph, "addolcimento", (h2O != null && GenericUtil.getCheckSi(h2O.getL24FlgTrattAcsAddolc())), 15);
		aggiungiCheckPrima(paragraph, "condiz. Chimico", (h2O != null && GenericUtil.getCheckSi(h2O.getL24FlgTrattAcsChimico())), 15);

		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.RIGHT);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		tabella.addCell(cell);

		document.add(tabella);
	}

	//D. CONTROLLO DELL'IMPIANTO (ESAMI VISIVI)
	private void aggiungiControlloImpiantoScambiatori(Document document, SigitTRappTipo3Dto rappTipo3Dto) throws DocumentException {

		float[] columnWidths = { 35, 15, 35, 15 };

		PdfPTable tabella = new PdfPTable(columnWidths);
		tabella.setWidthPercentage(100);
		tabella.getDefaultCell().setBorder(1);
		tabella.getDefaultCell().setPaddingLeft(PADDING_LEFT);

		PdfPCell cell;
		tabella.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);

		addEmptyCell(tabella, 4, Rectangle.LEFT | Rectangle.RIGHT);

		// riga1
		cell = new PdfPCell(new Paragraph("D. CONTROLLO DELL'IMPIANTO (esami visivi)", FONT_HELVETICA_7_B));
		cell.setColspan(4);
		cell.setBorder(Rectangle.LEFT | Rectangle.RIGHT);
		tabella.addCell(cell);

		// riga2 : locale di installazione idoneo + stato delle coibentazioni idoneo
		BigDecimal dFlgLocaleIdoneo = rappTipo3Dto.getDFlgLocaleIdoneo();
		tabella = addSiNoNcParagraph(tabella, dFlgLocaleIdoneo, true, "Luogo di installazione idoneo");

		BigDecimal dFlgCoibIdonea = rappTipo3Dto.getDFlgCoibIdonea();
		tabella = addSiNoNcParagraph(tabella, dFlgCoibIdonea, false, "Stato delle coibentazioni idoneo");

		// riga3 : linee elettriche idonee + assenza di perdite dal circuito idraulico
		BigDecimal dFlgLineaElettIdonea = rappTipo3Dto.getDFlgLineaElettIdonea();
		tabella = addSiNoNcParagraph(tabella, dFlgLineaElettIdonea, true, "Linee elettriche idonee");

		BigDecimal dFlgAssenzaPerdite = rappTipo3Dto.getDFlgAssenzaPerdite();
		tabella = addSiNoNcParagraph(tabella, dFlgAssenzaPerdite, false, "Assenza di perdite dal circuito idraulico");

		document.add(tabella);
	}

	//E. CONTROLLO E VERIFICA ENERGETICA SCAMBIATORE
	private void aggiungiControlloEVerificaEnergeticaScamb(Document document, SigitTDettTipo3Dto sigitTDettTipo3Dto, SigitVSk4ScDto vSk4ScDto, SigitDFluidoDto fluido, SigitDFluidoDto alimentazione)
			throws DocumentException {

		float[] firstColumnWidths = { 50, 35, 15 };

		PdfPTable tabella = new PdfPTable(firstColumnWidths);
		tabella.setWidthPercentage(100);
		tabella.getDefaultCell().setBorder(1);
		tabella.getDefaultCell().setPaddingLeft(PADDING_LEFT);
		tabella.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);

		addEmptyCell(tabella, 3, Rectangle.LEFT | Rectangle.RIGHT);

		// riga1
		Phrase phrase = new Phrase();
		phrase.add(new Chunk ("E. CONTROLLO E VERIFICA ENERGETICA DEL SCAMBIATORE ", FONT_HELVETICA_7_B));
		phrase.add(new Chunk ("SC ", FONT_HELVETICA_7));
		phrase.add(new Chunk (ConvertUtil.getStringValid(vSk4ScDto.getProgressivo()), FONT_HELVETICA_7_B));
		aggiungiSpaziVuoti(phrase, 17);
		phrase.add(new Chunk ("Data di installazione: ", FONT_HELVETICA_7));
		phrase.add(new Chunk (ConvertUtil.getStringValid(vSk4ScDto.getDataInstall()), FONT_HELVETICA_7));
		PdfPCell cell;
		cell = new PdfPCell(phrase);
		cell.setBorder(Rectangle.LEFT | Rectangle.RIGHT);
		cell.setColspan(3);
		tabella.addCell(cell);
		
		// riga2
		Paragraph paragraph = new Paragraph("", FONT_HELVETICA_7);
		aggiungiTesto(paragraph, "Fabbricante ", 14);
		paragraph.add(ConvertUtil.getStringValid(vSk4ScDto.getDesMarca()));
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.LEFT);
		tabella.addCell(cell);

		paragraph = new Paragraph("", FONT_HELVETICA_7);
		aggiungiCheckPrima(paragraph, "Climatizzazione invernale", GenericUtil.getCheckSi(sigitTDettTipo3Dto.getEFlgClimaInverno()));
		aggiungiSpaziVuoti(paragraph, 5);
		aggiungiCheckPrima(paragraph, "Produzione acs", GenericUtil.getCheckSi(sigitTDettTipo3Dto.getEFlgProduzAcs()));
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.RIGHT);
		cell.setColspan(2);
		tabella.addCell(cell);

		// riga3
		paragraph = new Paragraph("", FONT_HELVETICA_7);
		aggiungiTesto(paragraph, "Modello ", 14);
		paragraph.add(ConvertUtil.getStringValid(vSk4ScDto.getModello()));
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.LEFT);
		tabella.addCell(cell);

		paragraph = new Paragraph("Potenza termica nominale ", FONT_HELVETICA_7);
		aggiungiSpaziVuoti(paragraph, 5);
		paragraph.add(ConvertUtil.getStringValid((vSk4ScDto.getPotenzaTermicaKw())));
		paragraph.add(" (kW)");
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.RIGHT);
		cell.setColspan(2);
		tabella.addCell(cell);

		// riga4
		paragraph = new Paragraph("", FONT_HELVETICA_7);
		aggiungiTesto(paragraph, "Matricola ", 14);
		paragraph.add(ConvertUtil.getStringValid(vSk4ScDto.getMatricola()));
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.LEFT);
		tabella.addCell(cell);

		BigDecimal eFlgPotenzaCompatibile = sigitTDettTipo3Dto.getEFlgPotenzaCompatibile();
		tabella = addSiNoNcParagraph(tabella, eFlgPotenzaCompatibile, false, "Potenza compatibile con i dati di progetto");

		//riga 5
		paragraph = new Paragraph("", FONT_HELVETICA_7);
		aggiungiTesto(paragraph, "Alimentazione ", 14);
		paragraph.add(ConvertUtil.getStringValid(alimentazione != null ? alimentazione.getDesFluido() : ""));
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.LEFT);
		tabella.addCell(cell);

		BigDecimal eFlgCoibIdonea = sigitTDettTipo3Dto.getEFlgCoibIdonea();
		tabella = addSiNoNcParagraph(tabella, eFlgCoibIdonea, false, "Stato delle coibentazioni idoneo");

		//riga 6
		paragraph = new Paragraph("", FONT_HELVETICA_7);
		aggiungiTesto(paragraph, "Fluido vettore termico in uscita ", 14);
		paragraph.add(ConvertUtil.getStringValid(fluido != null ? fluido.getDesFluido() : ""));
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.LEFT);
		tabella.addCell(cell);

		BigDecimal eFlgDispFunzionanti = sigitTDettTipo3Dto.getEFlgDispFunzionanti();
		tabella = addSiNoNcParagraph(tabella, eFlgDispFunzionanti, false, "Dispositivi di regolazione e controllo funzionanti\nAssenza di trafilamenti sulla valvola di regolazione");

		tabella.addCell(cell);
		document.add(tabella);
	}

	//E. DETTAGLIO SC
	private void aggiungiDettaglioScambiatore(Document document, List<SigitTDettTipo3Dto> tDettTipo3List) throws DocumentException {
		float[] columnWidths = { 14, 14, 14, 15, 14, 14, 15 };

		PdfPTable tabella = new PdfPTable(columnWidths);
		tabella.setWidthPercentage(100);
		tabella.getDefaultCell().setBorder(1);
		tabella.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
		tabella.getDefaultCell().setPaddingLeft(PADDING_LEFT);

		PdfPCell cell;
		int listLastElement = tDettTipo3List.size() - 1;
		for (int i = 0; i < tDettTipo3List.size(); i++) {

			SigitTDettTipo3Dto tDettTipo3 = tDettTipo3List.get(i);

			// riga intestazioni

			Paragraph paragraph = new Paragraph("Temperatura  esterna (\u00B0C)", FONT_HELVETICA_7);
			cell = new PdfPCell(paragraph);
			cell.setBorder(Rectangle.LEFT | Rectangle.TOP);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			tabella.addCell(cell);

			paragraph = new Paragraph("Temp. mandata Primario (\u00B0C)", FONT_HELVETICA_7);
			cell = new PdfPCell(paragraph);
			cell.setBorder(Rectangle.TOP);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			tabella.addCell(cell);

			paragraph = new Paragraph("Temp. ritorno Primario (\u00B0C)", FONT_HELVETICA_7);
			cell = new PdfPCell(paragraph);
			cell.setBorder(Rectangle.TOP);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			tabella.addCell(cell);

			paragraph = new Paragraph("Potenza termica (kW)", FONT_HELVETICA_7);
			cell = new PdfPCell(paragraph);
			cell.setBorder(Rectangle.TOP);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			tabella.addCell(cell);

			paragraph = new Paragraph("Portata fluido primario (m3/h)", FONT_HELVETICA_7);
			cell = new PdfPCell(paragraph);
			cell.setBorder(Rectangle.TOP);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			tabella.addCell(cell);

			paragraph = new Paragraph("Temp. mandata Secondario (\u00B0C)", FONT_HELVETICA_7);
			cell = new PdfPCell(paragraph);
			cell.setBorder(Rectangle.TOP);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			tabella.addCell(cell);

			paragraph = new Paragraph("Temp. ritorno Secondario (\u00B0C)", FONT_HELVETICA_7);
			cell = new PdfPCell(paragraph);
			cell.setBorder(Rectangle.RIGHT | Rectangle.TOP);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			tabella.addCell(cell);

			//riga valori

			paragraph = new Paragraph(ConvertUtil.getStringValid((tDettTipo3.getETempExtC())), FONT_HELVETICA_7);
			cell = new PdfPCell(paragraph);
			if (i == listLastElement) {
				cell.setBorder(Rectangle.LEFT | Rectangle.BOTTOM);
			} else {
				cell.setBorder(Rectangle.LEFT);
			}

			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			tabella.addCell(cell);

			paragraph = new Paragraph(ConvertUtil.getStringValid((tDettTipo3.getETempMandPrimarioC())), FONT_HELVETICA_7);
			cell = new PdfPCell(paragraph);
			if (i == listLastElement) {
				cell.setBorder(Rectangle.BOTTOM);
			} else {
				cell.setBorder(Rectangle.NO_BORDER);
			}
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			tabella.addCell(cell);

			paragraph = new Paragraph(ConvertUtil.getStringValid((tDettTipo3.getETempRitorPrimarioC())), FONT_HELVETICA_7);
			cell = new PdfPCell(paragraph);
			if (i == listLastElement) {
				cell.setBorder(Rectangle.BOTTOM);
			} else {
				cell.setBorder(Rectangle.NO_BORDER);
			}
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			tabella.addCell(cell);

			paragraph = new Paragraph(ConvertUtil.getStringValid((tDettTipo3.getEPotenzaTermKw())), FONT_HELVETICA_7);
			cell = new PdfPCell(paragraph);
			if (i == listLastElement) {
				cell.setBorder(Rectangle.BOTTOM);
			} else {
				cell.setBorder(Rectangle.NO_BORDER);
			}
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			tabella.addCell(cell);

			paragraph = new Paragraph("", FONT_HELVETICA_7);

			paragraph = new Paragraph(ConvertUtil.getStringValid((tDettTipo3.getEPortFluidoM3H())), FONT_HELVETICA_7);
			cell = new PdfPCell(paragraph);
			if (i == listLastElement) {
				cell.setBorder(Rectangle.BOTTOM);
			} else {
				cell.setBorder(Rectangle.NO_BORDER);
			}
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			tabella.addCell(cell);

			paragraph = new Paragraph(ConvertUtil.getStringValid((tDettTipo3.getETempMandSecondarioC())), FONT_HELVETICA_7);
			cell = new PdfPCell(paragraph);
			if (i == listLastElement) {
				cell.setBorder(Rectangle.BOTTOM);
			} else {
				cell.setBorder(Rectangle.NO_BORDER);
			}
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			tabella.addCell(cell);

			paragraph = new Paragraph(ConvertUtil.getStringValid((tDettTipo3.getETempRitSecondarioC())), FONT_HELVETICA_7);
			cell = new PdfPCell(paragraph);
			if (i == listLastElement) {
				cell.setBorder(Rectangle.RIGHT | Rectangle.BOTTOM);
			} else {
				cell.setBorder(Rectangle.RIGHT);
			}
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			tabella.addCell(cell);
		}

		document.add(tabella);
	}

	//F. CHECKLIST
	private void aggiungiCheckListScambiatore(Document document, SigitTRappTipo3Dto rappTipo3Dto) throws DocumentException {

		float[] columnWidths = { 20, 80 };

		PdfPTable tabella = new PdfPTable(columnWidths);
		tabella.setWidthPercentage(100);
		tabella.getDefaultCell().setBorder(1);
		tabella.getDefaultCell().setPaddingLeft(PADDING_LEFT);

		PdfPCell cell;
		tabella.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);

		addEmptyCell(tabella, 2, Rectangle.LEFT | Rectangle.RIGHT);

		// riga1
		cell = new PdfPCell(new Paragraph("F. CHECK-LIST", FONT_HELVETICA_7_B));
		cell.setColspan(2);
		cell.setBorder(Rectangle.LEFT | Rectangle.RIGHT);

		tabella.addCell(cell);

		// riga2
		Paragraph paragraph = new Paragraph(
				"Elenco di possibili interventi, dei quali va valutata la convenienza economica, che qualora applicabili all'impianto, potrebbero comportare un miglioramento\r\n"
						+ "della prestazione energetica:", FONT_HELVETICA_7);
		cell = new PdfPCell(paragraph);
		cell.setColspan(2);
		cell.setBorder(Rectangle.LEFT | Rectangle.RIGHT);
		tabella.addCell(cell);

		// riga3
		paragraph = new Paragraph("", FONT_HELVETICA_7);
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.LEFT);
		tabella.addCell(cell);

		paragraph = new Paragraph("", FONT_HELVETICA_7);
		aggiungiCheckPrima(paragraph, "l'adozione di valvole termostatiche sui corpi scaldanti\n", GenericUtil.getCheckSi(rappTipo3Dto.getFFlgValvoleTermost()));
		aggiungiCheckPrima(paragraph, "verifica coerenza tra parametri della curva climatica impostati sulla centralina ed i valori di temperatura ambiente\n", GenericUtil.getCheckSi(rappTipo3Dto.getFFlgVerificaParam()));
		aggiungiCheckPrima(paragraph, "verifica presenza perdite di acqua\n", GenericUtil.getCheckSi(rappTipo3Dto.getFFlgPerditeH2o()));
		aggiungiCheckPrima(paragraph, "installazione di adeguato \"involucro\" di coibentazione per lo scambiatore se non presente", GenericUtil.getCheckSi(rappTipo3Dto.getFFlgInstallInvolucro()));

		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.RIGHT);
		tabella.addCell(cell);

		document.add(tabella);
	}

	/******/

	// REE Tipo 4 - CG (Cogeneratori)
	public DettaglioDocumento generaReeCg(DettaglioAllegato dettAllegato, boolean isSimul, boolean isBozza) {
		gestDebug(isSimul, "generaReeCG - START");

		DettaglioDocumento dettDoc = new DettaglioDocumento();
		try {
			String idAllegato = null;
			SigitTImpiantoDto impianto = null;
			DatiCGCommon allegato4Common = null;
			SigitTAllegatoDto allegato = null;
			List<SigitTUnitaImmobiliareDto> unitaImmobiliareList = null;
			List<SigitVSk4CgDto> allegatoCompCgList = null;
			List<SigitTDettTipo4Dto> tDettTipo4List = null;
			SigitTPersonaGiuridicaDto pgManut = null;
			SigitTRappTipo4Dto rappTipo4Dto = null;

			if (!isSimul) { //recupero dati dal sistema
				idAllegato = ConvertUtil.convertToString(dettAllegato.getIdAllegato());
				allegato4Common = getServiceManager().cercaDatiAllegato4Common(dettAllegato);
				allegato = allegato4Common.getAllegatoDto();
				unitaImmobiliareList = allegato4Common.getListaUnitaImmobiliare();
				allegatoCompCgList = allegato4Common.getSk4CgDtoList();
				rappTipo4Dto = getDbServiceImp().cercaTRappTipo4ById(allegato.getIdAllegato());
				pgManut = getDbServiceImp().cercaTPersonaGiuridicaById(ConvertUtil.convertToInteger(dettAllegato.getPersonaGiuridica().getIdPersonaGiuridica()));
			} else { //utilizzo un mock
				allegato4Common = new DatiCGCommon();
				impianto = new SigitTImpiantoDto();
				allegatoCompCgList = new ArrayList<SigitVSk4CgDto>();

				SigitVSk4CgDto sk4CgDto = new SigitVSk4CgDto();
				sk4CgDto.setDesMarca("NUOVO FABBRICANTE");
				sk4CgDto.setModello("NUOVO MODELLO");
				sk4CgDto.setMatricola("N. NUOVA_MATRICOLA_1234567890");
				sk4CgDto.setDesCombustibile("GAS");
				sk4CgDto.setPotenzaElettricaKw(BigDecimal.valueOf(24));
				sk4CgDto.setPotenzaTermicaKw(BigDecimal.valueOf(21));
				sk4CgDto.setCoMin(BigDecimal.valueOf(54));
				sk4CgDto.setCoMax(BigDecimal.valueOf(152));

				SigitVSk4CgDto sk4CgDtoA = new SigitVSk4CgDto();
				sk4CgDtoA.setDesMarca("ALTRO FABBRICANTE");
				sk4CgDtoA.setModello("ALTRO MODELLO");
				sk4CgDtoA.setMatricola("ALTRO N. NUOVA_MATRICOLA_1234567890");
				sk4CgDtoA.setDesCombustibile("GAS");
				sk4CgDtoA.setPotenzaElettricaKw(BigDecimal.valueOf(27));
				sk4CgDtoA.setPotenzaTermicaKw(BigDecimal.valueOf(29));

				allegatoCompCgList.add(sk4CgDto);
				allegatoCompCgList.add(sk4CgDtoA);

				allegato4Common.setImpiantoDto(new SigitTImpiantoDto());
				allegato4Common.setAllegatoDto(new SigitTAllegatoDto());
				//allegato1Common.setPersonaFisicaDto(new SigitTPersonaFisicaDto());

				SigitTPersonaGiuridicaDto pg = new SigitTPersonaGiuridicaDto();
				pg.setDenominazione("MIA IMPRESA");
				allegato4Common.setPersonaGiuridicaDto(pg);

				allegato4Common.setTerzoResp(false);
				allegato4Common.setIdRuolo(Constants.ID_RUOLO_OCCUPANTE);

				SigitTTrattH2ODto sigitTratH2O = new SigitTTrattH2ODto();
				sigitTratH2O.setL23FlgTrattClimaAssente(BigDecimal.ZERO);
				sigitTratH2O.setL23FlgTrattClimaAddolc(BigDecimal.ONE);
				sigitTratH2O.setL22DurezzaH2oFr(BigDecimal.valueOf(46));
				allegato4Common.setDettaglioTrattAcqua(sigitTratH2O);

				allegato = new SigitTAllegatoDto();
				allegato.setFkTipoDocumento(ConvertUtil.convertToBigDecimal(Constants.ALLEGATO_TIPO_4));
				allegato.setAPotenzaTermicaNominaleMax(new BigDecimal(15));
				allegato.setBFlgDichiarConform(BigDecimal.ONE);
				allegato.setBFlgLibrettoUso(BigDecimal.ONE);
				allegato.setBFlgLibImp(BigDecimal.ZERO);
				allegato.setBFlgLibCompl(BigDecimal.ZERO);

				allegato4Common.setAllegatoDto(allegato);
				pgManut = new SigitTPersonaGiuridicaDto();

				unitaImmobiliareList = new ArrayList<SigitTUnitaImmobiliareDto>();
				unitaImmobiliareList.add(new SigitTUnitaImmobiliareDto());

				rappTipo4Dto = new SigitTRappTipo4Dto();
				rappTipo4Dto.setCFlgTrattClimaNonRichiest(BigDecimal.ZERO);
				rappTipo4Dto.setDFlgLuogoIdoneo(BigDecimal.ONE);
				rappTipo4Dto.setDFlgCircIdrIdoneo(BigDecimal.ZERO);
				rappTipo4Dto.setDFlgVentilazAdeg(BigDecimal.ONE);
				rappTipo4Dto.setDFlgCircOlioIdoneo(BigDecimal.valueOf(2));
				rappTipo4Dto.setDFlgVentilazLibera(BigDecimal.ZERO);
				rappTipo4Dto.setDFlgCircCombIdoneo(BigDecimal.valueOf(2));
				rappTipo4Dto.setDFlgLineaElettIdonea(BigDecimal.ONE);
				rappTipo4Dto.setDFlgFunzScambIdonea(BigDecimal.valueOf(2));
				rappTipo4Dto.setDFlgCaminoIdoneo(BigDecimal.ZERO);
				rappTipo4Dto.setDFlgCapsulaIdonea(BigDecimal.ONE);
				rappTipo4Dto.setFFlgAdozioneValvole(BigDecimal.ONE);
				rappTipo4Dto.setFFlgIsolamentoRete(BigDecimal.ZERO);
				rappTipo4Dto.setFFlgSistemaTrattH2o(BigDecimal.ONE);
				rappTipo4Dto.setFFlgSostSistemaRegolaz(BigDecimal.ZERO);
			}

			Document document = creaDocumentoRee();
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			PdfWriter writer = PdfWriter.getInstance(document, outputStream);

			PDFReeEventListener event = new PDFReeEventListener(ConvertUtil.convertToString(allegato.getFkTipoDocumento()), ConvertUtil.formattaSiglaBollino(allegato.getFkNumeroBollino()), isBozza, true);
			writer.setPageEvent(event);

			document.open();
			addCodDocPerFirma(document, idAllegato);
			Paragraph par = new Paragraph("RAPPORTO DI CONTROLLO DI EFFICIENZA ENERGETICA TIPO 4 (cogeneratori)", FONT_HELVETICA_8_B);
			par.setAlignment(Element.ALIGN_CENTER);
			document.add(par);

			aggiungiDatiIdentificativi(document, allegato4Common.getImpiantoDto(), allegato4Common.getAllegatoDto(), unitaImmobiliareList);
			aggiungiResponsabileEManutentore(document, allegato4Common.getPersonaFisicaDto(), allegato4Common.getPersonaGiuridicaDto(), allegato4Common.getIdRuolo(), allegato4Common.isTerzoResp(), pgManut);
			aggiungiDocumentazioneCorredo(document, allegato);

			aggiungiTrattamentoAcquaCg(document, rappTipo4Dto, allegato4Common.getDettaglioTrattAcqua());
			aggiungiControlloImpiantoCg(document, rappTipo4Dto);

			for (SigitVSk4CgDto vSk4CgDto : allegatoCompCgList) {
				SigitDFluidoDto fluido = null;
				SigitTDettTipo4Dto dettTipo4 = null;
				if (!isSimul) {
					tDettTipo4List = getDbServiceImp().getDettTipo4(ConvertUtil.convertToString(vSk4CgDto.getCodiceImpianto()), ConvertUtil.convertToInteger(vSk4CgDto.getProgressivo()), idAllegato);
					dettTipo4 = tDettTipo4List.get(0);
					BigDecimal fkFluido = dettTipo4.getFkFluido();
					if (fkFluido != null) {
						fluido = getDbServiceImp().getFluidoById(fkFluido.intValue());
					}
				} else {
					dettTipo4 = new SigitTDettTipo4Dto();
					dettTipo4.setEPotenzaAssorbCombKw(BigDecimal.valueOf(26));
					dettTipo4.setEPotenzaMorsettiKw(BigDecimal.valueOf(16));
					dettTipo4.setEPotenzaTermBypassKw(BigDecimal.valueOf(22));
					dettTipo4.setETempAriaC(BigDecimal.valueOf(18));
					dettTipo4.setETempFumiMonteC(BigDecimal.valueOf(20));
					dettTipo4.setETempFumiValleC(BigDecimal.valueOf(16));
					dettTipo4.setETempH2oInC(BigDecimal.valueOf(12));
					dettTipo4.setETempH2oMotoreC(BigDecimal.valueOf(13));
					dettTipo4.setETempH2oOutC(BigDecimal.valueOf(15));

					fluido = new SigitDFluidoDto();
					fluido.setDesFluido("Acqua calda");
				}
				aggiungiControlloEVerificaEnergeticaCg(document, dettTipo4, vSk4CgDto, fluido);
				aggiungiCircuitoCg(document, dettTipo4, vSk4CgDto);
			}

			aggiungiCheckListCg(document, rappTipo4Dto);
			aggiungiConclusione(document, allegato);

			outputStream.flush();
			if (document.isOpen())
				document.close();
			outputStream.close();

			byte[] thePdfIText = outputStream.toByteArray();

			dettDoc.setFile(thePdfIText);
			dettDoc.setNomeDocumento("ReeCG_IText.pdf");

		} catch (Exception docEx) {
			gestError(isSimul, docEx.getMessage(), docEx);
		}

		gestDebug(isSimul, "generaReeCG - END");
		return dettDoc;
	}

	/***METODI SPECIFICI REE TIPO 4 - (Cogeneratori) ***/

	//C. TRATTAMENTO DELL'ACQUA
	private static void aggiungiTrattamentoAcquaCg(Document document, SigitTRappTipo4Dto rappTipo4Dto, SigitTTrattH2ODto h2O) throws DocumentException {

		float[] columnWidths = { 25, 20, 55 };

		PdfPTable tabella = new PdfPTable(columnWidths);
		tabella.setWidthPercentage(100);
		tabella.getDefaultCell().setBorder(1);
		tabella.getDefaultCell().setPaddingLeft(PADDING_LEFT);

		PdfPCell cell;
		tabella.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);

		addEmptyCell(tabella, 3, Rectangle.LEFT | Rectangle.RIGHT);

		// riga1
		cell = new PdfPCell(new Paragraph("C. TRATTAMENTO DELL'ACQUA", FONT_HELVETICA_7_B));
		cell.setColspan(3);
		cell.setBorder(Rectangle.LEFT | Rectangle.RIGHT);
		tabella.addCell(cell);

		// riga2
		Paragraph paragraph = new Paragraph("Durezza totale dell'acqua ", FONT_HELVETICA_7);
		paragraph.add(h2O != null ? ConvertUtil.getStringValid((h2O.getL22DurezzaH2oFr())) : ""); // JIRA SIGIT-667

		paragraph.add("(\u00B0fr)");
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.LEFT);
		tabella.addCell(cell);

		paragraph = new Paragraph("Trattamento: ", FONT_HELVETICA_7);
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
		tabella.addCell(cell);

		paragraph = new Paragraph("", FONT_HELVETICA_7);
		aggiungiCheckPrima(paragraph, "non richiesto", GenericUtil.getCheckSi(rappTipo4Dto.getCFlgTrattClimaNonRichiest()), 15);
		aggiungiCheckPrima(paragraph, "assente", (h2O != null && GenericUtil.getCheckSi(h2O.getL23FlgTrattClimaAssente())), 15);
		aggiungiCheckPrima(paragraph, "filtrazione", (h2O != null && GenericUtil.getCheckSi(h2O.getL23FlgTrattClimaFiltr())), 15);
		aggiungiCheckPrima(paragraph, "addolcimento", (h2O != null && GenericUtil.getCheckSi(h2O.getL23FlgTrattClimaAddolc())), 15);
		aggiungiCheckPrima(paragraph, "condiz. Chimico", (h2O != null && GenericUtil.getCheckSi(h2O.getL23FlgTrattClimaChimico())), 15);

		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.RIGHT);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		tabella.addCell(cell);

		document.add(tabella);
	}

	//D. CONTROLLO DELL'IMPIANTO (ESAMI VISIVI)
	private static void aggiungiControlloImpiantoCg(Document document, SigitTRappTipo4Dto rappTipo4Dto) throws DocumentException {

		float[] columnWidths = { 37, 13, 35, 15 };

		PdfPTable tabella = new PdfPTable(columnWidths);
		tabella.setWidthPercentage(100);
		tabella.getDefaultCell().setBorder(1);
		tabella.getDefaultCell().setPaddingLeft(PADDING_LEFT);

		PdfPCell cell;
		tabella.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);

		addEmptyCell(tabella, 4, Rectangle.LEFT | Rectangle.RIGHT);

		// riga1
		cell = new PdfPCell(new Paragraph("D. CONTROLLO DELL'IMPIANTO", FONT_HELVETICA_7_B));
		cell.setColspan(4);
		cell.setBorder(Rectangle.LEFT | Rectangle.RIGHT);
		tabella.addCell(cell);

		// riga2 : luogo di installazione idoneo + tenuta circuito idraulico idonea
		BigDecimal dFlgLuogoIdoneo = rappTipo4Dto.getDFlgLuogoIdoneo();
		addSiNoNcParagraph(tabella, dFlgLuogoIdoneo, true, "Luogo di installazione idoneo ", "(esame visivo)");

		BigDecimal dFlgCircIdrIdoneo = rappTipo4Dto.getDFlgCircIdrIdoneo();
		addSiNoNcParagraph(tabella, dFlgCircIdrIdoneo, false, "Tenuta circuito idraulico idonea");

		// riga3 : dimensioni aperture + tenuta circuito olio idonea
		BigDecimal dFlgVentilazAdeg = rappTipo4Dto.getDFlgVentilazAdeg();
		addSiNoNcParagraph(tabella, dFlgVentilazAdeg, true, "Adeguate dimensioni aperture di ventilazione ", "(esame visivo)");

		BigDecimal dFlgCircOlioIdoneo = rappTipo4Dto.getDFlgCircOlioIdoneo();
		addSiNoNcParagraph(tabella, dFlgCircOlioIdoneo, false, "Tenuta circuito olio idonea");

		// riga 4 aperture ventilazioni libere + tenuta circuito alimentazione combustibile idonea
		BigDecimal dFlgVentilazLibera = rappTipo4Dto.getDFlgVentilazLibera();
		addSiNoNcParagraph(tabella, dFlgVentilazLibera, true, "Adeguate di ventilazione libere da ostruzioni ", "(esame visivo)");

		BigDecimal dFlgCircCombIdoneo = rappTipo4Dto.getDFlgCircCombIdoneo();
		addSiNoNcParagraph(tabella, dFlgCircCombIdoneo, false, "Tenuta circuito alimentazione combustibile idonea");

		// riga 5 Linee elettrice e cablaggi idonei + funzionalita' dello scambiatore di calore 
		BigDecimal dFlgLineaElettIdonea = rappTipo4Dto.getDFlgLineaElettIdonea();
		addSiNoNcParagraph(tabella, dFlgLineaElettIdonea, true, "Linee elettrice e cablaggi idonei ", "(esame visivo)");

		BigDecimal dFlgFunzScambIdonea = rappTipo4Dto.getDFlgFunzScambIdonea();
		addSiNoNcParagraph(tabella, dFlgFunzScambIdonea, false, "Funzionalita' dello scambiatore di calore di separazione tra unita' cogenerativa e impianto edificio (se presente) idonea");

		// riga 6 Camino e canale da fumo idonei
		BigDecimal dFlgCaminoIdoneo = rappTipo4Dto.getDFlgCaminoIdoneo();
		addSiNoNcParagraph(tabella, dFlgCaminoIdoneo, true, "Camino e canale da fumo idonei ", "(esame visivo)");

		cell = new PdfPCell(new Paragraph(""));
		cell.setColspan(2);
		cell.setBorder(Rectangle.RIGHT);
		tabella.addCell(cell);

		// riga 6 Camino e canale da fumo idonei
		BigDecimal dFlgCapsulaIdonea = rappTipo4Dto.getDFlgCapsulaIdonea();
		addSiNoNcParagraph(tabella, dFlgCapsulaIdonea, true, "Capsula insonorizzante idonea ", "(esame visivo)");

		cell = new PdfPCell(new Paragraph(""));
		cell.setColspan(2);
		cell.setBorder(Rectangle.RIGHT);
		tabella.addCell(cell);

		document.add(tabella);
	}

	//E. CONTROLLO E VERIFICA ENERGETICA COGENERATORE
	private static void aggiungiControlloEVerificaEnergeticaCg(Document document, SigitTDettTipo4Dto dettTipo4, SigitVSk4CgDto vSk4CgDto, SigitDFluidoDto fluido) throws DocumentException {
		float[] firstColumnWidths = { 50, 50 };

		PdfPTable tabella = new PdfPTable(firstColumnWidths);
		tabella.setWidthPercentage(100);
		tabella.getDefaultCell().setBorder(1);
		tabella.getDefaultCell().setPaddingLeft(PADDING_LEFT);
		tabella.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);

		addEmptyCell(tabella, 2, Rectangle.LEFT | Rectangle.RIGHT);

		// riga1
		Phrase phrase = new Phrase();
		phrase.add(new Chunk("E. CONTROLLO E VERIFICA ENERGETICA DEL COGENERATORE ", FONT_HELVETICA_7_B));
		phrase.add(new Chunk("CG ", FONT_HELVETICA_7));
		phrase.add(new Chunk(ConvertUtil.getStringValid((vSk4CgDto.getProgressivo())), FONT_HELVETICA_7_B));
		PdfPCell cell;
		cell = new PdfPCell(phrase);
		cell.setColspan(2);
		cell.setBorder(Rectangle.LEFT | Rectangle.RIGHT);
		tabella.addCell(cell);

		// riga2
		Paragraph paragraph = new Paragraph("", FONT_HELVETICA_7);
		aggiungiTesto(paragraph, "Fabbricante", 14);
		paragraph.add(ConvertUtil.getStringValid(vSk4CgDto.getDesMarca()));
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.LEFT);
		tabella.addCell(cell);

		paragraph = new Paragraph("", FONT_HELVETICA_7);
		aggiungiTesto(paragraph, "Potenza elettrica nominale ai morsetti", 14);
		aggiungiSpaziVuoti(paragraph, 5);
		paragraph.add(ConvertUtil.getStringValid((vSk4CgDto.getPotenzaElettricaKw())));
		paragraph.add(" (kW)");
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.RIGHT);
		tabella.addCell(cell);

		// riga3
		paragraph = new Paragraph("", FONT_HELVETICA_7);
		aggiungiTesto(paragraph, "Modello", 14);
		paragraph.add(ConvertUtil.getStringValid(vSk4CgDto.getModello()));
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.LEFT);
		tabella.addCell(cell);

		paragraph = new Paragraph("", FONT_HELVETICA_7);
		aggiungiTesto(paragraph, "Potenza assorbita con il combustibile", 14);
		aggiungiSpaziVuoti(paragraph, 5);
		paragraph.add(ConvertUtil.getStringValid((dettTipo4.getEPotenzaAssorbCombKw())));
		paragraph.add(" (kW)");
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.RIGHT);
		tabella.addCell(cell);

		// riga4
		paragraph = new Paragraph("", FONT_HELVETICA_7);
		aggiungiTesto(paragraph, "Matricola", 14);
		paragraph.add(ConvertUtil.getStringValid(vSk4CgDto.getMatricola()));
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.LEFT);
		tabella.addCell(cell);

		paragraph = new Paragraph("", FONT_HELVETICA_7);
		aggiungiTesto(paragraph, "Potenza termica nominale (massimo recupero) ", 14);
		aggiungiSpaziVuoti(paragraph, 5);
		paragraph.add(ConvertUtil.getStringValid((vSk4CgDto.getPotenzaTermicaKw())));
		paragraph.add(" (kW)");
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.RIGHT);
		tabella.addCell(cell);

		//riga 5
		paragraph = new Paragraph("", FONT_HELVETICA_7);
		aggiungiTesto(paragraph, "Alimentazione", 14);
		paragraph.add(ConvertUtil.getStringValid(vSk4CgDto.getDesCombustibile()));
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.LEFT);
		tabella.addCell(cell);

		paragraph = new Paragraph("", FONT_HELVETICA_7);
		aggiungiTesto(paragraph, "Potenza termica a piena potenza con by-pass fumi aperto\n (se presente)", 14);
		aggiungiSpaziVuoti(paragraph, 5);
		paragraph.add(ConvertUtil.getStringValid((dettTipo4.getEPotenzaTermBypassKw())));
		paragraph.add(" (kW)");
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.RIGHT);
		tabella.addCell(cell);

		//riga 6
		paragraph = new Paragraph("", FONT_HELVETICA_7);
		aggiungiTesto(paragraph, "Fluido vettore termico in uscita", 14);
		aggiungiSpaziVuoti(paragraph, 5);
		paragraph.add(ConvertUtil.getStringValid(fluido != null ? fluido.getDesFluido() : ""));
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.LEFT);
		tabella.addCell(cell);

		String emissMono = "";
		if (vSk4CgDto.getCoMin() != null) {
			emissMono += vSk4CgDto.getCoMin();
		}
		emissMono += " / ";
		if (vSk4CgDto.getCoMax() != null) {
			emissMono += vSk4CgDto.getCoMax();
		}

		paragraph = new Paragraph("", FONT_HELVETICA_7);
		aggiungiTesto(paragraph, "Emissioni di monossido di carbonio CO  riportati al 5% di O", 14);
		aggiungiSpaziVuoti(paragraph, 6);
		paragraph.add(emissMono);
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.RIGHT);
		tabella.addCell(cell);

		document.add(tabella);
	}

	//E. CIRCUITO COGENERATORE
	private static void aggiungiCircuitoCg(Document document, SigitTDettTipo4Dto dettTipo4, SigitVSk4CgDto vSk4CgDto) throws DocumentException {

		float[] columnWidths = { 14, 14, 14, 15, 14, 14, 15 };

		PdfPTable tabella = new PdfPTable(columnWidths);
		tabella.setWidthPercentage(100);
		tabella.getDefaultCell().setBorder(1);
		tabella.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
		tabella.getDefaultCell().setPaddingLeft(PADDING_LEFT);

		PdfPCell cell;

		// riga intestazioni

		Paragraph paragraph = new Paragraph("Temp. aria comburente \u00B0C", FONT_HELVETICA_7);
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.LEFT | Rectangle.TOP);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		tabella.addCell(cell);

		paragraph = new Paragraph("Temp. acqua in uscita \u00B0C", FONT_HELVETICA_7);
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.TOP);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		tabella.addCell(cell);

		paragraph = new Paragraph("Temp. acqua in ingresso \u00B0C", FONT_HELVETICA_7);
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.TOP);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		tabella.addCell(cell);

		paragraph = new Paragraph("Potenza ai morsetti  del generatore (kW)", FONT_HELVETICA_7);
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.TOP);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		tabella.addCell(cell);

		paragraph = new Paragraph("Temp. acqua motore (solo m.c.i.) \u00B0C", FONT_HELVETICA_7);
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.TOP);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		tabella.addCell(cell);

		paragraph = new Paragraph("Temp. fumi a valle dello scambiatore fumi \u00B0C", FONT_HELVETICA_7);
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.TOP);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		tabella.addCell(cell);

		paragraph = new Paragraph("Temp. fumi a monte dello scambiatore fumi \u00B0C", FONT_HELVETICA_7);
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.TOP | Rectangle.RIGHT);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		tabella.addCell(cell);

		//riga valori

		paragraph = new Paragraph(ConvertUtil.getStringValid((dettTipo4.getETempAriaC())), FONT_HELVETICA_7);
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.LEFT | Rectangle.BOTTOM);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		tabella.addCell(cell);

		paragraph = new Paragraph(ConvertUtil.getStringValid((dettTipo4.getETempH2oOutC())), FONT_HELVETICA_7);
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.BOTTOM);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		tabella.addCell(cell);

		paragraph = new Paragraph(ConvertUtil.getStringValid((dettTipo4.getETempH2oInC())), FONT_HELVETICA_7);
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.BOTTOM);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		tabella.addCell(cell);

		paragraph = new Paragraph(ConvertUtil.getStringValid((dettTipo4.getEPotenzaMorsettiKw())), FONT_HELVETICA_7);
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.BOTTOM);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		tabella.addCell(cell);

		paragraph = new Paragraph("", FONT_HELVETICA_7);

		paragraph = new Paragraph(ConvertUtil.getStringValid((dettTipo4.getETempH2oMotoreC())), FONT_HELVETICA_7);
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.BOTTOM);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		tabella.addCell(cell);

		paragraph = new Paragraph(ConvertUtil.getStringValid((dettTipo4.getETempFumiValleC())), FONT_HELVETICA_7);
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.BOTTOM);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		tabella.addCell(cell);

		paragraph = new Paragraph(ConvertUtil.getStringValid((dettTipo4.getETempFumiMonteC())), FONT_HELVETICA_7);
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.BOTTOM | Rectangle.RIGHT);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		tabella.addCell(cell);

		document.add(tabella);
	}

	//F. CHECKLIST
	private static void aggiungiCheckListCg(Document document, SigitTRappTipo4Dto rappTipo4Dto) throws DocumentException {

		float[] columnWidths = { 20, 80 };

		PdfPTable tabella = new PdfPTable(columnWidths);
		tabella.setWidthPercentage(100);
		tabella.getDefaultCell().setBorder(1);
		tabella.getDefaultCell().setPaddingLeft(PADDING_LEFT);

		PdfPCell cell;
		tabella.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);

		addEmptyCell(tabella, 2, Rectangle.LEFT | Rectangle.RIGHT);

		// riga1
		cell = new PdfPCell(new Paragraph("F. CHECK-LIST", FONT_HELVETICA_7_B));
		cell.setColspan(2);
		cell.setBorder(Rectangle.LEFT | Rectangle.RIGHT);

		tabella.addCell(cell);

		// riga2
		Paragraph paragraph = new Paragraph(
				"Elenco di possibili interventi, dei quali va valutata la convenienza economica, che qualora applicabili all'impianto, potrebbero comportare un miglioramento\r\n"
						+ "della prestazione energetica:", FONT_HELVETICA_7);
		cell = new PdfPCell(paragraph);
		cell.setColspan(2);
		cell.setBorder(Rectangle.LEFT | Rectangle.RIGHT);
		tabella.addCell(cell);

		// riga3
		paragraph = new Paragraph("", FONT_HELVETICA_7);
		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.LEFT);
		tabella.addCell(cell);

		paragraph = new Paragraph("", FONT_HELVETICA_7);
		aggiungiCheckPrima(paragraph, "l'adozione di valvole termostatiche sui corpi scaldanti. \n", GenericUtil.getCheckSi(rappTipo4Dto.getFFlgAdozioneValvole()));
		aggiungiCheckPrima(paragraph, "l'isolamento della rete di distribuzione nei locali non riscaldati. \n", GenericUtil.getCheckSi(rappTipo4Dto.getFFlgIsolamentoRete()));
		aggiungiCheckPrima(paragraph, "l'introduzione di un sistema di trattamento dell'acqua sanitaria e per riscaldamento, ove assente. \n", GenericUtil.getCheckSi(rappTipo4Dto.getFFlgSistemaTrattH2o()));
		aggiungiCheckPrima(paragraph, "la sostituzione di un sistema di regolazione on/off con un sistema programmabile su piu' livelli di temperatura. \n", GenericUtil.getCheckSi(rappTipo4Dto.getFFlgSostSistemaRegolaz()));

		cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.RIGHT);
		tabella.addCell(cell);

		document.add(tabella);
	}

	/*** METODI COMUNI ***/
	private static PdfPTable addSiNoNcParagraph(PdfPTable tabella, BigDecimal flagCheckbox, boolean isLeftParagraph, String mainLabel, String secondaryLabel) {
		PdfPCell cell;
		Paragraph paragraph = new Paragraph();
		paragraph.add(new Chunk(mainLabel, FONT_HELVETICA_7));
		if (secondaryLabel != null) {
			paragraph.add(new Chunk(secondaryLabel, FONT_HELVETICA_5));
		}
		cell = new PdfPCell(paragraph);
		if (isLeftParagraph) {
			cell.setBorder(Rectangle.LEFT);
		} else {
			cell.setBorder(Rectangle.NO_BORDER);
		}
		tabella.addCell(cell);

		paragraph = new Paragraph("", FONT_HELVETICA_7);
		aggiungiCheckSi(paragraph, GenericUtil.getCheckSi(flagCheckbox));
		aggiungiCheckNo(paragraph, GenericUtil.getCheckNo(flagCheckbox));
		aggiungiCheckPrima(paragraph, "NC", GenericUtil.getCheckNc(flagCheckbox));

		cell = new PdfPCell(paragraph);
		if (isLeftParagraph) {
			cell.setBorder(Rectangle.NO_BORDER);
		} else {
			cell.setBorder(Rectangle.RIGHT);
		}
		tabella.addCell(cell);

		return tabella;
	}

	private static PdfPTable addSiNoNcParagraph(PdfPTable tabella, BigDecimal dFlgCircIdrIdoneo, boolean isLeftParagraph, String mainLabel) {
		return addSiNoNcParagraph(tabella, dFlgCircIdrIdoneo, isLeftParagraph, mainLabel, null);
	}

	private void addCodDocPerFirma(Document doc, String idAllegato) throws DocumentException {
		Font f = new Font(FONT_HELVETICA_5);
		f.setColor(Color.white);
		Chunk c = new Chunk("id_allegato:" + idAllegato + "#", f);
		Paragraph par = new Paragraph(c);
		par.setAlignment(Element.ALIGN_CENTER);
		doc.add(par);
	}

	private String getDesUnitaMisura(String unitaMisuraPk) {
		if (GenericUtil.isNullOrEmpty(unitaMisuraPk)) {
			return "";
		}
		try {
			SigitDUnitaMisuraDto unitaMisura = getDbServiceImp().getUnitaMisuraById(ConvertUtil.convertToInteger(unitaMisuraPk));
			return unitaMisura.getDesUnitaMisura();
		} catch (Exception e) {
			log.error("Errore durante il recupero dell' unita di misura: ", e);
			return "";
		}
	}
}
