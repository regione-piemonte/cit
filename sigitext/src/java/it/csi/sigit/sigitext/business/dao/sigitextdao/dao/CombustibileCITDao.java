package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.CombustibileCITDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.CombustibileCITPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.CombustibileCITDaoException;

import java.util.List;

/**
 * Interfaccia pubblica del DAO CombustibileCIT.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface CombustibileCITDao {

	/** 
	 * Restituisce tutte le righe della tabella SIGIT_D_COMBUSTIBILE.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<CombustibileCITDto> findAll() throws CombustibileCITDaoException;

	/** 
	 * Returns all rows from the SIGIT_D_COMBUSTIBILE table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public CombustibileCITDto findByPrimaryKey(CombustibileCITPk pk) throws CombustibileCITDaoException;

}
