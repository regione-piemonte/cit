package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * DTO specifico della query modellata nel finder byFkPgPfConta.
 * @generated
 */
public class SigitVRicerca3ResponsabileByFkPgPfContaDto implements Serializable {

	/**	 
	* @generated
	*/
	private java.math.BigDecimal contaResp;

	/**
	* @generated
	*/
	public void setContaResp(java.math.BigDecimal val) {

		contaResp = val;

	}
	/**
	* @generated
	*/
	public java.math.BigDecimal getContaResp() {

		return contaResp;

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
