/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitbatchn.batch.importmassivoallegati;

import it.csi.sigit.sigitbatchn.batch.AbstractBatch;
import it.csi.sigit.sigitbatchn.batch.BatchConf;
import it.csi.sigit.sigitbatchn.batch.BatchException;
import it.csi.sigit.sigitbatchn.batch.reader.DataReader;
import it.csi.sigit.sigitbatchn.batch.reader.DataStringReader;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.SigitTImpXmlDto;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.SigitTImportDto;
import it.csi.sigit.sigitbatchn.business.manager.SigitbatchMgr;
import it.csi.sigit.sigitbatchn.business.manager.business.ImportMassivoAllegatiBusinessMgr;
import it.csi.sigit.sigitbatchn.business.manager.util.ManagerException;
import it.csi.sigit.sigitbatchn.business.manager.util.Messages;
import it.csi.sigit.sigitbatchn.business.manager.util.ValidationManagerException;
import it.csi.sigit.sigitbatchn.business.util.Constants;
import it.csi.sigit.sigitbatchn.business.util.ConvertUtil;
import it.csi.sigit.sigitbatchn.business.util.DateUtil;
import it.csi.sigit.sigitbatchn.business.util.GenericUtil;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

/**
 * Batch per recuperare le informazioni degli impianti
 * 
 * @author 71845 - Marco Giacometto
 */
public class ImportMassivoAllegatiBatch extends AbstractBatch {
	/**
	 * Nome della classe
	 */
	private final static String CLASS_NAME = ImportMassivoAllegatiBatch.class.getSimpleName();
	
	protected static Logger log = Logger.getLogger(Constants.APPLICATION_CODE
			+ ".business");
	
	/**
	 * Menager business
	 */
	//private ImportMassivoAllegatiBusinessMgr businessMgr = null;
	
	/**
	 * Menager business
	 */
	private SigitbatchMgr sigitbatchMgr = null;
	
	/**
	 * Lista degli errori riscontrati
	 */
	private List<Errors> errorsList = null;
	
	/**
	 * Lista degi rapporto controllo inviati
	 */
	private List<Importati> inviatiList = null;
	
	/**
	 * Lista degi rapporto controllo importati
	 */
	private List<Importati> importatiList = null;
	
	/**
	 * {@inheritDoc}
	 */
	public void execute() throws BatchException {
		final String METHOD_NAME = "execute";
		ImportMassivoAllegatiConf conf = null;
		List<DataReader> xmlReaderList = null;
		List<SigitTImportDto> dtoList = null;
		List<SigitTImportDto> dtoListVerificati = null;

		log.debug("[ImportMassivoAllegatiBatch::execute] BEGIN");
		try {
			//conf = readConfiguration();
			
			String dataInizioElaborazione = DateUtil.getDataCorrenteCompletaFormat();
			
			
			dtoList = getSigitbatchMgr().getXmlDaImportare();
			
			boolean isFileImportato = false;
			SigitTImpXmlDto impXml = null;
			for (SigitTImportDto sigitTImportDto : dtoList) {
				
				//testaInvioMail(sigitTImportDto);
				
				
				try
				{
					impXml = getSigitbatchMgr().verificaXmlAllegato(sigitTImportDto.getNomeFileImport(), sigitTImportDto);

					getSigitbatchMgr().importaXmlAllegato(sigitTImportDto, impXml);
				
					isFileImportato = true;

				}
				

				catch (ManagerException ex)
				{
										
					String msg = ex.getMessage();

					msg = msg.replaceFirst("##valueNomeFile##", sigitTImportDto.getNomeFileImport());
					
					getSigitbatchMgr().gestisciErroreAllegato(sigitTImportDto, msg);
				}
				catch (Exception ex)
				{
					// DA GESTIRE
					ex.printStackTrace();
				}
				
			}
			
			
			// DEVO INVIARE LA MAIL ALL'ASSISTENZA
			getSigitbatchMgr().gestisciInvioMailAssistenza(dataInizioElaborazione);
			
			
			//xmlReaderList = getXmlReader(dtoList);
			
			//ImportMassivoImpiantiXmlBeanDataImport c = (ImportMassivoImpiantiXmlBeanDataImport) dataImport;
			//c.setDtoList(dtoList);
			
//			((ImportMassivoAllegatiXmlBeanDataImport) dataImport).setDtoList(dtoList);
//			dataImport.importData(conf, xmlReaderList);
		}
		
		catch (Exception e) {
			e.printStackTrace();
			throw new BatchException("Esecuzione del batch fallita", e);
		}
		finally {
			
			// INVIARE LA MAIL AD ASSISTENZA
		}
		log.debug("[ImportMassivoAllegatiBatch::execute] END");
	}

	/*
	private void testaInvioMail(SigitTImportDto sigitTImportDto)
	{
		try {
			getSigitbatchMgr().gestisciInvioMailImportOK(sigitTImportDto, null, null);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	*/
	
