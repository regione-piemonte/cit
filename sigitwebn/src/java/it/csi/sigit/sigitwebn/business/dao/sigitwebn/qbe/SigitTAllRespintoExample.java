/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitwebn.business.dao.sigitwebn.qbe;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.qbe.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * @generated
 */
public class SigitTAllRespintoExample extends AbstractExample {

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk _dataControllo;

	/**
	 * @generated
	 */
	public void setDataControllo(
			it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		_dataControllo = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getDataControllo() {
		return _dataControllo;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk _idImpRuoloPfpg;

	/**
	 * @generated
	 */
	public void setIdImpRuoloPfpg(
			it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		_idImpRuoloPfpg = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getIdImpRuoloPfpg() {
		return _idImpRuoloPfpg;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk _fkTipoDocumento;

	/**
	 * @generated
	 */
	public void setFkTipoDocumento(
			it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		_fkTipoDocumento = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFkTipoDocumento() {
		return _fkTipoDocumento;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk _siglaBollino;

	/**
	 * @generated
	 */
	public void setSiglaBollino(
			it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		_siglaBollino = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getSiglaBollino() {
		return _siglaBollino;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk _numeroBollino;

	/**
	 * @generated
	 */
	public void setNumeroBollino(
			it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		_numeroBollino = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getNumeroBollino() {
		return _numeroBollino;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk _nomeAllegato;

	/**
	 * @generated
	 */
	public void setNomeAllegato(
			it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		_nomeAllegato = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getNomeAllegato() {
		return _nomeAllegato;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk _dataUltMod;

	/**
	 * @generated
	 */
	public void setDataUltMod(
			it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		_dataUltMod = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getDataUltMod() {
		return _dataUltMod;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk _utenteUltMod;

	/**
	 * @generated
	 */
	public void setUtenteUltMod(
			it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		_utenteUltMod = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getUtenteUltMod() {
		return _utenteUltMod;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk _dataRespinta;

	/**
	 * @generated
	 */
	public void setDataRespinta(
			it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		_dataRespinta = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getDataRespinta() {
		return _dataRespinta;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk _dataInvio;

	/**
	 * @generated
	 */
	public void setDataInvio(
			it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		_dataInvio = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getDataInvio() {
		return _dataInvio;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk _fOsservazioni;

	/**
	 * @generated
	 */
	public void setFOsservazioni(
			it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		_fOsservazioni = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFOsservazioni() {
		return _fOsservazioni;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk _fRaccomandazioni;

	/**
	 * @generated
	 */
	public void setFRaccomandazioni(
			it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		_fRaccomandazioni = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFRaccomandazioni() {
		return _fRaccomandazioni;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk _fPrescrizioni;

	/**
	 * @generated
	 */
	public void setFPrescrizioni(
			it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		_fPrescrizioni = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFPrescrizioni() {
		return _fPrescrizioni;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk _fInterventoEntro;

	/**
	 * @generated
	 */
	public void setFInterventoEntro(
			it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		_fInterventoEntro = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFInterventoEntro() {
		return _fInterventoEntro;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk _idAllegato;

	/**
	 * @generated
	 */
	public void setIdAllegato(
			it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		_idAllegato = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getIdAllegato() {
		return _idAllegato;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk _uidIndex;

	/**
	 * @generated
	 */
	public void setUidIndex(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		_uidIndex = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getUidIndex() {
		return _uidIndex;
	}

}
