package it.csi.sigit.sigitwebn.business.dao.sigitwebn.qbe;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.qbe.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Classe utilizzata dal framework di QBE (Query By Example).
 * Rappresenta l'esempio corrispondente al DTO [SigitDTipoDocumentoDto].
 * Contiene:
 * - una property di tipo FieldCheck per ogni property del DTO: 
 *   deve essere valorizzata per definire il constraint che l'esempio
 *   pone relativamente a quella property (es. range tra 1 e 100).
 * Combinando opportunamente i check e gli esempi (positivi e negativi)
 * e' possibile costruire query complesse
 * @generated
 */
public class SigitDTipoDocumentoExample extends AbstractExample {

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk idTipoDocumento;

	/**
	 * @generated
	 */
	public void setIdTipoDocumento(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		idTipoDocumento = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getIdTipoDocumento() {
		return idTipoDocumento;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk desTipoDocumento;

	/**
	 * @generated
	 */
	public void setDesTipoDocumento(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		desTipoDocumento = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getDesTipoDocumento() {
		return desTipoDocumento;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk flgVisuElencoAll;

	/**
	 * @generated
	 */
	public void setFlgVisuElencoAll(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		flgVisuElencoAll = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFlgVisuElencoAll() {
		return flgVisuElencoAll;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk flgRicercaAll;

	/**
	 * @generated
	 */
	public void setFlgRicercaAll(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		flgRicercaAll = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFlgRicercaAll() {
		return flgRicercaAll;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk flgVisuElencoRapprova;

	/**
	 * @generated
	 */
	public void setFlgVisuElencoRapprova(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		flgVisuElencoRapprova = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFlgVisuElencoRapprova() {
		return flgVisuElencoRapprova;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk flgVisuElencoManut;

	/**
	 * @generated
	 */
	public void setFlgVisuElencoManut(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		flgVisuElencoManut = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFlgVisuElencoManut() {
		return flgVisuElencoManut;
	}

}