	/**
	 * Invia tutte le mail necessarie
	 * 
	 * @param conf Configurazione per inviare le mail
	 * @throws BatchException Errore durante l'invio delle mail
	 */
	/*
	private void sendAllMails(ImportMassivoAllegatiConf conf) throws BatchException {
		Hashtable<Integer, List<Errors>> listErrors = null;
		List<Errors> manutentoreErrorsList = null;
		
		//sendMail(conf);
		
		String mailServizio = conf.getIndirizzoMailDestinatario();
		
		// Aggregazione degli errori per manutentore
		listErrors = new Hashtable<Integer, List<Errors>>();
		for(Errors errors : errorsList) {
			manutentoreErrorsList = listErrors.get(errors.getIdManutentore());
			if(manutentoreErrorsList == null) {
				manutentoreErrorsList = new ArrayList<Errors>();
				listErrors.put(errors.getIdManutentore(), manutentoreErrorsList);
			}
			manutentoreErrorsList.add(errors);
		}
		
		
		// Invio delle mail ai manutentori KO
		for(Integer idManutentore : listErrors.keySet()) {
			errorsList = listErrors.get(idManutentore);
			
			//System.out.println("Invio mail di errore a (mail): "+errorsList.get(0).getMailManutentore());
			//System.out.println("Invio mail di errore a (id): "+errorsList.get(0).getIdManutentore());

			conf.setIndirizzoMailDestinatario(errorsList.get(0).getMailManutentore());
			sendMail(conf);
			
			// invio la stessa mail anche al servizio
			conf.setIndirizzoMailDestinatario(mailServizio);
			sendMail(conf);
		}
		
		errorsList = null;
		
		
		//System.out.println("Stampo importatiList: "+importatiList);
		
		
		
		// Invio delle mail ai manutentori OK
		for(Importati importati : inviatiList) {
			
			conf.setIndirizzoMailDestinatario(importati.getMailManutentore());
			Hashtable<String, InputStream> attachmentList = new Hashtable<String, InputStream>();
			for(Rapporto rapportoControllo : importati.getRapportoControlloList()) {
				
				//System.out.println("Stampo l'idRapportoControllo: "+rapportoControllo.getIdRapportoControllo());
				//System.out.println("Stampo la dataRapportoControllo: "+rapportoControllo.getDataRapportoControllo());
				
				byte[] filePDF;
				try {
					//getDataImport().
					filePDF = getSigitMgr().getRicevutaPDF(ConvertUtil.convertToString(rapportoControllo.getIdRapportoControllo()));
				} catch (ManagerException e) {
					loggerHelper.error(CLASS_NAME, "sendAllMails", "Errore nel recupero della ricevuta", e);
					throw new BatchException(e);
				}
				InputStream inputStreamPDF = new ByteArrayInputStream(filePDF); 
				
				StringBuilder nome = new StringBuilder();
				nome.append("Ricevuta");
				nome.append("_");
				nome.append(importati.getCodiceImpianto());
				nome.append("_");
				nome.append(ConvertUtil.convertToString(rapportoControllo.getDataRapportoControllo(), ConvertUtil.FORMAT_DATE_UNDERSCORE));
				nome.append("_");
				nome.append(rapportoControllo.getIdRapportoControllo());
				nome.append(".pdf");

				//System.out.println(" nome allegato? " + nome);
				//log.debug(" nome allegato? " + nome);
				
				attachmentList.put(nome.toString(), inputStreamPDF);
				
			}
			
			conf.setOggettoDinamicoMail("Codice impianto: "+importati.getCodiceImpianto());
			conf.setAttachmentList(attachmentList);
			
			//System.out.println("conf.getAttachmentList().keySet(): "+conf.getAttachmentList().keySet());
			
			sendMail(conf);
		}
		inviatiList = null;
		
		loggerHelper.debug("DEVO INVIARE LE MAIL DI IMPORTATI");
		
		// Aggregazione degli importati per manutentore
		Hashtable<Integer, List<Importati>> listImportati = new Hashtable<Integer, List<Importati>>();
		List<Importati> manutentoreImportatiList = null;
		for(Importati importati : importatiList) {
			manutentoreImportatiList = listImportati.get(importati.getIdManutentore());
			if(manutentoreImportatiList == null) {
				manutentoreImportatiList = new ArrayList<Importati>();
				listImportati.put(importati.getIdManutentore(), manutentoreImportatiList);
			}
			manutentoreImportatiList.add(importati);
		}
		
		// Invio delle mail ai manutentori OK (solo importati)
		for(Integer idManutentore : listImportati.keySet()) {
			importatiList = listImportati.get(idManutentore);
			
			conf.setIndirizzoMailDestinatario(importatiList.get(0).getMailManutentore());
			//conf.setOggettoDinamicoMail("Codice impianto: "+importati.getCodiceImpianto());
			sendMailImportati(conf);
		}
		
		
		// Invio delle mail ai manutentori OK (solo importati)
//		for(Importati importati : importatiList) {
//			
//			conf.setIndirizzoMailDestinatario(importati.getMailManutentore());
//			conf.setOggettoDinamicoMail("Codice impianto: "+importati.getCodiceImpianto());
//			sendMailImportati(conf);
//		}
		
		
	}
	*/
	
