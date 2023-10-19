package it.csi.sigit.sigitwebn.dto.gestisci_azioni;

import java.util.*;
import it.csi.sigit.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.dto.accesso.*;
import it.csi.sigit.sigitwebn.dto.codici_impianto.*;
import it.csi.sigit.sigitwebn.dto.common.*;
import it.csi.sigit.sigitwebn.dto.impianto.*;
import it.csi.sigit.sigitwebn.dto.main.*;
import it.csi.sigit.sigitwebn.dto.bollini.*;
import it.csi.sigit.sigitwebn.dto.allegati.*;
import it.csi.sigit.sigitwebn.dto.subentro.*;
import it.csi.sigit.sigitwebn.dto.delega.*;
import it.csi.sigit.sigitwebn.dto.terzoresponsabile.*;
import it.csi.sigit.sigitwebn.dto.ispezioni.*;
import it.csi.sigit.sigitwebn.dto.distributori.*;
import it.csi.sigit.sigitwebn.dto.incarico.*;
import it.csi.sigit.sigitwebn.dto.impresa.*;
import it.csi.sigit.sigitwebn.dto.documentazione.*;
import it.csi.sigit.sigitwebn.dto.libretto.*;
import it.csi.sigit.sigitwebn.dto.ree.*;
import it.csi.sigit.sigitwebn.dto.verifica.*;
import it.csi.sigit.sigitwebn.dto.accertamento.*;
import it.csi.sigit.sigitwebn.dto.azioni.*;
import it.csi.sigit.sigitwebn.dto.sanzioni.*;
import it.csi.sigit.sigitwebn.dto.rappprova.*;
import it.csi.sigit.sigitwebn.dto.back_office.*;
import it.csi.sigit.sigitwebn.dto.userws.*;

import it.csi.sigit.sigitwebn.presentation.uiutils.*;
import flexjson.JSON;
import com.opensymphony.xwork2.conversion.annotations.*;
import com.opensymphony.xwork2.validator.annotations.*;

/**
 * Questo DTO incapsula tutto il contenuto informativo necessario all'esecuzione della
 * logica di business associata alla Schermata [cpElencoSveglie]
 */
@Validation
public class CpElencoSveglieModel extends BaseSessionAwareDTO {

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	////////////////////////////////////////////////////////////////////
	/// application data
	////////////////////////////////////////////////////////////////////

	/**
	 * imposta il valore dell' ApplicationData 'appDatautenteLoggato'
	 * @param value
	 * @generated
	 */

