package it.csi.sigit.sigitwebn.dto.seleziona_ruolo;

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
 * logica di business associata alla Schermata [cpSelezRuolo]
 */
@Validation
public class CpSelezRuoloModel extends BaseSessionAwareDTO {

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	////////////////////////////////////////////////////////////////////
	/// application data
	////////////////////////////////////////////////////////////////////

	/**
	 * imposta il valore dell' ApplicationData 'appDatacurrentUser'
	 * @param value
	 * @generated
	 */

	public void setAppDatacurrentUser(it.csi.sigit.sigitwebn.dto.common.UserInfo value) {
		getSession().put("appDatacurrentUser", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatacurrentUser'
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.common.UserInfo getAppDatacurrentUser() {
		return (it.csi.sigit.sigitwebn.dto.common.UserInfo) (getSession().get("appDatacurrentUser"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataruoliTrovati'
	 * @param value
	 * @generated
	 */

	public void setAppDataruoliTrovati(java.util.ArrayList<it.csi.sigit.sigitwebn.dto.accesso.Ruolo> value) {
		getSession().put("appDataruoliTrovati", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataruoliTrovati'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.accesso.Ruolo> getAppDataruoliTrovati() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.accesso.Ruolo>) (getSession()
				.get("appDataruoliTrovati"));
	}

	/**
	 * @generated
	 */
	private java.lang.String appDataidRuoloSelez = null;

	/**
	 * imposta il valore dell' ApplicationData 'appDataidRuoloSelez'
	 * @param value
	 * @generated
	 */

	public void setAppDataidRuoloSelez(java.lang.String value) {
		appDataidRuoloSelez = value;
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidRuoloSelez'
	 * @generated
	 */
	public java.lang.String getAppDataidRuoloSelez() {
		return appDataidRuoloSelez;
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
	 * imposta il valore dell' ApplicationData 'appDatafiltroRuoloSelez'
	 * @param value
	 * @generated
	 */

	public void setAppDatafiltroRuoloSelez(java.lang.String value) {
		getSession().put("appDatafiltroRuoloSelez", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatafiltroRuoloSelez'
	 * @generated
	 */
	public java.lang.String getAppDatafiltroRuoloSelez() {
		return (java.lang.String) (getSession().get("appDatafiltroRuoloSelez"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataruoliFiltro'
	 * @param value
	 * @generated
	 */

	public void setAppDataruoliFiltro(java.util.ArrayList<it.csi.sigit.sigitwebn.dto.accesso.Ruolo> value) {
		getSession().put("appDataruoliFiltro", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataruoliFiltro'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.accesso.Ruolo> getAppDataruoliFiltro() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.accesso.Ruolo>) (getSession().get("appDataruoliFiltro"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataruoliTrovatiFiltrati'
	 * @param value
	 * @generated
	 */

	public void setAppDataruoliTrovatiFiltrati(java.util.ArrayList<it.csi.sigit.sigitwebn.dto.accesso.Ruolo> value) {
		getSession().put("appDataruoliTrovatiFiltrati", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataruoliTrovatiFiltrati'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.accesso.Ruolo> getAppDataruoliTrovatiFiltrati() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.accesso.Ruolo>) (getSession()
				.get("appDataruoliTrovatiFiltrati"));
	}

	////////////////////////////////////////////////////////////////////
	/// campi per widget semplici
	////////////////////////////////////////////////////////////////////

}
