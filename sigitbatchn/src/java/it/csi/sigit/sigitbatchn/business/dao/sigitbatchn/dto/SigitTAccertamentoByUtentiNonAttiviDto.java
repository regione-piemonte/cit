package it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto;

import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dao.*;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * DTO specifico della query modellata nel finder byUtentiNonAttivi.
 * @generated
 */
public class SigitTAccertamentoByUtentiNonAttiviDto implements Serializable {

	/*	 
	 * @generated
	 */
	private Integer accIdAccertamento;

	/**
	 * @generated
	 */
	public void setAccIdAccertamento(Integer val) {

		accIdAccertamento = val;

	}
	/**
	 * @generated
	 */
	public Integer getAccIdAccertamento() {

		return accIdAccertamento;

	}

	/*	 
	 * @generated
	 */
	private String accCfUtenteAssegn;

	/**
	 * @generated
	 */
	public void setAccCfUtenteAssegn(String val) {

		accCfUtenteAssegn = val;

	}
	/**
	 * @generated
	 */
	public String getAccCfUtenteAssegn() {

		return accCfUtenteAssegn;

	}

	/*	 
	 * @generated
	 */
	private String accDenomUtenteAssegn;

	/**
	 * @generated
	 */
	public void setAccDenomUtenteAssegn(String val) {

		accDenomUtenteAssegn = val;

	}
	/**
	 * @generated
	 */
	public String getAccDenomUtenteAssegn() {

		return accDenomUtenteAssegn;

	}

	/*	 
	 * @generated
	 */
	private java.sql.Date accDtSveglia;

	/**
	 * @generated
	 */
	public void setAccDtSveglia(java.sql.Date val) {

		if (val != null) {
			accDtSveglia = new java.sql.Date(val.getTime());
		} else {
			accDtSveglia = null;
		}

	}
	/**
	 * @generated
	 */
	public java.sql.Date getAccDtSveglia() {

		if (accDtSveglia != null) {
			return new java.sql.Date(accDtSveglia.getTime());
		} else {
			return null;
		}

	}

	/*	 
	 * @generated
	 */
	private String accNoteSveglia;

	/**
	 * @generated
	 */
	public void setAccNoteSveglia(String val) {

		accNoteSveglia = val;

	}
	/**
	 * @generated
	 */
	public String getAccNoteSveglia() {

		return accNoteSveglia;

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
