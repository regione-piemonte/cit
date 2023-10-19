package it.csi.sigit.sigitwebn.presentation.sigitwebn.action.gestisci_delega;

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
import it.csi.sigit.sigitwebn.dto.gestisci_delega.CpGestDelegaModel;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.command.*;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.security.*;

import it.csi.sigit.sigitwebn.business.*;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.action.*;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.action.gestisci_delega.states.CpGestDelegaScreenStates;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.interceptor.MethodProtection;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.interceptor.FatClientOnly;
import it.csi.sigit.sigitwebn.presentation.uiutils.*;
import flexjson.JSON;

/**
 * CpGestDelegaAction Action Class.
 *
 * @author GuiGen
 */
@Validation()
@Conversion()
public class CpGestDelegaAction extends AbstractCPAction<CpGestDelegaModel>
		implements
			Preparable,
			ModelDriven<CpGestDelegaModel> {

	/**
	 * Il modello del content panel.
	 * Viene riempito a fornte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	private CpGestDelegaModel model;

	/**
	 * Il modello del content panel.
	 * Viene riempito a fornte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	public CpGestDelegaModel getModel() {
		return model;
	}

	/**
	 * Il modello del content panel.
	 * Viene riempito a fronte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	@VisitorFieldValidator(message = "", appendPrefix = false)
	public void setModel(CpGestDelegaModel modello) {
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
			model = new CpGestDelegaModel();
		}
		// associo la sessione applicativa al modello, in modo che
		// possa implementare l'accesso agli application data
		// di scope session/same page
		model.setSession(session);
	}

	/**
	 * nome del content panel
	 */
	private static final String CP_NAME = "cpGestDelega";

	/**
	 * nome del namespace che contiene il content panel
	 */
	private static final String CP_NAMESPACE = "gestisci_delega";

	/**
	 * nome completo del namespace che contiene il content panel
	 */
	private static final String CP_FULL_NAMESPACE = "/base/gestisci_delega";

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

	private static final String URL_BACK_COMMAND = "/base/gestisci_delega/" + CP_NAME;

	/**
	 * classe model associata al ContentPanel
	 */
	public Class modelClass() {
		return it.csi.sigit.sigitwebn.dto.gestisci_delega.CpGestDelegaModel.class;
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
	 * Gestione dell'evento CLICKED sul widget [btnImpCercaCF]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnImpCercaCF_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_delega", "cpgestdelega", "btnImpCercaCF", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnImpNuovaRicercaCF]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnImpNuovaRicercaCF_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_delega", "cpgestdelega", "btnImpNuovaRicercaCF", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnInserisciDelegato]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnInserisciDelegato_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_delega", "cpgestdelega", "btnInserisciDelegato", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnCessaDelegato]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnCessaDelegato_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_delega", "cpgestdelega", "btnCessaDelegato", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnDelegatoCercaCf]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnDelegatoCercaCf_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_delega", "cpgestdelega", "btnDelegatoCercaCf", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnDelegatoNuovaRicercaCf]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnDelegatoNuovaRicercaCf_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_delega", "cpgestdelega", "btnDelegatoNuovaRicercaCf", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnDelAnnulla]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnDelAnnulla_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_delega", "cpgestdelega", "btnDelAnnulla", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnDelConferma]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnDelConferma_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_delega", "cpgestdelega", "btnDelConferma", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnAnnullaPelegatoPot]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnAnnullaPelegatoPot_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_delega", "cpgestdelega", "btnAnnullaPelegatoPot", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnSelezionaDelegatoPot]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnSelezionaDelegatoPot_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_delega", "cpgestdelega", "btnSelezionaDelegatoPot", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnDelIndietro]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnDelIndietro_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_delega", "cpgestdelega", "btnDelIndietro", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btConferma]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtConferma_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_delega", "cpgestdelega", "btConferma", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btAnnulla]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtAnnulla_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_delega", "cpgestdelega", "btAnnulla", "CLICKED");

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
	 * al data-binding relativo al dataset DATASET del widget cbImpSiglaRea.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbImpSiglaRea_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoSiglaRea", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget tbDelegatiAssociati.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideTbDelegatiAssociati_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoDelegatiAssociati", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget tbDelegatiPotenziali.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideTbDelegatiPotenziali_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoDelegatiPotenziali", "", false, false);
	}

	/**
	 * Gestione della validazione
	 */
	public void validate() {
		/*PROTECTED REGION ID(R-1009540161) ENABLED START*/
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
