package it.csi.sigit.sigitwebn.business.dao.sigitwebn.qbe;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.qbe.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Classe utilizzata dal framework di QBE (Query By Example).
 * Rappresenta l'esempio corrispondente al DTO [SigitTmpLibrettoDto].
 * Contiene:
 * - una property di tipo FieldCheck per ogni property del DTO: 
 *   deve essere valorizzata per definire il constraint che l'esempio
 *   pone relativamente a quella property (es. range tra 1 e 100).
 * Combinando opportunamente i check e gli esempi (positivi e negativi)
 * e' possibile costruire query complesse
 * @generated
 */
public class SigitTmpLibrettoExample extends AbstractExample {

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk idLibretto;

	/**
	 * @generated
	 */
	public void setIdLibretto(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		idLibretto = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getIdLibretto() {
		return idLibretto;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk flgElaborato;

	/**
	 * @generated
	 */
	public void setFlgElaborato(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		flgElaborato = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFlgElaborato() {
		return flgElaborato;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk flgEsitoElab;

	/**
	 * @generated
	 */
	public void setFlgEsitoElab(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		flgEsitoElab = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFlgEsitoElab() {
		return flgEsitoElab;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk dataElab;

	/**
	 * @generated
	 */
	public void setDataElab(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		dataElab = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getDataElab() {
		return dataElab;
	}

}
