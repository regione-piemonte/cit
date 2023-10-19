package it.csi.sigit.sigitwebn.presentation.uiutils;

/**
 * Contiene lo stato della tabella dal punto di vista di:
 * - porzione di dati da visualizzare nella viewport
 * - ordinamento
 * @generated
 */
public class TableStatus implements java.io.Serializable {

	/**
	 * callback
	 */
	private String callback;

	/**
	 * start
	 */
	private String start;

	/**
	 * limit
	 */
	private String limit;

	/**
	 * sort
	 */
	private String sort;

	/**
	 * dir
	 */
	private String dir;
	/**
	 * parametro che contiene il nome dell'id del record
	 */
	private String valueSelector;
	/**
	 * parametro che contiene lo stato della tabella
	 * se impostato a true allora rimuove il relativo cookie dello stato.
	 */
	private boolean clearStatus;

	/**
	 * callback
	 */
	public String getCallback() {
		return callback;
	}

	/**
	 * callback
	 */
	public void setCallback(String callback) {
		this.callback = callback;
	}

	/**
	 * start
	 */
	public String getStart() {
		return start;
	}

	/**
	 * start
	 */
	public void setStart(String start) {
		this.start = start;
	}

	/**
	 * limit
	 */
	public String getLimit() {
		return limit;
	}

	/**
	 * limit
	 */
	public void setLimit(String limit) {
		this.limit = limit;
	}

	/**
	 * sort
	 */
	public String getSort() {
		return sort;
	}

	/**
	 * sort
	 */
	public void setSort(String sort) {
		this.sort = sort;
	}

	/**
	 * dir
	 */
	public String getDir() {
		return dir;
	}

	/**
	 * dir
	 */
	public void setDir(String dir) {
		this.dir = dir;
	}

	/**
	 * valueSelector
	 */
	public String getValueSelector() {
		return valueSelector;
	}

	/**
	 * valueSelector
	 */
	public void setValueSelector(String valueSelector) {
		this.valueSelector = valueSelector;
	}

	/**
	 * isClearStatus
	 */
	public boolean isClearStatus() {
		return clearStatus;
	}

	/**
	 * setClearStatus
	 */
	public void setClearStatus(boolean clearStatus) {
		this.clearStatus = clearStatus;
	}
}
