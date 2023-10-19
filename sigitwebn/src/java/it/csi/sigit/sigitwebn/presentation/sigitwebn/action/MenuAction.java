package it.csi.sigit.sigitwebn.presentation.sigitwebn.action;

import java.util.*;

import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.validator.annotations.*;

import it.csi.sigit.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.*;
import it.csi.sigit.sigitwebn.presentation.sigitwebn.command.*;
import it.csi.sigit.sigitwebn.presentation.sigitwebn.interceptor.FatClientOnly;

/**
 * MenuAction Action Class.
 *
 * @author GuiGen
 */
@Validation()
public class MenuAction extends BaseAction<GlobalMenuModel> implements ModelDriven<GlobalMenuModel> {

	private GlobalMenuModel model;

	public GlobalMenuModel getModel() {
		return model;
	}

	public void setModel(GlobalMenuModel modello) {
		this.model = modello;
	}

	@Override
	public void setSession(Map session) {
		// TODO Auto-generated method stub
		super.setSession(session);
		if (model == null) {
			model = new GlobalMenuModel();
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
		return it.csi.sigit.sigitwebn.dto.GlobalMenuModel.class;
	}

	/**
	 *
	 * @return Il risultato delle azioni, SUCCESS altrimenti.
	 */
	@SkipValidation
	public String execute() throws CommandExecutionException {
		return SUCCESS;
	}

	/**
	 * 
	 * @return SUCCESS result.
	 */
	public String goToMenuHome() throws CommandExecutionException {

		// gestione degli eventi di tipo CLICKED
		ICommand action = initCommand(null, "global", "menuHome", "CLICKED");
		String result = action.doCommand(this);
		if (result != null) {
			if (LOG.isDebugEnabled()) {
				LOG.debug("[MenuAction::goToMenuHome] returning result [" + result + "]");
			}
			setActiveMenu("menuHome");
			return result;
		} else {
			if (LOG.isDebugEnabled()) {
				LOG.debug("[MenuAction::goToMenuHome] returning default result [SUCCESS]");
			}
			setActiveMenu("menuHome");
			return SUCCESS;
		}
	}

	/**
	 * 
	 * @return SUCCESS result.
	 */
	public String goToMenuRuolo() throws CommandExecutionException {

		// gestione degli eventi di tipo CLICKED
		ICommand action = initCommand(null, "global", "menuRuolo", "CLICKED");
		String result = action.doCommand(this);
		if (result != null) {
			if (LOG.isDebugEnabled()) {
				LOG.debug("[MenuAction::goToMenuRuolo] returning result [" + result + "]");
			}
			setActiveMenu("menuRuolo");
			return result;
		} else {
			if (LOG.isDebugEnabled()) {
				LOG.debug("[MenuAction::goToMenuRuolo] returning default result [SUCCESS]");
			}
			setActiveMenu("menuRuolo");
			return SUCCESS;
		}
	}

	/**
	 * 
	 * @return SUCCESS result.
	 */
	public String goToMenuCodImp() throws CommandExecutionException {

		// gestione degli eventi di tipo CLICKED
		ICommand action = initCommand(null, "global", "menuCodImp", "CLICKED");
		String result = action.doCommand(this);
		if (result != null) {
			if (LOG.isDebugEnabled()) {
				LOG.debug("[MenuAction::goToMenuCodImp] returning result [" + result + "]");
			}
			setActiveMenu("menuCodImp");
			return result;
		} else {
			if (LOG.isDebugEnabled()) {
				LOG.debug("[MenuAction::goToMenuCodImp] returning default result [SUCCESS]");
			}
			setActiveMenu("menuCodImp");
			return SUCCESS;
		}
	}

	/**
	 * 
	 * @return SUCCESS result.
	 */
	public String goToMenuAcquistaBollini() throws CommandExecutionException {

		// gestione degli eventi di tipo CLICKED
		ICommand action = initCommand(null, "global", "menuAcquistaBollini", "CLICKED");
		String result = action.doCommand(this);
		if (result != null) {
			if (LOG.isDebugEnabled()) {
				LOG.debug("[MenuAction::goToMenuAcquistaBollini] returning result [" + result + "]");
			}
			setActiveMenu("menuAcquistaBollini");
			return result;
		} else {
			if (LOG.isDebugEnabled()) {
				LOG.debug("[MenuAction::goToMenuAcquistaBollini] returning default result [SUCCESS]");
			}
			setActiveMenu("menuAcquistaBollini");
			return SUCCESS;
		}
	}

	/**
	 * 
	 * @return SUCCESS result.
	 */
	public String goToMenuSubentro() throws CommandExecutionException {

		// gestione degli eventi di tipo CLICKED
		ICommand action = initCommand(null, "global", "menuSubentro", "CLICKED");
		String result = action.doCommand(this);
		if (result != null) {
			if (LOG.isDebugEnabled()) {
				LOG.debug("[MenuAction::goToMenuSubentro] returning result [" + result + "]");
			}
			setActiveMenu("menuSubentro");
			return result;
		} else {
			if (LOG.isDebugEnabled()) {
				LOG.debug("[MenuAction::goToMenuSubentro] returning default result [SUCCESS]");
			}
			setActiveMenu("menuSubentro");
			return SUCCESS;
		}
	}

	/**
	 * 
	 * @return SUCCESS result.
	 */
	public String goToMenuDelega() throws CommandExecutionException {

		// gestione degli eventi di tipo CLICKED
		ICommand action = initCommand(null, "global", "menuDelega", "CLICKED");
		String result = action.doCommand(this);
		if (result != null) {
			if (LOG.isDebugEnabled()) {
				LOG.debug("[MenuAction::goToMenuDelega] returning result [" + result + "]");
			}
			setActiveMenu("menuDelega");
			return result;
		} else {
			if (LOG.isDebugEnabled()) {
				LOG.debug("[MenuAction::goToMenuDelega] returning default result [SUCCESS]");
			}
			setActiveMenu("menuDelega");
			return SUCCESS;
		}
	}

	/**
	 * 
	 * @return SUCCESS result.
	 */
	public String goToMenuIncaricoCat() throws CommandExecutionException {

		// gestione degli eventi di tipo CLICKED
		ICommand action = initCommand(null, "global", "menuIncaricoCat", "CLICKED");
		String result = action.doCommand(this);
		if (result != null) {
			if (LOG.isDebugEnabled()) {
				LOG.debug("[MenuAction::goToMenuIncaricoCat] returning result [" + result + "]");
			}
			setActiveMenu("menuIncaricoCat");
			return result;
		} else {
			if (LOG.isDebugEnabled()) {
				LOG.debug("[MenuAction::goToMenuIncaricoCat] returning default result [SUCCESS]");
			}
			setActiveMenu("menuIncaricoCat");
			return SUCCESS;
		}
	}

	/**
	 * 
	 * @return SUCCESS result.
	 */
	public String goToMenuTerzoResp() throws CommandExecutionException {

		// gestione degli eventi di tipo CLICKED
		ICommand action = initCommand(null, "global", "menuTerzoResp", "CLICKED");
		String result = action.doCommand(this);
		if (result != null) {
			if (LOG.isDebugEnabled()) {
				LOG.debug("[MenuAction::goToMenuTerzoResp] returning result [" + result + "]");
			}
			setActiveMenu("menuTerzoResp");
			return result;
		} else {
			if (LOG.isDebugEnabled()) {
				LOG.debug("[MenuAction::goToMenuTerzoResp] returning default result [SUCCESS]");
			}
			setActiveMenu("menuTerzoResp");
			return SUCCESS;
		}
	}

	/**
	 * 
	 * @return SUCCESS result.
	 */
	public String goToMenuImpianto() throws CommandExecutionException {

		// gestione degli eventi di tipo CLICKED
		ICommand action = initCommand(null, "global", "menuImpianto", "CLICKED");
		String result = action.doCommand(this);
		if (result != null) {
			if (LOG.isDebugEnabled()) {
				LOG.debug("[MenuAction::goToMenuImpianto] returning result [" + result + "]");
			}
			setActiveMenu("menuImpianto");
			return result;
		} else {
			if (LOG.isDebugEnabled()) {
				LOG.debug("[MenuAction::goToMenuImpianto] returning default result [SUCCESS]");
			}
			setActiveMenu("menuImpianto");
			return SUCCESS;
		}
	}

	/**
	 * 
	 * @return SUCCESS result.
	 */
	public String goToMenuAllegati() throws CommandExecutionException {

		// gestione degli eventi di tipo CLICKED
		ICommand action = initCommand(null, "global", "menuAllegati", "CLICKED");
		String result = action.doCommand(this);
		if (result != null) {
			if (LOG.isDebugEnabled()) {
				LOG.debug("[MenuAction::goToMenuAllegati] returning result [" + result + "]");
			}
			setActiveMenu("menuAllegati");
			return result;
		} else {
			if (LOG.isDebugEnabled()) {
				LOG.debug("[MenuAction::goToMenuAllegati] returning default result [SUCCESS]");
			}
			setActiveMenu("menuAllegati");
			return SUCCESS;
		}
	}

	/**
	 * 
	 * @return SUCCESS result.
	 */
	public String goToMenuImportMassivo() throws CommandExecutionException {

		// gestione degli eventi di tipo CLICKED
		ICommand action = initCommand(null, "global", "menuImportMassivo", "CLICKED");
		String result = action.doCommand(this);
		if (result != null) {
			if (LOG.isDebugEnabled()) {
				LOG.debug("[MenuAction::goToMenuImportMassivo] returning result [" + result + "]");
			}
			setActiveMenu("menuImportMassivo");
			return result;
		} else {
			if (LOG.isDebugEnabled()) {
				LOG.debug("[MenuAction::goToMenuImportMassivo] returning default result [SUCCESS]");
			}
			setActiveMenu("menuImportMassivo");
			return SUCCESS;
		}
	}

	/**
	 * 
	 * @return SUCCESS result.
	 */
	public String goToMenuRicercaAvanzataImp() throws CommandExecutionException {

		// gestione degli eventi di tipo CLICKED
		ICommand action = initCommand(null, "global", "menuRicercaAvanzataImp", "CLICKED");
		String result = action.doCommand(this);
		if (result != null) {
			if (LOG.isDebugEnabled()) {
				LOG.debug("[MenuAction::goToMenuRicercaAvanzataImp] returning result [" + result + "]");
			}
			setActiveMenu("menuRicercaAvanzataImp");
			return result;
		} else {
			if (LOG.isDebugEnabled()) {
				LOG.debug("[MenuAction::goToMenuRicercaAvanzataImp] returning default result [SUCCESS]");
			}
			setActiveMenu("menuRicercaAvanzataImp");
			return SUCCESS;
		}
	}

	/**
	 * 
	 * @return SUCCESS result.
	 */
	public String goToMenuDatiImpresa() throws CommandExecutionException {

		// gestione degli eventi di tipo CLICKED
		ICommand action = initCommand(null, "global", "menuDatiImpresa", "CLICKED");
		String result = action.doCommand(this);
		if (result != null) {
			if (LOG.isDebugEnabled()) {
				LOG.debug("[MenuAction::goToMenuDatiImpresa] returning result [" + result + "]");
			}
			setActiveMenu("menuDatiImpresa");
			return result;
		} else {
			if (LOG.isDebugEnabled()) {
				LOG.debug("[MenuAction::goToMenuDatiImpresa] returning default result [SUCCESS]");
			}
			setActiveMenu("menuDatiImpresa");
			return SUCCESS;
		}
	}

	/**
	 * 
	 * @return SUCCESS result.
	 */
	public String goToMenuExportMassivo() throws CommandExecutionException {

		// gestione degli eventi di tipo CLICKED
		ICommand action = initCommand(null, "global", "menuExportMassivo", "CLICKED");
		String result = action.doCommand(this);
		if (result != null) {
			if (LOG.isDebugEnabled()) {
				LOG.debug("[MenuAction::goToMenuExportMassivo] returning result [" + result + "]");
			}
			setActiveMenu("menuExportMassivo");
			return result;
		} else {
			if (LOG.isDebugEnabled()) {
				LOG.debug("[MenuAction::goToMenuExportMassivo] returning default result [SUCCESS]");
			}
			setActiveMenu("menuExportMassivo");
			return SUCCESS;
		}
	}

	/**
	 * 
	 * @return SUCCESS result.
	 */
	public String goToMenuBackOffice() throws CommandExecutionException {

		// gestione degli eventi di tipo CLICKED
		ICommand action = initCommand(null, "global", "menuBackOffice", "CLICKED");
		String result = action.doCommand(this);
		if (result != null) {
			if (LOG.isDebugEnabled()) {
				LOG.debug("[MenuAction::goToMenuBackOffice] returning result [" + result + "]");
			}
			setActiveMenu("menuBackOffice");
			return result;
		} else {
			if (LOG.isDebugEnabled()) {
				LOG.debug("[MenuAction::goToMenuBackOffice] returning default result [SUCCESS]");
			}
			setActiveMenu("menuBackOffice");
			return SUCCESS;
		}
	}

	/**
	 * 
	 * @return SUCCESS result.
	 */
	public String goToMenuRicercaVerifiche() throws CommandExecutionException {

		// gestione degli eventi di tipo CLICKED
		ICommand action = initCommand(null, "global", "menuRicercaVerifiche", "CLICKED");
		String result = action.doCommand(this);
		if (result != null) {
			if (LOG.isDebugEnabled()) {
				LOG.debug("[MenuAction::goToMenuRicercaVerifiche] returning result [" + result + "]");
			}
			setActiveMenu("menuRicercaVerifiche");
			return result;
		} else {
			if (LOG.isDebugEnabled()) {
				LOG.debug("[MenuAction::goToMenuRicercaVerifiche] returning default result [SUCCESS]");
			}
			setActiveMenu("menuRicercaVerifiche");
			return SUCCESS;
		}
	}

	/**
	 * 
	 * @return SUCCESS result.
	 */
	public String goToMenuRicercaAccertamenti() throws CommandExecutionException {

		// gestione degli eventi di tipo CLICKED
		ICommand action = initCommand(null, "global", "menuRicercaAccertamenti", "CLICKED");
		String result = action.doCommand(this);
		if (result != null) {
			if (LOG.isDebugEnabled()) {
				LOG.debug("[MenuAction::goToMenuRicercaAccertamenti] returning result [" + result + "]");
			}
			setActiveMenu("menuRicercaAccertamenti");
			return result;
		} else {
			if (LOG.isDebugEnabled()) {
				LOG.debug("[MenuAction::goToMenuRicercaAccertamenti] returning default result [SUCCESS]");
			}
			setActiveMenu("menuRicercaAccertamenti");
			return SUCCESS;
		}
	}

	/**
	 * 
	 * @return SUCCESS result.
	 */
	public String goToMenuRicercaIspezioni() throws CommandExecutionException {

		// gestione degli eventi di tipo CLICKED
		ICommand action = initCommand(null, "global", "menuRicercaIspezioni", "CLICKED");
		String result = action.doCommand(this);
		if (result != null) {
			if (LOG.isDebugEnabled()) {
				LOG.debug("[MenuAction::goToMenuRicercaIspezioni] returning result [" + result + "]");
			}
			setActiveMenu("menuRicercaIspezioni");
			return result;
		} else {
			if (LOG.isDebugEnabled()) {
				LOG.debug("[MenuAction::goToMenuRicercaIspezioni] returning default result [SUCCESS]");
			}
			setActiveMenu("menuRicercaIspezioni");
			return SUCCESS;
		}
	}

	/**
	 * 
	 * @return SUCCESS result.
	 */
	public String goToMenuRicercaSanzioni() throws CommandExecutionException {

		// gestione degli eventi di tipo CLICKED
		ICommand action = initCommand(null, "global", "menuRicercaSanzioni", "CLICKED");
		String result = action.doCommand(this);
		if (result != null) {
			if (LOG.isDebugEnabled()) {
				LOG.debug("[MenuAction::goToMenuRicercaSanzioni] returning result [" + result + "]");
			}
			setActiveMenu("menuRicercaSanzioni");
			return result;
		} else {
			if (LOG.isDebugEnabled()) {
				LOG.debug("[MenuAction::goToMenuRicercaSanzioni] returning default result [SUCCESS]");
			}
			setActiveMenu("menuRicercaSanzioni");
			return SUCCESS;
		}
	}

	/**
	 * 
	 * @return SUCCESS result.
	 */
	public String goToMenuRicercaSveglie() throws CommandExecutionException {

		// gestione degli eventi di tipo CLICKED
		ICommand action = initCommand(null, "global", "menuRicercaSveglie", "CLICKED");
		String result = action.doCommand(this);
		if (result != null) {
			if (LOG.isDebugEnabled()) {
				LOG.debug("[MenuAction::goToMenuRicercaSveglie] returning result [" + result + "]");
			}
			setActiveMenu("menuRicercaSveglie");
			return result;
		} else {
			if (LOG.isDebugEnabled()) {
				LOG.debug("[MenuAction::goToMenuRicercaSveglie] returning default result [SUCCESS]");
			}
			setActiveMenu("menuRicercaSveglie");
			return SUCCESS;
		}
	}

	/**
	 * 
	 * @return SUCCESS result.
	 */
	public String goToMenuDatiDistributore() throws CommandExecutionException {

		// gestione degli eventi di tipo CLICKED
		ICommand action = initCommand(null, "global", "menuDatiDistributore", "CLICKED");
		String result = action.doCommand(this);
		if (result != null) {
			if (LOG.isDebugEnabled()) {
				LOG.debug("[MenuAction::goToMenuDatiDistributore] returning result [" + result + "]");
			}
			setActiveMenu("menuDatiDistributore");
			return result;
		} else {
			if (LOG.isDebugEnabled()) {
				LOG.debug("[MenuAction::goToMenuDatiDistributore] returning default result [SUCCESS]");
			}
			setActiveMenu("menuDatiDistributore");
			return SUCCESS;
		}
	}

	/**
	 * 
	 * @return SUCCESS result.
	 */
	public String goToMenuToken() throws CommandExecutionException {

		// gestione degli eventi di tipo CLICKED
		ICommand action = initCommand(null, "global", "menuToken", "CLICKED");
		String result = action.doCommand(this);
		if (result != null) {
			if (LOG.isDebugEnabled()) {
				LOG.debug("[MenuAction::goToMenuToken] returning result [" + result + "]");
			}
			setActiveMenu("menuToken");
			return result;
		} else {
			if (LOG.isDebugEnabled()) {
				LOG.debug("[MenuAction::goToMenuToken] returning default result [SUCCESS]");
			}
			setActiveMenu("menuToken");
			return SUCCESS;
		}
	}

	public static final String ACTIVE_MENU_ATTRNAME = "active_menu";

	public void setActiveMenu(String menuName) {
		//session.put(ACTIVE_MENU_ATTRNAME, "menu_items_" + menuName);
	}

	/**
	 * inizializza la struttura dei command da eseguire per ciascun event handler 
	 * di ciascun widget
	 */
	protected ICommand initCommand(String moduleName, String panelName, String sourceWidget, String eventType) {
		ICommand cmd = null;
		try {
			cmd = CommandFactory.getInstance().buildCmdStructure_internal(null, "global",
					"_" + sourceWidget.toLowerCase() + "_" + "CLICKED");
		} catch (CommandExecutionException cee) {
			LOG.error("Errore imprevisto nella creazione dei comandi:" + cee.getMessage() + ", restituisco NOPCommand",
					cee);
			cmd = new NOPCommand();
		}
		return cmd;
	}

	/**
	 * Gestione della validazione
	 */
	public void validate() {
		/*PROTECTED REGION ID(R-963475072) ENABLED START*/
		/* Inserire la validazione */
		/*PROTECTED REGION END*/
	}

	/**
	 *	Metodo per la rimozione dalla sessione degli application data a scope
	 *  SAME_PAGE. 
	 */
	public void clearPageScopedAppData(String targetContentPanelName) {
		// non sapendo quale content panel si sta abbandonando vengono rimossi tutti
		// gli appdata a scope PAGE

	}

	protected void dumpModel(boolean pre) {
		// metodo intenzionalmente vuoto
	}

	protected void doBeforeEventCommand() {
		// il menu e' globale: non sono previsti before/after event commands
	}

	protected void doAfterEventCommand() {
		// il menu e' globale: non sono previsti before/after event commands
	}
}
