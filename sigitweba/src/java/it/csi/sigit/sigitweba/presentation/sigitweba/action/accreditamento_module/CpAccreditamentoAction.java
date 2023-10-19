package it.csi.sigit.sigitweba.presentation.sigitweba.action.accreditamento_module;

import java.util.*;

import java.lang.reflect.InvocationTargetException;
import java.beans.IntrospectionException;

import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.validator.annotations.*;
import com.opensymphony.xwork2.conversion.annotations.*;
import com.opensymphony.xwork2.ActionContext;

import it.csi.sigit.sigitweba.util.*;
import it.csi.sigit.sigitweba.dto.*;
import it.csi.sigit.sigitweba.dto.accreditamento_module.CpAccreditamentoModel;

import it.csi.sigit.sigitweba.presentation.sigitweba.command.*;

import it.csi.sigit.sigitweba.presentation.sigitweba.security.*;

import it.csi.sigit.sigitweba.business.*;

import it.csi.sigit.sigitweba.presentation.sigitweba.action.*;

import it.csi.sigit.sigitweba.presentation.sigitweba.action.accreditamento_module.states.CpAccreditamentoScreenStates;

import it.csi.sigit.sigitweba.presentation.sigitweba.interceptor.MethodProtection;

import it.csi.sigit.sigitweba.presentation.sigitweba.interceptor.FatClientOnly;
import it.csi.sigit.sigitweba.presentation.uiutils.*;
import flexjson.JSON;

/**
 * CpAccreditamentoAction Action Class.
 *
 * @author GuiGen
 */
