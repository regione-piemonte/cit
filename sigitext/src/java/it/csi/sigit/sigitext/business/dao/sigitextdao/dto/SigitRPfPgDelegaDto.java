package it.csi.sigit.sigitext.business.dao.sigitextdao.dto;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.*;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Data transfer object relativo al DAO SigitRPfPgDelegaDao.
 * @generated
 */
public class SigitRPfPgDelegaDto extends SigitRPfPgDelegaPk {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna FK_RUOLO_ACCRED
	 * @generated
	 */
	protected java.math.BigDecimal fkRuoloAccred;

	/**
	 * Imposta il valore della proprieta' fkRuoloAccred associata alla
	 * colonna FK_RUOLO_ACCRED.
	 * @generated
	 */
	public void setFkRuoloAccred(java.math.BigDecimal val) {

		fkRuoloAccred = val;

	}

	/**
	 * Legge il valore della proprieta' fkRuoloAccred associata alla
	 * @generated
	 */
	public java.math.BigDecimal getFkRuoloAccred() {

		return fkRuoloAccred;

	}

	/**
	 * store della proprieta' associata alla colonna FK_TIPO_DM
	 * @generated
	 */
	protected String fkTipoDm;

	/**
	 * Imposta il valore della proprieta' fkTipoDm associata alla
	 * colonna FK_TIPO_DM.
	 * @generated
	 */
	public void setFkTipoDm(String val) {

		fkTipoDm = val;

	}

	/**
	 * Legge il valore della proprieta' fkTipoDm associata alla
	 * @generated
	 */
	public String getFkTipoDm() {

		return fkTipoDm;

	}

	/**
	 * store della proprieta' associata alla colonna FLG_DELEGA
	 * @generated
	 */
	protected String flgDelega;

	/**
	 * Imposta il valore della proprieta' flgDelega associata alla
	 * colonna FLG_DELEGA.
	 * @generated
	 */
	public void setFlgDelega(String val) {

		flgDelega = val;

	}

	/**
	 * Legge il valore della proprieta' flgDelega associata alla
	 * @generated
	 */
	public String getFlgDelega() {

		return flgDelega;

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
	 * Crea una istanza di SigitRPfPgDelegaPk a partire dal valore dei campi chiave del DTO
	 * 
	 * @return SigitRPfPgDelegaPk
	 * @generated
	 */
	public SigitRPfPgDelegaPk createPk() {
		return new SigitRPfPgDelegaPk(idPersonaFisica, idPersonaGiuridica, dataInizio);
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
