
package it.csi.sigit.sigitwebn.presentation.sigitwebn.action;

import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
import it.csi.sigit.sigitwebn.dto.DTOUtils;

/**
 * Implementazione del comando OnOffCommand 
 */
public class OnOffCommand implements ICommand {

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per poter essere inserita in sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;
	private static final String SESSION_MENU_ONOFF = "menuOnOffMap";

	String[] targetsWidgets = null;
	String[] targetsMenuElement = null;
	boolean enable = true;

	public String[] getTargetsWidgets() {
		return (String[]) DTOUtils.arrayCopyOf(this.targetsWidgets, String.class);
	}

	public void setTargetsWidgets(String[] p_targetsWidgets) {
		this.targetsWidgets = (String[]) DTOUtils.arrayCopyOf(p_targetsWidgets, String.class);
	}

	public String[] getTargetsMenuElement() {
		return (String[]) DTOUtils.arrayCopyOf(this.targetsMenuElement, String.class);
	}

	public void setTargetsMenuElement(String[] p_targetsMenuElement) {
		this.targetsMenuElement = (String[]) DTOUtils.arrayCopyOf(p_targetsMenuElement, String.class);
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	/**
	 * @param targetWidgets nomi dei widget da abilitare/disabilitare
	 * @param enable se vale true i widget saranno abilitati, altrimenti saranno disabilitati
	 */
	public OnOffCommand(String targetsWidgets[], boolean enable) {
		this.setTargetsWidgets(targetsWidgets);
		this.enable = enable;
	}

	/**
	 * costruttore di default
	 */
	public OnOffCommand() {
		/// costruttore intenzionalmente vuoto
	}

	/**
	 * @param targetWidgets nomi dei widget da abilitare/disabilitare
	 * @param targetsMenuElement nomi dei menu da abilitare/disabilitare
	 * @param enable se vale true i widget/menu saranno abilitati, altrimenti saranno disabilitati
	 */
	public OnOffCommand(String targetsWidgets[], String targetsMenuElement[], boolean enable) {
		this.setTargetsWidgets(targetsWidgets);
		this.setTargetsMenuElement(targetsMenuElement);
		this.enable = enable;
	}

	/**
	 * esecuzione del comando OnOffCommand. Lo stato di abilitazione dei widget/menu e' contenuto in
	 * sessione.
	 */
	public String doCommand(BaseAction strutsAction) throws CommandExecutionException {
		if (strutsAction instanceof AbstractCPAction) {
			String containerName = ((AbstractCPAction) strutsAction).getCPName();
			if (this.targetsWidgets != null) {
				Map<String, Boolean> cpWidgetsStatus = (Map<String, Boolean>) strutsAction.session.get(containerName);
				if (cpWidgetsStatus == null) {
					cpWidgetsStatus = new HashMap<String, Boolean>();
					strutsAction.session.put(containerName, cpWidgetsStatus);
				}
				for (int i = 0; i < this.targetsWidgets.length; i++) {
					cpWidgetsStatus.put(this.targetsWidgets[i] + "_enabled", Boolean.valueOf(this.enable));
				}
			}
		}

		if (this.targetsMenuElement != null) {
			Map<String, Boolean> menuOnOffMap = (Map<String, Boolean>) strutsAction.session.get(SESSION_MENU_ONOFF);
			if (menuOnOffMap == null) {
				menuOnOffMap = new HashMap<String, Boolean>();
				strutsAction.session.put(SESSION_MENU_ONOFF, menuOnOffMap);
			}
			for (int i = 0; i < this.targetsMenuElement.length; i++) {
				menuOnOffMap.put(this.targetsMenuElement[i] + "_enabled", Boolean.valueOf(this.enable));
			}
		}
		return null;
	}
}
