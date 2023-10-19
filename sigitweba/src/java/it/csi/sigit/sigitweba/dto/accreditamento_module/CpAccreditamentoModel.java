package it.csi.sigit.sigitweba.dto.accreditamento_module;

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
 * logica di business associata alla Schermata [cpAccreditamento]
 */
@Validation
public class CpAccreditamentoModel extends BaseSessionAwareDTO {

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	////////////////////////////////////////////////////////////////////
	/// application data
	////////////////////////////////////////////////////////////////////

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
	 * imposta il valore dell' ApplicationData 'appDataprovince'
	 * @param value
	 * @generated
	 */

	public void setAppDataprovince(java.util.ArrayList<it.csi.sigit.sigitweba.dto.common.CodeDescription> value) {
		getSession().put("appDataprovince", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataprovince'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitweba.dto.common.CodeDescription> getAppDataprovince() {
		return (java.util.ArrayList<it.csi.sigit.sigitweba.dto.common.CodeDescription>) (getSession()
				.get("appDataprovince"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatacomuni'
	 * @param value
	 * @generated
	 */

	public void setAppDatacomuni(java.util.ArrayList<it.csi.sigit.sigitweba.dto.common.CodeDescription> value) {
		getSession().put("appDatacomuni", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatacomuni'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitweba.dto.common.CodeDescription> getAppDatacomuni() {
		return (java.util.ArrayList<it.csi.sigit.sigitweba.dto.common.CodeDescription>) (getSession()
				.get("appDatacomuni"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoIndirizziPF'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoIndirizziPF(
			java.util.ArrayList<it.csi.sigit.sigitweba.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoIndirizziPF", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoIndirizziPF'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitweba.dto.common.CodeDescription> getAppDataelencoIndirizziPF() {
		return (java.util.ArrayList<it.csi.sigit.sigitweba.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoIndirizziPF"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatalistFormazioni'
	 * @param value
	 * @generated
	 */

	public void setAppDatalistFormazioni(
			java.util.ArrayList<it.csi.sigit.sigitweba.dto.accreditamento_tns.Formazione> value) {
		getSession().put("appDatalistFormazioni", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatalistFormazioni'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitweba.dto.accreditamento_tns.Formazione> getAppDatalistFormazioni() {
		return (java.util.ArrayList<it.csi.sigit.sigitweba.dto.accreditamento_tns.Formazione>) (getSession()
				.get("appDatalistFormazioni"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataFormazione'
	 * @param value
	 * @generated
	 */

	public void setAppDataFormazione(it.csi.sigit.sigitweba.dto.accreditamento_tns.Formazione value) {
		getSession().put("appDataFormazione", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataFormazione'
	 * @generated
	 */
	public it.csi.sigit.sigitweba.dto.accreditamento_tns.Formazione getAppDataFormazione() {
		return (it.csi.sigit.sigitweba.dto.accreditamento_tns.Formazione) (getSession().get("appDataFormazione"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoImprese'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoImprese(
			java.util.ArrayList<it.csi.sigit.sigitweba.dto.accreditamento_tns.PersonaGiuridica> value) {
		getSession().put("appDataelencoImprese", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoImprese'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitweba.dto.accreditamento_tns.PersonaGiuridica> getAppDataelencoImprese() {
		return (java.util.ArrayList<it.csi.sigit.sigitweba.dto.accreditamento_tns.PersonaGiuridica>) (getSession()
				.get("appDataelencoImprese"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatapersonaGiuridica'
	 * @param value
	 * @generated
	 */

	public void setAppDatapersonaGiuridica(it.csi.sigit.sigitweba.dto.accreditamento_tns.PersonaGiuridica value) {
		getSession().put("appDatapersonaGiuridica", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatapersonaGiuridica'
	 * @generated
	 */
	public it.csi.sigit.sigitweba.dto.accreditamento_tns.PersonaGiuridica getAppDatapersonaGiuridica() {
		return (it.csi.sigit.sigitweba.dto.accreditamento_tns.PersonaGiuridica) (getSession()
				.get("appDatapersonaGiuridica"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoSigleRea'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoSigleRea(java.util.ArrayList<it.csi.sigit.sigitweba.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoSigleRea", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoSigleRea'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitweba.dto.common.CodeDescription> getAppDataelencoSigleRea() {
		return (java.util.ArrayList<it.csi.sigit.sigitweba.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoSigleRea"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataimpresaSelezionata'
	 * @param value
	 * @generated
	 */

	public void setAppDataimpresaSelezionata(java.lang.String value) {
		getSession().put("appDataimpresaSelezionata", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataimpresaSelezionata'
	 * @generated
	 */
	public java.lang.String getAppDataimpresaSelezionata() {
		return (java.lang.String) (getSession().get("appDataimpresaSelezionata"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoIndirizziPG'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoIndirizziPG(
			java.util.ArrayList<it.csi.sigit.sigitweba.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoIndirizziPG", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoIndirizziPG'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitweba.dto.common.CodeDescription> getAppDataelencoIndirizziPG() {
		return (java.util.ArrayList<it.csi.sigit.sigitweba.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoIndirizziPG"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataruoliImpresa'
	 * @param value
	 * @generated
	 */

	public void setAppDataruoliImpresa(java.util.ArrayList<it.csi.sigit.sigitweba.dto.common.CodeDescription> value) {
		getSession().put("appDataruoliImpresa", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataruoliImpresa'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitweba.dto.common.CodeDescription> getAppDataruoliImpresa() {
		return (java.util.ArrayList<it.csi.sigit.sigitweba.dto.common.CodeDescription>) (getSession()
				.get("appDataruoliImpresa"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatatipiDM'
	 * @param value
	 * @generated
	 */

	public void setAppDatatipiDM(java.util.ArrayList<it.csi.sigit.sigitweba.dto.common.CodeDescription> value) {
		getSession().put("appDatatipiDM", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatatipiDM'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitweba.dto.common.CodeDescription> getAppDatatipiDM() {
		return (java.util.ArrayList<it.csi.sigit.sigitweba.dto.common.CodeDescription>) (getSession()
				.get("appDatatipiDM"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoProvinceIT'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoProvinceIT(
			java.util.ArrayList<it.csi.sigit.sigitweba.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoProvinceIT", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoProvinceIT'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitweba.dto.common.CodeDescription> getAppDataelencoProvinceIT() {
		return (java.util.ArrayList<it.csi.sigit.sigitweba.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoProvinceIT"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoComuniPG'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoComuniPG(java.util.ArrayList<it.csi.sigit.sigitweba.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoComuniPG", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoComuniPG'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitweba.dto.common.CodeDescription> getAppDataelencoComuniPG() {
		return (java.util.ArrayList<it.csi.sigit.sigitweba.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoComuniPG"));
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

	////////////////////////////////////////////////////////////////////
	/// campi per widget semplici
	////////////////////////////////////////////////////////////////////

	// Table tbFormazione

	private java.lang.String widgTbFormazione;

	public void setWidg_tbFormazione(java.lang.String value) {
		widgTbFormazione = value;
	}

	public java.lang.String getWidg_tbFormazione() {
		return widgTbFormazione;
	}

}
