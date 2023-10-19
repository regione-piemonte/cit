package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * DTO specifico della query modellata nel finder cercaUbicazioneImpianto.
 * @generated
 */
public class SigitVTotImpiantoCercaUbicazioneImpiantoDto implements Serializable {

	/*	 
	 * @generated
	 */
	private java.math.BigDecimal codiceImpianto;

	/**
	 * @generated
	 */
	public void setCodiceImpianto(java.math.BigDecimal val) {

		codiceImpianto = val;

	}
	/**
	 * @generated
	 */
	public java.math.BigDecimal getCodiceImpianto() {

		return codiceImpianto;

	}

	/*	 
	 * @generated
	 */
	private String siglaProvincia;

	/**
	 * @generated
	 */
	public void setSiglaProvincia(String val) {

		siglaProvincia = val;

	}
	/**
	 * @generated
	 */
	public String getSiglaProvincia() {

		return siglaProvincia;

	}

	/*	 
	 * @generated
	 */
	private String istatComune;

	/**
	 * @generated
	 */
	public void setIstatComune(String val) {

		istatComune = val;

	}
	/**
	 * @generated
	 */
	public String getIstatComune() {

		return istatComune;

	}

	/*	 
	 * @generated
	 */
	private String provincia;

	/**
	 * @generated
	 */
	public void setProvincia(String val) {

		provincia = val;

	}
	/**
	 * @generated
	 */
	public String getProvincia() {

		return provincia;

	}

	/*	 
	 * @generated
	 */
	private String comune;

	/**
	 * @generated
	 */
	public void setComune(String val) {

		comune = val;

	}
	/**
	 * @generated
	 */
	public String getComune() {

		return comune;

	}

	/*	 
	 * @generated
	 */
	private String indirizzo;

	/**
	 * @generated
	 */
	public void setIndirizzo(String val) {

		indirizzo = val;

	}
	/**
	 * @generated
	 */
	public String getIndirizzo() {

		return indirizzo;

	}

	/*	 
	 * @generated
	 */
	private String civico;

	/**
	 * @generated
	 */
	public void setCivico(String val) {

		civico = val;

	}
	/**
	 * @generated
	 */
	public String getCivico() {

		return civico;

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
