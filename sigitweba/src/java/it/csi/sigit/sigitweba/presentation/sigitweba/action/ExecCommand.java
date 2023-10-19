
package it.csi.sigit.sigitweba.presentation.sigitweba.action;

import java.util.*;
import com.opensymphony.xwork2.ActionSupport;
import it.csi.sigit.sigitweba.dto.*;
import it.csi.sigit.sigitweba.business.BackEndFacade;
import java.lang.reflect.Method;
import it.csi.sigit.sigitweba.business.BEException;
import java.lang.reflect.InvocationTargetException;

/**
 * Implementazione del comando ExecCommand.
 */
public class ExecCommand implements ICommand {

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per poter essere inserita in sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * gli esiti possibili
	 */
	String esiti[] = null;

	/**
	 * le azioni corrispondenti agli esiti possibili
	 */
	ICommand azioni[] = null;

	/**
	 * il nome del metodo da eseguire
	 */
	String nomeMetodo = null;

	/**
	 * gli appdata che la logica modifica
	 */
	String appDataToStore[] = null;

	public String[] getEsiti() {
		return (String[]) DTOUtils.arrayCopyOf(this.esiti, String.class);
	}

	public void setEsiti(String[] p_esiti) {
		this.esiti = (String[]) DTOUtils.arrayCopyOf(p_esiti, String.class);
	}

	public ICommand[] getAzioni() {
		return (ICommand[]) DTOUtils.arrayCopyOf(this.azioni, ICommand.class);
	}

	public void setAzioni(ICommand[] p_azioni) {
		this.azioni = (ICommand[]) DTOUtils.arrayCopyOf(p_azioni, ICommand.class);
	}

	public String getNomeMetodo() {
		return nomeMetodo;
	}

	public void setNomeMetodo(String nomeMetodo) {
		this.nomeMetodo = nomeMetodo;
	}

	public String[] getAppDataToStore() {
		return (String[]) DTOUtils.arrayCopyOf(this.appDataToStore, String.class);
	}

	public void setAppDataToStore(String[] p_appDataToStore) {
		this.appDataToStore = (String[]) DTOUtils.arrayCopyOf(p_appDataToStore, String.class);
	}

	/**
	 * mappa <result,azione>
	 */
	java.util.Hashtable resultAzioni = new java.util.Hashtable();

	/**
	 * @param esiti elenco dei possibili esiti (restituiti dal metodo di business effettivo
	 * @param azioni elenco degli oggeti ICommand da eseguire a fronte di ciascun esito
	 * @param nomeMetodo nome del metodo del bean dello strato di business logic da eseguire
	 * @param appDataToStore elenco dei nomi degli application data modificati dalla logica di business
	 */
	public ExecCommand(String esiti[], ICommand[] azioni, String nomeMetodo, String appDataToStore[]) {
		this.setEsiti(esiti);
		this.setAzioni(azioni);
		this.nomeMetodo = nomeMetodo;
		this.setAppDataToStore(appDataToStore);
	}

	/**
	 * costruttore di default
	 */
	public ExecCommand() {
		/// costruttore intenzionalmente vuoto
	}

	private void initCommand() {
		if (this.esiti != null && this.resultAzioni.isEmpty()) {
			// riempio la mappa <esiti,azioni>
			for (int i = 0; i < this.esiti.length; i++)
				this.resultAzioni.put(this.esiti[i], this.azioni[i]);
		}
	}

	/**
	 * Esecuzione della logica di business.
	 * Il model su cui lavorera' il metodo di business e' estratto dalla action.
	 * viene quindi invocato il metodo di business tramite introspection e viene
	 * preparato il risultato da restituire al workflow di struts (aggiornando anche i
	 * messaggi con quanto eventualmente contenuto nell'oggetto ExecResult restituito 
	 * dal metodo di business.
	 */
	public String doCommand(BaseAction strutsAction) throws CommandExecutionException {
		initCommand();
		// action --> model
		Object theModel = strutsAction.toModel();
		// esecuzione azione
		ExecResults execResults = doLogic(theModel, strutsAction.getSpringBackEnd());
		String result = execResults.getResultCode();
		BaseSessionAwareDTO outModel = (BaseSessionAwareDTO) execResults.getModel();

		// model --> action
		strutsAction.fromModel(outModel);
		// impostazione degli appData
		storeAppData(execResults, strutsAction);
		// impostazione degli eventuali messaggi
		updateMessages(execResults.getFldErrors(), execResults.getGlobalErrors(), execResults.getGlobalMessages(),
				strutsAction);
		// determinazione esito e azione corrispondente
		ICommand resultAction = null;
		for (int i = 0; i < this.esiti.length; i++) {
			if (this.esiti[i].equals(result))
				resultAction = this.azioni[i];
		}
		// esecuzione azione conseguente all'esito
		if (resultAction != null) {
			return resultAction.doCommand(strutsAction);
		} else
			throw new IllegalStateException(
					"Il result code " + result + " non e' tra quelli previsti (" + (this.esiti) + ")");
	}

