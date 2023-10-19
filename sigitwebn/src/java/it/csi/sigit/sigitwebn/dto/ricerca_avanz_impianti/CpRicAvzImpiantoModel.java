package it.csi.sigit.sigitwebn.dto.ricerca_avanz_impianti;

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
 * logica di business associata alla Schermata [cpRicAvzImpianto]
 */
@Validation
public class CpRicAvzImpiantoModel extends BaseSessionAwareDTO {

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	////////////////////////////////////////////////////////////////////
	/// application data
	////////////////////////////////////////////////////////////////////

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoComuni'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoComuni(java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoComuni", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoComuni'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> getAppDataelencoComuni() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoComuni"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoProvince'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoProvince(java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoProvince", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoProvince'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> getAppDataelencoProvince() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoProvince"));
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
	 * imposta il valore dell' ApplicationData 'appDatarisultatoRicercaImpianti'
	 * @param value
	 * @generated
	 */

	public void setAppDatarisultatoRicercaImpianti(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.impianto.RisultatoRicImpianto> value) {
		getSession().put("appDatarisultatoRicercaImpianti", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatarisultatoRicercaImpianti'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.impianto.RisultatoRicImpianto> getAppDatarisultatoRicercaImpianti() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.impianto.RisultatoRicImpianto>) (getSession()
				.get("appDatarisultatoRicercaImpianti"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataaggiornaElencoImpianti'
	 * @param value
	 * @generated
	 */

	public void setAppDataaggiornaElencoImpianti(java.lang.Boolean value) {
		getSession().put("appDataaggiornaElencoImpianti", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataaggiornaElencoImpianti'
	 * @generated
	 */
	public java.lang.Boolean getAppDataaggiornaElencoImpianti() {
		return (java.lang.Boolean) (getSession().get("appDataaggiornaElencoImpianti"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoProvincePiemonte'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoProvincePiemonte(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoProvincePiemonte", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoProvincePiemonte'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> getAppDataelencoProvincePiemonte() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoProvincePiemonte"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataidImpiantoSelez'
	 * @param value
	 * @generated
	 */

	public void setAppDataidImpiantoSelez(java.lang.String value) {
		getSession().put("appDataidImpiantoSelez", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidImpiantoSelez'
	 * @generated
	 */
	public java.lang.String getAppDataidImpiantoSelez() {
		return (java.lang.String) (getSession().get("appDataidImpiantoSelez"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataricercaAvanzataImpianti'
	 * @param value
	 * @generated
	 */

	public void setAppDataricercaAvanzataImpianti(it.csi.sigit.sigitwebn.dto.impianto.RicercaAvanzataImpianti value) {
		getSession().put("appDataricercaAvanzataImpianti", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataricercaAvanzataImpianti'
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.impianto.RicercaAvanzataImpianti getAppDataricercaAvanzataImpianti() {
		return (it.csi.sigit.sigitwebn.dto.impianto.RicercaAvanzataImpianti) (getSession()
				.get("appDataricercaAvanzataImpianti"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoTipoComponenti'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoTipoComponenti(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoTipoComponenti", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoTipoComponenti'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> getAppDataelencoTipoComponenti() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoTipoComponenti"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoCombustibili'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoCombustibili(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoCombustibili", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoCombustibili'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> getAppDataelencoCombustibili() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoCombustibili"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoMarche'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoMarche(java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoMarche", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoMarche'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> getAppDataelencoMarche() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoMarche"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoTipoRapporto'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoTipoRapporto(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoTipoRapporto", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoTipoRapporto'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> getAppDataelencoTipoRapporto() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoTipoRapporto"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoSigleBollino'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoSigleBollino(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoSigleBollino", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoSigleBollino'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> getAppDataelencoSigleBollino() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoSigleBollino"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoStatoImpianto'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoStatoImpianto(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoStatoImpianto", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoStatoImpianto'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> getAppDataelencoStatoImpianto() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoStatoImpianto"));
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
	 * imposta il valore dell' ApplicationData 'appDataelencoTipiDocumentazione'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoTipiDocumentazione(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoTipiDocumentazione", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoTipiDocumentazione'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> getAppDataelencoTipiDocumentazione() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoTipiDocumentazione"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoSiNo'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoSiNo(java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoSiNo", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoSiNo'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> getAppDataelencoSiNo() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoSiNo"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoTipoImpianto'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoTipoImpianto(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoTipoImpianto", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoTipoImpianto'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> getAppDataelencoTipoImpianto() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoTipoImpianto"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoUnitMisuraNox'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoUnitMisuraNox(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoUnitMisuraNox", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoUnitMisuraNox'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> getAppDataelencoUnitMisuraNox() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoUnitMisuraNox"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatalinkMappaWms'
	 * @param value
	 * @generated
	 */

	public void setAppDatalinkMappaWms(java.lang.String value) {
		getSession().put("appDatalinkMappaWms", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatalinkMappaWms'
	 * @generated
	 */
	public java.lang.String getAppDatalinkMappaWms() {
		return (java.lang.String) (getSession().get("appDatalinkMappaWms"));
	}

	////////////////////////////////////////////////////////////////////
	/// campi per widget semplici
	////////////////////////////////////////////////////////////////////

}
