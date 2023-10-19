package it.csi.sigit.sigitwebn.business.dao.sigitwebn.qbe;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.qbe.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Classe utilizzata dal framework di QBE (Query By Example).
 * Rappresenta l'esempio corrispondente al DTO [SigitRPfRuoloPaDto].
 * Contiene:
 * - una property di tipo FieldCheck per ogni property del DTO: 
 *   deve essere valorizzata per definire il constraint che l'esempio
 *   pone relativamente a quella property (es. range tra 1 e 100).
 * Combinando opportunamente i check e gli esempi (positivi e negativi)
 * e' possibile costruire query complesse
 * @generated
 */
public class SigitRPfRuoloPaExample extends AbstractExample {

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk idPersonaFisica;

	/**
	 * @generated
	 */
	public void setIdPersonaFisica(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		idPersonaFisica = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getIdPersonaFisica() {
		return idPersonaFisica;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk idRuoloPa;

	/**
	 * @generated
	 */
	public void setIdRuoloPa(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		idRuoloPa = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getIdRuoloPa() {
		return idRuoloPa;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk istatAbilitazione;

	/**
	 * @generated
	 */
	public void setIstatAbilitazione(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		istatAbilitazione = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getIstatAbilitazione() {
		return istatAbilitazione;
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

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk descAbilitazione;

	/**
	 * @generated
	 */
	public void setDescAbilitazione(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		descAbilitazione = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getDescAbilitazione() {
		return descAbilitazione;
	}

}
