package it.csi.sigit.sigitwebn.business.dao.sigitwebn.qbe;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.qbe.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Classe utilizzata dal framework di QBE (Query By Example).
 * Rappresenta l'esempio corrispondente al DTO [SigitTConsumoTipo1BDto].
 * Contiene:
 * - una property di tipo FieldCheck per ogni property del DTO: 
 *   deve essere valorizzata per definire il constraint che l'esempio
 *   pone relativamente a quella property (es. range tra 1 e 100).
 * Combinando opportunamente i check e gli esempi (positivi e negativi)
 * e' possibile costruire query complesse
 * @generated
 */
public class SigitTConsumoTipo1BExample extends AbstractExample {

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk idConsumoTipo1b;

	/**
	 * @generated
	 */
	public void setIdConsumoTipo1b(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		idConsumoTipo1b = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getIdConsumoTipo1b() {
		return idConsumoTipo1b;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk esercizio;

	/**
	 * @generated
	 */
	public void setEsercizio(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		esercizio = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getEsercizio() {
		return esercizio;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk letturaIniziale;

	/**
	 * @generated
	 */
	public void setLetturaIniziale(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		letturaIniziale = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getLetturaIniziale() {
		return letturaIniziale;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk letturaFinale;

	/**
	 * @generated
	 */
	public void setLetturaFinale(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		letturaFinale = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getLetturaFinale() {
		return letturaFinale;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk consumo;

	/**
	 * @generated
	 */
	public void setConsumo(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		consumo = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getConsumo() {
		return consumo;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk fkAllegato;

	/**
	 * @generated
	 */
	public void setFkAllegato(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		fkAllegato = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFkAllegato() {
		return fkAllegato;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk idTipoConsumo1b;

	/**
	 * @generated
	 */
	public void setIdTipoConsumo1b(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		idTipoConsumo1b = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getIdTipoConsumo1b() {
		return idTipoConsumo1b;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk idUnitaMisura;

	/**
	 * @generated
	 */
	public void setIdUnitaMisura(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		idUnitaMisura = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getIdUnitaMisura() {
		return idUnitaMisura;
	}

}
