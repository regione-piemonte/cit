package it.csi.sigit.sigitwebn.presentation.sigitwebn.action.gestisci_libretto_scheda3;

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
import it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda3.CpGestLibScheda3Model;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.command.*;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.security.*;

import it.csi.sigit.sigitwebn.business.*;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.action.*;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.action.gestisci_libretto_scheda3.states.CpGestLibScheda3ScreenStates;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.interceptor.MethodProtection;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.interceptor.FatClientOnly;
import it.csi.sigit.sigitwebn.presentation.uiutils.*;
import flexjson.JSON;

/**
 * CpGestLibScheda3Action Action Class.
 *
 * @author GuiGen
 */
@Validation()
@Conversion()
public class CpGestLibScheda3Action extends AbstractCPAction<CpGestLibScheda3Model>
		implements
			Preparable,
			ModelDriven<CpGestLibScheda3Model> {

	/**
	 * Il modello del content panel.
	 * Viene riempito a fornte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	private CpGestLibScheda3Model model;

	/**
	 * Il modello del content panel.
	 * Viene riempito a fornte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	public CpGestLibScheda3Model getModel() {
		return model;
	}

	/**
	 * Il modello del content panel.
	 * Viene riempito a fronte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	@VisitorFieldValidator(message = "", appendPrefix = false)
	public void setModel(CpGestLibScheda3Model modello) {
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
			model = new CpGestLibScheda3Model();
		}
		// associo la sessione applicativa al modello, in modo che
		// possa implementare l'accesso agli application data
		// di scope session/same page
		model.setSession(session);
	}

	/**
	 * nome del content panel
	 */
	private static final String CP_NAME = "cpGestLibScheda3";

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
		return it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda3.CpGestLibScheda3Model.class;
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

		return handleEventInternal("gestisci_libretto_scheda3", "cpgestlibscheda3", "menuLibretto", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnVisRev3Resp]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnVisRev3Resp_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_libretto_scheda3", "cpgestlibscheda3", "btnVisRev3Resp", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnDettRev3Resp]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnDettRev3Resp_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_libretto_scheda3", "cpgestlibscheda3", "btnDettRev3Resp", "CLICKED");

	}

	/**
	 * Gestione dell'evento VALUE_CHANGED sul widget [cbTipiCessazione]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleCbTipiCessazione_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("gestisci_libretto_scheda3", "cpgestlibscheda3", "cbTipiCessazione",
				"VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btConfermaRevoca]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtConfermaRevoca_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_libretto_scheda3", "cpgestlibscheda3", "btConfermaRevoca", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btIndietroConfermaCessazione]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtIndietroConfermaCessazione_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_libretto_scheda3", "cpgestlibscheda3", "btIndietroConfermaCessazione",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnIndietroRoot]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnIndietroRoot_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_libretto_scheda3", "cpgestlibscheda3", "btnIndietroRoot", "CLICKED");

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
	 * al data-binding relativo al dataset DATASET del widget tbRespImpianto3Resp.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideTbRespImpianto3Resp_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoDettaglioTerzoResponsabile", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbTipiCessazione.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbTipiCessazione_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoTipiCessazione", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget tbAutodichiarazioni.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideTbAutodichiarazioni_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoAutodichiarazioni", "", false, false);
	}

	/**
	 * Gestione della validazione
	 */
	public void validate() {
		/*PROTECTED REGION ID(R1945303343) ENABLED START*/
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
