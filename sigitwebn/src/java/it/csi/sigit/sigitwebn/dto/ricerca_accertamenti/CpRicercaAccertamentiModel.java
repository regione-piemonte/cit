package it.csi.sigit.sigitwebn.dto.ricerca_accertamenti;

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
 * logica di business associata alla Schermata [cpRicercaAccertamenti]
 */
@Validation
public class CpRicercaAccertamentiModel extends BaseSessionAwareDTO {

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
	 * imposta il valore dell' ApplicationData 'appDataelencoVerifiche'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoVerifiche(java.util.ArrayList<it.csi.sigit.sigitwebn.dto.verifica.Verifica> value) {
		getSession().put("appDataelencoVerifiche", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoVerifiche'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.verifica.Verifica> getAppDataelencoVerifiche() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.verifica.Verifica>) (getSession()
				.get("appDataelencoVerifiche"));
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
	 * imposta il valore dell' ApplicationData 'appDataelencoTipiVerifica'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoTipiVerifica(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.IdDescription> value) {
		getSession().put("appDataelencoTipiVerifica", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoTipiVerifica'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.IdDescription> getAppDataelencoTipiVerifica() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.IdDescription>) (getSession()
				.get("appDataelencoTipiVerifica"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoSiglaBollini'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoSiglaBollini(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoSiglaBollini", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoSiglaBollini'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> getAppDataelencoSiglaBollini() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoSiglaBollini"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataricercaAccertamento'
	 * @param value
	 * @generated
	 */
	@VisitorFieldValidator(message = "", key = "cpRicercaAccertamenti.ricercaAccertamento.visitorvalidator.label", appendPrefix = true)
	public void setAppDataricercaAccertamento(it.csi.sigit.sigitwebn.dto.accertamento.RicercaAccertamento value) {
		getSession().put("appDataricercaAccertamento", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataricercaAccertamento'
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.accertamento.RicercaAccertamento getAppDataricercaAccertamento() {
		return (it.csi.sigit.sigitwebn.dto.accertamento.RicercaAccertamento) (getSession()
				.get("appDataricercaAccertamento"));
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

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoComuniPiemonteIstat'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoComuniPiemonteIstat(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoComuniPiemonteIstat", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoComuniPiemonteIstat'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> getAppDataelencoComuniPiemonteIstat() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoComuniPiemonteIstat"));
	}

	////////////////////////////////////////////////////////////////////
	/// campi per widget semplici
	////////////////////////////////////////////////////////////////////

}
