package it.csi.sigit.sigitwebn.presentation.sigitwebn.action.gestisci_libretto_scheda10_1;

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
import it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda10_1.CpGestLibScheda10_1DettModel;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.command.*;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.security.*;

import it.csi.sigit.sigitwebn.business.*;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.action.*;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.action.gestisci_libretto_scheda10_1.states.CpGestLibScheda10_1DettScreenStates;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.interceptor.MethodProtection;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.interceptor.FatClientOnly;
import it.csi.sigit.sigitwebn.presentation.uiutils.*;
import flexjson.JSON;

/**
 * CpGestLibScheda10_1DettAction Action Class.
 *
 * @author GuiGen
 */
@Validation()
@Conversion()
public class CpGestLibScheda10_1DettAction extends AbstractCPAction<CpGestLibScheda10_1DettModel>
		implements
			Preparable,
			ModelDriven<CpGestLibScheda10_1DettModel> {

	/**
	 * Il modello del content panel.
	 * Viene riempito a fornte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	private CpGestLibScheda10_1DettModel model;

	/**
	 * Il modello del content panel.
	 * Viene riempito a fornte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	public CpGestLibScheda10_1DettModel getModel() {
		return model;
	}

	/**
	 * Il modello del content panel.
	 * Viene riempito a fronte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	@VisitorFieldValidator(message = "", appendPrefix = false)
	public void setModel(CpGestLibScheda10_1DettModel modello) {
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
			model = new CpGestLibScheda10_1DettModel();
		}
		// associo la sessione applicativa al modello, in modo che
		// possa implementare l'accesso agli application data
		// di scope session/same page
		model.setSession(session);
	}

	/**
	 * nome del content panel
	 */
	private static final String CP_NAME = "cpGestLibScheda10_1Dett";

	/**
	 * nome del namespace che contiene il content panel
	 */
	private static final String CP_NAMESPACE = "gestisci_libretto_scheda10_1";

	/**
	 * nome completo del namespace che contiene il content panel
	 */
	private static final String CP_FULL_NAMESPACE = "/base/gestisci_libretto_scheda10_1";

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

	private static final String URL_BACK_COMMAND = "/base/gestisci_libretto_scheda10_1/" + CP_NAME;

	/**
	 * classe model associata al ContentPanel
	 */
	public Class modelClass() {
		return it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda10_1.CpGestLibScheda10_1DettModel.class;
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

		return handleEventInternal("gestisci_libretto_scheda10_1", "cpgestlibscheda10_1dett", "menuLibretto",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btSostComp]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtSostComp_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_libretto_scheda10_1", "cpgestlibscheda10_1dett", "btSostComp", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btDismettiComp]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtDismettiComp_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_libretto_scheda10_1", "cpgestlibscheda10_1dett", "btDismettiComp",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btRiattivaComp]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtRiattivaComp_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_libretto_scheda10_1", "cpgestlibscheda10_1dett", "btRiattivaComp",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [tbComponenti]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleTbComponenti_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_libretto_scheda10_1", "cpgestlibscheda10_1dett", "tbComponenti",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btRipristina]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtRipristina_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_libretto_scheda10_1", "cpgestlibscheda10_1dett", "btRipristina",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btSalva]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtSalva_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_libretto_scheda10_1", "cpgestlibscheda10_1dett", "btSalva", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnIndietro]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnIndietro_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_libretto_scheda10_1", "cpgestlibscheda10_1dett", "btnIndietro", "CLICKED");

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
	 * al data-binding relativo al dataset DATASET del widget cbTipologia.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbTipologia_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoTipoDettaglioVm", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget tbComponenti.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideTbComponenti_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDatalistaComponentiVM", "", false, false);
	}

	/**
	 * Gestione della validazione
	 */
	public void validate() {
		/*PROTECTED REGION ID(R1211141098) ENABLED START*/
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
