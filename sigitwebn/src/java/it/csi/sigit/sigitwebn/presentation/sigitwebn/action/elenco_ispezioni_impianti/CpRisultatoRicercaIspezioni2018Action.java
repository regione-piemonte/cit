package it.csi.sigit.sigitwebn.presentation.sigitwebn.action.elenco_ispezioni_impianti;

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
import it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpRisultatoRicercaIspezioni2018Model;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.command.*;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.security.*;

import it.csi.sigit.sigitwebn.business.*;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.action.*;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.action.elenco_ispezioni_impianti.states.CpRisultatoRicercaIspezioni2018ScreenStates;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.interceptor.MethodProtection;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.interceptor.FatClientOnly;
import it.csi.sigit.sigitwebn.presentation.uiutils.*;
import flexjson.JSON;

/**
 * CpRisultatoRicercaIspezioni2018Action Action Class.
 *
 * @author GuiGen
 */
@Validation()
@Conversion()
public class CpRisultatoRicercaIspezioni2018Action extends AbstractCPAction<CpRisultatoRicercaIspezioni2018Model>
		implements
			Preparable,
			ModelDriven<CpRisultatoRicercaIspezioni2018Model> {

	/**
	 * Il modello del content panel.
	 * Viene riempito a fornte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	private CpRisultatoRicercaIspezioni2018Model model;

	/**
	 * Il modello del content panel.
	 * Viene riempito a fornte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	public CpRisultatoRicercaIspezioni2018Model getModel() {
		return model;
	}

	/**
	 * Il modello del content panel.
	 * Viene riempito a fronte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	@VisitorFieldValidator(message = "", appendPrefix = false)
	public void setModel(CpRisultatoRicercaIspezioni2018Model modello) {
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
			model = new CpRisultatoRicercaIspezioni2018Model();
		}
		// associo la sessione applicativa al modello, in modo che
		// possa implementare l'accesso agli application data
		// di scope session/same page
		model.setSession(session);
	}

	/**
	 * nome del content panel
	 */
	private static final String CP_NAME = "cpRisultatoRicercaIspezioni2018";

	/**
	 * nome del namespace che contiene il content panel
	 */
	private static final String CP_NAMESPACE = "elenco_ispezioni_impianti";

	/**
	 * nome completo del namespace che contiene il content panel
	 */
	private static final String CP_FULL_NAMESPACE = "/base/elenco_ispezioni_impianti";

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

	private static final String URL_BACK_COMMAND = "/base/elenco_ispezioni_impianti/" + CP_NAME;

	/**
	 * classe model associata al ContentPanel
	 */
	public Class modelClass() {
		return it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpRisultatoRicercaIspezioni2018Model.class;
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
	 * Gestione dell'evento CLICKED sul widget [btVisualizzaModifica]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtVisualizzaModifica_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_ispezioni_impianti", "cprisultatoricercaispezioni2018",
				"btVisualizzaModifica", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [scaricaXls]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleScaricaXls_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_ispezioni_impianti", "cprisultatoricercaispezioni2018", "scaricaXls",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btCopertinaIspezione]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtCopertinaIspezione_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_ispezioni_impianti", "cprisultatoricercaispezioni2018",
				"btCopertinaIspezione", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btLetteraAvviso]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtLetteraAvviso_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_ispezioni_impianti", "cprisultatoricercaispezioni2018", "btLetteraAvviso",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btIndietroRisultatoRicercaIspezioni]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtIndietroRisultatoRicercaIspezioni_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_ispezioni_impianti", "cprisultatoricercaispezioni2018",
				"btIndietroRisultatoRicercaIspezioni", "CLICKED");

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
	 * al data-binding relativo al dataset DATASET del widget tbRisultatiRicerca.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideTbRisultatiRicerca_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataElencoIspezioni2018", "", false, false);
	}

	/**
	 * Gestione della validazione
	 */
	public void validate() {
		/*PROTECTED REGION ID(R-103918841) ENABLED START*/
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
