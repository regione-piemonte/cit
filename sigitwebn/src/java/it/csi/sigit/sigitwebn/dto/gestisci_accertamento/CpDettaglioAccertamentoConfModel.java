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
 * logica di business associata alla Schermata [cpDettaglioAccertamentoConf]
 */
@Validation
public class CpDettaglioAccertamentoConfModel extends BaseSessionAwareDTO {

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
	 * imposta il valore dell' ApplicationData 'appDataricercaImpiantoDaAssociareAccertamento'
	 * @param value
	 * @generated
	 */

	public void setAppDataricercaImpiantoDaAssociareAccertamento(
			it.csi.sigit.sigitwebn.dto.accertamento.RicercaImpiantoDaAssociare value) {
		getSession().put("appDataricercaImpiantoDaAssociareAccertamento", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataricercaImpiantoDaAssociareAccertamento'
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.accertamento.RicercaImpiantoDaAssociare getAppDataricercaImpiantoDaAssociareAccertamento() {
		return (it.csi.sigit.sigitwebn.dto.accertamento.RicercaImpiantoDaAssociare) (getSession()
				.get("appDataricercaImpiantoDaAssociareAccertamento"));
	}

	////////////////////////////////////////////////////////////////////
	/// campi per widget semplici
	////////////////////////////////////////////////////////////////////

}
