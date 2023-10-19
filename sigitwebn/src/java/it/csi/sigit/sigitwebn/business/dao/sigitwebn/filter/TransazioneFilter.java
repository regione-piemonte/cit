/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter;

import java.math.BigDecimal;
import java.sql.Date;

/**
 * Filtro per cercare per codice REA
 * 
 */
public class TransazioneFilter {

	/**
	 * Codice impianto
	 */
	private Integer codiceImpianto = null;
	
	/**
	 * Codice impianto
	 */
	private String siglaBollino = null;
	
	/**
	 * Numero bollino
	 */
	private Integer numeroBollino = null;
	
	/**
	 * Sigla REA
	 */
	private String siglaRea = null;
	/**
	 * Numero REA
	 */
	private Integer numeroRea = null;

	/**
	 * Id persona giuridica
	 */
	private Integer idPersonaGiuridica = null;

	/**
	 * Codice fiscale
	 */
	private String codiceFiscale = null;
	
	/**
	 * Data controllo
	 */
	private Date dataControllo = null;
	
	/**
	 * Data acquisizione da
	 */
	private Date dataAcquisizioneDa = null;
	
	/**
	 * Data acquisizione a
	 */
	private Date dataAcquisizioneA = null;
	
	
	
	/**
	 * Inizializza un'istanza della classe
	 */
	public TransazioneFilter() {
	}

	/**
	 * Inizializza un'istanza della classe
	 * 
	 * @param codiceImpianto Codice impianto
	 * @param siglaRea Sigla REA
	 * @param numeroRea Numero REA
	 * @param codiceFiscale  Codice fiscale
	 */
	public TransazioneFilter(Integer codiceImpianto, String siglaRea, Integer numeroRea, String codiceFiscale, Date dataAcquisizioneDa, Date dataAcquisizioneA) {
		this.codiceImpianto = codiceImpianto;
		this.siglaRea = siglaRea;
		this.numeroRea = numeroRea;
		this.codiceFiscale = codiceFiscale;
		this.dataAcquisizioneDa = dataAcquisizioneDa;
		this.dataAcquisizioneA = dataAcquisizioneA;
		
	}

	/**
	 * Inizializza un'istanza della classe
	 * 
	 * @param siglaBollino Sigla bollino
	 * @param numeroBollino Numero bollino
	 * @param siglaRea Sigla REA
	 * @param numeroRea Numero REA
	 * @param codiceFiscale  Codice fiscale
	 */
	public TransazioneFilter(String siglaBollino, Integer numeroBollino, String siglaRea, Integer numeroRea, String codiceFiscale, Date dataAcquisizioneDa, Date dataAcquisizioneA) {
		this.siglaBollino = siglaBollino;
		this.numeroBollino = numeroBollino;
		this.siglaRea = siglaRea;
		this.numeroRea = numeroRea;
		this.codiceFiscale = codiceFiscale;
		this.dataAcquisizioneDa = dataAcquisizioneDa;
		this.dataAcquisizioneA = dataAcquisizioneA;
	}

	/**
	 * Inizializza un'istanza della classe
	 * 
	 * @param siglaBollino Sigla bollino
	 * @param numeroBollino Numero bollino
	 * @param siglaRea Sigla REA
	 * @param numeroRea Numero REA
	 * @param codiceFiscale  Codice fiscale
	 */
	public TransazioneFilter(String siglaBollino, Integer numeroBollino, Integer idPersonaGiuridica) {
		this.siglaBollino = siglaBollino;
		this.numeroBollino = numeroBollino;
		this.idPersonaGiuridica = idPersonaGiuridica;
	}
	/**
	 * Imposta il codice impianto
	 * 
	 * @param codiceFiscale Codice impianto
	 */
	public void setCodiceImpianto(Integer codiceImpianto) {
		this.codiceImpianto = codiceImpianto;
	}

	/**
	 * Restituisce il codice impianto
	 * 
	 * @return Codice impianto
	 */
	public Integer getCodiceImpianto() {
		return codiceImpianto;
	}
	
	/**
	 * Restituisce la sigla bollino
	 * 
	 * @return Sigla bollino
	 */
	public String getSiglaBollino() {
		return siglaBollino;
	}
	
	/**
	 * Imposta la sigla bollino
	 * 
	 * @param siglaBollino Sigla bollino
	 */
	public void setSiglaBollino(String siglaBollino) {
		this.siglaBollino = siglaBollino;
	}
	
	/**
	 * Restituisce il numero bollino
	 * 
	 * @return Numero bollino
	 */
	public Integer getNumeroBollino() {
		return numeroBollino;
	}
	
	/**
	 * Imposta il numero bollino
	 * 
	 * @param numeroBollino Numero bollino
	 */
	public void setNumeroBollino(Integer numeroBollino) {
		this.numeroBollino = numeroBollino;
	}

	/**
	 * Restituisce la sigla REA
	 * 
	 * @return Sigla REA
	 */
	public String getSiglaRea() {
		return siglaRea;
	}

	/**
	 * Imposta la sigla REA
	 * 
	 * @param siglaRea Sigla REA
	 */
	public void setSiglaRea(String siglaRea) {
		this.siglaRea = siglaRea;
	}

	/**
	 * Restituisce il numero REA
	 * 
	 * @return Numero REA
	 */
	public Integer getNumeroRea() {
		return numeroRea;
	}

	/**
	 * Imposta il numero REA
	 * 
	 * @param numeroRea Numero REA
	 */
	public void setNumeroRea(Integer numeroRea) {
		this.numeroRea = numeroRea;
	}
	
	/**
	 * Imposta il codice fiscale
	 * 
	 * @param codiceFiscale Codice fiscale
	 */
	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	/**
	 * Restituisce il codice fiscale
	 * 
	 * @return Codice fiscale
	 */
	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	
	/**
	 * Imposta la data controllo
	 * 
	 * @param dataControllo Data controllo
	 */
	public void setDataControllo(Date dataControllo) {
		this.dataControllo = dataControllo;
	}

	/**
	 * Restituisce il data controllo
	 * 
	 * @return Data controllo
	 */
	public Date getDataControllo() {
		return dataControllo;
	}

	public Date getDataAcquisizioneDa() {
		return dataAcquisizioneDa;
	}

	public void setDataAcquisizioneDa(Date dataAcquisizioneDa) {
		this.dataAcquisizioneDa = dataAcquisizioneDa;
	}

	public Date getDataAcquisizioneA() {
		return dataAcquisizioneA;
	}

	public void setDataAcquisizioneA(Date dataAcquisizioneA) {
		this.dataAcquisizioneA = dataAcquisizioneA;
	}

	public Integer getIdPersonaGiuridica() {
		return idPersonaGiuridica;
	}

	public void setIdPersonaGiuridica(Integer idPersonaGiuridica) {
		this.idPersonaGiuridica = idPersonaGiuridica;
	}
	
	
}
