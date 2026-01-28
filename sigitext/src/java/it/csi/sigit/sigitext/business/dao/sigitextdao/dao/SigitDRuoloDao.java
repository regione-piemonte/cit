package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import java.util.List;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitDRuoloDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitDRuoloPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitDRuoloDaoException;

public interface SigitDRuoloDao {
	
	public SigitDRuoloDto findById(SigitDRuoloPk pk) throws SigitDRuoloDaoException;
	SigitDRuoloDto findByDes(String desRuolo, String ruoloFunz) throws SigitDRuoloDaoException;
	List<SigitDRuoloDto> findByRuoloFunz(String ruoloFunz) throws SigitDRuoloDaoException;

}
