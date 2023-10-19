
package it.csi.sigit.sigitwebn.presentation.sigitwebn.action;

import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
import it.csi.sigit.sigitwebn.dto.DTOUtils;

/**
 * Implementazione del comando ScreenStateCommand
 */
public class ScreenStateCommand implements ICommand {

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per poter essere inserita in sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	String stateName = null;

	public void setStateName(String n) {
		this.stateName = n;
	}

	public String getStateName() {
		return this.stateName;
	}

	String[] widgetsOn = null;
	String[] widgetsOff = null;
	String[] widgetsShown = null;
	String[] widgetsHidden = null;

	public String[] getWidgetsOn() {
		return (String[]) DTOUtils.arrayCopyOf(this.widgetsOn, String.class);
	}

	public void setWidgetsOn(String[] p_widgetsOn) {
		this.widgetsOn = (String[]) DTOUtils.arrayCopyOf(p_widgetsOn, String.class);
	}

	public String[] getWidgetsOff() {
		return (String[]) DTOUtils.arrayCopyOf(this.widgetsOff, String.class);
	}

	public void setWidgetsOff(String[] p_widgetsOff) {
		this.widgetsOff = (String[]) DTOUtils.arrayCopyOf(p_widgetsOff, String.class);
	}

	public String[] getWidgetsShown() {
		return (String[]) DTOUtils.arrayCopyOf(this.widgetsOn, String.class);
	}

	public void setWidgetsShown(String[] p_widgetsShown) {
		this.widgetsShown = (String[]) DTOUtils.arrayCopyOf(p_widgetsShown, String.class);
	}

	public String[] getWidgetsHidden() {
		return (String[]) DTOUtils.arrayCopyOf(this.widgetsHidden, String.class);
	}

	public void setWidgetsHidden(String[] p_widgetsHidden) {
		this.widgetsHidden = (String[]) DTOUtils.arrayCopyOf(p_widgetsHidden, String.class);
	}

	/**
	 * @param containerName nome del content panel a cui fanno riferimento gli screen state
	 * @param stateName nome dello ScreenState da attivare
	 * @param widgetsOn elenco dei nomi dei widget da abilitare
	 * @param widgetsOff elenco dei nomi dei widget da disabilitare
	 * @param widgetsShown elenco dei nomi dei widget da mostrare
	 * @param widgetsHidden elenco dei nomi dei widget da nascondere
	 */
	public ScreenStateCommand(String stateName, String widgetsOn[], String widgetsOff[], String widgetsShown[],
			String widgetsHidden[]) {
		this.stateName = stateName;
		this.setWidgetsOn(widgetsOn);
		this.setWidgetsOff(widgetsOff);
		this.setWidgetsShown(widgetsShown);
		this.setWidgetsHidden(widgetsHidden);
	}

	/**
	 * costruttore di default
	 */
	public ScreenStateCommand() {
		/// costruttore intenzionalmente vuoto
	}

	/**
	 * Esecuzione del comando ScreenStateCommand. L'esecuzione di questo comando e' concretizzata
	 * tramite l'esecuzione di una serie di comnadi ONOFF e Visibility a seconda di quanto descritto
	 * iun widgetsOn/Off, widgetShown/Hidden.  
	 */
	public String doCommand(BaseAction strutsAction) throws CommandExecutionException {
		if (strutsAction instanceof AbstractCPAction) {
			String containerName = ((AbstractCPAction) strutsAction).getCPName();
			OnOffCommand turnOn = new OnOffCommand(this.widgetsOn, true);
			OnOffCommand turnOff = new OnOffCommand(this.widgetsOff, false);
			VisibilityCommand show = new VisibilityCommand(this.widgetsShown, true);
			VisibilityCommand hide = new VisibilityCommand(this.widgetsHidden, false);
			turnOn.doCommand(strutsAction);
			turnOff.doCommand(strutsAction);
			show.doCommand(strutsAction);
			hide.doCommand(strutsAction);
			if (this.stateName != null) {
				strutsAction.getSession().put(containerName + "_currentState", this.stateName);
			}
		}
		return null;
	}
}
