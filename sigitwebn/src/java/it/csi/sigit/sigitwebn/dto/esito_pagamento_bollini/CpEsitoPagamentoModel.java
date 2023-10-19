package it.csi.sigit.sigitwebn.dto.esito_pagamento_bollini;

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
 * logica di business associata alla Schermata [cpEsitoPagamento]
 */
@Validation
public class CpEsitoPagamentoModel extends BaseSessionAwareDTO {

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	////////////////////////////////////////////////////////////////////
	/// application data
	////////////////////////////////////////////////////////////////////

	/**
	 * imposta il valore dell' ApplicationData 'appDatamsgPagamento'
	 * @param value
	 * @generated
	 */

	public void setAppDatamsgPagamento(java.lang.String value) {
		getSession().put("appDatamsgPagamento", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatamsgPagamento'
	 * @generated
	 */
	public java.lang.String getAppDatamsgPagamento() {
		return (java.lang.String) (getSession().get("appDatamsgPagamento"));
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

	////////////////////////////////////////////////////////////////////
	/// campi per widget semplici
	////////////////////////////////////////////////////////////////////

	// HiddenValue hvPagamentoOK

	private java.lang.String widgHvPagamentoOK;

	public void setWidg_hvPagamentoOK(java.lang.String value) {
		widgHvPagamentoOK = value;
	}

	public java.lang.String getWidg_hvPagamentoOK() {
		return widgHvPagamentoOK;
	}
	// HiddenValue hvPagamentoKO

	private java.lang.String widgHvPagamentoKO;

	public void setWidg_hvPagamentoKO(java.lang.String value) {
		widgHvPagamentoKO = value;
	}

	public java.lang.String getWidg_hvPagamentoKO() {
		return widgHvPagamentoKO;
	}
	// HiddenValue hvPagamentoABORT

	private java.lang.String widgHvPagamentoABORT;

	public void setWidg_hvPagamentoABORT(java.lang.String value) {
		widgHvPagamentoABORT = value;
	}

	public java.lang.String getWidg_hvPagamentoABORT() {
		return widgHvPagamentoABORT;
	}
	// HiddenValue hvPagamentoANOMAL

	private java.lang.String widgHvPagamentoANOMAL;

	public void setWidg_hvPagamentoANOMAL(java.lang.String value) {
		widgHvPagamentoANOMAL = value;
	}

	public java.lang.String getWidg_hvPagamentoANOMAL() {
		return widgHvPagamentoANOMAL;
	}

}
