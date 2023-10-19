package it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti;

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
 * logica di business associata alla Schermata [cpRisultatoRicercaIspezioni2018]
 */
@Validation
public class CpRisultatoRicercaIspezioni2018Model extends BaseSessionAwareDTO {

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	////////////////////////////////////////////////////////////////////
	/// application data
	////////////////////////////////////////////////////////////////////

	/**
	 * imposta il valore dell' ApplicationData 'appDataElencoIspezioni2018'
	 * @param value
	 * @generated
	 */

	public void setAppDataElencoIspezioni2018(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.ispezioni.Ispezione2018> value) {
		getSession().put("appDataElencoIspezioni2018", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataElencoIspezioni2018'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.ispezioni.Ispezione2018> getAppDataElencoIspezioni2018() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.ispezioni.Ispezione2018>) (getSession()
				.get("appDataElencoIspezioni2018"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataidIspezioneSelezionato'
	 * @param value
	 * @generated
	 */

	public void setAppDataidIspezioneSelezionato(java.lang.Integer value) {
		getSession().put("appDataidIspezioneSelezionato", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidIspezioneSelezionato'
	 * @generated
	 */
	public java.lang.Integer getAppDataidIspezioneSelezionato() {
		return (java.lang.Integer) (getSession().get("appDataidIspezioneSelezionato"));
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
	 * imposta il valore dell' ApplicationData 'appDataRicercaIspezioni2018'
	 * @param value
	 * @generated
	 */

	public void setAppDataRicercaIspezioni2018(it.csi.sigit.sigitwebn.dto.ispezioni.RicercaIspezioni2018 value) {
		getSession().put("appDataRicercaIspezioni2018", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataRicercaIspezioni2018'
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.ispezioni.RicercaIspezioni2018 getAppDataRicercaIspezioni2018() {
		return (it.csi.sigit.sigitwebn.dto.ispezioni.RicercaIspezioni2018) (getSession()
				.get("appDataRicercaIspezioni2018"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoStatiIspezione'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoStatiIspezione(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.IdDescription> value) {
		getSession().put("appDataelencoStatiIspezione", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoStatiIspezione'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.IdDescription> getAppDataelencoStatiIspezione() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.IdDescription>) (getSession()
				.get("appDataelencoStatiIspezione"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataIspezione2018'
	 * @param value
	 * @generated
	 */

	public void setAppDataIspezione2018(it.csi.sigit.sigitwebn.dto.ispezioni.Ispezione2018 value) {
		getSession().put("appDataIspezione2018", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataIspezione2018'
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.ispezioni.Ispezione2018 getAppDataIspezione2018() {
		return (it.csi.sigit.sigitwebn.dto.ispezioni.Ispezione2018) (getSession().get("appDataIspezione2018"));
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
	 * imposta il valore dell' ApplicationData 'appDataidAccertamentoSelezionato'
	 * @param value
	 * @generated
	 */

	public void setAppDataidAccertamentoSelezionato(java.lang.String value) {
		getSession().put("appDataidAccertamentoSelezionato", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidAccertamentoSelezionato'
	 * @generated
	 */
	public java.lang.String getAppDataidAccertamentoSelezionato() {
		return (java.lang.String) (getSession().get("appDataidAccertamentoSelezionato"));
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
	 * imposta il valore dell' ApplicationData 'appDataaggiornaDati'
	 * @param value
	 * @generated
	 */

	public void setAppDataaggiornaDati(java.lang.Boolean value) {
		getSession().put("appDataaggiornaDati", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataaggiornaDati'
	 * @generated
	 */
	public java.lang.Boolean getAppDataaggiornaDati() {
		return (java.lang.Boolean) (getSession().get("appDataaggiornaDati"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoProvincePiemonteIstat'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoProvincePiemonteIstat(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoProvincePiemonteIstat", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoProvincePiemonteIstat'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> getAppDataelencoProvincePiemonteIstat() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoProvincePiemonteIstat"));
	}

	////////////////////////////////////////////////////////////////////
	/// campi per widget semplici
	////////////////////////////////////////////////////////////////////

}
