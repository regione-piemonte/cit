package it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto;

import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dao.*;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * DTO specifico della query modellata nel finder ispezione2018ByUtentiNonAttivi.
 * @generated
 */
public class SigitTSanzioneIspezione2018ByUtentiNonAttiviDto implements Serializable {

	/*	 
	 * @generated
	 */
	private Integer sIdSanzione;

	/**
	 * @generated
	 */
	public void setSIdSanzione(Integer val) {

		sIdSanzione = val;

	}
	/**
	 * @generated
	 */
	public Integer getSIdSanzione() {

		return sIdSanzione;

	}

	/*	 
	 * @generated
	 */
	private String sCfResponsabile;

	/**
	 * @generated
	 */
	public void setSCfResponsabile(String val) {

		sCfResponsabile = val;

	}
	/**
	 * @generated
	 */
	public String getSCfResponsabile() {

		return sCfResponsabile;

	}

	/*	 
	 * @generated
	 */
	private String sDenomUtResponsabile;

	/**
	 * @generated
	 */
	public void setSDenomUtResponsabile(String val) {

		sDenomUtResponsabile = val;

	}
	/**
	 * @generated
	 */
	public String getSDenomUtResponsabile() {

		return sDenomUtResponsabile;

	}

	/*	 
	 * @generated
	 */
	private java.sql.Date sDtSveglia;

	/**
	 * @generated
	 */
	public void setSDtSveglia(java.sql.Date val) {

		if (val != null) {
			sDtSveglia = new java.sql.Date(val.getTime());
		} else {
			sDtSveglia = null;
		}

	}
	/**
	 * @generated
	 */
	public java.sql.Date getSDtSveglia() {

		if (sDtSveglia != null) {
			return new java.sql.Date(sDtSveglia.getTime());
		} else {
			return null;
		}

	}

	/*	 
	 * @generated
	 */
	private String sNoteSveglia;

	/**
	 * @generated
	 */
	public void setSNoteSveglia(String val) {

		sNoteSveglia = val;

	}
	/**
	 * @generated
	 */
	public String getSNoteSveglia() {

		return sNoteSveglia;

	}

	/*	 
	 * @generated
	 */
	private Integer aIdRuoloPa;

	/**
	 * @generated
	 */
	public void setAIdRuoloPa(Integer val) {

		aIdRuoloPa = val;

	}
	/**
	 * @generated
	 */
	public Integer getAIdRuoloPa() {

		return aIdRuoloPa;

	}

	/*	 
	 * @generated
	 */
	private String aIstatAbilitazione;

	/**
	 * @generated
	 */
	public void setAIstatAbilitazione(String val) {

		aIstatAbilitazione = val;

	}
	/**
	 * @generated
	 */
	public String getAIstatAbilitazione() {

		return aIstatAbilitazione;

	}

	/*	 
	 * @generated
	 */
	private String aMailComunicazione;

	/**
	 * @generated
	 */
	public void setAMailComunicazione(String val) {

		aMailComunicazione = val;

	}
	/**
	 * @generated
	 */
	public String getAMailComunicazione() {

		return aMailComunicazione;

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
