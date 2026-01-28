package it.csi.sigit.sigitext.business.dao.sigitextdao.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class SigitRIspezIspetPk implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private BigDecimal idIspezIspet;


	public BigDecimal getIdIspezIspet() {
		return idIspezIspet;
	}


	public void setIdIspezIspet(BigDecimal idIspezIspet) {
		this.idIspezIspet = idIspezIspet;
	}


	@Override
	public String toString() {
		return "SigitRIspezIspetPk [idIspezIspet=" + idIspezIspet + "]";
	}
	
	
}
