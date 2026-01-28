package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.filter.CompFilter;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTCompGfCompletoDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTCompGfDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTCompGfPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTCompGfDaoException;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTCompGtDaoException;

import java.util.List;

/**
 * Interfaccia pubblica del DAO sigitTCompGf.
 * Espone le operazioni che possono essere eseguite per la gestione
 * della tabella [Table[TRANSIENT]]
 *
 * @generated
 */
public interface SigitTCompGfDao {
	public SigitTCompGfPk insert(SigitTCompGfDto dto);

	public void customDeleterByCodImpianto(Integer filter) throws SigitTCompGfDaoException;

	public List<SigitTCompGfDto> ricercaComponentiByFiltro(CompFilter filter) throws SigitTCompGfDaoException;

	public List<SigitTCompGfCompletoDto> ricercaComponentiCompletoByFiltro(CompFilter compFilter) throws SigitTCompGfDaoException;

	public void update(SigitTCompGfDto dto) throws SigitTCompGfDaoException;

	public void delete(SigitTCompGfPk pk) throws SigitTCompGfDaoException;

	public void delete(CompFilter compFilter) throws SigitTCompGfDaoException;

	public void customDeleterByFilter(CompFilter filter) throws SigitTCompGfDaoException;

}
