package it.csi.sigit.sigitwebn.dto.libretto;

public class ComponenteCS implements java.io.Serializable {

	/// Field [idComponente]
	private java.lang.String idComponente = null;

	/**
	 * imposta il valore del campo [idComponente]
	 * @param val
	 * @generated
	 */

	public void setIdComponente(java.lang.String val) {
		idComponente = val;
	}

	/**
	 * legge il valore del campo [idComponente]
	 * @generated
	 */
	public java.lang.String getIdComponente() {
		return idComponente;
	}

	/// Field [idTipoComponente]
	private java.lang.String idTipoComponente = null;

	/**
	 * imposta il valore del campo [idTipoComponente]
	 * @param val
	 * @generated
	 */

	public void setIdTipoComponente(java.lang.String val) {
		idTipoComponente = val;
	}

	/**
	 * legge il valore del campo [idTipoComponente]
	 * @generated
	 */
	public java.lang.String getIdTipoComponente() {
		return idTipoComponente;
	}

	/// Field [progrComponente]
	private java.lang.String progrComponente = null;

	/**
	 * imposta il valore del campo [progrComponente]
	 * @param val
	 * @generated
	 */

	public void setProgrComponente(java.lang.String val) {
		progrComponente = val;
	}

	/**
	 * legge il valore del campo [progrComponente]
	 * @generated
	 */
	public java.lang.String getProgrComponente() {
		return progrComponente;
	}

	/// Field [dataInstallazione]
	private java.lang.String dataInstallazione = null;

	/**
	 * imposta il valore del campo [dataInstallazione]
	 * @param val
	 * @generated
	 */

	public void setDataInstallazione(java.lang.String val) {
		dataInstallazione = val;
	}

	/**
	 * legge il valore del campo [dataInstallazione]
	 * @generated
	 */
	public java.lang.String getDataInstallazione() {
		return dataInstallazione;
	}

	/// Field [dataDismissione]
	private java.lang.String dataDismissione = null;

	/**
	 * imposta il valore del campo [dataDismissione]
	 * @param val
	 * @generated
	 */

	public void setDataDismissione(java.lang.String val) {
		dataDismissione = val;
	}

	/**
	 * legge il valore del campo [dataDismissione]
	 * @generated
	 */
	public java.lang.String getDataDismissione() {
		return dataDismissione;
	}

	/// Field [idFabbricante]
	private java.lang.Integer idFabbricante = null;

	/**
	 * imposta il valore del campo [idFabbricante]
	 * @param val
	 * @generated
	 */

	public void setIdFabbricante(java.lang.Integer val) {
		idFabbricante = val;
	}

	/**
	 * legge il valore del campo [idFabbricante]
	 * @generated
	 */
	public java.lang.Integer getIdFabbricante() {
		return idFabbricante;
	}

	/// Field [descFabbricante]
	private java.lang.String descFabbricante = null;

	/**
	 * imposta il valore del campo [descFabbricante]
	 * @param val
	 * @generated
	 */

	public void setDescFabbricante(java.lang.String val) {
		descFabbricante = val;
	}

	/**
	 * legge il valore del campo [descFabbricante]
	 * @generated
	 */
	public java.lang.String getDescFabbricante() {
		return descFabbricante;
	}

	/// Field [collettori]
	private java.lang.String collettori = null;

	/**
	 * imposta il valore del campo [collettori]
	 * @param val
	 * @generated
	 */

	public void setCollettori(java.lang.String val) {
		collettori = val;
	}

	/**
	 * legge il valore del campo [collettori]
	 * @generated
	 */
	public java.lang.String getCollettori() {
		return collettori;
	}

	/// Field [supTotAp]
	private java.lang.String supTotAp = null;

	/**
	 * imposta il valore del campo [supTotAp]
	 * @param val
	 * @generated
	 */

	public void setSupTotAp(java.lang.String val) {
		supTotAp = val;
	}

	/**
	 * legge il valore del campo [supTotAp]
	 * @generated
	 */
	public java.lang.String getSupTotAp() {
		return supTotAp;
	}

	/// Field [ripristina]
	private java.lang.String ripristina = null;

	/**
	 * imposta il valore del campo [ripristina]
	 * @param val
	 * @generated
	 */

	public void setRipristina(java.lang.String val) {
		ripristina = val;
	}

	/**
	 * legge il valore del campo [ripristina]
	 * @generated
	 */
	public java.lang.String getRipristina() {
		return ripristina;
	}

	/// Field [ripristinaAttivabile]
	private java.lang.Boolean ripristinaAttivabile = null;

	/**
	 * imposta il valore del campo [ripristinaAttivabile]
	 * @param val
	 * @generated
	 */

	public void setRipristinaAttivabile(java.lang.Boolean val) {
		ripristinaAttivabile = val;
	}

	/**
	 * legge il valore del campo [ripristinaAttivabile]
	 * @generated
	 */
	public java.lang.Boolean getRipristinaAttivabile() {
		return ripristinaAttivabile;
	}

	/// Field [flgDismesso]
	private boolean flgDismesso = false;

	/**
	 * imposta il valore del campo [flgDismesso]
	 * @param val
	 * @generated
	 */

	public void setFlgDismesso(boolean val) {
		flgDismesso = val;
	}

	/**
	 * legge il valore del campo [flgDismesso]
	 * @generated
	 */
	public boolean getFlgDismesso() {
		return flgDismesso;
	}

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 * @generated
	 */
	public ComponenteCS() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R766931241) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
