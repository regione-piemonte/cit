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
 * DTO specifico della query modellata nel finder codImpAttById3Resp.
 * @generated
 */
public class SigitRComp4ContrattoCodImpAttById3RespDto implements Serializable {

	/*	 
	 * @generated
	 */
	private java.math.BigDecimal codice_impianto;

	/**
	 * @generated
	 */
	public void setCodice_impianto(java.math.BigDecimal val) {

		codice_impianto = val;

	}
	/**
	 * @generated
	 */
	public java.math.BigDecimal getCodice_impianto() {

		return codice_impianto;

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
