package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.filter.CompFilter;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTCompGtCompletoDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTCompGtDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTCompGtPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTCompGtDaoException;

import java.util.List;

/**
 * Interfaccia pubblica del DAO sigitTCompGt.
 * Espone le operazioni che possono essere eseguite per la gestione
 * della tabella [Table[TRANSIENT]]
 *
 * @generated
 */
public interface SigitTCompGtDao {

	/**
	 * Metodo di inserimento del DAO sigitTCompGt. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 *
	 * @param dto
	 * @return SigitTCompGtPk
	 * @generated
	 */

	public SigitTCompGtPk insert(SigitTCompGtDto dto)

	;

	/**
	 * Custom deleter in the SIGIT_T_COMP_GT table.
	 *
	 * @generated
	 */
	public void customDeleterByCodImpianto(Integer filter) throws SigitTCompGtDaoException;

	public List<SigitTCompGtCompletoDto> ricercaComponentiByFiltro(CompFilter compFilter) throws SigitTCompGtDaoException;

	public void update(SigitTCompGtDto mapToSigitTCompGTDto) throws SigitTCompGtDaoException;

	public void delete(CompFilter cp) throws SigitTCompGtDaoException;

	public void delete(SigitTCompGtPk pk) throws SigitTCompGtDaoException;

	public void customDeleterByFilter(CompFilter filter) throws SigitTCompGtDaoException;
}
