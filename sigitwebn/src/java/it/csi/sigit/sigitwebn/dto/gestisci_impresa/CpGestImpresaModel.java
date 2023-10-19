package it.csi.sigit.sigitwebn.dto.gestisci_impresa;

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
 * logica di business associata alla Schermata [cpGestImpresa]
 */
@Validation
public class CpGestImpresaModel extends BaseSessionAwareDTO {

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	////////////////////////////////////////////////////////////////////
	/// application data
	////////////////////////////////////////////////////////////////////

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
	 * imposta il valore dell' ApplicationData 'appDataimpresa'
	 * @param value
	 * @generated
	 */

	public void setAppDataimpresa(it.csi.sigit.sigitwebn.dto.accesso.PersonaGiuridica value) {
		getSession().put("appDataimpresa", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataimpresa'
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.accesso.PersonaGiuridica getAppDataimpresa() {
		return (it.csi.sigit.sigitwebn.dto.accesso.PersonaGiuridica) (getSession().get("appDataimpresa"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoIndirizziImp'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoIndirizziImp(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoIndirizziImp", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoIndirizziImp'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> getAppDataelencoIndirizziImp() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoIndirizziImp"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoImprese'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoImprese(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.accesso.PersonaGiuridica> value) {
		getSession().put("appDataelencoImprese", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoImprese'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.accesso.PersonaGiuridica> getAppDataelencoImprese() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.accesso.PersonaGiuridica>) (getSession()
				.get("appDataelencoImprese"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoStatoImp'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoStatoImp(java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoStatoImp", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoStatoImp'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> getAppDataelencoStatoImp() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoStatoImp"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataidImpresaSelezionata'
	 * @param value
	 * @generated
	 */

	public void setAppDataidImpresaSelezionata(java.lang.Integer value) {
		getSession().put("appDataidImpresaSelezionata", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidImpresaSelezionata'
	 * @generated
	 */
	public java.lang.Integer getAppDataidImpresaSelezionata() {
		return (java.lang.Integer) (getSession().get("appDataidImpresaSelezionata"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataruoliImpresa'
	 * @param value
	 * @generated
	 */

	public void setAppDataruoliImpresa(java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> value) {
		getSession().put("appDataruoliImpresa", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataruoliImpresa'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> getAppDataruoliImpresa() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription>) (getSession()
				.get("appDataruoliImpresa"));
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
	 * imposta il valore dell' ApplicationData 'appDataricercaImprese'
	 * @param value
	 * @generated
	 */

	public void setAppDataricercaImprese(it.csi.sigit.sigitwebn.dto.impresa.RicercaImprese value) {
		getSession().put("appDataricercaImprese", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataricercaImprese'
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.impresa.RicercaImprese getAppDataricercaImprese() {
		return (it.csi.sigit.sigitwebn.dto.impresa.RicercaImprese) (getSession().get("appDataricercaImprese"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoDatiVisura'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoDatiVisura(java.util.ArrayList<it.csi.sigit.sigitwebn.dto.impresa.LabelValue> value) {
		getSession().put("appDataelencoDatiVisura", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoDatiVisura'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.impresa.LabelValue> getAppDataelencoDatiVisura() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.impresa.LabelValue>) (getSession()
				.get("appDataelencoDatiVisura"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoIncarichiAttivi'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoIncarichiAttivi(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.accesso.PersonaGiuridica> value) {
		getSession().put("appDataelencoIncarichiAttivi", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoIncarichiAttivi'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.accesso.PersonaGiuridica> getAppDataelencoIncarichiAttivi() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.accesso.PersonaGiuridica>) (getSession()
				.get("appDataelencoIncarichiAttivi"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatanumeroRapportiInviati'
	 * @param value
	 * @generated
	 */

	public void setAppDatanumeroRapportiInviati(java.lang.Integer value) {
		getSession().put("appDatanumeroRapportiInviati", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatanumeroRapportiInviati'
	 * @generated
	 */
	public java.lang.Integer getAppDatanumeroRapportiInviati() {
		return (java.lang.Integer) (getSession().get("appDatanumeroRapportiInviati"));
	}

	////////////////////////////////////////////////////////////////////
	/// campi per widget semplici
	////////////////////////////////////////////////////////////////////

	// Table tbVisuraImpresa

	private java.lang.String widgTbVisuraImpresa;

	public void setWidg_tbVisuraImpresa(java.lang.String value) {
		widgTbVisuraImpresa = value;
	}

	public java.lang.String getWidg_tbVisuraImpresa() {
		return widgTbVisuraImpresa;
	}

	// Table tbIncTrovate

	private java.lang.String widgTbIncTrovate;

	public void setWidg_tbIncTrovate(java.lang.String value) {
		widgTbIncTrovate = value;
	}

	public java.lang.String getWidg_tbIncTrovate() {
		return widgTbIncTrovate;
	}

}
