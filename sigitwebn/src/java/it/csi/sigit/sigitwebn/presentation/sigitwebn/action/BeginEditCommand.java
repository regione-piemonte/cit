
package it.csi.sigit.sigitwebn.presentation.sigitwebn.action;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import it.csi.sigit.sigitwebn.dto.DTOUtils;

/**
 * Implementazione del comando BeginEditCommand.
 */
public class BeginEditCommand implements ICommand {

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per poter essere inserita in sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	String[] targetAppDataNames;

	public String[] getTargetAppDataNames() {
		return (String[]) DTOUtils.arrayCopyOf(this.targetAppDataNames, String.class);
	}

	public void setTargetAppDataNames(String[] p_targetAppDataNames) {
		this.targetAppDataNames = (String[]) DTOUtils.arrayCopyOf(p_targetAppDataNames, String.class);
	}

	/**
	 * @param targetAppDataNames i nomi degli applicaiton data da includere nella
	 * sessione
	 */
	public BeginEditCommand(String[] targetAppDataNames) {
		this.setTargetAppDataNames(targetAppDataNames);
	}

	/**
	 * costruttore di default
	 */
	public BeginEditCommand() {
		/// costruttore intenzionalmente vuoto
	}

	/**
	 * Esecuzione del comando BeginEditCommand. 
	 * Salva un backup (deep copy) degli appdata specificati
	 */
	public String doCommand(BaseAction strutsAction) throws CommandExecutionException {
		if (targetAppDataNames != null) {
			for (int i = 0; i < targetAppDataNames.length; i++) {
				String currADName = targetAppDataNames[i];
				try {
					storeBackup(currADName, strutsAction);
				} catch (CloneNotSupportedException cnse) { //NOSONAR  Reason:dubbia classificazione severity
					throw new CommandExecutionException(
							"Errore nella creazioene del backup dell'appdata [" + currADName + "]:" + cnse.getMessage(),
							cnse);
				}
			}
		}
		return null;
	}

	/**
	 * Effettua il salvataggio di un backup del singolo applicationData
	 * @param adName il nome dell'application data
	 * @param strutsAction la action su cui si scatena il comando
	 */
	public static void storeBackup(String adName, BaseAction strutsAction) throws CloneNotSupportedException {
		Object currADVal = strutsAction.getSession().get(adName);
		Object currADValClone = deepClone(currADVal);
		if (currADVal != null) {
			strutsAction.getSession().put(adName + "_bckp", currADValClone);
		}
	}

	/**
	 * Effettua un clone ricorsivo delle strutture dati in input.
	 * Il clone viene fatto tramite serializzazione in memory e successiva deserializzazione.
	 */
	public static Object deepClone(Object orig) throws CloneNotSupportedException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream(baos);
			oos.writeObject(orig);
			ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
			ObjectInputStream ois = new ObjectInputStream(bais);
			Object clone = ois.readObject();
			return clone;
		} catch (IOException e) { //NOSONAR  Reason:dubbia classificazione severity
			throw new CloneNotSupportedException();
		} catch (ClassNotFoundException e) { //NOSONAR  Reason:dubbia classificazione severity
			throw new CloneNotSupportedException();
		}
	}
};
