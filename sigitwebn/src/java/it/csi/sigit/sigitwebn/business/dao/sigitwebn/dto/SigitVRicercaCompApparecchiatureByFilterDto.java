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
 * DTO specifico della query modellata nel finder apparecchiatureByFilter.
 * @generated
 */
public class SigitVRicercaCompApparecchiatureByFilterDto
		implements
			Serializable {

	/*	 
	 * @generated
	 */
	private String rcIdTipoComponente;

	/**
	 * @generated
	 */
	public void setRcIdTipoComponente(String val) {
		rcIdTipoComponente = val;
	}
	/**
	 * @generated
	 */
	public String getRcIdTipoComponente() {
		return rcIdTipoComponente;
	}

	/*	 
	 * @generated
	 */
	private java.math.BigDecimal rcProgressivo;

	/**
	 * @generated
	 */
	public void setRcProgressivo(java.math.BigDecimal val) {
		rcProgressivo = val;
	}
	/**
	 * @generated
	 */
	public java.math.BigDecimal getRcProgressivo() {
		return rcProgressivo;
	}

	/*	 
	 * @generated
	 */
	private String mDesMarca;

	/**
	 * @generated
	 */
	public void setMDesMarca(String val) {
		mDesMarca = val;
	}
	/**
	 * @generated
	 */
	public String getMDesMarca() {
		return mDesMarca;
	}

	/*	 
	 * @generated
	 */
	private String rcModello;

	/**
	 * @generated
	 */
	public void setRcModello(String val) {
		rcModello = val;
	}
	/**
	 * @generated
	 */
	public String getRcModello() {
		return rcModello;
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
