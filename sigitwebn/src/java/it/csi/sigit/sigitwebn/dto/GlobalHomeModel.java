package it.csi.sigit.sigitwebn.dto;

import java.util.*;
import com.opensymphony.xwork2.validator.annotations.*;
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

/**
 * Questo DTO incapsula tutto il contenuto informativo necessario all'esecuzione della
 * logica di business associata alla OnInit action
 */
public class GlobalHomeModel extends BaseSessionAwareDTO {

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	////////////////////////////////////////////////////////////////////
	/// application data
	////////////////////////////////////////////////////////////////////

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
	 * imposta il valore dell' ApplicationData 'appDataruoliTrovatiFiltrati'
	 * @param value
	 * @generated
	 */

	public void setAppDataruoliTrovatiFiltrati(java.util.ArrayList<it.csi.sigit.sigitwebn.dto.accesso.Ruolo> value) {
		getSession().put("appDataruoliTrovatiFiltrati", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataruoliTrovatiFiltrati'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.accesso.Ruolo> getAppDataruoliTrovatiFiltrati() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.accesso.Ruolo>) (getSession()
				.get("appDataruoliTrovatiFiltrati"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoSiglaBollino'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoSiglaBollino(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoSiglaBollino", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoSiglaBollino'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> getAppDataelencoSiglaBollino() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoSiglaBollino"));
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
	 * imposta il valore dell' ApplicationData 'appDataruoliFiltro'
	 * @param value
	 * @generated
	 */

	public void setAppDataruoliFiltro(java.util.ArrayList<it.csi.sigit.sigitwebn.dto.accesso.Ruolo> value) {
		getSession().put("appDataruoliFiltro", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataruoliFiltro'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.accesso.Ruolo> getAppDataruoliFiltro() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.accesso.Ruolo>) (getSession().get("appDataruoliFiltro"));
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
	 * imposta il valore dell' ApplicationData 'appDataruoliTrovati'
	 * @param value
	 * @generated
	 */

	public void setAppDataruoliTrovati(java.util.ArrayList<it.csi.sigit.sigitwebn.dto.accesso.Ruolo> value) {
		getSession().put("appDataruoliTrovati", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataruoliTrovati'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.accesso.Ruolo> getAppDataruoliTrovati() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.accesso.Ruolo>) (getSession()
				.get("appDataruoliTrovati"));
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
	 * imposta il valore dell' ApplicationData 'appDatafiltroRuoloSelez'
	 * @param value
	 * @generated
	 */

	public void setAppDatafiltroRuoloSelez(java.lang.String value) {
		getSession().put("appDatafiltroRuoloSelez", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatafiltroRuoloSelez'
	 * @generated
	 */
	public java.lang.String getAppDatafiltroRuoloSelez() {
		return (java.lang.String) (getSession().get("appDatafiltroRuoloSelez"));
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
	 * imposta il valore dell' ApplicationData 'appDatanumeroTransazione'
	 * @param value
	 * @generated
	 */

	public void setAppDatanumeroTransazione(java.lang.String value) {
		getSession().put("appDatanumeroTransazione", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatanumeroTransazione'
	 * @generated
	 */
	public java.lang.String getAppDatanumeroTransazione() {
		return (java.lang.String) (getSession().get("appDatanumeroTransazione"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataidTransazione'
	 * @param value
	 * @generated
	 */

	public void setAppDataidTransazione(java.lang.Long value) {
		getSession().put("appDataidTransazione", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidTransazione'
	 * @generated
	 */
	public java.lang.Long getAppDataidTransazione() {
		return (java.lang.Long) (getSession().get("appDataidTransazione"));
	}

	/**
	 * Activation Param [tranId]
	 * @generated
	 */
	private java.lang.String tranId = null;

	/**
	 * imposta il valore dell' Activation Param [tranId]
	 * @praram val
	 * @generated
	 */
	public void setTranId(java.lang.String val) {
		tranId = val;
	}

	/**
	 * legge il valore dell' Activation Param [tranId]
	 * @generated
	 */
	public java.lang.String getTranId() {
		return tranId;
	}

}
