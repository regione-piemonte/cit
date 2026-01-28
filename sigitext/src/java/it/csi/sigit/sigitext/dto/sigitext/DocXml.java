package it.csi.sigit.sigitext.dto.sigitext;

public class DocXml {
	
	private String nome_file;
	private String descrizione;
	private String data_upload;
	private String uid_index;
	private byte[] file;
	
	public DocXml() {

	}
	
	public String getNome_file() {
		return nome_file;
	}
	
	public void setNome_file(String nome_file) {
		this.nome_file = nome_file;
	}
	
	public String getDescrizione() {
		return descrizione;
	}
	
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	public String getData_upload() {
		return data_upload;
	}
	
	public void setData_upload(String data_upload) {
		this.data_upload = data_upload;
	}
	
	public String getUid_index() {
		return uid_index;
	}
	
	public void setUid_index(String uid_index) {
		this.uid_index = uid_index;
	}
	
	public byte[] getFile() {
		return file;
	}
	
	public void setFile(byte[] file) {
		this.file = file;
	} 
	
}
