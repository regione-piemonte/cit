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
 * logica di business associata alla Schermata [cpElencoAbilitazioni]
 */
@Validation
public class CpElencoAbilitazioniModel extends BaseSessionAwareDTO {

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
	 * imposta il valore dell' ApplicationData 'appDatalistaAbilitazioni'
	 * @param value
	 * @generated
	 */

	public void setAppDatalistaAbilitazioni(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.back_office.Abilitazione> value) {
		getSession().put("appDatalistaAbilitazioni", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatalistaAbilitazioni'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.back_office.Abilitazione> getAppDatalistaAbilitazioni() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.back_office.Abilitazione>) (getSession()
				.get("appDatalistaAbilitazioni"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataricercaAbilitazione'
	 * @param value
	 * @generated
	 */

	public void setAppDataricercaAbilitazione(it.csi.sigit.sigitwebn.dto.back_office.Abilitazione value) {
		getSession().put("appDataricercaAbilitazione", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataricercaAbilitazione'
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.back_office.Abilitazione getAppDataricercaAbilitazione() {
		return (it.csi.sigit.sigitwebn.dto.back_office.Abilitazione) (getSession().get("appDataricercaAbilitazione"));
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
	 * imposta il valore dell' ApplicationData 'appDataidAbilitazioneSelez'
	 * @param value
	 * @generated
	 */

	public void setAppDataidAbilitazioneSelez(java.lang.Integer value) {
		getSession().put("appDataidAbilitazioneSelez", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidAbilitazioneSelez'
	 * @generated
	 */
	public java.lang.Integer getAppDataidAbilitazioneSelez() {
		return (java.lang.Integer) (getSession().get("appDataidAbilitazioneSelez"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatanewMail'
	 * @param value
	 * @generated
	 */

	public void setAppDatanewMail(java.lang.String value) {
		getSession().put("appDatanewMail", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatanewMail'
	 * @generated
	 */
	public java.lang.String getAppDatanewMail() {
		return (java.lang.String) (getSession().get("appDatanewMail"));
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

	////////////////////////////////////////////////////////////////////
	/// campi per widget semplici
	////////////////////////////////////////////////////////////////////

}
