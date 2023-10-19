package it.csi.sigit.sigitwebn.presentation.sigitwebn.action;

import java.util.*;

import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.validator.annotations.*;

import it.csi.sigit.sigitwebn.dto.*;

import it.csi.sigit.sigitwebn.presentation.sigitwebn.command.*;

import it.csi.sigit.sigitwebn.business.*;

/**
 * HomeAction Action Class.
 *
 * @author GuiGen
 */
@Validation()
public class HomeAction extends BaseAction<GlobalHomeModel> implements ModelDriven<GlobalHomeModel> {

	private GlobalHomeModel model;

	public GlobalHomeModel getModel() {
		return model;
	}

	public void setModel(GlobalHomeModel modello) {
		this.model = modello;
	}

	@Override
	public void setSession(Map session) {
		// TODO Auto-generated method stub
		super.setSession(session);
		if (model == null) {
			model = new GlobalHomeModel();
		}
		model.setSession(session);
	}

	private Map<String, JumpExtCommand> jumpExtCommands = new HashMap<String, JumpExtCommand>();

	public Map<String, JumpExtCommand> getJumpExtCommands() {
		return jumpExtCommands;
	}

	public void setJumpExtCommands(Map<String, JumpExtCommand> jumpExtCommands) {
		this.jumpExtCommands = jumpExtCommands;
	}

	/**
	 * classe model associata
	 */
	public Class modelClass() {

		return it.csi.sigit.sigitwebn.dto.GlobalHomeModel.class;

	}

	/**
	 *
	 * @return Il risultato delle azioni, SUCCESS altrimenti.
	 */
	public String execute() throws CommandExecutionException {

		LOG.debug("[HomeAction::execute] START");

		ICommand action = initCommand();
		String result = action.doCommand(this);
		if (result != null) {
			return result;
		} else {
			LOG.debug("[HomeAction::execute] END");
			return SUCCESS;
		}
	}

	/**
	 * Gestione della validazione
	 */
	public void validate() {
		/*PROTECTED REGION ID(R103397888) ENABLED START*/
		/* Inserire la validazione */
		/*PROTECTED REGION END*/
	}

	protected void dumpModel(boolean pre) {
		// metodo intenzionalmente vuoto
	}

	protected ICommand initCommand(String moduleName, String panelName, String widgName, String eventName) {
		// metodo intenzionalmente vuoto
		return null;
	}

	protected void doBeforeEventCommand() {
		// la home action e' globale: non sono previsti before/after event commands
	}

	protected void doAfterEventCommand() {
		// la home action e' globale: non sono previsti before/after event commands
	}

	/**
	 *	Metodo per la rimozione dalla sessione degli application data a scope
	 *  SAME_PAGE. 
	 */
	public void clearPageScopedAppData(String targetContentPanelName) {
		// TODO: nel caso dell'on-init command non si ha ancora un 
		// "content panel corrente" -> NOP
	}

	/**
	 * inizializza la struttura dei command da eseguire allo startup della sessione 
	 */
	private ICommand initCommand() {

		ICommand cmd = null;
		try {
			cmd = CommandFactory.getInstance().buildCmdStructure_internal(null, "global", "" + "_" + "APP_INIT");
		} catch (CommandExecutionException cee) {
			LOG.error("Errore imprevisto nella creazione dei comandi:" + cee.getMessage() + ", restituisco NOPCommand",
					cee);
			cmd = new NOPCommand();
		}
		return cmd;
	}

}
