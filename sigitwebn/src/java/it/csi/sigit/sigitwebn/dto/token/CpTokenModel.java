package it.csi.sigit.sigitwebn.dto.token;

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
 * logica di business associata alla Schermata [cpToken]
 */
@Validation
public class CpTokenModel extends BaseSessionAwareDTO {

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
	 * imposta il valore dell' ApplicationData 'appDataimpresa'
	 * @param value
	 * @generated
	 */

	public void setAppDataimpresa(it.csi.sigit.sigitwebn.dto.accesso.PersonaGiuridica value) {
		getSession().put("appDataimpresa", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataimpresa'
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.accesso.PersonaGiuridica getAppDataimpresa() {
		return (it.csi.sigit.sigitwebn.dto.accesso.PersonaGiuridica) (getSession().get("appDataimpresa"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoUserWs'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoUserWs(java.util.ArrayList<it.csi.sigit.sigitwebn.dto.userws.UserWs> value) {
		getSession().put("appDataelencoUserWs", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoUserWs'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.userws.UserWs> getAppDataelencoUserWs() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.userws.UserWs>) (getSession()
				.get("appDataelencoUserWs"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatauserWs'
	 * @param value
	 * @generated
	 */

	public void setAppDatauserWs(it.csi.sigit.sigitwebn.dto.userws.UserWs value) {
		getSession().put("appDatauserWs", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatauserWs'
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.userws.UserWs getAppDatauserWs() {
		return (it.csi.sigit.sigitwebn.dto.userws.UserWs) (getSession().get("appDatauserWs"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataidUserWsSelected'
	 * @param value
	 * @generated
	 */

	public void setAppDataidUserWsSelected(java.lang.Integer value) {
		getSession().put("appDataidUserWsSelected", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidUserWsSelected'
	 * @generated
	 */
	public java.lang.Integer getAppDataidUserWsSelected() {
		return (java.lang.Integer) (getSession().get("appDataidUserWsSelected"));
	}

	////////////////////////////////////////////////////////////////////
	/// campi per widget semplici
	////////////////////////////////////////////////////////////////////

}
