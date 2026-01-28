package it.csi.sigit.sigitext.dto.sigitext;

import java.util.List;

public class ImportDatiDistributore {
  private Integer id_import_distrib;
  private Integer fk_persona_giuridica;
  private Integer fk_stato_distrib;
  private String des_stato_distrib;
  private String data_inizio_elab; 
  private String data_fine_elab;
  private String data_annullamento;
  private String nome_file_import;
  private String uid_index;
  private String anno_riferimento;
  private String data_invio_mail_distrib;
  private String data_invio_mail_assistenza;
  private Integer tot_record_elaborati;
  private Integer tot_record_scartati;
  private String data_ult_mod;
  private String utente_ult_mod;
  private String utente_caricamento;
  private List<DatiFornitura> datiFornitura;
  private String dt_assegnazione;
  private String tipo_caricamento;
  private String stato_file;
  
	public Integer getId_import_distrib() {
		return id_import_distrib;
	}
	public void setId_import_distrib(Integer id_import_distrib) {
		this.id_import_distrib = id_import_distrib;
	}
	public Integer getFk_persona_giuridica() {
		return fk_persona_giuridica;
	}
	public void setFk_persona_giuridica(Integer fk_persona_giuridica) {
		this.fk_persona_giuridica = fk_persona_giuridica;
	}
	public Integer getFk_stato_distrib() {
		return fk_stato_distrib;
	}
	public void setFk_stato_distrib(Integer fk_stato_distrib) {
		this.fk_stato_distrib = fk_stato_distrib;
	}
	public String getDes_stato_distrib() {
		return des_stato_distrib;
	}
	public void setDes_stato_distrib(String des_stato_distrib) {
		this.des_stato_distrib = des_stato_distrib;
	}
	public String getData_inizio_elab() {
		return data_inizio_elab;
	}
	public void setData_inizio_elab(String data_inizio_elab) {
		this.data_inizio_elab = data_inizio_elab;
	}
	public String getData_fine_elab() {
		return data_fine_elab;
	}
	public void setData_fine_elab(String data_fine_elab) {
		this.data_fine_elab = data_fine_elab;
	}
	public String getData_annullamento() {
		return data_annullamento;
	}
	public void setData_annullamento(String data_annullamento) {
		this.data_annullamento = data_annullamento;
	}
	public String getNome_file_import() {
		return nome_file_import;
	}
	public void setNome_file_import(String nome_file_import) {
		this.nome_file_import = nome_file_import;
	}
	public String getUid_index() {
		return uid_index;
	}
	public void setUid_index(String uid_index) {
		this.uid_index = uid_index;
	}
	public String getAnno_riferimento() {
		return anno_riferimento;
	}
	public void setAnno_riferimento(String anno_riferimento) {
		this.anno_riferimento = anno_riferimento;
	}
	public String getData_invio_mail_distrib() {
		return data_invio_mail_distrib;
	}
	public void setData_invio_mail_distrib(String data_invio_mail_distrib) {
		this.data_invio_mail_distrib = data_invio_mail_distrib;
	}
	public String getData_invio_mail_assistenza() {
		return data_invio_mail_assistenza;
	}
	public void setData_invio_mail_assistenza(String data_invio_mail_assistenza) {
		this.data_invio_mail_assistenza = data_invio_mail_assistenza;
	}
	public Integer getTot_record_elaborati() {
		return tot_record_elaborati;
	}
	public void setTot_record_elaborati(Integer tot_record_elaborati) {
		this.tot_record_elaborati = tot_record_elaborati;
	}
	public Integer getTot_record_scartati() {
		return tot_record_scartati;
	}
	public void setTot_record_scartati(Integer tot_record_scartati) {
		this.tot_record_scartati = tot_record_scartati;
	}
	public String getData_ult_mod() {
		return data_ult_mod;
	}
	public void setData_ult_mod(String data_ult_mod) {
		this.data_ult_mod = data_ult_mod;
	}
	public String getUtente_ult_mod() {
		return utente_ult_mod;
	}
	public void setUtente_ult_mod(String utente_ult_mod) {
		this.utente_ult_mod = utente_ult_mod;
	}
	public String getUtente_caricamento() {
		return utente_caricamento;
	}
	public void setUtente_caricamento(String utente_caricamento) {
		this.utente_caricamento = utente_caricamento;
	}
	public List<DatiFornitura> getDatiFornitura() {
		return datiFornitura;
	}
	public void setDatiFornitura(List<DatiFornitura> datiFornitura) {
		this.datiFornitura = datiFornitura;
	}
	public String getDt_assegnazione() {
		return dt_assegnazione;
	}
	public void setDt_assegnazione(String dt_assegnazione) {
		this.dt_assegnazione = dt_assegnazione;
	}
	public String getTipo_caricamento() {
		return tipo_caricamento;
	}
	public void setTipo_caricamento(String tipo_caricamento) {
		this.tipo_caricamento = tipo_caricamento;
	}
	public String getStato_file() {
		return stato_file;
	}
	public void setStato_file(String stato_file) {
		this.stato_file = stato_file;
	}
}
