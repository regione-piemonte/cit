package it.csi.sigit.sigitwebn.dto.ricerca_allegati_module;

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
 * logica di business associata alla Schermata [cpRicercaAllegati]
 */
@Validation
public class CpRicercaAllegatiModel extends BaseSessionAwareDTO {

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	////////////////////////////////////////////////////////////////////
	/// application data
	////////////////////////////////////////////////////////////////////

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoStatiAllegato'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoStatiAllegato(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoStatiAllegato", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoStatiAllegato'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> getAppDataelencoStatiAllegato() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoStatiAllegato"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoTipiDocumento'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoTipiDocumento(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoTipiDocumento", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoTipiDocumento'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> getAppDataelencoTipiDocumento() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoTipiDocumento"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataricercaAllegati'
	 * @param value
	 * @generated
	 */

	public void setAppDataricercaAllegati(it.csi.sigit.sigitwebn.dto.allegati.RicercaAllegati value) {
		getSession().put("appDataricercaAllegati", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataricercaAllegati'
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.allegati.RicercaAllegati getAppDataricercaAllegati() {
		return (it.csi.sigit.sigitwebn.dto.allegati.RicercaAllegati) (getSession().get("appDataricercaAllegati"));
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

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoSigleBollino'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoSigleBollino(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoSigleBollino", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoSigleBollino'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> getAppDataelencoSigleBollino() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoSigleBollino"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoSigleRea'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoSigleRea(java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoSigleRea", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoSigleRea'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> getAppDataelencoSigleRea() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoSigleRea"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataaggiornaElencoAllegati'
	 * @param value
	 * @generated
	 */

	public void setAppDataaggiornaElencoAllegati(java.lang.Boolean value) {
		getSession().put("appDataaggiornaElencoAllegati", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataaggiornaElencoAllegati'
	 * @generated
	 */
	public java.lang.Boolean getAppDataaggiornaElencoAllegati() {
		return (java.lang.Boolean) (getSession().get("appDataaggiornaElencoAllegati"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoAllegati'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoAllegati(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.allegati.ElencoAllegati> value) {
		getSession().put("appDataelencoAllegati", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoAllegati'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.allegati.ElencoAllegati> getAppDataelencoAllegati() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.allegati.ElencoAllegati>) (getSession()
				.get("appDataelencoAllegati"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoSiNo'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoSiNo(java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoSiNo", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoSiNo'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> getAppDataelencoSiNo() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoSiNo"));
	}

	////////////////////////////////////////////////////////////////////
	/// campi per widget semplici
	////////////////////////////////////////////////////////////////////

}
