package it.csi.citpwa.model.sigitext;

import java.io.Serializable;
import java.util.Date;

public class DocumentiAllegatiImpianto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer idDocAllegato;
	private String nomeDoc;
	private String tipoDoc;
	private String descrizione;
	private Date dataUpload;
	private String stato;
	private String uidIndex;
	private Date dataControllo;
	private String tipoREE;
	private Integer statoREE;
	private String tipoComponente;
	private String descrizioneTipoRee;
	private String descrizioneStatoRee;
	
	public Integer getIdDocAllegato() {
		return idDocAllegato;
	}
	public void setIdDocAllegato(Integer idDocAllegato) {
		this.idDocAllegato = idDocAllegato;
	}
	public String getNomeDoc() {
		return nomeDoc;
	}
	public void setNomeDoc(String nomeDoc) {
		this.nomeDoc = nomeDoc;
	}
	public String getTipoDoc() {
		return tipoDoc;
	}
	public void setTipoDoc(String tipoDoc) {
		this.tipoDoc = tipoDoc;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public Date getDataUpload() {
		return dataUpload;
	}
	public void setDataUpload(Date dataUpload) {
		this.dataUpload = dataUpload;
	}
	public String getStato() {
		return stato;
	}
	public void setStato(String stato) {
		this.stato = stato;
	}
	public String getUidIndex() {
		return uidIndex;
	}
	public void setUidIndex(String uidIndex) {
		this.uidIndex = uidIndex;
	}
	public Date getDataControllo() {
		return dataControllo;
	}
	public void setDataControllo(Date dataControllo) {
		this.dataControllo = dataControllo;
	}
	public String getTipoREE() {
		return tipoREE;
	}
	public void setTipoREE(String tipoREE) {
		this.tipoREE = tipoREE;
	}
	public Integer getStatoREE() {
		return statoREE;
	}
	public void setStatoREE(Integer statoREE) {
		this.statoREE = statoREE;
	}
	public String getTipoComponente() {
		return tipoComponente;
	}
	public void setTipoComponente(String tipoComponente) {
		this.tipoComponente = tipoComponente;
	}
	public String getDescrizioneTipoRee() {
		return descrizioneTipoRee;
	}
	public void setDescrizioneTipoRee(String descrizioneTipoRee) {
		this.descrizioneTipoRee = descrizioneTipoRee;
	}
	public String getDescrizioneStatoRee() {
		return descrizioneStatoRee;
	}
	public void setDescrizioneStatoRee(String descrizioneStatoRee) {
		this.descrizioneStatoRee = descrizioneStatoRee;
	}
}
