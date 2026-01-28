package it.csi.sigit.sigitext.business.dao.sigitextdao.dto;

public class SigitTAzioneContrattoDto extends SigitTAzioneContrattoPk {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String cf_utente_azione;
	private String descrizione_azione;
	private java.sql.Date old_data_fine;
	
	public String getCf_utente_azione() {
		return cf_utente_azione;
	}
	public void setCf_utente_azione(String cf_utente_azione) {
		this.cf_utente_azione = cf_utente_azione;
	}
	public String getDescrizione_azione() {
		return descrizione_azione;
	}
	public void setDescrizione_azione(String descrizione_azione) {
		this.descrizione_azione = descrizione_azione;
	}
	public java.sql.Date getOld_data_fine() {
		return old_data_fine;
	}
	public void setOld_data_fine(java.sql.Date old_data_fine) {
		this.old_data_fine = old_data_fine;
	}

}
