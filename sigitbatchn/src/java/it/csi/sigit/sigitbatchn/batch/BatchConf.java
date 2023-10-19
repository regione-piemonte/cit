/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitbatchn.batch;

import java.io.InputStream;
import java.util.Hashtable;

/**
 * Interfaccia di una generica configurazione di un batch
 * 
 * @author 71845 - Marco Giacometto
 */
public interface BatchConf {
	/**
	 * Imposta l'indirizzo mail del mittente
	 * 
	 * @param indirizzoMailMittente Indirizzo mail del mittente
	 */
	public void setIndirizzoMailMittente(String indirizzoMailMittente);

	/**
	 * Restituisce l'indirizzo mail del mittente
	 * 
	 * @return Indirizzo mail del mittente
	 */
	public String getIndirizzoMailMittente();

	/**
	 * Imposta l'inidirzzo mail del destinatario
	 * 
	 * @param indirizzoMailDestinatario Inidirzzo mail del destinatario
	 */
	public void setIndirizzoMailDestinatario(String indirizzoMailDestinatario);

	/**
	 * Restituisce l'inidirzzo mail del destinatario
	 * 
	 * @return Inidirzzo mail del destinatario
	 */
	public String getIndirizzoMailDestinatario();

	/**
	 * Imposta l'oggetto della mail
	 * 
	 * @param oggettoMail Oggetto della mail
	 */
	public void setOggettoMail(String oggettoMail);

	
	/**
	 * Restituisce l'oggetto della mail
	 * 
	 * @return Oggetto della mail
	 */
	public String getOggettoMail();

	/**
	 * Restituisce l'oggetto della mail (dinamico opzionale)
	 * 
	 * @return Oggetto (dinamico opzionale) della mail
	 */
	public String getOggettoDinamicoMail();
	
	/**
	 * Restituisce l'oggetto della mail degli importati
	 * 
	 * @return Oggetto della mail
	 */
	public String getOggettoMailImportati();

	/**
	 * Imposta il testo della mail OK
	 * 
	 * @param testoMailOk Testo della mail OK
	 */
	public void setTestoMailOk(String testoMailOk);

	/**
	 * Restituisce il testo della mail OK
	 * 
	 * @return Testo della mail OK
	 */
	public String getTestoMailOk();

	/**
	 * Restituisce il testo della mail OK inviati
	 * 
	 * @return Testo della mail OK
	 */
	public String getTestoMailOkInviati();
	
	/**
	 * Restituisce il testo della mail OK importati
	 * 
	 * @return Testo della mail OK
	 */
	public String getTestoMailOkImportati();
	
	
	/**
	 * Imposta il testo della mail KO
	 * 
	 * @param testoMailKo Testo della mail KO
	 */
	public void setTestoMailKo(String testoMailKo);

	/**
	 * Restituisce il testo della mail KO
	 * 
	 * @return Testo della mail KO
	 */
	public String getTestoMailKo();
	/**
	 * Imposta gli allegati
	 * 
	 * @param Allegati
	 */
	public void setAttachmentList(Hashtable<String, InputStream> attachmentList);
	/**
	 * Restituisce gli allegati
	 * 
	 * @return Allegati
	 */
	public Hashtable getAttachmentList();
}
