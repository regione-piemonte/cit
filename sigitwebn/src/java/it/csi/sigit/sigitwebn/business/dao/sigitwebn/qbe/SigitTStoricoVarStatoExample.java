package it.csi.sigit.sigitwebn.business.dao.sigitwebn.qbe;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.qbe.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Classe utilizzata dal framework di QBE (Query By Example).
 * Rappresenta l'esempio corrispondente al DTO [SigitTStoricoVarStatoDto].
 * Contiene:
 * - una property di tipo FieldCheck per ogni property del DTO: 
 *   deve essere valorizzata per definire il constraint che l'esempio
 *   pone relativamente a quella property (es. range tra 1 e 100).
 * Combinando opportunamente i check e gli esempi (positivi e negativi)
 * e' possibile costruire query complesse
 * @generated
 */
public class SigitTStoricoVarStatoExample extends AbstractExample {

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
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk dtEvento;

	/**
	 * @generated
	 */
	public void setDtEvento(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		dtEvento = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getDtEvento() {
		return dtEvento;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk dtInizioVariazione;

	/**
	 * @generated
	 */
	public void setDtInizioVariazione(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		dtInizioVariazione = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getDtInizioVariazione() {
		return dtInizioVariazione;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk motivo;

	/**
	 * @generated
	 */
	public void setMotivo(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		motivo = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getMotivo() {
		return motivo;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk statoDa;

	/**
	 * @generated
	 */
	public void setStatoDa(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		statoDa = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getStatoDa() {
		return statoDa;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk statoA;

	/**
	 * @generated
	 */
	public void setStatoA(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		statoA = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getStatoA() {
		return statoA;
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

}
