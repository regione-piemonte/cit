package it.csi.sigit.elencom.presentation.elencom.action.ricerca_module;

import java.util.*;

import java.lang.reflect.InvocationTargetException;
import java.beans.IntrospectionException;

import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.validator.annotations.*;
import com.opensymphony.xwork2.conversion.annotations.*;
import com.opensymphony.xwork2.ActionContext;

import it.csi.sigit.elencom.util.*;
import it.csi.sigit.elencom.dto.*;
import it.csi.sigit.elencom.dto.ricerca_module.CpRicercaModel;

import it.csi.sigit.elencom.presentation.elencom.command.*;

import it.csi.sigit.elencom.presentation.elencom.security.*;

import it.csi.sigit.elencom.business.*;

import it.csi.sigit.elencom.presentation.elencom.action.*;

import it.csi.sigit.elencom.presentation.elencom.action.ricerca_module.states.CpRicercaScreenStates;

import it.csi.sigit.elencom.presentation.elencom.interceptor.MethodProtection;

import it.csi.sigit.elencom.presentation.elencom.interceptor.FatClientOnly;
import it.csi.sigit.elencom.presentation.uiutils.*;
import flexjson.JSON;

/**
 * CpRicercaAction Action Class.
 *
 * @author GuiGen
 */
@Validation()
@Conversion()
public class CpRicercaAction extends AbstractCPAction<CpRicercaModel>
		implements
			Preparable,
			ModelDriven<CpRicercaModel> {

	/**
	 * Il modello del content panel.
	 * Viene riempito a fornte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	private CpRicercaModel model;

	/**
	 * Il modello del content panel.
	 * Viene riempito a fornte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	public CpRicercaModel getModel() {
		return model;
	}

	/**
	 * Il modello del content panel.
	 * Viene riempito a fronte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	@VisitorFieldValidator(message = "", appendPrefix = false)
	public void setModel(CpRicercaModel modello) {
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
			model = new CpRicercaModel();
		}
		// associo la sessione applicativa al modello, in modo che
		// possa implementare l'accesso agli application data
		// di scope session/same page
		model.setSession(session);
	}

	/**
	 * nome del content panel
	 */
	private static final String CP_NAME = "cpRicerca";

	/**
	 * nome del namespace che contiene il content panel
	 */
	private static final String CP_NAMESPACE = "ricerca_module";

	/**
	 * nome completo del namespace che contiene il content panel
	 */
	private static final String CP_FULL_NAMESPACE = "/base/ricerca_module";

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

	private static final String URL_BACK_COMMAND = "/base/ricerca_module/" + CP_NAME;

	/**
	 * classe model associata al ContentPanel
	 */
	public Class modelClass() {
		return it.csi.sigit.elencom.dto.ricerca_module.CpRicercaModel.class;
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

		if (AbstractCPAction.IMPLICIT_EVENT_ON_INIT.equals(implicitEventName)) //NOSONAR
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
	 * Gestione dell'evento VALUE_CHANGED sul widget [cbProvince]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleCbProvince_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("ricerca_module", "cpricerca", "cbProvince", "VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento VALUE_CHANGED sul widget [cbComuni]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleCbComuni_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("ricerca_module", "cpricerca", "cbComuni", "VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [hvDettWMS]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleHvDettWMS_CLICKED() throws CommandExecutionException {

		return handleEventInternal("ricerca_module", "cpricerca", "hvDettWMS", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btRicNew]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtRicNew_CLICKED() throws CommandExecutionException {

		return handleEventInternal("ricerca_module", "cpricerca", "btRicNew", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btDettaglio]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtDettaglio_CLICKED() throws CommandExecutionException {

		return handleEventInternal("ricerca_module", "cpricerca", "btDettaglio", "CLICKED");

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
	 * al data-binding relativo al dataset DATASET del widget cbProvince.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbProvince_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDatacomboProvince", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbComuni.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbComuni_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDatacomboComuni", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget tbElenco.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideTbElenco_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDatamanutentoriAppData", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget tbCorsi.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideTbCorsi_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoCorsi", "", false, false);
	}

	/**
	 * Gestione della validazione
	 */
	public void validate() {
		/*PROTECTED REGION ID(R847650837) ENABLED START*/
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