@Validation()
@Conversion()
public class CpAccreditamentoAction extends AbstractCPAction<CpAccreditamentoModel>
		implements
			Preparable,
			ModelDriven<CpAccreditamentoModel> {

	/**
	 * Il modello del content panel.
	 * Viene riempito a fornte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	private CpAccreditamentoModel model;

	/**
	 * Il modello del content panel.
	 * Viene riempito a fornte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	public CpAccreditamentoModel getModel() {
		return model;
	}

	/**
	 * Il modello del content panel.
	 * Viene riempito a fronte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	@VisitorFieldValidator(message = "", appendPrefix = false)
	public void setModel(CpAccreditamentoModel modello) {
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
			model = new CpAccreditamentoModel();
		}
		// associo la sessione applicativa al modello, in modo che
		// possa implementare l'accesso agli application data
		// di scope session/same page
		model.setSession(session);
	}

	/**
	 * nome del content panel
	 */
	private static final String CP_NAME = "cpAccreditamento";

	/**
	 * nome del namespace che contiene il content panel
	 */
	private static final String CP_NAMESPACE = "accreditamento_module";

	/**
	 * nome completo del namespace che contiene il content panel
	 */
	private static final String CP_FULL_NAMESPACE = "/base/accreditamento_module";

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

	private static final String URL_BACK_COMMAND = "/base/accreditamento_module/" + CP_NAME;

	/**
	 * classe model associata al ContentPanel
	 */
	public Class modelClass() {
		return it.csi.sigit.sigitweba.dto.accreditamento_module.CpAccreditamentoModel.class;
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

		if (AbstractCPAction.IMPLICIT_EVENT_ON_INIT.equals(implicitEventName)) //NOSONAR
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
	 * Gestione dell'evento VALUE_CHANGED sul widget [cbIndirizzoEst]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleCbIndirizzoEst_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("accreditamento_module", "cpaccreditamento", "cbIndirizzoEst", "VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento VALUE_CHANGED sul widget [cbAccredProvincia]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleCbAccredProvincia_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("accreditamento_module", "cpaccreditamento", "cbAccredProvincia", "VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [bCerca]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBCerca_CLICKED() throws CommandExecutionException {

		return handleEventInternal("accreditamento_module", "cpaccreditamento", "bCerca", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [bNuovaRic]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBNuovaRic_CLICKED() throws CommandExecutionException {

		return handleEventInternal("accreditamento_module", "cpaccreditamento", "bNuovaRic", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [bVerifica]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBVerifica_CLICKED() throws CommandExecutionException {

		return handleEventInternal("accreditamento_module", "cpaccreditamento", "bVerifica", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [cbotSalva]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleCbotSalva_CLICKED() throws CommandExecutionException {

		return handleEventInternal("accreditamento_module", "cpaccreditamento", "cbotSalva", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btInsertFormazione]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtInsertFormazione_CLICKED() throws CommandExecutionException {

		return handleEventInternal("accreditamento_module", "cpaccreditamento", "btInsertFormazione", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btSalvaFormazione]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtSalvaFormazione_CLICKED() throws CommandExecutionException {

		return handleEventInternal("accreditamento_module", "cpaccreditamento", "btSalvaFormazione", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btAnnullaFormazione]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtAnnullaFormazione_CLICKED() throws CommandExecutionException {

		return handleEventInternal("accreditamento_module", "cpaccreditamento", "btAnnullaFormazione", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btInsertImpresa]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtInsertImpresa_CLICKED() throws CommandExecutionException {

		return handleEventInternal("accreditamento_module", "cpaccreditamento", "btInsertImpresa", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btModImpresa]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtModImpresa_CLICKED() throws CommandExecutionException {

		return handleEventInternal("accreditamento_module", "cpaccreditamento", "btModImpresa", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btCessaLegame]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtCessaLegame_CLICKED() throws CommandExecutionException {

		return handleEventInternal("accreditamento_module", "cpaccreditamento", "btCessaLegame", "CLICKED");

	}

	/**
	 * Gestione dell'evento VALUE_CHANGED sul widget [cbImpresaIndirizzoEst]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleCbImpresaIndirizzoEst_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("accreditamento_module", "cpaccreditamento", "cbImpresaIndirizzoEst",
				"VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento VALUE_CHANGED sul widget [cbImpresaProvincia]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleCbImpresaProvincia_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("accreditamento_module", "cpaccreditamento", "cbImpresaProvincia", "VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btImpresaCercaIndirizzo]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtImpresaCercaIndirizzo_CLICKED() throws CommandExecutionException {

		return handleEventInternal("accreditamento_module", "cpaccreditamento", "btImpresaCercaIndirizzo", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btImpresaNuovaRicerca]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtImpresaNuovaRicerca_CLICKED() throws CommandExecutionException {

		return handleEventInternal("accreditamento_module", "cpaccreditamento", "btImpresaNuovaRicerca", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btImpresaVerificaEmail]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtImpresaVerificaEmail_CLICKED() throws CommandExecutionException {

		return handleEventInternal("accreditamento_module", "cpaccreditamento", "btImpresaVerificaEmail", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btAnnulla]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtAnnulla_CLICKED() throws CommandExecutionException {

		return handleEventInternal("accreditamento_module", "cpaccreditamento", "btAnnulla", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btSalvaImpresa]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtSalvaImpresa_CLICKED() throws CommandExecutionException {

		return handleEventInternal("accreditamento_module", "cpaccreditamento", "btSalvaImpresa", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btAnnullaConferma]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtAnnullaConferma_CLICKED() throws CommandExecutionException {

		return handleEventInternal("accreditamento_module", "cpaccreditamento", "btAnnullaConferma", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btConfermaCessLegame]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtConfermaCessLegame_CLICKED() throws CommandExecutionException {

		return handleEventInternal("accreditamento_module", "cpaccreditamento", "btConfermaCessLegame", "CLICKED");

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
	 * al data-binding relativo al dataset DATASET del widget cbAccredProvincia.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbAccredProvincia_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataprovince", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbAccredComune.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbAccredComune_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDatacomuni", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbElencoIndirizzi.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbElencoIndirizzi_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoIndirizziPF", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget tbFormazione.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideTbFormazione_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDatalistFormazioni", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget tbImprese.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideTbImprese_DATASET() throws CommandExecutionException {

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

		return provideDataInternal("appDataelencoSigleRea", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbImpresaProvincia.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbImpresaProvincia_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoProvinceIT", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbImpresaComune.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbImpresaComune_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoComuniPG", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbImpresaIndirizzo.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbImpresaIndirizzo_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoIndirizziPG", "", false, false);
	}

	/**
	 * Gestione della validazione
	 */
	public void validate() {
		/*PROTECTED REGION ID(R1382771591) ENABLED START*/
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
