package it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto;

import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dao.*;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * DTO specifico della query modellata nel finder byCodiceFiscale.
 * @generated
 */
public class SigitTIspezione2018ByCodiceFiscaleDto implements Serializable {

	/*	 
	 * @generated
	 */
	private Integer is_2018IdIspezione2018;

	/**
	 * @generated
	 */
	public void setIs_2018IdIspezione2018(Integer val) {

		is_2018IdIspezione2018 = val;

	}
	/**
	 * @generated
	 */
	public Integer getIs_2018IdIspezione2018() {

		return is_2018IdIspezione2018;

	}

	/*	 
	 * @generated
	 */
	private java.sql.Timestamp is_2018DtSveglia;

	/**
	 * @generated
	 */
	public void setIs_2018DtSveglia(java.sql.Timestamp val) {

		if (val != null) {
			is_2018DtSveglia = new java.sql.Timestamp(val.getTime());
		} else {
			is_2018DtSveglia = null;
		}

	}
	/**
	 * @generated
	 */
	public java.sql.Timestamp getIs_2018DtSveglia() {

		if (is_2018DtSveglia != null) {
			return new java.sql.Timestamp(is_2018DtSveglia.getTime());
		} else {
			return null;
		}

	}

	/*	 
	 * @generated
	 */
	private String is_2018NoteSveglia;

	/**
	 * @generated
	 */
	public void setIs_2018NoteSveglia(String val) {

		is_2018NoteSveglia = val;

	}
	/**
	 * @generated
	 */
	public String getIs_2018NoteSveglia() {

		return is_2018NoteSveglia;

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
