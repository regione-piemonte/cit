package it.csi.sigit.sigitext.business.dao.sigitextdao.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class SigitDTipoInterventoDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	protected BigDecimal idTipoIntervento;
	protected String desTipoIntervento;
	
	
	public BigDecimal getIdTipoIntervento() {
		return idTipoIntervento;
	}
	public void setIdTipoIntervento(BigDecimal idTipoIntervento) {
		this.idTipoIntervento = idTipoIntervento;
	}
	public String getDesTipoIntervento() {
		return desTipoIntervento;
	}
	public void setDesTipoIntervento(String desTipoIntervento) {
		this.desTipoIntervento = desTipoIntervento;
	}
	
	

}
