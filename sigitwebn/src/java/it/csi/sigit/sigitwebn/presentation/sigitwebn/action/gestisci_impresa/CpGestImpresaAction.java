package it.csi.sigit.sigitwebn.presentation.sigitwebn.action.gestisci_impresa;

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
import it.csi.sigit.sigitwebn.dto.gestisci_impresa.CpGestImpresaModel;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.command.*;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.security.*;

import it.csi.sigit.sigitwebn.business.*;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.action.*;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.action.gestisci_impresa.states.CpGestImpresaScreenStates;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.interceptor.MethodProtection;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.interceptor.FatClientOnly;
import it.csi.sigit.sigitwebn.presentation.uiutils.*;
import flexjson.JSON;

/**
 * CpGestImpresaAction Action Class.
 *
 * @author GuiGen
 */
@Validation()
@Conversion()
public class CpGestImpresaAction extends AbstractCPAction<CpGestImpresaModel>
		implements
			Preparable,
			ModelDriven<CpGestImpresaModel> {

	/**
	 * Il modello del content panel.
	 * Viene riempito a fornte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	private CpGestImpresaModel model;

	/**
	 * Il modello del content panel.
	 * Viene riempito a fornte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	public CpGestImpresaModel getModel() {
		return model;
	}

	/**
	 * Il modello del content panel.
	 * Viene riempito a fronte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	@VisitorFieldValidator(message = "", appendPrefix = false)
	public void setModel(CpGestImpresaModel modello) {
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
			model = new CpGestImpresaModel();
		}
		// associo la sessione applicativa al modello, in modo che
		// possa implementare l'accesso agli application data
		// di scope session/same page
		model.setSession(session);
	}

	/**
	 * nome del content panel
	 */
	private static final String CP_NAME = "cpGestImpresa";

	/**
	 * nome del namespace che contiene il content panel
	 */
	private static final String CP_NAMESPACE = "gestisci_impresa";

	/**
	 * nome completo del namespace che contiene il content panel
	 */
	private static final String CP_FULL_NAMESPACE = "/base/gestisci_impresa";

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

	private static final String URL_BACK_COMMAND = "/base/gestisci_impresa/" + CP_NAME;

	/**
	 * classe model associata al ContentPanel
	 */
	public Class modelClass() {
		return it.csi.sigit.sigitwebn.dto.gestisci_impresa.CpGestImpresaModel.class;
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
	 * Gestione dell'evento CLICKED sul widget [btnImpCerca]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnImpCerca_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_impresa", "cpgestimpresa", "btnImpCerca", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btDettaglio]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtDettaglio_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_impresa", "cpgestimpresa", "btDettaglio", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btVisura]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtVisura_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_impresa", "cpgestimpresa", "btVisura", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btDaticat]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtDaticat_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_impresa", "cpgestimpresa", "btDaticat", "CLICKED");

	}

	/**
	 * Gestione dell'evento VALUE_CHANGED sul widget [cbStatoImpresa]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleCbStatoImpresa_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("gestisci_impresa", "cpgestimpresa", "cbStatoImpresa", "VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento VALUE_CHANGED sul widget [cbImpresaIndirizzoEst]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleCbImpresaIndirizzoEst_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("gestisci_impresa", "cpgestimpresa", "cbImpresaIndirizzoEst", "VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento VALUE_CHANGED sul widget [cbImpresaProvincia]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleCbImpresaProvincia_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("gestisci_impresa", "cpgestimpresa", "cbImpresaProvincia", "VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btImpresaCercaIndirizzo]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtImpresaCercaIndirizzo_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_impresa", "cpgestimpresa", "btImpresaCercaIndirizzo", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btImpresaNuovaRicerca]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtImpresaNuovaRicerca_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_impresa", "cpgestimpresa", "btImpresaNuovaRicerca", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btImpresaVerificaEmail]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtImpresaVerificaEmail_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_impresa", "cpgestimpresa", "btImpresaVerificaEmail", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btAnnulla]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtAnnulla_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_impresa", "cpgestimpresa", "btAnnulla", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btSalvaImpresa]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtSalvaImpresa_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_impresa", "cpgestimpresa", "btSalvaImpresa", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btAnnullaDatiCat]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtAnnullaDatiCat_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_impresa", "cpgestimpresa", "btAnnullaDatiCat", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnImpIndietro]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnImpIndietro_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_impresa", "cpgestimpresa", "btnImpIndietro", "CLICKED");

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
	 * al data-binding relativo al dataset DATASET del widget cbRuolo.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbRuolo_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataruoliImpresa", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbStatoImp.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbStatoImp_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoStatoImp", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget tbImpTrovate.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideTbImpTrovate_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoImprese", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbSiglaRea.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbSiglaRea_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoSiglaRea", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbStatoImpresa.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbStatoImpresa_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoStatoImp", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbImpresaProvincia.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbImpresaProvincia_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoProvince", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbImpresaComune.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbImpresaComune_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoComuni", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbImpresaIndirizzo.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbImpresaIndirizzo_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoIndirizziImp", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget tbVisuraImpresa.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideTbVisuraImpresa_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoDatiVisura", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget tbIncTrovate.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideTbIncTrovate_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoIncarichiAttivi", "", false, false);
	}

	/**
	 * Gestione della validazione
	 */
	public void validate() {
		/*PROTECTED REGION ID(R467436734) ENABLED START*/
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
