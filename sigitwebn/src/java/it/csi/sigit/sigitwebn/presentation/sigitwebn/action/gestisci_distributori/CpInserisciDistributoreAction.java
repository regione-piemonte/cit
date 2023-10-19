package it.csi.sigit.sigitwebn.presentation.sigitwebn.action.gestisci_distributori;

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
import it.csi.sigit.sigitwebn.dto.gestisci_distributori.CpInserisciDistributoreModel;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.command.*;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.security.*;

import it.csi.sigit.sigitwebn.business.*;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.action.*;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.action.gestisci_distributori.states.CpInserisciDistributoreScreenStates;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.interceptor.MethodProtection;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.interceptor.FatClientOnly;
import it.csi.sigit.sigitwebn.presentation.uiutils.*;
import flexjson.JSON;

/**
 * CpInserisciDistributoreAction Action Class.
 *
 * @author GuiGen
 */
@Validation()
@Conversion()
public class CpInserisciDistributoreAction extends AbstractCPAction<CpInserisciDistributoreModel>
		implements
			Preparable,
			ModelDriven<CpInserisciDistributoreModel> {

	/**
	 * Il modello del content panel.
	 * Viene riempito a fornte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	private CpInserisciDistributoreModel model;

	/**
	 * Il modello del content panel.
	 * Viene riempito a fornte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	public CpInserisciDistributoreModel getModel() {
		return model;
	}

	/**
	 * Il modello del content panel.
	 * Viene riempito a fronte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	@VisitorFieldValidator(message = "", appendPrefix = false)
	public void setModel(CpInserisciDistributoreModel modello) {
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
			model = new CpInserisciDistributoreModel();
		}
		// associo la sessione applicativa al modello, in modo che
		// possa implementare l'accesso agli application data
		// di scope session/same page
		model.setSession(session);
	}

	/**
	 * nome del content panel
	 */
	private static final String CP_NAME = "cpInserisciDistributore";

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
		return it.csi.sigit.sigitwebn.dto.gestisci_distributori.CpInserisciDistributoreModel.class;
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
	 * Gestione dell'evento VALUE_CHANGED sul widget [cbFornProvincia]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleCbFornProvincia_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("gestisci_distributori", "cpinseriscidistributore", "cbFornProvincia",
				"VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnCercaIndirizzoForn]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnCercaIndirizzoForn_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_distributori", "cpinseriscidistributore", "btnCercaIndirizzoForn",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnNuovaRicercaIndForn]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnNuovaRicercaIndForn_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_distributori", "cpinseriscidistributore", "btnNuovaRicercaIndForn",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento VALUE_CHANGED sul widget [cbFattUguale]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleCbFattUguale_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("gestisci_distributori", "cpinseriscidistributore", "cbFattUguale", "VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento VALUE_CHANGED sul widget [cbIndEstero]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleCbIndEstero_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("gestisci_distributori", "cpinseriscidistributore", "cbIndEstero", "VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento VALUE_CHANGED sul widget [cbFornProvinciaFatt]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleCbFornProvinciaFatt_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("gestisci_distributori", "cpinseriscidistributore", "cbFornProvinciaFatt",
				"VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnCercaIndirizzoFatt]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnCercaIndirizzoFatt_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_distributori", "cpinseriscidistributore", "btnCercaIndirizzoFatt",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnNuovaRicercaIndFatt]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnNuovaRicercaIndFatt_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_distributori", "cpinseriscidistributore", "btnNuovaRicercaIndFatt",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnDistrSalva]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnDistrSalva_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_distributori", "cpinseriscidistributore", "btnDistrSalva", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnDistrIndietro]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnDistrIndietro_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_distributori", "cpinseriscidistributore", "btnDistrIndietro", "CLICKED");

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
	 * al data-binding relativo al dataset DATASET del widget cbFornProvincia.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbFornProvincia_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoProvince", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbFornComune.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbFornComune_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoComuni", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbFornIndirizzo.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbFornIndirizzo_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoIndirizziFornitura", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbTipoContratto.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbTipoContratto_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoTipoContrattoDistrib", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbTipoCategoria.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbTipoCategoria_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoTipoCategoria", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbTipoCombustibile.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbTipoCombustibile_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoTipoCombustibile", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbTipoMisura.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbTipoMisura_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoUnitaMisura", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbFornProvinciaFatt.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbFornProvinciaFatt_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoProvince", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbFornComuneFatt.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbFornComuneFatt_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoComuniFatturazione", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbFattIndirizzo.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbFattIndirizzo_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoIndirizziFatturazione", "", false, false);
	}

	/**
	 * Gestione della validazione
	 */
	public void validate() {
		/*PROTECTED REGION ID(R839635011) ENABLED START*/
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
