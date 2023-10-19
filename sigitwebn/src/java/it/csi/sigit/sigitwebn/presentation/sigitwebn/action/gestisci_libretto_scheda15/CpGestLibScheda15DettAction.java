package it.csi.sigit.sigitwebn.presentation.sigitwebn.action.gestisci_libretto_scheda15;

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
import it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda15.CpGestLibScheda15DettModel;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.command.*;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.security.*;

import it.csi.sigit.sigitwebn.business.*;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.action.*;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.action.gestisci_libretto_scheda15.states.CpGestLibScheda15DettScreenStates;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.interceptor.MethodProtection;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.interceptor.FatClientOnly;
import it.csi.sigit.sigitwebn.presentation.uiutils.*;
import flexjson.JSON;

/**
 * CpGestLibScheda15DettAction Action Class.
 *
 * @author GuiGen
 */
@Validation()
@Conversion()
public class CpGestLibScheda15DettAction extends AbstractCPAction<CpGestLibScheda15DettModel>
		implements
			Preparable,
			ModelDriven<CpGestLibScheda15DettModel> {

	/**
	 * Il modello del content panel.
	 * Viene riempito a fornte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	private CpGestLibScheda15DettModel model;

	/**
	 * Il modello del content panel.
	 * Viene riempito a fornte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	public CpGestLibScheda15DettModel getModel() {
		return model;
	}

	/**
	 * Il modello del content panel.
	 * Viene riempito a fronte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	@VisitorFieldValidator(message = "", appendPrefix = false)
	public void setModel(CpGestLibScheda15DettModel modello) {
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
			model = new CpGestLibScheda15DettModel();
		}
		// associo la sessione applicativa al modello, in modo che
		// possa implementare l'accesso agli application data
		// di scope session/same page
		model.setSession(session);
	}

	/**
	 * nome del content panel
	 */
	private static final String CP_NAME = "cpGestLibScheda15Dett";

	/**
	 * nome del namespace che contiene il content panel
	 */
	private static final String CP_NAMESPACE = "gestisci_libretto_scheda15";

	/**
	 * nome completo del namespace che contiene il content panel
	 */
	private static final String CP_FULL_NAMESPACE = "/base/gestisci_libretto_scheda15";

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

	private static final String URL_BACK_COMMAND = "/base/gestisci_libretto_scheda15/" + CP_NAME;

	/**
	 * classe model associata al ContentPanel
	 */
	public Class modelClass() {
		return it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda15.CpGestLibScheda15DettModel.class;
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
	 * Gestione dell'evento CLICKED sul widget [menuLibretto]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleMenuLibretto_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_libretto_scheda15", "cpgestlibscheda15dett", "menuLibretto", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnCercaApparecchiature]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnCercaApparecchiature_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_libretto_scheda15", "cpgestlibscheda15dett", "btnCercaApparecchiature",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnNuovaRicercaApparecchiature]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnNuovaRicercaApparecchiature_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_libretto_scheda15", "cpgestlibscheda15dett",
				"btnNuovaRicercaApparecchiature", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnVerificaApparecchiature]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnVerificaApparecchiature_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_libretto_scheda15", "cpgestlibscheda15dett", "btnVerificaApparecchiature",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento VALUE_CHANGED sul widget [cbTipoIntervento]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleCbTipoIntervento_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("gestisci_libretto_scheda15", "cpgestlibscheda15dett", "cbTipoIntervento",
				"VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [bSalvaManut]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBSalvaManut_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_libretto_scheda15", "cpgestlibscheda15dett", "bSalvaManut", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnVisualizzaDoc]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnVisualizzaDoc_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_libretto_scheda15", "cpgestlibscheda15dett", "btnVisualizzaDoc",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnInserisciDocumento]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnInserisciDocumento_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_libretto_scheda15", "cpgestlibscheda15dett", "btnInserisciDocumento",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnEliminaDocumento]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnEliminaDocumento_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_libretto_scheda15", "cpgestlibscheda15dett", "btnEliminaDocumento",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnIndietro]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnIndietro_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_libretto_scheda15", "cpgestlibscheda15dett", "btnIndietro", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnChiudiDatiDocumento]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnChiudiDatiDocumento_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_libretto_scheda15", "cpgestlibscheda15dett", "btnChiudiDatiDocumento",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnCaricaDocumento]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnCaricaDocumento_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_libretto_scheda15", "cpgestlibscheda15dett", "btnCaricaDocumento",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btConfermaElim]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtConfermaElim_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_libretto_scheda15", "cpgestlibscheda15dett", "btConfermaElim", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btAnnullaElim]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtAnnullaElim_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestisci_libretto_scheda15", "cpgestlibscheda15dett", "btAnnullaElim", "CLICKED");

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
	 * al data-binding relativo al dataset DATASET del widget menuLibretto.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideMenuLibretto_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDatalibrettoMenuTree", "", false, true);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbTipoManut.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbTipoManut_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoTipoManutenzione", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbApparecchiature.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbApparecchiature_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoApparecchiatureManut", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbTipoIntervento.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbTipoIntervento_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoTipoIntervento", "", false, false);
	}

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
	 * Gestione della validazione
	 */
	public void validate() {
		/*PROTECTED REGION ID(R1306705975) ENABLED START*/
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
