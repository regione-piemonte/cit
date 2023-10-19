/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Data transfer object relativo al DAO SigitVRicercaImpiantiDao.
 * @generated
 */
public class SigitExtIspezioniSenzaCodImpiantoDto implements Serializable {

	private static final long serialVersionUID = 1L;

	protected Integer idIspezione2018;

	protected String flgPfPg;
	
	protected String cognomeDenom;

	protected String nome;
	
	protected String cfPiva;
	
	protected String dug;

	protected String indirizzo;

	protected String civico;

	protected String cap;

	protected String istatComune;

	protected String flgPfPgFatt;

	protected String cognomeDenomFatt;
	
	protected String nomeFatt;

	protected String cfPivaFatt;
	
	protected String dugFatt;

	protected String indirizzoFatt;

	protected String civicoFatt;

	protected String capFatt;

	protected String istatComuneFatt;

	protected String desTipoContrattoDistrib;

	protected String desCategoriaUtil;

	protected String desCombustibile;

	protected String desUnitaMisura;

	protected java.math.BigDecimal annoRif;

	protected java.math.BigDecimal nrMesiFattur;

	protected java.math.BigDecimal consumoAnno;

	protected java.math.BigDecimal consumoMensile;

	
	//c.des_tipo_contratto_distrib, u.des_categoria_util, comb.des_combustibile, m.des_unita_misura, 
	//d.anno_rif, d.nr_mesi_fattur, d.consumo_anno, d.consumo_mensile
	
	public Integer getIdIspezione2018() {
		return idIspezione2018;
	}

	public void setIdIspezione2018(Integer idIspezione2018) {
		this.idIspezione2018 = idIspezione2018;
	}

	public String getFlgPfPg() {
		return flgPfPg;
	}

	public void setFlgPfPg(String flgPfPg) {
		this.flgPfPg = flgPfPg;
	}

	public String getCognomeDenom() {
		return cognomeDenom;
	}

	public void setCognomeDenom(String cognomeDenom) {
		this.cognomeDenom = cognomeDenom;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCfPiva() {
		return cfPiva;
	}

	public void setCfPiva(String cfPiva) {
		this.cfPiva = cfPiva;
	}

	public String getDug() {
		return dug;
	}

	public void setDug(String dug) {
		this.dug = dug;
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

	public String getCap() {
		return cap;
	}

	public void setCap(String cap) {
		this.cap = cap;
	}

	public String getIstatComune() {
		return istatComune;
	}

	public void setIstatComune(String istatComune) {
		this.istatComune = istatComune;
	}

	public String getFlgPfPgFatt() {
		return flgPfPgFatt;
	}

	public void setFlgPfPgFatt(String flgPfPgFatt) {
		this.flgPfPgFatt = flgPfPgFatt;
	}

	public String getCognomeDenomFatt() {
		return cognomeDenomFatt;
	}

	public void setCognomeDenomFatt(String cognomeDenomFatt) {
		this.cognomeDenomFatt = cognomeDenomFatt;
	}

	public String getNomeFatt() {
		return nomeFatt;
	}

	public void setNomeFatt(String nomeFatt) {
		this.nomeFatt = nomeFatt;
	}

	public String getCfPivaFatt() {
		return cfPivaFatt;
	}

	public void setCfPivaFatt(String cfPivaFatt) {
		this.cfPivaFatt = cfPivaFatt;
	}

	public String getDugFatt() {
		return dugFatt;
	}

	public void setDugFatt(String dugFatt) {
		this.dugFatt = dugFatt;
	}

	public String getIndirizzoFatt() {
		return indirizzoFatt;
	}

	public void setIndirizzoFatt(String indirizzoFatt) {
		this.indirizzoFatt = indirizzoFatt;
	}

	public String getCivicoFatt() {
		return civicoFatt;
	}

	public void setCivicoFatt(String civicoFatt) {
		this.civicoFatt = civicoFatt;
	}

	public String getCapFatt() {
		return capFatt;
	}

	public void setCapFatt(String capFatt) {
		this.capFatt = capFatt;
	}

	public String getIstatComuneFatt() {
		return istatComuneFatt;
	}

	public void setIstatComuneFatt(String istatComuneFatt) {
		this.istatComuneFatt = istatComuneFatt;
	}

	public String getDesTipoContrattoDistrib() {
		return desTipoContrattoDistrib;
	}

	public void setDesTipoContrattoDistrib(String desTipoContrattoDistrib) {
		this.desTipoContrattoDistrib = desTipoContrattoDistrib;
	}

	public String getDesCategoriaUtil() {
		return desCategoriaUtil;
	}

	public void setDesCategoriaUtil(String desCategoriaUtil) {
		this.desCategoriaUtil = desCategoriaUtil;
	}

	public String getDesCombustibile() {
		return desCombustibile;
	}

	public void setDesCombustibile(String desCombustibile) {
		this.desCombustibile = desCombustibile;
	}

	public String getDesUnitaMisura() {
		return desUnitaMisura;
	}

	public void setDesUnitaMisura(String desUnitaMisura) {
		this.desUnitaMisura = desUnitaMisura;
	}

	public java.math.BigDecimal getAnnoRif() {
		return annoRif;
	}

	public void setAnnoRif(java.math.BigDecimal annoRif) {
		this.annoRif = annoRif;
	}

	public java.math.BigDecimal getNrMesiFattur() {
		return nrMesiFattur;
	}

	public void setNrMesiFattur(java.math.BigDecimal nrMesiFattur) {
		this.nrMesiFattur = nrMesiFattur;
	}

	public java.math.BigDecimal getConsumoAnno() {
		return consumoAnno;
	}

	public void setConsumoAnno(java.math.BigDecimal consumoAnno) {
		this.consumoAnno = consumoAnno;
	}

	public java.math.BigDecimal getConsumoMensile() {
		return consumoMensile;
	}

	public void setConsumoMensile(java.math.BigDecimal consumoMensile) {
		this.consumoMensile = consumoMensile;
	}

	
}
