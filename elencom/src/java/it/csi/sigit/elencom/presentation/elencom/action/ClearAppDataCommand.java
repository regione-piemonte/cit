
package it.csi.sigit.elencom.presentation.elencom.action;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import it.csi.sigit.elencom.dto.DTOUtils;

/**
 * Implementazione del comando ClearAppDataCommand.
 */
public class ClearAppDataCommand implements ICommand {
	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per poter essere inserita in sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	private String[] attributesToBeRemovedFromSession = null;

	public String[] getAttributesToBeRemovedFromSession() {
		return (String[]) DTOUtils.arrayCopyOf(this.attributesToBeRemovedFromSession, String.class);
	}

	public void setAttributesToBeRemovedFromSession(String[] p_attributesToBeRemovedFromSession) {
		this.attributesToBeRemovedFromSession = (String[]) DTOUtils.arrayCopyOf(p_attributesToBeRemovedFromSession,
				String.class);
	}

	/**
	 * @param nomi degli application data da cancellare
	 */
	public ClearAppDataCommand(String[] attributesToBeRemovedFromSession) {
		this.setAttributesToBeRemovedFromSession(attributesToBeRemovedFromSession);
	}

	/**
	 * costruttore di default
	 */
	public ClearAppDataCommand() {
		/// costruttore intenzionalmente vuoto
	}

	/**
	 * Implementazione del comando clearAppdataCommand. 
	 * Il comando rimuove dalla sessione gli attributi corrispondenti
	 * agli application data elencati in attributesToBeRemovedFromSession
	 */
	public String doCommand(BaseAction strutsAction) throws CommandExecutionException {
		if (this.attributesToBeRemovedFromSession != null && this.attributesToBeRemovedFromSession.length != 0) {
			for (int i = 0; i < this.attributesToBeRemovedFromSession.length; i++) {
				clearAppDataFromModel(strutsAction.getModel(), "appData" + (this.attributesToBeRemovedFromSession[i]));
			}
		}
		return null;
	}

	private void clearAppDataFromModel(Object model, String name) {
		Class modelClass = model.getClass();
		try {
			BeanInfo bi = Introspector.getBeanInfo(modelClass);
			PropertyDescriptor[] pds = bi.getPropertyDescriptors();
			for (int i = 0; i < pds.length; i++) {
				PropertyDescriptor currPD = pds[i];
				if (currPD.getName().equals(name)) {
					Method writeMethod = currPD.getWriteMethod();
					writeMethod.invoke(model, new Object[]{(Object) null});
				}
			}
		} catch (IntrospectionException e) { //NOSONAR  Reason:dubbia classificazione severity
			;;
		} catch (IllegalArgumentException e) { //NOSONAR  Reason:dubbia classificazione severity
			;;
		} catch (IllegalAccessException e) { //NOSONAR  Reason:dubbia classificazione severity
			;;
		} catch (InvocationTargetException e) { //NOSONAR  Reason:dubbia classificazione severity
			;;
		}
	}
};
