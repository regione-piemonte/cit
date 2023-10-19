package it.csi.sigit.sigitweba.presentation.sigitweba.action;

import java.util.*;
import java.lang.reflect.Method;
import java.beans.BeanInfo;
import java.lang.reflect.InvocationTargetException;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;

import com.opensymphony.xwork2.ActionContext;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.apache.log4j.Logger;

import it.csi.sigit.sigitweba.util.*;
import it.csi.sigit.sigitweba.dto.*;
import it.csi.sigit.sigitweba.business.*;

import it.csi.sigit.sigitweba.presentation.sigitweba.command.*;
import it.csi.sigit.sigitweba.presentation.sigitweba.security.*;

import it.csi.sigit.sigitweba.presentation.sigitweba.interceptor.FatClientOnly;
import it.csi.sigit.sigitweba.presentation.uiutils.*;
import flexjson.JSON;

/**
 * AbstractCPAction e' la classe base delle action relative ai ContentPanel.
 * Tutte le action relative ai vari ContentPanel dovranno ereditare da questa
 * e dovranno implementare in proprio le funzionalit&agrave; specifiche della pagina. 
 * 
 * @author GuiGen
 */
public abstract class AbstractCPAction<T extends BaseSessionAwareDTO> extends BaseAction<T> {

	/**
	 * costante utilizzata dai metodi interni per inserire in sessione un comando di pulizia dati.
	 * Il richiamo del comando viene effettuato nel metodo execute().
	 */
	protected static final String PENDING_CLEAR_COMMAND_ATTRIBUTE = "_pending_clear_command_";

	/**
	 * restituisce il nome del content panel. Deve essere sovrascritto dalle sottocolassi.
	 */
	public abstract String getCPName();

	/**
	 * restituisce il nome del nanmespace che contiene il content panel. Deve essere sovrascritto dalle sottocolassi.
	 */
	public abstract String getCPNamespace();

	/**
	 * restituisce il nome completo del nanmespace che contiene il content panel (ovvero comprendente anche 
	 * il prefisso "base" o "secure" e il separatore "/". Deve essere sovrascritto dalle sottocolassi.
	 */
	public abstract String getCPFullNamespace();

	/**
	 * nome dell'evento implicito che viene scatenato al refresh della schermata.
	 */
	protected static final String IMPLICIT_EVENT_ON_REFRESH = "ON_REFRESH";

	/**
	 * nome dell'evento implicito che viene scatenato all'ingresso 
	 * nella schermata.
	 */
	protected static final String IMPLICIT_EVENT_ON_ENTER = "ON_ENTER";

	/**
	 * nome dell'evento implicito che viene scatenato al primo ingresso
	 * nella schermata.
	 */
	protected static final String IMPLICIT_EVENT_ON_INIT = "ON_INIT";

	/**
	 * nome dell'evento implicito che viene scatenato prima di ogni
	 * evento esplicito avvenuto nella schermata.
	 */
	protected static final String IMPLICIT_EVENT_BEFORE_EVENTS = "BEFORE_EVENTS";

	/**
	 * nome dell'evento implicito che viene scatenato dopo ogni
	 * evento esplicito avvenuto nella schermata.
	 */
	protected static final String IMPLICIT_EVENT_AFTER_EVENTS = "AFTER_EVENTS";

	/**
	 * Deve essere ridefinito in tutte le action associate a content panel.
	 * @return true se l'evento implicito di nome <i>implicitEventName</i> 
	 * e' previsto per la schermata
	 */
	protected abstract boolean isImplicitEventDefined(String implicitEventName);

	// ridefinizione dei metodi di verifica visibilita'/validazione
	// per supportare i security check

