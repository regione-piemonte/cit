package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTDettTipo2Dto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTDettTipo2Pk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTDettTipo2DaoException;

import java.math.BigDecimal;
import java.util.List;

public interface SigitTDettTipo2Dao {
	public SigitTDettTipo2Pk insert(SigitTDettTipo2Dto dto);

	void customDeleterByIdAllegato(BigDecimal idAllegato) throws SigitTDettTipo2DaoException;

	List<SigitTDettTipo2Dto> findByAllegatoCodImpianto(SigitTDettTipo2Dto dto) throws SigitTDettTipo2DaoException;

	public void update(SigitTDettTipo2Dto dto) throws SigitTDettTipo2DaoException;
}
