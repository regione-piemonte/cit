package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTStoricoVarStatoPgDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTStoricoVarStatoPgDaoException;

public interface SigitTStoricoVarStatoPgDao {
	
	void insert(SigitTStoricoVarStatoPgDto dto) throws SigitTStoricoVarStatoPgDaoException;
	void update(SigitTStoricoVarStatoPgDto dto) throws SigitTStoricoVarStatoPgDaoException;
	

}
