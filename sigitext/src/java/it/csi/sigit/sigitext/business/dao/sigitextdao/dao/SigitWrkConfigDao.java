package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitWrkConfigDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitWrkConfigPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitWrkConfigDaoException;

import java.util.List;

public interface SigitWrkConfigDao {

	@SuppressWarnings("unchecked")
	public List<SigitWrkConfigDto> findAll() throws SigitWrkConfigDaoException;
	@SuppressWarnings("unchecked")
	public SigitWrkConfigDto findByPrimaryKey(SigitWrkConfigPk pk) throws SigitWrkConfigDaoException;
	@SuppressWarnings("unchecked")
	public List<SigitWrkConfigDto> findByChiaveConfig(String input) throws SigitWrkConfigDaoException;

}
