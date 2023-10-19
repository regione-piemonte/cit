package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.filter.LibrettoFilter;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitSLibrettoDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitSLibrettoDaoException;

import java.util.List;

public interface SigitSLibrettoDao {
	public void customUpdaterStoricizzaByCodImpianto(SigitSLibrettoDto filter, Object value)
			throws SigitSLibrettoDaoException;
	@SuppressWarnings("unchecked")
	public List<SigitSLibrettoDto> findByLibrettoFilter(LibrettoFilter input)
			throws SigitSLibrettoDaoException;

}
