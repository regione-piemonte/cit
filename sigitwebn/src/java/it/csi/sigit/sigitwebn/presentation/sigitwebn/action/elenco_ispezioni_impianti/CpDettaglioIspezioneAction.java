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
import it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpDettaglioIspezioneModel;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.command.*;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.security.*;

import it.csi.sigit.sigitwebn.business.*;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.action.*;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.action.elenco_ispezioni_impianti.states.CpDettaglioIspezioneScreenStates;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.interceptor.MethodProtection;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.interceptor.FatClientOnly;
import it.csi.sigit.sigitwebn.presentation.uiutils.*;
import flexjson.JSON;

/**
 * CpDettaglioIspezioneAction Action Class.
 *
 * @author GuiGen
 */
@Validation()
@Conversion()
public class CpDettaglioIspezioneAction extends AbstractCPAction<CpDettaglioIspezioneModel>
		implements
			Preparable,
			ModelDriven<CpDettaglioIspezioneModel> {

	/**
	 * Il modello del content panel.
	 * Viene riempito a fornte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	private CpDettaglioIspezioneModel model;

	/**
	 * Il modello del content panel.
	 * Viene riempito a fornte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	public CpDettaglioIspezioneModel getModel() {
		return model;
	}

	/**
	 * Il modello del content panel.
	 * Viene riempito a fronte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	@VisitorFieldValidator(message = "", appendPrefix = false)
	public void setModel(CpDettaglioIspezioneModel modello) {
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
			model = new CpDettaglioIspezioneModel();
		}
		// associo la sessione applicativa al modello, in modo che
		// possa implementare l'accesso agli application data
		// di scope session/same page
		model.setSession(session);
	}

	/**
	 * nome del content panel
	 */
	private static final String CP_NAME = "cpDettaglioIspezione";

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
		return it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpDettaglioIspezioneModel.class;
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
	 * Gestione dell'evento CLICKED sul widget [btnInserisciRappProva]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnInserisciRappProva_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_ispezioni_impianti", "cpdettaglioispezione", "btnInserisciRappProva",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnModificaRappProva]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnModificaRappProva_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_ispezioni_impianti", "cpdettaglioispezione", "btnModificaRappProva",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnDettaglioRappProva]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnDettaglioRappProva_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_ispezioni_impianti", "cpdettaglioispezione", "btnDettaglioRappProva",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnAnnullaRappProva]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnAnnullaRappProva_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_ispezioni_impianti", "cpdettaglioispezione", "btnAnnullaRappProva",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnRicevutaRappProva]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnRicevutaRappProva_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_ispezioni_impianti", "cpdettaglioispezione", "btnRicevutaRappProva",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnDocumentazioneRappProva]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnDocumentazioneRappProva_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_ispezioni_impianti", "cpdettaglioispezione", "btnDocumentazioneRappProva",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnIndietroElencoIspezioniImpianti]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnIndietroElencoIspezioniImpianti_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_ispezioni_impianti", "cpdettaglioispezione",
				"btnIndietroElencoIspezioniImpianti", "CLICKED");

	}

	/**
	 * Gestione dell'evento VALUE_CHANGED sul widget [cbTipoAllegato]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleCbTipoAllegato_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("elenco_ispezioni_impianti", "cpdettaglioispezione", "cbTipoAllegato",
				"VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnCerca]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnCerca_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_ispezioni_impianti", "cpdettaglioispezione", "btnCerca", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnNuovaCerca]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnNuovaCerca_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_ispezioni_impianti", "cpdettaglioispezione", "btnNuovaCerca", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnFiltraComp]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnFiltraComp_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_ispezioni_impianti", "cpdettaglioispezione", "btnFiltraComp", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnAnnullaDatiAllegato]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnAnnullaDatiAllegato_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_ispezioni_impianti", "cpdettaglioispezione", "btnAnnullaDatiAllegato",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnChiudiDatiAllegato]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnChiudiDatiAllegato_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_ispezioni_impianti", "cpdettaglioispezione", "btnChiudiDatiAllegato",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnCreaAllegato]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnCreaAllegato_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_ispezioni_impianti", "cpdettaglioispezione", "btnCreaAllegato", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btConfermaAnnullaAll]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtConfermaAnnullaAll_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_ispezioni_impianti", "cpdettaglioispezione", "btConfermaAnnullaAll",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btAnnullaAnnullaAll]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtAnnullaAnnullaAll_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_ispezioni_impianti", "cpdettaglioispezione", "btAnnullaAnnullaAll",
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
	 * al data-binding relativo al dataset DATASET del widget tblElencoRappProva.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideTblElencoRappProva_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoAllegatiIsp", "", false, false);
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
		/*PROTECTED REGION ID(R-1512755995) ENABLED START*/
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
