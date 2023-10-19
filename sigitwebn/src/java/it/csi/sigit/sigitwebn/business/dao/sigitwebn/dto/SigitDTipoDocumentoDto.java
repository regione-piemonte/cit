package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Data transfer object relativo al DAO SigitDTipoDocumentoDao.
 * @generated
 */
public class SigitDTipoDocumentoDto extends SigitDTipoDocumentoPk {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna DES_TIPO_DOCUMENTO
	 * @generated
	 */
	protected String desTipoDocumento;

	/**
	 * Imposta il valore della proprieta' desTipoDocumento associata alla
	 * colonna DES_TIPO_DOCUMENTO.
	 * @generated
	 */
	public void setDesTipoDocumento(String val) {

		desTipoDocumento = val;

	}

	/**
	 * Legge il valore della proprieta' desTipoDocumento associata alla
	 * @generated
	 */
	public String getDesTipoDocumento() {

		return desTipoDocumento;

	}

	/**
	 * store della proprieta' associata alla colonna FLG_VISU_ELENCO_ALL
	 * @generated
	 */
	protected java.math.BigDecimal flgVisuElencoAll;

	/**
	 * Imposta il valore della proprieta' flgVisuElencoAll associata alla
	 * colonna FLG_VISU_ELENCO_ALL.
	 * @generated
	 */
	public void setFlgVisuElencoAll(java.math.BigDecimal val) {

		flgVisuElencoAll = val;

	}

	/**
	 * Legge il valore della proprieta' flgVisuElencoAll associata alla
	 * @generated
	 */
	public java.math.BigDecimal getFlgVisuElencoAll() {

		return flgVisuElencoAll;

	}

	/**
	 * store della proprieta' associata alla colonna FLG_RICERCA_ALL
	 * @generated
	 */
	protected java.math.BigDecimal flgRicercaAll;

	/**
	 * Imposta il valore della proprieta' flgRicercaAll associata alla
	 * colonna FLG_RICERCA_ALL.
	 * @generated
	 */
	public void setFlgRicercaAll(java.math.BigDecimal val) {

		flgRicercaAll = val;

	}

	/**
	 * Legge il valore della proprieta' flgRicercaAll associata alla
	 * @generated
	 */
	public java.math.BigDecimal getFlgRicercaAll() {

		return flgRicercaAll;

	}

	/**
	 * store della proprieta' associata alla colonna FLG_VISU_ELENCO_RAPPROVA
	 * @generated
	 */
	protected java.math.BigDecimal flgVisuElencoRapprova;

	/**
	 * Imposta il valore della proprieta' flgVisuElencoRapprova associata alla
	 * colonna FLG_VISU_ELENCO_RAPPROVA.
	 * @generated
	 */
	public void setFlgVisuElencoRapprova(java.math.BigDecimal val) {

		flgVisuElencoRapprova = val;

	}

	/**
	 * Legge il valore della proprieta' flgVisuElencoRapprova associata alla
	 * @generated
	 */
	public java.math.BigDecimal getFlgVisuElencoRapprova() {

		return flgVisuElencoRapprova;

	}

	/**
	 * store della proprieta' associata alla colonna FLG_VISU_ELENCO_MANUT
	 * @generated
	 */
	protected java.math.BigDecimal flgVisuElencoManut;

	/**
	 * Imposta il valore della proprieta' flgVisuElencoManut associata alla
	 * colonna FLG_VISU_ELENCO_MANUT.
	 * @generated
	 */
	public void setFlgVisuElencoManut(java.math.BigDecimal val) {

		flgVisuElencoManut = val;

	}

	/**
	 * Legge il valore della proprieta' flgVisuElencoManut associata alla
	 * @generated
	 */
	public java.math.BigDecimal getFlgVisuElencoManut() {

		return flgVisuElencoManut;

	}

	/**
	 * Crea una istanza di SigitDTipoDocumentoPk a partire dal valore dei campi chiave del DTO
	 * 
	 * @return SigitDTipoDocumentoPk
	 * @generated
	 */
	public SigitDTipoDocumentoPk createPk() {
		return new SigitDTipoDocumentoPk(idTipoDocumento);
	}

	/**
	 * la semantica dell'equals del DTO e' la stessa della PK
	 * (ovvero della superclasse).
	 * @param other l'oggetto con cui effettuare il confronto
	 * @return true se i due oggetti sono semanticamente da considerarsi uguali
	 */
	public boolean equals(Object other) {
		return super.equals(other);
	}

	/**
	 * la semantica dell'hashCode del DTO e' la stessa della PK
	 * (ovvero della superclasse).
	 * 
	 * @return int
	 */
	public int hashCode() {
		return super.hashCode();
	}

}
