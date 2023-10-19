package it.csi.sigit.sigitwebn.dto.elenco_allegati_impianti;

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
 * logica di business associata alla Schermata [cpElencoAllegatiImpianti]
 */
@Validation
public class CpElencoAllegatiImpiantiModel extends BaseSessionAwareDTO {

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
	 * imposta il valore dell' ApplicationData 'appDataelencoAllegatiPerImpianto'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoAllegatiPerImpianto(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.allegati.DettaglioAllegato> value) {
		getSession().put("appDataelencoAllegatiPerImpianto", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoAllegatiPerImpianto'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.allegati.DettaglioAllegato> getAppDataelencoAllegatiPerImpianto() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.allegati.DettaglioAllegato>) (getSession()
				.get("appDataelencoAllegatiPerImpianto"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataidAllegatoImpiantoSelezionato'
	 * @param value
	 * @generated
	 */

	public void setAppDataidAllegatoImpiantoSelezionato(java.lang.Integer value) {
		getSession().put("appDataidAllegatoImpiantoSelezionato", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidAllegatoImpiantoSelezionato'
	 * @generated
	 */
	public java.lang.Integer getAppDataidAllegatoImpiantoSelezionato() {
		return (java.lang.Integer) (getSession().get("appDataidAllegatoImpiantoSelezionato"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatacodiceImpiantoAllegato'
	 * @param value
	 * @generated
	 */

	public void setAppDatacodiceImpiantoAllegato(java.lang.String value) {
		getSession().put("appDatacodiceImpiantoAllegato", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatacodiceImpiantoAllegato'
	 * @generated
	 */
	public java.lang.String getAppDatacodiceImpiantoAllegato() {
		return (java.lang.String) (getSession().get("appDatacodiceImpiantoAllegato"));
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
	 * imposta il valore dell' ApplicationData 'appDatapaginaChiamanteImp'
	 * @param value
	 * @generated
	 */

	public void setAppDatapaginaChiamanteImp(java.lang.String value) {
		getSession().put("appDatapaginaChiamanteImp", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatapaginaChiamanteImp'
	 * @generated
	 */
	public java.lang.String getAppDatapaginaChiamanteImp() {
		return (java.lang.String) (getSession().get("appDatapaginaChiamanteImp"));
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
	 * imposta il valore dell' ApplicationData 'appDatagestioneAllegatiImpianto'
	 * @param value
	 * @generated
	 */

	public void setAppDatagestioneAllegatiImpianto(it.csi.sigit.sigitwebn.dto.allegati.AllegatiPerImpianto value) {
		getSession().put("appDatagestioneAllegatiImpianto", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatagestioneAllegatiImpianto'
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.allegati.AllegatiPerImpianto getAppDatagestioneAllegatiImpianto() {
		return (it.csi.sigit.sigitwebn.dto.allegati.AllegatiPerImpianto) (getSession()
				.get("appDatagestioneAllegatiImpianto"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoTipiDocumentoProfilati'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoTipiDocumentoProfilati(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoTipiDocumentoProfilati", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoTipiDocumentoProfilati'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> getAppDataelencoTipiDocumentoProfilati() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoTipiDocumentoProfilati"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataisAbilitazioneDatiAllegato'
	 * @param value
	 * @generated
	 */

	public void setAppDataisAbilitazioneDatiAllegato(java.lang.Boolean value) {
		getSession().put("appDataisAbilitazioneDatiAllegato", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataisAbilitazioneDatiAllegato'
	 * @generated
	 */
	public java.lang.Boolean getAppDataisAbilitazioneDatiAllegato() {
		return (java.lang.Boolean) (getSession().get("appDataisAbilitazioneDatiAllegato"));
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
	 * imposta il valore dell' ApplicationData 'appDataelencoApparecchiature'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoApparecchiature(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoApparecchiature", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoApparecchiature'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> getAppDataelencoApparecchiature() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoApparecchiature"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoTipiCombustibile'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoTipiCombustibile(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoTipiCombustibile", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoTipiCombustibile'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> getAppDataelencoTipiCombustibile() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoTipiCombustibile"));
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

	////////////////////////////////////////////////////////////////////
	/// campi per widget semplici
	////////////////////////////////////////////////////////////////////

}
