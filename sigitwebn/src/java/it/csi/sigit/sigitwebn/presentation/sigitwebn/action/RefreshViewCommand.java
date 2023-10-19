
package it.csi.sigit.sigitwebn.presentation.sigitwebn.action;

import java.util.Arrays;
import it.csi.sigit.sigitwebn.dto.DTOUtils;

/**
 * Implementazione del comando RefreshViewCommand.
 */
public class RefreshViewCommand implements ICommand {

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per poter essere inserita in sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	String currentPanelName = null;

	public void setCurrentPanelName(String name) {
		currentPanelName = name;
	}

	public String getCurrentPanelName() {
		return currentPanelName;
	}

	String[] targetPanels = null;

	public void setTargetPanels(String[] tp) {
		this.targetPanels = (String[]) DTOUtils.arrayCopyOf(tp, String.class);
	}

	public String[] getTargetPanels() {
		return (String[]) DTOUtils.arrayCopyOf(this.targetPanels, String.class);
	}

	String[] targetWidgets = null;

	public void setTargetWidgets(String[] tw) {
		this.targetWidgets = (String[]) DTOUtils.arrayCopyOf(tw, String.class);
	}

	public String[] getTargetWidgets() {
		return (String[]) DTOUtils.arrayCopyOf(this.targetWidgets, String.class);
	}

	/**
	 * @param currentPanelName il nome del ContentPanel su cui deve essere effettuato il refresh
	 * @param targetPanelNames l'elenco dei nomi dei pannelli da rinfrescare
	 * @param targetWidgetNames l'elenco dei nomi dei widget da rinfrescare
	 */
	public RefreshViewCommand(String currentPanelName, String[] targetPanelNames, String[] targetWidgetNames) {
		this.currentPanelName = currentPanelName;
		this.setTargetPanels(targetPanelNames);
		this.setTargetWidgets(targetWidgetNames);
	}

	/**
	 * costruttore di default
	 */
	public RefreshViewCommand() {
		/// costruttore intenzionalmente vuoto
	}

	/**
	 * Nell'implementazione struts l'esecuzione di questo comando e' completamente a carico dello 
	 * strato javascript.
	 * Pertanto l'unico effetto di questo comando e' quello di comandare al workflow di struts la
	 * restituizione della pagina completa. La parte client ritagliera' le parti a seconda di 
	 * quali pannelli target sono stati modellati. 
	 */
	public String doCommand(BaseAction strutsAction) throws CommandExecutionException {
		return null;
	}
};
