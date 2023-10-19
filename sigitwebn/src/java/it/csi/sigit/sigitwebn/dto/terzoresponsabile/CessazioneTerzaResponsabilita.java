package it.csi.sigit.sigitwebn.dto.terzoresponsabile;

public class CessazioneTerzaResponsabilita implements java.io.Serializable {

	/// Field [idContratto]
	private java.lang.Integer idContratto = null;

	/**
	 * imposta il valore del campo [idContratto]
	 * @param val
	 * @generated
	 */

	public void setIdContratto(java.lang.Integer val) {
		idContratto = val;
	}

	/**
	 * legge il valore del campo [idContratto]
	 * @generated
	 */
	public java.lang.Integer getIdContratto() {
		return idContratto;
	}

	/// Field [idTipoCessazione]
	private java.lang.Integer idTipoCessazione = null;

	/**
	 * imposta il valore del campo [idTipoCessazione]
	 * @param val
	 * @generated
	 */

	public void setIdTipoCessazione(java.lang.Integer val) {
		idTipoCessazione = val;
	}

	/**
	 * legge il valore del campo [idTipoCessazione]
	 * @generated
	 */
	public java.lang.Integer getIdTipoCessazione() {
		return idTipoCessazione;
	}

	/// Field [dataCessazione]
	private java.lang.String dataCessazione = null;

	/**
	 * imposta il valore del campo [dataCessazione]
	 * @param val
	 * @generated
	 */

	public void setDataCessazione(java.lang.String val) {
		dataCessazione = val;
	}

	/**
	 * legge il valore del campo [dataCessazione]
	 * @generated
	 */
	public java.lang.String getDataCessazione() {
		return dataCessazione;
	}

	/// Field [motivoCessazione]
	private java.lang.String motivoCessazione = null;

	/**
	 * imposta il valore del campo [motivoCessazione]
	 * @param val
	 * @generated
	 */

	public void setMotivoCessazione(java.lang.String val) {
		motivoCessazione = val;
	}

	/**
	 * legge il valore del campo [motivoCessazione]
	 * @generated
	 */
	public java.lang.String getMotivoCessazione() {
		return motivoCessazione;
	}

	/// Field [elencoAutodichiarazioniSelezionate]
	private java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.IdDescription> elencoAutodichiarazioniSelezionate = new java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.IdDescription>();

	/**
	 * imposta il valore del campo [elencoAutodichiarazioniSelezionate]
	 * @param val
	 * @generated
	 */

	public void setElencoAutodichiarazioniSelezionate(
			java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.IdDescription> val) {
		elencoAutodichiarazioniSelezionate = val;
	}

	/**
	 * legge il valore del campo [elencoAutodichiarazioniSelezionate]
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.common.IdDescription> getElencoAutodichiarazioniSelezionate() {
		return elencoAutodichiarazioniSelezionate;
	}

	/// Field [desTipoCessazione]
	private java.lang.String desTipoCessazione = null;

	/**
	 * imposta il valore del campo [desTipoCessazione]
	 * @param val
	 * @generated
	 */

	public void setDesTipoCessazione(java.lang.String val) {
		desTipoCessazione = val;
	}

	/**
	 * legge il valore del campo [desTipoCessazione]
	 * @generated
	 */
	public java.lang.String getDesTipoCessazione() {
		return desTipoCessazione;
	}

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 * @generated
	 */
	public CessazioneTerzaResponsabilita() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R602121765) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