	/**
	 * Restituisce true se il widget e' abilitato.
	 * Il risultato e' condizionato da:
	 * - stato di default
	 * - stato comandato da OnOffCommand
	 * - stato comandato da ScreenStateCommand
	 * - security constraint
	 * @param cpName nome del content panel
	 * @param widgShortName nome del widget (se il nome termina con "_fictitious_" allora
	 *        il widget non deve essere considerato => restituisco sempre false)
	 */
	public boolean isWidgetDisabled(String cpName, String widgShortName) {
		// verifico se si tratta di un widget fittizio
		if (widgShortName.endsWith("_fictitious_")) {
			return false;
		}
		// ELSE...
		// recupero l'elenco del security constraint tramite l'apposita factory
		ConstraintFactory ctrFct = ConstraintFactory.getInstance();
		UISecConstraint ctr = null;
		try {
			ctr = ctrFct.buildCtrStructure_internal(("" + getCPNamespace()).toLowerCase(), cpName.toLowerCase(),
					widgShortName, "enabled");
		} catch (CommandExecutionException e) {
			LOG.error("[AbstractCPAction::isWidgetDisabled] errore durante verifica->disable", e);
			return true; // forzo la DISABILITAZIONE
		}
		//UISecConstraint ctr = allOnOffConstraints.get(widgShortName);
		if (ctr != null) {
			try {
				// se sono presenti dei constraint, li eseguo per conoscere lo stato
				// di abilitazione del widget
				return !ctr.verifyConstraint(getModel(), session, UISecConstraint.ONOFF_CONSTRAINED_BEHAVIOR,
						getSpringSecurityHelper());
			} catch (BEException ex) {
				LOG.error("[AbstractCPAction::isWidgetDisabled] errore durante verifica->disable", ex);
				return true; // forzo la DISABILITAZIONE
			}
		} else {
			// se non sono presenti constraint vale l'implementazione di default
			return super.isWidgetDisabled(cpName, widgShortName);
		}
	}

	/**
	 * Restituisce true se il widget e' visibile.
	 * Il risultato e' condizionato da:
	 * - stato di default
	 * - stato comandato da VisibilityCommand
	 * - stato comandato da ScreenStateCommand
	 * - security constraint
	 * @param cpName nome del content panel
	 * @param widgShortName nome del widget (se il nome termina con "_fictitious_" allora
	 *        il widget non deve essere considerato => restituisco sempre true)
	 */
	public boolean isWidgetVisible(String cpName, String widgShortName) {
		// verifico se si tratta di un widget fittizio
		if (widgShortName.endsWith("_fictitious_")) {
			return true;
		}
		// ELSE...
		// recupero l'elenco del security constraint tramite la apposita factory
		ConstraintFactory ctrFct = ConstraintFactory.getInstance();
		UISecConstraint ctr = null;
		try {
			ctr = ctrFct.buildCtrStructure_internal(("" + getCPNamespace()).toLowerCase(), cpName.toLowerCase(),
					widgShortName, "visible");
		} catch (CommandExecutionException e) {
			LOG.error("[AbstractCPAction::isWidgetVisible] errore durante verifica->hide", e);
			return false; // forzo l'invisibilita'
		}
		//UISecConstraint ctr = allVisibilityConstraints.get(widgShortName);
		if (ctr != null) {
			try {
				// se sono presenti dei constraint, li eseguo per conoscere lo stato
				// di visibilita' del widget
				return ctr.verifyConstraint(getModel(), session, UISecConstraint.VISIB_CONSTRAINED_BEHAVIOR,
						getSpringSecurityHelper());
			} catch (BEException ex) {
				LOG.error("[AbstractCPAction::isWidgetVisible] errore durante verifica->hide", ex);
				return false; // forzo l'invisibilita'
			}
		} else {
			// se non sono presenti constraint vale l'implementazione di default
			return super.isWidgetVisible(cpName, widgShortName);
		}
	}

	/**
	 * contiene le coppie <codice location, comando di jump corrispondente>
	 */
	private Map<String, JumpExtCommand> jumpExtCommands = new HashMap<String, JumpExtCommand>();

	/**
	 * contiene le coppie <codice location, comando di jump corrispondente>
	 */
	public Map<String, JumpExtCommand> getJumpExtCommands() {
		return jumpExtCommands;
	}

	/**
	 * contiene le coppie <codice location, comando di jump corrispondente>
	 */
	public void setJumpExtCommands(Map<String, JumpExtCommand> jumpExtCommands) {
		this.jumpExtCommands = jumpExtCommands;
	}

	/**
	 * Permette di marcare il content panel come gia' inizializzato
	 */
	public void markCPAsInitialized() {
		getSession().put(getCPName() + "_Initialized", Boolean.TRUE);
	}

	/**
	 * Permette di marcare il content panel come non ancora inizializzato
	 */
	public void markCPAsNotInitialized() {
		getSession().put(getCPName() + "_Initialized", Boolean.FALSE);
	}

