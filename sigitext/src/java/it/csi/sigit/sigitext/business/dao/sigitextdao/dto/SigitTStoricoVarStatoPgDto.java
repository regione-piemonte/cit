package it.csi.sigit.sigitext.business.dao.sigitextdao.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class SigitTStoricoVarStatoPgDto extends SigitTStoricoVarStatoPgPk {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private java.sql.Date dt_inizio_variazione;
	private String motivo;
	private BigDecimal stato_pg_da;
	private BigDecimal stato_pg_a;
	private Timestamp data_ult_mod;
	private String utente_ult_mod;
	
	public java.sql.Date getDt_inizio_variazione() {
		return dt_inizio_variazione;
	}
	public void setDt_inizio_variazione(java.sql.Date dt_inizio_variazione) {
		this.dt_inizio_variazione = dt_inizio_variazione;
	}
	public String getMotivo() {
		return motivo;
	}
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	public BigDecimal getStato_pg_da() {
		return stato_pg_da;
	}
	public void setStato_pg_da(BigDecimal stato_pg_da) {
		this.stato_pg_da = stato_pg_da;
	}
	public BigDecimal getStato_pg_a() {
		return stato_pg_a;
	}
	public void setStato_pg_a(BigDecimal stato_pg_a) {
		this.stato_pg_a = stato_pg_a;
	}
	public Timestamp getData_ult_mod() {
		return data_ult_mod;
	}
	public void setData_ult_mod(Timestamp data_ult_mod) {
		this.data_ult_mod = data_ult_mod;
	}
	public String getUtente_ult_mod() {
		return utente_ult_mod;
	}
	public void setUtente_ult_mod(String utente_ult_mod) {
		this.utente_ult_mod = utente_ult_mod;
	}

}
