/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitbatchn.batch.importmassivodistributori;

import it.csi.sigit.sigitbatchn.batch.AbstractBatch;
import it.csi.sigit.sigitbatchn.batch.BatchConf;
import it.csi.sigit.sigitbatchn.batch.BatchException;
import it.csi.sigit.sigitbatchn.batch.reader.DataReader;
import it.csi.sigit.sigitbatchn.batch.reader.DataStringReader;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.SigitTImpXmlDto;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.SigitTImportDistribDto;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.SigitTImportDto;
import it.csi.sigit.sigitbatchn.business.manager.SigitbatchMgr;
import it.csi.sigit.sigitbatchn.business.manager.business.ImportMassivoAllegatiBusinessMgr;
import it.csi.sigit.sigitbatchn.business.manager.util.ManagerException;
import it.csi.sigit.sigitbatchn.business.manager.util.Messages;
import it.csi.sigit.sigitbatchn.business.manager.util.ServiceException;
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
 * Batch per recuperare le informazioni dei distributori
 * 
 */
public class ImportMassivoDistributoriBatch extends AbstractBatch {
	/**
	 * Nome della classe
	 */
	private final static String CLASS_NAME = ImportMassivoDistributoriBatch.class.getSimpleName();
	
	protected static Logger log = Logger.getLogger(Constants.APPLICATION_CODE
			+ ".business");
	
	
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
		ImportMassivoDistributoriConf conf = null;
		List<DataReader> xmlReaderList = null;
		List<SigitTImportDistribDto> dtoList = null;
		List<SigitTImportDto> dtoListVerificati = null;

		log.debug("[ImportMassivoDistributoriBatch::execute] BEGIN");
		try {
			//conf = readConfiguration();
			
			String dataInizioElaborazione = DateUtil.getDataCorrenteCompletaFormat();
			
			
			dtoList = getSigitbatchMgr().getXmlDistributoriDaImportare();
			
			for (SigitTImportDistribDto sigitTImportDto : dtoList) {
				
				
				log.debug("GESTISCO L'ID IMPORT: "+sigitTImportDto.getIdImportDistrib());
				log.debug("Nome file: "+sigitTImportDto.getNomeFileImport());
				//testaInvioMail(sigitTImportDto);
				 
				
				
				try
				{
					getSigitbatchMgr().gestisciXmlDistributore(sigitTImportDto.getNomeFileImport(), sigitTImportDto);

				}
				

//				catch (ManagerException ex)
//				{
//										
//					String msg = ex.getMessage();
//
//					msg = msg.replaceFirst("##valueNomeFile##", sigitTImportDto.getNomeFileImport());
//					
//					
//					getSigitbatchMgr().gestisciErroreAllegato(sigitTImportDto, msg);
//				}
				catch (Exception ex)
				{
					log.error(ex);
					// DA GESTIRE
					//ex.printStackTrace();
				}
				
			}
			
			
			// DEVO INVIARE LA MAIL ALL'ASSISTENZA
			getSigitbatchMgr().gestisciInvioMailAssistenzaDistrib(dataInizioElaborazione);
			
			String msgError = null;
			try
			{
				getSigitbatchMgr().gestisciCancellazioneImportDistributori();
			}
			catch (ServiceException e)
			{
				// C'è stata un'eccezione nella cancellazione
				msgError = e.getMessage();
			}
			finally
			{
				// DEVO INVIARE LA MAIL ALL'ASSISTENZA
				getSigitbatchMgr().inviaMailAssistenzaCancellaDistrib(msgError);
			}
			
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
		log.debug("[ImportMassivoDistributoriBatch::execute] END");
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
