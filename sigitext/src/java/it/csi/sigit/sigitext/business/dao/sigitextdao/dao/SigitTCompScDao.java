package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.filter.CompFilter;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTCompScCompletoDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTCompScDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTCompScPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTCompScDaoException;

import java.util.List;

/**
 * Interfaccia pubblica del DAO sigitTCompSc.
 * Espone le operazioni che possono essere eseguite per la gestione
 * della tabella [Table[TRANSIENT]]
 *
 * @generated
 */
public interface SigitTCompScDao {

	/**
	 * Metodo di inserimento del DAO sigitTCompSc. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 *
	 * @param dto
	 * @return SigitTCompScPk
	 * @generated
	 */

	public SigitTCompScPk insert(SigitTCompScDto dto)

	;

	/**
	 * Custom deleter in the SIGIT_T_COMP_SC table.
	 *
	 * @generated
	 */
	public void customDeleterByCodImpianto(Integer filter) throws SigitTCompScDaoException;

	List ricercaComponentiByFiltro(CompFilter filter) throws SigitTCompScDaoException;

	public List<SigitTCompScCompletoDto> ricercaComponentiCompletoByFiltro(CompFilter filter) throws SigitTCompScDaoException;

	public void update(SigitTCompScDto dto) throws SigitTCompScDaoException;

	public void delete(SigitTCompScPk pk) throws SigitTCompScDaoException;

	public void delete(CompFilter compFilter) throws SigitTCompScDaoException;

	public void customDeleterByFilter(CompFilter filter) throws SigitTCompScDaoException;
}
