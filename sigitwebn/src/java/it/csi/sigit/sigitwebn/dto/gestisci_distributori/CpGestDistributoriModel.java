package it.csi.sigit.sigitwebn.dto.gestisci_distributori;

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
 * logica di business associata alla Schermata [cpGestDistributori]
 */
@Validation
public class CpGestDistributoriModel extends BaseSessionAwareDTO {

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	////////////////////////////////////////////////////////////////////
	/// application data
	////////////////////////////////////////////////////////////////////

	/**
	 * imposta il valore dell' ApplicationData 'appDatadettaglioImportDistributori'
	 * @param value
	 * @generated
	 */

	public void setAppDatadettaglioImportDistributori(
			it.csi.sigit.sigitwebn.dto.distributori.DettaglioImportDistributori value) {
		getSession().put("appDatadettaglioImportDistributori", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatadettaglioImportDistributori'
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.distributori.DettaglioImportDistributori getAppDatadettaglioImportDistributori() {
		return (it.csi.sigit.sigitwebn.dto.distributori.DettaglioImportDistributori) (getSession()
				.get("appDatadettaglioImportDistributori"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatadistributori'
	 * @param value
	 * @generated
	 */

	public void setAppDatadistributori(it.csi.sigit.sigitwebn.dto.distributori.Distributore value) {
		getSession().put("appDatadistributori", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatadistributori'
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.distributori.Distributore getAppDatadistributori() {
		return (it.csi.sigit.sigitwebn.dto.distributori.Distributore) (getSession().get("appDatadistributori"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoErroriImport'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoErroriImport(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.distributori.DettaglioErrore> value) {
		getSession().put("appDataelencoErroriImport", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoErroriImport'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.distributori.DettaglioErrore> getAppDataelencoErroriImport() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.distributori.DettaglioErrore>) (getSession()
				.get("appDataelencoErroriImport"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoImportDistributori'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoImportDistributori(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.distributori.DettaglioImportDistributori> value) {
		getSession().put("appDataelencoImportDistributori", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoImportDistributori'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.distributori.DettaglioImportDistributori> getAppDataelencoImportDistributori() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.distributori.DettaglioImportDistributori>) (getSession()
				.get("appDataelencoImportDistributori"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataidFileInviatoSelez'
	 * @param value
	 * @generated
	 */

	public void setAppDataidFileInviatoSelez(java.lang.Integer value) {
		getSession().put("appDataidFileInviatoSelez", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidFileInviatoSelez'
	 * @generated
	 */
	public java.lang.Integer getAppDataidFileInviatoSelez() {
		return (java.lang.Integer) (getSession().get("appDataidFileInviatoSelez"));
	}

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
	 * imposta il valore dell' ApplicationData 'appDatadistributoreManuale'
	 * @param value
	 * @generated
	 */

	public void setAppDatadistributoreManuale(it.csi.sigit.sigitwebn.dto.distributori.DistributoreMan value) {
		getSession().put("appDatadistributoreManuale", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatadistributoreManuale'
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.distributori.DistributoreMan getAppDatadistributoreManuale() {
		return (it.csi.sigit.sigitwebn.dto.distributori.DistributoreMan) (getSession()
				.get("appDatadistributoreManuale"));
	}

	////////////////////////////////////////////////////////////////////
	/// campi per widget semplici
	////////////////////////////////////////////////////////////////////

	// FileUpload widg_fuImport
	private List<File> widgFuImport; // The actual file(s)
	private List<String> widgFuImportContentType; // The content type of the file(s) 
	private List<String> widgFuImportFileName; // The uploaded file(s) name and path 

	public void setWidg_fuImport(List<File> value) {
		widgFuImport = value;
	}
	@JSON(include = false)
	public List<File> getWidg_fuImport() {
		return widgFuImport;
	}

	public void setWidg_fuImportContentType(List<String> value) {
		widgFuImportContentType = value;
	}
	@JSON(include = false)
	public List<String> getWidg_fuImportContentType() {
		return widgFuImportContentType;
	}

	public void setWidg_fuImportFileName(List<String> value) {
		widgFuImportFileName = value;
	}
	@JSON(include = false)
	public List<String> getWidg_fuImportFileName() {
		return widgFuImportFileName;
	}

	// Table tbElencoErrori

	private java.lang.String widgTbElencoErrori;

	public void setWidg_tbElencoErrori(java.lang.String value) {
		widgTbElencoErrori = value;
	}

	public java.lang.String getWidg_tbElencoErrori() {
		return widgTbElencoErrori;
	}

}
