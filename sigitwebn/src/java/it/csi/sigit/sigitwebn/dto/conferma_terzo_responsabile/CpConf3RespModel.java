package it.csi.sigit.sigitwebn.dto.conferma_terzo_responsabile;

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
 * logica di business associata alla Schermata [cpConf3Resp]
 */
@Validation
public class CpConf3RespModel extends BaseSessionAwareDTO {

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
	 * imposta il valore dell' ApplicationData 'appDataelencoProvincePiemonte'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoProvincePiemonte(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoProvincePiemonte", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoProvincePiemonte'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> getAppDataelencoProvincePiemonte() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoProvincePiemonte"));
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
	 * imposta il valore dell' ApplicationData 'appDataimpianto'
	 * @param value
	 * @generated
	 */

	public void setAppDataimpianto(it.csi.sigit.sigitwebn.dto.impianto.Impianto value) {
		getSession().put("appDataimpianto", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataimpianto'
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.impianto.Impianto getAppDataimpianto() {
		return (it.csi.sigit.sigitwebn.dto.impianto.Impianto) (getSession().get("appDataimpianto"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoIndirizzi3Resp'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoIndirizzi3Resp(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoIndirizzi3Resp", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoIndirizzi3Resp'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> getAppDataelencoIndirizzi3Resp() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoIndirizzi3Resp"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataterzoResponsabile'
	 * @param value
	 * @generated
	 */

	public void setAppDataterzoResponsabile(it.csi.sigit.sigitwebn.dto.terzoresponsabile.TerzoResponsabile value) {
		getSession().put("appDataterzoResponsabile", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataterzoResponsabile'
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.terzoresponsabile.TerzoResponsabile getAppDataterzoResponsabile() {
		return (it.csi.sigit.sigitwebn.dto.terzoresponsabile.TerzoResponsabile) (getSession()
				.get("appDataterzoResponsabile"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoResponsabiliImpianto'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoResponsabiliImpianto(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.impianto.RisultatoRicResponsabile> value) {
		getSession().put("appDataelencoResponsabiliImpianto", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoResponsabiliImpianto'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.impianto.RisultatoRicResponsabile> getAppDataelencoResponsabiliImpianto() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.impianto.RisultatoRicResponsabile>) (getSession()
				.get("appDataelencoResponsabiliImpianto"));
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
	 * imposta il valore dell' ApplicationData 'appDatadettaglioTerzoResponsabile'
	 * @param value
	 * @generated
	 */

	public void setAppDatadettaglioTerzoResponsabile(
			it.csi.sigit.sigitwebn.dto.terzoresponsabile.DettaglioTerzoResponsabile value) {
		getSession().put("appDatadettaglioTerzoResponsabile", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatadettaglioTerzoResponsabile'
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.terzoresponsabile.DettaglioTerzoResponsabile getAppDatadettaglioTerzoResponsabile() {
		return (it.csi.sigit.sigitwebn.dto.terzoresponsabile.DettaglioTerzoResponsabile) (getSession()
				.get("appDatadettaglioTerzoResponsabile"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoApp3Responsabile'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoApp3Responsabile(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoApp3Responsabile", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoApp3Responsabile'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> getAppDataelencoApp3Responsabile() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoApp3Responsabile"));
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
	 * imposta il valore dell' ApplicationData 'appDataelencoAutodichiarazioni'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoAutodichiarazioni(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.IdDescription> value) {
		getSession().put("appDataelencoAutodichiarazioni", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoAutodichiarazioni'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.IdDescription> getAppDataelencoAutodichiarazioni() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.IdDescription>) (getSession()
				.get("appDataelencoAutodichiarazioni"));
	}

	/**
	 * @generated
	 */
	private java.util.ArrayList<java.lang.Integer> appDataelencoIdSelezionati = new java.util.ArrayList<java.lang.Integer>();

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoIdSelezionati'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoIdSelezionati(java.util.ArrayList<java.lang.Integer> value) {
		appDataelencoIdSelezionati = value;
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoIdSelezionati'
	 * @generated
	 */
	public java.util.ArrayList<java.lang.Integer> getAppDataelencoIdSelezionati() {
		return appDataelencoIdSelezionati;
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoTipiCessazione'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoTipiCessazione(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.IdDescription> value) {
		getSession().put("appDataelencoTipiCessazione", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoTipiCessazione'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.IdDescription> getAppDataelencoTipiCessazione() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.IdDescription>) (getSession()
				.get("appDataelencoTipiCessazione"));
	}

	////////////////////////////////////////////////////////////////////
	/// campi per widget semplici
	////////////////////////////////////////////////////////////////////

}
