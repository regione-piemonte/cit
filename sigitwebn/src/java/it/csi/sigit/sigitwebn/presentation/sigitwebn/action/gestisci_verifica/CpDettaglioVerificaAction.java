package it.csi.sigit.sigitwebn.presentation.sigitwebn.action.gestisci_verifica;

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
import it.csi.sigit.sigitwebn.dto.gestisci_verifica.CpDettaglioVerificaModel;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.command.*;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.security.*;

import it.csi.sigit.sigitwebn.business.*;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.action.*;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.action.gestisci_verifica.states.CpDettaglioVerificaScreenStates;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.interceptor.MethodProtection;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.interceptor.FatClientOnly;
import it.csi.sigit.sigitwebn.presentation.uiutils.*;
import flexjson.JSON;

/**
 * CpDettaglioVerificaAction Action Class.
 *
 * @author GuiGen
 */
@Validation()
@Conversion()
public class CpDettaglioVerificaAction extends AbstractCPAction<CpDettaglioVerificaModel>
		implements
			Preparable,
			ModelDriven<CpDettaglioVerificaModel> {

	/**
	 * Il modello del content panel.
	 * Viene riempito a fornte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	private CpDettaglioVerificaModel model;

	/**
	 * Il modello del content panel.
	 * Viene riempito a fornte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	public CpDettaglioVerificaModel getModel() {
		return model;
	}

	/**
	 * Il modello del content panel.
	 * Viene riempito a fronte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	@VisitorFieldValidator(message = "", appendPrefix = false)
	public void setModel(CpDettaglioVerificaModel modello) {
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
			model = new CpDettaglioVerificaModel();
		}
		// associo la sessione applicativa al modello, in modo che
		// possa implementare l'accesso agli application data
		// di scope session/same page
		model.setSession(session);
	}

	/**
	 * nome del content panel
	 */
	private static final String CP_NAME = "cpDettaglioVerifica";

	/**
	 * nome del namespace che contiene il content panel
	 */
	private static final String CP_NAMESPACE = "gestisci_verifica";

	/**
	 * nome completo del namespace che contiene il content panel
	 */
	private static final String CP_FULL_NAMESPACE = "/base/gestisci_verifica";

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

	private static final String URL_BACK_COMMAND = "/base/gestisci_verifica/" + CP_NAME;

	/**
	 * classe model associata al ContentPanel
	 */
	public Class modelClass() {
		return it.csi.sigit.sigitwebn.dto.gestisci_verifica.CpDettaglioVerificaModel.class;
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
	 * Gestione dell'evento CLICKED sul widget [btSalva]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtSalva_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_verifica", "cpdettaglioverifica", "btSalva", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [tbAzioni]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleTbAzioni_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_verifica", "cpdettaglioverifica", "tbAzioni", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btInserisciAzione]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtInserisciAzione_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_verifica", "cpdettaglioverifica", "btInserisciAzione", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btIGestisciSveglia]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtIGestisciSveglia_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_verifica", "cpdettaglioverifica", "btIGestisciSveglia", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btAvviaAccertamento]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtAvviaAccertamento_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_verifica", "cpdettaglioverifica", "btAvviaAccertamento", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btVisAccertamento]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtVisAccertamento_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_verifica", "cpdettaglioverifica", "btVisAccertamento", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btAvviaIspezione]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtAvviaIspezione_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_verifica", "cpdettaglioverifica", "btAvviaIspezione", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btVisIspezione]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtVisIspezione_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_verifica", "cpdettaglioverifica", "btVisIspezione", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btIndietro]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtIndietro_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_verifica", "cpdettaglioverifica", "btIndietro", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btImpostaNuova]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtImpostaNuova_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_verifica", "cpdettaglioverifica", "btImpostaNuova", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btEliminaSveglia]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtEliminaSveglia_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_verifica", "cpdettaglioverifica", "btEliminaSveglia", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btChiudi]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtChiudi_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_verifica", "cpdettaglioverifica", "btChiudi", "CLICKED");

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
	 * al data-binding relativo al dataset DATASET del widget tbAzioni.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideTbAzioni_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoAzioni", "", false, false);
	}

	/**
	 * Gestione della validazione
	 */
	public void validate() {
		/*PROTECTED REGION ID(R-2004936422) ENABLED START*/
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
