package it.csi.sigit.sigitwebn.dto;

/**
 * contiene la struttura del singolo multipanel
 * @generated
 */
public class MultiPanelStructure implements java.io.Serializable {
	private String selectedPanelKey;
	private String selectedPanelValue;
	public String getSelectedPanelKey() {
		return selectedPanelKey;
	}

	/**
	 * @generated
	 */
	public void setSelectedPanelKey(String selectedPanelKey) {
		this.selectedPanelKey = selectedPanelKey;
	}
	/**
	 * @generated
	 */
	public String getSelectedPanelValue() {
		return selectedPanelValue;
	}
	/**
	 * @generated
	 */
	public void setSelectedPanelValue(String selectedPanelValue) {
		this.selectedPanelValue = selectedPanelValue;
	}
	/**
	 * costruttore
	 * @generated
	 */
	public MultiPanelStructure() {
	}

	/**
	 * costruttore
	 * @generated
	 */
	public MultiPanelStructure(String selectedPanelKey, String selectedPanelValue) {
		this.selectedPanelKey = selectedPanelKey;
		this.selectedPanelValue = selectedPanelValue;
	}
}
