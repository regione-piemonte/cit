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
import it.csi.sigit.sigitwebn.dto.gestisci_sanzioni.CpDettaglioSanzioneModel;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.command.*;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.security.*;

import it.csi.sigit.sigitwebn.business.*;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.action.*;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.action.gestisci_sanzioni.states.CpDettaglioSanzioneScreenStates;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.interceptor.MethodProtection;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.interceptor.FatClientOnly;
import it.csi.sigit.sigitwebn.presentation.uiutils.*;
import flexjson.JSON;

/**
 * CpDettaglioSanzioneAction Action Class.
 *
 * @author GuiGen
 */
@Validation()
@Conversion()
public class CpDettaglioSanzioneAction extends AbstractCPAction<CpDettaglioSanzioneModel>
		implements
			Preparable,
			ModelDriven<CpDettaglioSanzioneModel> {

	/**
	 * Il modello del content panel.
	 * Viene riempito a fornte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	private CpDettaglioSanzioneModel model;

	/**
	 * Il modello del content panel.
	 * Viene riempito a fornte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	public CpDettaglioSanzioneModel getModel() {
		return model;
	}

	/**
	 * Il modello del content panel.
	 * Viene riempito a fronte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	@VisitorFieldValidator(message = "", appendPrefix = false)
	public void setModel(CpDettaglioSanzioneModel modello) {
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
			model = new CpDettaglioSanzioneModel();
		}
		// associo la sessione applicativa al modello, in modo che
		// possa implementare l'accesso agli application data
		// di scope session/same page
		model.setSession(session);
	}

	/**
	 * nome del content panel
	 */
	private static final String CP_NAME = "cpDettaglioSanzione";

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
		return it.csi.sigit.sigitwebn.dto.gestisci_sanzioni.CpDettaglioSanzioneModel.class;
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
	 * Gestione dell'evento CLICKED sul widget [btnSalva]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnSalva_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_sanzioni", "cpdettagliosanzione", "btnSalva", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [tbAzioniSvolte]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleTbAzioniSvolte_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_sanzioni", "cpdettagliosanzione", "tbAzioniSvolte", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnInsAzione]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnInsAzione_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_sanzioni", "cpdettagliosanzione", "btnInsAzione", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnGestisciSveglia]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnGestisciSveglia_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_sanzioni", "cpdettagliosanzione", "btnGestisciSveglia", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btVisualizzaAccertamento]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtVisualizzaAccertamento_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_sanzioni", "cpdettagliosanzione", "btVisualizzaAccertamento", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btVisualizzaIspezione]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtVisualizzaIspezione_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_sanzioni", "cpdettagliosanzione", "btVisualizzaIspezione", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btNotificaSanzione]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtNotificaSanzione_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_sanzioni", "cpdettagliosanzione", "btNotificaSanzione", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btPagaSanzione]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtPagaSanzione_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_sanzioni", "cpdettagliosanzione", "btPagaSanzione", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btAnnullaSanzione]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtAnnullaSanzione_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_sanzioni", "cpdettagliosanzione", "btAnnullaSanzione", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btAssegnaSanzione]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtAssegnaSanzione_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_sanzioni", "cpdettagliosanzione", "btAssegnaSanzione", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnConfermaPagamento]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnConfermaPagamento_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_sanzioni", "cpdettagliosanzione", "btnConfermaPagamento", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnAnnullaPagamento]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnAnnullaPagamento_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_sanzioni", "cpdettagliosanzione", "btnAnnullaPagamento", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnConfermaAssegnazione]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnConfermaAssegnazione_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_sanzioni", "cpdettagliosanzione", "btnConfermaAssegnazione", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnAnnullaAssegnazione]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnAnnullaAssegnazione_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_sanzioni", "cpdettagliosanzione", "btnAnnullaAssegnazione", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btConferma]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtConferma_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_sanzioni", "cpdettagliosanzione", "btConferma", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btAnnulla]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtAnnulla_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_sanzioni", "cpdettagliosanzione", "btAnnulla", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnIndietroDettaglioSanzione]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnIndietroDettaglioSanzione_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_sanzioni", "cpdettagliosanzione", "btnIndietroDettaglioSanzione",
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
	 * al data-binding relativo al dataset DATASET del widget tbAzioniSvolte.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideTbAzioniSvolte_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoAzioni", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbComboValidatori.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbComboValidatori_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoValidatori", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbComboIspettori.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbComboIspettori_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoIspettori", "", false, false);
	}

	/**
	 * Gestione della validazione
	 */
	public void validate() {
		/*PROTECTED REGION ID(R-1053999958) ENABLED START*/
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
