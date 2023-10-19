package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * DTO specifico della query modellata nel finder byNumeroBollinoPerPotenzaPrezzo.
 * @generated
 */
public class SigitTCodiceBollByNumeroBollinoPerPotenzaPrezzoDto implements Serializable {

	/*	 
	 * @generated
	 */
	private java.math.BigDecimal fkTransazioneBoll;

	/**
	 * @generated
	 */
	public void setFkTransazioneBoll(java.math.BigDecimal val) {

		fkTransazioneBoll = val;

	}
	/**
	 * @generated
	 */
	public java.math.BigDecimal getFkTransazioneBoll() {

		return fkTransazioneBoll;

	}

	/*	 
	 * @generated
	 */
	private String siglaBollino;

	/**
	 * @generated
	 */
	public void setSiglaBollino(String val) {

		siglaBollino = val;

	}
	/**
	 * @generated
	 */
	public String getSiglaBollino() {

		return siglaBollino;

	}

	/*	 
	 * @generated
	 */
	private java.math.BigDecimal numeroBollino;

	/**
	 * @generated
	 */
	public void setNumeroBollino(java.math.BigDecimal val) {

		numeroBollino = val;

	}
	/**
	 * @generated
	 */
	public java.math.BigDecimal getNumeroBollino() {

		return numeroBollino;

	}

	/*	 
	 * @generated
	 */
	private java.math.BigDecimal fkPotenza;

	/**
	 * @generated
	 */
	public void setFkPotenza(java.math.BigDecimal val) {

		fkPotenza = val;

	}
	/**
	 * @generated
	 */
	public java.math.BigDecimal getFkPotenza() {

		return fkPotenza;

	}

	/*	 
	 * @generated
	 */
	private java.math.BigDecimal fkPrezzo;

	/**
	 * @generated
	 */
	public void setFkPrezzo(java.math.BigDecimal val) {

		fkPrezzo = val;

	}
	/**
	 * @generated
	 */
	public java.math.BigDecimal getFkPrezzo() {

		return fkPrezzo;

	}

	/*	 
	 * @generated
	 */
	private java.sql.Date fkDataInizioAcquisto;

	/**
	 * @generated
	 */
	public void setFkDataInizioAcquisto(java.sql.Date val) {

		if (val != null) {
			fkDataInizioAcquisto = new java.sql.Date(val.getTime());
		} else {
			fkDataInizioAcquisto = null;
		}

	}
	/**
	 * @generated
	 */
	public java.sql.Date getFkDataInizioAcquisto() {

		if (fkDataInizioAcquisto != null) {
			return new java.sql.Date(fkDataInizioAcquisto.getTime());
		} else {
			return null;
		}

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
