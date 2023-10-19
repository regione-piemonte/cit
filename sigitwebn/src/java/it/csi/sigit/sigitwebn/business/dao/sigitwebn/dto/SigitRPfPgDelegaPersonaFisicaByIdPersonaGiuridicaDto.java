package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * DTO specifico della query modellata nel finder personaFisicaByIdPersonaGiuridica.
 * @generated
 */
public class SigitRPfPgDelegaPersonaFisicaByIdPersonaGiuridicaDto implements Serializable {

	/*	 
	 * @generated
	 */
	private java.math.BigDecimal dIdPersonaFisica;

	/**
	 * @generated
	 */
	public void setDIdPersonaFisica(java.math.BigDecimal val) {

		dIdPersonaFisica = val;

	}
	/**
	 * @generated
	 */
	public java.math.BigDecimal getDIdPersonaFisica() {

		return dIdPersonaFisica;

	}

	/*	 
	 * @generated
	 */
	private java.math.BigDecimal dIdPersonaGiuridica;

	/**
	 * @generated
	 */
	public void setDIdPersonaGiuridica(java.math.BigDecimal val) {

		dIdPersonaGiuridica = val;

	}
	/**
	 * @generated
	 */
	public java.math.BigDecimal getDIdPersonaGiuridica() {

		return dIdPersonaGiuridica;

	}

	/*	 
	 * @generated
	 */
	private String pfCognome;

	/**
	 * @generated
	 */
	public void setPfCognome(String val) {

		pfCognome = val;

	}
	/**
	 * @generated
	 */
	public String getPfCognome() {

		return pfCognome;

	}

	/*	 
	 * @generated
	 */
	private String pfNome;

	/**
	 * @generated
	 */
	public void setPfNome(String val) {

		pfNome = val;

	}
	/**
	 * @generated
	 */
	public String getPfNome() {

		return pfNome;

	}

	/*	 
	 * @generated
	 */
	private String pfCodiceFiscale;

	/**
	 * @generated
	 */
	public void setPfCodiceFiscale(String val) {

		pfCodiceFiscale = val;

	}
	/**
	 * @generated
	 */
	public String getPfCodiceFiscale() {

		return pfCodiceFiscale;

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

	/*	 
	 * @generated
	 */
	private String dFlgDelega;

	/**
	 * @generated
	 */
	public void setDFlgDelega(String val) {

		dFlgDelega = val;

	}
	/**
	 * @generated
	 */
	public String getDFlgDelega() {

		return dFlgDelega;

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
