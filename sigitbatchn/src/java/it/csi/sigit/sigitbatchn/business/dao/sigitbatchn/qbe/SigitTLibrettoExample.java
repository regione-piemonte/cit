package it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.qbe;

import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dao.*;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.*;
import it.csi.sigit.sigitbatchn.business.dao.qbe.*;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Classe utilizzata dal framework di QBE (Query By Example).
 * Rappresenta l'esempio corrispondente al DTO [SigitTLibrettoDto].
 * Contiene:
 * - una property di tipo FieldCheck per ogni property del DTO: 
 *   deve essere valorizzata per definire il constraint che l'esempio
 *   pone relativamente a quella property (es. range tra 1 e 100).
 * Combinando opportunamente i check e gli esempi (positivi e negativi)
 * e' possibile costruire query complesse
 * @generated
 */
public class SigitTLibrettoExample extends AbstractExample {

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk idLibretto;

	/**
	 * @generated
	 */
	public void setIdLibretto(it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk chk) {
		idLibretto = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk getIdLibretto() {
		return idLibretto;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk fkStato;

	/**
	 * @generated
	 */
	public void setFkStato(it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk chk) {
		fkStato = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk getFkStato() {
		return fkStato;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk fkMotivoConsolid;

	/**
	 * @generated
	 */
	public void setFkMotivoConsolid(it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk chk) {
		fkMotivoConsolid = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk getFkMotivoConsolid() {
		return fkMotivoConsolid;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk fkTipoDocumento;

	/**
	 * @generated
	 */
	public void setFkTipoDocumento(it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk chk) {
		fkTipoDocumento = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk getFkTipoDocumento() {
		return fkTipoDocumento;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk dataConsolidamento;

	/**
	 * @generated
	 */
	public void setDataConsolidamento(it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk chk) {
		dataConsolidamento = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk getDataConsolidamento() {
		return dataConsolidamento;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk fileIndex;

	/**
	 * @generated
	 */
	public void setFileIndex(it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk chk) {
		fileIndex = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk getFileIndex() {
		return fileIndex;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk uidIndex;

	/**
	 * @generated
	 */
	public void setUidIndex(it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk chk) {
		uidIndex = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk getUidIndex() {
		return uidIndex;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk cfRedattore;

	/**
	 * @generated
	 */
	public void setCfRedattore(it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk chk) {
		cfRedattore = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk getCfRedattore() {
		return cfRedattore;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk flgControlloBozza;

	/**
	 * @generated
	 */
	public void setFlgControlloBozza(it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk chk) {
		flgControlloBozza = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk getFlgControlloBozza() {
		return flgControlloBozza;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk dataUltMod;

	/**
	 * @generated
	 */
	public void setDataUltMod(it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk chk) {
		dataUltMod = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk getDataUltMod() {
		return dataUltMod;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk utenteUltMod;

	/**
	 * @generated
	 */
	public void setUtenteUltMod(it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk chk) {
		utenteUltMod = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk getUtenteUltMod() {
		return utenteUltMod;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk codiceImpianto;

	/**
	 * @generated
	 */
	public void setCodiceImpianto(it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk chk) {
		codiceImpianto = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk getCodiceImpianto() {
		return codiceImpianto;
	}

}
