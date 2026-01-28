package it.csi.sigit.sigitext.business.dao.sigitextdao.dto;

import java.math.BigDecimal;
import java.util.Date;

public class SigitTDocContrattoDto extends SigitTDocContrattoPk {

	private static final long serialVersionUID = 1L;
	
	private BigDecimal fkContratto;
	private String nomeDocOriginale;
	private String nomeDoc;
	private String descrizione;
	private Date dataUpload;
	private Date dataDelete;
	private String  uidIndex;
	private Date dataUltMod;
	private String utenteUltMod;
	public BigDecimal getFkContratto() {
		return fkContratto;
	}
	public void setFkContratto(BigDecimal fkContratto) {
		this.fkContratto = fkContratto;
	}
	public String getNomeDocOriginale() {
		return nomeDocOriginale;
	}
	public void setNomeDocOriginale(String nomeDocOriginale) {
		this.nomeDocOriginale = nomeDocOriginale;
	}
	public String getNomeDoc() {
		return nomeDoc;
	}
	public void setNomeDoc(String nomeDoc) {
		this.nomeDoc = nomeDoc;
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
	public Date getDataDelete() {
		return dataDelete;
	}
	public void setDataDelete(Date dataDelete) {
		this.dataDelete = dataDelete;
	}
	public String getUidIndex() {
		return uidIndex;
	}
	public void setUidIndex(String uidIndex) {
		this.uidIndex = uidIndex;
	}
	public Date getDataUltMod() {
		return dataUltMod;
	}
	public void setDataUltMod(Date dataUltMod) {
		this.dataUltMod = dataUltMod;
	}
	public String getUtenteUltMod() {
		return utenteUltMod;
	}
	public void setUtenteUltMod(String utenteUltMod) {
		this.utenteUltMod = utenteUltMod;
	}
	
	public SigitTDocContrattoPk createPk() {
		return new SigitTDocContrattoPk(idDocContratto);
	}
	
	

}
