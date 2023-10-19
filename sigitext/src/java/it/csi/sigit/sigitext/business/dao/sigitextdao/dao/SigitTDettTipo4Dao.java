package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTDettTipo4Dto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTDettTipo4Pk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTDettTipo4DaoException;

import java.math.BigDecimal;
import java.util.List;

public interface SigitTDettTipo4Dao {
	public SigitTDettTipo4Pk insert(SigitTDettTipo4Dto dto);

	void customDeleterByIdAllegato(BigDecimal idAllegato) throws SigitTDettTipo4DaoException;

	List<SigitTDettTipo4Dto> findByAllegatoCodImpianto(SigitTDettTipo4Dto dto) throws SigitTDettTipo4DaoException;

	public void update(SigitTDettTipo4Dto dto) throws SigitTDettTipo4DaoException;

}
