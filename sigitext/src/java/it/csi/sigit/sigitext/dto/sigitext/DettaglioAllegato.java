/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitext.dto.sigitext;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTPersonaGiuridicaDto;

public class DettaglioAllegato implements java.io.Serializable {

	private Integer idAllegato = null;

	public void setIdAllegato(Integer val) {
		idAllegato = val;
	}

	public Integer getIdAllegato() {
		return idAllegato;
	}

	private String dataControllo = null;

	public void setDataControllo(String val) {
		dataControllo = val;
	}

	public String getDataControllo() {
		return dataControllo;
	}

	private String dataIntervento = null;

	public void setDataIntervento(String val) {
		dataIntervento = val;
	}

	public String getDataIntervento() {
		return dataIntervento;
	}
	
	private String tipoAllegato = null;

	public void setTipoAllegato(String val) {
		tipoAllegato = val;
	}

	public String getTipoAllegato() {
		return tipoAllegato;
	}

	private String statoAllegato = null;

	public void setStatoAllegato(String val) {
		statoAllegato = val;
	}
	
	public String getStatoAllegato() {
		return statoAllegato;
	}

	private String osservazioni = null;

	public void setOsservazioni(String val) {
		osservazioni = val;
	}

	public String getOsservazioni() {
		return osservazioni;
	}

	private String raccomandazioni = null;

	public void setRaccomandazioni(String val) {
		raccomandazioni = val;
	}

	public String getRaccomandazioni() {
		return raccomandazioni;
	}

	private String prescrizioni = null;

	public void setPrescrizioni(String val) {
		prescrizioni = val;
	}

	public String getPrescrizioni() {
		return prescrizioni;
	}

	private String interventoRaccomandato = null;

	public void setInterventoRaccomandato(String val) {
		interventoRaccomandato = val;
	}

	public String getInterventoRaccomandato() {
		return interventoRaccomandato;
	}

	private String numeroBollinoVerde = null;

	public void setNumeroBollinoVerde(String val) {
		numeroBollinoVerde = val;
	}

	public String getNumeroBollinoVerde() {
		return numeroBollinoVerde;
	}

	private String idTipoAllegato = null;

	public void setIdTipoAllegato(String val) {
		idTipoAllegato = val;
	}

	public String getIdTipoAllegato() {
		return idTipoAllegato;
	}

	private String siglaBollino = null;

	public void setSiglaBollino(String val) {
		siglaBollino = val;
	}

	public String getSiglaBollino() {
		return siglaBollino;
	}

	private Integer idStatoRapporto = null;

	public void setIdStatoRapporto(Integer val) {
		idStatoRapporto = val;
	}

	public Integer getIdStatoRapporto() {
		return idStatoRapporto;
	}

	private String idIspezIspet = null;

	public void setIdIspezIspet(String val) {
		idIspezIspet = val;
	}

	public String getIdIspezIspet() {
		return idIspezIspet;
	}

	private String codiceImpianto = null;

	public void setCodiceImpianto(String val) {
		codiceImpianto = val;
	}

	public String getCodiceImpianto() {
		return codiceImpianto;
	}

	private Integer flagControlloBozza = null;

	public void setFlagControlloBozza(Integer val) {
		flagControlloBozza = val;
	}

	public Integer getFlagControlloBozza() {
		return flagControlloBozza;
	}

	private String codFiscaleUtenteLoggato = null;

	public void setCodFiscaleUtenteLoggato(String val) {
		codFiscaleUtenteLoggato = val;
	}

	public String getCodFiscaleUtenteLoggato() {
		return codFiscaleUtenteLoggato;
	}

	private String arrivoDa = null;

	public void setArrivoDa(String val) {
		arrivoDa = val;
	}

	public String getArrivoDa() {
		return arrivoDa;
	}

	private java.util.ArrayList<String> idTipiCombustibile = new java.util.ArrayList<String>();

	public void setIdTipiCombustibile(java.util.ArrayList<String> val) {
		idTipiCombustibile = val;
	}
	
