package it.csi.sigit.sigitext.dto.sigitext;

import java.io.Serializable;
import java.util.Date;

public class DatiContratto implements Serializable {
	
	static final long serialVersionUID = 1L;
	
	private Integer id_contratto;
	private Integer fk_pg_3_resp;
	private Integer fk_imp_ruolo_pfpg_resp;
	private Integer codice_impianto;
	private Date data_inizio;
	private Date data_fine;
	private Integer flg_tacito_rinnovo;
	private Date data_caricamento;
	private Date data_ult_mod;
	private String utente_utl_mod;
	private Date data_cessazione;
	private Date data_inserimento_cessazione;
	private String motivo_cessazione;
	private String fk_tipo_cessazione;
	private String note;
	public Integer getId_contratto() {
		return id_contratto;
	}
	public void setId_contratto(Integer id_contratto) {
		this.id_contratto = id_contratto;
	}
	public Integer getFk_pg_3_resp() {
		return fk_pg_3_resp;
	}
	public void setFk_pg_3_resp(Integer fk_pg_3_resp) {
		this.fk_pg_3_resp = fk_pg_3_resp;
	}
	public Integer getFk_imp_ruolo_pfpg_resp() {
		return fk_imp_ruolo_pfpg_resp;
	}
	public void setFk_imp_ruolo_pfpg_resp(Integer fk_imp_ruolo_pfpg_resp) {
		this.fk_imp_ruolo_pfpg_resp = fk_imp_ruolo_pfpg_resp;
	}
	public Integer getCodice_impianto() {
		return codice_impianto;
	}
	public void setCodice_impianto(Integer codice_impianto) {
		this.codice_impianto = codice_impianto;
	}
	public Date getData_inizio() {
		return data_inizio;
	}
	public void setData_inizio(Date data_inizio) {
		this.data_inizio = data_inizio;
	}
	public Date getData_fine() {
		return data_fine;
	}
	public void setData_fine(Date data_fine) {
		this.data_fine = data_fine;
	}
	public Integer getFlg_tacito_rinnovo() {
		return flg_tacito_rinnovo;
	}
	public void setFlg_tacito_rinnovo(Integer flg_tacito_rinnovo) {
		this.flg_tacito_rinnovo = flg_tacito_rinnovo;
	}
	public Date getData_caricamento() {
		return data_caricamento;
	}
	public void setData_caricamento(Date data_caricamento) {
		this.data_caricamento = data_caricamento;
	}
	public Date getData_ult_mod() {
		return data_ult_mod;
	}
	public void setData_ult_mod(Date data_ult_mod) {
		this.data_ult_mod = data_ult_mod;
	}
	public String getUtente_utl_mod() {
		return utente_utl_mod;
	}
	public void setUtente_utl_mod(String utente_utl_mod) {
		this.utente_utl_mod = utente_utl_mod;
	}
	public Date getData_cessazione() {
		return data_cessazione;
	}
	public void setData_cessazione(Date data_cessazione) {
		this.data_cessazione = data_cessazione;
	}
	public Date getData_inserimento_cessazione() {
		return data_inserimento_cessazione;
	}
	public void setData_inserimento_cessazione(Date data_inserimento_cessazione) {
		this.data_inserimento_cessazione = data_inserimento_cessazione;
	}
	public String getMotivo_cessazione() {
		return motivo_cessazione;
	}
	public void setMotivo_cessazione(String motivo_cessazione) {
		this.motivo_cessazione = motivo_cessazione;
	}
	public String getFk_tipo_cessazione() {
		return fk_tipo_cessazione;
	}
	public void setFk_tipo_cessazione(String fk_tipo_cessazione) {
		this.fk_tipo_cessazione = fk_tipo_cessazione;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	


}
