package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.filter.ImpiantoFilter;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.filter.RicercaAvanzataImpiantoFilter;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitVRicercaImpiantiDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitVRicercaImpiantiDaoException;

import java.util.List;

public interface SigitVRicercaImpiantiDao {

	@SuppressWarnings("unchecked")
	public List<SigitVRicercaImpiantiDto> findByImpiantoFilter(ImpiantoFilter input)
			throws SigitVRicercaImpiantiDaoException;

	@SuppressWarnings("unchecked")
	public List<SigitVRicercaImpiantiDto> findImpiantiDaRicercaAvanzata(RicercaAvanzataImpiantoFilter input)
			throws SigitVRicercaImpiantiDaoException;
}