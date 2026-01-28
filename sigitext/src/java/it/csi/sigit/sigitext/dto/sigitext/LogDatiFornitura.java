package it.csi.sigit.sigitext.dto.sigitext;

public class LogDatiFornitura {
	private Integer id_log_distrib;
	private Integer fk_import_distrib;
	private String msg_errore;
	
	public Integer getId_log_distrib() {
		return id_log_distrib;
	}
	public void setId_log_distrib(Integer id_log_distrib) {
		this.id_log_distrib = id_log_distrib;
	}
	public Integer getFk_import_distrib() {
		return fk_import_distrib;
	}
	public void setFk_import_distrib(Integer fk_import_distrib) {
		this.fk_import_distrib = fk_import_distrib;
	}
	public String getMsg_errore() {
		return msg_errore;
	}
	public void setMsg_errore(String msg_errore) {
		this.msg_errore = msg_errore;
	}
}
