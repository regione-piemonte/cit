package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTDettTipo3Dto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTDettTipo3Pk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTDettTipo3DaoException;

import java.math.BigDecimal;
import java.util.List;

public interface SigitTDettTipo3Dao {
	public SigitTDettTipo3Pk insert(SigitTDettTipo3Dto dto);

	void customDeleterByIdAllegato(BigDecimal idAllegato) throws SigitTDettTipo3DaoException;

	List<SigitTDettTipo3Dto> findByAllegatoCodImpianto(SigitTDettTipo3Dto dto) throws SigitTDettTipo3DaoException;

	public void update(SigitTDettTipo3Dto dto) throws SigitTDettTipo3DaoException;
}
