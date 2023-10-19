package it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto;

import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dao.*;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Data transfer object relativo al DAO SigitVRicerca3ResponsabileDao.
 * @generated
 */
public class SigitVRicerca3ResponsabileDto implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_CONTRATTO
	 * @generated
	 */
	protected java.math.BigDecimal idContratto;

	/**
	 * Imposta il valore della proprieta' idContratto associata alla
	 * colonna ID_CONTRATTO.
	 * @generated
	 */
	public void setIdContratto(java.math.BigDecimal val) {

		idContratto = val;

	}

	/**
	 * Legge il valore della proprieta' idContratto associata alla
	 * @generated
	 */
	public java.math.BigDecimal getIdContratto() {

		return idContratto;

	}

	/**
	 * store della proprieta' associata alla colonna CODICE_IMPIANTO
	 * @generated
	 */
	protected java.math.BigDecimal codiceImpianto;

	/**
	 * Imposta il valore della proprieta' codiceImpianto associata alla
	 * colonna CODICE_IMPIANTO.
	 * @generated
	 */
	public void setCodiceImpianto(java.math.BigDecimal val) {

		codiceImpianto = val;

	}

	/**
	 * Legge il valore della proprieta' codiceImpianto associata alla
	 * @generated
	 */
	public java.math.BigDecimal getCodiceImpianto() {

		return codiceImpianto;

	}

	/**
	 * store della proprieta' associata alla colonna FK_RUOLO
	 * @generated
	 */
	protected java.math.BigDecimal fkRuolo;

	/**
	 * Imposta il valore della proprieta' fkRuolo associata alla
	 * colonna FK_RUOLO.
	 * @generated
	 */
	public void setFkRuolo(java.math.BigDecimal val) {

		fkRuolo = val;

	}

	/**
	 * Legge il valore della proprieta' fkRuolo associata alla
	 * @generated
	 */
	public java.math.BigDecimal getFkRuolo() {

		return fkRuolo;

	}

	/**
	 * store della proprieta' associata alla colonna DES_RUOLO
	 * @generated
	 */
	protected String desRuolo;

	/**
	 * Imposta il valore della proprieta' desRuolo associata alla
	 * colonna DES_RUOLO.
	 * @generated
	 */
	public void setDesRuolo(String val) {

		desRuolo = val;

	}

	/**
	 * Legge il valore della proprieta' desRuolo associata alla
	 * @generated
	 */
	public String getDesRuolo() {

		return desRuolo;

	}

	/**
	 * store della proprieta' associata alla colonna DATA_CARICAMENTO
	 * @generated
	 */
	protected java.sql.Timestamp dataCaricamento;

	/**
	 * Imposta il valore della proprieta' dataCaricamento associata alla
	 * colonna DATA_CARICAMENTO.
	 * @generated
	 */
	public void setDataCaricamento(java.sql.Timestamp val) {

		if (val != null) {
			dataCaricamento = new java.sql.Timestamp(val.getTime());
		} else {
			dataCaricamento = null;
		}

	}

	/**
	 * Legge il valore della proprieta' dataCaricamento associata alla
	 * @generated
	 */
	public java.sql.Timestamp getDataCaricamento() {

		if (dataCaricamento != null) {
			return new java.sql.Timestamp(dataCaricamento.getTime());
		} else {
			return null;
		}

	}

	/**
	 * store della proprieta' associata alla colonna DATA_CESSAZIONE
	 * @generated
	 */
	protected java.sql.Timestamp dataCessazione;

	/**
	 * Imposta il valore della proprieta' dataCessazione associata alla
	 * colonna DATA_CESSAZIONE.
	 * @generated
	 */
	public void setDataCessazione(java.sql.Timestamp val) {

		if (val != null) {
			dataCessazione = new java.sql.Timestamp(val.getTime());
		} else {
			dataCessazione = null;
		}

	}

	/**
	 * Legge il valore della proprieta' dataCessazione associata alla
	 * @generated
	 */
	public java.sql.Timestamp getDataCessazione() {

		if (dataCessazione != null) {
			return new java.sql.Timestamp(dataCessazione.getTime());
		} else {
			return null;
		}

	}

	/**
	 * store della proprieta' associata alla colonna DATA_INSERIMENTO_CESSAZIONE
	 * @generated
	 */
	protected java.sql.Timestamp dataInserimentoCessazione;

	/**
	 * Imposta il valore della proprieta' dataInserimentoCessazione associata alla
	 * colonna DATA_INSERIMENTO_CESSAZIONE.
	 * @generated
	 */
	public void setDataInserimentoCessazione(java.sql.Timestamp val) {

		if (val != null) {
			dataInserimentoCessazione = new java.sql.Timestamp(val.getTime());
		} else {
			dataInserimentoCessazione = null;
		}

	}

	/**
	 * Legge il valore della proprieta' dataInserimentoCessazione associata alla
	 * @generated
	 */
	public java.sql.Timestamp getDataInserimentoCessazione() {

		if (dataInserimentoCessazione != null) {
			return new java.sql.Timestamp(dataInserimentoCessazione.getTime());
		} else {
			return null;
		}

	}

	/**
	 * store della proprieta' associata alla colonna FK_PG_3_RESP
	 * @generated
	 */
	protected java.math.BigDecimal fkPg3Resp;

	/**
	 * Imposta il valore della proprieta' fkPg3Resp associata alla
	 * colonna FK_PG_3_RESP.
	 * @generated
	 */
	public void setFkPg3Resp(java.math.BigDecimal val) {

		fkPg3Resp = val;

	}

	/**
	 * Legge il valore della proprieta' fkPg3Resp associata alla
	 * @generated
	 */
	public java.math.BigDecimal getFkPg3Resp() {

		return fkPg3Resp;

	}

	/**
	 * store della proprieta' associata alla colonna FK_IMP_RUOLO_PFPG_RESP
	 * @generated
	 */
	protected java.math.BigDecimal fkImpRuoloPfpgResp;

	/**
	 * Imposta il valore della proprieta' fkImpRuoloPfpgResp associata alla
	 * colonna FK_IMP_RUOLO_PFPG_RESP.
	 * @generated
	 */
	public void setFkImpRuoloPfpgResp(java.math.BigDecimal val) {

		fkImpRuoloPfpgResp = val;

	}

	/**
	 * Legge il valore della proprieta' fkImpRuoloPfpgResp associata alla
	 * @generated
	 */
	public java.math.BigDecimal getFkImpRuoloPfpgResp() {

		return fkImpRuoloPfpgResp;

	}

	/**
	 * store della proprieta' associata alla colonna DATA_INIZIO_CONTRATTO
	 * @generated
	 */
	protected java.sql.Date dataInizioContratto;

	/**
	 * Imposta il valore della proprieta' dataInizioContratto associata alla
	 * colonna DATA_INIZIO_CONTRATTO.
	 * @generated
	 */
	public void setDataInizioContratto(java.sql.Date val) {

		if (val != null) {
			dataInizioContratto = new java.sql.Date(val.getTime());
		} else {
			dataInizioContratto = null;
		}

	}

	/**
	 * Legge il valore della proprieta' dataInizioContratto associata alla
	 * @generated
	 */
	public java.sql.Date getDataInizioContratto() {

		if (dataInizioContratto != null) {
			return new java.sql.Date(dataInizioContratto.getTime());
		} else {
			return null;
		}

	}

	/**
	 * store della proprieta' associata alla colonna DATA_FINE_CONTRATTO
	 * @generated
	 */
	protected java.sql.Date dataFineContratto;

	/**
	 * Imposta il valore della proprieta' dataFineContratto associata alla
	 * colonna DATA_FINE_CONTRATTO.
	 * @generated
	 */
	public void setDataFineContratto(java.sql.Date val) {

		if (val != null) {
			dataFineContratto = new java.sql.Date(val.getTime());
		} else {
			dataFineContratto = null;
		}

	}

	/**
	 * Legge il valore della proprieta' dataFineContratto associata alla
	 * @generated
	 */
	public java.sql.Date getDataFineContratto() {

		if (dataFineContratto != null) {
			return new java.sql.Date(dataFineContratto.getTime());
		} else {
			return null;
		}

	}

	/**
	 * store della proprieta' associata alla colonna FLG_TACITO_RINNOVO
	 * @generated
	 */
	protected java.math.BigDecimal flgTacitoRinnovo;

	/**
	 * Imposta il valore della proprieta' flgTacitoRinnovo associata alla
	 * colonna FLG_TACITO_RINNOVO.
	 * @generated
	 */
	public void setFlgTacitoRinnovo(java.math.BigDecimal val) {

		flgTacitoRinnovo = val;

	}

	/**
	 * Legge il valore della proprieta' flgTacitoRinnovo associata alla
	 * @generated
	 */
	public java.math.BigDecimal getFlgTacitoRinnovo() {

		return flgTacitoRinnovo;

	}

	/**
	 * store della proprieta' associata alla colonna RESP_CODICE_FISCALE
	 * @generated
	 */
	protected String respCodiceFiscale;

	/**
	 * Imposta il valore della proprieta' respCodiceFiscale associata alla
	 * colonna RESP_CODICE_FISCALE.
	 * @generated
	 */
	public void setRespCodiceFiscale(String val) {

		respCodiceFiscale = val;

	}

	/**
	 * Legge il valore della proprieta' respCodiceFiscale associata alla
	 * @generated
	 */
	public String getRespCodiceFiscale() {

		return respCodiceFiscale;

	}

	/**
	 * store della proprieta' associata alla colonna RESP_DENOMINAZIONE
	 * @generated
	 */
	protected String respDenominazione;

	/**
	 * Imposta il valore della proprieta' respDenominazione associata alla
	 * colonna RESP_DENOMINAZIONE.
	 * @generated
	 */
	public void setRespDenominazione(String val) {

		respDenominazione = val;

	}

	/**
	 * Legge il valore della proprieta' respDenominazione associata alla
	 * @generated
	 */
	public String getRespDenominazione() {

		return respDenominazione;

	}

	/**
	 * store della proprieta' associata alla colonna RESP_NOME
	 * @generated
	 */
	protected String respNome;

	/**
	 * Imposta il valore della proprieta' respNome associata alla
	 * colonna RESP_NOME.
	 * @generated
	 */
	public void setRespNome(String val) {

		respNome = val;

	}

	/**
	 * Legge il valore della proprieta' respNome associata alla
	 * @generated
	 */
	public String getRespNome() {

		return respNome;

	}

	/**
	 * store della proprieta' associata alla colonna TERZO_RESP_DENOMINAZIONE
	 * @generated
	 */
	protected String terzoRespDenominazione;

	/**
	 * Imposta il valore della proprieta' terzoRespDenominazione associata alla
	 * colonna TERZO_RESP_DENOMINAZIONE.
	 * @generated
	 */
	public void setTerzoRespDenominazione(String val) {

		terzoRespDenominazione = val;

	}

	/**
	 * Legge il valore della proprieta' terzoRespDenominazione associata alla
	 * @generated
	 */
	public String getTerzoRespDenominazione() {

		return terzoRespDenominazione;

	}

	/**
	 * store della proprieta' associata alla colonna TERZO_RESP_SIGLA_REA
	 * @generated
	 */
	protected String terzoRespSiglaRea;

	/**
	 * Imposta il valore della proprieta' terzoRespSiglaRea associata alla
	 * colonna TERZO_RESP_SIGLA_REA.
	 * @generated
	 */
	public void setTerzoRespSiglaRea(String val) {

		terzoRespSiglaRea = val;

	}

	/**
	 * Legge il valore della proprieta' terzoRespSiglaRea associata alla
	 * @generated
	 */
	public String getTerzoRespSiglaRea() {

		return terzoRespSiglaRea;

	}

	/**
	 * store della proprieta' associata alla colonna TERZO_RESP_NUMERO_REA
	 * @generated
	 */
	protected java.math.BigDecimal terzoRespNumeroRea;

	/**
	 * Imposta il valore della proprieta' terzoRespNumeroRea associata alla
	 * colonna TERZO_RESP_NUMERO_REA.
	 * @generated
	 */
	public void setTerzoRespNumeroRea(java.math.BigDecimal val) {

		terzoRespNumeroRea = val;

	}

	/**
	 * Legge il valore della proprieta' terzoRespNumeroRea associata alla
	 * @generated
	 */
	public java.math.BigDecimal getTerzoRespNumeroRea() {

		return terzoRespNumeroRea;

	}

	/**
	 * store della proprieta' associata alla colonna CODICE_FISCALE_3_RESP
	 * @generated
	 */
	protected String codiceFiscale3Resp;

	/**
	 * Imposta il valore della proprieta' codiceFiscale3Resp associata alla
	 * colonna CODICE_FISCALE_3_RESP.
	 * @generated
	 */
	public void setCodiceFiscale3Resp(String val) {

		codiceFiscale3Resp = val;

	}

	/**
	 * Legge il valore della proprieta' codiceFiscale3Resp associata alla
	 * @generated
	 */
	public String getCodiceFiscale3Resp() {

		return codiceFiscale3Resp;

	}

	/**
	 * store della proprieta' associata alla colonna DENOM_COMUNE_3_RESP
	 * @generated
	 */
	protected String denomComune3Resp;

	/**
	 * Imposta il valore della proprieta' denomComune3Resp associata alla
	 * colonna DENOM_COMUNE_3_RESP.
	 * @generated
	 */
	public void setDenomComune3Resp(String val) {

		denomComune3Resp = val;

	}

	/**
	 * Legge il valore della proprieta' denomComune3Resp associata alla
	 * @generated
	 */
	public String getDenomComune3Resp() {

		return denomComune3Resp;

	}

	/**
	 * store della proprieta' associata alla colonna SIGLA_PROV_3_RESP
	 * @generated
	 */
	protected String siglaProv3Resp;

	/**
	 * Imposta il valore della proprieta' siglaProv3Resp associata alla
	 * colonna SIGLA_PROV_3_RESP.
	 * @generated
	 */
	public void setSiglaProv3Resp(String val) {

		siglaProv3Resp = val;

	}

	/**
	 * Legge il valore della proprieta' siglaProv3Resp associata alla
	 * @generated
	 */
	public String getSiglaProv3Resp() {

		return siglaProv3Resp;

	}

	/**
	 * store della proprieta' associata alla colonna DENOM_PROVINCIA_3_RESP
	 * @generated
	 */
	protected String denomProvincia3Resp;

	/**
	 * Imposta il valore della proprieta' denomProvincia3Resp associata alla
	 * colonna DENOM_PROVINCIA_3_RESP.
	 * @generated
	 */
	public void setDenomProvincia3Resp(String val) {

		denomProvincia3Resp = val;

	}

	/**
	 * Legge il valore della proprieta' denomProvincia3Resp associata alla
	 * @generated
	 */
	public String getDenomProvincia3Resp() {

		return denomProvincia3Resp;

	}

	/**
	 * store della proprieta' associata alla colonna DENOM_COMUNE_IMPIANTO
	 * @generated
	 */
	protected String denomComuneImpianto;

	/**
	 * Imposta il valore della proprieta' denomComuneImpianto associata alla
	 * colonna DENOM_COMUNE_IMPIANTO.
	 * @generated
	 */
	public void setDenomComuneImpianto(String val) {

		denomComuneImpianto = val;

	}

	/**
	 * Legge il valore della proprieta' denomComuneImpianto associata alla
	 * @generated
	 */
	public String getDenomComuneImpianto() {

		return denomComuneImpianto;

	}

	/**
	 * store della proprieta' associata alla colonna DENOM_PROV_IMPIANTO
	 * @generated
	 */
	protected String denomProvImpianto;

	/**
	 * Imposta il valore della proprieta' denomProvImpianto associata alla
	 * colonna DENOM_PROV_IMPIANTO.
	 * @generated
	 */
	public void setDenomProvImpianto(String val) {

		denomProvImpianto = val;

	}

	/**
	 * Legge il valore della proprieta' denomProvImpianto associata alla
	 * @generated
	 */
	public String getDenomProvImpianto() {

		return denomProvImpianto;

	}

	/**
	 * store della proprieta' associata alla colonna SIGLA_PROV_IMPIANTO
	 * @generated
	 */
	protected String siglaProvImpianto;

	/**
	 * Imposta il valore della proprieta' siglaProvImpianto associata alla
	 * colonna SIGLA_PROV_IMPIANTO.
	 * @generated
	 */
	public void setSiglaProvImpianto(String val) {

		siglaProvImpianto = val;

	}

	/**
	 * Legge il valore della proprieta' siglaProvImpianto associata alla
	 * @generated
	 */
	public String getSiglaProvImpianto() {

		return siglaProvImpianto;

	}

}
