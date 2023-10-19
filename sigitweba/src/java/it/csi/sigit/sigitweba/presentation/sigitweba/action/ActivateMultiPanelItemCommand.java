
package it.csi.sigit.sigitweba.presentation.sigitweba.action;

/**
 * Implementazione del comnado ActivateMultiPanelItemCommand
 */
public class ActivateMultiPanelItemCommand implements ICommand {

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per poter essere inserita in sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	String contentPanelName;

	public void setContentPanelName(String n) {
		this.contentPanelName = n;
	}

	public String getContentPanelName() {
		return this.contentPanelName;
	}

	String containerName;

	public void setContainerName(String n) {
		this.containerName = n;
	}

	public String getContainerName() {
		return this.containerName;
	}

	String itemName;

	public void setItemName(String n) {
		this.itemName = n;
	}

	public String getItemName() {
		return this.itemName;
	}

	/**
	 * @param contentPanelName il nome del content panel
	 * @param containerName il nome del multi-panel contenitore
	 * @param itemName il nome dell'item da attivare (se null => non mostrare
	 *  nessun pannello
	 */
	public ActivateMultiPanelItemCommand(String contentPanelName, String containerName, String itemName) {
		assert contentPanelName != null && contentPanelName.length() > 0;
		assert containerName != null && containerName.length() > 0;
		// item name puo essere nullo => deselect

		this.contentPanelName = contentPanelName;
		this.containerName = containerName;
		this.itemName = itemName;
	}

	/**
	 * costruttore di default
	 */
	public ActivateMultiPanelItemCommand() {
		/// costruttore intenzionalmente vuoto
	}

	/**
	 * Esecuzione del comando ActivateMultiPanelItem. L'indicazione del nome dell'item 
	 * correntemente attivo e' mantenuta in sessione: 
	 * - chiave: <contentPanelName>_<containerName>_selectedMultiPanel" 
	 * - valore: <contentPanelName>_<containerName>_<itemName> oppure null per disattivare 
	 * tutti gli item
	 */
	public String doCommand(BaseAction strutsAction) throws CommandExecutionException {
		if (itemName != null) {
			strutsAction.getSession().put(contentPanelName + "_" + containerName + "_selectedMultiPanel",
					contentPanelName + "_" + containerName + "_" + itemName);
		} else {
			strutsAction.getSession().remove(contentPanelName + "_" + containerName + "_selectedMultiPanel");
		}
		return null;
	}
};
