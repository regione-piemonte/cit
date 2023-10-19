package it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto;

import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dao.*;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * DTO specifico della query modellata nel finder emailPfImport.
 * @generated
 */
public class SigitTPersonaFisicaEmailPfImportDto implements Serializable {

	/*	 
	 * @generated
	 */
	private String pfEmail;

	/**
	 * @generated
	 */
	public void setPfEmail(String val) {

		pfEmail = val;

	}
	/**
	 * @generated
	 */
	public String getPfEmail() {

		return pfEmail;

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
