package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.filter.CompFilter;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitRComp4ManutDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitRComp4ManutPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitRComp4ManutDaoException;

import java.util.List;

/**
 * Interfaccia pubblica del DAO sigitRComp4Manut.
 * Espone le operazioni che possono essere eseguite per la gestione
 * della tabella [Table[TRANSIENT]]
 *
 * @generated
 */
public interface SigitRComp4ManutDao {

	/**
	 * Metodo di inserimento del DAO sigitRComp4Manut. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 *
	 * @param dto
	 * @return SigitRComp4ManutPk
	 * @generated
	 */

	public SigitRComp4ManutPk insert(SigitRComp4ManutDto dto)

	;

	/**
	 * Custom deleter in the SIGIT_R_COMP4_MANUT table.
	 *
	 * @generated
	 */
	public void customDeleterByCodImpianto(Integer filter) throws SigitRComp4ManutDaoException;

	/**
	 * Implementazione del finder attiviByFilter
	 *
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitRComp4ManutDto> findAttiviByFilter(SigitRComp4ManutDto input) throws SigitRComp4ManutDaoException;

	/**
	 * Implementazione del finder byPersonaGiuridicaCodImpianto
	 *
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitRComp4ManutDto> findByPersonaGiuridicaCodImpianto(CompFilter input) throws SigitRComp4ManutDaoException;

	/**
	 * Implementazione del finder byRuoloFunzPersonaGiuridicaCodImpianto
	 *
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitRComp4ManutDto> findByRuoloFunzPersonaGiuridicaCodImpianto(CompFilter input) throws SigitRComp4ManutDaoException;

	public List<SigitRComp4ManutDto> findByFilter(CompFilter input) throws SigitRComp4ManutDaoException;

	public void customDeleterByFilter(SigitRComp4ManutDto filter) throws SigitRComp4ManutDaoException;

}
