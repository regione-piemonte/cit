package it.csi.sigit.sigitwebn.dto.allegati;

public class AllegatiPerImpianto implements java.io.Serializable {

	/// Field [listaAllegati]
	private java.util.ArrayList<it.csi.sigit.sigitwebn.dto.allegati.DettaglioAllegato> listaAllegati = new java.util.ArrayList<it.csi.sigit.sigitwebn.dto.allegati.DettaglioAllegato>();

	/**
	 * imposta il valore del campo [listaAllegati]
	 * @param val
	 * @generated
	 */

	public void setListaAllegati(java.util.ArrayList<it.csi.sigit.sigitwebn.dto.allegati.DettaglioAllegato> val) {
		listaAllegati = val;
	}

	/**
	 * legge il valore del campo [listaAllegati]
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.allegati.DettaglioAllegato> getListaAllegati() {
		return listaAllegati;
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
	public AllegatiPerImpianto() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R492968538) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
