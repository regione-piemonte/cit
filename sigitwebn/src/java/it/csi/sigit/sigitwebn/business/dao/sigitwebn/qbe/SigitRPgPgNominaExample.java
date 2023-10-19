package it.csi.sigit.sigitwebn.business.dao.sigitwebn.qbe;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.qbe.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Classe utilizzata dal framework di QBE (Query By Example).
 * Rappresenta l'esempio corrispondente al DTO [SigitRPgPgNominaDto].
 * Contiene:
 * - una property di tipo FieldCheck per ogni property del DTO: 
 *   deve essere valorizzata per definire il constraint che l'esempio
 *   pone relativamente a quella property (es. range tra 1 e 100).
 * Combinando opportunamente i check e gli esempi (positivi e negativi)
 * e' possibile costruire query complesse
 * @generated
 */
public class SigitRPgPgNominaExample extends AbstractExample {

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk idPersonaGiuridicaCat;

	/**
	 * @generated
	 */
	public void setIdPersonaGiuridicaCat(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		idPersonaGiuridicaCat = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getIdPersonaGiuridicaCat() {
		return idPersonaGiuridicaCat;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk idPersonaGiuridicaImpresa;

	/**
	 * @generated
	 */
	public void setIdPersonaGiuridicaImpresa(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		idPersonaGiuridicaImpresa = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getIdPersonaGiuridicaImpresa() {
		return idPersonaGiuridicaImpresa;
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
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk dataUltimaModifica;

	/**
	 * @generated
	 */
	public void setDataUltimaModifica(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		dataUltimaModifica = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getDataUltimaModifica() {
		return dataUltimaModifica;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk utenteUltimaModifica;

	/**
	 * @generated
	 */
	public void setUtenteUltimaModifica(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		utenteUltimaModifica = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getUtenteUltimaModifica() {
		return utenteUltimaModifica;
	}

}
