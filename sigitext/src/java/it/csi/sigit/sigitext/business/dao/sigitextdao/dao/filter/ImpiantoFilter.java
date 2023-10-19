package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.filter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

public class ImpiantoFilter {

	/**
	 * Codice impianto
	 */
	private Integer codiceImpianto = null;

	/**
	 * sigla provincia
	 */
	private String siglaProvincia = null;

	/**
	 * sigla comune
	 */
	private String siglaComune = null;

	/**
	 * desc comune
	 */
	private String descComune = null;

	/**
	 * indirizzo
	 */
	private String indirizzo = null;

	/**
	 * civico
	 */
	private String civico = null;

	/**
	 * cf responsabile
	 */
	private String cfResponsabile = null;

	/**
	 * cf proprietario
	 */
	private String cfProprietario = null;

	/**
	 * cf terzo responsabile
	 */
	private String cf3Responsabile = null;

	/**
	 * matricola
	 */
	private String matricola = null;

	/**
	 * Sigla REA
	 */
	private String siglaRea = null;
	/**
	 * Numero REA
	 */
	private Integer numeroRea = null;

	/**
	 * Codice fiscale
	 */
	private String cfDitta = null;

	/**
	 * Codice fiscale
	 */
	private String descRuoloFuonz = null;

	/**
	 * POD
	 */
	private String pod = null;

	/**
	 * PDR
	 */
	private String pdr = null;

	private BigDecimal idPersonaGiuridica;

	private Integer ruolo;

	private Date dataControllo;

	private BigDecimal flagVisuProprietario = null;
	
	private ArrayList<String> listaCodiciImpianto;
	/**
	 * Inizializza un'istanza della classe
	 */
	public ImpiantoFilter() {
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

	public String getSiglaProvincia() {
		return siglaProvincia;
	}

	public void setSiglaProvincia(String siglaProvincia) {
		this.siglaProvincia = siglaProvincia;
	}

	public String getSiglaComune() {
		return siglaComune;
	}

	public void setSiglaComune(String siglaComune) {
		this.siglaComune = siglaComune;
	}

	public String getDescComune() {
		return descComune;
	}

	public void setDescComune(String descComune) {
		this.descComune = descComune;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getCivico() {
		return civico;
	}

	public void setCivico(String civico) {
		this.civico = civico;
	}

	public String getCfResponsabile() {
		return cfResponsabile;
	}

	public void setCfResponsabile(String cfResponsabile) {
		this.cfResponsabile = cfResponsabile;
	}

	public String getCfProprietario() {
		return cfProprietario;
	}

	public void setCfProprietario(String cfProprietario) {
		this.cfProprietario = cfProprietario;
	}

	public String getCf3Responsabile() {
		return cf3Responsabile;
	}

	public void setCf3Responsabile(String cf3Responsabile) {
		this.cf3Responsabile = cf3Responsabile;
	}

	public String getMatricola() {
		return matricola;
	}

	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}

	public String getCfDitta() {
		return cfDitta;
	}

	public void setCfDitta(String cfDitta) {
		this.cfDitta = cfDitta;
	}

	public String getDescRuoloFuonz() {
		return descRuoloFuonz;
	}

	public void setDescRuoloFuonz(String descRuoloFuonz) {
		this.descRuoloFuonz = descRuoloFuonz;
	}

	public String getPod() {
		return pod;
	}

	public void setPod(String pod) {
		this.pod = pod;
	}

	public String getPdr() {
		return pdr;
	}

	public void setPdr(String pdr) {
		this.pdr = pdr;
	}

	public BigDecimal getIdPersonaGiuridica() {
		return idPersonaGiuridica;
	}

	public void setIdPersonaGiuridica(BigDecimal idPersonaGiuridica) {
		this.idPersonaGiuridica = idPersonaGiuridica;
	}

	public Integer getRuolo() {
		return ruolo;
	}

	public void setRuolo(Integer ruolo) {
		this.ruolo = ruolo;
	}

	public Date getDataControllo() {
		return dataControllo;
	}

	public void setDataControllo(Date dataControllo) {
		this.dataControllo = dataControllo;
	}

	public BigDecimal getFlagVisuProprietario() {
		return flagVisuProprietario;
	}

	public void setFlagVisuProprietario(BigDecimal flagVisuProprietario) {
		this.flagVisuProprietario = flagVisuProprietario;
	}

	public ArrayList<String> getListaCodiciImpianto() {
		return listaCodiciImpianto;
	}

	public void setListaCodiciImpianto(ArrayList<String> listaCodiciImpianto) {
		this.listaCodiciImpianto = listaCodiciImpianto;
	}

}
