package it.csi.sigit.sigitwebn.presentation.sigitwebn.action.elenco_ispezioni_impianti;

import java.util.*;

import java.lang.reflect.InvocationTargetException;
import java.beans.IntrospectionException;

import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.validator.annotations.*;
import com.opensymphony.xwork2.conversion.annotations.*;
import com.opensymphony.xwork2.ActionContext;

import it.csi.sigit.sigitwebn.util.*;
import it.csi.sigit.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpElencoIspezioniImpiantiModel;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.command.*;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.security.*;

import it.csi.sigit.sigitwebn.business.*;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.action.*;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.action.elenco_ispezioni_impianti.states.CpElencoIspezioniImpiantiScreenStates;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.interceptor.MethodProtection;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.interceptor.FatClientOnly;
import it.csi.sigit.sigitwebn.presentation.uiutils.*;
import flexjson.JSON;

/**
 * CpElencoIspezioniImpiantiAction Action Class.
 *
 * @author GuiGen
 */
@Validation()
@Conversion()
public class CpElencoIspezioniImpiantiAction extends AbstractCPAction<CpElencoIspezioniImpiantiModel>
		implements
			Preparable,
			ModelDriven<CpElencoIspezioniImpiantiModel> {

	/**
	 * Il modello del content panel.
	 * Viene riempito a fornte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	private CpElencoIspezioniImpiantiModel model;

	/**
	 * Il modello del content panel.
	 * Viene riempito a fornte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	public CpElencoIspezioniImpiantiModel getModel() {
		return model;
	}

	/**
	 * Il modello del content panel.
	 * Viene riempito a fronte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	@VisitorFieldValidator(message = "", appendPrefix = false)
	public void setModel(CpElencoIspezioniImpiantiModel modello) {
		this.model = modello;
	}

	/**
	 * Il metodo setSession() viene ridefinito in modo che venga asosciato all'oggetto
	 * model.
	 * N.B: il model deve essere creato in precedenza, altrimenti l'impostazione non 
	 * e' possibile. 
	 * Per questo motivo esso viene creato in questo (se non gia' esistente).
	 */
	@Override
	public void setSession(Map session) {
		// implementazione standard di SessionAware
		super.setSession(session);
		// creo una nuova istanza di modello, se gia' non esiste 
		if (model == null) {
			model = new CpElencoIspezioniImpiantiModel();
		}
		// associo la sessione applicativa al modello, in modo che
		// possa implementare l'accesso agli application data
		// di scope session/same page
		model.setSession(session);
	}

	/**
	 * nome del content panel
	 */
	private static final String CP_NAME = "cpElencoIspezioniImpianti";

	/**
	 * nome del namespace che contiene il content panel
	 */
	private static final String CP_NAMESPACE = "elenco_ispezioni_impianti";

	/**
	 * nome completo del namespace che contiene il content panel
	 */
	private static final String CP_FULL_NAMESPACE = "/base/elenco_ispezioni_impianti";

	/**
	 * restituisce il nome del content panel
	 */
	public String getCPName() {
		return CP_NAME;
	}

	/**
	 * restituisce il nome del namespace che contiene il content panel
	 */
	public String getCPNamespace() {
		return CP_NAMESPACE;
	}

	/**
	 * restituisce il nome del namespace che contiene il content panel, comprensivo di prefisso "base"/"secure"
	 */
	public String getCPFullNamespace() {
		return CP_FULL_NAMESPACE;
	}

	private static final String URL_BACK_COMMAND = "/base/elenco_ispezioni_impianti/" + CP_NAME;

	/**
	 * classe model associata al ContentPanel
	 */
	public Class modelClass() {
		return it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpElencoIspezioniImpiantiModel.class;
	}

	/**
	 * I singoli eventi sui singoli widget sono gestiti dai metodi specifici   
	 * @return SUCCESS.
	 */
	@SkipValidation
	public String execute() throws CommandExecutionException {
		return super.execute();
	}

	protected boolean isImplicitEventDefined(String implicitEventName) {

		if (AbstractCPAction.IMPLICIT_EVENT_ON_ENTER.equals(implicitEventName)) //NOSONAR
			return true; //NOSONAR

		if (AbstractCPAction.IMPLICIT_EVENT_AFTER_EVENTS.equals(implicitEventName)) //NOSONAR
			return true; //NOSONAR

		if (AbstractCPAction.IMPLICIT_EVENT_ON_REFRESH.equals(implicitEventName)) //NOSONAR
			return true; //NOSONAR

		// else
		return false;
	}

	protected boolean isOnRefreshLegacyMode() {
		return false;
	}

	//////////////////////////////////////////////////////////////////////////////////
	/// metodi specifici per la gestione del singolo tipo di evento sul singolo widget
	/// contenuto nel contentPanel
	/// metodo: handle<nomeWidget>_<NOME_EVENTO>
	/// es: handletreeVoci_CLICKED
	//////////////////////////////////////////////////////////////////////////////////

	/**
	 * Gestione dell'evento CLICKED sul widget [btnInserisciIspezionePerImpianto]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnInserisciIspezionePerImpianto_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_ispezioni_impianti", "cpelencoispezioniimpianti",
				"btnInserisciIspezionePerImpianto", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnModificaIspezionePerImpianto]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnModificaIspezionePerImpianto_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_ispezioni_impianti", "cpelencoispezioniimpianti",
				"btnModificaIspezionePerImpianto", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnConsolidaIspezionePerImpianto]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnConsolidaIspezionePerImpianto_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_ispezioni_impianti", "cpelencoispezioniimpianti",
				"btnConsolidaIspezionePerImpianto", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnAnnullaIspezionePerImpianto]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnAnnullaIspezionePerImpianto_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_ispezioni_impianti", "cpelencoispezioniimpianti",
				"btnAnnullaIspezionePerImpianto", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnDettaglioIspezionePerImpianto]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnDettaglioIspezionePerImpianto_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_ispezioni_impianti", "cpelencoispezioniimpianti",
				"btnDettaglioIspezionePerImpianto", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnInserisciAllegatoIspePerImpianto]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnInserisciAllegatoIspePerImpianto_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_ispezioni_impianti", "cpelencoispezioniimpianti",
				"btnInserisciAllegatoIspePerImpianto", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnModificaAllegatoIspePerImpianto]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnModificaAllegatoIspePerImpianto_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_ispezioni_impianti", "cpelencoispezioniimpianti",
				"btnModificaAllegatoIspePerImpianto", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnDettaglioAllegatoIspePerImpianto]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnDettaglioAllegatoIspePerImpianto_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_ispezioni_impianti", "cpelencoispezioniimpianti",
				"btnDettaglioAllegatoIspePerImpianto", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnAnnullaAllegatoIspePerImpianto]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnAnnullaAllegatoIspePerImpianto_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_ispezioni_impianti", "cpelencoispezioniimpianti",
				"btnAnnullaAllegatoIspePerImpianto", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnRicevutaAllegatoIspePerImpianto]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnRicevutaAllegatoIspePerImpianto_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_ispezioni_impianti", "cpelencoispezioniimpianti",
				"btnRicevutaAllegatoIspePerImpianto", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnDocumentazioneAllegatoIspePerImpianto]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnDocumentazioneAllegatoIspePerImpianto_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_ispezioni_impianti", "cpelencoispezioniimpianti",
				"btnDocumentazioneAllegatoIspePerImpianto", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnIndietroElencoIspezioniImpianti]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnIndietroElencoIspezioniImpianti_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_ispezioni_impianti", "cpelencoispezioniimpianti",
				"btnIndietroElencoIspezioniImpianti", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnCercaIspe]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnCercaIspe_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_ispezioni_impianti", "cpelencoispezioniimpianti", "btnCercaIspe", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnNuovaRicercaIspe]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnNuovaRicercaIspe_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_ispezioni_impianti", "cpelencoispezioniimpianti", "btnNuovaRicercaIspe",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnAnnullaDatiIspezione]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnAnnullaDatiIspezione_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_ispezioni_impianti", "cpelencoispezioniimpianti", "btnAnnullaDatiIspezione",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnChiudiDatiIspezione]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnChiudiDatiIspezione_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_ispezioni_impianti", "cpelencoispezioniimpianti", "btnChiudiDatiIspezione",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnCreaIspezione]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnCreaIspezione_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_ispezioni_impianti", "cpelencoispezioniimpianti", "btnCreaIspezione",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento VALUE_CHANGED sul widget [cbTipoAllegato]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleCbTipoAllegato_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("elenco_ispezioni_impianti", "cpelencoispezioniimpianti", "cbTipoAllegato",
				"VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnFiltraComp]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnFiltraComp_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_ispezioni_impianti", "cpelencoispezioniimpianti", "btnFiltraComp",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnAnnullaDatiAllegato]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnAnnullaDatiAllegato_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_ispezioni_impianti", "cpelencoispezioniimpianti", "btnAnnullaDatiAllegato",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnChiudiDatiAllegato]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnChiudiDatiAllegato_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_ispezioni_impianti", "cpelencoispezioniimpianti", "btnChiudiDatiAllegato",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnCreaAllegato]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnCreaAllegato_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_ispezioni_impianti", "cpelencoispezioniimpianti", "btnCreaAllegato",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btConferma]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtConferma_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_ispezioni_impianti", "cpelencoispezioniimpianti", "btConferma", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btAnnulla]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtAnnulla_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_ispezioni_impianti", "cpelencoispezioniimpianti", "btAnnulla", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btConfermaAnnulla]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtConfermaAnnulla_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_ispezioni_impianti", "cpelencoispezioniimpianti", "btConfermaAnnulla",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btAnnullaAnnulla]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtAnnullaAnnulla_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_ispezioni_impianti", "cpelencoispezioniimpianti", "btAnnullaAnnulla",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btConfermaAnnullaAll]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtConfermaAnnullaAll_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_ispezioni_impianti", "cpelencoispezioniimpianti", "btConfermaAnnullaAll",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btAnnullaAnnullaAll]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtAnnullaAnnullaAll_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_ispezioni_impianti", "cpelencoispezioniimpianti", "btAnnullaAnnullaAll",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btConfermaCancella]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtConfermaCancella_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_ispezioni_impianti", "cpelencoispezioniimpianti", "btConfermaCancella",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btAnnullaCancella]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtAnnullaCancella_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_ispezioni_impianti", "cpelencoispezioniimpianti", "btAnnullaCancella",
				"CLICKED");

	}

	//////////////////////////////////////////////////////////////////////////////////
	/// metodo di data providing sull'intero ContentPanel
	/// metodo: provide_CPDATA
	//////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////
	/// metodi di data providing sui widget dotati di multi data binding
	/// contenuti nel contentPanel
	/// metodo: provide<nomeWidget>_<tipologia dati>
	/// es: provideCbComuni_DATASET
	//////////////////////////////////////////////////////////////////////////////////

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget tblElencoIspezioni.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideTblElencoIspezioni_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoIspezioniPerImpianto", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbTipoAllegato.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbTipoAllegato_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoTipiDocumentoProfilatiIsp", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbCombustibile.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbCombustibile_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoTipiCombustibileIsp", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbApparecchiature.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbApparecchiature_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoApparecchiatureIsp", "", false, false);
	}

	/**
	 * Gestione della validazione
	 */
	public void validate() {
		/*PROTECTED REGION ID(R-1717200947) ENABLED START*/
		/* Inserire la validazione */
		/*PROTECTED REGION END*/
	}

	/**
	 * Metodo di preparazione della schermata/action
	 */
	public void prepare() throws CommandExecutionException {
		super.prepare();

	}

	/**
	 *	Metodo per la rimozione dalla sessione degli application data a scope
	 *  SAME_PAGE. 
	 */
	public void clearPageScopedAppData(String targetContentPanelName) {
		// nothing to clear...
	}

	@SkipValidation
	public String handleChangeTab() {
		if (this.hasActionErrors() || this.hasFieldErrors() || this.hasErrors())
			return INPUT;
		else {
			session.put(getModel().getSelectedTabKey(), getModel().getSelectedTabValue());
			return SUCCESS;
		}
	}

}
