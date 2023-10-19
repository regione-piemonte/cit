package it.csi.sigit.sigitwebn.dto.ricerca_impianti_graffatura;

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
 * logica di business associata alla Schermata [cpRicImpiantoGraffatura]
 */
@Validation
public class CpRicImpiantoGraffaturaModel extends BaseSessionAwareDTO {

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
	 * imposta il valore dell' ApplicationData 'appDataricercaImpianti'
	 * @param value
	 * @generated
	 */

	public void setAppDataricercaImpianti(it.csi.sigit.sigitwebn.dto.impianto.RicercaImpianti value) {
		getSession().put("appDataricercaImpianti", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataricercaImpianti'
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.impianto.RicercaImpianti getAppDataricercaImpianti() {
		return (it.csi.sigit.sigitwebn.dto.impianto.RicercaImpianti) (getSession().get("appDataricercaImpianti"));
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
	 * imposta il valore dell' ApplicationData 'appDataidResponsabileSelez'
	 * @param value
	 * @generated
	 */

	public void setAppDataidResponsabileSelez(java.lang.String value) {
		getSession().put("appDataidResponsabileSelez", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidResponsabileSelez'
	 * @generated
	 */
	public java.lang.String getAppDataidResponsabileSelez() {
		return (java.lang.String) (getSession().get("appDataidResponsabileSelez"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataprovenienza'
	 * @param value
	 * @generated
	 */

	public void setAppDataprovenienza(java.lang.String value) {
		getSession().put("appDataprovenienza", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataprovenienza'
	 * @generated
	 */
	public java.lang.String getAppDataprovenienza() {
		return (java.lang.String) (getSession().get("appDataprovenienza"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataimpianto'
	 * @param value
	 * @generated
	 */

	public void setAppDataimpianto(it.csi.sigit.sigitwebn.dto.impianto.Impianto value) {
		getSession().put("appDataimpianto", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataimpianto'
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.impianto.Impianto getAppDataimpianto() {
		return (it.csi.sigit.sigitwebn.dto.impianto.Impianto) (getSession().get("appDataimpianto"));
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
	 * imposta il valore dell' ApplicationData 'appDataimpiantoApprofondito'
	 * @param value
	 * @generated
	 */

	public void setAppDataimpiantoApprofondito(it.csi.sigit.sigitwebn.dto.impianto.Impianto value) {
		getSession().put("appDataimpiantoApprofondito", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataimpiantoApprofondito'
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.impianto.Impianto getAppDataimpiantoApprofondito() {
		return (it.csi.sigit.sigitwebn.dto.impianto.Impianto) (getSession().get("appDataimpiantoApprofondito"));
	}

	////////////////////////////////////////////////////////////////////
	/// campi per widget semplici
	////////////////////////////////////////////////////////////////////

}
