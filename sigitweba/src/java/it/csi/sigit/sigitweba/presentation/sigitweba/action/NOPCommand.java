
package it.csi.sigit.sigitweba.presentation.sigitweba.action;

/**
 * Implementazione di NOPCommand. 
 * Questo comando ha effetto nullo nella catena.
 */
public class NOPCommand implements ICommand {
	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per poter essere inserita in sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	public NOPCommand() {
		/// costruttore intenzionalmente vuoto
	}

	/**
	 * @return null. In questo modo il NOPCommand ha effetto nullo sull'esecuzione 
	 */
	public String doCommand(BaseAction strutsAction) throws CommandExecutionException {
		return null;
	}
};
