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
 * logica di business associata alla Schermata [cpGestSubentroMassivo]
 */
@Validation
public class CpGestSubentroMassivoModel extends BaseSessionAwareDTO {

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
	 * imposta il valore dell' ApplicationData 'appDataelencoImpreseAttuali'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoImpreseAttuali(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.IdDescription> value) {
		getSession().put("appDataelencoImpreseAttuali", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoImpreseAttuali'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.IdDescription> getAppDataelencoImpreseAttuali() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.IdDescription>) (getSession()
				.get("appDataelencoImpreseAttuali"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoImpreseSubentro'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoImpreseSubentro(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.IdDescription> value) {
		getSession().put("appDataelencoImpreseSubentro", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoImpreseSubentro'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.IdDescription> getAppDataelencoImpreseSubentro() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.IdDescription>) (getSession()
				.get("appDataelencoImpreseSubentro"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataimpresaAttuale'
	 * @param value
	 * @generated
	 */

	public void setAppDataimpresaAttuale(it.csi.sigit.sigitwebn.dto.accesso.PersonaGiuridica value) {
		getSession().put("appDataimpresaAttuale", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataimpresaAttuale'
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.accesso.PersonaGiuridica getAppDataimpresaAttuale() {
		return (it.csi.sigit.sigitwebn.dto.accesso.PersonaGiuridica) (getSession().get("appDataimpresaAttuale"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataimpresaSubentro'
	 * @param value
	 * @generated
	 */

	public void setAppDataimpresaSubentro(it.csi.sigit.sigitwebn.dto.accesso.PersonaGiuridica value) {
		getSession().put("appDataimpresaSubentro", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataimpresaSubentro'
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.accesso.PersonaGiuridica getAppDataimpresaSubentro() {
		return (it.csi.sigit.sigitwebn.dto.accesso.PersonaGiuridica) (getSession().get("appDataimpresaSubentro"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataidTipoSubentro'
	 * @param value
	 * @generated
	 */

	public void setAppDataidTipoSubentro(java.lang.Integer value) {
		getSession().put("appDataidTipoSubentro", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidTipoSubentro'
	 * @generated
	 */
	public java.lang.Integer getAppDataidTipoSubentro() {
		return (java.lang.Integer) (getSession().get("appDataidTipoSubentro"));
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

	////////////////////////////////////////////////////////////////////
	/// campi per widget semplici
	////////////////////////////////////////////////////////////////////

}
