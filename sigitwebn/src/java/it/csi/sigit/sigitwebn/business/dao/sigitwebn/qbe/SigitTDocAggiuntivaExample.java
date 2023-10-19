package it.csi.sigit.sigitwebn.business.dao.sigitwebn.qbe;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.qbe.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Classe utilizzata dal framework di QBE (Query By Example).
 * Rappresenta l'esempio corrispondente al DTO [SigitTDocAggiuntivaDto].
 * Contiene:
 * - una property di tipo FieldCheck per ogni property del DTO: 
 *   deve essere valorizzata per definire il constraint che l'esempio
 *   pone relativamente a quella property (es. range tra 1 e 100).
 * Combinando opportunamente i check e gli esempi (positivi e negativi)
 * e' possibile costruire query complesse
 * @generated
 */
public class SigitTDocAggiuntivaExample extends AbstractExample {

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk idDocAggiuntiva;

	/**
	 * @generated
	 */
	public void setIdDocAggiuntiva(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		idDocAggiuntiva = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getIdDocAggiuntiva() {
		return idDocAggiuntiva;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk codiceImpianto;

	/**
	 * @generated
	 */
	public void setCodiceImpianto(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		codiceImpianto = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getCodiceImpianto() {
		return codiceImpianto;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk fkTipoDocagg;

	/**
	 * @generated
	 */
	public void setFkTipoDocagg(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		fkTipoDocagg = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFkTipoDocagg() {
		return fkTipoDocagg;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk nomeDocOriginale;

	/**
	 * @generated
	 */
	public void setNomeDocOriginale(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		nomeDocOriginale = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getNomeDocOriginale() {
		return nomeDocOriginale;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk nomeDoc;

	/**
	 * @generated
	 */
	public void setNomeDoc(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		nomeDoc = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getNomeDoc() {
		return nomeDoc;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk uidIndex;

	/**
	 * @generated
	 */
	public void setUidIndex(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		uidIndex = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getUidIndex() {
		return uidIndex;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk desAltroTipodoc;

	/**
	 * @generated
	 */
	public void setDesAltroTipodoc(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		desAltroTipodoc = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getDesAltroTipodoc() {
		return desAltroTipodoc;
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
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk dataUpload;

	/**
	 * @generated
	 */
	public void setDataUpload(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		dataUpload = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getDataUpload() {
		return dataUpload;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk dataDelete;

	/**
	 * @generated
	 */
	public void setDataDelete(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		dataDelete = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getDataDelete() {
		return dataDelete;
	}

}
