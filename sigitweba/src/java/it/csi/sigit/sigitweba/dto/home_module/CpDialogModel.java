package it.csi.sigit.sigitweba.dto.home_module;

import java.util.*;
import it.csi.sigit.sigitweba.dto.*;
import it.csi.sigit.sigitweba.dto.common.*;
import it.csi.sigit.sigitweba.dto.accreditamento_tns.*;

import it.csi.sigit.sigitweba.presentation.uiutils.*;
import flexjson.JSON;
import com.opensymphony.xwork2.conversion.annotations.*;
import com.opensymphony.xwork2.validator.annotations.*;

/**
 * Questo DTO incapsula tutto il contenuto informativo necessario all'esecuzione della
 * logica di business associata alla Schermata [cpDialog]
 */
@Validation
public class CpDialogModel extends BaseSessionAwareDTO {

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	////////////////////////////////////////////////////////////////////
	/// application data
	////////////////////////////////////////////////////////////////////

	/**
	 * imposta il valore dell' ApplicationData 'appDatamessaggioErrore'
	 * @param value
	 * @generated
	 */

	public void setAppDatamessaggioErrore(java.lang.String value) {
		getSession().put("appDatamessaggioErrore", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatamessaggioErrore'
	 * @generated
	 */
	public java.lang.String getAppDatamessaggioErrore() {
		return (java.lang.String) (getSession().get("appDatamessaggioErrore"));
	}

	////////////////////////////////////////////////////////////////////
	/// campi per widget semplici
	////////////////////////////////////////////////////////////////////

	// HiddenValue hvIngressoWARN

	private java.lang.String widgHvIngressoWARN;

	public void setWidg_hvIngressoWARN(java.lang.String value) {
		widgHvIngressoWARN = value;
	}

	public java.lang.String getWidg_hvIngressoWARN() {
		return widgHvIngressoWARN;
	}

}
