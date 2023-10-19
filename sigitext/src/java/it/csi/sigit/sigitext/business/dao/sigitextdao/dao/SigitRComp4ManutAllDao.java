package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.filter.CompFilter;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitRComp4ManutAllDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitRComp4ManutAllPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitRComp4ManutAllDaoException;

import java.math.BigDecimal;
import java.util.List;

public interface SigitRComp4ManutAllDao {

	public SigitRComp4ManutAllPk insert(SigitRComp4ManutAllDto dto);

	public List<SigitRComp4ManutAllDto> findByComp(CompFilter filter) throws SigitRComp4ManutAllDaoException;

	void customDeleterByIdAllegato(BigDecimal idAllegato) throws SigitRComp4ManutAllDaoException;
}
