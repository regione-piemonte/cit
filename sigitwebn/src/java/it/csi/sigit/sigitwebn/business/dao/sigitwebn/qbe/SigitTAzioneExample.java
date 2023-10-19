package it.csi.sigit.sigitwebn.business.dao.sigitwebn.qbe;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.qbe.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Classe utilizzata dal framework di QBE (Query By Example).
 * Rappresenta l'esempio corrispondente al DTO [SigitTAzioneDto].
 * Contiene:
 * - una property di tipo FieldCheck per ogni property del DTO: 
 *   deve essere valorizzata per definire il constraint che l'esempio
 *   pone relativamente a quella property (es. range tra 1 e 100).
 * Combinando opportunamente i check e gli esempi (positivi e negativi)
 * e' possibile costruire query complesse
 * @generated
 */
public class SigitTAzioneExample extends AbstractExample {

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk idAzione;

	/**
	 * @generated
	 */
	public void setIdAzione(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		idAzione = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getIdAzione() {
		return idAzione;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk dtAzione;

	/**
	 * @generated
	 */
	public void setDtAzione(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		dtAzione = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getDtAzione() {
		return dtAzione;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk fkTipoAzione;

	/**
	 * @generated
	 */
	public void setFkTipoAzione(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		fkTipoAzione = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFkTipoAzione() {
		return fkTipoAzione;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk fkVerifica;

	/**
	 * @generated
	 */
	public void setFkVerifica(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		fkVerifica = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFkVerifica() {
		return fkVerifica;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk fkAccertamento;

	/**
	 * @generated
	 */
	public void setFkAccertamento(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		fkAccertamento = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFkAccertamento() {
		return fkAccertamento;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk fkIspezione2018;

	/**
	 * @generated
	 */
	public void setFkIspezione2018(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		fkIspezione2018 = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFkIspezione2018() {
		return fkIspezione2018;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk fkSanzione;

	/**
	 * @generated
	 */
	public void setFkSanzione(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		fkSanzione = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFkSanzione() {
		return fkSanzione;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk descrizioneAzione;

	/**
	 * @generated
	 */
	public void setDescrizioneAzione(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		descrizioneAzione = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getDescrizioneAzione() {
		return descrizioneAzione;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk cfUtenteAzione;

	/**
	 * @generated
	 */
	public void setCfUtenteAzione(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		cfUtenteAzione = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getCfUtenteAzione() {
		return cfUtenteAzione;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk denomUtenteAzione;

	/**
	 * @generated
	 */
	public void setDenomUtenteAzione(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		denomUtenteAzione = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getDenomUtenteAzione() {
		return denomUtenteAzione;
	}

}
