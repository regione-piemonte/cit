package it.csi.sigit.sigitwebn.dto.gestisci_impianto;

import java.io.File;
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
 * logica di business associata alla Schermata [cpGestImpianto]
 */
@Validation
public class CpGestImpiantoModel extends BaseSessionAwareDTO {

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	////////////////////////////////////////////////////////////////////
	/// application data
	////////////////////////////////////////////////////////////////////

	/**
	 * imposta il valore dell' ApplicationData 'appDataimpianto'
	 * @param value
	 * @generated
	 */

	public void setAppDataimpianto(it.csi.sigit.sigitwebn.dto.impianto.Impianto value) {
		getSession().put("appDataimpianto", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataimpianto'
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.impianto.Impianto getAppDataimpianto() {
		return (it.csi.sigit.sigitwebn.dto.impianto.Impianto) (getSession().get("appDataimpianto"));
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
	 * imposta il valore dell' ApplicationData 'appDataelencoStatoImpianto'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoStatoImpianto(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoStatoImpianto", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoStatoImpianto'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> getAppDataelencoStatoImpianto() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoStatoImpianto"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoIndirizzi'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoIndirizzi(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoIndirizzi", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoIndirizzi'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> getAppDataelencoIndirizzi() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoIndirizzi"));
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
	 * imposta il valore dell' ApplicationData 'appDataelencoComuniResp'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoComuniResp(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoComuniResp", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoComuniResp'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> getAppDataelencoComuniResp() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoComuniResp"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoIndirizziResp'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoIndirizziResp(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoIndirizziResp", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoIndirizziResp'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> getAppDataelencoIndirizziResp() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoIndirizziResp"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoTitoli'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoTitoli(java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoTitoli", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoTitoli'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> getAppDataelencoTitoli() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoTitoli"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataresponsabile'
	 * @param value
	 * @generated
	 */

	public void setAppDataresponsabile(it.csi.sigit.sigitwebn.dto.impianto.Responsabile value) {
		getSession().put("appDataresponsabile", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataresponsabile'
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.impianto.Responsabile getAppDataresponsabile() {
		return (it.csi.sigit.sigitwebn.dto.impianto.Responsabile) (getSession().get("appDataresponsabile"));
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
	 * imposta il valore dell' ApplicationData 'appDataidResponsabileSelez'
	 * @param value
	 * @generated
	 */

	public void setAppDataidResponsabileSelez(java.lang.String value) {
		getSession().put("appDataidResponsabileSelez", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidResponsabileSelez'
	 * @generated
	 */
	public java.lang.String getAppDataidResponsabileSelez() {
		return (java.lang.String) (getSession().get("appDataidResponsabileSelez"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoManutentori'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoManutentori(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.impianto.RisultatoRicManutentore> value) {
		getSession().put("appDataelencoManutentori", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoManutentori'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.impianto.RisultatoRicManutentore> getAppDataelencoManutentori() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.impianto.RisultatoRicManutentore>) (getSession()
				.get("appDataelencoManutentori"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoResponsabili'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoResponsabili(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.impianto.RisultatoRicResponsabile> value) {
		getSession().put("appDataelencoResponsabili", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoResponsabili'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.impianto.RisultatoRicResponsabile> getAppDataelencoResponsabili() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.impianto.RisultatoRicResponsabile>) (getSession()
				.get("appDataelencoResponsabili"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoResponsabiliTemp'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoResponsabiliTemp(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.impianto.Responsabile> value) {
		getSession().put("appDataelencoResponsabiliTemp", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoResponsabiliTemp'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.impianto.Responsabile> getAppDataelencoResponsabiliTemp() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.impianto.Responsabile>) (getSession()
				.get("appDataelencoResponsabiliTemp"));
	}

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
	 * imposta il valore dell' ApplicationData 'appDatapaginaChiamanteImp'
	 * @param value
	 * @generated
	 */

	public void setAppDatapaginaChiamanteImp(java.lang.String value) {
		getSession().put("appDatapaginaChiamanteImp", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatapaginaChiamanteImp'
	 * @generated
	 */
	public java.lang.String getAppDatapaginaChiamanteImp() {
		return (java.lang.String) (getSession().get("appDatapaginaChiamanteImp"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataisAbilitazioneDatiAllegato'
	 * @param value
	 * @generated
	 */

	public void setAppDataisAbilitazioneDatiAllegato(java.lang.Boolean value) {
		getSession().put("appDataisAbilitazioneDatiAllegato", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataisAbilitazioneDatiAllegato'
	 * @generated
	 */
	public java.lang.Boolean getAppDataisAbilitazioneDatiAllegato() {
		return (java.lang.Boolean) (getSession().get("appDataisAbilitazioneDatiAllegato"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataaggiornaElencoImpianti'
	 * @param value
	 * @generated
	 */

	public void setAppDataaggiornaElencoImpianti(java.lang.Boolean value) {
		getSession().put("appDataaggiornaElencoImpianti", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataaggiornaElencoImpianti'
	 * @generated
	 */
	public java.lang.Boolean getAppDataaggiornaElencoImpianti() {
		return (java.lang.Boolean) (getSession().get("appDataaggiornaElencoImpianti"));
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
	 * imposta il valore dell' ApplicationData 'appDataprovenienza'
	 * @param value
	 * @generated
	 */

	public void setAppDataprovenienza(java.lang.String value) {
		getSession().put("appDataprovenienza", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataprovenienza'
	 * @generated
	 */
	public java.lang.String getAppDataprovenienza() {
		return (java.lang.String) (getSession().get("appDataprovenienza"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataidentificativoImpianto'
	 * @param value
	 * @generated
	 */

	public void setAppDataidentificativoImpianto(it.csi.sigit.sigitwebn.dto.impianto.IdentificativoImpianto value) {
		getSession().put("appDataidentificativoImpianto", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidentificativoImpianto'
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.impianto.IdentificativoImpianto getAppDataidentificativoImpianto() {
		return (it.csi.sigit.sigitwebn.dto.impianto.IdentificativoImpianto) (getSession()
				.get("appDataidentificativoImpianto"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatapaginaChiamanteDocumenti'
	 * @param value
	 * @generated
	 */

	public void setAppDatapaginaChiamanteDocumenti(java.lang.String value) {
		getSession().put("appDatapaginaChiamanteDocumenti", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatapaginaChiamanteDocumenti'
	 * @generated
	 */
	public java.lang.String getAppDatapaginaChiamanteDocumenti() {
		return (java.lang.String) (getSession().get("appDatapaginaChiamanteDocumenti"));
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
	 * imposta il valore dell' ApplicationData 'appDataelencoImpiantiGraffati'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoImpiantiGraffati(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.impianto.ElencoImpiantiGraffati> value) {
		getSession().put("appDataelencoImpiantiGraffati", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoImpiantiGraffati'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.impianto.ElencoImpiantiGraffati> getAppDataelencoImpiantiGraffati() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.impianto.ElencoImpiantiGraffati>) (getSession()
				.get("appDataelencoImpiantiGraffati"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataimpiantoApprofondito'
	 * @param value
	 * @generated
	 */

	public void setAppDataimpiantoApprofondito(it.csi.sigit.sigitwebn.dto.impianto.Impianto value) {
		getSession().put("appDataimpiantoApprofondito", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataimpiantoApprofondito'
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.impianto.Impianto getAppDataimpiantoApprofondito() {
		return (it.csi.sigit.sigitwebn.dto.impianto.Impianto) (getSession().get("appDataimpiantoApprofondito"));
	}

	////////////////////////////////////////////////////////////////////
	/// campi per widget semplici
	////////////////////////////////////////////////////////////////////

	// Table tbManutentori

	private java.lang.String widgTbManutentori;

	public void setWidg_tbManutentori(java.lang.String value) {
		widgTbManutentori = value;
	}

	public java.lang.String getWidg_tbManutentori() {
		return widgTbManutentori;
	}

	// FileUpload widg_fuImpLib
	private File widgFuImpLib; // The actual file(s)
	private String widgFuImpLibContentType; // The content type of the file(s) 
	private String widgFuImpLibFileName; // The uploaded file(s) name and path 

	public void setWidg_fuImpLib(File value) {
		widgFuImpLib = value;
	}
	@JSON(include = false)
	public File getWidg_fuImpLib() {
		return widgFuImpLib;
	}

	public void setWidg_fuImpLibContentType(String value) {
		widgFuImpLibContentType = value;
	}
	@JSON(include = false)
	public String getWidg_fuImpLibContentType() {
		return widgFuImpLibContentType;
	}

	public void setWidg_fuImpLibFileName(String value) {
		widgFuImpLibFileName = value;
	}
	@JSON(include = false)
	public String getWidg_fuImpLibFileName() {
		return widgFuImpLibFileName;
	}

}
