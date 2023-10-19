package it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto;

import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dao.*;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * DTO specifico della query modellata nel finder byUtentiNonAttivi.
 * @generated
 */
public class SigitTIspezione2018ByUtentiNonAttiviDto implements Serializable {

	/*	 
	 * @generated
	 */
	private Integer tIdIspezione2018;

	/**
	 * @generated
	 */
	public void setTIdIspezione2018(Integer val) {

		tIdIspezione2018 = val;

	}
	/**
	 * @generated
	 */
	public Integer getTIdIspezione2018() {

		return tIdIspezione2018;

	}

	/*	 
	 * @generated
	 */
	private String vNome;

	/**
	 * @generated
	 */
	public void setVNome(String val) {

		vNome = val;

	}
	/**
	 * @generated
	 */
	public String getVNome() {

		return vNome;

	}

	/*	 
	 * @generated
	 */
	private String vCognome;

	/**
	 * @generated
	 */
	public void setVCognome(String val) {

		vCognome = val;

	}
	/**
	 * @generated
	 */
	public String getVCognome() {

		return vCognome;

	}

	/*	 
	 * @generated
	 */
	private String vCodiceFiscale;

	/**
	 * @generated
	 */
	public void setVCodiceFiscale(String val) {

		vCodiceFiscale = val;

	}
	/**
	 * @generated
	 */
	public String getVCodiceFiscale() {

		return vCodiceFiscale;

	}

	/*	 
	 * @generated
	 */
	private java.sql.Timestamp tDtSveglia;

	/**
	 * @generated
	 */
	public void setTDtSveglia(java.sql.Timestamp val) {

		if (val != null) {
			tDtSveglia = new java.sql.Timestamp(val.getTime());
		} else {
			tDtSveglia = null;
		}

	}
	/**
	 * @generated
	 */
	public java.sql.Timestamp getTDtSveglia() {

		if (tDtSveglia != null) {
			return new java.sql.Timestamp(tDtSveglia.getTime());
		} else {
			return null;
		}

	}

	/*	 
	 * @generated
	 */
	private String tNoteSveglia;

	/**
	 * @generated
	 */
	public void setTNoteSveglia(String val) {

		tNoteSveglia = val;

	}
	/**
	 * @generated
	 */
	public String getTNoteSveglia() {

		return tNoteSveglia;

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
