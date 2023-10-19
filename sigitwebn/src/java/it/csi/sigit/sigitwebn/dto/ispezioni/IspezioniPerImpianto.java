package it.csi.sigit.sigitwebn.dto.ispezioni;

public class IspezioniPerImpianto implements java.io.Serializable {

	/// Field [listaIspezioni]
	private java.util.ArrayList<it.csi.sigit.sigitwebn.dto.ispezioni.DettaglioIspezione> listaIspezioni = new java.util.ArrayList<it.csi.sigit.sigitwebn.dto.ispezioni.DettaglioIspezione>();

	/**
	 * imposta il valore del campo [listaIspezioni]
	 * @param val
	 * @generated
	 */

	public void setListaIspezioni(java.util.ArrayList<it.csi.sigit.sigitwebn.dto.ispezioni.DettaglioIspezione> val) {
		listaIspezioni = val;
	}

	/**
	 * legge il valore del campo [listaIspezioni]
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.ispezioni.DettaglioIspezione> getListaIspezioni() {
		return listaIspezioni;
	}

	/// Field [identificativoImpianto]
	private it.csi.sigit.sigitwebn.dto.impianto.IdentificativoImpianto identificativoImpianto = null;

	/**
	 * imposta il valore del campo [identificativoImpianto]
	 * @param val
	 * @generated
	 */

	public void setIdentificativoImpianto(it.csi.sigit.sigitwebn.dto.impianto.IdentificativoImpianto val) {
		identificativoImpianto = val;
	}

	/**
	 * legge il valore del campo [identificativoImpianto]
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.impianto.IdentificativoImpianto getIdentificativoImpianto() {
		return identificativoImpianto;
	}

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 * @generated
	 */
	public IspezioniPerImpianto() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R404646080) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
