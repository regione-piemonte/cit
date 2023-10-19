package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitDDettaglioGtDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitDDettaglioGtDaoException;

import java.util.List;

public interface SigitDDettaglioGtDao {

	public List<SigitDDettaglioGtDto> findAll() throws SigitDDettaglioGtDaoException;
}
