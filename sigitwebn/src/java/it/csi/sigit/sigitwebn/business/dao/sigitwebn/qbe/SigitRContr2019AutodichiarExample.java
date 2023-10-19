package it.csi.sigit.sigitwebn.business.dao.sigitwebn.qbe;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.qbe.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Classe utilizzata dal framework di QBE (Query By Example).
 * Rappresenta l'esempio corrispondente al DTO [SigitRContr2019AutodichiarDto].
 * Contiene:
 * - una property di tipo FieldCheck per ogni property del DTO: 
 *   deve essere valorizzata per definire il constraint che l'esempio
 *   pone relativamente a quella property (es. range tra 1 e 100).
 * Combinando opportunamente i check e gli esempi (positivi e negativi)
 * e' possibile costruire query complesse
 * @generated
 */
public class SigitRContr2019AutodichiarExample extends AbstractExample {

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
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk idAutodichiarazione;

	/**
	 * @generated
	 */
	public void setIdAutodichiarazione(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		idAutodichiarazione = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getIdAutodichiarazione() {
		return idAutodichiarazione;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk flgNominaCessa;

	/**
	 * @generated
	 */
	public void setFlgNominaCessa(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		flgNominaCessa = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFlgNominaCessa() {
		return flgNominaCessa;
	}

}
