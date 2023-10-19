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
public class SigitTCompBrBcExample extends AbstractExample {

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk _idCompBrRc;

	/**
	 * @generated
	 */
	public void setIdCompBrRc(
			it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		_idCompBrRc = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getIdCompBrRc() {
		return _idCompBrRc;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk _tipologiaBrRc;

	/**
	 * @generated
	 */
	public void setTipologiaBrRc(
			it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		_tipologiaBrRc = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getTipologiaBrRc() {
		return _tipologiaBrRc;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk _progressivoBrRc;

	/**
	 * @generated
	 */
	public void setProgressivoBrRc(
			it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		_progressivoBrRc = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getProgressivoBrRc() {
		return _progressivoBrRc;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk _fkTipoComponente;

	/**
	 * @generated
	 */
	public void setFkTipoComponente(
			it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		_fkTipoComponente = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFkTipoComponente() {
		return _fkTipoComponente;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk _fkProgressivo;

	/**
	 * @generated
	 */
	public void setFkProgressivo(
			it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		_fkProgressivo = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFkProgressivo() {
		return _fkProgressivo;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk _fkDataInstall;

	/**
	 * @generated
	 */
	public void setFkDataInstall(
			it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		_fkDataInstall = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFkDataInstall() {
		return _fkDataInstall;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk _tipologia;

	/**
	 * @generated
	 */
	public void setTipologia(
			it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		_tipologia = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getTipologia() {
		return _tipologia;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk _potTermMaxKw;

	/**
	 * @generated
	 */
	public void setPotTermMaxKw(
			it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		_potTermMaxKw = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getPotTermMaxKw() {
		return _potTermMaxKw;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk _potTermMinKw;

	/**
	 * @generated
	 */
	public void setPotTermMinKw(
			it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		_potTermMinKw = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getPotTermMinKw() {
		return _potTermMinKw;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk _codiceImpianto;

	/**
	 * @generated
	 */
	public void setCodiceImpianto(
			it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		_codiceImpianto = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getCodiceImpianto() {
		return _codiceImpianto;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk _dataInstall;

	/**
	 * @generated
	 */
	public void setDataInstall(
			it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		_dataInstall = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getDataInstall() {
		return _dataInstall;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk _dataDismiss;

	/**
	 * @generated
	 */
	public void setDataDismiss(
			it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		_dataDismiss = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getDataDismiss() {
		return _dataDismiss;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk _fkMarca;

	/**
	 * @generated
	 */
	public void setFkMarca(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		_fkMarca = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFkMarca() {
		return _fkMarca;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk _modello;

	/**
	 * @generated
	 */
	public void setModello(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		_modello = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getModello() {
		return _modello;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk _matricola;

	/**
	 * @generated
	 */
	public void setMatricola(
			it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		_matricola = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getMatricola() {
		return _matricola;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk _fkCombustibile;

	/**
	 * @generated
	 */
	public void setFkCombustibile(
			it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		_fkCombustibile = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFkCombustibile() {
		return _fkCombustibile;
	}

}
