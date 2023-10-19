package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTAzioneComp4Dto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTAzioneComp4Pk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTComp4Pk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTAzioneComp4DaoException;

public interface SigitTAzioneComp4Dao {

	public SigitTAzioneComp4Pk insert(SigitTAzioneComp4Dto dto);

	public void customDeleterByComp4(SigitTComp4Pk filter) throws SigitTAzioneComp4DaoException;

}
