package it.csi.sigit.elencom.dto.ricerca_module;

import java.util.*;
import it.csi.sigit.elencom.dto.*;
import it.csi.sigit.elencom.dto.common.*;
import it.csi.sigit.elencom.dto.ricercamanutentoretns.*;

import it.csi.sigit.elencom.presentation.uiutils.*;
import flexjson.JSON;
import com.opensymphony.xwork2.conversion.annotations.*;
import com.opensymphony.xwork2.validator.annotations.*;

/**
 * Questo DTO incapsula tutto il contenuto informativo necessario all'esecuzione della
 * logica di business associata alla Schermata [cpDettWMS]
 */
@Validation
public class CpDettWMSModel extends BaseSessionAwareDTO {

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	////////////////////////////////////////////////////////////////////
	/// application data
	////////////////////////////////////////////////////////////////////

	/**
	 * imposta il valore dell' ApplicationData 'appDatacurrentDettaglioGeografico'
	 * @param value
	 * @generated
	 */

	public void setAppDatacurrentDettaglioGeografico(it.csi.sigit.elencom.dto.common.DettaglioGeograficoPortale value) {
		getSession().put("appDatacurrentDettaglioGeografico", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatacurrentDettaglioGeografico'
	 * @generated
	 */
	public it.csi.sigit.elencom.dto.common.DettaglioGeograficoPortale getAppDatacurrentDettaglioGeografico() {
		return (it.csi.sigit.elencom.dto.common.DettaglioGeograficoPortale) (getSession()
				.get("appDatacurrentDettaglioGeografico"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatalistDettaglioGeografico'
	 * @param value
	 * @generated
	 */

	public void setAppDatalistDettaglioGeografico(
			java.util.ArrayList<it.csi.sigit.elencom.dto.common.DettaglioGeograficoPortale> value) {
		getSession().put("appDatalistDettaglioGeografico", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatalistDettaglioGeografico'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.elencom.dto.common.DettaglioGeograficoPortale> getAppDatalistDettaglioGeografico() {
		return (java.util.ArrayList<it.csi.sigit.elencom.dto.common.DettaglioGeograficoPortale>) (getSession()
				.get("appDatalistDettaglioGeografico"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatapaginaSelezionata'
	 * @param value
	 * @generated
	 */

	public void setAppDatapaginaSelezionata(java.lang.Integer value) {
		getSession().put("appDatapaginaSelezionata", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatapaginaSelezionata'
	 * @generated
	 */
	public java.lang.Integer getAppDatapaginaSelezionata() {
		return (java.lang.Integer) (getSession().get("appDatapaginaSelezionata"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataWMSComp'
	 * @param value
	 * @generated
	 */

	public void setAppDataWMSComp(java.lang.String value) {
		getSession().put("appDataWMSComp", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataWMSComp'
	 * @generated
	 */
	public java.lang.String getAppDataWMSComp() {
		return (java.lang.String) (getSession().get("appDataWMSComp"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataWMSCoordinates'
	 * @param value
	 * @generated
	 */

	public void setAppDataWMSCoordinates(java.lang.String value) {
		getSession().put("appDataWMSCoordinates", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataWMSCoordinates'
	 * @generated
	 */
	public java.lang.String getAppDataWMSCoordinates() {
		return (java.lang.String) (getSession().get("appDataWMSCoordinates"));
	}

	////////////////////////////////////////////////////////////////////
	/// campi per widget semplici
	////////////////////////////////////////////////////////////////////

}
