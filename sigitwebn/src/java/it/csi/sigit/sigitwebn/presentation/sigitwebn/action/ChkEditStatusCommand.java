
package it.csi.sigit.sigitwebn.presentation.sigitwebn.action;

import java.util.Arrays;
import it.csi.sigit.sigitwebn.dto.DTOUtils;

/**
 * Implementazione del comando ChkEditStatusCommand. Permette di esaminare se il valore
 * di un ApplicationData coinvolto in una sessione di editing (tramite BeginEditSessionCommand)
 * e' stato modificato.
 */
public class ChkEditStatusCommand implements ICommand {

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per poter essere inserita in sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	ICommand doIfChanged;
	ICommand doIfNotChanged;
	String checkAggr;
	String[] checkedData;

	public ICommand getDoIfChanged() {
		return doIfChanged;
	}

	public void setDoIfChanged(ICommand doIfChanged) {
		this.doIfChanged = doIfChanged;
	}

	public ICommand getDoIfNotChanged() {
		return doIfNotChanged;
	}

	public void setDoIfNotChanged(ICommand doIfNotChanged) {
		this.doIfNotChanged = doIfNotChanged;
	}

	public String getCheckAggr() {
		return checkAggr;
	}

	public void setCheckAggr(String checkAggr) {
		this.checkAggr = checkAggr;
	}

	public String[] getCheckedData() {
		return (String[]) DTOUtils.arrayCopyOf(this.checkedData, String.class);
	}

	public void setCheckedData(String[] p_checkedData) {
		this.checkedData = (String[]) DTOUtils.arrayCopyOf(p_checkedData, String.class);
	}

	/**
	 * @param checkedData il nome deli application data da esaminare
	 * @param checkAggregation modalita' di aggregazione dei risultati dei singoli check.
	 * puo' valere "AND", "OR" o "XOR"
	 * @param doIfChanged ICommand da eseguire se il check e' positivo (dati variati)
	 * @param doIfNotChanged ICommand da eseguire se il check e' negativo (dati non variati) 
	 */
	public ChkEditStatusCommand(String[] checkedData, String checkAggregation, ICommand doIfChanged,
			ICommand doIfNotChanged) {
		this.setCheckedData(checkedData);
		this.checkAggr = checkAggregation;
		this.doIfChanged = doIfChanged;
		this.doIfNotChanged = doIfNotChanged;
	}

	/**
	 * costruttore di default
	 */
	public ChkEditStatusCommand() {
		/// costruttore intenzionalmente vuoto
	}

	/**
	 * Esecuzione del comando. 
	 * A seconda del risultato del check (che tiene conto del tipo di aggregazione)
	 * viene eseguito il comando contenuto in doIfChanged o doIfNotchanged
	 */
	public String doCommand(BaseAction strutsAction) throws CommandExecutionException {
		boolean changed = checkAppdata4Changes(this.checkedData, this.checkAggr, strutsAction);
		if (changed)
			return this.doIfChanged.doCommand(strutsAction);
		else
			return this.doIfNotChanged.doCommand(strutsAction);
	}

	/**
	 * Verifica variazioni sugli appdata con la politica di aggregazione specificata
	 * @param checkedData
	 * @param checkAggr
	 * @param strutsAction
	 * @return
	 */
	boolean checkAppdata4Changes(String[] checkedData, String checkAggr, BaseAction strutsAction) {
		if (checkedData == null || checkedData.length == 0)
			return false;
		// else
		boolean ris = "OR".equals(checkAggr) ? false : ("AND".equals(checkAggr) ? true : false);
		for (int i = 0; i < checkedData.length; i++) {
			String currADName = checkedData[i];
			boolean currChanged = checkAppdata4Changes(currADName, strutsAction);
			if (currChanged && "OR".equals(checkAggr))
				return true; // al primo esco con true
			else if (!currChanged && "AND".equals(checkAggr))
				return false; // al primo falso esco con falso
			else if ("XOR".equals(checkAggr)) {
				if (currChanged && ris)
					return false; // secondo match: rompe lo xor
			}
		}
		return ris;
	}

	/**
	 * verifica se il singolo appdata e' variato
	 * @param currADName
	 * @param strutsAction
	 * @return
	 */
	private boolean checkAppdata4Changes(String currADName, BaseAction strutsAction) {
		Object adVal = strutsAction.getSession().get(currADName);
		Object adBkp = strutsAction.getSession().get(currADName + "_bckp");
		if (adBkp != null) {
			it.csi.sigit.sigitwebn.dto.DTOUtils dtoUtils = it.csi.sigit.sigitwebn.dto.DTOUtils.getInstance();
			return !(dtoUtils.deepEquals(adVal, adBkp));
		} else
			return false;
	}

};
