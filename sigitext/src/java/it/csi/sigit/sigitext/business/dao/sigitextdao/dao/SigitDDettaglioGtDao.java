package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import java.util.List;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitDDettaglioGtDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitDDettaglioGtPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitDDettaglioGtDaoException;

public interface SigitDDettaglioGtDao {

	public List<SigitDDettaglioGtDto> findAll() throws SigitDDettaglioGtDaoException;

	public SigitDDettaglioGtDto findByPrimaryKey(SigitDDettaglioGtPk pk) throws SigitDDettaglioGtDaoException;
}
