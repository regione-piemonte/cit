package it.csi.sigit.elencom.dto;

import java.util.*;
import com.opensymphony.xwork2.validator.annotations.*;
import it.csi.sigit.elencom.dto.common.*;
import it.csi.sigit.elencom.dto.ricercamanutentoretns.*;

/**
 * Questo DTO incapsula tutto il contenuto informativo necessario all'esecuzione della
 * logica di business associata al Menu
 */
public class GlobalMenuModel extends BaseSessionAwareDTO {

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	////////////////////////////////////////////////////////////////////
	/// application data
	////////////////////////////////////////////////////////////////////

	/**
	 * imposta il valore dell' ApplicationData 'appDataUrlHome'
	 * @param value
	 * @generated
	 */

	public void setAppDataUrlHome(java.lang.String value) {
		getSession().put("appDataUrlHome", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataUrlHome'
	 * @generated
	 */
	public java.lang.String getAppDataUrlHome() {
		return (java.lang.String) (getSession().get("appDataUrlHome"));
	}

}
