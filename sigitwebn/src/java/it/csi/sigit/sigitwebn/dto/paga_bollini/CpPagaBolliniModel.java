package it.csi.sigit.sigitwebn.dto.paga_bollini;

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
 * logica di business associata alla Schermata [cpPagaBollini]
 */
@Validation
public class CpPagaBolliniModel extends BaseSessionAwareDTO {

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	////////////////////////////////////////////////////////////////////
	/// application data
	////////////////////////////////////////////////////////////////////

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoGestoriPagamento'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoGestoriPagamento(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoGestoriPagamento", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoGestoriPagamento'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> getAppDataelencoGestoriPagamento() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoGestoriPagamento"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatadatiPagamento'
	 * @param value
	 * @generated
	 */

	public void setAppDatadatiPagamento(it.csi.sigit.sigitwebn.dto.bollini.DatiPagamento value) {
		getSession().put("appDatadatiPagamento", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatadatiPagamento'
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.bollini.DatiPagamento getAppDatadatiPagamento() {
		return (it.csi.sigit.sigitwebn.dto.bollini.DatiPagamento) (getSession().get("appDatadatiPagamento"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatamdpURL'
	 * @param value
	 * @generated
	 */

	public void setAppDatamdpURL(java.lang.String value) {
		getSession().put("appDatamdpURL", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatamdpURL'
	 * @generated
	 */
	public java.lang.String getAppDatamdpURL() {
		return (java.lang.String) (getSession().get("appDatamdpURL"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatatransazioneApp'
	 * @param value
	 * @generated
	 */

	public void setAppDatatransazioneApp(it.csi.sigit.sigitwebn.dto.bollini.TransazioneApp value) {
		getSession().put("appDatatransazioneApp", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatatransazioneApp'
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.bollini.TransazioneApp getAppDatatransazioneApp() {
		return (it.csi.sigit.sigitwebn.dto.bollini.TransazioneApp) (getSession().get("appDatatransazioneApp"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataacquistaBollini'
	 * @param value
	 * @generated
	 */

	public void setAppDataacquistaBollini(it.csi.sigit.sigitwebn.dto.bollini.AcquistoBollini value) {
		getSession().put("appDataacquistaBollini", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataacquistaBollini'
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.bollini.AcquistoBollini getAppDataacquistaBollini() {
		return (it.csi.sigit.sigitwebn.dto.bollini.AcquistoBollini) (getSession().get("appDataacquistaBollini"));
	}

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

	////////////////////////////////////////////////////////////////////
	/// campi per widget semplici
	////////////////////////////////////////////////////////////////////

}
