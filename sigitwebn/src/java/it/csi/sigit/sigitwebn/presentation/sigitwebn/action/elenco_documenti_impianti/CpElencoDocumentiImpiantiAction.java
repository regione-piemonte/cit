package it.csi.sigit.sigitwebn.presentation.sigitwebn.action.elenco_documenti_impianti;

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
import it.csi.sigit.sigitwebn.dto.elenco_documenti_impianti.CpElencoDocumentiImpiantiModel;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.command.*;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.security.*;

import it.csi.sigit.sigitwebn.business.*;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.action.*;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.action.elenco_documenti_impianti.states.CpElencoDocumentiImpiantiScreenStates;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.interceptor.MethodProtection;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.interceptor.FatClientOnly;
import it.csi.sigit.sigitwebn.presentation.uiutils.*;
import flexjson.JSON;

/**
 * CpElencoDocumentiImpiantiAction Action Class.
 *
 * @author GuiGen
 */
@Validation()
@Conversion()
public class CpElencoDocumentiImpiantiAction extends AbstractCPAction<CpElencoDocumentiImpiantiModel>
		implements
			Preparable,
			ModelDriven<CpElencoDocumentiImpiantiModel> {

	/**
	 * Il modello del content panel.
	 * Viene riempito a fornte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	private CpElencoDocumentiImpiantiModel model;

	/**
	 * Il modello del content panel.
	 * Viene riempito a fornte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	public CpElencoDocumentiImpiantiModel getModel() {
		return model;
	}

	/**
	 * Il modello del content panel.
	 * Viene riempito a fronte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	@VisitorFieldValidator(message = "", appendPrefix = false)
	public void setModel(CpElencoDocumentiImpiantiModel modello) {
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
			model = new CpElencoDocumentiImpiantiModel();
		}
		// associo la sessione applicativa al modello, in modo che
		// possa implementare l'accesso agli application data
		// di scope session/same page
		model.setSession(session);
	}

	/**
	 * nome del content panel
	 */
	private static final String CP_NAME = "cpElencoDocumentiImpianti";

	/**
	 * nome del namespace che contiene il content panel
	 */
	private static final String CP_NAMESPACE = "elenco_documenti_impianti";

	/**
	 * nome completo del namespace che contiene il content panel
	 */
	private static final String CP_FULL_NAMESPACE = "/base/elenco_documenti_impianti";

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

	private static final String URL_BACK_COMMAND = "/base/elenco_documenti_impianti/" + CP_NAME;

	/**
	 * classe model associata al ContentPanel
	 */
	public Class modelClass() {
		return it.csi.sigit.sigitwebn.dto.elenco_documenti_impianti.CpElencoDocumentiImpiantiModel.class;
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
	 * Gestione dell'evento CLICKED sul widget [btnVisualizzaDoc]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnVisualizzaDoc_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_documenti_impianti", "cpelencodocumentiimpianti", "btnVisualizzaDoc",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnInserisciDocumento]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnInserisciDocumento_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_documenti_impianti", "cpelencodocumentiimpianti", "btnInserisciDocumento",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnEliminaDocumento]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnEliminaDocumento_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_documenti_impianti", "cpelencodocumentiimpianti", "btnEliminaDocumento",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento VALUE_CHANGED sul widget [cbTipoDoc]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleCbTipoDoc_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("elenco_documenti_impianti", "cpelencodocumentiimpianti", "cbTipoDoc",
				"VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnChiudiDatiDocumento]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnChiudiDatiDocumento_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_documenti_impianti", "cpelencodocumentiimpianti", "btnChiudiDatiDocumento",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnCaricaDocumento]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnCaricaDocumento_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_documenti_impianti", "cpelencodocumentiimpianti", "btnCaricaDocumento",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btLibretto]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtLibretto_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_documenti_impianti", "cpelencodocumentiimpianti", "btLibretto", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnDettaglioAllegatoPerImpianto]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnDettaglioAllegatoPerImpianto_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_documenti_impianti", "cpelencodocumentiimpianti",
				"btnDettaglioAllegatoPerImpianto", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnIndietroElencoAllegatiImpianti]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnIndietroElencoAllegatiImpianti_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_documenti_impianti", "cpelencodocumentiimpianti",
				"btnIndietroElencoAllegatiImpianti", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btConfermaElim]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtConfermaElim_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_documenti_impianti", "cpelencodocumentiimpianti", "btConfermaElim",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btAnnullaElim]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtAnnullaElim_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_documenti_impianti", "cpelencodocumentiimpianti", "btAnnullaElim",
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
	 * al data-binding relativo al dataset DATASET del widget tblElencoDocumenti.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideTblElencoDocumenti_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoDocumenti", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbTipoDoc.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbTipoDoc_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoTipiDocumentazione", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget tbArchivioElencoLibrettiConsolidatiStorico.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideTbArchivioElencoLibrettiConsolidatiStorico_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDatalistaLibretti", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget tblStoricoREE.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideTblStoricoREE_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoAllegatiPerImpianto", "", false, false);
	}

	/**
	 * Gestione della validazione
	 */
	public void validate() {
		/*PROTECTED REGION ID(R548511867) ENABLED START*/
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
