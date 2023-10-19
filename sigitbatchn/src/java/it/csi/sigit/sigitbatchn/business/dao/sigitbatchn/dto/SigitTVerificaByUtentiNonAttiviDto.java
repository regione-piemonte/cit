package it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto;

import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dao.*;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * DTO specifico della query modellata nel finder byUtentiNonAttivi.
 * @generated
 */
public class SigitTVerificaByUtentiNonAttiviDto implements Serializable {

	/*	 
	 * @generated
	 */
	private Integer vIdVerifica;

	/**
	 * @generated
	 */
	public void setVIdVerifica(Integer val) {

		vIdVerifica = val;

	}
	/**
	 * @generated
	 */
	public Integer getVIdVerifica() {

		return vIdVerifica;

	}

	/*	 
	 * @generated
	 */
	private String vCfUtenteCaricamento;

	/**
	 * @generated
	 */
	public void setVCfUtenteCaricamento(String val) {

		vCfUtenteCaricamento = val;

	}
	/**
	 * @generated
	 */
	public String getVCfUtenteCaricamento() {

		return vCfUtenteCaricamento;

	}

	/*	 
	 * @generated
	 */
	private String vDenomUtenteCaricamento;

	/**
	 * @generated
	 */
	public void setVDenomUtenteCaricamento(String val) {

		vDenomUtenteCaricamento = val;

	}
	/**
	 * @generated
	 */
	public String getVDenomUtenteCaricamento() {

		return vDenomUtenteCaricamento;

	}

	/*	 
	 * @generated
	 */
	private java.sql.Date vDtSveglia;

	/**
	 * @generated
	 */
	public void setVDtSveglia(java.sql.Date val) {

		if (val != null) {
			vDtSveglia = new java.sql.Date(val.getTime());
		} else {
			vDtSveglia = null;
		}

	}
	/**
	 * @generated
	 */
	public java.sql.Date getVDtSveglia() {

		if (vDtSveglia != null) {
			return new java.sql.Date(vDtSveglia.getTime());
		} else {
			return null;
		}

	}

	/*	 
	 * @generated
	 */
	private String vNoteSveglia;

	/**
	 * @generated
	 */
	public void setVNoteSveglia(String val) {

		vNoteSveglia = val;

	}
	/**
	 * @generated
	 */
	public String getVNoteSveglia() {

		return vNoteSveglia;

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
