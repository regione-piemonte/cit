package it.csi.sigit.sigitwebn.business.dao.sigitwebn.qbe;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.qbe.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Classe utilizzata dal framework di QBE (Query By Example).
 * Rappresenta l'esempio corrispondente al DTO [SigitVRicerca3ResponsabileDto].
 * Contiene:
 * - una property di tipo FieldCheck per ogni property del DTO: 
 *   deve essere valorizzata per definire il constraint che l'esempio
 *   pone relativamente a quella property (es. range tra 1 e 100).
 * Combinando opportunamente i check e gli esempi (positivi e negativi)
 * e' possibile costruire query complesse
 * @generated
 */
public class SigitVRicerca3ResponsabileExample extends AbstractExample {

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
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk fkRuolo;

	/**
	 * @generated
	 */
	public void setFkRuolo(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		fkRuolo = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFkRuolo() {
		return fkRuolo;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk desRuolo;

	/**
	 * @generated
	 */
	public void setDesRuolo(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		desRuolo = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getDesRuolo() {
		return desRuolo;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk dataCaricamento;

	/**
	 * @generated
	 */
	public void setDataCaricamento(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		dataCaricamento = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getDataCaricamento() {
		return dataCaricamento;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk dataCessazione;

	/**
	 * @generated
	 */
	public void setDataCessazione(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		dataCessazione = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getDataCessazione() {
		return dataCessazione;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk dataInserimentoCessazione;

	/**
	 * @generated
	 */
	public void setDataInserimentoCessazione(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		dataInserimentoCessazione = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getDataInserimentoCessazione() {
		return dataInserimentoCessazione;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk fkPg3Resp;

	/**
	 * @generated
	 */
	public void setFkPg3Resp(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		fkPg3Resp = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFkPg3Resp() {
		return fkPg3Resp;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk fkImpRuoloPfpgResp;

	/**
	 * @generated
	 */
	public void setFkImpRuoloPfpgResp(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		fkImpRuoloPfpgResp = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFkImpRuoloPfpgResp() {
		return fkImpRuoloPfpgResp;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk dataInizioContratto;

	/**
	 * @generated
	 */
	public void setDataInizioContratto(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		dataInizioContratto = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getDataInizioContratto() {
		return dataInizioContratto;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk dataFineContratto;

	/**
	 * @generated
	 */
	public void setDataFineContratto(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		dataFineContratto = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getDataFineContratto() {
		return dataFineContratto;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk flgTacitoRinnovo;

	/**
	 * @generated
	 */
	public void setFlgTacitoRinnovo(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		flgTacitoRinnovo = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFlgTacitoRinnovo() {
		return flgTacitoRinnovo;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk respCodiceFiscale;

	/**
	 * @generated
	 */
	public void setRespCodiceFiscale(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		respCodiceFiscale = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getRespCodiceFiscale() {
		return respCodiceFiscale;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk respDenominazione;

	/**
	 * @generated
	 */
	public void setRespDenominazione(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		respDenominazione = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getRespDenominazione() {
		return respDenominazione;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk respNome;

	/**
	 * @generated
	 */
	public void setRespNome(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		respNome = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getRespNome() {
		return respNome;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk terzoRespDenominazione;

	/**
	 * @generated
	 */
	public void setTerzoRespDenominazione(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		terzoRespDenominazione = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getTerzoRespDenominazione() {
		return terzoRespDenominazione;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk terzoRespSiglaRea;

	/**
	 * @generated
	 */
	public void setTerzoRespSiglaRea(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		terzoRespSiglaRea = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getTerzoRespSiglaRea() {
		return terzoRespSiglaRea;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk terzoRespNumeroRea;

	/**
	 * @generated
	 */
	public void setTerzoRespNumeroRea(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		terzoRespNumeroRea = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getTerzoRespNumeroRea() {
		return terzoRespNumeroRea;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk codiceFiscale3Resp;

	/**
	 * @generated
	 */
	public void setCodiceFiscale3Resp(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		codiceFiscale3Resp = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getCodiceFiscale3Resp() {
		return codiceFiscale3Resp;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk denomComune3Resp;

	/**
	 * @generated
	 */
	public void setDenomComune3Resp(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		denomComune3Resp = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getDenomComune3Resp() {
		return denomComune3Resp;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk siglaProv3Resp;

	/**
	 * @generated
	 */
	public void setSiglaProv3Resp(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		siglaProv3Resp = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getSiglaProv3Resp() {
		return siglaProv3Resp;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk denomProvincia3Resp;

	/**
	 * @generated
	 */
	public void setDenomProvincia3Resp(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		denomProvincia3Resp = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getDenomProvincia3Resp() {
		return denomProvincia3Resp;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk denomComuneImpianto;

	/**
	 * @generated
	 */
	public void setDenomComuneImpianto(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		denomComuneImpianto = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getDenomComuneImpianto() {
		return denomComuneImpianto;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk denomProvImpianto;

	/**
	 * @generated
	 */
	public void setDenomProvImpianto(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		denomProvImpianto = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getDenomProvImpianto() {
		return denomProvImpianto;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk siglaProvImpianto;

	/**
	 * @generated
	 */
	public void setSiglaProvImpianto(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		siglaProvImpianto = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getSiglaProvImpianto() {
		return siglaProvImpianto;
	}

}
