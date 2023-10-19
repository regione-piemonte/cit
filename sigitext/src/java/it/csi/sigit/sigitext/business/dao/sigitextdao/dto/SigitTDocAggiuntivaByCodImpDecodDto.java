package it.csi.sigit.sigitext.business.dao.sigitextdao.dto;

import java.io.Serializable;

public class SigitTDocAggiuntivaByCodImpDecodDto implements Serializable {

	/*	 
	 * @generated
	 */
	private Integer docIdDocAggiuntiva;

	/**
	 * @generated
	 */
	public void setDocIdDocAggiuntiva(Integer val) {

		docIdDocAggiuntiva = val;

	}
	/**
	 * @generated
	 */
	public Integer getDocIdDocAggiuntiva() {

		return docIdDocAggiuntiva;

	}

	/*	 
	 * @generated
	 */
	private String docUidIndex;

	/**
	 * @generated
	 */
	public void setDocUidIndex(String val) {

		docUidIndex = val;

	}
	/**
	 * @generated
	 */
	public String getDocUidIndex() {

		return docUidIndex;

	}

	/*	 
	 * @generated
	 */
	private String docNomeDocOriginale;

	/**
	 * @generated
	 */
	public void setDocNomeDocOriginale(String val) {

		docNomeDocOriginale = val;

	}
	/**
	 * @generated
	 */
	public String getDocNomeDocOriginale() {

		return docNomeDocOriginale;

	}

	/*	 
	 * @generated
	 */
	private String docDesAltroTipodoc;

	/**
	 * @generated
	 */
	public void setDocDesAltroTipodoc(String val) {

		docDesAltroTipodoc = val;

	}
	/**
	 * @generated
	 */
	public String getDocDesAltroTipodoc() {

		return docDesAltroTipodoc;

	}

	/*	 
	 * @generated
	 */
	private String tipodocDesTipoDocAgg;

	/**
	 * @generated
	 */
	public void setTipodocDesTipoDocAgg(String val) {

		tipodocDesTipoDocAgg = val;

	}
	/**
	 * @generated
	 */
	public String getTipodocDesTipoDocAgg() {

		return tipodocDesTipoDocAgg;

	}

	/*	 
	 * @generated
	 */
	private java.sql.Timestamp docDataUpload;

	/**
	 * @generated
	 */
	public void setDocDataUpload(java.sql.Timestamp val) {

		if (val != null) {
			docDataUpload = new java.sql.Timestamp(val.getTime());
		} else {
			docDataUpload = null;
		}

	}
	/**
	 * @generated
	 */
	public java.sql.Timestamp getDocDataUpload() {

		if (docDataUpload != null) {
			return new java.sql.Timestamp(docDataUpload.getTime());
		} else {
			return null;
		}

	}

	/*	 
	 * @generated
	 */
	private java.sql.Timestamp docDataDelete;

	/**
	 * @generated
	 */
	public void setDocDataDelete(java.sql.Timestamp val) {

		if (val != null) {
			docDataDelete = new java.sql.Timestamp(val.getTime());
		} else {
			docDataDelete = null;
		}

	}
	/**
	 * @generated
	 */
	public java.sql.Timestamp getDocDataDelete() {

		if (docDataDelete != null) {
			return new java.sql.Timestamp(docDataDelete.getTime());
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
