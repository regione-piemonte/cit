package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import java.util.List;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitDTipoDocDto;
import it.csi.sigit.sigitext.exception.sigitext.SigitextException;

public interface SigitDTipoDocumentoDao {

	public List<SigitDTipoDocDto> getTipoDocumenti() throws SigitextException;
	
	String getDescrizioneById(Integer idTipoDocAgg) throws SigitextException;
	
}
