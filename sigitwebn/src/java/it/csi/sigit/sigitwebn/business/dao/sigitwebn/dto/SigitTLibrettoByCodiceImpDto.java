/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * DTO specifico della query modellata nel finder byCodiceImp.
 * @generated
 */
public class SigitTLibrettoByCodiceImpDto implements Serializable {

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
	private String mcDesMotivoConsolid;

	/**
	 * @generated
	 */
	public void setMcDesMotivoConsolid(String val) {

		mcDesMotivoConsolid = val;

	}
	/**
	 * @generated
	 */
	public String getMcDesMotivoConsolid() {

		return mcDesMotivoConsolid;

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
