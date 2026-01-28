package it.csi.sigit.sigitext.business.dao.sigitextdao.dto;

import java.io.Serializable;

public class SigitRContr2019AutodichiarPk implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id_contratto;
	private Integer id_autodichiarazione;
	
	public Integer getId_contratto() {
		return id_contratto;
	}
	public void setId_contratto(Integer id_contratto) {
		this.id_contratto = id_contratto;
	}
	public Integer getId_autodichiarazione() {
		return id_autodichiarazione;
	}
	public void setId_autodichiarazione(Integer id_autodichiarazione) {
		this.id_autodichiarazione = id_autodichiarazione;
	}

}
