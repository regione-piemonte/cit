package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import java.util.List;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitRContr2019AutodichiarDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitRContr2019AutodichiarPk;
import it.csi.sigit.sigitext.exception.sigitext.SigitextException;

public interface SigitRContr2019AutodichiarDao {

	List<SigitRContr2019AutodichiarDto> findAllByIdContratto(SigitRContr2019AutodichiarPk pk) throws SigitextException;
	void insert(SigitRContr2019AutodichiarDto dto) throws SigitextException;
}
