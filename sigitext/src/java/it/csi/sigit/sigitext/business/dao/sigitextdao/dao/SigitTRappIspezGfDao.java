package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import java.math.BigDecimal;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTRappIspezGfDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTRappIspezGfPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTRappIspezGfDaoException;

public interface SigitTRappIspezGfDao {

	public SigitTRappIspezGfPk insert(SigitTRappIspezGfDto dto) throws SigitTRappIspezGfDaoException;

	public void delete(BigDecimal idAllegato) throws SigitTRappIspezGfDaoException;
	
	public SigitTRappIspezGfDto findByPrimaryKey(SigitTRappIspezGfPk pk) throws SigitTRappIspezGfDaoException;
	
	public void update(SigitTRappIspezGfDto dto) throws SigitTRappIspezGfDaoException;
}
