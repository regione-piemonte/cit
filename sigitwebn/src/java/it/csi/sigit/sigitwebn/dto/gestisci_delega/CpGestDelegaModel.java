package it.csi.sigit.sigitwebn.dto.gestisci_delega;

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
 * logica di business associata alla Schermata [cpGestDelega]
 */
@Validation
public class CpGestDelegaModel extends BaseSessionAwareDTO {

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	////////////////////////////////////////////////////////////////////
	/// application data
	////////////////////////////////////////////////////////////////////

	/**
	 * imposta il valore dell' ApplicationData 'appDatadelega'
	 * @param value
	 * @generated
	 */

	public void setAppDatadelega(it.csi.sigit.sigitwebn.dto.delega.Delega value) {
		getSession().put("appDatadelega", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatadelega'
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.delega.Delega getAppDatadelega() {
		return (it.csi.sigit.sigitwebn.dto.delega.Delega) (getSession().get("appDatadelega"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatadelegato'
	 * @param value
	 * @generated
	 */

	public void setAppDatadelegato(it.csi.sigit.sigitwebn.dto.delega.Delegato value) {
		getSession().put("appDatadelegato", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatadelegato'
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.delega.Delegato getAppDatadelegato() {
		return (it.csi.sigit.sigitwebn.dto.delega.Delegato) (getSession().get("appDatadelegato"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoDelegatiAssociati'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoDelegatiAssociati(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.delega.Delegato> value) {
		getSession().put("appDataelencoDelegatiAssociati", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoDelegatiAssociati'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.delega.Delegato> getAppDataelencoDelegatiAssociati() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.delega.Delegato>) (getSession()
				.get("appDataelencoDelegatiAssociati"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoDelegatiPotenziali'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoDelegatiPotenziali(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.delega.Delegato> value) {
		getSession().put("appDataelencoDelegatiPotenziali", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoDelegatiPotenziali'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.delega.Delegato> getAppDataelencoDelegatiPotenziali() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.delega.Delegato>) (getSession()
				.get("appDataelencoDelegatiPotenziali"));
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
	 * imposta il valore dell' ApplicationData 'appDataidDelegatoAssociatoSelez'
	 * @param value
	 * @generated
	 */

	public void setAppDataidDelegatoAssociatoSelez(java.lang.String value) {
		getSession().put("appDataidDelegatoAssociatoSelez", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidDelegatoAssociatoSelez'
	 * @generated
	 */
	public java.lang.String getAppDataidDelegatoAssociatoSelez() {
		return (java.lang.String) (getSession().get("appDataidDelegatoAssociatoSelez"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataidDelegatoPotenzialeSelez'
	 * @param value
	 * @generated
	 */

	public void setAppDataidDelegatoPotenzialeSelez(java.lang.Integer value) {
		getSession().put("appDataidDelegatoPotenzialeSelez", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidDelegatoPotenzialeSelez'
	 * @generated
	 */
	public java.lang.Integer getAppDataidDelegatoPotenzialeSelez() {
		return (java.lang.Integer) (getSession().get("appDataidDelegatoPotenzialeSelez"));
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
