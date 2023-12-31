package it.csi.sigit.sigitwebn.dto.gestisci_azioni;

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
 * logica di business associata alla Schermata [cpAzione]
 */
@Validation
public class CpAzioneModel extends BaseSessionAwareDTO {

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
	 * imposta il valore dell' ApplicationData 'appDataazione'
	 * @param value
	 * @generated
	 */

	public void setAppDataazione(it.csi.sigit.sigitwebn.dto.azioni.Azione value) {
		getSession().put("appDataazione", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataazione'
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.azioni.Azione getAppDataazione() {
		return (it.csi.sigit.sigitwebn.dto.azioni.Azione) (getSession().get("appDataazione"));
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

	////////////////////////////////////////////////////////////////////
	/// campi per widget semplici
	////////////////////////////////////////////////////////////////////

	// FileUpload widg_fuUpload
	private File widgFuUpload; // The actual file(s)
	private String widgFuUploadContentType; // The content type of the file(s) 
	private String widgFuUploadFileName; // The uploaded file(s) name and path 

	public void setWidg_fuUpload(File value) {
		widgFuUpload = value;
	}
	@JSON(include = false)
	public File getWidg_fuUpload() {
		return widgFuUpload;
	}

	public void setWidg_fuUploadContentType(String value) {
		widgFuUploadContentType = value;
	}
	@JSON(include = false)
	public String getWidg_fuUploadContentType() {
		return widgFuUploadContentType;
	}

	public void setWidg_fuUploadFileName(String value) {
		widgFuUploadFileName = value;
	}
	@JSON(include = false)
	public String getWidg_fuUploadFileName() {
		return widgFuUploadFileName;
	}

}
