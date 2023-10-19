package it.csi.sigit.sigitwebn.dto.back_office;

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
 * logica di business associata alla Schermata [cpGestAbilitazione]
 */
@Validation
public class CpGestAbilitazioneModel extends BaseSessionAwareDTO {

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
	 * imposta il valore dell' ApplicationData 'appDataelencoIstatAbilitazioni'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoIstatAbilitazioni(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoIstatAbilitazioni", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoIstatAbilitazioni'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> getAppDataelencoIstatAbilitazioni() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoIstatAbilitazioni"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoRuolo'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoRuolo(java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.IdDescription> value) {
		getSession().put("appDataelencoRuolo", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoRuolo'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.IdDescription> getAppDataelencoRuolo() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.IdDescription>) (getSession()
				.get("appDataelencoRuolo"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataabilitazione'
	 * @param value
	 * @generated
	 */

	public void setAppDataabilitazione(it.csi.sigit.sigitwebn.dto.back_office.Abilitazione value) {
		getSession().put("appDataabilitazione", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataabilitazione'
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.back_office.Abilitazione getAppDataabilitazione() {
		return (it.csi.sigit.sigitwebn.dto.back_office.Abilitazione) (getSession().get("appDataabilitazione"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoUtentiPaTrovati'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoUtentiPaTrovati(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoUtentiPaTrovati", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoUtentiPaTrovati'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> getAppDataelencoUtentiPaTrovati() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoUtentiPaTrovati"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatamessaggioDinamico'
	 * @param value
	 * @generated
	 */

	public void setAppDatamessaggioDinamico(java.lang.String value) {
		getSession().put("appDatamessaggioDinamico", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatamessaggioDinamico'
	 * @generated
	 */
	public java.lang.String getAppDatamessaggioDinamico() {
		return (java.lang.String) (getSession().get("appDatamessaggioDinamico"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoUtentiPa'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoUtentiPa(java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoUtentiPa", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoUtentiPa'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> getAppDataelencoUtentiPa() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoUtentiPa"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatacomuniAbilitazione'
	 * @param value
	 * @generated
	 */

	public void setAppDatacomuniAbilitazione(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> value) {
		getSession().put("appDatacomuniAbilitazione", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatacomuniAbilitazione'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> getAppDatacomuniAbilitazione() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription>) (getSession()
				.get("appDatacomuniAbilitazione"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataprovinceAbilitazione'
	 * @param value
	 * @generated
	 */

	public void setAppDataprovinceAbilitazione(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> value) {
		getSession().put("appDataprovinceAbilitazione", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataprovinceAbilitazione'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> getAppDataprovinceAbilitazione() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription>) (getSession()
				.get("appDataprovinceAbilitazione"));
	}

	/**
	 * @generated
	 */
	private java.lang.String appDataprovinciaAbilitazioneSelez = null;

	/**
	 * imposta il valore dell' ApplicationData 'appDataprovinciaAbilitazioneSelez'
	 * @param value
	 * @generated
	 */

	public void setAppDataprovinciaAbilitazioneSelez(java.lang.String value) {
		appDataprovinciaAbilitazioneSelez = value;
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataprovinciaAbilitazioneSelez'
	 * @generated
	 */
	public java.lang.String getAppDataprovinciaAbilitazioneSelez() {
		return appDataprovinciaAbilitazioneSelez;
	}

	////////////////////////////////////////////////////////////////////
	/// campi per widget semplici
	////////////////////////////////////////////////////////////////////

}
