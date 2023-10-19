
package it.csi.sigit.elencom.presentation.elencom.action;

/**
 * Interfaccia comune di tutte le azioni di presentation
 *
 */
public interface ICommand extends java.io.Serializable {
	/**
	 * Esegue l'azione corrispondente
	 * @return il codice del RESULT struts conseguente all'azione (se l'azione comporta)
	 * una decisione sul result, null altrimenti
	 */
	public String doCommand(BaseAction strutsAction) throws CommandExecutionException;
};
