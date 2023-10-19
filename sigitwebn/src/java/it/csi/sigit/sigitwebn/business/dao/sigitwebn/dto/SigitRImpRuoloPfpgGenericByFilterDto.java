package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * DTO specifico della query modellata nel finder genericByFilter.
 * @generated
 */
public class SigitRImpRuoloPfpgGenericByFilterDto implements Serializable {

	/*	 
	 * @generated
	 */
	private java.math.BigDecimal idImpRuoloPgPf;

	/**
	 * @generated
	 */
	public void setIdImpRuoloPgPf(java.math.BigDecimal val) {

		idImpRuoloPgPf = val;

	}
	/**
	 * @generated
	 */
	public java.math.BigDecimal getIdImpRuoloPgPf() {

		return idImpRuoloPgPf;

	}

	/*	 
	 * @generated
	 */
	private java.math.BigDecimal codiceImpianto;

	/**
	 * @generated
	 */
	public void setCodiceImpianto(java.math.BigDecimal val) {

		codiceImpianto = val;

	}
	/**
	 * @generated
	 */
	public java.math.BigDecimal getCodiceImpianto() {

		return codiceImpianto;

	}

	/*	 
	 * @generated
	 */
	private java.sql.Date dataInizio;

	/**
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
	 * @generated
	 */
	public java.sql.Date getDataInizio() {

		if (dataInizio != null) {
			return new java.sql.Date(dataInizio.getTime());
		} else {
			return null;
		}

	}

	/*	 
	 * @generated
	 */
	private java.sql.Date dataFine;

	/**
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
	 * @generated
	 */
	public java.sql.Date getDataFine() {

		if (dataFine != null) {
			return new java.sql.Date(dataFine.getTime());
		} else {
			return null;
		}

	}

	/*	 
	 * @generated
	 */
	private java.math.BigDecimal idPersonaFisica;

	/**
	 * @generated
	 */
	public void setIdPersonaFisica(java.math.BigDecimal val) {

		idPersonaFisica = val;

	}
	/**
	 * @generated
	 */
	public java.math.BigDecimal getIdPersonaFisica() {

		return idPersonaFisica;

	}

	/*	 
	 * @generated
	 */
	private java.math.BigDecimal idPersonaGiuridica;

	/**
	 * @generated
	 */
	public void setIdPersonaGiuridica(java.math.BigDecimal val) {

		idPersonaGiuridica = val;

	}
	/**
	 * @generated
	 */
	public java.math.BigDecimal getIdPersonaGiuridica() {

		return idPersonaGiuridica;

	}

	/*	 
	 * @generated
	 */
	private String desRuolo;

	/**
	 * @generated
	 */
	public void setDesRuolo(String val) {

		desRuolo = val;

	}
	/**
	 * @generated
	 */
	public String getDesRuolo() {

		return desRuolo;

	}

	/*	 
	 * @generated
	 */
	private String ruoloFunz;

	/**
	 * @generated
	 */
	public void setRuoloFunz(String val) {

		ruoloFunz = val;

	}
	/**
	 * @generated
	 */
	public String getRuoloFunz() {

		return ruoloFunz;

	}

	/**
	 * Method 'equals'
	 * 
	 * @param _other
	 * @return boolean
	 * @generated
	 */
	public boolean equals(Object _other) {
		return super.equals(_other);
	}

	/**
	 * Method 'hashCode'
	 * 
	 * @return int
	 * @generated
	 */
	public int hashCode() {
		return super.hashCode();
	}

}
