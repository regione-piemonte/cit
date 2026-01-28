package it.csi.sigit.sigitext.business.dao.sigitextdao.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class SigitTAzioneContrattoPk implements Serializable {

	private static final long serialVersionUID = 1L; 
	
	private BigDecimal id_contratto;
	private java.sql.Timestamp dt_azione;
	
	public BigDecimal getId_contratto() {
		return id_contratto;
	}
	public void setId_contratto(BigDecimal id_contratto) {
		this.id_contratto = id_contratto;
	}
	public java.sql.Timestamp getDt_azione() {
		return dt_azione;
	}
	public void setDt_azione(java.sql.Timestamp dt_azione) {
		this.dt_azione = dt_azione;
	}
	
	
	

}
