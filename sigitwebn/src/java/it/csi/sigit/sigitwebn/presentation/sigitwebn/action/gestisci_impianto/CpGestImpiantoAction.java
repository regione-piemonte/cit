package it.csi.sigit.sigitwebn.presentation.sigitwebn.action.gestisci_impianto;

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
import it.csi.sigit.sigitwebn.dto.gestisci_impianto.CpGestImpiantoModel;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.command.*;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.security.*;

import it.csi.sigit.sigitwebn.business.*;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.action.*;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.action.gestisci_impianto.states.CpGestImpiantoScreenStates;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.interceptor.MethodProtection;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.interceptor.FatClientOnly;
import it.csi.sigit.sigitwebn.presentation.uiutils.*;
import flexjson.JSON;

/**
 * CpGestImpiantoAction Action Class.
 *
 * @author GuiGen
 */
@Validation()
@Conversion()
public class CpGestImpiantoAction extends AbstractCPAction<CpGestImpiantoModel>
		implements
			Preparable,
			ModelDriven<CpGestImpiantoModel> {

	/**
	 * Il modello del content panel.
	 * Viene riempito a fornte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	private CpGestImpiantoModel model;

	/**
	 * Il modello del content panel.
	 * Viene riempito a fornte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	public CpGestImpiantoModel getModel() {
		return model;
	}

	/**
	 * Il modello del content panel.
	 * Viene riempito a fronte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	@VisitorFieldValidator(message = "", appendPrefix = false)
	public void setModel(CpGestImpiantoModel modello) {
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
			model = new CpGestImpiantoModel();
		}
		// associo la sessione applicativa al modello, in modo che
		// possa implementare l'accesso agli application data
		// di scope session/same page
		model.setSession(session);
	}

	/**
	 * nome del content panel
	 */
	private static final String CP_NAME = "cpGestImpianto";

	/**
	 * nome del namespace che contiene il content panel
	 */
	private static final String CP_NAMESPACE = "gestisci_impianto";

	/**
	 * nome completo del namespace che contiene il content panel
	 */
	private static final String CP_FULL_NAMESPACE = "/base/gestisci_impianto";

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

	private static final String URL_BACK_COMMAND = "/base/gestisci_impianto/" + CP_NAME;

	/**
	 * classe model associata al ContentPanel
	 */
	public Class modelClass() {
		return it.csi.sigit.sigitwebn.dto.gestisci_impianto.CpGestImpiantoModel.class;
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

		if (AbstractCPAction.IMPLICIT_EVENT_ON_ENTER.equals(implicitEventName)) //NOSONAR
			return true; //NOSONAR

		if (AbstractCPAction.IMPLICIT_EVENT_AFTER_EVENTS.equals(implicitEventName)) //NOSONAR
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
	 * Gestione dell'evento CLICKED sul widget [btnInstCercaCF]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnInstCercaCF_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_impianto", "cpgestimpianto", "btnInstCercaCF", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnInstNuovaRicercaCF]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnInstNuovaRicercaCF_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_impianto", "cpgestimpianto", "btnInstNuovaRicercaCF", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnApprofondisciImpianto]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnApprofondisciImpianto_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_impianto", "cpgestimpianto", "btnApprofondisciImpianto", "CLICKED");

	}

	/**
	 * Gestione dell'evento VALUE_CHANGED sul widget [cbImpStatoImp]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleCbImpStatoImp_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("gestisci_impianto", "cpgestimpianto", "cbImpStatoImp", "VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento VALUE_CHANGED sul widget [cbImpLocProvincia]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleCbImpLocProvincia_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("gestisci_impianto", "cpgestimpianto", "cbImpLocProvincia", "VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnImpLocCercaIndirizzo]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnImpLocCercaIndirizzo_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_impianto", "cpgestimpianto", "btnImpLocCercaIndirizzo", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnImpLocNuovaRicercaIndirizzo]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnImpLocNuovaRicercaIndirizzo_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_impianto", "cpgestimpianto", "btnImpLocNuovaRicercaIndirizzo", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnImpiantoSalva]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnImpiantoSalva_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_impianto", "cpgestimpianto", "btnImpiantoSalva", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnConfermaProp]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnConfermaProp_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_impianto", "cpgestimpianto", "btnConfermaProp", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnModificaProp]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnModificaProp_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_impianto", "cpgestimpianto", "btnModificaProp", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnCessaProp]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnCessaProp_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_impianto", "cpgestimpianto", "btnCessaProp", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnRespInserisci]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnRespInserisci_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_impianto", "cpgestimpianto", "btnRespInserisci", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnRespModifica]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnRespModifica_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_impianto", "cpgestimpianto", "btnRespModifica", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btAvviaImport]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtAvviaImport_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_impianto", "cpgestimpianto", "btAvviaImport", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnLibVisualizza]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnLibVisualizza_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_impianto", "cpgestimpianto", "btnLibVisualizza", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnLibRappControllo]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnLibRappControllo_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_impianto", "cpgestimpianto", "btnLibRappControllo", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnLibDocumentazione]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnLibDocumentazione_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_impianto", "cpgestimpianto", "btnLibDocumentazione", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnVisLibrettoWeb]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnVisLibrettoWeb_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_impianto", "cpgestimpianto", "btnVisLibrettoWeb", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnLibAggiornamenti]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnLibAggiornamenti_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_impianto", "cpgestimpianto", "btnLibAggiornamenti", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnImpIndietro]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnImpIndietro_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_impianto", "cpgestimpianto", "btnImpIndietro", "CLICKED");

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
	 * al data-binding relativo al dataset DATASET del widget cbInstSiglaRea.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbInstSiglaRea_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoSiglaRea", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget tbManutentori.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideTbManutentori_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoManutentori", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbImpStatoImp.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbImpStatoImp_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoStatoImpianto", "", false, false);
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

		return provideDataInternal("appDataelencoIndirizzi", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget tbResponsabili.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideTbResponsabili_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoResponsabili", "", false, false);
	}

	/**
	 * Gestione della validazione
	 */
	public void validate() {
		/*PROTECTED REGION ID(R-1393464402) ENABLED START*/
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
