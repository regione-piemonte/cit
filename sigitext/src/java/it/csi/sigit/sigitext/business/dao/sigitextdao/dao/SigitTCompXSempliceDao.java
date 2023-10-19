package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTCompXSempliceDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTCompXSemplicePk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTCompXSempliceDaoException;

/**
 * Interfaccia pubblica del DAO sigitTCompXSemplice.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitTCompXSempliceDao {

	/**
	 * Metodo di inserimento del DAO sigitTCompXSemplice. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTCompXSemplicePk
	 * @generated
	 */

	public SigitTCompXSemplicePk insert(SigitTCompXSempliceDto dto)

	;

	/** 
	 * Custom deleter in the SIGIT_T_COMPX_SEMPLICE table.
	 * @generated
	 */
	public void customDeleterByCodImpianto(Integer filter) throws SigitTCompXSempliceDaoException;

	/** 
	 * Returns all rows from the SIGIT_T_COMPX_SEMPLICE table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitTCompXSempliceDto findByPrimaryKey(SigitTCompXSemplicePk pk) throws SigitTCompXSempliceDaoException;

}
