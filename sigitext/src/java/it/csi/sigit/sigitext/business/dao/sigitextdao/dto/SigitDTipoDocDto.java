package it.csi.sigit.sigitext.business.dao.sigitextdao.dto;

import java.io.Serializable;

public class SigitDTipoDocDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_PERSONA
	 * 
	 * @generated
	 */
	protected java.math.BigDecimal idTipoDoc;

	protected String description;

	public java.math.BigDecimal getIdTipoDoc() {
		return idTipoDoc;
	}

	public void setIdTipoDoc(java.math.BigDecimal idTipoDoc) {
		this.idTipoDoc = idTipoDoc;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
