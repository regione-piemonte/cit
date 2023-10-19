package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * DTO specifico della query modellata nel finder byCodiceImpiantoCountVerifiche.
 * @generated
 */
public class SigitVRicercaAllegatiByCodiceImpiantoCountVerificheDto implements Serializable {

	/*	 
	 * @generated
	 */
	private java.math.BigDecimal idallegato;

	/**
	 * @generated
	 */
	public void setIdallegato(java.math.BigDecimal val) {

		idallegato = val;

	}
	/**
	 * @generated
	 */
	public java.math.BigDecimal getIdallegato() {

		return idallegato;

	}

	/*	 
	 * @generated
	 */
	private java.sql.Date datacontrollo;

	/**
	 * @generated
	 */
	public void setDatacontrollo(java.sql.Date val) {

		if (val != null) {
			datacontrollo = new java.sql.Date(val.getTime());
		} else {
			datacontrollo = null;
		}

	}
	/**
	 * @generated
	 */
	public java.sql.Date getDatacontrollo() {

		if (datacontrollo != null) {
			return new java.sql.Date(datacontrollo.getTime());
		} else {
			return null;
		}

	}

	/*	 
	 * @generated
	 */
	private String descdocumento;

	/**
	 * @generated
	 */
	public void setDescdocumento(String val) {

		descdocumento = val;

	}
	/**
	 * @generated
	 */
	public String getDescdocumento() {

		return descdocumento;

	}

	/*	 
	 * @generated
	 */
	private String descstatorapp;

	/**
	 * @generated
	 */
	public void setDescstatorapp(String val) {

		descstatorapp = val;

	}
	/**
	 * @generated
	 */
	public String getDescstatorapp() {

		return descstatorapp;

	}

	/*	 
	 * @generated
	 */
	private String osservazioni;

	/**
	 * @generated
	 */
	public void setOsservazioni(String val) {

		osservazioni = val;

	}
	/**
	 * @generated
	 */
	public String getOsservazioni() {

		return osservazioni;

	}

	/*	 
	 * @generated
	 */
	private String raccomandazioni;

	/**
	 * @generated
	 */
	public void setRaccomandazioni(String val) {

		raccomandazioni = val;

	}
	/**
	 * @generated
	 */
	public String getRaccomandazioni() {

		return raccomandazioni;

	}

	/*	 
	 * @generated
	 */
	private String prescrizioni;

	/**
	 * @generated
	 */
	public void setPrescrizioni(String val) {

		prescrizioni = val;

	}
	/**
	 * @generated
	 */
	public String getPrescrizioni() {

		return prescrizioni;

	}

	/*	 
	 * @generated
	 */
	private java.sql.Date interv;

	/**
	 * @generated
	 */
	public void setInterv(java.sql.Date val) {

		if (val != null) {
			interv = new java.sql.Date(val.getTime());
		} else {
			interv = null;
		}

	}
	/**
	 * @generated
	 */
	public java.sql.Date getInterv() {

		if (interv != null) {
			return new java.sql.Date(interv.getTime());
		} else {
			return null;
		}

	}

	/*	 
	 * @generated
	 */
	private String elencoapp;

	/**
	 * @generated
	 */
	public void setElencoapp(String val) {

		elencoapp = val;

	}
	/**
	 * @generated
	 */
	public String getElencoapp() {

		return elencoapp;

	}

	/**	 
	* @generated
	*/
	private java.math.BigDecimal num_verifiche;

	/**
	* @generated
	*/
	public void setNum_verifiche(java.math.BigDecimal val) {

		num_verifiche = val;

	}
	/**
	* @generated
	*/
	public java.math.BigDecimal getNum_verifiche() {

		return num_verifiche;

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
