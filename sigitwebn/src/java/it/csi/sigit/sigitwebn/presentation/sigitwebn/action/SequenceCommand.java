
package it.csi.sigit.sigitwebn.presentation.sigitwebn.action;

import java.util.Arrays;
import it.csi.sigit.sigitwebn.dto.DTOUtils;

/**
 * Implementazione del comando SequenceCommand.
 */
public class SequenceCommand implements ICommand {

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per poter essere inserita in sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	ICommand[] actions;

	public ICommand[] getActions() {
		return (ICommand[]) DTOUtils.arrayCopyOf(this.actions, ICommand.class);
	}

	public void setActions(ICommand[] p_actions) {
		this.actions = (ICommand[]) DTOUtils.arrayCopyOf(p_actions, ICommand.class);
	}

	/** 
	 * @param actions elenco degli ICommand da eseguire in sequenza
	 */
	public SequenceCommand(ICommand[] actions) {
		this.setActions(actions);
	}

	/**
	 * costruttore di default
	 */
	public SequenceCommand() {
		/// costruttore intenzionalmente vuoto
	}

	/**
	 * La sequence action esegue in sequenza tutte le azioni atomiche
	 * incluse come step, mantenendo il pi&ugrave; recente risultato non nullo restituito
	 * dagli step (per determinare al termine quale debba essere la pagina successiva
	 */
	public String doCommand(BaseAction strutsAction) throws CommandExecutionException {
		String result = null;
		if (this.actions != null) {
			for (int i = 0; i < this.actions.length; i++) {
				ICommand currAct = this.actions[i];
				String currResult = currAct.doCommand(strutsAction);
				if (currResult != null)
					result = currResult;
			}
		}
		return result;
	}
};
