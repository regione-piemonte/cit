package it.csi.sigit.sigitweba.business.dao.sigitweba.qbe;

import it.csi.sigit.sigitweba.business.dao.sigitweba.dao.*;
import it.csi.sigit.sigitweba.business.dao.sigitweba.dto.*;
import it.csi.sigit.sigitweba.business.dao.qbe.*;
import it.csi.sigit.sigitweba.business.dao.sigitweba.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Classe utilizzata dal framework di QBE (Query By Example).
 * Rappresenta l'esempio corrispondente al DTO [SigitRPfPgDelegaDto].
 * Contiene:
 * - una property di tipo FieldCheck per ogni property del DTO: 
 *   deve essere valorizzata per definire il constraint che l'esempio
 *   pone relativamente a quella property (es. range tra 1 e 100).
 * Combinando opportunamente i check e gli esempi (positivi e negativi)
 * e' possibile costruire query complesse
 * @generated
 */
public class SigitRPfPgDelegaExample extends AbstractExample {

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitweba.business.dao.qbe.FieldChk idPersonaFisica;

	/**
	 * @generated
	 */
	public void setIdPersonaFisica(it.csi.sigit.sigitweba.business.dao.qbe.FieldChk chk) {
		idPersonaFisica = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitweba.business.dao.qbe.FieldChk getIdPersonaFisica() {
		return idPersonaFisica;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitweba.business.dao.qbe.FieldChk idPersonaGiuridica;

	/**
	 * @generated
	 */
	public void setIdPersonaGiuridica(it.csi.sigit.sigitweba.business.dao.qbe.FieldChk chk) {
		idPersonaGiuridica = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitweba.business.dao.qbe.FieldChk getIdPersonaGiuridica() {
		return idPersonaGiuridica;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitweba.business.dao.qbe.FieldChk dataInizio;

	/**
	 * @generated
	 */
	public void setDataInizio(it.csi.sigit.sigitweba.business.dao.qbe.FieldChk chk) {
		dataInizio = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitweba.business.dao.qbe.FieldChk getDataInizio() {
		return dataInizio;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitweba.business.dao.qbe.FieldChk fkRuoloAccred;

	/**
	 * @generated
	 */
	public void setFkRuoloAccred(it.csi.sigit.sigitweba.business.dao.qbe.FieldChk chk) {
		fkRuoloAccred = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitweba.business.dao.qbe.FieldChk getFkRuoloAccred() {
		return fkRuoloAccred;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitweba.business.dao.qbe.FieldChk fkTipoDm;

	/**
	 * @generated
	 */
	public void setFkTipoDm(it.csi.sigit.sigitweba.business.dao.qbe.FieldChk chk) {
		fkTipoDm = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitweba.business.dao.qbe.FieldChk getFkTipoDm() {
		return fkTipoDm;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitweba.business.dao.qbe.FieldChk flgDelega;

	/**
	 * @generated
	 */
	public void setFlgDelega(it.csi.sigit.sigitweba.business.dao.qbe.FieldChk chk) {
		flgDelega = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitweba.business.dao.qbe.FieldChk getFlgDelega() {
		return flgDelega;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitweba.business.dao.qbe.FieldChk dataFine;

	/**
	 * @generated
	 */
	public void setDataFine(it.csi.sigit.sigitweba.business.dao.qbe.FieldChk chk) {
		dataFine = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitweba.business.dao.qbe.FieldChk getDataFine() {
		return dataFine;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitweba.business.dao.qbe.FieldChk dataUltMod;

	/**
	 * @generated
	 */
	public void setDataUltMod(it.csi.sigit.sigitweba.business.dao.qbe.FieldChk chk) {
		dataUltMod = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitweba.business.dao.qbe.FieldChk getDataUltMod() {
		return dataUltMod;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitweba.business.dao.qbe.FieldChk utenteUltMod;

	/**
	 * @generated
	 */
	public void setUtenteUltMod(it.csi.sigit.sigitweba.business.dao.qbe.FieldChk chk) {
		utenteUltMod = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitweba.business.dao.qbe.FieldChk getUtenteUltMod() {
		return utenteUltMod;
	}

}
