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
import it.csi.sigit.sigitwebn.dto.gestisci_verifica.CpGestVerificaModel;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.command.*;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.security.*;

import it.csi.sigit.sigitwebn.business.*;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.action.*;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.action.gestisci_verifica.states.CpGestVerificaScreenStates;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.interceptor.MethodProtection;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.interceptor.FatClientOnly;
import it.csi.sigit.sigitwebn.presentation.uiutils.*;
import flexjson.JSON;

/**
 * CpGestVerificaAction Action Class.
 *
 * @author GuiGen
 */
@Validation()
@Conversion()
public class CpGestVerificaAction extends AbstractCPAction<CpGestVerificaModel>
		implements
			Preparable,
			ModelDriven<CpGestVerificaModel> {

	/**
	 * Il modello del content panel.
	 * Viene riempito a fornte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	private CpGestVerificaModel model;

	/**
	 * Il modello del content panel.
	 * Viene riempito a fornte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	public CpGestVerificaModel getModel() {
		return model;
	}

	/**
	 * Il modello del content panel.
	 * Viene riempito a fronte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	@VisitorFieldValidator(message = "", appendPrefix = false)
	public void setModel(CpGestVerificaModel modello) {
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
			model = new CpGestVerificaModel();
		}
		// associo la sessione applicativa al modello, in modo che
		// possa implementare l'accesso agli application data
		// di scope session/same page
		model.setSession(session);
	}

	/**
	 * nome del content panel
	 */
	private static final String CP_NAME = "cpGestVerifica";

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
		return it.csi.sigit.sigitwebn.dto.gestisci_verifica.CpGestVerificaModel.class;
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
	 * Gestione dell'evento CLICKED sul widget [hvGestInsVerificaAuto]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleHvGestInsVerificaAuto_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_verifica", "cpgestverifica", "hvGestInsVerificaAuto", "CLICKED");

	}

	/**
	 * Gestione dell'evento VALUE_CHANGED sul widget [cbTipoVerifica]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleCbTipoVerifica_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("gestisci_verifica", "cpgestverifica", "cbTipoVerifica", "VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btCercaImpianto]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtCercaImpianto_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_verifica", "cpgestverifica", "btCercaImpianto", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btNuovaRicercaImpianto]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtNuovaRicercaImpianto_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_verifica", "cpgestverifica", "btNuovaRicercaImpianto", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btCercaBollino]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtCercaBollino_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_verifica", "cpgestverifica", "btCercaBollino", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btNuovaRicercaBollino]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtNuovaRicercaBollino_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_verifica", "cpgestverifica", "btNuovaRicercaBollino", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btCercaDatoDistributore]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtCercaDatoDistributore_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_verifica", "cpgestverifica", "btCercaDatoDistributore", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btNuovaRicercaDatoDistributore]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtNuovaRicercaDatoDistributore_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_verifica", "cpgestverifica", "btNuovaRicercaDatoDistributore", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btSalva]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtSalva_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_verifica", "cpgestverifica", "btSalva", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btIndietro]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtIndietro_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_verifica", "cpgestverifica", "btIndietro", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btConferma]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtConferma_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_verifica", "cpgestverifica", "btConferma", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btAnnulla]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtAnnulla_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_verifica", "cpgestverifica", "btAnnulla", "CLICKED");

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
	 * al data-binding relativo al dataset DATASET del widget cbTipoVerifica.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbTipoVerifica_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoTipiVerifica", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbSiglaBollino.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbSiglaBollino_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoSiglaBollini", "", false, false);
	}

	/**
	 * Gestione della validazione
	 */
	public void validate() {
		/*PROTECTED REGION ID(R-760027156) ENABLED START*/
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
