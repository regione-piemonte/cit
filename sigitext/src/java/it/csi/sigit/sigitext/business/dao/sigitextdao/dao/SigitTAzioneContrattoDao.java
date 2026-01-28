package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTAzioneContrattoDto;
import it.csi.sigit.sigitext.exception.sigitext.SigitextException;

public interface SigitTAzioneContrattoDao {
	
	void insert(SigitTAzioneContrattoDto dto) throws SigitextException;

}
