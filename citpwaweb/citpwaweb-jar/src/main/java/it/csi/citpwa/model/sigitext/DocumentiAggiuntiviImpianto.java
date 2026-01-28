package it.csi.citpwa.model.sigitext;

import java.io.Serializable;
import java.util.Date;

public class DocumentiAggiuntiviImpianto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer idDocAggiuntiva;
	private String nomeDoc;
	private String tipoDoc;
	private String descrizione;
	private Date dataUpload;
	private String stato;
	private String uidIndex;
	private String tipoDocDes;
	
	public Integer getIdDocAggiuntiva() {
		return idDocAggiuntiva;
	}
	public void setIdDocAggiuntiva(Integer idDocAggiuntiva) {
		this.idDocAggiuntiva = idDocAggiuntiva;
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
	public String getTipoDocDes() {
		return tipoDocDes;
	}
	public void setTipoDocDes(String tipoDocDes) {
		this.tipoDocDes = tipoDocDes;
	}
}
