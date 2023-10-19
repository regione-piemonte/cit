/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto;

import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dao.*;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * DTO specifico della query modellata nel finder byFilter.
 * @generated
 */
public class SigitTCodiceBollByFilterDto implements Serializable {

	/*	 
	 * @generated
	 */
	private java.math.BigDecimal idTransazione;

	/**
	 * @generated
	 */
	public void setIdTransazione(java.math.BigDecimal val) {

		idTransazione = val;

	}
	/**
	 * @generated
	 */
	public java.math.BigDecimal getIdTransazione() {

		return idTransazione;

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
