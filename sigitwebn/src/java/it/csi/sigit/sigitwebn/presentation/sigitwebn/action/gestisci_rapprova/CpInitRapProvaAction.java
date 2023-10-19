package it.csi.sigit.sigitwebn.presentation.sigitwebn.action.gestisci_rapprova;

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
import it.csi.sigit.sigitwebn.dto.gestisci_rapprova.CpInitRapProvaModel;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.command.*;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.security.*;

import it.csi.sigit.sigitwebn.business.*;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.action.*;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.action.gestisci_rapprova.states.CpInitRapProvaScreenStates;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.interceptor.MethodProtection;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.interceptor.FatClientOnly;
import it.csi.sigit.sigitwebn.presentation.uiutils.*;
import flexjson.JSON;

/**
 * CpInitRapProvaAction Action Class.
 *
 * @author GuiGen
 */
@Validation()
@Conversion()
public class CpInitRapProvaAction extends AbstractCPAction<CpInitRapProvaModel>
		implements
			Preparable,
			ModelDriven<CpInitRapProvaModel> {

	/**
	 * Il modello del content panel.
	 * Viene riempito a fornte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	private CpInitRapProvaModel model;

	/**
	 * Il modello del content panel.
	 * Viene riempito a fornte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	public CpInitRapProvaModel getModel() {
		return model;
	}

	/**
	 * Il modello del content panel.
	 * Viene riempito a fronte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	@VisitorFieldValidator(message = "", appendPrefix = false)
	public void setModel(CpInitRapProvaModel modello) {
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
			model = new CpInitRapProvaModel();
		}
		// associo la sessione applicativa al modello, in modo che
		// possa implementare l'accesso agli application data
		// di scope session/same page
		model.setSession(session);
	}

	/**
	 * nome del content panel
	 */
	private static final String CP_NAME = "cpInitRapProva";

	/**
	 * nome del namespace che contiene il content panel
	 */
	private static final String CP_NAMESPACE = "gestisci_rapprova";

	/**
	 * nome completo del namespace che contiene il content panel
	 */
	private static final String CP_FULL_NAMESPACE = "/base/gestisci_rapprova";

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

	private static final String URL_BACK_COMMAND = "/base/gestisci_rapprova/" + CP_NAME;

	/**
	 * classe model associata al ContentPanel
	 */
	public Class modelClass() {
		return it.csi.sigit.sigitwebn.dto.gestisci_rapprova.CpInitRapProvaModel.class;
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
	 * Gestione dell'evento CLICKED sul widget [btnCerca]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnCerca_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_rapprova", "cpinitrapprova", "btnCerca", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnNuovaCerca]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnNuovaCerca_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_rapprova", "cpinitrapprova", "btnNuovaCerca", "CLICKED");

	}

	/**
	 * Gestione dell'evento VALUE_CHANGED sul widget [cbCombustibile]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleCbCombustibile_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("gestisci_rapprova", "cpinitrapprova", "cbCombustibile", "VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnAnnullaDatiAllegato]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnAnnullaDatiAllegato_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_rapprova", "cpinitrapprova", "btnAnnullaDatiAllegato", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnUploadAllegato]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnUploadAllegato_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_rapprova", "cpinitrapprova", "btnUploadAllegato", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnCreaAllegato]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnCreaAllegato_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_rapprova", "cpinitrapprova", "btnCreaAllegato", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnCaricaUploadAllegato]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnCaricaUploadAllegato_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_rapprova", "cpinitrapprova", "btnCaricaUploadAllegato", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnIndietroInitRapProva]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnIndietroInitRapProva_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_rapprova", "cpinitrapprova", "btnIndietroInitRapProva", "CLICKED");

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
	 * al data-binding relativo al dataset DATASET del widget cbTipoAllegato.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbTipoAllegato_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoTipiDocumentoProfilatiIsp", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbCombustibile.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbCombustibile_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoTipiCombustibileIsp", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbApparecchiature.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbApparecchiature_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoApparecchiatureIsp", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbTipoAllegatoMod.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbTipoAllegatoMod_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoTipiDocumentoProfilatiIsp", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbCombustibileMod.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbCombustibileMod_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoTipiCombustibileIsp", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbApparecchiatureMod.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbApparecchiatureMod_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoApparecchiatureIsp", "", false, false);
	}

	/**
	 * Gestione della validazione
	 */
	public void validate() {
		/*PROTECTED REGION ID(R1832658315) ENABLED START*/
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
