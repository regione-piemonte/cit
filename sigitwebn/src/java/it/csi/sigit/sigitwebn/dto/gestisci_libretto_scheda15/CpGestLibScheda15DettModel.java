package it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda15;

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
 * logica di business associata alla Schermata [cpGestLibScheda15Dett]
 */
@Validation
public class CpGestLibScheda15DettModel extends BaseSessionAwareDTO {

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
	 * imposta il valore dell' ApplicationData 'appDatalibrettoMenuTree'
	 * @param value
	 * @generated
	 */

	public void setAppDatalibrettoMenuTree(it.csi.custom.component.tree.base.TreeNode value) {
		getSession().put("appDatalibrettoMenuTree", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatalibrettoMenuTree'
	 * @generated
	 */
	public it.csi.custom.component.tree.base.TreeNode getAppDatalibrettoMenuTree() {
		return (it.csi.custom.component.tree.base.TreeNode) (getSession().get("appDatalibrettoMenuTree"));
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
	 * imposta il valore dell' ApplicationData 'appDatadettaglioManutenzione'
	 * @param value
	 * @generated
	 */

	public void setAppDatadettaglioManutenzione(it.csi.sigit.sigitwebn.dto.libretto.DettaglioManutenzione value) {
		getSession().put("appDatadettaglioManutenzione", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatadettaglioManutenzione'
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.libretto.DettaglioManutenzione getAppDatadettaglioManutenzione() {
		return (it.csi.sigit.sigitwebn.dto.libretto.DettaglioManutenzione) (getSession()
				.get("appDatadettaglioManutenzione"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoTipoManutenzione'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoTipoManutenzione(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoTipoManutenzione", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoTipoManutenzione'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> getAppDataelencoTipoManutenzione() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoTipoManutenzione"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoApparecchiatureManut'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoApparecchiatureManut(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoApparecchiatureManut", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoApparecchiatureManut'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> getAppDataelencoApparecchiatureManut() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoApparecchiatureManut"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoTipoIntervento'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoTipoIntervento(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoTipoIntervento", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoTipoIntervento'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> getAppDataelencoTipoIntervento() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoTipoIntervento"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataisNuovoComponente'
	 * @param value
	 * @generated
	 */

	public void setAppDataisNuovoComponente(java.lang.Boolean value) {
		getSession().put("appDataisNuovoComponente", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataisNuovoComponente'
	 * @generated
	 */
	public java.lang.Boolean getAppDataisNuovoComponente() {
		return (java.lang.Boolean) (getSession().get("appDataisNuovoComponente"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatarigaSelezionata'
	 * @param value
	 * @generated
	 */

	public void setAppDatarigaSelezionata(java.lang.String value) {
		getSession().put("appDatarigaSelezionata", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatarigaSelezionata'
	 * @generated
	 */
	public java.lang.String getAppDatarigaSelezionata() {
		return (java.lang.String) (getSession().get("appDatarigaSelezionata"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatadocumento'
	 * @param value
	 * @generated
	 */

	public void setAppDatadocumento(it.csi.sigit.sigitwebn.dto.documentazione.Documento value) {
		getSession().put("appDatadocumento", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatadocumento'
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.documentazione.Documento getAppDatadocumento() {
		return (it.csi.sigit.sigitwebn.dto.documentazione.Documento) (getSession().get("appDatadocumento"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoDocumenti'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoDocumenti(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.documentazione.Documento> value) {
		getSession().put("appDataelencoDocumenti", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoDocumenti'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.documentazione.Documento> getAppDataelencoDocumenti() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.documentazione.Documento>) (getSession()
				.get("appDataelencoDocumenti"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataidDocumentoSelezionato'
	 * @param value
	 * @generated
	 */

	public void setAppDataidDocumentoSelezionato(java.lang.Integer value) {
		getSession().put("appDataidDocumentoSelezionato", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidDocumentoSelezionato'
	 * @generated
	 */
	public java.lang.Integer getAppDataidDocumentoSelezionato() {
		return (java.lang.Integer) (getSession().get("appDataidDocumentoSelezionato"));
	}

	////////////////////////////////////////////////////////////////////
	/// campi per widget semplici
	////////////////////////////////////////////////////////////////////

	// FileUpload widg_fuUploadDoc
	private File widgFuUploadDoc; // The actual file(s)
	private String widgFuUploadDocContentType; // The content type of the file(s) 
	private String widgFuUploadDocFileName; // The uploaded file(s) name and path 

	public void setWidg_fuUploadDoc(File value) {
		widgFuUploadDoc = value;
	}
	@JSON(include = false)
	public File getWidg_fuUploadDoc() {
		return widgFuUploadDoc;
	}

	public void setWidg_fuUploadDocContentType(String value) {
		widgFuUploadDocContentType = value;
	}
	@JSON(include = false)
	public String getWidg_fuUploadDocContentType() {
		return widgFuUploadDocContentType;
	}

	public void setWidg_fuUploadDocFileName(String value) {
		widgFuUploadDocFileName = value;
	}
	@JSON(include = false)
	public String getWidg_fuUploadDocFileName() {
		return widgFuUploadDocFileName;
	}

}
