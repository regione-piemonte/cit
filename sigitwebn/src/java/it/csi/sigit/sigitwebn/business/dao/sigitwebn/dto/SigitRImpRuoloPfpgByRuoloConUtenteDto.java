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
 * DTO specifico della query modellata nel finder byRuoloConUtente.
 * @generated
 */
public class SigitRImpRuoloPfpgByRuoloConUtenteDto implements Serializable {

	/*	 
	 * @generated
	 */
	private java.math.BigDecimal ir;

	/**
	 * @generated
	 */
	public void setIr(java.math.BigDecimal val) {
		ir = val;
	}
	/**
	 * @generated
	 */
	public java.math.BigDecimal getIr() {
		return ir;
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