	public void setAppDatautenteLoggato(it.csi.sigit.sigitwebn.dto.main.UtenteLoggato value) {
		getSession().put("appDatautenteLoggato", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatautenteLoggato'
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.main.UtenteLoggato getAppDatautenteLoggato() {
		return (it.csi.sigit.sigitwebn.dto.main.UtenteLoggato) (getSession().get("appDatautenteLoggato"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataricercaSveglie'
	 * @param value
	 * @generated
	 */

	public void setAppDataricercaSveglie(it.csi.sigit.sigitwebn.dto.azioni.RicercaSveglie value) {
		getSession().put("appDataricercaSveglie", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataricercaSveglie'
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.azioni.RicercaSveglie getAppDataricercaSveglie() {
		return (it.csi.sigit.sigitwebn.dto.azioni.RicercaSveglie) (getSession().get("appDataricercaSveglie"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoSveglieAccertamento'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoSveglieAccertamento(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.azioni.Sveglia> value) {
		getSession().put("appDataelencoSveglieAccertamento", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoSveglieAccertamento'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.azioni.Sveglia> getAppDataelencoSveglieAccertamento() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.azioni.Sveglia>) (getSession()
				.get("appDataelencoSveglieAccertamento"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoSveglieAccertamentoNonAss'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoSveglieAccertamentoNonAss(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.azioni.Sveglia> value) {
		getSession().put("appDataelencoSveglieAccertamentoNonAss", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoSveglieAccertamentoNonAss'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.azioni.Sveglia> getAppDataelencoSveglieAccertamentoNonAss() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.azioni.Sveglia>) (getSession()
				.get("appDataelencoSveglieAccertamentoNonAss"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoSveglieIspezione'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoSveglieIspezione(java.util.ArrayList<it.csi.sigit.sigitwebn.dto.azioni.Sveglia> value) {
		getSession().put("appDataelencoSveglieIspezione", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoSveglieIspezione'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.azioni.Sveglia> getAppDataelencoSveglieIspezione() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.azioni.Sveglia>) (getSession()
				.get("appDataelencoSveglieIspezione"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoSveglieIspezioneNonAss'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoSveglieIspezioneNonAss(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.azioni.Sveglia> value) {
		getSession().put("appDataelencoSveglieIspezioneNonAss", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoSveglieIspezioneNonAss'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.azioni.Sveglia> getAppDataelencoSveglieIspezioneNonAss() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.azioni.Sveglia>) (getSession()
				.get("appDataelencoSveglieIspezioneNonAss"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoSveglieSanzione'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoSveglieSanzione(java.util.ArrayList<it.csi.sigit.sigitwebn.dto.azioni.Sveglia> value) {
		getSession().put("appDataelencoSveglieSanzione", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoSveglieSanzione'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.azioni.Sveglia> getAppDataelencoSveglieSanzione() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.azioni.Sveglia>) (getSession()
				.get("appDataelencoSveglieSanzione"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoSveglieVerifica'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoSveglieVerifica(java.util.ArrayList<it.csi.sigit.sigitwebn.dto.azioni.Sveglia> value) {
		getSession().put("appDataelencoSveglieVerifica", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoSveglieVerifica'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.azioni.Sveglia> getAppDataelencoSveglieVerifica() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.azioni.Sveglia>) (getSession()
				.get("appDataelencoSveglieVerifica"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataidAccertamentoSelezionato'
	 * @param value
	 * @generated
	 */

	public void setAppDataidAccertamentoSelezionato(java.lang.String value) {
		getSession().put("appDataidAccertamentoSelezionato", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidAccertamentoSelezionato'
	 * @generated
	 */
	public java.lang.String getAppDataidAccertamentoSelezionato() {
		return (java.lang.String) (getSession().get("appDataidAccertamentoSelezionato"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataidVerificaSelezionata'
	 * @param value
	 * @generated
	 */

	public void setAppDataidVerificaSelezionata(java.lang.String value) {
		getSession().put("appDataidVerificaSelezionata", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidVerificaSelezionata'
	 * @generated
	 */
	public java.lang.String getAppDataidVerificaSelezionata() {
		return (java.lang.String) (getSession().get("appDataidVerificaSelezionata"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataidIspezioneSelezionato'
	 * @param value
	 * @generated
	 */

	public void setAppDataidIspezioneSelezionato(java.lang.Integer value) {
		getSession().put("appDataidIspezioneSelezionato", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidIspezioneSelezionato'
	 * @generated
	 */
	public java.lang.Integer getAppDataidIspezioneSelezionato() {
		return (java.lang.Integer) (getSession().get("appDataidIspezioneSelezionato"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataidSanzioneSelezionata'
	 * @param value
	 * @generated
	 */

	public void setAppDataidSanzioneSelezionata(java.lang.Integer value) {
		getSession().put("appDataidSanzioneSelezionata", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidSanzioneSelezionata'
	 * @generated
	 */
	public java.lang.Integer getAppDataidSanzioneSelezionata() {
		return (java.lang.Integer) (getSession().get("appDataidSanzioneSelezionata"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataidAccertamentoNonAssSelezionato'
	 * @param value
	 * @generated
	 */

	public void setAppDataidAccertamentoNonAssSelezionato(java.lang.String value) {
		getSession().put("appDataidAccertamentoNonAssSelezionato", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidAccertamentoNonAssSelezionato'
	 * @generated
	 */
	public java.lang.String getAppDataidAccertamentoNonAssSelezionato() {
		return (java.lang.String) (getSession().get("appDataidAccertamentoNonAssSelezionato"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataidIspezioneNonAssSelezionato'
	 * @param value
	 * @generated
	 */

	public void setAppDataidIspezioneNonAssSelezionato(java.lang.Integer value) {
		getSession().put("appDataidIspezioneNonAssSelezionato", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidIspezioneNonAssSelezionato'
	 * @generated
	 */
	public java.lang.Integer getAppDataidIspezioneNonAssSelezionato() {
		return (java.lang.Integer) (getSession().get("appDataidIspezioneNonAssSelezionato"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataidAccertamentoAssSelezionato'
	 * @param value
	 * @generated
	 */

	public void setAppDataidAccertamentoAssSelezionato(java.lang.String value) {
		getSession().put("appDataidAccertamentoAssSelezionato", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidAccertamentoAssSelezionato'
	 * @generated
	 */
	public java.lang.String getAppDataidAccertamentoAssSelezionato() {
		return (java.lang.String) (getSession().get("appDataidAccertamentoAssSelezionato"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatapaginaChiamante'
	 * @param value
	 * @generated
	 */

	public void setAppDatapaginaChiamante(java.lang.String value) {
		getSession().put("appDatapaginaChiamante", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatapaginaChiamante'
	 * @generated
	 */
	public java.lang.String getAppDatapaginaChiamante() {
		return (java.lang.String) (getSession().get("appDatapaginaChiamante"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataIspezione2018'
	 * @param value
	 * @generated
	 */

	public void setAppDataIspezione2018(it.csi.sigit.sigitwebn.dto.ispezioni.Ispezione2018 value) {
		getSession().put("appDataIspezione2018", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataIspezione2018'
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.ispezioni.Ispezione2018 getAppDataIspezione2018() {
		return (it.csi.sigit.sigitwebn.dto.ispezioni.Ispezione2018) (getSession().get("appDataIspezione2018"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatapaginaChiamanteDettaglioSanzione'
	 * @param value
	 * @generated
	 */

	public void setAppDatapaginaChiamanteDettaglioSanzione(java.lang.String value) {
		getSession().put("appDatapaginaChiamanteDettaglioSanzione", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatapaginaChiamanteDettaglioSanzione'
	 * @generated
	 */
	public java.lang.String getAppDatapaginaChiamanteDettaglioSanzione() {
		return (java.lang.String) (getSession().get("appDatapaginaChiamanteDettaglioSanzione"));
	}

	////////////////////////////////////////////////////////////////////
	/// campi per widget semplici
	////////////////////////////////////////////////////////////////////

}
