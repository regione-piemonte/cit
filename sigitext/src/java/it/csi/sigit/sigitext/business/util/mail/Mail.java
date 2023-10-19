/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
/*
 * 
 */

package it.csi.sigit.sigitext.business.util.mail;

import java.util.ArrayList;

/**
 * The Class Mail.
 */
public class Mail implements java.io.Serializable {

	/// Field [idEmail]
	/** The _id email. */
	private String _idEmail = null;

	/**
	 * Sets the id email.
	 *
	 * @param val the new id email
	 */
	public void setIdEmail(String val) {
		_idEmail = val;
	}

	/**
	 * Gets the id email.
	 *
	 * @return the id email
	 */
	public String getIdEmail() {
		return _idEmail;
	}

	/// Field [mittente]
	/** The _mittente. */
	private String _mittente = null;

	/**
	 * Sets the mittente.
	 *
	 * @param val the new mittente
	 */
	public void setMittente(String val) {
		_mittente = val;
	}

	/**
	 * Gets the mittente.
	 *
	 * @return the mittente
	 */
	public String getMittente() {
		return _mittente;
	}

	/// Field [oggetto]
	/** The _oggetto. */
	private String _oggetto = null;

	/**
	 * Sets the oggetto.
	 *
	 * @param val the new oggetto
	 */
	public void setOggetto(String val) {
		_oggetto = val;
	}

	/**
	 * Gets the oggetto.
	 *
	 * @return the oggetto
	 */
	public String getOggetto() {
		return _oggetto;
	}

	/// Field [testo]
	/** The _testo. */
	private String _testo = null;

	/**
	 * Sets the testo.
	 *
	 * @param val the new testo
	 */
	public void setTesto(String val) {
		_testo = val;
	}

	/**
	 * Gets the testo.
	 *
	 * @return the testo
	 */
	public String getTesto() {
		return _testo;
	}
	
	/// Field [html]
	/** The _html. */
	private String _html = null;

	/**
	 * Sets the html.
	 *
	 * @param val the new html
	 */
	public void setHtml(String val) {
		_html = val;
	}

	/**
	 * Gets the html.
	 *
	 * @return the html
	 */
	public String getHtml() {
		return _html;
	}

	/// Field [destinatario]
	/** The _destinatario. */
	private String _destinatario = null;

	/**
	 * Sets the destinatario.
	 *
	 * @param val the new destinatario
	 */
	public void setDestinatario(String val) {
		_destinatario = val;
	}

	/**
	 * Gets the destinatario.
	 *
	 * @return the destinatario
	 */
	public String getDestinatario() {
		return _destinatario;
	}

	
	/** The _destinatari. */
	private ArrayList<String> _destinatari = null;

	/**
	 * Sets the destinatario.
	 *
	 * @param val the new destinatario
	 */
	public void setDestinatari(ArrayList<String> val) {
		_destinatari = val;
	}

	/**
	 * Gets the destinatari.
	 *
	 * @return the destinatari
	 */
	public ArrayList<String> getDestinatari() {
		return _destinatari;
	}
	
	/// Field [host]
	/** The _host. */
	private String _host = null;

	/**
	 * Sets the host.
	 *
	 * @param val the new host
	 */
	public void setHost(String val) {
		_host = val;
	}

	/**
	 * Gets the host.
	 *
	 * @return the host
	 */
	public String getHost() {
		return _host;
	}

	/// Field [port]
	/** The _port. */
	private String _port = null;

	/**
	 * Sets the port.
	 *
	 * @param val the new port
	 */
	public void setPort(String val) {
		_port = val;
	}

	/**
	 * Gets the port.
	 *
	 * @return the port
	 */
	public String getPort() {
		return _port;
	}

	/// Field [userId]
	/** The _user id. */
	private String _userId = null;

	/**
	 * Sets the user id.
	 *
	 * @param val the new user id
	 */
	public void setUserId(String val) {
		_userId = val;
	}

	/**
	 * Gets the user id.
	 *
	 * @return the user id
	 */
	public String getUserId() {
		return _userId;
	}

	/// Field [password]
	/** The _password. */
	private String _password = null;

	/**
	 * Sets the password.
	 *
	 * @param val the new password
	 */
	public void setPassword(String val) {
		_password = val;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return _password;
	}

	/// Field [protocol]
	/** The _protocol. */
	private String _protocol = null;

	/**
	 * Sets the protocol.
	 *
	 * @param val the new protocol
	 */
	public void setProtocol(String val) {
		_protocol = val;
	}

	/**
	 * Gets the protocol.
	 *
	 * @return the protocol
	 */
	public String getProtocol() {
		return _protocol;
	}

	private ArrayList<Allegato> _elencoAllegati = new ArrayList<Allegato>();
	
	public void setElencoAllegati(ArrayList<Allegato> val) {
		_elencoAllegati = val;
	}
	
	public ArrayList<Allegato> getElencoAllegati() {
		return _elencoAllegati;
	}

	/// Field [uid]
	/** The _uid. */
	private String _uid = null;

	/**
	 * Sets the uid.
	 *
	 * @param val the new uid
	 */
	public void setUid(String val) {
		_uid = val;
	}

	/**
	 * Gets the uid.
	 *
	 * @return the uid
	 */
	public String getUid() {
		return _uid;
	}

	/// Field [uidSegnatura]
	/** The _uid segnatura. */
	private String _uidSegnatura = null;

	/**
	 * Sets the uid segnatura.
	 *
	 * @param val the new uid segnatura
	 */
	public void setUidSegnatura(String val) {
		_uidSegnatura = val;
	}

	/**
	 * Gets the uid segnatura.
	 *
	 * @return the uid segnatura
	 */
	public String getUidSegnatura() {
		return _uidSegnatura;
	}

	/// Field [nomeAllegato]
	/** The _nome allegato. */
	private String _nomeAllegato = null;

	/**
	 * Sets the nome allegato.
	 *
	 * @param val the new nome allegato
	 */
	public void setNomeAllegato(String val) {
		_nomeAllegato = val;
	}

	/**
	 * Gets the nome allegato.
	 *
	 * @return the nome allegato
	 */
	public String getNomeAllegato() {
		return _nomeAllegato;
	}

	/// Field [destinatarioCC]
	/** The _destinatario cc. */
	private String _destinatarioCC = null;

	/**
	 * Sets the destinatario cc.
	 *
	 * @param val the new destinatario cc
	 */
	public void setDestinatarioCC(String val) {
		_destinatarioCC = val;
	}

	/**
	 * Gets the destinatario cc.
	 *
	 * @return the destinatario cc
	 */
	public String getDestinatarioCC() {
		return _destinatarioCC;
	}

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 */
	public Mail() {
		super();

	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		/*PROTECTED REGION ID(R271254851) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
