package it.csi.sigit.sigitwebn.presentation.sigitwebn.action.gestisci_sanzioni;

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
import it.csi.sigit.sigitwebn.dto.gestisci_sanzioni.CpInserisciNotificaSanzioneModel;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.command.*;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.security.*;

import it.csi.sigit.sigitwebn.business.*;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.action.*;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.action.gestisci_sanzioni.states.CpInserisciNotificaSanzioneScreenStates;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.interceptor.MethodProtection;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.interceptor.FatClientOnly;
import it.csi.sigit.sigitwebn.presentation.uiutils.*;
import flexjson.JSON;

/**
 * CpInserisciNotificaSanzioneAction Action Class.
 *
 * @author GuiGen
 */
@Validation()
@Conversion()
public class CpInserisciNotificaSanzioneAction extends AbstractCPAction<CpInserisciNotificaSanzioneModel>
		implements
			Preparable,
			ModelDriven<CpInserisciNotificaSanzioneModel> {

	/**
	 * Il modello del content panel.
	 * Viene riempito a fornte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	private CpInserisciNotificaSanzioneModel model;

	/**
	 * Il modello del content panel.
	 * Viene riempito a fornte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	public CpInserisciNotificaSanzioneModel getModel() {
		return model;
	}

	/**
	 * Il modello del content panel.
	 * Viene riempito a fronte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	@VisitorFieldValidator(message = "", appendPrefix = false)
	public void setModel(CpInserisciNotificaSanzioneModel modello) {
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
			model = new CpInserisciNotificaSanzioneModel();
		}
		// associo la sessione applicativa al modello, in modo che
		// possa implementare l'accesso agli application data
		// di scope session/same page
		model.setSession(session);
	}

	/**
	 * nome del content panel
	 */
	private static final String CP_NAME = "cpInserisciNotificaSanzione";

	/**
	 * nome del namespace che contiene il content panel
	 */
	private static final String CP_NAMESPACE = "gestisci_sanzioni";

	/**
	 * nome completo del namespace che contiene il content panel
	 */
	private static final String CP_FULL_NAMESPACE = "/base/gestisci_sanzioni";

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

	private static final String URL_BACK_COMMAND = "/base/gestisci_sanzioni/" + CP_NAME;

	/**
	 * classe model associata al ContentPanel
	 */
	public Class modelClass() {
		return it.csi.sigit.sigitwebn.dto.gestisci_sanzioni.CpInserisciNotificaSanzioneModel.class;
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
	 * Gestione dell'evento VALUE_CHANGED sul widget [rbRespIsImpresa]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleRbRespIsImpresa_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("gestisci_sanzioni", "cpinseriscinotificasanzione", "rbRespIsImpresa",
				"VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btCercaCodiceFiscale]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtCercaCodiceFiscale_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_sanzioni", "cpinseriscinotificasanzione", "btCercaCodiceFiscale",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btNuovaRicerca]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtNuovaRicerca_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_sanzioni", "cpinseriscinotificasanzione", "btNuovaRicerca", "CLICKED");

	}

	/**
	 * Gestione dell'evento VALUE_CHANGED sul widget [cbRespIndirizzoEst]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleCbRespIndirizzoEst_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("gestisci_sanzioni", "cpinseriscinotificasanzione", "cbRespIndirizzoEst",
				"VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento VALUE_CHANGED sul widget [cbProvincia]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleCbProvincia_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("gestisci_sanzioni", "cpinseriscinotificasanzione", "cbProvincia", "VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnCercaIndirizzo]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnCercaIndirizzo_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_sanzioni", "cpinseriscinotificasanzione", "btnCercaIndirizzo", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnNuovaRicercaIndirizzo]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnNuovaRicercaIndirizzo_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_sanzioni", "cpinseriscinotificasanzione", "btnNuovaRicercaIndirizzo",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnAnnullaSceltaSanzionato]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnAnnullaSceltaSanzionato_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_sanzioni", "cpinseriscinotificasanzione", "btnAnnullaSceltaSanzionato",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnSelezionaSanzionato]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnSelezionaSanzionato_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_sanzioni", "cpinseriscinotificasanzione", "btnSelezionaSanzionato",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btSalvaSanzione]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtSalvaSanzione_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_sanzioni", "cpinseriscinotificasanzione", "btSalvaSanzione", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btIndietro]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtIndietro_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_sanzioni", "cpinseriscinotificasanzione", "btIndietro", "CLICKED");

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
	 * al data-binding relativo al dataset DATASET del widget cbProvincia.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbProvincia_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoProvince", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbComune.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbComune_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoComuni", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbIndirizzo.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbIndirizzo_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoIndirizziSanzionato", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget tbElencoSanzionabili.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideTbElencoSanzionabili_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoCandidatiSanzionati", "", false, false);
	}

	/**
	 * Gestione della validazione
	 */
	public void validate() {
		/*PROTECTED REGION ID(R473243443) ENABLED START*/
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
