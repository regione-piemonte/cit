package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Data transfer object relativo al DAO SigitTRifCatastDao.
 * @generated
 */
public class SigitTRifCatastDto extends SigitTRifCatastPk {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna FK_DATO_DISTRIB
	 * @generated
	 */
	protected Integer fkDatoDistrib;

	/**
	 * Imposta il valore della proprieta' fkDatoDistrib associata alla
	 * colonna FK_DATO_DISTRIB.
	 * @generated
	 */
	public void setFkDatoDistrib(Integer val) {

		fkDatoDistrib = val;

	}

	/**
	 * Legge il valore della proprieta' fkDatoDistrib associata alla
	 * @generated
	 */
	public Integer getFkDatoDistrib() {

		return fkDatoDistrib;

	}

	/**
	 * store della proprieta' associata alla colonna SEZIONE
	 * @generated
	 */
	protected String sezione;

	/**
	 * Imposta il valore della proprieta' sezione associata alla
	 * colonna SEZIONE.
	 * @generated
	 */
	public void setSezione(String val) {

		sezione = val;

	}

	/**
	 * Legge il valore della proprieta' sezione associata alla
	 * @generated
	 */
	public String getSezione() {

		return sezione;

	}

	/**
	 * store della proprieta' associata alla colonna FOGLIO
	 * @generated
	 */
	protected String foglio;

	/**
	 * Imposta il valore della proprieta' foglio associata alla
	 * colonna FOGLIO.
	 * @generated
	 */
	public void setFoglio(String val) {

		foglio = val;

	}

	/**
	 * Legge il valore della proprieta' foglio associata alla
	 * @generated
	 */
	public String getFoglio() {

		return foglio;

	}

	/**
	 * store della proprieta' associata alla colonna PARTICELLA
	 * @generated
	 */
	protected String particella;

	/**
	 * Imposta il valore della proprieta' particella associata alla
	 * colonna PARTICELLA.
	 * @generated
	 */
	public void setParticella(String val) {

		particella = val;

	}

	/**
	 * Legge il valore della proprieta' particella associata alla
	 * @generated
	 */
	public String getParticella() {

		return particella;

	}

	/**
	 * store della proprieta' associata alla colonna SUBALTERNO
	 * @generated
	 */
	protected String subalterno;

	/**
	 * Imposta il valore della proprieta' subalterno associata alla
	 * colonna SUBALTERNO.
	 * @generated
	 */
	public void setSubalterno(String val) {

		subalterno = val;

	}

	/**
	 * Legge il valore della proprieta' subalterno associata alla
	 * @generated
	 */
	public String getSubalterno() {

		return subalterno;

	}

	/**
	 * Crea una istanza di SigitTRifCatastPk a partire dal valore dei campi chiave del DTO
	 * 
	 * @return SigitTRifCatastPk
	 * @generated
	 */
	public SigitTRifCatastPk createPk() {
		return new SigitTRifCatastPk(idRifCatast);
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
