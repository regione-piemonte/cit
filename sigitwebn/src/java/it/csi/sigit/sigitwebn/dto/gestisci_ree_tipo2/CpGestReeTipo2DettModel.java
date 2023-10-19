package it.csi.sigit.sigitwebn.dto.gestisci_ree_tipo2;

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
 * logica di business associata alla Schermata [cpGestReeTipo2Dett]
 */
@Validation
public class CpGestReeTipo2DettModel extends BaseSessionAwareDTO {

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
	 * imposta il valore dell' ApplicationData 'appDataidentificativoImpianto'
	 * @param value
	 * @generated
	 */

	public void setAppDataidentificativoImpianto(it.csi.sigit.sigitwebn.dto.impianto.IdentificativoImpianto value) {
		getSession().put("appDataidentificativoImpianto", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidentificativoImpianto'
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.impianto.IdentificativoImpianto getAppDataidentificativoImpianto() {
		return (it.csi.sigit.sigitwebn.dto.impianto.IdentificativoImpianto) (getSession()
				.get("appDataidentificativoImpianto"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatareeMenuTree'
	 * @param value
	 * @generated
	 */

	public void setAppDatareeMenuTree(it.csi.custom.component.tree.base.TreeNode value) {
		getSession().put("appDatareeMenuTree", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatareeMenuTree'
	 * @generated
	 */
	public it.csi.custom.component.tree.base.TreeNode getAppDatareeMenuTree() {
		return (it.csi.custom.component.tree.base.TreeNode) (getSession().get("appDatareeMenuTree"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatareeTipo2'
	 * @param value
	 * @generated
	 */

	public void setAppDatareeTipo2(it.csi.sigit.sigitwebn.dto.ree.Tipo2 value) {
		getSession().put("appDatareeTipo2", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatareeTipo2'
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.ree.Tipo2 getAppDatareeTipo2() {
		return (it.csi.sigit.sigitwebn.dto.ree.Tipo2) (getSession().get("appDatareeTipo2"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatareeTipo2Dett'
	 * @param value
	 * @generated
	 */

	public void setAppDatareeTipo2Dett(it.csi.sigit.sigitwebn.dto.ree.Tipo2Dett value) {
		getSession().put("appDatareeTipo2Dett", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatareeTipo2Dett'
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.ree.Tipo2Dett getAppDatareeTipo2Dett() {
		return (it.csi.sigit.sigitwebn.dto.ree.Tipo2Dett) (getSession().get("appDatareeTipo2Dett"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataprogressivoSelezionato'
	 * @param value
	 * @generated
	 */

	public void setAppDataprogressivoSelezionato(java.lang.Integer value) {
		getSession().put("appDataprogressivoSelezionato", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataprogressivoSelezionato'
	 * @generated
	 */
	public java.lang.Integer getAppDataprogressivoSelezionato() {
		return (java.lang.Integer) (getSession().get("appDataprogressivoSelezionato"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatamoduloSelezionato'
	 * @param value
	 * @generated
	 */

	public void setAppDatamoduloSelezionato(java.lang.String value) {
		getSession().put("appDatamoduloSelezionato", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatamoduloSelezionato'
	 * @generated
	 */
	public java.lang.String getAppDatamoduloSelezionato() {
		return (java.lang.String) (getSession().get("appDatamoduloSelezionato"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoModuli'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoModuli(java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoModuli", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoModuli'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> getAppDataelencoModuli() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoModuli"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataricaricaPagina'
	 * @param value
	 * @generated
	 */

	public void setAppDataricaricaPagina(java.lang.Boolean value) {
		getSession().put("appDataricaricaPagina", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataricaricaPagina'
	 * @generated
	 */
	public java.lang.Boolean getAppDataricaricaPagina() {
		return (java.lang.Boolean) (getSession().get("appDataricaricaPagina"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataallegato'
	 * @param value
	 * @generated
	 */

	public void setAppDataallegato(it.csi.sigit.sigitwebn.dto.allegati.DettaglioAllegato value) {
		getSession().put("appDataallegato", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataallegato'
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.allegati.DettaglioAllegato getAppDataallegato() {
		return (it.csi.sigit.sigitwebn.dto.allegati.DettaglioAllegato) (getSession().get("appDataallegato"));
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
	 * imposta il valore dell' ApplicationData 'appDataelencoModalitaProva'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoModalitaProva(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoModalitaProva", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoModalitaProva'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> getAppDataelencoModalitaProva() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoModalitaProva"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatareeTipo2DettCircuito'
	 * @param value
	 * @generated
	 */

	public void setAppDatareeTipo2DettCircuito(it.csi.sigit.sigitwebn.dto.ree.Tipo2DettCircuito value) {
		getSession().put("appDatareeTipo2DettCircuito", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatareeTipo2DettCircuito'
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.ree.Tipo2DettCircuito getAppDatareeTipo2DettCircuito() {
		return (it.csi.sigit.sigitwebn.dto.ree.Tipo2DettCircuito) (getSession().get("appDatareeTipo2DettCircuito"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoReeTipo2DettCircuito'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoReeTipo2DettCircuito(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.ree.Tipo2DettCircuito> value) {
		getSession().put("appDataelencoReeTipo2DettCircuito", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoReeTipo2DettCircuito'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.ree.Tipo2DettCircuito> getAppDataelencoReeTipo2DettCircuito() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.ree.Tipo2DettCircuito>) (getSession()
				.get("appDataelencoReeTipo2DettCircuito"));
	}

	////////////////////////////////////////////////////////////////////
	/// campi per widget semplici
	////////////////////////////////////////////////////////////////////

}
