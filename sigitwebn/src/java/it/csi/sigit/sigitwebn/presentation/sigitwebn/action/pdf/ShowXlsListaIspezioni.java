/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitwebn.presentation.sigitwebn.action.pdf;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitExtIspezioniConCodImpiantoDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitExtIspezioniDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitExtIspezioniSenzaCodImpiantoDto;
import it.csi.sigit.sigitwebn.business.manager.DbMgr;
import it.csi.sigit.sigitwebn.business.manager.ServiziMgr;
import it.csi.sigit.sigitwebn.business.manager.util.ManagerException;
import it.csi.sigit.sigitwebn.business.manager.util.Message;
import it.csi.sigit.sigitwebn.business.pdf.ModuloBuilder;
import it.csi.sigit.sigitwebn.dto.BaseSessionAwareDTO;
import it.csi.sigit.sigitwebn.dto.ispezioni.Ispezione2018;
import it.csi.sigit.sigitwebn.presentation.sigitwebn.action.BaseAction;
import it.csi.sigit.sigitwebn.presentation.sigitwebn.action.CommandExecutionException;
import it.csi.sigit.sigitwebn.presentation.sigitwebn.action.ICommand;
import it.csi.sigit.sigitwebn.util.Constants;
import it.csi.sigit.sigitwebn.util.ConvertUtil;
import it.csi.sigit.sigitwebn.util.GenericUtil;
import it.csi.sigit.sigitwebn.util.Messages;
import it.csi.sigit.sigitwebn.util.enumutil.PositivoNegativoEnum;
import jxl.Workbook;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ShowXlsListaIspezioni extends BaseAction<BaseSessionAwareDTO> {

	
	private static final long serialVersionUID = 1L;
	private BaseSessionAwareDTO model;
	private InputStream inputStream;
	private String inputName;
	private String contentDisposition;
	private String contentType;
	
	private ModuloBuilder moduloBuilder;
	private DbMgr dbMgr;

	
	private ServiziMgr serviziMgr;
	
	private WritableCellFormat arial10Boldformat = null;
	private WritableCellFormat arial10Colorformat = null;
	private WritableCellFormat arial10Lineformat = null;
	
	@Override
	public String execute()
	{
		
//		String contentType = "application/pdf";
//		String contentDisp = "inline;filename=ricevutaAllegato.pdf";
		
		String contentType = "application/download";
		String contentDisp = "attachment;filename=elencoIspezioni.xls";
		
		LOG.debug("creo la ricevuta");
		
		try
		{
			ArrayList<Ispezione2018> listIspezioni = (ArrayList<Ispezione2018>)session.get("appDataElencoIspezioni2018");

			//String actionPageBack = (String)session.get(Constants.SESSIONE_VAR_ACTION_PAGE_BACK);
			
//			LOG.debug("idAllegato: " + idAllegato);
//			LOG.debug("actionPageBack: " + actionPageBack);
//			
//			moduloBuilder.setIdAllegato(idAllegato);
//			moduloBuilder.setActionPageBack(actionPageBack);

			byte[] ispezioni = null;
			
			if (listIspezioni != null && listIspezioni.size() > 0)
			{
				ArrayList<String> listAllIdIspezioni = new ArrayList<String>();
				ArrayList<String> listCodImpianti = new ArrayList<String>();
				ArrayList<String> listIdIspezioni = new ArrayList<String>();
				
				for (Ispezione2018 ispezione2018 : listIspezioni) {
					
					if (ispezione2018 != null)
					{
						listAllIdIspezioni.add(ispezione2018.getIdentificativoIspezione());
						
						if (GenericUtil.isNotNullOrEmpty(ispezione2018.getCodiceImpianto()))
						{
							listCodImpianti.add(ispezione2018.getCodiceImpianto());
						}
						else
						{
							listIdIspezioni.add(ispezione2018.getIdentificativoIspezione());
						}
						
					}
				}
				
				List<SigitExtIspezioniDto> listIspezioniAll = null;
				List<SigitExtIspezioniConCodImpiantoDto> listIspezioniCodImpianto = null;
				List<SigitExtIspezioniSenzaCodImpiantoDto> listIspezioniSenzaImpianto = null;
				
				if (listAllIdIspezioni.size() > 0)
				{
					listIspezioniAll = getDbMgr().cercaIspezioniDett(listAllIdIspezioni);
				}
				
				if (listCodImpianti.size() > 0)
				{
					listIspezioniCodImpianto = getDbMgr().cercaIspezioniDettConCodImpianto(listCodImpianti);
				}
				
				if (listIdIspezioni.size() > 0)
				{
					listIspezioniSenzaImpianto = getDbMgr().cercaIspezioniDettSenzaCodImpianto(listIdIspezioni);
				}

				ispezioni = creaFileIspezioni(listIspezioniAll, listIspezioniCodImpianto, listIspezioniSenzaImpianto);

			}
			
			
			
			
			LOG.debug("STAMPO LE ISPEZIONI: "+ispezioni);
			
			if(ispezioni!=null)
			{
				setInputStream(new ByteArrayInputStream(ispezioni));
				LOG.debug("file ispezioni aggiunte");
				setContentDisposition(contentDisp);
				setContentType(contentType);
				return "downloadFile";
			}
			
			LOG.debug("MODULO NON TROVATO");
			
			return "KO";
		}
		catch (Exception ex)
		{
			LOG.error(ex);
			return "KO";
		}
	}
	
	private byte[] creaFileIspezioni(List<SigitExtIspezioniDto> listIspezioniAll, List<SigitExtIspezioniConCodImpiantoDto> listIspezioniConImpianto, List<SigitExtIspezioniSenzaCodImpiantoDto> listIspezioniSenzaImpianto) throws ManagerException
	{
		try {
			
			// Definisco gli stili
			WritableFont arial10Boldfont = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD); 
			arial10Boldformat = new WritableCellFormat (arial10Boldfont); 

			WritableFont arial10Colorfont = new WritableFont(WritableFont.ARIAL, 10); 
			arial10Colorformat = new WritableCellFormat (arial10Colorfont);
			arial10Colorformat.setBackground(Colour.YELLOW2);
			arial10Colorformat.setBorder(Border.ALL, BorderLineStyle.THIN);

			WritableFont arial10Linefont = new WritableFont(WritableFont.ARIAL, 10); 
			arial10Lineformat = new WritableCellFormat (arial10Linefont); 
			arial10Lineformat.setBorder(Border.ALL, BorderLineStyle.THIN);
			
			/*
			nfInteroCell = new WritableCellFormat(NumberFormats.INTEGER);
			nfInteroCell.setBorder(Border.ALL, BorderLineStyle.THIN);

			//NumberFormat nfFour = new NumberFormat("#,##0.####");
			NumberFormat nfFour = new NumberFormat("#,##0.0000");
			nfDoubleFourCell = new WritableCellFormat(nfFour);
			nfDoubleFourCell.setBorder(Border.ALL, BorderLineStyle.THIN);
			
			//NumberFormat nfFive = new NumberFormat("#,##0.#####");
			NumberFormat nfFive = new NumberFormat("#,##0.00000");
			nfDoubleFiveCell = new WritableCellFormat(nfFive);
			nfDoubleFiveCell.setBorder(Border.ALL, BorderLineStyle.THIN);
			*/

			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			
			WritableWorkbook workbook = Workbook.createWorkbook(baos);
			
			creaFoglioIspezioni(workbook, listIspezioniAll);
			creaFoglioConCodiceImpianto(workbook, listIspezioniConImpianto);
			creaFoglioSenzaCodiceImpianto(workbook, listIspezioniSenzaImpianto);
			
			workbook.write();
			workbook.close();
			
			return baos.toByteArray();
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_SERVIZIO));
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_SERVIZIO));
		} catch (ManagerException e) {
			// TODO Auto-generated catch block
			throw e;
		}
	}
	
	private void creaFoglioIspezioni(WritableWorkbook workbook, List<SigitExtIspezioniDto> listIspezioni) throws ManagerException
	{
		try {
			WritableSheet sheet = workbook.createSheet("Ispezioni", 1);

			Label label = new Label(1,1,"Elenco Ispezioni", arial10Boldformat);

			sheet.addCell(label);

			label = null;

			int riga = 3;
			int col = 1;

			String[] intestazioneCol = new String[]{
					"Id Ispezione", 
					"Ispettore Assegnatario", 
					"Secondo Ispettore", 
					"Data Creazione", 
					"Stato", 
					"Codice Impianto", 
					"Prov Competenza", 
					"Comune Competenza", 
					"Esito Ispezione", 
					"Ispezione a Pagamento", 
					"Indirizzo",
					"Civico", 
					"POT_H2O_KW", 
					"POT_CLIMA_INV_KW", 
					"POT_CLIMA_EST_KW"};

			for (int i = 0; i < intestazioneCol.length; i++) {

				label = new Label(col ,riga, intestazioneCol[i], arial10Colorformat);
				sheet.addCell(label);
				sheet.setColumnView(col, 42);
				col++;
			}

			if (listIspezioni != null)
			{
				for (int i = 0; i < listIspezioni.size(); i++) 
				{
					col = 1;
					riga++;

					SigitExtIspezioniDto ispez = listIspezioni.get(i);

					sheet.addCell(settaCella(col++, riga, ConvertUtil.convertToString(ispez.getIdIspezione2018()), arial10Lineformat));

					String valore = "";
					if (GenericUtil.isNotNullOrEmpty(ispez.getCognome()))
					{
						valore = ConvertUtil.getStringByConcat(" ", ispez.getCognome(), ispez.getNome(), "("+ispez.getCodiceFiscale()+")");
					}
					
					sheet.addCell(settaCella(col++, riga, valore, arial10Lineformat));

					sheet.addCell(settaCella(col++, riga, ispez.getCfIspettoreSecondario(), arial10Lineformat));

					sheet.addCell(settaCella(col++, riga, ConvertUtil.convertToString(ispez.getDtCreazione()), arial10Lineformat));

					sheet.addCell(settaCella(col++, riga, ispez.getDesStatoIspezione(), arial10Lineformat));

					sheet.addCell(settaCella(col++, riga, ConvertUtil.convertToString(ispez.getCodiceImpianto()), arial10Lineformat));

					sheet.addCell(settaCella(col++, riga, ispez.getSiglaProvincia(), arial10Lineformat));

					sheet.addCell(settaCella(col++, riga, ispez.getDenominazioneComune(), arial10Lineformat));

					Boolean esitoBoolean = ConvertUtil.convertToBoolean(ispez.getFlgEsito());
					valore = esitoBoolean == null ? "" : esitoBoolean ? PositivoNegativoEnum.POSITIVO.getDescrizione() : PositivoNegativoEnum.NEGATIVO.getDescrizione();

					sheet.addCell(settaCella(col++, riga, valore, arial10Lineformat));

					Boolean isPagamentoBoolean = ConvertUtil.convertToBoolean(ispez.getFlgIspPagamento());
					valore = isPagamentoBoolean == null ? "" : isPagamentoBoolean ? Constants.LABEL_SI : Constants.LABEL_NO;

					sheet.addCell(settaCella(col++, riga, valore, arial10Lineformat));
					
					sheet.addCell(settaCella(col++, riga, ispez.getIndirizzoUnitaImmob(), arial10Lineformat));

					sheet.addCell(settaCella(col++, riga, ispez.getCivico(), arial10Lineformat));

					sheet.addCell(settaCella(col++, riga, ConvertUtil.convertToString(ispez.getL13PotH2oKw()), arial10Lineformat));

					sheet.addCell(settaCella(col++, riga, ConvertUtil.convertToString(ispez.getL13PotClimaInvKw()), arial10Lineformat));

					sheet.addCell(settaCella(col++, riga, ConvertUtil.convertToString(ispez.getL13PotClimaEstKw()), arial10Lineformat));

				}
			}
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_SERVIZIO));
		}
	}
	
	private void creaFoglioConCodiceImpianto(WritableWorkbook workbook, List<SigitExtIspezioniConCodImpiantoDto> listIspezioniConImpianto) throws ManagerException
	{
		try {
			WritableSheet sheet = workbook.createSheet("Con Codice Impianto", 2);

			Label label = new Label(1,1,"Elenco Ispezioni Con Codice Impianto", arial10Boldformat);

			sheet.addCell(label);

			label = null;

			int riga = 3;
			int col = 1;

			String[] intestazioneCol = new String[]{
					"Codice Impianto", 
					"Ruolo", 
					"Id Responsabile", 
					"Cognome Denominazione", 
					"Nome", 
					"Codice Fiscale", 
					"Indirizzo", 
					"Civico", 
					"Cap", 
					"Comune", 
					"Provincia", 
					"Email", 
					"Sigla REA", 
			"Numero REA"};

			for (int i = 0; i < intestazioneCol.length; i++) {

				label = new Label(col ,riga, intestazioneCol[i], arial10Colorformat);
				sheet.addCell(label);
				sheet.setColumnView(col, 42);
				col++;
			}

			if (listIspezioniConImpianto != null)
			{
				for (int i = 0; i < listIspezioniConImpianto.size(); i++) 
				{
					col = 1;
					riga++;

					SigitExtIspezioniConCodImpiantoDto ispez = listIspezioniConImpianto.get(i);

					sheet.addCell(settaCella(col++, riga, ConvertUtil.convertToString(ispez.getCodiceImpianto()), arial10Lineformat));

					sheet.addCell(settaCella(col++, riga, ispez.getRuolo(), arial10Lineformat));

					sheet.addCell(settaCella(col++, riga, ConvertUtil.convertToString(ispez.getIdResponsabile()), arial10Lineformat));

					sheet.addCell(settaCella(col++, riga, ispez.getCognomeDenominazione(), arial10Lineformat));

					sheet.addCell(settaCella(col++, riga, ispez.getNome(), arial10Lineformat));

					sheet.addCell(settaCella(col++, riga, ispez.getCodiceFiscale(), arial10Lineformat));

					sheet.addCell(settaCella(col++, riga, ispez.getIndirizzo(), arial10Lineformat));

					sheet.addCell(settaCella(col++, riga, ispez.getCivico(), arial10Lineformat));

					sheet.addCell(settaCella(col++, riga, ispez.getCap(), arial10Lineformat));

					sheet.addCell(settaCella(col++, riga, ispez.getComune(), arial10Lineformat));

					sheet.addCell(settaCella(col++, riga, ispez.getProvincia(), arial10Lineformat));

					sheet.addCell(settaCella(col++, riga, ispez.getEmail(), arial10Lineformat));

					sheet.addCell(settaCella(col++, riga, ispez.getSiglaRea(), arial10Lineformat));

					sheet.addCell(settaCella(col++, riga, ConvertUtil.convertToString(ispez.getNumeroRea()), arial10Lineformat));

				}
			}
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_SERVIZIO));
		}
	}

	private void creaFoglioSenzaCodiceImpianto(WritableWorkbook workbook, List<SigitExtIspezioniSenzaCodImpiantoDto> listIspezioniSenzaImpianto) throws ManagerException
	{
		try {
			WritableSheet sheet = workbook.createSheet("Senza Codice Impianto", 3);

			Label label = new Label(1,1,"Elenco Ispezioni Senza Codice Impianto", arial10Boldformat);

			sheet.addCell(label);

			label = null;

			int riga = 3;
			int col = 1;

			String[] intestazioneCol = new String[]{
					"Id Ispezione", 
					"Flg PfPg", 
					"Cognome Denominazione", 
					"Nome", 
					"CF P. IVA", 
					"DUG", 
					"Indirizzo", 
					"Civico", 
					"Cap", 
					"Istat Comune",
					"Flg PfPg Fatt", 
					"Cognome Denominazione Fatt", 
					"Nome Fatt", 
					"CF P. IVA Fatt", 
					"DUG Fatt", 
					"Indirizzo Fatt", 
					"Civico Fatt", 
					"Cap Fatt", 
					"Istat Comune Fatt",
					"Tipo Contratto Distrib", 
					"Categoria", 
					"Combustibile", 
					"Unita Misura", 
					"Anno Rif", 
					"Nr Mesi Fatt", 
					"Consumo Anno", 
			"Consumo Mensile"};

			for (int i = 0; i < intestazioneCol.length; i++) {

				label = new Label(col ,riga, intestazioneCol[i], arial10Colorformat);
				sheet.addCell(label);
				sheet.setColumnView(col, 42);
				col++;
			}

			if (listIspezioniSenzaImpianto != null)
			{
				for (int i = 0; i < listIspezioniSenzaImpianto.size(); i++) 
				{
					col = 1;
					riga++;

					SigitExtIspezioniSenzaCodImpiantoDto ispez = listIspezioniSenzaImpianto.get(i);

					sheet.addCell(settaCella(col++, riga, ConvertUtil.convertToString(ispez.getIdIspezione2018()), arial10Lineformat));

					sheet.addCell(settaCella(col++, riga, ispez.getFlgPfPg(), arial10Lineformat));

					sheet.addCell(settaCella(col++, riga, ispez.getCognomeDenom(), arial10Lineformat));

					sheet.addCell(settaCella(col++, riga, ispez.getNome(), arial10Lineformat));

					sheet.addCell(settaCella(col++, riga, ispez.getCfPiva(), arial10Lineformat));

					sheet.addCell(settaCella(col++, riga, ispez.getDug(), arial10Lineformat));

					sheet.addCell(settaCella(col++, riga, ispez.getIndirizzo(), arial10Lineformat));

					sheet.addCell(settaCella(col++, riga, ispez.getCivico(), arial10Lineformat));

					sheet.addCell(settaCella(col++, riga, ispez.getCap(), arial10Lineformat));

					sheet.addCell(settaCella(col++, riga, ispez.getIstatComune(), arial10Lineformat));

					sheet.addCell(settaCella(col++, riga, ispez.getFlgPfPgFatt(), arial10Lineformat));

					sheet.addCell(settaCella(col++, riga, ispez.getCognomeDenomFatt(), arial10Lineformat));

					sheet.addCell(settaCella(col++, riga, ispez.getNomeFatt(), arial10Lineformat));

					sheet.addCell(settaCella(col++, riga, ispez.getCfPivaFatt(), arial10Lineformat));

					sheet.addCell(settaCella(col++, riga, ispez.getDugFatt(), arial10Lineformat));

					sheet.addCell(settaCella(col++, riga, ispez.getIndirizzoFatt(), arial10Lineformat));

					sheet.addCell(settaCella(col++, riga, ispez.getCivicoFatt(), arial10Lineformat));

					sheet.addCell(settaCella(col++, riga, ispez.getCapFatt(), arial10Lineformat));

					sheet.addCell(settaCella(col++, riga, ispez.getIstatComuneFatt(), arial10Lineformat));
					
					sheet.addCell(settaCella(col++, riga, ispez.getDesTipoContrattoDistrib(), arial10Lineformat));

					sheet.addCell(settaCella(col++, riga, ispez.getDesCategoriaUtil(), arial10Lineformat));

					sheet.addCell(settaCella(col++, riga, ispez.getDesCombustibile(), arial10Lineformat));

					sheet.addCell(settaCella(col++, riga, ispez.getDesUnitaMisura(), arial10Lineformat));

					sheet.addCell(settaCella(col++, riga, ConvertUtil.convertToString(ispez.getAnnoRif()), arial10Lineformat));

					sheet.addCell(settaCella(col++, riga, ConvertUtil.convertToString(ispez.getNrMesiFattur()), arial10Lineformat));

					sheet.addCell(settaCella(col++, riga, ConvertUtil.convertToString(ispez.getConsumoAnno()), arial10Lineformat));

					sheet.addCell(settaCella(col++, riga, ConvertUtil.convertToString(ispez.getConsumoMensile()), arial10Lineformat));
					
				}
			}
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			throw new ManagerException(e, new Message(Messages.ERROR_RECUPERO_SERVIZIO));
		}
	}

	private Label settaCella(int col, int riga, String valore, WritableCellFormat cellFormat)
	{
		return new Label(col, riga, GenericUtil.getStringValid(valore), cellFormat);
	}
	
	@SuppressWarnings("rawtypes")
	public Class modelClass() {
		return getClass();
	}

	public BaseSessionAwareDTO getModel() {
		return this.model;
	}

	public void setModel(BaseSessionAwareDTO t) {
		this.model = t;
	}

	@Override
	protected void dumpModel(boolean pre) {
		
	}

	@Override
	protected void doBeforeEventCommand() throws CommandExecutionException {
		
	}

	@Override
	protected void doAfterEventCommand() throws CommandExecutionException {
	}

	@Override
	protected ICommand initCommand(String moduleName, String panelName,
			String widgName, String eventName) {
		return null;
	}

	@Override
	public void clearPageScopedAppData(String targetContentPanelName) {
		
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public String getInputName() {
		return inputName;
	}

	public void setInputName(String inputName) {
		this.inputName = inputName;
	}


	public String getContentDisposition() {
		return contentDisposition;
	}


	public void setContentDisposition(String contentDisposition) {
		this.contentDisposition = contentDisposition;
	}


	public String getContentType() {
		return contentType;
	}


	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	

	public DbMgr getDbMgr() {
		return dbMgr;
	}


	public void setDbMgr(DbMgr dbMgr) {
		this.dbMgr = dbMgr;
	}

	public ServiziMgr getServiziMgr() {
		return serviziMgr;
	}


	public void setServiziMgr(ServiziMgr serviziMgr) {
		this.serviziMgr = serviziMgr;
	}
	
	public ModuloBuilder getModuloBuilder() {
		return moduloBuilder;
	}
	public void setModuloBuilder(ModuloBuilder moduloBuilder) {
		this.moduloBuilder = moduloBuilder;
	}
	
}
