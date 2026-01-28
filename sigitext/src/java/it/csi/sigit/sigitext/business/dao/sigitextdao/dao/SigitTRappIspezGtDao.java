package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import java.math.BigDecimal;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTRappIspezGtDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTRappIspezGtPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitSLibrettoDaoException;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTRappIspezGtDaoException;

public interface SigitTRappIspezGtDao {

	
	public SigitTRappIspezGtPk insert(SigitTRappIspezGtDto dto) throws SigitTRappIspezGtDaoException;

	public void delete(BigDecimal idAllegato) throws SigitTRappIspezGtDaoException;
	
	public SigitTRappIspezGtDto findByIdAllegato(BigDecimal idAllegato) throws SigitSLibrettoDaoException;
	
	public SigitTRappIspezGtPk update(SigitTRappIspezGtDto dto) throws SigitTRappIspezGtDaoException;
}
