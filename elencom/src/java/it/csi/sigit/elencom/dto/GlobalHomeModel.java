package it.csi.sigit.elencom.dto;

import java.util.*;
import com.opensymphony.xwork2.validator.annotations.*;
import it.csi.sigit.elencom.dto.common.*;
import it.csi.sigit.elencom.dto.ricercamanutentoretns.*;

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
	 * imposta il valore dell' ApplicationData 'appDatacomboProvince'
	 * @param value
	 * @generated
	 */

	public void setAppDatacomboProvince(
			java.util.ArrayList<it.csi.sigit.elencom.dto.ricercamanutentoretns.CodiceDescrizione> value) {
		getSession().put("appDatacomboProvince", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatacomboProvince'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.elencom.dto.ricercamanutentoretns.CodiceDescrizione> getAppDatacomboProvince() {
		return (java.util.ArrayList<it.csi.sigit.elencom.dto.ricercamanutentoretns.CodiceDescrizione>) (getSession()
				.get("appDatacomboProvince"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatamanutentoriAppData'
	 * @param value
	 * @generated
	 */

	public void setAppDatamanutentoriAppData(
			java.util.ArrayList<it.csi.sigit.elencom.dto.ricercamanutentoretns.Manutentore> value) {
		getSession().put("appDatamanutentoriAppData", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatamanutentoriAppData'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.elencom.dto.ricercamanutentoretns.Manutentore> getAppDatamanutentoriAppData() {
		return (java.util.ArrayList<it.csi.sigit.elencom.dto.ricercamanutentoretns.Manutentore>) (getSession()
				.get("appDatamanutentoriAppData"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatafiltroManutentore'
	 * @param value
	 * @generated
	 */

	public void setAppDatafiltroManutentore(it.csi.sigit.elencom.dto.ricercamanutentoretns.FiltroManutentore value) {
		getSession().put("appDatafiltroManutentore", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatafiltroManutentore'
	 * @generated
	 */
	public it.csi.sigit.elencom.dto.ricercamanutentoretns.FiltroManutentore getAppDatafiltroManutentore() {
		return (it.csi.sigit.elencom.dto.ricercamanutentoretns.FiltroManutentore) (getSession()
				.get("appDatafiltroManutentore"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatacomboComuni'
	 * @param value
	 * @generated
	 */

	public void setAppDatacomboComuni(
			java.util.ArrayList<it.csi.sigit.elencom.dto.ricercamanutentoretns.CodiceDescrizione> value) {
		getSession().put("appDatacomboComuni", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatacomboComuni'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.elencom.dto.ricercamanutentoretns.CodiceDescrizione> getAppDatacomboComuni() {
		return (java.util.ArrayList<it.csi.sigit.elencom.dto.ricercamanutentoretns.CodiceDescrizione>) (getSession()
				.get("appDatacomboComuni"));
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
	 * imposta il valore dell' ApplicationData 'appDatamanutentoreAppData'
	 * @param value
	 * @generated
	 */

	public void setAppDatamanutentoreAppData(it.csi.sigit.elencom.dto.ricercamanutentoretns.Manutentore value) {
		getSession().put("appDatamanutentoreAppData", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatamanutentoreAppData'
	 * @generated
	 */
	public it.csi.sigit.elencom.dto.ricercamanutentoretns.Manutentore getAppDatamanutentoreAppData() {
		return (it.csi.sigit.elencom.dto.ricercamanutentoretns.Manutentore) (getSession()
				.get("appDatamanutentoreAppData"));
	}

	/**
	 * Activation Param [wms]
	 * @generated
	 */
	private java.lang.String wms = null;

	/**
	 * imposta il valore dell' Activation Param [wms]
	 * @praram val
	 * @generated
	 */
	public void setWms(java.lang.String val) {
		wms = val;
	}

	/**
	 * legge il valore dell' Activation Param [wms]
	 * @generated
	 */
	public java.lang.String getWms() {
		return wms;
	}

	/**
	 * Activation Param [comp]
	 * @generated
	 */
	private java.lang.String comp = null;

	/**
	 * imposta il valore dell' Activation Param [comp]
	 * @praram val
	 * @generated
	 */
	public void setComp(java.lang.String val) {
		comp = val;
	}

	/**
	 * legge il valore dell' Activation Param [comp]
	 * @generated
	 */
	public java.lang.String getComp() {
		return comp;
	}

}
