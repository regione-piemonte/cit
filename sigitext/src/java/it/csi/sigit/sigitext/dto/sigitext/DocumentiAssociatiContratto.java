package it.csi.sigit.sigitext.dto.sigitext;

import java.io.Serializable;
import java.util.Date;

public class DocumentiAssociatiContratto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer idDocContratto;
	private String nomeDoc;
	private String tipoDoc;
	private String descrizione;
	private Date dataUpload;
	private String stato;
	private String uidIndex;
	private Integer fkContratto;
	private Date dataInizio;
	private Date dataFine;
	private Integer flgTacitoRinnovo;
	private Date dataCessazione;
	private String motivoCessazione;
	private Integer fkTipoCessazione;
	private String desTipoCessazione;
	private String note;
	private Integer fkPg3Resp;
	private String denominazione3Resp;
	private String codiceFiscale3Resp;
	
	
	
	public Integer getIdDocContratto() {
		return idDocContratto;
	}
	public void setIdDocContratto(Integer idDocContratto) {
		this.idDocContratto = idDocContratto;
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
	public Integer getFkContratto() {
		return fkContratto;
	}
	public void setFkContratto(Integer fkContratto) {
		this.fkContratto = fkContratto;
	}
	public Date getDataInizio() {
		return dataInizio;
	}
	public void setDataInizio(Date dataInizio) {
		this.dataInizio = dataInizio;
	}
	public Date getDataFine() {
		return dataFine;
	}
	public void setDataFine(Date dataFine) {
		this.dataFine = dataFine;
	}
	public Integer getFlgTacitoRinnovo() {
		return flgTacitoRinnovo;
	}
	public void setFlgTacitoRinnovo(Integer flgTacitoRinnovo) {
		this.flgTacitoRinnovo = flgTacitoRinnovo;
	}
	public Date getDataCessazione() {
		return dataCessazione;
	}
	public void setDataCessazione(Date dataCessazione) {
		this.dataCessazione = dataCessazione;
	}
	public String getMotivoCessazione() {
		return motivoCessazione;
	}
	public void setMotivoCessazione(String motivoCessazione) {
		this.motivoCessazione = motivoCessazione;
	}
	public Integer getFkTipoCessazione() {
		return fkTipoCessazione;
	}
	public void setFkTipoCessazione(Integer fkTipoCessazione) {
		this.fkTipoCessazione = fkTipoCessazione;
	}
	public String getDesTipoCessazione() {
		return desTipoCessazione;
	}
	public void setDesTipoCessazione(String desTipoCessazione) {
		this.desTipoCessazione = desTipoCessazione;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Integer getFkPg3Resp() {
		return fkPg3Resp;
	}
	public void setFkPg3Resp(Integer fkPg3Resp) {
		this.fkPg3Resp = fkPg3Resp;
	}
	public String getDenominazione3Resp() {
		return denominazione3Resp;
	}
	public void setDenominazione3Resp(String denominazione3Resp) {
		this.denominazione3Resp = denominazione3Resp;
	}
	public String getCodiceFiscale3Resp() {
		return codiceFiscale3Resp;
	}
	public void setCodiceFiscale3Resp(String codiceFiscale3Resp) {
		this.codiceFiscale3Resp = codiceFiscale3Resp;
	}
	
	

}
