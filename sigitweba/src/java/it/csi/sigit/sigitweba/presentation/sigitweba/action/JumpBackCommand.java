
package it.csi.sigit.sigitweba.presentation.sigitweba.action;

/**
 * Implementazione del comando JumpBackCommand
 */
public class JumpBackCommand implements ICommand {

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per poter essere inserita in sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * costruttore di default
	 */
	public JumpBackCommand() {
		/// costruttore intenzionalmente vuoto
	}

	/**
	 * Esecuzione del comando JumpBackCommand. L'esecuzione di questo comando consiste nella restituzione
	 * al workflow di struts del result GO_TO_BackPage, che tutte le action asosciate ai ContnetPanel
	 * possiedono, e che a runtime ridirige il flusso al content panel sul top dello stack.
	 * Il result GO_TO_BackPage prende le info circa namespace e action a cui saltare dalle property
	 * backNamespace e backActionName contenute nella action. questo comando pertanto, oltre a restituire
	 * il result GO_TO_BackPage, imposta anche tale coppia di proprieta'.
	 * Nel caso in cui lo stack sia vuoto il comando resittuisce il result BACK_TO_HOME che fa ritornare il
	 * flusso di esecuzione alla home page applicativa.
	 */
	public String doCommand(BaseAction strutsAction) throws CommandExecutionException {
		// clear page scoped appdata
		if (strutsAction instanceof AbstractCPAction) {
			strutsAction.clearPageScopedAppData(((AbstractCPAction) strutsAction).getCPName());
		}
		java.util.LinkedList<java.lang.String> navigationQueue = strutsAction.getAppDataNavigationQueue();
		if (navigationQueue != null && !navigationQueue.isEmpty()) {
			String backPage = navigationQueue.getLast();
			if (null != backPage && !"".equalsIgnoreCase(backPage)) {
				String[] splitArray = backPage.split("/");
				strutsAction.setBackActionName(splitArray[3]);
				strutsAction.setBackNamespace("/" + splitArray[1] + "/" + splitArray[2]);
				navigationQueue.removeLast();
				return "GO_TO_BackPage";
			}
		}
		return "BACK_TO_HOME";

	}

};
