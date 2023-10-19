package it.csi.sigit.sigitwebn.presentation.sigitwebn.action.gestisci_distributori;

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
import it.csi.sigit.sigitwebn.dto.gestisci_distributori.CpGestDistributoriModel;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.command.*;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.security.*;

import it.csi.sigit.sigitwebn.business.*;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.action.*;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.action.gestisci_distributori.states.CpGestDistributoriScreenStates;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.interceptor.MethodProtection;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.interceptor.FatClientOnly;
import it.csi.sigit.sigitwebn.presentation.uiutils.*;
import flexjson.JSON;

/**
 * CpGestDistributoriAction Action Class.
 *
 * @author GuiGen
 */
@Validation()
@Conversion()
public class CpGestDistributoriAction extends AbstractCPAction<CpGestDistributoriModel>
		implements
			Preparable,
			ModelDriven<CpGestDistributoriModel> {

	/**
	 * Il modello del content panel.
	 * Viene riempito a fornte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	private CpGestDistributoriModel model;

	/**
	 * Il modello del content panel.
	 * Viene riempito a fornte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	public CpGestDistributoriModel getModel() {
		return model;
	}

	/**
	 * Il modello del content panel.
	 * Viene riempito a fronte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	@VisitorFieldValidator(message = "", appendPrefix = false)
	public void setModel(CpGestDistributoriModel modello) {
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
			model = new CpGestDistributoriModel();
		}
		// associo la sessione applicativa al modello, in modo che
		// possa implementare l'accesso agli application data
		// di scope session/same page
		model.setSession(session);
	}

	/**
	 * nome del content panel
	 */
	private static final String CP_NAME = "cpGestDistributori";

	/**
	 * nome del namespace che contiene il content panel
	 */
	private static final String CP_NAMESPACE = "gestisci_distributori";

	/**
	 * nome completo del namespace che contiene il content panel
	 */
	private static final String CP_FULL_NAMESPACE = "/base/gestisci_distributori";

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

	private static final String URL_BACK_COMMAND = "/base/gestisci_distributori/" + CP_NAME;

	/**
	 * classe model associata al ContentPanel
	 */
	public Class modelClass() {
		return it.csi.sigit.sigitwebn.dto.gestisci_distributori.CpGestDistributoriModel.class;
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

		return handleEventInternal("gestisci_distributori", "cpgestdistributori", "btnImpCercaCF", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnImpNuovaRicercaCF]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnImpNuovaRicercaCF_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_distributori", "cpgestdistributori", "btnImpNuovaRicercaCF", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnImporta]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnImporta_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_distributori", "cpgestdistributori", "btnImporta", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnSostituisci]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnSostituisci_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_distributori", "cpgestdistributori", "btnSostituisci", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnDettaglio]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnDettaglio_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_distributori", "cpgestdistributori", "btnDettaglio", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnAnnulla]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnAnnulla_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_distributori", "cpgestdistributori", "btnAnnulla", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnRicevuta]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnRicevuta_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_distributori", "cpgestdistributori", "btnRicevuta", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnInserimento]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnInserimento_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_distributori", "cpgestdistributori", "btnInserimento", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnDettCaricaManuale]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnDettCaricaManuale_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_distributori", "cpgestdistributori", "btnDettCaricaManuale", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnAvviaImport]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnAvviaImport_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_distributori", "cpgestdistributori", "btnAvviaImport", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnChiudiImport]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnChiudiImport_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_distributori", "cpgestdistributori", "btnChiudiImport", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnChiudiErrori]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnChiudiErrori_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_distributori", "cpgestdistributori", "btnChiudiErrori", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnDistrIndietro]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnDistrIndietro_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_distributori", "cpgestdistributori", "btnDistrIndietro", "CLICKED");

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
	 * al data-binding relativo al dataset DATASET del widget tbDatiInviati.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideTbDatiInviati_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoImportDistributori", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget tbElencoErrori.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideTbElencoErrori_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoErroriImport", "", false, false);
	}

	/**
	 * Gestione della validazione
	 */
	public void validate() {
		/*PROTECTED REGION ID(R812602801) ENABLED START*/
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
