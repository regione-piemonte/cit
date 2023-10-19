package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Data transfer object relativo al DAO SigitRIspezIspetDao.
 * @generated
 */
public class SigitRIspezIspetDto extends SigitRIspezIspetPk {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna FK_RUOLO
	 * @generated
	 */
	protected java.math.BigDecimal fkRuolo;

	/**
	 * Imposta il valore della proprieta' fkRuolo associata alla
	 * colonna FK_RUOLO.
	 * @generated
	 */
	public void setFkRuolo(java.math.BigDecimal val) {

		fkRuolo = val;

	}

	/**
	 * Legge il valore della proprieta' fkRuolo associata alla
	 * @generated
	 */
	public java.math.BigDecimal getFkRuolo() {

		return fkRuolo;

	}

	/**
	 * store della proprieta' associata alla colonna DATA_INIZIO
	 * @generated
	 */
	protected java.sql.Date dataInizio;

	/**
	 * Imposta il valore della proprieta' dataInizio associata alla
	 * colonna DATA_INIZIO.
	 * @generated
	 */
	public void setDataInizio(java.sql.Date val) {

		if (val != null) {
			dataInizio = new java.sql.Date(val.getTime());
		} else {
			dataInizio = null;
		}

	}

	/**
	 * Legge il valore della proprieta' dataInizio associata alla
	 * @generated
	 */
	public java.sql.Date getDataInizio() {

		if (dataInizio != null) {
			return new java.sql.Date(dataInizio.getTime());
		} else {
			return null;
		}

	}

	/**
	 * store della proprieta' associata alla colonna DATA_FINE
	 * @generated
	 */
	protected java.sql.Date dataFine;

	/**
	 * Imposta il valore della proprieta' dataFine associata alla
	 * colonna DATA_FINE.
	 * @generated
	 */
	public void setDataFine(java.sql.Date val) {

		if (val != null) {
			dataFine = new java.sql.Date(val.getTime());
		} else {
			dataFine = null;
		}

	}

	/**
	 * Legge il valore della proprieta' dataFine associata alla
	 * @generated
	 */
	public java.sql.Date getDataFine() {

		if (dataFine != null) {
			return new java.sql.Date(dataFine.getTime());
		} else {
			return null;
		}

	}

	/**
	 * store della proprieta' associata alla colonna FK_PERSONA_FISICA
	 * @generated
	 */
	protected java.math.BigDecimal fkPersonaFisica;

	/**
	 * Imposta il valore della proprieta' fkPersonaFisica associata alla
	 * colonna FK_PERSONA_FISICA.
	 * @generated
	 */
	public void setFkPersonaFisica(java.math.BigDecimal val) {

		fkPersonaFisica = val;

	}

	/**
	 * Legge il valore della proprieta' fkPersonaFisica associata alla
	 * @generated
	 */
	public java.math.BigDecimal getFkPersonaFisica() {

		return fkPersonaFisica;

	}

	/**
	 * store della proprieta' associata alla colonna FK_PERSONA_GIURIDICA
	 * @generated
	 */
	protected java.math.BigDecimal fkPersonaGiuridica;

	/**
	 * Imposta il valore della proprieta' fkPersonaGiuridica associata alla
	 * colonna FK_PERSONA_GIURIDICA.
	 * @generated
	 */
	public void setFkPersonaGiuridica(java.math.BigDecimal val) {

		fkPersonaGiuridica = val;

	}

	/**
	 * Legge il valore della proprieta' fkPersonaGiuridica associata alla
	 * @generated
	 */
	public java.math.BigDecimal getFkPersonaGiuridica() {

		return fkPersonaGiuridica;

	}

	/**
	 * store della proprieta' associata alla colonna DATA_ULT_MOD
	 * @generated
	 */
	protected java.sql.Timestamp dataUltMod;

	/**
	 * Imposta il valore della proprieta' dataUltMod associata alla
	 * colonna DATA_ULT_MOD.
	 * @generated
	 */
	public void setDataUltMod(java.sql.Timestamp val) {

		if (val != null) {
			dataUltMod = new java.sql.Timestamp(val.getTime());
		} else {
			dataUltMod = null;
		}

	}

	/**
	 * Legge il valore della proprieta' dataUltMod associata alla
	 * @generated
	 */
	public java.sql.Timestamp getDataUltMod() {

		if (dataUltMod != null) {
			return new java.sql.Timestamp(dataUltMod.getTime());
		} else {
			return null;
		}

	}

	/**
	 * store della proprieta' associata alla colonna UTENTE_ULT_MOD
	 * @generated
	 */
	protected String utenteUltMod;

	/**
	 * Imposta il valore della proprieta' utenteUltMod associata alla
	 * colonna UTENTE_ULT_MOD.
	 * @generated
	 */
	public void setUtenteUltMod(String val) {

		utenteUltMod = val;

	}

	/**
	 * Legge il valore della proprieta' utenteUltMod associata alla
	 * @generated
	 */
	public String getUtenteUltMod() {

		return utenteUltMod;

	}

	/**
	 * store della proprieta' associata alla colonna FLG_PRIMO_CARICATORE
	 * @generated
	 */
	protected java.math.BigDecimal flgPrimoCaricatore;

	/**
	 * Imposta il valore della proprieta' flgPrimoCaricatore associata alla
	 * colonna FLG_PRIMO_CARICATORE.
	 * @generated
	 */
	public void setFlgPrimoCaricatore(java.math.BigDecimal val) {

		flgPrimoCaricatore = val;

	}

	/**
	 * Legge il valore della proprieta' flgPrimoCaricatore associata alla
	 * @generated
	 */
	public java.math.BigDecimal getFlgPrimoCaricatore() {

		return flgPrimoCaricatore;

	}

	/**
	 * store della proprieta' associata alla colonna ID_ISPEZIONE_2018
	 * @generated
	 */
	protected Integer idIspezione2018;

	/**
	 * Imposta il valore della proprieta' idIspezione2018 associata alla
	 * colonna ID_ISPEZIONE_2018.
	 * @generated
	 */
	public void setIdIspezione2018(Integer val) {

		idIspezione2018 = val;

	}

	/**
	 * Legge il valore della proprieta' idIspezione2018 associata alla
	 * @generated
	 */
	public Integer getIdIspezione2018() {

		return idIspezione2018;

	}

	/**
	 * Crea una istanza di SigitRIspezIspetPk a partire dal valore dei campi chiave del DTO
	 * 
	 * @return SigitRIspezIspetPk
	 * @generated
	 */
	public SigitRIspezIspetPk createPk() {
		return new SigitRIspezIspetPk(idIspezIspet);
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
