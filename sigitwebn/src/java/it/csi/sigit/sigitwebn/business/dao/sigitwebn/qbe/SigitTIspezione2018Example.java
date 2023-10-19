package it.csi.sigit.sigitwebn.business.dao.sigitwebn.qbe;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.qbe.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Classe utilizzata dal framework di QBE (Query By Example).
 * Rappresenta l'esempio corrispondente al DTO [SigitTIspezione2018Dto].
 * Contiene:
 * - una property di tipo FieldCheck per ogni property del DTO: 
 *   deve essere valorizzata per definire il constraint che l'esempio
 *   pone relativamente a quella property (es. range tra 1 e 100).
 * Combinando opportunamente i check e gli esempi (positivi e negativi)
 * e' possibile costruire query complesse
 * @generated
 */
public class SigitTIspezione2018Example extends AbstractExample {

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk idIspezione2018;

	/**
	 * @generated
	 */
	public void setIdIspezione2018(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		idIspezione2018 = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getIdIspezione2018() {
		return idIspezione2018;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk fkStatoIspezione;

	/**
	 * @generated
	 */
	public void setFkStatoIspezione(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		fkStatoIspezione = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFkStatoIspezione() {
		return fkStatoIspezione;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk fkVerifica;

	/**
	 * @generated
	 */
	public void setFkVerifica(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		fkVerifica = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFkVerifica() {
		return fkVerifica;
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
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk cfIspettoreSecondario;

	/**
	 * @generated
	 */
	public void setCfIspettoreSecondario(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		cfIspettoreSecondario = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getCfIspettoreSecondario() {
		return cfIspettoreSecondario;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk enteCompetente;

	/**
	 * @generated
	 */
	public void setEnteCompetente(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		enteCompetente = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getEnteCompetente() {
		return enteCompetente;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk flgEsito;

	/**
	 * @generated
	 */
	public void setFlgEsito(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		flgEsito = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFlgEsito() {
		return flgEsito;
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
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk istatProvCompetenza;

	/**
	 * @generated
	 */
	public void setIstatProvCompetenza(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		istatProvCompetenza = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getIstatProvCompetenza() {
		return istatProvCompetenza;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk flgAccSostitutivo;

	/**
	 * @generated
	 */
	public void setFlgAccSostitutivo(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		flgAccSostitutivo = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFlgAccSostitutivo() {
		return flgAccSostitutivo;
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
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk dtConclusione;

	/**
	 * @generated
	 */
	public void setDtConclusione(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		dtConclusione = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getDtConclusione() {
		return dtConclusione;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk flgIspPagamento;

	/**
	 * @generated
	 */
	public void setFlgIspPagamento(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		flgIspPagamento = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFlgIspPagamento() {
		return flgIspPagamento;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk istatComuneCompetenza;

	/**
	 * @generated
	 */
	public void setIstatComuneCompetenza(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		istatComuneCompetenza = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getIstatComuneCompetenza() {
		return istatComuneCompetenza;
	}

}
