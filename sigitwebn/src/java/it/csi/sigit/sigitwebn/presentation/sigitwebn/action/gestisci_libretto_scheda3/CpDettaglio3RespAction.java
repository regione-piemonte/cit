package it.csi.sigit.sigitwebn.presentation.sigitwebn.action.gestisci_libretto_scheda3;

import java.io.File;
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
import it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda3.CpDettaglio3RespModel;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.command.*;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.security.*;

import it.csi.sigit.sigitwebn.business.*;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.action.*;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.action.gestisci_libretto_scheda3.states.CpDettaglio3RespScreenStates;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.interceptor.MethodProtection;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.interceptor.FatClientOnly;
import it.csi.sigit.sigitwebn.presentation.uiutils.*;
import flexjson.JSON;

/**
 * CpDettaglio3RespAction Action Class.
 *
 * @author GuiGen
 */
@Validation()
@Conversion()
public class CpDettaglio3RespAction extends AbstractCPAction<CpDettaglio3RespModel>
		implements
			Preparable,
			ModelDriven<CpDettaglio3RespModel> {

	/**
	 * Il modello del content panel.
	 * Viene riempito a fornte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	private CpDettaglio3RespModel model;

	/**
	 * Il modello del content panel.
	 * Viene riempito a fornte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	public CpDettaglio3RespModel getModel() {
		return model;
	}

	/**
	 * Il modello del content panel.
	 * Viene riempito a fronte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	@VisitorFieldValidator(message = "", appendPrefix = false)
	public void setModel(CpDettaglio3RespModel modello) {
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
			model = new CpDettaglio3RespModel();
		}
		// associo la sessione applicativa al modello, in modo che
		// possa implementare l'accesso agli application data
		// di scope session/same page
		model.setSession(session);
	}

	/**
	 * nome del content panel
	 */
	private static final String CP_NAME = "cpDettaglio3Resp";

	/**
	 * nome del namespace che contiene il content panel
	 */
	private static final String CP_NAMESPACE = "gestisci_libretto_scheda3";

	/**
	 * nome completo del namespace che contiene il content panel
	 */
	private static final String CP_FULL_NAMESPACE = "/base/gestisci_libretto_scheda3";

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

	private static final String URL_BACK_COMMAND = "/base/gestisci_libretto_scheda3/" + CP_NAME;

	/**
	 * classe model associata al ContentPanel
	 */
	public Class modelClass() {
		return it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda3.CpDettaglio3RespModel.class;
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
	 * Gestione dell'evento CLICKED sul widget [menuLibretto]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleMenuLibretto_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_libretto_scheda3", "cpdettaglio3resp", "menuLibretto", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btProroga]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtProroga_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_libretto_scheda3", "cpdettaglio3resp", "btProroga", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btConfermaProroga]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtConfermaProroga_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_libretto_scheda3", "cpdettaglio3resp", "btConfermaProroga", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btChiudiProroga]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtChiudiProroga_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_libretto_scheda3", "cpdettaglio3resp", "btChiudiProroga", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btVisDOc]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtVisDOc_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_libretto_scheda3", "cpdettaglio3resp", "btVisDOc", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btInsDOc]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtInsDOc_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_libretto_scheda3", "cpdettaglio3resp", "btInsDOc", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btElimDOc]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtElimDOc_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_libretto_scheda3", "cpdettaglio3resp", "btElimDOc", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btCaricaDoc]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtCaricaDoc_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_libretto_scheda3", "cpdettaglio3resp", "btCaricaDoc", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btChiudiDoc]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtChiudiDoc_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_libretto_scheda3", "cpdettaglio3resp", "btChiudiDoc", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btIndConfTerzResp]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtIndConfTerzResp_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_libretto_scheda3", "cpdettaglio3resp", "btIndConfTerzResp", "CLICKED");

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
	 * al data-binding relativo al dataset DATASET del widget menuLibretto.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideMenuLibretto_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDatalibrettoMenuTree", "", false, true);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget tbDocContratti.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideTbDocContratti_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoDocContratti", "", false, false);
	}

	/**
	 * Gestione della validazione
	 */
	public void validate() {
		/*PROTECTED REGION ID(R369086810) ENABLED START*/
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
