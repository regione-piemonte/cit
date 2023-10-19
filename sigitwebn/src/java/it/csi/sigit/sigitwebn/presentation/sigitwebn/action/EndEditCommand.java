
package it.csi.sigit.sigitwebn.presentation.sigitwebn.action;

import java.util.Arrays;
import it.csi.sigit.sigitwebn.dto.DTOUtils;

/**
 * Implementazione del comando EndEditSession.
 */
public class EndEditCommand implements ICommand {

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per poter essere inserita in sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	String[] targetAppDataNames;
	boolean undo;

	public String[] getTargetAppDataNames() {
		return (String[]) DTOUtils.arrayCopyOf(this.targetAppDataNames, String.class);
	}

	public void setTargetAppDataNames(String[] p_targetAppDataNames) {
		this.targetAppDataNames = (String[]) DTOUtils.arrayCopyOf(p_targetAppDataNames, String.class);
	}

	public boolean isUndo() {
		return undo;
	}

	public void setUndo(boolean undo) {
		this.undo = undo;
	}

	/**
	 * @param targetAppDataNames i nomi degli application data da ripristinare (eventualmente)
	 * @param undo se valorizzato a true, il valore degli appdata referenziati viene ripristinato a partire
	 * dal valore di backup effettuato durante l'esecuzione del BeginEditCommand corrispondente
	 */
	public EndEditCommand(String[] targetAppDataNames, boolean undo) {
		this.setTargetAppDataNames(targetAppDataNames);
		this.undo = undo;
	}

	/**
	 * costruttore di default
	 */
	public EndEditCommand() {
		/// costruttore intenzionalmente vuoto
	}

	/**
	 * Elimina i backup (deep copy) degli appdata specificati, ripristinando il
	 * valore se undo==true; 
	 */
	public String doCommand(BaseAction strutsAction) throws CommandExecutionException {
		if (targetAppDataNames != null) {
			for (int i = 0; i < targetAppDataNames.length; i++) {
				String currADName = targetAppDataNames[i];
				endEditForAppdata(currADName, undo, strutsAction);
			}
		}
		return null;
	}

	/**
	 * Rimuove i backup e se necessario effettua il restore del valore del singolo application data
	 * @param adName
	 * @param undo
	 * @param strutsAction
	 */
	public static void endEditForAppdata(String adName, boolean undo, BaseAction strutsAction) {
		if (undo) {
			// undo del dato
			Object currADValBkp = strutsAction.getSession().get(adName + "_bckp");
			if (currADValBkp != null) {
				strutsAction.getSession().put(adName, currADValBkp);
			}
		}
		// rimuove il backup 
		strutsAction.getSession().remove(adName + "_bckp");
	}

};