	/**
	 * @return true se il content panel e' gia' stato inizializzato
	 */
	public boolean isCPAlreadyInitialized() {
		Boolean b = (java.lang.Boolean) (getSession().get(getCPName() + "_Initialized"));
		return b != null && b.booleanValue();
	}

	/**
	 * 
	 * @return true se si sta entrando nel content panel da un'altra schermata
	 */
	public boolean isEntering() {
		return (null == getCurrentContentPanel()
				|| (null != getCurrentContentPanel() && !getCPName().equalsIgnoreCase(getCurrentContentPanel())));
	}

	/**
	 * Questo metodo, che deve essere ridefinito in tutte le schermate, serve per capire se
	 * il comando di ON_REFRESH deve essere eseguito nella nuova modalita' (quella prevista
	 * daqi CPCommands) oppure ad ogni interazione (modalita' legacy prevista prima dell'
	 * introduzione dei CPCommands.
	 */
	protected abstract boolean isOnRefreshLegacyMode();

	/**
	 * Decide se deve essere eseguita la logica (eventualmente) modellata come evento implicito di ON_REFRESH. 
	 * La logica applicativa e' eseguita ad ogni azione di interazione utente eseguita sulla schermata 
	 * (ingresso nella schermata, evento di interazione con un widget, ...), con le seguenti eccezioni: 
	 * - Se in pagina viene inserito un CPCommand ON_INIT allora l'ON_REFRESH non verra' eseguito al primo accesso alla schermata. 
	 * - Se in pagina viene inserito un CPCommand ON_ENTER allora l'ON_REFRESH non verra' eseguito in concomitanza al nuovo ingresso al ContentPanel.
	 * Queste eccezioni non valgono se il comando di ON_REFRESH e' stato modellato in modalita' legacy (non come CPCommand).  
	 */
	protected boolean mustExecuteOnRefreshCommand() {
		if (isOnRefreshLegacyMode()) {
			return true;
		} else {
			ICommand onInitCmd = initOnInitCPCommand();
			ICommand onEnterCmd = initOnEnterCPCommand();
			return (onInitCmd == null && onEnterCmd == null)
					|| ((onInitCmd != null || onEnterCmd != null) && !isEntering());
		}
	}

	/**
	 * inizializza la struttura dei command da eseguire per ciascun event handler 
	 * di ciascun widget
	 */
	protected final ICommand initCommand(String moduleName, String panelName, String sourceWidget, String eventType) {
		ICommand cmd = null;
		try {
			// carica la struttura di comandi dal file JSON corrispondente
			cmd = CommandFactory.getInstance().buildCmdStructure_internal(moduleName, getCPName().toLowerCase(),
					sourceWidget + "_" + eventType);
		} catch (CommandExecutionException cee) {
			LOG.error("Errore imprevisto nella creazione dei comandi:" + cee.getMessage() + ", restituisco NOPCommand",
					cee);
			cmd = new NOPCommand();
		}
		return cmd;
	}

	/**
	 * inizializza la struttura dei command da eseguire al refresh del pannello
	 */
	protected ICommand initOnRefreshCommand() {

		ICommand cmd = null;
		if (this.isImplicitEventDefined(IMPLICIT_EVENT_ON_REFRESH)) {
			try {
				cmd = CommandFactory.getInstance().buildCmdStructure_internal(getCPNamespace().toLowerCase(),
						getCPName().toLowerCase(), "" + "_" + "ON_REFRESH");
			} catch (CommandExecutionException cee) {
				LOG.error("Errore imprevisto nella creazione dei comandi:" + cee.getMessage()
						+ ", restituisco NOPCommand", cee);
				cmd = new NOPCommand();
			}
		} else {
			cmd = new NOPCommand();
		}
		return cmd;
	}

	/**
	 * inizializza la struttura dei command da eseguire al refresh del pannello
	 */
	protected ICommand initOnInitCPCommand() {
		ICommand cmd = null;
		if (this.isImplicitEventDefined(IMPLICIT_EVENT_ON_INIT)) {
			try {
				cmd = CommandFactory.getInstance().buildCmdStructure_internal(getCPNamespace().toLowerCase(),
						getCPName().toLowerCase(), "" + "_" + "ON_INIT");
			} catch (CommandExecutionException cee) {
				LOG.error("Errore imprevisto nella creazione dei comandi:" + cee.getMessage()
						+ ", restituisco NOPCommand", cee);
				cmd = new NOPCommand();
			}
		} else {
			cmd = new NOPCommand();
		}
		return cmd;
	}

