package it.csi.sigit.sigitwebn.dto.gestisci_rapprova;

import java.io.File;
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
 * logica di business associata alla Schermata [cpInitRapProva]
 */
@Validation
public class CpInitRapProvaModel extends BaseSessionAwareDTO {

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	////////////////////////////////////////////////////////////////////
	/// application data
	////////////////////////////////////////////////////////////////////

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

	////////////////////////////////////////////////////////////////////
	/// campi per widget semplici
	////////////////////////////////////////////////////////////////////

	// FileUpload widg_fuUploadAllegato
	private File widgFuUploadAllegato; // The actual file(s)
	private String widgFuUploadAllegatoContentType; // The content type of the file(s) 
	private String widgFuUploadAllegatoFileName; // The uploaded file(s) name and path 

	public void setWidg_fuUploadAllegato(File value) {
		widgFuUploadAllegato = value;
	}
	@JSON(include = false)
	public File getWidg_fuUploadAllegato() {
		return widgFuUploadAllegato;
	}

	public void setWidg_fuUploadAllegatoContentType(String value) {
		widgFuUploadAllegatoContentType = value;
	}
	@JSON(include = false)
	public String getWidg_fuUploadAllegatoContentType() {
		return widgFuUploadAllegatoContentType;
	}

	public void setWidg_fuUploadAllegatoFileName(String value) {
		widgFuUploadAllegatoFileName = value;
	}
	@JSON(include = false)
	public String getWidg_fuUploadAllegatoFileName() {
		return widgFuUploadAllegatoFileName;
	}

}
