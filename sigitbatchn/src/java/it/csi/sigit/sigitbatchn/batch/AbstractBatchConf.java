/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitbatchn.batch;

import java.io.InputStream;
import java.util.Hashtable;

/**
 * Implementazione di una generica configurazione di un batch
 * 
 * @author 71845 - Marco Giacometto
 */
public abstract class AbstractBatchConf implements BatchConf {
	/**
	 * Indirizzo mail del mittente
	 */
	private String indirizzoMailMittente = null;
	/**
	 * Inidirzzo mail del destinatario
	 */
	private String indirizzoMailDestinatario = null;
	/**
	 * Oggetto della mail
	 */
	private String oggettoMail = null;
	/**
	 * Oggetto della mail
	 */
	private String oggettoDinamicoMail = null;
	/**
	 * Testo della mail OK
	 */
	private String testoMailOk = null;
	/**
	 * Testo della mail OK inviati
	 */
	private String testoMailOkInviati = null;
	/**
	 * Testo della mail KO
	 */
	private String testoMailKo = null;
	/**
	 * Oggetto della mail OK importati
	 */
	private String oggettoMailImportati = null;
	/**
	 * Testo della mail OK importati
	 */
	private String testoMailOkImportati = null;
	
	/**
	 * Allegati
	 */
	private Hashtable<String, InputStream> attachmentList = null;
	/**
	 * {@inheritDoc}
	 */
	public void setIndirizzoMailMittente(String indirizzoMailMittente) {
		this.indirizzoMailMittente = indirizzoMailMittente;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getIndirizzoMailMittente() {
		return indirizzoMailMittente;
	}

	/**
	 * {@inheritDoc}
	 */
	public void setIndirizzoMailDestinatario(String indirizzoMailDestinatario) {
		this.indirizzoMailDestinatario = indirizzoMailDestinatario;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getIndirizzoMailDestinatario() {
		return indirizzoMailDestinatario;
	}

	/**
	 * {@inheritDoc}
	 */
	public void setOggettoMail(String oggettoMail) {
		this.oggettoMail = oggettoMail;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getOggettoMail() {
		return oggettoMail;
	}

	/**
	 * {@inheritDoc}
	 */
	public void setOggettoDinamicoMail(String oggettoDinamicoMail) {
		this.oggettoDinamicoMail = oggettoDinamicoMail;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getOggettoDinamicoMail() {
		return oggettoDinamicoMail;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void setTestoMailOk(String testoMailOk) {
		this.testoMailOk = testoMailOk;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getTestoMailOk() {
		return testoMailOk;
	}

	/**
	 * {@inheritDoc}
	 */
	public void setTestoMailOkInviati(String testoMailOkInviati) {
		this.testoMailOkInviati = testoMailOkInviati;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getTestoMailOkInviati() {
		return testoMailOkInviati;
	}

	/**
	 * {@inheritDoc}
	 */
	public void setTestoMailKo(String testoMailKo) {
		this.testoMailKo = testoMailKo;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getTestoMailKo() {
		return testoMailKo;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void setTestoMailOkImportati(String testoMailOkImportati) {
		this.testoMailOkImportati = testoMailOkImportati;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getTestoMailOkImportati() {
		return testoMailOkImportati;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void setOggettoMailImportati(String oggettoMailImportati) {
		this.oggettoMailImportati = oggettoMailImportati;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getOggettoMailImportati() {
		return oggettoMailImportati;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void setAttachmentList(Hashtable<String, InputStream> attachmentList) {
		this.attachmentList = attachmentList;
	}

	/**
	 * {@inheritDoc}
	 */
	public Hashtable<String, InputStream> getAttachmentList() {
		return attachmentList;
	}
	/**
	 * {@inheritDoc}
	 */
	public String toString() {
		StringBuilder builder = null;

		builder = new StringBuilder();
		builder.append("Indirizzo mail mittente:     ").append(getIndirizzoMailMittente()).append("\n");
		builder.append("Indirizzo mail destinatario: ").append(getIndirizzoMailDestinatario()).append("\n");
		builder.append("Oggetto mail:    ").append(getOggettoMail()).append("\n");
		builder.append("Testo mail OK:   ").append(getTestoMailOk()).append("\n");
		builder.append("Testo mail KO:   ").append(getTestoMailKo()).append("\n");
		return builder.toString();
	}
}
