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
 * Classe utilizzata dal framework di QBE (Query By Example).
 * Rappresenta l'esempio corrispondente al DTO [SigitTTransazioneBollDto].
 * Contiene:
 * - una property di tipo FieldCheck per ogni property del DTO: 
 *   deve essere valorizzata per definire il constraint che l'esempio
 *   pone relativamente a quella property (es. range tra 1 e 100).
 * Combinando opportunamente i check e gli esempi (positivi e negativi)
 * e' possibile costruire query complesse
 * @generated
 */
public class SigitTTransazioneBollExample extends AbstractExample {

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk idTransazioneBoll;

	/**
	 * @generated
	 */
	public void setIdTransazioneBoll(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		idTransazioneBoll = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getIdTransazioneBoll() {
		return idTransazioneBoll;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk idStatoTransazione;

	/**
	 * @generated
	 */
	public void setIdStatoTransazione(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		idStatoTransazione = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getIdStatoTransazione() {
		return idStatoTransazione;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk fkTipoPagamento;

	/**
	 * @generated
	 */
	public void setFkTipoPagamento(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		fkTipoPagamento = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFkTipoPagamento() {
		return fkTipoPagamento;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk cfUtente;

	/**
	 * @generated
	 */
	public void setCfUtente(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		cfUtente = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getCfUtente() {
		return cfUtente;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk dataTransazione;

	/**
	 * @generated
	 */
	public void setDataTransazione(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		dataTransazione = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getDataTransazione() {
		return dataTransazione;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk siglaBollino;

	/**
	 * @generated
	 */
	public void setSiglaBollino(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		siglaBollino = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getSiglaBollino() {
		return siglaBollino;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk bollinoDa;

	/**
	 * @generated
	 */
	public void setBollinoDa(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		bollinoDa = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getBollinoDa() {
		return bollinoDa;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk bollinoA;

	/**
	 * @generated
	 */
	public void setBollinoA(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		bollinoA = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getBollinoA() {
		return bollinoA;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk fkPersonaGiuridica;

	/**
	 * @generated
	 */
	public void setFkPersonaGiuridica(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		fkPersonaGiuridica = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFkPersonaGiuridica() {
		return fkPersonaGiuridica;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk dataUltMod;

	/**
	 * @generated
	 */
	public void setDataUltMod(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		dataUltMod = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getDataUltMod() {
		return dataUltMod;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk utenteUltMod;

	/**
	 * @generated
	 */
	public void setUtenteUltMod(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		utenteUltMod = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getUtenteUltMod() {
		return utenteUltMod;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk numTransazione;

	/**
	 * @generated
	 */
	public void setNumTransazione(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		numTransazione = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getNumTransazione() {
		return numTransazione;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk note;

	/**
	 * @generated
	 */
	public void setNote(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		note = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getNote() {
		return note;
	}

}
