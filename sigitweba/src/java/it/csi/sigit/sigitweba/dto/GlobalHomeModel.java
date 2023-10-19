package it.csi.sigit.sigitweba.dto;

import java.util.*;
import com.opensymphony.xwork2.validator.annotations.*;
import it.csi.sigit.sigitweba.dto.common.*;
import it.csi.sigit.sigitweba.dto.accreditamento_tns.*;

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

	/**
	 * imposta il valore dell' ApplicationData 'appDatacurrentUser'
	 * @param value
	 * @generated
	 */

	public void setAppDatacurrentUser(it.csi.sigit.sigitweba.dto.common.UserInfo value) {
		getSession().put("appDatacurrentUser", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatacurrentUser'
	 * @generated
	 */
	public it.csi.sigit.sigitweba.dto.common.UserInfo getAppDatacurrentUser() {
		return (it.csi.sigit.sigitweba.dto.common.UserInfo) (getSession().get("appDatacurrentUser"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatapersonaFisica'
	 * @param value
	 * @generated
	 */

	public void setAppDatapersonaFisica(it.csi.sigit.sigitweba.dto.accreditamento_tns.PersonaFisica value) {
		getSession().put("appDatapersonaFisica", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatapersonaFisica'
	 * @generated
	 */
	public it.csi.sigit.sigitweba.dto.accreditamento_tns.PersonaFisica getAppDatapersonaFisica() {
		return (it.csi.sigit.sigitweba.dto.accreditamento_tns.PersonaFisica) (getSession().get("appDatapersonaFisica"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataisPrimoIngresso'
	 * @param value
	 * @generated
	 */

	public void setAppDataisPrimoIngresso(java.lang.Boolean value) {
		getSession().put("appDataisPrimoIngresso", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataisPrimoIngresso'
	 * @generated
	 */
	public java.lang.Boolean getAppDataisPrimoIngresso() {
		return (java.lang.Boolean) (getSession().get("appDataisPrimoIngresso"));
	}

}
