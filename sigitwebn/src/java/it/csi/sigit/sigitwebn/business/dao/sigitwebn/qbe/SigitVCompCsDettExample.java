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
public class SigitVCompCsDettExample extends AbstractExample {

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
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk _idTipoComponente;

	/**
	 * @generated
	 */
	public void setIdTipoComponente(
			it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		_idTipoComponente = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getIdTipoComponente() {
		return _idTipoComponente;
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
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk _progressivo;

	/**
	 * @generated
	 */
	public void setProgressivo(
			it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		_progressivo = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getProgressivo() {
		return _progressivo;
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
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk _potenzaTermicaKw;

	/**
	 * @generated
	 */
	public void setPotenzaTermicaKw(
			it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		_potenzaTermicaKw = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getPotenzaTermicaKw() {
		return _potenzaTermicaKw;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk _idDettTipo3;

	/**
	 * @generated
	 */
	public void setIdDettTipo3(
			it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		_idDettTipo3 = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getIdDettTipo3() {
		return _idDettTipo3;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk _fkAllegato;

	/**
	 * @generated
	 */
	public void setFkAllegato(
			it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		_fkAllegato = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFkAllegato() {
		return _fkAllegato;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk _fkFluido;

	/**
	 * @generated
	 */
	public void setFkFluido(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		_fkFluido = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFkFluido() {
		return _fkFluido;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk _fkFluidoAlimentaz;

	/**
	 * @generated
	 */
	public void setFkFluidoAlimentaz(
			it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		_fkFluidoAlimentaz = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFkFluidoAlimentaz() {
		return _fkFluidoAlimentaz;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk _eFluidoAltro;

	/**
	 * @generated
	 */
	public void setEFluidoAltro(
			it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		_eFluidoAltro = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getEFluidoAltro() {
		return _eFluidoAltro;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk _eAlimentazioneAltro;

	/**
	 * @generated
	 */
	public void setEAlimentazioneAltro(
			it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		_eAlimentazioneAltro = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getEAlimentazioneAltro() {
		return _eAlimentazioneAltro;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk _eFlgClimaInverno;

	/**
	 * @generated
	 */
	public void setEFlgClimaInverno(
			it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		_eFlgClimaInverno = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getEFlgClimaInverno() {
		return _eFlgClimaInverno;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk _eFlgProduzAcs;

	/**
	 * @generated
	 */
	public void setEFlgProduzAcs(
			it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		_eFlgProduzAcs = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getEFlgProduzAcs() {
		return _eFlgProduzAcs;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk _eFlgPotenzaCompatibile;

	/**
	 * @generated
	 */
	public void setEFlgPotenzaCompatibile(
			it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		_eFlgPotenzaCompatibile = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getEFlgPotenzaCompatibile() {
		return _eFlgPotenzaCompatibile;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk _eFlgCoibIdonea;

	/**
	 * @generated
	 */
	public void setEFlgCoibIdonea(
			it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		_eFlgCoibIdonea = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getEFlgCoibIdonea() {
		return _eFlgCoibIdonea;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk _eFlgDispFunzionanti;

	/**
	 * @generated
	 */
	public void setEFlgDispFunzionanti(
			it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		_eFlgDispFunzionanti = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getEFlgDispFunzionanti() {
		return _eFlgDispFunzionanti;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk _eTempExtC;

	/**
	 * @generated
	 */
	public void setETempExtC(
			it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		_eTempExtC = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getETempExtC() {
		return _eTempExtC;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk _eTempMandPrimarioC;

	/**
	 * @generated
	 */
	public void setETempMandPrimarioC(
			it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		_eTempMandPrimarioC = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getETempMandPrimarioC() {
		return _eTempMandPrimarioC;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk _eTempRitorPrimarioC;

	/**
	 * @generated
	 */
	public void setETempRitorPrimarioC(
			it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		_eTempRitorPrimarioC = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getETempRitorPrimarioC() {
		return _eTempRitorPrimarioC;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk _eTempMandSecondarioC;

	/**
	 * @generated
	 */
	public void setETempMandSecondarioC(
			it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		_eTempMandSecondarioC = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getETempMandSecondarioC() {
		return _eTempMandSecondarioC;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk _eTempRitSecondarioC;

	/**
	 * @generated
	 */
	public void setETempRitSecondarioC(
			it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		_eTempRitSecondarioC = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getETempRitSecondarioC() {
		return _eTempRitSecondarioC;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk _ePotenzaTermKw;

	/**
	 * @generated
	 */
	public void setEPotenzaTermKw(
			it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		_ePotenzaTermKw = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getEPotenzaTermKw() {
		return _ePotenzaTermKw;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk _ePortFluidoM3H;

	/**
	 * @generated
	 */
	public void setEPortFluidoM3H(
			it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		_ePortFluidoM3H = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getEPortFluidoM3H() {
		return _ePortFluidoM3H;
	}

}
