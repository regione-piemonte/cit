/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitwebn.dto.acquisisci_codici_impianto;

import java.util.*;
import it.csi.sigit.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.dto.accesso.*;
import it.csi.sigit.sigitwebn.dto.codici_impianto.*;
import it.csi.sigit.sigitwebn.dto.common.*;
import it.csi.sigit.sigitwebn.dto.impianto.*;
import it.csi.sigit.sigitwebn.dto.main.*;

import it.csi.sigit.sigitwebn.presentation.uiutils.*;
import flexjson.JSON;
import com.opensymphony.xwork2.conversion.annotations.*;
import com.opensymphony.xwork2.validator.annotations.*;

/**
 * Questo DTO incapsula tutto il contenuto informativo necessario all'esecuzione della
 * logica di business associata alla Schermata [cpAcqCod]
 */
@Validation
public class CpAcqCodModel extends BaseSessionAwareDTO {

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	////////////////////////////////////////////////////////////////////
	/// application data
	////////////////////////////////////////////////////////////////////

	/**
	 * imposta il valore dell' ApplicationData 'appDataricercaCodImpianto'
	 * @param value
	 * @generated
	 */

	public void setAppDataricercaCodImpianto(
			it.csi.sigit.sigitwebn.dto.codici_impianto.RicercaCodImpianto value) {
		getSession().put("appDataricercaCodImpianto", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataricercaCodImpianto'
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.codici_impianto.RicercaCodImpianto getAppDataricercaCodImpianto() {
		return (it.csi.sigit.sigitwebn.dto.codici_impianto.RicercaCodImpianto) (getSession()
				.get("appDataricercaCodImpianto"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatautenteLoggato'
	 * @param value
	 * @generated
	 */

	public void setAppDatautenteLoggato(
			it.csi.sigit.sigitwebn.dto.main.UtenteLoggato value) {
		getSession().put("appDatautenteLoggato", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatautenteLoggato'
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.main.UtenteLoggato getAppDatautenteLoggato() {
		return (it.csi.sigit.sigitwebn.dto.main.UtenteLoggato) (getSession()
				.get("appDatautenteLoggato"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoSiglaRea'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoSiglaRea(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> value) {
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
		return (java.lang.Boolean) (getSession()
				.get("appDataaggiornaElencoCodImpianto"));
	}

	/**
	 * @generated
	 */
	private it.csi.sigit.sigitwebn.dto.codici_impianto.AcquisizioneCodici appDataacquisizioneCodiciImpianto = null;

	/**
	 * imposta il valore dell' ApplicationData 'appDataacquisizioneCodiciImpianto'
	 * @param value
	 * @generated
	 */

	public void setAppDataacquisizioneCodiciImpianto(
			it.csi.sigit.sigitwebn.dto.codici_impianto.AcquisizioneCodici value) {
		appDataacquisizioneCodiciImpianto = value;
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataacquisizioneCodiciImpianto'
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.codici_impianto.AcquisizioneCodici getAppDataacquisizioneCodiciImpianto() {
		return appDataacquisizioneCodiciImpianto;
	}

	////////////////////////////////////////////////////////////////////
	/// campi per widget semplici
	////////////////////////////////////////////////////////////////////

	////////////////////////////////////////////////////////////////////
	/// ulteriori campi comuni 
	////////////////////////////////////////////////////////////////////

	/////////////////////////////////////////
	/// property comuni a tutte le action
	/////////////////////////////////////////

	/// parametri per cambio TAB

	private String selectedTabKey;

	public void setSelectedTabKey(String value) {
		selectedTabKey = value;
	}

	public String getSelectedTabKey() {
		return selectedTabKey;
	}

	private String selectedTabValue;

	public void setSelectedTabValue(String value) {
		selectedTabValue = value;
	}

	public String getSelectedTabValue() {
		return selectedTabValue;
	}

	/**
	 * @generated
	 */
	private List<TableFilter> filter;

	/**
	 * @generated
	 */
	public List<TableFilter> getFilter() {
		return filter;
	}

	/**
	 * @generated
	 */
	public void setFilter(List<TableFilter> filter) {
		this.filter = filter;
	}

	/**
	 * @generated
	 */
	private TableStatus tableStatus;

	/**
	 * @generated
	 */
	public TableStatus getTableStatus() {
		return tableStatus;
	}

	/**
	 * @generated
	 */
	public void setTableStatus(TableStatus tableStatus) {
		this.tableStatus = tableStatus;
	}

}
