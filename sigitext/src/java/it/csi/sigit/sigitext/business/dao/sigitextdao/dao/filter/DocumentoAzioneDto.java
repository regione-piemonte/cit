/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.filter;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTDocAzioneDto;
import it.csi.sigit.sigitext.business.util.DateUtil;

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
		docEntity.setNomeDoc(doc.getNomeFileMod());
		docEntity.setNomeDocOriginale(doc.getNomeFile());
		docEntity.setUtenteUltMod(cfUtenteMod);
		
		return docEntity;
		
	}
	
}
