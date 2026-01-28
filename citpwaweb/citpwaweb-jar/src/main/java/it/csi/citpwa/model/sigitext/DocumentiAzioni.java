package it.csi.citpwa.model.sigitext;

import java.io.Serializable;
import java.util.Date;

public class DocumentiAzioni implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer idDocAzione;
	private String nomeDoc;
	private String tipoDoc;
	private String descrizione;
	private Date dataUpload;
	private String stato;
	private String uidIndex;
	
	public Integer getIdDocAzione() {
		return idDocAzione;
	}
	public void setIdDocAzione(Integer idDocAzione) {
		this.idDocAzione = idDocAzione;
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
}
