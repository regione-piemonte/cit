package it.csi.sigit.elencom.business.dao.elencom.qbe;

import it.csi.sigit.elencom.business.dao.elencom.dao.*;
import it.csi.sigit.elencom.business.dao.elencom.dto.*;
import it.csi.sigit.elencom.business.dao.qbe.*;
import it.csi.sigit.elencom.business.dao.elencom.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Classe utilizzata dal framework di QBE (Query By Example).
 * Rappresenta l'esempio corrispondente al DTO [MvOdVistaDettaglioImpiantiDto].
 * Contiene:
 * - una property di tipo FieldCheck per ogni property del DTO: 
 *   deve essere valorizzata per definire il constraint che l'esempio
 *   pone relativamente a quella property (es. range tra 1 e 100).
 * Combinando opportunamente i check e gli esempi (positivi e negativi)
 * e' possibile costruire query complesse
 * @generated
 */
public class MvOdVistaDettaglioImpiantiExample extends AbstractExample {

	/**
	 * @generated
	 */
	private it.csi.sigit.elencom.business.dao.qbe.FieldChk codiceImpianto;

	/**
	 * @generated
	 */
	public void setCodiceImpianto(it.csi.sigit.elencom.business.dao.qbe.FieldChk chk) {
		codiceImpianto = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.elencom.business.dao.qbe.FieldChk getCodiceImpianto() {
		return codiceImpianto;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.elencom.business.dao.qbe.FieldChk denominazioneComune;

	/**
	 * @generated
	 */
	public void setDenominazioneComune(it.csi.sigit.elencom.business.dao.qbe.FieldChk chk) {
		denominazioneComune = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.elencom.business.dao.qbe.FieldChk getDenominazioneComune() {
		return denominazioneComune;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.elencom.business.dao.qbe.FieldChk denominazioneProvincia;

	/**
	 * @generated
	 */
	public void setDenominazioneProvincia(it.csi.sigit.elencom.business.dao.qbe.FieldChk chk) {
		denominazioneProvincia = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.elencom.business.dao.qbe.FieldChk getDenominazioneProvincia() {
		return denominazioneProvincia;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.elencom.business.dao.qbe.FieldChk l12FkCategoria;

	/**
	 * @generated
	 */
	public void setL12FkCategoria(it.csi.sigit.elencom.business.dao.qbe.FieldChk chk) {
		l12FkCategoria = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.elencom.business.dao.qbe.FieldChk getL12FkCategoria() {
		return l12FkCategoria;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.elencom.business.dao.qbe.FieldChk l12VolRiscM3;

	/**
	 * @generated
	 */
	public void setL12VolRiscM3(it.csi.sigit.elencom.business.dao.qbe.FieldChk chk) {
		l12VolRiscM3 = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.elencom.business.dao.qbe.FieldChk getL12VolRiscM3() {
		return l12VolRiscM3;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.elencom.business.dao.qbe.FieldChk l12VolRaffM3;

	/**
	 * @generated
	 */
	public void setL12VolRaffM3(it.csi.sigit.elencom.business.dao.qbe.FieldChk chk) {
		l12VolRaffM3 = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.elencom.business.dao.qbe.FieldChk getL12VolRaffM3() {
		return l12VolRaffM3;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.elencom.business.dao.qbe.FieldChk l13PotH2oKw;

	/**
	 * @generated
	 */
	public void setL13PotH2oKw(it.csi.sigit.elencom.business.dao.qbe.FieldChk chk) {
		l13PotH2oKw = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.elencom.business.dao.qbe.FieldChk getL13PotH2oKw() {
		return l13PotH2oKw;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.elencom.business.dao.qbe.FieldChk l13PotClimaInvKw;

	/**
	 * @generated
	 */
	public void setL13PotClimaInvKw(it.csi.sigit.elencom.business.dao.qbe.FieldChk chk) {
		l13PotClimaInvKw = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.elencom.business.dao.qbe.FieldChk getL13PotClimaInvKw() {
		return l13PotClimaInvKw;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.elencom.business.dao.qbe.FieldChk l13PotClimaEstKw;

	/**
	 * @generated
	 */
	public void setL13PotClimaEstKw(it.csi.sigit.elencom.business.dao.qbe.FieldChk chk) {
		l13PotClimaEstKw = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.elencom.business.dao.qbe.FieldChk getL13PotClimaEstKw() {
		return l13PotClimaEstKw;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.elencom.business.dao.qbe.FieldChk tipoComponente;

	/**
	 * @generated
	 */
	public void setTipoComponente(it.csi.sigit.elencom.business.dao.qbe.FieldChk chk) {
		tipoComponente = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.elencom.business.dao.qbe.FieldChk getTipoComponente() {
		return tipoComponente;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.elencom.business.dao.qbe.FieldChk progressivo;

	/**
	 * @generated
	 */
	public void setProgressivo(it.csi.sigit.elencom.business.dao.qbe.FieldChk chk) {
		progressivo = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.elencom.business.dao.qbe.FieldChk getProgressivo() {
		return progressivo;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.elencom.business.dao.qbe.FieldChk dataInstall;

	/**
	 * @generated
	 */
	public void setDataInstall(it.csi.sigit.elencom.business.dao.qbe.FieldChk chk) {
		dataInstall = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.elencom.business.dao.qbe.FieldChk getDataInstall() {
		return dataInstall;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.elencom.business.dao.qbe.FieldChk desMarca;

	/**
	 * @generated
	 */
	public void setDesMarca(it.csi.sigit.elencom.business.dao.qbe.FieldChk chk) {
		desMarca = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.elencom.business.dao.qbe.FieldChk getDesMarca() {
		return desMarca;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.elencom.business.dao.qbe.FieldChk desCombustibile;

	/**
	 * @generated
	 */
	public void setDesCombustibile(it.csi.sigit.elencom.business.dao.qbe.FieldChk chk) {
		desCombustibile = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.elencom.business.dao.qbe.FieldChk getDesCombustibile() {
		return desCombustibile;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.elencom.business.dao.qbe.FieldChk desDettaglio;

	/**
	 * @generated
	 */
	public void setDesDettaglio(it.csi.sigit.elencom.business.dao.qbe.FieldChk chk) {
		desDettaglio = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.elencom.business.dao.qbe.FieldChk getDesDettaglio() {
		return desDettaglio;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.elencom.business.dao.qbe.FieldChk potenza;

	/**
	 * @generated
	 */
	public void setPotenza(it.csi.sigit.elencom.business.dao.qbe.FieldChk chk) {
		potenza = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.elencom.business.dao.qbe.FieldChk getPotenza() {
		return potenza;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.elencom.business.dao.qbe.FieldChk rendimentoPerc;

	/**
	 * @generated
	 */
	public void setRendimentoPerc(it.csi.sigit.elencom.business.dao.qbe.FieldChk chk) {
		rendimentoPerc = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.elencom.business.dao.qbe.FieldChk getRendimentoPerc() {
		return rendimentoPerc;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.elencom.business.dao.qbe.FieldChk dataControllo;

	/**
	 * @generated
	 */
	public void setDataControllo(it.csi.sigit.elencom.business.dao.qbe.FieldChk chk) {
		dataControllo = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.elencom.business.dao.qbe.FieldChk getDataControllo() {
		return dataControllo;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.elencom.business.dao.qbe.FieldChk eNoxPpm;

	/**
	 * @generated
	 */
	public void setENoxPpm(it.csi.sigit.elencom.business.dao.qbe.FieldChk chk) {
		eNoxPpm = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.elencom.business.dao.qbe.FieldChk getENoxPpm() {
		return eNoxPpm;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.elencom.business.dao.qbe.FieldChk eNoxMgKwh;

	/**
	 * @generated
	 */
	public void setENoxMgKwh(it.csi.sigit.elencom.business.dao.qbe.FieldChk chk) {
		eNoxMgKwh = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.elencom.business.dao.qbe.FieldChk getENoxMgKwh() {
		return eNoxMgKwh;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.elencom.business.dao.qbe.FieldChk eNModuloTermico;

	/**
	 * @generated
	 */
	public void setENModuloTermico(it.csi.sigit.elencom.business.dao.qbe.FieldChk chk) {
		eNModuloTermico = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.elencom.business.dao.qbe.FieldChk getENModuloTermico() {
		return eNModuloTermico;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.elencom.business.dao.qbe.FieldChk flgNoOpendata;

	/**
	 * @generated
	 */
	public void setFlgNoOpendata(it.csi.sigit.elencom.business.dao.qbe.FieldChk chk) {
		flgNoOpendata = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.elencom.business.dao.qbe.FieldChk getFlgNoOpendata() {
		return flgNoOpendata;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.elencom.business.dao.qbe.FieldChk indirizzoUnitaImmob;

	/**
	 * @generated
	 */
	public void setIndirizzoUnitaImmob(it.csi.sigit.elencom.business.dao.qbe.FieldChk chk) {
		indirizzoUnitaImmob = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.elencom.business.dao.qbe.FieldChk getIndirizzoUnitaImmob() {
		return indirizzoUnitaImmob;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.elencom.business.dao.qbe.FieldChk civico;

	/**
	 * @generated
	 */
	public void setCivico(it.csi.sigit.elencom.business.dao.qbe.FieldChk chk) {
		civico = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.elencom.business.dao.qbe.FieldChk getCivico() {
		return civico;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.elencom.business.dao.qbe.FieldChk sezione;

	/**
	 * @generated
	 */
	public void setSezione(it.csi.sigit.elencom.business.dao.qbe.FieldChk chk) {
		sezione = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.elencom.business.dao.qbe.FieldChk getSezione() {
		return sezione;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.elencom.business.dao.qbe.FieldChk foglio;

	/**
	 * @generated
	 */
	public void setFoglio(it.csi.sigit.elencom.business.dao.qbe.FieldChk chk) {
		foglio = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.elencom.business.dao.qbe.FieldChk getFoglio() {
		return foglio;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.elencom.business.dao.qbe.FieldChk particella;

	/**
	 * @generated
	 */
	public void setParticella(it.csi.sigit.elencom.business.dao.qbe.FieldChk chk) {
		particella = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.elencom.business.dao.qbe.FieldChk getParticella() {
		return particella;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.elencom.business.dao.qbe.FieldChk subalterno;

	/**
	 * @generated
	 */
	public void setSubalterno(it.csi.sigit.elencom.business.dao.qbe.FieldChk chk) {
		subalterno = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.elencom.business.dao.qbe.FieldChk getSubalterno() {
		return subalterno;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.elencom.business.dao.qbe.FieldChk podElettrico;

	/**
	 * @generated
	 */
	public void setPodElettrico(it.csi.sigit.elencom.business.dao.qbe.FieldChk chk) {
		podElettrico = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.elencom.business.dao.qbe.FieldChk getPodElettrico() {
		return podElettrico;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.elencom.business.dao.qbe.FieldChk pdrGas;

	/**
	 * @generated
	 */
	public void setPdrGas(it.csi.sigit.elencom.business.dao.qbe.FieldChk chk) {
		pdrGas = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.elencom.business.dao.qbe.FieldChk getPdrGas() {
		return pdrGas;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.elencom.business.dao.qbe.FieldChk eNoxMgNm3;

	/**
	 * @generated
	 */
	public void setENoxMgNm3(it.csi.sigit.elencom.business.dao.qbe.FieldChk chk) {
		eNoxMgNm3 = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.elencom.business.dao.qbe.FieldChk getENoxMgNm3() {
		return eNoxMgNm3;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.elencom.business.dao.qbe.FieldChk coordXLongDd;

	/**
	 * @generated
	 */
	public void setCoordXLongDd(it.csi.sigit.elencom.business.dao.qbe.FieldChk chk) {
		coordXLongDd = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.elencom.business.dao.qbe.FieldChk getCoordXLongDd() {
		return coordXLongDd;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.elencom.business.dao.qbe.FieldChk coordYLatDd;

	/**
	 * @generated
	 */
	public void setCoordYLatDd(it.csi.sigit.elencom.business.dao.qbe.FieldChk chk) {
		coordYLatDd = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.elencom.business.dao.qbe.FieldChk getCoordYLatDd() {
		return coordYLatDd;
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.elencom.business.dao.qbe.FieldChk flgTipoImpianto;

	/**
	 * @generated
	 */
	public void setFlgTipoImpianto(it.csi.sigit.elencom.business.dao.qbe.FieldChk chk) {
		flgTipoImpianto = chk;
	}

	/**
	 * @generated
	 */
	public it.csi.sigit.elencom.business.dao.qbe.FieldChk getFlgTipoImpianto() {
		return flgTipoImpianto;
	}

}