	/**
	 * Restituisce i reader degli XML da importare
	 * 
	 * @param dtoList Lista di DTO con gli XML da importare
	 * @return Lista dei reader degli XML da importare
	 */
	/*
	private List<DataReader> getXmlReader(List<SigitTImportDto> dtoList) {
		final String METHOD_NAME = "getXmlReader";
		List<DataReader> xmlList = null;

		loggerHelper.debugBegin(CLASS_NAME, METHOD_NAME);
		xmlList = new ArrayList<DataReader>();
		for(SigitTImportDto dto : dtoList) {
			xmlList.add(new DataStringReader(new String(dto.getFileImport())));
		}
		loggerHelper.debugEnd(CLASS_NAME, METHOD_NAME);
		return xmlList;
	}
	 */
	
	/**
	 * Legge la configurazione del batch
	 * 
	 * @return Configurazione del batch
	 * @throws BatchException Errore durante la lettura del batch
	 */
	/*
	private ImportMassivoAllegatiConf readConfiguration() throws BatchException {
		ImportMassivoAllegatiConf conf = null;
		final String METHOD_NAME = "readConfiguration";

		loggerHelper.debugBegin(CLASS_NAME, METHOD_NAME);
		try {
			conf = businessMgr.readImportMassivoImpiantiConf();
		}
		catch(BusinessMgrException e) {
			loggerHelper.error(CLASS_NAME, METHOD_NAME, "Lettura configurazione fallita", e);
			throw new BatchException(e);
		}
		loggerHelper.debugEnd(CLASS_NAME, METHOD_NAME);
		return conf;
	}
	*/

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getMailObject(BatchConf conf) throws BatchException {
		return conf.getOggettoMail();
	}

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	
	protected String getMailBody(BatchConf conf) throws BatchException {
		StringBuilder mailBody = null;

		mailBody = new StringBuilder();
		boolean isErrorsListEmpty = true;
		if((errorsList != null) && (errorsList.size() > 0)) {
			isErrorsListEmpty = false;
			mailBody.append(conf.getTestoMailKo()).append(MAIL_NEW_LINE);
			mailBody.append(" - Errori riscontrati:").append(MAIL_NEW_LINE);
			for(Errors errors : errorsList) 
			{
				mailBody.append(MAIL_NEW_LINE);
				mailBody.append(MAIL_BLANK).append(MAIL_BLANK);
				mailBody.append("Impianto ").append(errors.getCodiceImpianto()).append(MAIL_NEW_LINE);
				for(String errorMessage : errors.getErrorMessagesList()) {
					if(StringUtils.isNotBlank(errorMessage)) {
						mailBody.append(MAIL_BLANK).append(MAIL_BLANK).append(MAIL_BLANK).append(MAIL_BLANK);
						mailBody.append("- ").append(errorMessage).append(MAIL_NEW_LINE);
					}
				}
			}
		}
		else if((inviatiList != null) && (inviatiList.size() > 0)) {
			mailBody.append(conf.getTestoMailOkInviati());
		}
		else if((importatiList != null) && (importatiList.size() > 0)) {
		
			mailBody.append(conf.getTestoMailOkImportati()).append(MAIL_NEW_LINE);
				
			for(Importati importati : importatiList) 
			{
				mailBody.append(importati.getCodiceImpianto()).append(MAIL_NEW_LINE);
				//mailBody.append(conf.getTestoMailOkImportati()).append(MAIL_NEW_LINE);
				log.debug("Stampo gli impianti importati: "+importati.getCodiceImpianto());
				log.debug("Stampo gli impianti importati (rapp controllo): "+importati.getRapportoControlloList());
			}
				
		}
		
		else 
		{
			mailBody.append(conf.getTestoMailOk());
		}
		
		return mailBody.toString();
	}
	
	
	/**
	 * Restituisce il manager business
	 * 
	 * @return Manager business
	 */
//	public ImportMassivoAllegatiBusinessMgr getBusinessMgr() {
//		return businessMgr;
//	}

	/**
	 * Imposta il manager business
	 * 
	 * @param businessMgr Manager business
	 */
//	public void setBusinessMgr(ImportMassivoAllegatiBusinessMgr businessMgr) {
//		this.businessMgr = businessMgr;
//	}
	
	/**
	 * Restituisce il gestore dei servizi
	 * 
	 * @return Gestore dei servizi common
	 */
	
	public SigitbatchMgr getSigitbatchMgr() {
		return sigitbatchMgr;
	}

	/**
	 * Imposta il gestore dei servizi
	 * 
	 * @param commonSigitMgr Gestore dei servizi common
	 */
	
	public void setSigitbatchMgr(SigitbatchMgr sigitbatchMgr) {
		this.sigitbatchMgr = sigitbatchMgr;
	}
	
}
