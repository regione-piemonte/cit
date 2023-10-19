/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

public class SigitExtVerificaDto extends SigitTVerificaDto implements Serializable{
	
	private BigDecimal fkAccertamento;
	private BigDecimal fkIspezione;
	
	
	public BigDecimal getFkAccertamento() {
		return fkAccertamento;
	}
	public void setFkAccertamento(BigDecimal fkAccertamento) {
		this.fkAccertamento = fkAccertamento;
	}
	public BigDecimal getFkIspezione() {
		return fkIspezione;
	}
	public void setFkIspezione(BigDecimal fkIspezione) {
		this.fkIspezione = fkIspezione;
	}
	

	
}
