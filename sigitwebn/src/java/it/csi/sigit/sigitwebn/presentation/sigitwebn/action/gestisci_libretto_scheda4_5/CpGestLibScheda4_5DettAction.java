package it.csi.sigit.sigitwebn.presentation.sigitwebn.action.gestisci_libretto_scheda4_5;

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
import it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda4_5.CpGestLibScheda4_5DettModel;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.command.*;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.security.*;

import it.csi.sigit.sigitwebn.business.*;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.action.*;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.action.gestisci_libretto_scheda4_5.states.CpGestLibScheda4_5DettScreenStates;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.interceptor.MethodProtection;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.interceptor.FatClientOnly;
import it.csi.sigit.sigitwebn.presentation.uiutils.*;
import flexjson.JSON;

/**
 * CpGestLibScheda4_5DettAction Action Class.
 *
 * @author GuiGen
 */
@Validation()
@Conversion()
public class CpGestLibScheda4_5DettAction extends AbstractCPAction<CpGestLibScheda4_5DettModel>
		implements
			Preparable,
			ModelDriven<CpGestLibScheda4_5DettModel> {

	/**
	 * Il modello del content panel.
	 * Viene riempito a fornte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	private CpGestLibScheda4_5DettModel model;

	/**
	 * Il modello del content panel.
	 * Viene riempito a fornte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	public CpGestLibScheda4_5DettModel getModel() {
		return model;
	}

	/**
	 * Il modello del content panel.
	 * Viene riempito a fronte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	@VisitorFieldValidator(message = "", appendPrefix = false)
	public void setModel(CpGestLibScheda4_5DettModel modello) {
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
			model = new CpGestLibScheda4_5DettModel();
		}
		// associo la sessione applicativa al modello, in modo che
		// possa implementare l'accesso agli application data
		// di scope session/same page
		model.setSession(session);
	}

	/**
	 * nome del content panel
	 */
	private static final String CP_NAME = "cpGestLibScheda4_5Dett";

	/**
	 * nome del namespace che contiene il content panel
	 */
	private static final String CP_NAMESPACE = "gestisci_libretto_scheda4_5";

	/**
	 * nome completo del namespace che contiene il content panel
	 */
	private static final String CP_FULL_NAMESPACE = "/base/gestisci_libretto_scheda4_5";

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

	private static final String URL_BACK_COMMAND = "/base/gestisci_libretto_scheda4_5/" + CP_NAME;

	/**
	 * classe model associata al ContentPanel
	 */
	public Class modelClass() {
		return it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda4_5.CpGestLibScheda4_5DettModel.class;
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
	 * Gestione dell'evento CLICKED sul widget [menuLibretto]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleMenuLibretto_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_libretto_scheda4_5", "cpgestlibscheda4_5dett", "menuLibretto", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [bSostituisciComponente]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBSostituisciComponente_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_libretto_scheda4_5", "cpgestlibscheda4_5dett", "bSostituisciComponente",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [bDismettiComponente]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBDismettiComponente_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_libretto_scheda4_5", "cpgestlibscheda4_5dett", "bDismettiComponente",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [bRiattivaComponente]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBRiattivaComponente_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_libretto_scheda4_5", "cpgestlibscheda4_5dett", "bRiattivaComponente",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [tbSostituzioni]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleTbSostituzioni_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_libretto_scheda4_5", "cpgestlibscheda4_5dett", "tbSostituzioni",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btRipristinaAttualeDett]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtRipristinaAttualeDett_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_libretto_scheda4_5", "cpgestlibscheda4_5dett", "btRipristinaAttualeDett",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btSalvaDett]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtSalvaDett_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_libretto_scheda4_5", "cpgestlibscheda4_5dett", "btSalvaDett", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btIndietroDett]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtIndietroDett_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_libretto_scheda4_5", "cpgestlibscheda4_5dett", "btIndietroDett",
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
	 * al data-binding relativo al dataset DATASET del widget cbFabbricante.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbFabbricante_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoFabbricante", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget tbSostituzioni.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideTbSostituzioni_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDatalistaStoricoComponentiSC", "", false, false);
	}

	/**
	 * Gestione della validazione
	 */
	public void validate() {
		/*PROTECTED REGION ID(R1674511191) ENABLED START*/
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
		String[] appDataToClear = new String[]{"editabilitaByRee", "editabilitaByRee_bckp"

		};

		ClearAppDataCommand clearCmd = new ClearAppDataCommand(appDataToClear);
		session.put(PENDING_CLEAR_COMMAND_ATTRIBUTE, clearCmd);

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
