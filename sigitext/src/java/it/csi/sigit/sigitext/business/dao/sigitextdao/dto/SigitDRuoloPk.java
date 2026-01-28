package it.csi.sigit.sigitext.business.dao.sigitextdao.dto;

import java.io.Serializable;

public class SigitDRuoloPk implements Serializable {

	private static final long serialVersionUID = 1L;
	
	protected Integer idRuolo;
	
	public SigitDRuoloPk() {
		
	}
	
	public SigitDRuoloPk(Integer idRuolo) {
		this.idRuolo = idRuolo;
	}

	public Integer getIdRuolo() {
		return idRuolo;
	}

	public void setIdRuolo(Integer idRuolo) {
		this.idRuolo = idRuolo;
	}
	
	

}
