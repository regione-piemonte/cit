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
 * DTO specifico della query modellata nel finder byFilter.
 * @generated
 */
public class SigitTIspezione2018ByFilterDto implements Serializable {

	/*	 
	 * @generated
	 */
	private Integer ispIdIspezione2018;

	/**
	 * @generated
	 */
	public void setIspIdIspezione2018(Integer val) {

		ispIdIspezione2018 = val;

	}
	/**
	 * @generated
	 */
	public Integer getIspIdIspezione2018() {

		return ispIdIspezione2018;

	}

	/*	 
	 * @generated
	 */
	private String persNome;

	/**
	 * @generated
	 */
	public void setPersNome(String val) {

		persNome = val;

	}
	/**
	 * @generated
	 */
	public String getPersNome() {

		return persNome;

	}

	/*	 
	 * @generated
	 */
	private String persCognome;

	/**
	 * @generated
	 */
	public void setPersCognome(String val) {

		persCognome = val;

	}
	/**
	 * @generated
	 */
	public String getPersCognome() {

		return persCognome;

	}

	/*	 
	 * @generated
	 */
	private String persCodiceFiscale;

	/**
	 * @generated
	 */
	public void setPersCodiceFiscale(String val) {

		persCodiceFiscale = val;

	}
	/**
	 * @generated
	 */
	public String getPersCodiceFiscale() {

		return persCodiceFiscale;

	}

	/*	 
	 * @generated
	 */
	private String ispCfIspettoreSecondario;

	/**
	 * @generated
	 */
	public void setIspCfIspettoreSecondario(String val) {

		ispCfIspettoreSecondario = val;

	}
	/**
	 * @generated
	 */
	public String getIspCfIspettoreSecondario() {

		return ispCfIspettoreSecondario;

	}

	/*	 
	 * @generated
	 */
	private java.sql.Timestamp ispDtCreazione;

	/**
	 * @generated
	 */
	public void setIspDtCreazione(java.sql.Timestamp val) {

		if (val != null) {
			ispDtCreazione = new java.sql.Timestamp(val.getTime());
		} else {
			ispDtCreazione = null;
		}

	}
	/**
	 * @generated
	 */
	public java.sql.Timestamp getIspDtCreazione() {

		if (ispDtCreazione != null) {
			return new java.sql.Timestamp(ispDtCreazione.getTime());
		} else {
			return null;
		}

	}

	/*	 
	 * @generated
	 */
	private java.math.BigDecimal ispFkStatoIspezione;

	/**
	 * @generated
	 */
	public void setIspFkStatoIspezione(java.math.BigDecimal val) {

		ispFkStatoIspezione = val;

	}
	/**
	 * @generated
	 */
	public java.math.BigDecimal getIspFkStatoIspezione() {

		return ispFkStatoIspezione;

	}

	/*	 
	 * @generated
	 */
	private java.math.BigDecimal ispCodiceImpianto;

	/**
	 * @generated
	 */
	public void setIspCodiceImpianto(java.math.BigDecimal val) {

		ispCodiceImpianto = val;

	}
	/**
	 * @generated
	 */
	public java.math.BigDecimal getIspCodiceImpianto() {

		return ispCodiceImpianto;

	}

	/*	 
	 * @generated
	 */
	private java.math.BigDecimal ispFlgEsito;

	/**
	 * @generated
	 */
	public void setIspFlgEsito(java.math.BigDecimal val) {

		ispFlgEsito = val;

	}
	/**
	 * @generated
	 */
	public java.math.BigDecimal getIspFlgEsito() {

		return ispFlgEsito;

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
