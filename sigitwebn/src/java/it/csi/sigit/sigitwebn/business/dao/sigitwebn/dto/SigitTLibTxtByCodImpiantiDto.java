package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * DTO specifico della query modellata nel finder byCodImpianti.
 * @generated
 */
public class SigitTLibTxtByCodImpiantiDto implements Serializable {

	/*	 
	 * @generated
	 */
	private java.math.BigDecimal libCodiceImpianto;

	/**
	 * @generated
	 */
	public void setLibCodiceImpianto(java.math.BigDecimal val) {

		libCodiceImpianto = val;

	}
	/**
	 * @generated
	 */
	public java.math.BigDecimal getLibCodiceImpianto() {

		return libCodiceImpianto;

	}

	/*	 
	 * @generated
	 */
	private String txtXmlLibretto;

	/**
	 * @generated
	 */
	public void setTxtXmlLibretto(String val) {

		txtXmlLibretto = val;

	}
	/**
	 * @generated
	 */
	public String getTxtXmlLibretto() {

		return txtXmlLibretto;

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
