package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * DTO specifico della query modellata nel finder byCodiceImpiantoNonBozza.
 * @generated
 */
public class SigitSLibrettoByCodiceImpiantoNonBozzaDto implements Serializable {

	/*	 
	 * @generated
	 */
	private java.math.BigDecimal libIdLibretto;

	/**
	 * @generated
	 */
	public void setLibIdLibretto(java.math.BigDecimal val) {

		libIdLibretto = val;

	}
	/**
	 * @generated
	 */
	public java.math.BigDecimal getLibIdLibretto() {

		return libIdLibretto;

	}

	/*	 
	 * @generated
	 */
	private java.sql.Date libDataConsolidamento;

	/**
	 * @generated
	 */
	public void setLibDataConsolidamento(java.sql.Date val) {

		if (val != null) {
			libDataConsolidamento = new java.sql.Date(val.getTime());
		} else {
			libDataConsolidamento = null;
		}

	}
	/**
	 * @generated
	 */
	public java.sql.Date getLibDataConsolidamento() {

		if (libDataConsolidamento != null) {
			return new java.sql.Date(libDataConsolidamento.getTime());
		} else {
			return null;
		}

	}

	/*	 
	 * @generated
	 */
	private String motDesMotivoConsolid;

	/**
	 * @generated
	 */
	public void setMotDesMotivoConsolid(String val) {

		motDesMotivoConsolid = val;

	}
	/**
	 * @generated
	 */
	public String getMotDesMotivoConsolid() {

		return motDesMotivoConsolid;

	}

	/*	 
	 * @generated
	 */
	private String libFileIndex;

	/**
	 * @generated
	 */
	public void setLibFileIndex(String val) {

		libFileIndex = val;

	}
	/**
	 * @generated
	 */
	public String getLibFileIndex() {

		return libFileIndex;

	}

	/*	 
	 * @generated
	 */
	private String libUidIndex;

	/**
	 * @generated
	 */
	public void setLibUidIndex(String val) {

		libUidIndex = val;

	}
	/**
	 * @generated
	 */
	public String getLibUidIndex() {

		return libUidIndex;

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
