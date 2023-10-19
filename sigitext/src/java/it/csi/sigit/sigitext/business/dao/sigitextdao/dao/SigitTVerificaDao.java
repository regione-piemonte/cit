package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.filter.RicercaVerificaFilter;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTVerificaDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTVerificaPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTVerificaDaoException;

import java.util.List;

public interface SigitTVerificaDao {

	public SigitTVerificaPk insert(SigitTVerificaDto dto);

	public void update(SigitTVerificaDto dto) throws SigitTVerificaDaoException;

	public void updateColumnsSveglia(SigitTVerificaDto dto) throws SigitTVerificaDaoException;

	public void delete(SigitTVerificaPk pk) throws SigitTVerificaDaoException;

	public void customDeleterByCodImpianto(Integer filter) throws SigitTVerificaDaoException;

	@SuppressWarnings("unchecked")
	public SigitTVerificaDto findByPrimaryKey(SigitTVerificaPk pk) throws SigitTVerificaDaoException;

	@SuppressWarnings("unchecked")
	public List<SigitTVerificaDto> findByExample(RicercaVerificaFilter input) throws SigitTVerificaDaoException;

	/**
	 * Restituisce tutte le righe della tabella SIGIT_T_VERIFICA.
	 *
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTVerificaDto> findAll() throws SigitTVerificaDaoException;

	/**
	 * Implementazione del finder sveglieAttiveByCF
	 *
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTVerificaDto> findSveglieAttiveByCF(String input) throws SigitTVerificaDaoException;

}
