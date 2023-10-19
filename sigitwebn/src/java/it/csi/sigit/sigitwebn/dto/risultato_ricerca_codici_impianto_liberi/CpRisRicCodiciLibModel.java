package it.csi.sigit.sigitwebn.dto.risultato_ricerca_codici_impianto_liberi;

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
 * logica di business associata alla Schermata [cpRisRicCodiciLib]
 */
@Validation
public class CpRisRicCodiciLibModel extends BaseSessionAwareDTO {

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	////////////////////////////////////////////////////////////////////
	/// application data
	////////////////////////////////////////////////////////////////////

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoCodImpianto'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoCodImpianto(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.main.RisultatoRicTransazione> value) {
		getSession().put("appDataelencoCodImpianto", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoCodImpianto'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.main.RisultatoRicTransazione> getAppDataelencoCodImpianto() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.main.RisultatoRicTransazione>) (getSession()
				.get("appDataelencoCodImpianto"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataricercaCodImpianto'
	 * @param value
	 * @generated
	 */

	public void setAppDataricercaCodImpianto(it.csi.sigit.sigitwebn.dto.main.RicercaTransazione value) {
		getSession().put("appDataricercaCodImpianto", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataricercaCodImpianto'
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.main.RicercaTransazione getAppDataricercaCodImpianto() {
		return (it.csi.sigit.sigitwebn.dto.main.RicercaTransazione) (getSession().get("appDataricercaCodImpianto"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataidCodImpiantoSelez'
	 * @param value
	 * @generated
	 */

	public void setAppDataidCodImpiantoSelez(java.lang.String value) {
		getSession().put("appDataidCodImpiantoSelez", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidCodImpiantoSelez'
	 * @generated
	 */
	public java.lang.String getAppDataidCodImpiantoSelez() {
		return (java.lang.String) (getSession().get("appDataidCodImpiantoSelez"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataaggiornaElencoCodImpianto'
	 * @param value
	 * @generated
	 */

	public void setAppDataaggiornaElencoCodImpianto(java.lang.Boolean value) {
		getSession().put("appDataaggiornaElencoCodImpianto", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataaggiornaElencoCodImpianto'
	 * @generated
	 */
	public java.lang.Boolean getAppDataaggiornaElencoCodImpianto() {
		return (java.lang.Boolean) (getSession().get("appDataaggiornaElencoCodImpianto"));
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
	 * imposta il valore dell' ApplicationData 'appDataelencoCodImpiantoLiberi'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoCodImpiantoLiberi(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.codici_impianto.RisultatoRicCodImpiantoLib> value) {
		getSession().put("appDataelencoCodImpiantoLiberi", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoCodImpiantoLiberi'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.codici_impianto.RisultatoRicCodImpiantoLib> getAppDataelencoCodImpiantoLiberi() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.codici_impianto.RisultatoRicCodImpiantoLib>) (getSession()
				.get("appDataelencoCodImpiantoLiberi"));
	}

	////////////////////////////////////////////////////////////////////
	/// campi per widget semplici
	////////////////////////////////////////////////////////////////////

	// Table tbRisultatoRicCodiciLib

	private java.lang.String widgTbRisultatoRicCodiciLib;

	public void setWidg_tbRisultatoRicCodiciLib(java.lang.String value) {
		widgTbRisultatoRicCodiciLib = value;
	}

	public java.lang.String getWidg_tbRisultatoRicCodiciLib() {
		return widgTbRisultatoRicCodiciLib;
	}

}
