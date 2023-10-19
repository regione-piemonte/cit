package it.csi.sigit.sigitwebn.business.dao.sigitwebn.qbe;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.qbe.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Classe utilizzata dal framework di QBE (Query By Example).
 * Rappresenta l'esempio corrispondente al DTO [SigitTSanzioneDto].
 * Contiene:
 * - una property di tipo FieldCheck per ogni property del DTO: 
 *   deve essere valorizzata per definire il constraint che l'esempio
 *   pone relativamente a quella property (es. range tra 1 e 100).
 * Combinando opportunamente i check e gli esempi (positivi e negativi)
 * e' possibile costruire query complesse
 * @generated
 */
public class SigitTSanzioneExample extends AbstractExample {

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk idSanzione;

	/**
	 * @generated
	 */
	public void setIdSanzione(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		idSanzione = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getIdSanzione() {
		return idSanzione;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk fkStatoSanzione;

	/**
	 * @generated
	 */
	public void setFkStatoSanzione(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		fkStatoSanzione = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFkStatoSanzione() {
		return fkStatoSanzione;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk fkIspezione2018;

	/**
	 * @generated
	 */
	public void setFkIspezione2018(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		fkIspezione2018 = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFkIspezione2018() {
		return fkIspezione2018;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk fkAccertamento;

	/**
	 * @generated
	 */
	public void setFkAccertamento(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		fkAccertamento = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFkAccertamento() {
		return fkAccertamento;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk fkPfSanzionata;

	/**
	 * @generated
	 */
	public void setFkPfSanzionata(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		fkPfSanzionata = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFkPfSanzionata() {
		return fkPfSanzionata;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk fkPgSanzionata;

	/**
	 * @generated
	 */
	public void setFkPgSanzionata(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		fkPgSanzionata = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFkPgSanzionata() {
		return fkPgSanzionata;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk motivazioneSanzione;

	/**
	 * @generated
	 */
	public void setMotivazioneSanzione(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		motivazioneSanzione = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getMotivazioneSanzione() {
		return motivazioneSanzione;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk valoreSanzione;

	/**
	 * @generated
	 */
	public void setValoreSanzione(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		valoreSanzione = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getValoreSanzione() {
		return valoreSanzione;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk dtCreazione;

	/**
	 * @generated
	 */
	public void setDtCreazione(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		dtCreazione = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getDtCreazione() {
		return dtCreazione;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk dtComunicazione;

	/**
	 * @generated
	 */
	public void setDtComunicazione(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		dtComunicazione = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getDtComunicazione() {
		return dtComunicazione;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk dtPagamento;

	/**
	 * @generated
	 */
	public void setDtPagamento(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		dtPagamento = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getDtPagamento() {
		return dtPagamento;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk note;

	/**
	 * @generated
	 */
	public void setNote(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		note = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getNote() {
		return note;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk motivoAnnullamento;

	/**
	 * @generated
	 */
	public void setMotivoAnnullamento(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		motivoAnnullamento = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getMotivoAnnullamento() {
		return motivoAnnullamento;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk dtAnnullamento;

	/**
	 * @generated
	 */
	public void setDtAnnullamento(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		dtAnnullamento = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getDtAnnullamento() {
		return dtAnnullamento;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk cfResponsabile;

	/**
	 * @generated
	 */
	public void setCfResponsabile(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		cfResponsabile = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getCfResponsabile() {
		return cfResponsabile;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk denomUtResponsabile;

	/**
	 * @generated
	 */
	public void setDenomUtResponsabile(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		denomUtResponsabile = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getDenomUtResponsabile() {
		return denomUtResponsabile;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk dtSveglia;

	/**
	 * @generated
	 */
	public void setDtSveglia(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		dtSveglia = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getDtSveglia() {
		return dtSveglia;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk noteSveglia;

	/**
	 * @generated
	 */
	public void setNoteSveglia(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		noteSveglia = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getNoteSveglia() {
		return noteSveglia;
	}

}
