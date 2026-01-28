package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import java.math.BigDecimal;
import java.util.List;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTDettIspezGfDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTDettIspezGfPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTDettIspezGfDaoException;

public interface SigitTDettIspezGfDao {

	public SigitTDettIspezGfPk insert(SigitTDettIspezGfDto dto) throws SigitTDettIspezGfDaoException;

	public void delete(BigDecimal idAllegato) throws SigitTDettIspezGfDaoException;
	
	public List<SigitTDettIspezGfDto> findByExample(SigitTDettIspezGfDto input) throws SigitTDettIspezGfDaoException;
	
	public List<SigitTDettIspezGfDto> findByIdAllegato(java.math.BigDecimal input) throws SigitTDettIspezGfDaoException;
	
	public void update(SigitTDettIspezGfDto dto) throws SigitTDettIspezGfDaoException;
}
