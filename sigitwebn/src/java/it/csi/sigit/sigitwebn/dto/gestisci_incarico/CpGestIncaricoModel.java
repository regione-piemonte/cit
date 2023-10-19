package it.csi.sigit.sigitwebn.dto.gestisci_incarico;

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
 * logica di business associata alla Schermata [cpGestIncarico]
 */
@Validation
public class CpGestIncaricoModel extends BaseSessionAwareDTO {

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	////////////////////////////////////////////////////////////////////
	/// application data
	////////////////////////////////////////////////////////////////////

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
	 * imposta il valore dell' ApplicationData 'appDataelencoCat'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoCat(java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoCat", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoCat'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> getAppDataelencoCat() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoCat"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoIncaricatiAssociati'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoIncaricatiAssociati(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.incarico.Incaricato> value) {
		getSession().put("appDataelencoIncaricatiAssociati", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoIncaricatiAssociati'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.incarico.Incaricato> getAppDataelencoIncaricatiAssociati() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.incarico.Incaricato>) (getSession()
				.get("appDataelencoIncaricatiAssociati"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataidIncaricatoAssociatoSelez'
	 * @param value
	 * @generated
	 */

	public void setAppDataidIncaricatoAssociatoSelez(java.lang.String value) {
		getSession().put("appDataidIncaricatoAssociatoSelez", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidIncaricatoAssociatoSelez'
	 * @generated
	 */
	public java.lang.String getAppDataidIncaricatoAssociatoSelez() {
		return (java.lang.String) (getSession().get("appDataidIncaricatoAssociatoSelez"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataincaricato'
	 * @param value
	 * @generated
	 */

	public void setAppDataincaricato(it.csi.sigit.sigitwebn.dto.incarico.Incaricato value) {
		getSession().put("appDataincaricato", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataincaricato'
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.incarico.Incaricato getAppDataincaricato() {
		return (it.csi.sigit.sigitwebn.dto.incarico.Incaricato) (getSession().get("appDataincaricato"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataincarico'
	 * @param value
	 * @generated
	 */

	public void setAppDataincarico(it.csi.sigit.sigitwebn.dto.incarico.Incarico value) {
		getSession().put("appDataincarico", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataincarico'
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.incarico.Incarico getAppDataincarico() {
		return (it.csi.sigit.sigitwebn.dto.incarico.Incarico) (getSession().get("appDataincarico"));
	}

	////////////////////////////////////////////////////////////////////
	/// campi per widget semplici
	////////////////////////////////////////////////////////////////////

}
