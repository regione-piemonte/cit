package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTLibrettoDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTLibrettoPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTLibrettoDaoException;

import java.util.List;

/**
 * Interfaccia pubblica del DAO sigitTLibretto.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitTLibrettoDao {

	/**
	 * Metodo di inserimento del DAO sigitTLibretto. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTLibrettoPk
	 * @generated
	 */

	public SigitTLibrettoPk insert(SigitTLibrettoDto dto)

	;

	/** 
	 * Updates a single row in the SIGIT_T_LIBRETTO table.
	 * @generated
	 */
	public void update(SigitTLibrettoDto dto) throws SigitTLibrettoDaoException;

	/** 
	 * Custom updater in the SIGIT_T_LIBRETTO table.
	 * @generated
	 */
	public void customUpdaterStoricizzaByCodImpianto(SigitTLibrettoDto filter, Object value)
			throws SigitTLibrettoDaoException;

	/** 
	 * Implementazione del finder byLibrettoFilter
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTLibrettoDto> findByLibrettoFilter(
			it.csi.sigit.sigitext.business.dao.sigitextdao.dao.filter.LibrettoFilter input)
			throws SigitTLibrettoDaoException;

	/** 
	 * Implementazione del finder byCodImpianto
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTLibrettoDto> findByCodImpianto(Integer input) throws SigitTLibrettoDaoException;

	/** 
	 * Implementazione del finder byUid
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTLibrettoDto> findByUid(String input) throws SigitTLibrettoDaoException;

}
