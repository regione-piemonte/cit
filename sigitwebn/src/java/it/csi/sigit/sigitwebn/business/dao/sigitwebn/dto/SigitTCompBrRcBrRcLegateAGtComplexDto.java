package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * DTO specifico della query modellata nel finder BrRcLegateAGtComplex.
 * @generated
 */
public class SigitTCompBrRcBrRcLegateAGtComplexDto implements Serializable {

	/*	 
	 * @generated
	 */
	private java.math.BigDecimal idCompBrRc;

	/**
	 * @generated
	 */
	public void setIdCompBrRc(java.math.BigDecimal val) {

		idCompBrRc = val;

	}

	/**
	 * @generated
	 */
	public java.math.BigDecimal getIdCompBrRc() {

		return idCompBrRc;

	}

	/*	 
	 * @generated
	 */
	private String tipologiaBrRc;

	/**
	 * @generated
	 */
	public void setTipologiaBrRc(String val) {

		tipologiaBrRc = val;

	}

	/**
	 * @generated
	 */
	public String getTipologiaBrRc() {

		return tipologiaBrRc;

	}

	/*	 
	 * @generated
	 */
	private java.math.BigDecimal progressivoBrRc;

	/**
	 * @generated
	 */
	public void setProgressivoBrRc(java.math.BigDecimal val) {

		progressivoBrRc = val;

	}

	/**
	 * @generated
	 */
	public java.math.BigDecimal getProgressivoBrRc() {

		return progressivoBrRc;

	}

	/*	 
	 * @generated
	 */
	private String fkTipoComponente;

	/**
	 * @generated
	 */
	public void setFkTipoComponente(String val) {

		fkTipoComponente = val;

	}

	/**
	 * @generated
	 */
	public String getFkTipoComponente() {

		return fkTipoComponente;

	}

	/*	 
	 * @generated
	 */
	private java.math.BigDecimal fkProgressivo;

	/**
	 * @generated
	 */
	public void setFkProgressivo(java.math.BigDecimal val) {

		fkProgressivo = val;

	}

	/**
	 * @generated
	 */
	public java.math.BigDecimal getFkProgressivo() {

		return fkProgressivo;

	}

	/*	 
	 * @generated
	 */
	private java.sql.Date fkDataInstall;

	/**
	 * @generated
	 */
	public void setFkDataInstall(java.sql.Date val) {

		if (val != null) {
			fkDataInstall = new java.sql.Date(val.getTime());
		} else {
			fkDataInstall = null;
		}

	}

	/**
	 * @generated
	 */
	public java.sql.Date getFkDataInstall() {

		if (fkDataInstall != null) {
			return new java.sql.Date(fkDataInstall.getTime());
		} else {
			return null;
		}

	}

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
	private String modello;

	/**
	 * @generated
	 */
	public void setModello(String val) {

		modello = val;

	}

	/**
	 * @generated
	 */
	public String getModello() {

		return modello;

	}

	/*	 
	 * @generated
	 */
	private String matricola;

	/**
	 * @generated
	 */
	public void setMatricola(String val) {

		matricola = val;

	}

	/**
	 * @generated
	 */
	public String getMatricola() {

		return matricola;

	}

	/*	 
	 * @generated
	 */
	private java.math.BigDecimal idMarca;

	/**
	 * @generated
	 */
	public void setIdMarca(java.math.BigDecimal val) {

		idMarca = val;

	}

	/**
	 * @generated
	 */
	public java.math.BigDecimal getIdMarca() {

		return idMarca;

	}

	/*	 
	 * @generated
	 */
	private String desMarca;

	/**
	 * @generated
	 */
	public void setDesMarca(String val) {

		desMarca = val;

	}

	/**
	 * @generated
	 */
	public String getDesMarca() {

		return desMarca;

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
