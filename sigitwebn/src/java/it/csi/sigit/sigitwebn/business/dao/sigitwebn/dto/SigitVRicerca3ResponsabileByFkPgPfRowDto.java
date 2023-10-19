package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * DTO specifico della query modellata nel finder byFkPgPfRow.
 * @generated
 */
public class SigitVRicerca3ResponsabileByFkPgPfRowDto implements Serializable {

	/*	 
	 * @generated
	 */
	private String denominazioneResp;

	/**
	 * @generated
	 */
	public void setDenominazioneResp(String val) {

		denominazioneResp = val;

	}
	/**
	 * @generated
	 */
	public String getDenominazioneResp() {

		return denominazioneResp;

	}

	/*	 
	 * @generated
	 */
	private String denominazione3Resp;

	/**
	 * @generated
	 */
	public void setDenominazione3Resp(String val) {

		denominazione3Resp = val;

	}
	/**
	 * @generated
	 */
	public String getDenominazione3Resp() {

		return denominazione3Resp;

	}

	/*	 
	 * @generated
	 */
	private java.sql.Date dataInizioContratto;

	/**
	 * @generated
	 */
	public void setDataInizioContratto(java.sql.Date val) {

		if (val != null) {
			dataInizioContratto = new java.sql.Date(val.getTime());
		} else {
			dataInizioContratto = null;
		}

	}
	/**
	 * @generated
	 */
	public java.sql.Date getDataInizioContratto() {

		if (dataInizioContratto != null) {
			return new java.sql.Date(dataInizioContratto.getTime());
		} else {
			return null;
		}

	}

	/*	 
	 * @generated
	 */
	private java.sql.Date dataFineContratto;

	/**
	 * @generated
	 */
	public void setDataFineContratto(java.sql.Date val) {

		if (val != null) {
			dataFineContratto = new java.sql.Date(val.getTime());
		} else {
			dataFineContratto = null;
		}

	}
	/**
	 * @generated
	 */
	public java.sql.Date getDataFineContratto() {

		if (dataFineContratto != null) {
			return new java.sql.Date(dataFineContratto.getTime());
		} else {
			return null;
		}

	}

	/*	 
	 * @generated
	 */
	private java.sql.Timestamp dataCessazione;

	/**
	 * @generated
	 */
	public void setDataCessazione(java.sql.Timestamp val) {

		if (val != null) {
			dataCessazione = new java.sql.Timestamp(val.getTime());
		} else {
			dataCessazione = null;
		}

	}
	/**
	 * @generated
	 */
	public java.sql.Timestamp getDataCessazione() {

		if (dataCessazione != null) {
			return new java.sql.Timestamp(dataCessazione.getTime());
		} else {
			return null;
		}

	}

	/*	 
	 * @generated
	 */
	private java.math.BigDecimal flgTacitoRinnovo;

	/**
	 * @generated
	 */
	public void setFlgTacitoRinnovo(java.math.BigDecimal val) {

		flgTacitoRinnovo = val;

	}
	/**
	 * @generated
	 */
	public java.math.BigDecimal getFlgTacitoRinnovo() {

		return flgTacitoRinnovo;

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
