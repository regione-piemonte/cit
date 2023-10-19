package it.csi.sigit.elencom.dto;

import java.util.Map;
import java.util.List;
import org.apache.log4j.*;
import it.csi.sigit.elencom.util.*;
import it.csi.sigit.elencom.presentation.uiutils.*;
import flexjson.JSON;

/**
 * Superclasse astratta di tutti i DTO associati ai ContentPanel. 
 * I DTO associati ai content panel utilizzano la sessione applicativa per
 * la memorizzazione degli ApplicationData a scope 'session' o 'page'
 * @generated
 */
public abstract class BaseSessionAwareDTO implements java.io.Serializable {
	protected Map session;

	/**
	 * imposta un riferimento alla sessioen applicativa. Deve essere impostato in modo
	 * da condividere la sessione con la action
	 * @generated
	 */
	public void setSession(Map session) {
		this.session = session;
	}

	/**
	 * restituisce la sessione
	 * @generated
	 */
	public Map getSession() {
		return this.session;
	}

	////////////////////////////////////////////////////////
	/// property comuni a tutte le action
	/// (possono essere utilizzate effettivamente o meno
	/// a seconda che il ContentPanel  contenga o meno un
	/// TreeView, una Table, dei tab/wizard) 
	////////////////////////////////////////////////////////

	// nodo selezionato in un eventuale tree
	private String _idNodo = "";

	public void setIdNodo(String val) {
		_idNodo = val;
	}

	public String getIdNodo() {
		return _idNodo;
	}

	// riga selezionata in una eventuale tabella
	// NOTA: l'id della cella selezionata e' data da idRiga + idColonna
	private String idRiga = "";

	public void setIdRiga(String val) {
		idRiga = val;
	}

	public String getIdRiga() {
		return idRiga;
	}

	// colonna selezionata in una eventuale tabella
	// NOTA: l'id della cella selezionata e' data da idRiga + idColonna
	private String idColonna = "";

	public void setIdColonna(String val) {
		idColonna = val;
	}

	public String getIdColonna() {
		return idColonna;
	}

	/// parametri per cambio TAB

	private String selectedTabKey;

	public void setSelectedTabKey(String value) {
		selectedTabKey = value;
	}

	public String getSelectedTabKey() {
		return selectedTabKey;
	}

	private String selectedTabValue;

	public void setSelectedTabValue(String value) {
		selectedTabValue = value;
	}

	public String getSelectedTabValue() {
		return selectedTabValue;
	}

	/**
	 * @generated
	 */
	private List<TableFilter> filter;

	/**
	 * @generated
	 */
	public List<TableFilter> getFilter() {
		return filter;
	}

	/**
	 * @generated
	 */
	public void setFilter(List<TableFilter> filter) {
		this.filter = filter;
	}

	/**
	 * @generated
	 */
	private TableStatus tableStatus;

	/**
	 * @generated
	 */
	public TableStatus getTableStatus() {
		return tableStatus;
	}

	/**
	 * @generated
	 */
	public void setTableStatus(TableStatus tableStatus) {
		this.tableStatus = tableStatus;
	}

	/**  
	 * @generated
	 */
	protected static final Logger LOG = Logger.getLogger(Constants.APPLICATION_CODE + ".dto");

	/**
	 * dump di debug dello stato interno del DTO
	 * @generated
	 */
	public String dump() {
		StringBuffer sb = new StringBuffer();
		sb.append("" + getClass().getName() + "{\n");
		sb.append("\telenco fields:\n");
		java.beans.BeanInfo bi;
		try {
			bi = java.beans.Introspector.getBeanInfo(this.getClass());
			java.beans.PropertyDescriptor[] pds = bi.getPropertyDescriptors();
			for (int i = 0; i < pds.length; i++) {
				java.beans.PropertyDescriptor currPD = pds[i];
				java.lang.reflect.Method currReadMethod = currPD.getReadMethod();
				if (currReadMethod != null) {
					appendPropertyText(currReadMethod, currPD, this, sb);
				}
			}
		} catch (java.beans.IntrospectionException e) { //NOSONAR  Reason:dubbia classificazione severity
			// questo caso non dovrebbe mai presentarsi
			sb.append("<errore nell accesso ai campi>");
		}

		sb.append("\t\t");

		sb.append("\tsessione:\n");

		sb.append("}\n");
		return sb.toString();
	}

	private void appendPropertyText(java.lang.reflect.Method currReadMethod, java.beans.PropertyDescriptor currPD,
			Object target, StringBuffer sb) {
		try {
			Object srcVal = currReadMethod.invoke(target, new Object[]{});
			sb.append("\t\t" + currPD.getName() + "=" + srcVal + "\n");
		} catch (IllegalArgumentException e) { //NOSONAR  Reason:dubbia classificazione severity
			// questo caso non dovrebbe mai presentarsi
			sb.append("\t\t" + currPD.getName() + "= <errore nell'accesso>" + "\n");
		} catch (IllegalAccessException e) { //NOSONAR  Reason:dubbia classificazione severity
			// questo caso non dovrebbe mai presentarsi
			sb.append("\t\t" + currPD.getName() + "= <errore nell'accesso>" + "\n");
		} catch (java.lang.reflect.InvocationTargetException e) { //NOSONAR  Reason:dubbia classificazione severity
			// questo caso non dovrebbe mai presentarsi
			sb.append("\t\t" + currPD.getName() + "= <errore nell'accesso>" + "\n");
		}
	}
}
