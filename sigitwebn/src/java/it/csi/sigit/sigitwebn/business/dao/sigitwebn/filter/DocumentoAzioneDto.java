/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTDocAzioneDto;
import it.csi.sigit.sigitwebn.util.DateUtil;
import it.csi.sigit.sigitwebn.util.ReplaceSpecialCharUtils;

public class DocumentoAzioneDto extends ImportFileSuper {

	private String idAllegato;
	private String descrizione;

	
	public String getIdAllegato() {
		return idAllegato;
	}




	public void setIdAllegato(String idAllegato) {
		this.idAllegato = idAllegato;
	}




	public String getDescrizione() {
		return descrizione;
	}




	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}




	public static SigitTDocAzioneDto mapToSigitTDocAzioneDto(Integer idAzione, DocumentoAzioneDto doc, String cfUtenteMod) {
		
		SigitTDocAzioneDto docEntity = new SigitTDocAzioneDto();
		docEntity.setFkAzione(idAzione);
		docEntity.setDataUltMod(DateUtil.getSqlCurrentDate());
		docEntity.setNomeDoc(ReplaceSpecialCharUtils.sanitize(doc.getNomeFileMod()));
		docEntity.setNomeDocOriginale(ReplaceSpecialCharUtils.sanitize(doc.getNomeFile()));
		docEntity.setUtenteUltMod(ReplaceSpecialCharUtils.sanitize(cfUtenteMod));
		
		return docEntity;
		
	}
	
}
