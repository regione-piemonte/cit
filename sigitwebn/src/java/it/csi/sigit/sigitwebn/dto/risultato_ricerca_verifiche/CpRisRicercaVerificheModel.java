package it.csi.sigit.sigitwebn.dto.risultato_ricerca_verifiche;

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
 * logica di business associata alla Schermata [cpRisRicercaVerifiche]
 */
@Validation
public class CpRisRicercaVerificheModel extends BaseSessionAwareDTO {

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	////////////////////////////////////////////////////////////////////
	/// application data
	////////////////////////////////////////////////////////////////////

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoVerifiche'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoVerifiche(java.util.ArrayList<it.csi.sigit.sigitwebn.dto.verifica.Verifica> value) {
		getSession().put("appDataelencoVerifiche", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoVerifiche'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.verifica.Verifica> getAppDataelencoVerifiche() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.verifica.Verifica>) (getSession()
				.get("appDataelencoVerifiche"));
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
	 * imposta il valore dell' ApplicationData 'appDataelencoTipiVerifica'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoTipiVerifica(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.IdDescription> value) {
		getSession().put("appDataelencoTipiVerifica", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoTipiVerifica'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.IdDescription> getAppDataelencoTipiVerifica() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.IdDescription>) (getSession()
				.get("appDataelencoTipiVerifica"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataricercaVerifica'
	 * @param value
	 * @generated
	 */
	@VisitorFieldValidator(message = "", key = "cpRisRicercaVerifiche.ricercaVerifica.visitorvalidator.label", appendPrefix = true)
	public void setAppDataricercaVerifica(it.csi.sigit.sigitwebn.dto.verifica.RicercaVerifica value) {
		getSession().put("appDataricercaVerifica", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataricercaVerifica'
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.verifica.RicercaVerifica getAppDataricercaVerifica() {
		return (it.csi.sigit.sigitwebn.dto.verifica.RicercaVerifica) (getSession().get("appDataricercaVerifica"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoValidatoriVerifica'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoValidatoriVerifica(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoValidatoriVerifica", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoValidatoriVerifica'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> getAppDataelencoValidatoriVerifica() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoValidatoriVerifica"));
	}

	////////////////////////////////////////////////////////////////////
	/// campi per widget semplici
	////////////////////////////////////////////////////////////////////

}
