package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import java.math.BigDecimal;
import java.util.List;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitRIspezIspetDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitRIspezIspetDaoException;

public interface SigitRIspezIspetDao {
	
	public List<SigitRIspezIspetDto> findByFkPersonaFisica(BigDecimal fkPersonaFisica) throws SigitRIspezIspetDaoException;

	List<SigitRIspezIspetDto> findByIdIspezione2018(BigDecimal idIspezione2018) throws SigitRIspezIspetDaoException;

	public void update(SigitRIspezIspetDto sigitRIspezIspetDto) throws SigitRIspezIspetDaoException;

	public Integer insert(SigitRIspezIspetDto sigitRIspezIspetDto) throws SigitRIspezIspetDaoException;

	public SigitRIspezIspetDto findByPrimaryKey(BigDecimal idIspezIspet) throws SigitRIspezIspetDaoException;

}
