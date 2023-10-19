package it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda3;

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
 * logica di business associata alla Schermata [cpGestLibScheda3]
 */
@Validation
public class CpGestLibScheda3Model extends BaseSessionAwareDTO {

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
	 * imposta il valore dell' ApplicationData 'appDataelencoDettaglioTerzoResponsabile'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoDettaglioTerzoResponsabile(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.terzoresponsabile.DettaglioTerzoResponsabile> value) {
		getSession().put("appDataelencoDettaglioTerzoResponsabile", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoDettaglioTerzoResponsabile'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.terzoresponsabile.DettaglioTerzoResponsabile> getAppDataelencoDettaglioTerzoResponsabile() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.terzoresponsabile.DettaglioTerzoResponsabile>) (getSession()
				.get("appDataelencoDettaglioTerzoResponsabile"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoTipiCessazione'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoTipiCessazione(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.IdDescription> value) {
		getSession().put("appDataelencoTipiCessazione", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoTipiCessazione'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.IdDescription> getAppDataelencoTipiCessazione() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.IdDescription>) (getSession()
				.get("appDataelencoTipiCessazione"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatadatiRevocaResponsabile'
	 * @param value
	 * @generated
	 */

	public void setAppDatadatiRevocaResponsabile(
			it.csi.sigit.sigitwebn.dto.terzoresponsabile.CessazioneTerzaResponsabilita value) {
		getSession().put("appDatadatiRevocaResponsabile", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatadatiRevocaResponsabile'
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.terzoresponsabile.CessazioneTerzaResponsabilita getAppDatadatiRevocaResponsabile() {
		return (it.csi.sigit.sigitwebn.dto.terzoresponsabile.CessazioneTerzaResponsabilita) (getSession()
				.get("appDatadatiRevocaResponsabile"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatalibrettoMenuTree'
	 * @param value
	 * @generated
	 */

	public void setAppDatalibrettoMenuTree(it.csi.custom.component.tree.base.TreeNode value) {
		getSession().put("appDatalibrettoMenuTree", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatalibrettoMenuTree'
	 * @generated
	 */
	public it.csi.custom.component.tree.base.TreeNode getAppDatalibrettoMenuTree() {
		return (it.csi.custom.component.tree.base.TreeNode) (getSession().get("appDatalibrettoMenuTree"));
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
	 * imposta il valore dell' ApplicationData 'appDataidContrattoSelez'
	 * @param value
	 * @generated
	 */

	public void setAppDataidContrattoSelez(java.lang.Integer value) {
		getSession().put("appDataidContrattoSelez", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidContrattoSelez'
	 * @generated
	 */
	public java.lang.Integer getAppDataidContrattoSelez() {
		return (java.lang.Integer) (getSession().get("appDataidContrattoSelez"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatadettaglioTerzoResponsabile'
	 * @param value
	 * @generated
	 */

	public void setAppDatadettaglioTerzoResponsabile(
			it.csi.sigit.sigitwebn.dto.terzoresponsabile.DettaglioTerzoResponsabile value) {
		getSession().put("appDatadettaglioTerzoResponsabile", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatadettaglioTerzoResponsabile'
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.terzoresponsabile.DettaglioTerzoResponsabile getAppDatadettaglioTerzoResponsabile() {
		return (it.csi.sigit.sigitwebn.dto.terzoresponsabile.DettaglioTerzoResponsabile) (getSession()
				.get("appDatadettaglioTerzoResponsabile"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataidTipoCessazioneSelez'
	 * @param value
	 * @generated
	 */

	public void setAppDataidTipoCessazioneSelez(java.lang.Integer value) {
		getSession().put("appDataidTipoCessazioneSelez", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidTipoCessazioneSelez'
	 * @generated
	 */
	public java.lang.Integer getAppDataidTipoCessazioneSelez() {
		return (java.lang.Integer) (getSession().get("appDataidTipoCessazioneSelez"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoAutodichiarazioni'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoAutodichiarazioni(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.IdDescription> value) {
		getSession().put("appDataelencoAutodichiarazioni", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoAutodichiarazioni'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.IdDescription> getAppDataelencoAutodichiarazioni() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.IdDescription>) (getSession()
				.get("appDataelencoAutodichiarazioni"));
	}

	/**
	 * @generated
	 */
	private java.util.ArrayList<java.lang.Integer> appDataelencoIdSelezionati = new java.util.ArrayList<java.lang.Integer>();

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoIdSelezionati'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoIdSelezionati(java.util.ArrayList<java.lang.Integer> value) {
		appDataelencoIdSelezionati = value;
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoIdSelezionati'
	 * @generated
	 */
	public java.util.ArrayList<java.lang.Integer> getAppDataelencoIdSelezionati() {
		return appDataelencoIdSelezionati;
	}

	////////////////////////////////////////////////////////////////////
	/// campi per widget semplici
	////////////////////////////////////////////////////////////////////

}
