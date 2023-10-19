package it.csi.sigit.sigitwebn.dto.gestisci_sanzioni;

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
 * logica di business associata alla Schermata [cpInserisciNotificaSanzione]
 */
@Validation
public class CpInserisciNotificaSanzioneModel extends BaseSessionAwareDTO {

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
	 * imposta il valore dell' ApplicationData 'appDatadatiInserimentoSanzione'
	 * @param value
	 * @generated
	 */

	public void setAppDatadatiInserimentoSanzione(it.csi.sigit.sigitwebn.dto.sanzioni.DatiInserimentoSanzione value) {
		getSession().put("appDatadatiInserimentoSanzione", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatadatiInserimentoSanzione'
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.sanzioni.DatiInserimentoSanzione getAppDatadatiInserimentoSanzione() {
		return (it.csi.sigit.sigitwebn.dto.sanzioni.DatiInserimentoSanzione) (getSession()
				.get("appDatadatiInserimentoSanzione"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoComuni'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoComuni(java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoComuni", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoComuni'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> getAppDataelencoComuni() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoComuni"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoProvince'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoProvince(java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoProvince", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoProvince'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> getAppDataelencoProvince() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoProvince"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoIndirizziSanzionato'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoIndirizziSanzionato(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoIndirizziSanzionato", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoIndirizziSanzionato'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> getAppDataelencoIndirizziSanzionato() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoIndirizziSanzionato"));
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
	 * imposta il valore dell' ApplicationData 'appDataidSanzionatoScelto'
	 * @param value
	 * @generated
	 */

	public void setAppDataidSanzionatoScelto(java.lang.Integer value) {
		getSession().put("appDataidSanzionatoScelto", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidSanzionatoScelto'
	 * @generated
	 */
	public java.lang.Integer getAppDataidSanzionatoScelto() {
		return (java.lang.Integer) (getSession().get("appDataidSanzionatoScelto"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoCandidatiSanzionati'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoCandidatiSanzionati(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.sanzioni.CandidatoSanzionato> value) {
		getSession().put("appDataelencoCandidatiSanzionati", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoCandidatiSanzionati'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.sanzioni.CandidatoSanzionato> getAppDataelencoCandidatiSanzionati() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.sanzioni.CandidatoSanzionato>) (getSession()
				.get("appDataelencoCandidatiSanzionati"));
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
