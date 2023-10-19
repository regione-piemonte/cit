package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Data transfer object relativo al DAO SigitTAllTxtDao.
 * @generated
 */
public class SigitTAllTxtDto extends SigitTAllTxtPk {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna XML_ALLEGATO
	 * @generated
	 */
	protected String xmlAllegato;

	/**
	 * Imposta il valore della proprieta' xmlAllegato associata alla
	 * colonna XML_ALLEGATO.
	 * @generated
	 */
	public void setXmlAllegato(String val) {

		xmlAllegato = val;

	}

	/**
	 * Legge il valore della proprieta' xmlAllegato associata alla
	 * @generated
	 */
	public String getXmlAllegato() {

		return xmlAllegato;

	}

	/**
	 * Crea una istanza di SigitTAllTxtPk a partire dal valore dei campi chiave del DTO
	 * 
	 * @return SigitTAllTxtPk
	 * @generated
	 */
	public SigitTAllTxtPk createPk() {
		return new SigitTAllTxtPk(idAllegato);
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
