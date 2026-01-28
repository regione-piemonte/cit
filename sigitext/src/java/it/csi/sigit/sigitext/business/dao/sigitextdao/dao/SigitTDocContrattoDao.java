package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import java.math.BigDecimal;
import java.util.List;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTDocContrattoDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTDocContrattoPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTDocContrattoDaoException;

public interface SigitTDocContrattoDao {
	
	SigitTDocContrattoPk insert(SigitTDocContrattoDto dto);
	
	List<SigitTDocContrattoDto> findSigitTDocContrattoByFkContratto(BigDecimal fkContratto) throws SigitTDocContrattoDaoException;
	
	public SigitTDocContrattoDto findByUidIndex(String uidIndex) throws SigitTDocContrattoDaoException;
	
	public void updateColumnsAggiornaEliminaDoc(SigitTDocContrattoDto dto) throws SigitTDocContrattoDaoException;
	
	void updateUidIndex(Integer idDocContratto, String uidIndex, String nomeDoc);
}
