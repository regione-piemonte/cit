
package it.csi.sigit.sigitwebn.presentation.sigitwebn.action;

/**
 * Implementazione del comando JumpCommand
 */
public class JumpCommand implements ICommand {

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per poter essere inserita in sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * nome del ContentPanel target del salto
	 */
	String name;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	/**
	 * se impostato a true, verra' inserita la pagina (content panel) corrente nello 
	 * stack
	 */
	boolean pushCurrent;

	public void setPushCurrent(boolean pushCurrent) {
		this.pushCurrent = pushCurrent;
	}

	public boolean isPushCurrent() {
		return this.pushCurrent;
	}

	/**
	 * @param panelName il nome del contentPanel a cui saltare
	 * @param currentPageName il nome del contentPanel di partenza (serve in 
	 * caso di pushCurrentPage
	 * @param pushCurrentPage se impostato a true viene inserito il nome del contentPanel
	 * corrente nello stack
	 */
	public JumpCommand(String panelName, boolean pushCurrent) {
		name = panelName;
		this.pushCurrent = pushCurrent;
	}

	/**
	 * costruttore di default
	 */
	public JumpCommand() {
		/// costruttore intenzionalmente vuoto
	}

	/**
	 * Esecuzione del salto. L'esecuzione del jump command si concretizza con la restituzione
	 * al workflow di struts del result corrispondente alla action associata al
	 * ContentPanel target. 
	 * Nel caso sia specificato pushCurrentPage=true, verra' inserito nello stack delle pagine
	 * il nome del contentPanel di partenza, contenuto in currentPageName.
	 * Inoltre viene eseguita la pulizia degli application data di scope SAME_PAGE.
	 */
	public String doCommand(BaseAction strutsAction) throws CommandExecutionException {
		//se prevista modalita' PUSH_PAGE_CURRENT --> inserisci in queque currentPage 
		if (strutsAction instanceof AbstractCPAction) {
			AbstractCPAction cpAction = (AbstractCPAction) strutsAction;
			String currentPageName = cpAction.getCPFullNamespace() + "/" + cpAction.getCPName();
			if (this.pushCurrent && (null != currentPageName && !"".equalsIgnoreCase(currentPageName))) {
				if (strutsAction.getAppDataNavigationQueue() == null)
					strutsAction.setAppDataNavigationQueue(new java.util.LinkedList());
				strutsAction.getAppDataNavigationQueue().add(currentPageName);
			} else {
				if (strutsAction.getAppDataNavigationQueue() != null)
					strutsAction.getAppDataNavigationQueue().clear();
			}
		}
		// clear page scoped appdata
		strutsAction.clearPageScopedAppData(name);
		return "GO_TO_" + name;
	}
};
