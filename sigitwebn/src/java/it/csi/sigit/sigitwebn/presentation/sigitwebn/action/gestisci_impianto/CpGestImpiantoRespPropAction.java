package it.csi.sigit.sigitwebn.presentation.sigitwebn.action.gestisci_impianto;

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
import it.csi.sigit.sigitwebn.dto.gestisci_impianto.CpGestImpiantoRespPropModel;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.command.*;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.security.*;

import it.csi.sigit.sigitwebn.business.*;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.action.*;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.action.gestisci_impianto.states.CpGestImpiantoRespPropScreenStates;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.interceptor.MethodProtection;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.interceptor.FatClientOnly;
import it.csi.sigit.sigitwebn.presentation.uiutils.*;
import flexjson.JSON;

/**
 * CpGestImpiantoRespPropAction Action Class.
 *
 * @author GuiGen
 */
@Validation()
@Conversion()
public class CpGestImpiantoRespPropAction extends AbstractCPAction<CpGestImpiantoRespPropModel>
		implements
			Preparable,
			ModelDriven<CpGestImpiantoRespPropModel> {

	/**
	 * Il modello del content panel.
	 * Viene riempito a fornte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	private CpGestImpiantoRespPropModel model;

	/**
	 * Il modello del content panel.
	 * Viene riempito a fornte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	public CpGestImpiantoRespPropModel getModel() {
		return model;
	}

	/**
	 * Il modello del content panel.
	 * Viene riempito a fronte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	@VisitorFieldValidator(message = "", appendPrefix = false)
	public void setModel(CpGestImpiantoRespPropModel modello) {
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
			model = new CpGestImpiantoRespPropModel();
		}
		// associo la sessione applicativa al modello, in modo che
		// possa implementare l'accesso agli application data
		// di scope session/same page
		model.setSession(session);
	}

	/**
	 * nome del content panel
	 */
	private static final String CP_NAME = "cpGestImpiantoRespProp";

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
		return it.csi.sigit.sigitwebn.dto.gestisci_impianto.CpGestImpiantoRespPropModel.class;
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

		return handleEventInternal("gestisci_impianto", "cpgestimpiantorespprop", "rbRespIsImpresa", "VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnRespCercaCF]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnRespCercaCF_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_impianto", "cpgestimpiantorespprop", "btnRespCercaCF", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnRespNuovaRicercaCF]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnRespNuovaRicercaCF_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_impianto", "cpgestimpiantorespprop", "btnRespNuovaRicercaCF", "CLICKED");

	}

	/**
	 * Gestione dell'evento VALUE_CHANGED sul widget [cbRespIndirizzoEst]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleCbRespIndirizzoEst_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("gestisci_impianto", "cpgestimpiantorespprop", "cbRespIndirizzoEst",
				"VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento VALUE_CHANGED sul widget [cbRespProvincia]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleCbRespProvincia_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("gestisci_impianto", "cpgestimpiantorespprop", "cbRespProvincia", "VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnRespCercaIndirizzo]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnRespCercaIndirizzo_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_impianto", "cpgestimpiantorespprop", "btnRespCercaIndirizzo", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnRespNuovaRicercaIndirizzo]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnRespNuovaRicercaIndirizzo_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_impianto", "cpgestimpiantorespprop", "btnRespNuovaRicercaIndirizzo",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnRespSalva]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnRespSalva_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_impianto", "cpgestimpiantorespprop", "btnRespSalva", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnRespTempAnnulla]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnRespTempAnnulla_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_impianto", "cpgestimpiantorespprop", "btnRespTempAnnulla", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnRespTempSelez]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnRespTempSelez_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_impianto", "cpgestimpiantorespprop", "btnRespTempSelez", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnImpIndietro]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnImpIndietro_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_impianto", "cpgestimpiantorespprop", "btnImpIndietro", "CLICKED");

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
	 * al data-binding relativo al dataset DATASET del widget cbRespTitolo.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbRespTitolo_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoTitoli", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbRespSiglaRea.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbRespSiglaRea_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoSiglaRea", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbRespProvincia.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbRespProvincia_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoProvince", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbRespComune.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbRespComune_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoComuniResp", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbRespIndirizzo.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbRespIndirizzo_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoIndirizziResp", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget tbResponsabiliTrovatiTemp.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideTbResponsabiliTrovatiTemp_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoResponsabiliTemp", "", false, false);
	}

	/**
	 * Gestione della validazione
	 */
	public void validate() {
		/*PROTECTED REGION ID(R-1842050853) ENABLED START*/
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
