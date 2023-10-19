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
 * logica di business associata alla Schermata [cpRicerca]
 */
@Validation
public class CpRicercaModel extends BaseSessionAwareDTO {

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	////////////////////////////////////////////////////////////////////
	/// application data
	////////////////////////////////////////////////////////////////////

	/**
	 * imposta il valore dell' ApplicationData 'appDatacrumbs'
	 * @param value
	 * @generated
	 */

	public void setAppDatacrumbs(java.util.ArrayList<java.lang.String> value) {
		getSession().put("appDatacrumbs", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatacrumbs'
	 * @generated
	 */
	public java.util.ArrayList<java.lang.String> getAppDatacrumbs() {
		return (java.util.ArrayList<java.lang.String>) (getSession().get("appDatacrumbs"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatacurrentUser'
	 * @param value
	 * @generated
	 */

	public void setAppDatacurrentUser(it.csi.sigit.elencom.dto.common.UserInfo value) {
		getSession().put("appDatacurrentUser", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatacurrentUser'
	 * @generated
	 */
	public it.csi.sigit.elencom.dto.common.UserInfo getAppDatacurrentUser() {
		return (it.csi.sigit.elencom.dto.common.UserInfo) (getSession().get("appDatacurrentUser"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataTreeStatus'
	 * @param value
	 * @generated
	 */

	public void setAppDataTreeStatus(it.csi.custom.component.tree.base.TreeStatus value) {
		getSession().put("appDataTreeStatus", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataTreeStatus'
	 * @generated
	 */
	public it.csi.custom.component.tree.base.TreeStatus getAppDataTreeStatus() {
		return (it.csi.custom.component.tree.base.TreeStatus) (getSession().get("appDataTreeStatus"));
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
	 * imposta il valore dell' ApplicationData 'appDatafiltroManutentore'
	 * @param value
	 * @generated
	 */
	@VisitorFieldValidator(message = "", key = "cpRicerca.filtroManutentore.visitorvalidator.label", appendPrefix = true)
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
	 * imposta il valore dell' ApplicationData 'appDatamanutentoreAppData'
	 * @param value
	 * @generated
	 */
	@VisitorFieldValidator(message = "", key = "cpRicerca.manutentoreAppData.visitorvalidator.label", appendPrefix = true)
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
	 * imposta il valore dell' ApplicationData 'appDatamanutentoriAppData'
	 * @param value
	 * @generated
	 */
	@VisitorFieldValidator(message = "", key = "cpRicerca.manutentoriAppData.visitorvalidator.label", appendPrefix = true)
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
	 * imposta il valore dell' ApplicationData 'appDataidManutentoreSelezionato'
	 * @param value
	 * @generated
	 */

	public void setAppDataidManutentoreSelezionato(java.lang.String value) {
		getSession().put("appDataidManutentoreSelezionato", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidManutentoreSelezionato'
	 * @generated
	 */
	public java.lang.String getAppDataidManutentoreSelezionato() {
		return (java.lang.String) (getSession().get("appDataidManutentoreSelezionato"));
	}

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

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoCorsi'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoCorsi(java.util.ArrayList<it.csi.sigit.elencom.dto.ricercamanutentoretns.Corso> value) {
		getSession().put("appDataelencoCorsi", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoCorsi'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.elencom.dto.ricercamanutentoretns.Corso> getAppDataelencoCorsi() {
		return (java.util.ArrayList<it.csi.sigit.elencom.dto.ricercamanutentoretns.Corso>) (getSession()
				.get("appDataelencoCorsi"));
	}

	////////////////////////////////////////////////////////////////////
	/// campi per widget semplici
	////////////////////////////////////////////////////////////////////

	// HiddenValue hvDettWMS

	private java.lang.String widgHvDettWMS;

	public void setWidg_hvDettWMS(java.lang.String value) {
		widgHvDettWMS = value;
	}

	public java.lang.String getWidg_hvDettWMS() {
		return widgHvDettWMS;
	}

	// Table tbCorsi

	private java.lang.String widgTbCorsi;

	public void setWidg_tbCorsi(java.lang.String value) {
		widgTbCorsi = value;
	}

	public java.lang.String getWidg_tbCorsi() {
		return widgTbCorsi;
	}

}
