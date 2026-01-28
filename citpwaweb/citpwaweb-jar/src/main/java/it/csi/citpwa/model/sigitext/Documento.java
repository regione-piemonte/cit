package it.csi.citpwa.model.sigitext;

import java.util.Date;

public class Documento implements java.io.Serializable {
	static final long serialVersionUID = 1L;

	private String uid;
	private String nome;
	private Long dimensione;
	private Date dataUpload;
	private String mimeType;
	private String encoding;
	private Boolean isPdfStatico;
	private String doc;
	
	public Boolean getIsPdfStatico() {
		return isPdfStatico;
	}
	
	public void setIsPdfStatico(Boolean pdfStatico) {
		isPdfStatico = pdfStatico;
	}
	
	public String getEncoding() {
		return encoding;
	}
	
	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}
	
	public String getMimeType() {
		return mimeType;
	}
	
	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}
	
	public Date getDataUpload() {
		return (dataUpload == null ? null : new Date(dataUpload.getTime()));
	}
	
	public void setDataUpload(Date dataUpload) {
		this.dataUpload = (dataUpload == null ? null : new Date(dataUpload.getTime()));
	}
	
	public Long getDimensione() {
		return dimensione;
	}
	
	public void setDimensione(Long dimensione) {
		this.dimensione = dimensione;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getUid() {
		return uid;
	}
	
	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getDoc() {
		return doc;
	}

	public void setDoc(String doc) {
		this.doc = doc;
	}

}
