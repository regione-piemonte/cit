package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * DTO specifico della query modellata nel finder validatori.
 * @generated
 */
public class SigitTPersonaFisicaValidatoriDto implements Serializable {

	/*	 
	 * @generated
	 */
	private java.math.BigDecimal pfIdPersonaFisica;

	/**
	 * @generated
	 */
	public void setPfIdPersonaFisica(java.math.BigDecimal val) {

		pfIdPersonaFisica = val;

	}
	/**
	 * @generated
	 */
	public java.math.BigDecimal getPfIdPersonaFisica() {

		return pfIdPersonaFisica;

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
