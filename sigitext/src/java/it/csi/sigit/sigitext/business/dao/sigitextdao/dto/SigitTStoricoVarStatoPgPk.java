package it.csi.sigit.sigitext.business.dao.sigitextdao.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class SigitTStoricoVarStatoPgPk implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected java.sql.Timestamp dt_evento;
	protected BigDecimal id_persona_giuridica;
	
	
	public java.sql.Timestamp getDt_evento() {
		return dt_evento;
	}
	public void setDt_evento(java.sql.Timestamp dt_evento) {
		this.dt_evento = dt_evento;
	}
	public BigDecimal getId_persona_giuridica() {
		return id_persona_giuridica;
	}
	public void setId_persona_giuridica(BigDecimal id_persona_giuridica) {
		this.id_persona_giuridica = id_persona_giuridica;
	}

}
