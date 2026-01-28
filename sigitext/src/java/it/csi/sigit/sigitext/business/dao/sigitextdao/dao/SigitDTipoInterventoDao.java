package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import java.util.List;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitDTipoInterventoDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitDTipoInterventoDaoException;

public interface SigitDTipoInterventoDao {
	
	public List<SigitDTipoInterventoDto> findAll() throws SigitDTipoInterventoDaoException;

}
