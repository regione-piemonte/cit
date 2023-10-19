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
 * logica di business associata alla Schermata [cpBackOffice]
 */
@Validation
public class CpBackOfficeModel extends BaseSessionAwareDTO {

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
	 * imposta il valore dell' ApplicationData 'appDataelencoCodImpianto'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoCodImpianto(java.lang.String value) {
		getSession().put("appDataelencoCodImpianto", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoCodImpianto'
	 * @generated
	 */
	public java.lang.String getAppDataelencoCodImpianto() {
		return (java.lang.String) (getSession().get("appDataelencoCodImpianto"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatariepilogoStoricizzazione'
	 * @param value
	 * @generated
	 */

	public void setAppDatariepilogoStoricizzazione(
			it.csi.sigit.sigitwebn.dto.back_office.RiepilogoStoricizzazione value) {
		getSession().put("appDatariepilogoStoricizzazione", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatariepilogoStoricizzazione'
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.back_office.RiepilogoStoricizzazione getAppDatariepilogoStoricizzazione() {
		return (it.csi.sigit.sigitwebn.dto.back_office.RiepilogoStoricizzazione) (getSession()
				.get("appDatariepilogoStoricizzazione"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatacountImpiantiAggiornatiADataAggiornaCoord'
	 * @param value
	 * @generated
	 */

	public void setAppDatacountImpiantiAggiornatiADataAggiornaCoord(java.lang.String value) {
		getSession().put("appDatacountImpiantiAggiornatiADataAggiornaCoord", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatacountImpiantiAggiornatiADataAggiornaCoord'
	 * @generated
	 */
	public java.lang.String getAppDatacountImpiantiAggiornatiADataAggiornaCoord() {
		return (java.lang.String) (getSession().get("appDatacountImpiantiAggiornatiADataAggiornaCoord"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatacountImpiantiSenzaCoordinate'
	 * @param value
	 * @generated
	 */

	public void setAppDatacountImpiantiSenzaCoordinate(java.lang.Integer value) {
		getSession().put("appDatacountImpiantiSenzaCoordinate", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatacountImpiantiSenzaCoordinate'
	 * @generated
	 */
	public java.lang.Integer getAppDatacountImpiantiSenzaCoordinate() {
		return (java.lang.Integer) (getSession().get("appDatacountImpiantiSenzaCoordinate"));
	}

	////////////////////////////////////////////////////////////////////
	/// campi per widget semplici
	////////////////////////////////////////////////////////////////////

}
