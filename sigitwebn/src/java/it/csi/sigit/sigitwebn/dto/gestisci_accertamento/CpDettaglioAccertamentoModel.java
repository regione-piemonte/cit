package it.csi.sigit.sigitwebn.dto.gestisci_accertamento;

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
 * logica di business associata alla Schermata [cpDettaglioAccertamento]
 */
@Validation
public class CpDettaglioAccertamentoModel extends BaseSessionAwareDTO {

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
	 * imposta il valore dell' ApplicationData 'appDataaccertamento'
	 * @param value
	 * @generated
	 */

	public void setAppDataaccertamento(it.csi.sigit.sigitwebn.dto.accertamento.Accertamento value) {
		getSession().put("appDataaccertamento", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataaccertamento'
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.accertamento.Accertamento getAppDataaccertamento() {
		return (it.csi.sigit.sigitwebn.dto.accertamento.Accertamento) (getSession().get("appDataaccertamento"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoTipoAnomalie'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoTipoAnomalie(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoTipoAnomalie", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoTipoAnomalie'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> getAppDataelencoTipoAnomalie() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoTipoAnomalie"));
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
	 * imposta il valore dell' ApplicationData 'appDatasveglia'
	 * @param value
	 * @generated
	 */

	public void setAppDatasveglia(it.csi.sigit.sigitwebn.dto.azioni.Sveglia value) {
		getSession().put("appDatasveglia", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatasveglia'
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.azioni.Sveglia getAppDatasveglia() {
		return (it.csi.sigit.sigitwebn.dto.azioni.Sveglia) (getSession().get("appDatasveglia"));
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
	 * imposta il valore dell' ApplicationData 'appDataverifica'
	 * @param value
	 * @generated
	 */

	public void setAppDataverifica(it.csi.sigit.sigitwebn.dto.verifica.Verifica value) {
		getSession().put("appDataverifica", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataverifica'
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.verifica.Verifica getAppDataverifica() {
		return (it.csi.sigit.sigitwebn.dto.verifica.Verifica) (getSession().get("appDataverifica"));
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
	 * imposta il valore dell' ApplicationData 'appDataelencoStatoAccertamento'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoStatoAccertamento(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.IdDescription> value) {
		getSession().put("appDataelencoStatoAccertamento", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoStatoAccertamento'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.IdDescription> getAppDataelencoStatoAccertamento() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.IdDescription>) (getSession()
				.get("appDataelencoStatoAccertamento"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoIspezioniAccertamento'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoIspezioniAccertamento(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.accertamento.IspezioneAccertamento> value) {
		getSession().put("appDataelencoIspezioniAccertamento", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoIspezioniAccertamento'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.accertamento.IspezioneAccertamento> getAppDataelencoIspezioniAccertamento() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.accertamento.IspezioneAccertamento>) (getSession()
				.get("appDataelencoIspezioniAccertamento"));
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
	 * imposta il valore dell' ApplicationData 'appDataelencoTipoConclusione'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoTipoConclusione(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.IdDescription> value) {
		getSession().put("appDataelencoTipoConclusione", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoTipoConclusione'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.IdDescription> getAppDataelencoTipoConclusione() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.IdDescription>) (getSession()
				.get("appDataelencoTipoConclusione"));
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
	 * imposta il valore dell' ApplicationData 'appDataelencoSanzioni'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoSanzioni(java.util.ArrayList<it.csi.sigit.sigitwebn.dto.sanzioni.Sanzione> value) {
		getSession().put("appDataelencoSanzioni", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoSanzioni'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.sanzioni.Sanzione> getAppDataelencoSanzioni() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.sanzioni.Sanzione>) (getSession()
				.get("appDataelencoSanzioni"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataazioneCodImpianto'
	 * @param value
	 * @generated
	 */

	public void setAppDataazioneCodImpianto(java.lang.String value) {
		getSession().put("appDataazioneCodImpianto", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataazioneCodImpianto'
	 * @generated
	 */
	public java.lang.String getAppDataazioneCodImpianto() {
		return (java.lang.String) (getSession().get("appDataazioneCodImpianto"));
	}

	////////////////////////////////////////////////////////////////////
	/// campi per widget semplici
	////////////////////////////////////////////////////////////////////

	// Table tbAzioni

	private java.lang.String widgTbAzioni;

	public void setWidg_tbAzioni(java.lang.String value) {
		widgTbAzioni = value;
	}

	public java.lang.String getWidg_tbAzioni() {
		return widgTbAzioni;
	}

}
