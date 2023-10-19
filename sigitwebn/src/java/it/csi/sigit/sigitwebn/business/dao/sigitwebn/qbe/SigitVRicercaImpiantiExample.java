package it.csi.sigit.sigitwebn.business.dao.sigitwebn.qbe;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.qbe.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Classe utilizzata dal framework di QBE (Query By Example).
 * Rappresenta l'esempio corrispondente al DTO [SigitVRicercaImpiantiDto].
 * Contiene:
 * - una property di tipo FieldCheck per ogni property del DTO: 
 *   deve essere valorizzata per definire il constraint che l'esempio
 *   pone relativamente a quella property (es. range tra 1 e 100).
 * Combinando opportunamente i check e gli esempi (positivi e negativi)
 * e' possibile costruire query complesse
 * @generated
 */
public class SigitVRicercaImpiantiExample extends AbstractExample {

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
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk istatComune;

	/**
	 * @generated
	 */
	public void setIstatComune(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		istatComune = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getIstatComune() {
		return istatComune;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk denominazioneComune;

	/**
	 * @generated
	 */
	public void setDenominazioneComune(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		denominazioneComune = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getDenominazioneComune() {
		return denominazioneComune;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk siglaProvincia;

	/**
	 * @generated
	 */
	public void setSiglaProvincia(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		siglaProvincia = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getSiglaProvincia() {
		return siglaProvincia;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk denominazioneProvincia;

	/**
	 * @generated
	 */
	public void setDenominazioneProvincia(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		denominazioneProvincia = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getDenominazioneProvincia() {
		return denominazioneProvincia;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk fkStato;

	/**
	 * @generated
	 */
	public void setFkStato(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		fkStato = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFkStato() {
		return fkStato;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk l13PotH2oKw;

	/**
	 * @generated
	 */
	public void setL13PotH2oKw(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		l13PotH2oKw = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getL13PotH2oKw() {
		return l13PotH2oKw;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk l13PotClimaInvKw;

	/**
	 * @generated
	 */
	public void setL13PotClimaInvKw(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		l13PotClimaInvKw = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getL13PotClimaInvKw() {
		return l13PotClimaInvKw;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk l13PotClimaEstKw;

	/**
	 * @generated
	 */
	public void setL13PotClimaEstKw(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		l13PotClimaEstKw = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getL13PotClimaEstKw() {
		return l13PotClimaEstKw;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk flgNopdr;

	/**
	 * @generated
	 */
	public void setFlgNopdr(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		flgNopdr = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFlgNopdr() {
		return flgNopdr;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk indirizzoUnitaImmob;

	/**
	 * @generated
	 */
	public void setIndirizzoUnitaImmob(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		indirizzoUnitaImmob = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getIndirizzoUnitaImmob() {
		return indirizzoUnitaImmob;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk civico;

	/**
	 * @generated
	 */
	public void setCivico(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		civico = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getCivico() {
		return civico;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk sezione;

	/**
	 * @generated
	 */
	public void setSezione(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		sezione = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getSezione() {
		return sezione;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk foglio;

	/**
	 * @generated
	 */
	public void setFoglio(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		foglio = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFoglio() {
		return foglio;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk particella;

	/**
	 * @generated
	 */
	public void setParticella(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		particella = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getParticella() {
		return particella;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk subalterno;

	/**
	 * @generated
	 */
	public void setSubalterno(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		subalterno = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getSubalterno() {
		return subalterno;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk podElettrico;

	/**
	 * @generated
	 */
	public void setPodElettrico(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		podElettrico = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getPodElettrico() {
		return podElettrico;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk pdrGas;

	/**
	 * @generated
	 */
	public void setPdrGas(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		pdrGas = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getPdrGas() {
		return pdrGas;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk denominazioneResponsabile;

	/**
	 * @generated
	 */
	public void setDenominazioneResponsabile(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		denominazioneResponsabile = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getDenominazioneResponsabile() {
		return denominazioneResponsabile;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk denominazione3Responsabile;

	/**
	 * @generated
	 */
	public void setDenominazione3Responsabile(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		denominazione3Responsabile = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getDenominazione3Responsabile() {
		return denominazione3Responsabile;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk siglaRea3r;

	/**
	 * @generated
	 */
	public void setSiglaRea3r(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		siglaRea3r = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getSiglaRea3r() {
		return siglaRea3r;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk numeroRea3r;

	/**
	 * @generated
	 */
	public void setNumeroRea3r(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		numeroRea3r = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getNumeroRea3r() {
		return numeroRea3r;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk codiceFiscale3r;

	/**
	 * @generated
	 */
	public void setCodiceFiscale3r(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		codiceFiscale3r = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getCodiceFiscale3r() {
		return codiceFiscale3r;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk codiceFiscale;

	/**
	 * @generated
	 */
	public void setCodiceFiscale(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		codiceFiscale = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getCodiceFiscale() {
		return codiceFiscale;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk dataFinePfpg;

	/**
	 * @generated
	 */
	public void setDataFinePfpg(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		dataFinePfpg = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getDataFinePfpg() {
		return dataFinePfpg;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk ruoloResponsabile;

	/**
	 * @generated
	 */
	public void setRuoloResponsabile(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		ruoloResponsabile = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getRuoloResponsabile() {
		return ruoloResponsabile;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk ruoloFunz;

	/**
	 * @generated
	 */
	public void setRuoloFunz(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		ruoloFunz = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getRuoloFunz() {
		return ruoloFunz;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk flgTipoImpianto;

	/**
	 * @generated
	 */
	public void setFlgTipoImpianto(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		flgTipoImpianto = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFlgTipoImpianto() {
		return flgTipoImpianto;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk flgAppareccUiExt;

	/**
	 * @generated
	 */
	public void setFlgAppareccUiExt(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		flgAppareccUiExt = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFlgAppareccUiExt() {
		return flgAppareccUiExt;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk flgContabilizzazione;

	/**
	 * @generated
	 */
	public void setFlgContabilizzazione(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		flgContabilizzazione = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFlgContabilizzazione() {
		return flgContabilizzazione;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk desStato;

	/**
	 * @generated
	 */
	public void setDesStato(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		desStato = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getDesStato() {
		return desStato;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk flgVisuProprietario;

	/**
	 * @generated
	 */
	public void setFlgVisuProprietario(it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk chk) {
		flgVisuProprietario = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.business.dao.qbe.FieldChk getFlgVisuProprietario() {
		return flgVisuProprietario;
	}

}
