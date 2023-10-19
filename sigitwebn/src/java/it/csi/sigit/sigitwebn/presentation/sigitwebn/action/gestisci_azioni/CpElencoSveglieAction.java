package it.csi.sigit.sigitwebn.presentation.sigitwebn.action.gestisci_azioni;

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
import it.csi.sigit.sigitwebn.dto.gestisci_azioni.CpElencoSveglieModel;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.command.*;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.security.*;

import it.csi.sigit.sigitwebn.business.*;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.action.*;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.action.gestisci_azioni.states.CpElencoSveglieScreenStates;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.interceptor.MethodProtection;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.interceptor.FatClientOnly;
import it.csi.sigit.sigitwebn.presentation.uiutils.*;
import flexjson.JSON;

/**
 * CpElencoSveglieAction Action Class.
 *
 * @author GuiGen
 */
@Validation()
@Conversion()
public class CpElencoSveglieAction extends AbstractCPAction<CpElencoSveglieModel>
		implements
			Preparable,
			ModelDriven<CpElencoSveglieModel> {

	/**
	 * Il modello del content panel.
	 * Viene riempito a fornte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	private CpElencoSveglieModel model;

	/**
	 * Il modello del content panel.
	 * Viene riempito a fornte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	public CpElencoSveglieModel getModel() {
		return model;
	}

	/**
	 * Il modello del content panel.
	 * Viene riempito a fronte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	@VisitorFieldValidator(message = "", appendPrefix = false)
	public void setModel(CpElencoSveglieModel modello) {
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
			model = new CpElencoSveglieModel();
		}
		// associo la sessione applicativa al modello, in modo che
		// possa implementare l'accesso agli application data
		// di scope session/same page
		model.setSession(session);
	}

	/**
	 * nome del content panel
	 */
	private static final String CP_NAME = "cpElencoSveglie";

	/**
	 * nome del namespace che contiene il content panel
	 */
	private static final String CP_NAMESPACE = "gestisci_azioni";

	/**
	 * nome completo del namespace che contiene il content panel
	 */
	private static final String CP_FULL_NAMESPACE = "/base/gestisci_azioni";

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

	private static final String URL_BACK_COMMAND = "/base/gestisci_azioni/" + CP_NAME;

	/**
	 * classe model associata al ContentPanel
	 */
	public Class modelClass() {
		return it.csi.sigit.sigitwebn.dto.gestisci_azioni.CpElencoSveglieModel.class;
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
	 * Gestione dell'evento CLICKED sul widget [btCercaUtente]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtCercaUtente_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_azioni", "cpelencosveglie", "btCercaUtente", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btNuovaRicercaUtente]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtNuovaRicercaUtente_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_azioni", "cpelencosveglie", "btNuovaRicercaUtente", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btVisVerifica]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtVisVerifica_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_azioni", "cpelencosveglie", "btVisVerifica", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btVisAccertamento]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtVisAccertamento_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_azioni", "cpelencosveglie", "btVisAccertamento", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btVisIspezione]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtVisIspezione_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_azioni", "cpelencosveglie", "btVisIspezione", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btVisSanzione]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtVisSanzione_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_azioni", "cpelencosveglie", "btVisSanzione", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btVisAccertamentoNonAss]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtVisAccertamentoNonAss_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_azioni", "cpelencosveglie", "btVisAccertamentoNonAss", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btVisIspezioneNonAss]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtVisIspezioneNonAss_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_azioni", "cpelencosveglie", "btVisIspezioneNonAss", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btIndietro]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtIndietro_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_azioni", "cpelencosveglie", "btIndietro", "CLICKED");

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
	 * al data-binding relativo al dataset DATASET del widget tbVerifiche.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideTbVerifiche_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoSveglieVerifica", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget tbAccertamento.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideTbAccertamento_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoSveglieAccertamento", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget tbIspezione.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideTbIspezione_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoSveglieIspezione", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget tbSanzione.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideTbSanzione_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoSveglieSanzione", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget tbAccertamentoNonAss.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideTbAccertamentoNonAss_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoSveglieAccertamentoNonAss", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget tbIspezioneNonAss.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideTbIspezioneNonAss_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoSveglieIspezioneNonAss", "", false, false);
	}

	/**
	 * Gestione della validazione
	 */
	public void validate() {
		/*PROTECTED REGION ID(R-1435617627) ENABLED START*/
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
