
package it.csi.sigit.elencom.presentation.elencom.action;

import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
import it.csi.sigit.elencom.dto.DTOUtils;

/**
 * Implementazione dle comando VisibilityCommand
 */
public class VisibilityCommand implements ICommand {

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per poter essere inserita in sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * nome dell'attributo in sessione che contiene la mappa di visibilita' dei menu
	 */
	private static final String SESSION_MENU_VISIBILITY = "menuVisibilityMap";

	/**
	 * targetsWidgets
	 */
	String[] targetsWidgets = null;

	/**
	 * targetsMenuElement
	 */
	String[] targetsMenuElement = null;

	/**
	 * show?
	 */
	boolean show = true;

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

	public boolean isShow() {
		return show;
	}

	public void setShow(boolean show) {
		this.show = show;
	}

	/**
	 * @param targetWidgets nomi dei widget da mostrare/nascondere
	 * @param targetsMenuElement nomi dei menu da mostrare/nascondere
	 * @param show se vale true i widget/menu saranno abilitati, altrimenti saranno disabilitati
	 */
	public VisibilityCommand(String targetsWidgets[], String targetsMenuElement[], boolean show) {
		this.setTargetsWidgets(targetsWidgets);
		this.setTargetsMenuElement(targetsMenuElement);
		this.show = show;
	}

	/**
	 * costruttore di default
	 */
	public VisibilityCommand() {
		/// costruttore intenzionalmente vuoto
	}

	/**
	 * @param targetWidgets nomi dei widget da mostrare/nascondere
	 * @param show se vale true i widget/menu saranno abilitati, altrimenti saranno disabilitati
	 */
	public VisibilityCommand(String targetsWidgets[], boolean show) {
		this.setTargetsWidgets(targetsWidgets);
		this.show = show;
	}

	/**
	 * esecuzione del comando VisibilityCommand. Lo stato di visibilita' dei widget/menu e' contenuto in
	 * sessione.
	 */
	public String doCommand(BaseAction strutsAction) throws CommandExecutionException {

		//Definzione Visibility Widgets per ContentPanel
		if (strutsAction instanceof AbstractCPAction) {
			String containerName = ((AbstractCPAction) strutsAction).getCPName();
			if (this.targetsWidgets != null) {
				// lo stato di visibilita' dei widget e' mantenuto in sessione
				// in una mappa a due livelli:
				// - il primo livello contiene <nome cp, mappa per il cp>
				// - il secondo livello contiene <[widget]_visible, true|false>
				Map<String, Boolean> cpWidgetsStatus = (Map<String, Boolean>) strutsAction.session.get(containerName);
				if (cpWidgetsStatus == null) {
					cpWidgetsStatus = new HashMap<String, Boolean>();
					strutsAction.session.put(containerName, cpWidgetsStatus);
				}
				for (int i = 0; i < this.targetsWidgets.length; i++) {
					cpWidgetsStatus.put(this.targetsWidgets[i] + "_visible", Boolean.valueOf(this.show));
				}

			}
		}

		//Definzione Visibility MenuElement 
		if (this.targetsMenuElement != null) {
			// lo stato di visibilita' di una voce di menu e' contenuta in sessione
			// in una mappa
			Map<String, Boolean> menuVisibilityMap = (Map<String, Boolean>) strutsAction.session
					.get(SESSION_MENU_VISIBILITY);

			if (menuVisibilityMap == null) {
				// se la mappa non esiste ancora la creo
				menuVisibilityMap = new HashMap<String, Boolean>();
				strutsAction.session.put(SESSION_MENU_VISIBILITY, menuVisibilityMap);
			}
			// inserisco lo stato di visibilita' di tutti i target menu
			// inserendo la coppia <[menu]_visible, true|false>
			for (int i = 0; i < this.targetsMenuElement.length; i++) {
				menuVisibilityMap.put(this.targetsMenuElement[i] + "_visible", Boolean.valueOf(this.show));
			}
		}
		return null;
	}
}
