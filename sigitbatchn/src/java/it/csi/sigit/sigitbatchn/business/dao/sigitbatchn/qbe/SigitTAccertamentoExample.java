package it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.qbe;

import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dao.*;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.*;
import it.csi.sigit.sigitbatchn.business.dao.qbe.*;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Classe utilizzata dal framework di QBE (Query By Example).
 * Rappresenta l'esempio corrispondente al DTO [SigitTAccertamentoDto].
 * Contiene:
 * - una property di tipo FieldCheck per ogni property del DTO: 
 *   deve essere valorizzata per definire il constraint che l'esempio
 *   pone relativamente a quella property (es. range tra 1 e 100).
 * Combinando opportunamente i check e gli esempi (positivi e negativi)
 * e' possibile costruire query complesse
 * @generated
 */
public class SigitTAccertamentoExample extends AbstractExample {

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk idAccertamento;

	/**
	 * @generated
	 */
	public void setIdAccertamento(it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk chk) {
		idAccertamento = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk getIdAccertamento() {
		return idAccertamento;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk fkVerifica;

	/**
	 * @generated
	 */
	public void setFkVerifica(it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk chk) {
		fkVerifica = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk getFkVerifica() {
		return fkVerifica;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk fkStatoAccertamento;

	/**
	 * @generated
	 */
	public void setFkStatoAccertamento(it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk chk) {
		fkStatoAccertamento = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk getFkStatoAccertamento() {
		return fkStatoAccertamento;
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
	private it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk cfUtenteAssegn;

	/**
	 * @generated
	 */
	public void setCfUtenteAssegn(it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk chk) {
		cfUtenteAssegn = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk getCfUtenteAssegn() {
		return cfUtenteAssegn;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk dtCreazione;

	/**
	 * @generated
	 */
	public void setDtCreazione(it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk chk) {
		dtCreazione = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk getDtCreazione() {
		return dtCreazione;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk dtConclusione;

	/**
	 * @generated
	 */
	public void setDtConclusione(it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk chk) {
		dtConclusione = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk getDtConclusione() {
		return dtConclusione;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk fkTipoConclusione;

	/**
	 * @generated
	 */
	public void setFkTipoConclusione(it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk chk) {
		fkTipoConclusione = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk getFkTipoConclusione() {
		return fkTipoConclusione;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk fkTipoAnomalia;

	/**
	 * @generated
	 */
	public void setFkTipoAnomalia(it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk chk) {
		fkTipoAnomalia = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk getFkTipoAnomalia() {
		return fkTipoAnomalia;
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

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk siglaProvCompetenza;

	/**
	 * @generated
	 */
	public void setSiglaProvCompetenza(it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk chk) {
		siglaProvCompetenza = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk getSiglaProvCompetenza() {
		return siglaProvCompetenza;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk istatProvCompetenza;

	/**
	 * @generated
	 */
	public void setIstatProvCompetenza(it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk chk) {
		istatProvCompetenza = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk getIstatProvCompetenza() {
		return istatProvCompetenza;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk denomUtenteAssegn;

	/**
	 * @generated
	 */
	public void setDenomUtenteAssegn(it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk chk) {
		denomUtenteAssegn = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk getDenomUtenteAssegn() {
		return denomUtenteAssegn;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk istatComuneCompetenza;

	/**
	 * @generated
	 */
	public void setIstatComuneCompetenza(it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk chk) {
		istatComuneCompetenza = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk getIstatComuneCompetenza() {
		return istatComuneCompetenza;
	}

}
