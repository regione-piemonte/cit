package it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.qbe;

import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dao.*;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.*;
import it.csi.sigit.sigitbatchn.business.dao.qbe.*;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Classe utilizzata dal framework di QBE (Query By Example).
 * Rappresenta l'esempio corrispondente al DTO [SigitTImportDistribDto].
 * Contiene:
 * - una property di tipo FieldCheck per ogni property del DTO: 
 *   deve essere valorizzata per definire il constraint che l'esempio
 *   pone relativamente a quella property (es. range tra 1 e 100).
 * Combinando opportunamente i check e gli esempi (positivi e negativi)
 * e' possibile costruire query complesse
 * @generated
 */
public class SigitTImportDistribExample extends AbstractExample {

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk idImportDistrib;

	/**
	 * @generated
	 */
	public void setIdImportDistrib(it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk chk) {
		idImportDistrib = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk getIdImportDistrib() {
		return idImportDistrib;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk fkPersonaGiuridica;

	/**
	 * @generated
	 */
	public void setFkPersonaGiuridica(it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk chk) {
		fkPersonaGiuridica = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk getFkPersonaGiuridica() {
		return fkPersonaGiuridica;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk fkStatoDistrib;

	/**
	 * @generated
	 */
	public void setFkStatoDistrib(it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk chk) {
		fkStatoDistrib = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk getFkStatoDistrib() {
		return fkStatoDistrib;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk dataInizioElab;

	/**
	 * @generated
	 */
	public void setDataInizioElab(it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk chk) {
		dataInizioElab = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk getDataInizioElab() {
		return dataInizioElab;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk dataFineElab;

	/**
	 * @generated
	 */
	public void setDataFineElab(it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk chk) {
		dataFineElab = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk getDataFineElab() {
		return dataFineElab;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk dataAnnullamento;

	/**
	 * @generated
	 */
	public void setDataAnnullamento(it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk chk) {
		dataAnnullamento = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk getDataAnnullamento() {
		return dataAnnullamento;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk nomeFileImport;

	/**
	 * @generated
	 */
	public void setNomeFileImport(it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk chk) {
		nomeFileImport = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk getNomeFileImport() {
		return nomeFileImport;
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
	private it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk annoRiferimento;

	/**
	 * @generated
	 */
	public void setAnnoRiferimento(it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk chk) {
		annoRiferimento = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk getAnnoRiferimento() {
		return annoRiferimento;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk dataInvioMailDistrib;

	/**
	 * @generated
	 */
	public void setDataInvioMailDistrib(it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk chk) {
		dataInvioMailDistrib = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk getDataInvioMailDistrib() {
		return dataInvioMailDistrib;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk dataInvioMailAssistenza;

	/**
	 * @generated
	 */
	public void setDataInvioMailAssistenza(it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk chk) {
		dataInvioMailAssistenza = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk getDataInvioMailAssistenza() {
		return dataInvioMailAssistenza;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk totRecordElaborati;

	/**
	 * @generated
	 */
	public void setTotRecordElaborati(it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk chk) {
		totRecordElaborati = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk getTotRecordElaborati() {
		return totRecordElaborati;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk totRecordScartati;

	/**
	 * @generated
	 */
	public void setTotRecordScartati(it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk chk) {
		totRecordScartati = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk getTotRecordScartati() {
		return totRecordScartati;
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
	private it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk utenteCaricamento;

	/**
	 * @generated
	 */
	public void setUtenteCaricamento(it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk chk) {
		utenteCaricamento = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitbatchn.business.dao.qbe.FieldChk getUtenteCaricamento() {
		return utenteCaricamento;
	}

}
