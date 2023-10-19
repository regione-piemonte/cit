package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * DTO specifico della query modellata nel finder byRuoloFunzionale.
 * @generated
 */
public class SigitDTipoDocumentoByRuoloFunzionaleDto implements Serializable {

	/*	 
	 * @generated
	 */
	private java.math.BigDecimal idTipoDocumento;

	/**
	 * @generated
	 */
	public void setIdTipoDocumento(java.math.BigDecimal val) {

		idTipoDocumento = val;

	}
	/**
	 * @generated
	 */
	public java.math.BigDecimal getIdTipoDocumento() {

		return idTipoDocumento;

	}

	/*	 
	 * @generated
	 */
	private String descTipoDocumento;

	/**
	 * @generated
	 */
	public void setDescTipoDocumento(String val) {

		descTipoDocumento = val;

	}
	/**
	 * @generated
	 */
	public String getDescTipoDocumento() {

		return descTipoDocumento;

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
