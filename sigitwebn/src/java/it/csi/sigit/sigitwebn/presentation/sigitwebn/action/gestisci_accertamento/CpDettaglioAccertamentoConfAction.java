package it.csi.sigit.sigitwebn.presentation.sigitwebn.action.gestisci_accertamento;

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
import it.csi.sigit.sigitwebn.dto.gestisci_accertamento.CpDettaglioAccertamentoConfModel;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.command.*;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.security.*;

import it.csi.sigit.sigitwebn.business.*;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.action.*;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.action.gestisci_accertamento.states.CpDettaglioAccertamentoConfScreenStates;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.interceptor.MethodProtection;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.interceptor.FatClientOnly;
import it.csi.sigit.sigitwebn.presentation.uiutils.*;
import flexjson.JSON;

/**
 * CpDettaglioAccertamentoConfAction Action Class.
 *
 * @author GuiGen
 */
@Validation()
@Conversion()
public class CpDettaglioAccertamentoConfAction extends AbstractCPAction<CpDettaglioAccertamentoConfModel>
		implements
			Preparable,
			ModelDriven<CpDettaglioAccertamentoConfModel> {

	/**
	 * Il modello del content panel.
	 * Viene riempito a fornte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	private CpDettaglioAccertamentoConfModel model;

	/**
	 * Il modello del content panel.
	 * Viene riempito a fornte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	public CpDettaglioAccertamentoConfModel getModel() {
		return model;
	}

	/**
	 * Il modello del content panel.
	 * Viene riempito a fronte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	@VisitorFieldValidator(message = "", appendPrefix = false)
	public void setModel(CpDettaglioAccertamentoConfModel modello) {
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
			model = new CpDettaglioAccertamentoConfModel();
		}
		// associo la sessione applicativa al modello, in modo che
		// possa implementare l'accesso agli application data
		// di scope session/same page
		model.setSession(session);
	}

	/**
	 * nome del content panel
	 */
	private static final String CP_NAME = "cpDettaglioAccertamentoConf";

	/**
	 * nome del namespace che contiene il content panel
	 */
	private static final String CP_NAMESPACE = "gestisci_accertamento";

	/**
	 * nome completo del namespace che contiene il content panel
	 */
	private static final String CP_FULL_NAMESPACE = "/base/gestisci_accertamento";

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

	private static final String URL_BACK_COMMAND = "/base/gestisci_accertamento/" + CP_NAME;

	/**
	 * classe model associata al ContentPanel
	 */
	public Class modelClass() {
		return it.csi.sigit.sigitwebn.dto.gestisci_accertamento.CpDettaglioAccertamentoConfModel.class;
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
	 * Gestione dell'evento CLICKED sul widget [btCercaImpianto]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtCercaImpianto_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_accertamento", "cpdettaglioaccertamentoconf", "btCercaImpianto",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btNuovaRicercaImpianto]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtNuovaRicercaImpianto_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_accertamento", "cpdettaglioaccertamentoconf", "btNuovaRicercaImpianto",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btSalvaConcludiAcc]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtSalvaConcludiAcc_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_accertamento", "cpdettaglioaccertamentoconf", "btSalvaConcludiAcc",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btSalvaAssociaAcc]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtSalvaAssociaAcc_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_accertamento", "cpdettaglioaccertamentoconf", "btSalvaAssociaAcc",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btCercaCodiceImpianto]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtCercaCodiceImpianto_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_accertamento", "cpdettaglioaccertamentoconf", "btCercaCodiceImpianto",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btNuovaRicercaCodiceImpianto]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtNuovaRicercaCodiceImpianto_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_accertamento", "cpdettaglioaccertamentoconf",
				"btNuovaRicercaCodiceImpianto", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btSalvaAssociaCodImp]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtSalvaAssociaCodImp_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_accertamento", "cpdettaglioaccertamentoconf", "btSalvaAssociaCodImp",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btIndietro]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtIndietro_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_accertamento", "cpdettaglioaccertamentoconf", "btIndietro", "CLICKED");

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
	 * al data-binding relativo al dataset DATASET del widget cbTipoConclusione.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbTipoConclusione_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoTipoConclusione", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbElencoValidatori.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbElencoValidatori_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoValidatori", "", false, false);
	}

	/**
	 * Gestione della validazione
	 */
	public void validate() {
		/*PROTECTED REGION ID(R-2102058713) ENABLED START*/
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
