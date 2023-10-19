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
 * Rappresenta l'esempio corrispondente al DTO [SigitRTransAcqBollQtaDto].
 * Contiene:
 * - una property di tipo FieldCheck per ogni property del DTO: 
 *   deve essere valorizzata per definire il constraint che l'esempio
 *   pone relativamente a quella property (es. range tra 1 e 100).
 * Combinando opportunamente i check e gli esempi (positivi e negativi)
 * e' possibile costruire query complesse
 * @generated
 */
public class SigitRTransAcqBollQtaExample extends AbstractExample {

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
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk idPotenza;

	/**
	 * @generated
	 */
	public void setIdPotenza(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		idPotenza = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getIdPotenza() {
		return idPotenza;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk idPrezzo;

	/**
	 * @generated
	 */
	public void setIdPrezzo(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		idPrezzo = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getIdPrezzo() {
		return idPrezzo;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk dtInizioAcquisto;

	/**
	 * @generated
	 */
	public void setDtInizioAcquisto(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		dtInizioAcquisto = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getDtInizioAcquisto() {
		return dtInizioAcquisto;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk quantita;

	/**
	 * @generated
	 */
	public void setQuantita(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		quantita = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getQuantita() {
		return quantita;
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

}
