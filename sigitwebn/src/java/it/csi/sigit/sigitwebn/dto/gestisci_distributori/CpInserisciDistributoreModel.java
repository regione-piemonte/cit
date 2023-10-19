package it.csi.sigit.sigitwebn.dto.gestisci_distributori;

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
 * logica di business associata alla Schermata [cpInserisciDistributore]
 */
@Validation
public class CpInserisciDistributoreModel extends BaseSessionAwareDTO {

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
	 * imposta il valore dell' ApplicationData 'appDataelencoTipoContrattoDistrib'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoTipoContrattoDistrib(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.IdDescription> value) {
		getSession().put("appDataelencoTipoContrattoDistrib", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoTipoContrattoDistrib'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.IdDescription> getAppDataelencoTipoContrattoDistrib() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.IdDescription>) (getSession()
				.get("appDataelencoTipoContrattoDistrib"));
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

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoIndirizziFornitura'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoIndirizziFornitura(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoIndirizziFornitura", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoIndirizziFornitura'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> getAppDataelencoIndirizziFornitura() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoIndirizziFornitura"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoIndirizziFatturazione'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoIndirizziFatturazione(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoIndirizziFatturazione", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoIndirizziFatturazione'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> getAppDataelencoIndirizziFatturazione() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoIndirizziFatturazione"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoTipoCategoria'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoTipoCategoria(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoTipoCategoria", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoTipoCategoria'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> getAppDataelencoTipoCategoria() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoTipoCategoria"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoTipoCombustibile'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoTipoCombustibile(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoTipoCombustibile", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoTipoCombustibile'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> getAppDataelencoTipoCombustibile() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoTipoCombustibile"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoUnitaMisura'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoUnitaMisura(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoUnitaMisura", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoUnitaMisura'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> getAppDataelencoUnitaMisura() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoUnitaMisura"));
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
	 * imposta il valore dell' ApplicationData 'appDataelencoComuniFatturazione'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoComuniFatturazione(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoComuniFatturazione", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoComuniFatturazione'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> getAppDataelencoComuniFatturazione() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoComuniFatturazione"));
	}

	////////////////////////////////////////////////////////////////////
	/// campi per widget semplici
	////////////////////////////////////////////////////////////////////

}
