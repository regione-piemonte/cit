package it.csi.sigit.sigitwebn.dto.userws;

public class UserWs implements java.io.Serializable {

	/// Field [idUserWs]
	private java.lang.Integer idUserWs = null;

	/**
	 * imposta il valore del campo [idUserWs]
	 * @param val
	 * @generated
	 */

	public void setIdUserWs(java.lang.Integer val) {
		idUserWs = val;
	}

	/**
	 * legge il valore del campo [idUserWs]
	 * @generated
	 */
	public java.lang.Integer getIdUserWs() {
		return idUserWs;
	}

	/// Field [userWs]
	private java.lang.String userWs = null;

	/**
	 * imposta il valore del campo [userWs]
	 * @param val
	 * @generated
	 */

	public void setUserWs(java.lang.String val) {
		userWs = val;
	}

	/**
	 * legge il valore del campo [userWs]
	 * @generated
	 */
	public java.lang.String getUserWs() {
		return userWs;
	}

	/// Field [dtCreazioneToken]
	private java.lang.String dtCreazioneToken = null;

	/**
	 * imposta il valore del campo [dtCreazioneToken]
	 * @param val
	 * @generated
	 */

	public void setDtCreazioneToken(java.lang.String val) {
		dtCreazioneToken = val;
	}

	/**
	 * legge il valore del campo [dtCreazioneToken]
	 * @generated
	 */
	public java.lang.String getDtCreazioneToken() {
		return dtCreazioneToken;
	}

	/// Field [dtScadenzaToken]
	private java.lang.String dtScadenzaToken = null;

	/**
	 * imposta il valore del campo [dtScadenzaToken]
	 * @param val
	 * @generated
	 */

	public void setDtScadenzaToken(java.lang.String val) {
		dtScadenzaToken = val;
	}

	/**
	 * legge il valore del campo [dtScadenzaToken]
	 * @generated
	 */
	public java.lang.String getDtScadenzaToken() {
		return dtScadenzaToken;
	}

	/// Field [token]
	private java.lang.String token = null;

	/**
	 * imposta il valore del campo [token]
	 * @param val
	 * @generated
	 */

	public void setToken(java.lang.String val) {
		token = val;
	}

	/**
	 * legge il valore del campo [token]
	 * @generated
	 */
	public java.lang.String getToken() {
		return token;
	}

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 * @generated
	 */
	public UserWs() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R-439990168) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
