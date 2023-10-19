package it.csi.sigit.sigitwebn.dto.gestisci_sanzioni;

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
 * logica di business associata alla Schermata [cpDettaglioSanzione]
 */
@Validation
public class CpDettaglioSanzioneModel extends BaseSessionAwareDTO {

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
	 * imposta il valore dell' ApplicationData 'appDatasanzione'
	 * @param value
	 * @generated
	 */

	public void setAppDatasanzione(it.csi.sigit.sigitwebn.dto.sanzioni.Sanzione value) {
		getSession().put("appDatasanzione", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatasanzione'
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.sanzioni.Sanzione getAppDatasanzione() {
		return (it.csi.sigit.sigitwebn.dto.sanzioni.Sanzione) (getSession().get("appDatasanzione"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataidSanzioneSelezionata'
	 * @param value
	 * @generated
	 */

	public void setAppDataidSanzioneSelezionata(java.lang.Integer value) {
		getSession().put("appDataidSanzioneSelezionata", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidSanzioneSelezionata'
	 * @generated
	 */
	public java.lang.Integer getAppDataidSanzioneSelezionata() {
		return (java.lang.Integer) (getSession().get("appDataidSanzioneSelezionata"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoAzioni'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoAzioni(java.util.ArrayList<it.csi.sigit.sigitwebn.dto.azioni.Azione> value) {
		getSession().put("appDataelencoAzioni", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoAzioni'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.azioni.Azione> getAppDataelencoAzioni() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.azioni.Azione>) (getSession()
				.get("appDataelencoAzioni"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataidAzioneSelezionata'
	 * @param value
	 * @generated
	 */

	public void setAppDataidAzioneSelezionata(java.lang.String value) {
		getSession().put("appDataidAzioneSelezionata", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidAzioneSelezionata'
	 * @generated
	 */
	public java.lang.String getAppDataidAzioneSelezionata() {
		return (java.lang.String) (getSession().get("appDataidAzioneSelezionata"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataidTipoAzione'
	 * @param value
	 * @generated
	 */

	public void setAppDataidTipoAzione(java.lang.Integer value) {
		getSession().put("appDataidTipoAzione", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidTipoAzione'
	 * @generated
	 */
	public java.lang.Integer getAppDataidTipoAzione() {
		return (java.lang.Integer) (getSession().get("appDataidTipoAzione"));
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
	 * imposta il valore dell' ApplicationData 'appDataelencoStatiSanzione'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoStatiSanzione(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.IdDescription> value) {
		getSession().put("appDataelencoStatiSanzione", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoStatiSanzione'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.IdDescription> getAppDataelencoStatiSanzione() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.IdDescription>) (getSession()
				.get("appDataelencoStatiSanzione"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatapaginaChiamanteDettaglioSanzione'
	 * @param value
	 * @generated
	 */

	public void setAppDatapaginaChiamanteDettaglioSanzione(java.lang.String value) {
		getSession().put("appDatapaginaChiamanteDettaglioSanzione", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatapaginaChiamanteDettaglioSanzione'
	 * @generated
	 */
	public java.lang.String getAppDatapaginaChiamanteDettaglioSanzione() {
		return (java.lang.String) (getSession().get("appDatapaginaChiamanteDettaglioSanzione"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatadatiInserimentoSanzione'
	 * @param value
	 * @generated
	 */

	public void setAppDatadatiInserimentoSanzione(it.csi.sigit.sigitwebn.dto.sanzioni.DatiInserimentoSanzione value) {
		getSession().put("appDatadatiInserimentoSanzione", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatadatiInserimentoSanzione'
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.sanzioni.DatiInserimentoSanzione getAppDatadatiInserimentoSanzione() {
		return (it.csi.sigit.sigitwebn.dto.sanzioni.DatiInserimentoSanzione) (getSession()
				.get("appDatadatiInserimentoSanzione"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoIspettori'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoIspettori(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoIspettori", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoIspettori'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> getAppDataelencoIspettori() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoIspettori"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoValidatori'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoValidatori(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoValidatori", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoValidatori'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> getAppDataelencoValidatori() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoValidatori"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatadataPagamento'
	 * @param value
	 * @generated
	 */

	public void setAppDatadataPagamento(java.lang.String value) {
		getSession().put("appDatadataPagamento", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatadataPagamento'
	 * @generated
	 */
	public java.lang.String getAppDatadataPagamento() {
		return (java.lang.String) (getSession().get("appDatadataPagamento"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatamotivoAnnullamentoSanzione'
	 * @param value
	 * @generated
	 */

	public void setAppDatamotivoAnnullamentoSanzione(java.lang.String value) {
		getSession().put("appDatamotivoAnnullamentoSanzione", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatamotivoAnnullamentoSanzione'
	 * @generated
	 */
	public java.lang.String getAppDatamotivoAnnullamentoSanzione() {
		return (java.lang.String) (getSession().get("appDatamotivoAnnullamentoSanzione"));
	}

	////////////////////////////////////////////////////////////////////
	/// campi per widget semplici
	////////////////////////////////////////////////////////////////////

	// Table tbAzioniSvolte

	private java.lang.String widgTbAzioniSvolte;

	public void setWidg_tbAzioniSvolte(java.lang.String value) {
		widgTbAzioniSvolte = value;
	}

	public java.lang.String getWidg_tbAzioniSvolte() {
		return widgTbAzioniSvolte;
	}

}