	public java.util.ArrayList<String> getIdTipiCombustibile() {
		return idTipiCombustibile;
	}

	private java.util.ArrayList<String> idApparecchiature = new java.util.ArrayList<String>();

	public void setIdApparecchiature(java.util.ArrayList<String> val) {
		idApparecchiature = val;
	}

	public java.util.ArrayList<String> getIdApparecchiature() {
		return idApparecchiature;
	}

	private java.util.ArrayList<String> idApparecchiatureFunz = new java.util.ArrayList<String>();

	public void setIdApparecchiatureFunz(java.util.ArrayList<String> val) {
		idApparecchiatureFunz = val;
	}
	
	public java.util.ArrayList<String> getIdApparecchiatureFunz() {
		return idApparecchiatureFunz;
	}

	private String elencoCombustibili = null;

	public void setElencoCombustibili(String val) {
		elencoCombustibili = val;
	}

	public String getElencoCombustibili() {
		return elencoCombustibili;
	}

	private String elencoApparecchiature = null;

	public void setElencoApparecchiature(String val) {
		elencoApparecchiature = val;
	}

	public String getElencoApparecchiature() {
		return elencoApparecchiature;
	}

	private Integer idIspezione = null;

	public void setIdIspezione(Integer val) {
		idIspezione = val;
	}

	public Integer getIdIspezione() {
		return idIspezione;
	}

	private String ruoloFunzionale = null;

	public void setRuoloFunzionale(String val) {
		ruoloFunzionale = val;
	}

	public String getRuoloFunzionale() {
		return ruoloFunzionale;
	}

	private SigitTPersonaGiuridicaDto personaGiuridica = null;

	public void setPersonaGiuridica(SigitTPersonaGiuridicaDto val) {
		personaGiuridica = val;
	}

	public SigitTPersonaGiuridicaDto getPersonaGiuridica() {
		return personaGiuridica;
	}

	private java.util.ArrayList<String> idCom4Manut = new java.util.ArrayList<String>();

	public void setIdCom4Manut(java.util.ArrayList<String> val) {
		idCom4Manut = val;
	}

	public java.util.ArrayList<String> getIdCom4Manut() {
		return idCom4Manut;
	}

	private String codiceReaPg = null;

	public void setCodiceReaPg(String val) {
		codiceReaPg = val;
	}

	public String getCodiceReaPg() {
		return codiceReaPg;
	}

	private String codiceFiscalePg = null;

	public void setCodiceFiscalePg(String val) {
		codiceFiscalePg = val;
	}

	public String getCodiceFiscalePg() {
		return codiceFiscalePg;
	}

	private Integer idStatoPg = null;

	public void setIdStatoPg(Integer val) {
		idStatoPg = val;
	}

	public Integer getIdStatoPg() {
		return idStatoPg;
	}

	private String codiceBollino = null;

	public void setCodiceBollino(String val) {
		codiceBollino = val;
	}

	public String getCodiceBollino() {
		return codiceBollino;
	}

	private Integer idTipoRapProva = null;

	public void setIdTipoRapProva(Integer val) {
		idTipoRapProva = val;
	}

	public Integer getIdTipoRapProva() {
		return idTipoRapProva;
	}

	private Integer idIspezione2018 = null;

	public void setIdIspezione2018(Integer val) {
		idIspezione2018 = val;
	}

	public Integer getIdIspezione2018() {
		return idIspezione2018;
	}

	private String oraArrivo = null;

	public void setOraArrivo(String val) {
		oraArrivo = val;
	}

	public String getOraArrivo() {
		return oraArrivo;
	}

	private String presenzaVerifica = null;

	public void setPresenzaVerifica(String val) {
		presenzaVerifica = val;
	}

	public String getPresenzaVerifica() {
		return presenzaVerifica;
	}

	private static final long serialVersionUID = 1L;

	public DettaglioAllegato() {
		super();

	}

	public String toString() {
		return super.toString();
	}
}
