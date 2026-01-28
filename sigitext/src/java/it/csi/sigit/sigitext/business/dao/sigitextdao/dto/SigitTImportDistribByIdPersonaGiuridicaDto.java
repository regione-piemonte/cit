package it.csi.sigit.sigitext.business.dao.sigitextdao.dto;

import java.io.Serializable;

/**
 * DTO specifico della query modellata nel finder byIdPersonaGiuridica.
 * @generated
 */
public class SigitTImportDistribByIdPersonaGiuridicaDto implements Serializable {

	/*	 
	 * @generated
	 */
	private Integer idIdImportDistrib;

	/**
	 * @generated
	 */
	public void setIdIdImportDistrib(Integer val) {

		idIdImportDistrib = val;

	}
	/**
	 * @generated
	 */
	public Integer getIdIdImportDistrib() {

		return idIdImportDistrib;

	}
	
	private Integer fkPersonaGiuridica;
	
	public Integer getFkPersonaGiuridica() {
		
		return fkPersonaGiuridica;
	
	}
	
	public void setFkPersonaGiuridica(Integer fkPersonaGiuridica) {
		
		this.fkPersonaGiuridica = fkPersonaGiuridica;
	
	}
	
	private Integer fkStatoDistrib;
	
	public Integer getFkStatoDistrib() {
		
		return fkStatoDistrib;

	}
	
	public void setFkStatoDistrib(Integer fkStatoDistrib) {
	
		this.fkStatoDistrib = fkStatoDistrib;
	
	}

	/*	 
	 * @generated
	 */
	private java.sql.Timestamp idDataInizioElab;

	/**
	 * @generated
	 */
	public void setIdDataInizioElab(java.sql.Timestamp val) {

		if (val != null) {
			idDataInizioElab = new java.sql.Timestamp(val.getTime());
		} else {
			idDataInizioElab = null;
		}

	}
	/**
	 * @generated
	 */
	public java.sql.Timestamp getIdDataInizioElab() {

		if (idDataInizioElab != null) {
			return new java.sql.Timestamp(idDataInizioElab.getTime());
		} else {
			return null;
		}

	}

	/*	 
	 * @generated
	 */
	private java.sql.Timestamp idDataFineElab;

	/**
	 * @generated
	 */
	public void setIdDataFineElab(java.sql.Timestamp val) {

		if (val != null) {
			idDataFineElab = new java.sql.Timestamp(val.getTime());
		} else {
			idDataFineElab = null;
		}

	}
	/**
	 * @generated
	 */
	public java.sql.Timestamp getIdDataFineElab() {

		if (idDataFineElab != null) {
			return new java.sql.Timestamp(idDataFineElab.getTime());
		} else {
			return null;
		}

	}

	/*	 
	 * @generated
	 */
	private String idNomeFileImport;

	/**
	 * @generated
	 */
	public void setIdNomeFileImport(String val) {

		idNomeFileImport = val;

	}
	/**
	 * @generated
	 */
	public String getIdNomeFileImport() {

		return idNomeFileImport;

	}
	
	private String uidIndex;
	
	public String getUidIndex() {
		
		return uidIndex;
	
	}
	
	public void setUidIndex(String uidIndex) {
	
		this.uidIndex = uidIndex;
	
	}

	/*	 
	 * @generated
	 */
	private java.math.BigDecimal idAnnoRiferimento;

	/**
	 * @generated
	 */
	public void setIdAnnoRiferimento(java.math.BigDecimal val) {

		idAnnoRiferimento = val;

	}
	/**
	 * @generated
	 */
	public java.math.BigDecimal getIdAnnoRiferimento() {

		return idAnnoRiferimento;

	}
	
	private String dataInvioMailDistrib;
	
	public String getDataInvioMailDistrib() {
		
		return dataInvioMailDistrib;
	
	}
	
	public void setDataInvioMailDistrib(String dataInvioMailDistrib) {
	
		this.dataInvioMailDistrib = dataInvioMailDistrib;
	
	}

	private String dataInvioMailAssistenza;
	
	public String getDataInvioMailAssistenza() {
	
		return dataInvioMailAssistenza;
	
	}
	
	public void setDataInvioMailAssistenza(String dataInvioMailAssistenza) {
	
		this.dataInvioMailAssistenza = dataInvioMailAssistenza;
	
	}

	/*	 
	 * @generated
	 */
	private String sdDesStatoDistrib;

	/**
	 * @generated
	 */
	public void setSdDesStatoDistrib(String val) {

		sdDesStatoDistrib = val;

	}
	/**
	 * @generated
	 */
	public String getSdDesStatoDistrib() {

		return sdDesStatoDistrib;

	}

	/*	 
	 * @generated
	 */
	private java.sql.Timestamp idDataAnnullamento;

	/**
	 * @generated
	 */
	public void setIdDataAnnullamento(java.sql.Timestamp val) {

		if (val != null) {
			idDataAnnullamento = new java.sql.Timestamp(val.getTime());
		} else {
			idDataAnnullamento = null;
		}

	}
	/**
	 * @generated
	 */
	public java.sql.Timestamp getIdDataAnnullamento() {

		if (idDataAnnullamento != null) {
			return new java.sql.Timestamp(idDataAnnullamento.getTime());
		} else {
			return null;
		}

	}

	/*	 
	 * @generated
	 */
	private java.math.BigDecimal idTotRecordElaborati;

	/**
	 * @generated
	 */
	public void setIdTotRecordElaborati(java.math.BigDecimal val) {

		idTotRecordElaborati = val;

	}
	/**
	 * @generated
	 */
	public java.math.BigDecimal getIdTotRecordElaborati() {

		return idTotRecordElaborati;

	}

	/*	 
	 * @generated
	 */
	private java.math.BigDecimal idTotRecordScartati;

	/**
	 * @generated
	 */
	public void setIdTotRecordScartati(java.math.BigDecimal val) {

		idTotRecordScartati = val;

	}
	/**
	 * @generated
	 */
	public java.math.BigDecimal getIdTotRecordScartati() {

		return idTotRecordScartati;

	}
	
	private String dataUltMod;
	
	public String getDataUltMod() {
	
		return dataUltMod;

	}
	
	public void setDataUltMod(String dataUltMod) {
	
		this.dataUltMod = dataUltMod;
	
	}
	
	private String utenteUltMod;
	
	public String getUtenteUltMod() {
		
		return utenteUltMod;
	
	}
	
	public void setUtenteUltMod(String utenteUltMod) {
	
		this.utenteUltMod = utenteUltMod;
	
	}
	
	private String utenteCaricamento;
	
	public String getUtenteCaricamento() {
	
		return utenteCaricamento;
	
	}
	
	public void setUtenteCaricamento(String utenteCaricamento) {
	
		this.utenteCaricamento = utenteCaricamento;
	
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
