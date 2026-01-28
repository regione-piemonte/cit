package it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti;

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
 * logica di business associata alla Schermata [cpDettaglioIspezione]
 */
@Validation
public class CpDettaglioIspezioneModel extends BaseSessionAwareDTO {

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
	 * imposta il valore dell' ApplicationData 'appDataelencoAllegatiIsp'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoAllegatiIsp(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.allegati.DettaglioAllegato> value) {
		getSession().put("appDataelencoAllegatiIsp", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoAllegatiIsp'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.allegati.DettaglioAllegato> getAppDataelencoAllegatiIsp() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.allegati.DettaglioAllegato>) (getSession()
				.get("appDataelencoAllegatiIsp"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataispezione'
	 * @param value
	 * @generated
	 */

	public void setAppDataispezione(it.csi.sigit.sigitwebn.dto.ispezioni.DettaglioIspezione value) {
		getSession().put("appDataispezione", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataispezione'
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.ispezioni.DettaglioIspezione getAppDataispezione() {
		return (it.csi.sigit.sigitwebn.dto.ispezioni.DettaglioIspezione) (getSession().get("appDataispezione"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataallegatoIsp'
	 * @param value
	 * @generated
	 */

	public void setAppDataallegatoIsp(it.csi.sigit.sigitwebn.dto.allegati.DettaglioAllegato value) {
		getSession().put("appDataallegatoIsp", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataallegatoIsp'
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.allegati.DettaglioAllegato getAppDataallegatoIsp() {
		return (it.csi.sigit.sigitwebn.dto.allegati.DettaglioAllegato) (getSession().get("appDataallegatoIsp"));
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
	 * imposta il valore dell' ApplicationData 'appDataidAllegatoIspSelezionato'
	 * @param value
	 * @generated
	 */

	public void setAppDataidAllegatoIspSelezionato(java.lang.Integer value) {
		getSession().put("appDataidAllegatoIspSelezionato", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidAllegatoIspSelezionato'
	 * @generated
	 */
	public java.lang.Integer getAppDataidAllegatoIspSelezionato() {
		return (java.lang.Integer) (getSession().get("appDataidAllegatoIspSelezionato"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoTipiDocumentoProfilatiIsp'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoTipiDocumentoProfilatiIsp(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoTipiDocumentoProfilatiIsp", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoTipiDocumentoProfilatiIsp'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> getAppDataelencoTipiDocumentoProfilatiIsp() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoTipiDocumentoProfilatiIsp"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoTipiCombustibileIsp'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoTipiCombustibileIsp(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoTipiCombustibileIsp", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoTipiCombustibileIsp'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> getAppDataelencoTipiCombustibileIsp() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoTipiCombustibileIsp"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoApparecchiatureIsp'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoApparecchiatureIsp(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoApparecchiatureIsp", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoApparecchiatureIsp'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> getAppDataelencoApparecchiatureIsp() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoApparecchiatureIsp"));
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
	 * imposta il valore dell' ApplicationData 'appDataidIspezioneImpiantoSelezionato'
	 * @param value
	 * @generated
	 */

	public void setAppDataidIspezioneImpiantoSelezionato(java.lang.Integer value) {
		getSession().put("appDataidIspezioneImpiantoSelezionato", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidIspezioneImpiantoSelezionato'
	 * @generated
	 */
	public java.lang.Integer getAppDataidIspezioneImpiantoSelezionato() {
		return (java.lang.Integer) (getSession().get("appDataidIspezioneImpiantoSelezionato"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataaggiornaElencoIspezioniAllegati'
	 * @param value
	 * @generated
	 */

	public void setAppDataaggiornaElencoIspezioniAllegati(java.lang.Boolean value) {
		getSession().put("appDataaggiornaElencoIspezioniAllegati", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataaggiornaElencoIspezioniAllegati'
	 * @generated
	 */
	public java.lang.Boolean getAppDataaggiornaElencoIspezioniAllegati() {
		return (java.lang.Boolean) (getSession().get("appDataaggiornaElencoIspezioniAllegati"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataRicercaApparecchiatureRappProva'
	 * @param value
	 * @generated
	 */

	public void setAppDataRicercaApparecchiatureRappProva(
			it.csi.sigit.sigitwebn.dto.ispezioni.RicercaApparecchiatureRappProva value) {
		getSession().put("appDataRicercaApparecchiatureRappProva", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataRicercaApparecchiatureRappProva'
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.ispezioni.RicercaApparecchiatureRappProva getAppDataRicercaApparecchiatureRappProva() {
		return (it.csi.sigit.sigitwebn.dto.ispezioni.RicercaApparecchiatureRappProva) (getSession()
				.get("appDataRicercaApparecchiatureRappProva"));
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

}