	/**
	 * inserisce negli appositi campi della action struts2 gli errori/messaggi provenienti dalla
	 * business logic.
	 */
	public void updateMessages(Map<String, String> fieldErrors, Collection<String> globalErrors,
			Collection<String> globalMessages, ActionSupport action) {
		if (fieldErrors != null) {
			Iterator<String> fieldKey_it = fieldErrors.keySet().iterator();
			while (fieldKey_it.hasNext()) {
				String currKey = fieldKey_it.next();
				action.addFieldError(currKey, fieldErrors.get(currKey));
			}
		}
		if (globalErrors != null) {
			Iterator<String> it = globalErrors.iterator();
			while (it.hasNext()) {
				action.addActionError(it.next());
			}
		}
		if (globalMessages != null) {
			Iterator<String> it = globalMessages.iterator();
			while (it.hasNext()) {
				action.addActionMessage(it.next());
			}
		}
	}

	/**
	 * Imposta in sessione o action i valori
	 * degli app data previsti dalla exec action
	 */
	public void storeAppData(ExecResults res, BaseAction strutsAction) throws CommandExecutionException {
		for (int i = 0; i < this.appDataToStore.length; i++) {
			storeSpecificAppData(this.appDataToStore[i], res.getModel(), strutsAction);
		}
	}

	/**
	 * Imposta in sessione o action il valore
	 * dell'app data previsto dalla exec action
	 */
	private void storeSpecificAppData(String nomeAppData, Object sourceModel, BaseAction targetAction)
			throws CommandExecutionException {

		try {
			java.lang.reflect.Method srcReadMethod = targetAction.findReadMethod(nomeAppData, sourceModel.getClass());
			if (srcReadMethod != null) {
				Object srcVal = srcReadMethod.invoke(sourceModel, new Object[]{});
				java.lang.reflect.Method currWriteMethod = targetAction.findWriteMethod(nomeAppData,
						targetAction.getClass());
				if (currWriteMethod != null) {
					currWriteMethod.invoke(targetAction, new Object[]{srcVal});
				}
			}
		} catch (Exception ioe) {
			throw new CommandExecutionException(
					"errore non gestito nell'esecuzione del metodo [" + (this.nomeMetodo) + "]:" + ioe.getMessage(),
					ioe);
		}
	}

	/**	
	 * Esegue la logica e restituisce il result_code corretto
	 */
	public ExecResults doLogic(Object theModel, BackEndFacade backEnd) throws CommandExecutionException {

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch(
				it.csi.sigit.sigitweba.util.Constants.APPLICATION_CODE);
		ExecResults result = null;

		try {

			watcher.start();
			Class cl = backEnd.getClass();
			Method m = cl.getMethod(this.nomeMetodo, new Class[]{theModel.getClass()});
			result = (ExecResults) m.invoke(backEnd, new Object[]{theModel});

			watcher.stop();
			watcher.dumpElapsed("ExecCommand", "readOne()", "chiamata verso BackEnd", this.nomeMetodo);
			return result;

		} catch (NoSuchMethodException ensm) {
			throw new CommandExecutionException(
					"errore non gestito nell'esecuzione del metodo [" + this.nomeMetodo + "]:" + ensm.getMessage(),
					ensm);
		} catch (IllegalAccessException eiacc) {
			throw new CommandExecutionException(
					"errore non gestito nell'esecuzione del metodo [" + this.nomeMetodo + "]:" + eiacc.getMessage(),
					eiacc);
		} catch (IllegalArgumentException eiarg) {
			throw new CommandExecutionException(
					"errore non gestito nell'esecuzione del metodo [" + this.nomeMetodo + "]:" + eiarg.getMessage(),
					eiarg);
		} catch (InvocationTargetException einvoc) {
			if (einvoc.getTargetException() instanceof BEException) {
				throw new CommandExecutionException("errore non gestito nell'esecuzione del metodo [" + this.nomeMetodo
						+ "]:" + einvoc.getMessage(), einvoc);
			} else {
				throw new CommandExecutionException("errore non gestito nell'esecuzione del metodo [" + this.nomeMetodo
						+ "]:" + einvoc.getMessage(), einvoc);
			}
		}
	}
}
