package it.csi.sigit.sigitwebn.business.dao.sigitwebn.qbe;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.qbe.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Classe utilizzata dal framework di QBE (Query By Example).
 * Rappresenta l'esempio corrispondente al DTO [SigitRIspezIspetDto].
 * Contiene:
 * - una property di tipo FieldCheck per ogni property del DTO: 
 *   deve essere valorizzata per definire il constraint che l'esempio
 *   pone relativamente a quella property (es. range tra 1 e 100).
 * Combinando opportunamente i check e gli esempi (positivi e negativi)
 * e' possibile costruire query complesse
 * @generated
 */
public class SigitRIspezIspetExample extends AbstractExample {

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk idIspezIspet;

	/**
	 * @generated
	 */
	public void setIdIspezIspet(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		idIspezIspet = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getIdIspezIspet() {
		return idIspezIspet;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk fkRuolo;

	/**
	 * @generated
	 */
	public void setFkRuolo(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		fkRuolo = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFkRuolo() {
		return fkRuolo;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk dataInizio;

	/**
	 * @generated
	 */
	public void setDataInizio(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		dataInizio = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getDataInizio() {
		return dataInizio;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk dataFine;

	/**
	 * @generated
	 */
	public void setDataFine(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		dataFine = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getDataFine() {
		return dataFine;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk fkPersonaFisica;

	/**
	 * @generated
	 */
	public void setFkPersonaFisica(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		fkPersonaFisica = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFkPersonaFisica() {
		return fkPersonaFisica;
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
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk flgPrimoCaricatore;

	/**
	 * @generated
	 */
	public void setFlgPrimoCaricatore(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		flgPrimoCaricatore = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFlgPrimoCaricatore() {
		return flgPrimoCaricatore;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk idIspezione2018;

	/**
	 * @generated
	 */
	public void setIdIspezione2018(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		idIspezione2018 = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getIdIspezione2018() {
		return idIspezione2018;
	}

}
