package it.csi.sigit.sigitwebn.business.dao.sigitwebn.qbe;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.qbe.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Classe utilizzata dal framework di QBE (Query By Example).
 * Rappresenta l'esempio corrispondente al DTO [SigitVPotenzaPrezzoDto].
 * Contiene:
 * - una property di tipo FieldCheck per ogni property del DTO: 
 *   deve essere valorizzata per definire il constraint che l'esempio
 *   pone relativamente a quella property (es. range tra 1 e 100).
 * Combinando opportunamente i check e gli esempi (positivi e negativi)
 * e' possibile costruire query complesse
 * @generated
 */
public class SigitVPotenzaPrezzoExample extends AbstractExample {

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
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk desPotenza;

	/**
	 * @generated
	 */
	public void setDesPotenza(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		desPotenza = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getDesPotenza() {
		return desPotenza;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk limiteInferiore;

	/**
	 * @generated
	 */
	public void setLimiteInferiore(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		limiteInferiore = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getLimiteInferiore() {
		return limiteInferiore;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk limiteSuperiore;

	/**
	 * @generated
	 */
	public void setLimiteSuperiore(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		limiteSuperiore = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getLimiteSuperiore() {
		return limiteSuperiore;
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
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk prezzo;

	/**
	 * @generated
	 */
	public void setPrezzo(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		prezzo = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getPrezzo() {
		return prezzo;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk dtInizio;

	/**
	 * @generated
	 */
	public void setDtInizio(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		dtInizio = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getDtInizio() {
		return dtInizio;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk dtFine;

	/**
	 * @generated
	 */
	public void setDtFine(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		dtFine = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getDtFine() {
		return dtFine;
	}

}
