package it.csi.sigit.sigitwebn.presentation.sigitwebn.action.elenco_ispezioni_impianti;

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
import it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpDettaglioIspezione2018Model;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.command.*;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.security.*;

import it.csi.sigit.sigitwebn.business.*;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.action.*;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.action.elenco_ispezioni_impianti.states.CpDettaglioIspezione2018ScreenStates;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.interceptor.MethodProtection;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.interceptor.FatClientOnly;
import it.csi.sigit.sigitwebn.presentation.uiutils.*;
import flexjson.JSON;

/**
 * CpDettaglioIspezione2018Action Action Class.
 *
 * @author GuiGen
 */
@Validation()
@Conversion()
public class CpDettaglioIspezione2018Action extends AbstractCPAction<CpDettaglioIspezione2018Model>
		implements
			Preparable,
			ModelDriven<CpDettaglioIspezione2018Model> {

	/**
	 * Il modello del content panel.
	 * Viene riempito a fornte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	private CpDettaglioIspezione2018Model model;

	/**
	 * Il modello del content panel.
	 * Viene riempito a fornte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	public CpDettaglioIspezione2018Model getModel() {
		return model;
	}

	/**
	 * Il modello del content panel.
	 * Viene riempito a fronte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	@VisitorFieldValidator(message = "", appendPrefix = false)
	public void setModel(CpDettaglioIspezione2018Model modello) {
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
			model = new CpDettaglioIspezione2018Model();
		}
		// associo la sessione applicativa al modello, in modo che
		// possa implementare l'accesso agli application data
		// di scope session/same page
		model.setSession(session);
	}

	/**
	 * nome del content panel
	 */
	private static final String CP_NAME = "cpDettaglioIspezione2018";

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
		return it.csi.sigit.sigitwebn.dto.elenco_ispezioni_impianti.CpDettaglioIspezione2018Model.class;
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
	 * Gestione dell'evento VALUE_CHANGED sul widget [provComp]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleProvComp_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("elenco_ispezioni_impianti", "cpdettaglioispezione2018", "provComp",
				"VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btSalvaIspezione]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtSalvaIspezione_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_ispezioni_impianti", "cpdettaglioispezione2018", "btSalvaIspezione",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btAvviaSanzione]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtAvviaSanzione_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_ispezioni_impianti", "cpdettaglioispezione2018", "btAvviaSanzione",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btVisualizzaSanzione]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtVisualizzaSanzione_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_ispezioni_impianti", "cpdettaglioispezione2018", "btVisualizzaSanzione",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [tbRapportiProva]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleTbRapportiProva_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_ispezioni_impianti", "cpdettaglioispezione2018", "tbRapportiProva",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btInserisciRapProva]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtInserisciRapProva_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_ispezioni_impianti", "cpdettaglioispezione2018", "btInserisciRapProva",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btModificaRapProva]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtModificaRapProva_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_ispezioni_impianti", "cpdettaglioispezione2018", "btModificaRapProva",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btDettaglioRapProva]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtDettaglioRapProva_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_ispezioni_impianti", "cpdettaglioispezione2018", "btDettaglioRapProva",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btAnnullaRapProva]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtAnnullaRapProva_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_ispezioni_impianti", "cpdettaglioispezione2018", "btAnnullaRapProva",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btConsolidaRapProva]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtConsolidaRapProva_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_ispezioni_impianti", "cpdettaglioispezione2018", "btConsolidaRapProva",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btCaricaRapProvaFirmato]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtCaricaRapProvaFirmato_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_ispezioni_impianti", "cpdettaglioispezione2018", "btCaricaRapProvaFirmato",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnUploadRappProvaFirmato]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnUploadRappProvaFirmato_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_ispezioni_impianti", "cpdettaglioispezione2018", "btnUploadRappProvaFirmato",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnCloseUploadRappProvaFirmato]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnCloseUploadRappProvaFirmato_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_ispezioni_impianti", "cpdettaglioispezione2018",
				"btnCloseUploadRappProvaFirmato", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [tbAzioniSvolte]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleTbAzioniSvolte_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_ispezioni_impianti", "cpdettaglioispezione2018", "tbAzioniSvolte",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btInserisciAzione]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtInserisciAzione_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_ispezioni_impianti", "cpdettaglioispezione2018", "btInserisciAzione",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btGestisciSveglia]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtGestisciSveglia_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_ispezioni_impianti", "cpdettaglioispezione2018", "btGestisciSveglia",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btVisualizzaVerifica]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtVisualizzaVerifica_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_ispezioni_impianti", "cpdettaglioispezione2018", "btVisualizzaVerifica",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btVisualizzaAccertamento]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtVisualizzaAccertamento_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_ispezioni_impianti", "cpdettaglioispezione2018", "btVisualizzaAccertamento",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btConcludiIspezione]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtConcludiIspezione_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_ispezioni_impianti", "cpdettaglioispezione2018", "btConcludiIspezione",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btAnnullaIspezione]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtAnnullaIspezione_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_ispezioni_impianti", "cpdettaglioispezione2018", "btAnnullaIspezione",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btAssegna]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtAssegna_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_ispezioni_impianti", "cpdettaglioispezione2018", "btAssegna", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btAssociaCodiceImpianto]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtAssociaCodiceImpianto_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_ispezioni_impianti", "cpdettaglioispezione2018", "btAssociaCodiceImpianto",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btConfermaConclusione2]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtConfermaConclusione2_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_ispezioni_impianti", "cpdettaglioispezione2018", "btConfermaConclusione2",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btAnnullaConclusione2]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtAnnullaConclusione2_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_ispezioni_impianti", "cpdettaglioispezione2018", "btAnnullaConclusione2",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btConfermaAssegnazione]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtConfermaAssegnazione_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_ispezioni_impianti", "cpdettaglioispezione2018", "btConfermaAssegnazione",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btAnnullaAssegnazione]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtAnnullaAssegnazione_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_ispezioni_impianti", "cpdettaglioispezione2018", "btAnnullaAssegnazione",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btCercaCodiceImpianto]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtCercaCodiceImpianto_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_ispezioni_impianti", "cpdettaglioispezione2018", "btCercaCodiceImpianto",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btNuovaRicercaCodiceImpianto]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtNuovaRicercaCodiceImpianto_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_ispezioni_impianti", "cpdettaglioispezione2018",
				"btNuovaRicercaCodiceImpianto", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btConfermaCodiceImpianto]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtConfermaCodiceImpianto_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_ispezioni_impianti", "cpdettaglioispezione2018", "btConfermaCodiceImpianto",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btAnnullaAssociazioneImpianto]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtAnnullaAssociazioneImpianto_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_ispezioni_impianti", "cpdettaglioispezione2018",
				"btAnnullaAssociazioneImpianto", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btSalvaIndietro]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtSalvaIndietro_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_ispezioni_impianti", "cpdettaglioispezione2018", "btSalvaIndietro",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btConfermaInvio]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtConfermaInvio_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_ispezioni_impianti", "cpdettaglioispezione2018", "btConfermaInvio",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btAnnullaInvio]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtAnnullaInvio_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_ispezioni_impianti", "cpdettaglioispezione2018", "btAnnullaInvio",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btConfermaAnnullaAll]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtConfermaAnnullaAll_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_ispezioni_impianti", "cpdettaglioispezione2018", "btConfermaAnnullaAll",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btAnnullaAnnullaAll]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtAnnullaAnnullaAll_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_ispezioni_impianti", "cpdettaglioispezione2018", "btAnnullaAnnullaAll",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btConfermaConclusione]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtConfermaConclusione_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_ispezioni_impianti", "cpdettaglioispezione2018", "btConfermaConclusione",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btAnnullaConclusione]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtAnnullaConclusione_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_ispezioni_impianti", "cpdettaglioispezione2018", "btAnnullaConclusione",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btConfermaAnnullamentoIspezione]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtConfermaAnnullamentoIspezione_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_ispezioni_impianti", "cpdettaglioispezione2018",
				"btConfermaAnnullamentoIspezione", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btAnnullaAnnullamentoIspezione]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtAnnullaAnnullamentoIspezione_CLICKED() throws CommandExecutionException {

		return handleEventInternal("elenco_ispezioni_impianti", "cpdettaglioispezione2018",
				"btAnnullaAnnullamentoIspezione", "CLICKED");

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
	 * al data-binding relativo al dataset DATASET del widget cbSecondoIspettore.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbSecondoIspettore_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoSecondiIspettori", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget provComp.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideProvComp_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoProvincePiemonteIstat", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget comComp.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideComComp_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoComuniPiemonteIstat", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget tbSazioni.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideTbSazioni_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoSanzioni", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget tbRapportiProva.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideTbRapportiProva_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoAllegatiIsp", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget tbAzioniSvolte.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideTbAzioniSvolte_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoAzioni", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbElencoIspettori.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbElencoIspettori_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoIspettori", "", false, false);
	}

	/**
	 * Gestione della validazione
	 */
	public void validate() {
		/*PROTECTED REGION ID(R-2108604832) ENABLED START*/
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
