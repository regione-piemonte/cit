package it.csi.sigit.sigitwebn.presentation.sigitwebn.action.risultato_ricerca_allegati_module;

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
import it.csi.sigit.sigitwebn.dto.risultato_ricerca_allegati_module.CpRisultatoRicercaAllegatiModel;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.command.*;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.security.*;

import it.csi.sigit.sigitwebn.business.*;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.action.*;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.action.risultato_ricerca_allegati_module.states.CpRisultatoRicercaAllegatiScreenStates;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.interceptor.MethodProtection;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.interceptor.FatClientOnly;
import it.csi.sigit.sigitwebn.presentation.uiutils.*;
import flexjson.JSON;

/**
 * CpRisultatoRicercaAllegatiAction Action Class.
 *
 * @author GuiGen
 */
@Validation()
@Conversion()
public class CpRisultatoRicercaAllegatiAction extends AbstractCPAction<CpRisultatoRicercaAllegatiModel>
		implements
			Preparable,
			ModelDriven<CpRisultatoRicercaAllegatiModel> {

	/**
	 * Il modello del content panel.
	 * Viene riempito a fornte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	private CpRisultatoRicercaAllegatiModel model;

	/**
	 * Il modello del content panel.
	 * Viene riempito a fornte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	public CpRisultatoRicercaAllegatiModel getModel() {
		return model;
	}

	/**
	 * Il modello del content panel.
	 * Viene riempito a fronte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	@VisitorFieldValidator(message = "", appendPrefix = false)
	public void setModel(CpRisultatoRicercaAllegatiModel modello) {
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
			model = new CpRisultatoRicercaAllegatiModel();
		}
		// associo la sessione applicativa al modello, in modo che
		// possa implementare l'accesso agli application data
		// di scope session/same page
		model.setSession(session);
	}

	/**
	 * nome del content panel
	 */
	private static final String CP_NAME = "cpRisultatoRicercaAllegati";

	/**
	 * nome del namespace che contiene il content panel
	 */
	private static final String CP_NAMESPACE = "risultato_ricerca_allegati_module";

	/**
	 * nome completo del namespace che contiene il content panel
	 */
	private static final String CP_FULL_NAMESPACE = "/base/risultato_ricerca_allegati_module";

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

	private static final String URL_BACK_COMMAND = "/base/risultato_ricerca_allegati_module/" + CP_NAME;

	/**
	 * classe model associata al ContentPanel
	 */
	public Class modelClass() {
		return it.csi.sigit.sigitwebn.dto.risultato_ricerca_allegati_module.CpRisultatoRicercaAllegatiModel.class;
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
	 * Gestione dell'evento CLICKED sul widget [btExportExcel]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtExportExcel_CLICKED() throws CommandExecutionException {

		return handleEventInternal("risultato_ricerca_allegati_module", "cprisultatoricercaallegati", "btExportExcel",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnModificaAllegato]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnModificaAllegato_CLICKED() throws CommandExecutionException {

		return handleEventInternal("risultato_ricerca_allegati_module", "cprisultatoricercaallegati",
				"btnModificaAllegato", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnDettaglioAllegato]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnDettaglioAllegato_CLICKED() throws CommandExecutionException {

		return handleEventInternal("risultato_ricerca_allegati_module", "cprisultatoricercaallegati",
				"btnDettaglioAllegato", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnInviaAllegato]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnInviaAllegato_CLICKED() throws CommandExecutionException {

		return handleEventInternal("risultato_ricerca_allegati_module", "cprisultatoricercaallegati",
				"btnInviaAllegato", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnRespingiAllegato]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnRespingiAllegato_CLICKED() throws CommandExecutionException {

		return handleEventInternal("risultato_ricerca_allegati_module", "cprisultatoricercaallegati",
				"btnRespingiAllegato", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnEliminaAllegato]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnEliminaAllegato_CLICKED() throws CommandExecutionException {

		return handleEventInternal("risultato_ricerca_allegati_module", "cprisultatoricercaallegati",
				"btnEliminaAllegato", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [bntnRicevuta]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBntnRicevuta_CLICKED() throws CommandExecutionException {

		return handleEventInternal("risultato_ricerca_allegati_module", "cprisultatoricercaallegati", "bntnRicevuta",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnDocumentazione]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnDocumentazione_CLICKED() throws CommandExecutionException {

		return handleEventInternal("risultato_ricerca_allegati_module", "cprisultatoricercaallegati",
				"btnDocumentazione", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnIndietro]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnIndietro_CLICKED() throws CommandExecutionException {

		return handleEventInternal("risultato_ricerca_allegati_module", "cprisultatoricercaallegati", "btnIndietro",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btConfermaElim]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtConfermaElim_CLICKED() throws CommandExecutionException {

		return handleEventInternal("risultato_ricerca_allegati_module", "cprisultatoricercaallegati", "btConfermaElim",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btAnnullaElim]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtAnnullaElim_CLICKED() throws CommandExecutionException {

		return handleEventInternal("risultato_ricerca_allegati_module", "cprisultatoricercaallegati", "btAnnullaElim",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnConfermaInvio]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnConfermaInvio_CLICKED() throws CommandExecutionException {

		return handleEventInternal("risultato_ricerca_allegati_module", "cprisultatoricercaallegati",
				"btnConfermaInvio", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnAnnullaInvio]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnAnnullaInvio_CLICKED() throws CommandExecutionException {

		return handleEventInternal("risultato_ricerca_allegati_module", "cprisultatoricercaallegati", "btnAnnullaInvio",
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
	 * al data-binding relativo al dataset DATASET del widget tbRisRicercaAllegati.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideTbRisRicercaAllegati_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoAllegati", "", false, false);
	}

	/**
	 * Gestione della validazione
	 */
	public void validate() {
		/*PROTECTED REGION ID(R1089550947) ENABLED START*/
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