	/**
	 * inizializza la struttura dei command da eseguire al refresh del pannello
	 */
	protected ICommand initOnEnterCPCommand() {
		ICommand cmd = null;
		if (this.isImplicitEventDefined(IMPLICIT_EVENT_ON_ENTER)) {
			try {
				cmd = CommandFactory.getInstance().buildCmdStructure_internal(getCPNamespace().toLowerCase(),
						getCPName().toLowerCase(), "" + "_" + "ON_ENTER");
			} catch (CommandExecutionException cee) {
				LOG.error("Errore imprevisto nella creazione dei comandi:" + cee.getMessage()
						+ ", restituisco NOPCommand", cee);
				cmd = new NOPCommand();
			}
		} else {
			cmd = new NOPCommand();
		}
		return cmd;
	}

	/**
	 * inizializza la struttura dei command da eseguire al refresh del pannello
	 */
	protected ICommand initBeforeEventCPCommand() {
		ICommand cmd = null;
		if (this.isImplicitEventDefined(IMPLICIT_EVENT_BEFORE_EVENTS)) {
			try {
				cmd = CommandFactory.getInstance().buildCmdStructure_internal(getCPNamespace().toLowerCase(),
						getCPName().toLowerCase(), "" + "_" + "BEFORE_EVENTS");
			} catch (CommandExecutionException cee) {
				LOG.error("Errore imprevisto nella creazione dei comandi:" + cee.getMessage()
						+ ", restituisco NOPCommand", cee);
				cmd = new NOPCommand();
			}
		} else {
			cmd = new NOPCommand();
		}
		return cmd;

	}

	/**
	 * inizializza la struttura dei command da eseguire al refresh del pannello
	 */
	protected ICommand initAfterEventCPCommand() {
		ICommand cmd = null;
		if (this.isImplicitEventDefined(IMPLICIT_EVENT_AFTER_EVENTS)) {
			try {
				cmd = CommandFactory.getInstance().buildCmdStructure_internal(getCPNamespace().toLowerCase(),
						getCPName().toLowerCase(), "" + "_" + "AFTER_EVENTS");
			} catch (CommandExecutionException cee) {
				LOG.error("Errore imprevisto nella creazione dei comandi:" + cee.getMessage()
						+ ", restituisco NOPCommand", cee);
				cmd = new NOPCommand();
			}
		} else {
			cmd = new NOPCommand();
		}
		return cmd;

	}

	/**
	 * comandi da eseguire prima di ciascun evento
	 */
	protected void doBeforeEventCommand() throws CommandExecutionException {
		// comandi da eseguire prima dei comandi associati ad ogni evento
		ICommand cmdBeforeEvent = initBeforeEventCPCommand();
		if (cmdBeforeEvent != null) {
			cmdBeforeEvent.doCommand(this);
		}

	}

	/**
	 * comandi da eseguire dopo ciascun evento
	 */
	protected void doAfterEventCommand() throws CommandExecutionException {
		// comandi da eseguire prima dei comandi associati ad ogni evento
		ICommand cmdAfterEvent = initAfterEventCPCommand();
		if (cmdAfterEvent != null) {
			cmdAfterEvent.doCommand(this);
		}
	}

