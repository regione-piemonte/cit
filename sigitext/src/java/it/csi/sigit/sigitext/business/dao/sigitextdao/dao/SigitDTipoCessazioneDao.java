package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import java.util.List;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitDTipoCessazioneDto;
import it.csi.sigit.sigitext.exception.sigitext.SigitextException;

public interface SigitDTipoCessazioneDao {
	
	List<SigitDTipoCessazioneDto> getAllTipoCessazioneByIdTipoCessazioneMajorZero() throws SigitextException;
	SigitDTipoCessazioneDto getTipoCessazioneByDes(String des) throws SigitextException;
	SigitDTipoCessazioneDto getTipoCessazioneById(Integer id) throws SigitextException;

}
