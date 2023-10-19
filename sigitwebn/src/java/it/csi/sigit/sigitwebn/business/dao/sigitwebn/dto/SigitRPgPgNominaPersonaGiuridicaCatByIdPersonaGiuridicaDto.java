package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * DTO specifico della query modellata nel finder personaGiuridicaCatByIdPersonaGiuridica.
 * @generated
 */
public class SigitRPgPgNominaPersonaGiuridicaCatByIdPersonaGiuridicaDto implements Serializable {

	/*	 
	 * @generated
	 */
	private java.math.BigDecimal dIdPersonaGiuridicaCat;

	/**
	 * @generated
	 */
	public void setDIdPersonaGiuridicaCat(java.math.BigDecimal val) {

		dIdPersonaGiuridicaCat = val;

	}
	/**
	 * @generated
	 */
	public java.math.BigDecimal getDIdPersonaGiuridicaCat() {

		return dIdPersonaGiuridicaCat;

	}

	/*	 
	 * @generated
	 */
	private java.math.BigDecimal dIdPersonaGiuridicaImpresa;

	/**
	 * @generated
	 */
	public void setDIdPersonaGiuridicaImpresa(java.math.BigDecimal val) {

		dIdPersonaGiuridicaImpresa = val;

	}
	/**
	 * @generated
	 */
	public java.math.BigDecimal getDIdPersonaGiuridicaImpresa() {

		return dIdPersonaGiuridicaImpresa;

	}

	/*	 
	 * @generated
	 */
	private String pgDenominazione;

	/**
	 * @generated
	 */
	public void setPgDenominazione(String val) {

		pgDenominazione = val;

	}
	/**
	 * @generated
	 */
	public String getPgDenominazione() {

		return pgDenominazione;

	}

	/*	 
	 * @generated
	 */
	private String pgCodiceFiscale;

	/**
	 * @generated
	 */
	public void setPgCodiceFiscale(String val) {

		pgCodiceFiscale = val;

	}
	/**
	 * @generated
	 */
	public String getPgCodiceFiscale() {

		return pgCodiceFiscale;

	}

	/*	 
	 * @generated
	 */
	private java.sql.Date dDataInizio;

	/**
	 * @generated
	 */
	public void setDDataInizio(java.sql.Date val) {

		if (val != null) {
			dDataInizio = new java.sql.Date(val.getTime());
		} else {
			dDataInizio = null;
		}

	}
	/**
	 * @generated
	 */
	public java.sql.Date getDDataInizio() {

		if (dDataInizio != null) {
			return new java.sql.Date(dDataInizio.getTime());
		} else {
			return null;
		}

	}

	/*	 
	 * @generated
	 */
	private java.sql.Date dDataFine;

	/**
	 * @generated
	 */
	public void setDDataFine(java.sql.Date val) {

		if (val != null) {
			dDataFine = new java.sql.Date(val.getTime());
		} else {
			dDataFine = null;
		}

	}
	/**
	 * @generated
	 */
	public java.sql.Date getDDataFine() {

		if (dDataFine != null) {
			return new java.sql.Date(dDataFine.getTime());
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
