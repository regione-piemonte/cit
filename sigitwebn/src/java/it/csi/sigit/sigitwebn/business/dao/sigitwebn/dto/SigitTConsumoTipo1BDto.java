package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Data transfer object relativo al DAO SigitTConsumoTipo1BDao.
 * @generated
 */
public class SigitTConsumoTipo1BDto extends SigitTConsumoTipo1BPk {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ESERCIZIO
	 * @generated
	 */
	protected java.math.BigDecimal esercizio;

	/**
	 * Imposta il valore della proprieta' esercizio associata alla
	 * colonna ESERCIZIO.
	 * @generated
	 */
	public void setEsercizio(java.math.BigDecimal val) {

		esercizio = val;

	}

	/**
	 * Legge il valore della proprieta' esercizio associata alla
	 * @generated
	 */
	public java.math.BigDecimal getEsercizio() {

		return esercizio;

	}

	/**
	 * store della proprieta' associata alla colonna LETTURA_INIZIALE
	 * @generated
	 */
	protected java.math.BigDecimal letturaIniziale;

	/**
	 * Imposta il valore della proprieta' letturaIniziale associata alla
	 * colonna LETTURA_INIZIALE.
	 * @generated
	 */
	public void setLetturaIniziale(java.math.BigDecimal val) {

		letturaIniziale = val;

	}

	/**
	 * Legge il valore della proprieta' letturaIniziale associata alla
	 * @generated
	 */
	public java.math.BigDecimal getLetturaIniziale() {

		return letturaIniziale;

	}

	/**
	 * store della proprieta' associata alla colonna LETTURA_FINALE
	 * @generated
	 */
	protected java.math.BigDecimal letturaFinale;

	/**
	 * Imposta il valore della proprieta' letturaFinale associata alla
	 * colonna LETTURA_FINALE.
	 * @generated
	 */
	public void setLetturaFinale(java.math.BigDecimal val) {

		letturaFinale = val;

	}

	/**
	 * Legge il valore della proprieta' letturaFinale associata alla
	 * @generated
	 */
	public java.math.BigDecimal getLetturaFinale() {

		return letturaFinale;

	}

	/**
	 * store della proprieta' associata alla colonna CONSUMO
	 * @generated
	 */
	protected java.math.BigDecimal consumo;

	/**
	 * Imposta il valore della proprieta' consumo associata alla
	 * colonna CONSUMO.
	 * @generated
	 */
	public void setConsumo(java.math.BigDecimal val) {

		consumo = val;

	}

	/**
	 * Legge il valore della proprieta' consumo associata alla
	 * @generated
	 */
	public java.math.BigDecimal getConsumo() {

		return consumo;

	}

	/**
	 * store della proprieta' associata alla colonna FK_ALLEGATO
	 * @generated
	 */
	protected java.math.BigDecimal fkAllegato;

	/**
	 * Imposta il valore della proprieta' fkAllegato associata alla
	 * colonna FK_ALLEGATO.
	 * @generated
	 */
	public void setFkAllegato(java.math.BigDecimal val) {

		fkAllegato = val;

	}

	/**
	 * Legge il valore della proprieta' fkAllegato associata alla
	 * @generated
	 */
	public java.math.BigDecimal getFkAllegato() {

		return fkAllegato;

	}

	/**
	 * store della proprieta' associata alla colonna ID_TIPO_CONSUMO_1B
	 * @generated
	 */
	protected java.math.BigDecimal idTipoConsumo1b;

	/**
	 * Imposta il valore della proprieta' idTipoConsumo1b associata alla
	 * colonna ID_TIPO_CONSUMO_1B.
	 * @generated
	 */
	public void setIdTipoConsumo1b(java.math.BigDecimal val) {

		idTipoConsumo1b = val;

	}

	/**
	 * Legge il valore della proprieta' idTipoConsumo1b associata alla
	 * @generated
	 */
	public java.math.BigDecimal getIdTipoConsumo1b() {

		return idTipoConsumo1b;

	}

	/**
	 * store della proprieta' associata alla colonna ID_UNITA_MISURA
	 * @generated
	 */
	protected String idUnitaMisura;

	/**
	 * Imposta il valore della proprieta' idUnitaMisura associata alla
	 * colonna ID_UNITA_MISURA.
	 * @generated
	 */
	public void setIdUnitaMisura(String val) {

		idUnitaMisura = val;

	}

	/**
	 * Legge il valore della proprieta' idUnitaMisura associata alla
	 * @generated
	 */
	public String getIdUnitaMisura() {

		return idUnitaMisura;

	}

	/**
	 * Crea una istanza di SigitTConsumoTipo1BPk a partire dal valore dei campi chiave del DTO
	 * 
	 * @return SigitTConsumoTipo1BPk
	 * @generated
	 */
	public SigitTConsumoTipo1BPk createPk() {
		return new SigitTConsumoTipo1BPk(idConsumoTipo1b);
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
