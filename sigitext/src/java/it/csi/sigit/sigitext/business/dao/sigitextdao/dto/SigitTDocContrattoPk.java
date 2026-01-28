package it.csi.sigit.sigitext.business.dao.sigitextdao.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class SigitTDocContrattoPk implements Serializable {

	private static final long serialVersionUID = 1L;
	
	protected BigDecimal idDocContratto;
	
	public SigitTDocContrattoPk() {
		
	}
	
	public SigitTDocContrattoPk(BigDecimal idDocContratto) {
		this.idDocContratto = idDocContratto;
	}

	public BigDecimal getIdDocContratto() {
		return idDocContratto;
	}

	public void setIdDocContratto(BigDecimal idDocContratto) {
		this.idDocContratto = idDocContratto;
	}
	
	

}
