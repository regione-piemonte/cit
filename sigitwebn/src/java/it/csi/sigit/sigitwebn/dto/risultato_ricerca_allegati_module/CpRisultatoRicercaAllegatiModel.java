package it.csi.sigit.sigitwebn.dto.risultato_ricerca_allegati_module;

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
 * logica di business associata alla Schermata [cpRisultatoRicercaAllegati]
 */
@Validation
public class CpRisultatoRicercaAllegatiModel extends BaseSessionAwareDTO {

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
	 * imposta il valore dell' ApplicationData 'appDataelencoAllegati'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoAllegati(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.allegati.ElencoAllegati> value) {
		getSession().put("appDataelencoAllegati", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoAllegati'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.allegati.ElencoAllegati> getAppDataelencoAllegati() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.allegati.ElencoAllegati>) (getSession()
				.get("appDataelencoAllegati"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataricercaAllegati'
	 * @param value
	 * @generated
	 */

	public void setAppDataricercaAllegati(it.csi.sigit.sigitwebn.dto.allegati.RicercaAllegati value) {
		getSession().put("appDataricercaAllegati", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataricercaAllegati'
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.allegati.RicercaAllegati getAppDataricercaAllegati() {
		return (it.csi.sigit.sigitwebn.dto.allegati.RicercaAllegati) (getSession().get("appDataricercaAllegati"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataidAllegatoSelezionato'
	 * @param value
	 * @generated
	 */

	public void setAppDataidAllegatoSelezionato(java.lang.Integer value) {
		getSession().put("appDataidAllegatoSelezionato", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidAllegatoSelezionato'
	 * @generated
	 */
	public java.lang.Integer getAppDataidAllegatoSelezionato() {
		return (java.lang.Integer) (getSession().get("appDataidAllegatoSelezionato"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatacurrentUser'
	 * @param value
	 * @generated
	 */

	public void setAppDatacurrentUser(it.csi.sigit.sigitwebn.dto.common.UserInfo value) {
		getSession().put("appDatacurrentUser", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatacurrentUser'
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.common.UserInfo getAppDatacurrentUser() {
		return (it.csi.sigit.sigitwebn.dto.common.UserInfo) (getSession().get("appDatacurrentUser"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataaggiornaElencoAllegati'
	 * @param value
	 * @generated
	 */

	public void setAppDataaggiornaElencoAllegati(java.lang.Boolean value) {
		getSession().put("appDataaggiornaElencoAllegati", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataaggiornaElencoAllegati'
	 * @generated
	 */
	public java.lang.Boolean getAppDataaggiornaElencoAllegati() {
		return (java.lang.Boolean) (getSession().get("appDataaggiornaElencoAllegati"));
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
	 * imposta il valore dell' ApplicationData 'appDatapaginaChiamanteAllegati'
	 * @param value
	 * @generated
	 */

	public void setAppDatapaginaChiamanteAllegati(java.lang.String value) {
		getSession().put("appDatapaginaChiamanteAllegati", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatapaginaChiamanteAllegati'
	 * @generated
	 */
	public java.lang.String getAppDatapaginaChiamanteAllegati() {
		return (java.lang.String) (getSession().get("appDatapaginaChiamanteAllegati"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatadettaglioElencoAllegati'
	 * @param value
	 * @generated
	 */

	public void setAppDatadettaglioElencoAllegati(it.csi.sigit.sigitwebn.dto.allegati.ElencoAllegati value) {
		getSession().put("appDatadettaglioElencoAllegati", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatadettaglioElencoAllegati'
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.allegati.ElencoAllegati getAppDatadettaglioElencoAllegati() {
		return (it.csi.sigit.sigitwebn.dto.allegati.ElencoAllegati) (getSession()
				.get("appDatadettaglioElencoAllegati"));
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

	////////////////////////////////////////////////////////////////////
	/// campi per widget semplici
	////////////////////////////////////////////////////////////////////

}
