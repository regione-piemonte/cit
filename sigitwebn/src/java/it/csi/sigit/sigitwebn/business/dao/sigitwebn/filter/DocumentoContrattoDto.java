/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTDocAzioneDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTDocContrattoDto;
import it.csi.sigit.sigitwebn.dto.terzoresponsabile.DocContratto;
import it.csi.sigit.sigitwebn.util.ConvertUtil;
import it.csi.sigit.sigitwebn.util.DateUtil;

public class DocumentoContrattoDto extends ImportFileSuper {

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




	public static SigitTDocContrattoDto mapToSigitTDocContrattoDto(Integer idContratto, DocumentoContrattoDto doc, String cfUtenteMod) {
		
		SigitTDocContrattoDto docEntity = new SigitTDocContrattoDto();
		docEntity.setFkContratto(idContratto);
		docEntity.setDataUltMod(DateUtil.getSqlCurrentDate());
		docEntity.setNomeDoc(doc.getNomeFileMod());
		docEntity.setNomeDocOriginale(doc.getNomeFile());
		docEntity.setUtenteUltMod(cfUtenteMod);
		docEntity.setDescrizione(doc.getDescrizione());
		
		return docEntity;
		
	}
	
	
	public static DocContratto mapToSigitTDocContrattoClient(SigitTDocContrattoDto inputDb) {
		DocContratto docClient = new DocContratto();
		docClient.setDataUpload(ConvertUtil.convertToString(inputDb.getDataUpload()));
		docClient.setDescrizione(inputDb.getDescrizione());
		docClient.setIdDocContratto(inputDb.getIdDocContratto());
		docClient.setNomeDocumento(inputDb.getNomeDoc());
		docClient.setStatoDocumento(inputDb.getDataDelete() == null ? "Attivo" : "Cancellato");
		docClient.setUidIndex(inputDb.getUidIndex());
		return docClient;
	}
	
}
