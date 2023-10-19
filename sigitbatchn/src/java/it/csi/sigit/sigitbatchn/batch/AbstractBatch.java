/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitbatchn.batch;

import java.io.InputStream;
import java.util.Hashtable;

import org.apache.commons.lang.StringUtils;



import it.csi.sigit.sigitbatchn.business.util.LoggerHelper;
import it.csi.sigit.sigitbatchn.business.util.mail.MailSender;

/**
 * Generico batch
 * 
 * @author 71845 - Marco Giacometto
 */
public abstract class AbstractBatch implements Batch {
	/**
	 * Nome della classe
	 */
	public final static String CLASS_NAME = AbstractBatch.class.getSimpleName();
	/**
	 * Nuova riga da utilizzare nelle mail
	 */
	public final static String MAIL_NEW_LINE = "<br>";
	/**
	 * Blank da utilizzare nelle mail
	 */
	public final static String MAIL_BLANK = "&nbsp;";
	/**
	 * Gestore dei messaggi
	 */
	//protected MsgMgr msgMgr = null;
	/**
	 * Mail sender per invare la mail di fine batch
	 */
	protected MailSender mailSender = null;
	/**
	 * Import dei dati
	 */
	protected DataImport dataImport = null;

	
	
	/**
	 * Restituisce il gestore dei messaggi
	 * 
	 * @return Gestore dei messaggi
	 */
//	public MsgMgr getMsgMgr() {
//		return msgMgr;
//	}

	/**
	 * Imposta il gestore dei messaggi
	 * 
	 * @param msgMgr Gestore dei messaggi
	 */
//	public void setMsgMgr(MsgMgr msgMgr) {
//		this.msgMgr = msgMgr;
//	}

	/**
	 * Imposta il Mail sender per invare la mail di fine batch
	 * 
	 * @param mailSender Mail sender per invare la mail di fine batch
	 */
	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}

	/**
	 * Restituisce il Mail sender per invare la mail di fine batch
	 * 
	 * @return Mail sender per invare la mail di fine batch
	 */
	public MailSender getMailSender() {
		return mailSender;
	}

	/**
	 * Imposta l'import dei dati
	 * 
	 * @param dataImport Import dei dati
	 */
	public void setDataImport(DataImport dataImport) {
		this.dataImport = dataImport;
	}

	/**
	 * Restituisce l'import dei dati
	 * 
	 * @return Import dei dati
	 */
	public DataImport getDataImport() {
		return dataImport;
	}

	/**
	 * Invia una mail di fine batch
	 * 
	 * @param conf Configurazione del batch
	 * @throws BatchException Errore durante l'invio della mail
	 */
	/*
	protected void sendMail(BatchConf conf) throws BatchException {
		final String METHOD_NAME = "sendMail";
		String mailBody = null;
		String mailObject = null;

		loggerHelper.debugBegin(CLASS_NAME, METHOD_NAME);
		try {
			mailObject = getMailObject(conf);
			mailBody = getMailBody(conf);
			
			loggerHelper.debug("INVIO MAIL");
			loggerHelper.debug("Stampo il getIndirizzoMailMittente: "+conf.getIndirizzoMailMittente());
			loggerHelper.debug("Stampo il getIndirizzoMailDestinatario: "+conf.getIndirizzoMailDestinatario());
			loggerHelper.debug("Stampo l'oggetto: "+mailObject);
			loggerHelper.debug("Stampo il mailBody: "+mailBody);

			// In caso di invio Ricevute
			Hashtable<String, InputStream> attachmentList = null;
			if (conf.getAttachmentList() != null && !conf.getAttachmentList().isEmpty())
			{
				attachmentList = conf.getAttachmentList();
				
				if (StringUtils.isNotBlank(conf.getOggettoDinamicoMail()))
					mailObject += " ("+conf.getOggettoDinamicoMail()+") ";
			}
			
			//mailSender.send(conf.getIndirizzoMailMittente(), conf.getIndirizzoMailDestinatario(), null, null, mailObject, mailBody, attachmentList);
		}
		catch(Exception e) {
			loggerHelper.error(CLASS_NAME, METHOD_NAME, "Invio mail di fine batch fallito", e);
			throw new BatchException(e);
		}
		loggerHelper.debugEnd(CLASS_NAME, METHOD_NAME);
	}
	*/

	/**
	 * Invia una mail di fine batch
	 * 
	 * @param conf Configurazione del batch
	 * @throws BatchException Errore durante l'invio della mail
	 */
	/*
	protected void sendMailImportati(BatchConf conf) throws BatchException {
		final String METHOD_NAME = "sendMail";
		String mailBody = null;
		String mailObject = null;

		loggerHelper.debugBegin(CLASS_NAME, METHOD_NAME);
		try {
			mailObject = conf.getOggettoMailImportati();
			mailBody = getMailBody(conf);
			
			loggerHelper.debug("INVIO MAIL");
			loggerHelper.debug("Stampo il getIndirizzoMailMittente: "+conf.getIndirizzoMailMittente());
			loggerHelper.debug("Stampo il getIndirizzoMailDestinatario: "+conf.getIndirizzoMailDestinatario());
			loggerHelper.debug("Stampo l'oggetto: "+mailObject);
			loggerHelper.debug("Stampo il mailBody: "+mailBody);

			// In caso di invio Ricevute
			Hashtable<String, InputStream> attachmentList = null;
			
			loggerHelper.debug("Stampo gli attachmentList(): "+conf.getAttachmentList());
			//mailObject += " ("+conf.getOggettoDinamicoMail()+") ";
			
			if (conf.getAttachmentList() != null && !conf.getAttachmentList().isEmpty())
			{
				attachmentList = conf.getAttachmentList();
				
				if (StringUtils.isNotBlank(conf.getOggettoDinamicoMail()))
					mailBody += " ("+conf.getOggettoDinamicoMail()+") ";
			}
			
			//mailSender.send(conf.getIndirizzoMailMittente(), conf.getIndirizzoMailDestinatario(), null, null, mailObject, mailBody, null);
		}
		catch(Exception e) {
			loggerHelper.error(CLASS_NAME, METHOD_NAME, "Invio mail di fine batch fallito", e);
			throw new BatchException(e);
		}
		loggerHelper.debugEnd(CLASS_NAME, METHOD_NAME);
	}
	*/
	
	/**
	 * Restituisce l'oggetto della mail
	 * 
	 * @param conf Configurazione del batch
	 * @return Oggetto della mail
	 * @throws BatchException Errore durante la costruzione dell'oggetto della
	 *             mail
	 */
	protected abstract String getMailObject(BatchConf conf) throws BatchException;
	
	/**
	 * Restituisce il corpo della mail
	 * 
	 * @param conf Configurazione del batch
	 * @return Corpo della mail
	 * @throws BatchException Errore durante la costruzione del corpo della mail
	 */
	protected abstract String getMailBody(BatchConf conf) throws BatchException;
}
