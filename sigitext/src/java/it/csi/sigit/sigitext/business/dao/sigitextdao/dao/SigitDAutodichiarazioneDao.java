package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import java.util.List;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitDAutodichiarazioneDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitDAutodichiarazionePk;
import it.csi.sigit.sigitext.exception.sigitext.SigitextException;

public interface SigitDAutodichiarazioneDao {
	
	List<SigitDAutodichiarazioneDto> findAll() throws SigitextException;
	String getDesById(SigitDAutodichiarazionePk pk) throws SigitextException;

}
