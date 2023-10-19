package it.csi.sigit.elencom.dto;

/**
 * Contiene informazioni relative al singolo widget
 * @generated
 */
public class WidgetsStructure implements java.io.Serializable {

	private String widgetName;
	private boolean visible;
	private boolean disabled;

	/**
	 * @generated
	 */
	public String getWidgetName() {
		return widgetName;
	}
	/**
	 * @generated
	 */
	public void setWidgetName(String widgetName) {
		this.widgetName = widgetName;
	}
	/**
	 * @generated
	 */
	public boolean isVisible() {
		return visible;
	}
	/**
	 * @generated
	 */
	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	/**
	 * @generated
	 */
	public boolean isDisabled() {
		return disabled;
	}
	/**
	 * @generated
	 */
	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}

	/**
	 * costruttore
	 * @generated
	 */
	public WidgetsStructure() {
	}

	/**
	 * costruttore
	 * @generated
	 */
	public WidgetsStructure(String widgetName, boolean visible, boolean disabled) {
		this.widgetName = widgetName;
		this.visible = visible;
		this.disabled = disabled;
	}
}
