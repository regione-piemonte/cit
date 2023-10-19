package it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.qbe;

import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dao.*;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.*;
import it.csi.sigit.sigitbatchn.business.dao.qbe.*;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Classe utilizzata dal framework di QBE (Query By Example).
 * Rappresenta l'esempio corrispondente al DTO [SigitTVerificaDto].
 * Contiene:
 * - una property di tipo FieldCheck per ogni property del DTO: 
 *   deve essere valorizzata per definire il constraint che l'esempio
 *   pone relativamente a quella property (es. range tra 1 e 100).
 * Combinando opportunamente i check e gli esempi (positivi e negativi)
 * e' possibile costruire query complesse
 * @generated
 */
public class SigitTVerificaExample extends AbstractExample {

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk idVerifica;

	/**
	 * @generated
	 */
	public void setIdVerifica(it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk chk) {
		idVerifica = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk getIdVerifica() {
		return idVerifica;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk fkTipoVerifica;

	/**
	 * @generated
	 */
	public void setFkTipoVerifica(it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk chk) {
		fkTipoVerifica = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk getFkTipoVerifica() {
		return fkTipoVerifica;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk fkAllegato;

	/**
	 * @generated
	 */
	public void setFkAllegato(it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk chk) {
		fkAllegato = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk getFkAllegato() {
		return fkAllegato;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk fkDatoDistrib;

	/**
	 * @generated
	 */
	public void setFkDatoDistrib(it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk chk) {
		fkDatoDistrib = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk getFkDatoDistrib() {
		return fkDatoDistrib;
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

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk cfUtenteCaricamento;

	/**
	 * @generated
	 */
	public void setCfUtenteCaricamento(it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk chk) {
		cfUtenteCaricamento = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk getCfUtenteCaricamento() {
		return cfUtenteCaricamento;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk denomUtenteCaricamento;

	/**
	 * @generated
	 */
	public void setDenomUtenteCaricamento(it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk chk) {
		denomUtenteCaricamento = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk getDenomUtenteCaricamento() {
		return denomUtenteCaricamento;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk dtCaricamento;

	/**
	 * @generated
	 */
	public void setDtCaricamento(it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk chk) {
		dtCaricamento = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk getDtCaricamento() {
		return dtCaricamento;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk siglaBollino;

	/**
	 * @generated
	 */
	public void setSiglaBollino(it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk chk) {
		siglaBollino = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk getSiglaBollino() {
		return siglaBollino;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk numeroBollino;

	/**
	 * @generated
	 */
	public void setNumeroBollino(it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk chk) {
		numeroBollino = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk getNumeroBollino() {
		return numeroBollino;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk dtSveglia;

	/**
	 * @generated
	 */
	public void setDtSveglia(it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk chk) {
		dtSveglia = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk getDtSveglia() {
		return dtSveglia;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk noteSveglia;

	/**
	 * @generated
	 */
	public void setNoteSveglia(it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk chk) {
		noteSveglia = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk getNoteSveglia() {
		return noteSveglia;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk note;

	/**
	 * @generated
	 */
	public void setNote(it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk chk) {
		note = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk getNote() {
		return note;
	}

}
