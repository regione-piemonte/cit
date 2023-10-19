package it.csi.sigit.sigitwebn.presentation.sigitwebn.action.gestisci_terzo_responsabile;

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
import it.csi.sigit.sigitwebn.dto.gestisci_terzo_responsabile.CpGest3RespModel;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.command.*;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.security.*;

import it.csi.sigit.sigitwebn.business.*;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.action.*;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.action.gestisci_terzo_responsabile.states.CpGest3RespScreenStates;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.interceptor.MethodProtection;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.interceptor.FatClientOnly;
import it.csi.sigit.sigitwebn.presentation.uiutils.*;
import flexjson.JSON;

/**
 * CpGest3RespAction Action Class.
 *
 * @author GuiGen
 */
@Validation()
@Conversion()
public class CpGest3RespAction extends AbstractCPAction<CpGest3RespModel>
		implements
			Preparable,
			ModelDriven<CpGest3RespModel> {

	/**
	 * Il modello del content panel.
	 * Viene riempito a fornte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	private CpGest3RespModel model;

	/**
	 * Il modello del content panel.
	 * Viene riempito a fornte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	public CpGest3RespModel getModel() {
		return model;
	}

	/**
	 * Il modello del content panel.
	 * Viene riempito a fronte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	@VisitorFieldValidator(message = "", appendPrefix = false)
	public void setModel(CpGest3RespModel modello) {
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
			model = new CpGest3RespModel();
		}
		// associo la sessione applicativa al modello, in modo che
		// possa implementare l'accesso agli application data
		// di scope session/same page
		model.setSession(session);
	}

	/**
	 * nome del content panel
	 */
	private static final String CP_NAME = "cpGest3Resp";

	/**
	 * nome del namespace che contiene il content panel
	 */
	private static final String CP_NAMESPACE = "gestisci_terzo_responsabile";

	/**
	 * nome completo del namespace che contiene il content panel
	 */
	private static final String CP_FULL_NAMESPACE = "/base/gestisci_terzo_responsabile";

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

	private static final String URL_BACK_COMMAND = "/base/gestisci_terzo_responsabile/" + CP_NAME;

	/**
	 * classe model associata al ContentPanel
	 */
	public Class modelClass() {
		return it.csi.sigit.sigitwebn.dto.gestisci_terzo_responsabile.CpGest3RespModel.class;
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

		return handleEventInternal("gestisci_terzo_responsabile", "cpgest3resp", "btnImpCercaCF", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnImpNuovaRicercaCF]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnImpNuovaRicercaCF_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_terzo_responsabile", "cpgest3resp", "btnImpNuovaRicercaCF", "CLICKED");

	}

	/**
	 * Gestione dell'evento VALUE_CHANGED sul widget [cbImpLocProvincia]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleCbImpLocProvincia_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("gestisci_terzo_responsabile", "cpgest3resp", "cbImpLocProvincia", "VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnImpLocCercaIndirizzo]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnImpLocCercaIndirizzo_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_terzo_responsabile", "cpgest3resp", "btnImpLocCercaIndirizzo", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnImpLocNuovaRicercaIndirizzo]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnImpLocNuovaRicercaIndirizzo_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_terzo_responsabile", "cpgest3resp", "btnImpLocNuovaRicercaIndirizzo",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnVerificaImpianto]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnVerificaImpianto_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_terzo_responsabile", "cpgest3resp", "btnVerificaImpianto", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnNewRicImpianto]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnNewRicImpianto_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_terzo_responsabile", "cpgest3resp", "btnNewRicImpianto", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnConfResp]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnConfResp_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_terzo_responsabile", "cpgest3resp", "btnConfResp", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btn3RespIndietro]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtn3RespIndietro_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_terzo_responsabile", "cpgest3resp", "btn3RespIndietro", "CLICKED");

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
	 * al data-binding relativo al dataset DATASET del widget cbImpLocProvincia.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbImpLocProvincia_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoProvincePiemonte", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbImpLocComune.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbImpLocComune_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoComuni", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbImpLocIndirizzo.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbImpLocIndirizzo_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoIndirizzi3Resp", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget tbRespImpianto3Resp.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideTbRespImpianto3Resp_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoResponsabiliImpianto", "", false, false);
	}

	/**
	 * Gestione della validazione
	 */
	public void validate() {
		/*PROTECTED REGION ID(R-1174355000) ENABLED START*/
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