	/**
	 * viene richiamato prima di ogni metodo della action. Utilizzato per l'implementazione degli eventi 
	 * del ContentPanel
	 */
	public void prepare() throws CommandExecutionException {
		super.prepare();
		// cancellazione eventuale degli errori di conversione non desiderati
		clearConversionErrorsIfSkipValidation();

		ActionContext ctx = ActionContext.getContext();
		String methodName = ctx.getActionInvocation().getProxy().getMethod();

		boolean onRefreshEvent = true;

		ICommand cmdOnEnter = initOnEnterCPCommand();
		ICommand cmdOnInit = initOnInitCPCommand();
		ICommand cmdOnRefresh = initOnRefreshCommand();

		// CpCommand.ON_INIT: comandi eseguiti al primo accesso per sessione applicativa
		boolean isOnInitCmdExecuted = false;
		if (!isCPAlreadyInitialized()) {
			if (cmdOnInit != null) {
				cmdOnInit.doCommand(this);
				isOnInitCmdExecuted = true;
			}
			markCPAsInitialized(); // marca in ogni caso come inizializzato
		}

		onRefreshEvent = mustExecuteOnRefreshCommand();

		// CpCommand.ON_REFRESH: comandi eseguiti ad ogni refresh per sessione applicativa
		if (onRefreshEvent) {
			if (methodName.startsWith("execute")
					|| (!methodName.startsWith("exec") && !methodName.startsWith("provide"))) {
				if (cmdOnRefresh != null) {
					cmdOnRefresh.doCommand(this);
				}
			}
		}

		// comandi eseguiti ad ogni refresh solo se non sono in modalita' fatclient
		if (onRefreshEvent) {
			if (methodName.startsWith("execute")
					|| (!methodName.startsWith("exec") && !methodName.startsWith("provide"))) {
				// comandi eseguiti ad ogni refresh solo per i metodi non fatclient
				ICommand cmd = initOnRefreshCommand();
				if (cmd != null) {
					cmd.doCommand(this);
				}
			}
		}
	}

	/**
	 * I singoli eventi sui singoli widget sono gestiti dai metodi specifici   
	 * @return SUCCESS.
	 */
	@SkipValidation
	public String execute() throws CommandExecutionException {
		// esegue eventuali comandi di clear appdata
		ICommand clearCmd = (ICommand) session.get(PENDING_CLEAR_COMMAND_ATTRIBUTE);
		if (clearCmd != null) {
			// esegue la rimozione degli appdata a scope page, tramite l'apposito comando
			clearCmd.doCommand(this);
			// elimina il comando dalla sessione, in quanto ormai eseguito
			session.remove(PENDING_CLEAR_COMMAND_ATTRIBUTE);
		}

		if (isEntering()) {
			// CpCommand OnEnter
			//// inizializzazione
			ICommand cmdOnEnter = initOnEnterCPCommand();
			//// esecuzione
			if (cmdOnEnter != null) {
				cmdOnEnter.doCommand(this);
			}
		}

		// imposta il nome del content panel corrente
		setCurrentContentPanel(getCPName());
		return SUCCESS;
	}

	/**  */
	protected void dumpModel(boolean pre) {
		LOG.debug("[AbstractCPAction::dumpmodel] START");

		LOG.debug("[AbstractCPAction::dumpmodel] #### DUMP del model della action " + this.getClass()
				+ (pre ? " prima dell'azione" : " dopo l'azione"));
		LOG.debug("[AbstractCPAction::dumpmodel] [a] campi pubblici del model");
		try {
			java.beans.BeanInfo bi = java.beans.Introspector.getBeanInfo(this.getClass());
			java.beans.PropertyDescriptor[] props = bi.getPropertyDescriptors();
			for (int i = 0; i < props.length; i++) {
				java.beans.PropertyDescriptor pd = props[i];
				java.lang.reflect.Method m = pd.getReadMethod();
				if (m != null) {
					Object pval = m.invoke(this, new Object[]{});
					LOG.debug("[AbstractCPAction::dumpmodel] " + pd.getName() + ":" + pval);
				}
			}
		} catch (IllegalAccessException e) {
			LOG.error("[AbstractCPAction::dumpmodel] Errore nel dump" + e + ", ignoro", e);
		} catch (InvocationTargetException e) {
			LOG.error("[AbstractCPAction::dumpmodel] Errore nel dump" + e + ", ignoro", e);
		} catch (IntrospectionException e) {
			LOG.error("[AbstractCPAction::dumpmodel] Errore nel dump" + e + ", ignoro", e);
		}
		LOG.debug("[AbstractCPAction::dumpmodel] [b] stato dei widget");
		Object cpWidgetStatus = session.get(getCPName());
		LOG.debug("[AbstractCPAction::dumpmodel] " + cpWidgetStatus);
		LOG.debug("[AbstractCPAction::dumpmodel] [c] sessione");
		LOG.debug("[AbstractCPAction::dumpmodel] " + session);
	}
}
