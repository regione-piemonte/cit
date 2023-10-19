package it.csi.sigit.sigitwebn.dto.libretto;

public class ConsumoAcqua implements java.io.Serializable {

	/// Field [unitaMisura]
	private java.lang.Integer unitaMisura = null;

	/**
	 * imposta il valore del campo [unitaMisura]
	 * @param val
	 * @generated
	 */

	public void setUnitaMisura(java.lang.Integer val) {
		unitaMisura = val;
	}

	/**
	 * legge il valore del campo [unitaMisura]
	 * @generated
	 */
	public java.lang.Integer getUnitaMisura() {
		return unitaMisura;
	}

	/// Field [listaConsumi]
	private java.util.ArrayList<it.csi.sigit.sigitwebn.dto.libretto.Consumo> listaConsumi = new java.util.ArrayList<it.csi.sigit.sigitwebn.dto.libretto.Consumo>();

	/**
	 * imposta il valore del campo [listaConsumi]
	 * @param val
	 * @generated
	 */

	public void setListaConsumi(java.util.ArrayList<it.csi.sigit.sigitwebn.dto.libretto.Consumo> val) {
		listaConsumi = val;
	}

	/**
	 * legge il valore del campo [listaConsumi]
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.libretto.Consumo> getListaConsumi() {
		return listaConsumi;
	}

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 * @generated
	 */
	public ConsumoAcqua() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R58327462) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
