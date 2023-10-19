/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter;

import java.io.File;
import java.sql.Timestamp;


public class ImportDocumentoFilter extends ImportFileSuper{
	
	private String codImpianto;
	private String idAllegato;
	private Integer idImpRuoloPfpg;
	private Integer idTipoDocumento;
	private String descrizione;
	
	
	
	public String getCodImpianto() {
		return codImpianto;
	}
	public void setCodImpianto(String codImpianto) {
		this.codImpianto = codImpianto;
	}
	public String getIdAllegato() {
		return idAllegato;
	}
	public void setIdAllegato(String idAllegato) {
		this.idAllegato = idAllegato;
	}
	public Integer getIdTipoDocumento() {
		return idTipoDocumento;
	}
	public void setIdTipoDocumento(Integer idTipoDocumento) {
		this.idTipoDocumento = idTipoDocumento;
	}
	public Integer getIdImpRuoloPfpg() {
		return idImpRuoloPfpg;
	}
	public void setIdImpRuoloPfpg(Integer idImpRuoloPfpg) {
		this.idImpRuoloPfpg = idImpRuoloPfpg;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	
	
}
