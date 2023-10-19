
package it.csi.sigit.elencom.presentation.elencom.action;

/**
 * Implementazione del comando ShowDialogCommnad
 */
public class ShowDialogCommand implements ICommand {

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per poter essere inserita in sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param panelName il nome del DialogPanel da visualizzare
	 */
	public ShowDialogCommand(String panelName) {
		name = panelName;
	}

	/**
	 * costruttore di default
	 */
	public ShowDialogCommand() {
		/// costruttore intenzionalmente vuoto
	}

	/**
	 * Esecuzione del comando ShowDialogCommand. 
	 * Si concretizza con la restituzione al workflow di struts del result SHOW_<nome dialog>.
	 */
	public String doCommand(BaseAction strutsAction) throws CommandExecutionException {
		return "SHOW_" + name;
	}
};
