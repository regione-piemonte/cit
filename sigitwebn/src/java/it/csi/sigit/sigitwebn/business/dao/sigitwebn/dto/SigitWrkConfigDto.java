package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Data transfer object relativo al DAO SigitWrkConfigDao.
 * @generated
 */
public class SigitWrkConfigDto extends SigitWrkConfigPk {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna CHIAVE_CONFIG
	 * @generated
	 */
	protected String chiaveConfig;

	/**
	 * Imposta il valore della proprieta' chiaveConfig associata alla
	 * colonna CHIAVE_CONFIG.
	 * @generated
	 */
	public void setChiaveConfig(String val) {

		chiaveConfig = val;

	}

	/**
	 * Legge il valore della proprieta' chiaveConfig associata alla
	 * @generated
	 */
	public String getChiaveConfig() {

		return chiaveConfig;

	}

	/**
	 * store della proprieta' associata alla colonna VALORE_CONFIG_NUM
	 * @generated
	 */
	protected java.math.BigDecimal valoreConfigNum;

	/**
	 * Imposta il valore della proprieta' valoreConfigNum associata alla
	 * colonna VALORE_CONFIG_NUM.
	 * @generated
	 */
	public void setValoreConfigNum(java.math.BigDecimal val) {

		valoreConfigNum = val;

	}

	/**
	 * Legge il valore della proprieta' valoreConfigNum associata alla
	 * @generated
	 */
	public java.math.BigDecimal getValoreConfigNum() {

		return valoreConfigNum;

	}

	/**
	 * store della proprieta' associata alla colonna VALORE_CONFIG_CHAR
	 * @generated
	 */
	protected String valoreConfigChar;

	/**
	 * Imposta il valore della proprieta' valoreConfigChar associata alla
	 * colonna VALORE_CONFIG_CHAR.
	 * @generated
	 */
	public void setValoreConfigChar(String val) {

		valoreConfigChar = val;

	}

	/**
	 * Legge il valore della proprieta' valoreConfigChar associata alla
	 * @generated
	 */
	public String getValoreConfigChar() {

		return valoreConfigChar;

	}

	/**
	 * store della proprieta' associata alla colonna VALORE_FLAG
	 * @generated
	 */
	protected String valoreFlag;

	/**
	 * Imposta il valore della proprieta' valoreFlag associata alla
	 * colonna VALORE_FLAG.
	 * @generated
	 */
	public void setValoreFlag(String val) {

		valoreFlag = val;

	}

	/**
	 * Legge il valore della proprieta' valoreFlag associata alla
	 * @generated
	 */
	public String getValoreFlag() {

		return valoreFlag;

	}

	/**
	 * Crea una istanza di SigitWrkConfigPk a partire dal valore dei campi chiave del DTO
	 * 
	 * @return SigitWrkConfigPk
	 * @generated
	 */
	public SigitWrkConfigPk createPk() {
		return new SigitWrkConfigPk(idConfig);
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
