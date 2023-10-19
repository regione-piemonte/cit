package it.csi.sigit.sigitwebn.presentation.sigitwebn.action.elenco_allegati_impianti;

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
import it.csi.sigit.sigitwebn.dto.elenco_allegati_impianti.CpElencoAllegatiImpiantiModel;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.command.*;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.security.*;

import it.csi.sigit.sigitwebn.business.*;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.action.*;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.action.elenco_allegati_impianti.states.CpElencoAllegatiImpiantiScreenStates;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.interceptor.MethodProtection;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.interceptor.FatClientOnly;
import it.csi.sigit.sigitwebn.presentation.uiutils.*;
import flexjson.JSON;

/**
 * CpElencoAllegatiImpiantiAction Action Class.
 *
 * @author GuiGen
 */
@Validation()
@Conversion()
public class CpElencoAllegatiImpiantiAction extends AbstractCPAction<CpElencoAllegatiImpiantiModel>
		implements
			Preparable,
			ModelDriven<CpElencoAllegatiImpiantiModel> {

	/**
	 * Il modello del content panel.
	 * Viene riempito a fornte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	private CpElencoAllegatiImpiantiModel model;

	/**
	 * Il modello del content panel.
	 * Viene riempito a fornte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	public CpElencoAllegatiImpiantiModel getModel() {
		return model;
	}

	/**
	 * Il modello del content panel.
	 * Viene riempito a fronte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	@VisitorFieldValidator(message = "", appendPrefix = false)
	public void setModel(CpElencoAllegatiImpiantiModel modello) {
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
			model = new CpElencoAllegatiImpiantiModel();
		}
		// associo la sessione applicativa al modello, in modo che
		// possa implementare l'accesso agli application data
		// di scope session/same page
		model.setSession(session);
	}

	/**
	 * nome del content panel
	 */
	private static final String CP_NAME = "cpElencoAllegatiImpianti";

	/**
	 * nome del namespace che contiene il content panel
	 */
	private static final String CP_NAMESPACE = "elenco_allegati_impianti";

	/**
	 * nome completo del namespace che contiene il content panel
	 */
	private static final String CP_FULL_NAMESPACE = "/base/elenco_allegati_impianti";

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

	private static final String URL_BACK_COMMAND = "/base/elenco_allegati_impianti/" + CP_NAME;

	/**
	 * classe model associata al ContentPanel
	 */
	public Class modelClass() {
		return it.csi.sigit.sigitwebn.dto.elenco_allegati_impianti.CpElencoAllegatiImpiantiModel.class;
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

		return handleEventInternal("elenco_allegati_impianti", "cpelencoallegatiimpianti", "btExportExcel", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnInserisciAllegatoPerImpianto]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnInserisciAllegatoPerImpianto_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_allegati_impianti", "cpelencoallegatiimpianti",
				"btnInserisciAllegatoPerImpianto", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnModificaAllegatoPerImpianto]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnModificaAllegatoPerImpianto_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_allegati_impianti", "cpelencoallegatiimpianti",
				"btnModificaAllegatoPerImpianto", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnDettaglioAllegatoPerImpianto]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnDettaglioAllegatoPerImpianto_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_allegati_impianti", "cpelencoallegatiimpianti",
				"btnDettaglioAllegatoPerImpianto", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnInviaAllegatoPerImpianto]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnInviaAllegatoPerImpianto_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_allegati_impianti", "cpelencoallegatiimpianti",
				"btnInviaAllegatoPerImpianto", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnRespingiAllegatoPerImpianto]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnRespingiAllegatoPerImpianto_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_allegati_impianti", "cpelencoallegatiimpianti",
				"btnRespingiAllegatoPerImpianto", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnEliminaAllegatoPerImpianto]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnEliminaAllegatoPerImpianto_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_allegati_impianti", "cpelencoallegatiimpianti",
				"btnEliminaAllegatoPerImpianto", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnInsVerifica]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnInsVerifica_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_allegati_impianti", "cpelencoallegatiimpianti", "btnInsVerifica", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnRicevutaPerImpianto]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnRicevutaPerImpianto_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_allegati_impianti", "cpelencoallegatiimpianti", "btnRicevutaPerImpianto",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnDocumentazione]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnDocumentazione_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_allegati_impianti", "cpelencoallegatiimpianti", "btnDocumentazione",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnReeFirmato]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnReeFirmato_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_allegati_impianti", "cpelencoallegatiimpianti", "btnReeFirmato", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnIndietroElencoAllegatiImpianti]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnIndietroElencoAllegatiImpianti_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_allegati_impianti", "cpelencoallegatiimpianti",
				"btnIndietroElencoAllegatiImpianti", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnCercaApparecchiature]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnCercaApparecchiature_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_allegati_impianti", "cpelencoallegatiimpianti", "btnCercaApparecchiature",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnNuovaRicercaApparecchiature]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnNuovaRicercaApparecchiature_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_allegati_impianti", "cpelencoallegatiimpianti",
				"btnNuovaRicercaApparecchiature", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnFiltraComp]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnFiltraComp_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_allegati_impianti", "cpelencoallegatiimpianti", "btnFiltraComp", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnVerificaApparecchiature]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnVerificaApparecchiature_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_allegati_impianti", "cpelencoallegatiimpianti", "btnVerificaApparecchiature",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnChiudiDatiAlleagto]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnChiudiDatiAlleagto_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_allegati_impianti", "cpelencoallegatiimpianti", "btnChiudiDatiAlleagto",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnReeWeb]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnReeWeb_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_allegati_impianti", "cpelencoallegatiimpianti", "btnReeWeb", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btConferma]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtConferma_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_allegati_impianti", "cpelencoallegatiimpianti", "btConferma", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btAnnulla]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtAnnulla_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_allegati_impianti", "cpelencoallegatiimpianti", "btAnnulla", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btConfermaElim]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtConfermaElim_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_allegati_impianti", "cpelencoallegatiimpianti", "btConfermaElim", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btAnnullaElim]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtAnnullaElim_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_allegati_impianti", "cpelencoallegatiimpianti", "btAnnullaElim", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [indietrobtndialog]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleIndietrobtndialog_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_allegati_impianti", "cpelencoallegatiimpianti", "indietrobtndialog",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btIndietroNoReeFirmato]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtIndietroNoReeFirmato_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_allegati_impianti", "cpelencoallegatiimpianti", "btIndietroNoReeFirmato",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btISiReeFirmato]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtISiReeFirmato_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_allegati_impianti", "cpelencoallegatiimpianti", "btISiReeFirmato",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btIndietroNoReplaceReeFirmato]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtIndietroNoReplaceReeFirmato_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_allegati_impianti", "cpelencoallegatiimpianti",
				"btIndietroNoReplaceReeFirmato", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btISiReplaceReeFirmato]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtISiReplaceReeFirmato_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_allegati_impianti", "cpelencoallegatiimpianti", "btISiReplaceReeFirmato",
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
	 * al data-binding relativo al dataset DATASET del widget tblElencoAllegati.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideTblElencoAllegati_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoAllegatiPerImpianto", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbTipoAllegato.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbTipoAllegato_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoTipiDocumentoProfilati", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbCombustibile.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbCombustibile_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoTipiCombustibile", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbApparecchiature.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbApparecchiature_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoApparecchiature", "", false, false);
	}

	/**
	 * Gestione della validazione
	 */
	public void validate() {
		/*PROTECTED REGION ID(R670436516) ENABLED START*/
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
