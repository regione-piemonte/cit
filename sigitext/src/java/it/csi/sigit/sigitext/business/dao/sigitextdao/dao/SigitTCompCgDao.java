package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.filter.CompFilter;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTCompCgCompletoDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTCompCgDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTCompCgPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTCompCgDaoException;

import java.util.List;

/**
 * Interfaccia pubblica del DAO sigitTCompCg.
 * Espone le operazioni che possono essere eseguite per la gestione
 * della tabella [Table[TRANSIENT]]
 *
 * @generated
 */
public interface SigitTCompCgDao {

	public SigitTCompCgPk insert(SigitTCompCgDto dto);

	public void customDeleterByCodImpianto(Integer filter) throws SigitTCompCgDaoException;

	List ricercaComponentiByFiltro(CompFilter filter) throws SigitTCompCgDaoException;

	public List<SigitTCompCgCompletoDto> ricercaComponentiCompletoByFiltro(CompFilter input) throws SigitTCompCgDaoException;

	public void update(SigitTCompCgDto dto) throws SigitTCompCgDaoException;

	public void delete(SigitTCompCgPk pk) throws SigitTCompCgDaoException;

	public void delete(CompFilter compFilter) throws SigitTCompCgDaoException;

	public void customDeleterByFilter(CompFilter filter) throws SigitTCompCgDaoException;
}
