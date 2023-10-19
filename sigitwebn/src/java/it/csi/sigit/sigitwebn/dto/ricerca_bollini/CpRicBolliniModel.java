package it.csi.sigit.sigitwebn.dto.ricerca_bollini;

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
 * logica di business associata alla Schermata [cpRicBollini]
 */
@Validation
public class CpRicBolliniModel extends BaseSessionAwareDTO {

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	////////////////////////////////////////////////////////////////////
	/// application data
	////////////////////////////////////////////////////////////////////

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoBollini'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoBollini(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.main.RisultatoRicTransazione> value) {
		getSession().put("appDataelencoBollini", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoBollini'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.main.RisultatoRicTransazione> getAppDataelencoBollini() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.main.RisultatoRicTransazione>) (getSession()
				.get("appDataelencoBollini"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataricercaBollini'
	 * @param value
	 * @generated
	 */

	public void setAppDataricercaBollini(it.csi.sigit.sigitwebn.dto.main.RicercaTransazione value) {
		getSession().put("appDataricercaBollini", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataricercaBollini'
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.main.RicercaTransazione getAppDataricercaBollini() {
		return (it.csi.sigit.sigitwebn.dto.main.RicercaTransazione) (getSession().get("appDataricercaBollini"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoSiglaRea'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoSiglaRea(java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoSiglaRea", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoSiglaRea'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> getAppDataelencoSiglaRea() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoSiglaRea"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataaggiornaElencoBollini'
	 * @param value
	 * @generated
	 */

	public void setAppDataaggiornaElencoBollini(java.lang.Boolean value) {
		getSession().put("appDataaggiornaElencoBollini", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataaggiornaElencoBollini'
	 * @generated
	 */
	public java.lang.Boolean getAppDataaggiornaElencoBollini() {
		return (java.lang.Boolean) (getSession().get("appDataaggiornaElencoBollini"));
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
	 * imposta il valore dell' ApplicationData 'appDataelencoSiglaBollini'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoSiglaBollini(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoSiglaBollini", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoSiglaBollini'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> getAppDataelencoSiglaBollini() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoSiglaBollini"));
	}

	////////////////////////////////////////////////////////////////////
	/// campi per widget semplici
	////////////////////////////////////////////////////////////////////

}
