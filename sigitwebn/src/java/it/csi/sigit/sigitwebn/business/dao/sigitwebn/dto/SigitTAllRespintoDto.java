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
 * Data transfer object relativo al DAO SigitTAllRespintoDao.
 * @generated
 */
public class SigitTAllRespintoDto implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna DATA_CONTROLLO
	 * @generated
	 */
	private java.sql.Date _dataControllo;

	/**
	 * Imposta il valore della proprieta' dataControllo associata alla
	 * colonna DATA_CONTROLLO.
	 * @generated
	 */
	public void setDataControllo(java.sql.Date val) {
		_dataControllo = val;
	}

	/**
	 * Legge il valore della proprieta' dataControllo associata alla
	 * @generated
	 */
	public java.sql.Date getDataControllo() {
		return _dataControllo;
	}

	/**
	 * store della proprieta' associata alla colonna ID_IMP_RUOLO_PFPG
	 * @generated
	 */
	private java.math.BigDecimal _idImpRuoloPfpg;

	/**
	 * Imposta il valore della proprieta' idImpRuoloPfpg associata alla
	 * colonna ID_IMP_RUOLO_PFPG.
	 * @generated
	 */
	public void setIdImpRuoloPfpg(java.math.BigDecimal val) {
		_idImpRuoloPfpg = val;
	}

	/**
	 * Legge il valore della proprieta' idImpRuoloPfpg associata alla
	 * @generated
	 */
	public java.math.BigDecimal getIdImpRuoloPfpg() {
		return _idImpRuoloPfpg;
	}

	/**
	 * store della proprieta' associata alla colonna FK_TIPO_DOCUMENTO
	 * @generated
	 */
	private java.math.BigDecimal _fkTipoDocumento;

	/**
	 * Imposta il valore della proprieta' fkTipoDocumento associata alla
	 * colonna FK_TIPO_DOCUMENTO.
	 * @generated
	 */
	public void setFkTipoDocumento(java.math.BigDecimal val) {
		_fkTipoDocumento = val;
	}

	/**
	 * Legge il valore della proprieta' fkTipoDocumento associata alla
	 * @generated
	 */
	public java.math.BigDecimal getFkTipoDocumento() {
		return _fkTipoDocumento;
	}

	/**
	 * store della proprieta' associata alla colonna SIGLA_BOLLINO
	 * @generated
	 */
	private String _siglaBollino;

	/**
	 * Imposta il valore della proprieta' siglaBollino associata alla
	 * colonna SIGLA_BOLLINO.
	 * @generated
	 */
	public void setSiglaBollino(String val) {
		_siglaBollino = val;
	}

	/**
	 * Legge il valore della proprieta' siglaBollino associata alla
	 * @generated
	 */
	public String getSiglaBollino() {
		return _siglaBollino;
	}

	/**
	 * store della proprieta' associata alla colonna NUMERO_BOLLINO
	 * @generated
	 */
	private java.math.BigDecimal _numeroBollino;

	/**
	 * Imposta il valore della proprieta' numeroBollino associata alla
	 * colonna NUMERO_BOLLINO.
	 * @generated
	 */
	public void setNumeroBollino(java.math.BigDecimal val) {
		_numeroBollino = val;
	}

	/**
	 * Legge il valore della proprieta' numeroBollino associata alla
	 * @generated
	 */
	public java.math.BigDecimal getNumeroBollino() {
		return _numeroBollino;
	}

	/**
	 * store della proprieta' associata alla colonna NOME_ALLEGATO
	 * @generated
	 */
	private String _nomeAllegato;

	/**
	 * Imposta il valore della proprieta' nomeAllegato associata alla
	 * colonna NOME_ALLEGATO.
	 * @generated
	 */
	public void setNomeAllegato(String val) {
		_nomeAllegato = val;
	}

	/**
	 * Legge il valore della proprieta' nomeAllegato associata alla
	 * @generated
	 */
	public String getNomeAllegato() {
		return _nomeAllegato;
	}

	/**
	 * store della proprieta' associata alla colonna DATA_ULT_MOD
	 * @generated
	 */
	private java.sql.Timestamp _dataUltMod;

	/**
	 * Imposta il valore della proprieta' dataUltMod associata alla
	 * colonna DATA_ULT_MOD.
	 * @generated
	 */
	public void setDataUltMod(java.sql.Timestamp val) {
		_dataUltMod = val;
	}

	/**
	 * Legge il valore della proprieta' dataUltMod associata alla
	 * @generated
	 */
	public java.sql.Timestamp getDataUltMod() {
		return _dataUltMod;
	}

	/**
	 * store della proprieta' associata alla colonna UTENTE_ULT_MOD
	 * @generated
	 */
	private String _utenteUltMod;

	/**
	 * Imposta il valore della proprieta' utenteUltMod associata alla
	 * colonna UTENTE_ULT_MOD.
	 * @generated
	 */
	public void setUtenteUltMod(String val) {
		_utenteUltMod = val;
	}

	/**
	 * Legge il valore della proprieta' utenteUltMod associata alla
	 * @generated
	 */
	public String getUtenteUltMod() {
		return _utenteUltMod;
	}

	/**
	 * store della proprieta' associata alla colonna DATA_RESPINTA
	 * @generated
	 */
	private java.sql.Date _dataRespinta;

	/**
	 * Imposta il valore della proprieta' dataRespinta associata alla
	 * colonna DATA_RESPINTA.
	 * @generated
	 */
	public void setDataRespinta(java.sql.Date val) {
		_dataRespinta = val;
	}

	/**
	 * Legge il valore della proprieta' dataRespinta associata alla
	 * @generated
	 */
	public java.sql.Date getDataRespinta() {
		return _dataRespinta;
	}

	/**
	 * store della proprieta' associata alla colonna DATA_INVIO
	 * @generated
	 */
	private java.sql.Date _dataInvio;

	/**
	 * Imposta il valore della proprieta' dataInvio associata alla
	 * colonna DATA_INVIO.
	 * @generated
	 */
	public void setDataInvio(java.sql.Date val) {
		_dataInvio = val;
	}

	/**
	 * Legge il valore della proprieta' dataInvio associata alla
	 * @generated
	 */
	public java.sql.Date getDataInvio() {
		return _dataInvio;
	}

	/**
	 * store della proprieta' associata alla colonna F_OSSERVAZIONI
	 * @generated
	 */
	private String _fOsservazioni;

	/**
	 * Imposta il valore della proprieta' fOsservazioni associata alla
	 * colonna F_OSSERVAZIONI.
	 * @generated
	 */
	public void setFOsservazioni(String val) {
		_fOsservazioni = val;
	}

	/**
	 * Legge il valore della proprieta' fOsservazioni associata alla
	 * @generated
	 */
	public String getFOsservazioni() {
		return _fOsservazioni;
	}

	/**
	 * store della proprieta' associata alla colonna F_RACCOMANDAZIONI
	 * @generated
	 */
	private String _fRaccomandazioni;

	/**
	 * Imposta il valore della proprieta' fRaccomandazioni associata alla
	 * colonna F_RACCOMANDAZIONI.
	 * @generated
	 */
	public void setFRaccomandazioni(String val) {
		_fRaccomandazioni = val;
	}

	/**
	 * Legge il valore della proprieta' fRaccomandazioni associata alla
	 * @generated
	 */
	public String getFRaccomandazioni() {
		return _fRaccomandazioni;
	}

	/**
	 * store della proprieta' associata alla colonna F_PRESCRIZIONI
	 * @generated
	 */
	private String _fPrescrizioni;

	/**
	 * Imposta il valore della proprieta' fPrescrizioni associata alla
	 * colonna F_PRESCRIZIONI.
	 * @generated
	 */
	public void setFPrescrizioni(String val) {
		_fPrescrizioni = val;
	}

	/**
	 * Legge il valore della proprieta' fPrescrizioni associata alla
	 * @generated
	 */
	public String getFPrescrizioni() {
		return _fPrescrizioni;
	}

	/**
	 * store della proprieta' associata alla colonna F_INTERVENTO_ENTRO
	 * @generated
	 */
	private java.sql.Date _fInterventoEntro;

	/**
	 * Imposta il valore della proprieta' fInterventoEntro associata alla
	 * colonna F_INTERVENTO_ENTRO.
	 * @generated
	 */
	public void setFInterventoEntro(java.sql.Date val) {
		_fInterventoEntro = val;
	}

	/**
	 * Legge il valore della proprieta' fInterventoEntro associata alla
	 * @generated
	 */
	public java.sql.Date getFInterventoEntro() {
		return _fInterventoEntro;
	}

	/**
	 * store della proprieta' associata alla colonna ID_ALLEGATO
	 * @generated
	 */
	private java.math.BigDecimal _idAllegato;

	/**
	 * Imposta il valore della proprieta' idAllegato associata alla
	 * colonna ID_ALLEGATO.
	 * @generated
	 */
	public void setIdAllegato(java.math.BigDecimal val) {
		_idAllegato = val;
	}

	/**
	 * Legge il valore della proprieta' idAllegato associata alla
	 * @generated
	 */
	public java.math.BigDecimal getIdAllegato() {
		return _idAllegato;
	}

	/**
	 * store della proprieta' associata alla colonna UID_INDEX
	 * @generated
	 */
	private String _uidIndex;

	/**
	 * Imposta il valore della proprieta' uidIndex associata alla
	 * colonna UID_INDEX.
	 * @generated
	 */
	public void setUidIndex(String val) {
		_uidIndex = val;
	}

	/**
	 * Legge il valore della proprieta' uidIndex associata alla
	 * @generated
	 */
	public String getUidIndex() {
		return _uidIndex;
	}

	/**
	 * Crea una istanza di SigitTAllRespintoPk a partire dal valore dei campi chiave del DTO
	 * 
	 * @return SigitTAllRespintoPk
	 * @generated
	 */
	public SigitTAllRespintoPk createPk() {
		return new SigitTAllRespintoPk(_dataControllo, _idImpRuoloPfpg,
				_idAllegato);
	}

}
