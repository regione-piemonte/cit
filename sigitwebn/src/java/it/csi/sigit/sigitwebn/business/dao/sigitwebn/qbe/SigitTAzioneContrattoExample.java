package it.csi.sigit.sigitwebn.business.dao.sigitwebn.qbe;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.qbe.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Classe utilizzata dal framework di QBE (Query By Example).
 * Rappresenta l'esempio corrispondente al DTO [SigitTAzioneContrattoDto].
 * Contiene:
 * - una property di tipo FieldCheck per ogni property del DTO: 
 *   deve essere valorizzata per definire il constraint che l'esempio
 *   pone relativamente a quella property (es. range tra 1 e 100).
 * Combinando opportunamente i check e gli esempi (positivi e negativi)
 * e' possibile costruire query complesse
 * @generated
 */
public class SigitTAzioneContrattoExample extends AbstractExample {

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk idContratto;

	/**
	 * @generated
	 */
	public void setIdContratto(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		idContratto = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getIdContratto() {
		return idContratto;
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
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk oldDataFine;

	/**
	 * @generated
	 */
	public void setOldDataFine(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		oldDataFine = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getOldDataFine() {
		return oldDataFine;
	}

}
