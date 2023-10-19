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
	 * imposta il valore dell' ApplicationData 'appDataidIncaricatoAssociatoSelez'
	 * @param value
	 * @generated
	 */

	public void setAppDataidIncaricatoAssociatoSelez(java.lang.String value) {
		getSession().put("appDataidIncaricatoAssociatoSelez", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidIncaricatoAssociatoSelez'
	 * @generated
	 */
	public java.lang.String getAppDataidIncaricatoAssociatoSelez() {
		return (java.lang.String) (getSession().get("appDataidIncaricatoAssociatoSelez"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoIndirizziSub'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoIndirizziSub(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoIndirizziSub", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoIndirizziSub'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> getAppDataelencoIndirizziSub() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoIndirizziSub"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataidDelegatoAssociatoSelez'
	 * @param value
	 * @generated
	 */

	public void setAppDataidDelegatoAssociatoSelez(java.lang.String value) {
		getSession().put("appDataidDelegatoAssociatoSelez", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidDelegatoAssociatoSelez'
	 * @generated
	 */
	public java.lang.String getAppDataidDelegatoAssociatoSelez() {
		return (java.lang.String) (getSession().get("appDataidDelegatoAssociatoSelez"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatasubentro'
	 * @param value
	 * @generated
	 */

	public void setAppDatasubentro(it.csi.sigit.sigitwebn.dto.subentro.Subentro value) {
		getSession().put("appDatasubentro", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatasubentro'
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.subentro.Subentro getAppDatasubentro() {
		return (it.csi.sigit.sigitwebn.dto.subentro.Subentro) (getSession().get("appDatasubentro"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataidImpresaSelezionata'
	 * @param value
	 * @generated
	 */

	public void setAppDataidImpresaSelezionata(java.lang.Integer value) {
		getSession().put("appDataidImpresaSelezionata", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidImpresaSelezionata'
	 * @generated
	 */
	public java.lang.Integer getAppDataidImpresaSelezionata() {
		return (java.lang.Integer) (getSession().get("appDataidImpresaSelezionata"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataidAccertamentoSelezionato'
	 * @param value
	 * @generated
	 */

	public void setAppDataidAccertamentoSelezionato(java.lang.String value) {
		getSession().put("appDataidAccertamentoSelezionato", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidAccertamentoSelezionato'
	 * @generated
	 */
	public java.lang.String getAppDataidAccertamentoSelezionato() {
		return (java.lang.String) (getSession().get("appDataidAccertamentoSelezionato"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataricercaSanzioni'
	 * @param value
	 * @generated
	 */

	public void setAppDataricercaSanzioni(it.csi.sigit.sigitwebn.dto.sanzioni.RicercaSanzioni value) {
		getSession().put("appDataricercaSanzioni", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataricercaSanzioni'
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.sanzioni.RicercaSanzioni getAppDataricercaSanzioni() {
		return (it.csi.sigit.sigitwebn.dto.sanzioni.RicercaSanzioni) (getSession().get("appDataricercaSanzioni"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoTipoSubentro'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoTipoSubentro(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoTipoSubentro", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoTipoSubentro'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> getAppDataelencoTipoSubentro() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoTipoSubentro"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoDatiVisura'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoDatiVisura(java.util.ArrayList<it.csi.sigit.sigitwebn.dto.impresa.LabelValue> value) {
		getSession().put("appDataelencoDatiVisura", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoDatiVisura'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.impresa.LabelValue> getAppDataelencoDatiVisura() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.impresa.LabelValue>) (getSession()
				.get("appDataelencoDatiVisura"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoTipiDocumento'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoTipiDocumento(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoTipiDocumento", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoTipiDocumento'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> getAppDataelencoTipiDocumento() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoTipiDocumento"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoImprese'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoImprese(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.accesso.PersonaGiuridica> value) {
		getSession().put("appDataelencoImprese", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoImprese'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.accesso.PersonaGiuridica> getAppDataelencoImprese() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.accesso.PersonaGiuridica>) (getSession()
				.get("appDataelencoImprese"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatadelegato'
	 * @param value
	 * @generated
	 */

	public void setAppDatadelegato(it.csi.sigit.sigitwebn.dto.delega.Delegato value) {
		getSession().put("appDatadelegato", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatadelegato'
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.delega.Delegato getAppDatadelegato() {
		return (it.csi.sigit.sigitwebn.dto.delega.Delegato) (getSession().get("appDatadelegato"));
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
	 * imposta il valore dell' ApplicationData 'appDataricercaSveglie'
	 * @param value
	 * @generated
	 */

	public void setAppDataricercaSveglie(it.csi.sigit.sigitwebn.dto.azioni.RicercaSveglie value) {
		getSession().put("appDataricercaSveglie", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataricercaSveglie'
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.azioni.RicercaSveglie getAppDataricercaSveglie() {
		return (it.csi.sigit.sigitwebn.dto.azioni.RicercaSveglie) (getSession().get("appDataricercaSveglie"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataaggiornaElencoBollini'
	 * @param value
	 * @generated
	 */

	public void setAppDataaggiornaElencoBollini(java.lang.Boolean value) {
		getSession().put("appDataaggiornaElencoBollini", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataaggiornaElencoBollini'
	 * @generated
	 */
	public java.lang.Boolean getAppDataaggiornaElencoBollini() {
		return (java.lang.Boolean) (getSession().get("appDataaggiornaElencoBollini"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatadistributori'
	 * @param value
	 * @generated
	 */

	public void setAppDatadistributori(it.csi.sigit.sigitwebn.dto.distributori.Distributore value) {
		getSession().put("appDatadistributori", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatadistributori'
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.distributori.Distributore getAppDatadistributori() {
		return (it.csi.sigit.sigitwebn.dto.distributori.Distributore) (getSession().get("appDatadistributori"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataidDelegatoPotenzialeSelez'
	 * @param value
	 * @generated
	 */

	public void setAppDataidDelegatoPotenzialeSelez(java.lang.Integer value) {
		getSession().put("appDataidDelegatoPotenzialeSelez", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidDelegatoPotenzialeSelez'
	 * @generated
	 */
	public java.lang.Integer getAppDataidDelegatoPotenzialeSelez() {
		return (java.lang.Integer) (getSession().get("appDataidDelegatoPotenzialeSelez"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataidImpiantoSelez'
	 * @param value
	 * @generated
	 */

	public void setAppDataidImpiantoSelez(java.lang.String value) {
		getSession().put("appDataidImpiantoSelez", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidImpiantoSelez'
	 * @generated
	 */
	public java.lang.String getAppDataidImpiantoSelez() {
		return (java.lang.String) (getSession().get("appDataidImpiantoSelez"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoSigleBollino'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoSigleBollino(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoSigleBollino", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoSigleBollino'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> getAppDataelencoSigleBollino() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoSigleBollino"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoSigleRea'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoSigleRea(java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoSigleRea", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoSigleRea'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> getAppDataelencoSigleRea() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoSigleRea"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataverifica'
	 * @param value
	 * @generated
	 */

	public void setAppDataverifica(it.csi.sigit.sigitwebn.dto.verifica.Verifica value) {
		getSession().put("appDataverifica", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataverifica'
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.verifica.Verifica getAppDataverifica() {
		return (it.csi.sigit.sigitwebn.dto.verifica.Verifica) (getSession().get("appDataverifica"));
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
	 * imposta il valore dell' ApplicationData 'appDataelencoDelegatiPotenziali'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoDelegatiPotenziali(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.delega.Delegato> value) {
		getSession().put("appDataelencoDelegatiPotenziali", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoDelegatiPotenziali'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.delega.Delegato> getAppDataelencoDelegatiPotenziali() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.delega.Delegato>) (getSession()
				.get("appDataelencoDelegatiPotenziali"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoDelegatiAssociati'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoDelegatiAssociati(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.delega.Delegato> value) {
		getSession().put("appDataelencoDelegatiAssociati", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoDelegatiAssociati'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.delega.Delegato> getAppDataelencoDelegatiAssociati() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.delega.Delegato>) (getSession()
				.get("appDataelencoDelegatiAssociati"));
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
	 * imposta il valore dell' ApplicationData 'appDataelencoIndirizziImp'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoIndirizziImp(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoIndirizziImp", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoIndirizziImp'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> getAppDataelencoIndirizziImp() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoIndirizziImp"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatadettaglioImportDistributori'
	 * @param value
	 * @generated
	 */

	public void setAppDatadettaglioImportDistributori(
			it.csi.sigit.sigitwebn.dto.distributori.DettaglioImportDistributori value) {
		getSession().put("appDatadettaglioImportDistributori", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatadettaglioImportDistributori'
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.distributori.DettaglioImportDistributori getAppDatadettaglioImportDistributori() {
		return (it.csi.sigit.sigitwebn.dto.distributori.DettaglioImportDistributori) (getSession()
				.get("appDatadettaglioImportDistributori"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoErroriImport'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoErroriImport(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.distributori.DettaglioErrore> value) {
		getSession().put("appDataelencoErroriImport", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoErroriImport'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.distributori.DettaglioErrore> getAppDataelencoErroriImport() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.distributori.DettaglioErrore>) (getSession()
				.get("appDataelencoErroriImport"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoImportDistributori'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoImportDistributori(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.distributori.DettaglioImportDistributori> value) {
		getSession().put("appDataelencoImportDistributori", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoImportDistributori'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.distributori.DettaglioImportDistributori> getAppDataelencoImportDistributori() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.distributori.DettaglioImportDistributori>) (getSession()
				.get("appDataelencoImportDistributori"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoIncaricatiAssociati'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoIncaricatiAssociati(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.incarico.Incaricato> value) {
		getSession().put("appDataelencoIncaricatiAssociati", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoIncaricatiAssociati'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.incarico.Incaricato> getAppDataelencoIncaricatiAssociati() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.incarico.Incaricato>) (getSession()
				.get("appDataelencoIncaricatiAssociati"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataincaricato'
	 * @param value
	 * @generated
	 */

	public void setAppDataincaricato(it.csi.sigit.sigitwebn.dto.incarico.Incaricato value) {
		getSession().put("appDataincaricato", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataincaricato'
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.incarico.Incaricato getAppDataincaricato() {
		return (it.csi.sigit.sigitwebn.dto.incarico.Incaricato) (getSession().get("appDataincaricato"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataricercaAllegati'
	 * @param value
	 * @generated
	 */

	public void setAppDataricercaAllegati(it.csi.sigit.sigitwebn.dto.allegati.RicercaAllegati value) {
		getSession().put("appDataricercaAllegati", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataricercaAllegati'
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.allegati.RicercaAllegati getAppDataricercaAllegati() {
		return (it.csi.sigit.sigitwebn.dto.allegati.RicercaAllegati) (getSession().get("appDataricercaAllegati"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataidFileInviatoSelez'
	 * @param value
	 * @generated
	 */

	public void setAppDataidFileInviatoSelez(java.lang.Integer value) {
		getSession().put("appDataidFileInviatoSelez", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidFileInviatoSelez'
	 * @generated
	 */
	public java.lang.Integer getAppDataidFileInviatoSelez() {
		return (java.lang.Integer) (getSession().get("appDataidFileInviatoSelez"));
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
	 * imposta il valore dell' ApplicationData 'appDataincarico'
	 * @param value
	 * @generated
	 */

	public void setAppDataincarico(it.csi.sigit.sigitwebn.dto.incarico.Incarico value) {
		getSession().put("appDataincarico", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataincarico'
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.incarico.Incarico getAppDataincarico() {
		return (it.csi.sigit.sigitwebn.dto.incarico.Incarico) (getSession().get("appDataincarico"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataRicercaIspezioni2018'
	 * @param value
	 * @generated
	 */

	public void setAppDataRicercaIspezioni2018(it.csi.sigit.sigitwebn.dto.ispezioni.RicercaIspezioni2018 value) {
		getSession().put("appDataRicercaIspezioni2018", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataRicercaIspezioni2018'
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.ispezioni.RicercaIspezioni2018 getAppDataRicercaIspezioni2018() {
		return (it.csi.sigit.sigitwebn.dto.ispezioni.RicercaIspezioni2018) (getSession()
				.get("appDataRicercaIspezioni2018"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataricercaCodImpianto'
	 * @param value
	 * @generated
	 */

	public void setAppDataricercaCodImpianto(it.csi.sigit.sigitwebn.dto.main.RicercaTransazione value) {
		getSession().put("appDataricercaCodImpianto", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataricercaCodImpianto'
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.main.RicercaTransazione getAppDataricercaCodImpianto() {
		return (it.csi.sigit.sigitwebn.dto.main.RicercaTransazione) (getSession().get("appDataricercaCodImpianto"));
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
	 * imposta il valore dell' ApplicationData 'appDataelencoCat'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoCat(java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoCat", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoCat'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> getAppDataelencoCat() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoCat"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataimpresa'
	 * @param value
	 * @generated
	 */

	public void setAppDataimpresa(it.csi.sigit.sigitwebn.dto.accesso.PersonaGiuridica value) {
		getSession().put("appDataimpresa", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataimpresa'
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.accesso.PersonaGiuridica getAppDataimpresa() {
		return (it.csi.sigit.sigitwebn.dto.accesso.PersonaGiuridica) (getSession().get("appDataimpresa"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataricercaBollini'
	 * @param value
	 * @generated
	 */

	public void setAppDataricercaBollini(it.csi.sigit.sigitwebn.dto.main.RicercaTransazione value) {
		getSession().put("appDataricercaBollini", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataricercaBollini'
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.main.RicercaTransazione getAppDataricercaBollini() {
		return (it.csi.sigit.sigitwebn.dto.main.RicercaTransazione) (getSession().get("appDataricercaBollini"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataidAllegatoImpiantoSelezionato'
	 * @param value
	 * @generated
	 */

	public void setAppDataidAllegatoImpiantoSelezionato(java.lang.Integer value) {
		getSession().put("appDataidAllegatoImpiantoSelezionato", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidAllegatoImpiantoSelezionato'
	 * @generated
	 */
	public java.lang.Integer getAppDataidAllegatoImpiantoSelezionato() {
		return (java.lang.Integer) (getSession().get("appDataidAllegatoImpiantoSelezionato"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoStatiAllegato'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoStatiAllegato(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoStatiAllegato", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoStatiAllegato'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> getAppDataelencoStatiAllegato() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoStatiAllegato"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataricercaVerifica'
	 * @param value
	 * @generated
	 */

	public void setAppDataricercaVerifica(it.csi.sigit.sigitwebn.dto.verifica.RicercaVerifica value) {
		getSession().put("appDataricercaVerifica", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataricercaVerifica'
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.verifica.RicercaVerifica getAppDataricercaVerifica() {
		return (it.csi.sigit.sigitwebn.dto.verifica.RicercaVerifica) (getSession().get("appDataricercaVerifica"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatadelega'
	 * @param value
	 * @generated
	 */

	public void setAppDatadelega(it.csi.sigit.sigitwebn.dto.delega.Delega value) {
		getSession().put("appDatadelega", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatadelega'
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.delega.Delega getAppDatadelega() {
		return (it.csi.sigit.sigitwebn.dto.delega.Delega) (getSession().get("appDatadelega"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoCodImpianto'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoCodImpianto(java.lang.String value) {
		getSession().put("appDataelencoCodImpianto", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoCodImpianto'
	 * @generated
	 */
	public java.lang.String getAppDataelencoCodImpianto() {
		return (java.lang.String) (getSession().get("appDataelencoCodImpianto"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataricercaImpianti'
	 * @param value
	 * @generated
	 */

	public void setAppDataricercaImpianti(it.csi.sigit.sigitwebn.dto.impianto.RicercaImpianti value) {
		getSession().put("appDataricercaImpianti", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataricercaImpianti'
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.impianto.RicercaImpianti getAppDataricercaImpianti() {
		return (it.csi.sigit.sigitwebn.dto.impianto.RicercaImpianti) (getSession().get("appDataricercaImpianti"));
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
	 * imposta il valore dell' ApplicationData 'appDataricercaImprese'
	 * @param value
	 * @generated
	 */

	public void setAppDataricercaImprese(it.csi.sigit.sigitwebn.dto.impresa.RicercaImprese value) {
		getSession().put("appDataricercaImprese", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataricercaImprese'
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.impresa.RicercaImprese getAppDataricercaImprese() {
		return (it.csi.sigit.sigitwebn.dto.impresa.RicercaImprese) (getSession().get("appDataricercaImprese"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataricercaAccertamento'
	 * @param value
	 * @generated
	 */

	public void setAppDataricercaAccertamento(it.csi.sigit.sigitwebn.dto.accertamento.RicercaAccertamento value) {
		getSession().put("appDataricercaAccertamento", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataricercaAccertamento'
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.accertamento.RicercaAccertamento getAppDataricercaAccertamento() {
		return (it.csi.sigit.sigitwebn.dto.accertamento.RicercaAccertamento) (getSession()
				.get("appDataricercaAccertamento"));
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
	 * imposta il valore dell' ApplicationData 'appDataidVerificaSelezionata'
	 * @param value
	 * @generated
	 */

	public void setAppDataidVerificaSelezionata(java.lang.String value) {
		getSession().put("appDataidVerificaSelezionata", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidVerificaSelezionata'
	 * @generated
	 */
	public java.lang.String getAppDataidVerificaSelezionata() {
		return (java.lang.String) (getSession().get("appDataidVerificaSelezionata"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataricercaAvanzataImpianti'
	 * @param value
	 * @generated
	 */

	public void setAppDataricercaAvanzataImpianti(it.csi.sigit.sigitwebn.dto.impianto.RicercaAvanzataImpianti value) {
		getSession().put("appDataricercaAvanzataImpianti", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataricercaAvanzataImpianti'
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.impianto.RicercaAvanzataImpianti getAppDataricercaAvanzataImpianti() {
		return (it.csi.sigit.sigitwebn.dto.impianto.RicercaAvanzataImpianti) (getSession()
				.get("appDataricercaAvanzataImpianti"));
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

}
