package it.csi.sigit.sigitwebn.business.dao.sigitwebn.qbe;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.qbe.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Classe utilizzata dal framework di QBE (Query By Example).
 * Rappresenta l'esempio corrispondente al DTO [SigitTRappDettaglioDto].
 * Contiene:
 * - una property di tipo FieldCheck per ogni property del DTO: 
 *   deve essere valorizzata per definire il constraint che l'esempio
 *   pone relativamente a quella property (es. range tra 1 e 100).
 * Combinando opportunamente i check e gli esempi (positivi e negativi)
 * e' possibile costruire query complesse
 * @generated
 */
public class SigitTRappDettaglioExample extends AbstractExample {

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk idRapportoDettaglio;

	/**
	 * @generated
	 */
	public void setIdRapportoDettaglio(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		idRapportoDettaglio = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getIdRapportoDettaglio() {
		return idRapportoDettaglio;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk fkRapportoControllo;

	/**
	 * @generated
	 */
	public void setFkRapportoControllo(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		fkRapportoControllo = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFkRapportoControllo() {
		return fkRapportoControllo;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk flgPendenze;

	/**
	 * @generated
	 */
	public void setFlgPendenze(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		flgPendenze = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFlgPendenze() {
		return flgPendenze;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk flgSezioni;

	/**
	 * @generated
	 */
	public void setFlgSezioni(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		flgSezioni = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFlgSezioni() {
		return flgSezioni;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk flgCurve;

	/**
	 * @generated
	 */
	public void setFlgCurve(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		flgCurve = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFlgCurve() {
		return flgCurve;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk flgLunghezza;

	/**
	 * @generated
	 */
	public void setFlgLunghezza(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		flgLunghezza = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFlgLunghezza() {
		return flgLunghezza;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk flgStatoOk;

	/**
	 * @generated
	 */
	public void setFlgStatoOk(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		flgStatoOk = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFlgStatoOk() {
		return flgStatoOk;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk flgSingolo;

	/**
	 * @generated
	 */
	public void setFlgSingolo(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		flgSingolo = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFlgSingolo() {
		return flgSingolo;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk flgAParete;

	/**
	 * @generated
	 */
	public void setFlgAParete(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		flgAParete = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFlgAParete() {
		return flgAParete;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk flgNoRiflusso;

	/**
	 * @generated
	 */
	public void setFlgNoRiflusso(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		flgNoRiflusso = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFlgNoRiflusso() {
		return flgNoRiflusso;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk flgCoibentazioni;

	/**
	 * @generated
	 */
	public void setFlgCoibentazioni(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		flgCoibentazioni = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFlgCoibentazioni() {
		return flgCoibentazioni;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk flgNoPerdite;

	/**
	 * @generated
	 */
	public void setFlgNoPerdite(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		flgNoPerdite = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFlgNoPerdite() {
		return flgNoPerdite;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk flgCannafumariaCollettiva;

	/**
	 * @generated
	 */
	public void setFlgCannafumariaCollettiva(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		flgCannafumariaCollettiva = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFlgCannafumariaCollettiva() {
		return flgCannafumariaCollettiva;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk flgUgelliPuliti;

	/**
	 * @generated
	 */
	public void setFlgUgelliPuliti(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		flgUgelliPuliti = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFlgUgelliPuliti() {
		return flgUgelliPuliti;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk flgRompitiraggioOk;

	/**
	 * @generated
	 */
	public void setFlgRompitiraggioOk(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		flgRompitiraggioOk = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFlgRompitiraggioOk() {
		return flgRompitiraggioOk;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk flgScambiatorePulito;

	/**
	 * @generated
	 */
	public void setFlgScambiatorePulito(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		flgScambiatorePulito = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFlgScambiatorePulito() {
		return flgScambiatorePulito;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk flgFunzionamentoOk;

	/**
	 * @generated
	 */
	public void setFlgFunzionamentoOk(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		flgFunzionamentoOk = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFlgFunzionamentoOk() {
		return flgFunzionamentoOk;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk flgDispositiviOk;

	/**
	 * @generated
	 */
	public void setFlgDispositiviOk(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		flgDispositiviOk = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFlgDispositiviOk() {
		return flgDispositiviOk;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk flgAssenzaPerditeAcqua;

	/**
	 * @generated
	 */
	public void setFlgAssenzaPerditeAcqua(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		flgAssenzaPerditeAcqua = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFlgAssenzaPerditeAcqua() {
		return flgAssenzaPerditeAcqua;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk flgValvolaSicurLibera;

	/**
	 * @generated
	 */
	public void setFlgValvolaSicurLibera(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		flgValvolaSicurLibera = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFlgValvolaSicurLibera() {
		return flgValvolaSicurLibera;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk flgVasoEspCarico;

	/**
	 * @generated
	 */
	public void setFlgVasoEspCarico(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		flgVasoEspCarico = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFlgVasoEspCarico() {
		return flgVasoEspCarico;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk flgSicurezzaOk;

	/**
	 * @generated
	 */
	public void setFlgSicurezzaOk(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		flgSicurezzaOk = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFlgSicurezzaOk() {
		return flgSicurezzaOk;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk flgNoUsureDeformazioni;

	/**
	 * @generated
	 */
	public void setFlgNoUsureDeformazioni(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		flgNoUsureDeformazioni = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFlgNoUsureDeformazioni() {
		return flgNoUsureDeformazioni;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk flgCircuitoAriaLibero;

	/**
	 * @generated
	 */
	public void setFlgCircuitoAriaLibero(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		flgCircuitoAriaLibero = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFlgCircuitoAriaLibero() {
		return flgCircuitoAriaLibero;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk flgAccoppGenOk;

	/**
	 * @generated
	 */
	public void setFlgAccoppGenOk(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		flgAccoppGenOk = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFlgAccoppGenOk() {
		return flgAccoppGenOk;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk flgFunzionamentoCorretto;

	/**
	 * @generated
	 */
	public void setFlgFunzionamentoCorretto(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		flgFunzionamentoCorretto = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFlgFunzionamentoCorretto() {
		return flgFunzionamentoCorretto;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk tempFumi;

	/**
	 * @generated
	 */
	public void setTempFumi(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		tempFumi = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getTempFumi() {
		return tempFumi;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk tempAria;

	/**
	 * @generated
	 */
	public void setTempAria(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		tempAria = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getTempAria() {
		return tempAria;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk o2;

	/**
	 * @generated
	 */
	public void setO2(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		o2 = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getO2() {
		return o2;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk co2;

	/**
	 * @generated
	 */
	public void setCo2(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		co2 = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getCo2() {
		return co2;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk bacharach;

	/**
	 * @generated
	 */
	public void setBacharach(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		bacharach = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getBacharach() {
		return bacharach;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk co;

	/**
	 * @generated
	 */
	public void setCo(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		co = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getCo() {
		return co;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk rendComb;

	/**
	 * @generated
	 */
	public void setRendComb(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		rendComb = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getRendComb() {
		return rendComb;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk flgLibrettoBruciatore;

	/**
	 * @generated
	 */
	public void setFlgLibrettoBruciatore(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		flgLibrettoBruciatore = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFlgLibrettoBruciatore() {
		return flgLibrettoBruciatore;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk nox;

	/**
	 * @generated
	 */
	public void setNox(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		nox = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getNox() {
		return nox;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk flgLibrettoCaldaia;

	/**
	 * @generated
	 */
	public void setFlgLibrettoCaldaia(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		flgLibrettoCaldaia = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFlgLibrettoCaldaia() {
		return flgLibrettoCaldaia;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk noteDocumentazione;

	/**
	 * @generated
	 */
	public void setNoteDocumentazione(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		noteDocumentazione = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getNoteDocumentazione() {
		return noteDocumentazione;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk flgEvLineeElettriche;

	/**
	 * @generated
	 */
	public void setFlgEvLineeElettriche(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		flgEvLineeElettriche = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFlgEvLineeElettriche() {
		return flgEvLineeElettriche;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk flgEvBruciatore;

	/**
	 * @generated
	 */
	public void setFlgEvBruciatore(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		flgEvBruciatore = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFlgEvBruciatore() {
		return flgEvBruciatore;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk flgEvGeneratoreCalore;

	/**
	 * @generated
	 */
	public void setFlgEvGeneratoreCalore(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		flgEvGeneratoreCalore = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFlgEvGeneratoreCalore() {
		return flgEvGeneratoreCalore;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk flgEvCanaliFumo;

	/**
	 * @generated
	 */
	public void setFlgEvCanaliFumo(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		flgEvCanaliFumo = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFlgEvCanaliFumo() {
		return flgEvCanaliFumo;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk flgControlloRend;

	/**
	 * @generated
	 */
	public void setFlgControlloRend(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		flgControlloRend = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFlgControlloRend() {
		return flgControlloRend;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk tiraggio;

	/**
	 * @generated
	 */
	public void setTiraggio(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		tiraggio = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getTiraggio() {
		return tiraggio;
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
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk bFlgDichiarConform;

	/**
	 * @generated
	 */
	public void setBFlgDichiarConform(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		bFlgDichiarConform = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getBFlgDichiarConform() {
		return bFlgDichiarConform;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk fRaccomandazioni;

	/**
	 * @generated
	 */
	public void setFRaccomandazioni(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		fRaccomandazioni = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFRaccomandazioni() {
		return fRaccomandazioni;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk fPrescrizioni;

	/**
	 * @generated
	 */
	public void setFPrescrizioni(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		fPrescrizioni = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFPrescrizioni() {
		return fPrescrizioni;
	}

}
