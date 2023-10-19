package it.csi.sigit.sigitwebn.presentation.sigitwebn.action.ricerca_avanz_impianti;

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
import it.csi.sigit.sigitwebn.dto.ricerca_avanz_impianti.CpRicAvzImpiantoModel;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.command.*;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.security.*;

import it.csi.sigit.sigitwebn.business.*;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.action.*;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.action.ricerca_avanz_impianti.states.CpRicAvzImpiantoScreenStates;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.interceptor.MethodProtection;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.interceptor.FatClientOnly;
import it.csi.sigit.sigitwebn.presentation.uiutils.*;
import flexjson.JSON;

/**
 * CpRicAvzImpiantoAction Action Class.
 *
 * @author GuiGen
 */
@Validation()
@Conversion()
public class CpRicAvzImpiantoAction extends AbstractCPAction<CpRicAvzImpiantoModel>
		implements
			Preparable,
			ModelDriven<CpRicAvzImpiantoModel> {

	/**
	 * Il modello del content panel.
	 * Viene riempito a fornte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	private CpRicAvzImpiantoModel model;

	/**
	 * Il modello del content panel.
	 * Viene riempito a fornte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	public CpRicAvzImpiantoModel getModel() {
		return model;
	}

	/**
	 * Il modello del content panel.
	 * Viene riempito a fronte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	@VisitorFieldValidator(message = "", appendPrefix = false)
	public void setModel(CpRicAvzImpiantoModel modello) {
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
			model = new CpRicAvzImpiantoModel();
		}
		// associo la sessione applicativa al modello, in modo che
		// possa implementare l'accesso agli application data
		// di scope session/same page
		model.setSession(session);
	}

	/**
	 * nome del content panel
	 */
	private static final String CP_NAME = "cpRicAvzImpianto";

	/**
	 * nome del namespace che contiene il content panel
	 */
	private static final String CP_NAMESPACE = "ricerca_avanz_impianti";

	/**
	 * nome completo del namespace che contiene il content panel
	 */
	private static final String CP_FULL_NAMESPACE = "/base/ricerca_avanz_impianti";

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

	private static final String URL_BACK_COMMAND = "/base/ricerca_avanz_impianti/" + CP_NAME;

	/**
	 * classe model associata al ContentPanel
	 */
	public Class modelClass() {
		return it.csi.sigit.sigitwebn.dto.ricerca_avanz_impianti.CpRicAvzImpiantoModel.class;
	}

	/**
	 * I singoli eventi sui singoli widget sono gestiti dai metodi specifici   
	 * @return SUCCESS.
	 */
	@SkipValidation
	public String execute() throws CommandExecutionException {
		return super.execute();
	}

	//////////////////////////////////////////////////////////////////////////////////
	/// metodi specifici per la gestione del click sui Tab
	/// contenuto nel contentPanel
	/// metodo: handle<id_completo_tab_item>_CLICKED
	/// 
	//////////////////////////////////////////////////////////////////////////////////

	/**
	 * Gestione dell'evento di click sul tab Switcher del tab-set tsRicAvz 
	 */
	public String handle_CpRicAvzImpianto_TsRicAvz_FpTabRicAvz_CLICKED() throws CommandExecutionException {

		// impostazione dei parametri di selezione tab
		getModel().setSelectedTabKey("cpRicAvzImpianto_tsRicAvz_selectedMultiPanel");
		getModel().setSelectedTabValue("cpRicAvzImpianto_tsRicAvz_fpTabRicAvz");
		// richiamo della logica associata al tab-switcher
		String tempResult = handleTsRicAvz_CLICKED();
		// selezione del tab di destinazione
		handleChangeTab();
		return SUCCESS;
	}

	/**
	 * Gestione dell'evento di click sul tab Switcher del tab-set tsRicAvz 
	 */
	public String handle_CpRicAvzImpianto_TsRicAvz_FpRicAvzAll_CLICKED() throws CommandExecutionException {

		// impostazione dei parametri di selezione tab
		getModel().setSelectedTabKey("cpRicAvzImpianto_tsRicAvz_selectedMultiPanel");
		getModel().setSelectedTabValue("cpRicAvzImpianto_tsRicAvz_fpRicAvzAll");
		// richiamo della logica associata al tab-switcher
		String tempResult = handleTsRicAvz_CLICKED();
		// selezione del tab di destinazione
		handleChangeTab();
		return SUCCESS;
	}

	/**
	 * Gestione dell'evento di click sul tab Switcher del tab-set tsRicAvz 
	 */
	public String handle_CpRicAvzImpianto_TsRicAvz_FpRicAvz3Resp_CLICKED() throws CommandExecutionException {

		// impostazione dei parametri di selezione tab
		getModel().setSelectedTabKey("cpRicAvzImpianto_tsRicAvz_selectedMultiPanel");
		getModel().setSelectedTabValue("cpRicAvzImpianto_tsRicAvz_fpRicAvz3Resp");
		// richiamo della logica associata al tab-switcher
		String tempResult = handleTsRicAvz_CLICKED();
		// selezione del tab di destinazione
		handleChangeTab();
		return SUCCESS;
	}

	protected boolean isImplicitEventDefined(String implicitEventName) {

		if (AbstractCPAction.IMPLICIT_EVENT_ON_INIT.equals(implicitEventName)) //NOSONAR
			return true; //NOSONAR

		if (AbstractCPAction.IMPLICIT_EVENT_ON_ENTER.equals(implicitEventName)) //NOSONAR
			return true; //NOSONAR

		if (AbstractCPAction.IMPLICIT_EVENT_AFTER_EVENTS.equals(implicitEventName)) //NOSONAR
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
	 * Gestione dell'evento VALUE_CHANGED sul widget [cbProvincia]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleCbProvincia_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("ricerca_avanz_impianti", "cpricavzimpianto", "cbProvincia", "VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento VALUE_CHANGED sul widget [cbTipoComp]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleCbTipoComp_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("ricerca_avanz_impianti", "cpricavzimpianto", "cbTipoComp", "VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btRicComp]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtRicComp_CLICKED() throws CommandExecutionException {

		return handleEventInternal("ricerca_avanz_impianti", "cpricavzimpianto", "btRicComp", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnAnnullaRicImpiantoCom]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnAnnullaRicImpiantoCom_CLICKED() throws CommandExecutionException {

		return handleEventInternal("ricerca_avanz_impianti", "cpricavzimpianto", "btnAnnullaRicImpiantoCom", "CLICKED");

	}

	/**
	 * Gestione dell'evento VALUE_CHANGED sul widget [cbAllTipoRapp]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleCbAllTipoRapp_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("ricerca_avanz_impianti", "cpricavzimpianto", "cbAllTipoRapp", "VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btRicAll]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtRicAll_CLICKED() throws CommandExecutionException {

		return handleEventInternal("ricerca_avanz_impianti", "cpricavzimpianto", "btRicAll", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnAnnullaRicImpiantoAll]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnAnnullaRicImpiantoAll_CLICKED() throws CommandExecutionException {

		return handleEventInternal("ricerca_avanz_impianti", "cpricavzimpianto", "btnAnnullaRicImpiantoAll", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btRicResp]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtRicResp_CLICKED() throws CommandExecutionException {

		return handleEventInternal("ricerca_avanz_impianti", "cpricavzimpianto", "btRicResp", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnAnnullaRicImpiantoResp]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnAnnullaRicImpiantoResp_CLICKED() throws CommandExecutionException {

		return handleEventInternal("ricerca_avanz_impianti", "cpricavzimpianto", "btnAnnullaRicImpiantoResp",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [tsRicAvz]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleTsRicAvz_CLICKED() throws CommandExecutionException {

		return handleEventInternal("ricerca_avanz_impianti", "cpricavzimpianto", "tsRicAvz", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btIndietro]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtIndietro_CLICKED() throws CommandExecutionException {

		return handleEventInternal("ricerca_avanz_impianti", "cpricavzimpianto", "btIndietro", "CLICKED");

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

		return provideDataInternal("appDataelencoProvincePiemonte", "", false, false);
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
	 * al data-binding relativo al dataset DATASET del widget cbStatoImp.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbStatoImp_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoStatoImpianto", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbImpTipo.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbImpTipo_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoTipoImpianto", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbUiExt.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbUiExt_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoSiNo", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbContabilizzazione.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbContabilizzazione_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoSiNo", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbSglReaComp.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbSglReaComp_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoSiglaRea", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbAllTipoDoc.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbAllTipoDoc_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoTipiDocumentazione", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbTipoComp.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbTipoComp_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoTipoComponenti", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbMarca.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbMarca_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoMarche", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbCombu.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbCombu_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoCombustibili", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbAllTipoRapp.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbAllTipoRapp_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoTipoRapporto", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbRicAvzSic.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbRicAvzSic_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoSiNo", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbAllVerAss.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbAllVerAss_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoSiNo", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbAllUMisNox.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbAllUMisNox_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoUnitMisuraNox", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbAllSigleBoll.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbAllSigleBoll_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoSigleBollino", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbElencoCat.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbElencoCat_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoCat", "", false, false);
	}

	/**
	 * Gestione della validazione
	 */
	public void validate() {
		/*PROTECTED REGION ID(R-1102545100) ENABLED START*/
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
