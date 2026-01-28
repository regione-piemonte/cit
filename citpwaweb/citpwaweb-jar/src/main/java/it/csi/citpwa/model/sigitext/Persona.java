/*
 *
 *  * ******************************************************************************
 *  *  SPDX-License-Identifier: EUPL-1.2
 *  *  Copyright Regione Piemonte - 2021
 *  * *****************************************************************************
 *
 */

package it.csi.citpwa.model.sigitext;

import java.io.Serializable;
import java.util.Date;

public class Persona implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer idPersona;
	private String titolo;
	private Integer tipo;
	private String codiceFiscale;
	private String cognomeDenominazione;
	private String nome;
	private Integer residenzaEstera;
	private Integer stradario;
	private String indirizzoSitad;
	private String indirizzoNonTrovato;
	private String comune;
	private String provincia;
	private String civico;
	private String statoEstero;
	private String cittaEstero;
	private String indirizzoEstero;
	private String capEstero;
	private Date dataInizioResp;
	private Date dataFineResp;
	private String email;
	private Boolean flgResp;
	
	private String siglaProv;
	
	private String istatComune;
	
	private String accreditato;
	
	private String cap;
	private Integer newsletter;
	private Integer gdpr;
	
	public String getCap() {
		return cap;
	}
	
	public void setCap(String cap) {
		this.cap = cap;
	}
	
	public Integer getNewsletter() {
		return newsletter;
	}
	
	public void setNewsletter(Integer newsletter) {
		this.newsletter = newsletter;
	}
	
	public Integer getGdpr() {
		return gdpr;
	}
	
	public void setGdpr(Integer gdpr) {
		this.gdpr = gdpr;
	}
	
	public Persona() {
	}
	
	public Persona(Integer idPersona, String titolo, Integer tipo, String codiceFiscale, String cognomeDenominazione, String nome, Integer residenzaEstera, Integer stradario, String indirizzoSitad, String indirizzoNonTrovato, String comune, String provincia, String civico, String statoEstero, String cittaEstero, String indirizzoEstero, String capEstero, Date dataInizioResp, String email, Boolean flgResp, String siglaProv, String istatComune) {
		this.idPersona = idPersona;
		this.titolo = titolo;
		this.tipo = tipo;
		this.codiceFiscale = codiceFiscale;
		this.cognomeDenominazione = cognomeDenominazione;
		this.nome = nome;
		this.residenzaEstera = residenzaEstera;
		this.stradario = stradario;
		this.indirizzoSitad = indirizzoSitad;
		this.indirizzoNonTrovato = indirizzoNonTrovato;
		this.comune = comune;
		this.provincia = provincia;
		this.civico = civico;
		this.statoEstero = statoEstero;
		this.cittaEstero = cittaEstero;
		this.indirizzoEstero = indirizzoEstero;
		this.capEstero = capEstero;
		this.dataInizioResp = dataInizioResp;
		this.email = email;
		this.flgResp = flgResp;
		this.siglaProv = siglaProv;
		this.istatComune = istatComune;
	}
	
	public Integer getIdPersona() {
		return idPersona;
	}
	
	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}
	
	public String getTitolo() {
		return titolo;
	}
	
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	
	public Integer getTipo() {
		return tipo;
	}
	
	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}
	
	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	
	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}
	
	public String getCognomeDenominazione() {
		return cognomeDenominazione;
	}
	
	public void setCognomeDenominazione(String cognomeDenominazione) {
		this.cognomeDenominazione = cognomeDenominazione;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Integer getResidenzaEstera() {
		return residenzaEstera;
	}
	
	public void setResidenzaEstera(Integer residenzaEstera) {
		this.residenzaEstera = residenzaEstera;
	}
	
	public Integer getStradario() {
		return stradario;
	}
	
	public void setStradario(Integer stradario) {
		this.stradario = stradario;
	}
	
	public String getIndirizzoSitad() {
		return indirizzoSitad;
	}
	
	public void setIndirizzoSitad(String indirizzoSitad) {
		this.indirizzoSitad = indirizzoSitad;
	}
	
	public String getIndirizzoNonTrovato() {
		return indirizzoNonTrovato;
	}
	
	public void setIndirizzoNonTrovato(String indirizzoNonTrovato) {
		this.indirizzoNonTrovato = indirizzoNonTrovato;
	}
	
	public String getComune() {
		return comune;
	}
	
	public void setComune(String comune) {
		this.comune = comune;
	}
	
	public String getProvincia() {
		return provincia;
	}
	
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	
	public String getCivico() {
		return civico;
	}
	
	public void setCivico(String civico) {
		this.civico = civico;
	}
	
	public String getStatoEstero() {
		return statoEstero;
	}
	
	public void setStatoEstero(String statoEstero) {
		this.statoEstero = statoEstero;
	}
	
	public String getCittaEstero() {
		return cittaEstero;
	}
	
	public void setCittaEstero(String cittaEstero) {
		this.cittaEstero = cittaEstero;
	}
	
	public String getIndirizzoEstero() {
		return indirizzoEstero;
	}
	
	public void setIndirizzoEstero(String indirizzoEstero) {
		this.indirizzoEstero = indirizzoEstero;
	}
	
	public String getCapEstero() {
		return capEstero;
	}
	
	public void setCapEstero(String capEstero) {
		this.capEstero = capEstero;
	}
	
	public Date getDataInizioResp() {
		return dataInizioResp;
	}
	
	public void setDataInizioResp(Date dataInizioResp) {
		this.dataInizioResp = dataInizioResp;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Boolean getFlgResp() {
		return flgResp;
	}
	
	public void setFlgResp(Boolean resp) {
		flgResp = resp;
	}
	
	public String getSiglaProv() {
		return siglaProv;
	}
	
	public void setSiglaProv(String siglaProv) {
		this.siglaProv = siglaProv;
	}
	
	public String getIstatComune() {
		return istatComune;
	}
	
	public void setIstatComune(String istatComune) {
		this.istatComune = istatComune;
	}
	
	public String getAccreditato() {
		return accreditato;
	}
	
	public void setAccreditato(String accreditato) {
		this.accreditato = accreditato;
	}
	
	
	
	public Date getDataFineResp() {
		return dataFineResp;
	}
	
	public void setDataFineResp(Date dataFineResp) {
		this.dataFineResp = dataFineResp;
	}
	
	@Override
	public String toString() {
		return "Persona{" + "idPersona=" + idPersona + ", titolo='" + titolo + '\'' + ", tipo=" + tipo + ", codiceFiscale='" + codiceFiscale + '\'' + ", cognomeDenominazione='" + cognomeDenominazione
				+ '\'' + ", nome='" + nome + '\'' + ", residenzaEstera=" + residenzaEstera + ", stradario=" + stradario + ", indirizzoSitad='" + indirizzoSitad + '\'' + ", indirizzoNonTrovato='"
				+ indirizzoNonTrovato + '\'' + ", comune='" + comune + '\'' + ", provincia='" + provincia + '\'' + ", civico='" + civico + '\'' + ", statoEstero='" + statoEstero + '\''
				+ ", cittaEstero='" + cittaEstero + '\'' + ", indirizzoEstero='" + indirizzoEstero + '\'' + ", capEstero='" + capEstero + '\'' + ", dataInizioResp=" + dataInizioResp + ", email='"
				+ email + '\'' + ", flgResp=" + flgResp + ", siglaProv='" + siglaProv + '\'' + ", istatComune='" + istatComune + '\'' + ", accreditato='" + accreditato + '\'' + '}';
	}
}
