package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import java.math.BigDecimal;
import java.util.List;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTDettIspezGtDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTDettIspezGtPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTDettIspezGtDaoException;

public interface SigitTDettIspezGtDao {

	public SigitTDettIspezGtPk insert(SigitTDettIspezGtDto dto) throws SigitTDettIspezGtDaoException;
	
	public  List<SigitTDettIspezGtDto> findByFkAllegato(BigDecimal fkAllegato) throws SigitTDettIspezGtDaoException;
	
	public List<SigitTDettIspezGtDto> findByExample(SigitTDettIspezGtDto input) throws SigitTDettIspezGtDaoException;
	
	public void delete(BigDecimal idAllegato) throws SigitTDettIspezGtDaoException;
	
	public void update(SigitTDettIspezGtDto dto) throws SigitTDettIspezGtDaoException;
}
