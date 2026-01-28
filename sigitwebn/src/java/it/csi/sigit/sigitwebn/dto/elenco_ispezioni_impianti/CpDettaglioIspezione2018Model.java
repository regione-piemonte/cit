package it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti;

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
 * logica di business associata alla Schermata [cpDettaglioIspezione2018]
 */
@Validation
public class CpDettaglioIspezione2018Model extends BaseSessionAwareDTO {

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	////////////////////////////////////////////////////////////////////
	/// application data
	////////////////////////////////////////////////////////////////////

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
	 * imposta il valore dell' ApplicationData 'appDataIspezione2018'
	 * @param value
	 * @generated
	 */

	public void setAppDataIspezione2018(it.csi.sigit.sigitwebn.dto.ispezioni.Ispezione2018 value) {
		getSession().put("appDataIspezione2018", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataIspezione2018'
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.ispezioni.Ispezione2018 getAppDataIspezione2018() {
		return (it.csi.sigit.sigitwebn.dto.ispezioni.Ispezione2018) (getSession().get("appDataIspezione2018"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoIspettori'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoIspettori(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoIspettori", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoIspettori'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> getAppDataelencoIspettori() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoIspettori"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoSanzioni'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoSanzioni(java.util.ArrayList<it.csi.sigit.sigitwebn.dto.sanzioni.Sanzione> value) {
		getSession().put("appDataelencoSanzioni", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoSanzioni'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.sanzioni.Sanzione> getAppDataelencoSanzioni() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.sanzioni.Sanzione>) (getSession()
				.get("appDataelencoSanzioni"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataidSanzioneSelezionata'
	 * @param value
	 * @generated
	 */

	public void setAppDataidSanzioneSelezionata(java.lang.Integer value) {
		getSession().put("appDataidSanzioneSelezionata", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidSanzioneSelezionata'
	 * @generated
	 */
	public java.lang.Integer getAppDataidSanzioneSelezionata() {
		return (java.lang.Integer) (getSession().get("appDataidSanzioneSelezionata"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoAllegatiIsp'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoAllegatiIsp(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.allegati.DettaglioAllegato> value) {
		getSession().put("appDataelencoAllegatiIsp", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoAllegatiIsp'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.allegati.DettaglioAllegato> getAppDataelencoAllegatiIsp() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.allegati.DettaglioAllegato>) (getSession()
				.get("appDataelencoAllegatiIsp"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataidAllegatoIspSelezionato'
	 * @param value
	 * @generated
	 */

	public void setAppDataidAllegatoIspSelezionato(java.lang.Integer value) {
		getSession().put("appDataidAllegatoIspSelezionato", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidAllegatoIspSelezionato'
	 * @generated
	 */
	public java.lang.Integer getAppDataidAllegatoIspSelezionato() {
		return (java.lang.Integer) (getSession().get("appDataidAllegatoIspSelezionato"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoAzioni'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoAzioni(java.util.ArrayList<it.csi.sigit.sigitwebn.dto.azioni.Azione> value) {
		getSession().put("appDataelencoAzioni", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoAzioni'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.azioni.Azione> getAppDataelencoAzioni() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.azioni.Azione>) (getSession()
				.get("appDataelencoAzioni"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataidAzioneSelezionata'
	 * @param value
	 * @generated
	 */

	public void setAppDataidAzioneSelezionata(java.lang.String value) {
		getSession().put("appDataidAzioneSelezionata", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidAzioneSelezionata'
	 * @generated
	 */
	public java.lang.String getAppDataidAzioneSelezionata() {
		return (java.lang.String) (getSession().get("appDataidAzioneSelezionata"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataidTipoAzione'
	 * @param value
	 * @generated
	 */

	public void setAppDataidTipoAzione(java.lang.Integer value) {
		getSession().put("appDataidTipoAzione", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidTipoAzione'
	 * @generated
	 */
	public java.lang.Integer getAppDataidTipoAzione() {
		return (java.lang.Integer) (getSession().get("appDataidTipoAzione"));
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
	 * imposta il valore dell' ApplicationData 'appDataConclusioneIspezione2018'
	 * @param value
	 * @generated
	 */

	public void setAppDataConclusioneIspezione2018(
			it.csi.sigit.sigitwebn.dto.ispezioni.ConclusioneIspezione2018 value) {
		getSession().put("appDataConclusioneIspezione2018", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataConclusioneIspezione2018'
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.ispezioni.ConclusioneIspezione2018 getAppDataConclusioneIspezione2018() {
		return (it.csi.sigit.sigitwebn.dto.ispezioni.ConclusioneIspezione2018) (getSession()
				.get("appDataConclusioneIspezione2018"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataIspettoreScelto'
	 * @param value
	 * @generated
	 */

	public void setAppDataIspettoreScelto(java.lang.String value) {
		getSession().put("appDataIspettoreScelto", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataIspettoreScelto'
	 * @generated
	 */
	public java.lang.String getAppDataIspettoreScelto() {
		return (java.lang.String) (getSession().get("appDataIspettoreScelto"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataRicercaImpiantoDaAssociare'
	 * @param value
	 * @generated
	 */

	public void setAppDataRicercaImpiantoDaAssociare(
			it.csi.sigit.sigitwebn.dto.ispezioni.RicercaImpiantoDaAssociare value) {
		getSession().put("appDataRicercaImpiantoDaAssociare", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataRicercaImpiantoDaAssociare'
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.ispezioni.RicercaImpiantoDaAssociare getAppDataRicercaImpiantoDaAssociare() {
		return (it.csi.sigit.sigitwebn.dto.ispezioni.RicercaImpiantoDaAssociare) (getSession()
				.get("appDataRicercaImpiantoDaAssociare"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataidIspezioneSelezionato'
	 * @param value
	 * @generated
	 */

	public void setAppDataidIspezioneSelezionato(java.lang.Integer value) {
		getSession().put("appDataidIspezioneSelezionato", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidIspezioneSelezionato'
	 * @generated
	 */
	public java.lang.Integer getAppDataidIspezioneSelezionato() {
		return (java.lang.Integer) (getSession().get("appDataidIspezioneSelezionato"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataallegatoIsp'
	 * @param value
	 * @generated
	 */

	public void setAppDataallegatoIsp(it.csi.sigit.sigitwebn.dto.allegati.DettaglioAllegato value) {
		getSession().put("appDataallegatoIsp", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataallegatoIsp'
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.allegati.DettaglioAllegato getAppDataallegatoIsp() {
		return (it.csi.sigit.sigitwebn.dto.allegati.DettaglioAllegato) (getSession().get("appDataallegatoIsp"));
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
	 * imposta il valore dell' ApplicationData 'appDataelencoSecondiIspettori'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoSecondiIspettori(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoSecondiIspettori", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoSecondiIspettori'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> getAppDataelencoSecondiIspettori() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoSecondiIspettori"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataaggiornaDati'
	 * @param value
	 * @generated
	 */

	public void setAppDataaggiornaDati(java.lang.Boolean value) {
		getSession().put("appDataaggiornaDati", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataaggiornaDati'
	 * @generated
	 */
	public java.lang.Boolean getAppDataaggiornaDati() {
		return (java.lang.Boolean) (getSession().get("appDataaggiornaDati"));
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
	 * imposta il valore dell' ApplicationData 'appDatadatiInserimentoSanzione'
	 * @param value
	 * @generated
	 */

	public void setAppDatadatiInserimentoSanzione(it.csi.sigit.sigitwebn.dto.sanzioni.DatiInserimentoSanzione value) {
		getSession().put("appDatadatiInserimentoSanzione", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatadatiInserimentoSanzione'
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.sanzioni.DatiInserimentoSanzione getAppDatadatiInserimentoSanzione() {
		return (it.csi.sigit.sigitwebn.dto.sanzioni.DatiInserimentoSanzione) (getSession()
				.get("appDatadatiInserimentoSanzione"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatapaginaChiamanteDettaglioSanzione'
	 * @param value
	 * @generated
	 */

	public void setAppDatapaginaChiamanteDettaglioSanzione(java.lang.String value) {
		getSession().put("appDatapaginaChiamanteDettaglioSanzione", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatapaginaChiamanteDettaglioSanzione'
	 * @generated
	 */
	public java.lang.String getAppDatapaginaChiamanteDettaglioSanzione() {
		return (java.lang.String) (getSession().get("appDatapaginaChiamanteDettaglioSanzione"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoStatiSanzione'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoStatiSanzione(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.IdDescription> value) {
		getSession().put("appDataelencoStatiSanzione", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoStatiSanzione'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.IdDescription> getAppDataelencoStatiSanzione() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.IdDescription>) (getSession()
				.get("appDataelencoStatiSanzione"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoComuniPiemonteIstat'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoComuniPiemonteIstat(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoComuniPiemonteIstat", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoComuniPiemonteIstat'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> getAppDataelencoComuniPiemonteIstat() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoComuniPiemonteIstat"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoProvincePiemonteIstat'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoProvincePiemonteIstat(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> value) {
		getSession().put("appDataelencoProvincePiemonteIstat", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoProvincePiemonteIstat'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription> getAppDataelencoProvincePiemonteIstat() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.CodeDescription>) (getSession()
				.get("appDataelencoProvincePiemonteIstat"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataazioneCodImpianto'
	 * @param value
	 * @generated
	 */

	public void setAppDataazioneCodImpianto(java.lang.String value) {
		getSession().put("appDataazioneCodImpianto", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataazioneCodImpianto'
	 * @generated
	 */
	public java.lang.String getAppDataazioneCodImpianto() {
		return (java.lang.String) (getSession().get("appDataazioneCodImpianto"));
	}

	////////////////////////////////////////////////////////////////////
	/// campi per widget semplici
	////////////////////////////////////////////////////////////////////

	// FileUpload widg_fuUploadRappProvaFirmato
	private File widgFuUploadRappProvaFirmato; // The actual file(s)
	private String widgFuUploadRappProvaFirmatoContentType; // The content type of the file(s) 
	private String widgFuUploadRappProvaFirmatoFileName; // The uploaded file(s) name and path 

	public void setWidg_fuUploadRappProvaFirmato(File value) {
		widgFuUploadRappProvaFirmato = value;
	}
	@JSON(include = false)
	public File getWidg_fuUploadRappProvaFirmato() {
		return widgFuUploadRappProvaFirmato;
	}

	public void setWidg_fuUploadRappProvaFirmatoContentType(String value) {
		widgFuUploadRappProvaFirmatoContentType = value;
	}
	@JSON(include = false)
	public String getWidg_fuUploadRappProvaFirmatoContentType() {
		return widgFuUploadRappProvaFirmatoContentType;
	}

	public void setWidg_fuUploadRappProvaFirmatoFileName(String value) {
		widgFuUploadRappProvaFirmatoFileName = value;
	}
	@JSON(include = false)
	public String getWidg_fuUploadRappProvaFirmatoFileName() {
		return widgFuUploadRappProvaFirmatoFileName;
	}

	// Table tbAzioniSvolte

	private java.lang.String widgTbAzioniSvolte;

	public void setWidg_tbAzioniSvolte(java.lang.String value) {
		widgTbAzioniSvolte = value;
	}

	public java.lang.String getWidg_tbAzioniSvolte() {
		return widgTbAzioniSvolte;
	}

}
