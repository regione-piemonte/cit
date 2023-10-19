package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTAllegatoDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTAllegatoPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTAllegatoDaoException;

import java.math.BigDecimal;

public interface SigitTAllegatoDao {

	public SigitTAllegatoPk insert(SigitTAllegatoDto dto);

	public void update(SigitTAllegatoDto dto) throws SigitTAllegatoDaoException;

	public SigitTAllegatoDto findByPrimaryKey(SigitTAllegatoPk pk) throws SigitTAllegatoDaoException;

	void delete(SigitTAllegatoPk sigitTAllegatoPk) throws SigitTAllegatoDaoException;

	public SigitTAllegatoDto findUltimoControlloGT(BigDecimal progressivo, BigDecimal codiceImpianto) throws SigitTAllegatoDaoException;
	public SigitTAllegatoDto findUltimoControlloGF(BigDecimal progressivo, BigDecimal codiceImpianto) throws SigitTAllegatoDaoException;
	public SigitTAllegatoDto findUltimoControlloSC(BigDecimal progressivo, BigDecimal codiceImpianto) throws SigitTAllegatoDaoException;
	public SigitTAllegatoDto findUltimoControlloCG(BigDecimal progressivo, BigDecimal codiceImpianto) throws SigitTAllegatoDaoException;

}
